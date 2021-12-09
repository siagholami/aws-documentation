# Creating Trusted Advisor alarms using CloudWatch<a name="cloudwatch-metrics-ta"></a>

You can use Amazon CloudWatch to create alarms on Trusted Advisor metrics for check status changes, resource status changes, and service limit utilization\. Depending on your requirements, you might create multiple alarms\.

Follow the procedure described here to create a CloudWatch alarm for Trusted Advisor\. Before you create alarms for Trusted Advisor metrics, do the following:
+ Familiarize yourself with metrics and alarms in CloudWatch\. For more information, see [What is Amazon CloudWatch?](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/WhatIsCloudWatch.html)
+ Refresh your checks through the Trusted Advisor console or through the AWS Support API\.

**To create a CloudWatch alarm for Trusted Advisor**

1. Open the CloudWatch console at [https://console\.aws\.amazon\.com/cloudwatch/](https://console.aws.amazon.com/cloudwatch/)\.

1. In the navigation bar, in the Region selector, choose **US East \(N\. Virginia\) Region**\.

1. In the navigation pane, choose **Alarms**\.

1. Choose **Create Alarm**\.

1. For the **Select Metric**, choose a metric for Trusted Advisor\.

1. To select a metric, do one of the following:

   1. In the search box, enter one or more dimension values to filter the metric list\.

   1. In the results table, select the check box for the row containing the desired metric\.

1. Choose **Next**\.

1. Configure the alarm:

   1. Under **Alarm Threshold**, specify a name and description\.

   1. For the **ServiceLimitUsage** metric, specify a threshold value between **0\.00** and **1\.00**\.

   1. For the **RedResources**, **YellowResources**, **GreenChecks**, **RedChecks**, and **YellowChecks** metrics, you can specify a threshold that is any whole number greater than or equal to zero\.

   1. Configure your desired behavior for missing data\. By default, this is set to **missing**\.

   1. Under **Actions**, add a notification list\.

1. Choose **Create Alarm**\.