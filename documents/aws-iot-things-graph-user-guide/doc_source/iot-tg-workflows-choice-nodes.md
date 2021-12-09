--------

--------

# Working with Choice Nodes<a name="iot-tg-workflows-choice-nodes"></a>

Choice nodes enable you to include conditional logic during the execution of a flow\. This topic describes how to use the choice node editor in the AWS IoT Things Graph console\. 

This topic shows you how to use choice nodes to create a time\-based flow that turns a light on and off depending on the time of day\. It assumes that your namespace includes a service that implements an AWS Lambda function that returns the hour of the day as an `Int`\. It also assumes that your namespace contains a device model for a light that has `TurnOn` and `TurnOff` actions\.

This example is for demonstration purposes only\. You can apply the approach in this example any workflow \(flow\) that contains the following elements\.
+ A service that implements a Lambda function that returns information about a current condition, such as time or temperature\.

  For information about how to create a service, see [Service Modeling 101](iot-tg-models-service101.html)\.
+ A device or device model that contains the equivalent of `TurnOn` and `TurnOff` actions\.

  For examples that show how to create devices with actions, see [Example Device and Service Definitions](iot-tg-examples.html)\. For more detailed information about creating a model, see [AWS IoT Things Graph Data Model Reference](iot-tg-models.html)\.

The instructions in this topic create the following flow\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/things-graph-choice-node-flow.png)

## Create the Flow<a name="iot-tg-workflows-choice-nodes-flow"></a>

The following instructions describe how to place all of the elements of the flow \(devices, service, events, and choice node\) into the flow designer\.

1. Open the [AWS IoT Things Graph console](https://console.aws.amazon.com/thingsgraph/home), and then choose **Create flow**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGConsoleCreateFlow.png)

1. Create a flow\.

   In the **Flow configuration** pane, name your flow \(such as **LightFlow**\)\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGFlowCNConfig.png)

1. Add the elements to the flow\.

   On the **Logic** tab, choose **Clock**, and then drag it into the flow designer\.

   On the **Service** tab, search for your Lambda service\. Choose the service and drag it into the flow designer\.

   On the **Logic** tab, choose **Choice**, and then drag it into the flow designer\.

   On the **Devices** tab, choose your device or device model, and then drag it into the flow designer\. Drag this same device into the flow designer a second time\.

   The two instances of the device or device model represent different steps that can occur in the flow, depending on the choice node output\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGFlowCNElements.png)

1. Connect the flow elements\.

   In the flow designer, connect the **ClockTrigger** to the Lambda function\. Connect the Lambda function to the choice node\. Connect the choice node to both instances of the device\.

   The flow designer displays one event between the Lambda function and the choice node, and one event between the choice node and each instance of the device or device model\. You can change the default name of the event that follows the Lambda function\. The other events will be named after events that you create in the choice node\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGFlowCNConnections.png)

## Configure Events and Choice Node Logic<a name="iot-tg-workflows-choice-nodes-logic"></a>

The following instructions describe how to configure the trigger logic, service output, and choice node logic in the flow\.

1. Configure the clock trigger\.

   In the flow designer, select the **ClockTrigger**\. In the trigger editor that appears in the right pane, for **Frequency**, enter **1**, and then select hours from the menu on the right\. For **Action**, choose **ThingsGraph\.startFlow**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGFlowCNTrigger.png)

1. Configure the output of the Lambda service\.

   In the flow designer, select the service\. In the action editor that appears in the right pane, select **No action configured**\. Select the action that generates the output for the choice node\. Provide a variable name to store the output\. The logic in the choice node uses the value or values in this output to create events\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGFlowCNLamAction.png)

1. Name the choice node\.

   In the flow designer, select the choice node\. In the choice editor that appears in the right pane, enter a value for **Choice title**\.

1. Configure the condition for the first rule in the choice node\.

   Expand **Rule A**\. Optionally, enter a title for the rule\.

   Enter an [expression](iot-tg-models-tdm-expressions.html) that evaluates the output from the Lambda service\. In this example, the rule evaluates the current hour to determine whether the current hour is at night: `${getHourResult > 14}`\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/things-graph-choice-node-ruleA.png)

1. Configure the event for the first rule in the choice node\.

   Choose **Add event**\. Enter an event name\. In this example, the rule creates an event named `isNight` whenever the expression in the condition evaluates to `true`\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/things-graph-choice-node-ruleA-event.png)

1. Configure the condition for the second rule in the choice node\.

   Choose **Add rule**\. Expand **Rule B**\. Optionally, enter a title for the rule\.

   Enter an [expression](iot-tg-models-tdm-expressions.html) that evaluates the output from the Lambda service\. In this example, the rule evaluates the current hour to determine whether the current hour is in the daytime: `${getHourResult <= 13}`\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/things-graph-choice-node-ruleB.png)

1. Configure the event for the second rule in the choice node\.

   Choose **Add event**\. Enter an event name\. In this example, the rule creates an event named `isDay` whenever the expression in the condition evaluates to `true`\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/things-graph-choice-node-ruleB-event.png)

1. Configure the default event in the choice node\.

   Expand **Default rule**\. This rule determines what happens when the output from the previous step is unexpected\. You can create new events and variables for this rule\. This example defaults to the `isNight` event\.
**Note**  
The default event is required\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/things-graph-choice-node-defaultrule.png)

1. Name the events connected to each instance of the device\.

   Choose one of the events that follow the choice node\. Enter the name of one of events that you created in the choice node\. Choose the other event, and enter the name of the other choice node event\. When you start typing, the flow designer prompts you to autocomplete the events that you created in the choice node\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGFlowCNConnectEvents.png)

1. Configure the device actions\.

   Select the device or device model that is connected to the `isNight` event\. Choose **No action configured**, and select the `turnOn` action\.

   Select the device or device model that is connected to the `isDay` event\. Choose **No action configured**, and select the `turnOff` action\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/things-graph-choice-node-flow.png)

In this example, the same device executes one of two possible steps, depending on the events that are emitted by the choice node\. The same device can be used in multiple steps and perform different actions depending on the events emitted by the choice node\. You can use choice nodes to execute more complex logic depending on the number of rules, the complexity of the expressions in the rules, and the number of variables that you create\.

For more information about expressions in choice nodes, see [Using Conditional Logic in Choice Nodes](iot-tg-workflows-choice-nodes-expressions.html)\.