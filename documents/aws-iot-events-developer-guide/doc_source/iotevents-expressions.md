# Using expressions<a name="iotevents-expressions"></a>

You can specify `actions` and `conditions` in a detector model in the following ways:
+ Enter supported expressions in the AWS IoT Events console\.
+ Pass the expressions to the AWS IoT Events APIs as parameters\.

## Usage<a name="expression-usage"></a>

The following AWS IoT Events APIs support expressions\. 

**`condition`**  
A condition expression builds the logic that determines if the state of a device or process has changed and if an action should be taken\. The evaluated result of the condition expression should be a Boolean value\. If the result isn't a Boolean value, it's equivalent to `false` and doesn't trigger the `actions`\.   
For more information, see [Event](https://docs.aws.amazon.com/iotevents/latest/apireference/API_Event.html)\.

**`mqttName`**  
An MQTT name expression defines an MQTT topic name when you publish message to an AWS IoT Core topic\. You can also define the MQTT topic name dynamically at runtime\. The expression can include variables \(`$variable.variable-name`\) and input values \(`$input.input-name.path-to-datum`\)\.   
For more information, see [IotTopicPublishAction](https://docs.aws.amazon.com/iotevents/latest/apireference/API_IotTopicPublishAction.html)\.

**`durationExpression`**  
A duration expression sets a timer\. The duration expression can include numbers, variables \(`$variable.variable-name`\), and input values \(`$input.input-name.path-to-datum`\)\. The evaluated result of the duration expression is rounded down to the nearest whole number\.   
For more information, see [SetTimerAction](https://docs.aws.amazon.com/iotevents/latest/apireference/API_SetTimerAction.html)\.

**`contentExpression`**  
A content expression configures an action payload when a specified `action` is triggered\. The content expression can include strings \(`'string'`\), variables \(`$variable.variable-name`\), input values \(`$input.input-name.path-to-datum`\), string concatenations, and strings that contain `${}`\.   
The following is a JSON payload example\.   

```
'{\"heartbeat_id\": \"${$input.HeartbeatInput.heartbeat_id}\", \"offline\": \"${$variable.offline}\"}'
```
For more information, see [Payload](https://docs.aws.amazon.com/iotevents/latest/apireference/API_Payload.html)\. 