# Public Key Cryptography Standard \(PKCS\) \#11 library<a name="security-pkcs"></a>

## Overview<a name="freertos-pkcs-overview"></a>

Public Key Cryptography Standard \#11 \(PKCS\#11\) is a cryptographic API that abstracts key storage, get/set properties for cryptographic objects, and session semantics\. See `pkcs11.h` \(obtained from OASIS, the standard body\) in the FreeRTOS source code repository\. In the FreeRTOS reference implementation, [PKCS\#11 API](https://docs.aws.amazon.com/freertos/latest/lib-ref/html2/pkcs11/index.html) calls are made by the TLS helper interface in order to perform TLS client authentication during `SOCKETS_Connect`\. PKCS\#11 API calls are also made by our one\-time developer provisioning workflow to import a TLS client certificate and private key for authentication to the AWS IoT MQTT broker\. Those two use cases, provisioning and TLS client authentication, require implementation of only a small subset of the PKCS\#11 interface standard\.

## Features<a name="freertos-pcks-features"></a>

The following subset of PKCS\#11 is used\. This list is in roughly the order in which the routines are called in support of provisioning, TLS client authentication, and cleanup\. For detailed descriptions of the functions, see the PKCS\#11 documentation provided by the standard committee\.

### General setup and tear down API<a name="pkcs-required-setup-teardown"></a>
+ `C_Initialize`
+ `C_Finalize`
+ `C_GetFunctionList`
+ `C_GetSlotList`
+ `C_GetTokenInfo`
+ `C_OpenSession`
+ `C_CloseSession`
+ `C_Login`

### Provisioning API<a name="pkcs-required-provisioning"></a>
+ `C_CreateObject CKO_PRIVATE_KEY` \(for device private key\)
+ `C_CreateObject CKO_CERTIFICATE` \(for device certificate and code verification certificate\)
+ `C_GenerateKeyPair`
+ `C_DestroyObject`

### Client authentication<a name="pkcs-required-client-auth"></a>
+ `C_GetAttributeValue`
+ `C_FindObjectsInit`
+ `C_FindObjects`
+ `C_FindObjectsFinal`
+ `C_GenerateRandom`
+ `C_SignInit`
+ `C_Sign`
+ `C_VerifyInit`
+ `C_Verify`
+ `C_DigestInit`
+ `C_DigestUpdate`
+ `C_DigestFinal`

## Asymmetric cryptosystem support<a name="pkcs-asym-crypto"></a>

The FreeRTOS PKCS\#11 reference implementation supports 2048\-bit RSA \(signing only\) and ECDSA with the NIST P\-256 curve\. The following instructions describe how to create an AWS IoT thing based on a P\-256 client certificate\.

Make sure you are using the following \(or more recent\) versions of the AWS CLI and OpenSSL:

```
aws --version
aws-cli/1.11.176 Python/2.7.9 Windows/8 botocore/1.7.34

openssl version
OpenSSL 1.0.2g  1 Mar 2016
```

The following procedure assumes that you used the aws configure command to configure the AWS CLI\. For more information, see [Quick configuration with aws configure](https://docs.aws.amazon.com/cli/latest/userguide/cli-configure-quickstart.html#cli-configure-quickstart-config) in the *AWS Command Line Interface User Guide*\.

**To create an AWS IoT thing based on a P\-256 client certificate**

1. Create an AWS IoT thing\.

   ```
   aws iot create-thing --thing-name thing-name
   ```

1. Use OpenSSL to create a P\-256 key\.

   ```
   openssl genpkey -algorithm EC -pkeyopt ec_paramgen_curve:P-256 -pkeyopt ec_param_enc:named_curve -outform PEM -out thing-name.key
   ```

1. Create a certificate enrollment request signed by the key created in step 2\.

   ```
   openssl req -new -nodes -days 365 -key thing-name.key -out thing-name.req
   ```

1. Submit the certificate enrollment request to AWS IoT\.

   ```
   aws iot create-certificate-from-csr  \
     --certificate-signing-request file://thing-name.req --set-as-active  \
     --certificate-pem-outfile thing-name.crt
   ```

1. Attach the certificate \(referenced by the ARN output by the previous command\) to the thing\.

   ```
   aws iot attach-thing-principal --thing-name thing-name \
     --principal "arn:aws:iot:us-east-1:123456789012:cert/86e41339a6d1bbc67abf31faf455092cdebf8f21ffbc67c4d238d1326c7de729"
   ```

1. Create a policy\. \(This policy is too permissive\. It should be used for development purposes only\.\)

   ```
   aws iot create-policy --policy-name FullControl --policy-document file://policy.json
   ```

   The following is a listing of the policy\.json file specified in the `create-policy` command\. You can omit the `greengrass:*` action if you don't want to run the FreeRTOS demo for Greengrass connectivity and discovery\.

   ```
   {
     "Version": "2012-10-17",
     "Statement": [
       {
         "Effect": "Allow",
         "Action": "iot:*",
         "Resource": "*"
       },
       {
         "Effect": "Allow",
         "Action": "greengrass:*",
         "Resource": "*"
       }
     ]
   }
   ```

1. Attach the principal \(certificate\) and policy to the thing\.

   ```
   aws iot attach-principal-policy --policy-name FullControl \
     --principal "arn:aws:iot:us-east-1:123456789012:cert/86e41339a6d1bbc67abf31faf455092cdebf8f21ffbc67c4d238d1326c7de729"
   ```

Now, follow the steps in the [AWS IoT Getting Started](https://docs.aws.amazon.com/iot/latest/developerguide/iot-gs.html) section of this guide\. Don’t forget to copy the certificate and private key you created into your `aws_clientcredential_keys.h` file\. Copy your thing name into `aws_clientcredential.h`\.

**Note**  
The certificate and private key are hard\-coded for demonstration purposes only\. Production\-level applications should store these files in a secure location\.

## Porting<a name="freertos-pkcs-porting"></a>

For information about porting the PKCS \#11 library to your platform, see [Porting the PKCS \#11 Library](https://docs.aws.amazon.com/freertos/latest/portingguide/afr-porting-pkcs.html) in the FreeRTOS Porting Guide\.