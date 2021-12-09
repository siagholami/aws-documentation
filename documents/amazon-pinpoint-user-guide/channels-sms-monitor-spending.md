# Monitoring SMS Spending Activity with Amazon Pinpoint<a name="channels-sms-monitor-spending"></a>

This topic provides information about viewing SMS spending metrics in Amazon CloudWatch\. It also explains how to set up a CloudWatch alarm that sends you a notification when your monthly SMS spending exceeds a certain amount\.

## View Your Monthly SMS Spending by Using CloudWatch<a name="channels-sms-monitor-spending-metrics"></a>

To quickly determine how much money you've spent sending SMS messages during the current month, you can use the Metrics section of the CloudWatch console\. CloudWatch retains metrics data for 15 months, so you can view real\-time data and analyze historical trends\.

For more information about viewing metrics in CloudWatch, see [Using Amazon CloudWatch Metrics](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/working_with_metrics.html) in the *Amazon CloudWatch User Guide*\.

**To view SMS spending metrics in CloudWatch**

1. Open the CloudWatch console at [https://console\.aws\.amazon\.com/cloudwatch/](https://console.aws.amazon.com/cloudwatch/)\.

1. In the navigation pane, choose **Metrics**\.

1. On the **All metrics** tab, choose **SNS**\.

1. Choose **Metrics with no dimensions**\.

1. Select **SMSMonthToDateSpentUSD**\. The graph updates to display the amount of money that you've spent sending SMS messages during the current month by using Amazon Pinpoint and Amazon Simple Notification Service \(Amazon SNS\)\.
**Note**  
The **SMSMonthToDateSpentUSD** metric doesn't appear until you send at least one SMS message by using Amazon Pinpoint or Amazon SNS\.

## Create an SMS Spending Alarm by Using CloudWatch<a name="channels-sms-monitor-spending-alarms"></a>

In addition to viewing your monthly SMS spending metrics, you can create CloudWatch alarms that notify you when your SMS spending exceeds a certain amount\. You can set up CloudWatch to deliver these notifications to you by sending them to an Amazon SNS topic\.

For more information about creating alarms in CloudWatch, see [Using Amazon CloudWatch Alarms](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/AlarmThatSendsEmail.html) in the *Amazon CloudWatch User Guide*\.

**To create an SMS spending alarm in CloudWatch**

1. If you haven't already done so, create an Amazon SNS topic and subscribe an endpoint to it\. The endpoint that you subscribe to the topic should be the location where you want to receive spending notifications\. For example, if you want to receive spending notifications by email, subscribe your email address to the Amazon SNS topic\. If you want to receive spending notifications by text message, subscribe an SMS endpoint to the topic\.

   For information about creating and subscribing to topics, see [Getting Started with Amazon SNS](https://docs.aws.amazon.com/sns/latest/dg/GettingStarted.html) in the *Amazon Simple Notification Service Developer Guide*\.

1. Open the CloudWatch console at [https://console\.aws\.amazon\.com/cloudwatch/](https://console.aws.amazon.com/cloudwatch/)\.

1. In the navigation pane, under **Alarms**, choose **Billing**\.

1. Next to **Billing alarms**, choose **Create alarm**\.

1. Choose **Select metric**\.

1. On the **All metrics** tab, choose **SNS**, and then choose **Metrics with no dimensions**\.

1. Select **SMSMonthToDateSpentUSD**\.
**Note**  
The **SMSMonthToDateSpentUSD** metric doesn't appear until you send at least one SMS message by using Amazon Pinpoint or Amazon SNS\.

1. Choose the **Graphed metrics** tab, and then complete the following steps: 
   + Under **Statistic**, choose the statistic or predefined percentile that you want to monitor, or specify a custom percentile—for example, **p99** or **p45**\.
   + Under **Period**, choose the evaluation period for the alarm\. When evaluating the alarm, each period is aggregated into one datapoint\.

1. Choose **Select metric**\. The **Specify metric and conditions** page appears, showing a graph and other information about the metric and statistic for the alarm\.

1. Under **Conditions**, complete the following steps:
   + For **Threshold type**, choose **Static**\.
   + For **Whenever SMSMonthToDateSpentUSD is**, specify whether you want the metric to be greater than, greater than or equal to, or equal to the threshold in order to trigger the alarm\. Then, under **than**, enter the threshold value, which is the dollar amount \(in US Dollars\) that you want to trigger the alarm\.

1. Under **Additional configuration**, complete the following steps:
   + For **Datapoints to alarm**, enter the number of evaluation periods \(datapoints\) during which the spending amount must exceed the threshold to trigger the alarm\.
   + For **Missing data treatment**, choose **Treat missing data as ignore \(maintain the alarm state\)**\.

1. Choose **Next**\.

1. Under **Notification**, complete the following steps:
   + For **Whenever this alarm state is**, choose **in Alarm**\. 
   + For **Select an SNS topic**, choose the Amazon SNS topic that you want the alarm notification to be sent to\.

1. Choose **Next**\.

1. Enter a name and, optionally, a description for the alarm, and then choose **Next**\.

1. Under **Preview and create**, review and confirm that the alarm settings are what you want, and then choose **Create alarm**\.