# Replication Between Aurora and MySQL or Between Aurora and Another Aurora DB Cluster \(Binlog Replication\)<a name="AuroraMySQL.Replication.MySQL"></a>

Because Amazon Aurora MySQL is compatible with MySQL, you can set up replication between a MySQL database and an Amazon Aurora MySQL DB cluster\. This type of replication uses the MySQL binary log replication, and is commonly referred to as *binlog replication*\. If you use binlog replication with Aurora, we recommend that your MySQL database run MySQL version 5\.5 or later\. You can set up replication where your Aurora MySQL DB cluster is the replication source or the replica\. You can replicate with an Amazon RDS MySQL DB instance, a MySQL database external to Amazon RDS, or another Aurora MySQL DB cluster\. 

You can also replicate with an Amazon RDS MySQL DB instance or Aurora MySQL DB cluster in another AWS Region\. When you're performing replication across AWS Regions, ensure that your DB clusters and DB instances are publicly accessible\. Aurora MySQL DB clusters must be part of a public subnet in your VPC\.

If you want to configure replication between an Aurora MySQL DB cluster and an Aurora MySQL DB cluster in another region, you can create an Aurora MySQL DB cluster as a read replica in a different AWS Region than the source DB cluster\. For more information, see [Replicating Amazon Aurora MySQL DB Clusters Across AWS Regions](AuroraMySQL.Replication.CrossRegion.md)\.

 With Aurora MySQL 2\.04 and higher, you can replicate between Aurora MySQL and an external source or target that uses global transaction identifiers \(GTIDs\) for replication\. Ensure that the GTID\-related parameters in the Aurora MySQL DB cluster have settings that are compatible with the GTID status of the external database\. To learn how to do this, see [Using GTID\-Based Replication for Aurora MySQL](mysql-replication-gtid.md)\. 

**Warning**  
When you replicate between Aurora MySQL and MySQL, ensure that you use only InnoDB tables\. If you have MyISAM tables that you want to replicate, you can convert them to InnoDB before setting up replication with the following command\.  

```
alter table <schema>.<table_name> engine=innodb, algorithm=copy;
```

Setting up MySQL replication with Aurora MySQL involves the following steps, which are discussed in detail following in this topic:

