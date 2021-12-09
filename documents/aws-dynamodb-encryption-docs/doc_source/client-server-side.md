# Client\-side and server\-side encryption<a name="client-server-side"></a>

The DynamoDB Encryption Client supports *client\-side encryption*, where you encrypt your table data before you send it to DynamoDB\. However, DynamoDB provides a server\-side *encryption at rest* feature that transparently encrypts your table when it is persisted to disk and decrypts it when you access the table\. 

The tools that you choose depend on the sensitivity of your data and the security requirements of your application\. You can use both the DynamoDB Encryption Client and encryption at rest\. When you send encrypted and signed items to DynamoDB, DynamoDB doesn't recognize the items as being protected\. It just detects typical table items with binary attribute values\. 

**Server\-side encryption at rest**

DynamoDB offers [encryption at rest](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/EncryptionAtRest.html), a *server\-side encryption* option in which DynamoDB transparently encrypts your tables for you when the table is persisted to disk, and decrypts them when you access the table data\. 

With server\-side encryption, your data is encrypted in transit over an HTTPS connection, decrypted at the DynamoDB endpoint, and then re\-encrypted before being stored in DynamoDB\.
+ **Encryption by default\.** DynamoDB transparently encrypts and decrypts all tables when they are written to disk\. There is no option to disable encryption at rest\. 
+ **DynamoDB creates and manages the cryptographic keys\. **The unique key for each table is protected by an [AWS Key Management Service](https://docs.aws.amazon.com/kms/latest/developerguide/) \(AWS KMS\) customer master key that never leaves AWS KMS unencrypted\. By default, DynamoDB uses an [AWS owned CMK](https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#aws-owned-cmk) in the DynamoDB service account, but you can elect to use an [AWS managed CMK](https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#aws-managed-cmk) or [customer managed CMK](https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#customer-cmk) in your account for some or all of your tables\.
+ **All table data is encrypted on disk\. **When an encrypted table is saved to disk, DynamoDB encrypts all table data, including the [primary key](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/HowItWorks.CoreComponents.html#HowItWorks.CoreComponents.PrimaryKey) and local and global [secondary indexes](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/HowItWorks.CoreComponents.html#HowItWorks.CoreComponents.SecondaryIndexes)\. If your table has a sort key, some of the sort keys that mark range boundaries are stored in plaintext in the table metadata\.
+ **Objects related to tables are encrypted, too\.** Encryption at rest protects [DynamoDB streams](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Streams.html), [global tables](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/GlobalTables.html), and [backups](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/BackupRestore.html) whenever they are written to durable media\.
+ **Your items are decrypted when you access them\. **When you access the table, DynamoDB decrypts the part of the table that includes your target item, and returns the plaintext item to you\.

 

**DynamoDB Encryption Client**

Client\-side encryption provides end\-to\-end protection for your data, in transit and at rest, from its source to storage in DynamoDB\. Your plaintext data is never exposed to any third party, including AWS\. However, you need to add the encryption features to your DynamoDB applications\. 
+ **Your data is protected in transit and at rest\.** It is never exposed to any third party, including AWS\.
+ **You can sign your table Items\.** You can direct the DynamoDB Encryption Client to calculate a signature over all or part of a table item, including the primary key attributes and the table name\. This signatures allows you to detect unauthorized changes to the item as a whole, including adding or deleting attributes, or swapping attribute values\.
+ **You choose how your cryptographic keys are generated and protected\.** You can create and manage your keys, or use a cryptographic service, such as AWS Key Management Service or [AWS CloudHSM](https://docs.aws.amazon.com/cloudhsm/latest/userguide/), to generate and protect your keys\.
+ **You determine how your data is protected **by [selecting a cryptographic materials provider](crypto-materials-providers.md) \(CMP\), or writing one of your own\. The CMP determines the encryption strategy used, including when unique keys are generated, and the encryption and signing algorithms that are used\.
+ **The DynamoDB Encryption Client doesn't encrypt the entire table\.** You can encrypt selected items in a table, or selected attribute values in some or all items\. However, the DynamoDB Encryption Client does not encrypt an entire item\. It does not encrypt attribute names, or the names or values of the primary key \(partition key and sort key\) attributes\. For details about what is encrypted \(and what is not\), see [Which fields are encrypted and signed?](encrypted-and-signed.md)\.

 

**AWS Encryption SDK**

If you are encrypting data that you store in DynamoDB, we recommend the DynamoDB Encryption Client\. 

The [AWS Encryption SDK](https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/) is a client\-side encryption library that helps you to encrypt and decrypt generic data\. Although it can protect any type of data, it isn't designed to work with structured data, like database records\. Unlike the DynamoDB Encryption Client, the AWS Encryption SDK cannot provide item\-level integrity checking and it has no logic to recognize attributes or prevent encryption of primary keys\.

If you use the AWS Encryption SDK to encrypt any element of your table, remember that it isn't compatible with the DynamoDB Encryption Client\. You cannot encrypt with one library and decrypt with the other\.