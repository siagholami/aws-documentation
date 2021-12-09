# What Is Amazon CloudSearch?<a name="what-is-cloudsearch"></a>

Amazon CloudSearch is a fully managed service in the cloud that makes it easy to set up, manage, and scale a search solution for your website or application\.

 With Amazon CloudSearch you can search large collections of data such as web pages, document files, forum posts, or product information\. You can quickly add search capabilities without having to become a search expert or worry about hardware provisioning, setup, and maintenance\. As your volume of data and traffic fluctuates, Amazon CloudSearch scales to meet your needs\. 

**Note**  
This document describes the Amazon CloudSearch 2013\-01\-01 API\. If you have 2011\-02\-01 search domains and need to reference the old documentation, you can download a PDF of the [2011\-02\-01 Developer Guide](https://s3.amazonaws.com/awsdocs/cloudsearch/2011-02-01/cloudsearch-dg-2011-02-01.pdf)\. 

You can use Amazon CloudSearch to index and search both structured data and plain text\. Amazon CloudSearch features:
+ Full text search with language\-specific text processing
+ Boolean search
+ Prefix searches
+ Range searches
+ Term boosting
+ Faceting
+ Highlighting
+ Autocomplete Suggestions

You can get search results in JSON or XML, sort and filter results based on field values, and sort results alphabetically, numerically, or according to custom expressions\. 

 To build a search solution with Amazon CloudSearch, you take the following steps:
+ **Create and configure a search domain\.** A search domain includes your searchable data and the search instances that handle your search requests\. If you have multiple collections of data that you want to make searchable, you can create multiple search domains\.
+ **Upload the data you want to search to your domain\.** Amazon CloudSearch indexes your data and deploys the search index to one or more search instances\. 
+ **Search your domain\.** You send a search request to your domain's search endpoint as an HTTP/HTTPS GET request\. 

**Topics**
+ [Are You New to Amazon CloudSearch?](#new-to-cloudsearch)
+ [How Search Works](how-search-works.md)
+ [Automatic Scaling in Amazon CloudSearch](concepts-scaling.md)
+ [Accessing Amazon CloudSearch](#accessing-cloudsearch)

## Are You New to Amazon CloudSearch?<a name="new-to-cloudsearch"></a>

For a high\-level overview of Amazon CloudSearch, service highlights, and pricing information, see the [Amazon CloudSearch detail page](http://aws.amazon.com/cloudsearch/)\. If you are ready to start using Amazon CloudSearch, you should begin with [Getting Started with Amazon CloudSearch](getting-started.md)\. 

You can interact with Amazon CloudSearch through the AWS Management Console, AWS SDKs, or AWS CLI\. While you can also submit API requests directly to Amazon CloudSearch, the SDKs and AWS CLI automatically sign your requests as needed and provide centralized tools for interacting with Amazon CloudSearch domains in conjunction with other AWS services\. For information about the AWS SDKs, see [Tools for Amazon Web Services](http://aws.amazon.com/tools/)\. For information about installing and using the AWS CLI, see the [AWS Command Line Interface User Guide](https://docs.aws.amazon.com/cli/latest/userguide/)\. 

For more information about configuring and managing your search domains, getting your data into Amazon CloudSearch, submitting search requests, and processing the responses, see: 
+ [Preparing Your Data](preparing-data.md)—how to format your data so you can upload it to an Amazon CloudSearch domain for indexing\.
+ [Configuring Index Fields](configuring-index-fields.md)—how to configure indexing options for an Amazon CloudSearch domain\.
+ [Searching Your Data with Amazon CloudSearch](searching.md)—how to use the Amazon CloudSearch query language\.
+ [Controlling Search Results](controlling-search-results.md)—how to sort, filter, and paginate search results\.

## Accessing Amazon CloudSearch<a name="accessing-cloudsearch"></a>

You can access Amazon CloudSearch through the Amazon CloudSearch console, the AWS SDKs, or the AWS CLI\. 
+ The [Amazon CloudSearch console](https://console.aws.amazon.com/cloudsearch/home?region=us-west-2) enables you to easily create, configure, and monitor your search domains, upload documents, and run test searches\. Using the console is the easiest way to get started with Amazon CloudSearch and provides a central command center for ongoing management of your search domains\. 
+ The [AWS SDKs](http://aws.amazon.com/code) support all of the Amazon CloudSearch API operations, making it easy to manage and interact with your search domains using your preferred technology\. The SDKs automatically sign requests as needed using your AWS credentials\.
+ The [AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/) wraps all of the Amazon CloudSearch API operations to provide a simple way to create and configure search domains, upload the data you want to search, and submit search requests\. The AWS CLI automatically signs requests as needed using your AWS credentials\. 

### Regions and Endpoints for Amazon CloudSearch<a name="endpoints"></a>

 Amazon CloudSearch provides regional endpoints for accessing the configuration service and domain\-specific endpoints for accessing the search and document services\. 

You use the configuration service to create and manage your search domains\. The region\-specific configuration service endpoints are of the form: `cloudsearch.region.amazonaws.com`\. For example, `cloudsearch.us-east-1.amazonaws.com`\. For a current list of supported regions, see [Regions and Endpoints](https://docs.aws.amazon.com/general/latest/gr/rande.html#cloudsearch_region) in the AWS General Reference\.

 To access the Amazon CloudSearch search and document services, you use separate domain\-specific endpoints:
+ `http://doc-domainname-domainid.us-east-1.cloudsearch.amazonaws.com`—a domain's document service endpoint is used to upload documents\.
+ `http://search-domainname-domainid.us-east-1.cloudsearch.amazonaws.com`—a domain's search endpoint is used to submit search requests\.

### Signing Amazon CloudSearch Requests<a name="signing-requests"></a>

If you're using a language for which AWS provides an SDK, we recommend that you use the SDK to submit Amazon CloudSearch requests\. All of the AWS SDKs greatly simplify the process of signing requests and save you a significant amount of time when compared with using the Amazon CloudSearch APIs directly\. The SDKs integrate easily with your development environment and provide easy access to related commands\. You can also use the Amazon CloudSearch console and AWS CLI to submit signed requests with no additional effort\.

If you choose to call the Amazon CloudSearch APIs directly, you must sign your own requests\. Configuration service requests must always be signed\. Upload, search, and suggest requests must be signed unless you configure anonymous access for those services\. To sign a request, you calculate a digital signature using a cryptographic hash function, which returns a hash value based on the input\. The input includes the text of your request and your secret access key\. The hash function returns a hash value that you include in the request as your signature\. The signature is part of the Authorization header of your request\. After receiving your request, Amazon CloudSearch recalculates the signature using the same hash function and input that you used to sign the request\. If the resulting signature matches the signature in the request, Amazon CloudSearch processes the request\. Otherwise, the request is rejected\.

Amazon CloudSearch supports authentication using AWS Signature Version 4\. For more information, see [Signature Version 4 Signing Process](https://docs.aws.amazon.com/general/latest/gr/signature-version-4.html)\.