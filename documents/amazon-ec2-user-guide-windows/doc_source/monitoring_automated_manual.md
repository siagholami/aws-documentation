# Automated and manual monitoring<a name="monitoring_automated_manual"></a>

AWS provides various tools that you can use to monitor Amazon EC2\. You can configure some of these tools to do the monitoring for you, while some of the tools require manual intervention\.

**Topics**
+ [Automated monitoring tools](#monitoring_automated_tools)
+ [Manual monitoring tools](#monitoring_manual_tools)

## Automated monitoring tools<a name="monitoring_automated_tools"></a>

You can use the following automated monitoring tools to watch Amazon EC2 and report back to you when something is wrong:
+ **System status checks** – monitor the AWS systems required to use your instance to ensure that they are working properly\. These checks detect problems with your instance that require AWS involvement to repair\. When a system status check fails, you can choose to wait for AWS to fix the issue or you can resolve it yourself \(for example, by stopping and restarting or terminating and replacing an instance\)\. Examples of problems that cause system status checks to fail include:
  + Loss of network connectivity
  + Loss of system power
  + Software issues on the physical host
  + Hardware issues on the physical host that impact network reachability

  For more information, see [Status checks for your instances](monitoring-system-instance-status-check.md)\.
+ **Instance status checks** – monitor the software and network configuration of your individual instance\. These checks detect problems that require your involvement to repair\. When an instance status check fails, typically you will need to address the problem yourself \(for example, by rebooting the instance or by making modifications in your operating system\)\. Examples of problems that may cause instance status checks to fail include:
  + Failed system status checks
  + Misconfigured networking or startup configuration
  + Exhausted memory
  + Corrupted file system
  + Incompatible kernel

  For more information, see [Status checks for your instances](monitoring-system-instance-status-check.md)\.
+ **Amazon CloudWatch alarms** – watch a single metric over a time period you specify, and perform one or more actions based on the value of the metric relative to a given threshold over a number of time periods\. The action is a notification sent to an Amazon Simple Notification Service \(Amazon SNS\) topic or Amazon EC2 Auto Scaling policy\. Alarms invoke actions for sustained state changes only\. CloudWatch alarms will not invoke actions simply because they are in a particular state; the state must have changed and been maintained for a specified number of periods\. For more information, see [Monitoring your instances using CloudWatch](using-cloudwatch.md)\.
+ **Amazon CloudWatch Events** – automate your AWS services and respond automatically to system events\. Events from AWS services are delivered to CloudWatch Events in near real time, and you can specify automated actions to take when an event matches a rule you write\. For more information, see [What is Amazon CloudWatch Events?](https://docs.aws.amazon.com/AmazonCloudWatch/latest/events/WhatIsCloudWatchEvents.html)\.
+ **Amazon CloudWatch Logs** – monitor, store, and access your log files from Amazon EC2 instances, AWS CloudTrail, or other sources\. For more information, see the [Amazon CloudWatch Logs User Guide](https://docs.aws.amazon.com/AmazonCloudWatch/latest/logs/)\.
+ **CloudWatch agent** – collect logs and system\-level metrics from both hosts and guests on your EC2 instances and on\-premises servers\. For more information, see [Collecting Metrics and Logs from Amazon EC2 Instances and On\-Premises Servers with the CloudWatch Agent](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/Install-CloudWatch-Agent.html) in the *Amazon CloudWatch User Guide*\.
+ **AWS Management Pack for Microsoft System Center Operations Manager** – links Amazon EC2 instances and the Windows or Linux operating systems running inside them\. The AWS Management Pack is an extension to Microsoft System Center Operations Manager\. It uses a designated computer in your datacenter \(called a watcher node\) and the Amazon Web Services APIs to remotely discover and collect information about your AWS resources\. For more information, see [AWS Management Pack for Microsoft System Center](AWSManagementPack.md)\.

## Manual monitoring tools<a name="monitoring_manual_tools"></a>

Another important part of monitoring Amazon EC2 involves manually monitoring those items that the monitoring scripts, status checks, and CloudWatch alarms don't cover\. The Amazon EC2 and CloudWatch console dashboards provide an at\-a\-glance view of the state of your Amazon EC2 environment\.
+ Amazon EC2 Dashboard shows:
  + Service Health and Scheduled Events by Region
  + Instance state
  + Status checks
  + Alarm status
  + Instance metric details \(In the navigation pane choose **Instances**, select an instance, and choose the **Monitoring** tab\)
  + Volume metric details \(In the navigation pane choose **Volumes**, select a volume, and choose the **Monitoring** tab\)
+ Amazon CloudWatch Dashboard shows:
  + Current alarms and status
  + Graphs of alarms and resources
  + Service health status

  In addition, you can use CloudWatch to do the following:
  + Graph Amazon EC2 monitoring data to troubleshoot issues and discover trends
  + Search and browse all your AWS resource metrics
  + Create and edit alarms to be notified of problems
  + See at\-a\-glance overviews of your alarms and AWS resources