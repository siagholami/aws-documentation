# Data Source Limits<a name="data-source-limits"></a>

Data sources that you use with Amazon QuickSight must conform to the following limits\.

## File Limits<a name="file-limits"></a>

The total size of the files specified in the manifest file can't exceed 25 GB when imported into SPICE\. This limit isn't based on the actual size of the files\. Instead, the limit is based on the space that the files occupy after they are imported into SPICE\. The SPICE capacity is calculated using the formula described in [Capacity Planning for SPICE](managing-spice-capacity.md#capacity-planning-for-spice)\. 

The total number of files specified in the manifest file can't exceed 1000\. 

Files can have up to 1000 columns\. Each column name can have up to 127 characters\. 

## Table and Query Limits<a name="table-limits"></a>

Any table or query result set you want to import into [SPICE](welcome.md#spice) must use 25 GB or less of space in SPICE\. The size limit is calculated based on the capacity the data occupies after imported into SPICE\. The SPICE capacity is calculated using the formula described in [Capacity Planning for SPICE](managing-spice-capacity.md#capacity-planning-for-spice)\.

If you want to retrieve data from a larger table, you can use one of several methods to reduce the size of the data\. You can deselect columns, or apply filters\. In a SQL query, you can also use predicates, such as `WHERE`, `HAVING`\.

Tables can have up to 1000 columns\. Each column name can have up to 127 characters\. 

## Field Limits<a name="field-limits"></a>

Data in any field of a data set you import into SPICE must be 511 characters or less\. Each field name can have up to 127 characters\.

## Supported Data Types<a name="supported-data-types"></a>

Amazon QuickSight currently supports the following primitive data types:
+ Date\. Dates must be in one of the [Supported Date Formats](#supported-date-formats)\.
+ Decimal\. The decimal data type supports up to four decimal places to the right of the decimal point\. Values that have a higher scale than this are truncated to the fourth decimal place when displayed in data preparation or analyses and when imported into SPICE\. For example, 13\.00049 is truncated to 13\.0004\.

  During data preparation, calculated fields that use decimal data with more than four decimal places use the full value to perform the calculation\. If the result is again decimal data that uses more than four decimal places, the result is then truncated as described preceding\. For more information, see [Handling Decimal Values in Calculated Fields](working-with-calculated-fields.md#handling-decimal-fields)\. 
+ Integer
+ String

Make sure that any table or file that you use as a data source contains only fields that can be implicitly converted to these data types\. Amazon QuickSight skips any data rows that can't be converted\. 

The following table lists the source data types that are supported\. Boolean data types are converted to integers in Amazon QuickSight\.


****  

| Database Engine or Source | Numeric Data Types | String Data Types | Datetime Data Types | Boolean Data Types | 
| --- | --- | --- | --- | --- | 
|   **Amazon Athena, Presto**  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/data-source-limits.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/data-source-limits.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/data-source-limits.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/data-source-limits.html)  | 
|  **Amazon Aurora**, **MariaDB**, and **MySQL**  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/data-source-limits.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/data-source-limits.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/data-source-limits.html)  |  | 
|   **PostgreSQL**   |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/data-source-limits.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/data-source-limits.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/data-source-limits.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/data-source-limits.html)  | 
|   **Apache Spark**  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/data-source-limits.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/data-source-limits.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/data-source-limits.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/data-source-limits.html)  | 
|   **Snowflake**   |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/data-source-limits.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/data-source-limits.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/data-source-limits.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/data-source-limits.html)  | 
|   **Microsoft SQL Server**   |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/data-source-limits.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/data-source-limits.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/data-source-limits.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/data-source-limits.html)  | 

## Unsupported Data Values<a name="unsupported-data-values"></a>

If a field contains values that don't conform with the data type that Amazon QuickSight assigns to the field, the rows containing those values are skipped\. For example, take the following source data\.

```
Sales ID    Sales Date    Sales Amount
-------------------------------------- 
001        10/14/2015        12.43
002        5/3/2012          25.00
003        Unknown           18.17
004        3/8/2009          86.02
```

Amazon QuickSight interprets Sales Date as a date field and drops the row containing a nondate value, so only the following rows are imported\.

```
Sales ID    Sales Date    Sales Amount
-------------------------------------- 
001        10/14/2015        12.43
002        5/3/2012          25.00
004        3/8/2009          86.02
```

Also, if a database field contains values that can't be interpreted by the JDBC driver for the source database engine, the uninterpretable values are replaced by null so that the rows can be imported\. The only known occurrence of this issue is with MySQL date, datetime, and timestamp fields that have all\-zero values, for example **0000\-00\-00 00:00:00**\. For example, take the following source data\.

