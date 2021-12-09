# A commented example: HVAC temperature control<a name="iotevents-commented-example"></a>

Some of the following example JSON files have comments inline, which makes them invalid JSON\. Complete versions of these examples, without comments, are available at [HVAC temperature control](iotevents-examples-hvac.md)\.

## Background<a name="iotevents-commented-example-background"></a>

This example implements a thermostat control model that gives you the ability to do the following\.
+ Define just one detector model that can be used to monitor and control multiple areas\. A detector instance is created for each area\.
+ Ingest temperature data from multiple sensors in each control area\.
+ Change the temperature set point for an area\.
+ Set operational parameters for each area and reset these parameters while the instance is in use\.
+ Dynamically add or delete sensors from an area\.
+ Specify a minimum runtime to protect heating and cooling units\.
+ Reject anomalous sensor readings\.
+ Define emergency set points that immediately engage heating or cooling if any one sensor reports a temperature above or below a given threshold\.
+ Report anomalous readings and temperature spikes\.

### Input definitions<a name="iotevents-commented-example-inputs"></a>

We want to create one detector model that we can use to monitor and control the temperature in several different areas\. Each area can have several sensors that report the temperature\. We assume each area is served by one heating unit and one cooling unit that can be turned on or off to control the temperature in the area\. Each area is controlled by one detector instance\.

Because the different areas we monitor and control might have different characteristics that demand different control parameters, we define the `'seedTemperatureInput'` to provide those parameters for each area\. When we send one of these input messages to AWS IoT Events, a new detector model instance is created that has the parameters we want to use in that area\. Here's the definition of that input\.

CLI command:

```
aws iotevents create-input --cli-input-json file://seedInput.json
```

File: `seedInput.json`

```
{
  "inputName": "seedTemperatureInput",
  "inputDescription": "Temperature seed values.",
  "inputDefinition": {
    "attributes": [
      { "jsonPath": "areaId" },
      { "jsonPath": "desiredTemperature" },
      { "jsonPath": "allowedError" },
      { "jsonPath": "rangeHigh" },
      { "jsonPath": "rangeLow" },
      { "jsonPath": "anomalousHigh" },
      { "jsonPath": "anomalousLow" },
      { "jsonPath": "sensorCount" },
      { "jsonPath": "noDelay" }
    ]
  }
}
```

Response:

```
{
    "inputConfiguration": {
        "status": "ACTIVE", 
        "inputArn": "arn:aws:iotevents:us-west-2:123456789012:input/seedTemperatureInput", 
        "lastUpdateTime": 1557519620.736, 
        "creationTime": 1557519620.736, 
        "inputName": "seedTemperatureInput", 
        "inputDescription": "Temperature seed values."
    }
}
```

**Notes**
+ A new detector instance is created for each unique `'areaId'` received in any message\. See the `'key'` field in the `'areaDetectorModel'` definition\.
+ The average temperature can vary from the `'desiredTemperature'` by the `'allowedError'` before the heating or cooling units are activated for the area\.
+ If any sensor reports a temperature above the `'rangeHigh'`, the detector reports a spike and immediately starts the cooling unit\.
+ If any sensor reports a temperature below the `'rangeLow'`, the detector reports a spike and immediately starts the heating unit\.
+ If any sensor reports a temperature above the `'anomalousHigh'` or below the `'anomalousLow'`, the detector reports an anomalous sensor reading, but ignores the reported temperature reading\.
+ The `'sensorCount'` tells the detector how many sensors are reporting for the area\. The detector calculates the average temperature in the area by giving the appropriate weight factor to each temperature reading it receives\. Because of this, the detector won't have to keep track of what each sensor reports, and the number of sensors can be changed dynamically, as needed\. However, if an individual sensor goes offline, the detector won't know this or make allowances for it\. We recommend that you create another detector model specifically for monitoring the connection status of each sensor\. Having two complementary detector models simplifies the design of both\.
+ The `'noDelay'` value can be `true` or `false`\. After a heating or cooling unit is turned on, it should remain on for a certain minimum time to protect the integrity of the unit and lengthen its operating life\. If `'noDelay'` is set to `false`, the detector instance enforces a delay before it turns off the cooling and heating units, to ensure that they are run for the minimum time\. The number of seconds of delay has been hardcoded in the detector model definition because we are unable to use a variable value to set a timer\.

The `'temperatureInput'` is used to transmit sensor data to a detector instance\.

CLI command:

```
aws iotevents create-input --cli-input-json file://temperatureInput.json
```

File: `temperatureInput.json`

```
{
  "inputName": "temperatureInput",
  "inputDescription": "Temperature sensor unit data.",
  "inputDefinition": {
    "attributes": [
      { "jsonPath": "sensorId" },
      { "jsonPath": "areaId" },
      { "jsonPath": "sensorData.temperature" }
    ]
  }
}
```

Response:

```
{
    "inputConfiguration": {
        "status": "ACTIVE", 
        "inputArn": "arn:aws:iotevents:us-west-2:123456789012:input/temperatureInput", 
        "lastUpdateTime": 1557519707.399, 
        "creationTime": 1557519707.399, 
        "inputName": "temperatureInput", 
        "inputDescription": "Temperature sensor unit data."
    }
}
```

