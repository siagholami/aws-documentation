# Logging and Monitoring<a name="security-logging"></a>

Monitoring is an important part of maintaining the reliability, availability, and performance of AWS IoT and your AWS solutions\. You should collect monitoring data from all parts of your AWS solution so that you can more easily debug a multi\-point failure, if one occurs\. For information on logging and monitoring procedures, see [Monitoring AWS IoT](monitoring_overview.md)

Before you start monitoring AWS IoT, you should create a monitoring plan that includes answers to the following questions:

## Monitoring Tools<a name="monitoring_automated_manual"></a>

AWS provides tools that you can use to monitor AWS IoT\. You can configure some of these tools to do the monitoring for you\. Some of the tools require manual intervention\. We recommend that you automate monitoring tasks as much as possible\.

### Automated Monitoring Tools<a name="monitoring_automated_tools"></a>

You can use the following automated monitoring tools to watch AWS IoT and report when something is wrong:
+ **Amazon CloudWatch Alarms** – Watch a single metric over a time period that you specify, and perform one or more actions based on the value of the metric relative to a given threshold over a number of time periods\. The action is a notification sent to an Amazon Simple Notification Service \(Amazon SNS\) topic or Amazon EC2 Auto Scaling policy\. CloudWatch alarms do not invoke actions simply because they are in a particular state\. The state must have changed and been maintained for a specified number of periods\. For more information, see [Monitor AWS IoT alarms and metrics using Amazon CloudWatch](monitoring-cloudwatch.md)\.
+ **Amazon CloudWatch Logs** – Monitor, store, and access your log files from AWS CloudTrail or other sources\. For more information, see [Monitor AWS IoT using CloudWatch Logs](cloud-watch-logs.md) For more information about using Amazon CloudWatch, see [Monitoring Log Files](https://docs.aws.amazon.com/AmazonCloudWatch/latest/DeveloperGuide/WhatIsCloudWatchLogs.html) in the *Amazon CloudWatch User Guide*\.
+ **Amazon CloudWatch Events** – Match events and route them to one or more target functions or streams to make changes, capture state information, and take corrective action\. For more information, see [What Is Amazon CloudWatch Events](https://docs.aws.amazon.com/AmazonCloudWatch/latest/DeveloperGuide/WhatIsCloudWatchEvents.html) in the *Amazon CloudWatch User Guide*\.
+ **AWS CloudTrail Log Monitoring** – Share log files between accounts, monitor CloudTrail log files in real time by sending them to CloudWatch Logs, write log processing applications in Java, and validate that your log files have not changed after delivery by CloudTrail\. For more information, see [Log AWS IoT API calls using AWS CloudTrail](iot-using-cloudtrail.md) and also [Working with CloudTrail Log Files](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-working-with-log-files.html) in the *AWS CloudTrail User Guide*\. 

### Manual Monitoring Tools<a name="monitoring_manual_tools"></a>

Another important part of monitoring AWS IoT involves manually monitoring those items that the CloudWatch alarms don't cover\. The AWS IoT, CloudWatch, and other AWS service console dashboards provide an at\-a\-glance view of the state of your AWS environment\. We recommend that you also check the log files on AWS IoT\.
+ AWS IoT dashboard shows:
  + CA certificates
  + Certificates
  + Polices
  + Rules
  + Things
+ CloudWatch home page shows:
  + Current alarms and status\.
  + Graphs of alarms and resources\.
  + Service health status\.

  You can use CloudWatch to do the following: 
  + Create [customized dashboards](https://docs.aws.amazon.com/AmazonCloudWatch/latest/DeveloperGuide/CloudWatch_Dashboards.html) to monitor the services you care about\.
  + Graph metric data to troubleshoot issues and discover trends\.
  + Search and browse all your AWS resource metrics\.
  + Create and edit alarms to be notified of problems\.