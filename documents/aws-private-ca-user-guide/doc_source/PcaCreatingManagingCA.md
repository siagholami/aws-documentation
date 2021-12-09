# Creating and Managing a Private CA<a name="PcaCreatingManagingCA"></a>

Using ACM Private CA, you can create an entirely AWS\-hosted private certificate authority \(CA\) for internal use by your organization\. You can also a tie a certificate revocation list \(CRL\) to your CA\. The root CA certificate, any subordinate CA certificates, and the CRL are stored and managed by ACM Private CA\. The private key for your root authority is securely stored in AWS\.

**Note**  
You have the option of encrypting your CRL\. For more information, see [Encrypting Your CRLs ](PcaCreateCa.md#crl-encryption)\.

You can access ACM Private CA using the AWS Management Console, the AWS CLI, and the ACM Private CA API\. The following topics show you how to use the console and the CLI\. To learn more about the API, see the [AWS Certificate Manager Private Certificate Authority API Reference](https://docs.aws.amazon.com/acm-pca/latest/APIReference/)\. For Java examples that show you how to use the API, see [Using the ACM Private CA API \(Java Examples\)](PcaApiIntro.md)\. 

**Topics**
+ [Setting Up ACM Private CA](PcaGettingStarted.md)
+ [Creating a Private CA and CRL](PcaCreateCa.md)
+ [Creating and Installing the Certificate for a Private CA](PCACertInstall.md)
+ [Enabling Access to a Private CA](granting-ca-access.md)
+ [Updating Your Private CA](PCAUpdateCA.md)
+ [Deleting Your Private CA](PCADeleteCA.md)
+ [Restoring Your Private CA](PCARestoreCA.md)