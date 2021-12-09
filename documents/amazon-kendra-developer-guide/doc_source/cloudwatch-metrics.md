--------

--------

# Monitoring Amazon Kendra with Amazon CloudWatch<a name="cloudwatch-metrics"></a>

To track the health of your indexes, use Amazon CloudWatch\. With CloudWatch, you can get metrics for document synchronization for your index\. You can also set up CloudWatch alarms to be notified when one or more metrics exceeds a threshold that you define\. For example, you can monitor the number of documents submitted to be indexed or the number of documents that failed to be indexed\.

You must have the appropriate CloudWatch permissions to monitor Amazon Kendra with CloudWatch\. For more information, see [Authentication and Access Control for Amazon CloudWatch](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/auth-and-access-control-cw.html) in the *Amazon CloudWatch User Guide*\.

## Viewing Amazon Kendra metrics<a name="viewing-metrics"></a>

View Amazon Kendra metrics using the CloudWatch console\.

**To view metrics \(CloudWatch console\)**

1. Sign in to the AWS Management Console and open the CloudWatch console at [https://console\.aws\.amazon\.com/cloudwatch/](https://console.aws.amazon.com/cloudwatch/)\.

1. Choose **Metrics**, choose **All Metrics** and then choose **Kendra**\.

1. Choose the dimension, choose a metric name, then choose **Add to graph**\.

1. Choose a value for the date range\. The metric count for the selected date range is displayed in the graph\.

## Creating an alarm<a name="cloudwatch-alarms"></a>

A CloudWatch alarm watches a single metric over a specified time period and performs one or more actions: sending a notification to an Amazon Simple Notification Service \(Amazon SNS\) top or Auto Scaling policy\. The actions or actions are based on the value of the metric relative to a given threshold over a number of time periods that you specify\. CloudWatch can also send you an Amazon SNS message when the alarm changes state\.

CloudWatch alarms invoke actions only when the state changes and has persisted for the period that you specify\.

**To set an alarm**

1. Sign in to the AWS Management Console and open the CloudWatch console at [https://console\.aws\.amazon\.com/cloudwatch/](https://console.aws.amazon.com/cloudwatch/)\.

1. Choose **Alarms** and then choose **Create Alarm**\.

1. Choose **Kendra metrics** and then choose a metric\.

1. For **Time Range**, choose a time range to monitor, and then choose **Next**\. 

1. Enter a **Name** and **Description**\.

1. For **Whenever**, choose **>=**, and type a maximum value\.

1. If you want CloudWatch to send an email when the alarm state is reached, in the **Actions** section, for **Whenever this alarm**, choose **State is ALARM**\. For **Send notification to**, choose a mailing list or choose **New list** and create a new mailing list

1. Preview the alarm in the **Alarm Preview** section\. If you are satisfied with the alarm, choose **Create Alarm**\.

## CloudWatch Metrics for index synchronization Jobs<a name="cloudwatch-metric-sync-jobs"></a>

The following table describes the Amazon Kendra metrics for data source synchronization jobs\.


| Metric | Description | 
| --- | --- | 
| DocumentsCrawled | The number of documents that the synchronization job scanned or discovered during the run\. Dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/kendra/latest/dg/cloudwatch-metrics.html)Unit: Count | 
| DocumentsSubmittedForIndexing | The number of documents that the synchronization job submitted to the index\. Dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/kendra/latest/dg/cloudwatch-metrics.html)Unit: Count | 
| DocumentsSubmittedForIndexingFailed | The number of documents that failed indexing\. Check the contents of the CloudWatch log for the synchronization job for details\. Dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/kendra/latest/dg/cloudwatch-metrics.html)Unit: Count | 
| DocumentsSubmittedForDeletion | The number of documents that the synchronization job asked to be removed from the index\. Dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/kendra/latest/dg/cloudwatch-metrics.html)Unit: Count | 
| DocumentsSubmittedForDeletionFailed | The number of documents that failed to be deleted\. Check the contents of the CloudWatch log for the synchronization job for details\. Dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/kendra/latest/dg/cloudwatch-metrics.html)Unit: Count | 

## Metrics for Amazon Kendra data sources<a name="cloudwatch-metrics-data-source"></a>

The following table describes the Amazon Kendra metrics for data source synchronization jobs\. Metrics marked with an asterisk \(\*\) are used only for Amazon S3 data sources\.


| Metric | Description | 
| --- | --- | 
| DocumentsSkippedNoChange \* | The number of documents examined and found not to have changed so they weren't submitted for indexing\. Dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/kendra/latest/dg/cloudwatch-metrics.html)Unit: Count | 
| DocumentsSkippedInvalidMetadata \* | The number of documents skipped because there was a problem with the associated metadata file\. Check the contents of the CloudWatch log for the synchronization run for details\. Dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/kendra/latest/dg/cloudwatch-metrics.html)Unit: Count | 
| DocumentsCrawled | The number of document files examined\. Dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/kendra/latest/dg/cloudwatch-metrics.html)Unit: Count | 
| DocumentsSubmittedForDeletion | The number of documents examined that were deleted from the data source and submitted for deletion\. Dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/kendra/latest/dg/cloudwatch-metrics.html)Unit: Count | 
| DocumentsSubmittedForDeletionFailed | The number of documents that failed deletion from a data source\. Dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/kendra/latest/dg/cloudwatch-metrics.html)Unit: Count | 
| DocumentsSubmittedForIndexing | The number of documents examined and submitted for indexing\. Dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/kendra/latest/dg/cloudwatch-metrics.html)Unit: Count | 
| DocumentsSubmittedForIndexingFailed | The number of documents submitted for idexing that couldn't be indexed\. Dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/kendra/latest/dg/cloudwatch-metrics.html)Unit: Count | 

## Metrics for indexed documents<a name="cloudwatch-metrics-id"></a>

The following table describes the Amazon Kendra metrics for indexed documents\. For documents that are indexed using the [BatchPutDocument](API_BatchPutDocument.md) operation, only the `IndexId` dimension is supported\.


| Metric | Description | 
| --- | --- | 
| DocumentsIndexed | The number of documents indexed\. Dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/kendra/latest/dg/cloudwatch-metrics.html)Unit: Count | 
| DocumentsFailedToIndex | The number of documents that could not be indexed\. Check the contents of the CloudWatch log for details\. Dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/kendra/latest/dg/cloudwatch-metrics.html)Unit: Count | 