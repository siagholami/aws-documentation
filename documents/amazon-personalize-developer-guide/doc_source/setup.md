# Setting Up Amazon Personalize<a name="setup"></a>

Before using Amazon Personalize, you must have an Amazon Web Services \(AWS\) account\. After you have an AWS account, you can access Amazon Personalize through the Amazon Personalize console, the AWS Command Line Interface \(AWS CLI\), or the AWS SDKs\.

This guide includes examples for AWS CLI, Python, and JavaScript with AWS Amplify\.

**Topics**
+ [Sign Up for AWS](#aws-personalize-set-up-aws-account)
+ [Regions and Endpoints](#endpoints)
+ [Setting Up Permissions](aws-personalize-set-up-permissions.md)
+ [Setting Up the AWS CLI](aws-personalize-set-up-aws-cli.md)
+ [Setting Up the AWS SDKs](aws-personalize-set-up-sdks.md)

## Sign Up for AWS<a name="aws-personalize-set-up-aws-account"></a>

When you sign up for Amazon Web Services \(AWS\), your account is automatically signed up for all services in AWS, including Amazon Personalize\. You are charged only for the services that you use\.

If you have an AWS account already, skip to the next task\. If you don't have an AWS account, use the following procedure to create one\.<a name="proc-set-up-aws-account"></a>

**To sign up for AWS**

1. Open [https://aws\.amazon\.com](https://aws.amazon.com), and then choose **Create an AWS Account**\.

1. Follow the on\-screen instructions to complete the account creation\. Note your 12\-digit AWS account number\. Part of the sign\-up procedure involves receiving a phone call and entering a PIN using the phone keypad\.

1. Create an AWS Identity and Access Management \(IAM\) admin user\. See [Creating Your First IAM User and Group](https://docs.aws.amazon.com/IAM/latest/UserGuide/getting-started_create-admin-group.html) in the *AWS Identity and Access Management User Guide* for instructions\.

   An IAM user with administrator permissions has unrestricted access to the AWS services in your account\. For information about restricting access to Amazon Personalize operations, see [Amazon Personalize Identity\-Based Policies](security_iam_service-with-iam.md#security_iam_service-with-iam-id-based-policies)

1. Create an IAM user for use with Amazon Personalize\. The account requires certain permissions\. For more information, see [Setting Up Permissions](aws-personalize-set-up-permissions.md)\.

## Regions and Endpoints<a name="endpoints"></a>

An endpoint is a URL that is the entry point for a web service\. Each endpoint is associated with a specific AWS region\. Pay attention to the default regions of the Amazon Personalize console, the AWS CLI, and the Amazon Personalize SDKs, as all Amazon Personalize components of a given campaign \(dataset, solution, campaign, event tracker\) must be created in the same region\. For the regions and endpoints supported by Amazon Personalize, see [Regions and Endpoints](https://docs.aws.amazon.com/general/latest/gr/rande.html#personalize_region)\.