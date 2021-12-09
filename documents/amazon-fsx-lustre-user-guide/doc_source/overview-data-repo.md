# Overview of data repositories<a name="overview-data-repo"></a>

When you use Amazon FSx with a durable storage repository, you can ingest and process large volumes of file data in a high\-performance file system\. At the same time, you can periodically write intermediate results to your data repository\. By using this approach, you can restart your workload at any time using the latest data stored in your data repository\. When your workload is done, you can write final results from your file system to your data repository and delete your file system\.

You can link your Amazon FSx file system to an Amazon S3 durable data repository when you create the file system\. For more information, see [Linking your file system to an S3 bucket](create-fs-linked-data-repo.md)\.

Amazon FSx is deeply integrated with Amazon S3\. This integration means that you can seamlessly access the objects stored in your Amazon S3 buckets from applications that mount your Amazon FSx file system\. You can also run your compute\-intensive workloads on Amazon EC2 instances in the AWS Cloud and export the results to your data repository after your workload is complete\.

In Amazon FSx for Lustre, you can export files and their associated metadata that you have written or modified in your file system to your durable data repository on Amazon S3 at any time\. When you export a file or directory, your file system exports only data files and metadata that were created or modified since the last export or since file system creation\. Such an export includes POSIX metadata\. 

Amazon FSx also supports cloud bursting workloads with on\-premises file systems by enabling you to copy data from on\-premises clients using AWS Direct Connect or VPN\.

**Important**  
If you have linked one or more Amazon FSx file systems to a durable data repository on Amazon S3, don't delete the Amazon S3 bucket until you have deleted all linked file systems\.

## POSIX metadata support for data repositories<a name="posix-metadata-support"></a>

Amazon FSx for Lustre automatically transfers Portable Operating System Interface \(POSIX\) metadata for files, directories, and symbolic links \(symlinks\) when importing and exporting data to and from a linked durable data repository on Amazon S3\. When you export changes in your file system to its linked data repository, Amazon FSx also exports POSIX metadata changes along with data changes\. Because of this metadata export, you can implement and maintain access controls between your Amazon FSx for Lustre file system and its data repository on S3\.

 Amazon FSx imports only S3 objects that have POSIX\-compliant object keys, such as the following\. For more information, see [Exporting changes to the data repository](export-changed-data-meta.md)\.

```
test/mydir/ 
test/
```

Amazon FSx doesn't import S3 object keys that are not POSIX\-compliant, such as the following\.

```
.
.. 
test/. 
test/..
```

Amazon FSx stores directories and symlinks as separate objects in the linked data repository on S3\. For directories, Amazon FSx creates an S3 object with a key name that ends with a slash \("/"\), as follows:
+ S3 object key = `test/mydir/` maps to the Amazon FSx directory `test/mydir`\.
+ S3 object key = `test/` maps to the Amazon FSx directory `test`\.

For symlinks, Amazon FSx for Lustre uses the same Amazon S3 schema as AWS DataSync, shown following:
+ S3 object key – The path to the link, relative to the Amazon FSx mount directory
+ S3 object data – The target path of this symlink
+ S3 object metadata – The metadata for the symlink

Amazon FSx stores POSIX metadata, including ownership, permissions, and timestamps for Amazon FSx files, directories and symbolic links, in S3 objects as follows:
+ `Content-Type` – HTTP entity header used to indicate the media type of resource for web browsers\.
+ `x-amz-meta-file-permissions` – File type and permissions in format `<octal file type><octal permission mask>`, consistent with `st_mode` in Linux stat\(2\)\.
**Note**  
Amazon FSx for Lustre does not import or retain `setuid` and `setgid` information\.
+ `x-amz-meta-file-owner` – The owner UID expressed as an integer\.
+ `x-amz-meta-file-group` – The group UID expressed as an integer\.
+ `x-amz-meta-file-atime` – The last accessed time in nanoseconds\. Terminate the time value with "ns"; otherwise Amazon FSx interprets the value as milliseconds\.
+ `x-amz-meta-file-mtime` – The last modified time in nanoseconds\. Terminate the time value with "ns"; otherwise, Amazon FSx interprets the value as milliseconds\.
+ `x-amz-meta-user-agent` – The user agent, ignored during Amazon FSx import\. During export, Amazon FSx sets this value to `aws-fsx-lustre`\.

**Note**  
Amazon FSx doesn't retain any user\-defined custom metadata on S3 objects\.

## Data repository lifecycle state<a name="data-repository-lifecycles"></a>

The data repository lifecycle state provides status information about the file system's linked data repository\. A data repository can have the following **Lifecycle states**:
+ **Creating** – Amazon FSx is creating the data repository configuration between the file system and the linked data repository\. The data repository is unavailable\.
+ **Available** – The data repository is available for use\.
+ **Updating** – The data repository configuration is undergoing a customer initiated update which may impact its availability\.
+ **Misconfigured** – Amazon FSx cannot automatically import updates from the S3 bucket until the data repository configuration is corrected\. For more information, see [Misconfigured linked S3 bucket](troubleshooting.md#troubleshooting-misconfigured-data-repository)\.

 You can view a file system's linked data repository lifecycle state using the Amazon FSx management console, the CLI, and the AWS API\. In the FSx console, you can access the **Lifecycle state** on the **Summary** panel of the file system details page in the Amazon FSx management console\. The `Lifecycle` property is found in the `DataRepositoryConfiguration` object in the response of a [https://docs.aws.amazon.com/cli/latest/reference/fsx/describe-file-systems.html](https://docs.aws.amazon.com/cli/latest/reference/fsx/describe-file-systems.html) CLI command \(the equivalent API action is [https://docs.aws.amazon.com/fsx/latest/APIReference/API_DescribeFileSystems.html](https://docs.aws.amazon.com/fsx/latest/APIReference/API_DescribeFileSystems.html)\)\. 