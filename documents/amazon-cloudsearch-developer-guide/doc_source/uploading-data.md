# Uploading Data to an Amazon CloudSearch Domain<a name="uploading-data"></a>

**Important**  
Before uploading data to an Amazon CloudSearch domain, follow these guidelines:  
Group documents into *batches* before you upload them\. Continuously uploading batches that consist of only one document has a huge, negative impact on the speed at which Amazon CloudSearch can process your updates\. Instead, create batches that are as close to the limit as possible and upload them less frequently\. For more information on maximum batch size and upload frequency, see [Understanding Amazon CloudSearch Limits](limits.md)\.
A domain's document and search endpoints remain the same for the life of the domain\. You should cache the endpoints rather than retrieving them before every upload or search request\. Querying the Amazon CloudSearch configuration service by calling `aws cloudsearch describe-domains` or `DescribeDomains` before every request will likely result in your requests being throttled\.

You create document batches to describe the data that you want to upload to an Amazon CloudSearch domain\. A document batch is a collection of add and delete operations that represent the documents you want to add, update, or delete from your domain\. Batches can be described in either JSON or XML\. When you upload document batches to a domain, the data is indexed automatically according to the domain's indexing options\.

As your data changes, you upload batches to add, change, or delete documents from your index\. Amazon CloudSearch applies updates continuously\. You only have to explicitly reindex your data when you make configuration changes that put your domain in the `NEEDS INDEXING` state or need to update suggesters\. 

**To upload data to your domain, it must be formatted as a valid JSON or XML batch\.** The fields specified in each document must correspond to index fields configured for the domain\. However, a document does not have to contain every configured index field\. For information about creating document batches, see [Preparing Your Data](preparing-data.md)\. For information about configuring index fields for a domain, see [Configuring Index Fields](configuring-index-fields.md)\.

