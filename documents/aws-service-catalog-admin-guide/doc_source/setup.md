# Setting Up for AWS Service Catalog<a name="setup"></a>

Before you get started with AWS Service Catalog, complete the following tasks\.

## Sign Up for Amazon Web Services<a name="setup-aws-signup"></a>

To use Amazon Web Services \(AWS\), you will need to sign up for an AWS account\.

**To sign up for an AWS account**

1. Open [https://portal\.aws\.amazon\.com/billing/signup](https://portal.aws.amazon.com/billing/signup)\.

1. Follow the online instructions\.

   Part of the sign\-up procedure involves receiving a phone call and entering a verification code on the phone keypad\.

AWS sends you a confirmation email after the sign up process is complete\. At any time, you can view your current account activity and manage your account by going to [https://aws.amazon.com/](https://aws.amazon.com/) and choosing **My Account**, **AWS Management Console**\.

## Grant Permissions to Administrators and End Users<a name="setup-users-and-groups"></a>

Catalog administrators and end users require different IAM permissions to use AWS Service Catalog\. As a catalog administrator, you must have IAM permissions that allow you to access the AWS Service Catalog administrator console, create products, and manage products\. Before your end users can use your products, you must grant them permissions that allow them to access the AWS Service Catalog end user console, launch products, and manage launched products as provisioned products\.

AWS Service Catalog provides many of these permissions using managed policies\. AWS maintains these policies and provides them in the AWS Identity and Access Management \(IAM\) service\. You can use these policies by attaching them to the IAM users, groups, or roles that you and your end users use\.
+ [Identity and Access Management in AWS Service Catalog](controlling_access.md)
+ [Grant Permissions to AWS Service Catalog Administrators](getstarted-iamadmin.md)
+ [Grant Permissions to AWS Service Catalog End Users](getstarted-iamenduser.md)