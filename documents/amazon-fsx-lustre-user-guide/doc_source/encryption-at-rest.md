# Encrypting Data at Rest<a name="encryption-at-rest"></a>

Encryption of data at rest is automatically enabled when you create an Amazon FSx for Lustre file system through the AWS Management Console, the AWS CLI, or programmatically through the Amazon FSx API or one of the AWS SDKs\. Your organization might require the encryption of all data that meets a specific classification or is associated with a particular application, workload, or environment\. If you create a persistent file system, you can specify the AWS KMS key to encrypt the data with\. If you create a scratch file system, the data is encrypted using keys managed by Amazon FSx\. For more information about creating a file system encrypted at rest using the console, see [Create Your Amazon FSx for Lustre File System](getting-started-step1.md)\.

**Note**  
The AWS key management infrastructure uses Federal Information Processing Standards \(FIPS\) 140\-2 approved cryptographic algorithms\. The infrastructure is consistent with National Institute of Standards and Technology \(NIST\) 800\-57 recommendations\.

For more information on how Amazon FSx for Lustre uses AWS KMS, see [How Amazon FSx for Lustre Uses AWS KMS](FSXKMS.md)\.

## How Encryption at Rest Works<a name="howencrypt"></a>

In an encrypted file system, data and metadata are automatically encrypted before being written to the file system\. Similarly, as data and metadata are read, they are automatically decrypted before being presented to the application\. These processes are handled transparently by Amazon FSx for Lustre, so you don't have to modify your applications\.

Amazon FSx for Lustre uses industry\-standard AES\-256 encryption algorithm to encrypt file system data at rest\. For more information, see [Cryptography Basics](https://docs.aws.amazon.com/kms/latest/developerguide/crypto-intro.html) in the *AWS Key Management Service Developer Guide*\.