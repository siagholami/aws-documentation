--------

--------

# Glossary<a name="iot-tg-glossary"></a>

[Action](iot-tg-models-tdm-iot-action.html)  
An abstract representation of a device that performs an instance of its capability, such as a camera capturing an image\.  
*Camera example:* The Camera device model in the AWS IoT Things Graph console has a `capture` action\.

[Capability](iot-tg-models-tdm-iot-capability.html)  
An abstract representation of a specific piece of functionality that a device can perform, such as the ability to capture an image\.  
*Motion sensor example:* The motion sensor device model in the AWS IoT Things Graph console has a `MotionSensorCapability` that contains its `capture` action\.

[Device model](iot-tg-models-tdm-iot-device-model.html)  
An abstract representation of a device as a set of actions, events, and states\. A model separates a device interface from its underlying implementation\. Models are like building blocks that you can snap together and integrate into any number of IoT applications\. IoT applications can interact with the model \(and thereby the underlying device\) by using the device capabilities that it exposes\. AWS IoT Things Graph includes built\-in models\. Users can also create their own with the AWS IoT Things Graph model editor\. Devices inherit from the device model and implement its capability\.  
*Motion sensor example:* You can find the motion sensor device model in the AWS IoT Things Graph console\. The [Aukru HCSR501 Motion Sensor](iot-tg-examples-motionsensor.html) device \(also available in the AWS IoT Things Graph console\) implements the generic motion sensor device model\.

[Device](iot-tg-models-tdm-iot-device.html)  
An implementation \(commonly from a manufacturer\) of a device model\. It inherits from a device model and implements the capability associated with the device model\. A specific camera produced by one manufacturer inherits from a generic camera device model\.  
You associate things in your registry by using devices\.  
*Motion sensor example:* The [Aukru HCSR501 Motion Sensor](iot-tg-examples-motionsensor.html) is an example of a device\. You can find it in the AWS IoT Things Graph console\. This device inherits from the motion sensor device model that is also available in the AWS IoT Things Graph console\.

[Event](iot-tg-models-tdm-iot-event.html)  
An abstract representation of a change in some condition or of an action that was taken on it, such as the click of a camera\.  
*Motion sensor example:* The motion sensor device model in the AWS IoT Things Graph console has a `StateChanged` event that occurs whenever the sensor detects motion\.

[Flow \(or workflow\)](iot-tg-models-tdm-iot-workflow.html)  
A definition of the logical interactions and orders of execution between the devices and services\. Flows consist of [device models](iot-tg-models-tdm-iot-device-model.html) and [services](iot-tg-models-tdm-iot-service.html)\. Flows deﬁne how the devices and services interact after a triggering event occurs\. A flow lists these interactions as a sequence of steps\. Each step contains an action on a device or web service, and the related inputs to and outputs from that action\.  
For more information, see [How a Flow Works](iot-tg-whatis-howitworks.html)\.

[Flow configuration](iot-tg-models-tdm-iot-sdc-deployconfig.html)  
An implementation a [workflow \(flow\)](iot-tg-models-tdm-iot-workflow.html) for a specific location or deployment\. A flow configuration consists of a flow, associated [triggers](iot-tg-models-tdm-iot-trigger.html), and all the corresponding physical things that interact with each other in the flows\.   
For more information, see [How a Flow Configuration Works](iot-tg-whatis-deployments.html)\.

[Mapping](iot-tg-models-tdm-iot-mapping.html)  
An information model that enables AWS IoT Things Graph to convert the output message of one device into the expected format for the next device in the flow\. Mappings bridge differences between the devices and enable them to work together\. Mappings enable you to build IoT applications that use a variety of devices from different manufacturers\.  
AWS IoT Things Graph includes mappings for basic types, such as `Float32ToFloat64` and `JSONToString`\.

[Namespace](iot-tg-whatis-namespace.html)  
The container for entities \(for example, models\), created using the Things Graph Data Modeling \(TDM\) language, that are associated with a specific account\. The namespace is part of the URN for each entity\. When you [upload TDM entities](iot-tg-models-gs.html) for the first time, AWS IoT Things Graph creates a namespace for you\. The namespace consists of your AWS Region, your account ID, and `default`\. The pattern is *REGION*/*ACCOUNT ID*/default\. For example, a TDM instance created in the `us-west-2` Region looks like this: `us-west-2/012345678910/default`\.  
Each user has a unique private namespace that you can synchronize with the public namespace\.  
See also [AWS IoT Things Graph Namespaces](iot-tg-whatis-namespace.html)\.

Node  
A visual representation of a workflow step in the AWS IoT Things Graph workflow designer\.

[Property](iot-tg-models-tdm-propertytype.html)  
The basic building block of a state, which describes the state of a device, such as its color or accuracy\.   
AWS IoT Things Graph provides several built\-in simple properties, such as `Int32`\.

[Service Model](iot-tg-models-tdm-iot-service.html)  
A web service or an AWS Lambda function that you can call from a workflow\. Its role in a workflow is analogous to that of a [device](#device) or [device model](#devicemodel)\.  
The [Rekognition](iot-tg-examples-rekognition.html) service model in the AWS IoT Things Graph console exposes the Amazon Rekognition `DetectFaces` API\.

[State](iot-tg-models-tdm-iot-state.html)  
A set of properties that describe a device or a web service\.  
The motion sensor device model in the AWS IoT Things Graph console has a `MotionSensorState`\. This contains a Boolean property that indicates whether the sensor has detected motion\.

TDM URN  
A URN that provides a hierarchical way of typing devices, properties, and entities\. It contains organizational information \(such as physical location\) about a type, and semantic information \(such as color or the URI for an image\)\.   
The following TDM URN is the ID of the [Aukru HCSR501 Motion Sensor](iot-tg-examples-motionsensor.html) device\.  
`urn:tdm:aws/examples:device:HCSR501MotionSensor`  
For more information, see [TDM URN Scheme](iot-tg-models-tdm-urnscheme.html)\.

Workflow  
See [Flow \(or workflow](#flow)\)