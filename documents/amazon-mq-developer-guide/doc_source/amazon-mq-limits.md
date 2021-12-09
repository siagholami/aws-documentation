# Quotas in Amazon MQ<a name="amazon-mq-limits"></a>

This topic lists quotas within Amazon MQ\. Many of the following quotas can be changed for specific AWS accounts\. To request an increase for a limit, see [AWS Service Quotas](https://docs.aws.amazon.com/general/latest/gr/aws_service_limits.html) in the *Amazon Web Services General Reference*\.

**Topics**
+ [Quotas Related to Brokers](#broker-limits)
+ [Quotas Related to Configurations](#configuration-limits)
+ [Quotas Related to Users](#activemq-user-limits)
+ [Quotas Related to Data Storage](#data-storage-limits)
+ [Quotas Related to API Throttling](#api-throttling-limits)

## Brokers<a name="broker-limits"></a>

The following table lists quotas related to Amazon MQ brokers\.


| Limit | Description | 
| --- | --- | 
| Broker name |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/amazon-mq-limits.html)  | 
| Brokers per AWS account, per region | 20 | 
| Broker configuration history depth | 10 | 
| Connections per wire\-level protocol | 1,000 \(100 for mq\.t3\.micro and mq\.t2\.micro brokers\) | 
| Security groups per broker | 5 | 
| Destinations \(queues and topics\) monitored in CloudWatch | CloudWatch monitors only the first 200 destinations\. | 

## Configurations<a name="configuration-limits"></a>

The following table lists quotas related to Amazon MQ configurations\.


| Limit | Description | 
| --- | --- | 
| Configuration name |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/amazon-mq-limits.html)  | 
| Configurations per AWS account | 1,000 | 
| Revisions per configuration | 300 | 

## Users<a name="activemq-user-limits"></a>

The following table lists quotas related to Amazon MQ users\.


| Limit | Description | 
| --- | --- | 
| Username |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/amazon-mq-limits.html)  | 
| Password |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/amazon-mq-limits.html)  | 
| Users per broker | 250 | 
| Groups per user | 20 | 

## Data Storage<a name="data-storage-limits"></a>

The following table lists quotas related to Amazon MQ data storage\.


| Limit | Description | 
| --- | --- | 
| Storage capacity per new mq\.t3\.micro or mq\.t2\.micro broker\. See [Instance Types](broker.md#broker-instance-types)\. | 20 GB | 
| Storage capacity per broker for other instance types\. See [Instance Types](broker.md#broker-instance-types)\. | 200 GB | 
| Storage for scheduled jobs \([JobSchedulerUsage](https://activemq.apache.org/maven/apidocs/org/apache/activemq/usage/JobSchedulerUsage.html)\) that are [backed by Amazon EBS](broker-storage.md) | 50 GB | 
| Temporary storage for brokers\. | 50 GB | 

## API Throttling<a name="api-throttling-limits"></a>

The following throttling quotas are aggregated per AWS account, *across all Amazon MQ APIs* to maintain service bandwidth\. For more information about Amazon MQ APIs, see the *[Amazon MQ REST API Reference](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/)*\.

**Important**  
These quotas don't apply to ActiveMQ broker messaging APIs\. For example, Amazon MQ doesn't throttle the sending or receiving of messages\.


| Bucket Size | Refill Rate per Second | 
| --- | --- | 
| 100 | 15 | 