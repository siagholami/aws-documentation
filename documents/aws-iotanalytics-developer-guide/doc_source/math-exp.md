# exp\(Decimal\)<a name="math-exp"></a>

Returns e raised to the Decimal argument\. `Decimal` arguments are rounded to double precision before function application\.

Examples: `exp(1)` = 1


| Argument type | Result | 
| --- | --- | 
|  `Int`  |  `Decimal` \(with double precision\), e^argument\.  | 
|  `Decimal`  |  `Decimal` \(with double precision\), e^argument  | 
|  `String`  |  `Decimal` \(with double precision\), e^argument\. If the `String` cannot be converted to a `Decimal`, the result if `Undefined`\.  | 
|  Other Value  |  `Undefined`\.  | 