# Monitoring Your File Gateway<a name="monitoring-file-gateway"></a>

You can monitor your file gateway and associated resources by using Amazon CloudWatch metrics and file share audit logs, and use Amazon CloudWatch Events to get notified when your file operations are done\. For information about file gateway type metrics, see [Understanding gateway metrics](Main_monitoring-gateways-common.md#MonitoringGateways-common)\.

**Topics**
+ [Getting File Gateway Health Logs with CloudWatch Log Groups](#cw-log-groups)
+ [Using Amazon CloudWatch Metrics](#using-CloudWatch-metrics)
+ [Getting Notified About File Operations](#get-notification)
+ [Understanding File Share Metrics](#monitoring-fileshare)
+ [Understanding File Gateway Audit Logs](#audit-logs)

## Getting File Gateway Health Logs with CloudWatch Log Groups<a name="cw-log-groups"></a>

You can use Amazon CloudWatch Logs to get information about the health of your file gateway and related resources\. You can use the logs to monitor your gateway for errors that it encounters\. In addition, you can use Amazon CloudWatch subscription filters to automate processing of the log information in real\-time\. For more information see, [Real\-time Processing of Log Data with Subscriptions](https://docs.aws.amazon.com/AmazonCloudWatch/latest/logs/Subscriptions.html) in the *Amazon CloudWatch User Guide\.*

For example, you can configure a CloudWatch Log Group to monitor your gateway and get notified when your file gateway fails to upload files to an S3 bucket\. You can either configure the group when you are activating the gateway or after your gateway is activated and up and running\. For information about how to configure a CloudWatch Log Group when activating a gateway, see [Configuring Amazon CloudWatch logging](create-gateway-file.md#configure-loging-file)\. For general information about CloudWatch Log Groups, see [ Working with Log Groups and Log Streams](https://docs.aws.amazon.com/AmazonCloudWatch/latest/logs/Working-with-log-groups-and-streams.html) in the *Amazon CloudWatch User Guide\.*

The following is an example of an error reported by file gateway\.

```
{
    "severity": "ERROR",
    "bucket": "bucket-smb-share2",
    "roleArn": "arn:aws:iam::123456789012:role/my-bucket",
    "source": "share-E1A2B34C",
    "type": "InaccessibleStorageClass",
    "operation": "S3Upload",
    "key": "myFolder/myFile.text",
    "gateway": "sgw-B1D123D4",
    "timestamp": "1565740862516"
}
```

This error means that file gateway is unable to upload the object `myFolder/myFile.text` to S3 because it has transitioned out of the Amazon S3 Standard storage class to either Amazon S3 Glacier or S3 Glacier Deep Archive storage class\.

In the preceding gateway health log, these items specify the given information:
+ `source: share-E1A2B34C` indicates the file share that encountered this error\.
+ `"type": "InaccessibleStorageClass"` indicates the type of error that occurred\. In this case, this error was encountered when the gateway was trying to upload the specified object to Amazon S3 or read from Amazon S3\. However, in this case the object has transitioned to Amazon S3 Glacier\. The value of `"type"` can be any error that the file gateway encounters\. For a list of possible errors, see [Troubleshooting file gateway issues](troubleshooting-file-gateway-issues.md)\.
+  `"operation": "S3Upload" `indicates that this error occurred when the gateway was trying to upload this object to S3\.
+ `"key": "myFolder/myFile.text"` indicates the object that caused the failure\.
+ `gateway": "sgw-B1D123D4` indicates the file gateway that encountered this error\.
+ `"timestamp": "1565740862516"` indicate the time that the error occurred\.

 For information about how to troubleshoot and fix these types of errors, see [Troubleshooting file gateway issues](troubleshooting-file-gateway-issues.md)\.

### Configuring a CloudWatch Log Group After Your Gateway is Activated<a name="creat-cwlogroup"></a>

The following procedure shows you how to configure a CloudWatch Log Group after your gateway is activated\.

**To configure a CloudWatch Log Group to work with your file gateway**

1. Sign in to the AWS Management Console and open the AWS Storage Gateway console at [https://console\.aws\.amazon\.com/storagegateway/home](https://console.aws.amazon.com/storagegateway/)\.

1. Choose **Gateways** and choose the gateway that you want to configure the CloudWatch Log Group for\. 

1. For **Actions**, choose **Edit gateway information** or in the **Details** tab, next to **Logging**, under **Not Enabled**, choose **Configure log group** to open the **Edit gateway information** dialog box\. 

1. For **Gateway log group**, choose **Use an existing log group** and then choose the log group that you want to use\. If you don't have a log group, choose **Create a new log group** to create one\. You are directed to the CloudWatch Logs console where you can create the log group\. If you create a new log group, choose the refresh button to view the new log group in the drop down list\.

1. When you are done, choose **Save**\.

1. To see the logs for your gateway, choose the gateway and choose the **Details** tab\.

For information about how to troubleshoot errors, see [Troubleshooting file gateway issues](troubleshooting-file-gateway-issues.md)\.

## Using Amazon CloudWatch Metrics<a name="using-CloudWatch-metrics"></a>

You can get monitoring data for your file gateway by using either the AWS Management Console or the CloudWatch API\. The console displays a series of graphs based on the raw data from the CloudWatch API\. The CloudWatch API can also be used through one of the [Amazon AWS Software Development Kits \(SDKs\)](http://aws.amazon.com/tools) or the [Amazon CloudWatch API](http://aws.amazon.com/cloudwatch) tools\. Depending on your needs, you might prefer to use either the graphs displayed in the console or retrieved from the API\.

Regardless of which method you choose to use to work with metrics, you must specify the following information:
+ The metric dimension to work with\. A *dimension* is a name\-value pair that helps you to uniquely identify a metric\. The dimensions for Storage Gateway are `GatewayId` and `GatewayName`\. In the CloudWatch console, you can use the `Gateway Metrics` view to easily select gateway\-specific dimensions\. For more information about dimensions, see [Dimensions](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/cloudwatch_concepts.html#Dimension) in the *Amazon CloudWatch User Guide*\.
+ The metric name, such as `ReadBytes`\.

The following table summarizes the types of Storage Gateway metric data that are available to you\.


| Amazon CloudWatch Namespace | Dimension | Description | 
| --- | --- | --- | 
| AWS/StorageGateway |  GatewayId, GatewayName  |  These dimensions filter for metric data that describes aspects of the gateway\. You can identify a file gateway to work with by specifying both the `GatewayId` and the `GatewayName` dimensions\. Throughput and latency data of a gateway are based on all the file shares in the gateway\. Data is available automatically in 5\-minute periods at no charge\.   | 

Working with gateway and file metrics is similar to working with other service metrics\. You can find a discussion of some of the most common metrics tasks in the CloudWatch documentation listed following:
+ [Viewing Available Metrics](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/viewing_metrics_with_cloudwatch.html)
+ [Getting Statistics for a Metric](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/getting-metric-statistics.html)
+ [Creating CloudWatch Alarms](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/AlarmThatSendsEmail.html)

## Getting Notified About File Operations<a name="get-notification"></a>

AWS Storage Gateway can trigger CloudWatch Events when your file operations are done: 
+ You can get notified when the gateway finishes the asynchronous uploading of your files to your file share\. You can use the [NotifyWhenUploaded](https://docs.aws.amazon.com/storagegateway/latest/APIReference/API_NotifyWhenUploaded.html) API to request a file upload notification\.
+ You can get notified when the gateway finishes refreshing the cache for your S3 bucket\. When you invoke the [RefreshCache](https://docs.aws.amazon.com/storagegateway/latest/APIReference/API_RefreshCache.html) operation through the AWS Storage Gateway console or AWS Storage Gateway API, you can subscribe to the notification when the operation completes\.

When the file operation you requested is done, AWS Storage Gateway sends you notification through CloudWatch Events\. You can configure CloudWatch Events to send the notification through event targets such as Amazon SNS, Amazon SQS or AWS Lambda function\. For example, you can configure an Amazon SNS target, to send the notification Amazon SNS consumers such as email and text message\. For information about CloudWatch Events, see [What is Amazon CloudWatch Events?](https://docs.aws.amazon.com/AmazonCloudWatch/latest/events/WhatIsCloudWatchEvents.html)

**To set up CloudWatch Events notification**

1. Create a target such as an Amazon SNS topic or Lambda function to invoke when the event you requested in AWS Storage Gateway is triggered\.

1. Create a rule in the CloudWatch Events Console to invoke targets based on an event in AWS Storage Gateway\.

1. In the rule, create an event patten for the event type\. The notification is triggered when the event matches this rule pattern\.

1. Select the target and configure the settings\.

The following example shows a rule that triggers the specified event type in the specified gateway and in the specified AWS Region\. For example, you could specify the `Storage Gateway File Upload Event` as the event type\.

```
{
   "source":[
      "aws.storagegateway"
   ],
   "resources":[
      "arn:aws:storagegateway:AWS Region:account-id
                 :gateway/gateway-id"
   ],
   "detail-type":[
      "Event type"
   ]
}
```

For information about how to use CloudWatch Events to trigger rules, see [Creating a CloudWatch Events Rule That Triggers on an Event](https://docs.aws.amazon.com/AmazonCloudWatch/latest/events/Create-CloudWatch-Events-Rule.html) in the *Amazon CloudWatch Events User Guide*\.

### Getting File Upload Notification<a name="get-upload-notification"></a>

There are two use cases you could use the file upload notification for:

For automating in\-cloud processing of files that are uploaded, you could call the `NotifyWhenUploaded` API and get back a notification id\. The notification that is triggered when the files have been uploaded have the same notification id as the one that was returned by the API\. If you map this notification id to track the list of files that you are uploading, you could trigger processing of the files that are uploaded in AWS when the event with the same id is generated\.

For content distribution use cases, you could have two file gateways that map to the same Amazon S3 bucket\. The file share client for Gateway1 could upload new files to S3 and the files are read by file share clients on Gateway 2\. The files will upload to S3, but they will not be visible to Gateway2 because it uses a locally cached version of files in S3\. To make the files visible in gateway2, you can use the [NotifyWhenUploaded](https://docs.aws.amazon.com/storagegateway/latest/APIReference/API_NotifyWhenUploaded.html) API to request file upload notification from Gateway1 to notify you when the upload is done\. You can then use the CloudWatch Events to automatically issue [RefreshCache](https://docs.aws.amazon.com/storagegateway/latest/APIReference/API_RefreshCache.html) request for the file share on Gateway2\. When the [RefreshCache](https://docs.aws.amazon.com/storagegateway/latest/APIReference/API_RefreshCache.html) request completes the new files will be visible in Gateway2\.

**Example Example???File Upload Notification**  
The following example shows a file upload notification that is sent to you through CloudWatch when the event matches the rule you created\. This notification is in JSON format\. You can configure this notification to be delivered to the target as a text message\.  

```
{
    "version" : "2012-10-17",
    "id" : "2649b160-d59d-c97f-3f64-8aaa9ea6aed3",
    "detail-type" : "Storage Gateway Upload Notification Event",
    "source" : "aws.storagegateway",
    "account" : "123456789012",
    "time" : "2017-11-06T21:34:42Z",
    "region" : "us-east-2",
    "resources" : [
        "arn:aws:storagegateway:us-east-2:123456789011:share/share-F123D451",
        "arn:aws:storagegateway:us-east-2:123456789011:gateway/sgw-712345DA"
        ],
    "detail" : {
                "event-type" :"upload-complete",
                "notification-id": "11b3106b-a18a-4890-9d47-a1a755ef5e47",
                "request-received" : "2018-02-06T21:34:42Z",
                "completed" : "2018-02-06T21:34:53Z"}
}
```


| Field names | Description | 
| --- | --- | 
| version | The current version of the IAM policy\. | 
| id | The ID that identifies the IAM policy\. | 
| detail\-type | A description of the of the event that triggered the notification that was sent\. | 
| source | The AWS service that is the source of the request and notification\. | 
| account | The id of the AWS account where the request and notification were generated from\. | 
| time | When the request to upload files to Amazon S3 was made\. | 
| region | The AWS Region where the request and notification was sent from\. | 
| resources | The storage gateway resources that the policy applies to\. | 
| source | The AWS service that is the source of the request and the notification\. | 
| event\-type | The CloudWatch Events that triggered the notification\. | 
| notification\-id | The randomly generated ID of the notification that was sent\. This ID is in UUID format\. This is the notification ID that is returned when `NotfyWhenUploaded` is called\. | 
| request\-received | When the gateway received the `NotfyWhenUploaded` request\. | 
| completed | When all the files in the working\-set were uploaded to Amazon S3\. | 

### Getting Refresh Cache Notification<a name="get-refresh-cache-notification"></a>

For refresh cache notification use case, you could have two file gateways that map to the same Amazon S3 bucket and the NFS client for Gateway1 uploads new files to the S3 bucket\. The files will upload to S3, but they will not appear in Gateway2 until you refresh the cache\. This is because Gateway2 uses a locally cached version of the files in S3\. You might want to do something with the files in Gateway2 when the refresh cache is done\. Large files could take a while to show up in Gateway2 so you might want to be notified when the cache refresh is done\. You can request refresh cache notification from Gateway2 to notify you when all the files are visible in Gateway2\.

**Example Example???Refresh Cache Notification**  
The following example shows a refresh cache notification that is sent to you through CloudWatch when the event matches the rule you created\. This notification is in JSON format\. You can configure this notification to be delivered to the target as a text message\.  

```
{
	"version": "2012-10-17",
	"id": "2649b160-d59d-c97f-3f64-8aaa9ea6aed3",
	"detail-type": "Storage Gateway Refresh Cache Event",
	"source": "aws.storagegateway",
	"account": "209870788375",
	"time": "2017-11-06T21:34:42Z",
	"region": "us-east-2",
	"resources": [
		"arn:aws:storagegateway:us-east-2:123456789011:share/share-F123D451",
		"arn:aws:storagegateway:us-east-2:123456789011:gateway/sgw-712345DA"
	],
	"detail": {
        "event-type": "refresh-complete",
        "notification-id": "1c14106b-a18a-4890-9d47-a1a755ef5e47",
        "started": "2018-02-06T21:34:42Z",
        "completed": "2018-02-06T21:34:53Z",
        "folderList": ["/"]
    },
}
```


| Field names | Description | 
| --- | --- | 
| version | The current version of the IAM policy\. | 
| id | The ID that identifies the IAM policy\. | 
| time | When the request to refresh the files in working\-set was made\. | 
| detail\-type | A description of the type of the event that triggered notification that was sent\. | 
| source | The AWS service that is the source of the request and notification\. | 
| account | The id of the AWS account where the request and notification were generated from\. | 
| source | The AWS service that is the source of the request and the notification\. | 
| event\-type | The CloudWatch Events that triggered the notification\. | 
| notification\-id | The randomly generated ID of the notification that was sent\. This ID is in UUID format\. This is the notification ID that is returned when you call `RefreshCache`\. | 
| started | when the gateway received the `RefreshCache` request and the refresh was started\.\. | 
| completed | When the refresh of the working\-set was completed\. | 
| folderList | A comma\-separated list of the paths of folders that were refreshed in the cache\. The default is \["/"\]\. | 

## Understanding File Share Metrics<a name="monitoring-fileshare"></a>

You can find information following about the AWS Storage Gateway metrics that cover file shares\. Each file share has a set of metrics associated with it\. Some file share\-specific metrics have the same name as certain gateway\-specific metrics\. These metrics represent the same kinds of measurements, but are scoped to the file share instead\. Always specify whether you want to work with either a gateway or a file share metric before working with a metric\. Specifically, when working with file share metrics, you must specify the `File share ID` that identifies the file share for which you are interested in viewing metrics\. For more information, see [Using Amazon CloudWatch Metrics](#using-CloudWatch-metrics)\.

The following table describes the Storage Gateway metrics that you can use to get information about your file shares\.


| Metric | Description | 
| --- | --- | 
| CacheHitPercent |  Percent of application read operations from the file shares that are served from cache\. The sample is taken at the end of the reporting period\. When there are no application read operations from the file share, this metric reports 100 percent\.  Units: Percent  | 
| CachePercentDirty |  The file share's contribution to the overall percentage of the gateway's cache that has not been persisted to AWS\. The sample is taken at the end of the reporting period\. Use the `CachePercentDirty` metric of the gateway to view the overall percentage of the gateway's cache that has not been persisted to AWS\. For more information, see [Understanding gateway metrics](Main_monitoring-gateways-common.md#MonitoringGateways-common)\. Units: Percent  | 
| CachePercentUsed |  The file share's contribution to the overall percent use of the gateway's cache storage\. The sample is taken at the end of the reporting period\. Use the `CachePercentUsed` metric of the gateway to view overall percent use of the gateway's cache storage\. For more information, see [Understanding gateway metrics](Main_monitoring-gateways-common.md#MonitoringGateways-common)\. Units: Percent  | 
| CloudBytesUploaded |  The total number of bytes that the gateway uploaded to AWS during the reporting period\.  Use this metric with the `Sum` statistic to measure throughput and with the `Samples` statistic to measure IOPS\.  Units: Bytes  | 
| CloudBytesDownloaded |  The total number of bytes that the gateway downloaded from AWS during the reporting period\.  Use this metric with the `Sum` statistic to measure throughput and with the `Samples` statistic to measure input/output operations per second \(IOPS\)\. Units: Bytes  | 
| ReadBytes  |  The total number of bytes read from your on\-premises applications in the reporting period for a file share\. Use this metric with the `Sum` statistic to measure throughput and with the `Samples` statistic to measure IOPS\. Units: Bytes  | 
| WriteBytes |  The total number of bytes written to your on\-premises applications in the reporting period\. Use this metric with the `Sum` statistic to measure throughput and with the `Samples` statistic to measure IOPS\. Units: Bytes  | 

## Understanding File Gateway Audit Logs<a name="audit-logs"></a>

File gateway audit logs provide you with details about user access to files and folders within a SMB file share\. You can use them to monitor user activities and take action if inappropriate activity patterns are identified\.

The following table describes the file gateway audit log file access operations\.


| Operation name | Definition | 
| --- | --- | 
| Read Data | Read the content of a file\. | 
| Write Data | Change the content of a file\. | 
| Create | Create a new file or folder\. | 
| Rename | Rename an existing file or folder\. | 
| Delete | Delete a file or folder\. | 
| Write Attributes | Update file or folder metadata \(ACLs, owner, group, permissions\)\. | 

The following table describes the file gateway audit log file access attributes\.


| Attribute | Definition | 
| --- | --- | 
| securityDescriptor | Shows the discretionary access control list \(DACL\) set on an object, in SDDL format\. | 
| sourceAddress | The IP address of file share client machine\. | 
| accountDomain | The Active Directory \(AD\) domain that the client???s account belongs to\. | 
| accountName | The AD user name of the client\. | 
| groupid | The identifier of the group the user account belongs to\. | 
| source | The ID of the file share being audited\. | 
| ownerId | The identifier for the owner of the object\. | 
| accessMode | The permission setting for the object\. | 
| mtime | This time that the object's content was modified, set by the client\. | 
| version | The version of the audit log format\. | 
| objectType | Defines whether the object is a file or folder\. | 
| bucket | The S3 bucket name\. | 
| objectName | The full path to the object\. | 
| ctime | The time that the object???s content or metadata was modified, set by the client\. | 
| shareName | The name of the share that is being accessed\. | 
| operation | The name of the object access operation\. | 
| newObjectName | The full path to the new object after it has been renamed\. | 
| gateway | The Storage Gateway ID\. | 
| timestamp | The time that the operation occurred based on the OS timestamp of the gateway\. | 
| status | The status of the operation\. Only success is logged \(failures are logged with the exception of failures arising from Permissions Denied\)\. | 
| fileSizeInBytes | The size of the file in bytes, set by the client at file creation time\. | 

The following table describes the file gateway audit log attributes logged in each file access operation\.


|  | Read Data | Write Data | Create Folder | Create File | Rename File/Folder | Delete File/Folder | Write Attributes \(Change ACL\) | Write Attributes \(Chown\) | Write Attributes \(Chmod\) | Write Attributes \(Chgrp\) | 
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | 
| securityDescriptor |  |  |  |  |  |  | X |  |  |  | 
| sourceAddress | X | X | X | X | X | X | X | X | X | X | 
| accountDomain | X | X | X | X | X | X | X | X | X | X | 
| accountName | X | X | X | X | X | X | X | X | X | X | 
| groupid |  |  | X | X |  |  |  |  |  | X | 
| source | X | X | X | X | X | X | X | X | X | X | 
| ownerId |  |  | X | X |  |  |  | X |  |  | 
| accessMode |  |  | X | X |  |  |  |  | X |  | 
| mtime |  |  | X | X |  |  |  |  |  |  | 
| version | X | X | X | X | X | X | X | X | X | X | 
| objectType | X | X | X | X | X | X | X | X | X | X | 
| bucket | X | X | X | X | X | X | X | X | X | X | 
| objectName | X | X | X | X | X | X | X | X | X | X | 
| ctime |  |  | X | X |  |  |  |  |  |  | 
| shareName | X | X | X | X | X | X | X | X | X | X | 
| operation | X | X | X | X | X | X | X | X | X | X | 
| newObjectName |  |  |  |  | X |  |  |  |  |  | 
| gateway | X | X | X | X | X | X | X | X | X | X | 
| timestamp | X | X | X | X | X | X | X | X | X | X | 
| status | X | X | X | X | X | X | X | X | X | X | 
| fileSizeInBytes |  |  |  | X |  |  |  |  |  |  | 