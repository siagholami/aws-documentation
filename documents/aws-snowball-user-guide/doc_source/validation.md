--------

This guide is for the Snowball \(50 TB or 80 TB of storage space\)\. If you are looking for documentation for the Snowball Edge, see the [AWS Snowball Edge Developer Guide](https://docs.aws.amazon.com/snowball/latest/developer-guide/whatisedge.html)\.

--------

# Data Validation in AWS Snowball<a name="validation"></a>

Following, you'll find information on how Snowball validates data transfers, and the manual steps you can take to ensure data integrity during and after a job\.

**Topics**
+ [Checksum Validation of Transferred Data](#snowball-checksums)
+ [Common Validation Errors](#validation-error-causes)
+ [Manual Data Validation for Snowball During Transfer](#manual-validation-device)
+ [Manual Data Validation for Snowball After Import into Amazon S3](#manual-validation-s3)

## Checksum Validation of Transferred Data<a name="snowball-checksums"></a>

When you copy a file from a local data source using the Snowball client or the Amazon S3 Adapter for Snowball, to the Snowball, a number of checksums are created\. These checksums are used to automatically validate data as it's transferred\.

At a high level, these checksums are created for each file \(or for parts of large files\)\. These checksums are never visible to you, nor are they available for download\. The checksums are used to validate the integrity of your data throughout the transfer, and will ensure that your data is copied correctly\.

When these checksums don't match, we won't import the associated data into Amazon S3\.

## Common Validation Errors<a name="validation-error-causes"></a>

Validations errors can occur\. Whenever there's a validation error, the corresponding data \(a file or a part of a large file\) is not written to the destination\. The common causes for validation errors are as follows:
+ Attempting to copy symbolic links\.
+ Attempting to copy files that are actively being modified\. This will not result in a validation error, but it will cause the checksums to not match at the end of the transfer\.
+ Attempting to copy whole files larger than 5 TB in size\.
+ Attempting to copy part sizes larger than 5 GB in size\.
+ Attempting to copy files to a Snowball that is already at full data storage capacity\.
+ Attempting to copy files to a Snowball that doesn't follow the [Object Key Naming Guidelines](https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingMetadata.html#object-key-guidelines) for Amazon S3\.

Whenever any one of these validation errors occurs, it is logged\. You can take steps to manually identify what files failed validation and why as described in the following sections:
+ [Manual Data Validation for Snowball During Transfer](#manual-validation-device) – Outlines how to check for failed files while you still have the Snowball on\-premises\.
+ [Manual Data Validation for Snowball After Import into Amazon S3](#manual-validation-s3) – Outlines how to check for failed files after your import job into Amazon S3 has ended\.

## Manual Data Validation for Snowball During Transfer<a name="manual-validation-device"></a>

You can use manual validation to check that your data was successfully transferred to a Snowball Edge\. You can also use manual validation if you receive an error after attempting to transfer data\. Use the following section to find how to manually validate data on a Snowball Edge\.

**Check the failed\-files log – Snowball client**  
When you run the Snowball client `copy` command, a log showing any files that couldn't be transferred to the Snowball is generated\. If you encounter an error during data transfer, the path for the failed\-files log will be printed to the terminal\. This log is saved as a comma\-separated values \(\.csv\) file\. Depending on your operating system, you find this log in one of the following locations:
+ **Windows** – `C:/Users/<username>/AppData/Local/Temp/snowball-<random-character-string>/failed-files`
+ **Linux** – `/tmp/snowball-<random-character-string>/failed-files`
+ **Mac** – `/var/folders/gf/<random-character-string>/<random-character-string>/snowball-7464536051505188504/failed-files `

**Use the \-\-verbose option for the Snowball client copy command**  
When you run the Snowball client `copy` command, you can use the `--verbose` option to list all the files that are transferred to the Snowball\. You can use this list to validate the content that was transferred to the Snowball\.

**Check the logs – Amazon S3 Adapter for Snowball**  
When you run the Amazon S3 Adapter for Snowball to copy data with the AWS CLI, logs are generated\. These logs are saved in the following locations, depending on your file system:
+ **Windows** – `C:/Users/<username>/.aws/snowball/logs/snowball_adapter_<year_month_date_hour>`
+ **Linux** – `/home/.aws/snowball/logs/snowball_adapter_<year_month_date_hour>`
+ **Mac** – `/Users/<username>/.aws/snowball/logs/snowball_adapter_<year_month_date_hour>`

**Use the \-\-stopOnError copy option**  
If you're transferring with the Snowball client, you can use this option to stop the transfer process in the event a file fails\. This option stops the copy on any failure so you can address that failure before continuing the copy operation\. For more information, see [Options for the snowball cp Command](copy-command-reference.md)\.

**Run the Snowball client's validate command**  
The Snowball client's `snowball validate` command can validate that the files on the Snowball were all completely copied over to the Snowball\. If you specify a path, then this command validates the content pointed to by that path and its subdirectories\. This command lists files that are currently in the process of being transferred as incomplete for their transfer status\. For more information on the validate command, see [Validate Command for the Snowball Client](using-client-commands.md#snowball-validate-command)\.

## Manual Data Validation for Snowball After Import into Amazon S3<a name="manual-validation-s3"></a>

After an import job has completed, you have several options to manually validate the data in Amazon S3, as described following\.

**Check job completion report and associated logs**  
Whenever data is imported into or exported out of Amazon S3, you get a downloadable PDF job report\. For import jobs, this report becomes available at the end of the import process\. For more information, see [Getting Your Job Completion Report and Logs in the Console](report.md)\.

**S3 inventory**  
If you transferred a huge amount of data into Amazon S3 in multiple jobs, going through each job completion report might not be an efficient use of time\. Instead, you can get an inventory of all the objects in one or more Amazon S3 buckets\. Amazon S3 inventory provides a \.csv file showing your objects and their corresponding metadata on a daily or weekly basis\. This file covers objects for an Amazon S3 bucket or a shared prefix \(that is, objects that have names that begin with a common string\)\.

Once you have the inventory of the Amazon S3 buckets that you've imported data into, you can easily compare it against the files that you transferred on your source data location\. In this way, you can quickly identify what files where not transferred\.

**Use the Amazon S3 sync command**  
If your workstation can connect to the internet, you can do a final validation of all your transferred files by running the AWS CLI command `aws s3 sync`\. This command syncs directories and S3 prefixes\. This command recursively copies new and updated files from the source directory to the destination\. For more information, see [https://docs.aws.amazon.com/cli/latest/reference/s3/sync.html](https://docs.aws.amazon.com/cli/latest/reference/s3/sync.html)\.

**Important**  
If you specify your local storage as the destination for this command, make sure that you have a backup of the files you sync against\. These files are overwritten by the contents in the specified Amazon S3 source\.