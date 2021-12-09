# `dateDiff`<a name="dateDiff-function"></a>

`dateDiff` returns the difference in days between two date fields\.

`dateDiff` is supported for use with analyses based on [SPICE](welcome.md#spice) data sets\.

### Syntax<a name="dateDiff-function-syntax"></a>

```
dateDiff(date1, date2)
```

### Arguments<a name="dateDiff-function-arguments"></a>

`dateDiff` takes two dates as arguments\.

 *date*   
A date field or a call to another function that outputs a date\. 

### Return Type<a name="dateDiff-function-return-type"></a>

Integer

### Example<a name="dateDiff-function-example"></a>

The following example returns the difference between two dates\.

```
dateDiff(orderDate, shipDate)
```

The following are the given field values\.

```
orderdDate          shipdate
=============================
01/01/14            01/05/14
09/13/16            09/20/16
```

For these field values, the following values are returned\.

```
4
7
```