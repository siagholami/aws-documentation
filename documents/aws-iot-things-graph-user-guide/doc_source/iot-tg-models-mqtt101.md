--------

--------

# MQTT Device Modeling 101<a name="iot-tg-models-mqtt101"></a>

This topic describes what you need to think about and plan for when you're creating models for your MQTT devices\. 

We'll use a motion sensor and a camera as reference points, but you can apply the process that this topic describes to any device that uses the MQTT communication protocol\. The devices that we model here are the [Aukru HC\-SR501 motion sensor](https://www.amazon.com/Aukru-Pyroelectricity-Raspberry-Microcontrollers-Electronic/dp/B019SX734A) and the [Raspberry Pi Camera](https://www.amazon.com/Raspberry-Pi-Camera-Module-Megapixel/dp/B01ER2SKFS)\.

The [Aukru\-HC\-SR501\.zip](samples/Aukru-HC-SR501.zip) and [RaspberryPiCamera\.zip](samples/RaspberryPiCamera.zip) files contain all of the GraphQL code discussed in this topic\.

When you define a device, you need to create two pieces\. The first piece is the abstract device model\. This piece generically defines what a type of device does\. The second piece is the device definition, which implements the model\. The device definition specifies the communication protocol used by the device\. Devices that use different protocols can inherit from the same device model\.

