# AWS Key Management Service<a name="awscryp-service-kms"></a>

AWS Key Management Service \(AWS KMS\) is an AWS service that makes it easy for you to create and control the encryption keys that are used to encrypt your data\. The customer master keys \(CMKs\) that you create in AWS KMS are protected by [FIPS 140\-2 validated cryptographic modules](https://csrc.nist.gov/projects/cryptographic-module-validation-program/Certificate/3139)\. They never leave AWS KMS unencrypted\. To use or manage your CMKs, you interact with AWS KMS\.

[Many AWS services](https://docs.aws.amazon.com/kms/latest/developerguide/service-integration.html) are integrated with AWS KMS so they encrypt your data with CMKs in your AWS account\. AWS KMS is also integrated with [AWS CloudTrail](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/) to deliver detailed logs of all cryptographic operations that use your CMKs and management operations that change their configuration\. This detailed logging helps you fulfill your auditing, regulatory and compliance requirements\.

## Why use AWS KMS?<a name="awscryp-service-kms-why"></a>

AWS KMS protects the *customer master keys* that protect your data\. 

In the classic scenario, you encrypt your data using data key A\. But you need to protect data key A, so you encrypt data key A by using data key B\. Now data key B is vulnerable, so you encrypt it by using data key C\. And, so on\. This encryption technique, which is called *[envelope encryption](https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#enveloping)*, always leaves one last encryption key unencrypted so you can decrypt your encryption keys and data\. That last unencrypted \(or plaintext\) key is called a *master key*\. 

![\[Master keys protect the data keys that protect your data\]](http://docs.aws.amazon.com/crypto/latest/userguide/images/key-hierarchy-master.png)

AWS KMS protects your master keys\. The *customer master keys* \(CMKs\) that KMS supports are created, managed, used, and deleted entirely within KMS\. They never leave the service unencrypted\. To use or manage your CMKs, you call KMS\.

![\[AWS KMS protects your master keys\]](http://docs.aws.amazon.com/crypto/latest/userguide/images/key-hierarchy-cmk.png)

## Using and managing AWS KMS customer master keys<a name="awscryp-service-kms-using-and-managing"></a>

AWS KMS customer master keys \(CMKs\) are 256\-bit Advanced Encryption Standard \(AES\) symmetric keys that are not exportable\. They spend their entire lifecycle entirely within AWS KMS\.

You can also create asymmetric RSA or elliptic curve \(ECC\) CMKs backed by asymmetric key pairs\. The public key in each asymmetric CMK is exportable, but the private key remains within AWS KMS\.

You can create, view, and manage the AWS KMS customer master keys \(CMKs\) in your AWS account from the AWS Management Console and AWS KMS API operations\. You have full control over your CMKs:
+ Establish policies that determine who can use and manage CMKs\. 
+ Enable and disable CMKs\. 
+ Rotate CMK key material\.
+ Schedule deletion of CMKs when you are finished using them\.

You can also use your CMKs in cryptographic operations\. You can encrypt and decrypt small amounts of data directly under the CMK\. But CMKs are typically used to generate, encrypt, decrypt, and reencrypt exportable data keys that protect your data outside of AWS KMS\. You can also give other AWS services permission to use your CMKs on your behalf to encrypt the data that the service stores and manages for you\.

## More resources and information<a name="awscryp-service-kms-more-info"></a>

You can read about AWS Key Management Service in the [AWS Key Management Service Developer Guide](https://docs.aws.amazon.com/kms/latest/developerguide/) and the [AWS Key Management Service API Reference](https://docs.aws.amazon.com/kms/latest/APIReference/)\. If you have questions, read and post on the [AWS KMS Discussion Forum](https://forums.aws.amazon.com/forum.jspa?forumID=182)\.

If you are required to control and manage the hardware security modules that generate and store your encryption keys, learn about [AWS CloudHSM](awscryp-service-hsm.md)\.

If you need help using encryption keys to encrypt your data, such as the data keys that AWS KMS returns, learn about the [AWS Encryption SDK](awscryp-service-encrypt.md)\. 