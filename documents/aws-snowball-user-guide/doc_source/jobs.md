--------

This guide is for the Snowball \(50 TB or 80 TB of storage space\)\. If you are looking for documentation for the Snowball Edge, see the [AWS Snowball Edge Developer Guide](https://docs.aws.amazon.com/snowball/latest/developer-guide/whatisedge.html)\.

--------

# Jobs for Standard Snowball devices<a name="jobs"></a>

A job in AWS Snowball \(Snowball\) is a discrete unit of work, defined when you create it in the console or the job management API\. Jobs have types, details, and statuses\. Each of those elements is covered in greater detail in the sections that follow\.

**Topics**
+ [Job Types](#jobtype)
+ [Job Details](#jobdetails)
+ [Job Statuses](#job-status)

## Job Types<a name="jobtype"></a>

There are two different job types: import jobs and export jobs\. Both of the Snowball job types are summarized following, including the source of the data, how much data can be moved, and the result you can expect at successful job completion\. Although these two types of jobs have fundamental differences, they share some common details The source can be local to your data center or office, or it can be an Amazon S3 bucket\.

### Import into Amazon S3<a name="importtype"></a>

An *import job* is the transfer of 80 TB or less of your data \(located in an on\-premises data source\), copied onto a single Snowball, and then moved into Amazon S3\. For import jobs, Snowballs and jobs have a one\-to\-one relationship, meaning that each job has exactly one Snowball associated with it\. If you need additional Snowballs, you can create new import jobs or clone existing ones\.

Your data source for an import job should be on\-premises\. In other words, the storage devices that hold the data to be transferred should be physically located at the address that you provided when you created the job\.

You can import any number of directories, files, and objects for each import job, provided the amount of data you're importing fits within a single Snowball\. In the US regions, Snowballs come in two sizes: 50 TB and 80 TB\. All other regions have 80 TB Snowballs only\.

When you import files, each file becomes an object in Amazon S3 and each directory becomes a prefix\. If you import data into an existing bucket, any existing objects with the same names as newly imported objects will be overwritten\.

When the import has been processed and verified, AWS performs a complete erasure of the Snowball\. This erasure follows the National Institute of Standards and Technology \(NIST\) 800\-88 standards\.

After your import is complete, you can download a job report\. This report alerts you to any objects that failed the import process\. You can find additional information in the success and failure logs\.

**Important**  
Don't delete your local copies of the transferred data until you can verify the results of the job completion report and review your import logs\.

### Export from Amazon S3<a name="exporttype"></a>

An *export job* is the transfer of any amount of data \(located in Amazon S3\), copied onto any number of Snowballs, and then moved one Snowball at a time into your on\-premises data destination\. When you create an export job, it's split into job parts\. Each job part is no more than 80 TB in size, and each job part has exactly one Snowball associated with it\.

Your data source for an export job is one or more Amazon S3 buckets\. Once the data for a job part is moved from Amazon S3 to a Snowball, you can download a job report\. This report will alert you to any objects that failed the transfer to the Snowball\. You can find more information in your job's success and failure logs\.

You can export any number of objects for each export job, using as many Snowballs as it takes to complete the transfer\. Snowballs for an export job's job parts are delivered one after another, with subsequent Snowballs shipping out to you once the previous job part has entered the **In transit to AWS** status\.

When you copy objects into your on\-premises data destination from a Snowball, those objects are saved as files\. If you copy objects into a location that already holds files, any existing files with the same names will be overwritten\.

When AWS receives a returned Snowball, we perform a complete erasure of the Snowball\. This erasure follows the NIST 800\-88 standards\.

**Important**  
Don't change, update, or delete the exported Amazon S3 objects until you can verify that all of your contents for the entire job have been copied to your on\-premises data destination\.

When you create an export job, you can choose to export an entire Amazon S3 bucket or a specific range of objects keys\. For more information, see [Using Export Ranges](ranges.md)\.

## Job Details<a name="jobdetails"></a>

Each import or export job for Snowball is defined by the details that you specify when it's created\. The following list describes all the details of a job\.
+ **Job name** – A name for the job, containing alphanumeric characters, spaces, and any Unicode special characters\.
+ **Job type** – The type of job, either import or export\.
+ **Job ID** – A unique 39\-character label that identifies your job\. The job ID appears at the bottom of the shipping label that appears on the E Ink display, and in the name of a job's manifest file\.
+ **Created date** – The date that you created this job\.
+ **Shipping speed** – Speed options are based on region\. For more information, see [Shipping Speeds](mailing-storage.md#shippingspeeds)\.
+ **IAM role ARN** – This Amazon Resource Name \(ARN\) is the AWS Identity and Access Management \(IAM\) role that is created during job creation with write permissions for your Amazon S3 buckets\. The creation process is automatic, and the IAM role that you allow Snowball to assume is only used to copy your data between your Amazon S3 buckets and the Snowball\. For more information, see [Creating an IAM Role for Snowball](auth-access-control.md#create-iam-role)\.
+ **AWS KMS key** – In Snowball, AWS Key Management Service \(AWS KMS\) encrypts the keys on each Snowball\. When you create your job, you also choose or create an ARN for an AWS KMS encryption key that you own\. For more information, see [AWS Key Management Service in Snowball](kms.md)\.
+ **Snowball capacity** – In the US regions, Snowballs come in two sizes: 50 TB and 80 TB\. All other regions have the 80 TB Snowballs only\.
+ **Storage service** – The AWS storage service associated with this job, in this case Amazon S3\.
+ **Resources** – The AWS storage service resources associated with your job\. In this case, these are the Amazon S3 buckets that your data is transferred to or from\.

## Job Statuses<a name="job-status"></a>

Each job has a *status*, which changes to denote the current state of the job\.


| Job Status | Description | Job Type That Status Applies To | 
| --- | --- | --- | 
| Job created | Your job has just been created\. This status is the only one during which you can cancel a job or its job parts, if the job is an export job\. | Both | 
| Preparing Snowball | AWS is preparing a Snowball for your job\. | Both | 
| Exporting | AWS is exporting your data from Amazon S3 onto a Snowball\. | Export | 
| Preparing shipment | AWS is preparing to ship a Snowball to you\. | Both | 
| In transit to you | The Snowball has been shipped to the address you provided during job creation\. | Both | 
| Delivered to you | The Snowball has arrived at the address you provided during job creation\. | Both | 
| In transit to AWS | You have shipped the Snowball back to AWS\. | Both | 
| At sorting facility | The device for this job is at our internal sorting facility\. Any additional processing for import jobs into Amazon S3 will begin soon, typically within 2 days\. | Both | 
| At AWS | Your shipment has arrived at AWS\. If you're importing data, your import typically begins within a day of its arrival\. | Both | 
| Importing | AWS is importing your data into Amazon Simple Storage Service \(Amazon S3\)\. | Import | 
| Completed | Your import job or export job part has completed successfully\. | Both | 
| Canceled | Your job has been canceled\. You can only cancel Snowball import jobs during the Job created status\. | Both | 