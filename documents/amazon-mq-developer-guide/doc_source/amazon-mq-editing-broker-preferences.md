# Tutorial: Editing Broker Engine Version, Instance Type, CloudWatch Logs, and Maintenance Preferences<a name="amazon-mq-editing-broker-preferences"></a>

In addition to [editing broker configurations and managing configuration revisions](amazon-mq-editing-managing-configurations.md), you can configure preferences specific to the broker\.

**Note**  
All preferences except for those for automatic minor version upgrades require you to schedule modifications\. For more information, see [Amazon MQ Broker Configuration Lifecycle](amazon-mq-broker-configuration-lifecycle.md)\.

The following example shows how you can edit Amazon MQ broker preferences using the AWS Management Console\.

## To Edit Broker Options<a name="edit-current-configuration-console"></a>

1. Sign in to the [Amazon MQ console](https://console.aws.amazon.com/amazon-mq/)\.

1. From the broker list, select your broker \(for example, **MyBroker**\) and then choose **Edit**\.

1. On the **Edit *MyBroker*** page, in the **Specifications** section, select a **Broker engine version** or a **Broker Instance type**\.

1. In the **Configuration** section, select the configuration and revision for your broker\. For more information, see [Tutorial: Editing Amazon MQ Broker Configurations and Managing Configuration Revisions](amazon-mq-editing-managing-configurations.md)\.

1. In the **Security and network** section, select a group from the **Security group\(s\)** drop\-down, or choose **Create a new security group** to open the Amazon VPC console\.

1. In the **CloudWatch Logs** section, choose whether to publish **General** logs and **Audit** logs to Amazon CloudWatch Logs\. For more information, see [Configuring Amazon MQ to Publish General and Audit Logs to Amazon CloudWatch Logs](security-logging-monitoring-configure-cloudwatch.md)\.
**Important**  
If you don't [add the `CreateLogGroup` permission to your Amazon MQ user](security-logging-monitoring-configure-cloudwatch.md#security-logging-monitoring-configure-cloudwatch-permissions) before the user creates or reboots the broker, Amazon MQ doesn't create the log group\.  
If you don't [configure a resource\-based policy for Amazon MQ](security-logging-monitoring-configure-cloudwatch.md#security-logging-monitoring-configure-cloudwatch-resource-permissions), the broker can't publish the logs to CloudWatch Logs\.

1. In the **Maintenance** section, configure your broker's maintenance schedule:

   To upgrade the broker to new versions as AWS releases them, choose **Enable automatic minor version upgrades**\. Automatic upgrades occur during the *maintenance window* defined by the day of the week, the time of day \(in 24\-hour format\), and the time zone \(UTC by default\)\.
**Note**  
For an active/standby broker, if one of the broker instances undergoes maintenance, it takes Amazon MQ a short while to take the inactive instance out of service\. This allows the healthy standby instance to become active and to begin accepting incoming communications\.

1. Choose **Schedule modifications**\.
**Note**  
If you choose only **Enable automatic minor version upgrades**, the button changes to **Save** because no broker reboot is necessary\.

   Your preferences are applied to your broker at the specified time\.