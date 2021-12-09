# Migrating Databases to Amazon Web Services \(AWS\)<a name="CHAP_Introduction"></a>

## AWS Migration Tools<a name="CHAP_Introduction.AWSTools"></a>

You can use several AWS tools and services to migrate data from an external database to AWS\. Depending on the type of database migration you are doing, you may find that the native migration tools for your database engine are also effective\.

AWS Database Migration Service \(AWS DMS\) helps you migrate databases to AWS efficiently and securely\. The source database can remain fully operational during the migration, minimizing downtime to applications that rely on the database\. AWS DMS can migrate your Oracle data to the most widely used commercial and open\-source databases on AWS\.

 AWS DMS migrates data, tables, and primary keys to the target database\. All other database elements are not migrated\. If you are migrating an Oracle database to Amazon Aurora with MySQL compatibility, for example, you would want to use the AWS Schema Conversion Tool in conjunction with AWS DMS\.

The AWS Schema Conversion Tool \(SCT\) makes heterogeneous database migrations easy by automatically converting the source database schema and a majority of the custom code, including views, stored procedures, and functions, to a format compatible with the target database\. Any code that cannot be automatically converted is clearly marked so that it can be manually converted\. You can use this tool to convert your source Oracle databases to an Amazon Aurora MySQL, MySQL, or PostgreSQL target database on either Amazon RDS or EC2\.

It is important to understand that DMS and SCT are two different tools and serve different needs and they don’t interact with each other in the migration process\. As per the DMS best practice, migration methodology for this tutorial is outlined as below:
+ AWS DMS takes a minimalist approach and creates only those objects required to efficiently migrate the data for example tables with primary key – therefore, we will use DMS to load the tables with data without any foreign keys or constraints\. \(We can also use the SCT to generate the table scripts and create it on the target before performing the load via DMS\)\.
+ We will leverage SCT:
  + To identify the issues, limitations and actions for the schema conversion
  + To generate the target schema scripts including foreign key and constraints
  + To convert code such as procedures and views from source to target and apply it on target

The size and type of Oracle database migration you want to do greatly determines the tools you should use\. For example, a heterogeneous migration, where you are migrating from an Oracle database to a different database engine on AWS, is best accomplished using AWS DMS\. A homogeneous migration, where you are migrating from an Oracle database to an Oracle database on AWS, is best accomplished using native Oracle tools\.

## Walkthroughs in this Guide<a name="CHAP_Introduction.Walkthroughs"></a>

[Migrating an On\-Premises Oracle Database to Amazon Aurora MySQL](CHAP_On-PremOracle2Aurora.md)

[Migrating an Amazon RDS Oracle Database to Amazon Aurora MySQL](CHAP_RDSOracle2Aurora.md)

[Migrating a SQL Server Database to Amazon Aurora MySQL](CHAP_SQLServer2Aurora.md)

[Migrating an Oracle Database to PostgreSQL](CHAP_RDSOracle2PostgreSQL.md)

[Migrating an Amazon RDS for Oracle Database to Amazon Redshift](CHAP_RDSOracle2Redshift.md)

[Migrating MySQL\-Compatible Databases to AWS](CHAP_MySQL.md)

[Migrating a MySQL\-Compatible Database to Amazon Aurora MySQL](CHAP_MySQL2Aurora.md)