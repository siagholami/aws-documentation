# Creating Data Sets Using New Data Sources<a name="creating-data-sets-new"></a>

To create a data set from a new data source, you must provide connection information to the data source\.
+ For local text or Excel files, you can simply identify the file location and upload the file\.
+ For Amazon S3, you must provide a manifest identifying the files or buckets that you want to use, and also the import settings for the target files\.
+ For Amazon Athena, all Athena databases associated with your AWS account are returned\. No additional credentials are required\.
+ For Salesforce, you must provide credentials to connect with\.
+ For Amazon Redshift, Amazon RDS, Amazon EC2, or other database data sources, you must provide information about the server and database that host the data, as well as valid credentials for that instance\.

**Topics**
+ [Creating a Data Set Using a Local Text File](create-a-data-set-file.md)
+ [Creating a Data Set Using a Microsoft Excel File](create-a-data-set-excel.md)
+ [Creating a Data Set Using Amazon S3 Files](create-a-data-set-s3.md)
+ [Creating a Data Set Using Amazon Athena Data](create-a-data-set-athena.md)
+ [Creating a Data Set from Salesforce](create-a-data-set-salesforce.md)
+ [Creating Data Sets from New Database Data Sources](creating-database-data-sets.md)