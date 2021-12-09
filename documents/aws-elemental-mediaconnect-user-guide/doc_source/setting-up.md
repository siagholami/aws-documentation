# Setting up AWS Elemental MediaConnect<a name="setting-up"></a>

Before you start using AWS Elemental MediaConnect, you must sign up for AWS \(if you don’t already have an AWS account\) and create IAM users and roles to allow access to MediaConnect\. This includes creating an IAM role for yourself\. If you want to use encryption to protect your content, you also must store your encryption keys in AWS Secrets Manager, and then give MediaConnect permission to obtain the keys from your Secrets Manager account\.

This section guides you through the steps required to configure users to access AWS Elemental MediaConnect\. For background and additional information about identity and access management for MediaConnect, see [Identity and access management for AWS Elemental MediaConnect](security-iam.md)\.

**Topics**
+ [Step 1\. Sign Up for AWS](setting-up-aws-sign-up.md)
+ [Step 2\. Create an admin IAM user](setting-up-IAM-admin-user.md)
+ [Step 3\. Create non\-admin IAM users](setting-up-create-nonadmin-IAM-users.md)
+ [Step 4\. \(Optional\) Set up encryption](setting-up-encryption.md)
+ [Step 5\. \(Optional\) Install the AWS CLI](setting-up-install-cli.md)