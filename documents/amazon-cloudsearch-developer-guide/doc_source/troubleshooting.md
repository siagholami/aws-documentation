# Troubleshooting Amazon CloudSearch<a name="troubleshooting"></a>

The following topics describe solutions to problems you might encounter when using Amazon CloudSearch\.

**Topics**
+ [Uploading Documents](#ts.uploaddocs)
+ [Deleting All Documents in an Amazon CloudSearch Domain](#ts.cleardomain)
+ [Amazon CloudSearch Domain Not Scaling Down After Deleting Documents](#ts.notscalingdown)
+ [Document Update Latency](#ts.slowupdates)
+ [Large Number of 5xx Errors When Uploading Documents to an Amazon CloudSearch Domain](#troubleshooting-upload-timeouts)
+ [Search Latency and Timeouts in Amazon CloudSearch](#ts.searchfailures)
+ [Search Latency for Faceted Queries in Amazon CloudSearch](#ts.slow-facet-searches)
+ [Sudden Increase in 5xx Errors When Searching an Amazon CloudSearch Domain](#troubleshooting-increased-errors)
+ [Indexing Failures after Updating Indexing Options in Amazon CloudSearch](#ts.indexingfailures)
+ [Domain Not Found When Submitting Amazon CloudSearch Requests](#troubleshooting-domain-not-found)
+ [Number of Searchable Documents Not Returned with Domain Information](#troubleshooting-searchable-documents)
+ [Configuration Service Access Policies Not Working in Amazon CloudSearch](#troubleshooting-configuration-access-policies)
+ [Search and Document Service Access Policies Not Working in Amazon CloudSearch](#troubleshooting-search-doc-access-policies)
+ [Amazon CloudSearch Console Permissions Errors](#troubleshooting-console-access)
+ [Using Wildcards to Search Text Fields Doesn't Produce Expected Results](#ts.wildcardsearchresults)
+ [Inconsistent Results When Using Cursors for Deep Paging](#ts.deeppaging)
+ [Certificate Errors When Using an SDK](#troubleshooting-certificates)

## Uploading Documents<a name="ts.uploaddocs"></a>

If your document data is not formatted correctly or contains invalid values, you will get errors when you attempt to upload it or use it to configure fields for your domain\. Here are some common problems and their solutions:
+ **Invalid JSON**—if you are using JSON, the first thing to do is make sure there are no JSON syntax errors in your document batch\. To do that, run it through a validation tool such as the [JSON Validator](http://jsonlint.com)\. This will identify any fundamental issues with the data\.
+ **Invalid XML**—document batches must be well\-formed XML\. You are especially likely to encounter issues if your fields contain XML data—the data must be XML\-encoded or enclosed in CDATA sections\. To identify any problems, run your document batch through a validation tool such as the [W3C Markup Validation Service](http://validator.w3.org/)\.
+ **Not Recognized as a Document Batch**—if Amazon CloudSearch doesn’t recognize your data as a valid document batch when you upload data using the console, Amazon CloudSearch generates a valid batch that contains a single content field and generic metadata fields such as `content_encoding`, `content_type`, and `resourcename`\. Since these are not normally the fields configured for the domain, you get errors stating that the fields don't exist\. Similarly, if you attempt to configure a domain from an invalid batch, Amazon CloudSearch responds with the content and meta\-data fields instead of the fields in the batch\.

   First, make sure that the batch is valid XML or JSON\. If it is, check for invalid document IDs and make sure you have specified the operation type for each document\. For add operations, make sure that the type, ID, and at least one field are specified for each document\. Delete operations only need to specify the type and ID\. For more information about formatting your data, see [Creating Document Batches](preparing-data.md#creating-document-batches)\. 
+ **Document IDs with bad values**—A document ID can contain any letter or number and the following characters: \_ \- = \# ; : / ? @ &\. Document IDs must be at least 1 and no more than 128 characters long\.
+ **Multi\-valued fields without a value**—when specifying document data in JSON, you cannot specify an empty array as the value of a field\. Multi\-valued fields must contain at least one value\. 
+ **Bad characters**—one problem that can be difficult to detect if you do not filter your data while generating your document batch is that can contain characters that are invalid in XML\. Both JSON and XML batches can contain only UTF\-8 characters that are valid in XML\. You can use a validation tool such as the [JSON Validator](http://jsonlint.com) or [W3C Markup Validation Service](http://validator.w3.org/) to identify invalid characters\.

## Deleting All Documents in an Amazon CloudSearch Domain<a name="ts.cleardomain"></a>

Amazon CloudSearch currently does not provide a mechanism for deleting all of the documents in a domain\. 

## Amazon CloudSearch Domain Not Scaling Down After Deleting Documents<a name="ts.notscalingdown"></a>

If your domain has scaled up to accommodate your index size and you delete a large number of documents, the domain scales down the next time the full index is rebuilt\. Although the index is automatically rebuilt periodically, to scale down as quickly as possible you can explicitly [run indexing](indexing.md) when you are done deleting documents\. 

## Document Update Latency<a name="ts.slowupdates"></a>

Sending a large volume of single\-document batches can increase the amount of time it takes each document to become searchable\. If you have a large amount of update traffic, you need to batch your updates\. We recommend using a batch size close to the 5 MB limit\. For more information, see [Creating Document Batches](preparing-data.md#creating-document-batches)\.

You can load up to 10,000 document batches per day \(every 24 hours\), with each batch size up to 5 MB\. Loading more data per day significantly increases the latency of document updates\. To mitigate this risk, you can increase your update capacity by selecting a larger instance type\. For more information, see [Configuring Scaling Options in Amazon CloudSearch](configuring-scaling-options.md)\. 

## Large Number of 5xx Errors When Uploading Documents to an Amazon CloudSearch Domain<a name="troubleshooting-upload-timeouts"></a>

If you parallelize uploads and your domain is on a search\.m1\.small instance, you might experience an unacceptably high rate of 504 or 507 errors\. Setting the desired instance type to a larger instance type will increase your update capacity and reduce the error rate\. For more information about handling 5xx errors, see [Handling Errors](error-handling.md)\. For information about prescaling your domain to increase upload capacity, see [Configuring Scaling Options in Amazon CloudSearch](configuring-scaling-options.md)\. 

## Search Latency and Timeouts in Amazon CloudSearch<a name="ts.searchfailures"></a>

If you are experiencing slow response times, frequently encountering internal server errors \(typically 507 or 509 errors\), or seeing the number of instance hours your search domain is consuming increase without a substantial increase in the volume of data you're searching, fine\-tuning your search requests to reduce the processing overhead can help\. For more information, see [Tuning Search Request Performance in Amazon CloudSearch](tuning-search.md)\. Increasing the desired replication count can also speed up search request processing\. For more information, see [Configuring Scaling Options in Amazon CloudSearch](configuring-scaling-options.md)\.

507 and 509 errors typically indicate that your search service is overloaded\. This can be due to the volume or complexity of search requests that you are submitting\. Amazon CloudSearch normally scales automatically to handle the load\. Because it takes some time to deploy additional search instances, we recommend using an exponential backoff retry policy to temporarily reduce the request rate and minimize request failures\. For more information, see [Error Retries and Exponential Backoff](https://docs.aws.amazon.com/general/latest/gr/api-retries.html)\.

Certain usage patterns, such as submitting complex search queries to a single small search instance, can sometimes result in timeouts without triggering automatic scaling\. If you repeatedly experience a high error rate, you can explicitly request additional capacity through the Amazon CloudSearch [Service Limit Request](https://console.aws.amazon.com/support/home#/case/create?issueType=service-limit-increase&limitType=service-code-cloudsearch-partitions-and-instances) form\.

## Search Latency for Faceted Queries in Amazon CloudSearch<a name="ts.slow-facet-searches"></a>

If you are bucketing facet information with the `buckets` option and experiencing slow query performance, try setting the buckets method to `interval`\. For more information, see [Bucketing Facet Information](faceting.md#bucketing-facets)\.

## Sudden Increase in 5xx Errors When Searching an Amazon CloudSearch Domain<a name="troubleshooting-increased-errors"></a>

If your search domain experiences a sudden spike in traffic, Amazon CloudSearch responds by adding search instances to your domain to handle the increased load\. However, it takes a few minutes to set up the new instances\. You are likely to see a temporary increase in 5xx errors until the new instances are ready to start processing requests\. For more information about handling 5xx errors, see [Handling Errors](error-handling.md)\. For information about pre\-scaling your domain to handle an expected spike in search requests, see [Configuring Scaling Options in Amazon CloudSearch](configuring-scaling-options.md)\. 

## Indexing Failures after Updating Indexing Options in Amazon CloudSearch<a name="ts.indexingfailures"></a>

If you make changes to a domain's index configuration, in certain cases you might encounter Failed to Validate errors when you run indexing\. This means that the index field options you set are not compatible with the documents that are already in your index\. Specifically, you changed the type of an index field, and there are documents in your index that contain data that is incompatible with that type\. For example, this might happen if you change a `literal` field to an `int` field, and some of your documents contain alphanumeric data in that field\. When this happens, Amazon CloudSearch sets the status of ALL fields that were being processed to the `FailedToValidate` state\. Rolling back the incompatible configuration change will enable you to successfully rebuild your index\. If the change is necessary, you must update or remove the incompatible documents from your index to use the new configuration\. If you can't identify the change that caused the error or need assistance identifying the incompatible documents, contact support\. 

## Domain Not Found When Submitting Amazon CloudSearch Requests<a name="troubleshooting-domain-not-found"></a>

You cannot access a 2013\-01\-01 domain with the 2011\-02\-01 command line tools or SDKs\. Similarly, you cannot access a 2011\-02\-01 domain with the 2013\-01\-01 command line tools or SDKs\. Make sure you are specifying the correct API version in your request and using the appropriate command line tools or SDK\. 

## Number of Searchable Documents Not Returned with Domain Information<a name="troubleshooting-searchable-documents"></a>

The `aws cloudsearch describe-domains` and `DescribeDomains` do not return the number of searchable documents in the domain\. To get the number of searchable documents, use the console or submit a `matchall` request to your domain's search endpoint\. 

```
q=matchall&q.parser=structured&size=0
```

## Configuration Service Access Policies Not Working in Amazon CloudSearch<a name="troubleshooting-configuration-access-policies"></a>

If you have both 2011 and 2013 domains, have configured IAM policies for accessing the configuration service, and are getting *not authorized* errors, note that the Amazon CloudSearch ARN is different for the 2011\-02\-01 API and the 2013\-01\-01 API\. To allow users to access both 2011 and 2013 domains, you must allow access to both ARNs in the IAM policy\. For example:

```
{
  "Statement": [
    {
      "Effect": "Allow",
      "Action": [
        "cloudsearch:*",
       ],
      "Resource": "arn:aws:cloudsearch:*",
      "Resource": "arn:aws:cs:*"
    }
  ]
}
```

If your 2011 policy granted access to particular domains or actions, you must include those restrictions in your policy\. Note that the only supported action for 2011 domains is `cloudsearch:*` and you might encounter other errors when attempting to configure resource\-level permissions for domains created with the 2011\-01\-01 API\.

## Search and Document Service Access Policies Not Working in Amazon CloudSearch<a name="troubleshooting-search-doc-access-policies"></a>

If you have configured access policies for you domain's search and document service endpoints, but are getting the error *403 Request forbidden by administrative rules*, it is likely due to one of the following issues\.
+ Make sure the API version and resource name are specified in your requests\. For example, to upload documents with the 2013\-01\-01 API, you must append `/2013-01-01/documents/batch` to your domain's document service endpoint:

  ```
  doc-movies-123456789012.us-east-1.cloudsearch.amazonaws.com/2013-01-01/documents/batch
  ```

  To submit search requests using the 2013\-01\-01 API, you must append `/2013-01-01/search` to your domain's search endpoint:

  ```
  search-movies-123456789012.us-east-1.cloudsearch.amazonaws.com/2013-01-01/search?q=star+wars&return=title
  ```

  To get suggestions using the 2013\-01\-01 API, you must append `/2013-01-01/suggest` to your domain's search endpoint:

  ```
  search-movies-123456789012.us-east-1.cloudsearch.amazonaws.com/2013-01-01/suggest?q=kat&suggester=mysuggester
  ```
+ If you are connecting from an EC2 instance, make sure the access policy specifies your EC2 instance's public IP address\. 
+ If the machine you are connecting from is behind a router, make sure the access policy specifies your public facing IP address\.

For more information, see [Configuring Access for Amazon CloudSearch](configuring-access.md)\. 

## Amazon CloudSearch Console Permissions Errors<a name="troubleshooting-console-access"></a>

To access to the console, you must have permissions for the `DescribeDomains` action\. Access to particular domains and actions might be restricted by to the configured IAM access policies\. In addition, uploading data from an Amazon S3 bucket or DynamoDB table requires access to those services and resources\. For more information about Amazon CloudSearch access policies, see [Configuring Access for Amazon CloudSearch](configuring-access.md)\.

## Using Wildcards to Search Text Fields Doesn't Produce Expected Results<a name="ts.wildcardsearchresults"></a>

When you submit a search request, the text you're searching for undergoes the same text processing so that it can be matched against the terms that appear in the index\. However, no text analysis is performed on the search term when you perform a prefix search\. This means that a search for a prefix that ends in `s` typically won't match the singular version of the term when stemming is enabled\. This can happen for any term that ends in `s`, not just plurals\. For example, if you search the `actor` field in the sample movie data for `Anders`, there are three matching movies\. If you search for `Ander*`, you get those movies as well as several others\. However, if you search for `Anders*` there are no matches\. This is because the term is stored in the index as `ander`, `anders` does not appear in the index\.

 If stemming is preventing your wildcard searches from returning all of the relevant matches, you can suppress stemming for the text field by setting the `AlgorithmicStemming` option to none, or you can map the data to a `literal` field instead of a `text` field\. 

For more information about how Amazon CloudSearch processes text, see [Text Processing in Amazon CloudSearch](text-processing.md)\.

## Inconsistent Results When Using Cursors for Deep Paging<a name="ts.deeppaging"></a>

When you use a cursor to page through a result set that is sorted by document score \(`_score`\), you can get inconsistent results if the index is updated between requests\. This can also occur if your domain's replication count is greater than one, because updates are applied in an eventually consistent manner across the instances in the domain\. If this is an issue, avoid sorting the results by score\. You can either use the `sort` option to sort by a particular field, or use `fq` instead of `q` to specify your search criteria\. \(Document scores are not calculated for filter queries\.\)

## Certificate Errors When Using an SDK<a name="troubleshooting-certificates"></a>

Because AWS SDKs use the CA certificates from your computer, changes to the certificates on the AWS servers can cause connection failures when you attempt to use an SDK\. Error messages vary, but typically contain the following text:

```
SSL3_GET_SERVER_CERTIFICATE:certificate verify failed
```

You can prevent these failures by keeping your computer's CA certificates and operating system up\-to\-date\. If you encounter this issue in a corporate environment and do not manage your own computer, you might need to ask an administrator to assist with the update process\.

The following list shows minimum operating system and Java versions:
+ Microsoft Windows versions that have updates from January 2005 or later installed contain at least one of the required CAs in their trust list\.
+ Mac OS X 10\.4 with Java for Mac OS X 10\.4 Release 5 \(February 2007\), Mac OS X 10\.5 \(October 2007\), and later versions contain at least one of the required CAs in their trust list\.
+ Red Hat Enterprise Linux 5 \(March 2007\), 6, and 7 and CentOS 5, 6, and 7 all contain at least one of the required CAs in their default trusted CA list\.
+ Java 1\.4\.2\_12 \(May 2006\), 5 Update 2 \(March 2005\), and all later versions, including Java 6 \(December 2006\), 7, and 8, contain at least one of the required CAs in their default trusted CA list\.

The three certificate authorities are:
+ Amazon Root CA 1
+ Starfield Services Root Certificate Authority \- G2
+ Starfield Class 2 Certification Authority

Root certificates from the first two authorities are available from [Amazon Trust Services](https://www.amazontrust.com/repository/), but keeping your computer up\-to\-date is the more straightforward solution\. To learn more about ACM\-provided certificates, see [AWS Certificate Manager FAQs](https://aws.amazon.com/certificate-manager/faqs/#certificates)\.

**Note**  
These certificates are not yet required, but are scheduled for deployment to the AWS servers in November 2017\.