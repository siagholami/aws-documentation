# trunc\(Decimal, Integer\)<a name="math-trunc"></a>

Truncates the first argument to the number of `Decimal` places specified by the second argument\. If the second argument is less than zero, it will be set to zero\. If the second argument is greater than 34, it will be set to 34\. Trailing zeros are stripped from the result\.

Examples:

`trunc(2.3, 0)` = 2

`trunc(2.3123, 2)` = 2\.31

`trunc(2.888, 2)` = 2\.88

`trunc(2.00, 5)` = 2


| Argument type 1 | Argument type 2 | Result | 
| --- | --- | --- | 
|  `Int`  |  `Int`  |  The source value\.  | 
|  `Int` / `Decimal` / `String`  |  `Int` / `Decimal`  |  The first argument is truncated to the length described by the second argument\. The second argument, if not an `Int`, will be rounded down to the nearest `Int`\. Strings are converted to `Decimal` values\. If the string conversion fails, the result is `Undefined`\.  | 
|  Other Value  |   |  Undefined\.  | 