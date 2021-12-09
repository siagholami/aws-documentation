--------

--------

# URN ID Scheme<a name="iot-tg-models-tdm-urnscheme"></a>

TDM URNs provide a hierarchical way of typing devices, properties, and entities\. They provide organizational information \(such as physical location\) about a type and semantic information \(such as color or the URI for an image\)\.

The TDM URN type ID consists of three components:
+ Hierarchical namespace
+ Metatype
+ Hierarchical semantic type path \(delimited with '/'\) that is an instance of the metatype

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TdmUrnScheme.png)

`urn`  
Identifier that is fixed and required by the URN scheme\.

`TDM`  
Fixed identifier that is the URN namespace for the AWS IoT Things Graph Data Model\.

`namespace`  
Identifier provided by the user\. There are two kinds of namespaces: public and private\. The public namespace contains the built\-in entities \(such as primitive properties\) supported by AWS IoT Things Graph\. A user's private namespace contains entities, workflows, and other AWS IoT Things Graph entities that the user creates\. Private namespaces are versioned, and they track and synchronize with the public namespace\. For more information about namespaces, see the definition in the [Glossary](iot-tg-whatis-glossary.html)\.

`metatype`  
A TDM data metatype such as device, action, event, and property\. 

`sem-type-path`  
The hierarchical path that specifies an instance of the `metatype`\. When the `metatype` is `Action` or `Event`, the `sem-type-path` values specify a capability and an action or event that is an instance of the capability, as in the following example\.  

```
urn:tdm:aws:action:camera/capture
```

## TDM URN Examples<a name="iot-tg-models-tdm-urnscheme-examples"></a>

The following table contains example TDM URNs for the TDM metatypes\. Note that this list doesn't contain every metatype in TDM\.


| TDM Metatype | Example TDM URN | 
| --- | --- | 
| Enum | urn:tdm:aws:enum:actionStatus | 
| Category | urn:tdm:aws:category:color | 
| Category \(subcategory\) | urn:tdm:aws:category:color/red | 
| Device | urn:tdm:aws:device:flashlight | 
| Property | urn:tdm:aws:property:switch | 
| Property \(sub\-property\) | urn:tdm:aws:property:switch/powerOnOff | 
| State | urn:tdm:aws:state:brightness | 
| Capability | urn:tdm:aws:capability:camera | 
| Action | urn:tdm:aws:action:camera/capture | 
| Event | urn:tdm:aws:event:camera/clicked | 
| Annotation | urn:tdm:aws:annotation:cameraUsage | 
| Mapping | urn:tdm:aws:mapping:brightnessRangeEnumToNumber | 
| Workflow | urn:tdm:aws:flow:simpleHomeSecurity | 