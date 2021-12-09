# round\(Decimal\)<a name="math-round"></a>

Rounds the given `Decimal` to the nearest `Int`\. If the `Decimal` is equidistant from two `Int` values \(for example, 0\.5\), the `Decimal` is rounded up\. 

Examples:

`Round(1.2)` = 1

`Round(1.5)` = 2

`Round(1.7)` = 2

`Round(-1.1)` = \-1

`Round(-1.5)` = \-2


| Argument type | Result | 
| --- | --- | 
|  `Int`  |  The argument  | 
|  `Decimal`  |  `Decimal` is rounded down to the nearest `Int`\.  | 
|  `String`  |  `Decimal` is rounded down to the nearest `Int`\. If the string cannot be converted to a `Decimal`, the result is `Undefined`\.  | 
|  Other Value  |  `Undefined`\.  | 