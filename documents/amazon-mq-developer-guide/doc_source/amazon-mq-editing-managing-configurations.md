# Tutorial: Editing Amazon MQ Broker Configurations and Managing Configuration Revisions<a name="amazon-mq-editing-managing-configurations"></a>

A *configuration* contains all of the settings for your ActiveMQ broker, in XML format \(similar to ActiveMQ's `activemq.xml` file\)\. You can apply a configuration immediately or during a *maintenance window*\.

**Note**  
For an active/standby broker, if one of the broker instances undergoes maintenance, it takes Amazon MQ a short while to take the inactive instance out of service\. This allows the healthy standby instance to become active and to begin accepting incoming communications\.

To keep track of the changes you make to your configuration, you can create *configuration revisions*\.

For more information, see the following:
+ [Configuration](configuration.md)
+ [Amazon MQ Broker Configuration Lifecycle](amazon-mq-broker-configuration-lifecycle.md)
+ [Amazon MQ Broker Configuration Parameters](amazon-mq-broker-configuration-parameters.md)
+ [Tutorial: Creating and Applying Amazon MQ Broker Configurations](amazon-mq-creating-applying-configurations.md)

The following examples show how you can edit Amazon MQ broker configurations and manage broker configuration revisions using the AWS Management Console\.

**Topics**
+ [To View a Previous Configuration Revision](#view-previous-configuration-console)
+ [To Edit the Current Configuration Revision](#edit-current-configuration-console)
+ [To Apply a Configuration Revision to Your Broker](#apply-configuration-revision-editing-console)
+ [To Roll Back Your Broker to the Last Configuration Revision](#roll-back-last-configuration-console)

## To View a Previous Configuration Revision<a name="view-previous-configuration-console"></a>

1. Sign in to the [Amazon MQ console](https://console.aws.amazon.com/amazon-mq/)\.

1. From the broker list, select your broker \(for example, **MyBroker**\) and then choose **Edit**\.

1. On the **Edit *MyBroker*** page, in the **Configuration** section, select a **Configuration** and a **Revision** and then choose **Edit**\.
**Note**  
Unless you select a configuration when you create a broker, the first configuration revision is always created for you when Amazon MQ creates the broker\.

   On the ***MyBroker*** page, the broker engine type and version that the configuration uses \(for example, **Apache ActiveMQ 5\.15\.8**\) are displayed\.

1. Choose **Revision history**\.

1. The configuration **Revision** number, **Revision date**, and **Description** are displayed for each revision\.

1. Select a revision and choose **View details**\.

   The broker configuration in XML format is displayed\.

## To Edit the Current Configuration Revision<a name="edit-current-configuration-console"></a>

1. Sign in to the [Amazon MQ console](https://console.aws.amazon.com/amazon-mq/)\.

1. From the broker list, select your broker \(for example, **MyBroker**\) and then choose **Edit**\.

1. On the ***MyBroker*** page, choose **Edit**\.

1. On the **Edit *MyBroker*** page, in the **Configuration** section, select a **Configuration** and a **Revision** and then choose **Edit**\.
**Note**  
Unless you select a configuration when you create a broker, the first configuration revision is always created for you when Amazon MQ creates the broker\.

   On the ***MyBroker*** page, the broker engine type and version that the configuration uses \(for example, **Apache ActiveMQ 5\.15\.8**\) are displayed\.

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
Making changes to a configuration does *not* apply the changes to the broker immediately\. To apply your changes, you must [wait for the next maintenance window](#apply-configuration-revision-editing-console) or [reboot the broker](amazon-mq-rebooting-broker.md)\. For more information, see [Amazon MQ Broker Configuration Lifecycle](amazon-mq-broker-configuration-lifecycle.md)\.  
Currently, you can't delete a configuration\.

## To Apply a Configuration Revision to Your Broker<a name="apply-configuration-revision-editing-console"></a>

1. Sign in to the [Amazon MQ console](https://console.aws.amazon.com/amazon-mq/)\.

1. From the broker list, select your broker \(for example, **MyBroker**\) and then choose **Edit**\.

1. On the **Edit *MyBroker*** page, in the **Configuration** section, select a **Configuration** and a **Revision** and then choose **Schedule Modifications**\.

1. In the **Schedule broker modifications** section, choose whether to apply modifications **During the next scheduled maintenance window** or **Immediately**\.
**Important**  
Your broker will be offline while it is being rebooted\.

1. Choose **Apply**\.

   Your configuration revision is applied to your broker at the specified time\.

## To Roll Back Your Broker to the Last Configuration Revision<a name="roll-back-last-configuration-console"></a>

1. Sign in to the [Amazon MQ console](https://console.aws.amazon.com/amazon-mq/)\.

1. From the broker list, choose the name of your broker \(for example, **MyBroker**\)\.

1. On the ***MyBroker*** page, choose **Actions**, **Roll back to last configuration**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/images/amazon-mq-tutorials-configuration-roll-back.png)

1. \(Optional\) To review the **Current configuration** or the **Last configuration**, on the **Roll back to the last configuration** page, in the **Summary** section, choose **Edit** for either configuration\.

1. In the **Schedule broker modifications** section, choose whether to apply modifications **During the next scheduled maintenance window** or **Immediately**\.
**Important**  
Your broker will be offline while it is being rebooted\.

1. Choose **Apply**\.

   Your configuration revision is applied to your broker at the specified time\.