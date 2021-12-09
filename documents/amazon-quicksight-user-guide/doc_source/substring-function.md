# `substring`<a name="substring-function"></a>

`substring` returns the characters in a string, starting at the location specified by the *start* argument and proceeding for the number of characters specified by the *length* arguments\. 

### Syntax<a name="substring-function-syntax"></a>

```
substring(expression, start, length)
```

### Arguments<a name="substring-function-arguments"></a>

 *expression*   
An expression can be the name of a field that uses the string data type like **address1**, a literal value like **'Unknown'**, or another function like `substring(field_name,0,5)`\.

 *start*   
The character location to start from\. *start* is inclusive, so the character at the starting position is the first character in the returned value\.

 *length*   
The number of additional characters to include after *start*\. *length* is inclusive of *start*, so the last character returned is *length* \- 1 after the starting character\.

### Return Type<a name="substring-function-return-type"></a>

String

### Example<a name="substring-function-example"></a>

The following example returns the thirteenth through nineteenth characters in a string\.

```
substring('Fantasy and Science Fiction',13,7)
```

The following value is returned\.

```
Science
```