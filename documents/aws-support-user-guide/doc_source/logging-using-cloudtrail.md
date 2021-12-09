# Logging AWS Support API calls with AWS CloudTrail<a name="logging-using-cloudtrail"></a>

AWS Support is integrated with AWS CloudTrail, a service that provides a record of actions taken by a user, role, or an AWS service in AWS Support\. CloudTrail captures API calls for AWS Support as events\. The calls captured include calls from the AWS Support console and code calls to the AWS Support API operations\.

If you create a trail, you can enable continuous delivery of CloudTrail events to an Amazon S3 bucket, including events for AWS Support\. If you don't configure a trail, you can still view the most recent events in the CloudTrail console in **Event history**\.

Using the information collected by CloudTrail, you can determine the request that was made to AWS Support, the IP address from which the request was made, who made the request, when it was made, and additional details\.

To learn more about CloudTrail, including how to configure and enable it, see the [AWS CloudTrail User Guide](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/)\.

## AWS Support information in CloudTrail<a name="aws-support-info-in-cloudtrail-history"></a>

CloudTrail is enabled on your AWS account when you create the account\. When supported event activity occurs in AWS Support, that activity is recorded in a CloudTrail event along with other AWS service events in **Event history**\. You can view, search, and download recent events in your AWS account\. For more information, see [Viewing events with CloudTrail event history](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/view-cloudtrail-events.html)\.

