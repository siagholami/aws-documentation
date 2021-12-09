# Troubleshooting<a name="CHAP_Oracle2PostgreSQL.Troubleshooting"></a>

The two most common problem areas when working with Oracle as a source and PostgreSQL as a target are: supplemental logging and case sensitivity\.
+ Supplemental logging – With Oracle, in order to replicate change data, supplemental logging must be enabled\. However, if you enable supplemental logging at the database level, it sometimes still needs to be enabled when new tables are created\. The best remedy for this is to allow AWS DMS to enable supplemental logging for you by using the extra connection attribute: 

  ```
  addSupplementalLogging=Y                        
  ```
+ Case sensitivity: Oracle is case\-insensitive \(unless you use quotes around your object names\)\. However, text appears in uppercase\. Thus, AWS DMS defaults to naming your target objects in uppercase\. In most cases, you'll want to use transformations to change schema, table, and column names to lower case\. 

For more tips, see the AWS DMS troubleshooting section in the [AWS DMS User Guide](http://docs.aws.amazon.com/dms/latest/userguide/CHAP_Troubleshooting.html)\.

To troubleshoot issues specific to Oracle, see the Oracle troubleshooting section:

[Troubleshooting Oracle Specific Issues](http://docs.aws.amazon.com/dms/latest/userguide/CHAP_Troubleshooting.html#CHAP_Troubleshooting.Oracle)

To troubleshoot PostgreSQL issues, see the PostgreSQL troubleshooting section:

[Troubleshooting PostgreSQL Specific Issues](http://docs.aws.amazon.com/dms/latest/userguide/CHAP_Troubleshooting.html#CHAP_Troubleshooting.PostgreSQL)