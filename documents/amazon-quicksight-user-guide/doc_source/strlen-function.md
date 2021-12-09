# `strlen`<a name="strlen-function"></a>

`strlen` returns the number of characters in a string, including spaces\.

### Syntax<a name="strlen-function-syntax"></a>

```
strlen(expression)
```

### Arguments<a name="strlen-function-arguments"></a>

 *expression*   
An expression can be the name of a field that uses the string data type like **address1**, a literal value like **'Unknown'**, or another function like `substring(field_name,0,5)`\.

### Return Type<a name="strlen-function-return-type"></a>

Integer

### Example<a name="strlen-function-example"></a>

The following example returns the length of the specified string\.

```
strlen('1421 Main Street')
```

The following value is returned\.

```
16
```