**Notes**
+ The `'sensorId'` isn't used by an example detector instance to control or monitor a sensor directly\. It's automatically passed into notifications sent by the detector instance\. From there, it can be used to identify the sensors that are failing \(for example, a sensor that regularly sends anomalous readings might be about to fail\), or that have gone offline \(when it's used as an input to an additional detector model that monitors the device's heartbeat\)\. The `'sensorId'` can also help identify warm or cold zones in an area if its readings regularly differ from the average\.
+ The `'areaId'` is used to route the sensor's data to the appropriate detector instance\. A detector instance is created for each unique `'areaId'` received in any message\. See the `'key'` field in the `'areaDetectorModel'` definition\.

### Detector model definition<a name="iotevents-commented-example-detector-model"></a>

The `'areaDetectorModel'` example has comments inline\.

CLI command:

```
aws iotevents create-detector-model --cli-input-json file://areaDetectorModel.json
```

File: `areaDetectorModel.json`

```
{
  "detectorModelName": "areaDetectorModel",
  "detectorModelDefinition": {
    "states": [
      {
        "stateName": "start",
        // In the 'start' state we set up the operation parameters of the new detector instance. 
        //   We get here when the first input message arrives. If that is a 'seedTemperatureInput' 
        //   message, we save the operation parameters, then transition to the 'idle' state. If 
        //   the first message is a 'temperatureInput', we wait here until we get a 
        //   'seedTemperatureInput' input to ensure our operation parameters are set. We can 
        //   also reenter this state using the 'BatchUpdateDetector' API. This enables us to
        //   reset the operation parameters without needing to delete the detector instance.
        "onEnter": {
          "events": [
            {
              "eventName": "prepare",
              "condition": "true",
              "actions": [
                {
                  "setVariable": {
                    // initialize 'sensorId' to an invalid value (0) until an actual sensor reading 
                    //   arrives
                    "variableName": "sensorId",
                    "value": "0"
                  }
                },
                {
                  "setVariable": {
                    // initialize 'reportedTemperature' to an invalid value (0.1) until an actual 
                    //   sensor reading arrives
                    "variableName": "reportedTemperature",
                    "value": "0.1"
                  }
                },
                {
                  "setVariable": {
                    // When using 'BatchUpdateDetector' to re-enter this state, this variable should 
                    //   be set to true.
                    "variableName": "resetMe",
                    "value": "false"
                  }
                }
              ]
            }
          ]
        },
        "onInput": {
          "transitionEvents": [
            {
              "eventName": "initialize",
              "condition": "$input.seedTemperatureInput.sensorCount > 0",
              // When a 'seedTemperatureInput' message with a valid 'sensorCount' is received,
              //   we use it to set the operational parameters for the area to be monitored.
              "actions": [
                { 
                  "setVariable": {
                    "variableName": "rangeHigh",
                    "value": "$input.seedTemperatureInput.rangeHigh"
                  }
                },
                { 
                  "setVariable": {
                    "variableName": "rangeLow",
                    "value": "$input.seedTemperatureInput.rangeLow"
                  }
                },
                { 
                  "setVariable": {
                    "variableName": "desiredTemperature",
                    "value": "$input.seedTemperatureInput.desiredTemperature"
                  }
                },
                { 
                  "setVariable": {
                    // Assume we're at the desired temperature when we start.
                    "variableName": "averageTemperature",
                    "value": "$input.seedTemperatureInput.desiredTemperature"
                  }
                },
                { 
                  "setVariable": {
                    "variableName": "allowedError",
                    "value": "$input.seedTemperatureInput.allowedError"
                  }
                },
                {
                  "setVariable": {
                    "variableName": "anomalousHigh",
                    "value": "$input.seedTemperatureInput.anomalousHigh"
                  }
                },
                {
                  "setVariable": {
                    "variableName": "anomalousLow",
                    "value": "$input.seedTemperatureInput.anomalousLow"
                  }
                },
                {
                  "setVariable": {
                    "variableName": "sensorCount",
                    "value": "$input.seedTemperatureInput.sensorCount"
                  }
                },
                {
                  "setVariable": {
                    "variableName": "noDelay",
                    "value": "$input.seedTemperatureInput.noDelay == true"
                  }
                }
              ],
              "nextState": "idle"
            },
            {
              "eventName": "reset",
              "condition": "($variable.resetMe == true) && ($input.temperatureInput.sensorData.temperature < $variable.anomalousHigh && $input.temperatureInput.sensorData.temperature > $variable.anomalousLow)",
              // This event is triggered if we have reentered the 'start' state using the 
              //   'BatchUpdateDetector' API with 'resetMe' set to true. When we reenter using
              //   'BatchUpdateDetector' we do not automatically continue to the 'idle' state, but
              //   wait in 'start' until the next input message arrives. This event enables us to 
              //   transition to 'idle' on the next valid 'temperatureInput' message that arrives.
              "actions": [
                {
                  "setVariable": {
                    "variableName": "averageTemperature",
                    "value": "((($variable.averageTemperature * ($variable.sensorCount - 1)) + $input.temperatureInput.sensorData.temperature) / $variable.sensorCount)"
                  }
                }
              ],
              "nextState": "idle"
            }
          ]
        },
        "onExit": {
          "events": [
            {
              "eventName": "resetHeatCool",
              "condition": "true",
              // Make sure the heating and cooling units are off before entering 'idle'.
              "actions": [
                {
                  "sns": {
                    "targetArn": "arn:aws:sns:us-west-2:123456789012:heatOff"
                  }
                },
                {
                  "sns": {
                    "targetArn": "arn:aws:sns:us-west-2:123456789012:coolOff"
                  }
                },
                {
                  "iotTopicPublish": {
                    "mqttTopic": "hvac/Heating/Off"
                  }
                },
                {
                  "iotTopicPublish": {
                    "mqttTopic": "hvac/Cooling/Off"
                  }
                }
              ]
            }
          ]
        }
      },


      {
        "stateName": "idle",
        "onInput": {
          "events": [
            {
              "eventName": "whatWasInput",
              "condition": "true",
              // By storing the 'sensorId' and the 'temperature' in variables, we make them 
              //   available in any messages we send out to report anomalies, spikes, or just
              //   if needed for debugging.
              "actions": [
                {
                  "setVariable": {
                    "variableName": "sensorId",
                    "value": "$input.temperatureInput.sensorId"
                  }
                },
                {
                  "setVariable": {
                    "variableName": "reportedTemperature",
                    "value": "$input.temperatureInput.sensorData.temperature"
                  }
                }
              ]
            },
            {
              "eventName": "changeDesired",
              "condition": "$input.seedTemperatureInput.desiredTemperature != $variable.desiredTemperature",
              // This event enables us to change the desired temperature at any time by sending a
              //   'seedTemperatureInput' message. But note that other operational parameters are not
              //   read or changed.
              "actions": [
                { 
                  "setVariable": {
                    "variableName": "desiredTemperature",
                    "value": "$input.seedTemperatureInput.desiredTemperature"
                  }
                }
              ]
            },
            {
              "eventName": "calculateAverage",
              "condition": "$input.temperatureInput.sensorData.temperature < $variable.anomalousHigh && $input.temperatureInput.sensorData.temperature > $variable.anomalousLow",
              // If a valid temperature reading arrives, we use it to update the average temperature.
              //   For simplicity, we assume our sensors will be sending updates at about the same rate,
              //   so we can calculate an approximate average by giving equal weight to each reading we receive.
              "actions": [
                {
                  "setVariable": {
                    "variableName": "averageTemperature",
                    "value": "((($variable.averageTemperature * ($variable.sensorCount - 1)) + $input.temperatureInput.sensorData.temperature) / $variable.sensorCount)"
                  }
                }
              ]
            }
          ],
          "transitionEvents": [
            {
              "eventName": "anomalousInputArrived",
              "condition": "$input.temperatureInput.sensorData.temperature >= $variable.anomalousHigh || $input.temperatureInput.sensorData.temperature <= $variable.anomalousLow",
              // When an anomalous reading arrives, send an MQTT message, but stay in the current state.
              "actions": [
                { 
                  "iotTopicPublish": {
                    "mqttTopic": "temperatureSensor/anomaly"
                  }
                }
              ],
              "nextState": "idle"
            },

            {
              "eventName": "highTemperatureSpike",
              "condition": "$input.temperatureInput.sensorData.temperature > $variable.rangeHigh",
              // When even a single temperature reading arrives that is above the 'rangeHigh', take
              //   emergency action to begin cooling, and report a high temperature spike.
              "actions": [
                {
                  "iotTopicPublish": {
                    "mqttTopic": "temperatureSensor/spike"
                  }
                },
                {
                  "sns": {
                    "targetArn": "arn:aws:sns:us-west-2:123456789012:coolOn"
                  }
                },
                {
                  "iotTopicPublish": {
                    "mqttTopic": "hvac/Cooling/On"
                  }
                },
                {
                  "setVariable": {
                    // This is necessary because we want to set a timer to delay the shutoff
                    //   of a cooling/heating unit, but we only want to set the timer when we 
                    //   enter that new state initially.
                    "variableName": "enteringNewState",
                    "value": "true"
                  }
                }
              ],
              "nextState": "cooling"
            },

            {
              "eventName": "lowTemperatureSpike",
              "condition": "$input.temperatureInput.sensorData.temperature < $variable.rangeLow",
              // When even a single temperature reading arrives that is below the 'rangeLow', take
              //   emergency action to begin heating, and report a low-temperature spike.
              "actions": [
                {
                  "iotTopicPublish": {
                    "mqttTopic": "temperatureSensor/spike"
                  }
                },
                {
                  "sns": {
                    "targetArn": "arn:aws:sns:us-west-2:123456789012:heatOn"
                  }
                },
                {
                  "iotTopicPublish": {
                    "mqttTopic": "hvac/Heating/On"
                  }
                },
                {
                  "setVariable": {
                    "variableName": "enteringNewState",
                    "value": "true"
                  }
                }
              ],
              "nextState": "heating"
            },

            {
              "eventName": "highTemperatureThreshold",
              "condition": "(((($variable.averageTemperature * ($variable.sensorCount - 1)) + $input.temperatureInput.sensorData.temperature) / $variable.sensorCount) > ($variable.desiredTemperature + $variable.allowedError))",
              // When the average temperature is above the desired temperature plus the allowed error factor,
              //   it is time to start cooling. Note that we calculate the average temperature here again
              //   because the value stored in the 'averageTemperature' variable is not yet available for use
              //   in our condition.
              "actions": [
                {
                  "sns": {
                    "targetArn": "arn:aws:sns:us-west-2:123456789012:coolOn"
                  }
                },
                {
                  "iotTopicPublish": {
                    "mqttTopic": "hvac/Cooling/On"
                  }
                },
                {
                  "setVariable": {
                    "variableName": "enteringNewState",
                    "value": "true"
                  }
                }
              ],
              "nextState": "cooling"
            },

            {
              "eventName": "lowTemperatureThreshold",
              "condition": "(((($variable.averageTemperature * ($variable.sensorCount - 1)) + $input.temperatureInput.sensorData.temperature) / $variable.sensorCount) < ($variable.desiredTemperature - $variable.allowedError))",
              // When the average temperature is below the desired temperature minus the allowed error factor,
              //   it is time to start heating. Note that we calculate the average temperature here again
              //   because the value stored in the 'averageTemperature' variable is not yet available for use
              //   in our condition.
              "actions": [
                {
                  "sns": {
                    "targetArn": "arn:aws:sns:us-west-2:123456789012:heatOn"
                  }
                },
                {
                  "iotTopicPublish": {
                    "mqttTopic": "hvac/Heating/On"
                  }
                },
                {
                  "setVariable": {
                    "variableName": "enteringNewState",
                    "value": "true"
                  }
                }
              ],
              "nextState": "heating"
            }
          ]
        }
      },


      {
        "stateName": "cooling",
        "onEnter": {
          "events": [
            {
              "eventName": "delay",
              "condition": "!$variable.noDelay && $variable.enteringNewState",
              // If the operational parameters specify that there should be a minimum time that the 
              //   heating and cooling units should be run before being shut off again, we set
              //   a timer to ensure the proper operation here.
              "actions": [
                {
                  "setTimer": {
                    "timerName": "coolingTimer",
                    "seconds": 180
                  }
                },
                {
                  "setVariable": {
                    // We use this 'goodToGo' variable to store the status of the timer expiration 
                    //   for use in conditions that also use input variable values. If 
                    //   'timeout()' is used in such mixed conditionals, its value is lost.
                    "variableName": "goodToGo",
                    "value": "false"
                  }
                }
              ]
            },
            {
              "eventName": "dontDelay",
              "condition": "$variable.noDelay == true",
              // If the heating/cooling unit shutoff delay is not used, no need to wait.
              "actions": [
                {
                  "setVariable": {
                    "variableName": "goodToGo",
                    "value": "true"
                  }
                }
              ]
            },
            {
              "eventName": "beenHere",
              "condition": "true",
              "actions": [
                {
                  "setVariable": {
                    "variableName": "enteringNewState",
                    "value": "false"
                  }
                }
              ]
            }
          ]
        },

        "onInput": {
          "events": [
            // These are events that occur when an input is received (if the condition is
            //   satisfied), but don't cause a transition to another state.
            {
              "eventName": "whatWasInput",
              "condition": "true",
              "actions": [
                {
                  "setVariable": {
                    "variableName": "sensorId",
                    "value": "$input.temperatureInput.sensorId"
                  }
                },
                {
                  "setVariable": {
                    "variableName": "reportedTemperature",
                    "value": "$input.temperatureInput.sensorData.temperature"
                  }
                }
              ]
            },
            {
              "eventName": "changeDesired",
              "condition": "$input.seedTemperatureInput.desiredTemperature != $variable.desiredTemperature",
              "actions": [
                { 
                  "setVariable": {
                    "variableName": "desiredTemperature",
                    "value": "$input.seedTemperatureInput.desiredTemperature"
                  }
                }
              ]
            },
            {
              "eventName": "calculateAverage",
              "condition": "$input.temperatureInput.sensorData.temperature < $variable.anomalousHigh && $input.temperatureInput.sensorData.temperature > $variable.anomalousLow",
              "actions": [
                {
                  "setVariable": {
                    "variableName": "averageTemperature",
                    "value": "((($variable.averageTemperature * ($variable.sensorCount - 1)) + $input.temperatureInput.sensorData.temperature) / $variable.sensorCount)"
                  }
                }
              ]
            },
            {
              "eventName": "areWeThereYet",
              "condition": "(timeout(\"coolingTimer\"))",
              "actions": [
                {
                  "setVariable": {
                    "variableName": "goodToGo",
                    "value": "true"
                  }
                }
              ]
            }
          ],
          "transitionEvents": [
            // Note that some tests of temperature values (for example, the test for an anomalous value) 
            //   must be placed here in the 'transitionEvents' because they work together with the tests 
            //   in the other conditions to ensure that we implement the proper "if..elseif..else" logic. 
            //   But each transition event must have a destination state ('nextState'), and even if that 
            //   is actually the current state, the "onEnter" events for this state will be executed again.
            //   This is the reason for the 'enteringNewState' variable and related.
            {
              "eventName": "anomalousInputArrived",
              "condition": "$input.temperatureInput.sensorData.temperature >= $variable.anomalousHigh || $input.temperatureInput.sensorData.temperature <= $variable.anomalousLow",
              "actions": [
                { 
                  "iotTopicPublish": {
                    "mqttTopic": "temperatureSensor/anomaly"
                  }
                }
              ],
              "nextState": "cooling"
            },

            {
              "eventName": "highTemperatureSpike",
              "condition": "$input.temperatureInput.sensorData.temperature > $variable.rangeHigh",
              "actions": [
                {
                  "iotTopicPublish": {
                    "mqttTopic": "temperatureSensor/spike"
                  }
                }
              ],
              "nextState": "cooling"
            },

            {
              "eventName": "lowTemperatureSpike",
              "condition": "$input.temperatureInput.sensorData.temperature < $variable.rangeLow",
              "actions": [
                {
                  "iotTopicPublish": {
                    "mqttTopic": "temperatureSensor/spike"
                  }
                },
                {
                  "sns": {
                    "targetArn": "arn:aws:sns:us-west-2:123456789012:coolOff"
                  }
                },
                {
                  "sns": {
                    "targetArn": "arn:aws:sns:us-west-2:123456789012:heatOn"
                  }
                },
                {
                  "iotTopicPublish": {
                    "mqttTopic": "hvac/Cooling/Off"
                  }
                },
                {
                  "iotTopicPublish": {
                    "mqttTopic": "hvac/Heating/On"
                  }
                },
                {
                  "setVariable": {
                    "variableName": "enteringNewState",
                    "value": "true"
                  }
                }
              ],
              "nextState": "heating"
            },

            {
              "eventName": "desiredTemperature",
              "condition": "(((($variable.averageTemperature * ($variable.sensorCount - 1)) + $input.temperatureInput.sensorData.temperature) / $variable.sensorCount) <= ($variable.desiredTemperature - $variable.allowedError)) && $variable.goodToGo == true",
              "actions": [
                {
                  "sns": {
                    "targetArn": "arn:aws:sns:us-west-2:123456789012:coolOff"
                  }
                },
                {
                  "iotTopicPublish": {
                    "mqttTopic": "hvac/Cooling/Off"
                  }
                }
              ],
              "nextState": "idle"
            }
          ]
        }
      },


      {
        "stateName": "heating",
        "onEnter": {
          "events": [
            {
              "eventName": "delay",
              "condition": "!$variable.noDelay && $variable.enteringNewState",
              "actions": [
                {
                  "setTimer": {
                    "timerName": "heatingTimer",
                    "seconds": 120
                  }
                },
                {
                  "setVariable": {
                    "variableName": "goodToGo",
                    "value": "false"
                  }
                }
              ]
            },
            {
              "eventName": "dontDelay",
              "condition": "$variable.noDelay == true",
              "actions": [
                {
                  "setVariable": {
                    "variableName": "goodToGo",
                    "value": "true"
                  }
                }
              ]
            },
            {
              "eventName": "beenHere",
              "condition": "true",
              "actions": [
                {
                  "setVariable": {
                    "variableName": "enteringNewState",
                    "value": "false"
                  }
                }
              ]
            }
          ]
        },

        "onInput": {
          "events": [
            {
              "eventName": "whatWasInput",
              "condition": "true",
              "actions": [
                {
                  "setVariable": {
                    "variableName": "sensorId",
                    "value": "$input.temperatureInput.sensorId"
                  }
                },
                {
                  "setVariable": {
                    "variableName": "reportedTemperature",
                    "value": "$input.temperatureInput.sensorData.temperature"
                  }
                }
              ]
            },
            {
              "eventName": "changeDesired",
              "condition": "$input.seedTemperatureInput.desiredTemperature != $variable.desiredTemperature",
              "actions": [
                { 
                  "setVariable": {
                    "variableName": "desiredTemperature",
                    "value": "$input.seedTemperatureInput.desiredTemperature"
                  }
                }
              ]
            },
            {
              "eventName": "calculateAverage",
              "condition": "$input.temperatureInput.sensorData.temperature < $variable.anomalousHigh && $input.temperatureInput.sensorData.temperature > $variable.anomalousLow",
              "actions": [
                {
                  "setVariable": {
                    "variableName": "averageTemperature",
                    "value": "((($variable.averageTemperature * ($variable.sensorCount - 1)) + $input.temperatureInput.sensorData.temperature) / $variable.sensorCount)"
                  }
                }
              ]
            },
            {
              "eventName": "areWeThereYet",
              "condition": "(timeout(\"heatingTimer\"))",
              "actions": [
                {
                  "setVariable": {
                    "variableName": "goodToGo",
                    "value": "true"
                  }
                }
              ]
            }
          ],
          "transitionEvents": [
            {
              "eventName": "anomalousInputArrived",
              "condition": "$input.temperatureInput.sensorData.temperature >= $variable.anomalousHigh || $input.temperatureInput.sensorData.temperature <= $variable.anomalousLow",
              "actions": [
                { 
                  "iotTopicPublish": {
                    "mqttTopic": "temperatureSensor/anomaly"
                  }
                }
              ],
              "nextState": "heating"
            },

            {
              "eventName": "highTemperatureSpike",
              "condition": "$input.temperatureInput.sensorData.temperature > $variable.rangeHigh",
              "actions": [
                {
                  "iotTopicPublish": {
                    "mqttTopic": "temperatureSensor/spike"
                  }
                },
                {
                  "sns": {
                    "targetArn": "arn:aws:sns:us-west-2:123456789012:heatOff"
                  }
                },
                {
                  "sns": {
                    "targetArn": "arn:aws:sns:us-west-2:123456789012:coolOn"
                  }
                },
                {
                  "iotTopicPublish": {
                    "mqttTopic": "hvac/Heating/Off"
                  }
                },
                {
                  "iotTopicPublish": {
                    "mqttTopic": "hvac/Cooling/On"
                  }
                },
                {
                  "setVariable": {
                    "variableName": "enteringNewState",
                    "value": "true"
                  }
                }
              ],
              "nextState": "cooling"
            },

            {
              "eventName": "lowTemperatureSpike",
              "condition": "$input.temperatureInput.sensorData.temperature < $variable.rangeLow",
              "actions": [
                {
                  "iotTopicPublish": {
                    "mqttTopic": "temperatureSensor/spike"
                  }
                }
              ],
              "nextState": "heating"
            },

            {
              "eventName": "desiredTemperature",
              "condition": "(((($variable.averageTemperature * ($variable.sensorCount - 1)) + $input.temperatureInput.sensorData.temperature) / $variable.sensorCount) >= ($variable.desiredTemperature + $variable.allowedError)) && $variable.goodToGo == true",
              "actions": [
                {
                  "sns": {
                    "targetArn": "arn:aws:sns:us-west-2:123456789012:heatOff"
                  }
                },
                {
                  "iotTopicPublish": {
                    "mqttTopic": "hvac/Heating/Off"
                  }
                }
              ],
              "nextState": "idle"
            }
          ]
        }
      } 

    ],

    "initialStateName": "start"
  },
  "key": "areaId",
  "roleArn": "arn:aws:iam::123456789012:role/IoTEventsRole" 
}
```

