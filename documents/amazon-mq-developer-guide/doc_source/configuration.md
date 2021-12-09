# Configuration<a name="configuration"></a>

A *configuration* contains all of the settings for your ActiveMQ broker, in XML format \(similar to ActiveMQ's `activemq.xml` file\)\. You can create a configuration before creating any brokers\. You can then apply the configuration to one or more brokers\.

**Important**  
Making changes to a configuration does *not* apply the changes to the broker immediately\. To apply your changes, you must [wait for the next maintenance window](amazon-mq-editing-managing-configurations.md#apply-configuration-revision-editing-console) or [reboot the broker](amazon-mq-rebooting-broker.md)\. For more information, see [Amazon MQ Broker Configuration Lifecycle](amazon-mq-broker-configuration-lifecycle.md)\.  
Currently, you can't delete a configuration\.

For information about creating, editing, and managing configurations, see the following:
+ [Tutorial: Creating and Applying Amazon MQ Broker Configurations](amazon-mq-creating-applying-configurations.md)
+ [Tutorial: Editing Amazon MQ Broker Configurations and Managing Configuration Revisions](amazon-mq-editing-managing-configurations.md)
+ [Configurations](amazon-mq-limits.md#configuration-limits)
+ [Amazon MQ Broker Configuration Parameters](amazon-mq-broker-configuration-parameters.md)

To keep track of the changes you make to your configuration, you can create *configuration revisions*\. For more information, see [Tutorial: Creating and Applying Amazon MQ Broker Configurations](amazon-mq-creating-applying-configurations.md) and [Tutorial: Editing Amazon MQ Broker Configurations and Managing Configuration Revisions](amazon-mq-editing-managing-configurations.md)\.

## Attributes<a name="configuration-attributes"></a>

A broker configuration has several attributes, for example:
+ A name \(`MyConfiguration`\)
+ An ID \(`c-1234a5b6-78cd-901e-2fgh-3i45j6k178l9`\)
+ An Amazon Resource Name \(ARN\) \(`arn:aws:mq:us-east-2:123456789012:configuration:MyConfiguration:c-1234a5b6-78cd-901e-2fgh-3i45j6k178l9`\)

For a full list of configuration attributes, see the following in the *Amazon MQ REST API Reference*:
+ [REST Operation ID: Configuration](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-configuration.html)
+ [REST Operation ID: Configurations](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-configurations.html)

For a full list of configuration revision attributes, see the following:
+ [REST Operation ID: Configuration Revision](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-configuration-revision.html)
+ [REST Operation ID: Configuration Revisions](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-configuration-revisions.html)