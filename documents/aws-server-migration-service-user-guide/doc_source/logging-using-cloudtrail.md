# Logging AWS Server Migration Service API calls using AWS CloudTrail<a name="logging-using-cloudtrail"></a>

AWS Server Migration Service is integrated with AWS CloudTrail, a service that provides a record of actions taken by a user, role, or an AWS service in AWS SMS\. CloudTrail captures all API calls for AWS SMS as events\. The calls captured include calls from the AWS SMS console and code calls to the AWS SMS API operations\. If you create a trail, you can enable continuous delivery of CloudTrail events to an Amazon S3 bucket, including events for AWS SMS\. If you don't configure a trail, you can still view the most recent events in the CloudTrail console in **Event history**\. Using the information collected by CloudTrail, you can determine the request that was made to AWS SMS, the IP address from which the request was made, who made the request, when it was made, and additional details\. 

For more information, see the [AWS CloudTrail User Guide](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/)\.

## AWS SMS information in CloudTrail<a name="service-name-info-in-cloudtrail"></a>

CloudTrail is enabled on your AWS account when you create the account\. When activity occurs in AWS SMS, that activity is recorded in a CloudTrail event along with other AWS service events in **Event history**\. You can view, search, and download recent events in your AWS account\. For more information, see [Viewing Events with CloudTrail Event History](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/view-cloudtrail-events.html)\. 

For an ongoing record of events in your AWS account, including events for AWS SMS, create a trail\. A *trail* enables CloudTrail to deliver log files to an Amazon S3 bucket\. By default, when you create a trail in the console, the trail applies to all AWS Regions\. The trail logs events from all Regions in the AWS partition and delivers the log files to the Amazon S3 bucket that you specify\. Additionally, you can configure other AWS services to further analyze and act upon the event data collected in CloudTrail logs\. For more information, see the following: 
+ [Overview for Creating a Trail](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-create-and-update-a-trail.html)
+ [CloudTrail Supported Services and Integrations](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-aws-service-specific-topics.html#cloudtrail-aws-service-specific-topics-integrations)
+ [Configuring Amazon SNS Notifications for CloudTrail](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/getting_notifications_top_level.html)
+ [Receiving CloudTrail Log Files from Multiple Regions](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/receive-cloudtrail-log-files-from-multiple-regions.html) and [Receiving CloudTrail Log Files from Multiple Accounts](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-receive-logs-from-multiple-accounts.html)

All AWS SMS actions are logged by CloudTrail and are documented in the [AWS SMS API Reference](https://docs.aws.amazon.com/server-migration-service/latest/APIReference/)\. For example, calls to the [https://docs.aws.amazon.com/server-migration-service/latest/APIReference/API_CreateReplicationJob.html](https://docs.aws.amazon.com/server-migration-service/latest/APIReference/API_CreateReplicationJob.html) , [https://docs.aws.amazon.com/server-migration-service/latest/APIReference/API_GetConnectors.html](https://docs.aws.amazon.com/server-migration-service/latest/APIReference/API_GetConnectors.html), and [https://docs.aws.amazon.com/server-migration-service/latest/APIReference/API_ImportServerCatalog.html](https://docs.aws.amazon.com/server-migration-service/latest/APIReference/API_ImportServerCatalog.html) actions generate entries in the CloudTrail log files\. 

Every event or log entry contains information about who generated the request\. The identity information helps you determine the following: 
+ Whether the request was made with root or AWS Identity and Access Management \(IAM\) user credentials\.
+ Whether the request was made with temporary security credentials for a role or federated user\.
+ Whether the request was made by another AWS service\.

For more information, see the [CloudTrail userIdentity Element](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-event-reference-user-identity.html)\.

## Understanding AWS SMS log file entries<a name="understanding-service-name-entries"></a>

A trail is a configuration that enables delivery of events as log files to an Amazon S3 bucket that you specify\. CloudTrail log files contain one or more log entries\. An event represents a single request from any source and includes information about the requested action, the date and time of the action, request parameters, and so on\. CloudTrail log files aren't an ordered stack trace of the public API calls, so they don't appear in any specific order\. 

The following example shows a CloudTrail log entry that demonstrates the `CreateReplicationJob` action\.

```
{
    "eventVersion": "1.05",
    "userIdentity": {
        "type": "IAMUser",
        "principalId": "0123456789abcdef01234",
        "arn": "arn:aws:iam::0123456789ab:user/sms-user",
        "accountId": "0123456789ab",
        "accessKeyId": "0123456789abcdef0123",
        "userName": "sms-user"
    },
    "eventTime": "2018-09-04T16:34:49Z",
    "eventSource": "sms.amazonaws.com",
    "eventName": "CreateReplicationJob",
    "awsRegion": "us-east-1",
    "sourceIPAddress": "1.2.3.4",
    "userAgent": "aws-sdk-java/example-sdk-version Linux/example-kernel-version …",
    "requestParameters": {
        "roleName": "sms",
        "serverId": "s-01234567",
        "runOnce": true,
        "seedReplicationTime": "Sep 4, 2018 4:36:48 PM"
    },
    "responseElements": {
        "replicationJobId": "sms-job-012345677"
    },
    "requestID": "00000000-1111-2222-3333-444444444444",
    "eventID": "55555555-6666-7777-8888-999999999999",
    "eventType": "AwsApiCall",
    "recipientAccountId": "0123456789ab"                            
}
```