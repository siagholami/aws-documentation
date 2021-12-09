--------

--------

# Deuta AL\-511\-00 IP\-DALI\-BRIDGE V2<a name="iot-tg-examples-dali"></a>

The following GraphQL shows the device definition for the [Deuta AL\-511\-00 IP\-DALI\-BRIDGE V2](https://deuta-controls.net/home-2/produkte/gebaeudeautomation/al-511-00-ip-dali-bridge-v2/?lang=en)\. This device is a communication bridge that connects a controller with an Ethernet interface to any DALI device\. Therefore, this device definition is just a template\. You can rename the actions based on the resources of the device that's connected to the bridge\. 

For more information about how to create a Modbus device model, see [Modbus Device Modeling 101](iot-tg-models-mod101.html)\. That topic explains how to translate details from the [product specification](https://deuta-controls.net/home-2/produkte/gebaeudeautomation/al-511-00-ip-dali-bridge-v2/?lang=en) into the device definition\.

```
{
    # Manufacturer: Deuta
    # Model: AL-511-00 IP-DALI-BRIDGE V2
    
    # Action definitions
type GetVersion @actionType(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:GetVersion") {
  return: VersionNumber @property(id: "urn:tdm:aws:Property:Int16")
}

type GetSerialNumber @actionType(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:GetSerialNumber") {
  return: SerialNumber @property(id: "urn:tdm:aws:Property:Int16")
}

type GetAnalogInputVoltage @actionType(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:GetAnalogInputVoltage") {
  return: AnalogInputVoltage @property(id: "urn:tdm:aws:Property:Int16")
}

type GetAnalogInputPercent @actionType(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:GetAnalogInputPercent") {
  return: Percent @property(id: "urn:tdm:aws:Property:Int16")
}

type GetDigitalThresholdValue @actionType(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:GetDigitalThresholdValue") {
  return: DigitalThresholdValue @property(id: "urn:tdm:aws:Property:Int16")
}

type SetDigitalThresholdValue @actionType(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:SetDigitalThresholdValue") {
  inputDigitalThresholdValue: DigitalThresholdValue @property(id: "urn:tdm:aws:Property:Int16")
}

type GetDigitalInput @actionType(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:GetDigitalInput") {
  return: DigitalSignal @property(id: "urn:tdm:aws:Property:Int16")
}

type GetDigitalOutputTemp @actionType(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:GetDigitalOutputTemp") {
  return: DigitalSignal @property(id: "urn:tdm:aws:Property:Int16")
}

type SetDigitalOutputTemp @actionType(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:SetDigitalOutputTemp") {
  inputDigitalOutputTemp: DigitalSignal @property(id: "urn:tdm:aws:Property:Int16")
}

type GetDigitalOutputRemanent @actionType(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:GetDigitalOutputRemanent") {
  return: DigitalSignal @property(id: "urn:tdm:aws:Property:Int16")
}

type SetDigitalOutputRemanent @actionType(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:SetDigitalOutputRemanent") {
  inputDigitalOutputRemanent: DigitalSignal @property(id: "urn:tdm:aws:Property:Int16")
}

type GetChipTemperature @actionType(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:GetChipTemperature") {
  return: ChipTemperature @property(id: "urn:tdm:aws:Property:Int16")
}

type GetAnalogInputOffset @actionType(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:GetAnalogInputOffset") {
  return: AnalogInputOffset @property(id: "urn:tdm:aws:Property:Int16")
}

type SetAnalogInputOffset @actionType(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:SetAnalogInputOffset") {
  inputAnalogInputOffset: AnalogInputOffset @property(id: "urn:tdm:aws:Property:Int16")
}

type GetAnalogInputGradient @actionType(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:GetAnalogInputGradient") {
  return: AnalogInputGradient @property(id: "urn:tdm:aws:Property:Int16")
}

type SetAnalogInputGradient @actionType(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:SetAnalogInputGradient") {
  inputAnalogInputGradient: AnalogInputGradient @property(id: "urn:tdm:aws:Property:Int16")
}

type GetSupplyVoltageStatus @actionType(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:GetSupplyVoltageStatus") {
  return: DigitalSignal @property(id: "urn:tdm:aws:Property:Int16")
}

type SetDALIcommand @actionType(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:SetDALIcommand") {
  inputCommand: DALIcommand @property(id: "urn:tdm:aws:Property:Int16")
}

type GetDALIanswer @actionType(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:GetDALIanswer") {
  return: DALIanswer @property(id: "urn:tdm:aws:Property:Int16")
}

    # Capability definition
type DALILightControllerCapability @capabilityType(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:capability:DALILightControllerCapability") {
  getMainVersion_HW: GetVersion @action(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:GetVersion")
  getSubVersion_HW: GetVersion @action(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:GetVersion")
  getMainVersion_SW: GetVersion @action(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:GetVersion")
  getSubVersion_SW: GetVersion @action(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:GetVersion")
  getSerialNumber_LSB: GetSerialNumber @action(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:GetSerialNumber")
  getSerialNumber_MSB: GetSerialNumber @action(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:GetSerialNumber")
  getAnalogInputVoltage: GetAnalogInputVoltage @action(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:GetAnalogInputVoltage")
  getAnalogInputPercent: GetAnalogInputPercent @action(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:GetAnalogInputPercent")
  getDigitalThresholdValue_low: GetDigitalThresholdValue @action(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:GetDigitalThresholdValue")
  setDigitalThresholdValue_low: SetDigitalThresholdValue @action(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:SetDigitalThresholdValue")
  getDigitalThresholdValue_high: GetDigitalThresholdValue @action(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:GetDigitalThresholdValue")
  setDigitalThresholdValue_high: SetDigitalThresholdValue @action(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:SetDigitalThresholdValue")
  getDigitalInput: GetDigitalInput @action(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:GetDigitalInput")
  getDigitalOutputTemp: GetDigitalOutputTemp @action(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:GetDigitalOutputTemp")
  setDigitalOutputTemp: SetDigitalOutputTemp @action(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:SetDigitalOutputTemp")
  getDigitalOutputRemanent: GetDigitalOutputRemanent @action(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:GetDigitalOutputRemanent")
  setDigitalOutputRemanent: SetDigitalOutputRemanent @action(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:SetDigitalOutputRemanent")
  getChipTemperature: GetChipTemperature @action(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:GetChipTemperature")
  getAnalogInputOffset: GetAnalogInputOffset @action(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:GetAnalogInputOffset")
  setAnalogInputOffset: SetAnalogInputOffset @action(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:SetAnalogInputOffset")
  getAnalogInputGradient: GetAnalogInputGradient @action(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:GetAnalogInputGradient")
  setAnalogInputGradient: SetAnalogInputGradient @action(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:SetAnalogInputGradient")
  getSupplyVoltageStatus: GetSupplyVoltageStatus @action(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:GetSupplyVoltageStatus")
  setDALIcommand: SetDALIcommand @action(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:SetDALIcommand")
  getDALIanswer: GetDALIanswer @action(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:action:GetDALIanswer")
}

    # Device Model definition (abstract device)
    type
type DALILightController @deviceModel(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:deviceModel:DALILightController", capability: "urn:tdm:aws/examples/modbus/deuta/dalibridge:capability:DALILightControllerCapability") {
  ignore: void
}

    # Device definition (physical device)
query ModbusDALILightController @device(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:device:ModbusDALILightController", deviceModel: "urn:tdm:aws/examples/modbus/deuta/dalibridge:deviceModel:DALILightController") {
  Modbus(ServerId: "1") {
    Capability(id: "urn:tdm:aws/examples/modbus/deuta/dalibridge:capability:DALILightControllerCapability") {
      Action(name: "getMainVersion_HW") {
        Params
        ReadHoldingRegisters {
          Request(Address: 2, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Int16")
          }
        }
      }
      Action(name: "getSubVersion_HW") {
        Params
        ReadHoldingRegisters {
          Request(Address: 3, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Int16")
          }
        }
      }
      Action(name: "getMainVersion_SW") {
        Params
        ReadHoldingRegisters {
          Request(Address: 4, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Int16")
          }
        }
      }
      Action(name: "getSubVersion_SW") {
        Params
        ReadHoldingRegisters {
          Request(Address: 5, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Int16")
          }
        }
      }
      Action(name: "getSerialNumber_LSB") {
        Params
        ReadHoldingRegisters {
          Request(Address: 6, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Int16")
          }
        }
      }
      Action(name: "getSerialNumber_MSB") {
        Params
        ReadHoldingRegisters {
          Request(Address: 7, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Int16")
          }
        }
      }
      Action(name: "getAnalogInputVoltage") {
        Params
        ReadHoldingRegisters {
          Request(Address: 24, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Int16")
          }
        }
      }
      Action(name: "getAnalogInputPercent") {
        Params
        ReadHoldingRegisters {
          Request(Address: 25, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Int16")
          }
        }
      }
      Action(name: "getDigitalThresholdValue_low") {
        Params
        ReadHoldingRegisters {
          Request(Address: 26, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Int16")
          }
        }
      }
      Action(name: "setDigitalThresholdValue_low") {
        Params {
          param(name: "inputDigitalThresholdValue", property: "urn:tdm:aws:Property:Int16")
        }
        WriteSingleRegister {
          Request(Address: 26) {
            params {
              param(name: "inputDigitalThresholdValue", property: "urn:tdm:aws:Property:Int16", value: "${inputDigitalThresholdValue.value}")
            }
          }
        }
      }
      Action(name: "getDigitalThresholdValue_high") {
        Params
        ReadHoldingRegisters {
          Request(Address: 27, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Int16")
          }
        }
      }
      Action(name: "setDigitalThresholdValue_high") {
        Params {
          param(name: "inputDigitalThresholdValue", property: "urn:tdm:aws:Property:Int16")
        }
        WriteSingleRegister {
          Request(Address: 27) {
            params {
              param(name: "inputDigitalThresholdValue", property: "urn:tdm:aws:Property:Int16", value: "${inputDigitalThresholdValue.value}")
            }
          }
        }
      }
      Action(name: "getDigitalInput") {
        Params
        ReadHoldingRegisters {
          Request(Address: 28, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Int16")
          }
        }
      }
      Action(name: "getDigitalOutputTemp") {
        Params
        ReadHoldingRegisters {
          Request(Address: 29, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Int16")
          }
        }
      }
      Action(name: "setDigitalOutputTemp") {
        Params {
          param(name: "inputDigitalOutputTemp", property: "urn:tdm:aws:Property:Int16")
        }
        WriteSingleRegister {
          Request(Address: 29) {
            params {
              param(name: "inputDigitalOutputTemp", property: "urn:tdm:aws:Property:Int16", value: "${inputDigitalOutputTemp.value}")
            }
          }
        }
      }
      Action(name: "getDigitalOutputRemanent") {
        Params
        ReadHoldingRegisters {
          Request(Address: 30, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Int16")
          }
        }
      }
      Action(name: "setDigitalOutputRemanent") {
        Params {
          param(name: "inputDigitalOutputRemanent", property: "urn:tdm:aws:Property:Int16")
        }
        WriteSingleRegister {
          Request(Address: 30) {
            params {
              param(name: "inputDigitalOutputRemanent", property: "urn:tdm:aws:Property:Int16", value: "${inputDigitalOutputRemanent.value}")
            }
          }
        }
      }
      Action(name: "getChipTemperature") {
        Params
        ReadHoldingRegisters {
          Request(Address: 31, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Int16")
          }
        }
      }
      Action(name: "getAnalogInputOffset") {
        Params
        ReadHoldingRegisters {
          Request(Address: 32, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Int16")
          }
        }
      }
      Action(name: "setAnalogInputOffset") {
        Params {
          param(name: "inputAnalogInputOffset", property: "urn:tdm:aws:Property:Int16")
        }
        WriteSingleRegister {
          Request(Address: 32) {
            params {
              param(name: "inputAnalogInputOffset", property: "urn:tdm:aws:Property:Int16", value: "${inputAnalogInputOffset.value}")
            }
          }
        }
      }
      Action(name: "getAnalogInputGradient") {
        Params
        ReadHoldingRegisters {
          Request(Address: 33, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Int16")
          }
        }
      }
      Action(name: "setAnalogInputGradient") {
        Params {
          param(name: "inputAnalogInputGradient", property: "urn:tdm:aws:Property:Int16")
        }
        WriteSingleRegister {
          Request(Address: 33) {
            params {
              param(name: "inputAnalogInputGradient", property: "urn:tdm:aws:Property:Int16", value: "${inputAnalogInputGradient.value}")
            }
          }
        }
      }
      Action(name: "getSupplyVoltageStatus") {
        Params
        ReadHoldingRegisters {
          Request(Address: 34, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Int16")
          }
        }
      }
      Action(name: "setDALIcommand") {
        Params {
          param(name: "inputCommand", property: "urn:tdm:aws:Property:Int16")
        }
        WriteSingleRegister {
          Request(Address: 1001) {
            params {
              param(name: "inputCommand", property: "urn:tdm:aws:Property:Int16", value: "${inputCommand.value}")
            }
          }
        }
      }
      Action(name: "getDALIanswer") {
        Params
        ReadHoldingRegisters {
          Request(Address: 2001, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Int16")
          }
        }
      }
    }
  }
}
}
```