Response:

```
{
    "detectorModelConfiguration": {
        "status": "ACTIVATING", 
        "lastUpdateTime": 1557523491.168, 
        "roleArn": "arn:aws:iam::123456789012:role/IoTEventsRole", 
        "creationTime": 1557523491.168, 
        "detectorModelArn": "arn:aws:iotevents:us-west-2:123456789012:detectorModel/areaDetectorModel", 
        "key": "areaId", 
        "detectorModelName": "areaDetectorModel", 
        "detectorModelVersion": "1"
    }
}
```

### BatchUpdateDetector example<a name="iotevents-commented-example-batch-update-detector"></a>

You can use the `BatchUpdateDetector` operation to put a detector instance into a known state, including timer and variable values\. In the following example, the `BatchUpdateDetector` operation resets operational parameters for an area that is under temperature monitoring and control\. This operation enables you to do this without having to delete, and recreate, or update the detector model\.

CLI command:

```
aws iotevents-data batch-update-detector --cli-input-json file://areaDM.BUD.json
```

File: `areaDM.BUD.json`

```
{
  "detectors": [
    {
      "messageId": "0001",
      "detectorModelName": "areaDetectorModel",
      "keyValue": "Area51",
      "state": {
        "stateName": "start",
        "variables": [
          {
            "name": "desiredTemperature",
            "value": "22"
          },
          {
            "name": "averageTemperature",
            "value": "22"
          },
          {
            "name": "allowedError",
            "value": "1.0"
          },
          {
            "name": "rangeHigh",
            "value": "30.0"
          },
          {
            "name": "rangeLow",
            "value": "15.0"
          },
          {
            "name": "anomalousHigh",
            "value": "60.0"
          },
          {
            "name": "anomalousLow",
            "value": "0.0"
          },
          {
            "name": "sensorCount",
            "value": "12"
          },
          {
            "name": "noDelay",
            "value": "true"
          },
          {
            "name": "goodToGo",
            "value": "true"
          },
          {
            "name": "sensorId",
            "value": "0"
          },
          {
            "name": "reportedTemperature",
            "value": "0.1"
          },
          {
            "name": "resetMe",
            // When 'resetMe' is true, our detector model knows that we have reentered the 'start' state
            //   to reset operational parameters, and will allow the next valid temperature sensor
            //   reading to cause the transition to the 'idle' state.
            "value": "true"
          }
        ],
        "timers": [
        ]
      }
    }
  ]
}
```

