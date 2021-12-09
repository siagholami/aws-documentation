# `parseDate`<a name="parseDate-function"></a>

`parseDate` parses a string to determine if it contains a date value, and returns a standard date in the format `yyyy-MM-ddTkk:mm:ss.SSSZ` \(using the format pattern syntax specified in [Class DateTimeFormat](http://www.joda.org/joda-time/apidocs/org/joda/time/format/DateTimeFormat.html) in the Joda project documentation\), for example 2015\-10\-15T19:11:51\.003Z\. This function returns all rows that contain a date in a valid format and skips any rows that don't, including rows that contain null values\.

Amazon QuickSight supports dates in the range from Jan 1, 1900 00:00:00 UTC to Dec 31, 2037 23:59:59 UTC\. See also [Supported Date Formats](data-source-limits.md#supported-date-formats)\.

**Note**  
`parseDate` is not supported for use with [SPICE](welcome.md#spice) data sets\.

### Syntax<a name="parseDate-function-syntax"></a>

```
parseDate(expression, ['format'], ['time_zone'])
```

### Arguments<a name="parseDate-function-arguments"></a>

 *expression*   
The expression must be a string\. It can be the name of a field that uses the string data type, a literal value like **'1/1/2016'**, or a call to another function that outputs a string\.

 *format*   
\(Optional\) A string containing the format pattern that *date\_string* must match\. For example, if you are using a field with data like **01/03/2016**, you specify the format 'MM/dd/yyyy'\. If you don't specify a format, it defaults to `yyyy-MM-dd`\. Rows whose data doesn't conform to *format* are skipped\.   
Different date formats are supported based on the type of data set used\. Use the following table to see details of supported date formats\.    
****    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/parseDate-function.html)

 *time\_zone*   
\(Optional\) A string representing an [IANA](http://www.iana.org/time-zones) time zone\.  
If you don't specify a time zone, UTC is used\.

### Return Type<a name="parseDate-function-return-type"></a>

Date

### Example<a name="parseDate-function-example"></a>

The following example evaluates `prodDate` to determine if it contains date values\.

```
parseDate(prodDate, 'MM/dd/yyyy')
```

The following are the given field values\.

```
prodDate
--------
01-01-1999
12/31/2006
1/18/1982 
7/4/2010
```

For these field values, the following rows are returned\.

```
12-31-2006T00:00:00.000Z
01-18-1982T00:00:00.000Z
07-04-2010T00:00:00.000Z
```