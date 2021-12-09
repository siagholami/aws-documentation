# Step 1: Install the SQL Drivers and AWS Schema Conversion Tool on Your Local Computer<a name="CHAP_RDSOracle2PostgreSQL.Steps.InstallSCT"></a>

Install the SQL drivers and the AWS Schema Conversion Tool \(AWS SCT\) on your local computer\. 

**To install the SQL client software**

1. Download the JDBC driver for your Oracle database release\. For example, the Oracle Database 12\.1\.0\.2 JDBC driver is \([ojdbc7\.jar](https://dms-sbs.s3.amazonaws.com/ojdbc7.jar)\)\.

1. Download the PostgreSQL driver \([postgresql\-42\.1\.4\.jar](https://jdbc.postgresql.org/download/postgresql-42.1.4.jar)\)\.

1. Install AWS SCT and the required JDBC drivers\.

   1. Download AWS SCT from [ Installing and Updating the AWS Schema Conversion Tool](http://docs.aws.amazon.com/SchemaConversionTool/latest/userguide/CHAP_SchemaConversionTool.Installing.html) in the *AWS Schema Conversion Tool User Guide*\.

   1. Launch AWS SCT\.

   1. In AWS SCT, choose **Global Settings** from **Settings**\.

   1. In **Global Settings**, choose **Driver**, and then choose **Browse** for **Oracle Driver Path**\. Locate the JDBC Oracle driver and choose **OK**\.

   1. Choose **Browse** for **PostgreSQL Driver Path**\. Locate the JDBC PostgreSQL driver and choose **OK**\.   
![\[AWS SCT Drivers\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2postgressql.5.png)

   1. Choose **OK** to close the dialog box\.