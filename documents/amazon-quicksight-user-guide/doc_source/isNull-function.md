# `isNull`<a name="isNull-function"></a>

`isNull` evaluates an expression to see if it is null\. If the expression is null, `isNull` returns true, and otherwise it returns false\.

### Syntax<a name="isNull-function-syntax"></a>

```
isNull(expression)
```

### Arguments<a name="isNull-function-arguments"></a>

 *expression*   
The expression to be evaluated as null or not\. It can be a field name like **address1** or a call to another function that outputs a string\. 

### Return Type<a name="isNull-function-return-type"></a>

Boolean

### Example<a name="isNull-function-example"></a>

The following example evaluates the sales\_amount field for null values\.

```
isNull(salesAmount)
```

The following are the given field values\.

```
20.13
(null)
57.54
```

For these field values, the following values are returned\.

```
false
true
false
```