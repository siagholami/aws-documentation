# When to use AWS Key Management Service \(AWS KMS\)<a name="awscryp-choose-kms"></a>

When you encrypt data, you need to protect your encryption key\. If you encrypt your key, you need to protect its encryption key\. Eventually, you must protect the highest level encryption key \(known as a *master key*\) in the hierarchy that protects your data\. That's where AWS KMS comes in\.

[AWS Key Management Service](https://docs.aws.amazon.com/kms/latest/developerguide/) \(AWS KMS\) lets you create, store, and manage [customer master keys](https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#master_keys) \(CMKs\) securely\. Your CMKs never leave AWS KMS unencrypted\. To use a CMK in a cryptographic operation, you call KMS\.

Additionally, you can create and manage [key policies](https://docs.aws.amazon.com/kms/latest/developerguide/key-policies.html) in AWS KMS, ensuring that only trusted users have access to CMKs\.

**When Do I Use It?**
+ Use AWS KMS to create and manage customer master keys \(CMKs\)\. You can establish policies that determine who can use your CMKs and how they can use them\. You can track their use in transaction and audit logs, such as [AWS CloudTrail](https://docs.aws.amazon.com/kms/latest/developerguide/logging-using-cloudtrail.html)\.
+ You can use your CMKs to encrypt small amounts of data \(up to 4096 bytes\)\. However, CMKs are typically used to generate, encrypt, and decrypt the [data keys](https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#data-keys) that encrypt your data\. Unlike CMKs, data keys can encrypt data of any size and format, including streamed data\. 

**When Do I Use Something Else?**
+ AWS KMS does not store or manage data keys, and you cannot use KMS to encrypt or decrypt with data keys\. To use data keys to encrypt and decrypt, use the AWS Encryption SDK\. 
+ AWS KMS CMKs are backed by [FIPS\-validated](https://csrc.nist.gov/projects/cryptographic-module-validation-program/Certificate/3139) hardware service modules \(HSMs\) that KMS manages\. To manage your own HSMs, use [AWS CloudHSM](awscryp-choose-hsm.md)\. 