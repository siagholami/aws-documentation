# Getting started with AD Connector<a name="connect_directory_connector"></a>

In this tutorial, you’ll learn how to set up an Amazon WorkDocs site using an AWS Directory Service AD Connector directory to connect to your on\-premises directory\. 

**Topics**
+ [Before you begin](#ad-connector-prereqs)
+ [Step 1: Launch the Amazon WorkDocs site](#ad-connector-site)
+ [Step 2: Connect directory](#ad-connector-dir)
+ [Step 3: Complete admin control panel setup](#ad-connector-admin-panel)

## Before you begin<a name="ad-connector-prereqs"></a>
+ You must meet the prerequisites identified in [AD Connector Prerequisites](https://docs.aws.amazon.com/directoryservice/latest/admin-guide/connect_prereq.html) in the *AWS Directory Service Administration Guide*\.
+ When you launch a new Amazon WorkDocs site, you must specify profile information for the administrator\. This information includes first name, last name, and email address\. Do not use **Admin** for your Amazon WorkDocs account user name\. **Admin** is a reserved user role in Amazon WorkDocs\.

## Step 1: Launch the Amazon WorkDocs site<a name="ad-connector-site"></a>

Follow the steps below to launch your Amazon WorkDocs site and connect to your on\-premises directory\.

**To launch the Amazon WorkDocs site**

1. Open the Amazon WorkDocs console at [https://console\.aws\.amazon\.com/zocalo/](https://console.aws.amazon.com/zocalo/)\.

   If you have never created or connected a directory in the selected Region, you see the Amazon WorkDocs start page\. After you create a directory in a particular Region, the start page is no longer available and you see the **Manage Your WorkDocs Sites** page instead\.

1. Choose **Get Started Now** from the Amazon WorkDocs start page or choose **Create a New WorkDocs Site** from the **Manage Your WorkDocs Sites** page\.

1. On the **Get Started with WorkDocs** page, next to **Standard Setup**, choose **Launch**\.

## Step 2: Connect directory<a name="ad-connector-dir"></a>

Follow the steps below to connect to your on\-premises directory using an AWS Directory Service AD Connector directory\.

**To connect your directory**

1. On the **Set up a Directory** page, under **AD Connector** choose **Create AD Connector**\.

1. For **Directory Details**, enter the following values and choose **Continue**\.  
**Directory DNS**  
The fully\-qualified name of the on\-premises directory, such as corp\.example\.com\. Amazon WorkDocs can only access user accounts in this directory\. User accounts cannot be contained in a parent directory, such as example\.com\.  
**NetBIOS Name**  
The NetBIOS name of the on\-premises directory, such as CORP\.  
**Account Username**  
The username of a user in the on\-premises directory\.   
**Account Password**  
The password for the on\-premises user account\.  
**Confirm Password**  
Re\-enter the password for the on\-premises user account\. This is required to prevent typing errors before the directory is connected\.  
**DNS Address**  
The IP address of a DNS server or domain controller in your on\-premises directory\. This server must be accessible from each subnet specified below\.

1. For **Access Point**, enter the following values:  
**Region**  
Verify the Region\.  
**Site URL**  
Enter the URL for your Amazon WorkDocs site\.

1. For **VPC Configuration**, enter the following values:  
**VPC**  
The VPC that the directory is connected to\.  
**Subnets**  
The subnets in the VPC to use to connect to your on\-premises directory\. The two subnets must be in different Availability Zones\.

1. Confirm that the directory information is correct, then choose **Connect Directory**\.

   It takes several minutes for the directory to be connected and the Amazon WorkDocs site to be created\. When the directory has been successfully connected, the **Status** value of the site changes to `Active`\.

All the users in the directory are added to your account as active Amazon WorkDocs users by default\. They can sign in and start using Amazon WorkDocs at any time\. For more information about user roles, see [User roles overview](users_ovw.md)\.

## Step 3: Complete admin control panel setup<a name="ad-connector-admin-panel"></a>

After you receive the administrator registration email, connect to the Amazon WorkDocs site using the client of your choice and complete setup from your admin control panel\.

**To complete admin control panel setup**

1. In the administrator registration email, use the link to sign in to Amazon WorkDocs\.

1. Under **My account**, choose **Open admin control panel**\.

1. Change settings for preferred language, storage, security, and recovery bin\. For more information, see [Managing site settings](manage-sites.md)\.

1. \(Optional\) Under **Manage Users**, choose **Invite Users**\. You can also edit user settings\. 

For more information, see [Inviting and managing Amazon WorkDocs users](users.md)\.