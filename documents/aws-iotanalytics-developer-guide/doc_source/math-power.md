# power\(Decimal, Decimal\)<a name="math-power"></a>

Returns the first argument raised to the second argument\. `Decimal` arguments are rounded to double precision before function application\.

Examples: `power(2, 5)` = 32\.0


| Argument type 1 | Argument type 2 | Output | 
| --- | --- | --- | 
|  `Int` / `Decimal`  |  `Int` / `Decimal`  |  A `Decimal` \(with double precision\), the first argument raised to the second argument's power\.  | 
|  `Int` / `Decimal` / `String`  |  `Int` / `Decimal` / `String`  |  A `Decimal` \(with double precision\), the first argument raised to the second argument's power\. Any strings are converted to `Decimals`\. If any `String` fails to be converted to `Decimal`, the result is `Undefined`\.  | 
|  Other Value  |  Other Value  |  `Undefined`\.  | 