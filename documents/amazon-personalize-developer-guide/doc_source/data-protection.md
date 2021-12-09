# Data Protection in Amazon Personalize<a name="data-protection"></a>

Amazon Personalize conforms to the AWS [shared responsibility model](http://aws.amazon.com/compliance/shared-responsibility-model/), which includes regulations and guidelines for data protection\. AWS is responsible for protecting the global infrastructure that runs all the AWS services\. AWS maintains control over data hosted on this infrastructure, including the security configuration controls for handling customer content and personal data\. AWS customers and APN partners, acting either as data controllers or data processors, are responsible for any personal data that they put in the AWS Cloud\. 

For data protection purposes, we recommend that you protect AWS account credentials and set up individual user accounts with AWS Identity and Access Management \(IAM\), so that each user is given only the permissions necessary to fulfill their job duties\. We also recommend that you secure your data in the following ways:
+ Use multi\-factor authentication \(MFA\) with each account\.
+ Use SSL/TLS to communicate with AWS resources\.
+ Set up API and user activity logging with AWS CloudTrail\.
+ Use AWS encryption solutions, along with all default security controls within AWS services\.
+ Use advanced managed security services such as Amazon Macie, which assists in discovering and securing personal data that is stored in Amazon Simple Storage Service \(Amazon S3\)\.

We strongly recommend that you never put sensitive identifying information, such as your customers' account numbers, into free\-form fields such as a **Name** field\. This includes when you work with Amazon Personalize or other AWS services using the console, API, AWS CLI, or AWS SDKs\. Any data that you enter into Amazon Personalize or other services might get picked up for inclusion in diagnostic logs\. When you provide a URL to an external server, don't include credentials information in the URL to validate your request to that server\.

For more information about data protection, see the [AWS Shared Responsibility Model and GDPR](http://aws.amazon.com/blogs/security/the-aws-shared-responsibility-model-and-gdpr/) blog post on the *AWS Security Blog*\.

## Encryption at Rest<a name="data-protection-at-rest"></a>

Amazon Personalize uses the default Amazon S3 key \(SSE\-S3\) for server\-side encryption of Amazon Personalize data placed in your S3 buckets\. You can also use one of your own AWS Key Management Service \(AWS KMS\) keys\.

## Encryption in Transit<a name="data-protection-in-transit"></a>

Amazon Personalize copies data out of your account and processes it in an internal AWS system\. By default, Amazon Personalize uses TLS 1\.2 with AWS certificates to encrypt data in transit\.

## Key Management<a name="data-protection-keys"></a>

The default Amazon S3 key is managed by AWS\. It is the responsibility of the customer to manage any customer\-provided [AWS Key Management Service \(AWS KMS\)](https://docs.aws.amazon.com/kms/latest/developerguide/overview.html) keys\.