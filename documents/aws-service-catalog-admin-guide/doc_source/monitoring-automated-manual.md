# Monitoring Tools<a name="monitoring-automated-manual"></a>

AWS provides various tools that you can use to monitor AWS Service Catalog\. You can configure some of these tools to do the monitoring for you, while some of the tools require manual intervention\. We recommend that you automate monitoring tasks as much as possible\.

## Automated Monitoring Tools<a name="monitoring-automated_tools"></a>

You can use the following automated monitoring tools to watch AWS Service Catalog and report when something is wrong:
+ Amazon CloudWatch alarms – Watch a single metric over a time period that you specify, and perform one or more actions based on the value of the metric relative to a given threshold over a number of time periods\. The action is a notification sent to an Amazon Simple Notification Service \(Amazon SNS\) topic or Amazon EC2 Auto Scaling policy\. CloudWatch alarms do not invoke actions simply because they are in a particular state; the state must have changed and been maintained for a specified number of periods\. To learn how to create an alarm, see [Creating Amazon CloudWatch Alarms](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/AlarmThatSendsEmail.html)\. For more information on using Amazon CloudWatch metrics with AWS Service Catalog, see [AWS Service Catalog CloudWatch Metrics](cloudwatch-metrics.md)\.