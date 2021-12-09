# Diagnosing connectivity issues<a name="diagnosing-connectivity-issues"></a>

A successful connection to AWS IoT requires:
+ A valid connection
+ A valid and active certificate
+ A policy that allows the desired connection and operation

## Connection<a name="troubleshooting-connect"></a>

How do I find the correct endpoint?  
+ The `endpointAddress` returned by aws iot [describe\-endpoint](https://awscli.amazonaws.com/v2/documentation/api/latest/reference/iot/describe-endpoint.html) \-\-endpoint\-type iot:Data\-ATS

  or
+ The `domainName` returned by aws iot [describe\-domain\-configuration](https://awscli.amazonaws.com/v2/documentation/api/latest/reference/iot/describe-domain-configuration.html) –\-domain\-configuration\-name "*domain\_configuration\_name*"

How do I find the correct Server Name Indication \(SNI\) value?  
The correct SNI value is the `endpointAddress` returned by the [describe\-endpoint](https://awscli.amazonaws.com/v2/documentation/api/latest/reference/iot/describe-endpoint.html) or [describe\-domain\-configuration](https://awscli.amazonaws.com/v2/documentation/api/latest/reference/iot/describe-domain-configuration.html) commands\. It's the same address as the endpoint in the previous step\.

## Authentication<a name="troubleshooting-authentication"></a>

How do my devices authenticate AWS IoT endpoints?  
Add the AWS IoT CA certificate to your client's trust store\. Refer to the documentation on [Server Authentication in AWS IoT Core](x509-client-certs.html#server-authentication) and then follow the links to download the appropriate CA certificate\.

How can I validate a correctly configured certificate?  
Use the OpenSSL `s_client` command to test a connection to the AWS IoT endpoint:  
` openssl s_client -connect custom_endpoint.iot.aws-region.amazonaws.com:8443 -CAfile CA.pem -cert cert.pem -key privateKey.pem`   
For more information about using `openssl s_client`, see [OpenSSL s\_client documentation](https://www.openssl.org/docs/man1.0.2/man1/openssl-s_client.html)\.

How do I check the status of a certificate?  
+ 

**List the certificates**  
If you don't know the certificate ID, you can see the status of all your certificates by using the aws iot [list\-certificates](https://awscli.amazonaws.com/v2/documentation/api/latest/reference/iot/list-certificates.html) command\.
+ 

**Show a certificate's details**  
If you know the certificate's ID, you can see more detailed information about the certificate by using the aws iot [describe\-certificate](https://awscli.amazonaws.com/v2/documentation/api/latest/reference/iot/describe-certificate.html) \-\-certificate\-id "*certificateId*" command\.
+ 

**Review the certificate in the AWS IoT Console**  
In the [AWS IoT console](https://console.aws.amazon.com/iot/home), in the left menu, choose **Secure**, and then choose **Certificates**\.

  Choose the certificate that you are using to connect from the list to open its detail page\.

  In the certificate's detail page, you can see its current status\.

  The certificate's status can be changed by using the **Actions** menu in the upper\-right corner of the details page\.

## Authorization<a name="troubleshooting-authorization"></a>

I received a `PUBNACK` or `SUBNACK` response from the broker\. What do I do?  
Make sure that there is a policy attached to the certificate you are using to call AWS IoT\. All publish/subscribe operations are denied by default\.

How do I check what the policy authorizes?  
In the [AWS IoT console](https://console.aws.amazon.com/iot/home), in the left menu, choose **Secure**, and then choose **Certificates**\.  
Choose the certificate that you are using to connect from the list to open its detail page\.  
In the certificate's detail page, you can see its current status\.  
In the left menu of the certificate's detail page, choose **Policies** to see the policies attached to the certificate\.  
Choose the desired policy to see its details page\.  
In the policy's details page, review the policy's **Policy document** to see what it authorizes\.  
Choose **Edit policy document** to make changes to the policy document\.