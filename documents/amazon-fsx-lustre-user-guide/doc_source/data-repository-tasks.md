# Data repository tasks<a name="data-repository-tasks"></a>

By using data repository tasks, you can manage the transfer of data and metadata between your Amazon FSx for Lustre file system and its durable data repository on Amazon S3\. 

*Data repository tasks* optimize data and metadata transfers between your Amazon FSx for Lustre file system and its data repository on S3\. One way that they do this is by tracking changes between your Amazon FSx file system and its linked data repository\. They also do this by using parallel transfer techniques to transfer data at speeds up to hundreds of GB/s\. You create and view data repository tasks using the Amazon FSx console, the AWS CLI, and the Amazon FSx API\. 

Data repository tasks maintain the file system's Portable Operating System Interface \(POSIX\) metadata, including ownership, permissions, and timestamps\. Because the tasks maintain this metadata, you can implement and maintain access controls between your Amazon FSx for Lustre file system and its data repository on S3\. Files and associated permissions are stored in the same format that is used by other AWS services, including AWS DataSync, AWS Storage Gateway, and AWS Transfer for SFTP\. Using the same format provides a consistent mechanism to control file access in AWS\. 

## Types of Data Repository Tasks<a name="data-repo-task-types"></a>

Currently, the **Export to repository** data repository task is the only task available\. For more information about using this task to export from your Lustre file system to its linked data repository on S3, see [Using data repository tasks to export data and metadata changes](export-data-repo-task.md)\.

**Topics**
+ [Types of Data Repository Tasks](#data-repo-task-types)
+ [Understanding a Task's Status and Details](data-repo-task-status.md)
+ [Using Data Repository Tasks](managing-data-repo-task.md)
+ [Working with Task Completion Reports](task-completion-report.md)
+ [Troubleshooting Failed Data Repository Tasks](failed-tasks.md)