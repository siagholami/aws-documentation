--------

--------

# HW Group Damocles Mini<a name="iot-tg-examples-damocles"></a>

The following GraphQL shows the device definition for the [HW Group Damocles Mini](https://www.hw-group.com/support/modbustcp-in-poseidon2-and-damocles2-family)\. This device connects to water, gas, electrical, or other meters, and you can use it in a variety of monitoring scenarios \(such as remote equipment monitoring and security and surveillance systems\)\. 

For more information about how to create a Modbus device model, see [Modbus Device Modeling 101](iot-tg-models-mod101.html)\. That topic explains how to translate details from the [product specification](https://www.hw-group.com/support/modbustcp-in-poseidon2-and-damocles2-family) into the device definition\.

```
{
    # Name: Damocles2 MINI
    # Manufacturer: HW Group
    # Model: Damocles2 MINI
    
    # Action definitions
type GetBoolean @actionType(id: "urn:tdm:aws/examples/modbus/hwgroup/damocles2mini:action:GetBoolean") {
  return: Boolean @property(id: "urn:tdm:aws:Property:Boolean")
}

type SetBoolean @actionType(id: "urn:tdm:aws/examples/modbus/hwgroup/damocles2mini:action:SetBoolean") {
  inputBoolean: Boolean @property(id: "urn:tdm:aws:Property:Boolean")
}

type GetInputCounter @actionType(id: "urn:tdm:aws/examples/modbus/hwgroup/damocles2mini:action:GetInputCounter") {
  return: InputCounter @property(id: "urn:tdm:aws:Property:Int32")
}

type SetInputCounter @actionType(id: "urn:tdm:aws/examples/modbus/hwgroup/damocles2mini:action:SetInputCounter") {
  inputCounterValue: InputCounter @property(id: "urn:tdm:aws:Property:Int32")
}

    # Capability definition
type DamoclesMiniCapability @capabilityType(id: "urn:tdm:aws/examples/modbus/hwgroup/damocles2mini:capability:DamoclesMiniCapability") {
  getDiscreteInput1Value: GetBoolean @action(id: "urn:tdm:aws/examples/modbus/hwgroup/damocles2mini:action:GetBoolean")
  getDiscreteInput2Value: GetBoolean @action(id: "urn:tdm:aws/examples/modbus/hwgroup/damocles2mini:action:GetBoolean")
  getDiscreteInput3Value: GetBoolean @action(id: "urn:tdm:aws/examples/modbus/hwgroup/damocles2mini:action:GetBoolean")
  getDiscreteInput4Value: GetBoolean @action(id: "urn:tdm:aws/examples/modbus/hwgroup/damocles2mini:action:GetBoolean")
  getOutput1Value: GetBoolean @action(id: "urn:tdm:aws/examples/modbus/hwgroup/damocles2mini:action:GetBoolean")
  setOutput1Value: SetBoolean @action(id: "urn:tdm:aws/examples/modbus/hwgroup/damocles2mini:action:SetBoolean")
  getOutput2Value: GetBoolean @action(id: "urn:tdm:aws/examples/modbus/hwgroup/damocles2mini:action:GetBoolean")
  setOutput2Value: SetBoolean @action(id: "urn:tdm:aws/examples/modbus/hwgroup/damocles2mini:action:SetBoolean")
  getInput1Counter: GetInputCounter @action(id: "urn:tdm:aws/examples/modbus/hwgroup/damocles2mini:action:GetInputCounter")
  setInput1Counter: SetInputCounter @action(id: "urn:tdm:aws/examples/modbus/hwgroup/damocles2mini:action:SetInputCounter")
  getInput2Counter: GetInputCounter @action(id: "urn:tdm:aws/examples/modbus/hwgroup/damocles2mini:action:GetInputCounter")
  setInput2Counter: SetInputCounter @action(id: "urn:tdm:aws/examples/modbus/hwgroup/damocles2mini:action:SetInputCounter")
  getInput3Counter: GetInputCounter @action(id: "urn:tdm:aws/examples/modbus/hwgroup/damocles2mini:action:GetInputCounter")
  setInput3Counter: SetInputCounter @action(id: "urn:tdm:aws/examples/modbus/hwgroup/damocles2mini:action:SetInputCounter")
  getInput4Counter: GetInputCounter @action(id: "urn:tdm:aws/examples/modbus/hwgroup/damocles2mini:action:GetInputCounter")
  setInput4Counter: SetInputCounter @action(id: "urn:tdm:aws/examples/modbus/hwgroup/damocles2mini:action:SetInputCounter")
}

    # Device Model definition (abstract device)
type DamoclesMini @deviceModel(id: "urn:tdm:aws/examples/modbus/hwgroup/damocles2mini:deviceModel:DamoclesMini", capability: "urn:tdm:aws/examples/modbus/hwgroup/damocles2mini:capability:DamoclesMiniCapability") {
  ignore: void
}

    # Modbus RTU
    # Device definition (physical device)
query ModbusDamoclesMini @device(id: "urn:tdm:aws/examples/modbus/hwgroup/damocles2mini:device:ModbusDamoclesMini", deviceModel: "urn:tdm:aws/examples/modbus/hwgroup/damocles2mini:deviceModel:DamoclesMini") {
  Modbus(ServerId: "1") {
    Capability(id: "urn:tdm:aws/examples/modbus/hwgroup/damocles2mini:capability:DamoclesMiniCapability") {
      Action(name: "getDiscreteInput1Value") {
        Params
        ReadDiscreteInputs {
          Request(Address: 100, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Boolean")
          }
        }
      }
      Action(name: "getDiscreteInput2Value") {
        Params
        ReadDiscreteInputs {
          Request(Address: 101, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Boolean")
          }
        }
      }
      Action(name: "getDiscreteInput3Value") {
        Params
        ReadDiscreteInputs {
          Request(Address: 102, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Boolean")
          }
        }
      }
      Action(name: "getDiscreteInput4Value") {
        Params
        ReadDiscreteInputs {
          Request(Address: 103, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Boolean")
          }
        }
      }
      Action(name: "getOutput1Value") {
        Params
        ReadCoils {
          Request(Address: 200, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Boolean")
          }
        }
      }
      Action(name: "setOutput1Value") {
        Params {
          param(name: "inputBoolean", property: "urn:tdm:aws:Property:Boolean")
        }
        WriteSingleCoil {
          Request(Address: 200) {
            params {
              param(name: "inputBoolean", property: "urn:tdm:aws:Property:Boolean", value: "${inputBoolean.value}")
            }
          }
        }
      }
      Action(name: "getOutput2Value") {
        Params
        ReadCoils {
          Request(Address: 201, ReadCount: 1)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Boolean")
          }
        }
      }
      Action(name: "setOutput2Value") {
        Params {
          param(name: "inputBoolean", property: "urn:tdm:aws:Property:Boolean")
        }
        WriteSingleCoil {
          Request(Address: 201) {
            params {
              param(name: "inputBoolean", property: "urn:tdm:aws:Property:Boolean", value: "${inputBoolean.value}")
            }
          }
        }
      }
      Action(name: "getInput1Counter") {
        Params
        ReadInputRegisters {
          Request(Address: 201, ReadCount: 2)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Int32")
          }
        }
      }
      Action(name: "setInput1Counter") {
        Params {
          param(name: "inputCounterValue", property: "urn:tdm:aws:Property:Int32")
        }
        WriteMultipleRegisters {
          Request(Address: 201, WriteCount: 2) {
            params {
              param(name: "inputCounterValue", property: "urn:tdm:aws:Property:Int32", value: "${inputCounterValue.value}")
            }
          }
        }
      }
      Action(name: "getInput2Counter") {
        Params
        ReadInputRegisters {
          Request(Address: 203, ReadCount: 2)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Int32")
          }
        }
      }
      Action(name: "setInput2Counter") {
        Params {
          param(name: "inputCounterValue", property: "urn:tdm:aws:Property:Int32")
        }
        WriteMultipleRegisters {
          Request(Address: 203, WriteCount: 2) {
            params {
              param(name: "inputCounterValue", property: "urn:tdm:aws:Property:Int32", value: "${inputCounterValue.value}")
            }
          }
        }
      }
      Action(name: "getInput3Counter") {
        Params
        ReadInputRegisters {
          Request(Address: 205, ReadCount: 2)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Int32")
          }
        }
      }
      Action(name: "setInput3Counter") {
        Params {
          param(name: "inputCounterValue", property: "urn:tdm:aws:Property:Int32")
        }
        WriteMultipleRegisters {
          Request(Address: 205, WriteCount: 2) {
            params {
              param(name: "inputCounterValue", property: "urn:tdm:aws:Property:Int32", value: "${inputCounterValue.value}")
            }
          }
        }
      }
      Action(name: "getInput4Counter") {
        Params
        ReadInputRegisters {
          Request(Address: 207, ReadCount: 2)
          Response {
            responsePayload(property: "urn:tdm:aws:Property:Int32")
          }
        }
      }
      Action(name: "setInput4Counter") {
        Params {
          param(name: "inputCounterValue", property: "urn:tdm:aws:Property:Int32")
        }
        WriteMultipleRegisters {
          Request(Address: 207, WriteCount: 2) {
            params {
              param(name: "inputCounterValue", property: "urn:tdm:aws:Property:Int32", value: "${inputCounterValue.value}")
            }
          }
        }
      }
    }
  }
}
}
```