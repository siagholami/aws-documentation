# Troubleshooting AWS IoT Events<a name="iotevents-troubleshooting"></a>

See the following section to troubleshoot errors and find and possible solutions to resolve issues with AWS IoT Events\.

**Topics**
+ [I get errors when I attempt to create a detector model\.](#detector-model)
+ [I get state updates from the old detector model through MQTT messages or SNS alerts after I deleted or updated a detector model a few minutes ago\.](#update-detector-model)
+ [The detector fails to trigger an action or transition to a new state when the condition is met\.](#no-action)
+ [Detectors don't trigger an action or a transition event when the variable reaches the specified value\.](#trigger-action)
+ [The detector enters the wrong states when I attempt to send messages to inputs by using `BatchPutMessage`\.](#wrong-state)
+ [I get a ` ('Connection aborted.', error(54, 'Connection reset by peer'))` error when I attempt to call or invoke an API\.](#connection-aborted-error)
+ [I get InvalidRequestException when I attempt to call `CreateDetectorModel` and `UpdateDetectorModel` APIs\.](#invalid-request)
+ [Amazon CloudWatch Logs contains error messages, when I use `action.setTimer`\.](#cw-logs-timer)
+ [Amazon CloudWatch Logs contains error and warning messages, when I use payload\.](#cw-logs-payload)
+ [Error: Incompatible data types \[<inferred\-types>\] found for <reference> in the following expression: <expression>](#troubleshoot-expressions-incompatible-data-types)

## I get errors when I attempt to create a detector model\.<a name="detector-model"></a>

**Solution:** When you create a detector model, make sure that you consider the following limitations\. 
+ Only one action is allowed in each `action` field\. 
+ The `condition` is required for `transitionEvents`\. It's optional for `OnEnter`, `OnInput`, and `OnExit` events\. 
+ If the `condition` field is empty, the evaluated result of the condition expression is equivalent to `true`\. 
+ The evaluated result of the condition expression should be a Boolean value\. If the result isn't a Boolean value, it's equivalent to `false` and doesn't trigger the `actions` or transition to the `nextState` specified in the event\. 

For more information, see [Detector model restrictions and limitations](iotevents-restrictions-detector-model.md)\. 

## I get state updates from the old detector model through MQTT messages or SNS alerts after I deleted or updated a detector model a few minutes ago\.<a name="update-detector-model"></a>

**Solution:** If you update, delete, or recreate a detector model \(see [UpdateDetectorModel](https://docs.aws.amazon.com/iotevents/latest/apireference/API_UpdateDetectorModel.html)\), there is some delay before all spawned detectors \(instances\) are deleted and the new model is used to recreate the detectors\. They are recreated after the new detector model takes effect and new inputs arrive\. During this time, inputs might continue to be processed by the detectors spawned by the previous version of the detector model\. During this period, you might continue to receive alerts defined by the previous detector model\. Wait for at least seven minutes before you recheck the update or report an error\. 

## The detector fails to trigger an action or transition to a new state when the condition is met\.<a name="no-action"></a>

**Solution:** Verify that the evaluated result of the condition expression is a Boolean value\. If the result isn't a Boolean value, it's equivalent to `false` and doesn't trigger the `action` or transition to the `nextState` specified in the event\. For more information, see [Conditional expression syntax](https://docs.aws.amazon.com/iotevents/latest/developerguide/iotevents-conditional-expressions.html)\. 

## Detectors don't trigger an action or a transition event when the variable reaches the specified value\.<a name="trigger-action"></a>

**Solution:** If you update `setVariable` for `onInput`, `onEnter`, or `onExit`, the new value isn't used when evaluating any `condition` during the current processing cycle\. Instead, the original value is used until the current cycle is complete\. You can change this behavior by setting the `evaluationMethod` parameter in the detector model definition\. When `evaluationMethod` is set to `SERIAL`, variables are updated and event conditions evaluated in the order that the events are defined\. When `evaluationMethod` is set to `BATCH` \(the default\), variables are updated and events performed only after all event conditions are evaluated\. 

## The detector enters the wrong states when I attempt to send messages to inputs by using `BatchPutMessage`\.<a name="wrong-state"></a>

**Solution:** If you use [BatchPutMessage](https://docs.aws.amazon.com/iotevents/latest/apireference/API_iotevents-data_BatchPutMessage.html) to send multiple messages to inputs, the order in which the messages or inputs are processed isn't guaranteed\. To guarantee ordering, send messages one at time and wait each time for `BatchPutMessage` to acknowledge success\. 

## I get a ` ('Connection aborted.', error(54, 'Connection reset by peer'))` error when I attempt to call or invoke an API\.<a name="connection-aborted-error"></a>

**Solution:** Verify that OpenSSL uses TLS 1\.1 or a later version to establish the connection\. This should be the default under most Linux distributions or Windows version 7 and later\. Users of macOS might need to upgrade OpenSSL\.

## I get InvalidRequestException when I attempt to call `CreateDetectorModel` and `UpdateDetectorModel` APIs\.<a name="invalid-request"></a>

**Solution:** Check the following to help resolve the issue\. For more information, see [CreateDetectorModel](https://docs.aws.amazon.com/iotevents/latest/apireference/API_CreateDetectorModel.html) and [UpdateDetectorModel](https://docs.aws.amazon.com/iotevents/latest/apireference/API_UpdateDetectorModel.html)\.
+ Make sure that you don't use both `seconds` and `durationExpression` as the parameters of `SetTimerAction` at the same time\.
+ Make sure that your string expression for `durationExpression` is valid\. The string expression can contain numbers, variables \(`$variable.<variable-name>`\), or input values \(`$input.<input-name>.<path-to-datum>`\)\.

## Amazon CloudWatch Logs contains error messages, when I use `action.setTimer`\.<a name="cw-logs-timer"></a>

You can set up Amazon CloudWatch Logs to monitor AWS IoT Events detector model instances\. The following are common errors generated by AWS IoT Events, when you set the timer\. 
+ **Error:** Your duration expression for the timer named <timer\-name> could not be evaluated to a number\.

  **Solution:** Make sure that your string expression for `durationExpression` can be converted to a number\. Other data types, such as Boolean, aren't allowed\.
+ **Error:** The evaluated result of your duration expression for the timer named <timer\-name> is greater than 31622440\. To ensure accuracy, make sure that your duration expression refers to a value between 60\-31622400\.

  **Solution:** Make sure that the duration of your timer is less than or equal to 31622400 seconds\. The evaluated result of the duration is rounded down to the nearest whole number\.
+ **Error:** The evaluated result of your duration expression for the timer named <timer\-name> is less than 60\. To ensure accuracy, make sure that your duration expression refers to a value between 60\-31622400\.

  **Solution:** Make sure that the duration of your timer is greater than or equal to 60 seconds\. The evaluated result of the duration is rounded down to the nearest whole number\.
+ **Error:** Your duration expression for the timer named <timer\-name> could not be evaluated\. Check the variable names, input names, and paths to the data to make sure that you refer to the existing variables and inputs\. 

  **Solution:** Make sure that your string expression refers to the existing variables and inputs\. The string expression can contain numbers, variables \(`$variable.variable-name`\), and input values \(`$input.input-name.path-to-datum`\)\.
+ **Error:** Failed to set the timer named <timer\-name>\. Check your duration expression, and try again\.

  **Solution:** See the [SetTimerAction](https://docs.aws.amazon.com/iotevents/latest/apireference/API_SetTimerAction.html) action to ensure that you specified the correct parameters, and then set the timer again\. 

For more information, see [ Enable Amazon CloudWatch logging when developing AWS IoT Events detector models](https://docs.aws.amazon.com/iotevents/latest/developerguide/best-practices.html#best-practices-cw-logs)\. 

## Amazon CloudWatch Logs contains error and warning messages, when I use payload\.<a name="cw-logs-payload"></a>

You can set up Amazon CloudWatch Logs to monitor AWS IoT Events detector model instances\. The following are common errors and warnings generated by AWS IoT Events, when you configure the action payload\. 
+ **Error:** We couldn't evaluate your expression for the action\. Make sure that the variable names, input names, and paths to the data refer to the existing variables and input values\. Note that the maximum allowable size of the payload is 1 KB\.

  **Solution:** Make sure that you enter the correct variable names, input names, and paths to the data\. You might also receive this error message if the action payload is larger than 1 KB\.
+ **Error:** We couldn't parse your content expression for the payload of <action\-type>\. Enter a content expression with the correct syntax\.

  **Solution:** The content expression can contain strings \(`'string'`\), variables \(`$variable.variable-name`\), input values \(`$input.input-name.path-to-datum`\), string concatenations, and strings that contain `${}`\.
+ **Error:** Your payload expression \{*expression*\} isn't valid\. The defined payload type is JSON, so you must specify an expression that AWS IoT Events would evaluate to a string\.

  **Solution:** If the specified payload type is JSON, AWS IoT Events first checks if the service can evaluate your expression to a string \. The evaluated result can't be a Boolean or number\. If the validation fails, you might receive this error\.
+ **Warning:** The action was executed, but we couldn't evaluate your content expression for the action payload to valid JSON\. The defined payload type is JSON\.

  **Solution:** Make sure that AWS IoT Events can evaluate your content expression for the action payload to valid JSON, if you define the payload type as `JSON`\. AWS IoT Events executes the action even if AWS IoT Events can't evaluate the content expression to valid JSON\.

For more information, see [ Enable Amazon CloudWatch logging when developing AWS IoT Events detector models](https://docs.aws.amazon.com/iotevents/latest/developerguide/best-practices.html#best-practices-cw-logs)\.

## Error: Incompatible data types \[<inferred\-types>\] found for <reference> in the following expression: <expression><a name="troubleshoot-expressions-incompatible-data-types"></a>

**Solution:** You might receive this error for one of the following reasons:
+ The evaluated results of your references are not compatible with other operands in your expressions\.
+ The type of the argument passed to a function is not supported\.

When you use references in expressions, check the following:<a name="expression-reference-type-compatibility"></a>
+ When you use a reference as an operand with one or more operators, make sure that all data types that you reference are compatible\.

  For example, in the following expression, integer `2` is an operand of both the `==` and `&&` operators\. To ensure that the operands are compatible, `$variable.testVariable + 1` and `$variable.testVariable` must reference an integer or decimal\.

  In addition, integer `1` is an operand of the `+` operator\. Therefore, `$variable.testVariable` must reference an integer or decimal\.

  ```
  ‘$variable.testVariable + 1 == 2 && $variable.testVariable’
  ```
+ When you use a reference as an argument passed to a function, make sure that the function supports the data types that you reference\.

  For example, the following `timeout("time-name")` function requires a string with double quotes as the argument\. If you use a reference for the *timer\-name* value, you must reference a string with double quotes\.

  ```
  timeout("timer-name")
  ```
**Note**  
For the `convert(type, expression)` function, if you use a reference for the *type* value, the evaluated result of your reference must be `String`, `Decimal`, or `Boolean`\.

For more information, see [References](expression-syntax.md#expression-reference)\. 