--------

--------

# Encryption at rest<a name="encryption-at-rest"></a>

Amazon Kendra encrypts your data at rest with your choice of an encryption key\. You can choose one of the following:
+ An AWS owned customer master key \(CMK\)\. If you don't specify an encryption key your data is encrypted with this key by default\.
+ An AWS managed CMK in your account\. This key is created, managed, and used on your behalf by Amazon Kendra\. The key name is `aws/kendra`\.
+ A customer managed CMK\. You can provide the ARN of an encryption key that you created in your account\. When you use a customer managed CMK, you must give the key a key policy that enables Amazon Kendra to use the key\. Select a symmetric customer managed CMK, Amazon Kendra does not support asymmetric CMKs\. For more information, see [Key management](key-management.md)\.