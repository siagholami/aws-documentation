# `parseDecimal`<a name="parseDecimal-function"></a>

`parseDecimal` parses a string to determine if it contains a decimal value\. This function returns all rows that contain a decimal, integer, or null value, and skips any rows that don't\. If the row contains an integer value, it is returned as a decimal\. For example, a value of '2' is returned as '2\.0'\.

### Syntax<a name="parseDecimal-function-syntax"></a>

```
parseDecimal(expression)
```

### Arguments<a name="parseDecimal-function-arguments"></a>

 *expression*   
The expression must be a string\. It can be the name of a field that uses the string data type, a literal value like **'9\.62'**, or a call to another function that outputs a string\.

### Return Type<a name="parseDecimal-function-return-type"></a>

Decimal

### Example<a name="parseDecimal-function-example"></a>

The following example evaluates `fee` to determine if it contains decimal values\.

```
parseDecimal(fee)
```

The following are the given field values\.

```
fee
--------
2
2a
12.13
3b
3.9
(null)
198.353398
```

For these field values, the following rows are returned\.

```
2.0
12.13
3.9
(null)
198.353398
```