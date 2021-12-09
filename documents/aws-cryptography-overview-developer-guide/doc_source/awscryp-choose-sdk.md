# When to use AWS Encryption SDK<a name="awscryp-choose-sdk"></a>

The [AWS Encryption SDK](https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/) is a client\-side encryption library that makes it easier to encrypt and decrypt data of any type in your application\. The Encryption SDK is available in [several programming languages](https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/programming-languages.html), including a [command\-line interface](https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/crypto-cli.html)\. 

You can use the AWS Encryption SDK to encrypt your data before you send it to an AWS service\. You can also use it with customer master keys in AWS Key Management Service \(AWS KMS\)\. However, the library does not require any AWS service\.

When you encrypt data, the SDK returns a single, portable [encrypted message](https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/concepts.html#message) that includes the encrypted data and encrypted data keys\. This object is designed to work in many different types of applications\. You can specify many of the encryption options, including selecting an encryption and signing algorithm\.

**When Do I Use It?**
+ Use the AWS Encryption SDK to encrypt and decrypt data in a script or application\. You can use it with [AWS Key Management Service](awscryp-service-kms.md) or any compatible [master key provider](https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/concepts.html#master-key-provider)\.

**When Do I Use Something Else?**
+ Many AWS services optionally encrypt the data that they store and manage for you\. \(This is known as *server\-side encryption*\.\) Many of these services are [integrated with AWS KMS](https://aws.amazon.com/kms/details/#integration)\. For details, see the information about encryption options in the service documentation\.
+ You might want to use a client\-side encryption library that includes special features for your data, such as [Amazon S3 client\-side encryption](https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingClientSideEncryption.html) or the [DynamoDB Encryption Client](awscryp-service-ddb-client.md)\.

  When you choose an SDK or encryption client library, remember that libraries are not compatible with one another\. That is, you cannot use one library to encrypt data and a different library to decrypt the data\. Unless you need a feature provided only by a different library, use the AWS Encryption SDK\.