# Legacy IAM roles for AWS SMS<a name="sms-legacy-iam-roles"></a>

Before the introduction of **AWSServiceRoleForSMS**, you would have been required to create a service role and a launch role to grant AWS SMS the permissions that it needs\. It is no longer necessary for you to create these roles\.

## Configure a service role for AWS SMS<a name="service-role"></a>

Use the following procedure to create an IAM role that grants permissions to AWS SMS to place migrated resources into your Amazon EC2 account\.

**To create the IAM role for AWS SMS**

1. Open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. In the navigation pane, choose **Roles**, **Create role**\.

1. Under **Choose the service that will use this role**, choose **SMS**, **Next: Permissions**\. 

1. Under **Attached permissions policies**, confirm that the policy **ServerMigrationServiceRole** is visible and choose **Next: Review**\.

1. Under **Review**, for **Role name**, enter **sms**\.
**Note**  
Alternatively, you can apply a different name\. However, you must then specify the role name explicitly each time that you create a replication job or an application\.

1. Choose **Create role**\. You should now see the **sms** role in the list of available roles\.

## Configure a launch role for AWS SMS<a name="sms-launch-role"></a>

If you plan to launch applications, you need an AWS SMS launch role\. You assign this role using the `PutAppLaunchConfiguration` API\. When the `LaunchApp` API is called, the role is used by AWS CloudFormation\. 

**To create a launch role for AWS SMS**

1. Open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. In the navigation pane, choose **Roles**, **Create role**\.

1. Under **Choose the service that will use this role**, choose **CloudFormation**, **Next: Permissions**\. 

1. Under **Attached permissions policies**, confirm that the policy **ServerMigrationServiceLaunchRole** is visible and choose **Next: Review**\.

1. Under **Review**, for **Role name**, enter **sms\-launch**\. 
**Note**  
Alternatively, you can apply a different name\. However, you must then specify the role name explicitly each time that you create a launch configuration for an application\.

1. Choose **Create role**\. You should now see the **sms\-launch** role in the list of available roles\.