# Data Encryption in Amazon FSx for Lustre<a name="encryption-fsxl"></a>

Amazon FSx for Lustre supports two forms of encryption for file systems, encryption of data at rest and encryption in transit\. Encryption of data at rest is automatically enabled when creating an Amazon FSx file system\. Encryption of data in transit is automatically enabled when you access an Amazon FSx file system from [Amazon EC2 instances](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/data-protection.html#encryption-transit) that support this feature\.

## When to Use Encryption<a name="whenencrypt"></a>

If your organization is subject to corporate or regulatory policies that require encryption of data and metadata at rest, we recommend creating an encrypted file system and mounting your file system using encryption of data in transit\.

For more information on encryption with Amazon FSx for Lustre, see these related topics:
+ [Create Your Amazon FSx for Lustre File System](getting-started-step1.md)
+ [Amazon FSx for Lustre API Permissions: Actions, Resources, and Conditions Reference](fsx-api-permissions-ref.md)

**Topics**
+ [When to Use Encryption](#whenencrypt)
+ [Encrypting Data at Rest](encryption-at-rest.md)
+ [Encrypting Data in Transit](encryption-in-transit-fsxl.md)
+ [How Amazon FSx for Lustre Uses AWS KMS](FSXKMS.md)