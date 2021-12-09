# Prerequisites for Amazon WorkDocs<a name="prereqs"></a>

To set up new Amazon WorkDocs sites, or manage existing sites, you must complete the following tasks\.

**Topics**
+ [Sign up for AWS](#console_signup)
+ [Create IAM users and groups \(recommended\)](#create-iam-users)

## Sign up for AWS<a name="console_signup"></a>

Your AWS account gives you access to all services, but you are charged only for the resources that you use\.

If you do not have an AWS account, complete the following steps to create one\.

**To sign up for an AWS account**

1. Open [https://portal\.aws\.amazon\.com/billing/signup](https://portal.aws.amazon.com/billing/signup)\.

1. Follow the online instructions\.

   Part of the sign\-up procedure involves receiving a phone call and entering a verification code on the phone keypad\.

Your AWS root account credentials identify you to services in AWS and grant you unlimited use of your AWS resources, such as your Amazon WorkDocs sites\. 

## Create IAM users and groups \(recommended\)<a name="create-iam-users"></a>

To allow other users to set up new Amazon WorkDocs sites, or manage existing sites, without sharing your security credentials, use AWS Identity and Access Management \(IAM\)\. We recommend that everyone work as an IAM user, even the account owner\. You should create an IAM user for yourself, give that IAM user administrative privileges, and use it for all your work\.

For more information, see [Identity and access management for Amazon WorkDocs](security-iam.md)\.