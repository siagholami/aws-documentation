# Step 6: Validate the Schema Conversion<a name="CHAP_RDSOracle2Aurora.Steps.ValidateSchemaConversion"></a>

To validate the schema conversion, you compare the objects found in the Oracle and Aurora MySQL databases using SQL Workbench/J\.

**To validate the schema conversion using SQL Workbench/J**

1. In SQL Workbench/J, choose **File**, then choose **Connect window**\. Choose the RDSAuroraConnection you created in an earlier step\. Click **OK**\.

1. Run the following script to verify the number of object types and count in HR schema in the target Aurora MySQL database\. These values should match the number of objects in the source Oracle database: 

   ```
   SELECT a.OBJECT_TYPE, COUNT(*)
   FROM
   (
   SELECT OBJECT_TYPE
   ,OBJECT_SCHEMA
   ,OBJECT_NAME
   FROM (
   SELECT 'TABLE' AS OBJECT_TYPE
   ,TABLE_NAME AS OBJECT_NAME
   ,TABLE_SCHEMA AS OBJECT_SCHEMA
   FROM information_schema.TABLES
   where  TABLE_TYPE='BASE TABLE'
   UNION
   SELECT 'VIEW' AS OBJECT_TYPE
   ,TABLE_NAME AS OBJECT_NAME
   ,TABLE_SCHEMA AS OBJECT_SCHEMA
   FROM information_schema.VIEWS
   UNION
   
   SELECT 'INDEX' AS OBJECT_TYPE
   ,CONCAT (
   CONSTRAINT_TYPE
   ,' : '
   ,CONSTRAINT_NAME
   ,' : '
   ,TABLE_NAME
   ) AS OBJECT_NAME
   ,TABLE_SCHEMA AS OBJECT_SCHEMA
   FROM information_schema.TABLE_CONSTRAINTS
   where constraint_type='PRIMARY KEY'
   UNION
   SELECT ROUTINE_TYPE AS OBJECT_TYPE
   ,ROUTINE_NAME AS OBJECT_NAME
   ,ROUTINE_SCHEMA AS OBJECT_SCHEMA
   FROM information_schema.ROUTINES
   UNION
   SELECT 'TRIGGER' AS OBJECT_TYPE
   ,CONCAT (
   TRIGGER_NAME
   ,' : '
   ,EVENT_OBJECT_SCHEMA
   ,' : '
   ,EVENT_OBJECT_TABLE
   ) AS OBJECT_NAME
   ,TRIGGER_SCHEMA AS OBJECT_SCHEMA
   FROM information_schema.triggers
   ) R
   WHERE R.OBJECT_SCHEMA ='HR'
   order by 1) a 
   GROUP BY a.OBJECT_TYPE;
   ```

   The output from this query should be similar to the following:

   ```
   OBJECT_TYPE	COUNT(*)		
   	INDEX	7		
   	PROCEDURE   2		
   	TABLE	7		
   	TRIGGER     4		
   	VIEW	1
   ```

   Next, run the following query to get table constraints information:

   ```
   SELECT CONSTRAINT_TYPE,COUNT(*) 
   FROM information_schema.TABLE_CONSTRAINTS where constraint_schema='HR' 	
   GROUP BY CONSTRAINT_TYPE;
   ```

   The output from this query should be similar to the following:

   ```
   CONSTRAINT_TYPE	COUNT(*)		
   	FOREIGN KEY	10		
   	PRIMARY KEY	7
   ```

1. Do the following steps to enable the auto\_increment option on the EMPLOYEES table to emulate the sequence functionality of the source Oracle database\.

   1. Verify that the mapping rules for data type conversion were executed properly for EMPLOYEES and its dependent tables by running the following query on the target Aurora MySQL database\.

      ```
      SELECT   
      kcu.constraint_name,
      kcu.column_name,
      col.data_type,
      kcu.table_schema,
      kcu.table_name,
      kcu.referenced_column_name
      FROM    
      information_schema.key_column_usage kcu,
      information_schema.table_constraints tc,
      information_schema.columns col
      WHERE    kcu.referenced_table_schema = 'HR'
      AND      kcu.referenced_table_name = 'EMPLOYEES'
      AND      kcu.referenced_table_name=tc.table_name
      AND      kcu.referenced_table_schema=tc.table_schema
      AND     tc.constraint_type='PRIMARY KEY'
      AND col.column_name=kcu.column_name
      and col.table_name=kcu.table_name
      ORDER BY kcu.table_name,kcu.column_name;
      ```

      The results of the query should be the following:

      ```
      constraint_name column_name  data_type  table_schema table_name  referenced_column_name
      DEPT_MGR_FK	MANAGER_ID  Smallint   HR	   DEPARTMENTS	EMPLOYEE_ID
      EMP_MANAGER_FK   MANAGER_ID  Smallint   HR	   EMPLOYEES	EMPLOYEE_ID
      JHIST_EMP_FK    EMPLOYEE_ID  Smallint   HR	    JOB_HISTORY	EMPLOYEE_ID
      ```

   1. Disable foreign key checks for the EMPLOYEES table by running the following command\. This step is required before you can alter the primary key column\. You can ignore the warning messages\.

      ```
      SET FOREIGN_KEY_CHECKS=0;
      ```

   1. Modify the primary key column to enable the auto\_increment option by running the following command:

      ```
      Alter table HR.EMPLOYEES modify column employee_id smallint auto_increment;
      ```

   1. Verify the column details by running the following query:

      ```
      SELECT column_name, column_type,column_key,extra 
      from information_schema.columns 
      where table_name = 'EMPLOYEES' AND COLUMN_NAME='EMPLOYEE_ID';
      ```

      The results of the query should be the following:

      ```
      column_name	column_type	column_key	extra
      employee_id	smallint(6)	PRI	     auto_increment
      ```

1. The following table shows the expected numbers of objects and whether they were migrated by AWS SCT\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_RDSOracle2Aurora.Steps.ValidateSchemaConversion.html)

1. Validate the results as mentioned in the spreadsheet provided by AWS [on this site](https://dms-sbs.s3.amazonaws.com/AWSDMSDemoStats.xlsx) or the text document provided by AWS [on this site](https://dms-sbs.s3.amazonaws.com/AWSDMSDemoStats.txt)\. 