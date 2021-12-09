# Issuing a Private End\-Entity Certificate<a name="PcaIssueCert"></a>

With a private CA in place, you can request private end\-entity certificates from either AWS Certificate Manager \(ACM\) or ACM Private CA\. The capabilities of both services are compared in the following table\.


****  

| Capability | ACM | ACM Private CA | 
| --- | --- | --- | 
| Issue end\-entity certificates | ✓ \(using [RequestCertificate](https://docs.aws.amazon.com/acm/latest/APIReference/API_RequestCertificate.html) \+ [GetCertificate](https://docs.aws.amazon.com/acm/latest/APIReference/API_GetCertificate.html) or the console\) | ✓ \(using [IssueCertificate](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_IssueCertificate.html)\) | 
| Association with internet\-facing AWS services | ✓ | Not supported | 
| Console support | ✓ | Not supported | 
| API support | ✓ | ✓ | 
| CLI support | ✓ | ✓ | 

When ACM Private CA creates a certificate, it follows a template that specifies the certificate type and path length\. If no template ARN is supplied to the API or CLI statement creating the certificate, the [EndEntityCertificate/V1](UsingTemplates.md#EndEntityCertificate-V1) template is applied by default\. For more information about available certificate templates, see [Understanding Certificate Templates](UsingTemplates.md)\.

While ACM certificates are designed around public trust, ACM Private CA serves the needs of your private PKI\. Consequently, you can configure certificates using the ACM Private CA API and CLI in ways not permitted by ACM\. These include the following:
+ Creating a certificate with any subject name\.
+ Using any of the [supported private key algorithms and key lengths](https://docs.aws.amazon.com/acm-pca/latest/userguide/supported-algorithms.html)\.
+ Using any of the [supported signing algorithms](https://docs.aws.amazon.com/acm-pca/latest/userguide/supported-algorithms.html)\.
+ Specifying any validity period for your private [CA](PcaCreateCa.html) and private [certificates](PcaIssueCert.html)\.

After creating a private certificate using ACM Private CA, you can [import](https://docs.aws.amazon.com/acm/latest/userguide/import-certificate-api-cli.html) it into ACM and use it with a supported AWS service\.

## Issuing a Certificate \(AWS CLI\)<a name="IssueCertCli"></a>

You can use the ACM Private CA CLI command [issue\-certificate](https://docs.aws.amazon.com/cli/latest/reference/acm-pca/issue-certificate.html) or the API action [IssueCertificate](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_IssueCertificate.html) to request an end\-entity certificate\. This command requires the Amazon Resource Name \(ARN\) of the private CA that you want to use to issue the certificate\.

If you use the ACM Private CA API or AWS CLI to issue a private certificate, the certificate in unmanaged, meaning that you cannot use the ACM console, ACM CLI, or ACM API to view or export it, and the certificate is not automatically renewed\. However, you can use the PCA [get\-certificate](https://docs.aws.amazon.com/cli/latest/reference/acm-pca/get-certificate.html) command to retrieve the certificate details, and if you own the CA, you can create an [audit report](PcaAuditReport.md)\.

The following command specifies no template, so an end\-entity certificate is issued by default\.

```
aws acm-pca issue-certificate \
--certificate-authority-arn arn:aws:acm-pca:region:account:\
certificate-authority/12345678-1234-1234-1234-123456789012 \
--csr fileb://C:\cert_1.csr \
--signing-algorithm "SHA256WITHRSA" \
--validity Value=365,Type="DAYS" \
--idempotency-token 1234
```

The ARN of the issued certificate is returned:

```
{
  "CertificateArn": "arn:aws:acm-pca:region:account:\
    certificate-authority/12345678-1234-1234-1234-123456789012/certificate/a2b95975ec6e1cd85a21c2104c5be129"
}
```