Response:

```
{
    "batchUpdateDetectorErrorEntries": []
}
```

### BatchPutMessage examples<a name="iotevents-commented-example-input-usage-examples"></a>

**Example 1**  
Use the `BatchPutMessage` operation to send a `"seedTemperatureInput"` message that sets the operational parameters for a given area under temperature control and monitoring\. Any message received by AWS IoT Events that has a new `"areaId"` causes a new detector instance to be created\. But the new detector instance won't change state to `"idle"` and begin monitoring the temperature and controlling heating or cooling units until a `"seedTemperatureInput"` message is received for the new area\.  
CLI command:  

```
aws iotevents-data batch-put-message --cli-input-json file://seedExample.json
```
File: `seedExample.json`  

```
{
  "messages": [
    {
      "messageId": "00001",
      "inputName": "seedTemperatureInput",
      "payload": "{\"areaId\": \"Area51\", \"desiredTemperature\": 20.0, \"allowedError\": 0.7, \"rangeHigh\": 30.0, \"rangeLow\": 15.0, \"anomalousHigh\": 60.0, \"anomalousLow\": 0.0, \"sensorCount\": 10, \"noDelay\": false}"
    }
  ]
}
```
Response:  

```
{
    "BatchPutMessageErrorEntries": []
}
```

**Example**  
2  
Use the `BatchPutMessage` operation to send a `"temperatureInput"` message to report temperature sensor data for a sensor in a given control and monitoring area\.  
CLI command:  

