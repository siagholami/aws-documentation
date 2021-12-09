# ISA alarm<a name="iotevents-examples-bisaa"></a>

This detector model is one of the templates available from the AWS IoT Events console\. It's included here for your convenience\.

```
{
    "detectorModelName": "AWS_IoTEvents_Blueprints_ISA_Alarm", 
    "detectorModelDefinition": {
        "states": [
            {
                "onInput": {
                    "transitionEvents": [
                        {
                            "eventName": "unshelve", 
                            "actions": [], 
                            "condition": "$input.AWS_IoTEvents_Blueprints_ISA_Alarm_Input.command == \"unshelve\" && $variable.state == \"rtnunack\"", 
                            "nextState": "RTN_Unacknowledged"
                        }, 
                        {
                            "eventName": "unshelve", 
                            "actions": [], 
                            "condition": "$input.AWS_IoTEvents_Blueprints_ISA_Alarm_Input.command == \"unshelve\" && $variable.state == \"ack\"", 
                            "nextState": "Acknowledged"
                        }, 
                        {
                            "eventName": "unshelve", 
                            "actions": [], 
                            "condition": "$input.AWS_IoTEvents_Blueprints_ISA_Alarm_Input.command == \"unshelve\" && $variable.state == \"unack\"", 
                            "nextState": "Unacknowledged"
                        }, 
                        {
                            "eventName": "unshelve", 
                            "actions": [], 
                            "condition": "$input.AWS_IoTEvents_Blueprints_ISA_Alarm_Input.command == \"unshelve\" && $variable.state == \"normal\"", 
                            "nextState": "Normal"
                        }
                    ], 
                    "events": []
                }, 
                "stateName": "Shelved", 
                "onEnter": {
                    "events": []
                }, 
                "onExit": {
                    "events": []
                }
            }, 
            {
                "onInput": {
                    "transitionEvents": [
                        {
                            "eventName": "abnormal_condition", 
                            "actions": [], 
                            "condition": "$input.AWS_IoTEvents_Blueprints_ISA_Alarm_Input.value > $variable.higher_threshold || $input.AWS_IoTEvents_Blueprints_ISA_Alarm_Input.value < $variable.lower_threshold", 
                            "nextState": "Unacknowledged"
                        }, 
                        {
                            "eventName": "acknowledge", 
                            "actions": [], 
                            "condition": "$input.AWS_IoTEvents_Blueprints_ISA_Alarm_Input.command == \"acknowledge\"", 
                            "nextState": "Normal"
                        }, 
                        {
                            "eventName": "shelve", 
                            "actions": [], 
                            "condition": "$input.AWS_IoTEvents_Blueprints_ISA_Alarm_Input.command == \"shelve\"", 
                            "nextState": "Shelved"
                        }, 
                        {
                            "eventName": "remove_from_service", 
                            "actions": [], 
                            "condition": "$input.AWS_IoTEvents_Blueprints_ISA_Alarm_Input.command == \"remove\"", 
                            "nextState": "Out_of_service"
                        }, 
                        {
                            "eventName": "suppression", 
                            "actions": [], 
                            "condition": "$input.AWS_IoTEvents_Blueprints_ISA_Alarm_Input.command == \"suppressed\"", 
                            "nextState": "Suppressed_by_design"
                        }
                    ], 
                    "events": []
                }, 
                "stateName": "RTN_Unacknowledged", 
                "onEnter": {
                    "events": [
                        {
                            "eventName": "State Save", 
                            "actions": [
                                {
                                    "setVariable": {
                                        "variableName": "state", 
                                        "value": "\"rtnunack\""
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
                            "eventName": "abnormal_condition", 
                            "actions": [], 
                            "condition": "$input.AWS_IoTEvents_Blueprints_ISA_Alarm_Input.value > $variable.higher_threshold || $input.AWS_IoTEvents_Blueprints_ISA_Alarm_Input.value < $variable.lower_threshold", 
                            "nextState": "Unacknowledged"
                        }, 
                        {
                            "eventName": "shelve", 
                            "actions": [], 
                            "condition": "$input.AWS_IoTEvents_Blueprints_ISA_Alarm_Input.command == \"shelve\"", 
                            "nextState": "Shelved"
                        }, 
                        {
                            "eventName": "remove_from_service", 
                            "actions": [], 
                            "condition": "$input.AWS_IoTEvents_Blueprints_ISA_Alarm_Input.command == \"remove\"", 
                            "nextState": "Out_of_service"
                        }, 
                        {
                            "eventName": "suppression", 
                            "actions": [], 
                            "condition": "$input.AWS_IoTEvents_Blueprints_ISA_Alarm_Input.command == \"suppressed\"", 
                            "nextState": "Suppressed_by_design"
                        }
                    ], 
                    "events": [
                        {
                            "eventName": "Create Config variables", 
                            "actions": [
                                {
                                    "setVariable": {
                                        "variableName": "lower_threshold", 
                                        "value": "$input.AWS_IoTEvents_Blueprints_ISA_Alarm_Input.lower_threshold"
                                    }
                                }, 
                                {
                                    "setVariable": {
                                        "variableName": "higher_threshold", 
                                        "value": "$input.AWS_IoTEvents_Blueprints_ISA_Alarm_Input.higher_threshold"
                                    }
                                }
                            ], 
                            "condition": "$variable.lower_threshold != $variable.lower_threshold"
                        }
                    ]
                }, 
                "stateName": "Normal", 
                "onEnter": {
                    "events": [
                        {
                            "eventName": "State Save", 
                            "actions": [
                                {
                                    "setVariable": {
                                        "variableName": "state", 
                                        "value": "\"normal\""
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
                            "eventName": "acknowledge", 
                            "actions": [], 
                            "condition": "$input.AWS_IoTEvents_Blueprints_ISA_Alarm_Input.command == \"acknowledge\"", 
                            "nextState": "Acknowledged"
                        }, 
                        {
                            "eventName": "return_to_normal", 
                            "actions": [], 
                            "condition": "($input.AWS_IoTEvents_Blueprints_ISA_Alarm_Input.value <= $variable.higher_threshold && $input.AWS_IoTEvents_Blueprints_ISA_Alarm_Input.value >= $variable.lower_threshold)", 
                            "nextState": "RTN_Unacknowledged"
                        }, 
                        {
                            "eventName": "shelve", 
                            "actions": [], 
                            "condition": "$input.AWS_IoTEvents_Blueprints_ISA_Alarm_Input.command == \"shelve\"", 
                            "nextState": "Shelved"
                        }, 
                        {
                            "eventName": "remove_from_service", 
                            "actions": [], 
                            "condition": "$input.AWS_IoTEvents_Blueprints_ISA_Alarm_Input.command == \"remove\"", 
                            "nextState": "Out_of_service"
                        }, 
                        {
                            "eventName": "suppression", 
                            "actions": [], 
                            "condition": "$input.AWS_IoTEvents_Blueprints_ISA_Alarm_Input.command == \"suppressed\"", 
                            "nextState": "Suppressed_by_design"
                        }
                    ], 
                    "events": []
                }, 
                "stateName": "Unacknowledged", 
                "onEnter": {
                    "events": [
                        {
                            "eventName": "State Save", 
                            "actions": [
                                {
                                    "setVariable": {
                                        "variableName": "state", 
                                        "value": "\"unack\""
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
                            "eventName": "unsuppression", 
                            "actions": [], 
                            "condition": "$input.AWS_IoTEvents_Blueprints_ISA_Alarm_Input.command == \"unsuppressed\" && $variable.state == \"normal\"", 
                            "nextState": "Normal"
                        }, 
                        {
                            "eventName": "unsuppression", 
                            "actions": [], 
                            "condition": "$input.AWS_IoTEvents_Blueprints_ISA_Alarm_Input.command == \"unsuppressed\" && $variable.state == \"unack\"", 
                            "nextState": "Unacknowledged"
                        }, 
                        {
                            "eventName": "unsuppression", 
                            "actions": [], 
                            "condition": "$input.AWS_IoTEvents_Blueprints_ISA_Alarm_Input.command == \"unsuppressed\" && $variable.state == \"ack\"", 
                            "nextState": "Acknowledged"
                        }, 
                        {
                            "eventName": "unsuppression", 
                            "actions": [], 
                            "condition": "$input.AWS_IoTEvents_Blueprints_ISA_Alarm_Input.command == \"unsuppressed\" && $variable.state == \"rtnunack\"", 
                            "nextState": "RTN_Unacknowledged"
                        }
                    ], 
                    "events": []
                }, 
                "stateName": "Suppressed_by_design", 
                "onEnter": {
                    "events": []
                }, 
                "onExit": {
                    "events": []
                }
            }, 
            {
                "onInput": {
                    "transitionEvents": [
                        {
                            "eventName": "return_to_service", 
                            "actions": [], 
                            "condition": "$input.AWS_IoTEvents_Blueprints_ISA_Alarm_Input.command == \"add\" && $variable.state == \"rtnunack\"", 
                            "nextState": "RTN_Unacknowledged"
                        }, 
                        {
                            "eventName": "return_to_service", 
                            "actions": [], 
                            "condition": "$input.AWS_IoTEvents_Blueprints_ISA_Alarm_Input.command == \"add\" && $variable.state == \"unack\"", 
                            "nextState": "Unacknowledged"
                        }, 
                        {
                            "eventName": "return_to_service", 
                            "actions": [], 
                            "condition": "$input.AWS_IoTEvents_Blueprints_ISA_Alarm_Input.command == \"add\" && $variable.state == \"ack\"", 
                            "nextState": "Acknowledged"
                        }, 
                        {
                            "eventName": "return_to_service", 
                            "actions": [], 
                            "condition": "$input.AWS_IoTEvents_Blueprints_ISA_Alarm_Input.command == \"add\" && $variable.state == \"normal\"", 
                            "nextState": "Normal"
                        }
                    ], 
                    "events": []
                }, 
                "stateName": "Out_of_service", 
                "onEnter": {
                    "events": []
                }, 
                "onExit": {
                    "events": []
                }
            }, 
            {
                "onInput": {
                    "transitionEvents": [
                        {
                            "eventName": "re-alarm", 
                            "actions": [], 
                            "condition": "timeout(\"snooze\")", 
                            "nextState": "Unacknowledged"
                        }, 
                        {
                            "eventName": "return_to_normal", 
                            "actions": [], 
                            "condition": "$input.AWS_IoTEvents_Blueprints_ISA_Alarm_Input.command == \"reset\"", 
                            "nextState": "Normal"
                        }, 
                        {
                            "eventName": "shelve", 
                            "actions": [], 
                            "condition": "$input.AWS_IoTEvents_Blueprints_ISA_Alarm_Input.command == \"shelve\"", 
                            "nextState": "Shelved"
                        }, 
                        {
                            "eventName": "remove_from_service", 
                            "actions": [], 
                            "condition": "$input.AWS_IoTEvents_Blueprints_ISA_Alarm_Input.command == \"remove\"", 
                            "nextState": "Out_of_service"
                        }, 
                        {
                            "eventName": "suppression", 
                            "actions": [], 
                            "condition": "$input.AWS_IoTEvents_Blueprints_ISA_Alarm_Input.command == \"suppressed\"", 
                            "nextState": "Suppressed_by_design"
                        }
                    ], 
                    "events": []
                }, 
                "stateName": "Acknowledged", 
                "onEnter": {
                    "events": [
                        {
                            "eventName": "Create Timer", 
                            "actions": [
                                {
                                    "setTimer": {
                                        "seconds": 60, 
                                        "timerName": "snooze"
                                    }
                                }
                            ], 
                            "condition": "true"
                        }, 
                        {
                            "eventName": "State Save", 
                            "actions": [
                                {
                                    "setVariable": {
                                        "variableName": "state", 
                                        "value": "\"ack\""
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
            }
        ], 
        "initialStateName": "Normal"
    },
    "detectorModelDescription": "This detector model is used to detect if a monitored device is in an Alarming State in accordance to the ISA 18.2.", 
    "roleArn": "arn:aws:iam::123456789012:role/IoTEventsRole", 
    "key": "alarmId" 
}
```