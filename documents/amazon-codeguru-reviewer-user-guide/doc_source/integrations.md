# Product and service integrations<a name="integrations"></a>

By default, Amazon CodeGuru Reviewer is integrated with the following products and services\. The information provided here can help you configure CodeGuru Reviewer to integrate with the products and services you use\.


**Products and services that are integrated with Amazon CodeGuru Reviewer**  

|  |  | 
| --- |--- |
| AWS CloudTrail |  [CloudTrail](https://docs.aws.amazon.com/codeguru/latest/reviewer-ug/logging-using-cloudtrail.html) captures AWS API calls and related events made by or on behalf of an AWS account and delivers log files to an Amazon S3 bucket that you specify\. You can configure CloudTrail to capture API calls from the CodeGuru Reviewer console, CodeGuru Reviewer commands from the AWS Command Line Interface \(AWS CLI\), and from the CodeGuru Reviewer API\.   | 
| Amazon CloudWatch |  You can use Amazon CloudWatch to monitor the number of recommendations created for your source code in an associated repository over time\. For more information, see [Monitoring CodeGuru Reviewer with Amazon CloudWatch](monitoring.md)\.  | 
| AWS CodeCommit |  You can configure CodeGuru Reviewer to provide analysis and recommendations for repositories in CodeCommit\.  For more information about CodeCommit, see the [CodeCommit user guide](https://docs.aws.amazon.com/codecommit/latest/userguide/welcome.html)\.   | 
| AWS CodeStar Connections |   AWS CodeStar Connections is a service that allows CodeGuru Reviewer to connect to third\-party repository source providers such as Bitbucket\. You do not need an AWS CodeStar Connections account to get analysis and recommendations for repositories\.  | 
| Bitbucket |   You can configure CodeGuru Reviewer to provide analysis and recommendations for repositories in Bitbucket\. To do this, you must have created a Bitbucket account and at least one Bitbucket repository\.   | 
| GitHub |   You can configure CodeGuru Reviewer to provide analysis and recommendations for repositories in GitHub\. To do this, you must have created a GitHub account and at least one GitHub repository\.   | 
| GitHub Enterprise Cloud |   You can configure CodeGuru Reviewer to provide analysis and recommendations for repositories in GitHub Enterprise Cloud in the same way that you would for other GitHub repositories\. To do this, you must have created a GitHub Enterprise Cloud organization in your accountand at least one repository\.   | 
| GitHub Enterprise Server |   You can configure CodeGuru Reviewer to provide analysis and recommendations for repositories in GitHub Enterprise Server\. To do this, you must have created a GitHub Enterprise Server account and at least one repository\. You should have already configured your network or virtual private cloud \(VPC\)\. You also must already have created your instance and, if you plan to connect with your VPC, launched your instance into your VPC\.  | 