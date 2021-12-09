--------

--------

# Aukru HCSR501 Motion Sensor<a name="iot-tg-examples-motionsensor"></a>

The following GraphQL shows the device definition for the [Aukru HC\-SR501 motion sensor](https://www.amazon.com/Aukru-Pyroelectricity-Raspberry-Microcontrollers-Electronic/dp/B019SX734A) that is available in the AWS IoT Things Graph console\. This device is used in [Creating a Flow with Devices](iot-tg-gs-thing-sample.html) and in [Creating a Flow with Devices and a Service](iot-tg-gs-thingdev-sample.html)\.

```
# Motion sensor state.
type MotionSensorState @stateType(id: "urn:tdm:aws/examples:State:MotionSensorState") {
        isMotionDetected: Boolean @property(id: "urn:tdm:aws:property:Boolean")
}

# Property representing the motion sensor state.
type MotionSensorStateProperty @propertyType(id: "urn:tdm:aws/examples:property:MotionSensorStateProperty",
            instanceOf: "urn:tdm:aws/examples:State:MotionSensorState",
description: "Property representing the motion sensor state") {ignore:void}

# Event emitted by the motion sensor.
type MotionSensorEvent @eventType(id: "urn:tdm:aws/examples:event:MotionSensorEvent",
payload: "urn:tdm:aws/examples:property:MotionSensorStateProperty") {ignore:void}

# Motion sensor capability.
type MotionSensorCapability @capabilityType(id: "urn:tdm:aws/examples:capability:MotionSensorCapability") {
        STATE: MotionSensorState @state(id: "urn:tdm:aws/examples:State:MotionSensorState")
        StateChanged: MotionSensorEvent @event(id: "urn:tdm:aws/examples:event:MotionSensorEvent")
}

# Motion sensor device model.
type MotionSensor @deviceModel(id: "urn:tdm:aws/examples:deviceModel:MotionSensor",
capability: "urn:tdm:aws/examples:capability:MotionSensorCapability") {ignore:void}

# Device definition for the HC-SR501 passive infrared sensor.
# In our implementation, this device uses a Java driver to connect to AWS IoT Greengrass.
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