# Data protection in AWS CodeCommit<a name="data-protection"></a>

AWS CodeCommit conforms to the AWS [shared responsibility model](http://aws.amazon.com/compliance/shared-responsibility-model/), which includes regulations and guidelines for data protection\. AWS is responsible for protecting the global infrastructure that runs all the AWS services\. AWS maintains control over data hosted on this infrastructure, including the security configuration controls for handling customer content and personal data\. AWS customers and APN partners, acting either as data controllers or data processors, are responsible for any personal data that they put in the AWS Cloud\. 

For data protection purposes, we recommend that you protect AWS account credentials and set up individual user accounts with AWS Identity and Access Management \(IAM\), so that each user is given only the permissions required to fulfill their job duties\. We also recommend that you secure your data in the following ways:
+ Use multi\-factor authentication \(MFA\) with each account\.
+ Use SSL/TLS to communicate with AWS resources\.
+ Set up API and user activity logging with AWS CloudTrail\.
+ Use AWS encryption solutions, along with all default security controls in AWS services\.
+ Use advanced managed security services such as Amazon Macie, which assists in discovering and securing personal data that is stored in Amazon S3\.

We strongly recommend that you never put sensitive identifying information, such as your customers' account numbers, into free\-form fields such as a **Name** field\. This includes when you work with CodeCommit or other AWS services using the console, API, AWS CLI, or AWS SDKs\. Any data that you enter into CodeCommit or other services might get picked up for inclusion in diagnostic logs\. When you provide a URL to an external server, don't include credentials information in the URL to validate your request to that server\.

For more information about data protection, see the [AWS Shared Responsibility Model and GDPR](http://aws.amazon.com/blogs/security/the-aws-shared-responsibility-model-and-gdpr/) blog post on the *AWS Security Blog*\.

CodeCommit repositories are automatically encrypted at rest\. No customer action is required\. CodeCommit also encrypts repository data in transit\. You can use either the HTTPS protocol, the SSH protocol, or both with CodeCommit repositories\. For more information, see [Setting up for AWS CodeCommit ](setting-up.md)\. You can also configure [cross\-account access](cross-account.md) to CodeCommit repositories\.

**Topics**
+ [AWS Key Management Service and encryption for AWS CodeCommit repositories](encryption.md)
+ [Connecting to AWS CodeCommit repositories with rotating credentials](temporary-access.md)