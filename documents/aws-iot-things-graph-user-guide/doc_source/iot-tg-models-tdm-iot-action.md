--------

--------

# Action<a name="iot-tg-models-tdm-iot-action"></a>

The `Action` construct is an abstract representation of a device performing an instance of its capability, such as a camera capturing an image\. An `Action` takes properties as its parameters and returns properties as its output\.

The following examples create three kinds of camera capture actions\. The three actions vary according the types of parameters they take \(if parameters are present\)\. The first example describes the simplest kind of camera capture\. The other two make the camera capture more complex by passing parameters that set a delay in milliseconds and picture resolution\. All three return an image URL as output\. The `return` keyword inside the braces and followed by a colon precedes the return value's name, type \(`@property` directive\), and URN\.

```
type cameraCaptureAction @actionType(id: "urn:tdm:aws:Action:cameraCapture"){
           return : imageLinkUri @property(id:"urn:tdm:aws:property:imageLink/imageLinkUri”)

type cameraDelayedCaptureAction @actionType(id:"urn:tdm:aws:Action:cameraCapture/cameraDelayedCapture")   {
           delay_ms : uint16 @property(id:"urn:tdm:aws:property:uint16"),
           return : imageLinkUri @property(id:"urn:tdm:aws:property:imageLink/imageLinkUri”)
           }

type cameraAdvancedCaptureAction 
        @actionType(id:"urn:tdm:aws:Action:cameraCapture/cameraDelayedCapture/cameraAdvancedCapture") {
           delay_ms : uint16 @property(id:"urn:tdm:aws:property:uint16"), 
           resolution : enumLowMediumHigh @property(id:"urn:tdm:aws::property:resolution/enumLowMediumHigh"),
           return : imageLinkUri @property(id:"urn:tdm:aws:property:imageLink/imageLinkUri”)         
           }
```