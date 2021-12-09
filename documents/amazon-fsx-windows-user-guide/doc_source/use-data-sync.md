# Step 5: Transfer Files to or from Amazon FSx for Windows File Server Using AWS DataSync<a name="use-data-sync"></a>

Now that you have a functioning setup for Amazon FSx for Windows File Server, you can use AWS DataSync to transfer files between an existing file system and Amazon FSx for Windows File Server\. 

AWS DataSync is a data transfer service that simplifies, automates, and accelerates moving and replicating data between on\-premises storage systems and AWS storage services over the internet or AWS Direct Connect\. DataSync can transfer your file data, and also file system metadata such as ownership, time stamps, and access permissions\.

In DataSync, a *location* for Amazon FSx for Windows is an endpoint for an Amazon FSx for Windows File Server\. You can transfer files between a location for Amazon FSx for Windows and a location for other file systems\. For information, see [Working with Locations](https://docs.aws.amazon.com/datasync/latest/userguide/working-with-locations.html) in the *AWS DataSync User Guide*\.

DataSync accesses your Amazon FSx for Windows File Server using the Server Message Block \(SMB\) protocol\. It authenticates by using the user name and password that you configure in the DataSync console or AWS CLI\. 

## Before You Begin<a name="data-sync-prereq"></a>

For this step, we assume that you have the following:
+ A source location that you can transfer files from\. If this source is an Amazon EFS file system, it needs to be accessible over NFS version 3, version 4, or 4\.1\. Example file systems include those located in on\-premises data centers, self\-managed in\-cloud file systems, and Amazon FSx for Windows file systems\. 
+ A destination file system to transfer files to\. Example file systems include those located in on\-premises data centers, self\-managed in\-cloud file systems, and Amazon FSx for Windows file systems\. If you don't have an Amazon FSx for Windows File Server file system, create one\. For more information, see [Getting Started with Amazon FSx](getting-started.md)\.
+ A server and network that meet the DataSync requirements\. To learn more, see [Requirements for DataSync](https://docs.aws.amazon.com/datasync/latest/userguide/requirements.html) in the *AWS DataSync User Guide*\.

When you have the preceding in place, you can begin transfer as discussed following\.

## Basic Steps for Transferring Files Using DataSync<a name="data-sync-basic-steps"></a>

To transfer files from a source location to a destination location using DataSync, take the following basic steps:
+ Download and deploy an agent in your environment and activate it\.
+ Create and configure a source and destination location\.
+ Create and configure a task\.
+ Run the task to transfer files from the source to the destination\.

To learn how to transfer files from an existing on\-premises file system to your Amazon FSx for Windows File Server, see [Getting Started with DataSync](https://docs.aws.amazon.com/datasync/latest/userguide/getting-started.html) in the *AWS DataSync User Guide*\. 

To learn how to transfer files from an existing in\-cloud file system to your Amazon FSx for Windows File Server, see [Deploying the DataSync Agent as an Amazon EC2 Instance](https://docs.aws.amazon.com/datasync/latest/userguide/ec2-agent.html) in the *AWS DataSync User Guide*\.  