```
aws iotevents-data batch-put-message --cli-input-json file://temperatureExample.json
```
File: `temperatureExample.json`  

```
{
  "messages": [
    {
      "messageId": "00005",
      "inputName": "temperatureInput",
      "payload": "{\"sensorId\": \"05\", \"areaId\": \"Area51\", \"sensorData\": {\"temperature\": 23.12} }"
    }
  ]
}
```
Response:  

```
{
    "BatchPutMessageErrorEntries": []
}
```

**Example 3**  
Use the `BatchPutMessage` operation to send a `"seedTemperatureInput"` message to change the value of the desired temperature for a given area\.  
CLI command:  

```
aws iotevents-data batch-put-message --cli-input-json file://seedSetDesiredTemp.json
```
File: `seedSetDesiredTemp.json`  

```
{
  "messages": [
    {
      "messageId": "00001",
      "inputName": "seedTemperatureInput",
      "payload": "{\"areaId\": \"Area51\", \"desiredTemperature\": 23.0}"
    }
  ]
}
```
Response:  

```
{
    "BatchPutMessageErrorEntries": []
}
```

### Example: Ingesting MQTT messages<a name="iotevents-commented-example-ingest-mqtt"></a>

If your sensor computing resources can't use the `"BatchPutMessage"` API, but can send their data to the AWS IoT Core message broker using a lightweight MQTT client, you can create an AWS IoT Core topic rule to redirect message data to an AWS IoT Events input\. The following is a definition of an AWS IoT Events topic rule that takes the `"areaId"` and `"sensorId"` input fields from the MQTT topic, and the `"sensorData.temperature"` field from the message payload `"temp"` field, and ingests this data into our AWS IoT Events `"temperatureInput"`\.

