# Defining data streams from equipment \(measurements\)<a name="measurements"></a>

A measurement represents a device's raw sensor data stream, such as timestamped temperature values or timestamped rotations per minute \(RPM\) values\.

**Topics**
+ [Defining measurements \(console\)](#define-measurements-console)
+ [Defining measurements \(CLI\)](#define-measurements-cli)

## Defining measurements \(console\)<a name="define-measurements-console"></a>

When you define a measurement for an asset model in the AWS IoT SiteWise console, you specify following parameters:
+ <a name="asset-property-name-console"></a>**Name** – The property's name\.
+ <a name="asset-property-unit-console"></a>**Unit** – \(Optional\) The scientific unit for the property, such as mm or Celsius\.
+ <a name="asset-property-data-type-console"></a>**Data type** – The property's data type, which is one of the following:
  + **String** – A string with up to 1024 bytes\.
  + **Integer** – A signed 32\-bit integer with range \[\-2,147,483,648, 2,147,483,647\]\.
  + **Double** – A floating point number with range \[\-10^100, 10^100\] and IEEE 754 double precision\.
  + **Boolean** – `true` or `false`\.

For more information, see [Creating an asset model \(console\)](create-asset-models.md#create-asset-model-console)\.

**Example measurement definition**  
The following example demonstrates a measurement that represents an asset's temperature sensor readings\.  

![\[AWS IoT SiteWise "Create model" page screenshot with an example measurement's parameters highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-define-measurement-console.png)

## Defining measurements \(CLI\)<a name="define-measurements-cli"></a>

When you define a measurement for an asset model with the AWS IoT SiteWise API, you specify the following parameters:
+ <a name="asset-property-name-cli"></a>`name` – The property's name\.
+ <a name="asset-property-data-type-cli"></a>`dataType` – The property's data type, which is one of the following:
  + `STRING` – A string with up to 1024 bytes\.
  + `INTEGER` – A floating point number with range \[\-10^100, 10^100\] and IEEE 754 double precision\.
  + `DOUBLE` – A signed 32\-bit integer with range \[\-2,147,483,648, 2,147,483,647\]\.
  + `BOOLEAN` – `true` or `false`\.
+ <a name="asset-property-unit-cli"></a>`unit` – \(Optional\) The scientific unit for the property, such as mm or Celsius\.

**Example measurement definition**  
The following example demonstrates a measurement that represents an asset's temperature sensor readings\. This object is an example of an [AssetModelProperty](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_AssetModelProperty.html) that contains a [Measurement](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_Measurement.html)\. You can specify this object as a part of the [CreateAssetModel](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_CreateAssetModel.html) request payload to create a measurement property\. For more information, see [Creating an asset model \(CLI\)](create-asset-models.md#create-asset-model-cli)\.  
The [Measurement](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_Measurement.html) structure is an empty structure when you define an asset model because you later configure each asset to use unique device data streams\. For more information about how to connect an asset's measurement property to a device's sensor data stream, see the [Mapping industrial data streams to asset properties](connect-data-streams.md)\.  

```
{
  ...
  "assetModelProperties": [
    {
      "name": "Temperature C",
      "dataType": "DOUBLE",
      "type": {
        "measurement": {}
      },
      "unit": "Celsius"
    }
  ],
  ...
}
```