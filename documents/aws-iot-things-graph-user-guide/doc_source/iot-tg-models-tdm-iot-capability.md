--------

--------

# Capability<a name="iot-tg-models-tdm-iot-capability"></a>

The `Capability` construct describes a piece of functionality that is implemented by an IoT device\. A `Capability` can extend one or more pre\-existing `Capabilities`\. It's a package containing a `State` and a set of `Actions` and `Events`\. A `Capability` definition consists of the following:
+ A unique identifier
+ At most, one `State`
+ A set of `Actions`
+ A set of `Events`

The following example creates a camera capability consisting of the `cameraState` state, the `cameraCapture` action, and the `cameraClicked` event created in the previous examples\.

```
type cameraCapability @capabilityType(id:"urn:tdm:aws:capability:camera") {

    # State alias: state type name @state()
    camera : cameraState @state(id:"urn:tdm:aws:property:cameraState"),

    # Action alias: action type name @action()
    capture :cameraCapture @action(id:"urn:tdm:aws:action:cameraCapture"),

    # Event alias: event type name @event()
    clicked :cameraClicked @event(id:"urn:tdm:aws:event:cameraClicked"),
}
```