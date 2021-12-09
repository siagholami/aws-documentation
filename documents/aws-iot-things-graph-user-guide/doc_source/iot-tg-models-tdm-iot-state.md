--------

--------

# State<a name="iot-tg-models-tdm-iot-state"></a>

The `State` construct is a set of properties that represent the inner state of a device at a point in time\. You can also create complex properties that are composed of `States`\.

**Examples**

Creates a light bulb state\.

```
type lightBulbState @stateType(id: "urn:tdm:aws:state:lightBulb"){
  power: SwitchEnum @property(id: "urn:tdm:aws:Property:switch/powerOnOff"),
  brightness: brightnessNumber @property(id: "urn:tdm:aws:Property:brightness/brightnessNumber") 
}
```

Creates a colored light bulb state that extends `lightBulbState`\.

```
type coloredLightBulbState @stateType(id: "urn:tdm:aws:state:lightbulb/coloredLightBulb") implements lightbulbState  @stateType(id: "urn:tdm:aws:state:lightbulb") {
  power: SwitchEnum @property(id: "urn:tdm:aws:property:switch/powerOnOff"),
  brightness: brightnessNumber @property(id:"urn:tdm:aws:property:brightness/brightnessNumber"),
  color: colorRGB @property(id:"urn:tdm:aws:property:color/colorRGB")
}
```

Creates a camera state\.

```
type cameraState @stateType(id: "urn:tdm:aws:state:camera"){
   imageUri: ImageLinkUri @property(id: "urn:tdm:aws:property:imageLink/imageLinkUri"),
   clickTime: DateTime @property(id: "urn:tdm:aws:Property:dateTime") 
   }
```

Creates an advanced camera state that extends `cameraState`\.

```
type advCameraState @stateType(id:“urn:tdm:aws:state:camera/advCamera") implements cameraState 
                         @stateType(id:“urn:tdm:aws:state:camera") {
   imageUri: ImageLinkUri @property(id: "urn:tdm:aws:property:imageLink/imageLinkUri"),
   clickTime: DateTime @property(id: "urn:tdm:aws:property:dateTime"),
   burstDelay: interval_ms @property(id: "urn:tdm:aws:property:interval/interval_ms"),
   burstclickCount: interval_ms @property(id: "urn:tdm:aws:property:uint8")
}
```

Creates complex properties that contain camera states\.

```
type cameraStateProperty @propertyType(id: "urn:tdm:aws:property:cameraState" instanceOf: "urn:tdm:aws:state:camera") {ignore:void}


type advCameraStateProperty @propertyType(id: "urn:tdm:aws:property:advCameraState" instanceOf: "urn:tdm:aws:state:advCamera") {ignore:void}


type profCameraStateProperty @propertyType(id:"urn:tdm:aws:property:profCameraState" instanceOf: "urn:tdm:aws:state:profCamera") {ignore:void}
```