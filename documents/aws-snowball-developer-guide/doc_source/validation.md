--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Data Validation with Snowball Edge Jobs<a name="validation"></a>

Following, you'll find information on how Snowball Edge validates data transfers, and the manual steps you can take to ensure data integrity during and after a job\.

**Topics**
+ [Checksum Validation of Transferred Data](#snowball-edge-checksums)
+ [Common Validation Errors](#validation-error-causes)
+ [Manual Data Validation for Snowball Edge After Import into Amazon S3](#manual-validation-s3)

## Checksum Validation of Transferred Data<a name="snowball-edge-checksums"></a>

When you copy a file from a local data source using the Amazon S3 Adapter for Snowball to the Snowball Edge, a number of checksums are created\. These checksums are used to automatically validate data as it's transferred\.

At a high level, these checksums are created for each file \(or for parts of large files\)\. For the Snowball Edge, these checksums are visible when you run the following AWS CLI command against a bucket on the device\. The checksums are used to validate the integrity of your data throughout the transfers and will ensure that your data is copied correctly\.

```
aws s3api list-objects --bucket bucket-name --endpoint http://ip:8080 --profile edge-profile
```

When these checksums don't match, we won't import the associated data into Amazon S3\.

## Common Validation Errors<a name="validation-error-causes"></a>

Validations errors can occur\. Whenever there's a validation error, the corresponding data \(a file or a part of a large file\) is not written to the destination\. The common causes for validation errors are as follows:
+ Attempting to copy symbolic links\.
+ Attempting to copy files that are actively being modified\. This will not result in a validation error, but it will cause the checksums to not match at the end of the transfer\.
+ Attempting to copy files larger than 5 TB in size\.
+ Attempting to copy part sizes larger than 512 MB in size\.
+ Attempting to copy files to a Snowball Edge that is already at full data storage capacity\.
+ Attempting to copy files to a Snowball Edge that doesn't follow the [Object Key Naming Guidelines](https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingMetadata.html#object-key-guidelines) for Amazon S3\.

Whenever any one of these validation errors occurs, it is logged\. You can take steps to manually identify what files failed validation and why as described in the following sections\.

## Manual Data Validation for Snowball Edge After Import into Amazon S3<a name="manual-validation-s3"></a>

After an import job has completed, you have several options to manually validate the data in Amazon S3, as described following\.

**Check job completion report and associated logs**  
Whenever data is imported into or exported out of Amazon S3, you get a downloadable PDF job report\. For import jobs, this report becomes available at the end of the import process\. For more information, see [Get Your Job Completion Report and Logs in the Console](report.md)\.

**S3 inventory**  
If you transferred a huge amount of data into Amazon S3 in multiple jobs, going through each job completion report might not be an efficient use of time\. Instead, you can get an inventory of all the objects in one or more Amazon S3 buckets\. Amazon S3 inventory provides a comma\-separated value \(CSV\) file showing your objects and their corresponding metadata on a daily or weekly basis\. This file covers objects for an Amazon S3 bucket or a shared prefix \(that is, objects that have names that begin with a common string\)\.

Once you have the inventory of the Amazon S3 buckets that you've imported data into, you can easily compare it against the files that you transferred on your source data location\. In this way, you can quickly identify what files where not transferred\.

**Use the Amazon S3 sync command**  
If your workstation can connect the internet, you can do a final validation of all your transferred files by running the AWS CLI command `aws s3 sync`\. This command syncs directories and S3 prefixes\. This command recursively copies new and updated files from the source directory to the destination\. For more information, see [https://docs.aws.amazon.com/cli/latest/reference/s3/sync.html](https://docs.aws.amazon.com/cli/latest/reference/s3/sync.html)\.

**Important**  
If you specify your local storage as the destination for this command, make sure that you have a backup of the files you sync against\. These files are overwritten by the contents in the specified Amazon S3 source\.