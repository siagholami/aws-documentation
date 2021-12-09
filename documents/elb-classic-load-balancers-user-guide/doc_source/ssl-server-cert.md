# SSL/TLS certificates for Classic Load Balancers<a name="ssl-server-cert"></a>

If you use HTTPS \(SSL or TLS\) for your front\-end listener, you must deploy an SSL/TLS certificate on your load balancer\. The load balancer uses the certificate to terminate the connection and then decrypt requests from clients before sending them to the instances\.

The SSL and TLS protocols use an X\.509 certificate \(SSL/TLS server certificate\) to authenticate both the client and the back\-end application\. An X\.509 certificate is a digital form of identification issued by a certificate authority \(CA\) and contains identification information, a validity period, a public key, a serial number, and the digital signature of the issuer\.

You can create a certificate using AWS Certificate Manager or a tool that supports the SSL and TLS protocols, such as OpenSSL\. You will specify this certificate when you create or update an HTTPS listener for your load balancer\. When you create a certificate for use with your load balancer, you must specify a domain name\.

## Create or import an SSL/TLS certificate using AWS Certificate Manager<a name="create-certificate-acm"></a>

We recommend that you use AWS Certificate Manager \(ACM\) to create or import certificates for your load balancer\. ACM integrates with Elastic Load Balancing so that you can deploy the certificate on your load balancer\. To deploy a certificate on your load balancer, the certificate must be in the same Region as the load balancer\. For more information, see [Request a public certificate](https://docs.aws.amazon.com/acm/latest/userguide/gs-acm-request-public.html) or [Importing certificates](https://docs.aws.amazon.com/acm/latest/userguide/import-certificate.html) in the *AWS Certificate Manager User Guide*\.

To allow an IAM user to deploy the certificate on your load balancer using the AWS Management Console, you must allow access to the ACM `ListCertificates` API action\. For more information, see [Listing certificates](https://docs.aws.amazon.com/acm/latest/userguide/authen-inlinepolicies.html#policy-list-certificates) in the *AWS Certificate Manager User Guide*\.

**Important**  
You cannot install certificates with 4096\-bit RSA keys or EC keys on your load balancer through integration with ACM\. You must upload certificates with 4096\-bit RSA keys or EC keys to IAM in order to use them with your load balancer\.

## Import an SSL/TLS certificate using IAM<a name="import-certificate-iam"></a>

If you are not using ACM, you can use SSL/TLS tools, such as OpenSSL, to create a certificate signing request \(CSR\), get the CSR signed by a CA to produce a certificate, and upload the certificate to AWS Identity and Access Management \(IAM\)\. For more information about uploading certificates to IAM, see [Working with server certificates](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_server-certs.html) in the *IAM User Guide*\.