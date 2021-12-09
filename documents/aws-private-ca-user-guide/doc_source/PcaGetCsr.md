# Get a Certificate Signing Request \(CSR\)<a name="PcaGetCsr"></a>

If you have created a private subordinate CA that you want to sign with an external CA, you must retrieve a certificate signing request \(CSR\)\. Then save it to a file\. You can do this using the AWS Management Console or the AWS CLI as discussed in the procedures that follow\. If you want to inspect the CSR, use the following OpenSSL command: 

```
openssl req -in path_to_CSR_file -text -noout
```

This command generates output similar to the following\. Notice that the **CA** extension is `TRUE`, indicating that the CSR is for a CA certificate\. 

```
Certificate Request:
    Data:
        Version: 0 (0x0)
        Subject: O=ExampleCompany, OU=Corporate Office, CN=Example CA 1
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
        Attributes:
        Requested Extensions:
            X509v3 Basic Constraints:
                CA:TRUE
    Signature Algorithm: sha256WithRSAEncryption
         c5:64:0e:6c:cf:11:03:0b:b7:b8:9e:48:e1:04:45:a0:7f:cc:
         a7:fd:e9:4d:c9:00:26:c5:6e:d0:7e:69:7a:fb:17:1f:f3:5d:
         ac:f3:65:0a:96:5a:47:3c:c1:ee:45:84:46:e3:e6:05:73:0c:
         ce:c9:a0:5e:af:55:bb:89:46:21:92:7b:10:96:92:1b:e6:75:
         de:02:13:2d:98:72:47:bd:b1:13:1a:3d:bb:71:ae:62:86:1a:
         ee:ae:4e:f4:29:2e:d6:fc:70:06:ac:ca:cf:bb:ee:63:68:14:
         8e:b2:8f:e3:8d:e8:8f:e0:33:74:d6:cf:e2:e9:41:ad:b6:47:
         f8:2e:7d:0a:82:af:c6:d8:53:c2:88:a0:32:05:09:e0:04:8f:
         79:1c:ac:0d:d4:77:8e:a6:b2:5f:07:f8:1b:e3:98:d4:12:3d:
         28:32:82:b5:50:92:a4:b2:4c:28:fc:d2:73:75:75:ff:10:33:
         2c:c0:67:4b:de:fd:e6:69:1c:a8:bb:e8:31:93:07:35:69:b7:
         d6:53:37:53:d5:07:dd:54:35:74:50:50:f9:99:7d:38:b7:b6:
         7f:bd:6c:b8:e4:2a:38:e5:04:00:a8:a3:d9:e5:06:38:e0:38:
         4c:ca:a9:3c:37:6d:ba:58:38:11:9c:30:08:93:a5:62:00:18:
         d1:83:66:40
```

## Retrieving a CSR \(Console\): Method 1<a name="getCsrConsole1"></a>

Use this procedure if you followed the steps to [create a private CA](PcaCreateCa.md) in ACM Private CA and left the **Success** dialog box open\. 

**To retrieve a CSR \(console\): method 1**

1. Immediately after ACM Private CA has successfully created your private CA, choose **Get started**\. The ACM Private CA console returns the CSR\. You can return to this step later\. 

1. Choose **Export CSR to a file** and save it locally\.

1. Choose **Next**\.

1. Follow the instructions in [Sign Your Private CA Certificate](PcaSignCert.md)\.

## Retrieving a CSR \(Console\): Method 2<a name="getCsrConsole2"></a>

Use this procedure if you followed the steps to [create a private CA](PcaCreateCa.md) in ACM Private CA and closed the **Success** dialog box\. 

**To retrieve a CSR \(console\): method 2**

1. When you are ready to continue, open the AWS Certificate Manager console and choose **Private CAs** in the left navigation pane\. 

1. Select your private CA from the list\.

1. From the **Actions** menu, choose **Import CA certificate**\. The ACM Private CA console returns the CSR\. 

1. Choose **Export CSR to a file** and save it locally\.

1. Choose **Next**\.

1. Follow the instructions in [Sign Your Private CA Certificate](PcaSignCert.md)\.

## Retrieving a CSR \(AWS CLI\)<a name="getCsrCli"></a>

Use this procedure to retrieve a CSR using the AWS Command Line Interface\.

**To retrieve a CSR \(AWS CLI\)**

1. Use the [get\-certificate\-authority\-csr](https://docs.aws.amazon.com/cli/latest/reference/acm-pca/get-certificate-authority-csr.html) command to retrieve the certificate signing request \(CSR\) for your private CA\. If you want to send the CSR to your display, use the `--output text` option to eliminate CR/LF characters from the end of each line\. To send the CSR to a file, use the redirect option \(>\) followed by a file name\. 

   ```
   aws acm-pca get-certificate-authority-csr \
   --certificate-authority-arn arn:aws:acm-pca:region:account:\
   certificate-authority/12345678-1234-1234-1234-123456789012 \
   --output text
   ```

1. Follow the instructions in [Sign Your Private CA Certificate](PcaSignCert.md)\.