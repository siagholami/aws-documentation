--------

--------

# Trigger<a name="iot-tg-models-tdm-iot-trigger"></a>

The `Trigger` construct defines the conditions that start a workflow\.

[Workflows](iot-tg-models-tdm-iot-workflow.html) can take parameters, including the device IDs to use in the workflow and other variables that help dictate the flow of control\. The parameters of a workflow are specified in the [System Deployment Configuration](iot-tg-models-tdm-iot-sdc-deployconfig.html) \(SDC\)\. SDC triggers have two components: a condition and some number of actions\. The condition specifies whether to trigger a new flow, and an action specifies exactly what to do if the condition is true\.

Because the parameters and triggers for a workflow are defined in a [Deployment Configuration](iot-tg-models-tdm-iot-sdc-deployconfig.html), expressions are also useful in that context\. Triggers have two components: a condition and a set of one or more actions\. The condition specifies whether to trigger a new workflow, and an action specifies what the workflow does if the condition is true\. The following example shows some ways of using expressions in the context of deployment configurations\. This example also appears in [Deployment Configuration](iot-tg-models-tdm-iot-sdc-deployconfig.html)\.

```
query AlexandriaSecuritySystem @deployment(id: "urn:tdm:aws:deployment:AlexandriaSecuritySystem", systemId: "urn:tdm:aws:system:SecuritySystem") {
    entrySensor(deviceId: "ABC123")
    entryCamera(deviceId: "XYZ987")
   
    triggers {
      MotionDetectedTrigger(description: "an example trigger") {
        condition(expr: "devices[name == 'entrySensor'].events[name == 'motionDetected'].lastEvent.value")          # Path expressions used inside a predicate expression
        action(expr: "ThingsGraph.startFlow('motionDetectionFlow', devices.entrySensor.motionEvent)")               # Initiate workflow
     
      MotionEndedTrigger(description: "an example trigger") {
        condition(expr: "devices[name == 'entrySensor'].events[name == 'motionDetected'].lastEvent.value == false") # Path expressions used inside a predicate expression.
        action(expr: "ThingsGraph.startFlow('motionDetectionFlow', devices.entrySensor.motionEvent)")               # Initiate workflow
        action(expr: "ThingsGraph.startFlow('logEventFlow')")                                                       # Initiate workflow
      }
    }
  }
}
```

The first condition uses two path expressions to identify a device that is used in a workflow and one of that device's events, with a predicate expression that determines whether the device has detected motion\. The `devices[name == 'entrySensor'].events[name == 'motionDetected'].lastEvent.value` expression evaluates to true if the `lastEvent` value sent by the `entrySensor` device is true, a non\-empty string, or a numeric value other than 0\. This signifies that a motion detected event has occurred\.

The second condition uses the same combination of path expressions inside a predicate expression to determine whether a given motion has ended\. The `devices[name == 'entrySensor'].events[name == 'motionDetected'].lastEvent.value == false` evaluates to true if the `lastEvent` value sent by the `entrySensor` device is false, an empty string, or 0\. This signifies that the sensor is no longer detecting motion\.

The actions specified in this definition use the `ThingsGraph.startFlow` function, which initiates the specified workflow and, where necessary, sends the `devices.entrySensor.motionEvent` to the workflow\.

TDM also supports time intervals as conditional expressions in triggers\. For example, if you want an action to occur every 5 minutes, you can specify that interval in the condition, as in the following example\.

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

The actions specified in this definition use the `ThingsGraph.startFlow` function, which initiates the specified workflow and, where necessary, sends the `devices.entrySensor.motionEvent` to the workflow\.

For more information about the types of expressions that you can use in TDM, see [Expressions](iot-tg-models-tdm-expressions.html)\.