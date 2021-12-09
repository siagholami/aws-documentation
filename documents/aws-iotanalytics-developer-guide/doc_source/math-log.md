# log\(Decimal\)<a name="math-log"></a>

Returns the base 10 logarithm of the argument\. `Decimal` arguments are rounded to double precision before function application\. 

Examples: `log(100)` = 2\.0


| Argument type | Result | 
| --- | --- | 
|  `Int`  |  `Decimal` \(with double precision\), the base 10 log of the argument\.  | 
|  `Decimal`  |  `Decimal` \(with double precision\), the base 10 log of the argument\.  | 
|  `Boolean`  |  `Undefined`\.  | 
|  `String`  |  `Decimal` \(with double precision\), the base 10 log of the argument\. If the `String` cannot be converted to a `Decimal`, the result is `Undefined`\.  | 
|  Array  |  `Undefined`\.  | 
|  Object  |  `Undefined`\.  | 
|  Null  |  `Undefined`\.  | 
|  Undefined  |  `Undefined`\.  | 