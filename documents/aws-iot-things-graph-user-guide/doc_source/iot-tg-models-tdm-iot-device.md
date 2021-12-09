--------

--------

# Device<a name="iot-tg-models-tdm-iot-device"></a>

The `Device` construct describes a specific IoT device that implements the `Capability` of a `DeviceModel`\. 

This is not a concrete device, but an abstract definition of a device\. After a device is defined in TDM, concrete devices can be mapped to the device definition\.

A `Device` definition includes the following:
+ An implementation of the parent device model's `State`
+ An implementation of the parent device model's `Actions` and `Events` in the context of a specific communication protocol, such as MQTT or Modbus

The following pseudocode describes what happens at a conceptual level when you create a device\.

```
Create Device deviceUrn Device_Model deviceModelUrn ‘{‘
              [State   ‘{‘ [alias propertyUrn]* ‘}’ ] 
             ([Action  actionName  Protocol [MQTT | ModBus]  ] ‘{‘ action-protocol-body’ }’)*
             ([Event  eventName  Protocol [MQTT | ModBus]  ] ‘{‘ event-protocol-body’ }’)* ‘}’

MQTT_action_protocol_body :: PROTOCOL MQTT2 ‘{‘
         REQUEST (TOPIC topicPath) Params ‘(‘ ([ [paramName] paramPropertyUrn valueExpr][,])* ‘)’
        RESPONSE (TOPIC topicPath) Property returnPropertyUrn
    ‘}’

MQTT_event_protocol_body :: PROTOCOL MQTT2 ‘{‘
         PAYLOAD [NAME payloadFieldName] TOPIC topicPath paylodPropertyUrn 
    ‘}’
```

**Key Concepts**

deviceUrn  
The URN that uniquely identifies the device\.

deviceModelUrn  
The URN that uniquely identifies the device model from which the device inherits\.

actionName  
The name of the action that the device implements\.

eventName  
The name of the event that the device implements\.

PROTOCOL  
The communication protocol that the device uses\.

topicPath  
The name of the topic associated with a request, response, or event\.

paramName  
The name of the action request parameter\.

paramPropertyUrn  
The URN that specifies the parameter property\.

valueExpr  
The expression that specifies the value to pass as a parameter value\.

payloadFieldName  
Optional payload field name\. Usually the payload is an unnamed structure\.

payloadPropertyUrn  
The URN of the event payload property\.

**GraphQL Example**

The following example creates a camera device that implements the camera device model\.

```
query cameraDevice @device(id: "urn:tdm:aws:device:camera",                                       # Device URN
                       deviceModel: "urn:tdm:aws:deviceModel:cameraModel") {                      # Device model URN
   MQTT {                                                                                                   # Commmunication protocol
       Capability(id: "urn:tdm:aws:capability:CameraCap") {                                       # URN of capability.
           state {                                                                                          # State implementation
               lastClickedImage(name: "lastImage", property: "urn:tdm:aws:Property:Uri")" +
           }
           Action(name: "capture") {                                                                        # Action name and implementation
               Publish {
                   Request(topic: "camera/capture") {                                                       # MQTT request topic
                       params
                   }
                   Response(topic: "camera/capture/finished") {                                             # MQTT response topic
                       responsePayload(property: "urn:tdm:aws:Property:Uri")                      # MQTT response payload (image URI)
                   }
               }
           }
         Event(name:"clicked") {                                                                            # Event implementation
            property: boolean @property(id: "urn:tdm:aws:Property:boolean")
         }
       }
   }
```

This example contains the following key elements\.
+ The URN that uniquely identifies the device \(first argument\)\.
+ The URN that uniquely identifies the device model \(second argument\)\.
+ The communication protocol used by the device\. Possible values are ModBus \(for local communication\), HTTP \(for remote communication\), and MQTT \(for both local and remote communication\)\.
+ The name and unique identifier \(URN\) of the capability that the device implements\.
+ The `Action` name and implementation\.
+ The `Request` definition\. This definition specifies the MQTT request topic and the parameters, if any, that are sent to it\.
+ The `Response` definition\. This definition specifies the MQTT response topic and the payload \(an image URL\) that is sent to it\.
+ The `Event` implementation\.

See the `DeviceActivity` implementations in [Workflow](iot-tg-models-tdm-iot-workflow.html) for sample implementations of `Devices`\.