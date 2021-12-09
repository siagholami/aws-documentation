# Step\-by\-Step Migration<a name="CHAP_RDSOracle2PostgreSQL.Steps"></a>

The following steps provide instructions for migrating an Oracle database to a PostgreSQL database\. These steps assume that you have already prepared your source database as described in [Prerequisites](CHAP_RDSOracle2PostgreSQL.Prerequisites.md)\. 

**Topics**
+ [Step 1: Install the SQL Drivers and AWS Schema Conversion Tool on Your Local Computer](CHAP_RDSOracle2PostgreSQL.Steps.InstallSCT.md)
+ [Step 2: Configure Your Oracle Source Database](CHAP_Oracle2PostgreSQL.Steps.ConfigureOracle.md)
+ [Step 3: Configure Your PostgreSQL Target Database](CHAP_Oracle2PostgreSQL.Steps.ConfigurePostgreSQL.md)
+ [Step 4: Use the AWS Schema Conversion Tool \(AWS SCT\) to Convert the Oracle Schema to PostgreSQL](CHAP_RDSOracle2PostgreSQL.Steps.ConvertSchema.md)
+ [Step 5: Create an AWS DMS Replication Instance](CHAP_RDSOracle2PostgreSQL.Steps.CreateReplicationInstance.md)
+ [Step 6: Create AWS DMS Source and Target Endpoints](CHAP_RDSOracle2PostgreSQL.Steps.CreateSourceTargetEndpoints.md)
+ [Step 7: Create and Run Your AWS DMS Migration Task](CHAP_RDSOracle2PostgreSQL.Steps.CreateMigrationTask.md)
+ [Step 8: Cut Over to PostgreSQL](CHAP_RDSOracle2PostgreSQL.Steps.CutOver.md)