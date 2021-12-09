# Encryption at Rest: How It Works<a name="encryption.howitworks"></a>

Amazon DynamoDB encryption at rest encrypts your data using 256\-bit Advanced Encryption Standard \(AES\-256\), which helps secure your data from unauthorized access to the underlying storage\. 

Encryption at rest integrates with AWS Key Management Service \(AWS KMS\) for managing the encryption key that is used to encrypt your tables\. 

When creating a new table or switching the encryption keys on an existing table, you can choose one of the following customer master keys \(CMK\): 
+ AWS owned CMK – Default encryption type\. The key is owned by DynamoDB \(no additional charge\)\. 
+ AWS managed CMK – The key is stored in your account and is managed by AWS KMS \(AWS KMS charges apply\)\. 
+ Customer managed CMK – The key is stored in your account and is created, owned, and managed by you\. You have full control over the CMK \(AWS KMS charges apply\)\.

## AWS Owned CMK<a name="ddb-owned"></a>

AWS owned CMKs are not stored in your AWS account\. They are part of a collection of CMKs that AWS owns and manages for use in multiple AWS accounts\. AWS services can use AWS owned CMKs to protect your data\.

You cannot view, manage, or use AWS owned CMKs, or audit their use\. However, you do not need to do any work or change any programs to protect the keys that encrypt your data\.

You are not charged a monthly fee or a usage fee for use of AWS owned CMKs, and they do not count against AWS KMS quotas for your account\.

## AWS Managed CMK<a name="managed-cmk-service-default-kms"></a>

AWS managed CMKs are CMKs in your account that are created, managed, and used on your behalf by an AWS service that is integrated with AWS KMS\. You can view the AWS managed CMKs in your account, view their key policies, and audit their use in AWS CloudTrail logs\. However, you cannot manage these CMKs or change their permissions\.

Encryption at rest automatically integrates with AWS KMS for managing the AWS managed CMK for DynamoDB \(`aws/dynamodb`\) that is used to encrypt your tables\. If an AWS managed CMK doesn't exist when you create your encrypted DynamoDB table, AWS KMS automatically creates a new key for you\. This key is used with encrypted tables that are created in the future\. AWS KMS combines secure, highly available hardware and software to provide a key management system scaled for the cloud\.

 For more information about managing permissions of the AWS managed CMK, see [Authorizing Use of the AWS Managed CMK](https://docs.aws.amazon.com/kms/latest/developerguide/services-dynamodb.html#dynamodb-authz) in the *AWS Key Management Service Developer Guide*\. 

## Customer Managed CMK<a name="managed-cmk-customer-managed"></a>

Customer managed CMKs are CMKs in your AWS account that you create, own, and manage\. You have full control over these CMKs, including establishing and maintaining their key policies, IAM policies, and grants; enabling and disabling them; rotating their cryptographic material; adding tags; creating aliases that refer to them; and scheduling them for deletion\. For more information about managing permissions of a customer managed CMK, see [Customer Managed CMK Key Policy](https://docs.aws.amazon.com/kms/latest/developerguide/services-dynamodb.html#dynamodb-customer-cmk-policy)\.

When you specify a customer managed CMK as the table\-level encryption key, the DynamoDB table, local and global secondary indexes, and streams are encrypted with the same customer managed CMK\. On\-demand backups are encrypted with the table\-level encryption key that is specified at the time the backup is created\. Updating the table\-level encryption key does not change the encryption key that is associated with existing on\-demand backups\.

Setting the state of the customer managed CMK to disabled or scheduling it for deletion prevents all users and the DynamoDB service from being able to encrypt or decrypt data and to perform read and write operations on the table\. DynamoDB must have access to your encryption key to ensure that you can continue to access your table and to prevent data loss\.

If you disable your customer managed CMK or schedule it for deletion, your table status becomes **Inaccessible**\. To ensure that you can continue working with the table, you must provide DynamoDB access to the specified encryption key within seven days\. As soon as the service detects that your encryption key is inaccessible, DynamoDB sends you an email notification to alert you\.

**Note**  
If your customer managed CMK remains inaccessible to the DynamoDB service for longer than seven days, the table is archived and can no longer be accessed\. DynamoDB creates an on\-demand backup of your table, and you are billed for it\. You can use this on\-demand backup to restore your data to a new table\. To initiate the restore, the last customer managed CMK on the table must be enabled, and DynamoDB must have access to it\.

## Notes on Using Managed CMKs<a name="managed-cmk-notes"></a>

Amazon DynamoDB can't read your table data unless it has access to the CMK stored in your AWS KMS account\. DynamoDB uses envelope encryption and key hierarchy to encrypt data\. Your AWS KMS encryption key is used to encrypt the root key of this key hierarchy\. For more information, see [Envelope Encryption](https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#enveloping) in the *AWS Key Management Service Developer Guide*\.

 You can use AWS CloudTrail and Amazon CloudWatch Logs to track the requests that DynamoDB sends to AWS KMS on your behalf\. For more information, see [Monitoring DynamoDB Interaction with AWS KMS](https://docs.aws.amazon.com/kms/latest/developerguide/services-dynamodb.html#dynamodb-cmk-fail) in the *AWS Key Management Service Developer Guide*\.

 DynamoDB doesn't call AWS KMS for every DynamoDB operation\. The key is refreshed once every 5 minutes per client connection with active traffic\.

Ensure that you have configured the SDK to reuse connections\. Otherwise, you will experience latencies from DynamoDB having to reestablish new AWS KMS cache entries for each DynamoDB operation\. In addition, you might potentially have to face higher AWS KMS and CloudTrail costs\. For example, to do this using the Node\.js SDK, you can create a new HTTPS agent with `keepAlive` turned on\. For more information, see [Configuring maxSockets in Node\.js](https://docs.aws.amazon.com/sdk-for-javascript/v2/developer-guide/node-configuring-maxsockets.html) in the *AWS SDK for JavaScript Developer Guide*\. 