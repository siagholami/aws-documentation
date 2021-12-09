# Prerequisites<a name="CHAP_RDSOracle2Redshift.Prerequisites"></a>

The following prerequisites are also required to complete this walkthrough:
+  Familiarity with Amazon RDS, Amazon Redshift, the applicable database technologies, and SQL\. 
+ The custom scripts that include creating the tables to be migrated and SQL queries for confirming the migration, as listed following:
  + [ SQL statements to build the SH schema](https://dms-sbs.s3.amazonaws.com/Oraclesalesstarschema.sql)
  + [ AWS CloudFormation template](https://dms-sbs.s3.amazonaws.com/Oracle_Redshift_For_DMSDemo.template)

   Each step in the walkthrough also contains a link to download the file involved or includes the exact query in the step\.
+ An AWS account with AWS Identity and Access Management \(IAM\) credentials that allow you to launch RDS, AWS Database Migration Service \(AWS DMS\) instances, and Amazon Redshift clusters in your AWS Region\. For information about IAM credentials, see [Creating an IAM User](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/CHAP_SettingUp.html#CHAP_SettingUp.IAM)\.
+ Basic knowledge of the Amazon Virtual Private Cloud \(Amazon VPC\) service and of security groups\. For information about using Amazon VPC with Amazon RDS, see [ Virtual Private Clouds \(VPCs\) and Amazon RDS](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/USER_VPC.html)\. For information about Amazon RDS security groups, see [ Amazon RDS Security Groups](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/Overview.RDSSecurityGroups.html)\. For information about using Amazon Redshift in a VPC, see [Managing Clusters in an Amazon Virtual Private Cloud \(VPC\)](http://docs.aws.amazon.com/redshift/latest/mgmt/managing-clusters-vpc.html)\.
+ An understanding of the supported features and limitations of AWS DMS\. For information about AWS DMS, see [ What Is AWS Database Migration Service? ](https://docs.aws.amazon.com/dms/latest/userguide/Welcome.html)
+ Knowledge of the supported data type conversion options for Oracle and Amazon Redshift\. For information about data types for Oracle as a source, see [ Using an Oracle Database as a Source for AWS Database Migration Service](https://docs.aws.amazon.com/dms/latest/userguide/CHAP_Source.Oracle.html)\. For information about data types for Amazon Redshift as a target, see [Using an Amazon Redshift Database as a Target for AWS Database Migration Service ](https://docs.aws.amazon.com/dms/latest/userguide/CHAP_Target.Redshift.html)\.

For more information about AWS DMS, see [the AWS DMS documentation](https://docs.aws.amazon.com/dms/latest/userguide/CHAP_GettingStarted.html)\.