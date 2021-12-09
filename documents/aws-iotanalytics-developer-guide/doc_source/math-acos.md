# acos\(Decimal\)<a name="math-acos"></a>

Returns the inverse cosine of a number in radians\. `Decimal` arguments are rounded to double precision before function application\.

Examples: `acos(0)` = 1\.5707963267948966


| Argument type | Result | 
| --- | --- | 
|  `Int`  |  `Decimal` \(with double precision\), the inverse cosine of the argument\. Imaginary results are returned as `Undefined`\.  | 
|  `Decimal`  |  `Decimal` \(with double precision\), the inverse cosine of the argument\. Imaginary results are returned as `Undefined`\.  | 
|  `Boolean`  |  `Undefined`\.  | 
|  `String`  |  `Decimal` \(with double precision\) the inverse cosine of the argument\. If the string cannot be converted, the result is `Undefined`\. Imaginary results are returned as `Undefined`\.  | 
|  Array  |  `Undefined`\.  | 
|  Object  |  `Undefined`\.  | 
|  Null  |  `Undefined`\.  | 
|  Undefined  |  `Undefined`\.  | 