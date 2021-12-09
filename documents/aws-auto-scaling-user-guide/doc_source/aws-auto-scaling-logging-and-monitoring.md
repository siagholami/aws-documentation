# Logging and Monitoring in AWS Auto Scaling<a name="aws-auto-scaling-logging-and-monitoring"></a>

Monitoring is an important part of maintaining the reliability, availability, and performance of AWS Auto Scaling and your other AWS solutions\. You should collect monitoring data from all parts of your AWS solution so that you can more easily debug a multi\-point failure if one occurs\. AWS provides the following tools for logging and monitoring activities, and taking automatic actions when appropriate:

**Amazon CloudWatch Alarms**  
To detect unhealthy application behavior, CloudWatch helps you by automatically monitoring certain metrics for your AWS resources\. You can configure a CloudWatch alarm and set up an Amazon SNS notification that sends an email when a metric’s value is not what you expect or when certain anomalies are detected\. For example, you can be notified when network activity is suddenly higher or lower than a metric's expected value\. For more information, see the *[Amazon CloudWatch User Guide](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/)*\.

**AWS CloudTrail**  
AWS CloudTrail captures API calls and related events made by or on behalf of your AWS account\. Then it delivers the log files to an Amazon S3 bucket that you specify\. You can identify which users and accounts called AWS, the source IP address from which the calls were made, and when the calls occurred\. For more information, see the *[AWS CloudTrail User Guide](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/)*\. For information about the AWS Auto Scaling API calls that are logged by CloudTrail, see [Logging AWS Auto Scaling API Calls with CloudTrail](https://docs.aws.amazon.com/autoscaling/plans/APIReference/logging-using-cloudtrail.html)\.

**Amazon CloudWatch Logs**  
Amazon CloudWatch Logs enable you to monitor, store, and access your log files from Amazon EC2 instances, CloudTrail, and other sources\. CloudWatch Logs can monitor information in the log files and notify you when certain thresholds are met\. You can also archive your log data in highly durable storage\. For more information, see the *[Amazon CloudWatch Logs User Guide](https://docs.aws.amazon.com/AmazonCloudWatch/latest/logs/)*\.

**Amazon EventBridge**  
EventBridge delivers a near real time stream of system events that describe changes in AWS resources\. AWS Auto Scaling currently does not emit events\. However, you can write rules that trigger automated actions in other AWS services as a result of API calls made by AWS Auto Scaling\. For more information, see [Creating an EventBridge Rule That Triggers on an AWS API Call Using AWS CloudTrail](https://docs.aws.amazon.com/eventbridge/latest/userguide/create-eventbridge-cloudtrail-rule.html) in the *Amazon EventBridge User Guide*\. 

**Related topics**
+ [Monitoring Your Auto Scaling Instances and Groups](https://docs.aws.amazon.com/autoscaling/ec2/userguide/as-monitoring-features.html) in the *Amazon EC2 Auto Scaling User Guide*
+ [Application Auto Scaling Monitoring](https://docs.aws.amazon.com/autoscaling/application/userguide/monitoring-overview.html) in the *Application Auto Scaling User Guide*