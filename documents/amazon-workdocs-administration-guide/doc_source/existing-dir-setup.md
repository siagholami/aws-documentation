# Getting started with an existing directory<a name="existing-dir-setup"></a>

In this tutorial, you’ll learn how to set up an Amazon WorkDocs site by enabling an existing AWS Directory Service directory\. 

**Topics**
+ [Before you begin](#existing-dir-prereqs)
+ [Step 1: Launch the Amazon WorkDocs site](#existing-dir-site)
+ [Step 2: Enable directory and set administrator](#existing-dir-enable)
+ [Step 3: Complete admin control panel setup](#existing-dir-admin-panel)

## Before you begin<a name="existing-dir-prereqs"></a>
+ You must have an existing AWS Directory Service directory in the current Region\. This can be either a Simple AD directory or an AD Connector directory\. 
+ If you are part of a compliance program, such as PCI, FedRAMP, or DoD, you must set up a AWS Managed Microsoft AD Directory to meet compliance requirements\. For more information, see [Getting started with AWS Managed Microsoft AD](connect_directory_microsoft.md)\.
+ When you launch a new Amazon WorkDocs site, you must specify profile information for the administrator\. This information includes first name, last name, and email address\. Do not use **Admin** for your Amazon WorkDocs account user name\. **Admin** is a reserved user role in Amazon WorkDocs\.

## Step 1: Launch the Amazon WorkDocs site<a name="existing-dir-site"></a>

Follow the steps below to launch your Amazon WorkDocs site using an existing AWS Directory Service directory\.

**To launch the Amazon WorkDocs site**

1. Open the Amazon WorkDocs console at [https://console\.aws\.amazon\.com/zocalo/](https://console.aws.amazon.com/zocalo/)\.

1. On the **Manage Your WorkDocs Sites** page, choose **Create a New WorkDocs Site**\.

## Step 2: Enable directory and set administrator<a name="existing-dir-enable"></a>

Follow the steps below to enable your existing directory and set an administrator\.

**To enable an existing directory**

1. On the **Select a Directory** page, select your AWS Directory Service directory from the **Available Directories** list and choose **Enable Directory**\.

1. On the **Set WorkDocs Administrator** page, enter a username from the AWS Directory Service directory to be your Amazon WorkDocs administrator and choose **Select Administrator**\.

   It takes several minutes for the directory to be connected and the Amazon WorkDocs site to be created\. When the directory has been successfully connected, the **Status** value of the site changes to `Active`\.

All the users in the directory are added to your account as active Amazon WorkDocs users, by default\. They can sign in and start using Amazon WorkDocs at any time\. For more information about user roles, see [User roles overview](users_ovw.md)\.

## Step 3: Complete admin control panel setup<a name="existing-dir-admin-panel"></a>

After you receive the administrator registration email, connect to the Amazon WorkDocs site using the client of your choice\. Then complete setup from your admin control panel\.

**To complete admin control panel setup**

1. In the administrator registration email, use the link to sign in to Amazon WorkDocs\.

1. Under **My account**, choose **Open admin control panel**\.

1. Change settings for preferred language, storage, security, and recovery bin\. For more information, see [Managing site settings](manage-sites.md)\.

1. \(Optional\) Under **Manage Users**, choose **Invite Users**\. You can also edit user settings\. 

For more information, see [Inviting and managing Amazon WorkDocs users](users.md)\.