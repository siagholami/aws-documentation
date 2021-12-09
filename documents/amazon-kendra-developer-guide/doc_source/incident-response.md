--------

--------

# Logging and monitoring in Amazon Kendra<a name="incident-response"></a>

Monitoring is an important part of maintaining the reliability, availability, and performance of your Amazon Kendra applications\. To monitor Amazon Kendra API calls, you can use AWS CloudTrail\. To monitor the status of your jobs, use Amazon CloudWatch Logs\.
+ **Amazon CloudWatch Alarms** — Using CloudWatch alarms, you watch a single metric over a time period that you specify\. If the metric exceeds a given threshold, a notification is sent to an Amazon SNS topic or AWS Auto Scaling policy\. CloudWatch alarms do not invoke actions when a metric is in a particular state\. Rather the state must have changed and been maintained for a specified number of periods\. For more information, see [Monitoring Amazon Kendra with Amazon CloudWatch](cloudwatch-metrics.md)\.
+ **AWS CloudTrail Logs** — CloudTrail provides a record of actions taken by a user, role, or an AWS service in Amazon Kendra\. Using the information collected by CloudTrail, you can determine the request that was made to Amazon Kendra, the IP address from which the request was made, who made the request, when it was made, and additional details\. For more information, see [Logging Amazon Kendra API calls with AWS CloudTrail logs](cloudtrail.md)\.