# `split`<a name="split-function"></a>

`split` splits a string into an array of substrings, based on a delimiter that you choose, and returns the item specified by the position\.

### Syntax<a name="split-function-syntax"></a>

```
split(expression, delimiter , position)
```

### Arguments<a name="split-function-arguments"></a>

 *expression*   
The expression must be a string\. It can be the name of a field that uses the string data type, a literal value like **'12 Main Street;1402 35th Ave;1818 Elm Ct;11 Janes Lane'**, or a call to another function that outputs a string\.

 *delimiter*   
The character that delimits where the string is broken into substrings\. For example, `split('one|two|three', '|', 2)` becomes the following\.  

```
one
two
three
```
If you choose `position = 2`, `split` returns `'two'`\.

 *position*   
\(Required\) The position of the item to return from the array\. The position of the first item in the array is 1\.

### Return Type<a name="split-function-return-type"></a>

String array

### Example<a name="split-function-example"></a>

The following example splits a string into an array, using the semicolon character \(;\) as the delimiter, and returns the third element of the array\.

```
split('123 Test St;1402 35th Ave;1818 Elm Ct;11 Janes Lane', ';', 3)
```

The following item is returned\.

```
1818 Elm Ct
```

This function skips items containing null values or empty strings\. 