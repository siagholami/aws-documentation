# `isNotNull`<a name="isNotNull-function"></a>

`isNotNull` evaluates an expression to see if it is not null\. If the expression is not null, `isNotNull` returns true, and otherwise it returns false\.

### Syntax<a name="isNotNull-function-syntax"></a>

```
isNotNull(expression)
```

### Arguments<a name="isNotNull-function-arguments"></a>

 *expression*   
The expression to be evaluated as null or not\. It can be a field name like **address1** or a call to another function that outputs a string\. 

### Return Type<a name="isNotNull-function-return-type"></a>

Boolean

### Example<a name="isNotNull-function-example"></a>

The following example evaluates the sales\_amount field for null values\.

```
isNotNull(salesAmount)
```

The following are the given field values\.

```
20.13
(null)
57.54
```

For these field values, the following values are returned\.

```
true
false
true
```