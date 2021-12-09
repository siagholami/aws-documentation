# Monitoring AWS Elemental MediaConnect with Amazon CloudWatch metrics<a name="monitor-with-cloudwatch"></a>

You can monitor AWS Elemental MediaConnect using CloudWatch, which collects raw data and processes it into readable, near real\-time metrics\. These statistics are kept for 15 months, so that you can access historical information and gain a better perspective on how your web application or service is performing\. You can also set alarms that watch for certain thresholds, and send notifications or take actions when those thresholds are met\. For more information, see the [Amazon CloudWatch User Guide](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/)\.

For AWS Elemental MediaConnect, you might want to watch `PacketLossPercent` and send an email to yourself when that metric reaches a certain threshold\.

**To view metrics using the CloudWatch console**

Metrics are grouped first by the service namespace, and then by the various dimension combinations within each namespace\.

1. Sign in to the AWS Management Console and open the CloudWatch console at [https://console\.aws\.amazon\.com/cloudwatch/](https://console.aws.amazon.com/cloudwatch/)\.

1. In the navigation pane, choose **Metrics**\.

1. Under **All metrics**, choose the **AWS/MediaConnect** namespace\.

1. Choose the metric dimension to view the metrics \(for example, choose `flow` to view metrics per flow\)\.

**To view metrics using the AWS CLI**
+ At a command prompt, use the following command:

  ```
  aws cloudwatch list-metrics --namespace "AWS/MediaConnect"
  ```