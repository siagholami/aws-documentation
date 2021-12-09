# Monitoring Amazon Personalize<a name="personalize-monitoring"></a>

With Amazon CloudWatch, you can get metrics associated with Amazon Personalize\. You can set up alarms to notify you when one or more of these metrics fall outside a defined threshold\. To see metrics, you can use [Amazon CloudWatch](https://console.aws.amazon.com/cloudwatch/), [Amazon AWS Command Line Interface](https://docs.aws.amazon.com/AmazonCloudWatch/latest/cli/), or the [CloudWatch API](https://docs.aws.amazon.com/AmazonCloudWatch/latest/APIReference/)\.

You can also see aggregated metrics, for a chosen period of time, by using the Amazon Personalize console\.

## Using CloudWatch Metrics for Amazon Personalize<a name="using-metrics"></a>

To use metrics, you must specify the following information:
+ The metric name\.
+ The metric dimension\. A *dimension* is a name\-value pair that helps you to uniquely identify a metric\.

You can get monitoring data for Amazon Personalize using the AWS Management Console, the AWS CLI, or the CloudWatch API\. You can also use the CloudWatch API through one of the Amazon AWS Software Development Kits \(SDKs\) or the CloudWatch API tools\. The console displays a series of graphs based on the raw data from the CloudWatch API\. Depending on your needs, you might prefer to use either the graphs displayed in the console or retrieved from the API\.

The following list shows some common uses for the metrics\. These are suggestions to get you started, not a comprehensive list\.


| How Do I? | Relevant Metric | 
| --- | --- | 
|  How do I track the number of events that have been recorded?  |  Monitor the `PutEventsRequests` metric\.  | 
|  How can I monitor the DatasetImportJob errors?  |  Use the `DatasetImportJobError` metric\.  | 
|  How can I monitor the latency of `GetRecommendations` calls?  |  Use the `GetRecommendationsLatency` metric\.  | 

You must have the appropriate CloudWatch permissions to monitor Amazon Personalize with CloudWatch\. For more information, see [Authentication and Access Control for Amazon CloudWatch](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/auth-and-access-control-cw.html)\.

## Access Amazon Personalize Metrics<a name="how-to-access"></a>

The following examples show how to access Amazon Personalize metrics using the CloudWatch console, the AWS CLI, and the CloudWatch API\.

**To view metrics \(console\)**

1. Sign in to the AWS Management Console and open the CloudWatch console at [https://console\.aws\.amazon\.com/cloudwatch/](https://console.aws.amazon.com/cloudwatch/)\.

1. Choose **Metrics**, choose the **All metrics** tab, and then choose **AWS/Personalize**\.

1. Choose the metric dimension\.

1. Choose the desired metric from the list, and choose a time period for the graph\.

**To view metrics for events received over a period of time \(CLI\)**
+ Open the AWS CLI and enter the following command:

  ```
  aws cloudwatch get-metric-statistics \
    --metric-name PutEventsRequests \
    --start-time 2019-03-15T00:00:20Z \
    --period 3600 \
    --end-time 2019-03-16T00:00:00Z \
    --namespace AWS/Personalize \
    --dimensions Name=EventTrackerArn,Value=EventTrackerArn \
    --statistics Sum
  ```

  This example shows the events received for the given event tracker ARN over a period of time\. For more information, see [get\-metric\-statistics](https://docs.aws.amazon.com/cli/latest/reference/cloudwatch/get-metric-statistics.html)\.

**To access metrics \(CloudWatch API\)**
+  Call `[GetMetricStatistics](https://docs.aws.amazon.com/AmazonCloudWatch/latest/APIReference/API_GetMetricStatistics.html)`\. For more information, see the [Amazon CloudWatch API Reference](https://docs.aws.amazon.com/AmazonCloudWatch/latest/APIReference/)\.

## Create an Alarm<a name="alarms"></a>

You can create a CloudWatch alarm that sends an Amazon Simple Notification Service \(Amazon SNS\) message when the alarm changes state\. An alarm watches a single metric over a time period you specify\. The alarm performs one or more actions based on the value of the metric relative to a given threshold over a number of time periods\. The action is a notification sent to an Amazon SNS topic or an AWS Auto Scaling policy\.

Alarms invoke actions for sustained state changes only\. CloudWatch alarms do not invoke actions simply because they are in a particular state\. The state must have changed and been maintained for a specified number of time periods\.

**To set an alarm \(console\)**

1. Sign in to the AWS Management Console and open the CloudWatch console at [https://console\.aws\.amazon\.com/cloudwatch/](https://console.aws.amazon.com/cloudwatch/)\.

1. In the navigation pane, Choose **Alarms**, and then choose **Create alarm**\. This launches the **Create Alarm Wizard**\. 

1. Choose **Select metric**\.

1. In the **All metrics** tab, choose **AWS/Personalize**\.

1. Choose **EventTrackerArn**, and then choose **PutEventsRequests** metrics\.

1. Choose the **Graphed metrics** tab\.

1. For **Statistic** choose **Sum**\.

1. Choose **Select metric**\.

1. Fill in the **Name** and **Description**\. For **Whenever**, choose **>**, and then enter a maximum value of your choice\.

1. If you want CloudWatch to send you email when the alarm state is reached, for **Whenever this alarm:**, choose ** State is ALARM**\. To send alarms to an existing Amazon SNS topic, for **Send notification to:**, choose an existing SNS topic\. To set the name and email addresses for a new email subscription list, choose **New list**\. CloudWatch saves the list and displays it in the field so you can use it to set future alarms\. 
**Note**  
If you use **New list** to create a new Amazon SNS topic, the email addresses must be verified before the intended recipients receive notifications\. Amazon SNS sends email only when the alarm enters an alarm state\. If this alarm state change happens before the email addresses are verified, intended recipients do not receive a notification\.

1. Choose **Create alarm**\. 

**To set an alarm \(AWS CLI\)**
+ Open the AWS CLI, and then enter the following command\. Change the value of the `alarm-actions` parameter to reference an Amazon SNS topic that you previously created\.

  ```
  aws cloudwatch put-metric-alarm \
      --alarm-name PersonalizeCLI \
      --alarm-description "Alarm when more than 10 events occur" \
      --metric-name PutEventsRequests \
      --namespace  AWS/Personalize \
      --statistic Sum \
      --period 300 \
      --threshold 10 \
      --comparison-operator GreaterThanThreshold \
      --evaluation-periods 1 \
      --unit Count \
      --dimensions Name=EventTrackerArn,Value=EventTrackerArn \
      --alarm-actions SNSTopicArn
  ```

  This example shows how to create an alarm for when more than 10 events occur for the given event tracker ARN within 5 minutes\. For more information, see [put\-metric\-alarm](https://docs.aws.amazon.com/cli/latest/reference/cloudwatch/put-metric-alarm.html)\.

**To set an alarm \(CloudWatch API\)**
+ Call `[PutMetricAlarm](https://docs.aws.amazon.com/AmazonCloudWatch/latest/APIReference/API_PutMetricAlarm.html)`\. For more information, see *[Amazon CloudWatch API Reference](https://docs.aws.amazon.com/AmazonCloudWatch/latest/APIReference/)*\.