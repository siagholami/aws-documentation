# Creating asset models<a name="create-asset-models"></a>

AWS IoT SiteWise asset models drive standardization of your industrial data\. An asset model contains a name, description, asset properties, and asset hierarchy definitions\. For example, you can define a wind turbine model with temperature, rotations per minute \(RPM\), and power properties\. Then, you can define a wind farm model with a net power output property and a wind turbine hierarchy definition\.

**Note**  
We recommend that you model your operation starting with the lowest\-level nodes\. For example, create your wind turbine model before you create your wind farm model\. Asset hierarchy definitions contain references to existing asset models\. With this approach, you can define asset hierarchies as you create your models\.

The following sections describe how to use the AWS IoT SiteWise console or API to create asset models\. The following sections also describe the different types of asset properties and asset hierarchies that you can use to create models\.

**Topics**
+ [Creating an asset model \(console\)](#create-asset-model-console)
+ [Creating an asset model \(CLI\)](#create-asset-model-cli)
+ [Example asset models](#asset-model-examples)
+ [Defining data properties](asset-properties.md)
+ [Defining relationships between assets \(hierarchies\)](asset-hierarchies.md)

## Creating an asset model \(console\)<a name="create-asset-model-console"></a>

You can use the AWS IoT SiteWise console to create an asset model\. The AWS IoT SiteWise console provides various features, such as formula autocompletion, that can help you define valid asset models\.

**To create an asset model \(console\)**

1. <a name="sitewise-open-console"></a>Navigate to the [AWS IoT SiteWise console](https://console.aws.amazon.com/iotsitewise/)\.

1. <a name="sitewise-choose-models"></a>In the navigation pane, choose **Models**\.

1. Choose **Create model**\.

1. On the **Create model** page, do the following:

   1. Enter a **Name** for the asset model, such as **Wind Turbine** or **Wind Turbine Model**\. This name must be unique across all models in your account in this Region\.

   1. \(Optional\) Add **Attribute definitions** for the model\. Attributes represent information that rarely changes\. For more information, see [Defining static data \(attributes\)](attributes.md)\.

   1. \(Optional\) Add **Measurement definitions** for the model\. Measurements represent data streams from your equipment\. For more information, see [Defining data streams from equipment \(measurements\)](measurements.md)\.

   1. \(Optional\) Add **Transform definitions** for the model\. Transforms are formulas that map data from one form to another\. For more information, see [Transforming data \(transforms\)](transforms.md)\.

   1. \(Optional\) Add **Metric definitions** for the model\. Metrics are formulas that aggregate data over time intervals\. Metrics can input data from associated assets, so that you can calculate values that represent your operation or a subset of your operation\. For more information, see [Aggregating data from properties and other assets \(metrics\)](metrics.md)\.

   1. \(Optional\) Add **Hierarchy definitions** for the model\. Hierarchies are relationships between assets\. For more information, see [Defining relationships between assets \(hierarchies\)](asset-hierarchies.md)\.

   1. \(Optional\) Add tags for the asset model\. For more information, see [Tagging your AWS IoT SiteWise resources](tag-resources.md)\.

   1. Choose **Create model**\.

   When you create an asset model, the AWS IoT SiteWise console navigates to the new model's page\. On this page, you can see the model's **Status**, which is initially **CREATING**\. This page automatically updates, so you can wait for the model's status to update\.
**Note**  
The asset model creation process can take up to a few minutes for complex models\. After the asset model status is **ACTIVE**, you can use the asset model to create assets\. For more information, see [Asset and model states](asset-and-model-states.md)\.

## Creating an asset model \(CLI\)<a name="create-asset-model-cli"></a>

You can use the AWS Command Line Interface \(AWS CLI\) to create an asset model\.

Use the [CreateAssetModel](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_CreateAssetModel.html) operation to create an asset model with properties and hierarchies\. This operation expects a payload with the following structure\.

```
{
  "assetModelName": "String",
  "assetModelDescription": "String",
  "assetModelProperties": Array of AssetModelProperty,
  "assetModelHierarchies": Array of AssetModelHierarchyDefinition
}
```

**To create an asset model \(CLI\)**

1. Create a file called `asset-model-payload.json` and then copy the following JSON object into the file\.

   ```
   {
     "assetModelName": "",
     "assetModelDescription": "",
     "assetModelProperties": [
     
     ],
     "assetModelHierarchies": [
     
     ]
   }
   ```

1. Use your preferred JSON text editor to edit the `asset-model-payload.json` file for the following:

   1. Enter a name \(`assetModelName`\) for the asset model, such as **Wind Turbine** or **Wind Turbine Model**\. This name must be unique across all models in your account in this Region\.

   1. \(Optional\) Enter a description \(`assetModelDescription`\) for the asset model, or remove the `assetModelDescription` key\-value pair\.

   1. \(Optional\) Define asset properties \(`assetModelProperties`\) for the model\. For more information, see [Defining data properties](asset-properties.md)\.

   1. \(Optional\) Define asset hierarchies \(`assetModelHierarchies`\) for the model\. For more information, see [Defining relationships between assets \(hierarchies\)](asset-hierarchies.md)\.

   1. \(Optional\) Add tags \(`tags`\) for the asset model\. For more information, see [Tagging your AWS IoT SiteWise resources](tag-resources.md)\.

1. Run the following command to create an asset model from the definition in the JSON file\.

   ```
   aws iotsitewise create-asset-model --cli-input-json file://asset-model-payload.json
   ```

   The operation returns a response that contains the `assetModelId` that you refer to when creating an asset\. The response also contains the state of the model \(`assetModelStatus.state`\), which is initially `CREATING`\. The asset model's status is `CREATING` until the changes propagate\.
**Note**  
The asset model creation process can take up to a few minutes for complex models\. To check the current status of your asset model, use the [DescribeAssetModel](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_DescribeAssetModel.html) operation by specifying the `assetModelId`\. After the asset model status is `ACTIVE`, you can use the asset model to create assets\. For more information, see [Asset and model states](asset-and-model-states.md)\.

## Example asset models<a name="asset-model-examples"></a>

This section contains example asset models definitions that you can use to create asset models with the AWS CLI and AWS IoT SiteWise SDKs\. These asset models represent a wind turbine and a wind farm\. Wind turbine assets ingest raw sensor data and calculate values such as power and average wind speed\. Wind farm assets calculate values such as total power for all wind turbines in the wind farm\.

**Topics**
+ [Wind turbine asset model](#example-wind-turbine)
+ [Wind farm asset model](#example-wind-farm)

### Wind turbine asset model<a name="example-wind-turbine"></a>

The following asset model represents a turbine in a wind farm\. The wind turbine ingests sensor data to calculate values such as power and average wind speed\.

**Note**  
This example model resembles the wind turbine model from the AWS IoT SiteWise demo\. For more information, see [Using the AWS IoT SiteWise demo](getting-started-demo.md)\.

```
{
  "assetModelName": "Wind Turbine Asset Model",
  "assetModelDescription": "Represents a turbine in a wind farm.",
  "assetModelProperties": [
    {
      "name": "Location",
      "dataType": "STRING",
      "type": {
        "attribute": {
          "defaultValue": "Renton"
        }
      }
    },
    {
      "name": "Make",
      "dataType": "STRING",
      "type": {
        "attribute": {
          "defaultValue": "Amazon"
        }
      }
    },
    {
      "name": "Model",
      "dataType": "INTEGER",
      "type": {
        "attribute": {
          "defaultValue": "500"
        }
      }
    },
    {
      "name": "Torque (KiloNewton Meter)",
      "dataType": "DOUBLE",
      "unit": "kNm",
      "type": {
        "measurement": {}
      }
    },
    {
      "name": "Wind Direction",
      "dataType": "DOUBLE",
      "unit": "Degrees",
      "type": {
        "measurement": {}
      }
    },
    {
      "name": "RotationsPerMinute",
      "dataType": "DOUBLE",
      "unit": "RPM",
      "type": {
        "measurement": {}
      }
    },
    {
      "name": "Wind Speed",
      "dataType": "DOUBLE",
      "unit": "m/s",
      "type": {
        "measurement": {}
      }
    },
    {
      "name": "RotationsPerSecond",
      "dataType": "DOUBLE",
      "unit": "RPS",
      "type": {
        "transform": {
          "expression": "rpm / 60",
          "variables": [
            {
              "name": "rpm",
              "value": {
                "propertyId": "RotationsPerMinute"
              }
            }
          ]
        }
      }
    },
    {
      "name": "Overdrive State",
      "dataType": "DOUBLE",
      "type": {
        "transform": {
          "expression": "gte(torque, 3)",
          "variables": [
            {
              "name": "torque",
              "value": {
                "propertyId": "Torque (KiloNewton Meter)"
              }
            }
          ]
        }
      }
    },
    {
      "name": "Average Power",
      "dataType": "DOUBLE",
      "unit": "Watts",
      "type": {
        "metric": {
          "expression": "avg(torque) * avg(rps) * 2 * 3.14",
          "variables": [
            {
              "name": "torque",
              "value": {
                "propertyId": "Torque (Newton Meter)"
              }
            },
            {
              "name": "rps",
              "value": {
                "propertyId": "RotationsPerSecond"
              }
            }
          ],
          "window": {
            "tumbling": {
              "interval": "5m"
            }
          }
        }
      }
    },
    {
      "name": "Average Wind Speed",
      "dataType": "DOUBLE",
      "unit": "m/s",
      "type": {
        "metric": {
          "expression": "avg(windspeed)",
          "variables": [
            {
              "name": "windspeed",
              "value": {
                "propertyId": "Wind Speed"
              }
            }
          ],
          "window": {
            "tumbling": {
              "interval": "5m"
            }
          }
        }
      }
    },
    {
      "name": "Torque (Newton Meter)",
      "dataType": "DOUBLE",
      "unit": "Nm",
      "type": {
        "transform": {
          "expression": "knm * 1000",
          "variables": [
            {
              "name": "knm",
              "value": {
                "propertyId": "Torque (KiloNewton Meter)"
              }
            }
          ]
        }
      }
    },
    {
      "name": "Overdrive State Time",
      "dataType": "DOUBLE",
      "unit": "Seconds",
      "type": {
        "metric": {
          "expression": "statetime(overdrive_state)",
          "variables": [
            {
              "name": "overdrive_state",
              "value": {
                "propertyId": "Overdrive State"
              }
            }
          ],
          "window": {
            "tumbling": {
              "interval": "5m"
            }
          }
        }
      }
    }
  ],
  "assetModelHierarchies": []
}
```

### Wind farm asset model<a name="example-wind-farm"></a>

The following asset model represents a wind farm that comprises multiple wind turbines\. This asset model defines a [hierarchy](asset-hierarchies.md) to the wind turbine model\. This enables the wind farm to calculate values \(such as average power\) from data for all wind turbines in the wind farm\.

**Note**  
This example model resembles the wind farm model from the AWS IoT SiteWise demo\. For more information, see [Using the AWS IoT SiteWise demo](getting-started-demo.md)\.

This asset model depends on the [Wind turbine asset model](#example-wind-turbine)\. Replace the `propertyId` and `childAssetModelId` values with those from an existing wind turbine asset model\.

```
{
  "assetModelName": "Wind Farm Asset Model",
  "assetModelDescription": "Represents a wind farm.",
  "assetModelProperties": [
    {
      "name": "Code",
      "dataType": "INTEGER",
      "type": {
        "attribute": {
          "defaultValue": "300"
        }
      }
    },
    {
      "name": "Location",
      "dataType": "STRING",
      "type": {
        "attribute": {
          "defaultValue": "Renton"
        }
      }
    },
    {
      "name": "Reliability Manager",
      "dataType": "STRING",
      "type": {
        "attribute": {
          "defaultValue": "Mary Major"
        }
      }
    },
    {
      "name": "Total Overdrive State Time",
      "dataType": "DOUBLE",
      "unit": "seconds",
      "type": {
        "metric": {
          "expression": "sum(overdrive_state_time)",
          "variables": [
            {
              "name": "overdrive_state_time",
              "value": {
                "propertyId": "ID of Average Power property in Wind Turbine Asset Model",
                "hierarchyId": "Turbine Asset Model"
              }
            }
          ],
          "window": {
            "tumbling": {
              "interval": "5m"
            }
          }
        }
      }
    },
    {
      "name": "Total Average Power",
      "dataType": "DOUBLE",
      "unit": "Watts",
      "type": {
        "metric": {
          "expression": "sum(turbine_avg_power)",
          "variables": [
            {
              "name": "turbine_avg_power",
              "value": {
                "propertyId": "ID of Overdrive State Time property in Wind Turbine Asset Model",
                "hierarchyId": "Turbine Asset Model"
              }
            }
          ],
          "window": {
            "tumbling": {
              "interval": "5m"
            }
          }
        }
      }
    }
  ],
  "assetModelHierarchies": [
    {
      "name": "Turbine Asset Model",
      "childAssetModelId": "ID of Wind Turbine Asset Model"
    }
  ]
}
```