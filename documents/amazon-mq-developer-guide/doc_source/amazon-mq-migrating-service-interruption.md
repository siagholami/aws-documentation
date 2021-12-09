# Migrating to Amazon MQ with Service Interruption<a name="amazon-mq-migrating-service-interruption"></a>

The following diagrams illustrate the scenario of migrating from an on\-premises message broker to an Amazon MQ broker in the AWS Cloud with service interruption\.

**Important**  
This scenario requires you to point your producer to your Amazon MQ broker's endpoint *before* you do the same for your consumers\. This sequence ensures that any messages in a FIFO \(first\-in\-first\-out\) queue maintain their order during the migration process\. If you're not concerned about message ordering, follow the steps in [Migrating to Amazon MQ without Service Interruption](amazon-mq-migrating-no-service-interruption.md)\.


| On\-Premises Message Broker | Migration to Amazon MQ with FIFO \(Ordered\) Queues | 
| --- | --- | 
|  ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/images/amazon-mq-migration-on-premises-single-producer.png)  |  ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/images/amazon-mq-migration-ordered-queues-service-interruption.png)  | 

## To migrate to Amazon MQ with service interruption<a name="migrate-with-service-interruption"></a>

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/images/number-1-red.png) [Create and configure an Amazon MQ broker](amazon-mq-creating-configuring-broker.md) and note your broker's endpoint, for example:

```
ssl://b-1234a5b6-78cd-901e-2fgh-3i45j6k178l9-1.mq.us-east-2.amazonaws.com:61617
```

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/images/number-2-red.png) Stop your existing producer, point the producer to your Amazon MQ broker's endpoint, and then restart the producer\.

**Important**  
This step requires an interruption of your application's functionality because no consumers are yet consuming messages from the Amazon MQ broker\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/images/number-3-red.png) Wait for your consumers to drain the destinations on your on\-premises broker\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/images/number-4-red.png) Do one of the following:
+ One by one, point each existing consumer to your Amazon MQ broker's endpoint\.
+ Create new consumers and point them to your Amazon MQ broker's endpoint\.
**Note**  
If you scale up your consumer fleet during the migration process, it is a best practice to scale it down afterward\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/images/number-5-red.png) Stop your on\-premises broker\.