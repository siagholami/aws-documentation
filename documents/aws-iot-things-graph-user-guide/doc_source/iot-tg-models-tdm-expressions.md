--------

--------

# Expressions<a name="iot-tg-models-tdm-expressions"></a>

TDM provides several ways to specify values whenever you define or use TDM constructs\. You can often specify literal values, but on many occasions you might need to evaluate information before specifying a particular value\. 

Workflows need to manipulate and evaluate data before determining what actions to take\. For example, certain steps can't be taken unless a given condition is met\. In that case, a Boolean expression might be appropriate\. 

Mappings use expressions to transform information from one device into representations that other devices can understand\. A service or device definition might require end user input, and this input can be represented as variables in TDM expressions\.

The following list contains the types of expressions that TDM supports\. Variables can be used in expressions\. In TDM, variable names begin with `$`\. Each expression type is followed by a set of examples\.

Literal  
Expressions that are static instances of the [built\-in primitive data types](iot-tg-models-tdm-datatypes.html)\.  

```
'hello'     # String literal
123         # Int literal
[1,2,3]     # Array literal
10L         # Long literal
10UL        # Unsigned long literal
```

Predicate  
Expressions that evaluate to true or false\.  

```
True
False
10 < 13
$aValue > $bvalue
(10 + 11) == 21
```

Path  
Expression that enables navigation through a complex object\. TDM supports path expressions that use both the forward slash \(`/` \) and dot \(`.`\) notations\.  

```
image.value
image/value
users[name == 'rob'].height
```

Arithmetic  
Expression that results in a numeric value\. The values used in an arithmetic expression can be other kinds of expressions\.  

```
1 + 2
100UL - 3.4L
'abc' + 1  + 2
(3 / 4) / (5 / 4)
users[name == 'rob'].height * 0.9
```

Ternary  
Conditional expressions that use the `?` operator: `condition ? expr1 : expr2`\.  

```
$aValue < $bvalue ? 'This is returned if $aValue is less than $bValue' : 'This is returned if $aValue is not less than $bValue'
```

IsNull  
Expression that uses two `?` symbols to determine whether the value to the left of the operator is null\. If the value to the left of the operator is null, the value to the right is returned\. If the value to the left of the operator is not null, the value to the left is returned\.  

```
$aValue ?? 'This string is returned if $aValue is null. $aValue is returned if it isn't null.'
```

Function calls  
TDM supports a set of utility functions\. These functions wrap the utility functions in [java\.lang\.math](https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html) and [java\.lang\.string](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)\. All of these begin with `tdm.lib`\. Array type parameters aren't supported\.  

```
tdm.lib.Math.log(2.71728) # Evaluates to 0.999999989
```

InstanceOf  
TDM supports the use of instance methods on primitive data types\. These are similar to instance methods in Java, such as `String.substring()` and `Integer.doubleValue()`\.  

```
((string) 'a' + 'b').substring(1)
```

Macro  
TDM supports interpolation of values into a string by wrapping expressions inside `${}`\.  

```
macro(This is a string with ${3 + 4} words)  # Evaluates to 'This is a string with 7 words'
macro({"name":"${'jeff' + ' ' + 'b'}", "age": ${100 % 52}}) # Evaluates to '{"name":"jeff b", "age": 48}'
```

You can use expressions in all kinds of TDM definitions, but they're especially important in Workflow and Mapping constructs\. \(See [Workflows](iot-tg-models-tdm-iot-workflow.html) and [Mappings](iot-tg-models-tdm-iot-mapping.html) for examples\.\) The examples in those sections demonstrate how to use expressions to evaluate and manipulate data supplied by devices and services\.