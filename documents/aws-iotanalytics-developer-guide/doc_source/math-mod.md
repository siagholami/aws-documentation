# mod\(Decimal, Decimal\)<a name="math-mod"></a>

Returns the remainder of the division of the first argument of the second argument\. You can also use `%` as an infix operator for the same modulo functionality\. 

Examples: `mod(8, 3)` = 3


| Left operand | Right operand | Output | 
| --- | --- | --- | 
|  `Int`  |  `Int`  |  `Int`, the first argument modulo of the second argument\.  | 
|  `Int` / `Decimal`  |  `Int` / `Decimal`  |  `Decimal`, the first argument modulo of the second argument\.  | 
|  `String` / `Int` / `Decimal`  |  `String` / `Int` / `Decimal`  |  If all strings convert to `Decimals`, the result if the first argument modulo the second argument\. Otherwise, `Undefined`\.  | 
|  Other Value  |  Other Value  |  `Undefined`\.  | 