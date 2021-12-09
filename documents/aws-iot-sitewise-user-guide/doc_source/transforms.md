# Transforming data \(transforms\)<a name="transforms"></a>

Transforms are mathematical expressions that map an asset property's data points from one form to another\. A transform expression consists of asset property variables, mathematical operators, and common functions\. The transformed data points hold a one\-to\-one relationship with the input data points\.

For example, if your asset has a temperature measurement stream named `Temperature_C` with units in Celsius, you can convert each data point to Fahrenheit with the formula `Temperature_F = 9/5 * Temperature_C + 32`\. Each time AWS IoT SiteWise receives a data point in the `Temperature_C` measurement stream, the corresponding `Temperature_F` value is calculated and available as the `Temperature_F` property within a few seconds\.

**Topics**
+ [Defining transforms \(console\)](#define-transforms-console)
+ [Defining transforms \(CLI\)](#define-transform-cli)

## Defining transforms \(console\)<a name="define-transforms-console"></a>

When you define a transform for an asset model in the AWS IoT SiteWise console, you specify following parameters:
+ <a name="asset-property-name-console"></a>**Name** – The property's name\.
+ **Formula** – The transform expression\. Transform expressions can use common functions and relational functions\. Start typing or press the down arrow key to trigger the autocomplete feature\. For more information, see [Using formula expressions](formula-expressions.md)\.
**Important**  <a name="transform-input-rules"></a>
Transforms can only input properties that are integer or double type\. Transforms must input one non\-attribute property and any number of attribute properties\. AWS IoT SiteWise calculates a new transformed data point each time the non\-attribute input property receives a new data point\. New attribute values don't trigger transform updates\.
+ <a name="asset-property-unit-console"></a>**Unit** – \(Optional\) The scientific unit for the property, such as mm or Celsius\.

For more information, see [Creating an asset model \(console\)](create-asset-models.md#create-asset-model-console)\.

**Example transform definition**  
The following example demonstrates a transform property that converts an asset's temperature measurement data from Celsius to Fahrenheit\.  

![\[AWS IoT SiteWise "Create model" page screenshot with an example transform's parameters highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-define-transform-console.png)

## Defining transforms \(CLI\)<a name="define-transform-cli"></a>

When you define a transform for an asset model with the AWS IoT SiteWise API, you specify the following parameters:
+ <a name="asset-property-name-cli"></a>`name` – The property's name\.
+ `dataType` – The data type of the transform, which must be `DOUBLE`\.
+ `expression` – The transform expression\. Transform expressions can use common functions and relational functions\. For more information, see [Using formula expressions](formula-expressions.md)\.
+ `variables` – The list of variables that defines the other properties of your asset to use in the expression\. Each variable structure contains a simple name to use in the expression and a `value` structure that identifies which property to link to that variable\. The `value` structure contains the following information:
  + `propertyId` – The ID of the property from which to input values\. You can use the property's name instead of its ID\.
**Important**  <a name="transform-input-rules"></a>
Transforms can only input properties that are integer or double type\. Transforms must input one non\-attribute property and any number of attribute properties\. AWS IoT SiteWise calculates a new transformed data point each time the non\-attribute input property receives a new data point\. New attribute values don't trigger transform updates\.
+ <a name="asset-property-unit-cli"></a>`unit` – \(Optional\) The scientific unit for the property, such as mm or Celsius\.

**Example transform definition**  
The following example demonstrates a transform property that converts an asset's temperature measurement data from Celsius to Fahrenheit\. This object is an example of an [AssetModelProperty](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_AssetModelProperty.html) that contains a [Transform](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_Transform.html)\. You can specify this object as a part of the [CreateAssetModel](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_CreateAssetModel.html) request payload to create a transform property\. For more information, see [Creating an asset model \(CLI\)](create-asset-models.md#create-asset-model-cli)\.  

```
{
  ...
  "assetModelProperties": [
    ...
    {
      "name": "Temperature F",
      "dataType": "DOUBLE",
      "type": {
        "transform": {
          "expression": "9/5 * temp_c + 32",
          "variables": [
            {
              "name": "temp_c",
              "value": {
                "propertyId": "Temperature C"
              }
            }
          ]
        }
      },
      "unit": "Fahrenheit"
    }
  ],
  ...
}
```