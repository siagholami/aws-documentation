# Creating an On\-Premises DB Instance<a name="creating-an-on-premises-db-instance"></a>

The basic building block of Amazon RDS is the DB instance\. The DB instance is where you create your on\-premises databases\. 

Before you can create on\-premises DB instances, you must complete the following prerequisites:
+ Set up your AWS account\. For instructions, see [Setting Up Amazon RDS on VMware](setting-up-rds-on-vmware.md)\.
+ Create at least one custom Availability Zone \(custom AZ\), and register the custom AZ with the vSphere cluster\. For instructions, see [Getting Started with Amazon RDS on VMware](getting-started-with-rds-on-vmware.md)\.

  If the status of the custom AZ in which you want to create a DB instance is **Disconnected**, see [Custom AZ Is Disconnected](troubleshooting-rds-on-vmware.md#troubleshooting-rds-on-vmware.disconnected)\.
+ If you are working with a DB engine that requires an on\-premises customer provided license \(such as Microsoft SQL Server\), install your operating system and database media\. For SQL Server, you must do this before you can create Amazon RDS DB instances\. For instructions, see [Installing the Media for Microsoft SQL Server](installing-media.md)\. Installing media is not required for MySQL or PostgreSQL\.
+ Determine which DB instance class most closely matches your VMware cluster\. For instructions, see [Choosing the On\-Premises DB Instance Class](db-instance-class-on-premises.md)\.

Amazon RDS on VMware supports the following DB engines and versions:
+ Amazon RDS for Microsoft SQL Server 2016 SP2 Enterprise Edition
+ Amazon RDS for MySQL version 5\.7
+ Amazon RDS for PostgreSQL version 10\.9\-R1 and 10\.10\-R1

You can create an on\-premises DB instance using the AWS Management Console, the AWS CLI, or the RDS API\.

## Console<a name="creating-an-on-premises-db-instance.console"></a>

**To create an on\-premises DB instance**

1. Sign in to the AWS Management Console and open the Amazon RDS console at [https://console\.aws\.amazon\.com/rds/](https://console.aws.amazon.com/rds/)\.

1. In the top\-right corner of the console, choose the AWS Region that contains the custom AZ in which you want to create the DB instance\. 

1. In the navigation pane, choose **Databases**\. 

1. Choose **Create database**\. 

   The **Create database** page opens\.  
![\[Create database page\]](http://docs.aws.amazon.com/AmazonRDS/latest/RDSonVMwareUserGuide/images/create-on-premises-db-instance.png)

1. In the **Database location** section, choose **On\-premises**\.

1. In the **Availability zone** section, choose **Custom Availability Zone**\.

1. In the **Engine options** section, choose the type of DB engine in **Engine type**, and then, for some DB engines, choose the DB engine version in **Version**\.  
![\[DB engine options\]](http://docs.aws.amazon.com/AmazonRDS/latest/RDSonVMwareUserGuide/images/create-on-premises-db-instance-engine.png)

   If you chose a DB engine that requires an on\-premises customer provided license \(such as Microsoft SQL Server\), you might need to choose the DB engine edition for **Edition**\.  
![\[DB engine edition and version\]](http://docs.aws.amazon.com/AmazonRDS/latest/RDSonVMwareUserGuide/images/create-on-premises-db-edition-version.png)
**Important**  
For DB engines that require an on\-premises customer\-provided license, operating system and database media must be installed in the custom AZ\. Also, the edition and version of the media must match your selections\. If the media is not installed, a warning message appears\. For information about installing media, see [Installing the Media for Microsoft SQL Server](installing-media.md)\.

1. In the **Settings** section, complete the **DB instance identifier**, **Master username**, and **Master password** settings\.

   For more information about settings, see [Settings](#creating-an-on-premises-db-instance.settings)\.

1. In the **DB instance size** section, choose the **DB instance class**\.

1. In the **Connectivity** section, enter the number for the **Database port**\.

1. In the **Additional configuration** section, complete the remaining settings\.

1. Choose **Create database**\. 

## AWS CLI<a name="creating-an-on-premises-db-instance.cli"></a>

To create an on\-premises DB instance by using the AWS CLI, call the [create\-db\-instance](https://docs.aws.amazon.com/cli/latest/reference/rds/create-db-instance.html) command with the options following\. 
+ `--availability-zone` \(Required\)
+ `--db-instance-class` \(Required\)
+ `--db-instance-identifier` \(Required\)
+ `--engine` \(Required\)
+ `--backup-retention-period`
+ `--db-name`
+ `--engine-version`
+ `--master-username`
+ `--master-user-password`
+ `--port`
+ `--preferred-backup-window`

For more information about these options, see [Settings](#creating-an-on-premises-db-instance.settings)\. 

**Example**  
The following example creates an on\-premises PostgreSQL DB instance named `mydbinstance`\.  
For Linux, OS X, or Unix:  

```
1. aws rds create-db-instance \
2.     --db-instance-identifier mydbinstance \
3.     --db-instance-class db.mv11.medium \
4.     --engine postgres \
5.     --availability-zone mycustomaz_identifier \
6.     --master-username masterawsuser \
7.     --master-user-password masteruserpassword
```
For Windows:  

```
1. aws rds create-db-instance ^
2.     --db-instance-identifier mydbinstance ^
3.     --db-instance-class db.mv11.medium ^
4.     --engine postgres ^
5.     --availability-zone mycustomaz_identifier ^
6.     --master-username masterawsuser ^
7.     --master-user-password masteruserpassword
```

Replace the placeholders with appropriate values\. For *mycustomaz\_identifier*, specify the unique identifier for the custom AZ that you want to create the DB instance in\.

## RDS API<a name="creating-an-on-premises-db-instance.api"></a>

To create an on\-premises DB instance by using the Amazon RDS API, call the [CreateDBInstance](https://docs.aws.amazon.com/AmazonRDS/latest/APIReference/API_CreateDBInstance.html) operation with the parameters following\. 

For `AvailabilityZone`, specify the unique identifier for the custom AZ that you want to create the DB instance in\.
+ `AvailabilityZone` \(Required\)
+ `DBInstanceClass` \(Required\)
+ `DBInstanceIdentifier` \(Required\)
+ `Engine` \(Required\)
+ `BackupRetentionPeriod`
+ `DBName`
+ `EngineVersion`
+ `MasterUsername`
+ `MasterUserPassword`
+ `Port`
+ `PreferredBackupWindow`

For more information about these parameters, see [Settings](#creating-an-on-premises-db-instance.settings)\. 

## Settings<a name="creating-an-on-premises-db-instance.settings"></a>

For details about the available settings that you can modify during DB instance creation, see the table following\. 


****  

| Console Setting | CLI Option | RDS API Parameter | Description | 
| --- | --- | --- | --- | 
|  **Backup retention period**  |  `--backup-retention-period`  |  `BackupRetentionPeriod`  |  The number of days that you want automatic backups of your DB instance to be retained\. For any nontrivial DB instance, set this value to 1 or greater\.  Enable the **Enable automatic backups** option to set this value\.  | 
|  **Backup window**  |  `--preferred-backup-window`  |  `PreferredBackupWindow`  |  The time period during which Amazon RDS automatically takes a backup of your DB instance\. Unless you have a specific time that you want to have your database backup, use the default of **No Preference**\.   | 
|  **Custom Availability Zone**  |  `--availability-zone`  |  `AvailabilityZone`  |  The custom AZ for your DB instance\.  For more information, see [Custom Availability Zones](rds-on-vmware-concepts.md#custom-azs)\.   | 
|  **Database name**  |  `--db-name`  |  `DBName`  |  The name for the database on your DB instance\. The requirements for the name vary by DB engine\. If you don't provide a name, Amazon RDS doesn't create a database on the DB instance you are creating\. You can create additional databases after the DB instance is created\.   | 
|  **Database port**  |  `--port`  |  `Port`  |  The port that you want to use to access the DB instance\.   | 
|  **DB instance class**  |  `--db-instance-class`  |  `DBInstanceClass`  |  The DB instance class that you want to use\.  For more information, see [Choosing the On\-Premises DB Instance Class](db-instance-class-on-premises.md)\.   | 
|  **DB instance identifier**  |  `--db-instance-identifier`  |  `DBInstanceIdentifier`  |  The name for your DB instance\. This value is stored as a lowercase string\.   | 
|  **Engine**  |  `--engine`  |  `Engine`  |  The name of the database engine to be used for this instance\. Currently, the following engines are supported:  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/AmazonRDS/latest/RDSonVMwareUserGuide/creating-an-on-premises-db-instance.html)  | 
|  **Master password**  |  `--master-user-password`  |  `MasterUserPassword`  |  The password for your master user\.   | 
|  **Master username**  |  `--master-username`  |  `MasterUsername`  |  The name that you use as the master user name to log on to your DB Instance\.  For more information, including a list of the default privileges for the master user, see [Master User Account Privileges](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/UsingWithRDS.MasterAccounts.html) in the *Amazon RDS User Guide*\.   | 
|  **Version**  |  `--engine-version`  |  `EngineVersion`  |  The version of database engine that you want to use\.  | 