# `toLower`<a name="toLower-function"></a>

`toLower` formats a string in all lowercase\. `toLower` skips rows containing null values\.

### Syntax<a name="toLower-function-syntax"></a>

```
toLower(expression)
```

### Arguments<a name="toLower-function-arguments"></a>

 *expression*   
The expression must be a string\. It can be the name of a field that uses the string data type, a literal value like **'12 Main Street'**, or a call to another function that outputs a string\.

### Return Type<a name="toLower-function-return-type"></a>

String

### Example<a name="toLower-function-example"></a>

The following example converts a string value into lowercase\.

```
toLower('Seattle Store #14')
```

The following value is returned\.

```
seattle store #14
```