# Monitoring Trusted Advisor check results with Amazon CloudWatch Events<a name="cloudwatch-events-ta"></a>

You can use Amazon CloudWatch Events to detect and react to changes in the status of Trusted Advisor checks\. Then, based on the rules that you create, CloudWatch Events invokes one or more target actions when a check status changes to the value you specify in a rule\. Depending on the type of status change, you might want to send notifications, capture status information, take corrective action, initiate events, or take other actions\. You can select the following types of targets when using CloudWatch Events as a part of your Trusted Advisor workflow:
+ AWS Lambda functions
+ Amazon Kinesis streams
+ Amazon Simple Queue Service queues
+ Built\-in targets \(CloudWatch alarm actions\)
+ Amazon Simple Notification Service topics

The following are some use cases:
+ Use a Lambda function to pass a notification to a Slack channel when check status changes\.
+ Push data about checks to a Kinesis stream to support comprehensive, real\-time status monitoring\.

For examples of using CloudWatch Events and Lambda functions to automate the response to Trusted Advisor check results, see [Trusted Advisor tools](https://github.com/aws/Trusted-Advisor-Tools)\.

The remainder of this topic describes the basic procedure for creating a CloudWatch Events rule for Trusted Advisor\. Before you create event rules for Trusted Advisor, however, you should do the following:
+ Familiarize yourself with events, rules, and targets in CloudWatch Events\. For more information, see [What is Amazon CloudWatch Events?](https://docs.aws.amazon.com/AmazonCloudWatch/latest/events/WhatIsCloudWatchEvents.html) and [New CloudWatch Events – track and respond to changes to your AWS resources](https://aws.amazon.com/blogs/aws/new-cloudwatch-events-track-and-respond-to-changes-to-your-aws-resources/)\.
+ Create the target or targets you will use in your event rules\.

**To create a CloudWatch Events rule for Trusted Advisor**

1. Open the CloudWatch console at [https://console\.aws\.amazon\.com/cloudwatch/](https://console.aws.amazon.com/cloudwatch/)\.

1. In the navigation bar, choose the **US East \(N\. Virginia\)** Region\.

1. In the navigation pane, choose **Events**\.

1. Choose **Create rule**, and then under **Event Source**, for **Service Name**, choose **Trusted Advisor**\.

1. Specify status values:
   + To make a rule that applies to all status values, choose **Check Item Refresh Status**, and then choose **Any status** \(the default\)\.
   + To make a rule that applies to some status values only, choose **Specific status\(es\)**, and then choose one or more status values from the list\.

1. Specify Trusted Advisor checks:
   + To make a rule that applies to all Trusted Advisor checks, choose **Any check**\.
   + To make a rule that applies to some checks only, choose **Specific check\(s\)**, and then choose one or more check names from the list\.

1. Specify AWS resources:
   + To make a rule that applies to all resources, choose **Any resource ID**\.
   + To make a rule that applies to one or more resources only, choose **Specific resource ID\(s\) by ARN**\. Then, enter the ARNs of the resources\.

1. Review your rule setup to make sure it meets your event\-monitoring requirements\.

1. In the **Targets** area, choose **Add target\***\.

1. In the **Select target type** list, choose the type of target you prepared to use with this rule\. Then, configure any additional options required by that type\.

1. Choose **Configure details**\.

1. On the **Configure rule details** page, enter a name and description for the rule\. To enable the rule as soon as it's created, choose the **State** box\.

1. If you're satisfied with the rule, choose **Create rule**\.