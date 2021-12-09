--------

--------

# Key Management<a name="key-management"></a>

All connections to AWS IoT Things Graph are done using the Transport Layer Security \(TLS\) protocol, so client\-side encryption keys aren't necessary for the initial TLS connection\. Devices must authenticate using an X\.509 certificate\. AWS IoT can generate a certificate for you, in which case it generates a public/private key pair\. 

You can generate a certificate in the following ways:
+ If you're using the AWS IoT console, you're prompted to download the certificate and keys\. 
+ If you're using the `create-keys-and-certificate` AWS CLI command, the AWS CLI returns the certificate and keys\.

**Important**  
You're responsible for copying the certificate and private key to your device and keeping it safe\.