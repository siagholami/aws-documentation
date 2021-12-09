# Searching DynamoDB Data with Amazon CloudSearch<a name="searching-dynamodb-data"></a>

You can specify a DynamoDB table as a source when configuring indexing options or uploading data to a search domain through the console or AWS CLI\. This enables you to quickly set up a search domain to experiment with searching data stored in DynamoDB database tables\. 

To keep your search domain in sync with changes to the table, you can send updates to both your table and your search domain, or you can periodically load the entire table into a new search domain\. 

**Topics**
+ [Configuring an Amazon CloudSearch Domain to Search DynamoDB Data](#searching-dynamodb-data.configuring)
+ [Uploading Data to Amazon CloudSearch from DynamoDB](#searching-dynamodb-data.uploading)
+ [Synchronizing a Search Domain with a DynamoDB Table](#searching-dynamodb-data.sync)

## Configuring an Amazon CloudSearch Domain to Search DynamoDB Data<a name="searching-dynamodb-data.configuring"></a>

The easiest way to configure a search domain to search DynamoDB data is to use the Amazon CloudSearch console\. The console's configuration wizard analyzes your table data and suggests indexing options based on the attributes in the table\. You can modify the suggested configuration to control which table attributes are indexed\.

**Note**  
To upload data from DynamoDB, you must have permission to access both the service and the resources you want to upload\. For more information, see [Using IAM to Control Access to DynamoDB Resources](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/UsingIAMWithDDB.html)\.

When you automatically configure a search domain from a DynamoDB table, a maximum of 200 unique attributes can be mapped to index fields\. \(You cannot configure more than 200 fields for a search domain, so you can only upload data from DynamoDB tables with 200 or fewer attributes\.\) When Amazon CloudSearch detects an attribute that has a small number of distinct values, the field is facet enabled in the suggested configuration\. 

**Important**  
When you use a DynamoDB table to configure a domain, the data is not automatically uploaded to the domain for indexing\. You must upload the data for indexing as a separate step after you configure the domain\.

### Configuring a Domain to Search DynamoDB using the Amazon CloudSearch Console<a name="w3aac17c27b9c10"></a>

You can use the Amazon CloudSearch console to analyze data from a DynamoDB table to configure a search domain\. A maximum of 5 MB is read from the table regardless of the table size\. By default, Amazon CloudSearch reads from the beginning of the table\. You can specify a start key to begin reading from a particular item\. 

**To configure a search domain using a DynamoDB table**

1. Sign in to the AWS Management Console and open the Amazon CloudSearch console at [https://console\.aws\.amazon\.com/cloudsearch/home](https://console.aws.amazon.com/cloudsearch/home)\.

1. In the **Navigation** pane, click the name of the domain, and then click the domain's **Indexing Options** link\.

1. At the top of the **Indexing Options** pane, click the **configuration wizard** link\.

1. In the **Choose Source** step, select **Analyze sample item\(s\) from DynamoDB**\.

1. From the **DynamoDB Table** list, select the DynamoDB table that you want to analyze\. 
   + To limit the read capacity units that can be consumed while reading from the table, enter the maximum percentage of read capacity units you want to use\.
   + To start reading from a particular item, specify a **Start Hash Key**\. If the table uses a hash and range type primary key, specify both the hash attribute and the range attribute for the item\. 

1. When you finish specifying the table options, click **Continue**\.

1. In the **Review Configuration** step, review the suggested configuration\. You can edit these fields and add additional fields\. 

1. When you finish, click **Apply Configuration**\.

1. In the **Apply Configuration** step, you can choose to run indexing when you exit the configuration wizard\. If you haven't uploaded data to your domain yet, clear the **Run Indexing Now** checkbox to exit without indexing\. If you are done making configuration changes and are ready to index your data with the new configuration, make sure **Run Indexing Now** is selected\. When you are ready to apply the changes, click **Finish**\.

You can also use a DynamoDB table to configure indexing options when you first create a domain\. In the **Configure Index** step, select **Analyze sample item\(s\) from DynamoDB** and select the table to analyze\.

## Uploading Data to Amazon CloudSearch from DynamoDB<a name="searching-dynamodb-data.uploading"></a>

You can upload DynamoDB data to a search domain through the Amazon CloudSearch console or with the Amazon CloudSearch command line tools\. When you upload data from a DynamoDB table, Amazon CloudSearch converts it to document batches so it can be indexed\. You select define index fields for each of the attributes in your domain configuration\. For more information, see [Configuring an Amazon CloudSearch Domain to Search DynamoDB Data](#searching-dynamodb-data.configuring)\.

You can upload data from more than one DynamoDB table to the same Amazon CloudSearch domain\. However, keep in mind that you can upload a maximum of 200 attributes from all tables combined\. If an item with the same key appears in more than one uploaded table, the last\-applied item overwrites all previous versions\. 

When converting table data to document batches, Amazon CloudSearch generates a document for each item it reads from the table, and represents each item attribute as a document field\. The unique ID for each document is either read from the `docid` item attribute \(if it exists\) or assigned an alphanumeric value based on the primary key\. 

When Amazon CloudSearch generates documents for table items:
+ Sets of strings and sets of numbers are represented as multi\-value fields\. If a DynamoDB set contains more than 100 values, only the first 100 values are added to the multi\-value field\.
+ DynamoDB binary attributes are ignored\.
+ Attribute names are modified to conform to the Amazon CloudSearch naming conventions for field names:
  + All uppercase letters are converted to lowercase\.
  + If the DynamoDB attribute name does not begin with a letter, the field name is prefixed with `f_`\.
  + Any characters other than a\-z, 0\-9, and \_ \(underscore\) are replaced by an underscore\. If this transformation results in a duplicate field name, a number is appended to make the field name unique\. For example, the attribute names `håt`, `h-t`, `hát` would be mapped to `h_t`, `h_t1`, and `h_t2` respectively\.
  + If the DynamoDB attribute name exceeds 64 characters, the first 56 characters of the attribute name are concatenated with the 8\-character MD5 hash of the full attribute name to form the field name\.
  + If the attribute name is `body`, it is mapped to the field name `f_body`\. 
  + If the attribute name is ` _score` it is mapped to the field name ` f_ _score`\.
+ Number attributes are mapped to Amazon CloudSearch int fields and the values are transformed to 32\-bit unsigned integers:
  + If a number attribute contains a decimal value, only the integral part of the value is stored\. Everything to the right of the decimal point is dropped\.
  + If the value is larger than can be stored as an unsigned integer, the value is truncated\. 
  + Negative integers are treated as unsigned positive integers\.

### Uploading DynamoDB Data to a Domain through the Amazon CloudSearch Console<a name="searching-dynamodb-data-console"></a>

You can use the Amazon CloudSearch console to upload up to 5 MB of data from a DynamoDB table to a search domain\.

**To upload DynamoDB data using the console**

1. Sign in to the AWS Management Console and open the Amazon CloudSearch console at [https://console\.aws\.amazon\.com/cloudsearch/home](https://console.aws.amazon.com/cloudsearch/home)\.

1. In the **Navigation** pane, click the name of the domain\.

1. At the top of the domain dashboard, click **Upload Documents**\.

1. In the **Document Source** step, select **Item\(s\) from DynamoDB**\.

1. In the **DynamoDB Table** list, select the DynamoDB table that contains your data\. 
   + To limit the read capacity units that can be consumed while reading from the table, enter the maximum percentage of read capacity units\.
   + To start reading from a particular item, specify a **Start Hash Key**\. If the table uses a hash and range type primary key, specify both the hash attribute and the range attribute for the item\.

1. When you finish specifying the table options, click **Continue**\.

1. In the **Review Documents** step, review the items that will be uploaded\. \(You can also save the generated document batch by clicking **Download the generated document batch**\.\) When you finish, click **Upload Documents**\. 

1. In the **Document Summary** step, click **Finish** to exit the upload documents wizard\.

## Synchronizing a Search Domain with a DynamoDB Table<a name="searching-dynamodb-data.sync"></a>

To keep your search domain in sync with updates to your DynamoDB table, you can either programmatically track and apply updates to your domain, or periodically create a new domain and upload the entire table again\. If you have a large amount of data, it's best to track and apply updates programmatically\. 

### Programmatically Synchronizing Updates<a name="searching-dynamodb-data.sync.programmatically"></a>

To synchronize changes and additions to your DynamoDB table, you can create a separate update table to track the changes to the table you are searching and periodically upload the contents of the update table to the corresponding search domain\. 

To remove documents from the search domain, you must generate and upload document batches that contain a delete operation for each deleted document\. One option is to use a separate DynamoDB table to track deleted items, periodically process the table to generate a batch of delete operations, and upload the batch to your search domain\. 

To make sure that you don't lose any changes that are made during the initial data upload, you must begin collecting tracking changes before the initial data upload\. While you might update some Amazon CloudSearch documents with identical data, you ensure that no changes are lost and your search domain contains an up\-to\-date version of every document\.

How often you synchronize updates depends on the volume of changes and your update latency tolerance\. One approach is to accumulate changes over a fixed time period and at the end of the time period upload the changes and delete the period's tracking tables\.

For example, to synchronize changes and additions once a day, at the beginning of each day you could create a table called updates\_YYYY\_MM\_DD to collect the daily updates\. At the end of the day, you upload the updates\_YYYY\_MM\_DD table to your search domain\. After the upload is complete, you can delete the update table and create a new one for the next day\. 

### Switching to a New Search Domain<a name="searching-dynamodb-data.sync.newtable"></a>

If you don't want to track and apply individual updates to your table, you can periodically load the entire table into a new search domain and then switch your query traffic over to the new domain\. 

**To switch to a new search domain**

1. Create a new search domain and copy the configuration from your existing domain\.

1. Upload the entire DynamoDB table to the new domain\. For more information, see [Uploading Data to Amazon CloudSearch from DynamoDB](#searching-dynamodb-data.uploading)\.

1. After the new domain is active, update the DNS entry that directs query traffic to the old search domain to point to the new domain\. For example, if you use [Amazon Route 53](http://aws.amazon.com/route53/), you can simply update the recordset with your new search service endpoint\.

1. Delete the old domain\.