# Mapping industrial data streams to asset properties<a name="connect-data-streams"></a>

If your asset has measurement properties, you can define the property aliases to map your data streams to those properties\. You can also set property aliases so that you can easily identify an asset property when you ingest or retrieve asset data\.

This process requires that you know your property alias, such as `/company/windfarm/3/turbine/7/temperature`\.
+ If you ingest data from OPC\-UA servers using a [gateway](gateways.md), your property alias is the path to a variable under the **Objects** node, starting with `/`\. For example, if the path to your variable is `company/windfarm/3/turbine/7/temperature`, then your property alias is `/company/windfarm/3/turbine/7/temperature`\. For more information about OPC\-UA information architecture, see [Information Model and Address Spacing mapping](https://reference.opcfoundation.org/Core/docs/Part8/A.4.2/) in the *OPC UA Online Reference*\.
**Notes**  
If you configure a data stream prefix for your OPC\-UA source, you must include that prefix in the property alias for all data streams from that source\. For example, if you use `/RentonWA` as a prefix, then the previous alias is `/RentonWA/company/windfarm/3/turbine/7/temperature`\.
Property aliases can contain up to 1,000 bytes\. OPC\-UA variables paths can contain up to 4,096 bytes\. Currently, AWS IoT SiteWise doesn't support ingesting data from OPC\-UA variables with long paths\.
+ If you ingest data from other sources, such as using [AWS IoT rules](iot-rules.md) or the [API](ingest-api.md), you define your property aliases\. You can define a property alias naming system that is applicable to your device configuration\. For example, if you ingest data from AWS IoT things, you can include the thing name in property aliases to uniquely identify data streams\. For more information about this example, see the [Ingesting data from AWS IoT things](ingest-data-from-iot-things.md) tutorial\.

**Note**  
Property aliases must be unique within a Region and AWS account\. AWS IoT SiteWise returns an error if you set a property alias to one that already exists on another asset property\.  
If you have multiple OPC\-UA sources with identical data stream paths, you can add a prefix to each source's paths to form unique aliases\. For more information, see [Configuring data sources](configure-sources.md)\.

**Topics**
+ [Setting a property alias \(console\)](#set-property-alias-console)
+ [Setting a property alias \(CLI\)](#set-property-alias-cli)

## Setting a property alias \(console\)<a name="set-property-alias-console"></a>

You can use the AWS IoT SiteWise console to set an alias for an asset property\.

**To set a property alias \(console\)**

1. <a name="sitewise-open-console"></a>Navigate to the [AWS IoT SiteWise console](https://console.aws.amazon.com/iotsitewise/)\.

1. <a name="sitewise-choose-assets"></a>In the navigation pane, choose **Assets**\.

1. Choose the asset for which you want to set a property alias\.
**Tip**  <a name="sitewise-expand-asset-hierarchy"></a>
You can choose the arrow icon to expand an asset hierarchy to find your asset\.  

![\[AWS IoT SiteWise "Assets" page screenshot with an asset hierarchy highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-expand-asset-hierarchy-console.png)

1. Choose **Edit**\.

1. Find the property for which you want to set an alias, and then enter the property alias\.  
![\[AWS IoT SiteWise "Edit asset" page screenshot with a property alias highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-enter-property-alias-console.png)

1. Choose **Save**\.

## Setting a property alias \(CLI\)<a name="set-property-alias-cli"></a>

You can use the AWS Command Line Interface \(AWS CLI\) to set an alias for an asset property\.

You must know your asset's `assetId` and property's `propertyId` to complete this procedure\. If you created an asset but don't know its `assetId`, use the [ListAssets](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_ListAssets.html) operation to view all of your assets for a specific model\. Then, use the [DescribeAsset](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_DescribeAsset.html) operation to view your asset's properties including property IDs\.

To map a data stream to your asset's property, use the [UpdateAssetProperty](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_UpdateAssetProperty.html) operation\. Specify the following parameters:
+ `assetId` – The asset's ID\.
+ `propertyId` – The asset property's ID\.
+ `propertyAlias` – The data stream's path to alias to the property\.
+ `propertyNotificationState` – The property value notification state: `ENABLED` or `DISABLED`\. Specify the property's existing notification state when you update the property alias\. You can retrieve the existing notification state with the [DescribeAssetProperty](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_DescribeAssetProperty.html) operation\.

  If you omit this parameter, the new notification state is `DISABLED`\. For more information about property notifications, see [Interacting with other AWS services](interact-with-other-services.md)\.

**To set a property alias \(CLI\)**

1. Run the following command to retrieve the property's current notification state\. Replace *asset\-id* and *property\-id* with the asset property's IDs\.

   ```
   aws iotsitewise describe-asset-property \
     --asset-id asset-id \
     --property-id property-id
   ```

   The operation returns a response that contains the asset property's details in the following format\. The property notification state is in `assetProperty.notification.state` in the JSON object\.

   ```
   {
     "assetId": "a1b2c3d4-5678-90ab-cdef-22222EXAMPLE",
     "assetName": "Wind Turbine 7",
     "assetModelId": "a1b2c3d4-5678-90ab-cdef-11111EXAMPLE",
     "assetProperty": {
       "id": "a1b2c3d4-5678-90ab-cdef-33333EXAMPLE",
       "name": "Wind Speed",
       "notification": {
         "topic": "$aws/sitewise/asset-models/a1b2c3d4-5678-90ab-cdef-11111EXAMPLE/assets/a1b2c3d4-5678-90ab-cdef-22222EXAMPLE/properties/a1b2c3d4-5678-90ab-cdef-33333EXAMPLE",
         "state": "DISABLED | ENABLED"
       },
       "dataType": "DOUBLE",
       "unit": "m/s",
       "type": {
         "measurement": {}
       }
     }
   }
   ```

1. Run the following command to set the asset property's alias\. Replace *property\-alias* with the property alias and *notification\-state* with the notification state, or omit `--property-notification-state` to disable notifications\.

   ```
   aws iotsitewise update-asset-property \
     --asset-id asset-id \
     --property-id property-id \
     --property-alias property-alias \
     --property-notification-state notification-state
   ```