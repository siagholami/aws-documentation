# `truncDate`<a name="truncDate-function"></a>

`truncDate` returns a date value that represents a specified portion of a date\. For example, requesting the year portion of the value 2012\-09\-02T00:00:00\.000Z returns 2012\-01\-01T00:00:00\.000Z\. Specifying a time\-related period for a date that doesn't contain time information returns the initial date value unchanged\.

`truncDate` is supported for use with analyses based on [SPICE](welcome.md#spice) data sets\.

### Syntax<a name="truncDate-function-syntax"></a>

```
truncDate('period', date)
```

### Arguments<a name="truncDate-function-arguments"></a>

 *period*   
The period of the date that you want returned\. Valid periods are as follows:  
+ YYYY: This returns the year portion of the date\.
+ Q: This returns the date of the first day of the quarter that the date belongs to\. 
+ MM: This returns the month portion of the date\.
+ DD: This returns the day portion of the date\.
+ WK: This returns the week portion of the date\. The week starts on Sunday in Amazon QuickSight\.
+ HH: This returns the hour portion of the date\.
+ MI: This returns the minute portion of the date\.
+ SS: This returns the second portion of the date\. \(Not supported when added inside SPICE\-based analyses\.\)

 *date*   
A date field or a call to another function that outputs a date\.

### Return Type<a name="truncDate-function-return-type"></a>

Date

### Example<a name="truncDate-function-example"></a>

The following example returns a date representing the month of the order date\.

```
truncDate('MM', orderDate)
```

The following are the given field values\.

```
orderDate      
=========
2012-12-14T00:00:00.000Z  
2013-12-29T00:00:00.000Z
2012-11-15T00:00:00.000Z
```

For these field values, the following values are returned\.

```
2012-12-01T00:00:00.000Z
2013-12-01T00:00:00.000Z
2012-11-01T00:00:00.000Z
```