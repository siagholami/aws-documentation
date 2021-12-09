# `trim`<a name="trim-function"></a>

`trim` removes both preceding and following whitespace from a string\. 

### Syntax<a name="trim-function-syntax"></a>

```
trim(expression)
```

### Arguments<a name="trim-function-arguments"></a>

 *expression*   
The expression must be a string\. It can be the name of a field that uses the string data type, a literal value like **'12 Main Street'**, or a call to another function that outputs a string\.

### Return Type<a name="trim-function-return-type"></a>

String

### Example<a name="trim-function-example"></a>

The following example removes the following spaces from a string\.

```
trim('   Seattle Store #14   ')
```

For these field values, the following values are returned\.

```
Seattle Store #14
```