# Understanding Certificate Templates<a name="UsingTemplates"></a>

ACM Private CA uses templates to create both CA certificates and end\-entity certificates that identify users, hosts, resources, and devices\. When you create a certificate in the console, a template is applied automatically\. Template options are based on the type of certificate that you have chosen and the path\-length that you specify\. If you use the CLI or API to create a certificate, you manually provide the ARN of the template that you want to apply\. \(The `EndEntityCertificate/V1` template is applied if you provide no ARN\.\)

**Note**  
Cross\-account certificate issuers are constrained by a [resource\-based policy](pca-rbp.md) and have access only to the `EndEntityCertificate/V1` template\.

The following links provide information about creating a certificate with ACM Private CA\. 
+ Using the command line: [issue\-certificate](https://docs.aws.amazon.com/cli/latest/reference/acm-pca/issue-certificate.html)\.
+ Using the API: [IssueCertificate](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_IssueCertificate.html)\.

The table below lists template types supported by ACM Private CA and links to their definitions\.


****  

|  Template Name  |  Template ARN  |  Certificate Type  |  Path Length  | 
| --- | --- | --- | --- | 
|  [CodeSigningCertificate/V1](#CodeSigningCertificate-V1)  |  `arn:aws:acm-pca:::template/CodeSigningCertificate/V1`  |  Code signing  |  Not applicable  | 
|  [CodeSigningCertificate\_CSRPassthrough/V1](#CodeSigningCertificate_CSRPassthrough-V1)  |  `arn:aws:acm-pca:::template/CodeSigningCertificate_CSRPassthrough/V1`  |  Code signing  | Not applicable | 
|  [EndEntityCertificate/V1](#EndEntityCertificate-V1)  |  `arn:aws:acm-pca:::template/EndEntityCertificate/V1`  |  End\-entity  |  Not applicable  | 
|  [EndEntityCertificate\_CSRPassthrough/V1](#EndEntityCertificate_CSRPassthrough-V1)  |  `arn:aws:acm-pca:::template/EndEntityCertificate_CSRPassthrough/V1`  |  End\-entity/passthrough  |  Not applicable  | 
|  [EndEntityClientAuthCertificate/V1](#EndEntityClientAuthCertificate-V1)  |  `arn:aws:acm-pca:::template/EndEntityClientAuthCertificate/V1`  |  End\-entity  |  Not applicable  | 
|  [EndEntityClientAuthCertificate\_CSRPassthrough/V1](#EndEntityClientAuthCertificate_CSRPassthrough-V1)  |  `arn:aws:acm-pca:::template/EndEntityClientAuthCertificate_CSRPassthrough/V1`  |  End\-entity/passthrough  |  Not applicable  | 
|  [EndEntityServerAuthCertificate/V1](#EndEntityServerAuthCertificate-V1)  |  `arn:aws:acm-pca:::template/EndEntityServerAuthCertificate/V1`  |  End\-entity  |  Not applicable  | 
|  [EndEntityServerAuthCertificate\_CSRPassthrough/V1](#EndEntityServerAuthCertificate_CSRPassthrough-V1)  |  `arn:aws:acm-pca:::template/EndEntityServerAuthCertificate_CSRPassthrough/V1`  | End\-entity/passthrough |  Not applicable  | 
|  [OCSPSigningCertificate/V1](#OCSPSigningCertificate-V1)  |  `arn:aws:acm-pca:::template/OCSPSigningCertificate/V1`  |  OCSP signing  |  Not applicable  | 
|  [OCSPSigningCertificate\_CSRPassthrough/V1](#OCSPSigningCertificate_CSRPassthrough-V1)  |  `arn:aws:acm-pca:::template/OCSPSigningCertificate_CSRPassthrough/V1`  |  OCSP signing  |  Not applicable  | 
|  [RootCACertificate/V1](#RootCACertificate-V1)  |  `arn:aws:acm-pca:::template/RootCACertificate/V1`  | CA | Unconstrained | 
|  [SubordinateCACertificate\_PathLen0/V1](#SubordinateCACertificate_PathLen0-V1)  |  `arn:aws:acm-pca:::template/SubordinateCACertificate_PathLen0/V1`  |  CA  |  0  | 
|  [SubordinateCACertificate\_PathLen1/V1](#SubordinateCACertificate_PathLen1-V1)  |  `arn:aws:acm-pca:::template/SubordinateCACertificate_PathLen1/V1`  |  CA  |  1  | 
|  [SubordinateCACertificate\_PathLen2/V1](#SubordinateCACertificate_PathLen2-V1)  |  `arn:aws:acm-pca:::template/SubordinateCACertificate_PathLen2/V1`  |  CA  | 2 | 
|  [SubordinateCACertificate\_PathLen3/V1](#SubordinateCACertificate_PathLen3-V1)  |  `arn:aws:acm-pca:::template/SubordinateCACertificate_PathLen3/V1`  |  CA  |  3  | 

For information about template ARNs in GovCloud regions, see [AWS Certificate Manager Private Certificate Authority](https://docs.aws.amazon.com/govcloud-us/latest/UserGuide/using-govcloud-arns.html#using-govcloud-arn-syntax-acmpca) in the *AWS GovCloud \(US\) User Guide*\.

## CodeSigningCertificate/V1 Definition<a name="CodeSigningCertificate-V1"></a>

This template is used to create certificates for code signing\. You can use code\-signing certificates from ACM Private CA with any code\-signing solution that is based on a private CA infrastructure\. For example, customers using Code Signing for AWS IoT can generate a code\-signing certificate with ACM Private CA and import it to AWS Certificate Manager\. For more information, see [What Is Code Signing for AWS IoT?](https://docs.aws.amazon.com/signer/latest/developerguide/Welcome.html) and [Obtain and Import a Code Signing Certificate](https://docs.aws.amazon.com/signer/latest/developerguide/gs-cs-cert.html)\.


****  

|  Parameter  | Value | 
| --- | --- | 
|  X509v3 subject alternative name  |  \[copy from CSR\]  | 
|  X509v3 basic constraints  |  `CA:FALSE`  | 
|  X509v3 authority key identifier  |  \[AKI\]  | 
|  X509v3 subject key identifier  |  \[SKI\]  | 
|  X509v3 key usage  |  critical, digital signature  | 
|  X509v3 extended key usage  |  critical, code signing  | 
|  X509v3 CRL distribution points\*  |  \[CRL distribution point\]  | 

\*CRL distribution points are included in the template only if the CA is configured with CRL generation enabled\. 

## CodeSigningCertificate\_CSRPassthrough/V1 Definition<a name="CodeSigningCertificate_CSRPassthrough-V1"></a>

This template is identical to the `CodeSigningCertificate` template with one difference: In this template, ACM Private CA passes additional extensions from the certificate signing request \(CSR\) into the certificate if the extensions are not specified in the template\. Extensions specified in the template always override extensions in the CSR\.


****  

|  Parameter  | Value | 
| --- | --- | 
|  X509v3 subject alternative name  |  \[copy from CSR\]  | 
|  X509v3 basic constraints  |  `CA:FALSE`  | 
|  X509v3 authority key identifier  |  \[AKI\]  | 
|  X509v3 subject key identifier  |  \[SKI\]  | 
|  X509v3 key usage  |  critical, digital signature  | 
|  X509v3 extended key usage  |  critical, code signing  | 
|  X509v3 CRL distribution points\*  |  \[CRL distribution point\]  | 

\*CRL distribution points are included in the template only if the CA is configured with CRL generation enabled\. 

## EndEntityCertificate/V1 Definition<a name="EndEntityCertificate-V1"></a>

This template is used to create certificates for end entities such as operating systems or web servers\. 


****  

|  Parameter  | Value | 
| --- | --- | 
|  X509v3 subject alternative name  |  \[copy from CSR\]  | 
|  X509v3 basic constraints  |  CA:`FALSE`  | 
|  X509v3 authority key identifier  |  \[AKI\]  | 
|  X509v3 subject key identifier  |  \[SKI\]  | 
|  X509v3 key usage  |  critical, digital signature, key encipherment  | 
|  X509v3 extended key usage  |  TLS web server authentication, TLS web client authentication  | 
|  X509v3 CRL distribution points\*  |  \[CRL distribution point\]  | 

\*CRL distribution points are included in the template only if the CA is configured with CRL generation enabled\. 

## EndEntityCertificate\_CSRPassthrough/V1 Definition<a name="EndEntityCertificate_CSRPassthrough-V1"></a>

This template is identical to the `EndEntityCertificate` template with one difference: In this template, ACM Private CA passes additional extensions from the certificate signing request \(CSR\) into the certificate if the extensions are not specified in the template\. Extensions specified in the template always override extensions in the CSR\.


****  

|  Parameter  | Value | 
| --- | --- | 
|  X509v3 subject alternative name  |  \[copy from CSR\]  | 
|  X509v3 basic constraints  |  `CA:FALSE`  | 
|  X509v3 authority key identifier  |  \[AKI\]  | 
|  X509v3 subject key identifier  |  \[SKI\]  | 
|  X509v3 key usage  |  critical, digital signature, key encipherment  | 
|  X509v3 extended key usage  |  TLS web server authentication, TLS web client authentication  | 
|  X509v3 CRL distribution points\*  |  \[CRL distribution point\]  | 

\*CRL distribution points are included in the template only if the CA is configured with CRL generation enabled\. 

## EndEntityClientAuthCertificate/V1 Definition<a name="EndEntityClientAuthCertificate-V1"></a>

This template differs from the `EndEntityCertificate` only in the extended key usage value, which restricts it to TLS web client authentication\.


****  

|  Parameter  | Value | 
| --- | --- | 
|  X509v3 subject alternative name  | \[copy from CSR\] | 
|  X509v3 basic constraints  |  `CA:FALSE`  | 
|  X509v3 authority key identifier  |  \[AKI\]  | 
|  X509v3 subject key identifier  |  \[SKI\]  | 
| X509v3 key usage |  critical, digital signature, key encipherment  | 
|  X509v3 extended key usage  |  TLS web client authentication  | 
|  X509v3 CRL distribution points\*  |  \[CRL distribution point\]  | 

\*CRL distribution points are included in the template only if the CA is configured with CRL generation enabled\. 

## EndEntityClientAuthCertificate\_CSRPassthrough/V1 Definition<a name="EndEntityClientAuthCertificate_CSRPassthrough-V1"></a>

This template is identical to the `EndEntityClientAuthCertificate` template with one difference\. In this template, ACM Private CA passes additional extensions from the certificate signing request \(CSR\) into the certificate if the extensions are not specified in the template\. Extensions specified in the template always override extensions in the CSR\.


****  

|  Parameter  | Value | 
| --- | --- | 
|  X509v3 subject alternative name  | \[copy from CSR\] | 
|  X509v3 basic constraints  |  `CA:FALSE`  | 
|  X509v3 authority key identifier  |  \[AKI\]  | 
|  X509v3 subject key identifier  |  \[SKI\]  | 
| X509v3 key usage |  critical, digital signature, key encipherment  | 
|  X509v3 extended key usage  |  TLS web client authentication  | 
|  X509v3 CRL distribution points\*  |  \[CRL distribution point\]  | 

\*CRL distribution points are included in the template only if the CA is configured with CRL generation enabled\. 

## EndEntityServerAuthCertificate/V1 Definition<a name="EndEntityServerAuthCertificate-V1"></a>

This template differs from the `EndEntityCertificate` only in the extended key usage value, which restricts it to TLS web server authentication\.


****  

|  Parameter  |  Value  | 
| --- | --- | 
|  X509v3 subject alternative name  |  \[copy from CSR\]  | 
|  X509v3 basic constraints  |  `CA:FALSE`  | 
|   X509v3 authority key identifier  |  \[AKI\]  | 
|  X509v3 subject key identifier  |  \[SKI\]  | 
|  X509v3 key usage  |  critical, digital signature, key encipherment  | 
|  X509v3 extended key usage  |  TLS web server authentication  | 
|  X509v3 CRL distribution points\*  |  \[CRL distribution point\]  | 

\*CRL distribution points are included in the template only if the CA is configured with CRL generation enabled\. 

## EndEntityServerAuthCertificate\_CSRPassthrough/V1 Definition<a name="EndEntityServerAuthCertificate_CSRPassthrough-V1"></a>

This template is identical to the `EndEntityServerAuthCertificate` template with one difference\. In this template, ACM Private CA passes additional extensions from the certificate signing request \(CSR\) into the certificate if the extensions are not specified in the template\. Extensions specified in the template always override extensions in the CSR\.


****  

|  Parameter  |  Value  | 
| --- | --- | 
|  X509v3 subject alternative name  |  \[copy from CSR\]  | 
|  X509v3 basic constraints  |  `CA:FALSE`  | 
|   X509v3 authority key identifier  |  \[AKI\]  | 
|  X509v3 subject key identifier  |  \[SKI\]  | 
|  X509v3 key usage  |  critical, digital signature, key encipherment  | 
|  X509v3 extended key usage  |  TLS web server authentication  | 
|  X509v3 CRL distribution points\*  |  \[CRL distribution point\]  | 

\*CRL distribution points are included in the template only if the CA is configured with CRL generation enabled\. 

## OCSPSigningCertificate/V1 Definition<a name="OCSPSigningCertificate-V1"></a>

This template is used to create certificates for signing OCSP responses\. The template is identical to the `CodeSigningCertificate` template, except that the extended key usage value specifies OCSP signing instead of code signing\.


****  

|  Parameter  | Value | 
| --- | --- | 
|   X509v3 subject alternative name  |  \[copy from CSR\]  | 
|  X509v3 basic constraints  |  `CA:FALSE`  | 
| X509v3 authority key identifier | \[AKI\] | 
|  X509v3 subject key identifier  |  \[SKI\]  | 
|  X509v3 key usage  | critical, digital signature | 
|  X509v3 extended key usage  |  critical, OCSP signing  | 
|  X509v3 CRL distribution points\*  | \[CRL distribution point\] | 

\*CRL distribution points are included in the template only if the CA is configured with CRL generation enabled\. 

## OCSPSigningCertificate\_CSRPassthrough/V1 Definition<a name="OCSPSigningCertificate_CSRPassthrough-V1"></a>

This template is identical to the `OCSPSigningCertificate` template with one difference\. In this template, ACM Private CA passes additional extensions from the certificate signing request \(CSR\) into the certificate if the extensions are not specified in the template\. Extensions specified in the template always override extensions in the CSR\.


****  

|  Parameter  | Value | 
| --- | --- | 
|   X509v3 subject alternative name  |  \[copy from CSR\]  | 
|  X509v3 basic constraints  |  `CA:FALSE`  | 
| X509v3 authority key identifier | \[AKI\] | 
|  X509v3 subject key identifier  |  \[SKI\]  | 
|  X509v3 key usage  | critical, digital signature | 
|  X509v3 extended key usage  |  critical, OCSP signing  | 
|  X509v3 CRL distribution points\*  | \[CRL distribution point\] | 

\*CRL distribution points are included in the template only if the CA is configured with CRL generation enabled\. 

## RootCACertificate/V1 Definition<a name="RootCACertificate-V1"></a>

This template is used to issue self\-signed root CA certificates\. CA certificates include a critical basic constraints extension with the CA field set to `TRUE` to designate that the certificate can be used to issue CA certificates\. This template does not specify a path length because the path length constrains the maximum length of the CA chain \(CA certification depth\)\. A constrained chain length could inhibit future expansion of the hierarchy\. Extended key usage is excluded to prevent use of the CA certificate as a TLS client or server certificate\. No CRL information is specified because a self\-signed certificate cannot be revoked\.


****  

|  Parameter  | Value | 
| --- | --- | 
|  X509v3 subject alternative name  |  \[Copy from CSR\]  | 
|  X509v3 basic constraints  |  Critical, `CA:TRUE`  | 
|  X509v3 authority key identifier  |  \[AKI\]  | 
|  X509v3 subject key identifier  |  \[SKI\]  | 
| X509v3 key usage | Critical, digital signature, keyCertSign, CRL sign | 
| X509v3 CRL distribution points | N/A | 

## SubordinateCACertificate\_PathLen0/V1 Definition<a name="SubordinateCACertificate_PathLen0-V1"></a>

This template is used to issue subordinate CA certificates with a path length of 0\. CA certificates include a critical basic constraints extension with the CA field set to `TRUE` to designate that the certificate can be used to issue CA certificates\. Extended key usage is not included, which prevents the CA certificate from being used as a TLS client or server certificate\.

For more information about certification paths, see [Setting Length Constraints on the Certification Path](https://docs.aws.amazon.com/acm-pca/latest/userguide/ca-hierarchy.html#length-constraints)\.


****  

|  Parameter  | Value | 
| --- | --- | 
| X509v3 subject alternative name |  \[copy from CSR\]  | 
|  X509v3 basic constraints  | Critical, CA:TRUE, pathlen: 0 | 
|  X509v3 authority key identifier  | \[AKI\] | 
|  X509v3 subject key identifier  |  \[SKI\]  | 
|  X509v3 key usage  |  critical, digital signature, `keyCertSign`, CRL sign  | 
|  X509v3 CRL distribution points\*  |  \[CRL distribution point\]  | 

\*CRL distribution points are included in certificates issued with this template only if the CA is configured with CRL generation enabled\.

## SubordinateCACertificate\_PathLen1/V1 Definition<a name="SubordinateCACertificate_PathLen1-V1"></a>

This template is used to issue subordinate CA certificates with a path length of 1\. CA certificates include a critical basic constraints extension with the CA field set to `TRUE` to designate that the certificate can be used to issue CA certificates\. Extended key usage is not included, which prevents the CA certificate from being used as a TLS client or server certificate\.

For more information about certification paths, see [Setting Length Constraints on the Certification Path](https://docs.aws.amazon.com/acm-pca/latest/userguide/ca-hierarchy.html#length-constraints)\.


****  

|  Parameter  | Value | 
| --- | --- | 
| X509v3 subject alternative name |  \[copy from CSR\]  | 
|  X509v3 basic constraints  | Critical, CA:TRUE, pathlen: 1 | 
|  X509v3 authority key identifier  | \[AKI\] | 
|  X509v3 subject key identifier  |  \[SKI\]  | 
|  X509v3 key usage  |  critical, digital signature, `keyCertSign`, CRL sign  | 
|  X509v3 CRL distribution points\*  |  \[CRL distribution point\]  | 

\*CRL distribution points are included in certificates issued with this template only if the CA is configured with CRL generation enabled\.

## SubordinateCACertificate\_PathLen2/V1 Definition<a name="SubordinateCACertificate_PathLen2-V1"></a>

This template is used to issue subordinate CA certificates with a path length of 2\. CA certificates include a critical basic constraints extension with the CA field set to `TRUE` to designate that the certificate can be used to issue CA certificates\. Extended key usage is not included, which prevents the CA certificate from being used as a TLS client or server certificate\.

For more information about certification paths, see [Setting Length Constraints on the Certification Path](https://docs.aws.amazon.com/acm-pca/latest/userguide/ca-hierarchy.html#length-constraints)\.


****  

|  Parameter  | Value | 
| --- | --- | 
| X509v3 subject alternative name |  \[copy from CSR\]  | 
|  X509v3 basic constraints  | Critical, CA:TRUE, pathlen: 2 | 
|  X509v3 authority key identifier  | \[AKI\] | 
|  X509v3 subject ky identifier  |  \[SKI\]  | 
|  X509v3 key usage  |  critical, digital signature, `keyCertSign`, CRL sign  | 
|  X509v3 CRL distribution points\*  |  \[CRL distribution point\]  | 

\*CRL distribution points are included in certificates issued with this template only if the CA is configured with CRL generation enabled\.

## SubordinateCACertificate\_PathLen3/V1 Definition<a name="SubordinateCACertificate_PathLen3-V1"></a>

This template is used to issue subordinate CA certificates with a path length of 3\. CA certificates include a critical basic constraints extension with the CA field set to `TRUE` to designate that the certificate can be used to issue CA certificates\. Extended key usage is not included, which prevents the CA certificate from being used as a TLS client or server certificate\.

For more information about certification paths, see [Setting Length Constraints on the Certification Path](https://docs.aws.amazon.com/acm-pca/latest/userguide/ca-hierarchy.html#length-constraints)\.


****  

|  Parameter  | Value | 
| --- | --- | 
| X509v3 subject alternative name |  \[copy from CSR\]  | 
|  X509v3 basic constraints  | Critical, CA:TRUE, pathlen: 3 | 
|  X509v3 authority key identifier  | \[AKI\] | 
|  X509v3 subject key identifier  |  \[SKI\]  | 
|  X509v3 key usage  |  critical, digital signature, `keyCertSign`, CRL sign  | 
|  X509v3 CRL distribution points\*  |  \[CRL distribution point\]  | 

\*CRL distribution points are included in certificates issued with this template only if the CA is configured with CRL generation enabled\.