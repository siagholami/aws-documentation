# Tutorial: Creating and Applying Amazon MQ Broker Configurations<a name="amazon-mq-creating-applying-configurations"></a>

A *configuration* contains all of the settings for your ActiveMQ broker, in XML format \(similar to ActiveMQ's `activemq.xml` file\)\. You can create a configuration before creating any brokers\. You can then apply the configuration to one or more brokers\. You can apply a configuration immediately or during a *maintenance window*\.

**Note**  
For an active/standby broker, if one of the broker instances undergoes maintenance, it takes Amazon MQ a short while to take the inactive instance out of service\. This allows the healthy standby instance to become active and to begin accepting incoming communications\.

For more information, see the following:
+ [Configuration](configuration.md)
+ [Amazon MQ Broker Configuration Lifecycle](amazon-mq-broker-configuration-lifecycle.md)
+ [Amazon MQ Broker Configuration Parameters](amazon-mq-broker-configuration-parameters.md)
+ [Tutorial: Editing Amazon MQ Broker Configurations and Managing Configuration Revisions](amazon-mq-editing-managing-configurations.md)

The following example shows how you can create and apply an Amazon MQ broker configuration using the AWS Management Console\.

**Topics**
+ [Step 1: Create a Configuration from Scratch](#creating-configuration-from-scratch-console)
+ [Step 2: Create a New Configuration Revision](#creating-new-configuration-revision-console)
+ [Step 3: Apply a Configuration Revision to Your Broker](#apply-configuration-revision-creating-console)

## Step 1: Create a Configuration from Scratch<a name="creating-configuration-from-scratch-console"></a>

1. Sign in to the [Amazon MQ console](https://console.aws.amazon.com/amazon-mq/)\.

1. On the left, expand the navigation panel and choose **Configurations**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/images/amazon-mq-tutorials-create-configuration.png)

1. On the **Configurations** page, choose **Create configuration**\.

1. On the **Create configuration** page, in the **Details** section, type the **Configuration name** \(for example, `MyConfiguration`\) and select a **Broker engine** version\.
**Note**  
Currently, Amazon MQ supports only `ActiveMQ` broker engine versions `5.15.8`, `5.15.6` and `5.15.0`\.

1. Choose **Create configuration**\.

## Step 2: Create a New Configuration Revision<a name="creating-new-configuration-revision-console"></a>

1. From the configuration list, choose ***MyConfiguration***\.
**Note**  
The first configuration revision is always created for you when Amazon MQ creates the configuration\.

   On the ***MyConfiguration*** page, the broker engine type and version that your new configuration revision uses \(for example, **Apache ActiveMQ 5\.15\.8**\) are displayed\.

1. On the **Configuration details** tab, the configuration revision number, description, and broker configuration in XML format are displayed\.
**Note**  
Editing the current configuration creates a new configuration revision\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/images/amazon-mq-tutorials-edit-configuration.png)

1. Choose **Edit configuration** and make changes to the XML configuration\.

1. Choose **Save**\.

   The **Save revision** dialog box is displayed\.

1. \(Optional\) Type `A description of the changes in this revision`\.

1. Choose **Save**\.

   The new revision of the configuration is saved\.
**Important**  
The Amazon MQ console automatically sanitizes invalid and prohibited configuration parameters according to a schema\. For more information and a full list of permitted XML parameters, see [Amazon MQ Broker Configuration Parameters](amazon-mq-broker-configuration-parameters.md)\.  
Making changes to a configuration does *not* apply the changes to the broker immediately\. To apply your changes, you must [wait for the next maintenance window](amazon-mq-editing-managing-configurations.md#apply-configuration-revision-editing-console) or [reboot the broker](amazon-mq-rebooting-broker.md)\. For more information, see [Amazon MQ Broker Configuration Lifecycle](amazon-mq-broker-configuration-lifecycle.md)\.  
Currently, you can't delete a configuration\.

## Step 3: Apply a Configuration Revision to Your Broker<a name="apply-configuration-revision-creating-console"></a>

1. On the left, expand the navigation panel and choose **Brokers**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/images/amazon-mq-tutorials-apply-configuration.png)

1. From the broker list, select your broker \(for example, **MyBroker**\) and then choose **Edit**\.

1. On the **Edit *MyBroker*** page, in the **Configuration** section, select a **Configuration** and a **Revision** and then choose **Schedule Modifications**\.

1. In the **Schedule broker modifications** section, choose whether to apply modifications **During the next scheduled maintenance window** or **Immediately**\.
**Important**  
Your broker will be offline while it is being rebooted\.

1. Choose **Apply**\.

   Your configuration revision is applied to your broker at the specified time\.