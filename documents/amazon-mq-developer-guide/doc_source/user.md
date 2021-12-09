# User<a name="user"></a>

An ActiveMQ *user* is a person or an application that can access the queues and topics of an ActiveMQ broker\. You can configure users to have specific permissions\. For example, you can allow some users to access the [ActiveMQ Web Console](http://activemq.apache.org/web-console.html)\.

A *group* is a semantic label\. You can assign a group to a user and configure permissions for groups to send to, receive from, and administer specific queues and topics\.

**Important**  
Making changes to a user does *not* apply the changes to the user immediately\. To apply your changes, you must [wait for the next maintenance window](amazon-mq-editing-managing-configurations.md#apply-configuration-revision-editing-console) or [reboot the broker](amazon-mq-rebooting-broker.md)\. For more information, see [Amazon MQ Broker Configuration Lifecycle](amazon-mq-broker-configuration-lifecycle.md)\.

For information about users and groups, see the following in the Apache ActiveMQ documentation:
+ [Authorization](http://activemq.apache.org/security.html#Security-Authorization)
+ [Authorization Example](http://activemq.apache.org/security.html#Security-AuthorizationExample)

For information about creating, editing, and deleting ActiveMQ users, see the following:
+ [Tutorial: Creating and Managing Amazon MQ Broker Users](amazon-mq-listing-managing-users.md)
+ [Users](amazon-mq-limits.md#activemq-user-limits)

## Attributes<a name="user-attributes"></a>

For a full list of user attributes, see the following in the *Amazon MQ REST API Reference*:
+ [REST Operation ID: User](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-user.html)
+ [REST Operation ID: Users](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-users.html)