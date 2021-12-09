# Monitoring with Amazon CloudWatch<a name="monitoring-cloudwatch"></a>

You can monitor pipelines and operations using CloudWatch, which collects and processes raw data from Elastic Transcoder into readable, near real\-time metrics\. These statistics are recorded for a period of two weeks, so that you can access historical information and gain a better perspective on how your web application or service is performing\. By default, Elastic Transcoder metric data is automatically sent to CloudWatch in 1\-minute periods\. For more information, see [What Are Amazon CloudWatch, Amazon CloudWatch Events, and Amazon CloudWatch Logs?](https://docs.aws.amazon.com/AmazonCloudWatch/latest/DeveloperGuide/WhatIsCloudWatch.html) in the *Amazon CloudWatch User Guide*\.

**Topics**
+ [Elastic Transcoder Metrics and Dimensions](metrics-dimensions.md)
+ [How Do I Use Elastic Transcoder Metrics?](#how-to-use-metrics)
+ [Creating CloudWatch Alarms to Monitor Elastic Transcoder](creating-alarms.md)

## How Do I Use Elastic Transcoder Metrics?<a name="how-to-use-metrics"></a>

The metrics reported by Elastic Transcoder provide information that you can analyze in different ways\. The list below shows some common uses for the metrics\. These are suggestions to get you started, not a comprehensive list\.
+ [How can I track the wait time before my job is started?](creating-alarms.md#track-standby)
+ [How can I be notified when a job fails due to an error?](creating-alarms.md#track-jobs-errored)
+ [How can I be notitifed when a job completes?](creating-alarms.md#track-jobs-completed)