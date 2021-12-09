# Migrating an Amazon RDS Oracle Database to Amazon Aurora MySQL<a name="CHAP_RDSOracle2Aurora"></a>

This walkthrough gets you started with heterogeneous database migration from Amazon RDS Oracle to Amazon Aurora with MySQL compatibility using AWS Database Migration Service and the AWS Schema Conversion Tool\. This is an introductory exercise so does not cover all scenarios but will provide you with a good understanding of the steps involved in executing such a migration\. 

It is important to understand that AWS DMS and AWS SCT are two different tools and serve different needs\. They don’t interact with each other in the migration process\. At a high level, the steps involved in this migration are:

1.  Using the AWS SCT to:
   +  Run the conversion report for Oracle to Aurora MySQL to identify the issues, limitations, and actions required for the schema conversion\.
   +  Generate the schema scripts and apply them on the target before performing the data load via AWS DMS\. AWS SCT will perform the necessary code conversion for objects like procedures and views\.

1.  Identify and implement solutions to the issues reported by AWS SCT\. For example, an object type like Oracle Sequence that is not supported in the Amazon Aurora MySQL can be handled using the auto\_increment option to populate surrogate keys or develop logic for sequences at the application layer\. 

1.  Disable foreign keys or any other constraints which may impact the AWS DMS data load\.

1.  AWS DMS loads the data from source to target using the Full Load approach\. Although AWS DMS is capable of creating objects in the target as part of the load, it follows a minimalistic approach to efficiently migrate the data so it doesn’t copy the entire schema structure from source to target\.

1.  Perform post\-migration activities such as creating additional indexes, enabling foreign keys, and making the necessary changes in the application to point to the new database\.

This walkthrough uses a custom AWS CloudFormation template to create an Amazon RDS DB instances for Oracle and Amazon Aurora MySQL\. It then uses a SQL command script to install a sample schema and data onto the Amazon RDS Oracle DB instance that you then migrate to Amazon Aurora MySQL\.

This walkthrough takes approximately two hours to complete\. The estimated cost to complete it, using AWS resources, is about $5\.00\. Be sure to follow the instructions to delete resources at the end of this walkthrough to avoid additional charges\.

**Topics**
+ [Costs](#CHAP_RDSOracle2Aurora.Costs)
+ [Prerequisites](CHAP_RDSOracle2Aurora.Prerequisites.md)
+ [Migration Architecture](CHAP_RDSOracle2Aurora.Architecture.md)
+ [Step\-by\-Step Migration](CHAP_RDSOracle2Aurora.Steps.md)
+ [Next Steps](CHAP_RDSOracle2Aurora.NextSteps.md)
+ [AWS CloudFormation Template, SQL Scripts, and Other Resources](CHAP_RDSOracle2Aurora.ScriptsTemplates.md)
+ [References](CHAP_RDSOracle2Aurora.References.md)

## Costs<a name="CHAP_RDSOracle2Aurora.Costs"></a>

For this walkthrough, you provision Amazon Relational Database Service \(Amazon RDS\) resources by using AWS CloudFormation and also AWS Database Migration Service \(AWS DMS\) resources\. Provisioning these resources will incur charges to your AWS account by the hour\. The AWS Schema Conversion Tool incurs no cost; it is provided as a part of AWS DMS\.

Although you'll need only a minimum of resources for this walkthrough, some of these resources are not eligible for AWS Free Tier\. At the end of this walkthrough, you'll find a section in which you delete the resources to avoid additional charges\. Delete the resources as soon as you complete the walkthrough\.

To estimate what it will cost to run this walkthrough on AWS, you can use the AWS Simple Monthly Calculator\. However, the AWS DMS service is not incorporated into the calculator yet\. The following table shows both AWS DMS and Amazon RDS Oracle Standard Edition Two pricing\. 


| AWS Service | Instance Type | Storage and I/O | 
| --- | --- | --- | 
| Amazon RDS Oracle DB instance, License Included \(Standard Edition Two\), Single AZ | db\.m3\.medium | Single AZ, 10 GB storage, GP2 | 
| Amazon Aurora MySQL DB instance | db\.r3\.large | Single AZ, 10 GB storage, 1 million I/O | 
| AWS DMS replication instance | t2\.small | 50 GB of storage for keeping replication logs included | 
| AWS DMS data transfer | Free—data transfer between AWS DMS and databases in RDS instances in the same Availability Zone is free |  | 
| Data transfer out | First 1 GB per month free |  | 

Assuming you run this walkthrough for two hours, we estimate the following pricing for AWS resources:
+ Amazon Aurora MySQL \+ 10 GB storage pricing estimated by using the [AWS Simple Monthly Calculator](https://calculator.s3.amazonaws.com/index.html#r=PDX&s=RDS&key=calc-73CBE401-DF5A-42CE-8B96-E9AB5D3765EE) is $1\.78\.
+ Amazon RDS Oracle SE2 \(license included\) \+ 10 GB GP2 storage cost, estimated as per the [pricing site](https://aws.amazon.com/rds/oracle/pricing/) at \($0\.226\) \* 2 hours \+ \($0\.115\) \* 10 GB, is $1\.602\.
+ AWS DMS service cost for the t2\.small instance with 50 GB GP2 storage, estimated as per the [pricing site](https://aws.amazon.com/dms/pricing/) at \($0\.036\) \* 2 hours, is $0\.072\.

Total estimated cost to run this project = $1\.78 \+ $1\.602 \+ $0\.072 = $3\.454—approximately $5\.00\.

This pricing is based on the following assumptions:
+ We assume the total data transfer to the Internet is less than a gigabyte\. The preceding pricing estimate assumes that data transfer and backup charges associated with the RDS and DMS services are within Free Tier limits\.
+ Storage consumed by the Aurora MySQL database is billed in per GB\-month increments, and I/Os consumed are billed in per\-million request increments\.
+ Data transfer between DMS and databases in RDS instances in the same Availability Zone is free\.