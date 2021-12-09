# Migrating a SQL Server Database to Amazon Aurora MySQL<a name="CHAP_SQLServer2Aurora"></a>

Using this walkthrough, you can learn how to migrate a Microsoft SQL Server database to an Amazon Aurora with MySQL compatibility database using the AWS Schema Conversion Tool \(AWS SCT\) and AWS Database Migration Service \(AWS DMS\)\. AWS DMS migrates your data from your SQL Server source into your Aurora MySQL target\. 

AWS DMS doesn't migrate your secondary indexes, sequences, default values, stored procedures, triggers, synonyms, views, and other schema objects that aren't specifically related to data migration\. To migrate these objects to your Aurora MySQL target, use AWS SCT\.

**Topics**
+ [Prerequisites](CHAP_SQLServer2Aurora.Prerequisites.md)
+ [Step\-by\-Step Migration](CHAP_SQLServer2Aurora.Steps.md)
+ [Troubleshooting](CHAP_SQLServer2Aurora.Steps.Troubleshooting.md)