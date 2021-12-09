# Monitoring Amazon CodeGuru Profiler with Amazon CloudWatch<a name="monitoring"></a>

 You can use Amazon CloudWatch to monitor the number of recommendations created on your profiling groups over time\. You can set a CloudWatch alarm that notifies you when the number of recommendations on a profiling group exceeds a threshold you set\. 

 For more information about creating and using CloudWatch alarms and metrics, see [Using Amazon CloudWatch metrics](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/AlarmThatSendsEmail.html)\. 

 You can track the following metric per profiling group\. 


****  

|   Metric   |   Description   | 
| --- | --- | 
| Recommendations |  The number of recommendations for a profiling group\. Units: Count Valid CloudWatch statistic: Maximum Valid CloudWatch period: Hourly  | 

**Topics**
+ [Monitoring profiling groups with CloudWatch metrics](cloudwatch-metric.md)
+ [Monitoring profiling groups with CloudWatch alarms](cloudwatch-alarm.md)