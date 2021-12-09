# Table Not Found When Using Athena with Amazon QuickSight<a name="troubleshoot-athena-table-not-found"></a>

If you receive a "`table not found`" error, this can happen if the tables in an analysis are missing from the Athena data source\. 

In the Athena console, check for your table under the corresponding schema\. You can recreate the table in Athena and then create a new data set in Amazon QuickSight on that table\. To investigate how the table was lost in the first place, you can use the Athena console to check the query history\. This helps you locate the queries that dropped the table\.

If this error happened when you were editing a custom SQL query in preview, verify the name of the table in the query, and check for any other syntax errors\. Amazon QuickSight can't infer the schema from the query\. The schema must be specified in the query\. 

For example, the following statement works\.

```
select from my_schema.my_table
```

The following statement fails because it's missing the schema\.

```
select from my_table
```