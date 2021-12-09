# `toUpper`<a name="toUpper-function"></a>

`toUpper` formats a string in all uppercase\. `toUpper` skips rows containing null values\.

### Syntax<a name="toUpper-function-syntax"></a>

```
toUpper(expression)
```

### Arguments<a name="toUpper-function-arguments"></a>

 *expression*   
The expression must be a string\. It can be the name of a field that uses the string data type, a literal value like **'12 Main Street'**, or a call to another function that outputs a string\.

### Return Type<a name="toUpper-function-return-type"></a>

String

### Example<a name="toUpper-function-example"></a>

The following example converts a string value into uppercase\.

```
toUpper('Seattle Store #14')
```

The following value is returned\.

```
SEATTLE STORE #14
```