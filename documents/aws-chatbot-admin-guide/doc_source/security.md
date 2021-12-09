# Security in AWS Chatbot<a name="security"></a>

 At AWS, cloud security is our highest priority\. As an AWS customer, you benefit from a data center and network architecture that we build to meet the requirements of the most security\-sensitive organizations\.

Security is a shared responsibility between AWS and you\. The [shared responsibility model](http://aws.amazon.com/compliance/shared-responsibility-model/) describes this as security *of* the cloud and security *in* the cloud:
+ **Security of the cloud** – AWS is responsible for protecting the infrastructure that runs AWS services in the AWS Cloud\. AWS also provides you with services that you can use securely\. Third\-party auditors regularly test and verify our security effectiveness as part of the [AWS compliance programs](http://aws.amazon.com/compliance/programs/)\. To learn about the compliance programs that apply to AWS Chatbot, see [AWS Services in Scope by Compliance Program](http://aws.amazon.com/compliance/services-in-scope/)\.
+ **Security in the cloud** – Your responsibility is determined by the AWS service that you use\. You are also responsible for other factors including the sensitivity of your data, your company’s requirements, and applicable laws and regulations\. 

This documentation helps you understand how to apply the shared responsibility model when using AWS Chatbot\. The following topics show you how to configure AWS Chatbot to meet your security and compliance objectives\. You also learn how to use other AWS services that help you to monitor and secure your AWS Chatbot resources\. 

**Topics**
+ [Data protection in AWS Chatbot](#per-service-security)
+ [Identity and Access Management for AWS Chatbot](security-iam.md)
+ [Compliance validation for AWS Chatbot](chatbot-compliance.md)
+ [Resilience in AWS Chatbot](disaster-recovery-resiliency.md)
+ [Infrastructure security in AWS Chatbot](infrastructure-security.md)

## Data protection in AWS Chatbot<a name="per-service-security"></a>

AWS Chatbot conforms to the AWS shared responsibility model, which includes regulations and guidelines for data protection\. AWS is responsible for protecting the global infrastructure that runs all of the AWS services\. AWS maintains control over data hosted on this infrastructure, including the security configuration controls for handling customer content and personal data\.

AWS customers and APN partners, acting either as data controllers or data processors, are responsible for any personal data that they put in the AWS Cloud\. 

For data protection purposes, we recommend that you protect AWS account credentials and set up individual user accounts with AWS Identity and Access Management \(IAM\), so that each user is given only the permissions necessary to fulfill their job duties\. 

We also recommend that you secure your data in the following ways: 
+ Use multi\-factor authentication \(MFA\) with each account\.
+ Use SSL/TLS to communicate with AWS resources\.
+ Set up API and user activity logging with AWS CloudTrail\. 
+ Use AWS encryption solutions, along with all default security controls within AWS services\. 
+ Use advanced managed security services such as Amazon Macie, which assists in discovering and securing personal data that is stored in Amazon Simple Storage Service \(Amazon S3\)\.
+ Never put sensitive identifying information, such as your customers' account numbers, into free\-form fields such as a **Name** field\. This includes when you work with AWS Chatbot or other AWS services using the console, API, AWS Command Line Interface \(AWS CLI\), or AWS SDKs\. Any data that you enter into AWS Chatbot or other services might get picked up for inclusion in diagnostic logs\.
+ When you provide a URL to an external server, don't include credentials information for validating your request to that server in the URL\. 

For more information about data protection, see the [AWS Shared Responsibility Model and GDPR blog post](https://aws.amazon.com/blogs/security/the-aws-shared-responsibility-model-and-gdpr) on the AWS Security Blog\. 

**Note**  
AWS Chatbot doesn't modify any event, alarm, or other reporting data when it forwards Amazon Simple Notification Service \(Amazon SNS\) notifications to chat rooms\. It treats all notifications as read only\. 