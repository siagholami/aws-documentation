# Sign Your Private CA Certificate<a name="PcaSignCert"></a>

After you [create](PcaCreateCa.md) your private CA using ACM Private CA and [retrieve](PcaGetCsr.md) a certificate signing request \(CSR\), you must take the CSR to your external X\.509 infrastructure\. Use an intermediate or root CA to create your private CA certificate and sign it\. Signing affirms the identity of the private CA within your organization\. When you have completed this process, follow the instructions in [Import Your Private CA Certificate into ACM Private CA](PcaImportCaCert.md)\. 

**Important**  
Details of your X\.509 infrastructure and the CA hierarchy within it are beyond the scope of this guide\. For more information, see [Creating and Signing a Private CA Certificate](PcaTsSignCsr.md)\. 
The validity period of a private CA is determined by the validity period you specify when you create the private CA certificate\. Set the **Not Before** and **Not After** fields\. Aside from enforcing the defined period, ACM Private CA does not restrict the lifetime of a CA\. 
If you must create a CA certificate that does not effectively expire, set the special value `99991231235959Z` in the **Not After** field\. We do not recommend this as a general practice\. 

The signed certificate is typically returned to you as a base64\-encoded PEM file or string\. This is shown by the following example\. If the certificate is encoded in a different format, you must convert it to PEM\. Various OpenSSL commands are available to perform format conversion\. 

```
-----BEGIN CERTIFICATE-----
MIIDRzCCA..................
..........9YFbLXtPgZooy2IgZ
------END CERTIFICATE------
```

You can use the OpenSSL `x509` command to view the contents of your signed PEM format certificate\. 

```
openssl x509 -in path_to_certificate_file -text -noout
```

This command outputs a certificate similar to the following example\.

```
Certificate:
    Data:
        Version: 3 (0x2)
        Serial Number: 4122 (0x101a)
    Signature Algorithm: sha256WithRSAEncryption
        Issuer: C=US, ST=Washington, L=Seattle, O=Example Company, OU=Corp, CN=www.example.com/emailAddress=corp@www.example.com
        Validity
            Not Before: Mar 29 19:28:43 2018 GMT
            Not After : Mar 26 19:28:43 2028 GMT
        Subject: O=Example Company, OU=Corporate Office, CN=Example Company CA 1
        Subject Public Key Info:
            Public Key Algorithm: rsaEncryption
                Public-Key: (2048 bit)
                Modulus:
                    00:d4:23:51:b3:dd:01:09:01:0b:4c:59:e4:ea:81:
                    1d:7f:48:36:ef:2a:e9:45:82:ec:95:1d:c6:d7:c9:
                    7f:19:06:73:c5:cd:63:43:14:eb:c8:03:82:f8:7b:
                    c7:89:e6:8d:03:eb:b6:76:58:70:f2:cb:c3:4c:67:
                    ea:50:fd:b9:17:84:b8:60:2c:64:9d:2e:d5:7d:da:
                    46:56:38:34:a9:0d:57:77:85:f1:6f:b8:ce:73:eb:
                    f7:62:a7:8e:e6:35:f5:df:0c:f7:3b:f5:7f:bd:f4:
                    38:0b:95:50:2c:be:7d:bf:d9:ad:91:c3:81:29:23:
                    b2:5e:a6:83:79:53:f3:06:12:20:7e:a8:fa:18:d6:
                    a8:f3:a3:89:a5:a3:6a:76:da:d0:97:e5:13:bc:84:
                    a6:5c:d6:54:1a:f0:80:16:dd:4e:79:7b:ff:6d:39:
                    b5:67:56:cb:02:6b:14:c3:17:06:0e:7d:fb:d2:7e:
                    1c:b8:7d:1d:83:13:59:b2:76:75:5e:d1:e3:23:6d:
                    8a:5e:f5:85:ca:d7:e9:a3:f1:9b:42:9f:ed:8a:3c:
                    14:4d:1f:fc:95:2b:51:6c:de:8f:ee:02:8c:0c:b6:
                    3e:2d:68:e5:f8:86:3f:4f:52:ec:a6:f0:01:c4:7d:
                    68:f3:09:ae:b9:97:d6:fc:e4:de:58:58:37:09:9a:
                    f6:27
                Exponent: 65537 (0x10001)
        X509v3 extensions:
            X509v3 Subject Key Identifier:
                3D:5B:CC:96:FA:A5:91:37:2A:C9:97:22:F8:AF:10:A7:4E:E1:A0:6A
            X509v3 Authority Key Identifier:
                keyid:0D:CE:76:F2:E3:3B:93:2D:36:05:41:41:16:36:C8:82:BC:CB:F8:A0

            X509v3 Basic Constraints: critical
                CA:TRUE
            X509v3 Key Usage: critical
                Digital Signature, Certificate Sign, CRL Sign
    Signature Algorithm: sha256WithRSAEncryption
         7e:4b:7c:ca:31:b2:66:25:eb:99:26:91:e2:77:1b:7c:2c:a5:
         d5:e4:ab:c3:98:2a:a2:d7:d9:3b:4a:89:27:cd:94:5c:50:fb:
         59:00:9b:13:56:08:da:87:3c:50:e4:eb:f9:b3:35:92:f8:72:
         d9:11:f0:1e:f3:3b:2e:f5:42:12:de:46:ce:36:ab:f7:b9:2f:
         7e:dd:50:47:49:ad:a6:ee:f6:67:b3:c6:2f:6c:7a:fe:16:9c:
         47:41:81:18:cd:ff:4e:b9:66:8b:ed:04:7a:d0:ce:cb:f3:88:
         c8:89:20:68:6a:2f:6c:3d:60:56:cb:5e:d3:e0:66:8a:32:d8:
         88:19
```