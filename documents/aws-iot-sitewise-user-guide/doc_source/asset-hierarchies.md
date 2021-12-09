# Defining relationships between assets \(hierarchies\)<a name="asset-hierarchies"></a>

You can define asset hierarchies to create logical associations between the assets in your industrial operation\. For example, you can define a wind farm composed of several wind turbine assets or an assembly line comprising multiple machine assets\.

When you associate a child asset to a parent asset through a hierarchy, the parent asset's metrics can input data from the child asset's metrics\. You can use asset hierarchies and metrics to calculate statistics that provide insight to your operation or a subset of your operation\. For more information, see [Aggregating data from properties and other assets \(metrics\)](metrics.md)\.

Each hierarchy defines a relationship between a parent asset model and a child asset model\. In a parent asset model, you can define multiple hierarchies to the same child asset model\. For example, if you have two different types of wind turbine in your wind farms, where all wind turbines use the same asset model, you can define a hierarchy for each type\. Then, you can define metrics in the wind farm model to calculate independent and combined statistics for each type of wind turbine\.

To define an asset hierarchy, you must have an asset model for a child asset\. For more information, see [Creating asset models](create-asset-models.md)\.

**Note**  
When you define an asset hierarchy, the child asset model must be `ACTIVE` or have a previous `ACTIVE` version\. For more information, see [Asset and model states](asset-and-model-states.md)\.  
Each asset model can have only one parent asset model\. For example, it's not possible to define three asset models \(A, B, and C\) where A and B both define a hierarchy to C\.

After you define hierarchical asset models and create assets, you can associate the assets to complete the parent\-child relationship\. For more information, see [Creating assets](create-assets.md) and [Associating and disassociating assets](add-associated-assets.md)\.

**Topics**
+ [Defining asset hierarchies \(console\)](#define-asset-hierarchies-console)
+ [Defining asset hierarchies \(CLI\)](#define-asset-hierarchies-cli)

## Defining asset hierarchies \(console\)<a name="define-asset-hierarchies-console"></a>

When you define a hierarchy for an asset model in the AWS IoT SiteWise console, you specify the following parameters:
+ **Hierarchy name** – The hierarchy's name, such as **Wind Turbines**\.
+ **Hierarchy model** – The child asset model\.

For more information, see [Creating an asset model \(console\)](create-asset-models.md#create-asset-model-console)\.

**Example hierarchy definition**  
The following example demonstrates an asset hierarchy that represents a wind farm's relationship to wind turbines\.  

![\[AWS IoT SiteWise "Create model" page screenshot with an example hierarchy's parameters highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-define-hierarchy-console.png)

## Defining asset hierarchies \(CLI\)<a name="define-asset-hierarchies-cli"></a>

When you define a hierarchy for an asset model with the AWS IoT SiteWise API, you specify the following parameters:
+ `name` – The hierarchy's name, such as **Wind Turbines**\.
+ `childAssetModelId` – The ID of the child asset model for the hierarchy\. You can use the [ListAssetModels](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_ListAssetModels.html) operation to find the ID of an existing asset model\.

**Example hierarchy definition**  
The following example demonstrates an asset hierarchy that represents a wind farm's relationship to wind turbines\. This object is an example of an [AssetModelHierarchy](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_AssetModelHierarchy.html)\. For more information, see [Creating an asset model \(CLI\)](create-asset-models.md#create-asset-model-cli)\.  

```
{
  ...
  "assetModelHierarchies": [
    {
      "name": "Wind Turbines",
      "childAssetModelId": "a1b2c3d4-5678-90ab-cdef-11111EXAMPLE"
    },
  ]
}
```