# Step\-by\-Step Migration<a name="CHAP_SQLServer2Aurora.Steps"></a>

The following steps provide instructions for migrating a Microsoft SQL Server database to an Amazon Aurora MySQL database\. These steps assume that you have already prepared your source database as described in [Prerequisites](CHAP_SQLServer2Aurora.Prerequisites.md)\. 

**Topics**
+ [Step 1: Install the SQL Drivers and AWS Schema Conversion Tool on Your Local Computer](CHAP_SQLServer2Aurora.Steps.InstallSCT.md)
+ [Step 2: Configure Your Microsoft SQL Server Source Database](CHAP_SQLServer2Aurora.Steps.ConfigureSQLServer.md)
+ [Step 3: Configure Your Aurora MySQL Target Database](CHAP_SQLServer2Aurora.Steps.ConfigureAurora.md)
+ [Step 4: Use AWS SCT to Convert the SQL Server Schema to Aurora MySQL](CHAP_SQLServer2Aurora.Steps.ConvertSchema.md)
+ [Step 5: Create an AWS DMS Replication Instance](CHAP_SQLServer2Aurora.Steps.CreateReplicationInstance.md)
+ [Step 6: Create AWS DMS Source and Target Endpoints](CHAP_SQLServer2Aurora.Steps.CreateSourceTargetEndpoints.md)
+ [Step 7: Create and Run Your AWS DMS Migration Task](CHAP_SQLServer2Aurora.Steps.CreateMigrationTask.md)
+ [Step 8: Cut Over to Aurora MySQL](CHAP_SQLServer2Aurora.Steps.CutOver.md)