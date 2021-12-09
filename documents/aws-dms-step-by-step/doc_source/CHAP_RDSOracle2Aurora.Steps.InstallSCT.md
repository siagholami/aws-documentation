# Step 2: Install the SQL Tools and AWS Schema Conversion Tool on Your Local Computer<a name="CHAP_RDSOracle2Aurora.Steps.InstallSCT"></a>

Next, you need to install a SQL client and the AWS Schema Conversion Tool \(AWS SCT\) on your local computer\. 

This walkthrough assumes you will use the SQL Workbench/J client to connect to the RDS instances for migration validation\. A few other software tools you might want to consider are the following:
+ [JACK DB](http://www.jackdb.com), an online web interface to work with RDS databases \(Oracle and Aurora MySQL\) over JDBC
+ [DBVisualizer](https://www.dbvis.com/download/)
+ [Oracle SQL Developer](https://www.oracle.com/technetwork/developer-tools/sql-developer/overview/index-097090.html)

**To install the SQL client software**

1. Download SQL Workbench/J from [the SQL Workbench/J website](http://www.sql-workbench.net/downloads.html), and then install it on your local computer\. This SQL client is free, open\-source, and DBMS\-independent\.

1. Download the Oracle Database 12\.1\.0\.2 JDBC driver \([ojdbc7\.jar](https://dms-sbs.s3.amazonaws.com/ojdbc7.jar)\)\.

1. Download the MySQL driver \([ mysql\-connector\-java\-5\.1\.39\-bin\.jar](https://dms-sbs.s3.amazonaws.com/mysql-connector-java-5.1.39-bin.jar)\)\.

1. Using SQL Workbench/J, configure JDBC drivers for Oracle and Aurora MySQL to set up connectivity, as described following\.

   1. In SQL Workbench/J, choose **File**, then choose **Manage Drivers**\.

   1. From the list of drivers, choose **Oracle**\.

   1. Choose the Open icon, then choose the **ojdbc\.jar** file that you downloaded in the previous step\. Choose **OK**\.  
![\[AWS Database Migration Service driver management\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2aurora7.png)

   1. From the list of drivers, choose MySQL\.

   1. Choose the Open icon, then choose the MySQL JDBC driver that you downloaded in the previous step\. Choose **OK**\.  
![\[AWS Database Migration Service driver management\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2aurora8.png)

Next, install the AWS Schema Migration Tool and the required JDBC drivers\.

**To install the AWS Schema Migration Tool and JDBC drivers**

1. Download the AWS Schema Conversion Tool from [Installing and Updating the AWS Schema Conversion Tool](http://docs.aws.amazon.com/SchemaConversionTool/latest/userguide/CHAP_SchemaConversionTool.Installing.html) in the *AWS Schema Conversion Tool User Guide\.* By default, the tool is installed in the "C:\\Program Files\\AWS Schema Conversion Tool\\AWS directory\.

1. Launch the AWS Schema Conversion Tool\.

1. In the AWS Schema Conversion Tool, choose **Global Settings** from **Settings**\.

1. In **Global Settings**, choose **Driver**, and then choose **Browse** for **Oracle Driver Path**\. Locate the JDBC Oracle driver and choose **OK**\. Next, choose **Browse** for **MySql Driver Path**\. Locate the JDBC MySQL driver and choose **OK**\. Choose **OK** to close the dialog box\.  
![\[Connecting to the Oracle DB instance for AWS Database Migration Service\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2aurora8.5.png)