--------

--------

# CoolAutomation CoolMasterNet<a name="iot-tg-examples-coolmaster"></a>

The following GraphQL shows the device definition for the [CoolAutomation CoolMasterNet](http://coolautomation.com/lib/doc/manual/Modbus-guidelines.pdf)\. This device is a communication bridge that connects home automation systems with heating, ventilation, and air conditioning systems\. Therefore, this device definition is just a template\. You can rename the actions based on the resources of the device that's connected to the bridge\. 

For more information about how to create a Modbus device model, see [Modbus Device Modeling 101](iot-tg-models-mod101.html)\. That topic explains how to translate details from the [product specification](http://coolautomation.com/lib/doc/manual/Modbus-guidelines.pdf) into the device definition\.

The CoolmasterNet uses virtual addresses \(VAs\)\. In this definition, the register addresses are examples\. You must update them to reflect your own VA configuration\. For more information, see the *VA's Configuration* section in the [product specification](http://coolautomation.com/lib/doc/manual/Modbus-guidelines.pdf)\.

```
{
    # Manufacturer: Cool Automation
    # Model: CoolMasterNet

    # Action definitions
type GetOperationMode @actionType(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetOperationMode") {
  return: OperationMode @property(id: "urn:tdm:aws:Property:Int16")
}

type SetOperationMode @actionType(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:SetOperationMode") {
  inputOperationMode: OperationMode @property(id: "urn:tdm:aws:Property:Int16")
}

type GetFanSpeed @actionType(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetFanSpeed") {
  return: FanSpeed @property(id: "urn:tdm:aws:Property:Int16")
}

type SetFanSpeed @actionType(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:SetFanSpeed") {
  inputFanSpeed: FanSpeed @property(id: "urn:tdm:aws:Property:Int16")
}

type SetTemperature @actionType(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:SetTemperature") {
  inputTemperature: Temperature @property(id: "urn:tdm:aws:Property:Int16")
}

type GetTemperatureSetting @actionType(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetTemperatureSetting") {
  return: Temperature @property(id: "urn:tdm:aws:Property:Int16")
}

type GetRoomTemperature @actionType(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetRoomTemperature") {
  return: Temperature @property(id: "urn:tdm:aws:Property:Int16")
}

type GetSwitchState_H @actionType(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetSwitchState_H") {
  return: SwitchOnOff_H @property(id: "urn:tdm:aws:Property:Int16")
}

type SetSwitchState_H @actionType(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:SetSwitchState_H") {
  inputSwitchOnOff_H: SwitchOnOff_H @property(id: "urn:tdm:aws:Property:Int16")
}

type GetSwitchState_C @actionType(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetSwitchState_C") {
  return: SwitchOnOff_C @property(id: "urn:tdm:aws:Property:Boolean")
}

type SetSwitchState_C @actionType(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:SetSwitchState_C") {
  inputSwitchOnOff_C: SwitchOnOff_C @property(id: "urn:tdm:aws:Property:Boolean")
}

type GetSwingSetting @actionType(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetSwingSetting") {
  return: SwingSetting @property(id: "urn:tdm:aws:Property:Int16")
}

type SetSwingSetting @actionType(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:SetSwingSetting") {
  inputSwingSetting: SwingSetting @property(id: "urn:tdm:aws:Property:Int16")
}

type GetFilterSign_H @actionType(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetFilterSign_H") {
  return: FilterSign_H @property(id: "urn:tdm:aws:Property:Int16")
}

type SetFilterSign_H @actionType(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:SetFilterSign_H") {
  inputFilterSign_H: FilterSign_H @property(id: "urn:tdm:aws:Property:Int16")
}

type GetFilterSign_C @actionType(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetFilterSign_C") {
  return: FilterSign_C @property(id: "urn:tdm:aws:Property:Boolean")
}

type SetFilterSign_C @actionType(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:SetFilterSign_C") {
  inputFilterSign_C: FilterSign_C @property(id: "urn:tdm:aws:Property:Boolean")
}

type GetExternalTerminalsStatus @actionType(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetExternalTerminalsStatus") {
  return: ExternalTerminalsStatus @property(id: "urn:tdm:aws:Property:Boolean")
}

type GetInhibitIndoorUnitOnOperationSetting @actionType(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetInhibitIndoorUnitOnOperationSetting") {
  return: InhibitIndoorUnitOnOperationSetting @property(id: "urn:tdm:aws:Property:Boolean")
}

type SetInhibitIndoorUnitOnOperationSetting @actionType(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:SetInhibitIndoorUnitOnOperationSetting") {
  inputInhibitIndoorUnitOnOperationSetting: InhibitIndoorUnitOnOperationSetting @property(id: "urn:tdm:aws:Property:Int16")
}

type GetAnalogInput1 @actionType(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetAnalogInput1") {
  return: AnalogInput1 @property(id: "urn:tdm:aws:Property:Int16")
}

type GetAnalogInput2 @actionType(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetAnalogInput2") {
  return: AnalogInput2 @property(id: "urn:tdm:aws:Property:Int16")
}

type GetDigitalOutput1 @actionType(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetDigitalOutput1") {
  return: DigitalOutput1 @property(id: "urn:tdm:aws:Property:Boolean")
}

type GetDigitalOutput2 @actionType(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetDigitalOutput2") {
  return: DigitalOutput2 @property(id: "urn:tdm:aws:Property:Boolean")
}

type GetDigitalOutput3 @actionType(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetDigitalOutput3") {
  return: DigitalOutput3 @property(id: "urn:tdm:aws:Property:Boolean")
}

type GetDigitalOutput4 @actionType(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetDigitalOutput4") {
  return: DigitalOutput4 @property(id: "urn:tdm:aws:Property:Boolean")
}

type GetDigitalOutput5 @actionType(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetDigitalOutput5") {
  return: DigitalOutput5 @property(id: "urn:tdm:aws:Property:Boolean")
}

type GetDigitalOutput6 @actionType(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetDigitalOutput6") {
  return: DigitalOutput6 @property(id: "urn:tdm:aws:Property:Boolean")
}

type SetDigitalOutput1 @actionType(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:SetDigitalOutput1") {
  inputDigitalOutput1: DigitalOutput1 @property(id: "urn:tdm:aws:Property:Boolean")
}

type SetDigitalOutput2 @actionType(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:SetDigitalOutput2") {
  inputDigitalOutput2: DigitalOutput2 @property(id: "urn:tdm:aws:Property:Boolean")
}

type SetDigitalOutput3 @actionType(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:SetDigitalOutput3") {
  inputDigitalOutput3: DigitalOutput3 @property(id: "urn:tdm:aws:Property:Boolean")
}

type SetDigitalOutput4 @actionType(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:SetDigitalOutput4") {
  inputDigitalOutput4: DigitalOutput4 @property(id: "urn:tdm:aws:Property:Boolean")
}

type SetDigitalOutput5 @actionType(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:SetDigitalOutput5") {
  inputDigitalOutput5: DigitalOutput5 @property(id: "urn:tdm:aws:Property:Boolean")
}

type SetDigitalOutput6 @actionType(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:SetDigitalOutput6") {
  inputDigitalOutput6: DigitalOutput6 @property(id: "urn:tdm:aws:Property:Boolean")
}

type GetDigitalInput @actionType(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetDigitalInput") {
  return: DigitalInput @property(id: "urn:tdm:aws:Property:Boolean")
}


    # Capability definition
type CoolMasterNetCapability @capabilityType(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:capability:CoolMasterNetCapability") {
  getOperationMode: GetOperationMode @action(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetOperationMode")
  setOperationMode: SetOperationMode @action(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:SetOperationMode")
  getFanSpeed: GetFanSpeed @action(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetFanSpeed")
  setFanSpeed: SetFanSpeed @action(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:SetFanSpeed")
  setTemperature: SetTemperature @action(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:SetTemperature")
  getTemperatureSetting: GetTemperatureSetting @action(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetTemperatureSetting")
  getRoomTemperature_H: GetRoomTemperature @action(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetRoomTemperature")
  getRoomTemperature_I: GetRoomTemperature @action(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetRoomTemperature")
  getSwitchState_H: GetSwitchState_H @action(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetSwitchState_H")
  setSwitchState_H: SetSwitchState_H @action(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:SetSwitchState_H")
  getSwitchState_C: GetSwitchState_C @action(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetSwitchState_C")
  setSwitchState_C: SetSwitchState_C @action(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:SetSwitchState_C")
  getSwingSetting: GetSwingSetting @action(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetSwingSetting")
  setSwingSetting: SetSwingSetting @action(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:SetSwingSetting")
  getFilterSign_H: GetFilterSign_H @action(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetFilterSign_H")
  setFilterSign_H: SetFilterSign_H @action(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:SetFilterSign_H")
  getFilterSign_C: GetFilterSign_C @action(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetFilterSign_C")
  setFilterSign_C: SetFilterSign_C @action(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:SetFilterSign_C")
  getExternalTerminalsStatus: GetExternalTerminalsStatus @action(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetExternalTerminalsStatus")
  getInhibitIndoorUnitOnOperationSetting: GetInhibitIndoorUnitOnOperationSetting @action(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetInhibitIndoorUnitOnOperationSetting")
  setInhibitIndoorUnitOnOperationSetting: SetInhibitIndoorUnitOnOperationSetting @action(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:SetInhibitIndoorUnitOnOperationSetting")
  getAnalogInput1: GetAnalogInput1 @action(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetAnalogInput1")
  getAnalogInput2: GetAnalogInput2 @action(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetAnalogInput2")
  getDigitalOutput1: GetDigitalOutput1 @action(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetDigitalOutput1")
  getDigitalOutput2: GetDigitalOutput2 @action(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetDigitalOutput2")
  getDigitalOutput3: GetDigitalOutput3 @action(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetDigitalOutput3")
  getDigitalOutput4: GetDigitalOutput4 @action(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetDigitalOutput4")
  getDigitalOutput5: GetDigitalOutput5 @action(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetDigitalOutput5")
  getDigitalOutput6: GetDigitalOutput6 @action(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetDigitalOutput6")
  setDigitalOutput1: SetDigitalOutput1 @action(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:SetDigitalOutput1")
  setDigitalOutput2: SetDigitalOutput2 @action(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:SetDigitalOutput2")
  setDigitalOutput3: SetDigitalOutput3 @action(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:SetDigitalOutput3")
  setDigitalOutput4: SetDigitalOutput4 @action(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:SetDigitalOutput4")
  setDigitalOutput5: SetDigitalOutput5 @action(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:SetDigitalOutput5")
  setDigitalOutput6: SetDigitalOutput6 @action(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:SetDigitalOutput6")
  getDigitalInput1: GetDigitalInput @action(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetDigitalInput")
  getDigitalInput2: GetDigitalInput @action(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetDigitalInput")
  getDigitalInput3: GetDigitalInput @action(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetDigitalInput")
  getDigitalInput4: GetDigitalInput @action(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetDigitalInput")
  getDigitalInput5: GetDigitalInput @action(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetDigitalInput")
  getDigitalInput6: GetDigitalInput @action(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:action:GetDigitalInput")
}

    # Device Model definition (abstract device)
type CoolMasterNet @deviceModel(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:deviceModel:CoolMasterNet", capability: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:capability:CoolMasterNetCapability") {
  ignore: void
}

    # Modbus RTU
    # Device definition (physical device)
query ModbusCoolMasterNet @device(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:device:ModbusCoolMasterNet", deviceModel: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:deviceModel:CoolMasterNet") {
  Modbus(ServerId: "1") {
    Capability(id: "urn:tdm:aws/examples/modbus/coolautomation/coolmasternet:capability:CoolMasterNetCapability") {
      Action(name: "getOperationMode") {
        Params
        ReadHoldingRegisters {
          Request(Address: 0, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Int16")
          }
        }
      }
      Action(name: "setOperationMode") {
        Params {
          param(name: "inputOperationMode", property: "urn:tdm:aws:Property:Int16")
        }
        WriteSingleRegister {
          Request(Address: 0) {
            params {
              param(name: "inputOperationMode", property: "urn:tdm:aws:Property:Int16", value: "${inputOperationMode.value}")
            }
          }
        }
      }
      Action(name: "getFanSpeed") {
        Params
        ReadHoldingRegisters {
          Request(Address: 1, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Int16")
          }
        }
      }
      Action(name: "setFanSpeed") {
        Params {
          param(name: "inputFanSpeed", property: "urn:tdm:aws:Property:Int16")
        }
        WriteSingleRegister {
          Request(Address: 1) {
            params {
              param(name: "inputFanSpeed", property: "urn:tdm:aws:Property:Int16", value: "${inputFanSpeed.value}")
            }
          }
        }
      }
      Action(name: "setTemperature") {
        Params {
          param(name: "inputTemperature", property: "urn:tdm:aws:Property:Int16")
        }
        WriteSingleRegister {
          Request(Address: 2) {
            params {
              param(name: "inputTemperature", property: "urn:tdm:aws:Property:Int16", value: "${inputTemperature.value}")
            }
          }
        }
      }
      Action(name: "getTemperatureSetting") {
        Params
        ReadHoldingRegisters {
          Request(Address: 2, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Int16")
          }
        }
      }
      Action(name: "getRoomTemperature_H") {
        Params
        ReadHoldingRegisters {
          Request(Address: 6, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Int16")
          }
        }
      }
      Action(name: "getRoomTemperature_I") {
        Params
        ReadInputRegisters {
          Request(Address: 1, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Int16")
          }
        }
      }
      Action(name: "getSwitchState_H") {
        Params
        ReadHoldingRegisters {
          Request(Address: 3, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Int16")
          }
        }
      }
      Action(name: "setSwitchState_H") {
        Params {
          param(name: "inputSwitchOnOff_H", property: "urn:tdm:aws:Property:Int16")
        }
        WriteSingleRegister {
          Request(Address: 3) {
            params {
              param(name: "inputSwitchOnOff_H", property: "urn:tdm:aws:Property:Int16", value: "${inputSwitchOnOff_H.value}")
            }
          }
        }
      }
      Action(name: "getSwitchState_C") {
        Params
        ReadCoils {
          Request(Address: 0, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Boolean")
          }
        }
      }
      Action(name: "setSwitchState_C") {
        Params {
          param(name: "inputSwitchOnOff_C", property: "urn:tdm:aws:Property:Boolean")
        }
        WriteSingleCoil {
          Request(Address: 0) {
            params {
              param(name: "inputSwitchOnOff_C", property: "urn:tdm:aws:Property:Boolean", value: "${inputSwitchOnOff_C.value}")
            }
          }
        }
      }
      Action(name: "getSwingSetting") {
        Params
        ReadHoldingRegisters {
          Request(Address: 5, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Int16")
          }
        }
      }
      Action(name: "setSwingSetting") {
        Params {
          param(name: "inputSwingSetting", property: "urn:tdm:aws:Property:Int16")
        }
        WriteSingleRegister {
          Request(Address: 5) {
            params {
              param(name: "inputSwingSetting", property: "urn:tdm:aws:Property:Int16", value: "${inputSwingSetting.value}")
            }
          }
        }
      }
      Action(name: "getFilterSign_H") {
        Params
        ReadHoldingRegisters {
          Request(Address: 4, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Int16")
          }
        }
      }
      Action(name: "setFilterSign_H") {
        Params {
          param(name: "inputFilterSign_H", property: "urn:tdm:aws:Property:Int16")
        }
        WriteSingleRegister {
          Request(Address: 4) {
            params {
              param(name: "inputFilterSign_H", property: "urn:tdm:aws:Property:Int16", value: "${inputFilterSign_H.value}")
            }
          }
        }
      }
      Action(name: "getFilterSign_C") {
        Params
        ReadCoils {
          Request(Address: 1, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Boolean")
          }
        }
      }
      Action(name: "setFilterSign_C") {
        Params {
          param(name: "inputFilterSign_C", property: "urn:tdm:aws:Property:Boolean")
        }
        WriteSingleCoil {
          Request(Address: 1) {
            params {
              param(name: "inputFilterSign_C", property: "urn:tdm:aws:Property:Boolean", value: "${inputFilterSign_C.value}")
            }
          }
        }
      }
      Action(name: "getExternalTerminalsStatus") {
        Params
        ReadCoils {
          Request(Address: 2, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Boolean")
          }
        }
      }
      Action(name: "getInhibitIndoorUnitOnOperationSetting") {
        Params
        ReadCoils {
          Request(Address: 3, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Boolean")
          }
        }
      }
      Action(name: "setInhibitIndoorUnitOnOperationSetting") {
        Params {
          param(name: "inputInhibitIndoorUnitOnOperationSetting", property: "urn:tdm:aws:Property:Int16")
        }
        WriteSingleCoil {
          Request(Address: 3) {
            params {
              param(name: "inputInhibitIndoorUnitOnOperationSetting", property: "urn:tdm:aws:Property:Int16", value: "${inputInhibitIndoorUnitOnOperationSetting.value}")
            }
          }
        }
      }
      Action(name: "getAnalogInput1") {
        Params
        ReadInputRegisters {
          Request(Address: 13, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Int16")
          }
        }
      }
      Action(name: "getAnalogInput2") {
        Params
        ReadInputRegisters {
          Request(Address: 14, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Int16")
          }
        }
      }
      Action(name: "getDigitalOutput1") {
        Params
        ReadCoils {
          Request(Address: 9, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Boolean")
          }
        }
      }
      Action(name: "getDigitalOutput2") {
        Params
        ReadCoils {
          Request(Address: 10, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Boolean")
          }
        }
      }
      Action(name: "getDigitalOutput3") {
        Params
        ReadCoils {
          Request(Address: 11, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Boolean")
          }
        }
      }
      Action(name: "getDigitalOutput4") {
        Params
        ReadCoils {
          Request(Address: 12, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Boolean")
          }
        }
      }
      Action(name: "getDigitalOutput5") {
        Params
        ReadCoils {
          Request(Address: 13, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Boolean")
          }
        }
      }
      Action(name: "getDigitalOutput6") {
        Params
        ReadCoils {
          Request(Address: 14, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Boolean")
          }
        }
      }
      Action(name: "setDigitalOutput1") {
        Params {
          param(name: "inputDigitalOutput1", property: "urn:tdm:aws:Property:Boolean")
        }
        WriteSingleCoil {
          Request(Address: 9) {
            params {
              param(name: "inputDigitalOutput1", property: "urn:tdm:aws:Property:Boolean", value: "${inputDigitalOutput1.value}")
            }
          }
        }
      }
      Action(name: "setDigitalOutput2") {
        Params {
          param(name: "inputDigitalOutput2", property: "urn:tdm:aws:Property:Boolean")
        }
        WriteSingleCoil {
          Request(Address: 10) {
            params {
              param(name: "inputDigitalOutput2", property: "urn:tdm:aws:Property:Boolean", value: "${inputDigitalOutput2.value}")
            }
          }
        }
      }
      Action(name: "setDigitalOutput3") {
        Params {
          param(name: "inputDigitalOutput3", property: "urn:tdm:aws:Property:Boolean")
        }
        WriteSingleCoil {
          Request(Address: 11) {
            params {
              param(name: "inputDigitalOutput3", property: "urn:tdm:aws:Property:Boolean", value: "${inputDigitalOutput3.value}")
            }
          }
        }
      }
      Action(name: "setDigitalOutput4") {
        Params {
          param(name: "inputDigitalOutput4", property: "urn:tdm:aws:Property:Boolean")
        }
        WriteSingleCoil {
          Request(Address: 12) {
            params {
              param(name: "inputDigitalOutput4", property: "urn:tdm:aws:Property:Boolean", value: "${inputDigitalOutput4.value}")
            }
          }
        }
      }
      Action(name: "setDigitalOutput5") {
        Params {
          param(name: "inputDigitalOutput5", property: "urn:tdm:aws:Property:Boolean")
        }
        WriteSingleCoil {
          Request(Address: 13) {
            params {
              param(name: "inputDigitalOutput5", property: "urn:tdm:aws:Property:Boolean", value: "${inputDigitalOutput5.value}")
            }
          }
        }
      }
      Action(name: "setDigitalOutput6") {
        Params {
          param(name: "inputDigitalOutput6", property: "urn:tdm:aws:Property:Boolean")
        }
        WriteSingleCoil {
          Request(Address: 14) {
            params {
              param(name: "inputDigitalOutput6", property: "urn:tdm:aws:Property:Boolean", value: "${inputDigitalOutput6.value}")
            }
          }
        }
      }
      Action(name: "getDigitalInput1") {
        Params
        ReadDiscreteInputs {
          Request(Address: 9, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Boolean")
          }
        }
      }
      Action(name: "getDigitalInput2") {
        Params
        ReadDiscreteInputs {
          Request(Address: 10, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Boolean")
          }
        }
      }
      Action(name: "getDigitalInput3") {
        Params
        ReadDiscreteInputs {
          Request(Address: 11, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Boolean")
          }
        }
      }
      Action(name: "getDigitalInput4") {
        Params
        ReadDiscreteInputs {
          Request(Address: 12, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Boolean")
          }
        }
      }
      Action(name: "getDigitalInput5") {
        Params
        ReadDiscreteInputs {
          Request(Address: 13, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Boolean")
          }
        }
      }
      Action(name: "getDigitalInput6") {
        Params
        ReadDiscreteInputs {
          Request(Address: 14, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Boolean")
          }
        }
      }
    }
  }
}
}
```