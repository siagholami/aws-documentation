# `replace`<a name="replace-function"></a>

`replace` replaces part of a string with another string that you specify\. 

### Syntax<a name="replace-function-syntax"></a>

```
replace(expression, substring, replacement)
```

### Arguments<a name="replace-function-arguments"></a>

 *expression*   
The expression must be a string\. It can be the name of a field that uses the string data type, a literal value like **'12 Main Street'**, or a call to another function that outputs a string\.

 *substring*   
The set of characters in *expression* that you want to replace\. The substring can occur one or more times in *expression*\.

 *replacement*   
The string you want to have substituted for *substring*\.

### Return Type<a name="replace-function-return-type"></a>

String

### Example<a name="replace-function-example"></a>

The following example replaces the substring 'and' with 'or'\.

```
replace('1 and 2 and 3', 'and', 'or')
```

The following string is returned\.

```
1 or 2 or 3
```