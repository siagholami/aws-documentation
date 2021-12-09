--------

--------

# Creating Systems<a name="iot-tg-sysdeploy-systems"></a>

A [system](https://docs.aws.amazon.com/thingsgraph/latest/ug/iot-tg-models-tdm-iot-system.html) is a collection of devices, services, and a workflow \(flow\) that interact with each other in an IoT system\. A system consists of AWS IoT and AWS IoT Things Graph flows\.

When you create a flow in the [AWS IoT Things Graph console](https://console.aws.amazon.com/thingsgraph/home), the console creates a system for you\. For example, the system in [Creating a Flow with Devices and a Service](https://docs.aws.amazon.com/thingsgraph/latest/ug/iot-tg-gs-thingdev-sample.html) contains `RekognitionFlow`\. The following AWS IoT Things Graph Data Model \(TDM\) code shows the underlying definition of the system created in that example\. Replace the *REGION* and *ACCOUNT ID* placeholders with your AWS Region and account ID\.

```
type RekognitionFlowSystem @systemType(id: "urn:tdm:REGION/ACCOUNT ID/default:System:RekognitionFlowSystem") {
  motionSensor: MotionSensor @thing(id: "urn:tdm:aws/examples:DeviceModel:MotionSensor")
  cameraRkgnExample: CameraRkgnExample @thing(id: "urn:tdm:aws/examples:DeviceModel:CameraRkgnExample")
  screen: Screen @thing(id: "urn:tdm:aws/examples:DeviceModel:Screen")
  RekognitionFlow: RekognitionFlow @workflow(id: "urn:tdm:REGION/ACCOUNT ID/default:Workflow:RekognitionFlow")
}
```

In this system:
+ **`@systemType` declaration** creates a system whose identifier is the [TDM URN](https://docs.aws.amazon.com/thingsgraph/latest/ug/iot-tg-models-tdm-urnscheme.html) inside the parentheses\.
+ **motionSensor: MotionSensor, etc\.** are used to assign the device or device models and the flow to names \(on the left side of each colon\) that the flow configuration uses\. The flow configuration uses the flow name to start the flow\. It uses the device and device model names to assign specific things in your registry to each device or device model\. In the flow configuration, these names must match the names in the system exactly\.
+ **`@thing` declarations** specify the devices or device models in the system\.
+ **`@workflow` declarations** specify the flows in the system\. You don't need to specify services in the system definition\.
+ You can include more than one flow in a system \(as long as you write the TDM yourself\)\. This enables you to deploy more than one flow at a time\.

The following command shows how to create a system by using the AWS CLI\.

```
 aws iotthingsgraph create-system-template --definition language=GRAPHQL,text="TDM System Definition"
```

For more information about creating a system programmatically, see [CreateSystemTemplate](https://docs.aws.amazon.com/thingsgraph/latest/APIReference/API_CreateSystemTemplate.html) in the [AWS IoT Things Graph API Reference](https://docs.aws.amazon.com/thingsgraph/latest/APIReference/)

The following section describes how to create flow configurations\.