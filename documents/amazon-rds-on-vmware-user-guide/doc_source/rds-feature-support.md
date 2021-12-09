# Support for RDS Features in Amazon RDS on VMware<a name="rds-feature-support"></a>

The primary use case for Amazon RDS on VMware is to support the Amazon RDS service with your choice of database on a VMware infrastructure\.

The following table shows current Amazon RDS on VMware support for Amazon RDS features\.


****  

| Feature | Supported | Notes | More Information | 
| --- | --- | --- | --- | 
| DB instance provisioning | Yes | — | [Creating an Amazon RDS DB Instance](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/CHAP_CommonTasks.Create.html) | 
| Modifying the master user password | No | — | [Modifying an Amazon RDS DB Instance](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/Overview.DBInstance.Modifying.html) | 
| Modifying the DB engine version | Yes | For the PostgreSQL DB engine, RDS on VMware supports version 10\.9\-R1 and 10\.10\-R1\. For the Microsoft SQL Server and MySQL DB engines, RDS on VMware currently only supports one DB engine version\. | [Modifying an Amazon RDS DB Instance](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/Overview.DBInstance.Modifying.html) | 
| Renaming a DB instance | Yes | — | [Renaming a DB Instance](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/USER_RenameInstance.html) | 
| Rebooting a DB instance | Yes | — | [Rebooting a DB Instance](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/USER_RebootInstance.html) | 
| Stopping a DB instance | No | — | [Stopping an Amazon RDS DB Instance Temporarily](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/USER_StopInstance.html) | 
| Starting a DB instance | No | — | [Starting an Amazon RDS DB Instance That Was Previously Stopped](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/USER_StartInstance.html) | 
| Multi\-AZ deployments | No | — | [High Availability \(Multi\-AZ\) for Amazon RDS](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/Concepts.MultiAZ.html) | 
| DB parameter groups | No | — | [Working with DB Parameter Groups](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/USER_WorkingWithParamGroups.html) | 
| Read replicas | Yes | Currently, this feature is supported for MySQL and PostgreSQL\. | [Working with Read Replicas](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/USER_ReadRepl.html) | 
| Encryption at rest and compliance certification | No | — | [Encrypting Amazon RDS Resources](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/Overview.Encryption.html) | 
| Tagging Amazon RDS resources | Yes | — | [Tagging Amazon RDS Resources](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/USER_Tagging.html) | 
| Option groups | No | — | [Working with Option Groups](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/USER_WorkingWithOptionGroups.html) | 
| Modifying the maintenance window | Yes | Modifying the maintenance window is supported, but you can't view or apply maintenance updates\. | [Maintaining a DB Instance](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/USER_UpgradeDBInstance.Maintenance.html) | 
| Modifying the backup window | No | — | [Working With Backups](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/USER_StartInstance.html) | 
| DB instance scaling | Yes | Modify the on\-premises DB instance class to scale the DB instance\. |  [Modifying an Amazon RDS DB Instance](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/Overview.DBInstance.Modifying.html) [Choosing the On\-Premises DB Instance Class](db-instance-class-on-premises.md)  | 
| Manual and automatic DB snapshots | Yes | All DB snapshots are stored locally\. DB snapshots aren't stored in Amazon S3\. DB snapshot copying and sharing aren't supported\. | [Creating a DB Snapshot](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/USER_CreateSnapshot.html) | 
| Restoring from a DB snapshot | Yes | — | [Restoring from a DB Snapshot](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/USER_RestoreFromSnapshot.html) | 
| Point\-in\-time recovery | Yes | Currently, this feature is supported for MySQL and PostgreSQL\. It isn't supported for Microsoft SQL Server\. | [Restoring a DB Instance to a Specified Time](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/USER_PIT.html) | 
| Enhanced Monitoring | No | — | [Enhanced Monitoring](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/USER_Monitoring.OS.html) | 
| Amazon CloudWatch monitoring | Yes | — | [Monitoring with Amazon CloudWatch](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/MonitoringOverview.html#monitoring-cloudwatch) | 
| Publishing database engine logs to Amazon CloudWatch Logs | No | — | [Publishing Database Engine Logs to Amazon CloudWatch Logs](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/MonitoringOverview.html#publishing_cloudwatchlogs) | 
| Event notification | No | — | [Using Amazon RDS Event Notification](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/USER_Events.html) | 
| Amazon RDS Performance Insights | No | — | [Using Amazon RDS Performance Insights](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/USER_PerfInsights.html) | 
| Stored procedures for Amazon RDS for MySQL | Yes | — | [MySQL on Amazon RDS SQL Reference](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/Appendix.MySQL.SQLRef.html) | 
| Automatic minor engine version upgrade | Yes | RDS on VMware doesn't support creating read replicas or importing a DB instance from Amazon S3, so enabling auto minor version upgrade during these operations doesn't apply to RDS on VMware DB instances\. | [ Automatically Upgrading the Minor Engine Version](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/USER_UpgradeDBInstance.Upgrading.html#USER_UpgradeDBInstance.Upgrading.AutoMinorVersionUpgrades) | 
| Replication with external databases \(MySQL\) | No | — | [Replication with a MySQL or MariaDB Instance Running External to Amazon RDS](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/MySQL.Procedural.Importing.External.Repl.html) | 
| Importing backups from Amazon S3 \(Microsoft SQL Server\) | No | — | [Importing and Exporting SQL Server Databases](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/SQLServer.Procedural.Importing.html) | 

**Note**  
Amazon RDS DB instance classes and storage types don't apply to Amazon RDS on VMware\.