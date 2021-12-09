# Data protection for CodeGuru Profiler<a name="data-protection"></a>

 Amazon CodeGuru Profiler conforms to the AWS [shared responsibility model](https://aws.amazon.com/compliance/shared-responsibility-model/), which includes regulations and guidelines for data protection\. AWS is responsible for protecting the global infrastructure that runs all the AWS services\. AWS maintains control over data hosted on this infrastructure, including the security configuration controls for handling customer content and personal data\. AWS customers and APN partners, acting either as data controllers or data processors, are responsible for any personal data that they put in the AWS Cloud\. 

 For data protection purposes, we recommend that you protect AWS account credentials and set up individual user accounts with AWS Identity and Access Management \(IAM\), so that each user is given only the permissions necessary to fulfill their job duties\. We also recommend that you secure your data in the following ways: 
+ Use multi\-factor authentication \(MFA\) with each account\.
+ Use Transport Layer Security \(TLS\) to communicate with AWS resources\.
+ Set up API and user activity logging with AWS CloudTrail\.
+ Use AWS encryption solutions, and all default security controls in AWS services\.

We strongly recommend that you never put sensitive identifying information, such as your customers' account numbers, into free\-form fields such as a **Name** field\. This includes when you work with CodeGuru Profiler or other AWS services using the console, API, AWS CLI, or AWS SDKs\. Any data that you enter into CodeGuru Profiler or other services might get picked up for inclusion in diagnostic logs\. When you provide a URL to an external server, don't include credentials information in the URL to validate your request to that server\. 

**Topics**
+ [Captured data in CodeGuru Profiler](#data-captured)
+ [Data encryption in CodeGuru Profiler](#data-encryption)
+ [Data retention in CodeGuru Profiler](#data-retention)

## Captured data in CodeGuru Profiler<a name="data-captured"></a>

 The CodeGuru Profiler agent collects stack traces at regular intervals by using native Java virtual machine capability\. The data is submitted in batches to CodeGuru Profiler\. 

 A stack trace is a sequence of names of functions or methods in execution, followed by the names of functions or methods that called them successively, continuing to the root of the service process\. The CodeGuru Profiler profiling agent doesn't have access to the names or values of function parameters\. It also doesn't have access to the values of variables or application data\. 

## Data encryption in CodeGuru Profiler<a name="data-encryption"></a>

 Encryption is an important part of CodeGuru Profiler security\. Data in transit and at rest are provided by default and don't require you to do anything\. 
+  **Encryption of data at rest** \- Data collected by CodeGuru Profiler is stored using Amazon S3, Amazon Kinesis, and Amazon DynamoDB and their data\-at\-rest encryption capabilities\. 
+  **Encryption of data in transit** \- All communication between customers and CodeGuru Profiler and between CodeGuru Profiler and its downstream dependencies is protected using TLS connections that are signed using the Signature Version 4 signing process\. All CodeGuru Profiler endpoints use SHA\-256 certificates that are managed by AWS Certificate Manager Private Certificate Authority\. For more information, see [Signature Version 4 Signing Process](https://docs.aws.amazon.com/general/latest/gr/signature-version-4.html) and [What is ACM PCA](https://docs.aws.amazon.com/acm-pca/latest/userguide/)\. 

## Data retention in CodeGuru Profiler<a name="data-retention"></a>

 Data received from an agent is aggregated into proﬁles representing ﬁve\-minute periods\. These are then aggregated into hourly and daily proﬁles\. CodeGuru Profiler currently retains ﬁve\-minute, hourly, and daily proﬁles for 14 days, 60 days, and three years, respectively\. 