# Migrating Existing Files to Amazon FSx for Windows File Server Using AWS DataSync<a name="migrate-files-to-fsx-datasync"></a>

We recommend using AWS DataSync to transfer data between Amazon FSx for Windows File Server file systems\. DataSync is a data transfer service that simplifies, automates, and accelerates moving and replicating data between on\-premises storage systems and other AWS storage services over the internet or AWS Direct Connect\. DataSync can transfer your file system data and metadata, such as ownership, time stamps, and access permissions\.

**Note**  
While DataSync does support copying NTFS access control lists \(ACLs\), it does not currently support copying file audit control information, also known as NTFS System Access Control Lists \(SACLs\), which are used by administrators to control audit logging of user attempts to access files\. If you need to copy SACLs into your Amazon FSx file system, we recommend that you use Robocopy\. For more information, see [Migrating Existing Files to Amazon FSx for Windows File Server Using Robocopy](migrate-files-to-fsx.md)\.

You can also use DataSync to transfer files between two Amazon FSx for Windows File Server file systems, including file systems in different AWS Regions and file systems owned by different AWS accounts\. You can also use DataSync with Amazon FSx for Windows File Server file systems for other tasks\. For example, you can perform one\-time data migrations, periodically ingest data for distributed workloads, and automate replication for data protection and recovery\.

In AWS DataSync, a *location* for Amazon FSx for Windows is an endpoint for an Amazon FSx for Windows File Server\. You can transfer files between a location for Amazon FSx for Windows and a location for other file systems\. For information, see [Working with Locations](https://docs.aws.amazon.com/datasync/latest/userguide/working-with-locations.html) in the *AWS DataSync User Guide*\.

DataSync accesses your Amazon FSx for Windows File Server using the Server Message Block \(SMB\) protocol\. It authenticates with the user name and password that you configure in the AWS DataSync console or AWS CLI\.

## Prerequisites<a name="migrate-data-sync-prereq"></a>

To migrate data into your Amazon FSx for Windows File Server setup, you need the following:
+ A source location that you can transfer files from\. If this source is an Amazon EFS file system, it needs to be accessible over NFS version 3, version 4, or 4\.1\. Example file systems include those located in on\-premises data centers, self\-managed in\-cloud file systems, and Amazon FSx for Windows file systems\. 
+ A destination file system to transfer files to\. Example file systems include those located in on\-premises data centers, self\-managed in\-cloud file systems, and Amazon FSx for Windows file systems\. If you don't have an Amazon FSx for Windows File Server file system, create one\. For more information, see [Getting Started with Amazon FSx](getting-started.md)\.
+ A server and network that meet the DataSync requirements\. To learn more, see [Requirements for DataSync](https://docs.aws.amazon.com/datasync/latest/userguide/requirements.html) in the *AWS DataSync User Guide*\.

When you have the preceding in place, you can begin transfer as discussed following\.

## Basic Steps for Migrating Files Using DataSync<a name="migrate-data-sync-basic-steps"></a>

To transfer files from a source location to a destination location using DataSync, take the following basic steps:
+ Download and deploy an agent in your environment and activate it\.
+ Create and configure a source and destination location\.
+ Create and configure a task\.
+ Run the task to transfer files from the source to the destination\.

To learn how to transfer files from an existing on\-premises file system to your Amazon FSx for Windows File Server, see [Getting Started with DataSync](https://docs.aws.amazon.com/datasync/latest/userguide/getting-started.html) in the *AWS DataSync User Guide*\. 

To learn how to transfer files from an existing in\-cloud file system to your Amazon FSx for Windows File Server, see [Deploying the DataSync Agent as an Amazon EC2 Instance](https://docs.aws.amazon.com/datasync/latest/userguide/ec2-agent.html) in the *AWS DataSync User Guide*\.  