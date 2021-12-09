# Retrieve a Private Certificate Created by ACM Private CA<a name="PcaGetCert"></a>

You can use the ACM Private CA API and AWS CLI to issue a private certificate\. If you do, you can use the AWS CLI or ACM Private CA API to retrieve that certificate\. If you used ACM to create your private CA and to request certificates, you must use ACM to export the certificate and the encrypted private key\. For more information, see [Exporting a Private Certificate](https://docs.aws.amazon.com/acm/latest/userguide/gs-acm-export-private.html)\. 

Use the [get\-certificate](https://docs.aws.amazon.com/cli/latest/reference/acm-pca/get-certificate.html) command to retrieve a private certificate\. You can also use the [GetCertificate](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_GetCertificate.html) operation\. Use the `--output text` option to output the certificate without <CR><LF> pairs\. 

**Note**  
If you want to revoke a certificate, you can use the get\-certificate command to retrieve the serial number in hexadecimal format\. You can also create an audit report to retrieve the hex serial number\. For more information, see [Using Audit Reports with Your Private CA](PcaAuditReport.md)\. 

```
aws acm-pca get-certificate \
--certificate-authority-arn arn:aws:acm-pca:region:account:\
certificate-authority/12345678-1234-1234-1234-123456789012 \
--certificate-arn arn:aws:acm-pca:region:account:\
certificate-authority/12345678-1234-1234-1234-123456789012/\
certificate/6707447683a9b7f4055627ffd55cebcc \
--output text
```

This command outputs the base64 encoded PEM format certificate and the certificate chain\.

```
-----BEGIN CERTIFICATE-----
...Base64-encoded certificate...
-----END CERTIFICATE----
-----BEGIN CERTIFICATE-----
...Base64-encoded certificate...
-----END CERTIFICATE----
-----BEGIN CERTIFICATE-----
...Base64-encoded certificate...
-----END CERTIFICATE----
```