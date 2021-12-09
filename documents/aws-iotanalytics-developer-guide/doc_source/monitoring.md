# Logging and monitoring in AWS IoT Analytics<a name="monitoring"></a>

AWS provides tools that you can use to monitor AWS IoT Analytics\. You can configure some of these tools to do the monitoring for you\. Some of the tools require manual intervention\. We recommend that you automate monitoring tasks as much as possible\.

## Automated monitoring tools<a name="automated-monitoring"></a>

You can use the following automated monitoring tools to watch AWS IoT and report when something is wrong:
+ **Amazon CloudWatch Logs** \- Monitor, store, and access your log files from AWS CloudTrail or other sources\. For more information, see [What is AWS CloudTrail](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-user-guide.html) Monitoring Log Files in the *Amazon CloudWatch User Guide*\.
+ **AWS CloudTrail log monitoring** \- Share log files between accounts, monitor CloudTrail log files in real time by sending them to CloudWatch Logs, write log\-processing applications in Java, and validate that your log files have not changed after delivery by CloudTrail\. For more information, see [Working with CloudTrail log files](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-working-with-log-files.html) in the *AWS CloudTrail User Guide*\.

## Manual monitoring tools<a name="manual-monitoring"></a>

Another important part of monitoring AWS IoT involves manually monitoring those items that the CloudWatch alarms don't cover\. The AWS IoT, CloudWatch, and other AWS service console dashboards provide an at\-a\-glance view of the state of your AWS environment\. We recommend that you also check the log files on AWS IoT Analytics\.
+ The AWS IoT Analytics console shows:
  + Channels
  + Pipelines
  + Data stores
  + Data sets
  + Notebooks
  + Settings
  + Learn
+ The CloudWatch home page shows:
  + Current alarms and status
  + Graphs of alarms and resources
  + Service health status

  In addition, you can use CloudWatch to do the following:
  + Create [customized dashboards](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/CloudWatch_Dashboards.html) to monitor the services you care about
  + Graph metric data to troubleshoot issues and discover trends
  + Search and browse all your AWS resource metrics
  + Create and edit alarms to be notified of problems