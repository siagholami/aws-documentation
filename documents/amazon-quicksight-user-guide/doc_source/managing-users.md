# Managing User Accounts in Amazon QuickSight Standard Edition<a name="managing-users"></a>

Use this topic to learn more about managing user accounts in Amazon QuickSight Standard edition\. For information on users in Enterprise edition, see [Managing User Accounts in Amazon QuickSight Enterprise Edition](managing-users-enterprise.md)\.

If you have administrative privileges in Amazon QuickSight, you can create and delete user accounts\. You can create user accounts based on AWS Identity and Access Management \(IAM\) credentials, or you can create Amazon QuickSight–only user accounts using the email address of the user\. 

You can't create Amazon QuickSight user accounts using AWS credentials that aren't IAM credentials\. Federated logins work through IAM roles\. User names that contain a semicolon \(;\) aren't supported\.

Each Amazon QuickSight Standard edition account can have up to 100 user accounts, including the AWS root account or IAM account that created the Amazon QuickSight account\. If you need an exception to this limit, follow the instructions in [AWS Service Limits](https://docs.aws.amazon.com/general/latest/gr/aws_service_limits.html) in the *AWS General Reference* to submit a limit increase request\.