# Using built\-in actions<a name="built-in-actions"></a>

<a name="build-in-actions-intro"></a>AWS IoT Events supports the following actions that let you use a timer or set a variable:<a name="build-in-actions"></a>
+ [`setTimer`](#iotevents-set-timer) to create a timer\.
+ [`resetTimer`](#iotevents-reset-timer) to reset the timer\.
+ [`clearTimer`](#iotevents-clear-timer) to delete the timer\.
+ [`setVariable`](#iotevents-set-variable) to create a variable\.

## Set timer action<a name="iotevents-set-timer"></a>

------
#### [ Set timer action ]

The `setTimer` action lets you create a timer with duration in seconds\. 

------
#### [ More information \(2\) ]

When you create a timer, you must specify the following parameters\.

**`timerName`**  
The name of the timer\.

**`durationExpression`**  
\(Optional\) The duration of the timer, in seconds\.  
The evaluated result of a duration expression is rounded down to the nearest whole number\. For example, if you set the timer to 60\.99 seconds, the evaluated result of the duration expression is 60 seconds\.

For more information, see [SetTimerAction](https://docs.aws.amazon.com/iotevents/latest/apireference/API_SetTimerAction.html) in the *AWS IoT Events API Reference*\.

------

## Reset timer action<a name="iotevents-reset-timer"></a>

------
#### [ Reset timer action ]

The `resetTimer` action lets you set the timer to the previously evaluated result of the duration expression\.

------
#### [ More information \(1\) ]

When you reset a timer, you must specify the following parameter\.

**`timerName`**  
The name of the timer\.  
AWS IoT Events doesn't reevaluate the duration expression when you reset the timer\.

For more information, see [ResetTimerAction](https://docs.aws.amazon.com/iotevents/latest/apireference/API_ResetTimerAction.html) in the *AWS IoT Events API Reference*\.

------

## Clear timer action<a name="iotevents-clear-timer"></a>

------
#### [ Clear timer action ]

The `clearTimer` action lets you delete an existing timer\.

------
#### [ More information \(1\) ]

When you delete a timer, you must specify the following parameter\.

**`timerName`**  
The name of the timer\.

For more information, see [ClearTimerAction](https://docs.aws.amazon.com/iotevents/latest/apireference/API_ClearTimerAction.html) in the *AWS IoT Events API Reference*\.

------

## Set variable action<a name="iotevents-set-variable"></a>

------
#### [ Set variable action ]

The `setVariable` action lets you create a variable with a specified value\.

------
#### [ More information \(2\) ]

When you create a variable, you must specify the following parameters\.

**`variableName`**  
The name of the variable\.

**`value`**  
The new value of the variable\.

For more information, see [SetVariableAction](https://docs.aws.amazon.com/iotevents/latest/apireference/API_SetVariableAction.html) in the *AWS IoT Events API Reference*\.

------