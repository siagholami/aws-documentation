# Amazon MQ Broker Configuration Lifecycle<a name="amazon-mq-broker-configuration-lifecycle"></a>

Making changes to a configuration revision or an ActiveMQ user does *not* apply the changes immediately\. To apply your changes, you must [wait for the next maintenance window](amazon-mq-editing-managing-configurations.md#apply-configuration-revision-editing-console) or [reboot the broker](amazon-mq-rebooting-broker.md)\. For more information, see [Amazon MQ Broker Configuration Lifecycle](#amazon-mq-broker-configuration-lifecycle)\.

The following diagram illustrates the configuration lifecycle\.

**Important**  
The next scheduled maintenance window triggers a reboot\. If the broker is rebooted before the next scheduled maintenance window, the changes are applied after the reboot\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/images/amazon-mq-configuration-lifecycle.png)

For information about creating, editing, and managing configurations, see the following:
+ [Tutorial: Creating and Applying Amazon MQ Broker Configurations](amazon-mq-creating-applying-configurations.md)
+ [Tutorial: Editing Amazon MQ Broker Configurations and Managing Configuration Revisions](amazon-mq-editing-managing-configurations.md)
+ [Amazon MQ Broker Configuration Parameters](amazon-mq-broker-configuration-parameters.md)

For information about creating, editing, and deleting ActiveMQ users, see the following:
+ [Tutorial: Creating and Managing Amazon MQ Broker Users](amazon-mq-listing-managing-users.md)
+ [Users](amazon-mq-limits.md#activemq-user-limits)