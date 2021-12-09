# Migrating a MySQL\-Compatible Database to Amazon Aurora MySQL<a name="CHAP_MySQL2Aurora"></a>

If your database supports the InnoDB or MyISAM tablespaces, you have these options for migrating your data to an Amazon Aurora MySQL DB cluster: 
+ You can create a dump of your data using the `mysqldump` utility, and then import that data into an existing Amazon Aurora MySQL DB cluster\. For more information, see [Migrating MySQL to Amazon Aurora MySQL by Using mysqldump](#CHAP_MySQL2Aurora.mysqldump)\.
+ You can copy the source files from your database to an S3 bucket, and then restore an Amazon Aurora MySQL DB cluster from those files\. This option can be considerably faster than migrating data using `mysqldump`\. For more information, see [Migrating Data from an External MySQL Database to an Amazon Aurora MySQL Using Amazon S3](#CHAP_MySQL2Aurora.S3)\.

## Migrating Data from an External MySQL Database to an Amazon Aurora MySQL Using Amazon S3<a name="CHAP_MySQL2Aurora.S3"></a>

You can copy the source files from your source MySQL version 5\.5 or 5\.6 database to an S3 bucket, and then restore an Amazon Aurora MySQL DB cluster from those files\.

This option can be considerably faster than migrating data using `mysqldump`, because using `mysqldump` replays all of the commands to recreate the schema and data from your source database in your new Amazon Aurora MySQL DB cluster\. By copying your source MySQL data files, Amazon Aurora MySQL can immediately use those files as the data for DB cluster\.

**Note**  
Restoring an Amazon Aurora MySQL DB cluster from backup files in an S3 bucket is not supported for the Asia Pacific \(Mumbai\) region\.

Amazon Aurora MySQL does not restore everything from your database\. You should save the database schema and values for the following items from your source MySQL or MariaDB database and add them to your restored Amazon Aurora MySQL DB cluster after it has been created\.
+ User accounts
+ Functions
+ Stored procedures
+ Time zone information\. Time zone information is loaded from the local operating system of your Amazon Aurora MySQL DB cluster\. 

### Prerequisites<a name="CHAP_MySQL2Aurora.S3.Prerequisites"></a>

Before you can copy your data to an S3 bucket and restore a DB cluster from those files, you must do the following:
+ Install Percona XtraBackup on your local server\.
+ Permit Amazon Aurora MySQL to access your S3 bucket on your behalf\.

#### Installing Percona XtraBackup<a name="CHAP_MySQL2Aurora.S3.Prerequisites.Percona"></a>

Amazon Aurora MySQL can restore a DB cluster from files that were created using Percona XtraBackup\. You can install Percona XtraBackup from the Percona website at [https://www\.percona\.com/doc/percona\-xtrabackup/2\.4/installation](https://www.percona.com/doc/percona-xtrabackup/2.4/installation)\.

#### Required Permissions<a name="CHAP_MySQL2Aurora.Permissions"></a>

To migrate your MySQL data to an Amazon Aurora MySQL DB cluster, several permissions are required:
+ The user that is requesting that Amazon RDS create a new cluster from an S3 bucket must have permission to list the buckets for your AWS account\. You grant the user this permission using an AWS Identity and Access Management \(IAM\) policy\.
+ Amazon RDS requires permission to act on your behalf to access the S3 bucket where you store the files used to create your Amazon Aurora MySQL DB cluster\. You grant Amazon RDS the required permissions using an IAM service role\. 
+ The user making the request must also have permission to list the IAM roles for your AWS account\.
+ If the user making the request will create the IAM service role, or will request that Amazon RDS create the IAM service role \(by using the console\), then the user must have permission to create an IAM role for your AWS account\.

For example, the following IAM policy grants a user the minimum required permissions to use the console to both list IAM roles, create an IAM role, and list the S3 buckets for your account\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "iam:ListRoles",
                "iam:CreateRole",
                "iam:CreatePolicy",
                "iam:AttachRolePolicy",
                "s3:ListBucket",
                "s3:ListObjects"
            ],
            "Resource": "*"
        }
    ]
}
```

Additionally, for a user to associate an IAM role with an S3 bucket, the IAM user must have the `iam:PassRole` permission for that IAM role\. This permission allows an administrator to restrict which IAM roles a user can associate with S3 buckets\. 

For example, the following IAM policy allows a user to associate the role named `S3Access` with an S3 bucket\.

```
{
   "Version":"2012-10-17",
   "Statement":[
      {
         "Sid":"AllowS3AccessRole",
        "Effect":"Allow",
        "Action":"iam:PassRole",
        "Resource":"arn:aws:iam::123456789012:role/S3Access"
      }
   ]
}
```

#### Creating the IAM Service Role<a name="CHAP_MySQL2Aurora.CreateS3Role"></a>

You can have the Amazon RDS Management Console create a role for you by choosing the **Create a New Role** option \(shown later in this topic\)\. If you select this option and specify a name for the new role, then Amazon RDS will create the IAM service role required for Amazon RDS to access your S3 bucket with the name that you supply\.

As an alternative, you can manually create the role using the following procedure\.

**To create an IAM role for Amazon RDS to access S3**

1. Sign in to the AWS Management Console and open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. In the left navigation pane, choose **Roles**\.

1. Choose **Create New Role**, specify a value for **Role Name** for the new role, and then choose **Next Step**\.

1. Under **AWS Service Roles**, find **Amazon RDS** and choose **Select**\.

1. Do not select a policy to attach in the **Attach Policy** step\. Instead, choose **Next Step**\.

1. Review your role information, and then choose **Create Role**\.

1. In the list of roles, choose the name of your newly created role\. Choose the **Permissions** tab\.

1. Choose **Inline Policies**\. Because your new role has no policy attached, you will be prompted to create one\. Click the link to create a new policy\.

1. On the **Set Permissions** page, choose **Custom Policy** and then choose **Select**\.

1. Type a **Policy Name** such as `S3-bucket-policy`\. Add the following code for **Policy Document**, replacing *<bucket name>* with the name of the S3 bucket that you are allowing access to\.

   As part of the policy document, you can also include a file name prefix\. If you specify a prefix, then Amazon Aurora MySQL will create the DB cluster using the files in the S3 bucket that begin with the specified prefix\. If you don't specify a prefix, then Amazon Aurora MySQL will create the DB cluster using all of the files in the S3 bucket\.

   To specify a prefix, replace *<prefix>* following with the prefix of your file names\. Include the asterisk \(\*\) after the prefix\. If you don't want to specify a prefix, specify only an asterisk\.

   ```
   {
       "Version": "2012-10-17",
       "Statement": [
           {
               "Effect": "Allow",
               "Action": [
                   "s3:ListBucket",
                   "s3:GetBucketLocation"
               ],
               "Resource": [
                   "arn:aws:s3:::<bucket name>"
               ]
           },
           {
               "Effect": "Allow",
               "Action": [
                   "s3:GetObject"
               ],
               "Resource": [
                   "arn:aws:s3:::<bucket name>/<prefix>*"
               ]
           }
       ]
   }
   ```

1. Choose **Apply Policy**\.

### Step 1: Backing Up Files to be Restored as a DB Cluster<a name="CHAP_MySQL2Aurora.S3.BackingUp"></a>

To create a backup of your MySQL database files that can be restored from S3 to create an Amazon Aurora MySQL DB cluster, use the Percona Xtrabackup utility \(`innobackupex`\) to back up your database\. 

For example, the following command creates a backup of a MySQL database and stores the files in the `/s3-restore/backup` folder\.

```
innobackupex --user=myuser --password=<password> --no-timestamp /s3-restore/backup
```

If you want to compress your backup into a single file \(which can be split, if needed\), you can use the `--stream` option to save your backup in one of the following formats:
+ Gzip \(\.gz\)
+ tar \(\.tar\)
+ Percona xbstream \(\.xbstream\)

For example, the following command creates a backup of your MySQL database split into multiple Gzip files\. The parameter values shown are for a small test database; for your scenario, you should determine the parameter values needed\.

```
innobackupex --user=myuser --password=<password> --stream=tar \
   /mydata/s3-restore/backup | split -d --bytes=512000 \
   - /mydata/s3-restore/backup3/backup.tar.gz
