# sign\(Decimal\)<a name="math-sign"></a>

Returns the sign of the given number\. When the sign of the argument is positive, 1 is returned\. When the sign of the argument is negative, \-1 is returned\. If the argument is 0, 0 is returned\. 

Examples:

`sign(-7)` = \-1

`sign(0)` = 0

`sign(13)` = 1


| Argument type | Result | 
| --- | --- | 
|  `Int`  |  `Int`, the sign of the `Int` value\.  | 
|  `Decimal`  |  `Int`, the sign of the `Decimal` value\.  | 
|  `String`  |  `Int`, the sign of the `Decimal` value\. The string if converted to a `Decimal` value, and the sign of the `Decimal` value is returned\. If the `String` cannot be converted to a `Decimal`, the result is `Undefined`\.  | 
|  Other Value  |  `Undefined`\.  | 