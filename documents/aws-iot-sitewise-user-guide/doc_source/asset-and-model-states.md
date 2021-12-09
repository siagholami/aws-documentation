# Asset and model states<a name="asset-and-model-states"></a>

When you create, update, or delete an asset or an asset model, the changes take time to propagate\. AWS IoT SiteWise resolves these operations asynchronously and updates the status of each resource\. Each asset and asset model has a status field that contains the state of the resource and any error message, if applicable\. The state can be one of the following values:
+ `ACTIVE` – The asset or asset model is active\. This is the only state in which you can query and interact with assets and asset models\.
+ `CREATING` – The asset or asset model is being created\.
+ `UPDATING` – The asset or asset model is being updated\.
+ `DELETING` – The asset or asset model is being deleted\.
+ `PROPAGATING` – \(Asset models only\) The asset model's changes are propagating to all of its assets\.
+ `FAILED` – The asset or asset model failed to validate during a create or update operation, possibly due to a circular reference in an expression\. You can delete assets and asset models that are in the `FAILED` state\.

Some of the create, update, and delete operations in AWS IoT SiteWise place an asset or asset model in a state other than `ACTIVE` while the operation resolves\. If you need to query or interact with an asset or asset model after you perform one of these operations, you must wait until the state changes to `ACTIVE`\. Otherwise, your requests fail\.

**Topics**
+ [Checking the status of an asset](#check-asset-status)
+ [Checking the status of an asset model](#check-model-status)

## Checking the status of an asset<a name="check-asset-status"></a>

You can use the AWS IoT SiteWise console or API to check the status of an asset\.

**Topics**
+ [Checking the status of an asset \(console\)](#check-asset-status-console)
+ [Checking the status of an asset \(CLI\)](#check-asset-status-cli)

### Checking the status of an asset \(console\)<a name="check-asset-status-console"></a>

Use the following procedure to check the status of an asset in the AWS IoT SiteWise console\.

**To check the status of an asset \(console\)**

1. <a name="sitewise-open-console"></a>Navigate to the [AWS IoT SiteWise console](https://console.aws.amazon.com/iotsitewise/)\.

1. <a name="sitewise-choose-assets"></a>In the navigation pane, choose **Assets**\.

1. Choose the asset to check\.
**Tip**  <a name="sitewise-expand-asset-hierarchy"></a>
You can choose the arrow icon to expand an asset hierarchy to find your asset\.  

![\[AWS IoT SiteWise "Assets" page screenshot with an asset hierarchy highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-expand-asset-hierarchy-console.png)

1. Find **Status** in the **Asset details** panel\.  
![\[AWS IoT SiteWise "Asset" page screenshot with asset status highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-view-asset-status-console.png)

### Checking the status of an asset \(CLI\)<a name="check-asset-status-cli"></a>

You can use the AWS Command Line Interface \(AWS CLI\) to check the status of an asset\.

To check the status of an asset, use the [DescribeAsset](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_DescribeAsset.html) operation with the `assetId` parameter\.

**To check the status of an asset \(CLI\)**
+ Run the following command to describe the asset\. Replace *asset\-id* with the asset's ID\.

  ```
  aws iotsitewise describe-asset --asset-id asset-id
  ```

  The operation returns a response that contains the asset's details\. The response contains an `assetStatus` object that has the following structure\.

  ```
  {
    ...
    "assetStatus": {
      "state": "String",
      "error": {
         "code": "String",
         "message": "String"
      }
    }
  }
  ```

  The asset's state is in `assetStatus.state` in the JSON object\.

## Checking the status of an asset model<a name="check-model-status"></a>

You can use the AWS IoT SiteWise console or API to check the status of an asset model\.

**Topics**
+ [Checking the status of an asset model \(console\)](#check-model-status-console)
+ [Checking the status of an asset model \(CLI\)](#check-model-status-cli)

### Checking the status of an asset model \(console\)<a name="check-model-status-console"></a>

Use the following procedure to check the status of an asset model in the AWS IoT SiteWise console\.

**To check the status of an asset model \(console\)**

1. <a name="sitewise-open-console"></a>Navigate to the [AWS IoT SiteWise console](https://console.aws.amazon.com/iotsitewise/)\.

1. <a name="sitewise-choose-models"></a>In the navigation pane, choose **Models**\.

1. Choose the asset model to check\.

1. Find **Status** in the **Details** panel\.  
![\[AWS IoT SiteWise "Asset model" page screenshot with asset model status highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-view-model-status-console.png)

### Checking the status of an asset model \(CLI\)<a name="check-model-status-cli"></a>

You can use the AWS CLI to check the status of an asset model\.

To check the status of an asset model, use the [DescribeAssetModel](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_DescribeAssetModel.html) operation with the `assetModelId` parameter\.

**To check the status of an asset model \(CLI\)**
+ Run the following command to describe the asset model\. Replace *asset\-model\-id* with the asset model's ID\.

  ```
  aws iotsitewise describe-asset-model --asset-model-id asset-model-id
  ```

  The operation returns a response that contains the asset model's details\. The response contains an `assetModelStatus` object that has the following structure\.

  ```
  {
    ...
    "assetModelStatus": {
      "state": "String",
      "error": {
         "code": "String",
         "message": "String"
      }
    }
  }
  ```

  The asset model's state is in `assetModelStatus.state` in the JSON object\.