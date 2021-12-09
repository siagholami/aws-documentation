# Creating Read Replicas<a name="read-replica"></a>

Amazon RDS on VMware uses the MySQL and PostgreSQL DB engines' built\-in replication functionality to create a special type of DB instance called a read replica from a source DB instance\. Updates made to the source DB instance are asynchronously copied to the read replica\. You can reduce the load on your source DB instance by routing read queries from your applications to the read replica\. Using read replicas, you can elastically scale out beyond the capacity constraints of a single DB instance for read\-heavy database workloads\.

When you create a read replica, you first specify an existing DB instance as the source\. Then Amazon RDS takes a snapshot of the source instance and creates a read\-only instance from the snapshot\. RDS then uses the asynchronous replication method for the DB engine to update the read replica whenever there is a change to the source DB instance\. The read replica operates as a DB instance that allows only read\-only connections\. Applications connect to a read replica the same way they do to any DB instance\. RDS replicates all databases in the source DB instance\.

For more information on Amazon RDS read replicas, see [Working with Read Replicas](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/USER_ReadRepl.html)\.

## Limitations<a name="read-replica.limitations"></a>

Read replicas on Amazon RDS on VMware have the following limitations:
+ Read replicas are supported only for MySQL and PostgreSQL DB instance types\.
+ RDS on VMware read replicas are supported on PostgreSQL versions 10\.9 and 10\.10, and MySQL version 5\.7\.
+ You can't create a read replica in a different custom Availability Zone \(CAZ\) from the primary DB instance\.
+ Only one read replica per DB instance is supported\.
+ The primary DB instance and the read replica both exist on\-premises\.
+ The read replica has the same compute and storage requirements as the primary DB instance\. Make sure that your installation has enough capacity for both the primary and the replica\.
+ The read replica isn't automatically promoted if the primary DB instance fails\. You must manually promote the read replica\.

## Creating a Read Replica<a name="creating-read-replica"></a>

You can create a read replica from an existing MySQL or PostgreSQL DB instance using the AWS Management Console or AWS CLI\.

### Console<a name="creating-read-replica.console"></a>

**To create a read replica from a source MySQL or PostgreSQL DB instance**

1. Sign in to the AWS Management Console and open the Amazon RDS console at [https://console\.aws\.amazon\.com/rds/](https://console.aws.amazon.com/rds/)\.

1. In the navigation pane, choose **Databases**\.

1. Choose the MySQL or PostgreSQL DB instance that you want to use as the source for a read replica\.

1. For **Actions**, choose **Create read replica**\.

1. Choose the instance specifications that you want to use\. We recommend that you use the same DB instance class and storage type as the source DB instance for the read replica\.

1. For **Avaliability zone**, choose the CAZ where you want to create the read replica\.

1. For **DB instance identifier**, enter a name for the read replica\.

1. Choose the other settings that you want to use\.

1. Choose **Create read replica**\.

### AWS CLI<a name="creating-read-replica.CLI"></a>

To create a read replica from a source MySQL or PostgreSQL DB instance, use the AWS CLI command [https://docs.aws.amazon.com/cli/latest/reference/rds/create-db-instance-read-replica.html](https://docs.aws.amazon.com/cli/latest/reference/rds/create-db-instance-read-replica.html)\.

**Example**  
For Linux, OS X, or Unix:  

```
aws rds create-db-instance-read-replica \
    --db-instance-identifier myreadreplica \
    --source-db-instance-identifier mydbinstance \
    --availability-zone mycaz
```
For Windows:  

```
aws rds create-db-instance-read-replica ^
    --db-instance-identifier myreadreplica ^
    --source-db-instance-identifier mydbinstance ^
    --availability-zone mycaz
```

## Promoting a Read Replica to Be a Standalone DB Instance<a name="USER_ReadRepl.Promote"></a>

You can promote a MySQL or PostgreSQL read replica into a standalone DB instance\. When you promote a read replica, the DB instance is rebooted before it becomes available\.

When you promote a read replica, the new DB instance that is created retains the backup retention period and backup window of the former read replica source\. The promotion process can take several minutes or longer to complete, depending on the size of the read replica\. After you promote the read replica to a new DB instance, it's just like any other DB instance\. For example, you can create read replicas from the new DB instance and perform point\-in\-time restore operations\. Because the promoted DB instance is no longer a read replica, you can't use it as a replication target\.

Backup duration is a function of the number of changes to the database since the previous backup\. If you plan to promote a read replica to a standalone instance, we recommend that you enable backups and complete at least one backup prior to promotion\. In addition, you can't promote a read replica to a standalone instance when it has the `backing-up` status\. If you have enabled backups on your read replica, configure the automated backup window so that daily backups don't interfere with read replica promotion\.

### Console<a name="USER_ReadRepl.Promote.Console"></a>

**To promote a read replica to a DB instance**

1. Sign in to the AWS Management Console and open the Amazon RDS console at [https://console\.aws\.amazon\.com/rds/](https://console.aws.amazon.com/rds/)\.

1. In the Amazon RDS console, choose **Databases**\.

   The **Databases** pane appears\. Each read replica shows **Replica** in the **Role** column\.

1. Choose the read replica that you want to promote\.

1. For **Actions**, choose **Promote read replica**\.

1. On the **Promote Read Replica** page, enter the backup retention period and the backup window for the new promoted DB instance\.

1. When the settings are as you want them, choose **Continue**\.

1. On the acknowledgment page, choose **Promote Read Replica**\.

### AWS CLI<a name="USER_ReadRepl.Promote.CLI"></a>

To promote a read replica to a DB instance, use the AWS CLI [https://docs.aws.amazon.com/cli/latest/reference/rds/promote-read-replica.html](https://docs.aws.amazon.com/cli/latest/reference/rds/promote-read-replica.html) command\.

**Example**  
For Linux, OS X, or Unix:  

```
aws rds promote-read-replica \
    --db-instance-identifier myreadreplica
```
For Windows:  

```
aws rds promote-read-replica ^
    --db-instance-identifier myreadreplica
```