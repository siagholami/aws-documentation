# Logging Operations with AWS CloudTrail<a name="logging-using-cloudtrail"></a>

Amazon QuickSight is integrated with AWS CloudTrail\. This service provides a record of actions taken by a user, role, or an AWS service in Amazon QuickSight\.  The calls captured include calls from the Amazon QuickSight console\. If you create a trail, you can enable continuous delivery of CloudTrail events to an Amazon S3 bucket, including events for Amazon QuickSight\. If you don't configure a trail, you can still view the most recent events in the CloudTrail console in **Event history**\. Using the information collected by CloudTrail, you can determine the request that was made to Amazon QuickSight, the IP address from which the request was made, who made the request, when it was made, and additional details\. 

To learn more about CloudTrail, including how to configure and enable it, see the [AWS CloudTrail User Guide](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/)\.

**Topics**
+ [Amazon QuickSight Information in CloudTrail](#quicksight-info-in-cloudtrail)
+ [Tracking Non\-API Events by Using CloudTrail Logs](logging-non-api.md)
+ [Example: Amazon QuickSight Log File Entries](#understanding-quicksight-entries)

## Amazon QuickSight Information in CloudTrail<a name="quicksight-info-in-cloudtrail"></a>

CloudTrail is enabled on your AWS account when you create the account\. When supported event activity occurs in Amazon QuickSight, that activity is recorded in a CloudTrail event along with other AWS service events in **Event history**\. You can view, search, and download recent events in your AWS account\. For more information, see [Viewing Events with CloudTrail Event History](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/view-cloudtrail-events.html)\. 

For an ongoing record of events in your AWS account, including events for Amazon QuickSight, create a trail\. A *trail* enables CloudTrail to deliver log files to an Amazon S3 bucket\. By default, when you create a trail in the console, the trail applies to all AWS Regions\. The trail logs events from all Regions in the AWS partition and delivers the log files to the Amazon S3 bucket that you specify\. Additionally, you can configure other AWS services to further analyze and act upon the event data collected in CloudTrail logs\. For more information, see the following: 
+ [Overview for Creating a Trail](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-create-and-update-a-trail.html)
+ [CloudTrail Supported Services and Integrations](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-aws-service-specific-topics.html#cloudtrail-aws-service-specific-topics-integrations)
+ [Configuring Amazon SNS Notifications for CloudTrail](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/getting_notifications_top_level.html)
+ [Receiving CloudTrail Log Files from Multiple Regions](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/receive-cloudtrail-log-files-from-multiple-regions.html) and [Receiving CloudTrail Log Files from Multiple Accounts](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-receive-logs-from-multiple-accounts.html)

Amazon QuickSight supports logging the following actions as events in CloudTrail log files:
+ Whether the request was made with root or AWS Identity and Access Management \(IAM\) user credentials
+ Whether the request was made with temporary security credentials for an IAM role or federated user
+ Whether the request was made by another AWS service

For more information on user identity, see the [CloudTrail userIdentity Element](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-event-reference-user-identity.html)\.

By default, each Amazon QuickSight log entry contains the following information:
+  **userIdentity** – User identity
+  **eventTime** – Event time
+  **eventId** – Event Id
+  **readOnly** – Read only
+  **awsRegion** – AWS Region
+  **eventSource \(quicksight\)** – Source of the event \(Amazon QuickSight\)
+  **eventType \(AwsServiceEvent\)** – Event type \(AWS service event\)
+  **recipientAccountId \(customer AWS account\)** – Recipient account ID \(Customer AWS account\)

**Note**  
 CloudTrail displays users as `unknown` if they were provisioned by Amazon QuickSight\. This display is because these users aren't a known IAM identity type\. 

## Example: Amazon QuickSight Log File Entries<a name="understanding-quicksight-entries"></a>

 A trail is a configuration that enables delivery of events as log files to an Amazon S3 bucket that you specify\. CloudTrail log files contain one or more log entries\. An event represents a single request from any source and includes information about the requested action, the date and time of the action, request parameters, and so on\. CloudTrail log files aren't an ordered stack trace of the public API calls, so they don't appear in any specific order\.

The following example shows a CloudTrail log entry that demonstrates the BatchCreateUser action\.

```
{ 
   "eventVersion":"1.05",
   "userIdentity":
	{ 
	   "type":"Root",
	   "principalId":"123456789012",
	   "arn":"arn:aws:iam::123456789012:root",
	   "accountId":"123456789012",
	   "userName":"test-username"
	},
	   "eventTime":"2017-04-19T03:16:13Z",
	   "eventSource":"quicksight.amazonaws.com",
	   "eventName":"BatchCreateUser",
	   "awsRegion":"us-west-2",
	   "requestParameters":null,
	   "responseElements":null,
	   "eventID":"e7d2382e-70a0-3fb7-9d41-a7a913422240",
	   "readOnly":false,
	   "eventType":"AwsServiceEvent",
	   "recipientAccountId":"123456789012",
	   "serviceEventDetails":
	   { 
		   "eventRequestDetails":
		   { 
				"users":
				{ 
					"test-user-11":
					{ 
						"role":"USER"
					},
					"test-user-22":
					{ 
						"role":"ADMIN"
					}
				}
			},
			"eventResponseDetails":
			{ 
			"validUsers":[ 
				],
			"InvalidUsers":[ 
				"test-user-11",
				"test-user-22"
				]
			}
	   }
   }
```