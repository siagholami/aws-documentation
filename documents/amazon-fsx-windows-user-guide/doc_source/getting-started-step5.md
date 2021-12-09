# Step 6: Clean Up Resources<a name="getting-started-step5"></a>

After you have finished this exercise, you should follow these steps to clean up your resources and protect your AWS account\.

**To clean up resources**

1. On the Amazon EC2 console, terminate your instance\. For more information, see [Terminate Your Instance](https://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/terminating-instances.html) in the *Amazon EC2 User Guide for Windows Instances\.*

1. On the Amazon FSx console, delete your file system\. All automatic backups are deleted automatically\. However, you still need to delete the manually created backups\. The following steps outline this process:

   1. Open the Amazon FSx console at [https://console\.aws\.amazon\.com/fsx/](https://console.aws.amazon.com/fsx/)\.

   1. From the console dashboard, choose the name of the file system you created for this exercise\.

   1. For **Actions**, choose **Delete file system**\.

   1. In the **Delete file system** dialog box that opens, decide whether you want to create a final backup\. If you do, provide a name for the final backup\. Any automatically created backups are also deleted\.
**Important**  
New file systems can be created from backups\. We recommend that you create a final backup as a best practice\. If you find you don't need it after a certain period of time, you can delete this and other manually created backups\.

   1. Enter the ID of the file system that you want to delete in the **File system ID** box\.

   1. Choose **Delete file system**\.

   1. The file system is now being deleted, and its status in the dashboard changes to **DELETING**\. When the file system has been deleted, it no longer appears in the dashboard\.

   1. Now you can delete any manually created backups for your file system\. From the left\-side navigation, choose **Backups**\.

   1. From the dashboard, choose any backups that have the same **File system ID** as the file system that you deleted, and choose **Delete backup**\.

   1. The **Delete backups** dialog box opens\. Leave the check box checked for the ID of the backup you selected, and choose **Delete backups**\.

   Your Amazon FSx file system and related automatic backups are now deleted\.

1. If you created an AWS Directory Service directory for this exercise in [Walkthrough 1: Prerequisites for Getting Started](walkthrough01-prereqs.md), you can delete it now\. For more information, see [Delete Your Directory](https://docs.aws.amazon.com/directoryservice/latest/admin-guide/simple_ad_delete.html) in the *AWS Directory Service Administration Guide\.*