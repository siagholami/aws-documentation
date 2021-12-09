--------

--------

# Troubleshooting<a name="troubleshooting"></a>

When you synchronize your Amazon Kendra index with a data source, you may run into issues that prevent the documents from being indexed\. Indexing is a two step process\. First, there is the data source level process of crawling the data source to find the new and updated documents to index, and to find any documents to remove from the index\. Second, there is the document level process where each document is accessed and indexed\. 

An error can occur in either of these steps\. Data source level errors are reported in the console in the **Sync run history** section of the data source details page\. The status of the synchronization job can be **Succeeded**, **Incomplete**, or **Failed**\. You can also see the number of documents indexed and deleted during the job\. If the status is **Failed**, a message is shown in the **Details** column\.

Document level errors are reported in Amazon CloudWatch Logs\. You can see the errors using the CloudWatch console\.

## My synchronization job failed<a name="failed"></a>

A synchronization job typically fails when there is a configuration error in the index or the data source\. The error message in the Details column of the data source gives information about what went wrong\. The problem is usually that the index or the data source does not have the proper IAM permissions\. The error message describes the permissions that are missing\. Here are some of the error messages that you can receive:

`Failed to create log group for job. Please make sure that the IAM role provided has sufficient permissions.`

If your index role does not have permission to use CloudWatch, the data source will not be able to create a CloudWatch log\. If you get this error you need to add CloudWatch permissions to the index role\.

`Failed to access S3 file prefix (bucket name) while trying to crawl your metadata files. Please make sure the IAM Role (role ARN) provided has sufficient permissions. `

When you are using an Amazon S3 data source, Amazon Kendra must have permission to access the bucket that contains the documents\. You need to add permission for Amazon Kendra to read the bucket to the data source IAM role\.

`The provided IAM Role (role ARN) could not be assumed. Please make sure Amazon Kendra is a trusted entity that is allowed to assume the role.`

Amazon Kendra needs permission to assume the index and data source IAM roles\. You need to add a trust policy to the roles with permission for the `sts:AssumeRole` action\.

For the IAM polices that Amazon Kendra needs to index a data source, see [IAM access roles for Amazon Kendra](iam-roles.md)\.

## My synchronization job is incomplete<a name="incomplete"></a>

Jobs are generally incomplete when they have completed the data source level process but have had some error during the document level process\. When a job is incomplete, some of the documents may have been successfully indexed\. For an Amazon S3 data source, an incomplete job is typically caused by:\.
+ The metadata for one or more documents was invalid\.
+ When there are documents to submit for indexing, at least one document was not submitted\.
+ When there are documents to submit for deleting from the index, at least one document was not submitted\.

To troubleshoot an incomplete synchronization job, look first to your CloudWatch logs\. 

1. From the details column, choose **View details in CloudWatch**\. 

1. Review the error messages to see what caused the document to fail\.

## My synchronization job succeeded but there are no indexed documents<a name="succeeded"></a>

Occasionally you will have a index synchronization job run that is marked as **Succeeded** but there are no new or updated documents indexed when you expect there to be\. Here are some reasons:
+ Check CloudWatch `DocumentsSubmittedForIndexingFailed` metric to see if there were any documents that failed to synchronize\. Check your CloudWatch logs for details\.
+ For an Amazon S3 data source, you may have given Amazon Kendra the wrong bucket name or prefix\. Make sure that the bucket that Amazon Kendra is using is the one that contains the documents to index\.
+ If you are re\-indexing a document that failed to be indexed in an earlier job, Amazon Kendra won't index it unless you make a change to the document or its associated metadata file\.

## General troubleshooting<a name="general"></a>

Amazon Kendra uses CloudWatch metrics and logs to provide you with insight into synchronizing your data sources\. You can use the metrics and logs to determine what went wrong with a synchronization run and to determine what you need to do to fix it\. 

For general troubleshooting, start with your CloudWatch metrics\. 
+ Check the `DocumentsCrawled` metric to see how many documents your data source checked\. For an Amazon S3 bucket, if the number is less than you expect, check to be sure that your data source is pointing to the right bucket\.
+ Check the `DocumentsSkippedNoChange` metric to see how many documents were skipped because they haven't changed since the last synchronization\. If the number does not match what you expect, check to make sure that your repository was updated correctly\. 
+ Check the `DocumentsSkippedInvalidMetadata` metric to see how many documents had invalid metadata\. Check your CloudWatch logs to see the specific errors that occurred\.
+ Check the `DocumentsSubmittedForIndexingFailed` metric to see the number of documents that were sent from the data source to the index but failed to be indexed for some reason\. For example, if you use a metadata attribute in an Amazon S3 data source that hasn't been defined as a custom index field the document will not be indexed\. Check your CloudWatch logs to see the specific errors that occurred\.
+ Check the `DocumentsSubmittedForDeletionFailed` metric to see how many documents that the data source attempted to remove from the index failed to be deleted from the index\. Check your CloudWatch logs to see the specific errors that occurred\.

You can look at the CloudWatch logs for a particular synchronization run to get details of the errors that occurred during the run\. For more information about CloudWatch logs with Amazon Kendra, see [Monitoring Amazon Kendra with Amazon CloudWatch Logs](cloudwatch-logs.md)\.