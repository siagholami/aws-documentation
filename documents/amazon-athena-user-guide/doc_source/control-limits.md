# Controlling Costs and Monitoring Queries with CloudWatch Metrics and Events<a name="control-limits"></a>

Workgroups allow you to set data usage control limits per query or per workgroup, set up alarms when those limits are exceeded, and publish query metrics to CloudWatch\.

In each workgroup, you can:
+ Configure **Data usage controls** per query and per workgroup, and establish actions that will be taken if queries breach the thresholds\.
+ View and analyze query metrics, and publish them to CloudWatch\. If you create a workgroup in the console, the setting for publishing the metrics to CloudWatch is selected for you\. If you use the API operations, you must [enable publishing the metrics](athena-cloudwatch-metrics-enable.md)\. When metrics are published, they are displayed under the **Metrics** tab in the **Workgroups** panel\. Metrics are disabled by default for the primary workgroup\. 

**Topics**
+ [Enabling CloudWatch Query Metrics](athena-cloudwatch-metrics-enable.md)
+ [Monitoring Athena Queries with CloudWatch Metrics](query-metrics-viewing.md)
+ [Monitoring Athena Queries with CloudWatch Events](athena-cloudwatch-events.md)
+ [Setting Data Usage Control Limits](workgroups-setting-control-limits-cloudwatch.md)