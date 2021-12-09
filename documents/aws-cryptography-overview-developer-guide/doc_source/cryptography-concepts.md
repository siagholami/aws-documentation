# Cryptography concepts<a name="cryptography-concepts"></a>

As you work with cryptographic tools and services, you are likely to encounter a number of basic concepts\.

**Topics**
+ [additional authenticated data \(AAD\)](#term-aad)
+ [asymmetric and symmetric encryption](#define-symmetric-asymmetric)
+ [authenticated encryption](#define-authenticated-encryption)
+ [authentication](#define-authentication)
+ [block cipher](#define-block-cipher)
+ [ciphertext](#define-ciphertext)
+ [client\-side and server\-side encryption](#define-client-server-side)
+ [data key](#define-data-key)
+ [decryption](#define-decryption)
+ [encryption](#define-encryption)
+ [encryption algorithm](#define-encryption-algorithm)
+ [encryption context](#define-encryption-context)
+ [envelope encryption](#define-envelope-encryption)
+ [hardware security module \(HSM\)](#define-hsm)
+ [key encryption key](#define-key-encryption-key)
+ [master key](#define-master-key)
+ [plaintext](#define-plaintext)
+ [private key](#define-private-key)
+ [public key](#define-public-key)
+ [stream cipher](#define-stream-cipher)

**additional authenticated data \(AAD\)**  <a name="term-aad"></a>
Nonsecret data that is provided to [encryption](#define-encryption) and [decryption](#define-decryption) operations to add an additional integrity and authenticity check on the encrypted data\. Typically, the decrypt operation fails if the AAD provided to the encrypt operation does not match the AAD provided to the decrypt operation\.  
[AWS Key Management Service](awscryp-service-kms.md) \(AWS KMS\) and the [AWS Encryption SDK](awscryp-service-encrypt.md) both support AAD by using an [encryption context](#define-encryption-context)\.  
See also: [authenticated encryption](#define-authenticated-encryption)

**authenticated encryption**  <a name="define-authenticated-encryption"></a>
*Authenticated encryption* uses [additional authenticated data](#term-aad) \(AAD\) to provide confidentiality, data integrity, and authenticity assurances on encrypted data\.   
For example, the AWS Key Management Service \(AWS KMS\) [https://docs.aws.amazon.com/kms/latest/APIReference/API_Encrypt.html](https://docs.aws.amazon.com/kms/latest/APIReference/API_Encrypt.html) API and the encryption methods in the AWS Encryption SDK take an [encryption context](#define-encryption-context) that represents additional authenticated data \(AAD\)\. The encryption context is cryptographically bound to the encrypted data so that the same encryption context is required to decrypt the data\. To learn how to use encryption context to protect the integrity of encrypted data, see [How to Protect the Integrity of Your Encrypted Data by Using AWS Key Management Service and EncryptionContext](https://aws.amazon.com/blogs/security/how-to-protect-the-integrity-of-your-encrypted-data-by-using-aws-key-management-service-and-encryptioncontext/) in the AWS Security Blog\.

**asymmetric and symmetric encryption**  <a name="define-symmetric-asymmetric"></a>
[Symmetric encryption](concepts-algorithms.md#concepts-algos) uses the same secret key to perform both the [encryption](#define-encryption) and [decryption](#define-decryption) processes\.   
[Asymmetric encryption](concepts-algorithms.md#concepts-asymm), also known as *public\-key encryption*, uses two keys, a [public key](#define-public-key) for encryption and a corresponding [private key](#define-private-key) for decryption\. The public key and private key are mathematically related so that when the public key is used for encryption, the corresponding private key must be used for decryption\. [Encryption algorithms](#define-encryption-algorithm) are either symmetric or asymmetric\.  
For more information, see [Cryptographic algorithms](concepts-algorithms.md)\.

**authentication**  <a name="define-authentication"></a>
The process of verifying identity, that is, determining whether an entity is who it claims to be and that the authentication information has not been manipulated by unauthorized entities\.

**block cipher**  <a name="define-block-cipher"></a>
An algorithm that operates on fixed\-length blocks of data, one block at a time, rather than encrypting one bit at a time as in [stream ciphers](#define-stream-cipher)\.

**ciphertext**  <a name="define-ciphertext"></a>
The encrypted data\. Ciphertext is typically the output of an [encryption algorithm](#define-encryption-algorithm) operating on [plaintext](#define-plaintext)\. Ciphertext is unreadable without knowledge of the algorithm and a secret key\.

**client\-side and server\-side encryption**  <a name="define-client-server-side"></a>
*Client\-side encryption* is encrypting data at or close to its source, such as encrypting data in the application or service that generates it\.   
*Server\-side encryption* is encrypting data at its destination, that is, the application or service that receives it\.  
The method that you choose depends on the sensitivity of your data and the security requirements of your application\. Client\-side and server\-side encryption differ in when, where, and who encrypts and decrypts the data\. They do not necessarily define how the data is encrypted and might use the same process\. In addition, they are not exclusive\. You can often use client\-side and server\-side encryption on the same data\.   
AWS supports both client\-side and server\-side encryption\. Most AWS services that store or manage customer data offer a server\-side encryption option or perform server\-side encryption of your data by default\. These services transparently encrypt your data before writing it to disk and transparently decrypt it when you access it\. Most AWS services that support server\-side encryption are integrated with [AWS Key Management Service](awscryp-service-kms.md) \(AWS KMS\) to protect the encryption keys that protect your data\. For a list of integrated services, see [AWS Service Integration](https://aws.amazon.com/kms/details/#integration)\.   
AWS also supports client\-side encryption libraries, such as the [AWS Encryption SDK](awscryp-service-encrypt.md), the [DynamoDB Encryption Client](awscryp-service-ddb-client.md), and [Amazon S3 client\-side encryption](https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingClientSideEncryption.html)\. For help choosing the library that best meets your needs, see [How to choose a PKI service](awspki-choose-toplevel.md)\.

**data key**  <a name="define-data-key"></a>
In [envelope encryption](#define-envelope-encryption), a *data key* or *data encryption key* is an encryption key that is used to protect data\. Data keys differ from [master keys](#define-master-key) and [key encryption keys](#define-key-encryption-key), which are typically used to encrypt other encryption keys\.   
The term *data key* usually refers to how the key is used, not how it is constructed\. Like all encryption keys, a data key is typically implemented as a byte array that meets the requirements of the encryption algorithm that uses it\. As such, data keys can be used to encrypt data or other data keys\.  
Often a tool or service generates unique data key for each data element, such as a database item, email message, or other resource\. Then, it encrypts all of the data keys under the same master key\.  
Several AWS tools and services provide data keys\.  
+ The HSMs in a [AWS CloudHSM](awscryp-service-hsm.md) cluster generate encryption keys that can be used as data keys, key encryption keys, or master keys\. 
+ You can ask [AWS Key Management Service](awscryp-service-kms.md) \(AWS KMS\) to generate a [data key](https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#data_keys)\. It returns a plaintext key and a copy of that key that is encrypted under the [customer master keys](https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#master_keys) that you specify\. 

**decryption**  <a name="define-decryption"></a>
The process of turning [ciphertext](#define-ciphertext) back into [plaintext](#define-plaintext)\. Decryption algorithms typically require an encryption key and can require other inputs, such as initialization vectors \(IVs\) and [additional authenticated data \(AAD\)](#term-aad)\.

**encryption**  <a name="define-encryption"></a>
The process of converting [plaintext](#define-plaintext) readable data to an unreadable form, known as [ciphertext](#define-ciphertext), to protect it\. The formula used to encrypt the data, known as an [encryption algorithm](#define-encryption-algorithm), must be almost impossible \(using current and anticipated technology\) to reverse without knowledge of the inputs to the algorithm\. These inputs can include an encryption key and other random and determined data\.  
All of the [cryptographic services and tools](awscryp-service-toplevel.md) that AWS supports provide methods for you to encrypt and decrypt your data\. Other AWS services automatically and transparently encrypt the data that they store and manage for you\. 

**encryption algorithm**  <a name="define-encryption-algorithm"></a>
A procedure or ordered set of instructions that specifies precisely how [plaintext](#define-plaintext) data is transformed into encrypted data or [ciphertext](#define-ciphertext)\. The input to an encryption algorithms includes the plaintext data and a encryption key\. The output includes the ciphertext\.   
For example, [AWS Key Management Service](awscryp-service-kms.md) \(AWS KMS\) uses the [Advanced Encryption Standard \(AES\)](https://en.wikipedia.org/wiki/Advanced_Encryption_Standard) [symmetric](#define-symmetric-asymmetric) algorithm in [Galois/Counter Mode \(GCM\)](https://en.wikipedia.org/wiki/Galois/Counter_Mode), known as AES\-GCM\. [AWS CloudHSM](awscryp-service-hsm.md) supports keys for multiple encryption algorithms\.

**encryption context **  <a name="define-encryption-context"></a>
A type of [additional authenticated data \(AAD\)](#term-aad)\. It typically consists of nonsecret, arbitrary, name–value pairs\. In most cases, you can provide an encryption context when you encrypt data\. The same encryption context must be provided to decrypt the data\. The encryption context is usually optional but recommended\.  
The term *encryption context* has different meanings in various AWS services and tools\. This can be confusing, so be sure to understand how your tool or service interprets this term\.  
The following tools and services support an encryption context\.  
+ In [AWS Key Management Service](awscryp-service-kms.md) \(AWS KMS\), an encryption context is a collection of nonsecret name–value pairs\. When you provide an encryption context to an [encryption](#define-encryption) operation, AWS KMS binds it cryptographically to the [ciphertext](#define-ciphertext)\. To decrypt the data, you must provide an exact, case\-sensitive match for the encryption context\.

  AWS KMS includes the encryption context in AWS CloudTrail logs of cryptographic operations\. As such, you can use a well\-designed encryption context to help you track and audit the use of your encryption keys for particular projects or types of data\. 

  AWS KMS also lets you use all or part of the encryption context as the condition for a permission in a policy or grant\. For example, you can allow a user to use a master key to decrypt data only when the encryption context includes a particular value\.

  For details, see [Encryption Context](https://docs.aws.amazon.com/kms/latest/developerguide/encryption-context.html) in the AWS Key Management Service Developer Guide\.

   
+ The [AWS Encryption SDK](awscryp-service-encrypt.md) also supports an optional encryption context in all cryptographic operations\. 

  However, you do not provide the encryption context to the [decryption](#define-decryption) operation\. Instead, when it encrypts data, the SDK saves the encryption context \(in [plaintext](#define-plaintext)\) along with the ciphertext in the [encrypted message](https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/concepts.html#message) that it returns\. When you ask the SDK to decrypt the encrypted message, the SDK uses the encryption context that it saved\.

  You can still use the encryption context to provide an additional verification of your data\. When you decrypt data, you can get and examine the encryption context and return the decrypted data only after verifying that the encryption context has the expected value\.

   
+ The [DynamoDB Encryption Client](awscryp-service-ddb-client.md) uses *encryption context* to mean something different from its use in AWS KMS or the AWS Encryption SDK\. The *DynamoDB encryption context* is a collection of information about the table and table item that you pass to a cryptographic materials provider \(CMP\)\. It is not related to AAD\.

   

**envelope encryption**  <a name="define-envelope-encryption"></a>
A strategy for protecting the encryption keys that you use to encrypt your data\. First, you encrypt [plaintext](#define-plaintext) data with a [data key](#define-data-key)\. Then, to protect the data key, you encrypt it under another key, known as a [key encryption key](#define-key-encryption-key)\.   
Encrypting the data key is more efficient than reencrypting the data under the new key because it is quicker and produces a much smaller [ciphertext](#define-ciphertext)\.   
You can even encrypt the data encryption key under another encryption key and encrypt that encryption key under still another encryption key\. But, eventually, one key must remain in plaintext so you can decrypt the keys and your data\. This top\-level plaintext key encryption key is known as the [master key](#define-master-key), as shown in the following diagram\.  

![\[Envelope encryption\]](http://docs.aws.amazon.com/crypto/latest/userguide/images/envelope-encryption.png)
Several [AWS cryptographic tools and services](awscryp-service-toplevel.md) support envelope encryption\. [AWS Key Management Service](awscryp-service-kms.md) \(AWS KMS\) protects the master key that must remain in plaintext\. It supplies master keys that never leave the service unencrypted\. AWS KMS supports operations that generate data keys that are encrypted under your master key\. You can use the data keys to encrypt your data outside of AWS KMS\.   
The [AWS Encryption SDK](awscryp-service-encrypt.md) automatically encrypts your data with a data key that is encrypted by a master key that you specify\. The [DynamoDB Encryption Client](awscryp-service-ddb-client.md) supports many [encryption](#define-encryption) strategies, including envelope encryption with an AWS KMS customer master key or with keys that you provide\.

**hardware security module \(HSM\)**  <a name="define-hsm"></a>
A computing device that performs cryptographic operations and provides secure storage for cryptographic keys\. Many HSMs have features that make them resistant to tampering or provide reliable tamper detection\.  
[AWS CloudHSM](awscryp-service-hsm.md) lets you create, manage, and control your own HSMs in the cloud\. [AWS Key Management Service](awscryp-service-kms.md) \(AWS KMS\) generates and protects the customer master keys \(CMKs\) that it provides in FIPS 140\-2 validated HSMs that it manages for you\. AWS KMS also lets you create your CMKs in a [custom key store](https://docs.aws.amazon.com/kms/latest/developerguide/custom-key-store-overview.html) backed by an AWS CloudHSM cluster that you own and manage\.

**key encryption key**  <a name="define-key-encryption-key"></a>
In [envelope encryption](#define-envelope-encryption), a *key encryption key* is an encryption key that is used to encrypt a [data key](#define-data-key) or another key encryption key\. To protect the key encryption key, it is encrypted by using a [master key](#define-master-key)\.  
The term *key encryption key* refers to how the key is used, not how it is constructed\. Like all encryption keys, a key encryption key is typically implemented as a byte array that meets the requirements of the [encryption algorithm](#define-encryption-algorithm) that uses it\.   
Several AWS services provide key encryption keys\.  
+ The HSMs in a [AWS CloudHSM](awscryp-service-hsm.md) cluster generate encryption keys that can be used as data keys, key encryption keys, or master keys\. 
+ You can ask [AWS Key Management Service](awscryp-service-kms.md) \(AWS KMS\) to generate a [data key](https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#data_keys), then use that key as a key encryption key outside of AWS KMS\. 

**master key**  <a name="define-master-key"></a>
In [envelope encryption](#define-envelope-encryption), a master key is an encryption key that is used to encrypt other encryption keys, such as [data keys](#define-data-key) and [key encryption keys](#define-key-encryption-key)\. Unlike data keys and key encryption keys, master keys must be kept in [plaintext](#define-plaintext) so they can be used to decrypt the keys that they encrypted\.  
The term *master key* usually refers to how the key is used, not how it is constructed\. Like all encryption keys, a master key is typically implemented as a byte array that meets the requirements of the [encryption algorithm](#define-encryption-algorithm) that uses it\.   
[AWS Key Management Service](awscryp-service-kms.md) \(AWS KMS\) generates and protect master keys\. Its [customer master keys](https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#master_keys) \(CMKs\) are created, managed, used, and deleted entirely within AWS KMS\.  
Several AWS services provide master keys\.  
+ The HSMs in a [AWS CloudHSM](awscryp-service-hsm.md) cluster generate encryption keys that can be used as data keys, key encryption keys, or master keys\. 
+ [AWS Key Management Service](awscryp-service-kms.md) \(AWS KMS\) generates and protects master keys\. Its [customer master keys](https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#master_keys) \(CMKs\) are created, managed, used, and deleted entirely within AWS KMS\.

**plaintext**  <a name="define-plaintext"></a>
Information or data in an unencrypted, unprotected, or human\-readable form\.  
See also: [ciphertext](#define-ciphertext)\.

**private key**  <a name="define-private-key"></a>
One of two keys, along with [public keys](#define-public-key), used to protect data in an [asymmetric encryption](#define-symmetric-asymmetric) scheme\. Public and private keys are algorithmically generated in tandem: the public key is distributed to multiple trusted entities, and one of its paired private keys is distributed to a single entity\. This way, a message can be *authenticated* because the public key signature proves that a trusted entity encrypted and sent it\. The message contents can also be *secured* so that only a private key holder can decrypt it\.

**public key**  <a name="define-public-key"></a>
One of two keys, along with [private keys](#define-private-key), used to protect data in an [asymmetric encryption](#define-symmetric-asymmetric) scheme\. Public and private keys are algorithmically generated in tandem: the public key is distributed to multiple trusted entities, and one of its paired private keys is distributed to a single entity\. This way, a message can be *authenticated* because the public key signature proves that a trusted entity encrypted and sent it\. The message contents can also be *secured* so that only a private key holder can decrypt it\.

**stream cipher**  <a name="define-stream-cipher"></a>
An algorithm that operates one bit of a data at a time rather than encrypting one block of data at a time as in [block ciphers](#define-block-cipher)\.