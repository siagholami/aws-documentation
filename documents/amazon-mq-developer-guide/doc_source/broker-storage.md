# Storage<a name="broker-storage"></a>

By default, Amazon MQ uses Amazon Elastic File System \(Amazon EFS\) for broker storage\. To take advantage of high durability and replication across multiple Availability Zones, use Amazon EFS\. To take advantage of low latency and high throughput, use Amazon EBS\.

**Important**  
You can use Amazon EBS only with the `mq.m5` broker instance type family\.
Although you can change the *broker instance type*, you can't change the *broker storage type* after you create the broker\.
Amazon EBS replicates data within a single Availability Zone and doesn't support the [active/standby](active-standby-broker-deployment.md) deployment mode\.
When working with Amazon EBS, we recommend creating mechanisms that would allow your application to recreate the message data \(if necessary\), rather than using Amazon EBS as the sole message storage location for your broker\. For example, you can use [JMS or XA transactions](https://activemq.apache.org/how-do-transactions-work) or store your messages at a location from which they can be replayed or regenerated\.

## Differences between Storage Types<a name="differences-between-storage-types"></a>

The following table provides a brief overview of the differences between in\-memory, Amazon EFS, and Amazon EBS storage types\.


| Storage Type | Persistence | Example Use Case | Approximate Maximum Number of Messages Enqueued per Producer, per Second \(1KB Message\) | Replication | 
| --- | --- | --- | --- | --- | 
| In\-memory | Non\-persistent |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/broker-storage.html)  | 5,000 | None | 
| Amazon EBS | Persistent |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/broker-storage.html)  | 500 | Multiple copies within a single Availability Zone \(AZ\) | 
| Amazon EFS | Persistent | Financial transactions | 80 | Multiple copies across multiple AZs | 

In\-memory message storage provides the lowest latency and the highest throughput\. However, messages are lost during instance replacement or broker restart\.

Amazon EFS is designed to be highly durable, replicated across multiple AZs to prevent the loss of data resulting from the failure of any single component or an issue that affects the availability of an AZ\. Amazon EBS is optimized for throughput and replicated across multiple servers within a single AZ\.