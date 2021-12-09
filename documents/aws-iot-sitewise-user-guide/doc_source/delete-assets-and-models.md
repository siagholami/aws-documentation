# Deleting assets and models<a name="delete-assets-and-models"></a>

You can delete your assets and models from AWS IoT SiteWise when you're done with them\. The delete operations are asynchronous and take time to propagate through AWS IoT SiteWise\.

**Topics**
+ [Deleting assets](#delete-assets)
+ [Deleting asset models](#delete-asset-models)

## Deleting assets<a name="delete-assets"></a>

You can use the AWS IoT SiteWise console or API to delete an asset\.

Before you can delete an asset, you must first disassociate its child assets and disassociate it from its parent asset\. For more information, see [Associating and disassociating assets](add-associated-assets.md)\. If you use the AWS CLI, you can use the [ListAssociatedAssets](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_ListAssociatedAssets.html) operation to list an asset's children\.

When you delete an asset, its status is `DELETING` until the changes propagate\. For more information, see [Asset and model states](asset-and-model-states.md)\. After the asset is deleted, you can't query that asset\. If you do, the API returns an HTTP 404 response\.

**Important**  
AWS IoT SiteWise deletes all property data for deleted assets\.

**Topics**
+ [Deleting an asset \(console\)](#delete-asset-console)
+ [Deleting an asset \(CLI\)](#delete-asset-cli)

### Deleting an asset \(console\)<a name="delete-asset-console"></a>

You can use the AWS IoT SiteWise console to delete an asset\.

**To delete an asset \(console\)**

1. <a name="sitewise-open-console"></a>Navigate to the [AWS IoT SiteWise console](https://console.aws.amazon.com/iotsitewise/)\.

1. <a name="sitewise-choose-assets"></a>In the navigation pane, choose **Assets**\.

1. Choose the asset to delete\.
**Tip**  <a name="sitewise-expand-asset-hierarchy"></a>
You can choose the arrow icon to expand an asset hierarchy to find your asset\.  

![\[AWS IoT SiteWise "Assets" page screenshot with an asset hierarchy highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-expand-asset-hierarchy-console.png)

1. If the asset has any **Associated assets**, delete each asset\. You can choose an asset's name to navigate to its page, where you can delete it\.  
![\[AWS IoT SiteWise "Asset" page screenshot with "Associated assets" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-list-associated-assets-console.png)

1. On the asset's page, choose **Delete**\.

1. In the **Delete asset** dialog, do the following:

   1. Enter **Delete** to confirm deletion\.

   1. Choose **Delete**\.  
![\[AWS IoT SiteWise "Asset" page screenshot with "Delete" highlighted in the delete confirmation dialog.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-delete-asset-console.png)

### Deleting an asset \(CLI\)<a name="delete-asset-cli"></a>

You can use the AWS Command Line Interface \(AWS CLI\) to delete an asset\.

Use the [DeleteAsset](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_DeleteAsset.html) operation to delete an asset\. Specify the following parameter:
+ `assetId` – The asset's ID\.

**To delete an asset \(CLI\)**

1. Run the following command to list the asset's hierarchies\. Replace *asset\-id* with the ID of the asset\.

   ```
   aws iotsitewise describe-asset --asset-id asset-id
   ```

   The operation returns a response that contains the asset's details\. The response contains an `assetHierarchies` list that has the following structure\.

   ```
   {
     ...
     "assetHierarchies": [
       {
         "id": "String",
         "name": "String"
       }
     ],
     ...
   }
   ```

   For more information, see the [DescribeAsset](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_DescribeAsset.html) operation\.

1. For each hierarchy, run the following command to list the asset's children that are associated with that hierarchy\. Replace *asset\-id* with the ID of the asset and *hierarchy\-id* with the ID of the hierarchy\.

   ```
   aws iotsitewise list-associated-assets \
     --asset-id asset-id \
     --hierarchy-id hierarchy-id
   ```

   For more information, see the [ListAssociatedAssets](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_ListAssociatedAssets.html) operation\.

1. Run the following command to delete each associated asset and then to delete the asset\. Replace *asset\-id* with the ID of the asset\.

   ```
   aws iotsitewise delete-asset --asset-id asset-id
   ```

## Deleting asset models<a name="delete-asset-models"></a>

You can use the AWS IoT SiteWise console or API to delete an asset model\.

Before you can delete an asset model, you must first delete all assets created from the asset model\.

When you delete an asset model, its status is `DELETING` until the changes propagate\. For more information, see [Asset and model states](asset-and-model-states.md)\. After the asset model is deleted, you can't query that asset model\. If you do, the API returns an HTTP 404 response\.

### Deleting an asset model \(console\)<a name="delete-asset-model-console"></a>

You can use the AWS IoT SiteWise console to delete an asset model\.

**Topics**

**To delete an asset model \(console\)**

1. <a name="sitewise-open-console"></a>Navigate to the [AWS IoT SiteWise console](https://console.aws.amazon.com/iotsitewise/)\.

1. <a name="sitewise-choose-models"></a>In the navigation pane, choose **Models**\.

1. Choose the asset model to delete\.

1. If the model has any **Assets**, delete each asset\. Choose an asset's name to navigate to its page, where you can delete it\. For more information, see [Deleting an asset \(console\)](#delete-asset-console)\.  
![\[AWS IoT SiteWise "Model" page screenshot with "Assets" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-list-assets-for-model-console.png)

1. On the model's page, choose **Delete**\.

1. In the **Delete model** dialog, do the following:

   1. Enter **Delete** to confirm deletion\.

   1. Choose **Delete**\.  
![\[AWS IoT SiteWise "Model" page screenshot with "Delete" highlighted in the delete confirmation dialog.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-delete-model-console.png)

### Deleting an asset model \(CLI\)<a name="delete-asset-model-cli"></a>

You can use the AWS CLI to delete an asset model\.

Use the [DeleteAssetModel](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_DeleteAssetModel.html) operation to delete an asset model\. Specify the following parameter:
+ `assetModelId` – The asset model's ID\.

**To delete an asset model \(CLI\)**

1. Run the following command to list all assets created from the model\. Replace *asset\-model\-id* with the ID of the asset model\.

   ```
   aws iotsitewise list-assets --asset-model-id asset-model-id
   ```

   For more information, see the [ListAssets](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_ListAssets.html) operation\.

1. If the previous command returns any assets from the model, delete each asset\. For more information, see [Deleting an asset \(CLI\)](#delete-asset-cli)\.

1. Run the following command to delete the asset model\. Replace *asset\-model\-id* with the ID of the asset model\.

   ```
   aws iotsitewise delete-asset-model --asset-model-id asset-model-id
   ```