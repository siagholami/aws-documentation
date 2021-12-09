--------

--------

# Raspberry Pi Camera<a name="iot-tg-examples-rpicamera"></a>

The following GraphQL shows the device definition for the [Raspberry Pi Camera](https://www.amazon.com/Raspberry-Pi-Camera-Module-Megapixel/dp/B01ER2SKFS) that is available in the AWS IoT Things Graph console\. This device is used in [Creating a Flow with Devices](iot-tg-gs-thing-sample.html)\. 

```
# Camera state.
type CameraState @stateType(id: "urn:tdm:aws/examples:state:CameraState") {
            lastClickedImage : Uri @property(id: "urn:tdm:aws:property:String")
}

# Property representing the camera state.
type CameraStateProperty @propertyType(id: "urn:tdm:aws/examples:property:CameraStateProperty",
instanceOf: "urn:tdm:aws/examples:state:CameraState") {ignore:void}

# The Capture action takes no arguments and returns the state of the device after completing.
type Capture @actionType(id:"urn:tdm:aws/examples:action:Capture") {
        return : CameraStateProperty @property(id: "urn:tdm:aws/examples:property:CameraStateProperty")
}

# Camera capability.
type CameraCapability @capabilityType(id: "urn:tdm:aws/examples:capability:CameraCapability") {
        STATE: CameraState @state(id: "urn:tdm:aws/examples:state:CameraState")
        capture: Capture @action(id: "urn:tdm:aws/examples:action:Capture")
}

# Camera device model.
type Camera @deviceModel(id:"urn:tdm:aws/examples:deviceModel:Camera",
capability: "urn:tdm:aws/examples:capability:CameraCapability"){ignore:void}

# Device definition for the Raspberry Pi Camera.
# In our implementation, this device uses a Java driver to connect to AWS IoT Greengrass.
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