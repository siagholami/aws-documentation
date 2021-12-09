# Monitor your Classic Load Balancer<a name="elb-monitor-logs"></a>

You can use the following features to monitor your load balancers, analyze traffic patterns, and troubleshoot issues with your load balancers and back\-end instances\.

**CloudWatch metrics**  
Elastic Load Balancing publishes data points to Amazon CloudWatch about your load balancers and back\-end instances\. CloudWatch enables you to retrieve statistics about those data points as an ordered set of time\-series data, known as *metrics*\. You can use these metrics to verify that your system is performing as expected\. For more information, see [CloudWatch metrics for your Classic Load Balancer](elb-cloudwatch-metrics.md)\.

**Elastic Load Balancing access logs**  
The access logs for Elastic Load Balancing capture detailed information for requests made to your load balancer and stores them as log files in the Amazon S3 bucket that you specify\. Each log contains details such as the time a request was received, the client's IP address, latencies, request path, and server responses\. You can use these access logs to analyze traffic patterns and to troubleshoot your back\-end applications\. For more information, see [Access logs for your Classic Load Balancer](access-log-collection.md)\.

**CloudTrail logs**  
AWS CloudTrail enables you to keep track of the calls made to the Elastic Load Balancing API by or on behalf of your AWS account\. CloudTrail stores the information in log files in the Amazon S3 bucket that you specify\. You can use these log files to monitor activity of your load balancers by determining which requests were made, the source IP addresses where the requests came from, who made the request, when the request was made, and so on\. For more information, see [Logging API calls for your Classic Load Balancer using AWS CloudTrail](ELB-API-Logs.md)\.