# Tutorial: Creating and Configuring an Amazon MQ Network of Brokers<a name="amazon-mq-creating-configuring-network-of-brokers"></a>

A *network of brokers* is comprised of multiple simultaneously active [single\-instance brokers](single-broker-deployment.md) or [active/standby brokers](active-standby-broker-deployment.md)\. You can configure networks of brokers in a variety of [topologies](network-of-brokers.md#nob-topologies) \(for example, *concentrator*, *hub\-and\-spokes*, *tree*, or *mesh*\), depending on your application's needs, such as high availability and scalability\. For instance, a [hub and spoke](network-of-brokers.md#nob-topologies-hub) network of brokers can increase resiliency, preserving messages if one broker is not reachable\. A network of brokers with a [concentrator](network-of-brokers.md#nob-topologies-concentrator) topology can collect messages from a larger number of brokers accepting incoming messages, and concentrate them to more central brokers, to better handle the load of many incoming messages\. In this tutorial, you learn how to create a two\-broker network of brokers with a *source and sink* topology\. 

For a conceptual overview and detailed configuration information, see the following:
+ [Amazon MQ Network of Brokers](network-of-brokers.md)
+ [Configure Your Network of Brokers Correctly](ensuring-effective-amazon-mq-performance.md#network-of-brokers-configure-correctly)
+ ``
+ ``
+ [Networks of Brokers](http://activemq.apache.org/networks-of-brokers.html) in the ActiveMQ documentation

You can use the Amazon MQ console to create an Amazon MQ network of brokers\. Because you can start the creation of the two brokers in parallel, this process takes approximately 15 minutes\. 

**Topics**
+ [Prerequisites](#creating-configuring-network-of-brokers-create-brokers)
+ [Configure the Brokers in a Network](#creating-configuring-network-of-brokers-allow-traffic)
+ [Configure Network Connectors for Your Broker](#creating-configuring-network-of-brokers-configure-network-connectors)
+ [Next Steps: Test the Network of Brokers](#creating-configuring-network-of-brokers-test)

## Prerequisites<a name="creating-configuring-network-of-brokers-create-brokers"></a>

To create a network of brokers, you must have the following:
+ Two or more simultaneously active brokers \(named `MyBroker1` and `MyBroker2` in this tutorial\)\. For more information about creating brokers, see [Tutorial: Creating and Configuring an Amazon MQ Broker](amazon-mq-creating-configuring-broker.md)\.
+ The two brokers must be in the same VPC or in peered VPCs\. For more information about VPCs, see [What is Amazon VPC?](https://docs.aws.amazon.com/vpc/latest/userguide/what-is-amazon-vpc.html) in the *Amazon VPC User Guide* and [What is VPC Peering?](https://docs.aws.amazon.com/vpc/latest/peering/Welcome.html) in the *Amazon VPC Peering Guide*\.
**Important**  
If you don't have a default VPC, subnet\(s\), or security group, you must create them first\. For more information, see the following in the *Amazon VPC User Guide*:  
[Creating a Default VPC](https://docs.aws.amazon.com/vpc/latest/userguide/default-vpc.html#create-default-vpc)
[Creating a Default Subnet](https://docs.aws.amazon.com/vpc/latest/userguide/default-vpc.html#create-default-subnet)
[Creating a Security Group](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_SecurityGroups.html#CreatingSecurityGroups)
+ Two users with identical usernames and passwords for both brokers\. For more information about creating users, see [Tutorial: Creating and Managing Amazon MQ Broker Users](amazon-mq-listing-managing-users.md)\.

The following example uses two [single\-instance brokers](single-broker-deployment.md)\. However, you can create networks of brokers using [active/standby brokers](active-standby-broker-deployment.md) or a combination of broker deployment modes\.

## Step 1: Allow Traffic between Brokers<a name="creating-configuring-network-of-brokers-allow-traffic"></a>

After you create your brokers, you must allow traffic between them\.

1. On the [Amazon MQ console](https://console.aws.amazon.com/amazon-mq/), on the **MyBroker2** page, in the **Details** section, under **Security and network**, choose the name of your security group or ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/images/amazon-mq-tutorials-broker-details-link.png)\.

   The **Security Groups** page of the EC2 Dashboard is displayed\.

1. From the security group list, choose your security group\.

1. At the bottom of the page, choose **Inbound**, and then choose **Edit**\.

1. In the **Edit inbound rules** dialog box, add a rule for the OpenWire endpoint\.

   1. Choose **Add Rule**\.

   1. For **Type**, select **Custom TCP**\.

   1. For **Port Range**, type the OpenWire port \(`61617`\)\.

   1. Do one of the following:
      + If you want to restrict access to a particular IP address, for **Source**, leave **Custom** selected, and then enter the IP address of `MyBroker1`, followed by `/32`\. \(This converts the IP address to a valid CIDR record\)\. For more information see [Elastic Network Interfaces](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-eni.html)\.
**Tip**  
To retrieve the IP address of `MyBroker1`, on the [Amazon MQ console](https://console.aws.amazon.com/amazon-mq/), choose the name of the broker and navigate to the **Details** section\.
      + If all the brokers are private and belong to the same VPC, for **Source**, leave **Custom** selected and then type the ID of the security group you are editing\.
**Note**  
For public brokers, you must restrict access using IP addresses\.

   1. Choose **Save**\.

      Your broker can now accept inbound connections\.

## Step 2: Configure Network Connectors for Your Broker<a name="creating-configuring-network-of-brokers-configure-network-connectors"></a>

After you allow traffic between your brokers, you must configure network connectors for one of them\.

1. Edit the configuration revision for broker `MyBroker1`\.

   1. On the **MyBroker1** page, choose **Edit**\.

   1. On the **Edit MyBroker1** page, in the **Configuration** section, choose **View**\.

      The broker engine type and version that the configuration uses \(for example, **Apache ActiveMQ 5\.15\.0**\) are displayed\.

   1. On the **Configuration details** tab, the configuration revision number, description, and broker configuration in XML format are displayed\.

   1. Choose **Edit configuration**\.

   1. At the bottom of the configuration file, uncomment the `<networkConnectors>` section and include the following information:
      + The `name` for the network connector\.
      + [The ActiveMQ Web Console `username`](#creating-configuring-network-of-brokers-create-brokers) that is common to both brokers\.
      + Enable `duplex` connections\.
      + Do one of the following:
        + If you are connecting the broker to a single\-instance broker, use the `static:` prefix and the OpenWire endpoint `uri` for `MyBroker2`\. For example:

          ```
          <networkConnectors>
            <networkConnector name="connector_1_to_2" userName="myCommonUser" duplex="true"
              uri="static:(ssl://b-1234a5b6-78cd-901e-2fgh-3i45j6k178l9-1.mq.us-east-2.amazonaws.com:61617)"/>
          </networkConnectors>
          ```
        + If you are connecting the broker to an active/standby broker, use the `masterslave:` prefix and the OpenWire endpoint `uri` for both brokers\. For example:

          ```
          <networkConnectors>
            <networkConnector name="connector_1_to_2" userName="myCommonUser" duplex="true"
              uri="masterslave:(ssl://b-1234a5b6-78cd-901e-2fgh-3i45j6k178l9-1.mq.us-east-2.amazonaws.com:61617,
              ssl://b-9876l5k4-32ji-109h-8gfe-7d65c4b132a1-2.mq.us-east-2.amazonaws.com:61617)"/>
          </networkConnectors>
          ```
**Note**  
Don't include the password for the ActiveMQ user\.

   1. Choose **Save**\.

   1. In the **Save revision** dialog box, type `Add network of brokers connector for MyBroker2`\.

   1. Choose **Save** to save the new revision of the configuration\.

1. Edit `MyBroker1` to set the latest configuration revision to apply immediately\.

   1. On the **MyBroker1** page, choose **Edit**\.

   1. On the **Edit MyBroker1** page, in the **Configuration** section, choose **Schedule Modifications**\.

   1. In the **Schedule broker modifications** section, choose to apply modifications **Immediately**\.

   1. Choose **Apply**\.

      `MyBroker1` is rebooted and your configuration revision is applied\.

   The network of brokers is created\.

## Next Steps<a name="creating-configuring-network-of-brokers-test"></a>

After you configure your network of brokers, you can test it by producing and consuming messages\.

**Important**  
Make sure that you [enable inbound connections](amazon-mq-working-java-example.md#quick-start-allow-inbound-connections) *from your local machine* for broker `MyBroker1` on port 8162 \(for the ActiveMQ Web Console\) and port 61617 \(for the OpenWire endpoint\)\.  
You might also need to adjust your security group\(s\) settings to allow the producer and consumer to connect to the network of brokers\.

1. On the [Amazon MQ console](https://console.aws.amazon.com/amazon-mq/), navigate to the **Connections** section and note the ActiveMQ Web Console endpoint for broker `MyBroker1`\.

1. Navigate to the ActiveMQ Web Console for broker `MyBroker1`\.

1. To verify that the network bridge is connected, choose **Network**\.

   In the **Network Bridges** section, the name and the address of `MyBroker2` are listed in the **Remote Broker** and **Remote Address** columns\.

1. From any machine that has access to broker `MyBroker2`, create a consumer\. For example:

   ```
   activemq consumer --brokerUrl "ssl://b-1234a5b6-78cd-901e-2fgh-3i45j6k178l9-1.mq.us-east-2.amazonaws.com:61617" \
   	--user commonUser \
   	--password myPassword456 \
   	--destination queue://MyQueue
   ```

   The consumer connects to the OpenWire endpoint of `MyBroker1` and begins to consume messages from queue `MyQueue`\.

1. From any machine that has access to broker `MyBroker1`, create a producer and send some messages\. For example:

   ```
   activemq producer --brokerUrl "ssl://b-9876l5k4-32ji-109h-8gfe-7d65c4b132a1-1.mq.us-east-2.amazonaws.com:61617" \
   	--user commonUser \
   	--password myPassword456 \
   	--destination queue://MyQueue \
   	--persistent true \
   	--messageSize 1000 \
   	--messageCount 10000
   ```

   The producer connects to the OpenWire endpoint of `MyBroker1` and begins to produce persistent messages to queue `MyQueue`\.