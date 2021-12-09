# cosh\(Decimal\)<a name="math-cosh"></a>

Returns the hyperbolic cosine of a number in radians\. `Decimal` arguments are rounded to double precision before function application\.

Examples: `cosh(2.3)` = 5\.037220649268761


| Argument type | Result | 
| --- | --- | 
|  `Int`  |  `Decimal` \(with double precision\), the hyperbolic cosine of the argument\. Imaginary results are returned as `Undefined`\.  | 
|  `Decimal`  |  `Decimal` \(with double precision\), the hyperbolic cosine of the argument\. Imaginary results are returned as `Undefined`\.  | 
|  `Boolean`  |  `Undefined`\.  | 
|  `String`  |  `Decimal` \(with double precision\), the hyperbolic cosine of the argument\. If the string cannot be converted to a `Decimal`, the result is `Undefined`\. Imaginary results are returned as `Undefined`\.  | 
|  Array  |  `Undefined`\.  | 
|  Object  |  `Undefined`\.  | 
|  Null  |  `Undefined`\.  | 
|  Undefined  |  `Undefined`\.  | 