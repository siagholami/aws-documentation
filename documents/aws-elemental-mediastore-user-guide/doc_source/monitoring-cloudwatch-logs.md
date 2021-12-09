# CloudWatch Logs<a name="monitoring-cloudwatch-logs"></a>

Access logging provides detailed records for the requests that are made to objects in a container\. Access logs are useful for many applications, such as security and access audits\. They can also help you learn about your customer base and understand your MediaStore bill\. CloudWatch Logs are categorized as follows:
+ A log stream is a sequence of log events that share the same source\.
+ A log group is a group of log streams that share the same retention, monitoring, and access control settings\. When you enable access logging on a container, MediaStore creates a log group with a name such as `/aws/mediastore/MyContainerName`\. You can define log groups and specify which streams to put into each group\. There is no quota on the number of log streams that can belong to one log group\.

By default, logs are kept indefinitely and never expire\. You can adjust the retention policy for each log group, keeping the indefinite retention, or choosing a retention period from one day to 10 years\.

## Logging status changes take effect over time<a name="monitoring-cloudwatch-logs-timing"></a>

Changes to the logging status of a container take time to actually affect the delivery of log files\. For example, if you enable logging for container A, some requests made in the following hour might be logged, while others might not\. If you disable logging for container B, some logs for the next hour might continue to be delivered to, while others might not\. In all cases, the new settings eventually take effect without any further action on your part\.

## Best effort server log delivery<a name="monitoring-cloudwatch-logs-best-effort"></a>

Access log records are delivered on a best effort basis\. Most requests for a container that is properly configured for logging result in a delivered log record\. Most log records are delivered within a few hours of the time that they are recorded, but they can be delivered more frequently\.

The completeness and timeliness of access logging is not guaranteed\. The log record for a particular request might be delivered long after the request was actually processed, or it might not be delivered at all\. The purpose of access logs is to give you an idea of the nature of traffic against your container\. It is rare to lose log records, but access logging is not meant to be a complete accounting of all requests\.

It follows from the best\-effort nature of the access logging feature that the usage reports available at the AWS portal \(Billing and Cost Management reports on the [AWS Management Console](https://console.aws.amazon.com/)\) might include one or more access requests that do not appear in a delivered access log\.

## Programming considerations for access log format<a name="monitoring-cloudwatch-logs-programming-considerations"></a>

From time to time, we might extend the access log format by adding new fields\. Code that parses access logs must be written to handle additional fields that it does not understand\.