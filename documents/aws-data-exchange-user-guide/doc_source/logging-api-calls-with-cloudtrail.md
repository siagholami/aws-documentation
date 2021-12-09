# Logging AWS Data Exchange API Calls with AWS CloudTrail<a name="logging-api-calls-with-cloudtrail"></a>

 AWS Data Exchange is integrated with AWS CloudTrail, a service that provides a record of actions taken by a user, role, or an AWS service in AWS Data Exchange\. AWS CloudTrail captures all calls to AWS Data Exchange APIs as events, including calls from the AWS Data Exchange console and from code calls to the AWS Data Exchange API operations\.

 If you create a trail, you can enable continuous delivery of CloudTrail events to an S3 bucket, including events for AWS Data Exchange\. If you don't configure a trail, you can still view the most recent events in the CloudTrail console in **Event history**\. Using the information collected by CloudTrail, you can determine the request that was made to AWS Data Exchange, the IP address from which the request was made, who made the request, when it was made, and other details\.

**Important**  
Some actions you can take are console\-only actions\. There is no corresponding API in the AWS SDK or AWS CLI\. These are actions that rely on AWS Marketplace functionality, such as publishing or subscribing to a product\. AWS Data Exchange provides CloudTrail logs for a subset of these console\-only actions\. See the following list of console\-only actions for which CloudTrail logs are provided\.  
For more information, see [What Is AWS CloudTrail?](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/)

In addition to CloudTrail events for all the [AWS Data Exchange APIs](https://docs.aws.amazon.com/data-exchange/latest/apireference) and corresponding console actions, AWS Data Exchange also provides CloudTrail trails for a subset of the AWS Marketplace\-backed console\-only actions\. AWS Data Exchange provides a CloudTrail log for the following console\-only actions:

**Subscriber Actions**
+ Subscribe to a product
+ Send subscription verification request
+ Enable subscription auto\-renewal
+ Disable subscription auto\-renewal
+ Cancel subscription verification request

**Provider Actions**
+ Publish a product
+ Unpublish a product
+ Edit a product
+ Create custom offer
+ Edit custom offer
+ Approve subscription verification request
+ Decline subscription verification request
+ Delete subscriber contact information

## AWS Data Exchange Information in CloudTrail<a name="nformation-in-cloudtrail"></a>

CloudTrail is enabled when you create your AWS account\. When activity occurs in AWS Data Exchange, the activity is recorded in a CloudTrail event along with other AWS service events in **Event history**\. You can view, search, and download recent events in your AWS account\. For more information, see [Viewing Events with CloudTrail Event History](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/view-cloudtrail-events.html) in the *AWS CloudTrail User Guide*\.

For an ongoing record of events in your AWS account, including events for AWS Data Exchange, create a trail\. CloudTrail uses this trail to deliver log files to an S3 bucket\. By default, when you use the console to create a trail, it applies to all AWS Regions\. The trail logs events from all AWS Regions and delivers the log files to the S3 bucket that you specify\. You can configure other AWS services to further analyze and act upon the event data collected in CloudTrail logs\. For more information, see:
+ [Overview for Creating a Trail](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-create-and-update-a-trail.html)
+ [CloudTrail Supported Services and Integrations](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-aws-service-specific-topics.html#cloudtrail-aws-service-specific-topics-integrations)
+ [Configuring Amazon SNS Notifications for CloudTrail](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/getting_notifications_top_level.html)
+ [Receiving CloudTrail Log Files from Multiple Regions](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/receive-cloudtrail-log-files-from-multiple-regions.html)
+ [Receiving CloudTrail Log Files from Multiple Accounts](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-receive-logs-from-multiple-accounts.html)

All AWS Data Exchange actions are logged by CloudTrail and are documented in the AWS Data Exchange API Reference\. For example, calls to the `CreateDataSet`, `StartImportAssetsFromS3Workflow`, and `ListRevisionAssets` API actions generate entries in the CloudTrail log files\.

Every event or log entry contains information about who generated the request\. The identity information helps you determine the following:
+ Whether the request was made with root or IAM user credentials\.
+ Whether the request was made with temporary security credentials for a role or federated user\.
+ Whether the request was made by another AWS service\.

For more information, see [CloudTrail userIdentity Element](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-event-reference-user-identity.html)\.

## Understanding AWS Data Exchange Log File Entries<a name="understanding-log-entries"></a>

A trail is a configuration that makes it possible to deliver events as log files to an S3 bucket that you specify\. CloudTrail log files contain one or more log entries\. An event represents a single request from any source and includes information about the requested action, the date and time of the action, request parameters, and so on\. CloudTrail log files are not an ordered stack trace of the public API calls, so they do not appear in any order\.

**Note**  
These examples have been formatted to improve readability\. In a CloudTrail log file, all entries and events are concatenated into a single line\. This example has been limited to a single AWS Data Exchange entry\. In a real CloudTrail log file, you see entries and events from multiple AWS services\.

The following example shows a CloudTrail log entry that demonstrates the `CreateDataSet` action:

```
{
    "eventVersion": "1.05",
    "userIdentity": {
        "type": "AssumedRole",
        "principalId": "AIDACKCEVSQ6C2EXAMPLE:account_name",
        "arn": "arn:aws:sts::123456789012:user/Mary_Major",
        "accountId": "123456789012",
        "accessKeyId": "AKIAIOSFODNN7EXAMPLE",
        "sessionContext": {
            "attributes": {
                "mfaAuthenticated": "false",
                "creationDate": "2018-06-20T18:32:25Z"
            },
            "sessionIssuer": {
                "type": "Role",
                "principalId": "AIDACKCEVSQ6C2EXAMPLE",
                "arn": "arn:aws:iam::123456789012:role/Admin",
                "accountId": "123456789012",
                "userName": "username"
            }
        }
    },
    "eventTime": "2018-06-20T19:04:36Z",
    "eventSource": "dataexchange.amazonaws.com",
    "eventName": "CreateDataSet",
    "awsRegion": "us-east-1",
    "sourceIPAddress": "203.0.113.12",
    "userAgent": "console.amazonaws.com",
    "requestParameters": {
        "Name": "MyDataSet",
        "AssetType": "S3_SNAPSHOT",
        "Description": "This is my dataset"
    },
    "responseElements": {
        "Origin": "OWNED",
        "AssetType": "S3_SNAPSHOT",
        "Name": "MyDataSet",
        "CreatedAt": 1726255485679,
        "UpdatedAt": 1726255485679,
        "Arn": "arn:aws:dataexchange:us-east-1:123456789012:data-sets/DataSetIdentifier",
        "Id": "DataSetIdentifier",
        "Description": "This is my dataset"
    },
    "requestID": "cb8c167e-EXAMPLE",
    "eventID": "e3c6f4ce-EXAMPLE",
    "readOnly": false,
    "eventType": "AwsApiCall",
    "recipientAccountId": "123456789012"
}>
```