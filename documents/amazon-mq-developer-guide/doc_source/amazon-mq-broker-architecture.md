# Amazon MQ Broker Architecture<a name="amazon-mq-broker-architecture"></a>

Amazon MQ brokers can be created as *single\-instance brokers* or *active/standby brokers*\. For both deployment modes, Amazon MQ provides high durability by storing its data redundantly\.

**Note**  
Amazon MQ uses [Apache KahaDB](http://activemq.apache.org/kahadb.html) as its data store\. Other data stores, such as JDBC and LevelDB, aren't supported\.

You can access your brokers by using [any programming language that ActiveMQ supports](http://activemq.apache.org/cross-language-clients.html) and by enabling TLS explicitly for the following protocols:
+ [AMQP](http://activemq.apache.org/amqp.html)
+ [MQTT](http://activemq.apache.org/mqtt.html)
+ MQTT over [WebSocket](http://activemq.apache.org/websockets.html)
+ [OpenWire](http://activemq.apache.org/openwire.html)
+ [STOMP](http://activemq.apache.org/stomp.html)
+ STOMP over WebSocket

**Topics**
+ [Amazon MQ Single\-Instance Broker](single-broker-deployment.md)
+ [Amazon MQ Active/Standby Broker for High Availability](active-standby-broker-deployment.md)
+ [Amazon MQ Network of Brokers](network-of-brokers.md)
+ [Amazon MQ Broker Configuration Lifecycle](amazon-mq-broker-configuration-lifecycle.md)