# `locate`<a name="locate-function"></a>

`locate` locates a substring that you specify within another string, and returns the number of characters until the first character in the substring\. The function returns 0 if it doesn't find the substring\.

### Syntax<a name="locate-function-syntax"></a>

```
locate(expression, substring, start)
```

### Arguments<a name="locate-function-arguments"></a>

 *expression*   
The expression must be a string\. It can be the name of a field that uses the string data type, a literal value like **'12 Main Street'**, or a call to another function that outputs a string\.

 *substring*   
The set of characters in *expression* that you want to locate\. The substring can occur one or more times in *expression*\.

 *start*   
\(Optional\) If *substring* occurs more than once, use *start* to identify where in the string the function should start looking for the substring\. For example, suppose that you want to find the second example of a substring and you think it typically occurs after the first 10 characters\. You specify a *start* value of 10\. 

### Return Type<a name="locate-function-return-type"></a>

Integer

### Examples<a name="locate-function-example"></a>

The following example returns information about where the first occurrence of the substring 'and' appears in a string\.

```
locate('1 and 2 and 3 and 4', 'and')
```

The following value is returned\.

```
3
```

The following example returns information about where the first occurrence of the substring 'and' appears in a string after the fourth character\.

```
locate('1 and 2 and 3 and 4', 'and', 4)
```

The following value is returned\.

```
9
```