```
Sales ID    Sales Date                Sales Amount
--------------------------------------------------- 
001        2004-10-12 09:14:27        12.43
002        2012-04-07 12:59:03        25.00
003        0000-00-00 00:00:00        18.17
004        2015-09-30 01:41:19        86.02
```

In this case, the following data is imported\.

```
Sales ID    Sales Date                Sales Amount
--------------------------------------------------- 
001        2004-10-12 09:14:27        12.43
002        2012-04-07 12:59:03        25.00
003        (null)                     18.17
004        2015-09-30 01:41:19        86.02
```

## Handling Date Time Zones<a name="date-interpretation"></a>

Amazon QuickSight uses UTC time for querying, filtering, and displaying date data\.

When date data doesn't specify a time zone, Amazon QuickSight assumes UTC values\. When date data does specify a time zone, Amazon QuickSight converts it to display in UTC time\. For example, a date field with a time zone offset like **2015\-11\-01T03:00:00\-08:00** is converted to UTC and displayed in Amazon QuickSight as **2015\-11\-01T15:30:00**\.

## Supported Date Formats<a name="supported-date-formats"></a>

Data in date fields must be in one of the following supported formats, depending on the data source type\. 

For file uploads, Amazon S3 sources, Athena and Salesforce, Amazon QuickSight supports the use of date and time formats \(both 24 hr and am/pm\) described in the Joda API documentation\. See [Class DateTimeFormat](http://www.joda.org/joda-time/apidocs/org/joda/time/format/DateTimeFormat.html) for a complete list of Joda date formats\. 

For relational database sources, including Amazon Redshift, Amazon RDS, PostgreSQL, MySQL, Aurora, MariaDB, and Microsoft SQL Server, Amazon QuickSight supports the following date and time formats \(24 hr only\): 

Amazon QuickSight supports dates in the range from Jan 1, 1400 00:00:00 UTC to Feb 26, 2364 23:59:59 UTC for SPICE data sets, \.

1.  `dd/MM/yyyy HH:mm:ss`, for example 31/12/2016 15:30:00\. 

1.  `dd/MM/yyyy`, for example 31/12/2016\. 

1.  `dd/MMM/yyyy HH:mm:ss`, for example 31/DEC/2016 15:30:00\. 

1.  `dd/MMM/yyyy`, for example 31/DEC/2016\. 

1.  `dd-MMM-yyyy HH:mm:ss`, for example 31\-DEC\-2016 15:30:00\. 

1.  `dd-MMM-yyyy`, for example 31\-DEC\-2016\. 

1.  `dd-MM-yyyy HH:mm:ss`, for example 31\-12\-2016 15:30:00\. 

1.  `dd-MM-yyyy`, for example 31\-12\-2016\. 

1.  `MM/dd/yyyy HH:mm:ss`, for example 12/31/2016 15:30:00\. 

1.  `MM/dd/yyyy`, for example 12/31/2016\. 

1.  `MM-dd-yyyy HH:mm:ss`, for example 12\-31\-2016 15:30:00\. 

1.  `MM-dd-yyyy`, for example 12\-31\-2016\. 

1.  `MMM/dd/yyyy HH:mm:ss`, for example DEC/31/2016 15:30:00\. 

1.  `MMM/dd/yyyy`, for example DEC/31/2016\. 

1.  `MMM-dd-yyyy HH:mm:ss`, for example DEC\-31\-2016 15:30:00\. 

1.  `MMM-dd-yyyy`, for example DEC\-31\-2016\. 

1.  `yyyy/MM/dd HH:mm:ss`, for example 2016/12/31 15:30:00\. 

1.  `yyyy/MM/dd`, for example 2016/12/31\. 

1.  `yyyy/MMM/dd HH:mm:ss`, for example 2016/DEC/31 15:30:00\. 

1.  `yyyy/MMM/dd`, for example 2016/DEC/31\. 

1.  `yyyy-MM-dd HH:mm:ss`, for example 2016\-12\-31 15:30:00\. 

1.  `yyyy-MM-dd`, for example 2016\-12\-31\. 

1.  `yyyy-MMM-dd HH:mm:ss`, for example 2016\-DEC\-31 15:30:00\. 

1.  `yyyy-MMM-dd`, for example 2016\-DEC\-31\. 

1. `yyyyMMdd'T'HHmmss`, for example 20161231T153000\.

1. `yyyy-MM-dd'T'HH:mm:ss`, for example 2016\-12\-31T15:30:00\.

**Note**  
When you create a calculated column formula using a date format that contains apostrophes, make sure to escape them\. For example, `formatDate({myDateField}, "yyyyMMdd'T'HHmmss")` or `formatDate({myDateField}, 'yyyyMMdd\'T\'HHmmss')`\.
