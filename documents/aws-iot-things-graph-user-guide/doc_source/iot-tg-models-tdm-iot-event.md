--------

--------

# Event<a name="iot-tg-models-tdm-iot-event"></a>

The `Event` construct describes a notification from a device that some action has been taken on it, such as a click of a camera\. The structure of this construct contains the following information:
+ The event name
+ A unique identifier of the source device of the event
+ A payload containing information that supports handling of the event

The following example creates an event that is published whenever a camera is clicked\.

```
type cameraClickedEvent @eventType(id: "urn:tdm:aws/sys/thing:Event:cameraClicked”,
                                   payload: "urn:tdm:aws:Property:Boolean"){ignore:void}
```