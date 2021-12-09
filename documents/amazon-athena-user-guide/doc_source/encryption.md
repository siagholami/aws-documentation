# Encryption at Rest<a name="encryption"></a>

You can run queries in Amazon Athena on encrypted data in Amazon S3 in the same Region\. You can also encrypt the query results in Amazon S3 and the data in the AWS Glue Data Catalog\.

You can encrypt the following assets in Athena:
+ The results of all queries in Amazon S3, which Athena stores in a location known as the Amazon S3 results location\. You can encrypt query results stored in Amazon S3 whether the underlying dataset is encrypted in Amazon S3 or not\. For information, see [Encrypting Query Results Stored in Amazon S3](encrypting-query-results-stored-in-s3.md)\.
+ The data in the AWS Glue Data Catalog\. For information, see [Permissions to Encrypted Metadata in the AWS Glue Data Catalog](#glue-encryption)\.

**Note**  
The setup for querying an encrypted dataset in Amazon S3 and the options in Athena to encrypt query results are independent\. Each option is enabled and configured separately\. You can use different encryption methods or keys for each\. This means that reading encrypted data in Amazon S3 doesn't automatically encrypt Athena query results in Amazon S3\. The opposite is also true\. Encrypting Athena query results in Amazon S3 doesn't encrypt the underlying dataset in Amazon S3\.

**Topics**
+ [Supported Amazon S3 Encryption Options](#encryption-options-S3-and-Athena)
+ [Permissions to Encrypted Data in Amazon S3](#permissions-for-encrypting-and-decrypting-data)
+ [Permissions to Encrypted Metadata in the AWS Glue Data Catalog](#glue-encryption)
+ [Encrypting Query Results Stored in Amazon S3](encrypting-query-results-stored-in-s3.md)
+ [Creating Tables Based on Encrypted Datasets in Amazon S3](creating-tables-based-on-encrypted-datasets-in-s3.md)

## Supported Amazon S3 Encryption Options<a name="encryption-options-S3-and-Athena"></a>

Athena supports the following encryption options for datasets and query results in Amazon S3\.


| Encryption Type | Description | Cross\-Region Support | 
| --- | --- | --- | 
| [SSE\-S3](https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingServerSideEncryption.html) | Server side encryption \(SSE\) with an Amazon S3\-managed key\. | Yes | 
| [SSE\-KMS](https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingKMSEncryption.html) | Server\-side encryption \(SSE\) with a AWS Key Management Service customer managed key\.  With this encryption type, Athena does not require you to indicate that data is encrypted when you create a table\.  | Yes | 
| [CSE\-KMS](https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingClientSideEncryption.html#client-side-encryption-kms-managed-master-key-intro) |  Client\-side encryption \(CSE\) with a AWS KMS customer managed key  | No | 

For more information about AWS KMS encryption with Amazon S3, see [What is AWS Key Management Service](https://docs.aws.amazon.com/kms/latest/developerguide/overview.html) and [How Amazon Simple Storage Service \(Amazon S3\) Uses AWS KMS](https://docs.aws.amazon.com/kms/latest/developerguide/services-s3.html) in the *AWS Key Management Service Developer Guide*\.

### Unsupported Options<a name="encryption-unsupported-options"></a>

The following encryption options are not supported:
+ SSE with customer\-provided keys \(SSE\-C\)\.
+ Client\-side encryption using a client\-side master key\.
+ Asymmetric keys\.

To compare Amazon S3 encryption options, see [Protecting Data Using Encryption](https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingEncryption.html) in the *Amazon Simple Storage Service Developer Guide*\.

## Permissions to Encrypted Data in Amazon S3<a name="permissions-for-encrypting-and-decrypting-data"></a>

Depending on the type of encryption you use in Amazon S3, you may need to add permissions, also known as "Allow" actions, to your policies used in Athena:
+ **SSE\-S3** – If you use SSE\-S3 for encryption, Athena users require no additional permissions in their policies\. It is sufficient to have the appropriate Amazon S3 permissions for the appropriate Amazon S3 location and for Athena actions\. For more information about policies that allow appropriate Athena and Amazon S3 permissions, see [IAM Policies for User Access](managed-policies.md) and [Amazon S3 Permissions](s3-permissions.md)\.
+ **AWS KMS** – If you use AWS KMS for encryption, Athena users must be allowed to perform particular AWS KMS actions in addition to Athena and Amazon S3 permissions\. You allow these actions by editing the key policy for the AWS KMS customer managed keys \(CMKs\) that are used to encrypt data in Amazon S3\. The easiest way to do this is to use the IAM console to add key users to the appropriate AWS KMS key policies\. For information about how to add a user to a AWS KMS key policy, see [How to Modify a Key Policy](https://docs.aws.amazon.com/kms/latest/developerguide/key-policy-modifying.html#key-policy-modifying-how-to-console-default-view) in the *AWS Key Management Service Developer Guide*\.
**Note**  
Advanced key policy administrators can adjust key policies\. `kms:Decrypt` is the minimum allowed action for an Athena user to work with an encrypted dataset\. To work with encrypted query results, the minimum allowed actions are `kms:GenerateDataKey` and `kms:Decrypt`\.

  When using Athena to query datasets in Amazon S3 with a large number of objects that are encrypted with AWS KMS, AWS KMS may throttle query results\. This is more likely when there are a large number of small objects\. Athena backs off retry requests, but a throttling error might still occur\. In this case, you can increase your service quotas for AWS KMS\. For more information, see [Quotas](https://docs.aws.amazon.com/kms/latest/developerguide/limits.html#requests-per-second) in the *AWS Key Management Service Developer Guide*\.

## Permissions to Encrypted Metadata in the AWS Glue Data Catalog<a name="glue-encryption"></a>

If you [encrypt metadata in the AWS Glue Data Catalog](https://docs.aws.amazon.com/glue/latest/dg/encrypt-glue-data-catalog.html), you must add `"kms:GenerateDataKey"`, `"kms:Decrypt"`, and `"kms:Encrypt"` actions to the policies you use for accessing Athena\. For information, see [Access to Encrypted Metadata in the AWS Glue Data Catalog](access-encrypted-data-glue-data-catalog.md)\.