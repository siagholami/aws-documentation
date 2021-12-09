# Application Auto Scaling Monitoring<a name="monitoring-overview"></a>

Monitoring is an important part of maintaining the reliability, availability, and performance of Application Auto Scaling and your other AWS solutions\. AWS provides monitoring tools to watch Application Auto Scaling, report when something is wrong, and take automatic actions when appropriate\.

You can use the following features to help you manage your AWS resources:

**Amazon EventBridge**  
EventBridge delivers a near real time stream of system events that describe changes in AWS resources\. EventBridge enables automated event\-driven computing\. You can write rules that watch for certain events and trigger automated actions in other AWS services when these events happen\. For more information, see [Application Auto Scaling Events and EventBridge](monitoring-eventbridge.md)\.  
With AWS CloudTrail, you can also create an EventBridge rule that triggers on API calls made by Application Auto Scaling\. For more information, see [Creating an EventBridge Rule That Triggers on an AWS API Call Using AWS CloudTrail](https://docs.aws.amazon.com/eventbridge/latest/userguide/create-eventbridge-cloudtrail-rule.html) in the *Amazon EventBridge User Guide*\. 

**AWS Personal Health Dashboard**  
The Personal Health Dashboard \(PHD\) displays information, and also provides notifications that are triggered by changes in the health of AWS resources\. The information is presented in two ways: on a dashboard that shows recent and upcoming events organized by category, and in a full event log that shows all events from the past 90 days\. For more information, see [Personal Health Dashboard Notifications for Application Auto Scaling](monitoring-personal-health-dashboard.md)\.

**Amazon CloudWatch Dashboards**  
Amazon CloudWatch monitors your AWS resources and the applications that you run on AWS in real time\. CloudWatch dashboards are customizable home pages in the CloudWatch console\. You can use these pages to monitor your resources in a single view, even including resources that are spread across different Regions\. You can use CloudWatch dashboards to create customized views of the metrics and alarms for your AWS resources\. For more information, see [Building Dashboards with CloudWatch](monitoring-cloudwatch.md)\.

**AWS CloudTrail**  
AWS CloudTrail captures API calls and related events made by or on behalf of your AWS account\. Then it delivers the log files to an Amazon S3 bucket that you specify\. You can identify which users and accounts called AWS, the source IP address from which the calls were made, and when the calls occurred\. For more information, see the [AWS CloudTrail User Guide](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/)\. For information about the Application Auto Scaling API calls that are logged by CloudTrail, see [Logging Application Auto Scaling API Calls with CloudTrail](https://docs.aws.amazon.com/autoscaling/application/APIReference/logging-using-cloudtrail.html)\.

**Amazon CloudWatch Logs**  
Amazon CloudWatch Logs enable you to monitor, store, and access your log files from Amazon EC2 instances, CloudTrail, and other sources\. CloudWatch Logs can monitor information in the log files and notify you when certain thresholds are met\. You can also archive your log data in highly durable storage\. For more information, see the [Amazon CloudWatch Logs User Guide](https://docs.aws.amazon.com/AmazonCloudWatch/latest/logs/)\.