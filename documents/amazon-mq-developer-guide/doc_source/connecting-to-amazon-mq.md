# Connecting to Amazon MQ<a name="connecting-to-amazon-mq"></a>

The following design patterns can improve the effectiveness of your application's connection to your Amazon MQ broker\.

**Topics**
+ [Never Modify or Delete the Amazon MQ Elastic Network Interface](#never-modify-delete-elastic-network-interface)
+ [Always Use Connection Pooling](#always-use-connection-pooling)
+ [Always Use the Failover Transport to Connect to Multiple Broker Endpoints](#always-use-failover-transport-connect-to-multiple-broker-endpoints)
+ [Avoid Using Message Selectors](#avoid-using-message-selectors)
+ [Prefer Virtual Destinations to Durable Subscriptions](#prefer-virtual-destinations-to-durable-subscriptions)

## Never Modify or Delete the Amazon MQ Elastic Network Interface<a name="never-modify-delete-elastic-network-interface"></a>

When you first [create an Amazon MQ broker](amazon-mq-creating-configuring-broker.md), Amazon MQ provisions an [elastic network interface](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_ElasticNetworkInterfaces.html) in the [Virtual Private Cloud \(VPC\)](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_Introduction.html) under your account and, thus, requires a number of [EC2 permissions](security-api-authentication-authorization.md)\. The network interface allows your client \(producer or consumer\) to communicate with the Amazon MQ broker\. The network interface is considered to be within the *service scope* of Amazon MQ, despite being part of your account's VPC\.

**Warning**  
You must not modify or delete this network interface\. Modifying or deleting the network interface can cause a permanent loss of connection between your VPC and your broker\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/images/amazon-mq-network-configuration-architecture-vpc-elastic-network-interface.png)

## Always Use Connection Pooling<a name="always-use-connection-pooling"></a>

In a scenario with a single producer and single consumer \(such as the [Getting Started with Amazon MQ](amazon-mq-getting-started.md) tutorial\), you can use a single [http://activemq.apache.org/maven/apidocs/org/apache/activemq/ActiveMQConnectionFactory.html](http://activemq.apache.org/maven/apidocs/org/apache/activemq/ActiveMQConnectionFactory.html) class for every producer and consumer\. For example:

```
// Create a connection factory.
final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(wireLevelEndpoint);

// Pass the username and password.
connectionFactory.setUserName(activeMqUsername);
connectionFactory.setPassword(activeMqPassword);

// Establish a connection for the consumer.
final Connection consumerConnection = connectionFactory.createConnection();
consumerConnection.start();
```

However, in more realistic scenarios with multiple producers and consumers, it can be costly and inefficient to create a large number of connections for multiple producers\. In these scenarios, you should group multiple producer requests using the [http://activemq.apache.org/maven/apidocs/org/apache/activemq/jms/pool/PooledConnectionFactory.html](http://activemq.apache.org/maven/apidocs/org/apache/activemq/jms/pool/PooledConnectionFactory.html) class\. For example:

**Note**  
Message consumers should *never* use the `PooledConnectionFactory` class\.

```
// Create a connection factory.
final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(wireLevelEndpoint);

// Pass the username and password.
connectionFactory.setUserName(activeMqUsername);
connectionFactory.setPassword(activeMqPassword);

// Create a pooled connection factory.
final PooledConnectionFactory pooledConnectionFactory = new PooledConnectionFactory();
pooledConnectionFactory.setConnectionFactory(connectionFactory);
pooledConnectionFactory.setMaxConnections(10);

// Establish a connection for the producer.
final Connection producerConnection = pooledConnectionFactory.createConnection();
producerConnection.start();
```

## Always Use the Failover Transport to Connect to Multiple Broker Endpoints<a name="always-use-failover-transport-connect-to-multiple-broker-endpoints"></a>

If you need your application to connect to multiple broker endpoints—for example, when you use an [active/standby](amazon-mq-creating-configuring-broker.md) deployment mode or when you [migrate from an on\-premises message broker to Amazon MQ](amazon-mq-migrating.md)—use the [Failover Transport](http://activemq.apache.org/failover-transport-reference.html) to allow your consumers to randomly connect to either one\. For example:

```
failover:(ssl://b-1234a5b6-78cd-901e-2fgh-3i45j6k178l9-1.mq.us-east-2.amazonaws.com:61617,ssl://b-9876l5k4-32ji-109h-8gfe-7d65c4b132a1-2.mq.us-east-2.amazonaws.com:61617)?randomize=true
```

## Avoid Using Message Selectors<a name="avoid-using-message-selectors"></a>

It is possible to use [JMS selectors](https://docs.oracle.com/cd/E19798-01/821-1841/bncer/index.html) to attach filters to topic subscriptions \(to route messages to consumers based on their content\)\. However, the use of JMS selectors fills up the Amazon MQ broker's filter buffer, preventing it from filtering messages\.

In general, avoid letting consumers route messages because, for optimal decoupling of consumers and producers, both the consumer and the producer should be ephemeral\.

## Prefer Virtual Destinations to Durable Subscriptions<a name="prefer-virtual-destinations-to-durable-subscriptions"></a>

A [durable subscription](http://activemq.apache.org/how-do-durable-queues-and-topics-work.html) can help ensure that the consumer receives all messages published to a topic, for example, after a lost connection is restored\. However, the use of durable subscriptions also precludes the use of competing consumers and might have performance issues at scale\. Consider using [virtual destinations](http://activemq.apache.org/virtual-destinations.html) instead\.