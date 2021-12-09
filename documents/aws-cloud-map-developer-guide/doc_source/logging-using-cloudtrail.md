# Logging AWS Cloud Map API Calls with AWS CloudTrail<a name="logging-using-cloudtrail"></a>

AWS Cloud Map is integrated with AWS CloudTrail, a service that provides a record of the actions that are taken by a user, a role, or an AWS service in AWS Cloud Map\. CloudTrail captures all API calls for most AWS Cloud Map API actions as events\. This includes calls from the AWS Cloud Map console and all programmatic access, such as the AWS Cloud Map API and AWS SDKs\. \(CloudTrail doesn't capture calls to the AWS Cloud Map [DiscoverInstances](https://docs.aws.amazon.com/cloud-map/latest/api/API_DiscoverInstances.html) API\.\) 

If you create a trail, you can enable continuous delivery of CloudTrail events to an Amazon S3 bucket, including events for AWS Cloud Map\. If you don't configure a trail, you can still view the most recent events in the CloudTrail console in **Event history**\. Using the information collected by CloudTrail, you can determine the request that was made to AWS Cloud Map, the IP address that the request was made from, who made the request, when it was made, and additional details\. 

**Topics**
+ [AWS Cloud Map Information in CloudTrail](#cloud-map-info-in-cloudtrail)
+ [Viewing AWS Cloud Map Events in Event History](#cloud-map-events-in-cloudtrail-event-history)
+ [Understanding AWS Cloud Map Log File Entries](#understanding-cloud-map-entries-in-cloudtrail)

## AWS Cloud Map Information in CloudTrail<a name="cloud-map-info-in-cloudtrail"></a>

CloudTrail is enabled on your AWS account when you create the account\. When activity occurs in AWS Cloud Map, that activity is recorded in a CloudTrail event along with other AWS service events in **Event history**\. You can view, search, and download recent events in your AWS account\. For more information, see [Viewing Events with CloudTrail Event History](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/view-cloudtrail-events.html)\. 

For an ongoing record of events in your AWS account, including events for AWS Cloud Map, create a trail\. A trail enables CloudTrail to deliver log files to an Amazon S3 bucket\. By default, when you create a trail in the console, the trail applies to all AWS Regions\. The trail logs events from all Regions in the AWS partition and delivers the log files to the Amazon S3 bucket that you specify\. Additionally, you can configure other AWS services to further analyze and act upon the event data collected in CloudTrail logs\. For more information, see the following topics: 
+ [Overview for Creating a Trail](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-create-and-update-a-trail.html)
+ [CloudTrail Supported Services and Integrations](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-aws-service-specific-topics.html#cloudtrail-aws-service-specific-topics-integrations)
+ [Configuring Amazon SNS Notifications for CloudTrail](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/getting_notifications_top_level.html)
+ [Receiving CloudTrail Log Files from Multiple Regions](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/receive-cloudtrail-log-files-from-multiple-regions.html) and [Receiving CloudTrail Log Files from Multiple Accounts](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-receive-logs-from-multiple-accounts.html)

Most AWS Cloud Map actions are logged by CloudTrail and are documented in the [AWS Cloud Map API Reference](https://docs.aws.amazon.com/cloud-map/latest/api/)\. For example, calls to the `CreateHttpNamespace`, `DeleteService`, and `RegisterInstance` actions generate entries in the CloudTrail log files\. \(CloudTrail doesn't capture calls to the AWS Cloud Map [DiscoverInstances](https://docs.aws.amazon.com/cloud-map/latest/api/API_DiscoverInstances.html) API\.\)

Every event or log entry contains information about who generated the request\. The identity information helps you determine the following: 
+ Whether the request was made with root or IAM user credentials\.
+ Whether the request was made with temporary security credentials for a role or federated user\.
+ Whether the request was made by another AWS service\.

For more information, see the [CloudTrail userIdentity Element](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-event-reference-user-identity.html)\.

## Viewing AWS Cloud Map Events in Event History<a name="cloud-map-events-in-cloudtrail-event-history"></a>

CloudTrail lets you view recent events in **Event history**\. To view events for AWS Cloud Map API requests, you must choose the AWS Region where you created your namespaces in the Region selector at the top of the console\. If you created namespaces in multiple AWS Regions, you must view the events for each Region separately\. For more information, see [Viewing Events with CloudTrail Event History](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/view-cloudtrail-events.html) in the *AWS CloudTrail User Guide*\.

## Understanding AWS Cloud Map Log File Entries<a name="understanding-cloud-map-entries-in-cloudtrail"></a>

A trail is a configuration that enables delivery of events as log files to an Amazon S3 bucket that you specify\. CloudTrail log files contain one or more log entries\. An event represents a single request from any source and includes information about the requested action, the date and time of the action, request parameters, and so on\. CloudTrail log files are not an ordered stack trace of the public API calls, so they do not appear in any specific order\. 

The `eventName` element identifies the action that occurred\. CloudTrail supports all AWS Cloud Map API actions\. The following example shows a CloudTrail log entry for `CreatePublicDnsNamespace`\.

```
{
    "Records": [
        {
            "eventVersion": "1.05",
            "userIdentity": {
                "type": "IAMUser",
                "principalId": "A1B2C3D4E5F6G7EXAMPLE",
                "arn": "arn:aws:iam::111122223333:user/smithj",
                "accountId": "111122223333",
                "accessKeyId": "AKIAIOSFODNN7EXAMPLE",
                "userName": "smithj"
            },
            "eventTime": "2018-01-16T00:44:17Z",
            "eventSource": "servicediscovery.amazonaws.com",
            "eventName": "CreatePublicDnsNamespace",
            "awsRegion": "us-west-2",
            "sourceIPAddress": "192.0.2.92",
            "userAgent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.12; rv:52.0) Gecko/20100101 Firefox/52.0",
            "requestParameters": {
                "description": "test",
                "creatorRequestId": "1234567890123456789",
                "name": "example.com"
            },
            "responseElements": {
                "operationId": "unmipghn37443trlkgpf4idvvitec6fw-2example"
            },
            "requestID": "35e1872d-c0dc-11e7-99e1-03e9fexample",
            "eventID": "409b4d91-34e6-41ee-bd97-a816dexample",
            "eventType": "AwsApiCall",
            "recipientAccountId": "444455556666"
        }
    ]
}
```