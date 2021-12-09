# Monitoring AWS Chatbot with Amazon CloudWatch<a name="monitoring-cloudwatch"></a>

You can monitor AWS Chatbot using CloudWatch, which collects raw data and processes it into readable, near real\-time metrics\. These statistics are kept for 15 months, so that you can access historical information and gain a better perspective on how your web application or service is performing\. You can also set alarms that watch for certain thresholds, and send notifications or take actions when those thresholds are met\. For more information, see the [Amazon CloudWatch User Guide](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/WhatIsCloudWatch.html)\.

## Enabling CloudWatch Metrics<a name="enable-cloudwatch"></a>

Amazon CloudWatch metrics are enabled by default\.

## Available metrics and dimensions<a name="available-cloudwatch-metrics"></a>

The metrics and dimensions that AWS Chatbot sends to Amazon CloudWatch are listed below\.

The `AWS/Chatbot` namespace includes the following metrics\.

**Note**  
To get AWS Chatbot metrics, you must specify **US East \(N\. Virginia\)** for the Region\.


| Metric | Description | 
| --- | --- | 
|  `EventsThrottled`  |  The number of throttled notifications\. Events may be throttled if the number of events received exceeds 10 per second\. Units: Count  | 
|  `EventsProcessed`  |  The number of event notifications received by AWS Chatbot\. Units: Count  | 
|  `UnsupportedEvents`  |  The number of unsupported events or messages attempted\. For a full list of AWS services supported by AWS Chatbot, see [Using AWS Chatbot with other AWS services](related-services.md)\. Units: Count  | 
|  `MessageDeliverySuccess`  |  The number of messages successfully delivered to the chat client\. Units: Count  | 
|  `MessageDeliveryFailure`  |  The number of messages that failed to deliver to the chat client\. Units: Count  | 

AWS Chatbot sends the following dimensions to CloudWatch\.


| Dimension | Description | 
| --- | --- | 
| `ConfigurationName` |  This dimension filters the data you request by the name of your configuration\.  | 

## Viewing AWS Chatbot metrics<a name="viewing-cloudwatch-metrics"></a>

You can view metrics in the CloudWatch console, which provides a fine\-grained and customizable display of your resources, as well as the number of running tasks in a service\.

### Viewing AWS Chatbot metrics in the CloudWatch console<a name="viewing-metrics-console"></a>

AWS Chatbot metrics can be viewed in the CloudWatch console\. The CloudWatch console provides a detailed view of AWS Chatbot metrics, and you can tailor the views to suit your needs\. For more information about CloudWatch, see the [Amazon CloudWatch User Guide](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/WhatIsCloudWatch.html)\.

**To view metrics in the CloudWatch console**

1. Open the CloudWatch console at [https://console\.aws\.amazon\.com/cloudwatch/](https://console.aws.amazon.com/cloudwatch/)\.

1. In the **Metrics** section in the left navigation, choose **AWS Chatbot**\.

1. Choose the metrics to view\. 