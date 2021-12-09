# Step\-by\-Step Migration<a name="CHAP_RDSOracle2Aurora.Steps"></a>

In the following sections, you can find step\-by\-step instructions for migrating an Amazon Relational Database Service \(Amazon RDS\) Oracle database to Amazon Aurora MySQL\. These steps assume that you have already prepared your source database as described in preceding sections\. 

**Topics**
+ [Step 1: Launch the RDS Instances in a VPC by Using the CloudFormation Template](CHAP_RDSOracle2Aurora.Steps.LaunchRDSwCloudFormation.md)
+ [Step 2: Install the SQL Tools and AWS Schema Conversion Tool on Your Local Computer](CHAP_RDSOracle2Aurora.Steps.InstallSCT.md)
+ [Step 3: Test Connectivity to the Oracle DB Instance and Create the Sample Schema](CHAP_RDSOracle2Aurora.Steps.ConnectOracle.md)
+ [Step 4: Test the Connectivity to the Aurora MySQL DB Instance](CHAP_RDSOracle2Aurora.Steps.ConnectAurora.md)
+ [Step 5: Use the AWS Schema Conversion Tool \(AWS SCT\) to Convert the Oracle Schema to Aurora MySQL](CHAP_RDSOracle2Aurora.Steps.ConvertSchema.md)
+ [Step 6: Validate the Schema Conversion](CHAP_RDSOracle2Aurora.Steps.ValidateSchemaConversion.md)
+ [Step 7: Create a AWS DMS Replication Instance](CHAP_RDSOracle2Aurora.Steps.CreateReplicationInstance.md)
+ [Step 8: Create AWS DMS Source and Target Endpoints](CHAP_RDSOracle2Aurora.Steps.CreateSourceTargetEndpoints.md)
+ [Step 9: Create and Run Your AWS DMS Migration Task](CHAP_RDSOracle2Aurora.Steps.CreateMigrationTask.md)
+ [Step 10: Verify That Your Data Migration Completed Successfully](CHAP_RDSOracle2Aurora.Steps.VerifyDataMigration.md)
+ [Step 11: Delete Walkthrough Resources](CHAP_RDSOracle2Aurora.Steps.DeleteResources.md)