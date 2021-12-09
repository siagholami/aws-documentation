# When to use DynamoDB Encryption Client<a name="awscryp-choose-ddb"></a>

The [Amazon DynamoDB Encryption Client](https://docs.aws.amazon.com/dynamodb-encryption-client/latest/devguide/) is a client\-side encryption library designed especially for data that you store in [Amazon DynamoDB](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/) \(DynamoDB\)\. It encrypts the attribute values in each table item using a unique encryption key and then signs the item to protect it against unauthorized changes\. Unauthorized changes include adding or deleting attributes or swapping encrypted values\. 

You can use the DynamoDB Encryption Client to encrypt and sign your table items before you send them to DynamoDB\. It is compatible with the [encryption at rest](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/EncryptionAtRest.html) server\-side encryption feature that DynamoDB provides for all tables\. For a detailed comparison of the DynamoDB Encryption Client and DynamoDB encryption at rest, see the [Client\-Side and Server\-Side Encryption](https://docs.aws.amazon.com/dynamodb-encryption-client/latest/devguide/client-server-side.html) topic in the *Amazon DynamoDB Encryption Client Developer Guide*\.

**When Do I Use It?**
+ If you need to encrypt and sign DynamoDB table items before you send them to DynamoDB, use the DynamoDB Encryption Client\. 
+ You can also use the DynamoDB Encryption Client to encrypt and sign data that is structured like DynamoDB table items—with attributes and values—even if it is not destined for DynamoDB\. The DynamoDB Encryption Client does not require any AWS service\.

**When Do I Use Something Else?**
+ You can rely on the server\-side [encryption at rest](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/EncryptionAtRest.html) feature that Amazon DynamoDB provides\. DynamoDB transparently encrypts all tables before writing them to disk and transparently decrypts the tables when you get them\. Encryption at rest is provided by default, and you cannot disable it\. However, if your data security standards require it, you can use both the DynamoDB Encryption Client and encryption at rest on your table data\.
+ With the DynamoDB Encryption Client, you can specify which attribute values you encrypt and which attributes are included in the item signature\. However, if you have unusual data protection requirements that the DynamoDB Encryption Client cannot satisfy, you might be able to use the [AWS Encryption SDK](awscryp-service-encrypt.md) to protect your data\. 

When choosing an SDK or encryption client library, remember that they are not compatible\. You cannot use one library to encrypt data and a different library to decrypt the data\. 