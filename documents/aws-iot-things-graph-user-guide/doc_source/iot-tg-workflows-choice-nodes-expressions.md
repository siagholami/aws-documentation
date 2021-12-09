--------

--------

# Using Conditional Logic in Choice Nodes<a name="iot-tg-workflows-choice-nodes-expressions"></a>

[AWS IoT Things Graph Data Model expressions](iot-tg-models-tdm-expressions.html) provide a way to express conditional logic in choice nodes\. This topic shows you how to implement these expressions in the AWS IoT Things Graph console\. It also shows you how to include variables and logical operators in expressions\. This topic assumes that you've read [Working with Choice Nodes](iot-tg-workflows-choice-nodes.html)\.

**Topics**
+ [Adding Choice Nodes and Rules to Your Flow](#iot-tg-workflows-choice-nodes-expressions-adding)
+ [Writing Expressions in Rules](#iot-tg-workflows-choice-nodes-expressions-writing)

## Adding Choice Nodes and Rules to Your Flow<a name="iot-tg-workflows-choice-nodes-expressions-adding"></a>

A choice node follows one or more steps in a flow that generate output that the flow uses to make decisions about what steps happen next\. The following image shows this sort of decision point\. 

**Example**  
A clock triggers a service that checks the time of day every hour\. A choice node decides whether to turn a light on or off depending on the current time\.  

![\[The flow designer canvas displays a clock trigger and a Lambda service that checks the hour of the day.\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/things-graph-choice-node-start.png)

**To add a choice node to your flow**

1. Choose the **Logic** tab on the right side of the flow designer\.  
![\[The choice node is the first option in the Logic tab.\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/things-graph-choice-node.png)

1. Choose **Choice** and drag it into the flow designer\.

1. Connect a step in the flow \(represented by a device or service\) to the choice node\. The flow designer displays an event between the device or service and the choice node\. You can replace the default name of this event\.

1. Connect the choice node to two or more devices and services\. These devices and services represent steps in the flow\. The flow designer displays an event between the choice node and each of the steps to which you've connected the choice node\. These events are named after events that you create in the choice node\.

1. Select the choice node\. The flow designer displays a choice activity editor in the right pane\.  
![\[The choice activity editor contains a text box for the choice title, a rule named Rule A, and a default rule.\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/things-graph-choice-node-ruleA-event.png)

The choice activity editor displays a text box that you use to add an optional title\. The editor also contains one rule named **Rule A** and a default rule\. Choose **Add rule** to add more rules\.

**Example**  
The following image shows what the flow designer canvas looks like when you configure the choice node and connect it to the potential next steps \(the light turns on or off\)\.  

![\[The flow designer canvas displays the complete flow, containing the clock trigger, the Lambda service that checks the hour of the day, the configured choice node, and the steps that turn the light on or off.\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/things-graph-choice-node-flow.png)

Rules tie conditions to events\. If a condition in the rule is met, the choice node fires an event specified in the rule\. You name each event that follows the choice node after the events that you create in the rules\. The default rule specifies which event to use when conditions in the other rules aren't met\. The default rule is required\. The events connect the choice node to conditional steps in the flow\.

## Writing Expressions in Rules<a name="iot-tg-workflows-choice-nodes-expressions-writing"></a>

Each rule \(except the default rule\) must contain a condition, and you express each condition with an AWS IoT Things Graph Data Model expression\. This section explains how to incorporate variables and logic in expressions\.

### Using Variable Values in Rules<a name="iot-tg-workflows-choice-nodes-expressions-writing-variables"></a>

If your expression consists of a simple operation on a variable or path, you can access its value by using the name of the variable or path, as in the following examples\.

```
            ${getHourResult < 14}
            ${getHourResultA > getHourResultB}
            ${image.width == 32}
```

The following table lists the data types of the values used in these expressions\.


| Data type | Value | 
| --- | --- | 
| getHourResult | Int | 
| getHourResultA | Int | 
| getHourResultB | Int | 
| image\.width | An Image object with a width property of type Int\. | 

### String Concatenation<a name="iot-tg-workflows-choice-nodes-expressions-writing-macro"></a>

The following example shows how to concatenate strings inside expressions\.

```
            ${message == "Current time: " + getHourResult}
```

The following table lists the data types of the values used in this expression\.


| Data type | Value | 
| --- | --- | 
| message | String | 
| getHourResult | Int | 

### Logical Operators<a name="iot-tg-workflows-choice-nodes-expressions-writing-logic"></a>

Use the following operators for logical AND, OR, and NOT\.


| Logic | Operator | 
| --- | --- | 
| AND | && | 
| OR | \|\| | 
| NOT | \! | 

**Example**  

```
            ${image.height == 32 && image.width == 55}
            ${getHourResult == 14 || !isDay}
            ${!isNight}
```

The following table lists the data types of the values used in this expression\.


| Data type | Value | 
| --- | --- | 
| image\.height | An Image object with a width property of type Int\. | 
| getHourResult | Int | 
| isDay | Boolean | 
| isNight | Boolean | 