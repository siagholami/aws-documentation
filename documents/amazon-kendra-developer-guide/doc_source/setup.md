--------

--------

# Setting up Amazon Kendra<a name="setup"></a>

Before using Amazon Kendra, you must have an Amazon Web Services \(AWS\) account\. After you have an AWS account, you can access Amazon Kendra through the Amazon Kendra console, the AWS Command Line Interface \(AWS CLI\), or the AWS SDKs\.

This guide includes examples for AWS CLI, Java, and Python\.

**Topics**
+ [Sign up for AWS](#aws-kendra-set-up-aws-account)
+ [Regions and endpoints](#endpoints)
+ [Setting up the AWS CLI](aws-kendra-set-up-aws-cli.md)
+ [Setting up the AWS SDKs](aws-kendra-set-up-sdks.md)

## Sign up for AWS<a name="aws-kendra-set-up-aws-account"></a>

When you sign up for Amazon Web Services \(AWS\), your account is automatically signed up for all services in AWS, including Amazon Kendra\. You are charged only for the services that you use\.

If you have an AWS account already, skip to the next task\. If you don't have an AWS account, use the following procedure to create one\.<a name="proc-set-up-aws-account"></a>

**To sign up for AWS**

1. Open [https://aws\.amazon\.com](https://aws.amazon.com), and then choose **Create an AWS Account**\.

1. Follow the on\-screen instructions to complete the account creation\. Note your 12\-digit AWS account number\. Part of the sign\-up procedure involves receiving a phone call and entering a PIN using the phone keypad\.

1. Create an AWS Identity and Access Management \(IAM\) admin user\. See [Creating Your First IAM User and Group](https://docs.aws.amazon.com/IAM/latest/UserGuide/getting-started_create-admin-group.html) in the *AWS Identity and Access Management User Guide* for instructions\.

## Regions and endpoints<a name="endpoints"></a>

An endpoint is a URL that is the entry point for a web service\. Each endpoint is associated with a specific AWS region\. If you use a combination of the Amazon Kendra console, the AWS CLI, and the Amazon Kendra SDKs, pay attention to their default regions as all Amazon Kendra components of a given campaign \(index, query, etc\.\) must be created in the same region\. For the regions and endpoints supported by Amazon Kendra, see [Regions and Endpoints](https://docs.aws.amazon.com/general/latest/gr/rande.html#kendra_region)\.