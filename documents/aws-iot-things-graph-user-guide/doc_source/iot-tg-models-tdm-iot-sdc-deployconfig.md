--------

--------

# Deployment<a name="iot-tg-models-tdm-iot-sdc-deployconfig"></a>

The `Deployment` construct associates a physical location with specific devices and the triggers that start the workflows in which they are used\.

The following example creates a `Deployment` for the door entry security system\.

**Note**  
Note that this example makes extensive use of [Expressions](iot-tg-models-tdm-expressions.html)\. For more information about how to construct and use expressions, see [Expressions](iot-tg-models-tdm-expressions.html)\.

```
query AlexandriaSecuritySystem @deployment(id: "urn:tdm:aws:deployment:AlexandriaSecuritySystem", systemId: "urn:tdm:aws:system:SecuritySystem") {
    entrySensor(deviceId: "ABC123")
    entryCamera(deviceId: "XYZ987")
   
    triggers {
      MotionDetectedTrigger(description: "an example trigger") {
        condition(expr: "devices[name == 'entrySensor'].events[name == 'motionDetected'].lastEvent.value")          # Path expressions used inside a predicate expression
        action(expr: "ThingsGraph.startFlow('motionDetectionFlow', devices.entrySensor.motionEvent)")               # Initiate workflow
     
      MotionEndedTrigger(description: "an example trigger") {
        condition(expr: "devices[name == 'entrySensor'].events[name == 'motionDetected'].lastEvent.value == false") #Path expressoins used inside a predicate expression.
        action(expr: "ThingsGraph.startFlow('motionDetectionFlow', devices.entrySensor.motionEvent)")               # Initiate workflow
        action(expr: "ThingsGraph.startFlow('logEventFlow')")                                                       # Initiate workflow
      }
    }
  }
}
```

The first condition uses two path expressions to identify a device that is used in a workflow and one of that device's events, with a predicate expression that determines whether the device has detected motion\. The `devices[name == 'entrySensor'].events[name == 'motionDetected'].lastEvent.value` expression evaluates to true if the `lastEvent` value sent by the `entrySensor` device is true, a non\-empty string, or a numeric value other than 0\. This signifies that a motion detected event has occurred\.

The second condition uses the same combination of path expressions inside a predicate expression to determine whether a given motion has ended\. The `devices[name == 'entrySensor'].events[name == 'motionDetected'].lastEvent.value == false` evaluates to true if the `lastEvent` value sent by the `entrySensor` device is false, an empty string, or 0\. This signifies that the sensor is no longer detecting motion\.

TDM also supports time intervals as conditional expressions\. For example, if you want an action to occur every 5 minutes, you can specify that interval in the condition, as in the following example\.

```
                    condition(expr: "every 5 minutes")
```

You can express the duration of a time interval in a condition expression with the following values:
+ Seconds
+ Minutes
+ Hours
+ Days
+ Weeks
+ Months
+ Years

The actions specified in this definition use the `ThingsGraph.startFlow` function\. This function initiates the specified workflow and, where necessary, sends the `devices.entrySensor.motionEvent` to the workflow\.