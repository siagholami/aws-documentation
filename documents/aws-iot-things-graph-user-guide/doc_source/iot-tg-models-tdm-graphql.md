--------

--------

# AWS IoT Things Graph Data Model and GraphQL<a name="iot-tg-models-tdm-graphql"></a>

The AWS IoT Things Graph Data Model \(TDM\) uses [GraphQL](https://graphql.org/) syntax to describe the structure and logic of constructs and concepts that are specific to the IoT domain\. In particular, it uses two specific GraphQL concepts—types and queries—in combination with GraphQL directives to represent constructs in the IoT domain\. 

TDM doesn't use other GraphQL concepts, such as mutations and subscriptions, and it doesn't interact with a GraphQL server or runtime\. Although it uses GraphQL in a way that is different from its original purposes, TDM is fully compatible with GraphQL\. It extends GraphQL in a way that is analogous to the way in which the C\+\+ programming language extends C\.

Instead of querying data from a GraphQL server, TDM enables you to create models of IoT devices and stateful web applications, and define how they interact within an IoT system\.

For more information about GraphQL and how to use it more generically, see the [GraphQL documentation](https://graphql.org/learn/)\.

The following sections describe how specific GraphQL concepts are implemented in TDM, and how the TDM constructs fit together at the highest level\.

## Type<a name="iot-tg-models-tdm-graphql-type"></a>

TDM uses GraphQL types to describe IoT concepts that can be represented as data structures without requiring complex payloads or logic\. Types in TDM are the basic building blocks of an IoT system\. The TDM constructs that are described as types are [Properties](iot-tg-models-tdm-propertytype.html), [States](iot-tg-models-tdm-iot-state.html), [Events](iot-tg-models-tdm-iot-event.html), [Actions](iot-tg-models-tdm-iot-action.html), [Capabilities](iot-tg-models-tdm-iot-capability.html), and [Systems](iot-tg-models-tdm-iot-system.html)\. 

The following example uses a GraphQL type to create a property named `imageUri`\. The example demonstrates additional TDM concepts that are discussed in later sections\. This property is a relatively simple structure with two arguments\. It also contains no payload\.

**Note**  
TDM keywords and variables are case insensitive\.

```
type imageUri @propertyType(id: "urn:tdm:aws:property:Uri", dataType: STRING){ignore:void}
```

The `@propertyType` directive \(discussed in [Using Directives](#iot-tg-models-tdm-graphql-directive)\) specifies this as a TDM [iot-tg-models-tdm-propertytype.html](iot-tg-models-tdm-propertytype.html)\. The first argument assigns a unique identifier according to the [TDM URN scheme](iot-tg-models-tdm-urnscheme.html)\. The second argument specifies the data type of this property as a string\.

The `ignore:void` name\-value pair between the braces indicates that this type contains no payload\. GraphQL syntax requires a trailing brace block with one or more field definitions\. This name\-value pair works around that requirement in cases where no payload is required\.

## Query<a name="iot-tg-models-tdm-graphql-query"></a>

TDM uses GraphQL queries to describe IoT concepts that are represented by logic and/or complex data structures that can't be described by the syntax of GraphQL types\. TDM queries contain structured data with logic that must be executed when IoT devices and services are interacting with each other\. The TDM constructs that are described as queries are [Mappings](iot-tg-models-tdm-iot-mapping.html), [Devices](iot-tg-models-tdm-iot-device.html), [Services](iot-tg-models-tdm-iot-service.html), and [Workflows](iot-tg-models-tdm-iot-workflow.html)\.

All of these constructs represent dynamic IoT interactions or direct participants in these interactions\. Mappings translate data received from one device into standards and formats that other devices can understand\. Workflows describe how devices in an IoT system interact in real time\. Triggers start workflows, and devices interact with each other within workflows\. Additionally, all of these constructs require relatively complex syntax to describe them\. 

The following example describes a device named `myMotionSensor`\. This device inherits from the `MotionSensor` device model and implements a capability associated with that device model\. The capability contains a state and an event\. The state, in turn, contains properties\. 

The specific TDM concepts demonstrated in this example are discussed in sections that follow in this guide\. The example demonstrates the general shape of a TDM query and the complexity that it supports\.

```
query myMotionSensor @device(id: "urn:tdm:aws:device:MotionSensor",
                               deviceModel: "urn:tdm:aws:deviceModel:MotionSensor") {
   MQTT {
       MotionSensorCap(id: "urn:tdm:aws:capability:MotionSensorCap") {
           state {
               isMotionDetected(name:"lastMotionDetected", property:"urn:tdm:aws:property:MotionDetected")
           }
           event(name: "motionDetected") {
               Subscribe(topic: "motionsensor/motion") {
                   responsepayload(property: "urn:tdm:{{NAMESPACE}}:Property:MotionDetected")
               }
           }
       }
   }
}
```

The `@device` directive specifies this as a TDM [Device](iot-tg-models-tdm-iot-device.html)\. As in the property definition, the first argument assigns a unique identifier according to the [TDM URN scheme](iot-tg-models-tdm-urnscheme.html)\. The second argument contains another TDM URN that specifies the device model from which this device inherits its capability\. The definition then implements the device model's capability by including a [State](iot-tg-models-tdm-iot-state.html) and an [Event](iot-tg-models-tdm-iot-event.html)\. A capability can also include an [Action](iot-tg-models-tdm-iot-action.html)\. If the device model's capability includes an `Action`, the device must implement it as well\. 

## Using Directives<a name="iot-tg-models-tdm-graphql-directive"></a>

TDM uses GraphQL directives extensively for implementing concepts that are specific to the IoT domain\. Directives can be attached to any field to insert domain\-specific information\. The preceding examples demonstrate how directives are used to specify a specific TDM construct \(`the propertyType` and `device` directives\)\. In TDM, directives play the role of statements\. When you see a directive in a type or query definition, it means "create an instance of this type"\.

TDM supports two kinds of directives: definition and usage\. You use definition directives to create instances of a type of construct\. For example, the `@propertyType` directive tells AWS IoT Things Graph to create a property\. The following example creates a property named `MotionDetected` by using the `@propertyType` definition directive\.

```
type MotionDetected @propertyType(id: "urn:tdm:aws:property:MotionDetected", dataType: Boolean){ignore:void}
```

The `@propertyType` directive tells AWS IoT Things Graph to create a property\. The first argument contains a TDM URN that uniquely identifies the new property\. This URN must be in the `property` branch of the [TDM URN scheme](iot-tg-models-tdm-urnscheme.html)\. The URN scheme and the directive must match\. The second argument specifies the property's data type, which in this case is the built\-in primitive `Boolean`\. The `ignore:void` name\-value pair between the braces specifies an empty payload\.

A usage directive is a specific instance of a type\. For example, after you create the `MotionDetected` property type, you can use it to construct a `State` by using the `@property` usage directive, as in the following example\.

```
type MotionSensorState @stateType(id: "urn:tdm:aws:state:MotionSensorState") {
  isMotionDetected : MotionDetected @property(id:"urn:tdm:aws:property:MotionDetected")  
}
```

The `@stateType` directive tells AWS IoT Things Graph to create a state definition\. The `urn:tdm:aws:property:MotionSensorState` argument uniquely identifies the new state and types it as a state by placing it under the `state` branch of the [TDM URN scheme](iot-tg-models-tdm-urnscheme.html)\. The URN scheme and the directive must match\. The first piece of the payload between the braces specifies the name of the state as it will be used when a device implements the state\. The pieces of the payload that follow the first colon specify the property that the state contains by name, by usage directive, and by URN\. The `@property` directive in this example means "use the property specified by this URN"\.

Notice that the `isMotionDetected` state name appears as part of the state implementation in the preceding device definition example\.

```
state {
        isMotionDetected(name:"lastMotionDetected", property:"urn:tdm:aws:property:MotionDetected")
      }
```

Directives and URNs provide a way of implementing type safety in GraphQL structures\. When you create a TDM construct by constructing a GraphQL `type` or `query`, you must create a unique URN that places the construct inside a conceptual hierarchy that matches the type specified by the directive\. When you use an instance of the type, you must supply a URN that already exists and that sits at a location in the conceptual hierarchy that matches the type specified by the directive\. 

The following table contains the usage and definition directives in TDM\.


| Definition | Usage | 
| --- | --- | 
| @actionType | @action | 
| @capabilityType | @capability | 
| @deployment |  | 
| @deviceModel | @device | 
| @enumType | @enum | 
| @enumValue |  | 
| @eventType | @event | 
| @mapping | 
| @propertyType | @property | 
|  | @service | 
| @stateType | @state | 
| @systemType | @system | 
|  | @thing | 
| @workflowType | @workflow | 

The sections following this topic describe how to use each directive to construct and/or use the specific TDM constructs\.

## Creating a Device with GraphQL<a name="iot-tg-models-tdm-graphql-devicemodel"></a>

To construct a complete device, you need to use the following constructs and associated directives\.
+ Property \(`type @propertyType`\): The attributes of a device, such as the color and brightness of a light bulb and the click time of a camera\.
+ Device Model \(`type @deviceModel`\): An abstraction of a device that contains a capability\. For example, you use a device model definition to create abstract definitions of things like light bulbs and cameras\.
+ Device \(`query @device`\): A device type that inherits from the device model and implements the device model's capability\. Cameras and light bulb models produced by specific manufacturers would be defined as devices\.
+ Capability \(`type @capabilityType`\): The actions, events, and state associated with the device\. A light bulb's capability would include its brightness \(part of its state\), the action of changing its brightness, and a power on/off event\. A camera's capability would include its burst delay interval \(part of its state\), the action of capturing an image, and the camera click event\.
+ Action \(`type @actionType`\): The device's ability to perform a function\. A light bulb can change its brightness, and a camera can capture an image\. Both are examples of actions\.
+ Event \(`type @eventType`\): The device's ability to communicate externally with other devices and services\. A light bulb can send a notification that it has been turned on or off, and a camera can send a notification that it has been clicked\. Both are examples of events\.
+ State \(`type @stateType`\): The properties that describe the device at a specific point in time\. A light bulb has properties like brightness and color\. A camera has properties like image URI \(for a specific image that it has captured\) and click time \(for the time when an image was captured\)\. A state is a collection of these properties\.
+ Mapping \(`query @mapping`\): Symmetrical, forward, and/or reverse transformations of properties and measurements that enable different device types to understand each other\. A mapping can transform an enum\-based brightness rating into a rating based on a numerical range\. It can also convert the burst delay property of a camera from milliseconds into seconds\. 

The following diagram shows how all of these constructs fit together in a device model\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TdmDeviceModel.png)