# Logging and monitoring in Amazon Chime<a name="monitoring-overview"></a>

Monitoring is an important part of maintaining the reliability, availability, and performance of Amazon Chime and your other AWS solutions\. AWS provides the following tools to monitor Amazon Chime, report issues, and take automatic actions when appropriate:
+ *Amazon CloudWatch* monitors in real time your AWS resources and the applications that you run on AWS\. You can collect and track metrics, create customized dashboards, and set alarms that notify you or take actions when a specified metric reaches a threshold that you specify\. For example, you can have CloudWatch track CPU usage or other metrics of your Amazon EC2 instances and automatically launch new instances when needed\. For more information, see the [Amazon CloudWatch User Guide](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/)\.
+ *Amazon EventBridge* delivers a near real\-time stream of system events that describe changes in AWS resources\. EventBridge enables automated event\-driven computing\. This lets you write rules that watch for certain events, and trigger automated actions in other AWS services when these events happen\. For more information, see the [Amazon EventBridge User Guide](https://docs.aws.amazon.com/eventbridge/latest/userguide/)\.
+ *Amazon CloudWatch Logs* lets you monitor, store, and access your log files from Amazon EC2 instances, CloudTrail, and other sources\. CloudWatch Logs can monitor information in the log files and notify you when certain thresholds are met\. You can also archive your log data in highly durable storage\. For more information, see the [Amazon CloudWatch Logs User Guide](https://docs.aws.amazon.com/AmazonCloudWatch/latest/logs/)\.
+ *AWS CloudTrail* captures API calls and related events made by or on behalf of your AWS account\. It then delivers the log files to an Amazon S3 bucket that you specify\. You can identify which users and accounts called AWS, the source IP address from which the calls were made, and when the calls occurred\. For more information, see the [AWS CloudTrail User Guide](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/)\.

**Topics**
+ [Monitoring Amazon Chime with Amazon CloudWatch](monitoring-cloudwatch.md)
+ [Automating Amazon Chime with EventBridge](automating-chime-with-cloudwatch-events.md)
+ [Logging Amazon Chime API calls with AWS CloudTrail](cloudtrail.md)