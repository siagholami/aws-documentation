# Create AWS IoT client certificates<a name="device-certs-create"></a>

AWS IoT provides client certificates that are signed by the Amazon Root certificate authority \(CA\)\.

This topic describes how to create a client certificate signed by the Amazon Root certificate authority and download the certificate files\. After you create the client certificate files, you must install them on the client\.

You can use the AWS IoT console or the AWS CLI to create an AWS IoT certificate signed by the Amazon Root certificate authority\.

## Create an AWS IoT certificate \(console\)<a name="device-certs-create-console"></a>

**To create an AWS IoT certificate using the AWS IoT console**

1. Sign in to the AWS Management Console, and open the [AWS IoT console](https://console.aws.amazon.com/iot/home)\.

1. In the left navigation pane, choose **Secure**, choose **Certificates**, and then choose **Create**\.

1. Choose **One\-click certificate creation \(recommended\)** \- **Create certificate**\.

1. From the **Certificate created\!** page, download the client certificate files for the thing, public key, and private key to a secure location\.

   If you also need the Amazon Root CA certificate file, this page also has the link to the page from where you can download it\.

1. A client certificate has now been created and registered with AWS IoT\. You must activate the certificate before you use it in a client\.

   Choose **Activate** to activate the client certificate now\. If you don't want to activate the certificate now, [Activate a client certificate \(console\)](activate-or-deactivate-device-cert.md#activate-device-cert-console) describes how to activate the certificate later\.

1. If you want to attach a policy to the certificate, choose **Attach a policy**\.

   If you don't want to attach a policy now, choose **Done** to finish\. You can attach a policy later\.

After you complete the procedure, install the certificate files on the client\.

## Create an AWS IoT certificate \(CLI\)<a name="device-certs-create-cli"></a>

The AWS CLI provides the [create\-keys\-and\-certificate](https://awscli.amazonaws.com/v2/documentation/api/latest/reference/iot/create-keys-and-certificate.html) command to create client certificates signed by the Amazon Root certificate authority\. This command, however, does not download the Amazon Root CA certificate file\. You can download the Amazon Root CA certificate file from [CA certificates for server authentication](server-authentication.md#server-authentication-certs)\. 

This command creates private key, public key, and X\.509 certificate files and registers and activates the certificate with AWS IoT\.

```
aws iot create-keys-and-certificate \
    --set-as-active \
    --certificate-pem-outfile certificate_filename \
    --public-key-outfile public_key_filename \
    --private-key-outfile private_key_filename
```

If you don't want to activate the certificate when you create and register it, this command creates private key, public key, and X\.509 certificate files and registers the certificate, but it does not activate it\. [Activate a client certificate \(CLI\)](activate-or-deactivate-device-cert.md#activate-device-cert-cli) describes how to activate the certificate later\.

```
aws iot create-keys-and-certificate \
    --no-set-as-active \
    --certificate-pem-outfile certificate_filename \
    --public-key-outfile public_key_filename \
    --private-key-outfile private_key_filename
```

Install the certificate files on the client\.