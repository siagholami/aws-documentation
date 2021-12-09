# Manually Setting Up Amazon Athena<a name="cur-ate-manual"></a>

We strongly recommend that you use the AWS CloudFormation template to create your table instead of creating it yourself\. The provided SQL query creates a table that covers only a single month of data, but the AWS CloudFormation template creates a table that can include multiple months and that updates automatically\. For more information on how to set up the AWS CloudFormation template, see [Setting Up Amazon Athena Integration](cur-ate-setup.md)\.

If you choose not to use the AWS CloudFormation template to set up your Athena table, manually follow the steps below\. You need to create a table before you can run SQL queries on your AWS CUR data\. You will need to do this step at least once a month and the table only includes data from the current AWS CUR\.

As part of the table creation process, AWS transforms the AWS CUR column names\. For more information about the transformation process, see [Column Names](cur-ate-run.md#column-transformations)\.
+ [Creating an Athena Table](create-manual-table.md)
+ [Creating a Cost and Usage Reports Status Table](create-manual-cur-table.md)
+ [Uploading Your Report Partitions](upload-report-partitions.md)