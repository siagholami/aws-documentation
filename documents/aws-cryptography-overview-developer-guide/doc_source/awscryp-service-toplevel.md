# AWS cryptographic services and tools<a name="awscryp-service-toplevel"></a>

AWS's cryptographic services utilize a wide range of encryption and storage technologies that can assure the integrity of your data at rest or in transit\. AWS offers several tools for cryptographic operations:
+ **[AWS CloudHSM](awscryp-service-hsm.md)** provides [hardware security modules \(HSMs\)](cryptography-concepts.md#define-hsm) that can securely store a variety of cryptographic keys, including [master keys](cryptography-concepts.md#define-master-key) and [data keys](cryptography-concepts.md#define-data-key)\.
+ **[AWS Key Management Service \(KMS\)](awscryp-service-kms.md)** provides tools for generating [master keys](cryptography-concepts.md#define-master-key) and other [data keys](cryptography-concepts.md#define-data-key)\. AWS KMS also interacts with many other AWS services to encrypt their service\-specific data\.
+ **[AWS Encryption SDK](awscryp-service-encrypt.md)** provides a client\-side encryption library for implementing encryption and decryption operations on *all* types of data\.
+ **[Amazon DynamoDB Encryption Client](awscryp-service-ddb-client.md)** provides a client\-side encryption library for encrypting data tables before sending them to a database service, such as [Amazon DynamoDB](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Introduction.html)\.
+ **[ AWS Secrets Manager](awscryp-service-sm.md)** provides encryption and rotation of encrypted secrets used with [AWS\-supported databases](https://aws.amazon.com/products/databases/?nc2=h_ql_prod_db)\. 

Many AWS services rely on these cryptographic services during data transfer or storage\. For a list of such services and an overview of how they use cryptographic practices, see [Other AWS Services](awscryp-service-other.md)\.

AWS cryptographic services comply with a wide range of cryptographic security standards, making it easy for you to protect your data without worrying about governmental or professional regulations\. For a full list of AWS data security standard compliances, see [AWS Compliance Programs](https://aws.amazon.com/compliance/programs/)\.