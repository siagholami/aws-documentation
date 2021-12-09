# Wrapped Materials Provider<a name="wrapped-provider"></a>

The *Wrapped Materials Provider* \(Wrapped CMP\) lets you use wrapping and signing keys from any source with the DynamoDB Encryption Client\. The Wrapped CMP does not depend on any AWS service\. However, you must generate and manage your wrapping and signing keys outside of the client, including providing the correct keys to verify and decrypt the item\. 

The Wrapped CMP generates a unique item encryption key for each item\. It wraps the item encryption key with the wrapping key that you provide and saves the wrapped item encryption key in the [material description attribute](concepts.md#material-description) of the item\. Because you supply the wrapping and signing keys, you determine how the wrapping and signing keys are generated and whether they are unique to each item or are reused\. 

The Wrapped CMP is a secure implementation and a good choice for applications that can manage cryptographic materials\.

The Wrapped CMP is one of several [cryptographic materials provider](concepts.md#concept-material-provider) \(CMPs\) that the DynamoDB Encryption Client supports\. For information about the other CMPs, see [How to choose a cryptographic materials provider](crypto-materials-providers.md)\.

**For example code, see:**
+ Java: [AsymmetricEncryptedItem](https://github.com/aws/aws-dynamodb-encryption-java/blob/master/examples/com/amazonaws/examples/AsymmetricEncryptedItem.java)
+ Python: [wrapped\-rsa\-encrypted\-table](https://github.com/aws/aws-dynamodb-encryption-python/blob/master/examples/src/wrapped_rsa_encrypted_table.py), [wrapped\-symmetric\-encrypted\-table](https://github.com/aws/aws-dynamodb-encryption-python/blob/master/examples/src/wrapped_symmetric_encrypted_table.py)

**Topics**
+ [How to use it](#wrapped-cmp-how-to-use)
+ [How it works](#wrapped-cmp-how-it-works)

## How to use it<a name="wrapped-cmp-how-to-use"></a>

To create a Wrapped CMP, specify a wrapping key \(required on encrypt\), an unwrapping key \(required on decrypt\), and a signing key\. You must supply keys when you encrypt and decrypt items\.

The wrapping, unwrapping, and signing keys can be symmetric keys or asymmetric key pairs\. 

------
#### [ Java ]

```
// This example uses asymmetric wrapping and signing key pairs
final KeyPair wrappingKeys = ...
final KeyPair signingKeys = ...

final WrappedMaterialsProvider cmp = 
    new WrappedMaterialsProvider(wrappingKeys.getPublic(),
                                 wrappingKeys.getPrivate(),
                                 signingKeys);
```

------
#### [ Python ]

```
# This example uses symmetric wrapping and signing keys
wrapping_key = ...
signing_key  = ...

wrapped_cmp = WrappedCryptographicMaterialsProvider(
    wrapping_key=wrapping_key,
    unwrapping_key=wrapping_key,
    signing_key=signing_key
)
```

------

## How it works<a name="wrapped-cmp-how-it-works"></a>

The Wrapped CMP generates a new item encryption key for every item\. It uses the wrapping, unwrapping, and signing keys that you provide, as shown in the following diagram\.

![\[The input, processing, and output of the Wrapped Materials Provider in the DynamoDB Encryption Client\]](http://docs.aws.amazon.com/dynamodb-encryption-client/latest/devguide/images/wrappedCMP.png)

**Topics**
+ [Get encryption materials](#wrapped-cmp-get-encryption-materials)
+ [Get decryption materials](#wrapped-cmp-get-decryption-materials)

### Get encryption materials<a name="wrapped-cmp-get-encryption-materials"></a>

This section describes in detail the inputs, outputs, and processing of the Wrapped Materials Provider \(Wrapped CMP\) when it receives a request for encryption materials\. 

**Input** \(from application\)
+ Wrapping key: An [Advanced Encryption Standard](https://en.wikipedia.org/wiki/Advanced_Encryption_Standard) \(AES\) symmetric key, or an [RSA](https://en.wikipedia.org/wiki/RSA_(cryptosystem)) public key\. Required if any attribute values are encrypted\. Otherwise, it is optional and ignored\.
+ Unwrapping key: Optional and ignored\. 
+ Signing key

**Input** \(from the item encryptor\)
+ [DynamoDB encryption context](concepts.md#encryption-context)

**Output** \(to the item encryptor\):
+ Plaintext item encryption key
+ Signing key \(unchanged\)
+ [Actual material description](concepts.md#material-description): These values are saved in the [material description attribute](concepts.md#material-description) that the client adds to the item\. 
  + `amzn-ddb-env-key`: Base64\-encoded wrapped item encryption key
  + `amzn-ddb-env-alg`: Encryption algorithm used to encrypt the item\. The default is AES\-256\-CBC\.
  + `amzn-ddb-wrap-alg`: The wrapping algorithm that the Wrapped CMP used to wrap the item encryption key\. If the wrapping key is an AES key, the key is wrapped using unpadded `AES-Keywrap` as defined in [RFC 3394](https://tools.ietf.org/html/rfc3394.html)\. If the wrapping key is an RSA key, the key is encrypted by using RSA OAEP with MGF1 padding\. 

**Processing**

When you encrypt an item, you pass in a wrapping key and a signing key\. An unwrapping key is optional and ignored\.

1. The Wrapped CMP generates a unique symmetric item encryption key for the table item\.

1. It uses the wrapping key that you specify to wrap the item encryption key\. Then, it removes it from memory as soon as possible\.

1. It returns the plaintext item encryption key, the signing key that you supplied, and an [actual material description](concepts.md#material-description) that includes the wrapped item encryption key, and the encryption and wrapping algorithms\.

1. The item encryptor uses the plaintext encryption key to encrypt the item\. It uses the signing key that you supplied to sign the item\. Then, it removes the plaintext keys from memory as soon as possible\. It copies the fields in the actual material description, including the wrapped encryption key \(`amzn-ddb-env-key`\), to the material description attribute of the item\.

### Get decryption materials<a name="wrapped-cmp-get-decryption-materials"></a>

This section describes in detail the inputs, outputs, and processing of the Wrapped Materials Provider \(Wrapped CMP\) when it receives a request for decryption materials\. 

**Input** \(from application\)
+ Wrapping key: Optional and ignored\.
+ Unwrapping key: The same [Advanced Encryption Standard](https://en.wikipedia.org/wiki/Advanced_Encryption_Standard) \(AES\) symmetric key or [RSA](https://en.wikipedia.org/wiki/RSA_(cryptosystem)) private key that corresponds to the RSA public key used to encrypt\. Required if any attribute values are encrypted\. Otherwise, it is optional and ignored\.
+ Signing key

**Input** \(from the item encryptor\)
+ A copy of the [DynamoDB encryption context](concepts.md#encryption-context) that contains the contents of the material description attribute\.

**Output** \(to the item encryptor\)
+ Plaintext item encryption key
+ Signing key \(unchanged\)

**Processing**

When you decrypt an item, you pass in an unwrapping key and a signing key\. A wrapping key is optional and ignored\.

1. The Wrapped CMP gets the wrapped item encryption key from the material description attribute of the item\.

1. It uses the unwrapping key and algorithm to unwrap the item encryption key\. 

1. It returns the plaintext item encryption key, the signing key, and encryption and signing algorithms to the item encryptor\.

1. The item encryptor uses the signing key to verify the item\. If it succeeds, it uses the item encryption key to decrypt the item\. Then, it removes the plaintext keys from memory as soon as possible\.