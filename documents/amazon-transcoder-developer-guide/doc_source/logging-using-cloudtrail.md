# Logging Elastic Transcoder API Calls with AWS CloudTrail<a name="logging-using-cloudtrail"></a>

Elastic Transcoder is integrated with AWS CloudTrail, a service that provides a record of actions taken by a user, role, or an AWS service in Elastic Transcoder\. CloudTrail captures all API calls for Elastic Transcoder as events, including calls from the Elastic Transcoder console and from code calls to the Elastic Transcoder APIs\. If you create a trail, you can enable continuous delivery of CloudTrail events to an Amazon S3 bucket, including events for Elastic Transcoder\. If you don't configure a trail, you can still view the most recent events in the CloudTrail console in **Event history**\. Using the information collected by CloudTrail, you can determine the request that was made to Elastic Transcoder, the IP address from which the request was made, who made the request, when it was made, and additional details\. 

To learn more about CloudTrail, see the [AWS CloudTrail User Guide](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/)\.

## Elastic Transcoder Information in CloudTrail<a name="service-name-info-in-cloudtrail"></a>

CloudTrail is enabled on your AWS account when you create the account\. When activity occurs in Elastic Transcoder, that activity is recorded in a CloudTrail event along with other AWS service events in **Event history**\. You can view, search, and download recent events in your AWS account\. For more information, see [Viewing Events with CloudTrail Event History](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/view-cloudtrail-events.html)\. 

