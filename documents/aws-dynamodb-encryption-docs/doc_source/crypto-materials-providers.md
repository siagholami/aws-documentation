# How to choose a cryptographic materials provider<a name="crypto-materials-providers"></a>

One of the most important decisions you make when using the DynamoDB Encryption Client is selecting a [cryptographic materials provider](concepts.md#concept-material-provider) \(CMP\)\. The CMP assembles and returns cryptographic materials to the item encryptor\. It also determines how encryption and signing keys are generated, whether new key materials are generated for each item or are reused, and the encryption and signing algorithms that are used\. 

You can choose a CMP from the implementations provided in the DynamoDB Encryption Client libraries or build a compatible custom CMP\. Your CMP choice might also depend on the [programming language](programming-languages.md) that you use\.

This topic describes the most common CMPs and offers some advice to help you choose the best one for your application\.

**Direct KMS Materials Provider**  
The Direct KMS Materials Provider protects your table items under an [AWS Key Management Service](https://docs.aws.amazon.com/kms/latest/developerguide/) \(AWS KMS\) [customer master key](https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#master_keys) \(CMK\) that never leaves AWS KMS unencrypted\. Your application doesn't have to generate or manage any cryptographic materials\. Because it uses the CMK to generate unique encryption and signing keys for each item, this provider calls AWS KMS every time it encrypts or decrypts an item\.   
If you use AWS KMS and one AWS KMS call per transaction is practical for your application, this provider is a good choice\.  
For details, see [Direct KMS Materials Provider](direct-kms-provider.md)\.

**Wrapped Materials Provider \(Wrapped CMP\)**  
The Wrapped Materials Provider \(Wrapped CMP\) lets you generate and manage your wrapping and signing keys outside of the DynamoDB Encryption Client\.   
The Wrapped CMP generates a unique encryption key for each item\. Then it uses wrapping \(or unwrapping\) and signing keys that you supply\. As such, you determine how the wrapping and signing keys are generated and whether they are unique to each item or are reused\. The Wrapped CMP is a secure alternative to the [Direct KMS Provider](direct-kms-provider.md) for applications that don't use AWS KMS and can safely manage cryptographic materials\.  
For details, see [Wrapped Materials Provider](wrapped-provider.md)\.

**Most Recent Provider**  
The *Most Recent Provider* is a [cryptographic materials provider](concepts.md#concept-material-provider) \(CMP\) that is designed to work with a [provider store](concepts.md#provider-store)\. It gets CMPs from the provider store, and gets the cryptographic materials that it returns from the CMPs\. The Most Recent Provider typically uses each CMP to satisfy multiple requests for cryptographic materials, but you can use the features of the provider store to control the extent to which materials are reused, determine how often its CMP is rotated, and even change the type of CMP that is used without changing the Most Recent Provider\.  
You can use the Most Recent Provider with any compatible provider store\. The DynamoDB Encryption Client includes a MetaStore, which is a provider store that returns Wrapped CMPs\.  
The Most Recent Provider is a good choice for applications that need to minimize calls to their cryptographic source, and applications that can reuse some cryptographic materials without violating their security requirements\. For example, it allows you to protect your cryptographic materials under an [AWS Key Management Service](https://docs.aws.amazon.com/kms/latest/developerguide/) \(AWS KMS\) [customer master key](https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#master_keys) without calling AWS KMS every time you encrypt or decrypt an item\.  
For details, see [Most Recent Provider](most-recent-provider.md)\.

**Static Materials Provider**  
The Static Materials Provider is designed for testing, proof\-of\-concept demonstrations, and legacy compatibility\. It doesn't generate any unique cryptographic materials for each item\. It returns the same encryption and signing keys that you supply, and those keys are used directly to encrypt, decrypt, and sign your table items\.   
The [Asymmetric Static Provider](https://aws.github.io/aws-dynamodb-encryption-java/javadoc/com/amazonaws/services/dynamodbv2/datamodeling/encryption/providers/AsymmetricStaticProvider.html) in the Java library is not a static provider\. It just supplies alternate constructors for the [Wrapped CMP](wrapped-provider.md)\. It is safe for production use, but you should use the Wrapped CMP directly whenever possible\.

**Topics**
+ [Direct KMS Materials Provider](direct-kms-provider.md)
+ [Wrapped Materials Provider](wrapped-provider.md)
+ [Most Recent Provider](most-recent-provider.md)
+ [Static Materials Provider](static-provider.md)