If your sensor computing resources can't use the `"BatchPutMessage"` API, but can send their data to the AWS IoT Core message broker using a lightweight MQTT client, you can create an AWS IoT Core topic rule to redirect message data to an AWS IoT Events input\. The following is a definition of an AWS IoT Events topic rule that takes the `"areaId"` and `"sensorId"` input fields from the MQTT topic, and the `"sensorData.temperature"` field from the message payload `"temp"` field, and ingests this data into our AWS IoT Events `"temperatureInput"`\.

CLI command:

```
aws iot create-topic-rule --cli-input-json file://temperatureTopicRule.json
```

File: `seedSetDesiredTemp.json`

```
{
  "ruleName": "temperatureTopicRule",
  "topicRulePayload": {
    "sql": "SELECT topic(3) as areaId, topic(4) as sensorId, temp as sensorData.temperature FROM 'update/temperature/#'",
    "description": "Ingest temperature sensor messages into IoT Events",
    "actions": [
      {
        "iotEvents": {
          "inputName": "temperatureInput",
          "roleArn": "arn:aws:iam::123456789012:role/service-role/anotheRole" 
        }
      }
    ],
    "ruleDisabled": false,
    "awsIotSqlVersion": "2016-03-23"
  }
}
```

Response: \[none\]

If the sensor sends a message on the topic `"update/temperature/Area51/03"` with the following payload\.

