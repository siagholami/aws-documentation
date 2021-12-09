# `toString`<a name="toString-function"></a>

`toString` formats the input expression as a string\. `toString` skips rows containing null values\.

### Syntax<a name="toString-function-syntax"></a>

```
toString(expression)
```

### Arguments<a name="toString-function-arguments"></a>

 *expression*   
 An expression can be a field of any data type, a literal value like **14\.62**, or a call to another function that returns any data type\.

### Return Type<a name="toString-function-return-type"></a>

String

### Example<a name="toString-function-example"></a>

The following example returns the values from `payDate` \(which uses the `date` data type\) as strings\.

```
toString(payDate)
```

The following are the given field values\.

```
payDate
--------
1992-11-14T00:00:00.000Z
2012-10-12T00:00:00.000Z
1973-04-08T00:00:00.000Z
```

For these field values, the following rows are returned\.

```
1992-11-14T00:00:00.000Z
2012-10-12T00:00:00.000Z
1973-04-08T00:00:00.000Z
```