For an ongoing record of events in your AWS account, including events for AWS Support, create a *trail*\. A trail enables CloudTrail to deliver log files to an Amazon S3 bucket\. By default, when you create a trail in the console, the trail applies to all AWS Regions\. The trail logs events from all Regions in the AWS partition and delivers the log files to the Amazon S3 bucket that you specify\. Additionally, you can configure other AWS services to further analyze and act upon the event data collected in CloudTrail logs\. For more information, see the following:
+ [Overview for creating a trail](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-create-and-update-a-trail.html)
+ [CloudTrail supported services and integrations](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-aws-service-specific-topics.html#cloudtrail-aws-service-specific-topics-integrations)
+ [Configuring Amazon SNS notifications for CloudTrail](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/getting_notifications_top_level.html)
+ [Receiving CloudTrail log files from multiple Regions](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/receive-cloudtrail-log-files-from-multiple-regions.html) and [Receiving CloudTrail log files from multiple accounts](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-receive-logs-from-multiple-accounts.html)

## AWS Support information in CloudTrail logging<a name="aws-support-info-in-cloudtrail-logging"></a>

When CloudTrail logging is enabled in your AWS account, API calls made to specific AWS Support operations are tracked in CloudTrail log files\. AWS Support operations are written with other AWS service records\. CloudTrail determines when to create and write to a new file based on a time period and file size\.

The following operations are supported:
+ [AddAttachmentsToSet](https://docs.aws.amazon.com/awssupport/latest/APIReference/API_AddAttachmentsToSet.html)
+ [AddCommunicationToCase](https://docs.aws.amazon.com/awssupport/latest/APIReference/API_AddCommunicationToCase.html)
+ [CreateCase](https://docs.aws.amazon.com/awssupport/latest/APIReference/API_CreateCase.html)
+ [DescribeAttachment](https://docs.aws.amazon.com/awssupport/latest/APIReference/API_DescribeAttachment.html)
+ [DescribeCases](https://docs.aws.amazon.com/awssupport/latest/APIReference/API_DescribeCases.html)
+ [DescribeCommunications](https://docs.aws.amazon.com/awssupport/latest/APIReference/API_DescribeCommunications.html)
+ [DescribeServices](https://docs.aws.amazon.com/awssupport/latest/APIReference/API_DescribeServices.html)
+ [DescribeSeverityLevels](https://docs.aws.amazon.com/awssupport/latest/APIReference/API_DescribeSeverityLevels.html)
+ [ResolveCase](https://docs.aws.amazon.com/awssupport/latest/APIReference/API_ResolveCase.html)

CloudTrail doesn't support logging for the AWS Support API operations for AWS Trusted Advisor, such as `DescribeTrustedAdvisorChecks`\. For more information about the AWS Support API operations, see the [AWS Support API Reference](https://docs.aws.amazon.com/awssupport/latest/APIReference/)\.

Every event or log entry contains information about who generated the request\. The identity information helps you determine the following:
+ Whether the request was made with root or AWS Identity and Access Management \(IAM\) user credentials\.
+ Whether the request was made with temporary security credentials for a role or federated user\.
+ Whether the request was made by another AWS service\.

For more information, see the [CloudTrail userIdentity element](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-event-reference-user-identity.html)\.

You can store your log files in your Amazon S3 bucket for as long as you want\. You can also define Amazon S3 lifecycle rules to archive or delete log files automatically\. By default, your log files are encrypted with Amazon S3 server\-side encryption \(SSE\)\.

If you want to be notified upon log file delivery, you can configure CloudTrail to publish Amazon Simple Notification Service notifications when new log files are delivered\. For more information, see [Configuring Amazon SNS notifications for CloudTrail](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/getting_notifications_top_level.html)\.

You can also aggregate AWS Support log files from multiple AWS Regions and multiple AWS accounts into a single Amazon S3 bucket\.

For more information, see [Receiving CloudTrail log files from multiple Regions](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-receive-logs-from-multiple-accounts.html) and [Receiving CloudTrail log files from multiple accounts](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-receive-logs-from-multiple-accounts.html)\.

### Trusted Advisor information in CloudTrail logging<a name="cloudtrail-logging-for-trusted-advisor"></a>

AWS Trusted Advisor is a feature in AWS Support that lets you check your AWS account for ways to save costs, improve security, and optimize your AWS account\.

CloudTrail doesn't log Trusted Advisor operations\.

For a list of supported Trusted Advisor operations, see [Trusted Advisor actions](security-trusted-advisor.md#trusted-advisor-operations)\. 

### Understanding AWS Support log file entries<a name="understanding-aws-support-entries"></a>

A trail is a configuration that enables delivery of events as log files to an Amazon S3 bucket that you specify\. CloudTrail log files contain one or more log entries\. An event represents a single request from any source\. It includes information about the requested operation, the date and time of the operation, request parameters, and so on\. CloudTrail log files aren't an ordered stack trace of the public API calls, so they don't appear in any specific order\.

The following example shows a CloudTrail log entry that demonstrates [CreateCase](https://docs.aws.amazon.com/awssupport/latest/APIReference/API_CreateCase.html) operation\.

```
{
   "Records": [
      {
         "eventVersion": "1.04",
         "userIdentity": {
            "type": "IAMUser",
            "principalId": "AIDACKCEVSQ6C2EXAMPLE",
            "arn": "arn:aws:iam::111122223333:user/janedoe",
            "accountId": "111122223333",
            "accessKeyId": "AKIAIOSFODNN7EXAMPLE",
            "userName": "janedoe",
            "sessionContext": {
               "attributes": {
                  "mfaAuthenticated": "false",
                  "creationDate": "2016-04-13T17:51:37Z"
               }
            },
            "invokedBy": "signin.amazonaws.com"
         },
         "eventTime": "2016-04-13T18:05:53Z",
         "eventSource": "support.amazonaws.com",
         "eventName": "CreateCase",
         "awsRegion": "us-east-1",
         "sourceIPAddress": "198.51.100.15",
         "userAgent": "signin.amazonaws.com",
         "requestParameters": {
            "severityCode": "low",
            "categoryCode": "other",
            "language": "en",
            "serviceCode": "support-api",
            "issueType": "technical"
         },
         "responseElements": {
            "caseId": "case-111122223333-muen-2016-c3f2077e504940f2"
         },
         "requestID": "58c257ef-01a2-11e6-be2a-01c031063738",
         "eventID": "5aa34bfc-ad5b-4fb1-8a55-2277c86e746a",
         "eventType": "AwsApiCall",
         "recipientAccountId": "111122223333"
      }
   ],
   ...
}
```