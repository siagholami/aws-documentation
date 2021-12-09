# Changing a Field Data Type<a name="changing-a-field-data-type"></a>

When Amazon QuickSight retrieves data, it assigns each field a data type based on the data in the field\. The possible data types are as follows:
+ Date — The date data type is used for date data in a supported format\. For information about the date formats Amazon QuickSight supports, see [Data Source Limits](data-source-limits.md)\.
+ Decimal — The decimal data type is used for numeric data that requires one or more decimal places of precision, for example 18\.23\. The decimal data type supports values with up to four decimal places to the right of the decimal point\. Values that have a higher scale than this are truncated to the fourth decimal place when displayed in data preparation or analyses and when imported into [SPICE](welcome.md#spice)\. For example, 13\.00049 is truncated to 13\.0004\.
+ Int — The int data type is used for numeric data that only contains integers, for example 39\.
+ String — The string data type is used for nondate alphanumeric data\.

During data preparation, you can change the data type of any field from the data source but not that of any calculated field you create\. Amazon QuickSight converts the field data according to the data type you choose\. Rows that contain data that is incompatible with that data type are skipped\. For example, suppose that you convert the following field from String to Int\.

```
10020
36803
14267a
98457
78216b
```

All records containing alphabetic characters in that field are skipped, as shown following\.

```
10020
36803
98457
```

If you have a database data set with fields whose data types aren't supported by Amazon QuickSight, use a SQL query during data preparation\. Then use `CAST` or `CONVERT` commands \(depending on what is supported by the source database\) to change the field data types\. For more information about adding a SQL query during data preparation, see [Using a SQL Query](adding-a-SQL-query.md)\. For more information about how different source data types are interpreted by Amazon QuickSight, see [Supported Data Types](data-source-limits.md#supported-data-types)\.

If you have numeric fields that act as dimensions rather than metrics, for example ZIP codes and most ID numbers, it's helpful to give them a string data type during data preparation\. Doing this lets Amazon QuickSight understand that they are not useful for performing mathematical calculations and can only be aggregated with the *Count* function\. For more information about how Amazon QuickSight uses dimensions and measures, see [Setting a Field as a Dimension or Measure](setting-dimension-or-measure.md)\.

In [SPICE](welcome.md#spice), numbers converted from numeric into an integer are truncated by default\. If you want to round your numbers instead, you can create a calculated field using the [`round`](round-function.md) function\. To see whether numbers are rounded or truncated before they are ingested into SPICE, check your database engine\.

**To change a field data type**

1. In the data preview pane, choose the data type icon under the field you want to change\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/data-types.png)

1. Choose the target data type\. Only data types other than the one currently in use are listed\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/data-types2.png)