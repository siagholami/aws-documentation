# Troubleshooting<a name="CHAP_On-PremOracle2Aurora.Steps.Troubleshooting"></a>

The two most common areas people have issues with when working with Oracle as a source and Aurora MySQL as a target are: supplemental logging and case sensitivity\.
+ Supplemental logging – With Oracle, in order to replication change data supplemental logging must be enabled\. However, if you enable supplemental logging at the database level, it sometimes still need to enable it when creating new tables\. The best remedy for this is to allow DMS to enable supplemental logging for you using the extra connection attribute: 

  ```
  addSupplementalLogging=Y                        
  ```
+ Case sensitivity: Oracle is case\-insensitive \(unless you use quotes around your object names\)\. However, text appears in uppercase\. Thus, AWS DMS defaults to naming your target objects in uppercase\. In most cases, you'll want to use transformations to change schema, table and column names to lower case\. 

For more tips, see the AWS DMS troubleshooting section in the [AWS DMS User Guide](http://docs.aws.amazon.com/dms/latest/userguide/CHAP_Troubleshooting.html)\.

To troubleshoot issues specific to Oracle, see the Oracle troubleshooting section:

[http://docs\.aws\.amazon\.com/dms/latest/userguide/CHAP\_Troubleshooting\.html\#CHAP\_Troubleshooting\.Oracle](http://docs.aws.amazon.com/dms/latest/userguide/CHAP_Troubleshooting.html#CHAP_Troubleshooting.Oracle)

To troubleshoot Aurora MySQL issues, see the MySQL troubleshooting section:

[http://docs\.aws\.amazon\.com/dms/latest/userguide/CHAP\_Troubleshooting\.html\#CHAP\_Troubleshooting\.MySQL](http://docs.aws.amazon.com/dms/latest/userguide/CHAP_Troubleshooting.html#CHAP_Troubleshooting.MySQL)