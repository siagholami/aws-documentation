# Tutorial: Listing Amazon MQ Brokers and Viewing Broker Details<a name="amazon-mq-listing-brokers"></a>

When you request that Amazon MQ create a broker, the creation process can take about 15 minutes\.\.

The following example shows how you can confirm your broker's existence by listing your brokers in the current region using the AWS Management Console\.

## To List Brokers and View Broker Details<a name="listing-all-brokers-console"></a>

1. Sign in to the [Amazon MQ console](https://console.aws.amazon.com/amazon-mq/)\.

   Your brokers in the current region are listed\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/images/amazon-mq-tutorials-list-brokers.png)

   The following information is displayed for each broker:
   + **Name**
   + **Creation** date
   + [**Status**](broker.md#broker-statuses)
   + [**Deployment mode**](amazon-mq-broker-architecture.md)
   + [**Instance type**](broker.md#broker-instance-types)

1. Choose your broker's name \(for example, **MyBroker**\)\.

   On the ***MyBroker*** page, the [configured](configuration.md) **Details** are displayed for your broker:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/images/amazon-mq-tutorials-show-broker-details.png)

   Below the **Details** section, the following information is displayed:
   + In the **Connections** section, the [ActiveMQ Web Console](http://activemq.apache.org/web-console.html) URL and the [wire\-level protocol endpoints](http://activemq.apache.org/configuring-transports.html)
   + In the **Users** section, the [users](user.md) associated with the broker