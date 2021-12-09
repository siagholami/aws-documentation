# Step 2: Configure Your Microsoft SQL Server Source Database<a name="CHAP_SQLServer2Aurora.Steps.ConfigureSQLServer"></a>

After installing the SQL drivers and AWS Schema Conversion Tool, you can configure your Microsoft SQL Server source database using one of several options, depending on how you plan to migrate your data\. 

**To configure your SQL Server source database**
+ When configuring your source database, you can choose to migrate existing data only, migrate existing data and replicate ongoing changes, or migrate existing data and use change data capture \(CDC\) to replicate ongoing changes\. For more information about these options, see [Prerequisites](CHAP_SQLServer2Aurora.Prerequisites.html)\.
  + Migrating existing data only

    No configuration steps are necessary for the SQL Server database\. You can move on to [Step 3: Configure Your Aurora MySQL Target Database](CHAP_SQLServer2Aurora.Steps.ConfigureAurora.md)\.
**Note**  
If the SQL Server database is an Amazon RDS database, replication is not supported, and you must use the option for migrating existing data only\.
  + Migrating existing data and replicating ongoing changes
**Note**  
Replication requires a primary key for all tables that are being replicated\. If your tables don't have primary keys defined, consider using CDC instead\.

    To configure MS\-REPLICATION, complete the following steps:

    1. In Microsoft SQL Server Management Studio, open the context \(right\-click\) menu for the **Replication** folder, and then choose **Configure Distribution**\.

    1. In the **Distributor** step, choose ***db\_name* will act as its own distributor**\. SQL Server creates a distribution database and log\.

       For more information, see the [ Microsoft documentation](https://docs.microsoft.com/en-us/sql/relational-databases/replication/enable-a-database-for-replication-sql-server-management-studio)\.

       When the configuration is complete, your server is enabled for replication\. Either a distribution database is in place, or you have configured your server to use a remote distribution database\.
  + Migrating existing data and using change data capture \(CDC\) to replicate ongoing changes

    To configure MS\-CDC, complete the following steps:

    1. Connect to SQL Server with a login that has SYSADMIN role membership\.

    1. For each database containing data that is being migrated, run the following command within the database context:

       ```
       use [DBname]
       EXEC sys.sp_cdc_enable_db
       ```

    1. For each table that you want to configure for ongoing migration, run the following command:

       ```
              
       EXEC sys.sp_cdc_enable_table @source_schema = N'schema_name', @source_name = N'table_name', @role_name = NULL;
       ```

       For more information, see the [ Microsoft documentation](https://docs.microsoft.com/en-us/sql/relational-databases/track-changes/enable-and-disable-change-data-capture-sql-server)\.

**Note**  
If you are migrating databases that participate in an AlwaysOn Availability Group, it is best practice to use replication for migration\. To use this option, publishing must be enabled, and a distribution database must be configured for each node of the AlwaysOn Availability Group\. Additionally, ensure you are using the name of the availability group listener for the database rather than the name of the server currently hosting the availability group database for the target server name\. These requirement apply to each instance of SQL Server in the cluster and must not be configured using the availability group listener\.
If your database isn’t supported for MS\-REPLICATION or MS\-CDC \(for example, if you are running the Workgroup Edition of SQL Server\), some changes can still be captured, such as `INSERT` and `DELETE` statements, but other DML statements such as `UPDATE` and `TRUNCATE TABLE` will not be captured\. Therefore, a migration with continuing data replication is not recommended in this configuration, and a static one time migration \(or repeated one time full migrations\) should be considered instead\.

For more information about using MS\-REPLICATION and MS\-CDC, see [Configuring a Microsoft SQL Server Database as a Replication Source for AWS Database Migration Service](http://docs.aws.amazon.com/dms/latest/userguide/CHAP_Source.SQLServer.html#CHAP_Source.SQLServer.Configuration)\.