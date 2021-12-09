# Retrieve a Certificate Authority \(CA\) Certificate<a name="PcaGetCACert"></a>

You can use the ACM Private CA API and AWS CLI to retrieve the certificate authority \(CA\) certificate for your private CA\. Run the `[get\-certificate\-authority\-certificate](https://docs.aws.amazon.com/cli/latest/reference/acm-pca/get-certificate-authority-certificate.html)` command\. You can also call the `[GetCertificateAuthorityCertificate](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_GetCertificateAuthorityCertificate.html)` operation\. Use the `--output text` option to output the certificate without `<CR><LF>` pairs\. 

```
aws acm-pca get-certificate-authority-certificate \
--certificate-authority-arn arn:aws:acm-pca:region:account:\
certificate-authority/12345678-1234-1234-1234-123456789012 \
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
```