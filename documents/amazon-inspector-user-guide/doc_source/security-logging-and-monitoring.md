# Logging and monitoring in Amazon Inspector<a name="security-logging-and-monitoring"></a>

Amazon Inspector is integrated with AWS CloudTrail, a service that provides a record of actions taken by a user, role, or an AWS service in Amazon Inspector\. CloudTrail captures all API calls for Amazon Inspector as events, including calls from the Amazon Inspector console and code calls to the Amazon Inspector API operations\.

For information on using CloudTrail logging in Amazon Inspector, see [Logging Amazon Inspector API calls with AWS CloudTrail](logging-using-cloudtrail.md)\.

You can monitor Amazon Inspector using Amazon CloudWatch, which collects and processes raw data into readable, near\-real time metrics\. By default, Amazon Inspector sends metric data to CloudWatch in 5\-minute periods\.

For information on using CloudWatch with Amazon Inspector, see [Monitoring Amazon Inspector using Amazon CloudWatch](using-cloudwatch.md)\.