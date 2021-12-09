# Tutorial: Rebooting an Amazon MQ Broker<a name="amazon-mq-rebooting-broker"></a>

To apply a new configuration to a broker, you can reboot the broker\. In addition, if your broker becomes unresponsive, you can reboot it to recover from a faulty state\.

The following example shows how you can reboot an Amazon MQ broker using the AWS Management Console\.

## To Reboot an Amazon MQ Broker<a name="rebooting-broker-console"></a>

1. Sign in to the [Amazon MQ console](https://console.aws.amazon.com/amazon-mq/)\.

1. From the broker list, choose the name of your broker \(for example, **MyBroker**\)\.

1. On the ***MyBroker*** page, choose **Actions**, **Reboot broker**\.
**Important**  
Your broker will be offline while it is being rebooted\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/images/amazon-mq-tutorials-reboot-broker.png)

1. In the **Reboot broker** dialog box, choose **Reboot**\.

   Rebooting the broker takes about 5 minutes\.