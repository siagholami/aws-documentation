# Troubleshooting issues in your DynamoDB Encryption Client application<a name="troubleshooting"></a>

This section describes problems that you might encounter when using the DynamoDB Encryption Client and offers suggestions for resolving them\.

If you have questions about using the DynamoDB Encryption Client, read and post on the [AWS Crypto Tools Discussion Forum](https://forums.aws.amazon.com/forum.jspa?forumID=302), file an issue in the GitHub repository for the [Java](https://github.com/aws/aws-dynamodb-encryption-java/) or [Python](https://github.com/aws/aws-dynamodb-encryption-python/) library, or contact [AWS Support](https://console.aws.amazon.com/support/home)\.

To suggest changes to any page in this guide, choose the feedback link in the lower\-right corner of the page, or the GitHub link in the upper\-right corner of the page\. You can also file an issue in the [aws\-dynamodb\-encryption\-docs](https://github.com/awsdocs/aws-dynamodb-encryption-docs) GitHub repository for this guide\.

**Topics**
+ [Access denied](#kms-permissions)
+ [Signature verification fails](#change-data-model)

## Access denied<a name="kms-permissions"></a>

**Problem**: Your application is denied access to a resource that it needs\.

**Suggestion**: Learn about the required permissions and add them to the security context in which your application runs\.

**Details**

To run an application that uses the a DynamoDB Encryption Client library, the caller must have permission to use its components\. Otherwise, they will be denied access to the required elements\. 
+ The DynamoDB Encryption Client does not require an Amazon Web Services \(AWS\) account or depend on any AWS service\. However, if your application uses AWS, you need [an AWS account](https://aws.amazon.com/premiumsupport/knowledge-center/create-and-activate-aws-account/) and [users who have permission](https://docs.aws.amazon.com/IAM/latest/UserGuide/getting-started_create-admin-group.html) to use the account\.
+ The DynamoDB Encryption Client does not require Amazon DynamoDB\. However, If the application that uses the client creates DynamoDB tables, puts items into a table, or gets items from a table, the caller must have permission to use the required DynamoDB operations in your AWS account\. For details, see the [access control topics](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/access-control-overview.html) in the *Amazon DynamoDB Developer Guide*\.
+ If your application uses a [client helper class](python-using.md#python-helpers) in the DynamoDB Encryption Client for Python, the caller must have permission to call the DynamoDB [DescribeTable](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_DescribeTable.html) operation\.
+ The DynamoDB Encryption Client does not require AWS Key Management Service\(AWS KMS\)\. However, if your application uses a [Direct KMS Materials Provider](direct-kms-provider.md), or it uses a [Most Recent Provider](most-recent-provider.md) with a provider store that uses AWS KMS, the caller must have permission to use the AWS KMS [GenerateDataKey](https://docs.aws.amazon.com/kms/latest/APIReference/API_GenerateDataKey.html) and [Decrypt](https://docs.aws.amazon.com/kms/latest/APIReference/API_Decrypt.html) operations\.

## Signature verification fails<a name="change-data-model"></a>

**Problem**: An item cannot be decrypted because signature verification fails\. The item also might not be encrypted and signed as you intend\.

**Suggestion**: Be sure that the attribute actions that you provide account for all attributes in the item\. Also, when decrypting an item, be sure to provide attribute actions that match the actions used to encrypt the item\.

**Details**

Every time you encrypt or decrypt an item, you need to provide [attribute actions](concepts.md#attribute-actions) that tell the DynamoDB Encryption Client which attributes to encrypt and sign, which attributes to sign \(but not encrypt\), and which to ignore\. Attribute actions are not saved in the encrypted item and the client does not handle schema changes automatically\.

If the attribute actions that you specify do not account for all attributes in the item, the item might not be encrypted and signed the way that you intend\. More importantly, if your attribute actions do not account for all attributes in the item, the item might not be encrypted and signed the way that you intend\. 

If the attribute actions that you provide when decrypting an item differ from the attribute actions that you provided when encrypting the item, the signature verification might fail\. This is a particular problem for distributed applications in which new attribute actions might not have propagated to all hosts\.

For example, if the attribute actions used to encrypt the item tell it to sign the `test` attribute, the signature in the item will include the `test` attribute\. But if the attribute actions used to decrypt the item do not account for the `test` attribute, the verification will fail because the client will try to verify a signature that does not include the `test` attribute\.

To prevent a problem like this one, try the following strategies:
+ Use the features of your programming language to specify a default action in your attribute actions so you don't need to specify every attribute\. For example, the [AttributeActions class](python-using.md#python-attribute-actions) in the Python client has a `default_action` parameter\. In Java, the [AttributeEncryptor](java-using.md#attribute-encryptor) that the `DynamoDBMapper` uses encrypts and signs all attributes, except for the primary key attributes\. Also, the lower\-level [DynamoDBEncryptor](https://aws.github.io/aws-dynamodb-encryption-java/javadoc/com/amazonaws/services/dynamodbv2/datamodeling/encryption/DynamoDBEncryptor.html) in Java supports [encryptAllFieldsExcept](https://aws.github.io/aws-dynamodb-encryption-java/javadoc/com/amazonaws/services/dynamodbv2/datamodeling/encryption/DynamoDBEncryptor.html#encryptAllFieldsExcept-java.util.Map-com.amazonaws.services.dynamodbv2.datamodeling.encryption.EncryptionContext-java.util.Collection-) and [decryptAllFieldsExcept](https://aws.github.io/aws-dynamodb-encryption-java/javadoc/com/amazonaws/services/dynamodbv2/datamodeling/encryption/DynamoDBEncryptor.html#decryptAllFieldsExcept-java.util.Map-com.amazonaws.services.dynamodbv2.datamodeling.encryption.EncryptionContext-java.util.Collection-) methods\.
+ Update your attribute actions as soon as you can, even before you add the new attribute\. This allows time for the change to propagate to all hosts\. It does not cause an error, because the client ignores actions for attributes that it does not encounter\.