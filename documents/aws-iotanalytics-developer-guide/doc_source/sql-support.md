# SQL expressions in AWS IoT Analytics<a name="sql-support"></a>

Data sets are generated using SQL expressions on data in a data store\. AWS IoT Analytics uses the same SQL queries, functions and operators as Amazon Athena\.

AWS IoT Analytics supports a subset of ANSI standard SQL syntax as follows\.

```
SELECT [ ALL | DISTINCT ] select_expression [, ...]
[ FROM from_item [, ...] ]
[ WHERE condition ]
[ GROUP BY [ ALL | DISTINCT ] grouping_element [, ...] ]
[ HAVING condition ]
[ UNION [ ALL | DISTINCT ] union_query ]
[ ORDER BY expression [ ASC | DESC ] [ NULLS FIRST | NULLS LAST] [, ...] ]
[ LIMIT [ count | ALL ] ]
```

However, AWS IoT Analytics doesn't support JOIN or WITH clauses\.

Amazon Athena and AWS IoT Analytics SQL functionality are based on Presto 0\.172, so they support the following functions:
+ [Logical operators](https://prestodb.io/docs/0.172/functions/logical.html)
+ [Comparison functions and operators](https://prestodb.io/docs/0.172/functions/comparison.html)
+ [Conditional expressions](https://prestodb.io/docs/0.172/functions/conditional.html)
+ [Conversion functions](https://prestodb.io/docs/0.172/functions/conversion.html)
+ [Mathematical functions and operators](https://prestodb.io/docs/0.172/functions/math.html)
+ [Bitwise functions](https://prestodb.io/docs/0.172/functions/bitwise.html)
+ [Decimal functions and operators](https://prestodb.io/docs/0.172/functions/decimal.html)
+ [String functions and operators](https://prestodb.io/docs/0.172/functions/string.html)
+ [Binary functions](https://prestodb.io/docs/0.172/functions/binary.html)
+ [Date and time functions and operators](https://prestodb.io/docs/0.172/functions/datetime.html)
+ [Regular expression functions](https://prestodb.io/docs/0.172/functions/regexp.html)
+ [JSON functions and operators](https://prestodb.io/docs/0.172/functions/json.html)
+ [URL functions](https://prestodb.io/docs/0.172/functions/url.html)
+ [Aggregate functions](https://prestodb.io/docs/0.172/functions/aggregate.html)
+ [Window functions](https://prestodb.io/docs/0.172/functions/window.html)
+ [Color functions](https://prestodb.io/docs/0.172/functions/color.html)
+ [Array functions and operators](https://prestodb.io/docs/0.172/functions/array.html)
+ [Map functions and operators](https://prestodb.io/docs/0.172/functions/map.html)
+ [Lambda expressions and functions](https://prestodb.io/docs/0.172/functions/lambda.html)
+ [Teradata functions](https://prestodb.io/docs/0.172/functions/teradata.html)

AWS IoT Analytics and Amazon Athena don't support the following:
+ User\-defined functions \(UDFs or UDAFs\)\.
+ Stored procedures
+ Some data types\.
+ CREATE TABLE AS SELECT statements\.
+ INSERT INTO statements\.
+ Prepared statements\. You cannot run EXECUTE with USING\.
+ CREATE TABLE LIKE\.
+ DESCRIBE INPUT and DESCRIBE OUTPUT
+ EXPLAIN statements\.
+ Federated connectors\.

These are the supported data types:
+ primitive\_type
  + TINYINT
  + SMALLINT
  + INT
  + BIGINT
  + BOOLEAN
  + DOUBLE
  + FLOAT
  + STRING
  + TIMESTAMP
  + DECIMAL\[\(\)precision, scale\]
  + DATE
  + CHAR\(fixed\-length character data with a specified length\)
  + VARCHAR \(variable\-length character data with a specified length\)
+ array\_type
  + ARRAY<data\_type>
+ map\_type
  + MAP<primitive\_type, data\_type>
+ struct\_type
  + STRUCT<col\_name:data\_type\[COMMENT col\_comment\]\[,\.\.\.\]>

AWS IoT Analytics entity names \(channel, data set, data store, and pipeline names\) must begin with a lower\-case letter and contain only lower\-case letters, digits and underscores\.

AWS IoT Analytics and Amazon Athena table, database and column names must contain only lower\-case letters, digits and underscore\. Use backticks to enclose table or column names that begin with an underscore, such as the following example\.

```
CREATE_TABLE `_myunderscoretable`(
   `_id` string,
   `_index` string,
   ...
```

Enclose table names that include numbers in quotation marks, such as the following example\.

```
CREATE_TABLE "table123"(
   `_id` string,
   `_index` string,
   ...
```