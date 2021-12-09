--------

--------

# System<a name="iot-tg-models-tdm-iot-system"></a>

The `System` construct describes a collection of devices, services, and workflows that interact with each other in an IoT system\. 

For example, a security system can consist of entry sensors, cameras, light bulbs, and a door monitoring workflow\. A `System` can be composed of other systems to create arbitrarily complex systems of systems\.

The following pseudocode shows what happens at a conceptual level when you create a system\.

```
CREATE SYSTEM systemUrn [Description text]  ‘{‘ [deviceRole deviceUrn [Description text][,]]* 
                                                   [serviceRole serviceUrn [Description text] [,]]* 
                                                   [workflowRole flowUrn [Description text] [,]]* ‘}’
```

**Key concepts**

systemUrn  
Unique URN of the system\.

deviceRole deviceUrn  
Role or name of the device identified by the deviceUrn\.

serviceRole serviceUrn  
Role or name of the service identified by serviceUrn\.

workflowRole flowUrn  
Role or name of the workflow identified by the workflowUrn\.

**GraphQL Example**

The following GraphQL creates a door entry security system\.

```
type DoorEntrySecuritySystem @SystemType(id:"urn:tdm:aws:system:DoorEntrySecurity", 
                                         description:"Door Entry Security") 
{
 # Devices and Services: Begin
 entrySensor: MotionSensorDevice @thing(id: "urn:tdm:aws:device:motionSensor"),
 entryCamera: CameraDevice @thing(id: "urn:tdm:aws:device:camera"),
 cameraLight: LightBulbDevice @thing(id: "urn:tdm:aws:device:lightBulb"),
 faceDetection: FaceDetectionService @thing(id: "urn:tdm:aws:service:faceDetection"),
 # Devices and Services: End
 
 # PowerOnOff is a Switch that controls power to entrySensor – motionSensor device
 powerOnOff: SwitchOnOffDevice @thing(id: "urn:tdm:aws:device:switchOnOff"),
 
 # Internal flow that automatically kicks in when entrySensor is powered on
 doorSecurityFlow: MonitorDoorEntryFlow @workflow(id: "urn:tdm:aws:workflow:monitorDoorEntry"),
 
 # Export PowerOnOffFLow as DoorEntrySecurity public API
 powerOnOffFlow: PowerOnOffFlow @workflow(id: "urn:tdm:aws:workflow:monitorDoorEntry, params[$powerOnOff, $entrySensor"]),

 # Expr property (implicitly isReadonly=true) 
 IsPowerOn : Boolean! @expr(“powerOnOff.state.power && entrySensor.state.connected”)
}
```

The following example creates a system that represents a professional camera room\. It contains a set of cameras and light bulbs, and a service that combines the images taken by the cameras into 3D visualizations\.

```
type CamaraRoom @systemType(id:"urn:tdm:aws:system:camera/3DCameraRoom", description:"3DCameraRoom ") {

 camera1: CameraDevice @Thing(id: "urn:tdm:aws:device:camera/advancedCamera"),
 cameraLight1: LightBulbDevice @thing(id:"urn:tdm:aws:device:lightbulb/cameraBulb"),

 camera2: CameraDevice @Thing(id: "urn:tdm:aws:device:camera/advancedCamera"),
 cameraLight2: LightBulbDevice @thing(id: "urn:tdm:aws:device:lightbulb/cameraBulb"),

 camera3: CameraDevice @Thing(id: "urn:tdm:aws:device:camera/advancedCamera"),
 cameraLight3: LightBulbDevice @thing(id: "urn:tdm:aws:device:lightbulb/cameraBulb"),

 camera4: CameraDevice @Thing(id: "urn:tdm:aws:device:camera/advancedCamera"),
 cameraLight4: LightBulbDevice @thing(id: "urn:tdm:aws:device:lightbulb/cameraBulb"),

 combineImages:CombineImagesFor3DVisualizationService 
                                  @service(id:"urn:tdm:aws:service:combineImagesFor3DVisualization")
}
```