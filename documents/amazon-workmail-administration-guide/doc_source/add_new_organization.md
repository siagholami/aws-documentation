# Adding an organization<a name="add_new_organization"></a>

To use Amazon WorkMail, you must first add an organization\. One AWS account can have multiple Amazon WorkMail organizations\. You can then add users, groups, and domains to the organizations\.

The following setup options are available:
+ **Quick setup**: Creates a directory for you\.
+ **Standard setup**: Integrates Amazon WorkMail with an existing directory such as an on\-premises Microsoft Active Directory, AWS Managed Active Directory, or AWS Simple Active Directory\.

You can also create a compatible directory using Amazon WorkDocs or Amazon WorkSpaces, then complete the Amazon WorkMail setup using the **Standard setup** option\.

**Topics**
+ [Quick setup: Creating a new directory](#quick_setup)
+ [Standard setup: Integrating with an existing directory](#premises_directory)
+ [Integrating an Amazon WorkDocs or Amazon WorkSpaces directory](#compatible)
+ [Organization states and descriptions](#org-states)

## Quick setup: Creating a new directory<a name="quick_setup"></a>

You can use the **Quick setup** option to create an Amazon WorkMail organization\.

**Note**  
The **Quick setup** option does not support nested groups, and it is not compatible with Amazon WorkDocs or Amazon WorkSpaces\.

The Amazon WorkMail **Quick setup** option does the following for you:
+ Creates a new WorkMail Directory for storing your users and groups\. You cannot view this type of directory in AWS Directory Service\.
+ Creates a free test domain\.
+ Uses the KMS default AWS managed master key for encrypting your mailbox contents\.

**To add an organization using the Quick setup option**

1. Open the Amazon WorkMail console at [https://console\.aws\.amazon\.com/workmail/](https://console.aws.amazon.com/workmail/)\.

1. In the navigation bar, select the AWS Region that meets your needs\. For more information, see [Regions and Endpoints](http://docs.aws.amazon.com/general/latest/gr/index.html?rande.html) in the *Amazon Web Services General Reference*\.

1. For **Get started**, choose **Create organization**\.

1. On the **Set up your organization** screen, choose **Quick setup**\.

1. On the **Quick setup** screen, for **Organization name**, enter a unique alias to be used as your mail domain, and then choose **Create**\.

   After your organization is created, you can add domains, users, and groups\.
**Note**  
If you exceed the number of organizations that you can create using the Quick setup, you receive the error 'You have reached the maximum number of organizations you can create'\. For more information, see [Amazon WorkMail quotas](workmail_limits.md)\.

## Standard setup: Integrating with an existing directory<a name="premises_directory"></a>

You can integrate Amazon WorkMail with an existing directory such as an on\-premises Microsoft Active Directory, AWS Managed Active Directory, or AWS Simple Active Directory\. By integrating with your on\-premises directory, you can reuse your existing users and groups in Amazon WorkMail and users can log in with their existing credentials\.

You also have the option to select a customer managed master key that Amazon WorkMail uses to encrypt the mailbox content\. You can either select the default AWS managed master key for Amazon WorkMail or select a customer managed master key in AWS KMS to use with Amazon WorkMail\. 

If the existing directory is on\-premises, you must first set up an AD Connector in AWS Directory Service\. The AD Connector is used to synchronize your users and groups to the Amazon WorkMail address book and perform user authentication requests\.

For information about setting up an AD Connector, see [Connecting to your existing directory with AD Connector](https://docs.aws.amazon.com/directoryservice/latest/admin-guide/create_directory.html#connect_directory) in the *AWS Directory Service Administration Guide*\.

**To perform a Standard setup**

1. Open the Amazon WorkMail console at [https://console\.aws\.amazon\.com/workmail/](https://console.aws.amazon.com/workmail/)\.

1. In the navigation bar, select the Region that meets your needs\. For more information, see [Regions and Endpoints](http://docs.aws.amazon.com/general/latest/gr/index.html?rande.html) in the *Amazon Web Services General Reference*\.

1. For **Get started**, choose **Create organization**\.

1. On the **Set up your organization** screen, choose **Standard setup**\.

1. On the **Standard setup** screen, for **Available Directories**, select your existing directory\.
**Note**  
If you have an on\-premises Active Directory with Microsoft Exchange and an AWS AD Connector, choose **Enable interoperability** on the **Interoperability with Microsoft Exchange** screen\. Interoperability allows you to minimize disruption to your users as you migrate mailboxes to Amazon WorkMail, or use Amazon WorkMail for a subset of your corporate mailboxes\. For more information, see [Interoperability between Amazon WorkMail and Microsoft Exchange](https://docs.aws.amazon.com/workmail/latest/adminguide/interoperability.html)\.   
Amazon WorkMail does not currently support managed Microsoft Active Directory directory services that are shared with multiple accounts\.

1. For **Master keys**, select either the default AWS managed master key or a customer managed master key in AWS Key Management Service\.
**Note**  
For information about creating a new customer managed master key, see [Creating keys](https://docs.aws.amazon.com/kms/latest/developerguide/create-keys.html) in the *AWS Key Management Service Developer Guide*\.  
If you are logged on as an AWS Identity and Access Management \(IAM\) user, make yourself a key administrator on the master key\. For more information, see [Enabling and disabling keys](https://docs.aws.amazon.com/kms/latest/developerguide/enabling-keys.html) in the *AWS Key Management Service Developer Guide*\.

## Integrating an Amazon WorkDocs or Amazon WorkSpaces directory<a name="compatible"></a>

To use Amazon WorkMail with Amazon WorkDocs or Amazon WorkSpaces, create a compatible directory by using the following steps\.

**To add a compatible Amazon WorkDocs or Amazon WorkSpaces organization**

1. Create a compatible directory using Amazon WorkDocs or Amazon WorkSpaces\.

   1. For Amazon WorkDocs instructions, see [Creating a Simple AD directory using Quick setup](https://docs.aws.amazon.com/workdocs/latest/adminguide/cloud_quick_start.html)\.

   1. For Amazon WorkSpaces instructions, see [Get started with Amazon WorkSpaces quick setup](https://docs.aws.amazon.com/workspaces/latest/adminguide/getting-started.html)\.

1. In the Amazon WorkMail console, set up Amazon WorkMail\. For more information, see [Standard setup: Integrating with an existing directory](#premises_directory)\.

## Organization states and descriptions<a name="org-states"></a>

After you create an organization, it can have one of the following states\.


****  

| **State** | Description | 
| --- | --- | 
|  **Active**  |  Your organization is healthy and ready for use\.  | 
|  **Creating**  |  A workflow is running to create your organization\.  | 
|  **Failed**  |  Your organization could not be created\.  | 
|  **Impaired**  |  Your organization is malfunctioning or an issue has been detected\.  | 
|  **Inactive**  |  Your organization is inactive\.  | 
|  **Requested**  |  Your organization creation request is in the queue and waiting to be created\.  | 
|  **Validating**  |  All settings for the organization are being health\-checked\.  | 