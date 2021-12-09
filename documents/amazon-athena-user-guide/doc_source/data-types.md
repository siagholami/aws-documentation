# Data Types in Amazon Athena<a name="data-types"></a>

When you run [CREATE TABLE](create-table.md), you specify column names and the data type that each column can contain\. Athena supports the the data types listed below\. For information about the data type mappings that the JDBC driver supports between Athena, JDBC, and Java, see [Data Types](https://s3.amazonaws.com/athena-downloads/drivers/JDBC/SimbaAthenaJDBC_2.0.5/docs/Simba+Athena+JDBC+Driver+Install+and+Configuration+Guide.pdf#page=37) in the *JDBC Driver Installation and Configuration Guide*\. For information about the data type mappings that the ODBC driver supports between Athena and SQL, see [Data Types](https://s3.amazonaws.com/athena-downloads/drivers/ODBC/SimbaAthenaODBC_1.0.5/Simba+Athena+ODBC+Install+and+Configuration+Guide.pdf#page=50) in the *ODBC Driver Installation and Configuration Guide*\.
+ **`BOOLEAN`** – Values are `true` and `false`\.
+ **`TINYINT`** – A 8\-bit signed `INTEGER` in two’s complement format, with a minimum value of \-27 and a maximum value of 27\-1\.
+ **`SMALLINT`** – A 16\-bit signed `INTEGER` in two’s complement format, with a minimum value of \-215 and a maximum value of 215\-1\.
+ **`INT`** and **`INTEGER`** – Athena combines two different implementations of the integer data type, as follows:
  + **`INT`** – In Data Definition Language \(DDL\) queries, Athena uses the `INT` data type\.
  + **`INTEGER`** – In DML queries, Athena uses the `INTEGER` data type\. `INTEGER` is represented as a 32\-bit signed value in two's complement format, with a minimum value of \-231 and a maximum value of 231\-1\. 
    + To ensure compatibility with business analytics applications, the JDBC driver returns the `INTEGER` type\.
+ **`BIGINT`** – A 64\-bit signed `INTEGER` in two’s complement format, with a minimum value of \-263 and a maximum value of 263\-1\.
+ **`DOUBLE`** – A 64\-bit double\-precision floating point number\.
+ **`FLOAT`** – A 32\-bit single\-precision floating point number\. Equivalent to the `REAL` in Presto\. In Athena, use `FLOAT` in DDL statements like `CREATE TABLE` and `REAL` in SQL functions like `SELECT CAST`\. The AWS Glue crawler returns values in `FLOAT`, and Athena translates `REAL` and `FLOAT` types internally \(see the [June 5, 2018](release-note-2018-06-05.md) release notes\)\.
+ **`DECIMAL`**`(precision, scale)` – `precision` is the total number of digits\. `scale` \(optional\) is the number of digits in fractional part with a default of 0\. For example, use these type definitions: `DECIMAL(11,5)`, `DECIMAL(15)`\.

  To specify decimal values as literals, such as when selecting rows with a specific decimal value in a query DDL expression, specify the `DECIMAL` type definition, and list the decimal value as a literal \(in single quotes\) in your query, as in this example: `decimal_value = DECIMAL '0.12'`\. 
+ **`CHAR`** – Fixed length character data, with a specified length between 1 and 255, such as `char(10)`\. For more information, see [CHAR Hive Data Type](https://cwiki.apache.org/confluence/display/Hive/LanguageManual+Types#LanguageManualTypes-char)\.
**Note**  
To use the `substr` function to return a substring of specified length from a `CHAR` data type, you must first cast the `CHAR` value as a `VARCHAR`, as in the following example\.  

  ```
  substr(cast(col1 as varchar), 1, 4)
  ```
+ **`VARCHAR`** – Variable length character data, with a specified length between 1 and 65535, such as `varchar(10)`\. For more information, see [VARCHAR Hive Data Type](https://cwiki.apache.org/confluence/display/Hive/LanguageManual+Types#LanguageManualTypes-varchar)\. 
+ **`STRING`** – A string literal enclosed in single or double quotes\. For more information, see [STRING Hive Data Type](https://cwiki.apache.org/confluence/display/Hive/LanguageManual+Types#LanguageManualTypes-StringsstringStrings)\.
**Note**  
Non\-string data types cannot be cast to `STRING` in Athena; cast them to `VARCHAR` instead\.
+ **`BINARY`** – Used for data in Parquet\.
+ **`DATE`** – A date in ISO format, such as `YYYY-MM-DD`\. For example, `DATE '2008-09-15'`\.
+ **`TIMESTAMP`** – Date and time instant in a `java.sql.Timestamp` compatible format, such as `yyyy-MM-dd HH:mm:ss[.f...]`\. For example, `TIMESTAMP '2008-09-15 03:04:05.324'`\. This format uses the session time zone\.
+ **`ARRAY`**`<data_type>`
+ **`MAP`**`<primitive_type, data_type>`
+ **`STRUCT`**`<col_name : data_type [COMMENT col_comment] , ...>`