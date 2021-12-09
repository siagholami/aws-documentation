# tanh\(Decimal\)<a name="math-tanh"></a>

Returns the hyperbolic tangent of a number in radians\. `Decimal` values are rounded to double precision before function application\.

Examples: `tanh(2.3)` = 0\.9800963962661914


| Argument type | Result | 
| --- | --- | 
|  `Int`  |  `Decimal` \(with double precision\), the hyperbolic tangent of the argument\.  | 
|  `Decimal`  |  `Decimal` \(with double precision\), the hyperbolic tangent of the argument\.  | 
|  `Boolean`  |  `Undefined`\.  | 
|  `String`  |  `Decimal` \(with double precision\), the hyperbolic tangent of the argument\. If the string cannot be converted to a `Decimal`, the result is `Undefined`\.  | 
|  `Array`  |  `Undefined`\.  | 
|  `Object`  |  `Undefined`\.  | 
|  `Null`  |  `Undefined`\.  | 
|  `Undefined`  |  `Undefined`\.  | 