# DynamoDB Encryption Client<a name="awscryp-service-ddb-client"></a>

The [Amazon DynamoDB Encryption Client](https://docs.aws.amazon.com/dynamodb-encryption-client/latest/devguide/) is a client\-side encryption library that helps you to protect your table data before you send it to Amazon DynamoDB\. Encrypting your sensitive data in transit and at rest helps ensure that your plaintext data isn’t available to any third party, including AWS\.

The DynamoDB Encryption Client is designed especially for DynamoDB applications\. It encrypts the attribute values in each table item using a unique encryption key\. It then signs the item to protect it against unauthorized changes, such as adding or deleting attributes or swapping encrypted values\. After you create and configure the required components, the DynamoDB Encryption Client transparently encrypts and signs your table items when you add them to a table\. It also verifies and decrypts them when you retrieve them\.

The DynamoDB Encryption Client is developed in open source\. It is available in Java and Python and the language implementations are interoperable\. For example, you can encrypt your data with the Java library and decrypt it with the Python library\.

For information about the DynamoDB Encryption Client, see the [DynamoDB Encryption Client Developer Guide](https://docs.aws.amazon.com/dynamodb-encryption-client/latest/devguide/)\.