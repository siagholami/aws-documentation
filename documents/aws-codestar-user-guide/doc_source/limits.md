# Limits in AWS CodeStar<a name="limits"></a>

The following table describes limits in AWS CodeStar\. AWS CodeStar depends on other AWS services for project resources\. Some of those service limits can be changed\. For information about limits that can be changed, see [AWS Service Limits](https://docs.aws.amazon.com/general/latest/gr/aws_service_limits.html)\.


|  |  | 
| --- |--- |
| Number of projects | Maximum of 333 projects in an AWS account\. Actual limit varies, depending on the level of other service dependencies \(for example, the maximum number of pipelines in CodePipeline allowed for your AWS account\)\. | 
| Number of AWS CodeStar projects to which an IAM user can belong | Maximum of 10 per individual IAM user\. | 
| Project IDs |  Project IDs must be unique in an AWS account\. Project IDs must be at least 2 characters and cannot exceed 15 characters\. Allowed characters include: Letters `a` through `z`, inclusive\. Numbers `0` through `9`, inclusive\. The special character `-` \(minus sign\)\. Any other characters, such as capital letters, spaces, `.` \(period\), `@` \(at sign\), or `_` \(underscore\), are not allowed\.   | 
| Project names | Project names cannot exceed 100 characters in length, and cannot begin or end with an empty space\.   | 
| Project descriptions | Any combination of characters between 0 and 1,024 characters in length\. Project descriptions are optional\. | 
| Team members in an AWS CodeStar project | 100 | 
| Display name in a user profile | Any combination of characters between 1 and 100 characters in length\. Display names must include at least one character\. That character cannot be a space\. Display names cannot begin or end with a space\. | 
| Email address in a user profile | The email address must include an @ and end in a valid domain extension\. | 
| Federated access, root account access, or temporary access to AWS CodeStar | AWS CodeStar supports federated users and use of temporary access credentials\. Using AWS CodeStar with a root account is not recommended\. | 
| IAM roles | A maximum of 5,120 characters in any managed policy that is attached to an IAM role\. | 