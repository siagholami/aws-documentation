# Monitoring AWS Health<a name="monitoring-logging-health-events"></a>

Monitoring is an important part of maintaining the reliability, availability, and performance of AWS Health and your other AWS solutions\. AWS provides the following monitoring tools to watch AWS Health, report when something is wrong, and take actions when appropriate:
+ Amazon CloudWatch monitors your AWS resources and the applications you run on AWS in real time\. You can collect and track metrics, create customized dashboards, and set alarms that notify you or take actions when a specified metric reaches a threshold that you specify\. For more information, see the [Amazon CloudWatch User Guide](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/)\.

  You can use Amazon CloudWatch Events so that you're notified about AWS Health events that might affect your services and resources\. For example, if AWS Health publishes an event about your Amazon EC2 instances, you can use these notifications to take action and update or replace your resources as needed\. For more information, see [Monitor for AWS Health events with Amazon CloudWatch Events](cloudwatch-events-health.md)\.
+ AWS CloudTrail captures API calls and related events made by or on behalf of your AWS account and delivers the log files to an Amazon S3 bucket that you specify\. You can identify which users and accounts called AWS, the source IP address from which the calls were made, and when the calls occurred\. For more information, see the [AWS CloudTrail User Guide](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/)\.

**Topics**
+ [Logging AWS Health API calls with AWS CloudTrail](logging-using-cloudtrail.md)