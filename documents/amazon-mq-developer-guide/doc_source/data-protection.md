# Data Protection in Amazon MQ<a name="data-protection"></a>

Amazon MQ conforms to the AWS [shared responsibility model](http://aws.amazon.com/compliance/shared-responsibility-model/), which includes regulations and guidelines for data protection\. AWS is responsible for protecting the global infrastructure that runs all the AWS services\. AWS maintains control over data hosted on this infrastructure, including the security configuration controls for handling customer content and personal data\. AWS customers and APN partners, acting either as data controllers or data processors, are responsible for any personal data that they put in the AWS Cloud\. 

For data protection purposes, we recommend that you protect AWS account credentials and set up individual user accounts with AWS Identity and Access Management \(IAM\), so that each user is given only the permissions necessary to fulfill their job duties\. We also recommend that you secure your data in the following ways:
+ Use multi\-factor authentication \(MFA\) with each account\.
+ Use SSL/TLS to communicate with AWS resources\.
+ Set up API and user activity logging with AWS CloudTrail\.
+ Use AWS encryption solutions, along with all default security controls within AWS services\.
+ Use advanced managed security services such as Amazon Macie, which assists in discovering and securing personal data that is stored in Amazon S3\.

We strongly recommend that you never put sensitive identifying information, such as your customers' account numbers, into free\-form fields such as a **Name** field\. This includes when you work with Amazon MQ or other AWS services using the console, API, AWS CLI, or AWS SDKs\. Any data that you enter into Amazon MQ or other services might get picked up for inclusion in diagnostic logs\. When you provide a URL to an external server, don't include credentials information in the URL to validate your request to that server\.

For more information about data protection, see the [AWS Shared Responsibility Model and GDPR](http://aws.amazon.com/blogs/security/the-aws-shared-responsibility-model-and-gdpr/) blog post on the *AWS Security Blog*\.

## Encryption<a name="data-protection-encryption"></a>

User data stored in Amazon MQ is encrypted at rest\. Amazon MQ encryption at rest provides enhanced security by encrypting your data using encryption keys stored in the AWS Key Management Service \(KMS\)\. This service helps reduce the operational burden and complexity involved in protecting sensitive data\. With encryption at rest, you can build security\-sensitive applications that meet encryption compliance and regulatory requirements\.

All connections between Amazon MQ brokers use Transport layer Security \(TLS\) to provide encryption in transit\. 

Amazon MQ encrypts messages at rest and in transit using encryption keys that it manages and stores securely\. For additional security, we highly recommend designing your application to use client\-side encryption\. For more information, see the *[AWS Encryption SDK Developer Guide](https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/)*\.

## Encryption at Rest<a name="data-protection-encryption-at-rest"></a>

Amazon MQ integrates with AWS Key Management Service \(KMS\) to offer transparent server\-side encryption\. Amazon MQ always encrypts your data at rest\. When you create a broker, you can specify the AWS KMS customer master key \(CMK\) that you want Amazon MQ to use to encrypt your data at rest\. If you don't specify a CMK, Amazon MQ creates an AWS managed CMK for you and uses it on your behalf\. For more information about CMKs, see [Customer Master Keys \(CMKs\)](https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#master_keys) in the AWS Key Management Service Developer Guide\.

When creating a broker, you can configure what Amazon MQ uses for your encryption key by selecting one of the following\.
+ **AWS owned CMK** — The key is owned by Amazon MQ and is not in your account\.
+ **AWS managed CMK** — The AWS managed CMK \(aws/mq\) is a CMK in your account that is created, managed, and used on your behalf by Amazon MQ\.
+ **Select existing customer managed CMK** — Customer managed CMKs are created and managed by you in AWS Key Management Service \(KMS\)\.

**Important**  
Amazon MQ uses Amazon Elastic File System \(EFS\) to store message data\. If you revoke the grant that gives Amazon EFS permission to use the KMS keys in your account, Amazon MQ cannot access this data and your broker will stop working\. When you revoke a grant for Amazon EFS, it will not take place immediately\. To revoke access rights, delete your broker rather than revoking the grant\.

## Encryption in Transit<a name="data-protection-encryption-in-transit"></a>

Amazon MQ encrypts data in transit between the brokers of your Amazon MQ deployment\. All data that passes between Amazon MQ brokers is encrypted using Transport layer Security \(TLS\)\. This is true for all available protocols\. 

You can access your brokers using the following protocols with TLS enabled:
+ [AMQP](http://activemq.apache.org/amqp.html)
+ [MQTT](http://activemq.apache.org/mqtt.html)
+ MQTT over [WebSocket](http://activemq.apache.org/websockets.html)
+ [OpenWire](http://activemq.apache.org/openwire.html)
+ [STOMP](http://activemq.apache.org/stomp.html)
+ STOMP over WebSocket