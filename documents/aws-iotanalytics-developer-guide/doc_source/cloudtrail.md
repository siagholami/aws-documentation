# Logging AWS IoT Analytics API calls with AWS CloudTrail<a name="cloudtrail"></a>

AWS IoT Analytics is integrated with AWS CloudTrail, a service that provides a record of actions taken by a user, role, or an AWS service in AWS IoT Analytics\. CloudTrail captures a subset of API calls for AWS IoT Analytics as events, including calls from the AWS IoT Analytics console and from code calls to the AWS IoT Analytics APIs\. If you create a trail, you can enable continuous delivery of CloudTrail events to an Amazon S3 bucket, including events for AWS IoT Analytics\. If you don't configure a trail, you can still view the most recent events in the CloudTrail console in **Event history**\. Using the information collected by CloudTrail, you can determine the request that was made to AWS IoT Analytics, the IP address from which the request was made, who made the request, when it was made, and additional details\.

To learn more about CloudTrail, see the [AWS CloudTrail User Guide](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-user-guide.html)\.

## AWS IoT Analytics information in AWS CloudTrail<a name="aws-iotanalytics-info-in-cloudtrail"></a>

CloudTrail is enabled on your AWS account when you create the account\. When activity occurs in AWS IoT Analytics, that activity is recorded in a CloudTrail event along with other AWS service events in **Event history**\. You can view, search, and download recent events in your AWS account\. For more information, see [Viewing events with CloudTrail event history](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/view-cloudtrail-events.html)\.

