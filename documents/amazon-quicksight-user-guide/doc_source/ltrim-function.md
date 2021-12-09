# `ltrim`<a name="ltrim-function"></a>

`ltrim` removes preceding whitespace from a string\.

### Syntax<a name="ltrim-function-syntax"></a>

```
ltrim(expression)
```

### Arguments<a name="ltrim-function-arguments"></a>

 *expression*   
The expression must be a string\. It can be the name of a field that uses the string data type, a literal value like **'12 Main Street'**, or a call to another function that outputs a string\.

### Return Type<a name="ltrim-function-return-type"></a>

String

### Example<a name="ltrim-function-example"></a>

The following example removes the preceding spaces from a string\.

```
ltrim('   Seattle Store #14')
```

The following value is returned\.

```
Seattle Store #14
```