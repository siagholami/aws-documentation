# `formatDate`<a name="formatDate-function"></a>

`formatDate` formats a date using a pattern you specify\. 

### Syntax<a name="formatDate-function-syntax"></a>

```
formatDate(date, ['format'], ['timezone'])
```

### Arguments<a name="formatDate-function-arguments"></a>

 *date*   
A date field or a call to another function that outputs a date\.

 *format*   
\(Optional\) A string containing the format pattern to apply\. This argument accepts the format patterns specified in [Supported Date Formats](data-source-limits.md#supported-date-formats)\.  
If you don't specify a format, this string defaults to yyyy\-MM\-dd**T**kk:mm:ss:SSS\.

 *time\_zone*   
\(Optional\) A string representing an [IANA](http://www.iana.org/time-zones) time zone\.  
If you don't specify a time zone, UTC is used\.

### Return Type<a name="formatDate-function-return-type"></a>

String

### Example<a name="formatDate-function-example"></a>

The following example formats a UTC date and displays using a specific time zone\.

```
formatDate(orderDate, 'dd MMM yyyy', 'America/Los_Angeles')
```

The following are the given field values\.

```
order date      
=========
2012-12-14T00:00:00.000Z  
2013-12-29T00:00:00.000Z
2012-11-15T00:00:00.000Z
```

For these field values, the following values are returned\.

```
13 Dec 2012
28 Dec 2013
14 Nov 2012
```