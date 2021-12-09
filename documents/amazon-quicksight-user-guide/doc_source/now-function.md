# `now`<a name="now-function"></a>

For database data sets that directly query the database, `now` returns the current date and time using the settings and format specified by the database server\. For file and Salesforce data sets, `now` returns the UTC date and time, in the format `yyyy-MM-ddTkk:mm:ss:SSSZ` \(for example, 2015\-10\-15T19:11:51:003Z\)\. `now` is not supported for use with database data sets that use [SPICE](welcome.md#spice)\.

### Syntax<a name="now-function-syntax"></a>

```
now()
```

### Return Type<a name="now-function-return-type"></a>

Date