For an ongoing record of events in your AWS account, including events for AWS IoT Analytics, create a trail\. A trail enables CloudTrail to deliver log files to an Amazon S3 bucket\. By default, when you create a trail in the console, the trail applies to all regions\. The trail logs events from all regions in the AWS partition and delivers the log files to the Amazon S3 bucket that you specify\. Additionally, you can configure other AWS services to further analyze and act upon the event data collected in CloudTrail logs\. For more information, see:
+ [Overview for creating a trail](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-create-and-update-a-trail.html)
+ [ CloudTrail supported services and integrations](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-aws-service-specific-topics.html#cloudtrail-aws-service-specific-topics-integrations)
+ [Configuring Amazon SNS notifications for CloudTrail](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/configure-sns-notifications-for-cloudtrail.html)
+ [Receiving CloudTrail log files from multiple regions](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/receive-cloudtrail-log-files-from-multiple-regions.html) and [Receiving CloudTrail log files from multiple accounts](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-receive-logs-from-multiple-accounts.html)

AWS IoT Analytics supports logging the following actions as events in CloudTrail log files:
+ [CancelPipelineReprocessing](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-cancelpipelinereprocessing)
+ [CreateChannel](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-createchannel)
+ [CreateDataset](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-createdataset)
+ [CreateDatasetContent](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-createdatasetcontent)
+ [CreateDatastore](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-createdatastore)
+ [CreatePipeline](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-createpipeline)
+ [DeleteChannel](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-deletechannel)
+ [DeleteDataset](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-deletedataset)
+ [DeleteDatasetContent](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-deletedatasetcontent)
+ [DeleteDatastore](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-deletedatastore)
+ [DeletePipeline](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-deletepipeline)
+ [DescribeChannel](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-describechannel)
+ [DescribeDataset](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-describedataset)
+ [DescribeDatastore](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-describedatastore)
+ [DescribeLoggingOptions](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-describeloggingoptions)
+ [DescribePipeline](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-describepipeline)
+ [GetDatasetContent](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-getdatasetcontent)
+ [ListChannels](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-listchannels)
+ [ListDatasets](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-listdatasets)
+ [ListDatastores](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-listdatastores)
+ [ListPipelines](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-listpipelines)
+ [PutLoggingOptions](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-putloggingoptions)
+ [RunPipelineActivity](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-runpipelineactivity)
+ [SampleChannelData](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-samplechanneldata)
+ [StartPipelineReprocessing](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-startpipelinereprocessing)
+ [UpdateChannel](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-updatechannel)
+ [UpdateDataset](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-updatedataset)
+ [UpdateDatastore](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-updatedatastore)
+ [UpdatePipeline](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-updatepipeline)

Every event or log entry contains information about who generated the request\. The identity information helps you determine the following:
+ Whether the request was made with root or AWS Identity and Access Management user credentials\.
+ Whether the request was made with temporary security credentials for a role or federated user\.
+ Whether the request was made by another AWS service\.

For more information, see the [CloudTrail userIdentity element](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-event-reference-user-identity.html)\.

## Understanding AWS IoT Analytics log file entries<a name="understanding-aws-iotanalytics-entries"></a>

A trail is a configuration that enables delivery of events as log files to an S3 bucket that you specify\. CloudTrail log files contain one or more log entries\. An event represents single request from any source and includes information about the requested action, the date and time of the action, request parameters, and so on\. CloudTrail log files are not an ordered stack trace of the public API calls, so they do not appear in any specific order\.

The following example shows a CloudTrail log entry that demonstrates the `CreateChannel` action\.

```
{
    "eventVersion": "1.05",
    "userIdentity": {
        "type": "AssumedRole",
        "principalId": "ABCDE12345FGHIJ67890B:AnalyticsChannelTestFunction",
        "arn": "arn:aws:sts::123456789012:assumed-role/AnalyticsRole/AnalyticsChannelTestFunction",
        "accountId": "123456789012",
        "accessKeyId": "ABCDE12345FGHIJ67890B",
        "sessionContext": {
            "attributes": {
                "mfaAuthenticated": "false",
                "creationDate": "2018-02-14T23:43:12Z"
            },
            "sessionIssuer": {
                "type": "Role",
                "principalId": "ABCDE12345FGHIJ67890B",
                "arn": "arn:aws:iam::123456789012:role/AnalyticsRole",
                "accountId": "123456789012",
                "userName": "AnalyticsRole"
            }
        }
    },
    "eventTime": "2018-02-14T23:55:14Z",
    "eventSource": "iotanalytics.amazonaws.com",
    "eventName": "CreateChannel",
    "awsRegion": "us-east-1",
    "sourceIPAddress": "198.162.1.0",
    "userAgent": "aws-internal/3 exec-env/AWS_Lambda_java8",
    "requestParameters": {
        "channelName": "channel_channeltest"
    },
    "responseElements": {
        "retentionPeriod": {
            "unlimited": true
        },
        "channelName": "channel_channeltest",
        "channelArn": "arn:aws:iotanalytics:us-east-1:123456789012:channel/channel_channeltest"
    },
    "requestID": "7f871429-11e2-11e8-9eee-0781b5c0ac59",
    "eventID": "17885899-6977-41be-a6a0-74bb95a78294",
    "eventType": "AwsApiCall",
    "recipientAccountId": "123456789012"
}
```

The following example shows a CloudTrail log entry that demonstrates the `CreateDataset` action\.

```
{
    "eventVersion": "1.05",
    "userIdentity": {
        "type": "AssumedRole",
        "principalId": "ABCDE12345FGHIJ67890B:AnalyticsDatasetTestFunction",
        "arn": "arn:aws:sts::123456789012:assumed-role/AnalyticsRole/AnalyticsDatasetTestFunction",
        "accountId": "123456789012",
        "accessKeyId": "ABCDE12345FGHIJ67890B",
        "sessionContext": {
            "attributes": {
                "mfaAuthenticated": "false",
                "creationDate": "2018-02-14T23:41:36Z"
            },
            "sessionIssuer": {
                "type": "Role",
                "principalId": "ABCDE12345FGHIJ67890B",
                "arn": "arn:aws:iam::123456789012:role/AnalyticsRole",
                "accountId": "123456789012",
                "userName": "AnalyticsRole"
            }
        }
    },
    "eventTime": "2018-02-14T23:53:39Z",
    "eventSource": "iotanalytics.amazonaws.com",
    "eventName": "CreateDataset",
    "awsRegion": "us-east-1",
    "sourceIPAddress": "198.162.1.0",
    "userAgent": "aws-internal/3 exec-env/AWS_Lambda_java8",
    "requestParameters": {
        "datasetName": "dataset_datasettest"
    },
    "responseElements": {
        "datasetArn": "arn:aws:iotanalytics:us-east-1:123456789012:dataset/dataset_datasettest",
        "datasetName": "dataset_datasettest"
    },
    "requestID": "46ee8dd9-11e2-11e8-979a-6198b668c3f0",
    "eventID": "5abe21f6-ee1a-48ef-afc5-c77211235303",
    "eventType": "AwsApiCall",
    "recipientAccountId": "123456789012"
}
```
