# Using the ACM Private CA API \(Java Examples\)<a name="PcaApiIntro"></a>

You can use the AWS Certificate Manager Private Certificate Authority API to programmatically interact with the service by sending HTTP requests\. The service returns HTTP responses\. For more information see [AWS Certificate Manager Private Certificate Authority API Reference](https://docs.aws.amazon.com/acm-pca/latest/APIReference/)\. 

In addition to the HTTP API, you can use the AWS SDKs and command line tools to interact with ACM Private CA\. This is recommended over the HTTP API\. For more information, see [Tools for Amazon Web Services](https://aws.amazon.com/tools/)\. The following topics show you how to use the [AWS SDK for Java](https://aws.amazon.com/sdk-for-java/) to program the ACM PCA API\. 

The [GetCertificateAuthorityCsr](JavaApi-GetCertificateAuthorityCsr.md), [GetCertificate](JavaApi-GetCertificate.md), and [DescribeCertificateAuthorityAuditReport](JavaApi-DescribeCertificateAuthorityAuditReport.md) operations support waiters\. You can use waiters to control the progression of your code based on the presence or state of certain resources\. For more information, see the following topics, as well as [Waiters in the AWS SDK for Java](https://aws.amazon.com/blogs/developer/waiters-in-the-aws-sdk-for-java/) in the [AWS Developer Blog](https://aws.amazon.com/blogs/developer/)\.

**Topics**
+ [Create and Activate a Root CA Programmatically](JavaApi-ActivateRootCA.md)
+ [Create and Activate a Subordinate CA Programmatically](JavaApi-ActivateSubordinateCA.md)
+ [CreateCertificateAuthority](JavaApi-CreatePrivateCertificateAuthority.md)
+ [CreateCertificateAuthorityAuditReport](JavaApi-CreateCertificateAuthorityAuditReport.md)
+ [CreatePermission](JavaApi-CreatePermission.md)
+ [DeleteCertificateAuthority](JavaApi-DeleteCertificateAuthority.md)
+ [DeletePermission](JavaApi-DeletePermission.md)
+ [DeletePolicy](JavaApi-DeletePolicy.md)
+ [DescribeCertificateAuthority](JavaApi-DescribeCertificateAuthority.md)
+ [DescribeCertificateAuthorityAuditReport](JavaApi-DescribeCertificateAuthorityAuditReport.md)
+ [GetCertificate](JavaApi-GetCertificate.md)
+ [GetCertificateAuthorityCertificate](JavaApi-GetCACertificate.md)
+ [GetCertificateAuthorityCsr](JavaApi-GetCertificateAuthorityCsr.md)
+ [GetPolicy](JavaApi-GetPolicy.md)
+ [ImportCertificateAuthorityCertificate](JavaApi-ImportCertificateAuthorityCertificate.md)
+ [IssueCertificate](JavaApi-IssueCertificate.md)
+ [ListCertificateAuthorities](JavaApi-ListCertificateAuthorities.md)
+ [ListPermissions](JavaApi-ListPermissions.md)
+ [ListTags](JavaApi-ListTags.md)
+ [PutPolicy](JavaApi-PutPolicy.md)
+ [RestoreCertificateAuthority](JavaApi-RestoreCertificateAuthority.md)
+ [RevokeCertificate](JavaApi-RevokeCertificate.md)
+ [TagCertificateAuthorities](JavaApi-TagPCA.md)
+ [UntagCertificateAuthority](JavaApi-UnTagPCA.md)
+ [UpdateCertificateAuthority](JavaApi-UpdateCertificateAuthority.md)