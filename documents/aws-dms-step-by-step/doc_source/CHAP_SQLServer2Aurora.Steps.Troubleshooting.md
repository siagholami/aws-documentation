# Troubleshooting<a name="CHAP_SQLServer2Aurora.Steps.Troubleshooting"></a>

When you work with Microsoft SQL Server as a source database and Amazon Aurora MySQL as a target database, the two most common problem areas are SQL Server change data capture \(CDC\) and foreign keys\.
+ MS\-CDC: If you are using MS\-CDC with SQL Server for the migration, errors that are related to permissions or errors during change data capture are common\. These types of errors usually result when one of the prerequisites was not met\. For example, the most common overlooked prerequisite is a full database backup\.
+ Foreign keys: During the full load process, AWS DMS does not load tables in any particular order, so it might load the child table data before parent table data\. As a result, foreign key constraints might be violated if they are enabled\. You should disable foreign keys on the Aurora MySQL target database\. You can enable the foreign keys on the target after the migration is complete\.

For more tips, see the AWS DMS troubleshooting section in the [AWS DMS User Guide](http://docs.aws.amazon.com/dms/latest/userguide/CHAP_Troubleshooting.html)\.

To troubleshoot issues specific to SQL Server, see the SQL Server troubleshooting section:
+ [Troubleshooting Microsoft SQL Server Specific Issues](http://docs.aws.amazon.com/dms/latest/userguide/CHAP_Troubleshooting.html#CHAP_Troubleshooting.SQLServer)

To troubleshoot Aurora MySQL issues, see the Aurora MySQL troubleshooting section and the MySQL troubleshooting section:
+ [Troubleshooting Amazon Aurora MySQL Specific Issues](http://docs.aws.amazon.com/dms/latest/userguide/CHAP_Troubleshooting.html#CHAP_Troubleshooting.Aurora)
+ [Troubleshooting MySQL Specific Issues](http://docs.aws.amazon.com/dms/latest/userguide/CHAP_Troubleshooting.html#CHAP_Troubleshooting.MySQL)