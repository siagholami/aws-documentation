--------

--------

# AWS IoT Things Graph Data Model Reference<a name="iot-tg-models"></a>

The AWS IoT Things Graph Data Model \(TDM\) is a declarative framework designed for representing IoT concepts, devices, and workflows\. It also provides semantic mappings between multiple representations of IoT concepts, such as color, brightness, and temperature\. GraphQL provides the language and syntax for expressing TDM concepts\.

Data models and mappings created in this framework enable automation engineers to build workflows consisting of devices from multiple manufacturers\. Because the IoT devices and their properties are represented and mapped in TDM, devices can interoperate and communicate with each other without any transformations or low\-level code on the devices\. For example, TDM can map equivalent units of measure across devices that use different scales, such as Fahrenheit and Celsius\.

Additionally, the TDM framework enables IoT automation engineers to build workflows consisting of device models created in TDM\. Physical devices can be assigned to device models, and their interactions in a workflow can be defined in TDM\. Engineers can then deploy multiple instances of a workflow using different sets of concrete devices in each deployment\. Engineers can also swap a given device from one manufacturer with a device from another manufacturer because both devices and their properties are represented in the same device model\.

TDM consists of a set of core constructs, including and most importantly `PropertyTypes`\. TDM also consists of a set of specialized constructs that support IoT\-specific constructs, including `State`, `Device`, and `Capability`\.

The following sections describe both the core and the IoT\-specific concepts of TDM\. They also describe how to use GraphQL syntax to create and extend TDM constructs\.

**Topics**
+ [What Is the AWS IoT Things Graph Data Model?](iot-tg-whatis-tdm.md)
+ [AWS IoT Things Graph Data Model and GraphQL](iot-tg-models-tdm-graphql.md)
+ [AWS IoT Things Graph Data Model Core Constructs](iot-tg-models-tdm-core.md)
+ [IoT Domain Constructs](iot-tg-models-tdm-iot.md)