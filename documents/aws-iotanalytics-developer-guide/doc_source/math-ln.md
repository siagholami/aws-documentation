# ln\(Decimal\)<a name="math-ln"></a>

Returns the natural logarithm of the argument\. `Decimal` arguments are rounded to double precision before function application\.

Examples: `ln(e)` = 1


| Argument type | Result | 
| --- | --- | 
|  `Int`  |  `Decimal` \(with double precision\), the natural log of the argument\.  | 
|  `Decimal`  |  `Decimal` \(with double precision\), the natural log of the argument  | 
|  `Boolean`  |  `Undefined`\.  | 
|  `String`  |  `Decimal` \(with double precision\), the natural log of the argument\. If the string cannot be converted to a `Decimal` the result is `Undefined`\.  | 
|  Array  |  `Undefined`\.  | 
|  Object  |  `Undefined`\.  | 
|  Null  |  `Undefined`\.  | 
|  Undefined  |  `Undefined`\.  | 