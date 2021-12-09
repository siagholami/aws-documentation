--------

--------

# Data sources<a name="hiw-data-source"></a>

A *data source* is a location, such as an Amazon Simple Storage Service \(Amazon S3\) bucket, where you store the documents for indexing\. Data sources can be automatically synchronized with an Amazon Kendra index so that new, updated, or deleted documents in the source repositories are included in searches\. Supported data sources are:
+ Amazon S3 buckets
+ Amazon RDS for MySQL and Amazon RDS for PostgreSQL databases
+ Microsoft OneDrive for Business
+ Microsoft SharePoint Online
+ Salesforce sites
+ ServiceNow instances

Supported document formats are: plain text, Microsoft Word, Microsoft PowerPoint, HTML, and PDF\. For more information, see [Types of documents](index-document-types.md)\. 

**Note**  
To create an index, you don't need a data source\. You can add documents directly to an index\. For more information, see [Adding documents directly to an index](in-adding-documents.md)\.

**To index documents using a data source\.**

1. [Create an index](create-index.md)\.

1. [Create a data source](data-source.md)\.

 For a walkthrough with the Amazon Kendra console or with the AWS CLI, see [Getting started](getting-started.md)\. 