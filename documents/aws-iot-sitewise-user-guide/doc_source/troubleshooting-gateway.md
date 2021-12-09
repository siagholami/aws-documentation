# Troubleshooting an AWS IoT SiteWise gateway<a name="troubleshooting-gateway"></a>

AWS IoT SiteWise gateways run an AWS IoT Greengrass connector\. You can configure your gateway to log connector events to CloudWatch and to your gateway's local file system\. Then, you can view the log files associated with the connector to troubleshoot your gateway\.

You can also view CloudWatch metrics reported by your gateways to troubleshoot issues with connectivity or data streams\. For more information, see [Gateway metrics](monitor-cloudwatch-metrics.md#gateway-metrics)\.

**Topics**
+ [Configuring and accessing AWS IoT SiteWise gateway logs](#configure-gateway-logs)
+ [Troubleshooting gateway issues](#troubleshoot-gateway-issues)
+ [Troubleshooting AWS IoT Greengrass issues](#troubleshoot-greengrass-issues)

## Configuring and accessing AWS IoT SiteWise gateway logs<a name="configure-gateway-logs"></a>

Before you can view gateway logs, you must configure your gateway to send logs to Amazon CloudWatch Logs or store logs on the local file system\.
+ Use CloudWatch Logs if you want to use the AWS Management Console to view your gateway's log files\. For more information, see [Using Amazon CloudWatch Logs](monitor-gateway-logs.md#gateway-cloudwatch-logs)\.
+ Use local file system logs if you want to use the command line or local software to view your gateway's log files\. For more information, see [Using local file system logs](monitor-gateway-logs.md#gateway-local-logs)\.

## Troubleshooting gateway issues<a name="troubleshoot-gateway-issues"></a>

Use the following information to troubleshoot gateway issues\.

**Topics**
+ [Unable to connect to stream manager](#gateway-issue-stream-manager)
+ [AWS IoT SiteWise doesn't receive data from OPC\-UA servers](#gateway-issue-data-streams)
+ [The gateway fails to publish data after you restore lost power or connectivity](#gateway-issue-after-downtime)

### Unable to connect to stream manager<a name="gateway-issue-stream-manager"></a>

You might see the following `swPublisher` error log message if stream manager isn't enabled on your gateway's AWS IoT Greengrass group\.

```
com.amazonaws.greengrass.streammanager.client.StreamManagerClientImpl: Connect failed
```

As of version 6, the AWS IoT SiteWise connector requires stream manager\. For more information about how to enable stream manager, see step 5 of [Configuring an AWS IoT Greengrass group](configure-gateway.md#attach-iam-role)\.

### AWS IoT SiteWise doesn't receive data from OPC\-UA servers<a name="gateway-issue-data-streams"></a>

If your AWS IoT SiteWise assets aren't receiving data sent by your OPC\-UA servers, you can search your gateway's logs to troubleshoot issues\. Look for info\-level `swPublisher` logs that contain the following message\.

```
Emitting diagnostic name=PublishError.SomeException
```

Based on the type of *SomeException* in the log, use the following exception types and corresponding issues to troubleshoot your gateway:
+ **ResourceNotFoundException** – Your OPC\-UA servers are sending data that doesn't match a property alias for any asset\. This exception can occur in two cases:
  + Your property aliases don't exactly match your OPC\-UA variables, including any source prefix you defined\. Check that your property aliases and source prefixes are correct\.
  + You haven't mapped your OPC\-UA variables to asset properties\. For more information, see [Mapping industrial data streams to asset properties](connect-data-streams.md)\.

    If you already mapped all of the OPC\-UA variables that you want in AWS IoT SiteWise, you can filter which OPC\-UA variables the gateway sends\. For more information, see [Using OPC\-UA node filters](opc-ua-node-filters.md)\.
+ **AccessDeniedException** – Your gateway's AWS IoT Greengrass group doesn't have sufficient permissions to use the [BatchPutAssetPropertyValue](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_BatchPutAssetPropertyValue.html) operation to send data to asset properties\. For more information, see the [AWS IoT SiteWise connector requirements](https://docs.aws.amazon.com/greengrass/latest/developerguide/iot-sitewise-connector.html#iot-sitewise-connector-req)\.
+ **InvalidRequestException** – Your OPC\-UA variables data types don't match your asset property data types\. For example, if an OPC\-UA variable has an integer data type, your corresponding asset property must be integer data type\. A double\-type asset property can't receive OPC\-UA integer values\. To fix this issue, define new properties with the correct data types\.
+ **TimestampOutOfRangeException** – Your gateway is sending data that is too outdated for AWS IoT SiteWise to accept\. If your gateway lost power or connection to the AWS Cloud, you might need to clear your gateway's cache\. For more information, see [The gateway fails to publish data after you restore lost power or connectivity](#gateway-issue-after-downtime)\.
+ **ThrottlingException** or **LimitExceededException** – Your request exceeded an AWS IoT SiteWise service quota, such as rate of data points ingested or request rate for asset property data API operations\. Check that your configuration doesn't exceed the [AWS IoT SiteWise quotas](quotas.md)\.

### The gateway fails to publish data after you restore lost power or connectivity<a name="gateway-issue-after-downtime"></a>

If your gateway loses power or connection to the AWS Cloud for an extended period of time, your gateway might fail to send data to AWS IoT SiteWise after it reconnects\. After the gateway's power and connection restore, the gateway attempts to publish cached data\. AWS IoT SiteWise rejects data with old timestamps, so if the cached data is older than the accepted range, the gateway fails to publish the cached data\. You can identify this issue by `TimestampOutOfRangeException` messages in your gateway's `swPublisher` logs\. For more information about the accepted range of timestamps, see the [BatchPutAssetPropertyValue](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_BatchPutAssetPropertyValue.html) operation\.

When this issue occurs, you can clear the cache to stop the gateway from sending messages with old timestamps\.

**Warning**  
When you clear the gateway's cache, you permanently delete all unpublished data from your gateway\. Your gateway doesn't receive new data while you complete the steps to clear the cache\.

**To clear a gateway's cache**

1. On the gateway, run the following command to stop the AWS IoT Greengrass daemon\. Replace *greengrass\-root* with the root of your AWS IoT Greengrass installation\. The default *greengrass\-root* is `/greengrass`\.

   ```
   sudo /greengrass-root/ggc/core/greengrassd stop
   ```

1. Run the following command to delete the message checkpoint database\. Replace *sitewise\-root* with the local storage path for your AWS IoT SiteWise configuration\. The default *sitewise\-root* is `/var/sitewise`\.

   ```
   sudo rm /sitewise-root/checkpoint.db
   ```

1. Run the following command to clear the stream manager buffer\.

   ```
   sudo rm /greengrass-root/ggc/var/state/stream_manager/SiteWise_Stream
   ```

1. Run the following command to start the AWS IoT Greengrass daemon\.

   ```
   sudo /greengrass-root/ggc/core/greengrassd start
   ```

   The time to restart your gateway depends on the number of OPC\-UA tags on your gateway's OPC\-UA sources\. Restart time can range from a few seconds \(for a gateway with few tags\) to several minutes \(for a gateway with many tags\)\.

## Troubleshooting AWS IoT Greengrass issues<a name="troubleshoot-greengrass-issues"></a>

To find solutions to many issues configuring or deploying your gateway on AWS IoT Greengrass, see [Troubleshooting AWS IoT Greengrass](https://docs.aws.amazon.com/greengrass/latest/developerguide/gg-troubleshooting.html) in the *AWS IoT Greengrass Developer Guide*\.