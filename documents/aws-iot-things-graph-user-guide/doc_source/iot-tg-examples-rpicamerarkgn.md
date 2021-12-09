--------

--------

# Raspberry Pi Camera \(for Amazon Rekognition\)<a name="iot-tg-examples-rpicamerarkgn"></a>

The following GraphQL shows the device definition for the [Raspberry Pi Camera](https://www.amazon.com/Raspberry-Pi-Camera-Module-Megapixel/dp/B01ER2SKFS) that is available in the AWS IoT Things Graph console\. This device is used in [Creating a Flow with Devices and a Service](iot-tg-gs-thingdev-sample.html)\. 

This camera definition includes a response payload that contains an Amazon Simple Storage Service \(Amazon S3\) bucket name and the name of an item in the bucket\. Amazon Rekognition requires the Amazon S3 bucket and item names as input parameters\. 

```
# Camera state.
type CameraStateRkgnExample @stateType(id: "urn:tdm:aws/examples:state:CameraStateRkgnExample") {
            lastClickedImage : Uri @property(id: "urn:tdm:aws:property:String"),
            s3BucketName : bucketName @property(id: "urn:tdm:aws:property:String"),
            s3ItemName : itemName @property(id: "urn:tdm:aws:property:String")
}

# Property representing the camera state.
type CameraStatePropertyRkgnExample @propertyType(id: "urn:tdm:aws/examples:property:CameraStatePropertyRkgnExample",
instanceOf: "urn:tdm:aws/examples:state:CameraStateRkgnExample") {ignore:void}

# The Capture action takes no arguments and returns the state of the device after completing.
type CaptureRkgnExample @actionType(id:"urn:tdm:aws/examples:action:CaptureRkgnExample") {
        return : CameraStatePropertyRkgnExample @property(id: "urn:tdm:aws/examples:property:CameraStatePropertyRkgnExample")
}

# Camera capability.
type CameraCapabilityRkgnExample @capabilityType(id: "urn:tdm:aws/examples:capability:CameraCapabilityRkgnExample") {
        STATE: CameraStateRkgnExample @state(id: "urn:tdm:aws/examples:state:CameraStateRkgnExample")
        capture: CaptureRkgnExample @action(id: "urn:tdm:aws/examples:action:CaptureRkgnExample")
}

# Camera device model.
type CameraRkgnExample @deviceModel(id:"urn:tdm:aws/examples:deviceModel:CameraRkgnExample",
capability: "urn:tdm:aws/examples:capability:CameraCapabilityRkgnExample"){ignore:void}

# Device definition for the Raspberry Pi Camera.
# In our implementation, this device uses a Java driver to connect to AWS IoT Greengrass.
query RaspberryPiCameraRkgnExample @device(id: "urn:tdm:aws/examples:device:RaspberryPiCameraRkgnExample",
            deviceModel: "urn:tdm:aws/examples:deviceModel:CameraRkgnExample") {
        MQTT {
            CameraCapabilityRkgnExample(id: "urn:tdm:aws/examples:capability:CameraCapabilityRkgnExample") {
                state {
                    lastClickedImage(name: "lastImage", property: "urn:tdm:aws:property:String"),
                    s3BucketName(name: "s3BucketName", property: "urn:tdm:aws:property:String"),
                    s3ItemName(name: "s3ItemName", property: "urn:tdm:aws:property:String")
                }
                Action(name: "capture") {
                    Publish {
                        Request(topic: "$macro(${systemRuntime.deviceId}/capture)") {
                            params
                        }
                        Response(topic: "$macro(${systemRuntime.deviceId}/capture/finished)") {
                            responsePayload(property: "urn:tdm:aws/examples:property:CameraStatePropertyRkgnExample")
                        }
                    }
                }
            }
        }
}
```