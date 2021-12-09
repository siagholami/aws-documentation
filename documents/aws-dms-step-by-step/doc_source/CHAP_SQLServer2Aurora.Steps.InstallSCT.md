# Step 1: Install the SQL Drivers and AWS Schema Conversion Tool on Your Local Computer<a name="CHAP_SQLServer2Aurora.Steps.InstallSCT"></a>

First, install the SQL drivers and the AWS Schema Conversion Tool \(AWS SCT\) on your local computer\. 

**To install the SQL client software**

1. Download the [JDBC driver for Microsoft SQL Server](https://www.microsoft.com/en-us/download/details.aspx?displaylang=en&id=11774)\.

1. Download the [JDBC driver for Aurora MySQL](https://dev.mysql.com/downloads/connector/j/)\. Amazon Aurora MySQL uses the MySQL driver\.

1. Install AWS SCT and the required JDBC drivers\.

   1. See [ Installing and Updating the AWS Schema Conversion Tool](http://docs.aws.amazon.com/SchemaConversionTool/latest/userguide/CHAP_SchemaConversionTool.Installing.html) in the *AWS Schema Conversion Tool User Guide*, and choose the appropriate link to download the AWS SCT\.

   1. Start AWS SCT, and choose **Settings**, **Global Settings**\.

   1. In **Global Settings**, choose **Drivers**, and then choose **Browse** for **Microsoft Sql Server Driver Path**\. Locate the JDBC driver for SQL Server, and choose **OK**\. 

   1. Choose **Browse** for **MySql Driver Path**\. Locate the JDBC driver you downloaded for Aurora MySQL, and choose **OK**\.  
![\[Locating JDBC Drivers for AWS SCT\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsqlserver2aurora-drivers.png)

   1. Choose **OK** to close the **Global Settings** dialog box\.