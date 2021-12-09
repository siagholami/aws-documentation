# `epochDate`<a name="epochDate-function"></a>

`epochDate` converts an epoch date into a standard date in the format yyyy\-MM\-dd**T**kk:mm:ss\.SSS**Z**, using the format pattern syntax specified in [Class DateTimeFormat](http://www.joda.org/joda-time/apidocs/org/joda/time/format/DateTimeFormat.html) in the Joda project documentation\. An example is `2015-10-15T19:11:51.003Z`\. 

`epochDate` is supported for use with analyses based on [SPICE](welcome.md#spice) data sets\.

### Syntax<a name="epochDate-function-syntax"></a>

```
epochDate(epochdate)
```

### Arguments<a name="epochDate-function-arguments"></a>

 *epochdate*   
An epoch date, which is an integer representation of a date as the number of seconds since 00:00:00 UTC on January 1, 1970\.   
*epochdate* must be an integer\. It can be the name of a field that uses the integer data type, a literal integer value, or a call to another function that outputs an integer\.  If the integer value is longer than 10 digits, the digits after the tenth place are discarded\.

### Return Type<a name="epochDate-function-return-type"></a>

Date

### Example<a name="epochDate-function-example"></a>

The following example converts an epoch date to a standard date\.

```
epochDate(3100768000)
```

The following value is returned\.

```
2068-04-04T12:26:40.000Z
```