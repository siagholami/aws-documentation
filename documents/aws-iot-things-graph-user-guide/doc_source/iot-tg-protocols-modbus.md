--------

--------

# Modbus<a name="iot-tg-protocols-modbus"></a>

AWS IoT Things Graph enables interaction through the Modbus protocol by specifying `Modbus` as the communication protocol in the device definition\. 

This topic describes how to model a Modbus device in GraphQL\. It also describes the types of Modbus interactions that the Things Data Model \(TDM\) currently supports, and the data transformations that occur when data types are modeled using the [AWS IoT Greengrass Modbus\-RTU Protocol Adapter](https://docs.aws.amazon.com/greengrass/latest/developerguide/modbus-protocol-adapter-connector.html)\.

**Prerequisites**
+ Version 1 of the [AWS IoT Greengrass Modbus\-RTU Protocol Adapter](https://docs.aws.amazon.com/greengrass/latest/developerguide/modbus-protocol-adapter-connector.html)\.
+ Modbus devices registered with credentials in the AWS IoT things registry\.

  For instructions on how to create things in the registry, see [Register a Device in the Registry](https://docs.aws.amazon.com/iot/latest/developerguide/register-device.html)\.
**Note**  
To add your devices to your AWS IoT Greengrass group, you need to register them as things with credentials, even though your devices don't need to use these credentials when your flows are running\.

## GraphQL for Defining Modbus Devices<a name="iot-tg-protocols-modbus-graphql"></a>

The following GraphQL shows how to define a device \(a sprinkler\) that uses the Modbus protocol\. This example assumes that the states, actions, and capability implemented in the device are already defined\. For more information about defining devices, see the [Things Data Model Reference](iot-tg-models.html), and the [iot-tg-models-tdm-iot-device.html](iot-tg-models-tdm-iot-device.html) construct specifically\.

```
 {

   type Sprinkler @deviceModel(id: "urn:tdm:REGION/ACCOUNT ID/default:DeviceModel:Sprinkler",
                                capability: "urn:tdm:REGION/ACCOUNT ID/default:Capability:SprinklerCapability) {
        ignore:void
    }
 
 query ModbusSprinkler @device(id: "urn:tdm:REGION/ACCOUNT ID/default:Device:MyModbusSprinkler",
                                    deviceModel: "urn:tdm:REGION/ACCOUNT ID/default:DeviceModel:Sprinkler") {
        Modbus(serverId:"2") {
            SprinklerCapability (id: "urn:tdm:REGION/ACCOUNT ID/default:Capability:SprinklerCapability") { 
                State {
                    valveState(name: "valveState", property:"urn:tdm:aws:Property:Boolean")
                    headAngle(name:  "headAngle",  property:"urn:tdm:REGION/ACCOUNT ID/default:Property:Angle")
                }
                Action(name: "actuateSprinklerHead") {
                    Params {
                        param(name:shouldActivate, property: "urn:tdm:aws:Property:Boolean")
                    }
                    WriteSingleCoil {
                        Request(Address: 1) {
                            params {
                                param(name:shouldActivate,
                                     property: "urn:tdm:aws:Property:Boolean",
                                      value: "${shouldActivate}")
                            }
                        }
                    }
                }

                Action(name: "getSprinklerHeadAngle") {
                    Params
                    ReadHoldingRegisters {
                        Response {
                            responsePayload(property: "urn:tdm:aws:Property:UInt16")
                        }
                    }
                }

                Action(name: "setSprinklerHeadAngle") {
                    Params {
                        param(name:angle, property: "urn:tdm:aws:Property:UInt16")
                    }
                    WriteSingleRegister {
                        Request(Address: 1) {
                            params {
                                param(name:angle,
                                     property: "urn:tdm:aws:Property:UInt16",
                                      value: "${angle}")
                            }
                        }
                    }
                }
            }
        }
    }
  }
```

**Key elements:**
+ **The `serverId` argument passed to the `Modbus` protocol block** \- The value of this argument specifies the Modbus endpoint ID to which AWS IoT Things Graph sends messages\.
+ **Implementations of the device's `State` and `Actions`** \- Modbus defines no event protocol for messages to be sent to the master, so the device definition contains no `Event` implementations\.
+ **Modbus request and response operations** \- Operations such as `WriteSingleCoil`, `ReadHoldingRegisters`, and `WriteSingleRegister` map precisely to the operations in the [AWS IoT Greengrass Modbus\-RTU Protocol Adapter](https://docs.aws.amazon.com/greengrass/latest/developerguide/modbus-protocol-adapter-connector.html)\.

## Interaction Flow<a name="iot-tg-protocols-modbus-interaction"></a>

AWS IoT Things Graph interacts with Modbus devices by using the [AWS IoT Greengrass Modbus RTU Protocol Adapter connector](https://docs.aws.amazon.com/greengrass/latest/developerguide/modbus-protocol-adapter-connector.html)\. The following diagram shows the flow that occurs when a flow invokes a Modbus device\. 

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGModbusSequence.png)

## Payload Translations<a name="iot-tg-protocols-modbus-translations"></a>

When AWS IoT Things Graph interacts with Modbus devices, most simple types and lists of simple types that are supported in the [AWS IoT Things Graph Data Model \(TDM\)](iot-tg-models.html) can be mapped to Modbus payloads\. However, complex objects can't be mapped\. 

The following tables describe the expected behavior when AWS IoT Things Graph serializes and deserializes Modbus data\.


**Coil Interactions**  

| TDM data type | Modbus serialization | Example TDM data | Example Modbus registers | 
| --- | --- | --- | --- | 
| List of Boolean values \(a single Boolean value is treated as a list of length 1\) |  **0** if the value is false, **1** if value is true\. Written to contiguous coils\.  |  0 \[0, 1, 1, 0\]  |  0 \[0, 1, 1, 0\]  | 
| Single integer value \(including all Int and UInt values\) |  **0** if the number == 0; otherwise, **1**\. Written to contiguous coils\.  |  \(UInt16\)13 \(Int64\)0 \[10, 0, \-4, 14\]  |  1 0 \[1, 0, 1, 1\]  | 


**Register Interactions**  

| TDM data type | Modbus serialization | Example TDM data | Example Modbus registers | 
| --- | --- | --- | --- | 
| Boolean or list of Boolean values |  Writes **0x01** to each register where Boolean is true, and **0x00** where Boolean is false\.  |  true \[true, true, false\]  |  \[0x0001\] \[0x0001, 0x0001, 0x0000\]  | 
| Int8 and UInt8 values |  Writes integers, two per register\. If there is an odd number of integers \(including one integer\), the value is written to MSB \(most significant byte\)\.  |  \(Int8\)1 \[\(int8\)3, \(int8\)5, \(int8\)4\] \[\(UInt8\)14, \(UInt8\)7\]  |  \[0x1000\] \[0x0305\]\[0x04000\] \[0xD700\]  | 
|  Int16 and UInt16 values  |  Writes integers, one per register\.  |  \[\(Int16\)17, \(Int16\)1\]  |  \[0x0010\]\[0x0001\]  | 
|  Int32 and UInt32 values  |  Writes one integer per two registers\. MSB is written first\.  |  \[0x00123400, 0x00F0\]  |  \[0x0012\]\[0x3400\]\[0x0000\]\[0x00F0\]  | 
|  Int64 and UInt64 values  |  Writes one integer per four registers\. MSB is written first\.  |  0x11223344  |  \[0x0000\]\[0x0000\]\[0x1122\]\[0x3344\]  | 
|  Float32 values  |  Writes one float per two registers\.  |  \[3\.14159, 2\.71828\]  |  \[0x4049\]\[0x0FD0\]\[0x402D\]\[0xF84D\]  | 
|  Float64 values  |  Writes one float per four registers\.  |  3\.14159  |  \[0x4009\]\[0x21F9\]\[0xF01B\]\[0x866E\]  | 
|  String  |  Writes the string as UTF\-8 encoded text\. If the string is an odd number of bytes, the last byte is written to the MSB of the last register\. A list of strings isn't allowed\.  |  "hello"  |  \[0x6865\]\[0x6C6C\]\[0x6F00\]  | 