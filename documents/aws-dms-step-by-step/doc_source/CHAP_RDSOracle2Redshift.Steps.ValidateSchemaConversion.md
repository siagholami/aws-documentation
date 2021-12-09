# Step 6: Validate the Schema Conversion<a name="CHAP_RDSOracle2Redshift.Steps.ValidateSchemaConversion"></a>

To validate the schema conversion, you compare the objects found in the Oracle and Amazon Redshift databases using SQL Workbench/J\.

**To validate the schema conversion using SQL Workbench/J**

1. In SQL Workbench/J, choose **File**, then choose **Connect window**\. Choose the **RedshiftConnection** you created in an earlier step\. Choose **OK**\.

1. Run the following script to verify the number of object types and count in SH schema in the target Amazon Redshift database\. These values should match the number of objects in the source Oracle database\.

   ```
   SELECT 'TABLE' AS OBJECT_TYPE,
          TABLE_NAME AS OBJECT_NAME,
          TABLE_SCHEMA AS OBJECT_SCHEMA
   FROM information_schema.TABLES
   WHERE TABLE_TYPE = 'BASE TABLE'
   AND   OBJECT_SCHEMA = 'sh';
   ```

   The output from this query should be similar to the following\.

   ```
   object_type | object_name | object_schema
   ------------+-------------+--------------
   TABLE       | channels    | sh           
   TABLE       | customers   | sh           
   TABLE       | products    | sh           
   TABLE       | promotions  | sh           
   TABLE       | sales       | sh
   ```

1. Verify the sort and distributions keys that are created in the Amazon Redshift cluster by using the following query\.

   ```
   set search_path to '$user', 'public', 'sh';
   
   SELECT tablename,
          "column",
          TYPE,
          encoding,
          distkey,
          sortkey,
          "notnull"
   FROM pg_table_def
   WHERE (distkey = TRUE OR sortkey <> 0);
   ```

   The results of the query reflect the distribution key \(`distkey`\) and sort key \(`sortkey`\) choices made by using AWS SCT key management\. 

   ```
   tablename  | column              | type                        | encoding | distkey | sortkey | notnull
   -----------+---------------------+-----------------------------+----------+---------+---------+--------
   channels   | channel_id          | numeric(38,18)              | none     | true    |       1 | true   
   customers  | cust_id             | numeric(38,18)              | none     | false   |       4 | true   
   customers  | cust_gender         | character(2)                | none     | false   |       1 | true   
   customers  | cust_year_of_birth  | smallint                    | none     | false   |       3 | true   
   customers  | cust_marital_status | character varying(40)       | none     | false   |       2 | false  
   products   | prod_id             | integer                     | none     | true    |       4 | true   
   products   | prod_subcategory    | character varying(100)      | none     | false   |       3 | true   
   products   | prod_category       | character varying(100)      | none     | false   |       2 | true   
   products   | prod_status         | character varying(40)       | none     | false   |       1 | true   
   promotions | promo_id            | integer                     | none     | true    |       1 | true   
   sales      | prod_id             | numeric(38,18)              | none     | false   |       4 | true   
   sales      | cust_id             | numeric(38,18)              | none     | false   |       3 | true   
   sales      | time_id             | timestamp without time zone | none     | true    |       1 | true   
   sales      | channel_id          | numeric(38,18)              | none     | false   |       2 | true   
   sales      | promo_id            | numeric(38,18)              | none     | false   |       5 | true
   ```