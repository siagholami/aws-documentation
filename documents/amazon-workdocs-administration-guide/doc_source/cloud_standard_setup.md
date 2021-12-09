# Getting started with Simple AD: Standard Setup<a name="cloud_standard_setup"></a>

In this tutorial, you’ll learn how to set up an Amazon WorkDocs site using **Standard Setup** to create a Simple AD directory in the cloud\.

**Topics**
+ [Before you begin](#standard-setup-prereqs)
+ [Step 1: Launch the Amazon WorkDocs site](#standard-setup-site)
+ [Step 2: Create directory and set administrator](#standard-setup-directory)
+ [Step 3: Complete admin control panel setup](#standard-setup-admin-panel)

## Before you begin<a name="standard-setup-prereqs"></a>
+ You must meet the prerequisites identified in [Simple AD Prerequisites](https://docs.aws.amazon.com/directoryservice/latest/admin-guide/cloud_prereq.html) in the *AWS Directory Service Administration Guide*\.
+ If you are part of a compliance program, such as PCI, FedRAMP, or DoD, you must set up a AWS Managed Microsoft AD Directory to meet compliance requirements\. For more information, see [Getting started with AWS Managed Microsoft AD](connect_directory_microsoft.md)\.
+ When you launch a new Amazon WorkDocs site, you must specify profile information for the administrator, including first and last name and an email address\. 

## Step 1: Launch the Amazon WorkDocs site<a name="standard-setup-site"></a>

Follow the steps below to launch your Amazon WorkDocs site using **Standard Setup**\.

**To launch the Amazon WorkDocs site**

1. Open the Amazon WorkDocs console at [https://console\.aws\.amazon\.com/zocalo/](https://console.aws.amazon.com/zocalo/)\.

   If you have never created or connected a directory in the selected Region, you see the Amazon WorkDocs start page\. After you create a directory in a particular Region, the start page is no longer available and you see the **Manage Your WorkDocs Sites** page instead\.

1. Choose **Get Started Now** from the Amazon WorkDocs start page or choose **Create a New WorkDocs Site** from the **Manage Your WorkDocs Sites** page\.

1. On the **Get Started with WorkDocs** page, next to **Standard Setup**, choose **Launch**\.

## Step 2: Create directory and set administrator<a name="standard-setup-directory"></a>

Follow the steps below to create a Simple AD directory and set an administrator\.

**To create a Simple AD directory**

1. On the **Set up a Directory** page, choose **Create Simple AD**\.

1. For **Access Point**, enter the following values and then choose **Continue**\.  
**Region**  
Verify the Region\.  
**Site URL**  
Enter the URL for your Amazon WorkDocs site\.

1. Enter the following values for **Directory Details**:  
**Directory DNS**  
The fully\-qualified name of the directory, such as `corp.example.com`\.  
**NetBIOS name**  
The NetBIOS name of the directory, such as `CORP`\.

1. Enter the following values for **Set WorkDocs Administrator**:  
**Email**  
The email address of the directory administrator, also used as the username\. The registration email is sent here\.  
**First Name**  
The first name of the directory administrator\.  
**Last Name**  
The last name of the directory administrator\.

1. For **VPC Details**, select **Set up a new VPC on my behalf** to have Amazon WorkDocs create and configure a VPC for you\. To use an existing VPC instead, select **Select an existing VPC to use with WorkDocs** and enter the following values\.  
**VPC**  
The VPC that the directory is created in\.  
**Subnets**  
The subnets in the VPC that the directory is created in\. The two subnets must be in different Availability Zones\. If you choose **No Preference**, two different subnets are randomly selected\.

1. Review the directory information and make any necessary changes\. When the information is correct, choose **Create Directory**\.

   It takes several minutes for the directory to be connected and the Amazon WorkDocs site to be created\. When the directory has been successfully connected, the **Status** value of the site changes to `Active`\.

## Step 3: Complete admin control panel setup<a name="standard-setup-admin-panel"></a>

After you receive the administrator registration email, connect to the Amazon WorkDocs site using the client of your choice and complete setup from your admin control panel\.

**To complete admin control panel setup**

1. In the administrator registration email, use the link to sign in to Amazon WorkDocs\.

1. Under **My account**, choose **Open admin control panel**\.

1. Change settings for preferred language, storage, security, and recovery bin\. For more information, see [Managing site settings](manage-sites.md)\.

1. Under **Manage Users**, choose **Invite Users**\. You can also edit user settings\. 

For more information, see [Inviting and managing Amazon WorkDocs users](users.md)\.