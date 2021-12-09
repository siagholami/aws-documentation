# Import Your Private CA Certificate into ACM Private CA<a name="PcaImportCaCert"></a>

After you [create](PcaCreateCa.md) your private CA, [retrieve](PcaGetCsr.md) the certificate signing request \(CSR\), and [sign](PcaSignCert.md) the CA certificate, you must import the certificate into ACM Private CA\. After signing and importing the certificate, you can use your private CA to issue and revoke trusted private SSL/TLS certificates\. These enable trusted communication between users, applications, computers, and other devices internal to your organization\. The certificates cannot be publicly trusted\. 

You must also retrieve the certificate chain that contains the certificate of the intermediate or root CA used to sign your private CA certificate and any preceding certificates\. To create the chain, concatenate your root certificate, if available, and any subordinate certificates that you might have into a single file\. You can use the `cat` command \(Linux\) to do so\. Each certificate must directly certify the one preceding\. The following example contains three certificates, but your PKI infrastructure might have more or fewer\. 

**Note**  
Your chain must be PEM formatted\.

```
    -----BEGIN CERTIFICATE-----
    Base64-encoded intermediate CA certificate 
    -----END CERTIFICATE-----
    -----BEGIN CERTIFICATE-----
    Base64-encoded intermediate CA certificate 
    -----END CERTIFICATE-----    
    -----BEGIN CERTIFICATE-----
    Base64-encoded root or intermediate CA certificate
    -----END CERTIFICATE-----
```

## Importing the Private CA Certificate \(Console\)<a name="ImportConsole"></a>

You can import a private CA certificate using the AWS Management Console\.

**To import the CA certificate \(console\)**

1. If your console is still open to the **Import a signed certificate authority \(CA\) certificate** page, skip to step 7\. Otherwise, continue\.

1. Sign in to your AWS account and open the ACM Private CA console at [https://console\.aws\.amazon\.com/acm\-pca/home](https://console.aws.amazon.com/acm-pca/home)\.

1. Choose **Private CAs**\.

1. Select your private CA from the list\.

1. On the **Actions** menu, choose **Import CA certificate**\.

1. Choose **Next**\.

1. For **Certificate body**, copy your signed private CA certificate into the textbox or import it from a file\. 

1. For **Certificate chain**, copy the certificate chain into the textbox or import it from a file\. 

1. Choose **Next**\.

1. Choose **Confirm and Import** to import the private CA certificate\. 

## Importing the Private CA Certificate \(AWS CLI\)<a name="ImportCli"></a>

Before beginning, make sure that you have your signed CA certificate and your certificate chain in PEM formatted files\.

**To import the CA certificate \(AWS CLI\)**  
Use the [import\-certificate\-authority\-certificate](https://docs.aws.amazon.com/cli/latest/reference/acm-pca/import-certificate-authority-certificate.html) command to import the private CA certificate into ACM Private CA\.

```
aws acm-pca import-certificate-authority-certificate \
--certificate-authority-arn arn:aws:acm-pca:region:account:\
certificate-authority/12345678-1234-1234-1234-123456789012 \
--certificate file://C:\example_ca_cert.pem \
--certificate-chain file://C:\example_ca_cert_chain.pem
```