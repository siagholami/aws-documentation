# Updating assets and models<a name="update-assets-and-models"></a>

You can update your assets and asset models in AWS IoT SiteWise to modify their names and definitions\. These update operations are asynchronous and take time to propagate through AWS IoT SiteWise\. Check the status of the asset or asset model before you make additional changes\. You must wait until the changes propagate before you can continue to use the updated asset or model\.

**Topics**
+ [Updating assets](#update-assets)
+ [Updating asset models](#update-asset-models)

## Updating assets<a name="update-assets"></a>

You can use the AWS IoT SiteWise console or API to update an asset's name\.

When you update an asset, the asset's status is `UPDATING` until the changes propagate\. For more information, see [Asset and model states](asset-and-model-states.md)\.

**Topics**
+ [Updating an asset \(console\)](#update-asset-console)
+ [Updating an asset \(CLI\)](#update-asset-cli)

### Updating an asset \(console\)<a name="update-asset-console"></a>

You can use the AWS IoT SiteWise console to update asset details\.

**To update an asset \(console\)**

1. <a name="sitewise-open-console"></a>Navigate to the [AWS IoT SiteWise console](https://console.aws.amazon.com/iotsitewise/)\.

1. <a name="sitewise-choose-assets"></a>In the navigation pane, choose **Assets**\.

1. Choose the asset to update\.
**Tip**  <a name="sitewise-expand-asset-hierarchy"></a>
You can choose the arrow icon to expand an asset hierarchy to find your asset\.  

![\[AWS IoT SiteWise "Assets" page screenshot with an asset hierarchy highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-expand-asset-hierarchy-console.png)

1. Choose **Edit**\.

1. Update the asset's **Name**\.

1. \(Optional\) On this page, update other information for the asset\. For more information, see the following:
   + [Mapping industrial data streams to asset properties](connect-data-streams.md)
   + [Updating attribute values](update-attribute-values.md)
   + [Interacting with other AWS services](interact-with-other-services.md)

1. Choose **Save**\.

### Updating an asset \(CLI\)<a name="update-asset-cli"></a>

You can use the AWS CLI to update an asset's name\.

Use the [UpdateAsset](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_UpdateAsset.html) operation to update an asset\. Specify the following parameters:
+ `assetId` – The asset's ID\.
+ `assetName` – The asset's new name\.

**To update an asset's name \(CLI\)**
+ Run the following command to update an asset's name\. Replace *asset\-id* with the ID of the asset and *asset\-name* with the new name for the asset\.

  ```
  aws iotsitewise update-asset \
    --asset-id asset-id \
    --asset-name asset-name
  ```

## Updating asset models<a name="update-asset-models"></a>

You can use the AWS IoT SiteWise console or API to update an asset model\.

You can't change the type or data type of an existing property\. You also can't change the window of an existing metric\.

**Important**  
If you remove a property from an asset model, AWS IoT SiteWise deletes all previous data for that property\. If you remove a hierarchy definition from an asset model, AWS IoT SiteWise disassociates all assets in that hierarchy\.

When you update an asset model, every asset based on that model reflects any changes that you make to the underlying model\. Until the changes propagate, each asset has the `UPDATING` state\. You must wait until those assets return to the `ACTIVE` state before you interact with them\. During this time, the updated asset model's status will be `PROPAGATING`\. For more information, see [Asset and model states](asset-and-model-states.md)\.

**Topics**
+ [Updating an asset model \(console\)](#update-asset-model-console)
+ [Updating an asset model \(CLI\)](#update-asset-model-cli)

### Updating an asset model \(console\)<a name="update-asset-model-console"></a>

You can use the AWS IoT SiteWise console to update an asset model\.

**To update an asset model \(console\)**

1. <a name="sitewise-open-console"></a>Navigate to the [AWS IoT SiteWise console](https://console.aws.amazon.com/iotsitewise/)\.

1. <a name="sitewise-choose-models"></a>In the navigation pane, choose **Models**\.

1. Choose the asset model to update\.

1. Choose **Edit**\.

1. On the **Edit model** page, do any of the following:
   + In **Model details**, change the **Name** of the model\.
   + Change any of the **Attribute definitions**\. You can't change the **Data type** of existing attributes\. For more information, see [Defining static data \(attributes\)](attributes.md)\.
   + Change any of the **Measurement definitions**\. You can't change the **Data type** of existing measurements\. For more information, see [Defining data streams from equipment \(measurements\)](measurements.md)\.
   + Change any of the **Transform definitions**\. For more information, see [Transforming data \(transforms\)](transforms.md)\.
   + Change any of the **Metric definitions**\. You can't change the **Time interval** of existing metrics\. For more information, see [Aggregating data from properties and other assets \(metrics\)](metrics.md)\.
   + Change any of the **Hierarchy definitions**\. You can't change the **Hierarchy model** of existing hierarchies\. For more information, see [Defining relationships between assets \(hierarchies\)](asset-hierarchies.md)\.

1. Choose **Save**\.

### Updating an asset model \(CLI\)<a name="update-asset-model-cli"></a>

You can use the AWS CLI to update an asset model\.

Use the [UpdateAssetModel](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_UpdateAssetModel.html) operation to update an asset model's name, description, properties, and hierarchies\. Specify the following parameter:
+ `assetModelId` – The asset model's ID\.

Specify the updated asset model in the payload\. To learn about the expected format of an asset model, see [Creating asset models](create-asset-models.md)\.

**Warning**  
The [UpdateAssetModel](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_UpdateAssetModel.html) operation overwrites the existing model with the model that you provide in the payload\. To avoid deleting your asset model's properties or hierarchies, you must include their IDs and definitions in the updated asset model payload\. To learn how to query your model's existing structure, see the [DescribeAssetModel](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_DescribeAssetModel.html) operation\.

**To update an asset model \(CLI\)**

1. Run the following command to retrieve the existing asset model definition\. Replace *asset\-model\-id* with the ID of the asset model to update\.

   ```
   aws iotsitewise describe-asset-model --asset-model-id asset-model-id
   ```

   The operation returns a response that contains the asset model's details\. The response has the following structure\.

   ```
   {
     "assetModelId": "String",
     "assetModelArn": "String",
     "assetModelName": "String",
     "assetModelDescription": "String",
     "assetModelProperties": Array of AssetModelProperty,
     "assetModelHierarchies": Array of AssetModelHierarchyDefinition,
     "assetModelCreationDate": "String",
     "assetModelLastUpdateDate": "String",
     "assetModelStatus": {
       "state": "String",
       "error": {
         "code": "String",
         "message": "String"
       }
     }
   }
   ```

   For more information, see the [DescribeAssetModel](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_DescribeAssetModel.html) operation\.

1. Create a file called `update-asset-model.json` and copy the previous command's response into the file\.

1. Remove the following key\-value pairs from the JSON object in `update-asset-model.json`:
   + `assetModelId`
   + `assetModelArn`
   + `assetModelCreationDate`
   + `assetModelLastUpdateDate`
   + `assetModelStatus`

   The [UpdateAssetModel](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_UpdateAssetModel.html) operation expects a payload with the following structure\.

   ```
   {
     "assetModelName": "String",
     "assetModelDescription": "String",
     "assetModelProperties": Array of AssetModelProperty,
     "assetModelHierarchies": Array of AssetModelHierarchyDefinition
   }
   ```

1. In `update-asset-model.json`, do any of the following:
   + Change the asset model's name \(`assetModelName`\)\.
   + Change, add, or remove the asset model's description \(`assetModelDescription`\)\.
   + Change, add, or remove any of the asset model's properties \(`assetModelProperties`\)\. You can't change the `dataType` of existing properties or the `window` of existing metrics\. For more information, see [Defining data properties](asset-properties.md)\.
   + Change, add, or remove any of the asset model's hierarchies \(`assetModelHierarchies`\)\. You can't change the `childAssetModelId` of existing hierarchies\. For more information, see [Defining relationships between assets \(hierarchies\)](asset-hierarchies.md)\.

1. Run the following command to update the asset model with the definition stored in `update-asset-model.json`\. Replace *asset\-model\-id* with the ID of the asset model\.

   ```
   aws iotsitewise update-asset-model \
     --asset-model-id asset-model-id \
     --cli-input-json file://model-payload.json
   ```