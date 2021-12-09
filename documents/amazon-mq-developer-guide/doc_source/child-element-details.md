# Amazon MQ Child Element Attributes<a name="child-element-details"></a>

The following is a detailed explanation of child element attributes\. For more information, see [XML Configuration](http://activemq.apache.org/xml-configuration.html) in the Apache ActiveMQ documentation\.

**Topics**
+ [authorizationEntry](#authorizationEntry)
+ [networkConnector](#networkConnector)
+ [kahaDB](#kahaDB)
+ [systemUsage](#systemUsage)

## authorizationEntry<a name="authorizationEntry"></a>

`authorizationEntry` is a child of the `authorizationEntries` child collection element\. 

### Attributes<a name="admin-read-write-attributes"></a>

#### admin\|read\|write<a name="admin-read-write"></a>

The permissions granted to a group of users\. For more information, see [Always Configure an Authorization Map](using-amazon-mq-securely.md#always-configure-authorization-map)\.

**Default:** `null`

### Example Configuration<a name="admin-read-write-example"></a>

```
<authorizationPlugin>
   <map>
      <authorizationMap>
         <authorizationEntries>
            <authorizationEntry admin="admins,activemq-webconsole" read="admins,users,activemq-webconsole" write="admins,activemq-webconsole" queue=">"/>
            <authorizationEntry admin="admins,activemq-webconsole" read="admins,users,activemq-webconsole" write="admins,activemq-webconsole" topic=">"/>
         </authorizationEntries>
      </authorizationMap>
   </map>
</authorizationPlugin>
```

## networkConnector<a name="networkConnector"></a>

`networkConnector` is a child of the `networkConnectors` child collection element\.

**Topics**
+ [Attributes](#networkConnector-attributes)
+ [Example Configurations](#networkConnector-example)

### Attributes<a name="networkConnector-attributes"></a>

#### conduitSubscriptions<a name="conduitSubscriptions"></a>

Specifies whether a network connection in a network of brokers treats multiple consumers subscribed to the same destination as one consumer\. For example, if `conduitSubscriptions` is set to `true` and two consumers connect to broker B and consume from a destination, broker B combines the subscriptions into a single logical subscription over the network connection to broker A, so that only a single copy of a message is forwarded from broker A to broker B\. 

**Note**  
Setting `conduitSubscriptions` to `true` can reduce redundant network traffic\. However, using this attribute can have implications for the load\-balancing of messages across consumers and might cause incorrect behavior in certain scenarios \(for example, with JMS message selectors or with durable topics\)\.

**Default:** `true`

#### duplex<a name="duplex"></a>

Specifies whether the connection in the network of brokers is used to produce *and* consume messages\. For example, if broker A creates a connection to broker B in non\-duplex mode, messages can be forwarded only from broker A to broker B\. However, if broker A creates a duplex connection to broker B, then broker B can forward messages to broker A without having to configure a `<networkConnector>`\.

**Default:** `false`

#### name<a name="name"></a>

The name of the bridge in the network of brokers\.

**Default:** `bridge`

#### uri<a name="uri"></a>

The wire\-level protocol endpoint for one of two brokers \(or for multiple brokers\) in a network of brokers\.

**Default:** `null`

#### username<a name="username"></a>

The username common to the brokers in a network of brokers\.

**Default:** `null`

### Example Configurations<a name="networkConnector-example"></a>

#### <a name="username"></a>

**Note**  
When using a `networkConnector` to define a network of brokers, don't include the password for the user common to your brokers\.

#### A Network of Brokers with Two Brokers<a name="example-network-of-brokers-two-brokers"></a>

In this configuration, two brokers are connected in a network of brokers\. The name of the network connector is `connector_1_to_2`, the username common to the brokers is `myCommonUser`, the connection is `duplex`, and the OpenWire endpoint URI is prefixed by `static:`, indicating a one\-to\-one connection between the brokers\.

```
<networkConnectors>
  <networkConnector name="connector_1_to_2" userName="myCommonUser" duplex="true"
    uri="static:(ssl://b-1234a5b6-78cd-901e-2fgh-3i45j6k178l9-1.mq.us-east-2.amazonaws.com:61617)"/>
</networkConnectors>
```

For more information, see [Step 2: Configure Network Connectors for Your Broker](amazon-mq-creating-configuring-network-of-brokers.md#creating-configuring-network-of-brokers-configure-network-connectors)\.

#### A Network of Brokers with Multiple Brokers<a name="example-network-of-brokers-multiple-brokers"></a>

In this configuration, multiple brokers are connected in a network of brokers\. The name of the network connector is `connector_1_to_2`, the username common to the brokers is `myCommonUser`, the connection is `duplex`, and the comma\-separated list of OpenWire endpoint URIs is prefixed by `masterslave:`, indicating a failover connection between the brokers\. The failover from broker to broker isn't randomized and reconnection attempts continue indefinitely\.

```
<networkConnectors>
  <networkConnector name="connector_1_to_2" userName="myCommonUser" duplex="true"
    uri="masterslave:(ssl://b-1234a5b6-78cd-901e-2fgh-3i45j6k178l9-1.mq.us-east-2.amazonaws.com:61617,
    ssl://b-9876l5k4-32ji-109h-8gfe-7d65c4b132a1-2.mq.us-east-2.amazonaws.com:61617)"/>
</networkConnectors>
```

**Note**  
We recommend using the `masterslave:` prefix for networks of brokers\. The prefix is identical to the more explicit `static:failover:()?randomize=false&maxReconnectAttempts=0` syntax\.

## kahaDB<a name="kahaDB"></a>

`kahaDB` is a child of the `persistenceAdapter` child collection element\.

### Attributes<a name="kahaDB-attributes"></a>

#### concurrentStoreAndDispatchQueues<a name="concurrentStoreAndDispatchQueues"></a>

Specifies whether to use concurrent store and dispatch for queues\. For more information, see [Disable Concurrent Store and Dispatch for Queues with Slow Consumers](ensuring-effective-amazon-mq-performance.md#disable-concurrent-store-and-dispatch-queues-flag-slow-consumers)\.

**Default:** `true`

#### journalDiskSyncInterval<a name="journalDiskSyncInterval"></a>

Interval \(ms\) for when to perform a disk sync if `journalDiskSyncStrategy=periodic`\. For more information, see the [Apache ActiveMQ kahaDB documentation](https://activemq.apache.org/kahadb)\.

**Default:** `1000`

#### journalDiskSyncStrategy<a name="journalDiskSyncStrategy"></a>

From ActiveMQ 5\.14\.0: this setting configures the disk sync policy\. For more information, see the [Apache ActiveMQ kahaDB documentation](https://activemq.apache.org/kahadb)\.

**Default:** `always`

**Note**  
The [ActiveMQ documentation](https://activemq.apache.org/kahadb) states that the data loss is limited to the duration of `journalDiskSyncInterval`, which has a default of 1s\. The data loss can be longer than the interval, but it is difficult to be precise\. Use caution\. 

#### preallocationStrategy<a name="preallocationStrategy"></a>

Configures how the broker will try to preallocate the journal files when a new journal file is needed\. For more information, see the [Apache ActiveMQ kahaDB documentation](https://activemq.apache.org/kahadb)\.

**Default:** `sparse_file`

### Example Configuration<a name="kahaDB-example"></a>

**Example**  

```
<broker xmlns="http://activemq.apache.org/schema/core">
    <persistenceAdapter>
       <kahaDB preallocationStrategy="zeros" concurrentStoreAndDispatchQueues="false" journalDiskSyncInterval="10000" journalDiskSyncStrategy="periodic"/>
   </persistenceAdapter>
</broker>
```

## systemUsage<a name="systemUsage"></a>

`systemUsage` is a child of the `systemUsage` child collection element\. It controls the maximum amount of space the broker will use before slowing down producers\. For more information, see [Producer Flow Control](http://activemq.apache.org/producer-flow-control.html) in the Apache ActiveMQ documentation\. 

### Child Element<a name="systemUsage-child"></a>

#### memoryUsage<a name="memoryUsage"></a>

 `memoryUsage` is a child of the `systemUsage` child element\. It manages memory usage\. Use `memoryUsage` to keep track of how much of something is being used so that you can control working set usage productively\. For more information, see [the schema](http://activemq.apache.org/schema/core/activemq-core-5.15.12-schema.html) in the Apache ActiveMQ documentation\.

##### Child Element<a name="memoryUsage-child"></a>

 `memoryUsage` is a child of the `memoryUsage` child element\. 

##### Attribute<a name="memeoryUsage-attribute"></a>

##### percentOfJvmHeap<a name="percentOfJvmHeap"></a>

Integer between 0 \(inclusive\) and 70 \(inclusive\)\.

*Default:* `70` 

### Attributes<a name="systemUsage-attributes"></a>

#### sendFailIfNoSpace<a name="sendFailIfNoSpace"></a>

Sets whether a `send()` method should fail if there is no space free\. The default value is false, which blocks the `send()` method until space becomes available\. For more information, see the [schema](http://activemq.apache.org/schema/core/activemq-core-5.15.12-schema.html) in the Apache Active MQ documentation\.

**Default:** `false`

#### sendFailIfNoSpaceAfterTimeout<a name="sendFailIfNoSpaceAfterTimeout"></a>

**Default:** `null`

#### Example Configuration<a name="systemUsage-example"></a>

**Example**  

```
<broker xmlns="http://activemq.apache.org/schema/core">
    <systemUsage>
      <systemUsage sendFailIfNoSpace="true" sendFailIfNoSpaceAfterTimeout="2000">
          <memoryUsage>
              <memoryUsage  percentOfJvmHeap="60" />
          </memoryUsage>>
      </systemUsage>
    </systemUsage>
</broker>
</persistenceAdapter>
```