Before you define your device, look in the [AWS IoT Things Graph console](https://console.aws.amazon.com/thingsgraph/home) to determine whether an abstract model for the type of device you're defining already exists\. If so, you can skip to the task of defining your device\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGDeviceModeling.png)

If you can't find an existing abstract device model for your device in the console, you have to define one\. For this exercise, assume that no model for a motion sensor device currently exists\.

## Creating Your Abstract Device Model<a name="iot-tg-models-mqtt101-abstract"></a>

The first piece of your device definition is its abstract representation in a device model\. The device model contains the capability\. You'll define the capability later, but now you can assign its [AWS IoT Things Graph Data Model \(TDM\) URN](iot-tg-models-tdm-urnscheme.html) in the device model\. The following GraphQL contains the motion sensor and camera device models\. \(The *REGION* and *ACCOUNT ID* values are specific to your account\.\)

**Motion Sensor**

```
type MotionSensor @deviceModel(id: "urn:tdm:aws/examples:deviceModel:MotionSensor",
  capability: "urn:tdm:aws/examples:capability:MotionSensorCapability") {
  ignore:void
  }
```

**Camera**

```
type Camera @deviceModel(id:"urn:tdm:aws/examples:deviceModel:Camera",
  capability: "urn:tdm:aws/examples:capability:CameraCapability"){
  ignore:void
}
```

## Creating Your Device's Capability \(Motion Sensor\)<a name="iot-tg-models-mqtt101-mscapability"></a>

The motion sensor device capability represents what happens to the sensor when an event occurs and how the sensor responds to this event\. 

The motion sensor device capability requires the following two TDM entities:
+ A `State` that represents whether the sensor has detected motion
+ An `Event` that represents the notification that the motion sensor sends when it detects motion

The `Event` also requires a complex `Property` that represents an instance of the device's `State`\. This `Property` is the payload that the device publishes to an MQTT topic whenever it detects motion\.

Start defining your device's capability by thinking about the functions that it serves\. A motion sensor device detects when a body or part of a body moves within the sensor's range\. When a motion sensor detects a body in motion, it generates a notification that this event has occurred\. Therefore, its capability definition requires only a single event\.

A motion detector also has two states: no motion detected and motion detected\. The motion detected event changes the state, so you need to include the state and the event in your capability\. You can represent this state as a Boolean value\. The following GraphQL defines this state\.

```
type MotionSensorState @stateType(id: "urn:tdm:aws/examples:State:MotionSensorState") {
        isMotionDetected: Boolean @property(id: "urn:tdm:aws:property:Boolean")
}
```

When it detects motion, the sensor sends a message to an MQTT topic\. This message contains a property that describes the current state of the sensor \(in this case, the state of its `isMotionDetected` property changing from false to true\)\. To make this possible, you need to create a complex property that is an instance of the motion sensor's state\. The following GraphQL defines this property\.

```
 type MotionSensorStateProperty @propertyType(id: "urn:tdm:aws/examples:property:MotionSensorStateProperty",
            instanceOf: "urn:tdm:aws/examples:State:MotionSensorState",
description: "Property representing the motion sensor state") {ignore:void}
```

Use this property as the payload that the motion sensor device sends when the motion detected event triggers a change in its state\. The following GraphQL defines this `Event` and specifies the complex property as the payload that it publishes to an MQTT topic\.

```
type MotionSensorEvent @eventType(id: "urn:tdm:aws/examples:event:MotionSensorEvent",
payload: "urn:tdm:aws/examples:property:MotionSensorStateProperty") {ignore:void}
```

**Note**  
A complex property is any property that contains more than one property or that is an instance of a state\.

You specify the MQTT topic to which the device publishes this payload later when you create your device definition\.

Now you're ready to define the device's capability\. The capability contains both the `MotionSensorState` that you created earlier and an instance of the `MotionSensorEvent` that is named `StateChanged`\. The TDM URN that uniquely identifies this capability matches the one that you used when you created the motion sensor abstract device model\.

```
type MotionSensorCapability @capabilityType(id: "urn:tdm:aws/examples:capability:MotionSensorCapability") {
        STATE: MotionSensorState @state(id: "urn:tdm:aws/examples:State:MotionSensorState")
        StateChanged: MotionSensorEvent @event(id: "urn:tdm:aws/examples:event:MotionSensorEvent")
}
```

You use the `StateChanged` event name when you implement the device's capability in the device definition\.

## Creating Your Device's Capability \(Camera\)<a name="iot-tg-models-mqtt101-camcapability"></a>

The camera device capability represents the action of a camera capturing an image\. The camera device capability requires the following two TDM entities:
+ A `State` that represents the last image taken by the camera
+ An `Action` that represents the notification that the camera sends when it captures an image

The `Action` also requires a complex `Property` that represents an instance of the device's `State`\. This `Property` is the payload that the device publishes to an MQTT topic whenever it captures an image\.

A camera captures and stores images\. We'll store the last image that the camera has captured in its state\. The following GraphQL defines this state\.

```
 type CameraState @stateType(id: "urn:tdm:aws/examples:state:CameraState") {
            lastClickedImage : Uri @property(id: "urn:tdm:aws:property:String")
}
```

After it captures an image, the camera sends a message to an MQTT topic\. This message contains a property that describes the current state of the camera \(in this case, the location of the last image it has captured\)\. Just as you did with the motion sensor, you need to create a complex property that is an instance of the camera's state\. The following GraphQL defines this property\.

```
type CameraStateProperty @propertyType(id: "urn:tdm:aws/examples:property:CameraStateProperty",
instanceOf: "urn:tdm:aws/examples:state:CameraState") {ignore:void}
```

Use this property as the payload that the camera sends when it captures an image and its state changes\. The following GraphQL defines this `Action` and specifies the complex property as the value that it publishes to an MQTT topic\.

```
type Capture @actionType(id:"urn:tdm:aws/examples:action:Capture") {
        return : CameraStateProperty @property(id: "urn:tdm:aws/examples:property:CameraStateProperty")
}
```

You specify the MQTT topic to which the device publishes this payload later when you create your device definition\.

Now you're ready to define the device's capability\. The capability contains both the `CameraState` that you created earlier and an instance of the `Capture` action, which is conveniently named `capture`\. The TDM URN that uniquely identifies this capability matches the one that you used when you created the camera abstract device model\.

```
type CameraCapability @capabilityType(id: "urn:tdm:aws/examples:capability:CameraCapability") {
        STATE: CameraState @state(id: "urn:tdm:aws/examples:state:CameraState")
        capture: Capture @action(id: "urn:tdm:aws/examples:action:Capture")
}
```

You use the `capture` event name when you implement the device's capability in the device definition\.

## Creating Your Device Definitions<a name="iot-tg-models-mqtt101-definition"></a>

Now that you have an abstract device model that contains a fully defined capability, you can write the definition for your specific device\. The abstract device model and capability specify what a motion sensor does at a generic level\. The device definition specifies how the specific device you want to use in a flow deployment interacts with AWS IoT Things Graph\.

Your device definition contains an `MQTT` block\. This block implements the capability that you defined earlier\. It also specifies the MQTT topic to which the device publishes its payload \(the complex property that specifies that the device's state has changed\)\. The following GraphQL contains the motion sensor device definition\.

```
query HCSR501MotionSensor @device(id: "urn:tdm:aws/examples:device:HCSR501MotionSensor",
            deviceModel: "urn:tdm:aws/examples:deviceModel:MotionSensor") {
        MQTT {
            MotionSensorCapability(id: "urn:tdm:aws/examples:capability:MotionSensorCapability") {
                state {
                    isMotionDetected(name:"isMotionDetected", property:"urn:tdm:aws:property:Boolean")
                }
                Event(name: "StateChanged") {
                    Subscribe(topic: "$macro(${systemRuntime.deviceId}/motion)") {
                            responsepayload(property: "urn:tdm:aws/examples:property:MotionSensorStateProperty")
                    }
                }
            }
        }
}
```

Key features:
+ The two parameters included after the `@device` declaration are the IDs of the device and the abstract device model from which the device inherits\.
+ The MQTT block contains the state that you created earlier, and the Boolean property that you specified in the state definition\.
+ The MQTT block also contains the `Event` block\. This block takes a `name` argument whose value matches the event name \(`StateChanged`\) that you specified in the capability definition\.
+ An event uses a `Subscribe` block to specify where the event notification will be published\. The `Subscribe` block takes a `topic` argument that specifies the MQTT topic to which the device publishes its notification\. In this case, the definition uses the `macro` keyword to include the value of the system variable that stores the name of the thing \(in the AWS IoT registry\) that you've associated with the device in a specific flow deployment\. This is a good way to ensure that things in multiple flow deployments are publishing to unique MQTT topics\.
+ The `responsepayload` block takes a `property` argument that specifies the payload that the device sends to the MQTT topic\. In this case, the device sends the value of the complex property that you created earlier\.

The following GraphQL contains the camera device definition\.

```
query RaspberryPiCamera @device(id: "urn:tdm:aws/examples:device:RaspberryPiCamera",
            deviceModel: "urn:tdm:aws/examples:deviceModel:Camera") {
        MQTT {
            CameraCapability(id: "urn:tdm:aws/examples:capability:CameraCapability") {
                state {
                    lastClickedImage(name: "lastImage", property: "urn:tdm:aws:property:String")
                }
                Action(name: "capture") {
                    Publish {
                        Request(topic: "$macro(${systemRuntime.deviceId}/capture)") {
                            params
                        }
                        Response(topic: "$macro(${systemRuntime.deviceId}/capture/finished)") {
                            responsePayload(property: "urn:tdm:aws/examples:property:CameraStateProperty")
                        }
                    }
                }
            }
        }
}
```

Key features:
+ The two parameters included after the `@device` declaration are the IDs of the device and the abstract device model from which the device inherits\.
+ The MQTT block contains the state that you created earlier, and the `String` property that you specified in the state definition\.
+ The MQTT block also contains the `Action` block\. This block takes a `name` argument whose value matches the event name \(`StateChanged`\) that you specified in the capability definition\.
+ An action uses a `Publish` block to specify where the action publishes its output\. The `Publish` block contains `Request` and `Response` blocks\. The `Request` block specifies the MQTT topic that sets the action in motion when notifications are published to it\. You use the `Response` block to send a notification that indicates that the action is complete\. This notification contains the location of the last image that the camera has captured\.
+ The `responsepayload` block inside the `Response` block takes a `property` argument that specifies the payload that the device sends to the MQTT topic\. In this case, the device sends the value of the complex property that you created earlier\.

The [Aukru\-HC\-SR501\.zip](samples/Aukru-HC-SR501.zip) and [RaspberryPiCamera\.zip](samples/RaspberryPiCamera.zip) files contain all of the GraphQL code discussed in this topic\. Download them to work with the code, and then upload any of your changes to AWS IoT Things Graph yourself\.