# Event detection with sensors and applications<a name="iotevents-examples-edwsaa"></a>

This detector model is one of the templates available from the AWS IoT Events console\. It's included here for your convenience\.

```
{
    "detectorModelName": "EventDetectionSensorsAndApplications", 
    "detectorModelDefinition": {
        "states": [
            {
                "onInput": {
                    "transitionEvents": [], 
                    "events": []
                }, 
                "stateName": "Device_exception", 
                "onEnter": {
                    "events": [
                        {
                            "eventName": "Send_mqtt", 
                            "actions": [
                                {
                                    "iotTopicPublish": {
                                        "mqttTopic": "Device_stolen"
                                    }
                                }
                            ], 
                            "condition": "true"
                        }
                    ]
                }, 
                "onExit": {
                    "events": []
                }
            }, 
            {
                "onInput": {
                    "transitionEvents": [
                        {
                            "eventName": "To_in_use", 
                            "actions": [], 
                            "condition": "$variable.position != $input.AWS_IoTEvents_Blueprints_Tracking_DeviceInput.gps_position", 
                            "nextState": "Device_in_use"
                        }
                    ], 
                    "events": []
                }, 
                "stateName": "Device_idle", 
                "onEnter": {
                    "events": [
                        {
                            "eventName": "Set_position", 
                            "actions": [
                                {
                                    "setVariable": {
                                        "variableName": "position", 
                                        "value": "$input.AWS_IoTEvents_Blueprints_Tracking_DeviceInput.gps_position"
                                    }
                                }
                            ], 
                            "condition": "true"
                        }
                    ]
                }, 
                "onExit": {
                    "events": []
                }
            }, 
            {
                "onInput": {
                    "transitionEvents": [
                        {
                            "eventName": "To_exception", 
                            "actions": [], 
                            "condition": "$input.AWS_IoTEvents_Blueprints_Tracking_UserInput.device_id != $input.AWS_IoTEvents_Blueprints_Tracking_DeviceInput.device_id", 
                            "nextState": "Device_exception"
                        }
                    ], 
                    "events": []
                }, 
                "stateName": "Device_in_use", 
                "onEnter": {
                    "events": []
                }, 
                "onExit": {
                    "events": []
                }
            }
        ], 
        "initialStateName": "Device_idle"
    }
}
```