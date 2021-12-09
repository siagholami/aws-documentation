# Revoking a Private Certificate<a name="PcaRevokeCert"></a>

You can use the AWS CLI or ACM Private CA API to revoke a certificate\. The certificate will be included in the certificate revocation list \(CRL\), if it exists, of the issuing private CA\. Revoked certificates are always recorded in the audit report\. 

**Note**  
Cross\-account certificate issuers cannot revoke the certificates that they issue\. The CA owner must perform revocation\. 

**To revoke a certificate**  
Use the [RevokeCertificate](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_RevokeCertificate.html) API action or [revoke\-certificate](https://docs.aws.amazon.com/cli/latest/reference/acm-pca/revoke-certificate.html) command to revoke a private PKI certificate\. The serial number must be in hexadecimal format\. You can retrieve the serial number by calling the [get\-certificate](https://docs.aws.amazon.com/cli/latest/reference/acm-pca/get-certificate.html) command\. The `revoke-certificate` command does not return a response\. 

```
aws acm-pca revoke-certificate \
--certificate-authority-arn arn:aws:acm-pca:region:account:\
certificate-authority/12345678-1234-1234-1234-123456789012 \ 
--certificate-serial 67:07:44:76:83:a9:b7:f4:05:56:27:ff:d5:5c:eb:cc \ 
--revocation-reason "KEY_COMPROMISE"
```

## Revoked Certificates in a CRL<a name="PcaRevokeCrl"></a>

The following example shows a revoked certificate in a certificate revocation list \(CRL\)\. A CRL is typically updated approximately 30 minutes after a certificate is revoked\. If for any reason the CRL update fails, ACM PCA attempts makes further attempts every 15 minutes\. With Amazon CloudWatch, you can create alarms for the metrics `CRLGenerated` and `MisconfiguredCRLBucket`\. For more information, see [Supported CloudWatch Metrics](https://docs.aws.amazon.com/acm-pca/latest/userguide/PcaCloudWatch.html)\. For more information about creating and configuring CRLs, see [Creating a Private CA and CRL](PcaCreateCa.md)\. 

```
Certificate Revocation List (CRL):
        Version 2 (0x1)
    Signature Algorithm: sha256WithRSAEncryption
        Issuer: /C=US/ST=WA/L=Seattle/O=Examples LLC/OU=Corporate Office/CN=www.example.com
        Last Update: Jan 10 19:28:47 2018 GMT
        Next Update: Jan  8 20:28:47 2028 GMT
        CRL extensions:
            X509v3 Authority Key Identifier:
                keyid:3B:F0:04:6B:51:54:1F:C9:AE:4A:C0:2F:11:E6:13:85:D8:84:74:67

            X509v3 CRL Number:
                1515616127629
Revoked Certificates:
    Serial Number: B17B6F9AE9309C51D5573BCA78764C23
        Revocation Date: Jan  9 17:19:17 2018 GMT
        CRL entry extensions:
            X509v3 CRL Reason Code:
                Key Compromise
    Signature Algorithm: sha256WithRSAEncryption
         21:2f:86:46:6e:0a:9c:0d:85:f6:b6:b6:db:50:ce:32:d4:76:
         99:3e:df:ec:6f:c7:3b:7e:a3:6b:66:a7:b2:83:e8:3b:53:42:
         f0:7a:bc:ba:0f:81:4d:9b:71:ee:14:c3:db:ad:a0:91:c4:9f:
         98:f1:4a:69:9a:3f:e3:61:36:cf:93:0a:1b:7d:f7:8d:53:1f:
         2e:f8:bd:3c:7d:72:91:4c:36:38:06:bf:f9:c7:d1:47:6e:8e:
         54:eb:87:02:33:14:10:7f:b2:81:65:a1:62:f5:fb:e1:79:d5:
         1d:4c:0e:95:0d:84:31:f8:5d:59:5d:f9:2b:6f:e4:e6:60:8b:
         58:7d:b2:a9:70:fd:72:4f:e7:5b:e4:06:fc:e7:23:e7:08:28:
         f7:06:09:2a:a1:73:31:ec:1c:32:f8:dc:03:ea:33:a8:8e:d9:
         d4:78:c1:90:4c:08:ca:ba:ec:55:c3:00:f4:2e:03:b2:dd:8a:
         43:13:fd:c8:31:c9:cd:8d:b3:5e:06:c6:cc:15:41:12:5d:51:
         a2:84:61:16:a0:cf:f5:38:10:da:a5:3b:69:7f:9c:b0:aa:29:
         5f:fc:42:68:b8:fb:88:19:af:d9:ef:76:19:db:24:1f:eb:87:
         65:b2:05:44:86:21:e0:b4:11:5c:db:f6:a2:f9:7c:a6:16:85:
         0e:81:b2:76
```

## Revoked Certificates in an Audit Report<a name="PcaRevokeAuditReport"></a>

All certificates, including revoked certificates, are included in the audit report for a private CA\. The following example shows an audit report with one issued and one revoked certificate\. For more information, see [Using Audit Reports with Your Private CA](PcaAuditReport.md)\. 

```
[{
  "awsAccountId": "123456789012",
  "certificateArn": "arn:aws:acm-pca:region:account:certificate-authority/CA_ID/certificate/e8cbd2bedb122329f97706bcfec990f8",
  "serial": "e8:cb:d2:be:db:12:23:29:f9:77:06:bc:fe:c9:90:f8",
  "subject": "1.2.840.113549.1.9.1=#161173616c6573406578616d706c652e636f6d,CN=www.example1.com,OU=Sales,O=Example Company,L=Seattle,ST=Washington,C=US",
  "notBefore": "2018-02-26T18:39:57+0000",
  "notAfter": "2019-02-26T19:39:57+0000",
  "issuedAt": "2018-02-26T19:39:58+0000",
  "revokedAt": "2018-02-26T20:00:36+0000",
  "revocationReason": "KEY_COMPROMISE"
},
{
  "awsAccountId": "123456789012",
  "certificateArn": "arn:aws:acm-pca:region:account:certificate-authority/CA_ID/certificate/2bae9a75d71b42b4e41e36f8b4b488fc",
  "serial": "2b:ae:9a:75:d7:1b:42:b4:e4:1e:36:f8:b4:b4:88:fc",
  "subject": "1.2.840.113549.1.9.1=#161970726f64407777772e70616c6f75736573616c65732e636f6d,CN=www.example3.com.com,OU=Sales,O=Example Company,L=Seattle,ST=Washington,C=US",
  "notBefore": "2018-01-22T20:10:49+0000",
  "notAfter": "2019-01-17T21:10:49+0000",
  "issuedAt": "2018-01-22T21:10:49+0000"
}]
```