# Tutorial: Connecting a Java Application to Your Amazon MQ Broker<a name="amazon-mq-connecting-application"></a>

After you create an Amazon MQ broker, you can connect your application to it\. The following examples show how you can use the Java Message Service \(JMS\) to create a connection to the broker, create a queue, and send a message\. For a complete, working Java example, see [Working Examples of Using Java Message Service \(JMS\) with ActiveMQ](amazon-mq-working-java-example.md)\.

You can connect to ActiveMQ brokers using [various ActiveMQ clients](http://activemq.apache.org/cross-language-clients.html)\. We recommend using the [ActiveMQ Client](https://mvnrepository.com/artifact/org.apache.activemq/activemq-client/5.15.0)\.

**Topics**
+ [Prerequisites](#connect-application-prerequisites-tutorial)
+ [To Create a Message Producer and Send a Message](#create-producer-send-message-tutorial)
+ [To Create a Message Consumer and Receive the Message](#create-consumer-receive-message-tutorial)

## Prerequisites<a name="connect-application-prerequisites-tutorial"></a>

### Enable VPC Attributes<a name="connect-application-enable-vpc-attributes-tutorial"></a>

To ensure that your broker is accessible within your VPC, you must enable the `enableDnsHostnames` and `enableDnsSupport` VPC attributes\. For more information, see [DNS Support in your VPC](https://docs.aws.amazon.com/vpc/latest/userguide/vpc-dns.html#vpc-dns-support) in the *Amazon VPC User Guide*\.

### Enable Inbound Connections<a name="connect-application-allow-inbound-connections-tutorial"></a>

1. Sign in to the [Amazon MQ console](https://console.aws.amazon.com/amazon-mq/)\.

1. From the broker list, choose the name of your broker \(for example, **MyBroker**\)\.

1. On the ***MyBroker*** page, in the **Connections** section, note the addresses and ports of the broker's ActiveMQ Web Console URL and wire\-level protocols\.

1. In the **Details** section, under **Security and network**, choose the name of your security group or ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/images/amazon-mq-tutorials-broker-details-link.png)\.

   The **Security Groups** page of the EC2 Dashboard is displayed\.

1. From the security group list, choose your security group\.

1. At the bottom of the page, choose **Inbound**, and then choose **Edit**\.

1. In the **Edit inbound rules** dialog box, add a rule for every URL or endpoint that you want to be publicly accessible \(the following example shows how to do this for an ActiveMQ Web Console\)\.

   1. Choose **Add Rule**\.

   1. For **Type**, select **Custom TCP**\.

   1. For **Port Range**, type the ActiveMQ Web Console port \(`8162`\)\.

   1. For **Source**, leave **Custom** selected and then type the IP address of the system that you want to be able to access the ActiveMQ Web Console \(for example, `192.0.2.1`\)\.

   1. Choose **Save**\.

      Your broker can now accept inbound connections\.

### Add Java Dependencies<a name="connect-application-java-dependencies-tutorial"></a>

Add the `activemq-client.jar` and `activemq-pool.jar` packages to your Java class path\. The following example shows these dependencies in a Maven project `pom.xml` file\.

```
<dependencies>
    <dependency>
        <groupId>org.apache.activemq</groupId>
        <artifactId>activemq-client</artifactId>
        <version>5.15.8</version>
    </dependency>
    <dependency>
        <groupId>org.apache.activemq</groupId>
        <artifactId>activemq-pool</artifactId>
        <version>5.15.8</version>
    </dependency>
</dependencies>
```

For more information about `activemq-client.jar`, see [Initial Configuration](http://activemq.apache.org/initial-configuration.html) in the Apache ActiveMQ documentation\.

**Important**  
In the following example code, producers and consumers run in a single thread\. For production systems \(or to test broker instance failover\), make sure that your producers and consumers run on separate hosts or threads\.

## To Create a Message Producer and Send a Message<a name="create-producer-send-message-tutorial"></a>

1. Create a JMS pooled connection factory for the message producer using your broker's endpoint and then call the `createConnection` method against the factory\.
**Note**  
For an active/standby broker, Amazon MQ provides two ActiveMQ Web Console URLs, but only one URL is active at a time\. Likewise, Amazon MQ provides two endpoints for each wire\-level protocol, but only one endpoint is active in each pair at a time\. The `-1` and `-2` suffixes denote a redundant pair\. For more information, see [Amazon MQ Broker Architecture](amazon-mq-broker-architecture.md)\)\.  
For wire\-level protocol endpoints, you can allow your application to connect to either endpoint by using the [Failover Transport](http://activemq.apache.org/failover-transport-reference.html)\.

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
**Note**  
Message producers should always use the `PooledConnectionFactory` class\. For more information, see [Always Use Connection Pooling](connecting-to-amazon-mq.md#always-use-connection-pooling)\.

1. Create a session, a queue named `MyQueue`, and a message producer\.

   ```
   // Create a session.
   final Session producerSession = producerConnection.createSession(false, Session.AUTO_ACKNOWLEDGE);
   
   // Create a queue named "MyQueue".
   final Destination producerDestination = producerSession.createQueue("MyQueue");
   
   // Create a producer from the session to the queue.
   final MessageProducer producer = producerSession.createProducer(producerDestination);
   producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
   ```

1. Create the message string `"Hello from Amazon MQ!"` and then send the message\.

   ```
   // Create a message.
   final String text = "Hello from Amazon MQ!";
   TextMessage producerMessage = producerSession.createTextMessage(text);
   
   // Send the message.
   producer.send(producerMessage);
   System.out.println("Message sent.");
   ```

1. Clean up the producer\.

   ```
   producer.close();
   producerSession.close();
   producerConnection.close();
   ```

## To Create a Message Consumer and Receive the Message<a name="create-consumer-receive-message-tutorial"></a>

1. Create a JMS connection factory for the message producer using your broker's endpoint and then call the `createConnection` method against the factory\.

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
**Note**  
Message consumers should *never* use the `PooledConnectionFactory` class\. For more information, see [Always Use Connection Pooling](connecting-to-amazon-mq.md#always-use-connection-pooling)\.

1. Create a session, a queue named `MyQueue`, and a message consumer\.

   ```
   // Create a session.
   final Session consumerSession = consumerConnection.createSession(false, Session.AUTO_ACKNOWLEDGE);
   
   // Create a queue named "MyQueue".
   final Destination consumerDestination = consumerSession.createQueue("MyQueue");
   
   // Create a message consumer from the session to the queue.
   final MessageConsumer consumer = consumerSession.createConsumer(consumerDestination);
   ```

1. Begin to wait for messages and receive the message when it arrives\.

   ```
   // Begin to wait for messages.
   final Message consumerMessage = consumer.receive(1000);
   
   // Receive the message when it arrives.
   final TextMessage consumerTextMessage = (TextMessage) consumerMessage;
   System.out.println("Message received: " + consumerTextMessage.getText());
   ```
**Note**  
Unlike AWS messaging services \(such as Amazon SQS\), the consumer is constantly connected to the broker\.

1. Close the consumer, session, and connection\.

   ```
   consumer.close();
   consumerSession.close();
   consumerConnection.close();
   ```