# Key management for SPEKE<a name="encryption-speke-key-management"></a>

With a SPEKE implementation, a conditional access \(CA\) system provides keys to AWS Elemental MediaConnect for content encryption and decryption\. API Gateway acts as a proxy for the communication between the service and the CA platform key provider\. Each AWS Elemental MediaConnect flow must reside in the same AWS Region as its API Gateway proxy\.

The following illustration shows how AWS Elemental MediaConnect obtains the encryption or decryption key using SPEKE\. In the originator's flow, the service obtains the encryption key and uses it to encrypt the content before sending it through the entitlement\. In the subscriber's flow, the service obtains the decryption key when the content is received from the entitlement\.

![\[The figure shows an AWS account with an AWS Elemental MediaConnect flow and an instance of API Gateway in the same AWS Region. An arrow shows that AWS Elemental MediaConnect sends a request for the encryption key. The request is sent to the CA platform key provider through API Gateway. A second arrow shows that the key provider returns the encryption key through API Gateway.\]](http://docs.aws.amazon.com/mediaconnect/latest/ug/)

These are the main services and components:
+ **AWS Elemental MediaConnect** – Provides and controls the encryption setup for the flow\. AWS Elemental MediaConnect obtains the encryption keys from the CA platform key provider through Amazon API Gateway\. Using the encryption keys, AWS Elemental MediaConnect encrypts the content \(for the originator's flow\) or decrypts the content \(for the subscriber's flow\)\. 
+ **API Gateway** – Manages customer\-trusted roles and proxy communication between the encryptor and the key provider\. API Gateway provides logging capabilities and lets customers control their relationships with the encryptor and with the CA platform\. The API Gateway must reside in the same AWS Region as the encryptor\.
+ **CA platform key provider** – Provides encryption and decryption keys to AWS Elemental MediaConnect through a SPEKE\-compliant API\.

For more information, see [Setting up SPEKE encryption](encryption-speke-set-up.md)\.