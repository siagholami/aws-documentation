--------

--------

# Device Model<a name="iot-tg-models-tdm-iot-device-model"></a>

The `DeviceModel` construct describes an abstraction of an IoT device or a stateful service\. A `DeviceModel` must implement one `Capability`\. It represents a conceptual device and isn't tied to any specific manufacturer\.

A `DeviceModel` consists of the following:
+ A TDM URN that identifies the device model
+ A TDM URN that identifies the device model's `Capability`

The following example creates a camera device model that contains the camera capability created in the previous example\.

```
type cameraDevice @deviceModel(id:"urn:tdm:aws:deviceModel:camera",
                               capability:"urn:tdm:aws:capability:camera”) {ignore:void}
```