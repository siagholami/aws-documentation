--------

--------

# Raspberry Pi Screen<a name="iot-tg-examples-rpiscreen"></a>

The following GraphQL shows the device definition for the [Raspberry Pi Screen](https://www.amazon.com/Raspberry-Pi-7-Touchscreen-Display/dp/B0153R2A9I) that is available in the AWS IoT Things Graph console\. This device is used in [Creating a Flow with Devices](iot-tg-gs-thing-sample.html) and in [Creating a Flow with Devices and a Service](iot-tg-gs-thingdev-sample.html)\. 

```
# Screen state.
type ScreenState @stateType(id: "urn:tdm:aws/examples:state:ScreenState") {
        currentDisplayImage : String @property(id: "urn:tdm:aws:property:String")
}

# The Display action takes an image URL as input, returns void, and displays the image.
type Display @actionType(id: "urn:tdm:aws/examples:action:Display") {
        imageUrl : String @property(id: "urn:tdm:aws:property:String")
}

# Screen capability.
type ScreenCapability @capabilityType(id: "urn:tdm:aws/examples:capability:ScreenCapability") {
        STATE: ScreenState @state(id: "urn:tdm:aws/examples:state:ScreenState")
        display: Display @action(id: "urn:tdm:aws/examples:action:Display")
}

# Screen device model.
type Screen @deviceModel(id:"urn:tdm:aws/examples:deviceModel:Screen",
capability: "urn:tdm:aws/examples:capability:ScreenCapability"){ ignore : void}

# Device definition for the Raspberry Pi Screen.
# In our implementation, this device uses a Java driver to connect to AWS IoT Greengrass
query RaspberryPiScreen @device(id: "urn:tdm:aws/examples:device:RaspberryPiScreen",
            deviceModel: "urn:tdm:aws/examples:deviceModel:Screen") {

        MQTT {
            ScreenCapability(id: "urn:tdm:aws/examples:capability:ScreenCapability") {
                state {
                    currentDisplayImage(name: "displayUri", property: "urn:tdm:aws:property:String")
                }

                Action(name: "display") {
                    params {
                        param(name:"imageUrl" property:"urn:tdm:aws:property:String")
                    }
                    Publish {
                        Request(topic: "$macro(${systemRuntime.deviceId}/display)") {
                            params {
                                param(name: "imageUri", property: "urn:tdm:aws/examples:property:CameraStateProperty", value: "${imageUrl.value}")
                            }
                        }
                    }
                }
            }
        }
}
```