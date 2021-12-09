# Syntax<a name="expression-syntax"></a>

You can use literals, operators, functions, references, and substitution templates in the AWS IoT Events expressions\.

## Literals<a name="expression-literal"></a>
+ Integer
+ Decimal
+ String
+ Boolean

## Operators<a name="expression-operator"></a>

Unary  
+ Not \(Boolean\): `!`
+ Not \(bitwise\): `~`
+ Minus \(arithmetic\): `-`

String  
+ Concatenation: **`+`**

  Both operands must be strings\. String literals must be enclosed in single quotes \('\)\.

  For example: `'my' + 'string'` \-> `'mystring'`

Arithmetic  
+ Addition: **`+`**

  Both operands must be numeric\.
+ Subtraction: **`-`**
+ Division: **`/`**

  The result of the division is a rounded integer value unless at least one of the operands \(divisor or dividend\) is a decimal value\.
+ Multiplication: **`*`**

Bitwise \(Integer\)  
+ OR: **`|`**

  For example: `13 | 5` \-> `13`
+ AND: **`&`**

  For example: `13 & 5` \-> `5`
+ XOR: **`^`**

  For example: `13 ^ 5` \-> `8`
+ NOT: **`~`**

  For example: `~13` \-> `-14`

Boolean  
+ Less Than: **`<`**
+ Less Than Or Equal To: **`<=`**
+ Equal To: **`==`**
+ Not Equal To: **`!=`**
+ Greater Than Or Equal To: **`>=`**
+ Greater Than: **`>`**
+ AND: **`&&`**
+ OR: **`||`**
**Note**  
When a subexpression of `||` contains undefined data, that subexpression is treated as `false`\.

Parentheses  
You can use parentheses to group terms within an expression\.

## Functions<a name="expression-function"></a>

Built\-in Functions    
`timeout("timer-name")`  
Evaluates to `true` if the specified timer has elapsed\. Replace "**timer\-name**" with the name of a timer that you defined, in quotation marks\. In an event action, you can define a timer and set it running, reset it, or clear one that you previously defined\. See the field `detectorModelDefinition.states.onInput|onEnter|onExit.events.actions.setTimer.timerName`\.   
A timer set in one state can be referenced in another\. But you must ensure that the state in which it is set is always visited before the state in which it's referenced\.  
To ensure accuracy, the minimum time that a timer should be set is 60 seconds\.  
`timeout()` returns `true` only the first time it's checked following the actual timer expiration and returns `false` thereafter\.  
`convert(type, expression)`  
Evaluates to the value of the expression converted to the specified type\. The *type* value must be `String`, `Boolean`, or `Decimal`\. Use one of these keywords or an expression that evaluates to a string containing the keyword\. Only the following conversions succeed and return a valid value:   
+ Boolean \-> string

  Returns the string `"true"` or `"false"`\.
+ Decimal \-> string
+ String \-> Boolean
+ String \-> decimal

  The string specified must be a valid representation of a decimal number, or `convert()` fails\.
If `convert()` doesn't return a valid value, the expression that it's a part of is also invalid\. This result is equivalent to `false` and won't trigger the `actions` or transition to the `nextState` specified as part of the event in which the expression occurs\.  
`isNull(expression)`  
Evaluates to `true` if the expression returns null\. For example, if the input `MyInput` receives the message `{ "a": null }`, then the following evaluates to `true`, but `isUndefined($input.MyInput.a)` evaluates to `false`\.  

```
isNull($input.MyInput.a)
```  
`isUndefined(expression)`  
Evaluates to `true` if the expression is undefined\. For example, if the input `MyInput` receives the message `{ "a": null }`, then the following evaluates to `false`, but `isNull($input.MyInput.a)` evaluates to `true`\.  

```
isUndefined($input.MyInput.a)
```  
`triggerType("type")`  
The *type* value can be `"Message"` or `"Timer"`\. Evaluates to `true` if the event condition in which it appears is being evaluated because a timer has expired like in the following example\.  

```
triggerType("Timer")
```
Or an input message was received\.   

```
triggerType("Message")
```  
`currentInput("input")`  
Evaluates to `true` if the event condition in which it appears is being evaluated because the specified input message was received\. For example, if the input `Command` receives the message `{ "value": "Abort" }`, then the following evaluates to `true`\.   

```
currentInput("Command")
```
Use this function to verify that the condition is being evaluated because a particular input has been received and a timer hasn't expired, as in the following expression\.  

```
currentInput("Command") && $input.Command.value == "Abort"
```

String Matching Functions    
`startsWith(expression1, expression2)`  
Evaluates to `true` if the first string expression starts with the second string expression\. For example, if input `MyInput` receives the message `{ "status": "offline"}`, then the following evaluates to `true`\.  

```
startsWith($input.MyInput.status, "off")
```
Both expressions must evaluate to a string value\. If either expression does not evaluate to a string value, then the result of the function is undefined\. No conversions are performed\.  
`endsWith(expression1, expression2)`  
Evaluates to `true` if the first string expression ends with the second string expression\. For example, if input `MyInput` receives the message `{ "status": "offline" }`, then the following evaluates to `true`\.  

```
endsWith($input.MyInput.status, "line")
```
Both expressions must evaluate to a string value\. If either expression does not evaluate to a string value, then the result of the function is undefined\. No conversions are performed\.  
`contains(expression1, expression2)`  
Evaluates to `true` if the first string expression contains the second string expression\. For example, if input `MyInput` receives the message `{ "status": "offline" }`, then the following evaluates to `true`\.  

```
contains($input.MyInput.value, "fli")
```
Both expressions must evaluate to a string value\. If either expression does not evaluate to a string value, then the result of the function is undefined\. No conversions are performed\.

Bitwise Integer Manipulation Functions    
`bitor(expression1, expression2)`  
Evaluates the bitwise OR of the integer expressions \(the binary OR operation is performed on the corresponding bits of the integers\)\. For example, if input `MyInput` receives the message `{ "value1": 13, "value2": 5 }`, then the following evaluates to `13`\.  

```
bitor($input.MyInput.value1, $input.MyInput.value2)
```
Both expressions must evaluate to an integer value\. If either expression does not evaluate to an integer value, then the result of the function is undefined\. No conversions are performed\.  
`bitand(expression1, expression2)`  
Evaluates the bitwise AND of the integer expressions \(the binary AND operation is performed on the corresponding bits of the integers\)\. For example, if input `MyInput` receives the message `{ "value1": 13, "value2": 5 }`, then the following evaluates to `5`\.   

```
bitand($input.MyInput.value1, $input.MyInput.value2)
```
Both expressions must evaluate to an integer value\. If either expression does not evaluate to an integer value, then the result of the function is undefined\. No conversions are performed\.  
`bitxor(expression1, expression2)`  
Evaluates the bitwise XOR of the integer expressions \(the binary XOR operation is performed on the corresponding bits of the integers\)\. For example, if input `MyInput` receives the message `{ "value1": 13, "value2": 5 }`, then the following evaluates to `8`\.  

```
bitxor($input.MyInput.value1, $input.MyInput.value2)
```
Both expressions must evaluate to an integer value\. If either expression does not evaluate to an integer value, then the result of the function is undefined\. No conversions are performed\.  
`bitnot(expression)`  
Evaluates the bitwise NOT of the integer expression \(the binary NOT operation is performed on the bits of the integer\)\. For example, if input `MyInput` receives the message `{ "value": 13 }`, then the following evaluates to `-14`\.  

```
bitnot($input.MyInput.value)
```
Both expressions must evaluate to an integer value\. If either expression does not evaluate to an integer value, then the result of the function is undefined\. No conversions are performed\.

## References<a name="expression-reference"></a>

Inputs  
`$input.input-name.path-to-data`  
`input-name` is an input that you create using the [CreateInput](https://docs.aws.amazon.com/iotevents/latest/apireference/API_CreateInput.html) action\.  
For example, if you have an input named `TemperatureInput` for which you defined `inputDefinition.attributes.jsonPath` entries, the values might appear in the following available fields\.  

```
{
    "temperature": 78.5,
    "date": 2018-10-03T16:09:09Z
  }
```
To reference the value of the `temperature` field, use the following command\.  

```
$input.TemperatureInput.temperature
```
For fields whose values are arrays, you can reference members of the array using `[n]`\. For example, given the following values:  

```
{
    "temperatures": [
      78.4,
      77.9,
      78.8
    ],
    "date": 2018-10-03T16:09:09Z
  }
```
The value `78.8` can be referenced with the following command\.  

```
$input.TemperatureInput.temperatures[2]
```

Variables  
`$variable.variable-name`  
The `variable-name` is a variable that you defined using the [CreateDetectorModel](https://docs.aws.amazon.com/iotevents/latest/apireference/API_CreateDetectorModel.html) action\.  
For example, if you have a variable named `TechnicianID` that you defined using `detectorDefinition.states.onInputEvents.actions.setVariable.variableName`, you can reference the \(string\) value most recently given to the variable with the following command\.  

```
$variable.TechnicianID
```
You can set the values of variables only using the `setVariable` action\. You can't assign values for variables in an expression\. A variable can't be unset\. For example, you can't assign it the value `null`\.

**Note**  
In references that use identifiers that don't follow the \(regular expression\) pattern `[a-zA-Z][a-zA-Z0-9_]*`, you must enclose those identifiers in backticks \(```\)\. For example, a reference to an input named `MyInput` with a field named `_value` must specify this field as `$input.MyInput.`_value``\.

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

AWS IoT Events expressions support integer, decimal, string, and Boolean data types\. The following table provides a list of incompatible pairs of types\.


|  Incompatible pairs of types  | 
| --- | 
|  Integer, string  | 
|  Integer, Boolean  | 
|  Decimal, string  | 
|  Decimal, Boolean  | 
|  String, Boolean  | 

## Substitution templates<a name="expression-substitution-template"></a>

****  
`'${expression}'`  
The `${}` identifies the string as an interpolated string\. The `expression` can be any AWS IoT Events expression\. This includes operators, functions, and references\.  
For example, you used the [SetVariableAction](https://docs.aws.amazon.com/iotevents/latest/apireference/API_SetVariableAction.html) action to define a variable\. The `variableName` is `SensorID`, and the `value` is `10`\. You can create the following substitution templates\.      
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/expression-syntax.html)