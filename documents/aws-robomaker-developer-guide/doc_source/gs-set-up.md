# Step 1: Create an AWS Account and an Administrator<a name="gs-set-up"></a>

Before you use AWS RoboMaker for the first time, complete the following tasks: 

**Topics**
+ [Create an AWS Account](#gs-account-create)
+ [Create an IAM Administrator and Sign in](#gs-account-user)

## Create an AWS Account<a name="gs-account-create"></a>

If you already have an AWS account, skip this step\.

When you sign up for Amazon Web Services \(AWS\), your AWS account is automatically signed up for all AWS services, including AWS RoboMaker\. You are charged only for the services that you use\. 

**To create an AWS account**

1. Open [https://portal\.aws\.amazon\.com/billing/signup](https://portal.aws.amazon.com/billing/signup)\.

1. Follow the online instructions\.

   Part of the sign\-up procedure involves receiving a phone call and entering a verification code on the phone keypad\.

Write down your AWS account ID because you'll need it for the next task\.

## Create an IAM Administrator and Sign in<a name="gs-account-user"></a>

When you create an AWS account, you get a single sign\-in identity\. This allows access to all of the AWS services and resources in the account\. This identity is called the AWS account *root user*\. When you sign in to the AWS Management Console with the credentials that you used to create the account, you have access to all of the AWS resources in your account\. 

We strongly recommend that you *not* use the root user for everyday tasks, even the administrative ones\. Instead, adhere to the [Create Individual IAM Users](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html#create-iam-users)\. Create an AWS Identity and Access Management \(IAM\) user with administrator permissions\. Then, securely store your root user credentials and use them to perform only a few account and service management tasks\. 

**To create an IAM user with administrator permissions, and sign in to the console**

1. Create an account with administrator permissions in your AWS account\. For instructions, see [Creating Your First IAM User and Administrators Group](https://docs.aws.amazon.com/IAM/latest/UserGuide/getting-started_create-admin-group.html) in the *IAM User Guide*\.
**Note**  
We assume that you use administrator\-level credentials for the exercises and procedures in this guide\. If you choose to create and use another IAM user, grant that user minimum permissions\. 

1. Sign in to the AWS Management Console\. 

   To sign in to the AWS Management Console as a IAM user, you must use a special URL\. For more information, see [How Users Sign In to Your Account](https://docs.aws.amazon.com/IAM/latest/UserGuide/getting-started_how-users-sign-in.html) in the *IAM User Guide*\.

For more information about IAM, see the following:
+ [AWS Identity and Access Management \(IAM\)](https://aws.amazon.com/iam/)
+ [Getting Started](https://docs.aws.amazon.com/IAM/latest/UserGuide/getting-started.html)
+ [IAM User Guide](https://docs.aws.amazon.com/IAM/latest/UserGuide/)