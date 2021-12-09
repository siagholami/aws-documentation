# Migrating an Amazon RDS for Oracle Database to Amazon Redshift<a name="CHAP_RDSOracle2Redshift"></a>

This walkthrough gets you started with heterogeneous database migration from Amazon RDS for Oracle to Amazon Redshift using AWS Database Migration Service \(AWS DMS\) and the AWS Schema Conversion Tool \(AWS SCT\)\. This introductory exercise doesn't cover all scenarios but provides you with a good understanding of the steps involved in such a migration\. 

It is important to understand that AWS DMS and AWS SCT are two different tools and serve different needs\. They don’t interact with each other in the migration process\. At a high level, the steps involved in this migration are the following:

1.  Using the AWS SCT to do the following:
   +  Run the conversion report for Oracle to Amazon Redshift to identify the issues, limitations, and actions required for the schema conversion\.
   +  Generate the schema scripts and apply them on the target before performing the data load by using AWS DMS\. AWS SCT performs the necessary code conversion for objects like procedures and views\.

1. Identify and implement solutions to the issues reported by AWS SCT\. 

1.  Disable foreign keys or any other constraints that might impact the AWS DMS data load\.

1.  AWS DMS loads the data from source to target using the Full Load approach\. Although AWS DMS is capable of creating objects in the target as part of the load, it follows a minimalistic approach to efficiently migrate the data so that it doesn’t copy the entire schema structure from source to target\.

1.  Perform postmigration activities such as creating additional indexes, enabling foreign keys, and making the necessary changes in the application to point to the new database\.

This walkthrough uses a custom AWS CloudFormation template to create RDS DB instances for Oracle and Amazon Redshift\. It then uses a SQL command script to install a sample schema and data onto the RDS Oracle DB instance that you then migrate to Amazon Redshift\.

This walkthrough takes approximately two hours to complete\. Be sure to follow the instructions to delete resources at the end of this walkthrough to avoid additional charges\.

**Topics**
+ [Prerequisites](CHAP_RDSOracle2Redshift.Prerequisites.md)
+ [Migration Architecture](CHAP_RDSOracle2Redshift.Architecture.md)
+ [Step\-by\-Step Migration](CHAP_RDSOracle2Redshift.Steps.md)
+ [Next Steps](CHAP_RDSOracle2Redshift.NextSteps.md)
+ [References](CHAP_RDSOracle2Redshift.References.md)