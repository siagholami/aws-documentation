# Amazon MQ Network of Brokers<a name="network-of-brokers"></a>

Amazon MQ supports ActiveMQ's network of brokers feature\.

A *network of brokers* is comprised of multiple simultaneously active [single\-instance brokers](single-broker-deployment.md) or [active/standby brokers](active-standby-broker-deployment.md)\. You can configure networks of brokers in a variety of [topologies](#nob-topologies) \(for example, *concentrator*, *hub\-and\-spokes*, *tree*, or *mesh*\), depending on your application's needs, such as high availability and scalability\. For instance, a [hub and spoke](#nob-topologies-hub) network of brokers can increase resiliency, preserving messages if one broker is not reachable\. A network of brokers with a [concentrator](#nob-topologies-concentrator) topology can collect messages from a larger number of brokers accepting incoming messages, and concentrate them to more central brokers, to better handle the load of many incoming messages\.

For a tutorial and detailed configuration information, see the following:
+ [Tutorial: Creating and Configuring an Amazon MQ Network of Brokers](amazon-mq-creating-configuring-network-of-brokers.md)
+ [Configure Your Network of Brokers Correctly](ensuring-effective-amazon-mq-performance.md#network-of-brokers-configure-correctly)
+ ``
+ ``
+ [Networks of Brokers](http://activemq.apache.org/networks-of-brokers.html) in the ActiveMQ documentation

The following are benefits of using a network of brokers:
+ Creating a network of brokers allows you to increase your aggregate throughput and maximum producer and consumer connection count by adding broker instances\.
+ You can ensure better availability by allowing your producers and consumers to be aware of multiple active broker instances\. This allows them to reconnect to a new instance if the one they're currently connected to becomes unavailable\.
+ Because producers and consumers can reconnect to another node in the network of brokers immediately, and because there's no need to wait for a standby broker instance to become promoted, client reconnection within a network of brokers is faster than for an [active/standby broker for high availability](active-standby-broker-deployment.md)\.

**Topics**
+ [How Does a Network of Brokers Work?](#how-does-it-work)
+ [How Does a Network of Brokers Handle Credentials?](#how-does-it-handle-credentials)
+ [Sample Blueprints](#sample-deployments)
+ [Network of Brokers Topologies](#nob-topologies)
+ [ Cross Region](#how-to-configure-cross-region)
+ [Dynamic Failover With Transport Connectors](#transport-connectors)

## How Does a Network of Brokers Work?<a name="how-does-it-work"></a>

Amazon MQ supports the ActiveMQ network of brokers feature in a number of ways\. First, you can edit the parameters within each broker's configuration to create a network of brokers, just as you would with native ActiveMQ\. Second, Amazon MQ has sample blueprints that use AWS CloudFormation to automate the creation of a network of brokers\. You can deploy these sample blueprints directly from the Amazon MQ console, or you can edit the related AWS CloudFormation templates to create your own topologies and configurations\.

A network of brokers is established by connecting one broker to another using network connectors\. Once connected, these brokers provide message forwarding\. For instance, if *Broker1* establishes a network connector to *Broker2*, messages on *Broker1* are forwarded to *Broker2* if there is a consumer on that broker for the queue or topic\. If the network connector is configured as `duplex`, messages are also forwarded from *Broker2* to *Broker1*\. Network connectors are configured in the broker *configuration*\. See, [Configuration](configuration.md)\. For instance, here is and example `networkConnector` entry in a broker configuration:

```
<networkConnectors>
  <networkConnector name="connector_1_to_2" userName="myCommonUser" duplex="true"
    uri="static:(ssl://b-1234a5b6-78cd-901e-2fgh-3i45j6k178l9-1.mq.us-east-2.amazonaws.com:61617)"/>
</networkConnectors>
```

A network of brokers ensures that messages flow from one broker instance to another, forwarding messages only to the broker instances that have corresponding consumers\. For the benefit of broker instances adjacent to each other within the network, ActiveMQ sends messages to *advisory topics* about producers and consumers connecting to and disconnecting from the network\. When a broker instance receives information about a producer that consumes from a particular destination, the broker instance begins to forward messages\. For more information, see [Advisory Topics](https://activemq.apache.org/advisory-message.html) in the ActiveMQ documentation\.

## How Does a Network of Brokers Handle Credentials?<a name="how-does-it-handle-credentials"></a>

For broker A to connect to broker B in a network, broker A must use valid credentials, like any other producer or consumer\. Instead of providing a password in broker A's `<networkConnector>` configuration, you must first create a user on broker A with the same values as another user on broker B \(these are *separate, unique* users that share the same username and password values\)\. When you specify the `userName` attribute in the `<networkConnector>` configuration, Amazon MQ will add the password automatically at runtime\.

**Important**  
Don't specify the `password` attribute for the `<networkConnector>`\. We don't recommend storing plaintext passwords in broker configuration files, because this makes the passwords visible in the Amazon MQ console\. For more information, see [Step 2: Configure Network Connectors for Your Broker](amazon-mq-creating-configuring-network-of-brokers.md#creating-configuring-network-of-brokers-configure-network-connectors)\.

Brokers must be in the same VPC or in peered VPCs\. For more information, see [Prerequisites](amazon-mq-creating-configuring-network-of-brokers.md#creating-configuring-network-of-brokers-create-brokers) in the [Creating and Configuring a Network of Brokers](amazon-mq-creating-configuring-network-of-brokers.md) tutorial\.

## Sample Blueprints<a name="sample-deployments"></a>

To get started using a Network of Brokers, Amazon MQ provides sample blueprints\. These sample blueprints create a Network of Brokers deployment, and all related resources using, AWS CloudFormation\. The two sample blueprints available are: 

1. Mesh network of single instance brokers

1. Mesh network of active/standby brokers

![\[Sample deployments\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/images/amazon-mq-sample-deployments.png)

From the **Create brokers** page, select one of the sample blueprints and choose **Next**\. Once the resources have been created, review the generated brokers and their configurations in the Amazon MQ console\.

By creating brokers and configuring different `networkConnector` elements in the broker configurations, you can create a network of brokers in many different topologies\. For more information on configuring a network of brokers, see [Networks of Brokers](http://activemq.apache.org/networks-of-brokers.html) in the ActiveMQ documentation\.

## Network of Brokers Topologies<a name="nob-topologies"></a>

By deploying brokers, and then configuring `networkConnector` entries in their configurations, you can build a network of brokers using different network topologies\. A network connector provides on\-demand message forwarding between connected brokers\. Connections can be configured as duplex, where messages are forwarded both ways between brokers, or not duplex, where the forwarding only propagates from one broker to the other\. For example, if we have a duplex connection between *Broker1* and *Broker2*, messages will be forwarded from each to the other if there is a consumer\.

![\[Duplex connector\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/images/amazon-mq-nob-duplex.png)

With a duplex network connector, messages are forwarded from each broker to the other\. These are forwarded *on\-demand*: if there is a consumer on *Broker2* for a message on *Broker1*, the message is forwarded\. Similarly, if there is a consumer on *Broker1* for a message on *Broker2* the message is also forwarded\.

For non\-duplex connections, messages are forwarded only from one broker to the other\. In this example, if there is a consumer on *Broker2* for a message on *Broker1*, the message is forwarded\. But messages will not be forwarded from *Broker2* to *Broker1*\.

![\[One way connector\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/images/amazon-mq-nob-notduplex.png)

Using both duplex and non\-duplex network connectors, it is possible to build a network of brokers in any number of network topologies\. 

**Note**  
In each of the network topology examples, the `networkConnector` elements reference the endpoint of the brokers they connect to\. Replace the broker endpoint entries in the `uri` attributes with the endpoints of your brokers\. See, [Tutorial: Listing Amazon MQ Brokers and Viewing Broker Details](amazon-mq-listing-brokers.md)\.

### Mesh Topology<a name="nob-topologies-mesh"></a>

A mesh topology provides multiple brokers that are all connected to each other\. This simple example connects three single\-instance brokers, but you can configure more brokers as a mesh\. 

![\[Mesh topology\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/images/amazon-mq-nob-mesh.png)

This topology, and one that includes a mesh of *active/standby* pairs of brokers, can be created using sample blueprints in the Amazon MQ console\. You can create these sample blueprint deployment to see a working network of brokers, and review how they are configured\. 

 You can configure a three broker mesh network like this by adding a network connector to *Broker1* that makes duplex connections to both *Broker2* and *Broker3*, and a single duplex connection between *Broker2* and *Broker3*\.

*Network connectors for Broker1:*

```
<networkConnectors>
    <networkConnector name="connector_1_to_2" userName="myCommonUser" duplex="true"
        uri="static:(ssl://b-9876l5k4-32ji-109h-8gfe-7d65c4b132a1-2.mq.us-east-2.amazonaws.com:61617)"/>
    <networkConnector name="connector_1_to_3" userName="myCommonUser" duplex="true"
        uri="static:(ssl://b-743c885d-2244-4c95-af67-a85017ff234e-3.mq.us-east-2.amazonaws.com:61617)"/>
</networkConnectors>
```

*Network connectors for Broker2:*

```
<networkConnectors>
    <networkConnector name="connector_2_to_3" userName="myCommonUser" duplex="true"
        uri="static:(ssl://b-743c885d-2244-4c95-af67-a85017ff234e-3.mq.us-east-2.amazonaws.com:61617)"/>
</networkConnectors>
```

By adding the above connectors to the configurations of *Broker1* and *Broker2*, you can create a mesh between these three brokers that forwards message between all the brokers on demand\. For more information, see [Amazon MQ Broker Configuration Parameters](amazon-mq-broker-configuration-parameters.md)\.

### Hub and Spoke Topology<a name="nob-topologies-hub"></a>

In a hub and spoke topology, messages are preserved if there is a disruption to any broker on a spoke\. Messages are forwarded throughout, and only the central *Broker1* is critical to the network’s operation\. 

![\[Hub and spoke topology\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/images/amazon-mq-nob-hub.png)

To configure the hub and spoke network of brokers in this example, you could add a `networkConnector` to each of the brokers on the spokes in the configuration of *Broker1*\. 

```
<networkConnectors>
    <networkConnector name="connector_hub_and_spoke_2" userName="myCommonUser" duplex="true"
        uri="static:(ssl://b-1234a5b6-78cd-901e-2fgh-3i45j6k178l9-1.mq.us-east-2.amazonaws.com:61617)"/>
    <networkConnector name="connector_hub_and_spoke_3" userName="myCommonUser" duplex="true"
        uri="static:(ssl://b-9876l5k4-32ji-109h-8gfe-7d65c4b132a1-2.mq.us-east-2.amazonaws.com:61617)"/>
    <networkConnector name="connector_hub_and_spoke_4" userName="myCommonUser" duplex="true"
        uri="static:(ssl://b-743c885d-2244-4c95-af67-a85017ff234e-3.mq.us-east-2.amazonaws.com:61617)"/>
    <networkConnector name="connector_hub_and_spoke_5" userName="myCommonUser" duplex="true"
        uri="static:(ssl://b-62a7fb31-d51c-466a-a873-905cd660b553-4.mq.us-east-2.amazonaws.com:61617)"/>
</networkConnectors>
```

### Concentrator Topology<a name="nob-topologies-concentrator"></a>

In this example topology, the three brokers on the bottom can handle a large number of connections, and those messages are concentrated to *Broker1* and *Broker2*\. Each of the other brokers has a non\-duplex connection to the more central brokers\. To scale the capacity of this topology, you can add additional brokers that receive messages and concentrate those messages in *Broker1* and *Broker2*\. 

![\[Concentrator topology\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/images/amazon-mq-nob-concentrator.png)

To configure this topology, each of the brokers on the bottom would contain a network connector to each of the brokers they are concentrating messages to\.

*Network connectors for Broker3:*

```
<networkConnectors>
    <networkConnector name="3_to_1" userName="myCommonUser" duplex="false"
        uri="static:(ssl://b-1234a5b6-78cd-901e-2fgh-3i45j6k178l9-1.mq.us-east-2.amazonaws.com:61617)"/>
    <networkConnector name="3_to_2" userName="myCommonUser" duplex="false"
        uri="static:(ssl://b-9876l5k4-32ji-109h-8gfe-7d65c4b132a1-2.mq.us-east-2.amazonaws.com:61617)"/>
</networkConnectors>
```

*Network connectors for Broker4:*

```
<networkConnectors>
    <networkConnector name="4_to_1" userName="myCommonUser" duplex="false"
        uri="static:(ssl://b-1234a5b6-78cd-901e-2fgh-3i45j6k178l9-1.mq.us-east-2.amazonaws.com:61617)"/>
    <networkConnector name="4_to_2" userName="myCommonUser" duplex="false"
        uri="static:(ssl://b-1234a5b6-78cd-901e-2fgh-3i45j6k178l9-1.mq.us-east-2.amazonaws.com:61617)"/>
</networkConnectors>
```

*Network connectors for Broker5:*

```
<networkConnectors>
    <networkConnector name="5_to_1" userName="myCommonUser" duplex="false"
        uri="static:(ssl://b-1234a5b6-78cd-901e-2fgh-3i45j6k178l9-1.mq.us-east-2.amazonaws.com:61617)"/>
    <networkConnector name="5_to_2" userName="myCommonUser" duplex="false"
        uri="static:(ssl://b-9876l5k4-32ji-109h-8gfe-7d65c4b132a1-2.mq.us-east-2.amazonaws.com:61617)"/>
</networkConnectors>
```

##  Cross Region<a name="how-to-configure-cross-region"></a>

To configure a network of brokers that spans AWS regions, deploy brokers in those regions, and configure network connectors to the endpoints of those brokers\.

![\[Cross-region mesh topology\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/images/amazon-mq-nob-cross-region.png)

To configure a network of brokers like this example, you could add `networkConnectors` entries to the configurations of *Broker1* and *Broker4* that reference the wire\-level endpoints of those brokers\.

*Network connectors for Broker1:*

```
<networkConnectors>
    <networkConnector name="1_to_2" userName="myCommonUser" duplex="true"
        uri="static:(ssl://b-9876l5k4-32ji-109h-8gfe-7d65c4b132a1-2.mq.us-east-2.amazonaws.com:61617)"/>
    <networkConnector name="1_to_3" userName="myCommonUser" duplex="true"
        uri="static:(ssl://b-743c885d-2244-4c95-af67-a85017ff234e-3.mq.us-east-2.amazonaws.com:61617)"/>
    <networkConnector name="1_to_4" userName="myCommonUser" duplex="true"
        uri="static:(ssl://b-62a7fb31-d51c-466a-a873-905cd660b553-4.mq.us-east-2.amazonaws.com:61617)"/>
</networkConnectors>
```

*Network connector for Broker2:*

```
<networkConnectors>
    <networkConnector name="2_to_3" userName="myCommonUser" duplex="true"
        uri="static:(ssl://b-743c885d-2244-4c95-af67-a85017ff234e-3.mq.us-east-2.amazonaws.com:61617)"/>
</networkConnectors>
```

*Network connectors for Broker4:*

```
<networkConnectors>
    <networkConnector name="4_to_3" userName="myCommonUser" duplex="true"
        uri="static:(ssl://b-743c885d-2244-4c95-af67-a85017ff234e-3.mq.us-east-2.amazonaws.com:61617)"/>
    <networkConnector name="4_to_2" userName="myCommonUser" duplex="true"
        uri="static:(ssl://b-9876l5k4-32ji-109h-8gfe-7d65c4b132a1-2.mq.us-east-2.amazonaws.com:61617)"/>      
</networkConnectors>
```

## Dynamic Failover With Transport Connectors<a name="transport-connectors"></a>

In addition to configuring `networkConnector` elements, you can configure your broker `transportConnector` options to enable dynamic failover, and to rebalance connections when brokers are added or removed from the network\. 

```
<transportConnectors>
  <transportConnector name="openwire" updateClusterClients="true" rebalanceClusterClients="true" updateClusterClientsOnRemove="true"/>
</transportConnectors>
```

In this example both `updateClusterClients` and `rebalanceClusterClients` are set to `true`\. In this case clients will be provided a list of brokers in the network, and will request them to rebalance if a new broker joins\.

Available options:
+ `updateClusterClients`: Passes information to clients about changes in the network of broker topology\.
+ `rebalanceClusterClients`: Causes clients to re\-balance across brokers when a new broker is added to a network of brokers\.
+ `updateClusterClientsOnRemove`: Updates clients with topology information when a broker leaves a network of brokers\.

When `updateClusterClients` is set to true, clients can be configured to connect to a single broker in a network of brokers\. 

```
failover:(ssl://b-1234a5b6-78cd-901e-2fgh-3i45j6k178l9-1.mq.us-east-2.amazonaws.com:61617)
```

When a new broker connects, it will be receive a list of URIs of all brokers in the network\. If the connection to the broker fails, it can dynamically switch to one of the brokers provided when it connected\.

For more information on failover, see [Broker\-side Options for Failover](http://activemq.apache.org/failover-transport-reference.html#FailoverTransportReference-Broker-sideOptionsforFailover) in the Active MQ documentation\.