```
{ "temp": 24.5 }
```

This results in data being ingested into AWS IoT Events as if the following `"BatchPutMessage"` API call had been made\.

```
aws iotevents-data batch-put-message --cli-input-json file://spoofExample.json
```

File: `spoofExample.json`

```
{
  "messages": [
    {
      "messageId": "54321",
      "inputName": "temperatureInput",
      "payload": "{\"sensorId\": \"03\", \"areaId\": \"Area51\", \"sensorData\": {\"temperature\": 24.5} }"
    }
  ]
}
```

### Examples: Generated Amazon SNS messages<a name="iotevents-commented-example-generated-sns"></a>

The following are examples of SNS messages generated by the `"Area51"` detector instance\.

```
Heating system off command> {
  "eventTime":1557520274729,
  "payload":{
    "actionExecutionId":"f3159081-bac3-38a4-96f7-74af0940d0a4",
    "detector":{
      "detectorModelName":"areaDetectorModel","keyValue":"Area51","detectorModelVersion":"1"},"eventTriggerDetails":{"inputName":"seedTemperatureInput","messageId":"00001","triggerType":"Message"},"state":{"stateName":"start","variables":{"sensorCount":10,"rangeHigh":30.0,"resetMe":false,"enteringNewState":true,"averageTemperature":20.0,"rangeLow":15.0,"noDelay":false,"allowedError":0.7,"desiredTemperature":20.0,"anomalousHigh":60.0,"reportedTemperature":0.1,"anomalousLow":0.0,"sensorId":0},"timers":{}}},"eventName":"resetHeatCool"}
```

```
Cooling system off command> {"eventTime":1557520274729,"payload":{"actionExecutionId":"98f6a1b5-8f40-3cdb-9256-93afd4d66192","detector":{"detectorModelName":"areaDetectorModel","keyValue":"Area51","detectorModelVersion":"1"},"eventTriggerDetails":{"inputName":"seedTemperatureInput","messageId":"00001","triggerType":"Message"},"state":{"stateName":"start","variables":{"sensorCount":10,"rangeHigh":30.0,"resetMe":false,"enteringNewState":true,"averageTemperature":20.0,"rangeLow":15.0,"noDelay":false,"allowedError":0.7,"desiredTemperature":20.0,"anomalousHigh":60.0,"reportedTemperature":0.1,"anomalousLow":0.0,"sensorId":0},"timers":{}}},"eventName":"resetHeatCool"}
```

### Example: DescribeDetector API<a name="iotevents-commented-example-describe-detector"></a>

You can use the `DescribeDetector` operation to see the current state, variable values, and timers for a detector instance\.

CLI command:

```
aws iotevents-data describe-detector --detector-model-name areaDetectorModel --key-value Area51
```

