# `right`<a name="right-function"></a>

`right` returns the rightmost characters from a string, including spaces\. You specify the number of characters to be returned\.

### Syntax<a name="right-function-syntax"></a>

```
right(expression, limit)
```

### Arguments<a name="right-function-arguments"></a>

 *expression*   
The expression must be a string\. It can be the name of a field that uses the string data type, a literal value like **'12 Main Street'**, or a call to another function that outputs a string\.

 *limit*   
The number of characters to be returned from *expression*, starting from the last character in the string\.

### Return Type<a name="right-function-return-type"></a>

String

### Example<a name="right-function-example"></a>

The following example returns the last five characters from a string\.

```
right('Seattle Store#14', 12)
```

The following value is returned\.

```
tle Store#14
```