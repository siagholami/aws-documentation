# `parseInt`<a name="parseInt-function"></a>

`parseInt` parses a string to determine if it contains an integer value\. This function returns all rows that contain a decimal, integer, or null value, and skips any rows that don't\. If the row contains a decimal value, it is returned as the nearest integer, rounded down\. For example, a value of '2\.99' is returned as '2'\.

### Syntax<a name="parseInt-function-syntax"></a>

```
parseInt(expression)
```

### Arguments<a name="parseInt-function-arguments"></a>

 *expression*   
The expression must be a string\. It can be the name of a field that uses the string data type, a literal value like **'3'**, or a call to another function that outputs a string\.

### Return Type<a name="parseInt-function-return-type"></a>

Integer

### Example<a name="parseInt-function-example"></a>

The following example evaluates `feeType` to determine if it contains integer values\.

```
parseInt(feeType)
```

The following are the given field values\.

```
feeType
--------
2
2.1
2a
3
3b
(null)
5
```

For these field values, the following rows are returned\.

```
2
2
3
(null)
5
```