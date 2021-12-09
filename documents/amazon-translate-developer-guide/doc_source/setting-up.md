# Step 1: Set Up an AWS Account and Create an Administrator User<a name="setting-up"></a>

Before you use Amazon Translate for the first time, complete the following tasks:

1. [Sign Up for AWS](#setting-up-signup)

1. [Create an IAM User](#setting-up-iam)

## Sign Up for AWS<a name="setting-up-signup"></a>

When you sign up for Amazon Web Services \(AWS\), your AWS account is automatically signed up for all AWS services, including Amazon Translate\. You are charged only for the services that you use\.

With Amazon Translate, you pay only for the resources that you use\. If you are a new AWS customer, you can get started with Amazon Translate for free\. For more information, see [AWS Free Usage Tier](https://aws.amazon.com/free/)\.

If you already have an AWS account, skip to the next section\. 

**To create an AWS account**

1. Open [https://portal\.aws\.amazon\.com/billing/signup](https://portal.aws.amazon.com/billing/signup)\.

1. Follow the online instructions\.

   Part of the sign\-up procedure involves receiving a phone call and entering a verification code on the phone keypad\.

Record your AWS account ID because you'll need it for the next task\.

## Create an IAM User<a name="setting-up-iam"></a>

AWS services, such as Amazon Translate, require that you provide credentials when you access them\. This allows the service to determine whether you have permissions to access the service's resources\. 

We strongly recommend that you access AWS using AWS Identity and Access Management \(IAM\), not the credentials for your AWS account\. To use IAM to access AWS, create an IAM user, add the user to an IAM group with administrative permissions, and then grant administrative permissions to the IAM user\. You can then access AWS using a special URL and the IAM user's credentials\.

Exercises in this guide assume that you have an IAM user with administrator privileges called `adminuser`\. 

**To create an administrator user**
+ In your AWS account, create an administrator user called `adminuser`\. For instructions, see [Creating Your First IAM User and Administrators Group](https://docs.aws.amazon.com/IAM/latest/UserGuide/getting-started_create-admin-group.html) in the *IAM User Guide*\.

For more information about IAM, see the following:
+ [AWS Identity and Access Management \(IAM\)](https://aws.amazon.com/iam/)
+ [Getting Started](https://docs.aws.amazon.com/IAM/latest/UserGuide/getting-started.html)
+ [IAM User Guide](https://docs.aws.amazon.com/IAM/latest/UserGuide/)

## Next Step<a name="setting-up-next-step-2"></a>

[Step 2: Set Up the AWS Command Line Interface \(AWS CLI\)](setup-awscli.md)