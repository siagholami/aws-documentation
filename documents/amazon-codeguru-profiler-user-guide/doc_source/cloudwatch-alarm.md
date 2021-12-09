# Monitoring profiling groups with CloudWatch alarms<a name="cloudwatch-alarm"></a>

 You can create an Amazon CloudWatch alarm for your profiling groups to monitor their recommendations\. 

An alarm watches the number of recommendations for a profiling group over a period of time that you specify\. You set one or more actions that happen when the number of recommendations for a profiling group exeeds a count over a number of time periods you choose\. For example, you can specify that an Amazon SNS notification is sent when more than five recommendations are generated for a profiling group within an hour\. 

 A user or role must have CloudWatch `PutMetricAlarm` permissions to create an alarm\. For more information, see [Using identity\-based policies for CodeGuru Profiler](auth-and-access-control-iam-identity-based-access-control.md) and [Amazon CloudWatch permissions reference](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/permissions-reference-cw.html) in the *Amazon CloudWatch User Guide*\. 

**To create a CloudWatch alarm for CodeGuru Profiler recommendations**

1. Sign in to the AWS Management Console and open the CloudWatch console at [https://console\.aws\.amazon\.com/cloudwatch/](https://console.aws.amazon.com/cloudwatch/)\.

1.  In the navigation pane, choose **Alarms**\. 

1.  Choose **Create alarm**\. 

1.  Choose **Select metric**\. 

1.  Choose **AWS/CodeGuruProfiler**\. 

1.  Choose **ProfilingGroupName**\. Then choose a metric to create an alarm for\. 

1.  Continue through the process to create your alarm\. 

   For more information about setting up CloudWatch alarms in the CloudWatch console, see [Using Amazon CloudWatch alarms](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/AlarmThatSendsEmail.html) in the *Amazon CloudWatch User Guide*\. 