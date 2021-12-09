# Step 8: Cut Over to PostgreSQL<a name="CHAP_RDSOracle2PostgreSQL.Steps.CutOver"></a>

Perform the following steps to move connections from your Oracle database to your PostgreSQL database\.

**To cut over to PostgreSQL**

1. End all Oracle database dependencies and activities, such as running scripts and client connections\.

   The following query should return no results:

   ```
   SELECT MACHINE, COUNT FROM V$SESSION GROUP BY MACHINE;
   ```

1. List any remaining sessions, and kill them\.

   ```
   SELECT SID, SERIAL#, STATUS FROM V$SESSION;
                           
   ALTER SYSTEM KILL 'sid, serial_number' IMMEDIATE;
   ```

1. Shut down all listeners on the Oracle database\.

1. Let the AWS DMS task apply the final changes from the Oracle database on the PostgreSQL database\.

   ```
   ALTER SYSTEM CHECKPOINT;
   ```

1. In the AWS DMS console, stop the AWS DMS task by clicking **Stop** for the task, and confirm that you want to stop the task\.

1. \(Optional\) Set up a rollback\.

   You can optionally set up a rollback task, in case you run into a show stopping issue, by creating a task going in the opposite direction\. Because all tables should be in sync between both databases, you only need to set up a CDC task\. Therefore, you do not have to disable any foreign key constraints\. Now that the source and target databases are reversed, you must follow the instructions in the following sections:
   + [Using a PostgreSQL Database as a Source for AWS Database Migration Service](http://docs.aws.amazon.com/dms/latest/userguide/CHAP_Source.PostgreSQL.html)
   + [Using an Oracle Database as a Target for AWS Database Migration Service](http://docs.aws.amazon.com/dms/latest/userguide/CHAP_Target.Oracle.html)

   1. Disable triggers on the source Oracle database\.

      ```
      SELECT 'ALTER TRIGGER' || owner || '.' || trigger_name || 'DISABLE;' 
         FROM DBA_TRIGGERS WHERE OWNER = 'schema_name';
      ```

      You do not have to disable the foreign key constraints\. During the CDC process, foreign key constraints are updated in the same order as they are updated by application users\.

   1. Create a new CDC\-only AWS DMS task with the endpoints reversed \(source PostgreSQL endpoint and target Oracle endpoint database\)\. See [Step 7: Create and Run Your AWS DMS Migration Task](CHAP_RDSOracle2PostgreSQL.Steps.CreateMigrationTask.md)\.

      For the rollback task, set **Migration type** to **Replicate data changes only** and **Target table preparation mode** to **Do nothing**\.

   1. Start the AWS DMS task to enable you to push changes back to the original source Oracle database from the new PostgreSQL database if rollback is necessary\. 

1. Connect to the PostgreSQL database, and enable triggers\.

   ```
   ALTER TABLE table_name ENABLE TRIGGER ALL;
   ```

1. If you set up a rollback, then complete the rollback setup\.

   1. Start the application services on new target PostgreSQL database \(including scripts , client software, and so on\)\.

   1. Add Cloudwatch monitoring on your new PostgreSQL database\. See [Monitoring Amazon RDS](http://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/CHAP_Monitoring.html)\.