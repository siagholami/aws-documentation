--------

--------

# Create and Deploy a Flow \(CLI\)<a name="iot-tg-workflows-cli"></a>

You've created the models that you'll use in your flow\. The remaining AWS IoT Things Graph Data Model \(TDM\) entities to create are the [Workflow](iot-tg-models-tdm-iot-workflow.html), [System](iot-tg-models-tdm-iot-system.html), and [Flow Configuration](iot-tg-models-tdm-iot-sdc-deployconfig.html)\. 

1. **Define the flow\.**

   The following GraphQL contains a definition of a flow that sends a message from a barcode reader to another device\.

   ```
   {
     query
     BarcodeReaderFlow($device1Id: String, $device2Id: String) @workflowType(id: "urn:tdm:REGION/ACCOUNT ID/default:Workflow:BarcodeReaderFlow") {
       variables {
         barcode @property(id: "urn:tdm:REGION/ACCOUNT ID/default:property:Barcode")
       }
       steps {
         step(name: "DeviceA", outEvent: ["step1_done"]) {
           DeviceActivity(deviceModel: "urn:tdm:REGION/ACCOUNT ID/default:deviceModel:DeviceA", deviceId: "${device1Id}", out: "barcode") @device(id: "urn:tdm:REGION/ACCOUNT ID/default:device:DeviceA") {
             readBarcode
           }
         }
         step(name: "DeviceB", inEvent: ["step1_done"]) {
           DeviceActivity(deviceModel: "urn:tdm:REGION/ACCOUNT ID/default:deviceModel:DeviceB", deviceId: "${device2Id}") @device(id: "urn:tdm:REGION/ACCOUNT ID/default:device:DeviceB") {
             doSomething(input: "${barcode}")
           }
         }
       }
     }
   }
   ```

1. **Create the flow\.**

   After you model the flow, you create it by using the `CreateWorkflowTemplate` API\. This API consumes a JSON object that contains two parameter values: `language` and `text`\. 

   Currently, the only supported value for `language` is GraphQL\. The value of `text` is a set of TDM definitions implemented in GraphQL\. 

   The resulting JSON looks like the following example\.

   ```
   {
       "language": "GRAPHQL",
       "text": "{query BarcodeReaderFlow($device1Id: String, $device2Id: String) @workflowType(id: 'urn:tdm:REGION/ACCOUNT ID/default:Workflow:BarcodeReaderFlow') {variables {barcode @property(id: 'urn:tdm:REGION/ACCOUNT ID/default:property:Barcode')} steps {step(name: 'DeviceA', outEvent: ['step1_done']) {DeviceActivity(deviceModel: 'urn:tdm:REGION/ACCOUNT ID/default:deviceModel:DeviceA', deviceId: '${device1Id}', out: 'barcode') {readBarcode}} step(name: 'DeviceB', inEvent: ['step1_done']) {DeviceActivity(deviceModel: 'urn:tdm:REGION/ACCOUNT ID/default:deviceModel:DeviceB', deviceId: '${device2Id}') {doSomething(input: '${barcode}')}}}}}"
   }
   ```

   After you construct the JSON payload that contains the GraphQL definition of the flow, you create the flow in your namespace by using the following CLI command\. 

   ```
    aws iotthingsgraph create-flow-template --definition file://flow file name  
   ```

1. **Define the system\.**

   In this step, you define a system that contains the flow you just created, and the devices that you modeled and associated with two things in your registry \(as described in [Getting Started with Models](iot-tg-models-gs.html)\)\. 

   The following GraphQL contains a system that includes your flow and those two things\. The URNs in the example are the unique identifiers of the device models that are associated with the things you created in [Getting Started with Models](iot-tg-models-gs.html)\.

   ```
   {
     type
     securitySystem @systemType(id: 'urn:tdm:REGION/ACCOUNT ID/default:system:BarcodeReaderFlow') {
       device1: Thing @thing(id: 'urn:tdm:REGION/ACCOUNT ID/default:deviceModel:DeviceA')
       device2: Thing @thing(id: 'urn:tdm:REGION/ACCOUNT ID/default:deviceModel:DeviceB')
       barcodeReaderFlow: Workflow @workflow(id: 'urn:tdm:REGION/ACCOUNT ID/default:Workflow:BarcodeReaderFlow')
     }
   }
   ```

