# Simple alarm<a name="iotevents-examples-bsa"></a>

This detector model is one of the templates available from the AWS IoT Events console\. It's included here for your convenience\.

```
{
    "detectorModelDefinition": {
        "states": [
            {
                "onInput": {
                    "transitionEvents": [
                        {
                            "eventName": "not_fixed", 
                            "actions": [], 
                            "condition": "timeout(\"snoozeTime\")", 
                            "nextState": "Alarming"
                        }, 
                        {
                            "eventName": "reset", 
                            "actions": [], 
                            "condition": "$input.AWS_IoTEvents_Blueprints_Simple_Alarm_Input.command == \"reset\"", 
                            "nextState": "Normal"
                        }
                    ], 
                    "events": [
                        {
                            "eventName": "DND", 
                            "actions": [
                                {
                                    "setVariable": {
                                        "variableName": "dnd_active", 
                                        "value": "1"
                                    }
                                }
                            ], 
                            "condition": "$input.AWS_IoTEvents_Blueprints_Simple_Alarm_Input.command == \"dnd\""
                        }
                    ]
                }, 
                "stateName": "Snooze", 
                "onEnter": {
                    "events": [
                        {
                            "eventName": "Create Timer", 
                            "actions": [
                                {
                                    "setTimer": {
                                        "seconds": 120, 
                                        "timerName": "snoozeTime"
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
                            "eventName": "out_of_range", 
                            "actions": [], 
                            "condition": "$input.AWS_IoTEvents_Blueprints_Simple_Alarm_Input.value > $variable.threshold", 
                            "nextState": "Alarming"
                        }
                    ], 
                    "events": [
                        {
                            "eventName": "Create Config variables", 
                            "actions": [
                                {
                                    "setVariable": {
                                        "variableName": "threshold", 
                                        "value": "$input.AWS_IoTEvents_Blueprints_Simple_Alarm_Input.threshold"
                                    }
                                }
                            ], 
                            "condition": "$variable.threshold != $variable.threshold"
                        }
                    ]
                }, 
                "stateName": "Normal", 
                "onEnter": {
                    "events": [
                        {
                            "eventName": "Init", 
                            "actions": [
                                {
                                    "setVariable": {
                                        "variableName": "dnd_active", 
                                        "value": "0"
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
                            "eventName": "reset", 
                            "actions": [], 
                            "condition": "$input.AWS_IoTEvents_Blueprints_Simple_Alarm_Input.command == \"reset\"", 
                            "nextState": "Normal"
                        }, 
                        {
                            "eventName": "acknowledge", 
                            "actions": [], 
                            "condition": "$input.AWS_IoTEvents_Blueprints_Simple_Alarm_Input.command == \"acknowledge\"", 
                            "nextState": "Snooze"
                        }
                    ], 
                    "events": [
                        {
                            "eventName": "Escalated Alarm Notification", 
                            "actions": [
                                {
                                    "sns": {
                                        "targetArn": "arn:aws:sns:us-west-2:123456789012:escalatedAlarmNotification"
                                    }
                                }
                            ], 
                            "condition": "timeout(\"unacknowledgeTIme\")"
                        }
                    ]
                }, 
                "stateName": "Alarming", 
                "onEnter": {
                    "events": [
                        {
                            "eventName": "Alarm Notification", 
                            "actions": [
                                {
                                    "sns": {
                                        "targetArn": "arn:aws:sns:us-west-2:123456789012:alarmNotification"
                                    }
                                }, 
                                {
                                    "setTimer": {
                                        "seconds": 300, 
                                        "timerName": "unacknowledgeTIme"
                                    }
                                }
                            ], 
                            "condition": "$variable.dnd_active != 1"
                        }
                    ]
                }, 
                "onExit": {
                    "events": []
                }
            }
        ], 
        "initialStateName": "Normal"
    }, 
    "detectorModelDescription": "This detector model is used to detect if a monitored device is in an Alarming State.", 
    "roleArn": "arn:aws:iam::123456789012:role/IoTEventsRole", 
    "key": "alarmId" 
}
```