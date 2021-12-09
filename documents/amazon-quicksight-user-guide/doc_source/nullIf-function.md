# `nullIf`<a name="nullIf-function"></a>

`nullIf` compares two expressions\. If they are equal, the function returns null\. If they are not equal, the function returns the first expression\.

### Syntax<a name="nullIf-function-syntax"></a>

```
nullIf(expression1, expression2)
```

### Arguments<a name="nullIf-function-arguments"></a>

`nullIf` takes two expressions as arguments\. 

 *expression*   
The expression can be numeric, datetime, or string\. It can be a field name, a literal value, or another function\. 

### Return Type<a name="nullIf-function-return-type"></a>

String

### Example<a name="nullIf-function-example"></a>

The following example returns nulls if the reason for a shipment delay is unknown\.

```
nullIf(delayReason, 'unknown')
```

The following are the given field values\.

```
delayReason
============
unknown         
back ordered 
weather delay
```

For these field values, the following values are returned\.

```
(null)
back ordered 
weather delay
```