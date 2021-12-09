--------

--------

# Adding Triggers to Flows<a name="iot-tg-workflows-logic"></a>

[Triggers](iot-tg-models-tdm-iot-trigger.html) enable you to include [expressions](iot-tg-models-tdm-expressions.html) in your flows\. You can create triggers that are time based, or that are tied to an event that occurs on a device\.

You add time\-based triggers to a flow using the **Logic** tab in the flow designer in the AWS IoT Things Graph console\. A time\-based trigger starts a flow after an interval of time that you define passes\. 

You can also use a device as a trigger if its capability contains at least one event\. You specify a set of conditions that the event creates that triggers the flow\.

This topic describes how to use the AWS IoT Things Graph console to include time\-based and device triggers in your flows\.

## Time\-Based Triggers<a name="iot-tg-workflows-logic-triggers-time"></a>

To include a time\-based trigger, on the **Logic** tab, choose **Clock**, and then drag it into the flow designer\. This adds a node named **ClockTrigger** to the designer\. 

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGClockTrigger.png)

In the trigger editor that appears in the right pane, for **Frequency**, enter any number\. Then from the menu on the right, select the type of time interval to use\. Your choices are **seconds**, **minutes**, **hours**, **days**, **weeks**, **months**, and **years**\. 

For **Action**, choose **ThingsGraph\.startFlow**\. This is currently the only option for **Action**\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGClockTriggerPopulated.png)

## Device Triggers<a name="iot-tg-workflows-logic-triggers-device"></a>

When you include a device that has one or more events and no actions in its capability, the device is automatically a trigger, and the **Set as Trigger** switch in the right pane is disabled\. This sort of device can only be a trigger and never a step in a flow\. 

When you use an event that has one or more actions and no events in its capability, the device is automatically a step and the **Set as Trigger** switch is disabled\.

When you include a device that has one or more events and one or more actions, the device is a step by default, but the **Set as Trigger** switch is enabled\. If you choose to set the device as a trigger, the trigger editor appears in the right pane\. From the **Condition event** menu in this editor, select the event to use\. For **Action**, choose **ThingsGraph\.startFlow**\. This is currently the only option for **Action**\.

The following screenshot shows a button that has a `ButtonPressed` event in its capability\. This event is selected under **Condition event**\. The `ButtonPressed` event returns a payload that consists of one Boolean value named `isLightOn`\. This value is stored in the `lastEvent` variable\. The `lastEvent` variable stores values emitted by the trigger device's last event\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGButtonTrigger.png)

You can use the values stored in the `lastEvent` variable to write an expression that starts a flow whenever a condition is met\. You enter this expression in the **Condition expression** field\. In this case, the button's `ButtonPressed` event starts the flow when the value of `lastEvent.isLightOn` is `false`\. To start the flow every time the event occurs, leave the **Condition expression** field blank\.

You can write more complex expressions depending on the number and types of values emitted by the trigger event\. For example, if a device emits a `lastEvent` variable that two properties named `type` and `value`, you could write the following expression\.

`lastEvent.type == "measurement" && lastEvent.value > 60 `

## Triggers and Flow Configurations<a name="iot-tg-workflows-logic-triggers-configs"></a>

When you create a flow configuration, the trigger in the flow can't be updated\. When you update a trigger in a flow, you must create and deploy a new flow configuration that contains the updated trigger\. Triggers in existing flow configurations can't be updated\.