# Quotas<a name="PcaLimits"></a>

AWS Certificate Manager Private Certificate Authority assigns quotas to your allowed number of certificates and certificate authorities as well as the API rate\.

**Topics**
+ [Quotas on CAs and Certificates](#PcaLimits-certificates)
+ [Quotas on API Requests](#PcaLimits-api)

## Quotas on CAs and Certificates<a name="PcaLimits-certificates"></a>

The following ACM Private CA certificate quotas apply to each Region and each account\. To request higher quotas, create a case at the [AWS Support Center](https://console.aws.amazon.com/support/home#/case/create?issueType=service-limit-increase&limitType=service-code-acm-pca)\.


****  

| Item | Default Quota | 
| --- | --- | 
| Number of private certificate authorities \(CAs\) | 200\* | 
| Number of private certificates per private CA \(lifetime\) | 1,000,000\* | 
| Number of unexpired revoked private certificates per CA\*\* | 1,000,000 | 

\* You can request a quota increase for this item\. Visit the [AWS Support Center](https://console.aws.amazon.com/support/), choose **Create case**, and choose **Service limit increase**\.

\*\* This quota reflects the number of unexpired certificates that can be included in the Certificate Revocation List \(CRL\), based on the maximum CRL size that can be processed by clients consuming CRLs\. **This quota cannot be increased\.**

**Note**  
A private CA that has been deleted counts towards your certificate quota until the end of its restoration period\. For more information, see [Delete Your Private CA](https://docs.aws.amazon.com/acm-pca/latest/userguide/PCADeleteCA.html)\.

ACM Private CA is integrated with ACM\. You can use the ACM console, AWS CLI, or ACM API to request private certificates from an existing private certificate authority \(CA\)\. The certificates are managed by ACM and have the same restrictions as public certificates that are issued by ACM\. For a list of the restrictions, see [Request a Private Certificate](https://docs.aws.amazon.com/acm/latest/userguide/gs-acm-request-private.html)\. You can also issue private certificates with the ACM Private CA API or AWS CLI\. For more information, see [Issuing a Private End\-Entity Certificate](PcaIssueCert.md)\. Regardless of which method you use, you can create 10 private CAs, request 1,000,000 private certificates, and revoke 1,000,000 certificate per account per Region\. ACM places quotas on public and imported certificates\. For more information, see [ACM Quotas](https://docs.aws.amazon.com/acm/latest/userguide/acm-limits.html)\. 

## Quotas on API Requests<a name="PcaLimits-api"></a>

The following quotas apply to the ACM Private CA API for each Region and account\. ACM Private CA throttles API requests at different rates depending on the API operation\. Throttling means that ACM Private CA rejects an otherwise valid request because the request exceeds the operation's quota for the number of requests per second\. When a request is throttled, ACM Private CA returns a [https://docs.aws.amazon.com/acm-pca/latest/APIReference/CommonErrors.html](https://docs.aws.amazon.com/acm-pca/latest/APIReference/CommonErrors.html) error\. The following table lists each API operation and the rate at which ACM Private CA throttles requests for that operation\. ACM Private CA does not guarantee a minimum request rate for APIs\.

**Note**  
If you encounter a [https://docs.aws.amazon.com/acm-pca/latest/APIReference/CommonErrors.html](https://docs.aws.amazon.com/acm-pca/latest/APIReference/CommonErrors.html) error, we recommend that you retry the operation before contacting support\.


**Requests\-per\-second quota for each ACM Private CA API operation**  

| API Operation | Requests per Second | 
| --- | --- | 
| [CreateCertificateAuthority](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_CreateCertificateAuthority.html) | 1 | 
| [CreateCertificateAuthorityAuditReport](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_CreateCertificateAuthorityAuditReport.html) | 1 | 
| [CreatePermission](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_CreatePermission.html) | 1 | 
| [DeleteCertificateAuthority](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_DeleteCertificateAuthority.html) | 10 | 
| [DeletePermission](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_DeletePermission.html) | 1 | 
| [DescribeCertificateAuthority](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_DescribeCertificateAuthority.html) | 20 | 
| [DescribeCertificateAuthorityAuditReport](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_DescribeCertificateAuthorityAuditReport.html) | 20 | 
| [GetCertificate](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_GetCertificate.html) | 75\* | 
| [GetCertificateAuthorityCertificate](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_GetCertificateAuthorityCertificate.html) | 20 | 
| [GetCertificateAuthorityCsr](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_GetCertificateAuthorityCsr.html) | 10 | 
| [ImportCertificateAuthorityCertificate](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_ImportCertificateAuthorityCertificate.html) | 10 | 
| [IssueCertificate](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_IssueCertificate.html) | 25\* | 
| [ListCertificateAuthorities](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_ListCertificateAuthorities.html) | 20 | 
| [ListPermissions](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_ListPermissions.html) | 5 | 
| [ListTags](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_ListTags.html) | 20 | 
| [RestoreCertificateAuthority](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_RestoreCertificateAuthority.html) | 20 | 
| [RevokeCertificate](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_RevokeCertificate.html) | 20 | 
| [TagCertificateAuthority](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_TagCertificateAuthority.html) | 10 | 
| [UntagCertificateAuthority](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_UntagCertificateAuthority.html) | 10 | 
| [UpdateCertificateAuthority](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_UpdateCertificateAuthority.html) | 10 | 

\* You can request a rate increase for this item\. Visit the [AWS Support Center](https://console.aws.amazon.com/support/), choose** Create case**, and choose **Service limit increase**\.