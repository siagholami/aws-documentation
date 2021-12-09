# Static Materials Provider<a name="static-provider"></a>

The *Static Materials Provider* \(Static CMP\) is a very simple [cryptographic materials provider](concepts.md#concept-material-provider) \(CMP\) that is intended for testing, proof\-of\-concept demonstrations, and legacy compatibility\.

To use the Static CMP to encrypt a table item, you supply an [Advanced Encryption Standard](https://en.wikipedia.org/wiki/Advanced_Encryption_Standard) \(AES\) symmetric encryption key and a signing key or key pair\. You must supply the same keys to decrypt the encrypted item\. The Static CMP does not perform any cryptographic operations\. Instead, it passes the encryption keys that you supply to the item encryptor unchanged\. The item encryptor encrypts the items directly under the encryption key\. Then, it uses the signing key directly to sign them\. 

Because the Static CMP does not generate any unique cryptographic materials, all table items that you process are encrypted with the same encryption key and signed by the same signing key\. When you use the same key to encrypt the attributes values in numerous items or use the same key or key pair to sign all items, you risk exceeding the cryptographic limits of the keys\. 

**Note**  
The [Asymmetric Static Provider](https://aws.github.io/aws-dynamodb-encryption-java/javadoc/com/amazonaws/services/dynamodbv2/datamodeling/encryption/providers/AsymmetricStaticProvider.html) in the Java library is not a static provider\. It just supplies alternate constructors for the [Wrapped CMP](wrapped-provider.md)\. It's safe for production use, but you should use the Wrapped CMP directly whenever possible\.

The Static CMP is one of several [cryptographic materials provider](concepts.md#concept-material-provider) \(CMPs\) that the DynamoDB Encryption Client supports\. For information about the other CMPs, see [How to choose a cryptographic materials provider](crypto-materials-providers.md)\.

**For example code, see:**
+ Java: [SymmetricEncryptedItem](https://github.com/aws/aws-dynamodb-encryption-java/blob/master/examples/com/amazonaws/examples/SymmetricEncryptedItem.java)

**Topics**
+ [How to use it](#static-cmp-how-to-use)
+ [How it works](#static-cmp-how-it-works)

## How to use it<a name="static-cmp-how-to-use"></a>

To create a static provider, supply an encryption key or key pair and a signing key or key pair\. You need to provide key material to encrypt and decrypt table items\.

------
#### [ Java ]

```
// To encrypt
SecretKey cek = ...;        // Encryption key
SecretKey macKey =  ...;    // Signing key
EncryptionMaterialsProvider provider = new SymmetricStaticProvider(cek, macKey);

// To decrypt
SecretKey cek = ...;        // Encryption key
SecretKey macKey =  ...;    // Verification key
EncryptionMaterialsProvider provider = new SymmetricStaticProvider(cek, macKey);
```

------
#### [ Python ]

```
# You can provide encryption materials, decryption materials, or both
encrypt_keys = EncryptionMaterials(
    encryption_key = ...,
    signing_key = ...
)

decrypt_keys = DecryptionMaterials(
    decryption_key = ...,
    verification_key = ...
)

static_cmp = StaticCryptographicMaterialsProvider(
    encryption_materials=encrypt_keys
    decryption_materials=decrypt_keys
)
```

------

## How it works<a name="static-cmp-how-it-works"></a>

The Static Provider passes the encryption and signing keys that you supply to the item encryptor, where they are used directly to encrypt and sign your table items\. Unless you supply different keys for each item, the same keys are used for every item\.

![\[The input, processing, and output of the Static Materials Provider in the DynamoDB Encryption Client\]](http://docs.aws.amazon.com/dynamodb-encryption-client/latest/devguide/images/staticCMP.png)

**Topics**
+ [Get encryption materials](#static-cmp-get-encryption-materials)
+ [Get decryption materials](#static-cmp-get-decryption-materials)

### Get encryption materials<a name="static-cmp-get-encryption-materials"></a>

This section describes in detail the inputs, outputs, and processing of the Static Materials Provider \(Static CMP\) when it receives a request for encryption materials\.

**Input** \(from the application\)
+ An encryption key – This must be a symmetric key, such as an [Advanced Encryption Standard](https://tools.ietf.org/html/rfc3394.html) \(AES\) key\. 
+ A signing key – This can be a symmetric key or an asymmetric key pair\. 

**Input** \(from the item encryptor\)
+ [DynamoDB encryption context](concepts.md#encryption-context)

**Output** \(to the item encryptor\)
+ The encryption key passed as input\.
+ The signing key passed as input\.
+ Actual material description: The [requested material description](concepts.md#material-description), if any, unchanged\.

### Get decryption materials<a name="static-cmp-get-decryption-materials"></a>

This section describes in detail the inputs, outputs, and processing of the Static Materials Provider \(Static CMP\) when it receives a request for decryption materials\.

Although it includes separate methods for getting encryption materials and getting decryption materials, the behavior is the same\. 

**Input** \(from the application\)
+ An encryption key – This must be a symmetric key, such as an [Advanced Encryption Standard](https://tools.ietf.org/html/rfc3394.html) \(AES\) key\. 
+ A signing key – This can be a symmetric key or an asymmetric key pair\. 

**Input** \(from the item encryptor\)
+ [DynamoDB encryption context](concepts.md#encryption-context) \(not used\)

**Output** \(to the item encryptor\)
+ The encryption key passed as input\.
+ The signing key passed as input\.