# Setting Up Amazon Athena Integration<a name="cur-ate-setup"></a>

We strongly recommend that you create both a new Amazon S3 bucket and a new Cost and Usage Reports to use with Athena\. The following setup process removes any Amazon S3 events that your bucket might already have, which can negatively affect any existing event\-based processes that you have for an existing AWS CUR\. Setting up a new report can take up to 8 hours, so we recommend that you plan to do the last two setup steps the following day\.

AWS CUR supports only the parquet compression format for Athena, and automatically overwrites previous reports stored in your Amazon S3 bucket\.

**Important**  
AWS CloudFormation doesn't support cross\-Region resources\. If you plan to use a AWS CloudFormation template, you must create all resources in the same Region\. The Region must support the following services:  
AWS Lambda
Amazon Simple Storage Service
AWS Glue
Amazon Athena

The following are the steps you need to set up Athena\.
+ [Creating a New Amazon S3 Bucket For Your Reports](create-athena-bucket.md)
+ [Creating New Cost and Usage Reports](create-athena-cur.md)
+ [Setting Up Athena Using AWS CloudFormation Templates](use-athena-cf.md)