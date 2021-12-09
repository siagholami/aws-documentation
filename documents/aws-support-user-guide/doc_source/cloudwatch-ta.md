# Monitoring Trusted Advisor checks<a name="cloudwatch-ta"></a>

AWS Trusted Advisor checks identify ways for you to reduce cost, increase performance, and improve security for your AWS account\. You can use Amazon CloudWatch Events to monitor the status of Trusted Advisor checks\. You can then use Amazon CloudWatch to create alarms on Trusted Advisor metrics\. These alarms notify you when the status changes for a Trusted Advisor check, such as an updated resource or a service quota that is reached\.

For example, Trusted Advisor provides the **Amazon S3 Bucket Permissions** check\. This check identifies if you have buckets that have open access permissions or allow access to any authenticated AWS user\. If a bucket permission changes, the status changes for the Trusted Advisor check\. CloudWatch Events detects this event and then sends you a notification so that you can take action\.

**Topics**
+ [Monitoring Trusted Advisor check results with Amazon CloudWatch Events](cloudwatch-events-ta.md)
+ [Creating Trusted Advisor alarms using CloudWatch](cloudwatch-metrics-ta.md)