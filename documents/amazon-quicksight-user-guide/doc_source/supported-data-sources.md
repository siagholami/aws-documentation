# Supported Data Sources<a name="supported-data-sources"></a>

Amazon QuickSight supports a variety of data sources that you can use to provide data for analyses\. The following data sources are supported:

## Relational Data Sources<a name="relational-data-sources"></a>

You can use any of the following relational data stores as data sources for Amazon QuickSight:
+ Amazon Athena
+ Amazon Aurora
+ Amazon Redshift
+ Amazon Redshift Spectrum
+ Amazon S3
+ Amazon S3 Analytics
+ Apache Spark 2\.0 or later
+ MariaDB 10\.0 or later
+ Microsoft SQL Server 2012 or later
+ MySQL 5\.1 or later
+ PostgreSQL 9\.3\.1 or later
+ Presto 0\.167 or later
+ Snowflake
+ Teradata 14\.0 or later

**Note**  
You can access additional data sources not listed here by linking or importing them through supported data sources\.

You can retrieve data from tables and materialized views in PostgreSQL instances, and from tables in all other database instances\.

Amazon Redshift clusters, Amazon Athena databases, and Amazon Relational Database Service \(RDS\) instances must be in AWS\. Other database instances must be in one of the following environments to be accessible from Amazon QuickSight:
+ Amazon EC2
+ On your local network
+ In a data center or some other internet\-accessible environment

## File Data Sources<a name="file-data-sources"></a>

You can use files in Amazon S3 or on your local network as data sources for Amazon QuickSight\. Amazon QuickSight supports files in the following formats:
+ *CSV/TSV* – Delimited text files
+ *ELF/CLF* – Extended and common log format files
+ *JSON* – Flat or semi\-structured data files
+ *XLSX* – Microsoft Excel files

Files in Amazon S3 that have been compressed with zip, or gzip \([www\.gzip\.org](http://www.gzip.org)\), can be imported as\-is\. If you used another compression program for files in Amazon S3, or if the files are on your local network, you need to unzip them before importing them\.

### JSON Data Sources<a name="json-data-sources"></a>

Amazon QuickSight natively supports JSON flat files and JSON semi structure data files\.

You can either upload a JSON file or connect to your Amazon S3 bucket that contains JSON data\. Amazon QuickSight automatically performs schema and type inference on JSON files and embedded JSON objects\. Then it flattens the JSON, so you can analyze and visualize application\-generated data\. 

Basic support for JSON flat file data includes the following:
+ Inferring the schema
+ Determining data types
+ Flattening the data
+ Parsing JSON \(JSON embedded objects\) from flat files

Support for JSON file structures \(\.json\) includes the following:
+ JSON records with structures
+ JSON records with root elements as arrays

You can also use the `parseJson` function to extract values from JSON objects in a text file\. For example, if your CSV file has a JSON object embedded in one of the fields, you can extract a value from a specified key value pair \(KVP\)\. For more information on how to do this, see [`parseJson`](parseJson-function.md)\.

The following JSON features aren't supported:
+ Reading JSON with a structure containing a list of records
+ List attributes and list objects within a JSON record are skipped during import
+ Customizing upload or configuration settings
+ parseJSON functions for SQL and analyses
+ Error messaging for invalid JSON
+ Extracting a JSON object from a JSON structure
+ Reading delimited JSON records

You can use the parseJson function to parse flat files during data preparation\. This function extracts elements from valid JSON structures and lists\.

The following JSON values are supported:
+ JSON object
+ String \(double quoted\)
+ Number \(integer and float\)
+ Boolean
+ NULL

## Software as a Service \(SaaS\) Data Sources<a name="service-data-sources"></a>

The following list shows which SaaS data sources are currently supported by Amazon QuickSight\. The ones that aren't labeled "direct connection" use OAuth to connect instead\. For sources using OAuth, the connector takes you to the SaaS site to authorize the connection before letting you create the data source\.

**Note**  
For this to work, the SaaS data source must be accessible to Amazon QuickSight over the network\.
+ Adobe Analytics
+ GitHub
+ JIRA \(direct connection\)
+ Salesforce

  You can use reports or objects in the following editions of Salesforce as data sources for Amazon QuickSight\. Joined reports aren't supported as Amazon QuickSight data sources\.
  + Enterprise Edition
  + Unlimited Edition
  + Developer Edition
+ ServiceNow \(direct connection\)
+ Twitter