# `concat`<a name="concat-function"></a>

`concat` concatenates two or more strings\.

### Syntax<a name="concat-function-syntax"></a>

```
concat(expression1, expression2 [, expression3 ...])
```

### Arguments<a name="concat-function-arguments"></a>

`concat` takes two or more string expressions as arguments\. 

 *expression*   
The expression must be a string\. It can be the name of a field that uses the string data type, a literal value like **'12 Main Street'**, or a call to another function that outputs a string\.

### Return Type<a name="concat-function-return-type"></a>

String

### Examples<a name="concat-function-example"></a>

The following example concatenates three string fields and adds appropriate spacing\.

```
concat(salutation, ' ', firstName, ' ', lastName)
```

The following are the given field values\.

```
salutation     firstName          lastName
-------------------------------------------------------
Ms.            Li                  Juan
Dr.            Ana Carolina        Silva
Mr.            Nikhil              Jayashankar
```

For these field values, the following values are returned\.

```
Ms. Li Juan
Dr. Ana Carolina Silva
Mr. Nikhil Jayashankar
```

The following example concatenates two string literals\.

```
concat('Hello', 'world')
```

The following value is returned\.

```
Helloworld
```