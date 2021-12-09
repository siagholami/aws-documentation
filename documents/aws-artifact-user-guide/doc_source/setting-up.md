# Setting Up AWS Artifact<a name="setting-up"></a>

When you sign up for AWS, your AWS account is automatically signed up for all services in AWS, including AWS Artifact\. If you haven't signed up for AWS, see [Sign Up for AWS](#setting-up-aws-sign-up)\. 

To create and manage user permissions to provide highly secure, limited access to your AWS resources, both for yourself and for others who need to work with your AWS resources, see [Create an IAM Admin Group and User](#setting-up-create-iam-user)\. 

**Topics**
+ [Sign Up for AWS](#setting-up-aws-sign-up)
+ [Create an IAM Admin Group and User](#setting-up-create-iam-user)

## Sign Up for AWS<a name="setting-up-aws-sign-up"></a>

If you do not have an AWS account, complete the following steps to create one\.

**To sign up for an AWS account**

1. Open [https://portal\.aws\.amazon\.com/billing/signup](https://portal.aws.amazon.com/billing/signup)\.

1. Follow the online instructions\.

   Part of the sign\-up procedure involves receiving a phone call and entering a verification code on the phone keypad\.

 Part of the sign\-up procedure involves receiving a phone call and entering a PIN using the phone keypad\. Note your AWS account number because you will need it later\.

## Create an IAM Admin Group and User<a name="setting-up-create-iam-user"></a>

When you sign up for AWS, you provide an email address and password that are associated with your AWS account\. These are your *root credentials*, and they provide complete access to all of your AWS resources\. However, we strongly recommend that you don't use the root account for everyday access\. We also recommend that you don't share account credentials with others to give them complete access to your account\. 

Instead of signing in to the account with your root credentials or sharing your credentials with others, you should create a special user identity called an *IAM user* for yourself and for anyone who might need access to a document or agreement in AWS Artifact\. With this approach, you can provide individual sign\-in information for each user, and you can grant each user only the permissions that they need to work with specific documents\. You can also grant multiple IAM users the same permissions by granting the permissions to an IAM group and adding the IAM users to the group\. For more information, see [Getting Started with AWS Artifact](getting-started.md)\.

If you already manage user identities outside AWS, you can use IAM *identity providers* instead of creating IAM users in your AWS account\. For more information, see [Identity Providers and Federation](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_providers.html) in the *IAM User Guide*\.