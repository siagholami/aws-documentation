# Handling Errors in Amazon CloudSearch<a name="error-handling"></a>

This section provides information about how to handle errors when interacting with Amazon CloudSearch programmatically\. For information about specific error codes returned by the Amazon CloudSearch services, see: 
+ [Search Service Errors](search-api.md#search-service-errors)
+ [documents/batch Status Codes](documents-batch-resource.md#documents-batch-status-codes)
+ [Configuration Service Common Errors](CommonErrors.md)\. For the specific errors that can be returned from a particular action, see the documentation for that [action](API_Operations.md)\.

**Topics**
+ [Error Types in Amazon CloudSearch](#error-handling-types)
+ [Retrying Requests in Amazon CloudSearch](#error-handling-retry)

## Error Types in Amazon CloudSearch<a name="error-handling-types"></a>

The HTTP status codes returned by the Amazon CloudSearch APIs indicate whether the request completed successfully, or if a client or server error occurred while processing the request:
+ 2xx status codes indicate that the client request was processed successfully\.
+ 4xx status codes indicate that there was a problem with the client request\. Common client request errors include providing invalid credentials and omitting required parameters\. When you get a 4xx error, you need to correct the problem and resubmit a properly formed client request\.
+ 5xx status codes indicate that a server error occurred while processing the client request\. Server errors are typically transient and are often the result of server timeouts, throttling, or capacity limitations\. We recommend catching and retrying all 5xx errors\.

An HTTP status code is returned for every request\. In addition, the body of the response provides additional warning and error information\. 

Messages in a `search` response indicate the severity level, the warning or error code, and a description of the problem with the search request\. For a list of the warnings and errors that can be returned by the search service, see [Search Response Properties \(JSON\)](search-api.md#search-response-elements-json) or [Search Response Elements \(XML\)](search-api.md#search-response-elements-xml)\. 

Errors and warnings in a `documents/batch` response provide information about parsing and validation issues encountered while processing the document data\. For more information, see [documents/batch Response \(JSON\)](documents-batch-resource.md#documents-batch-json-response) or [documents/batch Response \(XML\)](documents-batch-xml.md#documents-batch-xml-response)\. 

Errors returned in a configuration service response provide information about what caused the request to return a 4xx or 5xx status code\. For information about the common errors that all actions use, see [Common Errors](CommonErrors.md)\. Action\-specific errors are listed in the action topics in the [Configuration API Reference for Amazon CloudSearch ](configuration-api.md)\. 

## Retrying Requests in Amazon CloudSearch<a name="error-handling-retry"></a>

For your application to run smoothly, you need to build in logic to catch and respond to errors\. One typical approach is to implement your request within a try block or if\-then statement\.

We recommend catching and retrying all server errors \(5xx\)\. Because errors can be generated from anywhere within the request pipeline, you should implement a fallback for unexpected 5xx errors in addition to any special handling for specific status codes\. 

507 and 509 errors typically indicate that your search service is overloaded\. This can be due to the volume or complexity of search requests that you are submitting\. Amazon CloudSearch normally scales automatically to handle the load\. Because it takes some time to deploy additional search instances, we recommend using an exponential backoff retry policy to temporarily reduce the request rate and minimize request failures\. For more information, see [Error Retries and Exponential Backoff](https://docs.aws.amazon.com/general/latest/gr/api-retries.html)\.

Certain usage patterns, such as submitting complex search queries to a single small search instance, can sometimes result in timeouts without triggering automatic scaling\. If you repeatedly experience a high error rate, you can explicitly request additional capacity through the Amazon CloudSearch [Service Limit Request](https://console.aws.amazon.com/support/home#/case/create?issueType=service-limit-increase&limitType=service-code-cloudsearch-partitions-and-instances) form\.

Client errors \(4xx\) typically indicate that you need to revise the request to correct the problem—simply retrying the same request will most likely result in the same error\. 409 errors returned by the configuration service can indicate that the request was rejected because a resource limit has been reached\. For more information, see [Limits](limits.md)\.