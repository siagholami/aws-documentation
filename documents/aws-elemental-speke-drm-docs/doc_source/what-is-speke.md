# What Is Secure Packager and Encoder Key Exchange?<a name="what-is-speke"></a>

Secure Packager and Encoder Key Exchange \(SPEKE\) defines the standard for communication between encryptors and packagers of media content and digital rights management \(DRM\) key providers\. The specification accommodates encryptors running on\-premises and in the AWS Cloud\. 

**Topics**
+ [General Architecture](#general-architecture)
+ [AWS Cloud\-Based Architecture](#services-architecture)
+ [How to Get Started](#how-to-start)

## General Architecture<a name="general-architecture"></a>

The following illustration shows a high\-level view of the SPEKE content encryption architecture for on\-premises products\.

![\[The encryptor receives encryption requests from the person operating it. The encryptor sends a request to the DRM platform key provider for keys that it can use to secure the encrypted content. The key provider returns keys. The encryptor sends the encrypted content to a player. The player requests keys from the same key provider, which the player uses to unlock the content and serve it to its viewers.\]](http://docs.aws.amazon.com/speke/latest/documentation/images/speke-high-level.png)

These are the main components of the preceding architecture:
+ **Encryptor** – Provides the encryption technology\. Receives encryption requests from its operator, and retrieves the required keys from the DRM key provider to secure the encrypted content\. 
+ **DRM platform key provider** – Provides encryption keys to the encryptor through a SPEKE\-compliant API\. The provider also provides licenses to media players for decryption\. 
+ **Player** – Requests keys from the same DRM platform key provider, which the player uses to unlock the content and serve it to its viewers\.

## AWS Cloud\-Based Architecture<a name="services-architecture"></a>

The following illustration shows the high\-level architecture when SPEKE is used with services and features running in the AWS Cloud\.

![\[The encryptor, Amazon API Gateway, AWS IAM, and AWS Certificate Manager all reside in the same AWS Region. The AWS operators configure API Gateway and IAM to provide a proxy between the media service and the DRM platform key provider. AWS operators optionally configure certificates in the AWS Certificate Manager for use by the encryptor for content key encryption. The encryptor receives encryption requests from its operators. The encryptor sends a request through API Gateway to the key provider for keys that the encryptor can use to secure the encrypted content. If it is configured with certificates, the encryptor communicates with the certificate manager to manage content key encryption. The encryptor sends the encrypted content to an Amazon S3 bucket or to Amazon CloudFront. When a viewer asks to see the content on a player, the player requests the encrypted content from Amazon S3 or Amazon CloudFront and requests keys from the same DRM platform. The player uses the keys to unlock the content and serve it to its viewers.\]](http://docs.aws.amazon.com/speke/latest/documentation/images/speke-services-high-level.png)

These are the main services and components:
+ **Encryptor** – Provides the encryption technology in the AWS Cloud\. The encryptor receives requests from its operator and retrieves the required encryption keys from the DRM key provider, through Amazon API Gateway, to secure the encrypted content\. It delivers the encrypted content to an Amazon S3 bucket or through an Amazon CloudFront distribution\. 
+ **AWS IAM and Amazon API Gateway** – Manages customer\-trusted roles and proxy communication between the encryptor and the key provider\. API Gateway provides logging capabilities and lets customers control their relationships with the encryptor and with the DRM platform\. Customers enable key provider access through IAM role configuration\. The API Gateway must reside in the same AWS Region as the encryptor\.
+ **AWS Certificate Manager** – \(Optional\) Provides certificate management for content key encryption\. Encrypting content keys is the recommended practice for secure communication\. The certificate manager must reside in the same AWS Region as the encryptor\.
+ **DRM platform key provider** – Provides encryption keys to the encryptor through a SPEKE\-compliant API\. The provider also provides licenses to media players for decryption\. 
+ **Player** – Requests keys from the same DRM platform key provider, which the player uses to unlock the content and serve it to its viewers\.

The API Gateway API, the encryptor, and ACM must all reside in the same AWS Region\. 

## How to Get Started<a name="how-to-start"></a>

**Are you a customer?**  
Partner with an AWS Elemental DRM platform provider to get set up to use encryption\. For details, see [Customer Onboarding](customer-onboarding.md)\.

**Are you a DRM platform provider or a customer with your own key provider?**  
Expose a REST API for your key provider in compliance with the SPEKE specification\. For details, see [SPEKE API Specification](speke-api-specification.md)\.