You are billed for the total number of document batches uploaded to your search domain, including batches that contain delete operations\. For more information about Amazon CloudSearch pricing, see [aws\.amazon\.com/cloudsearch/pricing/](http://aws.amazon.com/cloudsearch/pricing/)\.

You can submit a document batch to a domain using the [Amazon CloudSearch console](#uploading-data-console), AWS CLI, or by [posting it directly](#uploading-data-api) to the domain's document service endpoint\.

For more information about the document service API, see the [Document Service API Reference](document-service-api.md)\.

**Topics**
+ [Submitting Document Upload Requests to an Amazon CloudSearch Domain](submitting-doc-requests.md)
+ [Bulk Uploads in Amazon CloudSearch](#bulk-uploads)
+ [Amazon CloudSearch console](#uploading-data-console)
+ [Uploading Data Using the AWS CLI](#uploading-data-clt)
+ [posting it directly](#uploading-data-api)

## Bulk Uploads in Amazon CloudSearch<a name="bulk-uploads"></a>

Document batches are limited to one batch every 10 seconds and 5 MB per batch\. To learn more, see [Limits](limits.md)\. However, you can upload batches in parallel to reduce the amount of time it takes to upload all of your data\.

To perform a bulk upload:
+ Set your desired instance type to a larger instance type than the default `search.m1.small`\. The number of upload threads you can use depends on the type of search instance your domain is using and the nature of your data and indexing options\. Larger instance types have a higher upload capacity\. Attempting to upload batches in parallel to a `search.m1.small` instance usually results in a high rate of 504 or 507 errors\. For more information about setting the desired instance type, see [Configuring Scaling Options in Amazon CloudSearch](configuring-scaling-options.md)\.
+ Start uploading data once your configuration changes are active\. If you encounter a high rate of 5xx errors, you either need to reduce your upload rate or switch to a larger instance type\. If you are already using the largest instance type, you can increase the desired partition count to further increase upload capacity\. 
**Important**  
If you submit a large volume of updates while your domain is in the PROCESSING state, it can increase the amount of time it takes for the updates to be applied to your search index\. To avoid this update lag, wait until your domain is in the ACTIVE state before starting your bulk upload\.
+ When you are finished with your bulk upload, you can change the desired instance type back to a smaller instance type\. If your index fits on a smaller type, Amazon CloudSearch will automatically scale your domain back down\. Amazon CloudSearch will not scale to an instance type that's smaller than the desired instance type configured for your domain\. 

 For datasets of less than 1 GB of data or fewer than one million 1 KB documents, a small search instance should be sufficient\. To upload data sets between 1 GB and 8 GB, we recommend setting the desired instance type to `search.m3.large` before you begin uploading\. For datasets between 8 GB and 16 GB, start with a `search.m3.xlarge`\. For datasets between 16 GB and 32 GB, start with a `search.m3.2xlarge`\. If you have more than 32 GB to upload, select the `search.m3.2xlarge` instance type and increase the desired partition count to accommodate your data set\. Each partition can contain up to 32 GB of data\. Submit a [Service Increase Limit Request](https://console.aws.amazon.com/support/home#/case/create?issueType=service-limit-increase&limitType=service-code-cloudsearch-partitions-and-instances) if you need more upload capacity or have more than 500 GB to index\. 

## Uploading Data Using the Amazon CloudSearch Console<a name="uploading-data-console"></a>

In the Amazon CloudSearch console, you can upload data from your local file system or Amazon S3 to your domain from the domain dashboard\. The console can automatically convert the following types of files to document batches during the upload process: 
+ Document batches formatted in JSON or XML \(\.json, \.xml\)
+ Comma Separated Value \(\.csv\)
+ Text Documents \(\.txt\)

You can also convert and upload items from an DynamoDB table\. For more information, see [Uploading DynamoDB Data](searching-dynamodb-data.md#searching-dynamodb-data-console)\.

**Note**  
To upload data from Amazon S3 or DynamoDB, you must have permission to access both the service and the resources you want to upload\. For more information, see [Using Bucket Policies and User Policies](https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingIAMPolicies.html) and [Using IAM to Control Access to DynamoDB Resources](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/UsingIAMWithDDB.html)\.

CSV files are parsed row\-by\-row and a separate document is generated for each row\. All other types of files are treated as a single document\. For more information about automatically generating document batches, see [Preparing Your Data](preparing-data.md)\.

**Note**  
Uploading data to Amazon CloudSearch from an Amazon S3 bucket or DynamoDB table requires access to those services and resources\.

**To send data to a domain for indexing**

1. Sign in to the AWS Management Console and open the Amazon CloudSearch console at [https://console\.aws\.amazon\.com/cloudsearch/home](https://console.aws.amazon.com/cloudsearch/home)\.

1. In the **Navigation** pane, click the name of the domain\.

1. At the top of the domain dashboard, click **Upload Documents\.**

1. Select the location of the data you want to upload to your domain:
   + File\(s\) on my local disk
   + Object\(s\) from Amazon S3
   + Item\(s\) from DynamoDB
   + Predefined data

   If you upload data that isn't formatted as document batches, it will automatically be converted during the upload process\.
**Note**  
 If a batch is invalid, Amazon CloudSearch converts the content to a valid batch that contains a single content field and generic metadata fields\. Since these are not normally the fields configured for the domain, you will get errors stating that the fields don't exist\.

1. If you are uploading local files, click **Browse** to choose the file\(s\) to upload:

1. If you are uploading objects from Amazon S3, select the bucket you want to upload from\. To upload the entire contents of the bucket, leave the **Prefix** field empty and click **Add**\. To upload selected objects, enter a filter in the **Prefix** field and click **Add**\. \(You can add multiple prefixes\.\) 

1. If you are uploading items from DynamoDB, select the table you want to upload from\. To start reading from a particular item, specify a start key\. To limit the read capacity units that can be consumed while reading from the table, enter the maximum percentage of read capacity units\.

1. If are uploading predefined sample data, choose the data set that you want to use: 

1. Once you've selected the data you want to upload, click **Continue**\.

1. In the **Review Documents** step, review the documents to be uploaded and click **Upload Documents** to continue\.

1. In the **Document Summary** step, if a document batch has been automatically generated from your data, you can click **Download the generated document batch** to get it\. Click **Finish** to return to the domain dashboard\. 

## Uploading Data Using the AWS CLI<a name="uploading-data-clt"></a>

You use the `aws cloudsearch upload-documents` command to send document batches to your search domain\. For information about installing and setting up the AWS CLI, see the [AWS Command Line Interface User Guide](https://docs.aws.amazon.com/cli/latest/userguide/)\. 

**To send document batches to a domain for indexing**
+ Run the `aws cloudsearchdomain upload-documents` command to upload your batches to your domain:

  ```
  aws cloudsearchdomain upload-documents --endpoint-url http://doc-movies-y6gelr4lv3jeu4rvoelunxsl2e.us-east-1.cloudsearch.amazonaws.com --content-type application/json --documents document-batch.json
  {
      "status": "success", 
      "adds": 5000, 
      "deletes": 0
  }
  ```

## Posting Documents to an Amazon CloudSearch Domain's Document Service Endpoint via HTTP<a name="uploading-data-api"></a>

You use the `[documents/batch](documents-batch-resource.md)` resource to post document batches to your domain to add, update, or remove documents\. For example:

```
curl -X POST --upload-file movie-data-2013.json doc-movies-123456789012.us-east-1.cloudsearch.amazonaws.com/2013-01-01/documents/batch --header "Content-Type:application/json"
```