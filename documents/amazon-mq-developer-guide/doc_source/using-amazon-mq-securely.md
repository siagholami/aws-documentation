# Security Best Practices for Amazon MQ<a name="using-amazon-mq-securely"></a>

The following design patterns can improve the security of your Amazon MQ broker\.

**Topics**
+ [Prefer Brokers without Public Accessibility](#prefer-brokers-without-public-accessibility)
+ [Always Use Client\-Side Encryption as a Complement to TLS](#always-use-client-side-encryption-complement-tls)
+ [Always Configure an Authorization Map](#always-configure-authorization-map)
+ [Block Unnecessary Protocols with VPC Security Groups](#amazon-mq-vpc-security-groups)

## Prefer Brokers without Public Accessibility<a name="prefer-brokers-without-public-accessibility"></a>

Brokers created without public accessibility can't be accessed from outside of your [VPC](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_Introduction.html)\. This greatly reduces your broker's susceptibility to Distributed Denial of Service \(DDoS\) attacks from the public internet\. For more information, see [Accessing the ActiveMQ Web Console of a Broker without Public Accessibility](accessing-web-console-of-broker-without-private-accessibility.md) in this guide and [How to Help Prepare for DDoS Attacks by Reducing Your Attack Surface](http://aws.amazon.com/blogs/security/how-to-help-prepare-for-ddos-attacks-by-reducing-your-attack-surface/) on the AWS Security Blog\.

## Always Use Client\-Side Encryption as a Complement to TLS<a name="always-use-client-side-encryption-complement-tls"></a>

You can access your brokers using the following protocols with TLS enabled:
+ [AMQP](http://activemq.apache.org/amqp.html)
+ [MQTT](http://activemq.apache.org/mqtt.html)
+ MQTT over [WebSocket](http://activemq.apache.org/websockets.html)
+ [OpenWire](http://activemq.apache.org/openwire.html)
+ [STOMP](http://activemq.apache.org/stomp.html)
+ STOMP over WebSocket

Amazon MQ encrypts messages at rest and in transit using encryption keys that it manages and stores securely\. For additional security, we highly recommend designing your application to use client\-side encryption\. For more information, see the *[AWS Encryption SDK Developer Guide](https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/)*\.

## Always Configure an Authorization Map<a name="always-configure-authorization-map"></a>

Because ActiveMQ has no authorization map configured by default, any authenticated user can perform any action on the broker\. Thus, it is a best practice to restrict permissions *by group*\. For more information, see ``\.

## Block Unnecessary Protocols with VPC Security Groups<a name="amazon-mq-vpc-security-groups"></a>

To improve security, you should restrict the connections of unnecessary protocols and ports by properly configuring your Amazon VPC Security Group\. For instance, to restrict access to most protocols while allowing access to OpenWire and the ActiveMQ web console, you could allow access to only 61617 and 8162\. This limits your exposure by blocking protocols you are not using, while allowing OpenWire and the ActiveMQ web console to function normally\.

Allow only the protocol ports that you are using\.
+ AMQP: 5671
+ MQTT: 8883
+ OpenWire: 61617
+ STOMP: 61614
+ WebSocket: 61619

For more information see\.
+ [Step 2: \(Optional\) Configure Additional Broker Settings](amazon-mq-creating-configuring-broker.md#configure-advanced-broker-settings-console)
+ [Security Groups for your VPC](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_SecurityGroups.html)
+ [Default Security Group for Your VPC](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_SecurityGroups.html#DefaultSecurityGroup)
+ [Working with Security Groups](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_SecurityGroups.html#WorkingWithSecurityGroups)