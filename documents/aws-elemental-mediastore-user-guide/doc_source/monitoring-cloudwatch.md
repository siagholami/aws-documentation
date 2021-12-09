# Monitoring AWS Elemental MediaStore with Amazon CloudWatch<a name="monitoring-cloudwatch"></a>

You can monitor AWS Elemental MediaStore using CloudWatch, which collects raw data and processes it into readable, near real\-time metrics\. These statistics are kept for 15 months, so that you can access historical information and gain a better perspective on how your web application or service is performing\. You can also set alarms that watch for certain thresholds, and send notifications or take actions when those thresholds are met\. For more information, see the [Amazon CloudWatch User Guide](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/)\.

AWS provides the following monitoring tools to watch MediaStore, report when something is wrong, and take automatic actions when appropriate:
+ Amazon CloudWatch Logs allows you to monitor, store, and access your log files from AWS services such as AWS Elemental MediaStore\. You can use CloudWatch Logs to monitor applications and systems using log data\. For example, CloudWatch Logs can track the number of errors that occur in your application logs and send you a notification whenever the rate of errors exceeds a threshold that you specify\. CloudWatch Logs uses your log data for monitoring, so no code changes are required\. For example, you can monitor application logs for specific literal terms \(such as "ValidationException"\) or count the number of `PutObject` requests that were made during a certain time period\. When the term that you are searching for is found, CloudWatch Logs reports the data to a CloudWatch metric that you specify\. Log data is encrypted while in transit and while it is at rest\. 
+ Amazon CloudWatch Events delivers system events that describe changes in AWS resources, such as MediaStore objects\. You can set up rules to match events \(such as a `DeleteObject` request\) and route them to one or more target functions or streams\. CloudWatch Events becomes aware of operational changes as they occur\. In addition, CloudWatch Events responds to these operational changes and takes corrective action as necessary, by sending messages to respond to the environment, activating functions, making changes, and capturing state information\.