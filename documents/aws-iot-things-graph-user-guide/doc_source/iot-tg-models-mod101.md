--------

--------

# Modbus Device Modeling 101<a name="iot-tg-models-mod101"></a>

This topic describes what you need to think about and plan for when you're creating models for your Modbus devices\. 

We'll use a weather monitoring device as a reference point, but you can apply the process that this topic describes to any device that uses the Modbus communication protocol\. The weather monitoring device that we model here is the [Elsner P03 Weather Station](https://www.elsner-elektronik.de/shop/en/fileuploader/download/download/?d=1&file=custom%2Fupload%2F30146-30147_P033-Modbus_P033-Modbus-GPS_DataSheet2-0_EN_19Mar2018.pdf) \(be sure to read the specification's description\)\.

The [Elsner\-Weather\-Station\.zip](samples/Elsner-Weather-Station.zip) file contains all of the GraphQL code discussed in this topic\.

The Elsner P03 Weather Station measures conditions in the physical environment\. From the device's description in the [specification](https://www.elsner-elektronik.de/shop/en/fileuploader/download/download/?d=1&file=custom%2Fupload%2F30146-30147_P033-Modbus_P033-Modbus-GPS_DataSheet2-0_EN_19Mar2018.pdf), we know that this device performs the following functions:
+ Measures brightness, with sensors for east, south, and west
+ Recognizes twilight and dawn
+ Measures wind strength
+ Measures temperature
+ Recognizes the presence of precipitation

When you define a device, you need to create two pieces\. The first piece is the abstract device model\. This piece generically defines what a type of device does\. The second piece is the device definition, which implements the model\. The device definition specifies the communication protocol used by the device\. Devices that use different protocols can inherit from the same device model\.

