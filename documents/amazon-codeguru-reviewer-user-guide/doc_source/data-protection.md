# Data protection for CodeGuru Reviewer<a name="data-protection"></a>

 Amazon CodeGuru Reviewer conforms to the AWS [shared responsibility model](https://aws.amazon.com/compliance/shared-responsibility-model/), which includes regulations and guidelines for data protection\. AWS is responsible for protecting the global infrastructure that runs all the AWS services\. AWS maintains control over data hosted on this infrastructure, including the security configuration controls for handling customer content and personal data\. AWS customers and APN partners, acting either as data controllers or data processors, are responsible for any personal data that they put in the AWS Cloud\. 

 For data protection purposes, we recommend that you protect AWS account credentials and set up individual user accounts with AWS Identity and Access Management \(IAM\), so that each user is given only the permissions necessary to fulfill their job duties\. We also recommend that you secure your data in the following ways: 
+ Use multi\-factor authentication \(MFA\) with each account\.
+ Use Transport Layer Security \(TLS\) to communicate with AWS resources\.
+ Set up API and user activity logging with AWS CloudTrail\.
+ Use AWS encryption solutions, and all default security controls in AWS services\.
+ Use advanced managed security services such as Amazon Macie, which assists in discovering and securing personal data that is stored in Amazon S3\.

We strongly recommend that you never put sensitive identifying information, such as your customers' account numbers, into free\-form fields such as a **Name** field\. This includes when you work with CodeGuru Reviewer or other AWS services using the console, API, AWS CLI, or AWS SDKs\. Any data that you enter into CodeGuru Reviewer or other services might get picked up for inclusion in diagnostic logs\. When you provide a URL to an external server, don't include credentials information in the URL to validate your request to that server\. 

**Topics**
+ [Captured data in CodeGuru Reviewer](#data-captured)
+ [Data retention in CodeGuru Reviewer](#data-retention)
+ [Data encryption in CodeGuru Reviewer](#data-encryption)

## Captured data in CodeGuru Reviewer<a name="data-captured"></a>

 CodeGuru Reviewer stores the following to create code reviews: 
+  Repository metadata, such as the name and owner of a repository 
+  Recommendations generated by CodeGuru Reviewer
+  Pull request metadata, such as the author and branch of a pull request 
+  Feedback submitted by customers about code reviews 

 CodeGuru Reviewer does not store your source code\. 

## Data retention in CodeGuru Reviewer<a name="data-retention"></a>

 Stored repository metadata, recommendations, and pull request metadata is retained for 90 days, then it's deleted\. Feedback provided to help CodeGuru Reviewer improve future recommendations isn't deleted\. 

## Data encryption in CodeGuru Reviewer<a name="data-encryption"></a>

 Encryption is an important part of CodeGuru Reviewer security\. Data in transit and at rest are encrypted by default and don't require you to do anything\. 
+  **Encryption of data at rest** ??? Data collected by CodeGuru Reviewer is stored using Amazon S3 and Amazon DynamoDB\. The data is encrypted using their data\-at\-rest encryption capabilities\. 
+  **Encryption of data in transit** ??? All communication between customers and CodeGuru Reviewer and between CodeGuru Reviewer and its downstream dependencies is protected using TLS connections that are signed using the Signature Version 4 signing process\. All CodeGuru Reviewer endpoints use SHA\-256 certificates that are managed by AWS Certificate Manager Private Certificate Authority\. For more information, see [Signature Version 4 Signing Process](https://docs.aws.amazon.com/general/latest/gr/signature-version-4.html) and [What is ACM PCA](https://docs.aws.amazon.com/acm-pca/latest/userguide/)\. 