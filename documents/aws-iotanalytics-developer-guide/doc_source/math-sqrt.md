# sqrt\(Decimal\)<a name="math-sqrt"></a>

Returns the square root of a number\. `Decimal` arguments are rounded to double precision before function application\.

Examples: `sqrt(9)` = 3\.0


| Argument type | Result | 
| --- | --- | 
|  `Int`  |  The square root of the argument\.  | 
|  `Decimal`  |  The square root of the argument\.  | 
|  `Boolean`  |  `Undefined`\.  | 
|  `String`  |  The square root of the argument\. If the string cannot be converted to a `Decimal`, the result is `Undefined`\.  | 
|  `Array`  |  `Undefined`\.  | 
|  `Object`  |  `Undefined`\.  | 
|  `Null`  |  `Undefined`\.  | 
|  `Undefined`  |  `Undefined`\.  | 