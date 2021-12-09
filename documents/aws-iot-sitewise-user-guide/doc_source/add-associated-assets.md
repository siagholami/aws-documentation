# Associating and disassociating assets<a name="add-associated-assets"></a>

If your asset's model defines any child asset model hierarchies, you can associate child assets to your asset\. Parent assets can access and aggregate data from associated assets\. For more information about hierarchical asset models, see [Defining relationships between assets \(hierarchies\)](asset-hierarchies.md)\.

**Topics**
+ [Associating and disassociating assets \(console\)](#associate-asset-console)
+ [Associating and disassociating assets \(CLI\)](#associate-asset-cli)

## Associating and disassociating assets \(console\)<a name="associate-asset-console"></a>

You can use the AWS IoT SiteWise console to associate and disassociate assets\.

**To associate an asset \(console\)**

1. <a name="sitewise-open-console"></a>Navigate to the [AWS IoT SiteWise console](https://console.aws.amazon.com/iotsitewise/)\.

1. <a name="sitewise-choose-assets"></a>In the navigation pane, choose **Assets**\.

1. Choose the parent asset for which you want to associate a child asset\.
**Tip**  <a name="sitewise-expand-asset-hierarchy"></a>
You can choose the arrow icon to expand an asset hierarchy to find your asset\.  

![\[AWS IoT SiteWise "Assets" page screenshot with an asset hierarchy highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-expand-asset-hierarchy-console.png)

1. Choose **Edit**\.

1. In **Assets associated to this asset**, choose **Add associated asset**\.  
![\[AWS IoT SiteWise "Edit asset" page screenshot with "Add associated asset" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-associate-asset-console.png)

1. For **Hierarchy**, choose the hierarchy that defines the relationship between the parent asset and the child asset\.

1. For **Asset**, choose the child asset to associate\.

1. Choose **Save**\.

**To disassociate an asset \(console\)**

1. <a name="sitewise-open-console"></a>Navigate to the [AWS IoT SiteWise console](https://console.aws.amazon.com/iotsitewise/)\.

1. <a name="sitewise-choose-assets"></a>In the navigation pane, choose **Assets**\.

1. Choose the parent asset for which you want to disassociate a child asset\.
**Tip**  <a name="sitewise-expand-asset-hierarchy"></a>
You can choose the arrow icon to expand an asset hierarchy to find your asset\.  

![\[AWS IoT SiteWise "Assets" page screenshot with an asset hierarchy highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-expand-asset-hierarchy-console.png)

1. Choose **Edit**\.

1. In **Assets associated to this asset**, choose **Disassociate** for the asset\.  
![\[AWS IoT SiteWise "Edit asset" page screenshot with "Disassociate" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-disassociate-asset-console.png)

1. Choose **Save**\.

## Associating and disassociating assets \(CLI\)<a name="associate-asset-cli"></a>

You can use the AWS Command Line Interface \(AWS CLI\) to associate and disassociate assets\.

For this procedure, you must know the ID of the hierarchy \(`hierarchyId`\) in the parent asset model that defines the relationship to the child asset model\. Use the [DescribeAsset](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_DescribeAsset.html) operation to find the hierarchy ID in the response\.

**To find a hierarchy ID**
+ Run the following command to describe the parent asset\. Replace *parent\-asset\-id* with the parent asset's ID\.

  ```
  aws iotsitewise describe-asset --asset-id parent-asset-id
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

  The hierarchy ID is the `id` value for a hierarchy in the list of asset hierarchies\.

After you have the hierarchy ID, you can associate or disassociate an asset with that hierarchy\.

To associate a child asset to a parent asset, use the [AssociateAssets](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_AssociateAssets.html) operation\. To disassociate a child asset from a parent asset, use the [DisassociateAssets](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_DisassociateAssets.html) operation\. Specify the following parameters, which are the same for both operations:
+ `assetId` – The parent asset's ID\.
+ `hierarchyId` – The hierarchy ID in the parent asset\.
+ `childAssetId` – The child asset's ID\.

**To associate an asset \(CLI\)**
+ Run the following command to associate a child asset to a parent asset\. Replace *parent\-asset\-id*, *hierarchy\-id*, and *child\-asset\-id* with the respective IDs\.

  ```
  aws iotsitewise associate-assets \
    --asset-id parent-asset-id \
    --hierarchy-id hierarchy-id \
    --child-asset-id child-asset-id
  ```

**To disassociate an asset \(CLI\)**
+ Run the following command to disassociate a child asset from a parent asset\. Replace *parent\-asset\-id*, *hierarchy\-id*, and *child\-asset\-id* with the respective IDs\.

  ```
  aws iotsitewise disassociate-assets \
    --asset-id parent-asset-id \
    --hierarchy-id hierarchy-id \
    --child-asset-id child-asset-id
  ```