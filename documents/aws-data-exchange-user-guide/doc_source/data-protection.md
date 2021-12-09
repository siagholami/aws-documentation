# Data Protection in AWS Data Exchange<a name="data-protection"></a>

AWS Data Exchange conforms to the AWS shared responsibility model, which includes regulations and guidelines for data protection\. AWS is responsible for protecting the global infrastructure that runs all AWS services\. AWS maintains control over data hosted on this infrastructure, including the security configuration controls for handling customer content and personal data\. AWS customers and APN partners, acting either as data controllers or data processors, are responsible for any personal data that they put in the AWS Cloud\.

For data protection purposes, we recommend that you protect AWS account credentials and set up individual user accounts with AWS Identity and Access Management \(IAM\), so that each user is given only the permissions required to fulfill their job duties\. We also recommend that you secure your data in the following ways:
+ Use multi\-factor authentication \(MFA\) with each account\.
+ Use SSL/TLS to communicate with AWS resources\.
+ Set up API and user activity logging with CloudTrail\.
+ Use AWS encryption solutions, along with all default security controls in AWS services\.
+ Use advanced managed security services such as Amazon Macie, which assists in discovering and securing personal data that is stored in Amazon S3\.

We strongly recommend that you never put sensitive identifying information, such as your customers' account numbers, into free\-form fields such as a **Name** field\. This includes when you work with AWS Data Exchange or other AWS services using the console, API, AWS CLI, or AWS SDKs\. Any data that you enter into AWS Data Exchange or other services might get picked up for inclusion in diagnostic logs\. When you provide a URL to an external server, don't include credentials information in the URL to validate your request to that server\.

For more information about data protection, see the [AWS Shared Responsibility Model and GDPR](https://aws.amazon.com/blogs/security/the-aws-shared-responsibility-model-and-gdpr) blog post on the *AWS Security Blog*\. 

AWS Data Exchange provides the following options that you can use to help secure the content that exists in your data sets:

**Topics**
+ [Encryption at Rest](#data-protection-encryption-rest)
+ [Encryption in Transit](#data-protection-encryption-in-transit)
+ [Restrict Access to Content](#data-protection-restrict-access)

## Encryption at Rest<a name="data-protection-encryption-rest"></a>

AWS Data Exchange always encrypts all data products stored in the service at rest without requiring any additional configuration\. This encryption is automatic when you use AWS Data Exchange\.

## Encryption in Transit<a name="data-protection-encryption-in-transit"></a>

AWS Data Exchange uses Transport Layer Security \(TLS\) and client\-side encryption for encryption in transit\. Communication with AWS Data Exchange is always done over HTTPS so your data is always encrypted in transit\. This encryption is configured by default when you use AWS Data Exchange\.

## Restrict Access to Content<a name="data-protection-restrict-access"></a>

As a best practice, you should restrict access to the appropriate subset of users\. With AWS Data Exchange, you can do this by ensuring that IAM users, groups, and roles who use your AWS account have the right permissions\. For more information about roles and policies for IAM entities, see *[IAM User Guide](https://docs.aws.amazon.com/IAM/latest/UserGuide/)*\.