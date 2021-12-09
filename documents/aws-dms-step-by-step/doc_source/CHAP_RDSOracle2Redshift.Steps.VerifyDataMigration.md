# Step 10: Verify That Your Data Migration Completed Successfully<a name="CHAP_RDSOracle2Redshift.Steps.VerifyDataMigration"></a>

When the migration task completes, you can compare your task results with the expected results\.

**To compare your migration task results with the expected results**

1. On the navigation pane, choose **Tasks**\. 

1. Choose your migration task \(**migrateSHschema**\)\.

1. Choose the **Table statistics** tab, shown following\.  
![\[Table statistics tab\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2redshift26.png)

1. Connect to the Amazon Redshift instance by using SQL Workbench/J, and then check whether the database tables were successfully migrated from Oracle to Amazon Redshift by running the SQL script shown following\.

   ```
   select "table", tbl_rows
   from svv_table_info
   where
   SCHEMA = 'sh'
   order by 1;
   ```

   Your results should look similar to the following\.

   ```
   table      | tbl_rows
   -----------+---------
   channels   |        5
   customers  |        8
   products   |       66
   promotions |      503
   sales      |     1106
   ```

1. To verify whether the output for tables and number of rows from the preceding query matches what is expected for RDS Oracle, compare your results with those in previous steps\.

1. Run the following query to check the relationship in tables; this query checks the departments with employees greater than 10\.

   ```
   Select b.channel_desc,count(*) from SH.SALES a,SH.CHANNELS b where a.channel_id=b.channel_id 
   group by b.channel_desc 
   order by 1;
   ```

   The output from this query should be similar to the following\.

   ```
   channel_desc | count
   -------------+------
   Direct Sales |   355
   Internet     |    26
   Partners     |   172
   ```

1. Verify column compression encoding\.

   DMS uses an Amazon Redshift COPY operation to load data\. By default, the COPY command applies automatic compression whenever loading to an empty target table\. The sample data for this walkthrough is not large enough for automatic compression to be applied\. When you migrate larger data sets, COPY will apply automatic compression\. 

   For more details about automatic compression on Amazon Redshift tables, see [Loading Tables with Automatic Compression](http://docs.aws.amazon.com/redshift/latest/dg/c_Loading_tables_auto_compress.html)\.

   To view compression encodings, run the following query\.

   ```
   SELECT *
   FROM pg_table_def
   WHERE schemaname = 'sh’;
   ```

Now you have successfully completed a database migration from an Amazon RDS for Oracle DB instance to Amazon Redshift\.