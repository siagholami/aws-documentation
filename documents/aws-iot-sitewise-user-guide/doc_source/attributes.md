# Defining static data \(attributes\)<a name="attributes"></a>

Asset attributes represent information that is generally static, such as device manufacturer or geographic location\. Each asset that you create from an asset model contains the attributes of that model\.

**Topics**
+ [Defining attributes \(console\)](#define-attributes-console)
+ [Defining attributes \(CLI\)](#define-attributes-cli)

## Defining attributes \(console\)<a name="define-attributes-console"></a>

When you define an attribute for an asset model in the AWS IoT SiteWise console, you specify the following parameters:
+ <a name="asset-property-name-console"></a>**Name** – The property's name\.
+ **Default value** – \(Optional\) The default value for this attribute\. Assets created from the model have this value for the attribute\. For more information about how to override the default value in an asset created from a model, see [Updating attribute values](update-attribute-values.md)\.
+ <a name="asset-property-data-type-console"></a>**Data type** – The property's data type, which is one of the following:
  + **String** – A string with up to 1024 bytes\.
  + **Integer** – A signed 32\-bit integer with range \[\-2,147,483,648, 2,147,483,647\]\.
  + **Double** – A floating point number with range \[\-10^100, 10^100\] and IEEE 754 double precision\.
  + **Boolean** – `true` or `false`\.

For more information, see [Creating an asset model \(console\)](create-asset-models.md#create-asset-model-console)\.

**Example attribute definition**  
The following example demonstrates an attribute that represents an asset's model number with a default value\.  

![\[AWS IoT SiteWise "Create model" page screenshot with an example attribute's parameters highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-define-attribute-console.png)

## Defining attributes \(CLI\)<a name="define-attributes-cli"></a>

When you define an attribute for an asset model with the AWS IoT SiteWise API, you specify the following parameters:
+ <a name="asset-property-name-cli"></a>`name` – The property's name\.
+ `defaultValue` – \(Optional\) The default value for this attribute\. Assets created from the model have this value for the attribute\. For more information about how to override the default value in an asset created from a model, see [Updating attribute values](update-attribute-values.md)\.
+ <a name="asset-property-data-type-cli"></a>`dataType` – The property's data type, which is one of the following:
  + `STRING` – A string with up to 1024 bytes\.
  + `INTEGER` – A floating point number with range \[\-10^100, 10^100\] and IEEE 754 double precision\.
  + `DOUBLE` – A signed 32\-bit integer with range \[\-2,147,483,648, 2,147,483,647\]\.
  + `BOOLEAN` – `true` or `false`\.

**Example attribute definition**  
The following example demonstrates an attribute that represents an asset's model number with a default value\. This object is an example of an [AssetModelProperty](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_AssetModelProperty.html) that contains an [Attribute](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_Attribute.html)\. You can specify this object as a part of the [CreateAssetModel](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_CreateAssetModel.html) request payload to create an attribute property\. For more information, see [Creating an asset model \(CLI\)](create-asset-models.md#create-asset-model-cli)\.  

```
{
  ...
  "assetModelProperties": [
    {
      "name": "Model number",
      "dataType": "STRING",
      "type": {
        "attribute": {
          "defaultValue": "BLT123"
        }
      }
    }
  ],
  ...
}
```