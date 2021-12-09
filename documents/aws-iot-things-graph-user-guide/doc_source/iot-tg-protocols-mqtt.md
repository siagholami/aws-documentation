--------

--------

# MQTT<a name="iot-tg-protocols-mqtt"></a>

AWS IoT Things Graph enables interaction through the MQTT protocol by specifying `MQTT` as the communication protocol in the device definition\. This topic describes how to model an MQTT device in GraphQL\.

The following GraphQL shows how to define a device \(a camera\) that uses the MQTT protocol\. This example assumes that the state, event, and capability implemented in the device are already defined\. For more information about defining devices, see the [Things Data Model Reference](iot-tg-models.html), and the [iot-tg-models-tdm-iot-device.html](iot-tg-models-tdm-iot-device.html) construct specifically\.

```
 {

        type DemoCamera @deviceModel(id:"urn:tdm:REGION/ACCOUNT ID/default:deviceModel:DemoCamera",
                capability: "urn:tdm:REGION/ACCOUNT ID/default:capability:DemoCameraCap"){ignore:void}
     
        query DemoPhyCamera @device(id: "urn:tdm:REGION/ACCOUNT ID/default:device:DemoPhyCamera",
                deviceModel: "urn:tdm:REGION/ACCOUNT ID/default:deviceModel:DemoCamera") {
            MQTT {
                DemoCameraCap(id: "urn:tdm:REGION/ACCOUNT ID/default:capability:DemoCameraCap") {
                    State {
                        lastClickedImage(name: "lastImage", property: "urn:tdm:aws:property:String")
                    }
                    Action(name: "capture") {
                        Publish {
                            Request(topic: "${systemRuntime.deviceId}/capture") {
                                params
                            }
                            Response(topic: "${systemRuntime.deviceId}/capture/finished") {
                                responsePayload(property: "urn:tdm:REGION/ACCOUNT ID/default:property:DemoCameraStateProperty")
                            }
                        }
                    }
                }
            }
        }
  }
```

**Key elements:**
+ **Implementations of the device's `State` and `Action`** \- A device implementation can also implement a device `Event`\.
+ **The `Publish` block inside the `Action` implementation** \- This block contains the `Request` and `Response` definitions\.
+ **The `Request` definition** \- This definition specifies the MQTT request topic and the parameters, if any, that are sent to it\. 
+ **The `Response` definition** \- This optional definition specifies the MQTT response topic \(if one exists\) and the payload that is sent to it\.

The following GraphQL defines another GraphQL device \(a motion sensor\)\. This example implements a device `Event` that contains a `Subscribe` block\. This block specifies the MQTT topic to which the motion sensor subscribes\.

```
{
        type DemoMotionSensor @deviceModel(id: "urn:tdm:REGION/ACCOUNT ID/default:deviceModel:DemoMotionSensor",
            capability: "urn:tdm:REGION/ACCOUNT ID/default:capability:DemoMotionSensorCap") {ignore:void}
     
        query DemoPhyMotionSensor @device(id: "urn:tdm:REGION/ACCOUNT ID/default:device:DemoPhyMotionSensor",
                deviceModel: "urn:tdm:REGION/ACCOUNT ID/default:deviceModel:DemoMotionSensor") {
            MQTT {
                MotionSensorCap(id: "urn:tdm:REGION/ACCOUNT ID/default:capability:DemoMotionSensorCap") {
                    State {
                        isMotionDetected(name:"isMotionDetected", property:"urn:tdm:aws:property:Boolean")
                    }
                    Event(name: "StateChanged") {
                        Subscribe(topic: "${systemRuntime.deviceId}/motion") {
                                responsepayload(property: "urn:tdm:REGION/ACCOUNT ID/default:property:DemoMotionSensorStateProperty")
                        }
                    }
                }
            }
        }
}
```