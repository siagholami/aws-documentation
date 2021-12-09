# asin\(Decimal\)<a name="math-asin"></a>

Returns the inverse sine of a number in radians\. `Decimal` arguments are rounded to double precision before function application\.

Examples: `asin(0)` = 0\.0


| Argument type | Result | 
| --- | --- | 
|  `Int`  |  `Decimal` \(with double precision\), the inverse sine of the argument\. Imaginary results are returned as `Undefined`\.  | 
|  `Decimal`  |  `Decimal` \(with double precision\), the inverse sine of the argument\. Imaginary results are returned as `Undefined`\.  | 
|  `Boolean`  |  `Undefined`\.  | 
|  `String`  |  `Decimal` \(with double precision\), the inverse sine of the argument\. If the string cannot be converted, the result is `Undefined`\. Imaginary results are returned as `Undefined`\.  | 
|  Array  |  `Undefined`\.  | 
|  Object  |  `Undefined`\.  | 
|  Null  |  `Undefined`\.  | 
|  Undefined  |  `Undefined`\.  | 