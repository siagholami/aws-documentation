# Getting started with Quick Start<a name="cloud_quick_start"></a>

In this tutorial, you'll learn how to set up a new Amazon WorkDocs site and create a Simple AD directory with **Quick Start**\. The **Quick Start** option is available only if you have never launched an Amazon WorkDocs site before\.

**Note**  
If you need more control over the directory configuration, such as specifying your own directory domain name or using an existing virtual private cloud \(VPC\) with the directory, use the **Standard Setup** option\. For more information, see [Getting started with Simple AD: Standard Setup](cloud_standard_setup.md)\.

**Topics**
+ [Before you begin](#quick-setup-prereqs)
+ [Step 1: Launch the Amazon WorkDocs site](#quick-setup-launch-site)
+ [Step 2: Create access point and set administrator](#quick-setup-access)
+ [Step 3: Complete admin control panel setup](#quick-setup-admin-panel)

## Before you begin<a name="quick-setup-prereqs"></a>
+ You must have an AWS account to create or administer an Amazon WorkDocs site\. Users do not need an AWS account to connect to and use Amazon WorkDocs\. For more information, see [Prerequisites for Amazon WorkDocs](prereqs.md)\.
+ When you launch a new Amazon WorkDocs site, you must specify profile information for the administrator, including first and last name and an email address\. 
+ If you are part of a compliance program, such as PCI, FedRAMP, or DoD, you must set up a Microsoft AD Directory to meet compliance requirements\. Follow the instructions on [Getting started with AWS Managed Microsoft AD](connect_directory_microsoft.md) instead\.

## Step 1: Launch the Amazon WorkDocs site<a name="quick-setup-launch-site"></a>

Using Quick Start, you can launch your first Amazon WorkDocs site in minutes\.

**To launch the Amazon WorkDocs site**

1. Open the Amazon WorkDocs console at [https://console\.aws\.amazon\.com/zocalo/](https://console.aws.amazon.com/zocalo/)\.

   If you have never created or connected a directory in the selected Region, you see the Amazon WorkDocs start page\. After you create a directory in a particular Region, the start page is no longer available and you see the **Manage Your WorkDocs Sites** page instead\.

1. Choose **Get Started Now** from the Amazon WorkDocs start page or choose **Create a New WorkDocs Site** from the **Manage Your WorkDocs Sites** page\.

1. On the **Get Started with WorkDocs** page, next to **Quick Start**, choose **Launch**\.

## Step 2: Create access point and set administrator<a name="quick-setup-access"></a>

Follow the steps below to create an access point and set an administrator\.

**To create access point and set administrator**

1. From the **WorkDocs Quick Start** page, enter the following values for **Access Point**:  
**Region**  
Verify the Region\.  
**Site URL**  
Enter the URL for your Amazon WorkDocs site\.

1. Enter the following values for **Set WorkDocs Administrator**:  
**Email**  
The email address of the directory administrator, also used as the username\. The registration email is sent here\.  
**First Name**  
The first name of the directory administrator\.  
**Last Name**  
The last name of the directory administrator\.

1. Choose **Complete Setup**\.

   It takes several minutes for the directory to be connected and the Amazon WorkDocs site to be created\. When the directory has been successfully connected, the **Status** value of the site changes to `Active`\.

Quick Start completes the following tasks on your behalf:
+ Creates a virtual private cloud \(VPC\)\.
+ Sets up a Simple AD directory in the VPC that is used to store user and Amazon WorkDocs site information\.
+ Creates a directory administrator account\. An email is sent to the administrator with instructions to complete registration\. Use this account to manage the directory\.
+ Creates the specified user accounts, adds them to the directory, and sends invitation emails\.

## Step 3: Complete admin control panel setup<a name="quick-setup-admin-panel"></a>

After you receive the administrator registration email, connect to the Amazon WorkDocs site using the client of your choice and complete setup from your admin control panel\.

**To complete admin control panel setup**

1. In the administrator registration email, use the link to sign in to Amazon WorkDocs\.

1. Under **My account**, choose **Open admin control panel**\.

1. Change settings for preferred language, storage, security, and recovery bin\. For more information, see [Managing site settings](manage-sites.md)\.

1. Under **Manage Users**, choose **Invite Users**\. You can also edit user settings\. 

For more information, see [Inviting and managing Amazon WorkDocs users](users.md)\.