# sin\(Decimal\)<a name="math-sin"></a>

Returns the sine of a number in radians\. `Decimal` arguments are rounded to double precision before function application\.

Examples: `sin(0)` = 0\.0


| Argument type | Result | 
| --- | --- | 
|  `Int`  |  `Decimal` \(with double precision\), the sine of the argument\.  | 
|  `Decimal`  |  `Decimal` \(with double precision\), the sine of the argument\.  | 
|  `Boolean`  |  `Undefined`\.  | 
|  `String`  |  `Decimal`, the sine of the argument\. If the string cannot be converted to a `Decimal`, the result is `Undefined`\.  | 
|  `Array`  |  `Undefined`\.  | 
|  `Object`  |  `Undefined`\.  | 
|  `Null`  |  `Undefined`\.  | 
|  `Undefined`  |  `Undefined`\.  | 