1. **Create the system\.**

   After you define the system, you create it by using the `CreateSystemTemplate` API\. This API consumes a JSON object that contains two parameter values: `language` and `text`\. 

   Currently, the only supported value for `language` is GraphQL\. The value of `text` parameter is a set of TDM definitions implemented in GraphQL\. 

   The resulting JSON looks like the following example\.

   ```
   {
       "language": "GRAPHQL",
       "text": "{type securitySystem @systemType(id: 'urn:tdm:REGION/ACCOUNT ID/default:system:BarcodeReaderFlow') {device1: Thing @thing(id: 'urn:tdm:REGION/ACCOUNT ID/default:deviceModel:DeviceA') device2: Thing @thing(id: 'urn:tdm:REGION/ACCOUNT ID/default:deviceModel:DeviceB') barcodeReaderFlow: Workflow @workflow(id: 'urn:tdm:REGION/ACCOUNT ID/default:Workflow:BarcodeReaderFlow')}}"
   }
   ```

   After you construct the JSON payload that contains the GraphQL definition of the flow, you create the flow in your namespace by using the following CLI command\. 

   ```
    aws iotthingsgraph create-system-template --definition file://system file name
   ```

1. **Define the flow configuration\.**

   Systems are deployed within flow configurations\. 

   The following GraphQL defines a flow configuration for the system that you just created\. It passes a trigger to the flow that starts the flow every 10 seconds\.

   ```
   {
     query
     BarcodeReaderFlow @deployment(id: 'urn:tdm:REGION/ACCOUNT ID/default:deployment:BarcodeReaderFlow', systemId: 'urn:tdm:REGION/ACCOUNT ID/default:system:BarcodeReaderFlow') {
       device1(deviceId: 'DeviceA')
       device2(deviceId: 'DeviceB')
       triggers {
         TenSecondTrigger(description: 'a trigger') {
           condition(expr: 'every 10 seconds')
           action(expr: 'ThingsGraph.startFlow(\"barcodeReaderFlow\", bindings[name == \"device1\"].deviceId, bindings[name == \"device2\"].deviceId)')
         }
       }
     }
   }
   ```

1. **Create the flow configuration\.**

   After you define the flow configuration, you create it by using the `CreateSystemInstance` API\. This API consumes a JSON object that contains two parameter values: `language` and `text`\. 

   Currently the only supported value for `language` is GraphQL\. The value of `text` is a set of TDM definitions implemented in GraphQL\. 

   The resulting JSON looks like the following example\.

   ```
   {
       "language": "GRAPHQL",
       "text": "{ query BarcodeReaderFlow @deployment(id: 'urn:tdm:REGION/ACCOUNT ID/default:deployment:BarcodeReaderFlow', systemId: 'urn:tdm:REGION/ACCOUNT ID/default:system:BarcodeReaderFlow') {device1(deviceId: 'DeviceA') device2(deviceId: 'DeviceB') triggers {TenSecondTrigger(description: 'a trigger') {condition(expr: 'every 10 seconds') action(expr: 'ThingsGraph.startFlow(\"barcodeReaderFlow\", bindings[name == \"device1\"].deviceId, bindings[name == \"device2\"].deviceId)')}}}}"
   }
   ```

   The `CreateSystemInstance` API also requires three additional parameters:   
target  
The target type for your deployment\. For AWS IoT Greengrass deployments, specify `GREENGRASS`\.  
s3BucketName  
The name of the Amazon S3 bucket where AWS IoT Things Graph will deploy the dependency closure of the flow configuration\.  
greengrassGroupName  
The name of the AWS IoT Greengrass group where the flow will run\. AWS IoT Things Graph deploys the AWS Lambda function to this group and configures it to use the flow configuration stored in the specified S3 bucket\. It also adds subscriptions to any MQTT topics specified in your device definitions, and adds the devices in your flow to the group\.

   After you construct the JSON payload that contains the GraphQL definition of the flow configuration, upload it to your namespace by using the following CLI command\. The output of this command includes an ID for your flow configuration\. You use this value when you deploy the flow configuration\.

   ```
   aws iotthingsgraph create-system-instance --definition file://flow configuration file name --target GREENGRASS --greengrass-group-name GREENGRASS GROUP NAME --s-3-bucket-name S3 BUCKET NAME  
   ```

1. **Deploy the flow configuration\.**

   Deploy your flow configuration to the AWS IoT Greengrass group that you specified in its configuration by using the `DeploySystemInstance` API\. This API adds AWS IoT Things Graph, your devices, and your flow to the AWS IoT Greengrass group that you specified when you created the flow configuration\. It also adds the configuration and its dependencies to the S3 bucket that you specified\.

   Deploy your flow by using the following CLI command\.

   ```
   aws iotthingsgraph deploy-system-instance --id SYSTEM DEPLOYMENT CONFIGURATION ID
   ```

   When this flow configuration is deployed, you can check the device logs on your AWS IoT Greengrass core device to verify that the flow is running every 10 seconds\.