# What Is Amazon MQ?<a name="welcome"></a>

Amazon MQ is a managed message broker service for [Apache ActiveMQ](http://activemq.apache.org/) that makes it easy to migrate to a message broker in the cloud\. A *message broker* allows software applications and components to communicate using various programming languages, operating systems, and formal messaging protocols\.

[![AWS Videos](http://img.youtube.com/vi/https://www.youtube.com/embed/iDT1zFpy1kE?rel=0&amp;controls=0&amp;showinfo=0/0.jpg)](http://www.youtube.com/watch?v=https://www.youtube.com/embed/iDT1zFpy1kE?rel=0&amp;controls=0&amp;showinfo=0)

Amazon MQ works with your existing applications and services without the need to manage, operate, or maintain your own messaging system\.

**Topics**
+ [What Are the Main Benefits of Amazon MQ?](#main-benefits)
+ [How is Amazon MQ Different from Amazon SQS or Amazon SNS?](#difference-from-sqs-sns)
+ [How Can I Get Started with Amazon MQ?](#get-started)
+ [We Want to Hear from You](#amazon-mq-we-want-to-hear-from-you)

## What Are the Main Benefits of Amazon MQ?<a name="main-benefits"></a>
+ **Security** – You control [who can create and modify brokers](security-api-authentication-authorization.md) and [who can send messages to and receive messages from](security-authentication-authorization.md) an ActiveMQ broker\. Amazon MQ encrypts messages at rest and in transit using encryption keys that it manages and stores securely\.
+ **Durability** – To ensure the safety of your messages, Amazon MQ stores them on [redundant shared storage](broker-storage.md)\.
+ **Availability** – You can create a [single\-instance broker](single-broker-deployment.md) \(comprised of one broker in one Availability Zone\), or an [active/standby broker for high availability](active-standby-broker-deployment.md) \(comprised of two brokers in two different Availability Zones\)\. For either broker type, Amazon MQ automatically provisions infrastructure for high durability\.
+ **Compatibility** – Amazon MQ supports industry\-standard APIs and protocols so you can [migrate from your existing message broker](amazon-mq-migrating.md) without rewriting [application code](amazon-mq-working-java-example.md)\.
+ **Operation offloading** – You can [configure many aspects of your ActiveMQ broker](amazon-mq-broker-configuration-parameters.md), such as predefined destinations, destination policies, authorization policies, and plugins\. Amazon MQ controls some of these configuration elements, such as network transports and storage, simplifying the maintenance and administration of your messaging system in the cloud\.
+ **Simplified authentication** – You can [authenticate Amazon MQ users ](security-authentication-authorization.md#integrate-ldap)through the credentials stored in your lightweight directory access protocol \(LDAP\) server\. You can also add, delete, and modify Amazon MQ users and assign permissions to topics and queues through it\. Management operations like creating, updating and deleting brokers still require IAM credentials and are not integrated with LDAP\. 

## How Is Amazon MQ Different from Amazon SQS or Amazon SNS?<a name="difference-from-sqs-sns"></a>

Amazon MQ is a managed message broker service that provides compatibility with many popular message brokers\. We recommend Amazon MQ for migrating applications from existing message brokers that rely on compatibility with APIs such as JMS or protocols such as AMQP, MQTT, OpenWire, and STOMP\.

[Amazon SQS](https://aws.amazon.com/sqs/) and [Amazon SNS](https://aws.amazon.com/sns/) are queue and topic services that are highly scalable, simple to use, and don't require you to set up message brokers\. We recommend these services for new applications that can benefit from nearly unlimited scalability and simple APIs\.

## How Can I Get Started with Amazon MQ?<a name="get-started"></a>
+ To create your first broker with Amazon MQ, see [Getting Started with Amazon MQ](amazon-mq-getting-started.md)\.
+ To discover the functionality and architecture of Amazon MQ, see [How Amazon MQ Works](amazon-mq-how-it-works.md)\.
+ To find out the guidelines and caveats that will help you make the most of Amazon MQ, see [Best Practices for Amazon MQ](amazon-mq-best-practices.md)\.
+ To learn about Amazon MQ REST APIs, see the *[Amazon MQ REST API Reference](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/)*\.
+ To learn about Amazon MQ AWS CLI commands, see [Amazon MQ in the *AWS CLI Command Reference*](https://docs.aws.amazon.com/cli/latest/reference/mq/index.html)\.

## We Want to Hear from You<a name="amazon-mq-we-want-to-hear-from-you"></a>

We welcome your feedback\. To contact us, visit the [Amazon MQ Discussion Forum](https://forums.aws.amazon.com/forum.jspa?forumID=279)\.