[1\. Enable Binary Logging on the Replication Source](#AuroraMySQL.Replication.MySQL.EnableBinlog)

[2\. Retain Binary Logs on the Replication Source Until No Longer Needed](#AuroraMySQL.Replication.MySQL.RetainBinlogs)

[3\. Create a Snapshot of Your Replication Source](#AuroraMySQL.Replication.MySQL.CreateSnapshot)

[4\. Load the Snapshot into Your Replica Target](#AuroraMySQL.Replication.MySQL.LoadSnapshot)

[5\. Enable Replication on Your Replica Target](#AuroraMySQL.Replication.MySQL.EnableReplication)

[6\. Monitor Your Replica](#AuroraMySQL.Replication.MySQL.Monitor)

## Setting Up Replication with MySQL or Another Aurora DB Cluster<a name="AuroraMySQL.Replication.MySQL.SettingUp"></a>

To set up Aurora replication with MySQL, take the following steps\. 

### 1\. Enable Binary Logging on the Replication Source<a name="AuroraMySQL.Replication.MySQL.EnableBinlog"></a>

Find instructions on how to enable binary logging on the replication source for your database engine following\.


| Database Engine | Instructions | 
| --- | --- | 
|  Aurora  |  **To enable binary logging on an Aurora MySQL DB cluster** Set the `binlog_format` parameter to `ROW`, `STATEMENT`, or `MIXED`\. `MIXED` is recommended unless you have a need for a specific binlog format\. The `binlog_format` parameter is a cluster\-level parameter that is in the default cluster parameter group\. If you are changing the `log_bin` parameter from `OFF` to another value, then you need to reboot your Aurora DB cluster for the change to take effect\. For more information, see [Amazon Aurora DB Cluster and DB Instance Parameters](USER_WorkingWithParamGroups.md#Aurora.Managing.ParameterGroups) and [Working with DB Parameter Groups and DB Cluster Parameter Groups](USER_WorkingWithParamGroups.md)\.   | 
|  RDS MySQL  |  **To enable binary logging on an Amazon RDS DB instance** You cannot enable binary logging directly for an Amazon RDS DB instance, but you can enable it by doing one of the following: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/AmazonRDS/latest/AuroraUserGuide/AuroraMySQL.Replication.MySQL.html)  | 
|  MySQL \(external\)  |  **To set up encrypted replication** To replicate data securely with Aurora MySQL version 5\.6, you can use encrypted replication\. Currently, encrypted replication with an external MySQL database is only supported for Aurora MySQL version 5\.6\.  If you don't need to use encrypted replication, you can skip these steps\.  The following are prerequisites for using encrypted replication: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/AmazonRDS/latest/AuroraUserGuide/AuroraMySQL.Replication.MySQL.html) During encrypted replication, the Aurora MySQL DB cluster acts a client to the MySQL database server\. The certificates and keys for the Aurora MySQL client are in files in \.pem format\. [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/AmazonRDS/latest/AuroraUserGuide/AuroraMySQL.Replication.MySQL.html) **To enable binary logging on an external MySQL database** [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/AmazonRDS/latest/AuroraUserGuide/AuroraMySQL.Replication.MySQL.html)  | 

### 2\. Retain Binary Logs on the Replication Source Until No Longer Needed<a name="AuroraMySQL.Replication.MySQL.RetainBinlogs"></a>

When you use MySQL binlog replication, Amazon RDS doesn't manage the replication process\. As a result, you need to ensure that the binlog files on your replication source are retained until after the changes have been applied to the replica\. This maintenance helps ensure that you can restore your source database in the event of a failure\.

Find instructions on how to retain binary logs for your database engine following\.


| Database Engine | Instructions | 
| --- | --- | 
|  Aurora  |  **To retain binary logs on an Aurora MySQL DB cluster** You do not have access to the binlog files for an Aurora MySQL DB cluster\. As a result, you must choose a time frame to retain the binlog files on your replication source long enough to ensure that the changes have been applied to your replica before the binlog file is deleted by Amazon RDS\. You can retain binlog files on an Aurora MySQL DB cluster for up to 90 days\. If you are setting up replication with a MySQL database or RDS MySQL DB instance as the replica, and the database that you are creating a replica for is very large, choose a large time frame to retain binlog files until the initial copy of the database to the replica is complete and the replica lag has reached 0\. To set the binlog retention time frame, use the [ mysql\_rds\_set\_configuration](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/mysql_rds_set_configuration.html) procedure and specify a configuration parameter of `'binlog retention hours'` along with the number of hours to retain binlog files on the DB cluster, up to 2160 \(90 days\)\. The following example that sets the retention period for binlog files to 6 days: <pre>CALL mysql.rds_set_configuration('binlog retention hours', 144);</pre> After replication has been started, you can verify that changes have been applied to your replica by running the `SHOW SLAVE STATUS` command on your replica and checking the `Seconds behind master` field\. If the `Seconds behind master` field is 0, then there is no replica lag\. When there is no replica lag, reduce the length of time that binlog files are retained by setting the `binlog retention hours` configuration parameter to a smaller time frame\. If you specify a value for `'binlog retention hours'` that is higher than 2160, then 2160 is used\.  | 
|  RDS MySQL  |  **To retain binary logs on an Amazon RDS DB instance** You can retain binlog files on an Amazon RDS DB instance by setting the binlog retention hours just as with an Aurora MySQL DB cluster, described in the previous section\. You can also retain binlog files on an Amazon RDS DB instance by creating a read replica for the DB instance\. This read replica is temporary and solely for the purpose of retaining binlog files\. After the read replica has been created, call the [ mysql\_rds\_stop\_replication](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/mysql_rds_stop_replication.html) procedure on the read replica \(the `mysql.rds_stop_replication` procedure is only available for MySQL versions 5\.5, 5\.6 and later, and 5\.7 and later\)\. While replication is stopped, Amazon RDS doesn't delete any of the binlog files on the replication source\. After you have set up replication with your permanent replica, you can delete the read replica when the replica lag \(`Seconds behind master` field\) between your replication source and your permanent replica reaches 0\.  | 
|  MySQL \(external\)  |  **To retain binary logs on an external MySQL database** Because binlog files on an external MySQL database are not managed by Amazon RDS, they are retained until you delete them\. After replication has been started, you can verify that changes have been applied to your replica by running the `SHOW SLAVE STATUS` command on your replica and checking the `Seconds behind master` field\. If the `Seconds behind master` field is 0, then there is no replica lag\. When there is no replica lag, you can delete old binlog files\.  | 

### 3\. Create a Snapshot of Your Replication Source<a name="AuroraMySQL.Replication.MySQL.CreateSnapshot"></a>

You use a snapshot of your replication source to load a baseline copy of your data onto your replica and then start replicating from that point on\.

Find instructions on how to create a snapshot of your replication source for your database engine following\.


| Database Engine | Instructions | 
| --- | --- | 
|  Aurora  |  **To create a snapshot of an Aurora MySQL DB cluster** [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/AmazonRDS/latest/AuroraUserGuide/AuroraMySQL.Replication.MySQL.html)  | 
|  RDS MySQL  |  **To create a snapshot of an Amazon RDS DB instance** [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/AmazonRDS/latest/AuroraUserGuide/AuroraMySQL.Replication.MySQL.html)  | 
|  MySQL \(external\)  |  **To create a snapshot of an external MySQL database** [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/AmazonRDS/latest/AuroraUserGuide/AuroraMySQL.Replication.MySQL.html)  | 

### 4\. Load the Snapshot into Your Replica Target<a name="AuroraMySQL.Replication.MySQL.LoadSnapshot"></a>

If you plan to load data from a dump of a MySQL database that is external to Amazon RDS, then you might want to create an EC2 instance to copy the dump files to, and then load the data into your DB cluster or DB instance from that EC2 instance\. Using this approach, you can compress the dump file\(s\) before copying them to the EC2 instance in order to reduce the network costs associated with copying data to Amazon RDS\. You can also encrypt the dump file or files to secure the data as it is being transferred across the network\.

Find instructions on how to load the snapshot of your replication source into your replica target for your database engine following\.


| Database Engine | Instructions | 
| --- | --- | 
|  Aurora  |  **To load a snapshot into an Aurora MySQL DB cluster** [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/AmazonRDS/latest/AuroraUserGuide/AuroraMySQL.Replication.MySQL.html)  | 
|  RDS MySQL  |  **To load a snapshot into an Amazon RDS DB instance** [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/AmazonRDS/latest/AuroraUserGuide/AuroraMySQL.Replication.MySQL.html)  | 
|  MySQL \(external\)  |  **To load a snapshot into an external MySQL database** You cannot load a DB snapshot or a DB cluster snapshot into an external MySQL database\. Instead, you must use the output from the `mysqldump` command\. [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/AmazonRDS/latest/AuroraUserGuide/AuroraMySQL.Replication.MySQL.html)  | 

### 5\. Enable Replication on Your Replica Target<a name="AuroraMySQL.Replication.MySQL.EnableReplication"></a>

Before you enable replication, we recommend that you take a manual snapshot of the Aurora MySQL DB cluster or RDS MySQL DB instance replica target\. If a problem arises and you need to re\-establish replication with the DB cluster or DB instance replica target, you can restore the DB cluster or DB instance from this snapshot instead of having to import the data into your replica target again\.

Also, create a user ID that is used solely for replication\. The following is an example\.

```
mysql> CREATE USER 'repl_user'@'<domain_name>' IDENTIFIED BY '<password>';
```

The user requires the `REPLICATION CLIENT` and `REPLICATION SLAVE` privileges\. Grant these privileges to the user\.

```
GRANT REPLICATION CLIENT, REPLICATION SLAVE ON *.* TO 'repl_user'@'<domain_name>';
```

If you need to use encrypted replication, require SSL connections for the replication user\. For example, you can use one of the following statement to require SSL connections on the user account `repl_user`\.

```
GRANT USAGE ON *.* TO 'repl_user'@'<domain_name>' REQUIRE SSL;            
```

**Note**  
If `REQUIRE SSL` isn't included, the replication connection might silently fall back to an unencrypted connection\.

Find instructions on how to enable replication for your database engine following\.


| Database Engine | Instructions | 
| --- | --- | 
|  Aurora  |  **To enable replication from an Aurora MySQL DB cluster** [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/AmazonRDS/latest/AuroraUserGuide/AuroraMySQL.Replication.MySQL.html)  | 
|  RDS MySQL  |  **To enable replication from an Amazon RDS DB instance** [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/AmazonRDS/latest/AuroraUserGuide/AuroraMySQL.Replication.MySQL.html)  | 
|  MySQL \(external\)  |  **To enable replication from an external MySQL database** [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/AmazonRDS/latest/AuroraUserGuide/AuroraMySQL.Replication.MySQL.html)  | 

### 6\. Monitor Your Replica<a name="AuroraMySQL.Replication.MySQL.Monitor"></a>

When you set up MySQL replication with an Aurora MySQL DB cluster, you must monitor failover events for the Aurora MySQL DB cluster when it is the replica target\. If a failover occurs, then the DB cluster that is your replica target might be recreated on a new host with a different network address\. For information on how to monitor failover events, see [Using Amazon RDS Event Notification](USER_Events.md)\. 

You can also monitor how far the replica target is behind the replication source by connecting to the replica target and running the `SHOW SLAVE STATUS` command\. In the command output, the `Seconds Behind Master` field tells you how far the replica target is behind the source\.

## Stopping Replication Between Aurora and MySQL or Between Aurora and Another Aurora DB Cluster<a name="AuroraMySQL.Replication.MySQL.Stopping"></a>

To stop binlog replication with a MySQL DB instance, external MySQL database, or another Aurora DB cluster, follow these steps, discussed in detail following in this topic\.

[1\. Stop Binlog Replication on the Replica Target](#AuroraMySQL.Replication.MySQL.Stopping.StopReplication)

[2\. Disable Binary Logging on the Replication Source](#AuroraMySQL.Replication.MySQL.Stopping.DisableBinaryLogging)

### 1\. Stop Binlog Replication on the Replica Target<a name="AuroraMySQL.Replication.MySQL.Stopping.StopReplication"></a>

Find instructions on how to stop binlog replication for your database engine following\.


| Database Engine | Instructions | 
| --- | --- | 
|  Aurora  |  **To stop binlog replication on an Aurora MySQL DB cluster replica target** Connect to the Aurora DB cluster that is the replica target, and call the [ mysql\_rds\_stop\_replication](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/mysql_rds_stop_replication.html) procedure\. The `mysql.rds_stop_replication` procedure is only available for MySQL versions 5\.5 and later, 5\.6 and later, and 5\.7 and later\.  | 
|  RDS MySQL  |  **To stop binlog replication on an Amazon RDS DB instance** Connect to the RDS DB instance that is the replica target and call the [ mysql\_rds\_stop\_replication](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/mysql_rds_stop_replication.html) procedure\. The `mysql.rds_stop_replication` procedure is only available for MySQL versions 5\.5 and later, 5\.6 and later, and 5\.7 and later\.  | 
|  MySQL \(external\)  |  **To stop binlog replication on an external MySQL database** Connect to the MySQL database and call the `STOP REPLICATION` command\.  | 

### 2\. Disable Binary Logging on the Replication Source<a name="AuroraMySQL.Replication.MySQL.Stopping.DisableBinaryLogging"></a>

Find instructions on how to disable binary logging on the replication source for your database engine following\.


| Database Engine | Instructions | 
| --- | --- | 
|  Aurora  |  **To disable binary logging on an Amazon Aurora DB cluster** [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/AmazonRDS/latest/AuroraUserGuide/AuroraMySQL.Replication.MySQL.html)  | 
|  RDS MySQL  |  **To disable binary logging on an Amazon RDS DB instance** You cannot disable binary logging directly for an Amazon RDS DB instance, but you can disable it by doing the following: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/AmazonRDS/latest/AuroraUserGuide/AuroraMySQL.Replication.MySQL.html)  | 
|  MySQL \(external\)  |  **To disable binary logging on an external MySQL database** Connect to the MySQL database and call the `STOP REPLICATION` command\. [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/AmazonRDS/latest/AuroraUserGuide/AuroraMySQL.Replication.MySQL.html)  | 