# Create CloudWatch Alarms for Amazon Pinpoint Metrics<a name="monitoring-create-alarms"></a>

In Amazon CloudWatch, you can create an alarm that sends a notification when the value of a certain metric is within or outside a threshold that you define\. For example, you can create an alarm that notifies you if more than a certain number of campaign messages weren't sent due to a temporary issue\. In this example, the alarm sends a notification if the value of the **CampaignSendMessageTemporaryFailure** metric is greater than the value that you specify\. 

This topic explains how to create an alarm for an Amazon Pinpoint metric by using the CloudWatch console\. For more information about creating alarms, including detailed information about alarm configuration settings, see [Using Amazon CloudWatch Alarms](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/AlarmThatSendsEmail.html) in the *Amazon CloudWatch User Guide*\.

**To create an alarm for an Amazon Pinpoint metric**

1. Open the CloudWatch console at [https://console\.aws\.amazon\.com/cloudwatch/](https://console.aws.amazon.com/cloudwatch/)\.

1. In the navigation pane, choose **Alarms**\.

1. Choose **Create alarm**\.

1. Choose **Select metric**\.

1. On the **All metrics** tab, choose **Pinpoint**, and then choose the type of metric that you want to create an alarm for\. The types of available metrics depends on the Amazon Pinpoint features that you use\.

1. Select the metric that you want to create an alarm for, and then choose **Select metric**\. The **Specify metric and conditions** page appears, showing a graph and other information about the metric\.

1. Under **Conditions**, complete the following steps:
   + For **Threshold type**, choose **Static**\.
   + For **Whenever **metric** is**, specify whether you want the value of the metric to be greater than, greater than or equal to, less than, or less than or equal to the threshold to trigger the alarm\. Then, under **than**, enter the threshold value that you want to trigger the alarm\.

1. Under **Additional configuration**, complete the following steps:
   + For **Datapoints to alarm**, enter the number of evaluation periods \(datapoints\) during which the metric value must meet the threshold conditions to trigger the alarm\.
   + For **Missing data treatment**, choose what you want the alarm to do if some data is missing\.

1. Choose **Next**\.

1. Under **Notification**, complete the following steps:
   + For **Whenever this alarm state is**, choose **in Alarm**\.
   + For **Select an SNS topic**, choose or create an Amazon Simple Notification Service \(Amazon SNS\) topic that you want the alarm notification to be sent to\.

1. Choose **Next**\.

1. Enter a name and, optionally, a description for the alarm, and then choose **Next**\.

1. Under **Preview and create**, review and confirm that the alarm settings are what you want, and then choose **Create alarm**\.