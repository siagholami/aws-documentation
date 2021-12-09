# cos\(Decimal\)<a name="math-cos"></a>

Returns the cosine of a number in radians\. `Decimal` arguments are rounded to double precision before function application\.

Examples: `cos(0)` = 1


| Argument type | Result | 
| --- | --- | 
|  `Int`  |  `Decimal` \(with double precision\), the cosine of the argument\. Imaginary results are returned as `Undefined`\.  | 
|  `Decimal`  |  `Decimal` \(with double precision\), the cosine of the argument\. Imaginary results are returned as `Undefined`\.  | 
|  `Boolean`  |  `Undefined`\.  | 
|  `String`  |  `Decimal` \(with double precision\), the cosine of the argument\. If the string cannot be converted to a `Decimal`, the result is `Undefined`\. Imaginary results are returned as `Undefined`\.  | 
|  Array  |  `Undefined`\.  | 
|  Object  |  `Undefined`\.  | 
|  Null  |  `Undefined`\.  | 
|  Undefined  |  `Undefined`\.  | 