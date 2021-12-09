# `left`<a name="left-function"></a>

`left` returns the leftmost characters from a string, including spaces\. You specify the number of characters to be returned\. 

### Syntax<a name="left-function-syntax"></a>

```
left(expression, limit)
```

### Arguments<a name="left-function-arguments"></a>

 *expression*   
The expression must be a string\. It can be the name of a field that uses the string data type, a literal value like **'12 Main Street'**, or a call to another function that outputs a string\.

 *limit*   
The number of characters to be returned from *expression*, starting from the first character in the string\.

### Return Type<a name="left-function-return-type"></a>

String

### Example<a name="left-function-example"></a>

The following example returns the first e characters from a string\.

```
left('Seattle Store #14', e)
```

The following value is returned\.

```
Sea
```