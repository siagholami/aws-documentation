# Migrating files to Amazon WorkDocs<a name="migration"></a>

Amazon WorkDocs administrators can use the Amazon WorkDocs Migration Service to perform a large\-scale migration of multiple files and folders to their Amazon WorkDocs site\. The Amazon WorkDocs Migration Service works with Amazon Simple Storage Service \(Amazon S3\)\. This lets you migrate departmental file shares and home drive or user file shares to Amazon WorkDocs\.

During this process, Amazon WorkDocs provides an AWS Identity and Access Management \(IAM\) policy for you\. Use this policy to create a new IAM role that grants access to the Amazon WorkDocs Migration Service to do the following:
+ Read and list the Amazon S3 bucket that you designate\.
+ Read and write to the Amazon WorkDocs site that you designate\.

Complete the following tasks to migrate your files and folders to Amazon WorkDocs\. Before you begin, confirm that you have the following permissions:
+ Administrator permissions for your Amazon WorkDocs site
+ Permissions to create an IAM role

If your Amazon WorkDocs site is set up on the same directory as your Amazon WorkSpaces fleet, you must follow these requirements:
+ Do not use **Admin** for your Amazon WorkDocs account user name\. **Admin** is a reserved user role in Amazon WorkDocs\.
+ Your Amazon WorkDocs administrator user type must be **Upgraded WS User**\. For more information, see [User roles overview](users_ovw.md) and [Editing users](edit_user.md)\.

**Note**  
Directory structure, file names, and file content are preserved when migrating to Amazon WorkDocs\. File ownership and permissions are not preserved\.

**Topics**
+ [Step 1: Preparing for migration](prepare.md)
+ [Step 2: Uploading files to Amazon S3](s3-upload.md)
+ [Step 3: Scheduling a migration](schedule.md)
+ [Step 4: Tracking a migration](track.md)
+ [Step 5: Cleaning up resources](cleanup.md)