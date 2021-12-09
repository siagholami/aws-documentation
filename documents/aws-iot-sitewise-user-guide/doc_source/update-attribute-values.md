# Updating attribute values<a name="update-attribute-values"></a>

Assets inherit the attributes of their asset model, including the default value of the attribute\. In some cases, you will want to keep the asset model's default attribute, such as for an asset manufacturer property\. In other cases, you will want to update the inherited attribute, such as for an asset's latitude and longitude\. 

**Topics**
+ [Updating an attribute value \(console\)](#update-attribute-value-console)
+ [Updating an attribute value \(CLI\)](#update-attribute-value-cli)

## Updating an attribute value \(console\)<a name="update-attribute-value-console"></a>

You can use the AWS IoT SiteWise console to update the value of an attribute asset property\.

**To update an attribute's value \(console\)**

1. <a name="sitewise-open-console"></a>Navigate to the [AWS IoT SiteWise console](https://console.aws.amazon.com/iotsitewise/)\.

1. <a name="sitewise-choose-assets"></a>In the navigation pane, choose **Assets**\.

1. Choose the asset for which you want to update an attribute\.
**Tip**  <a name="sitewise-expand-asset-hierarchy"></a>
You can choose the arrow icon to expand an asset hierarchy to find your asset\.  

![\[AWS IoT SiteWise "Assets" page screenshot with an asset hierarchy highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-expand-asset-hierarchy-console.png)

1. Choose **Edit**\.

1. Find the attribute to update, and then enter its new value\.  
![\[AWS IoT SiteWise "Edit asset" page screenshot with an attribute value highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-update-asset-attribute-console.png)

1. Choose **Save**\.

## Updating an attribute value \(CLI\)<a name="update-attribute-value-cli"></a>

You can use the AWS Command Line Interface \(AWS CLI\) to update an attribute value\.

You must know your asset's `assetId` and property's `propertyId` to complete this procedure\. If you created an asset but don't know its `assetId`, use the [ListAssets](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_ListAssets.html) operation to view all of your assets for a specific model\. Then, use the [DescribeAsset](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_DescribeAsset.html) operation to view your asset's properties including property IDs\.

Use the [BatchPutAssetPropertyValue](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_BatchPutAssetPropertyValue.html) operation to assign attribute values to your asset\. You can use this operation to set multiple attributes at once\. This operation's payload contains a list of entries, and each entry contains the asset ID, property ID, and attribute value\.

**To update an attribute's value \(CLI\)**

1. Create a file called `batch-put-payload.json` and copy the following JSON object into the file\. This example payload demonstrates how to set a wind turbine's latitude and longitude\. Update the IDs, values, and timestamps to modify the payload for your use case\.

   ```
   {
     "entries": [
       {
         "entryId": "windfarm3-turbine7-latitude",
         "assetId": "a1b2c3d4-5678-90ab-cdef-22222EXAMPLE",
         "propertyId": "a1b2c3d4-5678-90ab-cdef-33333EXAMPLE",
         "propertyValues": [
           {
             "value": {
               "doubleValue": 47.6204
             },
             "timestamp": {
               "timeInSeconds": 1575691200
             }
           }
         ]
       },
       {
         "entryId": "windfarm3-turbine7-longitude",
         "assetId": "a1b2c3d4-5678-90ab-cdef-22222EXAMPLE",
         "propertyId": "a1b2c3d4-5678-90ab-cdef-55555EXAMPLE",
         "propertyValues": [
           {
             "value": {
               "doubleValue": 122.3491
             },
             "timestamp": {
               "timeInSeconds": 1575691200
             }
           }
         ]
       }
     ]
   }
   ```

   Each entry in the payload contains an `entryId` that you can define as any unique string\. If any request entries fail, each error will contain the `entryId` of the corresponding request so that you know which requests to retry\.

   To set an attribute value, you can include one timestamp\-quality\-value \(TQV\) structure in the list of `propertyValues` for each attribute property\. This structure must contain the new `value` and the current `timestamp`\.
   + `value` – A structure that contains one of the following fields, depending on the type of the property being set:
     + `booleanValue`
     + `doubleValue`
     + `integerValue`
     + `stringValue`
   + `timestamp` – A structure that contains the current Unix epoch time in seconds, `timeInSeconds`\. AWS IoT SiteWise rejects any data points with timestamps older than 15 minutes in the past or newer than 5 minutes in the future\.

   For more information about how to prepare a payload for [BatchPutAssetPropertyValue](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_BatchPutAssetPropertyValue.html), see [Ingesting data using the AWS IoT SiteWise API](ingest-api.md)\.

1. Run the following command to send the attribute values to AWS IoT SiteWise\.

   ```
   aws iotsitewise batch-put-asset-property-value --cli-input-json file://batch-put-payload.json
   ```