For an ongoing record of events in your AWS account, including events for Elastic Transcoder, create a trail\. A trail enables CloudTrail to deliver log files to an Amazon S3 bucket\. By default, when you create a trail in the console, the trail applies to all regions\. The trail logs events from all regions in the AWS partition and delivers the log files to the Amazon S3 bucket that you specify\. Additionally, you can configure other AWS services to further analyze and act upon the event data collected in CloudTrail logs\. For more information, see: 
+ [Overview for Creating a Trail](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-create-and-update-a-trail.html)
+ [CloudTrail Supported Services and Integrations](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-aws-service-specific-topics.html#cloudtrail-aws-service-specific-topics-integrations)
+ [Configuring Amazon SNS Notifications for CloudTrail](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/getting_notifications_top_level.html)
+ [Receiving CloudTrail Log Files from Multiple Regions](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/receive-cloudtrail-log-files-from-multiple-regions.html) and [Receiving CloudTrail Log Files from Multiple Accounts](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-receive-logs-from-multiple-accounts.html)

All Elastic Transcoder actions are logged by CloudTrail and are documented in the [API Reference](api-reference.md)\. For example, calls to the `CreatePipeline`, `CreateJob`, and `CreatePreset` sections generate entries in the CloudTrail log files\. 

Every event or log entry contains information about who generated the request\. The identity information helps you determine the following: 
+ Whether the request was made with root or IAM user credentials\.
+ Whether the request was made with temporary security credentials for a role or federated user\.
+ Whether the request was made by another AWS service\.

For more information, see the [CloudTrail userIdentity Element](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-event-reference-user-identity.html)\.

## Understanding Elastic Transcoder Log File Entries<a name="understanding-service-name-entries"></a>

A trail is a configuration that enables delivery of events as log files to an Amazon S3 bucket that you specify\. CloudTrail log files contain one or more log entries\. An event represents a single request from any source and includes information about the requested action, the date and time of the action, request parameters, and so on\. CloudTrail log files are not an ordered stack trace of the public API calls, so they do not appear in any specific order\. 

The following example shows a CloudTrail log entry that demonstrates the `CreateJob`, `ListJobsByStatus`, `ReadJob`, `DeletePreset`, and `DeletePipeline` actions\.

```
{
    "Records": [
        {
            "eventVersion": "1.02",
            "userIdentity": {
                "type": "IAMUser",
                "principalId": "A1B2C3D4E5F6G7EXAMPLE",
                "arn": "arn:aws:iam::111122223333:user/smithj",
                "accountId": "111122223333",
                "accessKeyId": "AKIAIOSFODNN7EXAMPLE"
            },
            "eventTime": "2014-09-29T19:29:02Z",
            "eventSource": "elastictranscoder.amazonaws.com",
            "eventName": "CreateJob",
            "awsRegion": "us-east-2",
            "sourceIPAddress": "192.0.2.17",
            "userAgent": "aws-sdk-ruby/1.39.0 ruby/1.9.3 x86_64-linux",
            "requestParameters": {
                "input": {
                    "interlaced": "auto",
                    "resolution": "auto",
                    "frameRate": "auto",
                    "aspectRatio": "auto",
                    "container": "auto",
                    "key": "source/audio/cheesytoast.wav"
                },
                "output": {
                    "presetId": "1234-preset-example",
                    "key": "output/testing-toast.mp4",
                    "thumbnailPattern": "",
                    "rotate": "auto"
                },
                "pipelineId": "1234-pipeline-example"
            },
            "responseElements": {
                "job": {
                    "output": {
                        "rotate": "auto",
                        "presetId": "1234-preset-example",
                        "thumbnailPattern": "",
                        "watermarks": [],
                        "id": "1",
                        "key": "output/testing-toast.mp4",
                        "status": "Submitted"
                    },
                    "status": "Submitted",
                    "playlists": [],
                    "arn": "arn:aws:elastictranscoder:us-east-2:111122223333:job/1234-job-example",
                    "id": "1234-job-example",
                    "outputs": [
                        {
                            "rotate": "auto",
                            "presetId": "1234-preset-example",
                            "thumbnailPattern": "",
                            "watermarks": [],
                            "id": "1",
                            "key": "output/testing-toast.mp4",
                            "status": "Submitted"
                        }
                    ],
                    "pipelineId": "1234-pipeline-example",
                    "input": {
                        "interlaced": "auto",
                        "resolution": "auto",
                        "frameRate": "auto",
                        "aspectRatio": "auto",
                        "container": "auto",
                        "key": "source/audio/cheesytoast.wav"
                    }
                }
            },
            "requestID": "4e6b66f9-d548-11e3-a8a9-73e33example",
            "eventID": "5ab02562-0fc5-43d0-b7b6-90293example",
            "eventType": "AwsApiCall",
            "recipientAccountId": "111122223333"
        },
        {
            "eventVersion": "1.02",
            "userIdentity": {
                "type": "IAMUser",
                "principalId": "A1B2C3D4E5F6G7EXAMPLE",
                "arn": "arn:aws:iam::111122223333:user/smithj",
                "accountId": "111122223333",
                "accessKeyId": "AKIAIOSFODNN7EXAMPLE"
            },
            "eventTime": "2014-09-29T19:29:18Z",
            "eventSource": "elastictranscoder.amazonaws.com",
            "eventName": "ListJobsByStatus",
            "awsRegion": "us-east-2",
            "sourceIPAddress": "192.0.2.17",
            "userAgent": "aws-sdk-ruby/1.39.0 ruby/1.9.3 x86_64-linux",
            "requestParameters": {
                "status": "Submitted",
                "ascending": "false"
            },
            "responseElements": null,
            "requestID": "52de9f97-d548-11e3-8fb9-4dad0example",
            "eventID": "eb91f423-6dd3-4bb0-a148-3cdfbexample",
            "eventType": "AwsApiCall",
            "recipientAccountId": "111122223333"
        },
        {
            "eventVersion": "1.02",
            "userIdentity": {
                "type": "IAMUser",
                "principalId": "A1B2C3D4E5F6G7EXAMPLE",
                "arn": "arn:aws:iam::111122223333:user/smithj",
                "accountId": "111122223333",
                "accessKeyId": "AKIAIOSFODNN7EXAMPLE"
            },
            "eventTime": "2014-09-29T19:28:50Z",
            "eventSource": "elastictranscoder.amazonaws.com",
            "eventName": "ReadJob",
            "awsRegion": "us-east-2",
            "sourceIPAddress": "192.0.2.17",
            "userAgent": "aws-sdk-ruby/1.39.0 ruby/1.9.3 x86_64-linux",
            "requestParameters": {
                "id": "1412018849233-f2czlr"
            },
            "responseElements": null,
            "requestID": "497b3622-d548-11e3-8fb9-4dad0example",
            "eventID": "c32289c7-005a-46f7-9801-cba41example",
            "eventType": "AwsApiCall",
            "recipientAccountId": "111122223333"
        },
        {
            "eventVersion": "1.02",
            "userIdentity": {
                "type": "IAMUser",
                "principalId": "A1B2C3D4E5F6G7EXAMPLE",
                "arn": "arn:aws:iam::111122223333:user/smithj",
                "accountId": "111122223333",
                "accessKeyId": "AKIAIOSFODNN7EXAMPLE"
            },
            "eventTime": "2014-09-29T19:29:18Z",
            "eventSource": "elastictranscoder.amazonaws.com",
            "eventName": "DeletePreset",
            "awsRegion": "us-east-2",
            "sourceIPAddress": "192.0.2.17",
            "userAgent": "aws-sdk-ruby/1.39.0 ruby/1.9.3 x86_64-linux",
            "requestParameters": {
                "id": "1234-preset-example"
            },
            "responseElements": null,
            "requestID": "4e200613-d548-11e3-a8a9-73e33example",
            "eventID": "191ebb93-66b7-4517-a741-92b0eexample",
            "eventType": "AwsApiCall",
            "recipientAccountId": "111122223333"
        },
        {
            "eventVersion": "1.02",
            "userIdentity": {
                "type": "IAMUser",
                "principalId": "A1B2C3D4E5F6G7EXAMPLE",
                "arn": "arn:aws:iam::111122223333:user/smithj",
                "accountId": "111122223333",
                "accessKeyId": "AKIAIOSFODNN7EXAMPLE"
            },
            "eventTime": "2014-09-29T19:29:01Z",
            "eventSource": "elastictranscoder.amazonaws.com",
            "eventName": "DeletePipeline",
            "awsRegion": "us-east-2",
            "sourceIPAddress": "192.0.2.17",
            "userAgent": "aws-sdk-ruby/1.39.0 ruby/1.9.3 x86_64-linux",
            "requestParameters": {
                "id": "1412018848038-nkomx0"
            },
            "responseElements": null,
            "requestID": "42ca4299-d548-11e3-8fb9-4dad0example",
            "eventID": "7aeb434f-eb55-4e2a-82d8-417d5example",
            "eventType": "AwsApiCall",
            "recipientAccountId": "111122223333"
        },
    ]
}
```