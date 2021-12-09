# Migrating Data from an Amazon RDS MySQL DB Instance to an Amazon Aurora MySQL DB Cluster<a name="CHAP_MySQL2Aurora.RDSMySQL"></a>

You can migrate \(copy\) data to an Amazon Aurora MySQL DB cluster from an Amazon RDS snapshot, as described following\.

**Note**  
Because Amazon Aurora MySQL is compatible with MySQL, you can migrate data from your MySQL database by setting up replication between your MySQL database, and an Amazon Aurora MySQL DB cluster\. We recommend that your MySQL database run MySQL version 5\.5 or later\.

## Migrating an RDS MySQL Snapshot to Aurora MySQL<a name="CHAP_MySQL2Aurora.RDSMySQL.Snapshot"></a>

You can migrate a DB snapshot of an Amazon RDS MySQL DB instance to create an Aurora MySQL DB cluster\. The new DB cluster is populated with the data from the original Amazon RDS MySQL DB instance\. The DB snapshot must have been made from an Amazon RDS DB instance running MySQL 5\.6\.

You can migrate either a manual or automated DB snapshot\. After the DB cluster is created, you can then create optional Aurora MySQL Replicas\.

The general steps you must take are as follows:

1. Determine the amount of space to provision for your Amazon Aurora MySQL DB cluster\. For more information, see the [Amazon RDS documentation](http://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/CHAP_Storage.html)\.

1. Use the console to create the snapshot in the region where the Amazon RDS MySQL 5\.6 instance is located

1. If the DB snapshot is not in the region as your DB cluster, use the Amazon RDS console to copy the DB snapshot to that region\. For information about copying a DB snapshot, see the [ Amazon RDS documentation ](http://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/USER_CopySnapshot.html)\.

1. Use the console to migrate the DB snapshot and create an Amazon Aurora MySQL DB cluster with the same databases as the original DB instance of MySQL 5\.6\. 

**Warning**  
Amazon RDS limits each AWS account to one snapshot copy into each region at a time\.

### How Much Space Do I Need?<a name="CHAP_MySQL2Aurora.RDSMySQL.Snapshot.Space"></a>

When you migrate a snapshot of a MySQL DB instance into an Aurora MySQL DB cluster, Aurora MySQL uses an Amazon Elastic Block Store \(Amazon EBS\) volume to format the data from the snapshot before migrating it\. In some cases, additional space is needed to format the data for migration\. When migrating data into your DB cluster, observe the following guidelines and limitations:
+ Although Amazon Aurora MySQL supports storage up to 64 TB in size, the process of migrating a snapshot into an Aurora MySQL DB cluster is limited by the size of the EBS volume of the snapshot\. Thus, the maximum size for a snapshot that you can migrate is 6 TB\.
+ Tables that are not MyISAM tables and are not compressed can be up to 6 TB in size\. If you have MyISAM tables, then Aurora MySQL must use additional space in the volume to convert the tables to be compatible with Aurora MySQL\. If you have compressed tables, then Aurora MySQL must use additional space in the volume to expand these tables before storing them on the Aurora MySQL cluster volume\. Because of this additional space requirement, you should ensure that none of the MyISAM and compressed tables being migrated from your MySQL DB instance exceeds 3 TB in size\.

### Reducing the Amount of Space Required to Migrate Data into Amazon Aurora MySQL<a name="CHAP_MySQL2Aurora.RDSMySQL.Snapshot.PreImport"></a>

You might want to modify your database schema prior to migrating it into Amazon Aurora MySQL\. Such modification can be helpful in the following cases: 
+ You want to speed up the migration process\.
+ You are unsure of how much space you need to provision\.
+ You have attempted to migrate your data and the migration has failed due to a lack of provisioned space\.

You can make the following changes to improve the process of migrating a database into Amazon Aurora MySQL\.

**Important**  
Be sure to perform these updates on a new DB instance restored from a snapshot of a production database, rather than on a production instance\. You can then migrate the data from the snapshot of your new DB instance into your Amazon Aurora MySQL DB cluster to avoid any service interruptions on your production database\.


| Table Type | Limitation or Guideline | 
| --- | --- | 
|  MyISAM tables  |  Amazon Aurora MySQL supports InnoDB tables only\. If you have MyISAM tables in your database, then those tables must be converted before being migrated into Amazon Aurora MySQL\. The conversion process requires additional space for the MyISAM to InnoDB conversion during the migration procedure\. To reduce your chances of running out of space or to speed up the migration process, convert all of your MyISAM tables to InnoDB tables before migrating them\. The size of the resulting InnoDB table is equivalent to the size required by Amazon Aurora MySQL for that table\. To convert a MyISAM table to InnoDB, run the following command:  `alter table <schema>.<table_name> engine=innodb, algorithm=copy;`   | 
|  Compressed tables  |  Amazon Aurora MySQL does not support compressed tables \(that is, tables created with `ROW_FORMAT=COMPRESSED`\)\.  To reduce your chances of running out of space or to speed up the migration process, expand your compressed tables by setting `ROW_FORMAT` to `DEFAULT`, `COMPACT`, `DYNAMIC`, or `REDUNDANT`\. For more information, see [https://dev\.mysql\.com/doc/refman/5\.6/en/innodb\-row\-format\.html](https://dev.mysql.com/doc/refman/5.6/en/innodb-row-format.html)\.   | 

You can use the following SQL script on your existing MySQL DB instance to list the tables in your database that are MyISAM tables or compressed tables\.

```
 1. -- This script examines a MySQL database for conditions that will block
 2. -- migrating the database into an Amazon Aurora MySQL DB.
 3. -- It needs to be run from an account that has read permission for the
 4. -- INFORMATION_SCHEMA database.
 5. 
 6. -- Verify that this is a supported version of MySQL.
 7. 
 8. select msg as `==> Checking current version of MySQL.`
 9. from
10.   (
11.   select
12.     'This script should be run on MySQL version 5.6. ' +
13.     'Earlier versions are not supported.' as msg,
14.     cast(substring_index(version(), '.', 1) as unsigned) * 100 + 
15.       cast(substring_index(substring_index(version(), '.', 2), '.', -1) 
16.       as unsigned) 
17.     as major_minor
18.   ) as T
19. where major_minor <> 506;
20. 
21. 
22. -- List MyISAM and compressed tables. Include the table size.
23. 
24. select concat(TABLE_SCHEMA, '.', TABLE_NAME) as `==> MyISAM or Compressed Tables`,
25. round(((data_length + index_length) / 1024 / 1024), 2) "Approx size (MB)"
26. from INFORMATION_SCHEMA.TABLES
27. where
28.   ENGINE <> 'InnoDB'
29.   and
30.   (
31.     -- User tables
32.     TABLE_SCHEMA not in ('mysql', 'performance_schema', 
33.                          'information_schema')
34.     or
35.     -- Non-standard system tables
36.     (
37.       TABLE_SCHEMA = 'mysql' and TABLE_NAME not in
38.         (
39.           'columns_priv', 'db', 'event', 'func', 'general_log',
40.           'help_category', 'help_keyword', 'help_relation',
41.           'help_topic', 'host', 'ndb_binlog_index', 'plugin',
42.           'proc', 'procs_priv', 'proxies_priv', 'servers', 'slow_log',
43.           'tables_priv', 'time_zone', 'time_zone_leap_second',
44.           'time_zone_name', 'time_zone_transition', 
45.           'time_zone_transition_type', 'user'
46.         )
47.     )
48.   )
49.   or
50.   (
51.     -- Compressed tables
52.        ROW_FORMAT = 'Compressed'
53.   );
```

The script produces output similar to the output in the following example\. The example shows two tables that must be converted from MyISAM to InnoDB\. The output also includes the approximate size of each table in megabytes \(MB\)\. 

```
1. +---------------------------------+------------------+
2. | ==> MyISAM or Compressed Tables | Approx size (MB) |
3. +---------------------------------+------------------+
4. | test.name_table                 |          2102.25 |
5. | test.my_table                   |            65.25 |
6. +---------------------------------+------------------+
7. 2 rows in set (0.01 sec)
```

### Migrating a DB Snapshot by Using the Console<a name="CHAP_MySQL2Aurora.RDSMySQL.Snapshot.Console"></a>

You can migrate a DB snapshot of an Amazon RDS MySQL DB instance to create an Aurora MySQL DB cluster\. The new DB cluster will be populated with the data from the original Amazon RDS MySQL DB instance\. The DB snapshot must have been made from an Amazon RDS DB instance running MySQL 5\.6 and must not be encrypted\. For information about creating a DB snapshot, see the [Amazon RDS documentation](http://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/USER_CreateSnapshot.html)\.

If the DB snapshot is not in the AWS Region where you want to locate your data, use the Amazon RDS console to copy the DB snapshot to that region\. For information about copying a DB snapshot, see the [Amazon RDS documentation](http://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/USER_CopySnapshot.html)\.

When you migrate the DB snapshot by using the console, the console takes the actions necessary to create both the DB cluster and the primary instance\.

You can also choose for your new Aurora MySQL DB cluster to be encrypted "at rest" using an AWS Key Management Service \(AWS KMS\) encryption key\. This option is available only for unencrypted DB snapshots\.

**To migrate a MySQL 5\.6 DB snapshot by using the console**

1. Sign in to the AWS Management Console and open the Amazon RDS console at [https://console\.aws\.amazon\.com/rds/](https://console.aws.amazon.com/rds/)\.

1. Choose **Snapshots**\.

1. On the **Snapshots** page, choose the snapshot that you want to migrate into an Aurora MySQL DB cluster\.

1. Choose **Migrate Database**\.  
![\[Migrate a snapshot into Amazon Aurora MySQL\]](http://docs.aws.amazon.com/dms/latest/sbs/images/AuroraMigrate02.png)

1. Set the following values on the **Migrate Database** page:
   + **DB Instance Class**: Select a DB instance class that has the required storage and capacity for your database, for example `db.r3.large`\. Aurora MySQL cluster volumes automatically grow as the amount of data in your database increases, up to a maximum size of 64 terabytes \(TB\)\. So you only need to select a DB instance class that meets your current storage requirements\.
   + **DB Instance Identifier**: Type a name for the DB cluster that is unique for your account in the region you selected\. This identifier is used in the endpoint addresses for the instances in your DB cluster\. You might choose to add some intelligence to the name, such as including the region and DB engine you selected, for example **aurora\-cluster1**\.

     The DB instance identifier has the following constraints:
     + It must contain from 1 to 63 alphanumeric characters or hyphens\.
     + Its first character must be a letter\.
     + It cannot end with a hyphen or contain two consecutive hyphens\.
     + It must be unique for all DB instances per AWS account, per AWS Region\.
   + ****VPC**:** If you have an existing VPC, then you can use that VPC with your Amazon Aurora MySQL DB cluster by selecting your VPC identifier, for example `vpc-a464d1c1`\. For information on using an existing VPC, see the [Amazon RDS documentation](http://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/Aurora.CreateVPC.html)\.

     Otherwise, you can choose to have Amazon RDS create a VPC for you by selecting **Create a new VPC**\. 
   + ****Subnet Group**:** If you have an existing subnet group, then you can use that subnet group with your Amazon Aurora MySQL DB cluster by selecting your subnet group identifier, for example `gs-subnet-group1`\.

     Otherwise, you can choose to have Amazon RDS create a subnet group for you by selecting **Create a new subnet group**\. 
   + ****Publicly Accessible**:** Select **No** to specify that instances in your DB cluster can only be accessed by resources inside of your VPC\. Select **Yes** to specify that instances in your DB cluster can be accessed by resources on the public network\. The default is **Yes**\.
**Note**  
Your production DB cluster might not need to be in a public subnet, because only your application servers will require access to your DB cluster\. If your DB cluster doesn't need to be in a public subnet, set **Publicly Accessible** to **No**\.
   + ****Availability Zone**:** Select the Availability Zone to host the primary instance for your Aurora MySQL DB cluster\. To have Amazon RDS select an Availability Zone for you, select **No Preference**\.
   + ****Database Port**:** Type the default port to be used when connecting to instances in the DB cluster\. The default is `3306`\.
**Note**  
You might be behind a corporate firewall that doesn't allow access to default ports such as the MySQL default port, 3306\. In this case, provide a port value that your corporate firewall allows\. Remember that port value later when you connect to the Aurora MySQL DB cluster\.
   + ****Enable Encryption**:** Choose **Yes** for your new Aurora MySQL DB cluster to be encrypted "at rest\." If you choose **Yes**, you will be required to choose an AWS KMS encryption key as the **Master Key** value\.
   + ****Auto Minor Version Upgrade**:** Select **Yes** if you want to enable your Aurora MySQL DB cluster to receive minor MySQL DB engine version upgrades automatically when they become available\.

     The **Auto Minor Version Upgrade** option only applies to upgrades to MySQL minor engine versions for your Amazon Aurora MySQL DB cluster\. It doesn't apply to regular patches applied to maintain system stability\.  
![\[Migrate a snapshot into Amazon Aurora MySQL\]](http://docs.aws.amazon.com/dms/latest/sbs/images/AuroraMigrate03.png)

1. Choose **Migrate** to migrate your DB snapshot\. 

1. Choose **Instances**, and then choose the arrow icon to show the DB cluster details and monitor the progress of the migration\. On the details page, you will find the cluster endpoint used to connect to the primary instance of the DB cluster\. For more information on connecting to an Amazon Aurora MySQL DB cluster, see the [Amazon RDS documentation](http://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/Aurora.Connect.html)\.   
![\[DB Cluster Details\]](http://docs.aws.amazon.com/dms/latest/sbs/images/AuroraMigrate04.png)