# Data protection in Porting Assistant for \.NET<a name="data-protection"></a>

Porting Assistant for \.NET conforms to the AWS [shared responsibility model](http://aws.amazon.com/compliance/shared-responsibility-model/), which includes regulations and guidelines for data protection\. AWS is responsible for protecting the global infrastructure that runs all the AWS services\. AWS maintains control over data hosted on this infrastructure, including the security configuration controls for handling customer content and personal data\. AWS customers and APN partners, acting either as data controllers or data processors, are responsible for any personal data that they put in the AWS Cloud\. 

For data protection purposes, we recommend that you protect AWS account credentials and set up individual user accounts with AWS Identity and Access Management \(IAM\), so that each user is given only the permissions necessary to fulfill their job duties\. We also recommend that you secure your data in the following ways:
+ Use multi\-factor authentication \(MFA\) with each account\.
+ Use SSL/TLS to communicate with AWS resources\.
+ Set up API and user activity logging with AWS CloudTrail\.
+ Use AWS encryption solutions, along with all default security controls within AWS services\.
+ Use advanced managed security services such as Amazon Macie, which assists in discovering and securing personal data that is stored in Amazon S3\.

We strongly recommend that you never put sensitive identifying information, such as your customers' account numbers, into free\-form fields such as a **Name** field\. This includes when you work with Porting Assistant or other AWS services using the console, API, AWS CLI, or AWS SDKs\. Any data that you enter into Porting Assistant or other services might get picked up for inclusion in diagnostic logs\. When you provide a URL to an external server, don't include credentials information in the URL to validate your request to that server\.

For more information about data protection, see the [AWS Shared Responsibility Model and GDPR](http://aws.amazon.com/blogs/security/the-aws-shared-responsibility-model-and-gdpr/) blog post on the *AWS Security Blog*\.

**Topics**
+ [Data collected by Porting Assistant for \.NET](#porting-assistant-data-collected)

## Data collected by Porting Assistant for \.NET<a name="porting-assistant-data-collected"></a>

If you accept the data collection option in the **Settings** menu of the Porting Assistant tool, the following application data is collected:

1. Application errors generated when running assessments, porting, or when performing other functions provided by the Porting Assistant tool\.

1. Names and versions of public NuGet packages assessed by the Porting Assistant tool\.

1. Metrics for assessments run by the Porting Assistant tool on public NuGet packages, such as the number of packages and solutions, and the amount of time taken to create a solution\.

You can change your data collection settings at any time in the **Settings** menu of the Porting Assistant tool\. 

**Encryption at rest**  
All data within Porting Assistant for \.NET is encrypted at rest in accordance with industry standards\.

**Encryption in transit**  
All requests to Porting Assistant for \.NET must be made over the Transport Layer Security protocol \(TLS\)\. We recommend TLS 1\.2 or later\.