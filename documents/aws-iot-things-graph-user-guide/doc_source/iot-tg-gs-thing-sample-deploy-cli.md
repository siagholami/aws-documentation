--------

--------

# Creating a Flow with Devices by Using the AWS CLI<a name="iot-tg-gs-thing-sample-deploy-cli"></a>

This topic contains the AWS CLI commands that create the flow in [Creating a Flow With Devices](iot-tg-gs-thing-sample.html)\. The setup instructions for this example are identical to the ones in that topic\. Before starting with this example, follow all of the instructions in that topic up to [Create and Deploy the Flow](iot-tg-gs-thing-sample.html#iot-tg-gs-thing-sample-deploy), and then return to this topic\.

## Install the CLI<a name="iot-tg-gs-thingdev-sample-deploy-cli-install"></a>

To install the AWS CLI, follow the instructions in [Installing the AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-install.html)\.

## Create the Flow by Using the AWS CLI<a name="iot-tg-gs-thing-sample-deploy-cli-steps"></a>

The following steps describe how to create and deploy the flow by using the AWS CLI\.

1. The following AWS IoT Things Graph Data Model \(TDM\) code contains the definition of the flow used in this example\. 

   Copy this code to a file\. Replace the *REGION* and *ACCOUNT ID* placeholders with your AWS Region and account ID\.

   ```
   {
   query SecurityFlow($camera: string!, $screen: string!) @workflowType(id: \"urn:tdm:REGION/ACCOUNT ID/default:Workflow:SecurityFlow\") {
     variables {
       cameraResult @property(id: \"urn:tdm:aws/examples:property:CameraStateProperty\")
     }
     steps {
       step(name: \"Camera\", outEvent: [\"cameraStepDone\"]) {
         DeviceActivity(deviceModel: \"urn:tdm:aws/examples:deviceModel:Camera\", out: \"cameraResult\", deviceId: \"${camera}\") {
           capture
         }
       }
       step(name: \"Screen\", inEvent: [\"cameraStepDone\"]) {
         DeviceActivity(deviceModel: \"urn:tdm:aws/examples:deviceModel:Screen\", deviceId: \"${screen}\") {
           display(imageUrl: \"${cameraResult.lastClickedImage}\")
         }
       }
     }
   }
   }
   ```

1. Enter the following command to create the flow\. This command assumes that you're working in a Linux or Unix environment\. For other environments, use the equivalent of the `cat` utility\.

   ```
   aws iotthingsgraph create-flow-template --definition language=GRAPHQL,text='"'"$(cat PATH TO TDM FILE)"'"'
   ```

1. The following TDM code contains the definition of the system used in this example\. The console creates this system for you\. 

   Copy this code to a file\. Replace the *REGION* and *ACCOUNT ID* placeholders with your AWS Region and account ID\.

   ```
   {
   type SecurityFlow @systemType(id: \"urn:tdm:REGION/ACCOUNT ID/default:System:SecurityFlow\", description: \"Home Security System\") {
     motionSensor: Device @thing(id: \"urn:tdm:aws/examples:deviceModel:MotionSensor\") 
     camera: Device @thing(id: \"urn:tdm:aws/examples:deviceModel:Camera\")
     screen: Device @thing(id: \"urn:tdm:aws/examples:deviceModel:Screen\")
     SecurityFlow: Flow @workflow(id: \"urn:tdm:REGION/ACCOUNT ID/default:Workflow:SecurityFlow\")
   }
   }
   ```

1. Enter the following command to create the system\.

   ```
   aws iotthingsgraph create-system-template --definition language=GRAPHQL,text='"'"$(cat PATH TO TDM FILE)"'"'
   ```

1. Enter the following commands to associate the things you created in your registry with the device models used in the flow\. 

   Replace the *MotionSensorName*, *CameraName*, and *ScreenName* placeholders with the names of the things you created earlier\.

   ```
   aws iotthingsgraph associate-entity-to-thing --thing-name "MotionSensorName" --entity-id "urn:tdm:aws/examples:Device:HCSR501MotionSensor"
   aws iotthingsgraph associate-entity-to-thing --thing-name "CameraName" --entity-id "urn:tdm:aws/examples:Device:RaspberryPiCamera"
   aws iotthingsgraph associate-entity-to-thing --thing-name "ScreenName" --entity-id "urn:tdm:aws/examples:Device:RaspberryPiScreen"
   ```

1. The following TDM code contains the definition of the flow configuration used in this example\. The TDM definition is inside the `definition` object\. For more information, see [Creating Flow Configurations](iot-tg-sysdeploy-depconfig.html)\.

    Copy this code to a file\. Replace the *REGION* and *ACCOUNT ID* placeholders with your AWS Region and account ID\. Replace the *MotionSensorName*, *ScreenName*, and *CameraName* placeholders with the names of the things you created earlier\.

   ```
   {
   query Room215 @deployment(id: \"urn:tdm:REGION/ACCOUNT ID/default:Deployment:Room215\", systemId: \"urn:tdm:REGION/ACCOUNT ID/default:System:SecurityFlow\") {
       motionSensor(deviceId: \"MotionSensorName\")
       screen(deviceId: \"ScreenName\")
       camera(deviceId: \"CameraName\") 
       triggers {MotionEventTrigger(description: \"a trigger\") {  
       condition(expr: \"devices[name == 'motionSensor'].events[name == 'StateChanged'].lastEvent\") 
       action(expr: \"ThingsGraph.startFlow('SecurityFlow', bindings[name == 'camera'].deviceId, bindings[name == 'screen'].deviceId)\")
       }
      }
     }
     }
   ```

1. Enter the following command to create the flow configuration\. 

   Replace the *GREENGRASS GROUP* and *S3 BUCKET* with the names of your AWS IoT Greengrass group and Amazon S3 bucket\.

   ```
   aws iotthingsgraph create-system-instance --definition language=GRAPHQL,text='"'"$(cat PATH TO TDM FILE)"'"' \
                   --target GREENGRASS --greengrass-group-name GREENGRASS GROUP --s3-bucket-name S3 BUCKET
   ```

   When the operation completes, the AWS CLI returns the following deployment summary as a JSON object\. Use the `id` value in the `summary` block as the TDM URN of the flow configuration\. 

   ```
   {
       "summary": {
           "status": "PENDING_DEPLOYMENT",
           "greengrassGroupName": "ThingsGraphGrnGr",
           "target": "GREENGRASS",
           "arn": "arn:aws:iotthingsgraph:REGION:ACCOUNT ID:default#Deployment#Room215",
           "updatedAt": 1555021747.176,
           "id": "urn:tdm:REGION/ACCOUNT ID/default:Deployment:Room215",
           "createdAt": 1555021747.176
       }
   }
   ```

1. Enter the following command to deploy the flow configuration to your AWS IoT Greengrass group\. Use the TDM URN value returned in the previous step as the value of the `id` parameter\.

   ```
   aws iotthingsgraph deploy-system-instance --id SYSTEM INSTANCE URN
   ```

1. To verify the deployment, follow the steps in either [Run the Flow with Real Devices](iot-tg-gs-thing-sample.md#iot-tg-gs-thing-sample-runreal) or [Run the Flow with Mock Devices](iot-tg-gs-thing-sample.md#iot-tg-gs-thing-sample-runmock)\.

## Delete the Flow and Flow Configuration \(Optional\)<a name="iot-tg-gs-thingdev-sample-cleanup"></a>

For instructions on how to undeploy a flow configuration, and delete the flow configuration and flow that you've created, see [Deleting Flow Configurations](iot-tg-lifecycle.html#iot-tg-lifecycle-deletingflowconfig) and [Deleting Systems, Flows, and Namespaces](iot-tg-lifecycle.html#iot-tg-lifecycle-deletingsysflow) in [Lifecycle Management for AWS IoT Things Graph Entities, Flows, Systems, and Deployments](iot-tg-lifecycle.html)\.