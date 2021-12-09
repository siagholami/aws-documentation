# Prerequisites<a name="porting-assistant-prerequisites"></a>

The following prerequisites must be verified in order to successfully port your existing \.NET applications to \.NET Core using the Porting Assistant for \.NET tool\.

## Prerequisites<a name="porting-assistant-prereq-versions-depencies"></a>

The Porting Assistant tool requires the following prerequisites for installation and usage\.
+ **\.NET Core SDK 3\.1**: [Download \.NET Core](https://dotnet.microsoft.com/download/dotnet-core)\.
+ **AWS CLI**: You must have a valid AWS CLI profile in order for Porting Assistant to collect compatibility information on the public NuGet packages and the APIs within the packages that are in use by your application\. For instructions on how to configure an AWS CLI profile, see [Configuring the AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-configure.html)\. 
+ Windows 7 or later
+ Administrator access
+ Processor with 1\.8 GHz or above processing speed
+ 2 GB minimum of available memory
+ 5 GB minimum of free disk space

## AWS Identity and Access Management \(IAM\)<a name="porting-assistant-iam"></a>

You must attach the following IAM policy as an inline policy to your IAM user\. Then, configure a profile on your server with the IAM credentials of this user\.

```
{
 "Version": "2012-10-17",
 "Statement": [
 {
 "Sid": "EnCorePermission",
 "Effect": "Allow",
 "Action": "execute-api:invoke",
 "Resource": "arn:aws:execute-api:us-east-1:492443789615:3dmmp07yx6/*"
 }
 ]
}
```

**Attach policy**  
The following steps guide you through the process of attaching the IAM policy to an IAM user to grant the preceding permissions\.

1. Sign in to the AWS Management Console and open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam)\.

1. In the left navigation pane, choose **Policies**\.

1. Choose **Create policy**\.

1. Choose the **JSON** tab and copy and paste the preceding policy into the text field\.

1. Choose **Review Policy** and enter a **Name** and **Description** for the policy\.

1. Choose **Create Policy**\.

1. Filter the list of policies with the name of the policy that you just created\.

1. Select the bullet next to your new policy, and from the **Policy actions** dropdown, select **Attach**\.

1. Select the User name of the IAM user to which to attach the policy\.

1. Choose **Attach policy**\.

1. When you select an AWS profile from the dropdown in the **Set up Porting Assistant for \.NET** page of the tool, select the same IAM profile to which you attached this permission policy\.