Response:

```
{
    "detector": {
        "lastUpdateTime": 1557521572.216, 
        "creationTime": 1557520274.405, 
        "state": {
            "variables": [
                {
                    "name": "resetMe", 
                    "value": "false"
                }, 
                {
                    "name": "rangeLow", 
                    "value": "15.0"
                }, 
                {
                    "name": "noDelay", 
                    "value": "false"
                }, 
                {
                    "name": "desiredTemperature", 
                    "value": "20.0"
                }, 
                {
                    "name": "anomalousLow", 
                    "value": "0.0"
                }, 
                {
                    "name": "sensorId", 
                    "value": "\"01\""
                }, 
                {
                    "name": "sensorCount", 
                    "value": "10"
                }, 
                {
                    "name": "rangeHigh", 
                    "value": "30.0"
                }, 
                {
                    "name": "enteringNewState", 
                    "value": "false"
                }, 
                {
                    "name": "averageTemperature", 
                    "value": "19.572"
                }, 
                {
                    "name": "allowedError", 
                    "value": "0.7"
                }, 
                {
                    "name": "anomalousHigh", 
                    "value": "60.0"
                }, 
                {
                    "name": "reportedTemperature", 
                    "value": "15.72"
                }, 
                {
                    "name": "goodToGo", 
                    "value": "false"
                }
            ], 
            "stateName": "idle", 
            "timers": [
                {
                    "timestamp": 1557520454.0, 
                    "name": "idleTimer"
                }
            ]
        }, 
        "keyValue": "Area51", 
        "detectorModelName": "areaDetectorModel", 
        "detectorModelVersion": "1"
    }
}
```

### AWS IoT Core rules engine examples<a name="iotevents-commented-examples-iot-rules-examples"></a>

The following rules republish AWS IoT Core MQTT messages as shadow update request messages\. We assume that AWS IoT Core things are defined for a heating unit and a cooling unit for each area that is controlled by the detector model\. In this example, we have defined things named `"Area51HeatingUnit"` and `"Area51CoolingUnit"`\.

CLI command:

```
aws iot create-topic-rule --cli-input-json file://ADMShadowCoolOffRule.json
```

File: `ADMShadowCoolOffRule.json`

```
{
  "ruleName": "ADMShadowCoolOff",
  "topicRulePayload": {
    "sql": "SELECT topic(3) as state.desired.command FROM 'hvac/Cooling/Off'",
    "description": "areaDetectorModel mqtt topic publish to cooling unit shadow request",
    "ruleDisabled": false,
    "awsIotSqlVersion": "2016-03-23",
    "actions": [
      {
        "republish": {
          "topic": "$$aws/things/${payload.detector.keyValue}CoolingUnit/shadow/update",
          "roleArn": "arn:aws:iam::123456789012:role/service-role/ADMShadowRole" 
        }
      }
    ]
  }
}
```

Response: \[empty\]

CLI command:

```
aws iot create-topic-rule --cli-input-json file://ADMShadowCoolOnRule.json
```

File: `ADMShadowCoolOnRule.json`

```
{
  "ruleName": "ADMShadowCoolOn",
  "topicRulePayload": {
    "sql": "SELECT topic(3) as state.desired.command FROM 'hvac/Cooling/On'",
    "description": "areaDetectorModel mqtt topic publish to cooling unit shadow request",
    "ruleDisabled": false,
    "awsIotSqlVersion": "2016-03-23",
    "actions": [
      {
        "republish": {
          "topic": "$$aws/things/${payload.detector.keyValue}CoolingUnit/shadow/update",
          "roleArn": "arn:aws:iam::123456789012:role/service-role/ADMShadowRole" 
        }
      }
    ]
  }
}
```

Response: \[empty\]

CLI command:

```
aws iot create-topic-rule --cli-input-json file://ADMShadowHeatOffRule.json
```

File: `ADMShadowHeatOffRule.json`

```
{
  "ruleName": "ADMShadowHeatOff",
  "topicRulePayload": {
    "sql": "SELECT topic(3) as state.desired.command FROM 'hvac/Heating/Off'",
    "description": "areaDetectorModel mqtt topic publish to heating unit shadow request",
    "ruleDisabled": false,
    "awsIotSqlVersion": "2016-03-23",
    "actions": [
      {
        "republish": {
          "topic": "$$aws/things/${payload.detector.keyValue}HeatingUnit/shadow/update",
          "roleArn": "arn:aws:iam::123456789012:role/service-role/ADMShadowRole" 
        }
      }
    ]
  }
}
```

Response: \[empty\]

CLI command:

```
aws iot create-topic-rule --cli-input-json file://ADMShadowHeatOnRule.json
```

File: `ADMShadowHeatOnRule.json`

```
{
  "ruleName": "ADMShadowHeatOn",
  "topicRulePayload": {
    "sql": "SELECT topic(3) as state.desired.command FROM 'hvac/Heating/On'",
    "description": "areaDetectorModel mqtt topic publish to heating unit shadow request",
    "ruleDisabled": false,
    "awsIotSqlVersion": "2016-03-23",
    "actions": [
      {
        "republish": {
          "topic": "$$aws/things/${payload.detector.keyValue}HeatingUnit/shadow/update",
          "roleArn": "arn:aws:iam::123456789012:role/service-role/ADMShadowRole" 
        }
      }
    ]
  }
}
```

Response: \[empty\]