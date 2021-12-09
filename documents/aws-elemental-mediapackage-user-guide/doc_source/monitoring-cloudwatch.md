# Monitoring AWS Elemental MediaPackage with Amazon CloudWatch Metrics<a name="monitoring-cloudwatch"></a>

You can monitor AWS Elemental MediaPackage using CloudWatch, which collects raw data and processes it into readable, near real\-time metrics\. These statistics are kept for 15 months, so that you can access historical information and gain a better perspective on how your web application or service is performing\. You can also set alarms that watch for certain thresholds, and send notifications or take actions when those thresholds are met\. For more information, see the [Amazon CloudWatch User Guide](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/)\.

**To view metrics using the AWS Elemental MediaPackage console**  
AWS Elemental MediaPackage displays metrics throughout the console\.

1. Open the MediaPackage console at [https://console\.aws\.amazon\.com/mediapackage/](https://console.aws.amazon.com/mediapackage/)\.

1. Navigate to the appropriate page to view metrics:
   + For metrics on all channels and endpoints in the AWS Region, go to the **Channels** page\.
   + For metrics on a specific channel and all of its endpoints, go to the channel's details page\.
   + For metrics on a specific endpoint and its channel, go to the endpoint's details page\.

1. \(Optional\) To refine the metrics view, choose **Open in CloudWatch**\.

**To view metrics using the CloudWatch console**  
Metrics are grouped first by the service namespace, and then by the various dimension combinations within each namespace\.

1. Sign in to the AWS Management Console and open the CloudWatch console at [https://console\.aws\.amazon\.com/cloudwatch/](https://console.aws.amazon.com/cloudwatch/)\.

1. In the navigation pane, choose **Metrics**\.

1. Under **All metrics**, choose the **AWS/MediaPackage** namespace\.

1. Choose the metric dimension to view the metrics \(for example, choose `channel` to view metrics per channel\)\.

**To view metrics using the AWS CLI**  
At a command prompt, use the following command:

```
aws cloudwatch list-metrics --namespace "AWS/MediaPackage"
```

**Topics**
+ [AWS Elemental MediaPackage Live Content Metrics](metrics.md)
+ [AWS Elemental MediaPackage VOD Content Metrics](metrics-vod.md)