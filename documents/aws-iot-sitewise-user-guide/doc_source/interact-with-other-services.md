# Interacting with other AWS services<a name="interact-with-other-services"></a>

AWS IoT SiteWise can publish asset data to the AWS IoT MQTT publish\-subscribe message broker, so that you can interact with your asset data from other AWS services\. AWS IoT SiteWise assigns each asset property a unique MQTT topic that you can use to route your asset data to other AWS services using AWS IoT Core rules\. For example, you can configure AWS IoT Core rules to do the following tasks:
+ Identify equipment failure and notify appropriate personnel by sending data to [AWS IoT Events](https://docs.aws.amazon.com/iotevents/latest/developerguide/)\.
+ Historize select asset data for use in external software solutions by sending data to [Amazon DynamoDB](https://docs.aws.amazon.com/dynamodb)\.
+ Generate weekly reports by triggering an [AWS Lambda](https://docs.aws.amazon.com/lambda/latest/dg/) function\.

You can follow a tutorial that walks through the steps required to set up a rule that stores property values in DynamoDB\. For more information, see [Publishing property value updates to Amazon DynamoDB](publish-to-amazon-dynamodb.md)\.

For more information about how to configure a rule, see [Rules](https://docs.aws.amazon.com/iot/latest/developerguide/iot-rules.html) in the *AWS IoT Developer Guide*\.

You can also consume data from other AWS services back into AWS IoT SiteWise\. To ingest data through the AWS IoT SiteWise rule action, see [Ingesting data using AWS IoT Core rules](iot-rules.md)\.

**Topics**
+ [Understanding asset properties' MQTT topics](#mqtt-topics)
+ [Enabling asset property notifications](#enable-property-notifications)
+ [Querying asset property notification messages](#query-notification-messages)

## Understanding asset properties' MQTT topics<a name="mqtt-topics"></a>

Every asset property has a unique MQTT topic path in the following format\.

```
$aws/sitewise/asset-models/assetModelId/assets/assetId/properties/propertyId
```

**Note**  
AWS IoT SiteWise doesn't support the `#` \(multi\-level\) topic filter wildcard in the AWS IoT Core rules engine\. You can use the `+` \(single\-level\) wildcard\. For example, you can use the following topic filter to match all updates for a particular asset model\.  

```
$aws/sitewise/asset-models/assetModelId/assets/+/properties/+
```
To learn more about topic filter wildcards, see [Topics](https://docs.aws.amazon.com/iot/latest/developerguide/topics.html) in the *AWS IoT Core Developer Guide*\.

## Enabling asset property notifications<a name="enable-property-notifications"></a>

By default, AWS IoT SiteWise doesn't publish property value updates\. You can use the AWS IoT SiteWise console or API to enable notifications for each asset property\.

**Topics**
+ [Enabling asset property notifications \(console\)](#enable-property-notifications-console)
+ [Enabling asset property notifications \(CLI\)](#enable-property-notifications-cli)

### Enabling asset property notifications \(console\)<a name="enable-property-notifications-console"></a>

You can use the AWS IoT SiteWise console to enable notifications for an asset property\.

**To enable or disable notifications for an asset property \(console\)**

1. <a name="sitewise-open-console"></a>Navigate to the [AWS IoT SiteWise console](https://console.aws.amazon.com/iotsitewise/)\.

1. <a name="sitewise-choose-assets"></a>In the navigation pane, choose **Assets**\.

1. Choose the asset to enable a property's notifications\.
**Tip**  <a name="sitewise-expand-asset-hierarchy"></a>
You can choose the arrow icon to expand an asset hierarchy to find your asset\.  

![\[AWS IoT SiteWise "Assets" page screenshot with an asset hierarchy highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-expand-asset-hierarchy-console.png)

1. Choose **Edit**\.

1. For the asset property's **Notification status**, choose **ENABLED**\.  
![\[AWS IoT SiteWise "Edit asset" page screenshot with "Notification status" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-enable-property-notifications-console.png)

   You can also choose **DISABLED** to disable notifications for the asset property\.

1. Choose **Save**\.

### Enabling asset property notifications \(CLI\)<a name="enable-property-notifications-cli"></a>

You can use the AWS Command Line Interface \(AWS CLI\) to enable or disable notifications for an asset property\.

You must know your asset's `assetId` and property's `propertyId` to complete this procedure\. If you created an asset but don't know its `assetId`, use the [ListAssets](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_ListAssets.html) operation to view all of your assets for a specific model\. Then, use the [DescribeAsset](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_DescribeAsset.html) operation to view your asset's properties including property IDs\.

Use the [UpdateAssetProperty](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_UpdateAssetProperty.html) operation to enable or disable notifications for an asset property\. Specify the following parameters:
+ `assetId` – The asset's ID\.
+ `propertyId` – The asset property's ID\.
+ `propertyNotificationState` – The property value notification state: `ENABLED` or `DISABLED`\.
+ `propertyAlias` – The alias of the property\. Specify the property's existing alias when you update the notification state\. If you omit this parameter, the property's existing alias is removed\.

**To enable or disable notifications for an asset property \(CLI\)**

1. Run the following command to retrieve the asset property's alias\. Replace *asset\-id* with the ID of the asset and *property\-id* with the ID of the property\.

   ```
   aws iotsitewise describe-asset-property \
     --asset-id asset-id \
     --property-id property-id
   ```

   The operation returns a response that contains the asset property's details in the following format\. The property alias is in `assetProperty.alias` in the JSON object\.

   ```
   {
     "assetId": "a1b2c3d4-5678-90ab-cdef-22222EXAMPLE",
     "assetName": "Wind Turbine 7",
     "assetModelId": "a1b2c3d4-5678-90ab-cdef-11111EXAMPLE",
     "assetProperty": {
       "id": "a1b2c3d4-5678-90ab-cdef-33333EXAMPLE",
       "name": "Wind Speed",
       "alias": "/company/windfarm/3/turbine/7/windspeed",
       "notification": {
         "topic": "$aws/sitewise/asset-models/a1b2c3d4-5678-90ab-cdef-11111EXAMPLE/assets/a1b2c3d4-5678-90ab-cdef-22222EXAMPLE/properties/a1b2c3d4-5678-90ab-cdef-33333EXAMPLE",
         "state": "DISABLED"
       },
       "dataType": "DOUBLE",
       "unit": "m/s",
       "type": {
         "measurement": {}
       }
     }
   }
   ```

1. Run the following command to enable notifications for the asset property\. Replace *property\-alias* with the property alias from the previous command's response, or omit `--property-alias` to update the property without an alias\.

   ```
   aws iotsitewise update-asset-property \
     --asset-id asset-id \
     --property-id property-id \
     --property-notification-state ENABLED \
     --property-alias property-alias
   ```

   You can also pass `--property-notification-state DISABLED` to disable notifications for the asset property\.

## Querying asset property notification messages<a name="query-notification-messages"></a>

AWS IoT SiteWise publishes asset property data updates to AWS IoT Core in the following format\.

```
{
  "type": "PropertyValueUpdate",
  "payload": {
    "assetId": "String",
    "propertyId": "String",
    "values": [
      {
        "timestamp": {
          "timeInSeconds": Number,
          "offsetInNanos": Number
        },
        "quality": "String",
        "value": {
          "booleanValue": Boolean,
          "doubleValue": Number,
          "integerValue": Number,
          "stringValue": "String"
        }
      }
    ]
  }
}
```

Each structure in the `values` list is a timestamp\-quality\-value \(TQV\) structure\.
+ The `timestamp` contains the current Unix epoch time in seconds with nanosecond offset\.
+ The `quality` contains one of the following strings that indicate the quality of the data point:
  + `GOOD` – The data isn't affected by any issues\.
  + `BAD` – The data is affected by an issue such as sensor failure\.
  + `UNCERTAIN` – The data is affected by an issue such as sensor inaccuracy\.
+ The `value` contains one of the following fields, depending on the type of the property:
  + `booleanValue`
  + `doubleValue`
  + `integerValue`
  + `stringValue`

To parse values out of the `values` array, you need to use complex nested object queries in your rules' SQL statements\. For more information, see [Nested object queries](https://docs.aws.amazon.com/iot/latest/developerguide/iot-sql-nested-queries.html) in the *AWS IoT Developer Guide*, or see the [Publishing property value updates to Amazon DynamoDB](publish-to-amazon-dynamodb.md) tutorial for a specific example of parsing asset property notification messages\.

**Example query to extract the array of values**  
The following statement demonstrates how to query the array of updated property values for a specific double\-type property on all assets with that property\.  

```
SELECT
  (SELECT VALUE (value.doubleValue) FROM payload.values) AS windspeed
FROM
  '$aws/sitewise/asset-models/a1b2c3d4-5678-90ab-cdef-11111EXAMPLE/assets/+/properties/a1b2c3d4-5678-90ab-cdef-33333EXAMPLE' 
WHERE
  type = 'PropertyValueUpdate'
```
The previous rule query statement outputs data in the following format\.  

```
{
  "windspeed": [
    26.32020195042838,
    26.282584572975477,
    26.352566977372508,
    26.283084346171442,
    26.571883739599322,
    26.60684140743005,
    26.628738636715045,
    26.273486932802125,
    26.436379105473964,
    26.600590095377303
  ]
}
```

**Example query to extract a single value**  
The following statement demonstrates how to query the first value from the array of property values for a specific double\-type property on all assets with that property\.  

```
SELECT
  get((SELECT VALUE (value.doubleValue) FROM payload.values), 0) AS windspeed
FROM
  '$aws/sitewise/asset-models/a1b2c3d4-5678-90ab-cdef-11111EXAMPLE/assets/+/properties/a1b2c3d4-5678-90ab-cdef-33333EXAMPLE' 
WHERE
  type = 'PropertyValueUpdate'
```

The previous rule query statement outputs data in the following format\.

```
{
  "windspeed": 26.32020195042838
}
```

**Important**  
This rule query statement ignores value updates other than the first in each batch\. Each batch can contain up to 10 values\. If you need to include the remaining values, you must set up a more complex solution to output asset property values to other services\. For example, you can set up a rule with an AWS Lambda action to republish each value in the array to another topic, and set up another rule to query that topic and publish each value to the desired rule action\.