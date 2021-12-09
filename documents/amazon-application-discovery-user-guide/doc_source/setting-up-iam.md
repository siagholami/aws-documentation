# Step 2: Create IAM Users<a name="setting-up-iam"></a>

When you create an AWS account, you get a single sign\-in identity that has complete access to all of the AWS services and resources in the account\. This identity is called the AWS account *root user*\. Signing in to the AWS Management Console using the email address and password that you used to create the account gives you complete access to all of the AWS resources in your account\. 

We strongly recommend that you *not* use the root user for everyday tasks, even the administrative ones\. Instead, follow the security best practice [Create Individual IAM Users](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html#create-iam-users) and create an AWS Identity and Access Management \(IAM\) administrator user\. Then securely lock away the root user credentials and use them to perform only a few account and service management tasks\.

In addition to creating an administrative user you'll also need to create non\-administrative IAM users\. The following topics explain how to create both types of IAM users\.

**Topics**
+ [Creating an IAM Administrative User](#setting-up-iam-admin)
+ [Creating an IAM Non\-Administrative User](#setting-up-iam-non-admin)

## Creating an IAM Administrative User<a name="setting-up-iam-admin"></a>

By default, an administrator account inherits all the policies required for accessing Application Discovery Service\.

**To create an administrator user**
+ Create an administrator user in your AWS account\. For instructions, see [Creating Your First IAM User and Administrators Group](https://docs.aws.amazon.com/IAM/latest/UserGuide/getting-started_create-admin-group.html) in the *IAM User Guide*\.

## Creating an IAM Non\-Administrative User<a name="setting-up-iam-non-admin"></a>

When creating non\-administrative IAM users, follow the security best practice [ Grant Least Privilege](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html#grant-least-privilege), granting users minimum permissions\. 

Use IAM managed policies to define the level of access to Application Discovery Service by non\-administrative IAM users\. For information about Application Discovery Service managed policies, see [AWS Managed \(Predefined\) Policies for Application Discovery Service](security-iam-managed-policies.md)\.

**To create a non\-administrator user**
+ Create an administrator user in your AWS account\. For instructions, see [ Creating Your First IAM Delegated User and Group](https://docs.aws.amazon.com/IAM/latest/UserGuide/getting-started_create-delegated-user.html) in the *IAM User Guide*\.