Before you define your device, look in the [AWS IoT Things Graph console](https://console.aws.amazon.com/thingsgraph/home) to determine whether an abstract model for the type of device you're defining already exists\. If so, you can skip to the task of defining your device\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGDeviceModeling.png)

If you can't find an existing abstract device model for your device in the console, you have to define one\. For this exercise, assume that no model for a weather monitoring device currently exists\.

## Creating Your Abstract Device Model<a name="iot-tg-models-mod101-abstract"></a>

Begin by thinking about the function or functions that your device serves\. A weather monitoring device, or weather station, measures various conditions in the physical environment, such as temperature, wind speed, and the brightness of sunlight\. In the AWS IoT Things Graph Data Model \(TDM\), this collection of actions that the device can perform is its *capability*\.

Because this device uses the Modbus protocol, AWS IoT Things Graph communicates only with the master polling device\. The master device doesn't receive inputs from other devices, so when you model a Modbus device in TDM, you don't need to define any events\. Modbus device capabilities contain only actions\.

Knowing this, you can start by creating an abstract TDM device model\. \(The *REGION* and *ACCOUNT ID* values are specific to your account\. The *Suffix* value is 1 until you create different versions of your weather station\.\)

```
type 
WeatherStation @deviceModel(id: "urn:tdm:{{REGION}}/{{ACCOUNT_ID}}/default:deviceModel:WeatherStation_{{SUFFIX}}", 
                                            capability: "urn:tdm:{{REGION}}/{{ACCOUNT_ID}}/default:capability:WeatherStationCapability_{{SUFFIX}}"){
        IGNORE: VOID
    }
```

Next, you need to define the capability that you included in your abstract model\. Look through your product specification and note all of the actions that the master device performs and the registers that it uses to read and write data\. A typical weather station device needs to read data only from the devices that it's polling, so all of your actions will be "get" operations\.

Because you're creating a model for a weather station, you need to create a capability that includes recognizing rain and measuring temperature, wind speed, and the brightness of sunlight from the east, west, and south\.

```
type
WeatherStationCapability @capabilityType(id: "urn:tdm:{{REGION}}/{{ACCOUNT_ID}}/default:capability:WeatherStationCapability_{{SUFFIX}}") {
        getOutdoorTemperature: GetOutdoorTemperature @action(id: "urn:tdm:{{REGION}}/{{ACCOUNT_ID}}/default:action:GetOutdoorTemperature_{{SUFFIX}}")
        getIlluminanceOfSun_south: GetIlluminanceOfSun_south @action(id: "urn:tdm:{{REGION}}/{{ACCOUNT_ID}}/default:action:GetIlluminanceOfSun_south_{{SUFFIX}}")
        getIlluminanceOfSun_west: GetIlluminanceOfSun_west @action(id: "urn:tdm:{{REGION}}/{{ACCOUNT_ID}}/default:action:GetIlluminanceOfSun_west_{{SUFFIX}}")
        getIlluminanceOfSun_east: GetIlluminanceOfSun_east @action(id: "urn:tdm:{{REGION}}/{{ACCOUNT_ID}}/default:action:GetIlluminanceOfSun_east_{{SUFFIX}}")
        getLight: GetLight @action(id: "urn:tdm:{{REGION}}/{{ACCOUNT_ID}}/default:action:GetLight_{{SUFFIX}}")
        getWindSpeed: GetWindSpeed @action(id: "urn:tdm:{{REGION}}/{{ACCOUNT_ID}}/default:action:GetWindSpeed_{{SUFFIX}}")
        getRainCheck: GetRainCheck @action(id: "urn:tdm:{{REGION}}/{{ACCOUNT_ID}}/default:action:GetRainCheck_{{SUFFIX}}")
    }
```

### Implementing Your Device's Capability<a name="iot-tg-models-mod101-abstract-impl"></a>

Now you need to define the actions that you included in your device model's capability\. To do this, look at your product specification to determine how your device performs the actions in the capability\.

The device functions described in the [Elsner P03 Weather Station specification](https://www.elsner-elektronik.de/shop/en/fileuploader/download/download/?d=1&file=custom%2Fupload%2F30146-30147_P033-Modbus_P033-Modbus-GPS_DataSheet2-0_EN_19Mar2018.pdf) map to the actions that you included in the device model capability\.
+ The three action types for `getIlluminanceOfSun` correspond with the device's three brightness sensors\.
+ The `getLight` action corresponds with its recognition of twilight and dawn\.
+ The `getRainCheck` action corresponds with the precipitation recognition function, and the `getOutdoorTemperature` and `getWindSpeed` actions correspond with the device's temperature and wind strength measurement functions\.

The specification also contains a table named **P03\-Modbus output string to the master**\. This table contains the following information:
+ The register address where each measurement is stored\.
+ The number of bytes required to store each measurement\.
+ The type of measurement stored at each register \(under the **Variable** column\)\.
+ The **Meaning** of each measurement\. This column also gives important information about the data type of the measurement value\.

The following extract from the table can help you understand how the information in the specification maps both to your action definitions and to the device definition that you create when the abstract device model is complete\.


| Byte No\. | Register Address | Variable |  | Meaning | 
| --- | --- | --- | --- | --- | 
| 3 | 0 | Outdoor Temperature | H |  with sign, value/10 =  temperature xx\.x °C  | 
| 4 |  | Outdoor Temperature | L |  | 
| 5 | 1 | Sun sensor, south | H | 1\.\.\.99 Kilolux | 
| 6 |  | Sun sensor, south | L |  | 

This extract tells you that the temperature measurement is stored at register address 0, and its size in bytes is 2\. It contains a sign \(for above and below 0\) and uses the Celsius scale\. You know from this that you can use the [built\-in TDM data type](iot-tg-models-tdm-datatypes.html) `Int16` as the return type of the `getOutdoorTemperature` action\. You also know that you need to read 2 bytes to get the value\. The extract also tells you that the device stores the south sunlight measurement at register address 1, and that its size is also 2 bytes\. This value can also be returned as `Int16`\.

In fact, all but one of the values that the actions measure can be returned with the `Int16` data type\. The rain sensor measurement \(at register address 7\) stores a 1\-byte Boolean value\.

When you create the action definitions, you use your understanding of the data types to be returned\. When you create the device definition, you use the information about register addresses, data types, and sizes in bytes\. 

You can now define the following actions with your knowledge of the device, what it does, and how it performs its actions\.

```
type
GetOutdoorTemperature @actionType(id: "urn:tdm:{{REGION}}/{{ACCOUNT_ID}}/default:action:GetOutdoorTemperature_{{SUFFIX}}") {
        return: DegreesCelsius @property(id: "urn:tdm:aws:Property:Int16")
    }
type
GetIlluminanceOfSun_south @actionType(id: "urn:tdm:{{REGION}}/{{ACCOUNT_ID}}/default:action:GetIlluminanceOfSun_south_{{SUFFIX}}") {
        return: KiloLux @property(id: "urn:tdm:aws:Property:Int16")
    }
type
GetIlluminanceOfSun_west @actionType(id: "urn:tdm:{{REGION}}/{{ACCOUNT_ID}}/default:action:GetIlluminanceOfSun_west_{{SUFFIX}}") {
        return: KiloLux @property(id: "urn:tdm:aws:Property:Int16")
    }
type
GetIlluminanceOfSun_east @actionType(id: "urn:tdm:{{REGION}}/{{ACCOUNT_ID}}/default:action:GetIlluminanceOfSun_east_{{SUFFIX}}") {
        return: KiloLux @property(id: "urn:tdm:aws:Property:Int16")
    }
type
GetLight @actionType(id: "urn:tdm:{{REGION}}/{{ACCOUNT_ID}}/default:action:GetLight_{{SUFFIX}}") {
        return: Lux @property(id: "urn:tdm:aws:Property:Int16")
    }
type
GetWindSpeed @actionType(id: "urn:tdm:{{REGION}}/{{ACCOUNT_ID}}/default:action:GetWindSpeed_{{SUFFIX}}") {
        return: WindSpeed @property(id: "urn:tdm:aws:Property:Int16")
    }
type
GetRainCheck @actionType(id: "urn:tdm:{{REGION}}/{{ACCOUNT_ID}}/default:action:GetRainCheck_{{SUFFIX}}") {
        return: IsRain @property(id: "urn:tdm:aws:Property:Boolean")
    }
```

## Creating the Definition for Your Device<a name="iot-tg-models-mod101-concrete"></a>

You now have a complete abstract device model\. You've defined what capability the weather station performs and the actions that it takes to fulfill this capability\. Now you need to define how your device implements the abstract device model's capability\. 

To do this, you must know the following:
+ The Modbus endpoint ID to which AWS IoT Things Graph sends messages
+ The address of each register from which the master device gets each piece of information returned by each action
+ The number of bytes to read
+ The data type of each measurement value

The following example shows how these values are used in a device definition\. \(For more information about the elements of a Modbus device definition, see [Modbus](iot-tg-protocols-modbus.html)\.\)

```
 query 
 ModbusElsnerWeatherStation @device(id: "urn:tdm:{{REGION}}/{{ACCOUNT_ID}}/default:device:ModbusElsnerWeatherStation_{{SUFFIX}}",
                                             deviceModel: "urn:tdm:{{REGION}}/{{ACCOUNT_ID}}/default:deviceModel:WeatherStation_{{SUFFIX}}") {
        Modbus(ServerId:"2") {
            Capability (id: "urn:tdm:{{REGION}}/{{ACCOUNT_ID}}/default:capability:WeatherStationCapability_{{SUFFIX}}") {
                Action(name: "getOutdoorTemperature") {
                    Params
                    ReadInputRegisters {
                        Request (Address: 0, ReadCount: 1)
                        Response {
                            responsePayload(property: "urn:tdm:aws:Property:Int16")
                        }
                    }
                }
                Action(name: "getIlluminanceOfSun_south") {
                    Params
                    ReadInputRegisters {
                        Request (Address: 1, ReadCount: 1)
                        Response {
                            responsePayload(property: "urn:tdm:aws:Property:Int16")
                        }
                    }
                }
                Action(name: "getIlluminanceOfSun_west") {
                    Params
                    ReadInputRegisters {
                        Request (Address: 2, ReadCount: 1)
                        Response {
                            responsePayload(property: "urn:tdm:aws:Property:Int16")
                        }
                    }
                }
                Action(name: "getIlluminanceOfSun_east") {
                    Params
                    ReadInputRegisters {
                        Request (Address: 3, ReadCount: 1)
                        Response {
                            responsePayload(property: "urn:tdm:aws:Property:Int16")
                        }
                    }
                }
                Action(name: "getLight") {
                    Params
                    ReadInputRegisters {
                        Request (Address: 4, ReadCount: 1)
                        Response {
                            responsePayload(property: "urn:tdm:aws:Property:Int16")
                        }
                    }
                }
                Action(name: "getWindSpeed") {
                    Params
                    ReadInputRegisters {
                        Request (Address: 5, ReadCount: 1)
                        Response {
                            responsePayload(property: "urn:tdm:aws:Property:Int16")
                        }
                    }
                }
                Action(name: "getRainCheck") {
                    Params
                    ReadInputRegisters {
                        Request (Address: 6, ReadCount: 1)
                        Response {
                            responsePayload(property: "urn:tdm:aws:Property:Boolean")
                        }
                    }
                }
            }
        }
    }
```

The two parameters included after the `@device` declaration are the IDs of the device and device models\. The `serverId` value inside the Modbus protocol block is the Modbus endpoint ID\. Each request inside the `ReadInputRegisters` blocks includes the register address and read count for each value that the device returns\. The data type of each return value is included in the `responsePayload` blocks\.

The [Elsner\-Weather\-Station\.zip](samples/Elsner-Weather-Station.zip) file contains all of the GraphQL code discussed in this topic\. Download it to work with it, and then upload it to AWS IoT Things Graph yourself\.