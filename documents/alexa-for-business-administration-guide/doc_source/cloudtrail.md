# Logging Alexa for Business API Calls with AWS CloudTrail<a name="cloudtrail"></a>

Alexa for Business is integrated with AWS CloudTrail, a service that provides a record of actions taken by a user, role, or an AWS service in Alexa for Business\. CloudTrail captures all API calls for Alexa for Business as events\. The calls captured include calls from the Alexa for Business console and code calls to the Alexa for Business API operations\. If you create a trail, you can enable continuous delivery of CloudTrail events to an Amazon S3 bucket, including events for Alexa for Business\. If you don't configure a trail, you can still view the most recent events in the CloudTrail console in **Event history**\. Using the information collected by CloudTrail, you can determine the request that was made to Alexa for Business, the IP address from which the request was made, who made the request, when it was made, and additional details\. 

To learn more about CloudTrail, see the [AWS CloudTrail User Guide](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/)\.

## Alexa for Business Information in CloudTrail<a name="a4b-info-in-cloudtrail"></a>

CloudTrail is enabled on your AWS account when you create the account\. When activity occurs in Alexa for Business, that activity is recorded in a CloudTrail event along with other AWS service events in **Event history**\. You can view, search, and download recent events in your AWS account\. For more information, see [Viewing Events with CloudTrail Event History](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/view-cloudtrail-events.html)\. 

For an ongoing record of events in your AWS account, including events for Alexa for Business, create a trail\. A *trail* enables CloudTrail to deliver log files to an Amazon S3 bucket\. By default, when you create a trail in the console, the trail applies to all AWS Regions\. Currently, events for Alexa for Business only appear in US East \(N\. Virginia\), which is the only available region\. The trail logs events from all Regions in the AWS partition and delivers the log files to the Amazon S3 bucket that you specify\. Additionally, you can configure other AWS services to further analyze and act upon the event data collected in CloudTrail logs\. For more information, see the following: 
+ [Overview for Creating a Trail](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-create-and-update-a-trail.html)
+ [CloudTrail Supported Services and Integrations](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-aws-service-specific-topics.html#cloudtrail-aws-service-specific-topics-integrations)
+ [Configuring Amazon SNS Notifications for CloudTrail](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/getting_notifications_top_level.html)
+ [Receiving CloudTrail Log Files from Multiple Regions](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/receive-cloudtrail-log-files-from-multiple-regions.html) and [Receiving CloudTrail Log Files from Multiple Accounts](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-receive-logs-from-multiple-accounts.html)

All Alexa for Business actions are logged by CloudTrail and are documented in the [Alexa for Business API Reference](https://docs.aws.amazon.com/a4b/latest/APIReference/Welcome.html)\. For example, `CreateRoom`, `AssociateSkillGroupWithRoom`, and `DeleteRoom` all generate entries in CloudTrail log files\. 

Every event or log entry contains information about who generated the request\. The identity information helps you determine the following: 
+ Whether the request was made with root or AWS Identity and Access Management \(IAM\) user credentials\.
+ Whether the request was made with temporary security credentials for a role or federated user\.
+ Whether the request was made by another AWS service\.

For more information, see the [CloudTrail userIdentity Element](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-event-reference-user-identity.html)\.

## Understanding Alexa for Business Log File Entries<a name="understanding-a4b-entries"></a>

A trail is a configuration that enables delivery of events as log files to an Amazon S3 bucket that you specify\. CloudTrail log files contain one or more log entries\. An event represents a single request from any source and includes information about the requested action, the date and time of the action, request parameters, and so on\. CloudTrail log files aren't an ordered stack trace of the public API calls, so they don't appear in any specific order\. 

The following is an example of a CloudTrail log entry for Alexa for Business:

```
{
  "Records": [{
    "eventVersion": "1.05",
    "userIdentity": {
      "type": "IAMUser",
      "principalId": "EX_PRINCIPAL_ID",
      "arn": "arn:aws:iam::123456789012:user/Alice",
      "accountId": "123456789012",
      "accessKeyId": "EXAMPLE_KEY_ID",
      "userName": "Alice"
    },
    "eventTime": "2017-11-13T10:00:02Z",
    "eventSource": "a4b.amazonaws.com",
    "eventName": "CreateRoom",
    "awsRegion": "us-east-1",
    "sourceIPAddress": "192.2.0.1",
    "userAgent": "AWS Internal",
    "requestParameters": null,
    "responseElements": {
      "roomArn": "arn:aws:a4b:us-east-1:123456789012:room/8eed09c4eae340d2ba08b8c6c3e40970/66afda686e75c5b62fceaf60ac00e7a6"
    },
    "requestID": "6a875d42-c859-11e7-93bc-f944dc16ba6b",
    "eventID": "2b045b94-82d9-407d-aff3-6c308b40fecb",
    "resources": [{
      "ARN": "arn:aws:a4b:us-east-1:123456789012:profile/8eed09c4eae340d2ba08b8c6c3e40970/00491b672c651240de09540d2072f660",
      "accountId": "123456789012",
      "type": "AWS::A4B::Profile"
    }, {
      "ARN": "arn:aws:a4b:us-east-1:123456789012:room/8eed09c4eae340d2ba08b8c6c3e40970/66afda686e75c5b62fceaf60ac00e7a6",
      "accountId": "123456789012",
      "type": "AWS::A4B::Room"
	}],
    "eventType": "AwsApiCall",
    "recipientAccountId": "123456789012"
    }
  ]
```