```

For example, the following command creates a backup of your MySQL database split into multiple tar files\.

```
innobackupex --user=myuser --password=<password> --stream=tar \
   /mydata/s3-restore/backup | split -d --bytes=512000 \
   - /mydata/s3-restore/backup3/backup.tar
```

For example, the following command creates a backup of your MySQL database split into multiple xbstream files\.

```
innobackupex --stream=xbstream  \
   /mydata/s3-restore/backup | split -d --bytes=512000 \
   - /mydata/s3-restore/backup/backup.xbstream
```

S3 limits the size of a file uploaded to a bucket to 5 terabytes \(TB\)\. If the backup data for your database exceeds 5 TB, then you must use the `split` command to split the backup files into multiple files that are each less than 5 TB\.

Amazon Aurora MySQL does not support partial backups created using Percona Xtrabackup\. You cannot use the `--include`, `--tables-file`, or `--databases` options to create a partial backup when you backup the source files for your database\.

For more information, see the [The innobackupex Script](https://www.percona.com/doc/percona-xtrabackup/2.1/innobackupex/innobackupex_script.html)\.

Amazon Aurora MySQL consumes your backup files based on the file name\. Be sure to name your backup files with the appropriate file extension based on the file format—for example, `.xbstream` for files stored using the Percona xbstream format\.

Amazon Aurora MySQL consumes your backup files in alphabetical order as well as natural number order\. Always use the `split` option when you issue the `innobackupex` command to ensure that your backup files are written and named in the proper order\.

### Step 2: Copying Files to an Amazon S3 Bucket<a name="CHAP_MySQL2Aurora.S3.CopyingToS3"></a>

Once you have backed up your MySQL database using the Percona Xtrabackup utility, then you can copy your backup files to an S3 bucket\.

For information on creating and uploading a file to an S3 bucket, see [Getting Started with Amazon Simple Storage Service](http://docs.aws.amazon.com/AmazonS3/latest/gsg/GetStartedWithS3.html) in the *Amazon S3 Getting Started Guide*\.

### Step 3: Restoring an Aurora MySQL DB Cluster from an S3 Bucket<a name="CHAP_MySQL2Aurora.S3.RestoringFromS3"></a>

You can restore your backup files from your Amazon S3 bucket to a create new Amazon Aurora MySQL DB cluster by using the Amazon RDS console\. 

**To restore an Amazon Aurora MySQL DB cluster from files on an S3 bucket**

1. Sign in to the AWS Management Console and open the Amazon RDS console at [https://console\.aws\.amazon\.com/rds/](https://console.aws.amazon.com/rds/)\.

1. In the RDS Dashboard, choose **Restore Aurora MySQL DB Cluster from S3**\.

1. In the **Specify Source Backup Details**, specify the following:    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_MySQL2Aurora.html)

1. Choose **Next Step**\.

1. On the **Specify DB Details** page, specify your DB cluster information\. The following table shows settings for a DB instance\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_MySQL2Aurora.html)

   A typical **Specify DB Details** page looks like the following\.   
![\[Amazon Aurora MySQL Launch DB Instance Wizard DB Instance Details\]](http://docs.aws.amazon.com/dms/latest/sbs/images/AuroraLaunch02.png)

1. Confirm your master password, and then choose **Next**\.

1. On the **Configure Advanced Settings** page, you can customize additional settings for your Aurora MySQL DB cluster\. The following table shows the advanced settings for a DB cluster\.     
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_MySQL2Aurora.html)

   A typical **Configure Advanced Settings** page looks like the following\.   
![\[Amazon Aurora MySQL Launch DB Instance Wizard Configure Advanced Settings\]](http://docs.aws.amazon.com/dms/latest/sbs/images/AuroraLaunch03.png)

1. Choose **Launch DB Instance** to launch your Aurora MySQL DB instance, and then choose **Close** to close the wizard\. 

   On the Amazon RDS console, the new DB instance appears in the list of DB instances\. The DB instance has a status of **creating** until the DB instance is created and ready for use\. When the state changes to **available**, you can connect to the primary instance for your DB cluster\. Depending on the DB instance class and store allocated, it can take several minutes for the new instance to be available\.

   To view the newly created cluster, choose the **Clusters** view in the Amazon RDS console\. For more information, see the [ Amazon RDS documentation ](http://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/Aurora.Viewing.html)\.  
![\[Amazon Aurora MySQL DB Instances List\]](http://docs.aws.amazon.com/dms/latest/sbs/images/AuroraLaunch04.png)

   Note the port and the endpoint of the cluster\. Use the endpoint and port of the cluster in your JDBC and ODBC connection strings for any application that performs write or read operations\.

## Migrating MySQL to Amazon Aurora MySQL by Using mysqldump<a name="CHAP_MySQL2Aurora.mysqldump"></a>

You can create a dump of your data using the `mysqldump` utility, and then import that data into an existing Amazon Aurora MySQL DB cluster\.

Because Amazon Aurora MySQL is a MySQL\-compatible database, you can use the `mysqldump` utility to copy data from your MySQL or MariaDB database to an existing Amazon Aurora MySQL DB cluster\.