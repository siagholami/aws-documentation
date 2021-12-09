# Data Encryption in Amazon FSx<a name="encryption"></a>

Amazon FSx for Windows File Server supports two forms of encryption for file systems, encryption of data in transit and encryption at rest\. Encryption of data in transit is supported on file shares that are mapped on a compute instance that supports SMB protocol 3\.0 or newer\. Encryption of data at rest is automatically enabled when creating an Amazon FSx file system\. Amazon FSx automatically encrypts data in transit using SMB encryption as you access your file system without the need for you to modify your applications\.

## When to Use Encryption<a name="whenencrypt"></a>

If your organization is subject to corporate or regulatory policies that require encryption of data and metadata at rest, we recommend creating an encrypted file system mounting your file system using encryption of data in transit\.

For more information on encryption with Amazon FSx for Windows File Server, see these related topics:
+ [Create Your Amazon FSx for Windows File Server File System](getting-started-step1.md)
+ [Amazon FSx API Permissions: Actions, Resources, and Conditions Reference](fsx-api-permissions-ref.md)

**Topics**
+ [When to Use Encryption](#whenencrypt)
+ [Encryption at Rest](encryption-at-rest.md)
+ [Encryption in Transit](encryption-in-transit.md)