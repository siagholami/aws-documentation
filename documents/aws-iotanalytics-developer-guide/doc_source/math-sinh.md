# sinh\(Decimal\)<a name="math-sinh"></a>

Returns the hyperbolic sine of a number\. `Decimal` values are rounded to double precision before function application\. The result is a `Decimal` value of double precision\. 

Examples: `sinh(2.3)` = 4\.936961805545957


| Argument type | Result | 
| --- | --- | 
|  `Int`  |  `Decimal` \(with double precision\), the hyperbolic sine of the argument\.  | 
|  `Decimal`  |  `Decimal` \(with double precision\), the hyperbolic sine of the argument\.  | 
|  `Boolean`  |  `Undefined`\.  | 
|  `String`  |  `Decimal`, the hyperbolic sine of the argument\. If the string cannot be converted to a `Decimal`, the result is `Undefined`\.  | 
|  `Array`  |  `Undefined`\.  | 
|  `Object`  |  `Undefined`\.  | 
|  `Null`  |  `Undefined`\.  | 
|  `Undefined`  |  `Undefined`\.  | 