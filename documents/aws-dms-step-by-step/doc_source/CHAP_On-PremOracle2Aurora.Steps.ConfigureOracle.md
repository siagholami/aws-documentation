# Step 1: Configure Your Oracle Source Database<a name="CHAP_On-PremOracle2Aurora.Steps.ConfigureOracle"></a>

To use Oracle as a source for AWS Database Migration Service \(AWS DMS\), you must first ensure that ARCHIVELOG MODE is on to provide information to LogMiner\. AWS DMS uses LogMiner to read information from the archive logs so that AWS DMS can capture changes\. 

For AWS DMS to read this information, make sure the archive logs are retained on the database server as long as AWS DMS requires them\. If you configure your task to begin capturing changes immediately, you should only need to retain archive logs for a little longer than the duration of the longest running transaction\. Retaining archive logs for 24 hours is usually sufficient\. If you configure your task to begin from a point in time in the past, archive logs need to be available from that time forward\. For more specific instructions for enabling ARCHIVELOG MODE and ensuring log retention for your on\-premises Oracle database see the [Oracle documentation](https://community.oracle.com/thread/3717174)\. 

To capture change data, AWS DMS requires supplemental logging to be enabled on your source database for AWS DMS\. Minimal supplemental logging must be enabled at the database level\. AWS DMS also requires that identification key logging be enabled\. This option causes the database to place all columns of a row's primary key in the redo log file whenever a row containing a primary key is updated \(even if no value in the primary key has changed\)\. You can set this option at the database or table level\.

If your Oracle source is in Amazon RDS, your database will be placed in ARCHIVELOG MODE if, and only if, you enable backups\. The following command will ensure archive logs are retained on your RDS source for 24 hours:

```
exec rdsadmin.rdsadmin_util.set_configuration('archivelog retention hours',24);
```

**To configure your Oracle source database**

1. Run the following command to enable supplemental logging at the database level, which AWS DMS requires:

   ```
   ALTER DATABASE ADD SUPPLEMENTAL LOG DATA;
   
   For RDS:
   exec rdsadmin.rdsadmin_util.alter_supplemental_logging('ADD');
   ```

1. Use the following command to enable identification key supplemental logging at the database level\. AWS DMS requires supplemental key logging at the database level unless you allow AWS DMS to automatically add supplemental logging as needed or enable key\-level supplemental logging at the table level:

   ```
   ALTER DATABASE ADD SUPPLEMENTAL LOG DATA (PRIMARY KEY) COLUMNS;
   
   For RDS:
   exec rdsadmin.rdsadmin_util.alter_supplemental_logging('ADD','PRIMARY KEY');
   ```

1. Your source database incurs a small bit of overhead when key level supplemental logging is enabled\. Therefore, if you are migrating only a subset of your tables, you might want to enable key level supplemental logging at the table level\. To enable key level supplemental logging at the table level, use the following command\.

   ```
   alter table table_name add supplemental log data (PRIMARY KEY) columns;
   ```

   If a table does not have a primary key you have two options\.
   + You can add supplemental logging to all columns involved in the first unique index on the table \(sorted by index name\.\) 
   + You can add supplemental logging on all columns of the table\. 

   To add supplemental logging on a subset of columns in a table, that is those involved in a unique index, run the following command\.

   ```
   ALTER TABLE table_name ADD SUPPLEMENTAL LOG GROUP example_log_group (ID,NAME) 
   ALWAYS;
   ```

   To add supplemental logging for all columns of a table, run the following command\.

   ```
   alter table table_name add supplemental log data (ALL) columns;                       
   ```

1. Create or configure a database account to be used by AWS DMS\. We recommend that you use an account with the minimal privileges required by AWS DMS for your AWS DMS connection\. AWS DMS requires the following privileges\. 

   ```
   CREATE SESSION
   SELECT ANY TRANSACTION
   SELECT on V_$ARCHIVED_LOG
   SELECT on V_$LOG
   SELECT on V_$LOGFILE
   SELECT on V_$DATABASE
   SELECT on V_$THREAD
   SELECT on V_$PARAMETER
   SELECT on V_$NLS_PARAMETERS
   SELECT on V_$TIMEZONE_NAMES
   SELECT on V_$TRANSACTION
   SELECT on ALL_INDEXES
   SELECT on ALL_OBJECTS
   SELECT on ALL_TABLES
   SELECT on ALL_USERS
   SELECT on ALL_CATALOG
   SELECT on ALL_CONSTRAINTS
   SELECT on ALL_CONS_COLUMNS
   SELECT on ALL_TAB_COLS
   SELECT on ALL_IND_COLUMNS
   SELECT on ALL_LOG_GROUPS
   SELECT on SYS.DBA_REGISTRY
   SELECT on SYS.OBJ$
   SELECT on DBA_TABLESPACES
   SELECT on ALL_TAB_PARTITIONS
   SELECT on ALL_ENCRYPTED_COLUMNS
   * SELECT on all tables migrated
   ```

   If you want to capture and apply changes \(CDC\) you also need the following privileges\.

   ```
   EXECUTE on DBMS_LOGMNR 
   SELECT on V_$LOGMNR_LOGS
   SELECT on V_$LOGMNR_CONTENTS
   LOGMINING /* For Oracle 12c and higher. */
   * ALTER for any table being replicated (if you want DMS to add supplemental logging)
   ```

   For Oracle versions before 11\.2\.0\.3, you need the following privileges\. If views are exposed, you need the following privileges\.

   ```
   SELECT on DBA_OBJECTS /* versions before 11.2.0.3 */
   SELECT on ALL_VIEWS (required if views are exposed)
   ```