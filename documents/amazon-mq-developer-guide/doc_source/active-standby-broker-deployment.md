# Amazon MQ Active/Standby Broker for High Availability<a name="active-standby-broker-deployment"></a>

An *active/standby broker* is comprised of two brokers in two different Availability Zones, configured in a *redundant pair*\. These brokers communicate synchronously with your application, and with Amazon EFS\. For more information, see [Storage](broker-storage.md)\.

Usually, only one of the broker instances is active at any time, while the other broker instance is on standby\. If one of the broker instances malfunctions or undergoes maintenance, it takes Amazon MQ a short while to take the inactive instance out of service\. This allows the healthy standby instance to become active and to begin accepting incoming communications\. When you reboot a broker, the failover takes only a few seconds\.

For an active/standby broker, Amazon MQ provides two ActiveMQ Web Console URLs, but only one URL is active at a time\. Likewise, Amazon MQ provides two endpoints for each wire\-level protocol, but only one endpoint is active in each pair at a time\. The `-1` and `-2` suffixes denote a redundant pair\. For wire\-level protocol endpoints, you can allow your application to connect to either endpoint by using the [Failover Transport](http://activemq.apache.org/failover-transport-reference.html)\.

The following diagram illustrates an active/standby broker with Amazon EFS storage\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/images/amazon-mq-architecture-active-standby-deployment-efs.png)