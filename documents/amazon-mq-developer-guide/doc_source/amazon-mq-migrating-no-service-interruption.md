# Migrating to Amazon MQ without Service Interruption<a name="amazon-mq-migrating-no-service-interruption"></a>

The following diagrams illustrate the scenario of migrating from an on\-premises message broker to an Amazon MQ broker in the AWS Cloud without service interruption\.

**Important**  
This scenario might cause messages to be delivered out of order\. If you're concerned about message ordering, follow the steps in [Migrating to Amazon MQ with Service Interruption](amazon-mq-migrating-service-interruption.md)\.


| On\-Premises Message Broker | Migration to Amazon MQ with Standard \(Unordered\) Queues | 
| --- | --- | 
|  ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/images/amazon-mq-migration-on-premises-multiple-producers.png)  |  ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/images/amazon-mq-migration-unordered-queues-no-interruption.png)  | 

## To migrate to Amazon MQ without service interruption<a name="migrate-without-service-interruption"></a>

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/images/number-1-red.png)[Create and configure an Amazon MQ broker](amazon-mq-creating-configuring-broker.md) and note your broker's endpoint, for example:

```
ssl://b-1234a5b6-78cd-901e-2fgh-3i45j6k178l9-1.mq.us-east-2.amazonaws.com:61617
```

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/images/number-2-red.png) For either of the following cases, use the [Failover Transport](http://activemq.apache.org/failover-transport-reference.html) to allow your consumers to randomly connect to your on\-premises broker's endpoint or your Amazon MQ broker's endpoint\. For example:

```
failover:(ssl://on-premises-broker.example.com:61617,ssl://b-1234a5b6-78cd-901e-2fgh-3i45j6k178l9-1.mq.us-east-2.amazonaws.com:61617)?randomize=true
```

Do one of the following:
+ One by one, point each existing consumer to your Amazon MQ broker's endpoint\.
+ Create new consumers and point them to your Amazon MQ broker's endpoint\.
**Note**  
If you scale up your consumer fleet during the migration process, it is a best practice to scale it down afterward\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/images/number-3-red.png) One by one, stop each existing producer, point the producer to your Amazon MQ broker's endpoint, and then restart the producer\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/images/number-4-red.png) Wait for your consumers to drain the destinations on your on\-premises broker\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/images/number-5-red.png) Change your consumers' Failover transport to include only your Amazon MQ broker's endpoint\. For example:

```
failover:(ssl://b-1234a5b6-78cd-901e-2fgh-3i45j6k178l9-1.mq.us-east-2.amazonaws.com:61617)
```

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/images/number-6-red.png) Stop your on\-premises broker\.