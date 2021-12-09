# Logging and monitoring in AWS Elemental MediaStore<a name="incident-response"></a>

This section provides an overview of the options for logging and monitoring in AWS Elemental MediaStore for security purposes\. For more information about logging and monitoring in MediaStore, see [Monitoring and tagging in AWS Elemental MediaStore](monitoring.md)\.

Monitoring is an important part of maintaining the reliability, availability, and performance of AWS Elemental MediaStore and your AWS solutions\. You should collect monitoring data from all parts of your AWS solution so that you can more easily debug a multi\-point failure if one occurs\. AWS provides several tools for monitoring your MediaStore resources and responding to potential incidents\.

## Amazon CloudWatch alarms<a name="incident-response-cloudwatch-alarms"></a>

Using CloudWatch alarms, you watch a single metric over a time period that you specify\. If the metric exceeds a given threshold, a notification is sent to an Amazon SNS topic or AWS Auto Scaling policy\. CloudWatch alarms don't invoke actions because they are in a particular state\. Rather, the state must have changed and been maintained for a specified number of periods\. For more information, see [Monitoring with CloudWatch](monitoring-cloudwatch.md)\.

## AWS CloudTrail logs<a name="incident-response-cloudtrail-logs"></a>

CloudTrail provides a record of actions taken by a user, role, or an AWS service in AWS Elemental MediaStore\. Using the information collected by CloudTrail, you can determine the request that was made to MediaStore, the IP address from which the request was made, who made the request, when it was made, and additional details\. For more information, see [Logging API calls with CloudTrail](logging-using-cloudtrail.md)\.

## AWS Trusted Advisor<a name="incident-response-trust-advisor"></a>

Trusted Advisor draws upon best practices learned from serving hundreds of thousands of AWS customers\. Trusted Advisor inspects your AWS environment and then makes recommendations when opportunities exist to save money, improve system availability and performance, or help close security gaps\. All AWS customers have access to five Trusted Advisor checks\. Customers with a Business or Enterprise support plan can view all Trusted Advisor checks\.

For more information, see [AWS Trusted Advisor](https://docs.aws.amazon.com/awssupport/latest/user/getting-started.html#trusted-advisor)\.