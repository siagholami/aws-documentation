# ceil\(Decimal\)<a name="math-ceil"></a>

Rounds the given `Decimal` up to the nearest `Int`\.

Examples: 

`ceil(1.2)` = 2

`ceil(11.2)` = \-1


| Argument type | Result | 
| --- | --- | 
|  `Int`  |  `Int`, the argument value\.  | 
|  `Decimal`  |  `Int`, the string is converted to `Decimal` and rounded up to the nearest `Int`\. If the string cannot be converted to a `Decimal`, the result is `Undefined`\.  | 
|  Other Value  |  `Undefined`\.  | 