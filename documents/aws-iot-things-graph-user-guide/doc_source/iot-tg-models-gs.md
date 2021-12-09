--------

--------

# Creating and Uploading Entities<a name="iot-tg-models-gs"></a>

Creating entities for a flow involves three main tasks:
+ Defining the entities \(including the devices\) in the flow\.
+ Uploading the entities to your private namespace\.
+ Associating things in your registry with the devices that you've defined and uploaded\.

This topic describes how to complete these tasks by using either the AWS CLI or the AWS IoT Things Graph console\.

## Step 1\. Define the Entities<a name="iot-tg-models-gs-step1"></a>

The following GraphQL contains a complete definition of entities that compose the flow described in [Working with Flows](iot-tg-workflows.html)\. \(For an overview of how GraphQL is used in the Things Graph Data Model \(TDM\), see [AWS IoT Things Graph Data Model and GraphQL](iot-tg-models-tdm-graphql.html)\.

These definitions create a barcode reader and another device that does something with the reader output, with all of the TDM entities that compose the devices\.

**Note**  
Before uploading your models, you must wrap all of your definitions between opening and closing curly braces, as in the following example\.

```
{
  # Basic type definitions
  type
  String @propertyType(id: "urn:tdm:REGION/ACCOUNT ID/default:property:String", dataType: String) {
    IGNORE: VOID
  }

  type
  Boolean @propertyType(id: "urn:tdm:REGION/ACCOUNT ID/default:property:Boolean", dataType: Boolean) {
    IGNORE: VOID
  }

  # Complex Type (State) definitions
  type
  BarcodeType @stateType(id: "urn:tdm:REGION/ACCOUNT ID/default:state:BarcodeType") {
    id: Property @property(id: "urn:tdm:REGION/ACCOUNT ID/default:property:String")
  }

  type
  Barcode @propertyType(id: "urn:tdm:REGION/ACCOUNT ID/default:property:Barcode", instanceOf: "urn:tdm:REGION/ACCOUNT ID/default:state:BarcodeType") {
    IGNORE: VOID
  }

  # Action definitions
  type
  DeviceA_ReadBarcode @actionType(id: "urn:tdm:REGION/ACCOUNT ID/default:action:DeviceA_ReadBarcode") {
    return: Property @property(id: "urn:tdm:REGION/ACCOUNT ID/default:property:Barcode")
  }

  type
  DeviceB_Action @actionType(id: "urn:tdm:REGION/ACCOUNT ID/default:action:DeviceB_Action") {
    input: Property @property(id: "urn:tdm:REGION/ACCOUNT ID/default:property:Barcode")
  }

  # Capability definitions
  type
  DeviceA @capabilityType(id: "urn:tdm:REGION/ACCOUNT ID/default:capability:DeviceA") {
    readBarcode: Action @action(id: "urn:tdm:REGION/ACCOUNT ID/default:action:DeviceA_ReadBarcode")
  }

  type
  DeviceB @capabilityType(id: "urn:tdm:REGION/ACCOUNT ID/default:capability:DeviceB") {
    doSomething: Action @action(id: "urn:tdm:REGION/ACCOUNT ID/default:action:DeviceB_Action")
  }

  # Device model definitions (abstract device)
  type
  DeviceB @deviceModel(id: "urn:tdm:REGION/ACCOUNT ID/default:deviceModel:DeviceB", capability: "urn:tdm:REGION/ACCOUNT ID/default:capability:DeviceB") {
    IGNORE: VOID
  }

  type
  DeviceA @deviceModel(id: "urn:tdm:REGION/ACCOUNT ID/default:deviceModel:DeviceA", capability: "urn:tdm:REGION/ACCOUNT ID/default:capability:DeviceA") {
    IGNORE: VOID
  }

  # Device definitions (physical device)
  query
  DeviceA @device(id: "urn:tdm:REGION/ACCOUNT ID/default:device:DeviceA", deviceModel: "urn:tdm:REGION/ACCOUNT ID/default:deviceModel:DeviceA") {
    MQTT {
      Capability(id: "urn:tdm:REGION/ACCOUNT ID/default:capability:DeviceA") {
        Action(name: "readBarcode") {
          Publish {
            Request(topic: "DeviceA/in") {
              params
            }
            Response(topic: "DeviceA/out") {
              responsePayload(property: "urn:tdm:REGION/ACCOUNT ID/default:property:Barcode")
            }
          }
        }
      }
    }
  }

  query
  DeviceB @device(id: "urn:tdm:REGION/ACCOUNT ID/default:device:DeviceB", deviceModel: "urn:tdm:REGION/ACCOUNT ID/default:deviceModel:DeviceB") {
    MQTT {
      Capability(id: "urn:tdm:REGION/ACCOUNT ID/default:capability:DeviceB") {
        Action(name: "doSomething") {
          params {
            param(name: "input", property: "urn:tdm:REGION/ACCOUNT ID/default:property:Barcode")
          }
          Publish {
            Request(topic: "DeviceB/in") {
              params {
                param(name: "readId", property: "urn:tdm:REGION/ACCOUNT ID/default:property:Barcode", value: "${input.value}")
              }
            }
          }
        }
      }
    }
  }
}
```

These models create the properties, states, actions, and capabilities, and the two devices that contain these other entities\.

## Step 2\. Upload the Entity Definitions<a name="iot-tg-models-gs-step2"></a>

After you have finished writing the entity definitions that compose your flow, you upload the definitions to your private namespace\. You can do this in two ways, by using the `UploadEntityDefinitions` API and the CLI or by using the AWS IoT Things Graph console\. 

### Upload the Entity Definition \(CLI\)<a name="iot-tg-models-gs-cli"></a>

1. **Create the JSON definition document\.** 

   The `UploadEntityDefinitions` API consumes a JSON object with two parameter values: `language` and `text`\. 

   Currently, the only supported value for `language` is GraphQL\. The value of `text` is a set of TDM definitions implemented in GraphQL\. The resulting JSON looks like the following example\.

   ```
   {
       "language": "GRAPHQL",
       "text" : "string containing the GRAPHQL models"
    }
   ```

   You can construct the JSON payload in any way that your development framework and language support\. For convenience, the following example contains a valid JSON object that you can copy into a file if you don't want to create one yourself\.

   ```
   {
       "language": "GRAPHQL",
       "text": "{type String @propertyType(id: 'urn:tdm:REGION/ACCOUNT ID/default:property:String', dataType: String) {IGNORE: VOID} type Boolean @propertyType(id: 'urn:tdm:REGION/ACCOUNT ID/default:property:Boolean', dataType: Boolean) {IGNORE: VOID} type BarcodeType @stateType(id: 'urn:tdm:REGION/ACCOUNT ID/default:state:BarcodeType') {id: Property @property(id: 'urn:tdm:REGION/ACCOUNT ID/default:property:String')} type Barcode @propertyType(id: 'urn:tdm:REGION/ACCOUNT ID/default:property:Barcode', instanceOf: 'urn:tdm:REGION/ACCOUNT ID/default:state:BarcodeType') { IGNORE: VOID} type DeviceA_ReadBarcode @actionType(id: 'urn:tdm:REGION/ACCOUNT ID/default:action:DeviceA_ReadBarcode') {return: Property @property(id: 'urn:tdm:REGION/ACCOUNT ID/default:property:Barcode')} type DeviceB_Action @actionType(id: 'urn:tdm:REGION/ACCOUNT ID/default:action:DeviceB_Action') { input: Property @property(id: 'urn:tdm:REGION/ACCOUNT ID/default:property:Barcode')} type DeviceA @capabilityType(id: 'urn:tdm:REGION/ACCOUNT ID/default:capability:DeviceA') { readBarcode: Action @action(id: 'urn:tdm:REGION/ACCOUNT ID/default:action:DeviceA_ReadBarcode')} type DeviceB @capabilityType(id: 'urn:tdm:REGION/ACCOUNT ID/default:capability:DeviceB') {doSomething: Action @action(id: 'urn:tdm:REGION/ACCOUNT ID/default:action:DeviceB_Action')} type DeviceB @deviceModel(id: 'urn:tdm:REGION/ACCOUNT ID/default:deviceModel:DeviceB', capability: 'urn:tdm:REGION/ACCOUNT ID/default:capability:DeviceB') {IGNORE: VOID} type DeviceA @deviceModel(id: 'urn:tdm:REGION/ACCOUNT ID/default:deviceModel:DeviceA', capability: 'urn:tdm:REGION/ACCOUNT ID/default:capability:DeviceA') {IGNORE: VOID} query DeviceA @device(id: 'urn:tdm:REGION/ACCOUNT ID/default:device:DeviceA', deviceModel: 'urn:tdm:REGION/ACCOUNT ID/default:deviceModel:DeviceA') { MQTT { Capability(id: 'urn:tdm:REGION/ACCOUNT ID/default:capability:DeviceA') { Action(name: 'readBarcode') { Publish {Request(topic: 'DeviceA/in') {params} Response(topic: 'DeviceA/out') {responsePayload(property: 'urn:tdm:REGION/ACCOUNT ID/default:property:Barcode')}}}}}} query DeviceB @device(id: 'urn:tdm:REGION/ACCOUNT ID/default:device:DeviceB', deviceModel: 'urn:tdm:REGION/ACCOUNT ID/default:deviceModel:DeviceB') { MQTT {Capability(id: 'urn:tdm:REGION/ACCOUNT ID/default:capability:DeviceB') {Action(name: 'doSomething') {params {param(name: 'input', property: 'urn:tdm:REGION/ACCOUNT ID/default:property:Barcode')} Publish { Request(topic: 'DeviceB/in') { params {param(name: 'readId', property: 'urn:tdm:REGION/ACCOUNT ID/default:property:Barcode', value: '${input.value}')}}}}}}}}"
   }
   ```

1. **Upload the JSON definition document\.**

   After you construct the JSON payload that contains the GraphQL definitions, upload it to your namespace by using the following CLI command\.

   ```
   aws iotthingsgraph upload-entity-definitions --document file://entity file name                  
   ```

   This command is executed asynchronously\. Before using any of these entities, check whether the execution is complete by using the get\-upload\-status command, as in the following example\.

   ```
   aws iotthingsgraph get-upload-status --upload-id UPLOAD ID
   ```

### Upload the Entity Definition \(AWS IoT Things Graph console\)<a name="iot-tg-models-gs-console"></a>

1. In the [AWS IoT Things Graph console](https://console.aws.amazon.com/thingsgraph/home), select the menu icon at the upper left of the page\. Choose **Models**\.  
![\[Select the Models menu item.\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGSelectModels.png)

1. On the **Models** page, choose **Create model**\.   
![\[Select Create model at the upper right of the page.\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGCreateModel.png)

1. On the **Create device model** page, enter a name for your model\. You can choose **Upload a GraphQL file** or **Code in a GraphQL editor**\. 

   If you choose to upload a GraphQL file, you can use the same JSON definition document that you created in [Upload the Entity Definition \(CLI\)](#iot-tg-models-gs-cli)\. 

   For this example, choose **Code in a GraphQL editor**\. Then choose **Next**\.   
![\[Name the model SampleDevices and choose Code in a GraphQL editor.\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGCreateDeviceModel.png)

1. On the **Provide GraphQL** page, copy the GraphQL for your model into the editor\. Then choose **Import**\. Verify that your new model is included in the list on the **Models** page\.  
![\[Copy the GraphQL for your model into the editor, and then choose Import.\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGProvideGraphQL.png)

## Step 3\. Associate Devices with Things<a name="iot-tg-models-gs-step3"></a>

Now that you've created two devices, you associate them with things in your registry\. \(If you haven't created things for your devices already, see [Register a Device in the Registry](https://docs.aws.amazon.com/iot/latest/developerguide/register-device.html) for instructions on how to create things\.\)

### Associate Devices with Things \(CLI\)<a name="iot-models-gs-assoc-cli"></a>

When you have two configured things to associate with your abstract devices, you can associate them with your devices by using the following CLI command\.

```
aws iotthingsgraph associate-entity-to-thing --thing-name DeviceA --entity-id "urn:tdm:REGION/ACCOUNT_ID/default:device:DeviceA"                    
aws iotthingsgraph associate-entity-to-thing --thing-name DeviceB --entity-id "urn:tdm:REGION/ACCOUNT_ID/default:device:DeviceB"
```

### Associate Devices with Things \(AWS IoT Things Graph console\)<a name="iot-models-gs-assoc-console"></a>

1. On the [AWS IoT Things Graph console](https://console.aws.amazon.com/thingsgraph/home) home page, select the menu icon at the upper left of the page\. Choose **Models**\.   
![\[Select the Things menu item.\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGSelectThings.png)

1. On the **Things** page, select the check box next to the AWS IoT thing from your registry to associate with a device that you created\. Choose **Associate**\.  
![\[Select the Associate button at the uppoer right of the page to associate a thing from your registry with your device.\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGSelectAssociate.png)

1. On the **Select device model** page, choose the device to associate with your thing\. Then choose **Associate**\.  
![\[Choose the device to associate with your thing and then choose Associate.\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGSelectDeviceModel.png)

1. On the **Things** page, reload the page and verify that your device and thing are associated\.  
![\[Verify that the device is associated with the thing.\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGVerifyAssociate.png)

1. Repeat steps 2 and 3 for **ThingB** and any other things you want to associate with devices\.

For more information about creating and managing a flow that contains these entities, see [Creating and Deploying Flows](iot-tg-workflows-gs.html)\.