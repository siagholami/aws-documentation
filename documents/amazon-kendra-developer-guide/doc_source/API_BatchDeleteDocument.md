--------

--------

# BatchDeleteDocument<a name="API_BatchDeleteDocument"></a>

Removes one or more documents from an index\. The documents must have been added with the [BatchPutDocument](API_BatchPutDocument.md) operation\.

The documents are deleted asynchronously\. You can see the progress of the deletion by using AWS CloudWatch\. Any error messages releated to the processing of the batch are sent to you CloudWatch log\.

## Request Syntax<a name="API_BatchDeleteDocument_RequestSyntax"></a>

```
{
   "DataSourceSyncJobMetricTarget": { 
      "DataSourceId": "string",
      "DataSourceSyncJobId": "string"
   },
   "DocumentIdList": [ "string" ],
   "IndexId": "string"
}
```

## Request Parameters<a name="API_BatchDeleteDocument_RequestParameters"></a>

For information about the parameters that are common to all actions, see [Common Parameters](CommonParameters.md)\.

The request accepts the following data in JSON format\.

 ** [DataSourceSyncJobMetricTarget](#API_BatchDeleteDocument_RequestSyntax) **   <a name="Kendra-BatchDeleteDocument-request-DataSourceSyncJobMetricTarget"></a>
Maps a particular data source sync job to a particular data source\.  
Type: [DataSourceSyncJobMetricTarget](API_DataSourceSyncJobMetricTarget.md) object  
Required: No

 ** [DocumentIdList](#API_BatchDeleteDocument_RequestSyntax) **   <a name="Kendra-BatchDeleteDocument-request-DocumentIdList"></a>
One or more identifiers for documents to delete from the index\.  
Type: Array of strings  
Array Members: Minimum number of 1 item\. Maximum number of 10 items\.  
Length Constraints: Minimum length of 1\. Maximum length of 2048\.  
Required: Yes

 ** [IndexId](#API_BatchDeleteDocument_RequestSyntax) **   <a name="Kendra-BatchDeleteDocument-request-IndexId"></a>
The identifier of the index that contains the documents to delete\.  
Type: String  
Length Constraints: Fixed length of 36\.  
Pattern: `[a-zA-Z0-9][a-zA-Z0-9-]*`   
Required: Yes

## Response Syntax<a name="API_BatchDeleteDocument_ResponseSyntax"></a>

```
{
   "FailedDocuments": [ 
      { 
         "ErrorCode": "string",
         "ErrorMessage": "string",
         "Id": "string"
      }
   ]
}
```

## Response Elements<a name="API_BatchDeleteDocument_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [FailedDocuments](#API_BatchDeleteDocument_ResponseSyntax) **   <a name="Kendra-BatchDeleteDocument-response-FailedDocuments"></a>
A list of documents that could not be removed from the index\. Each entry contains an error message that indicates why the document couldn't be removed from the index\.  
Type: Array of [BatchDeleteDocumentResponseFailedDocument](API_BatchDeleteDocumentResponseFailedDocument.md) objects

## Errors<a name="API_BatchDeleteDocument_Errors"></a>

For information about the errors that are common to all actions, see [Common Errors](CommonErrors.md)\.

 **AccessDeniedException**   
HTTP Status Code: 400

 **ConflictException**   
HTTP Status Code: 400

 **InternalServerException**   
HTTP Status Code: 500

 **ResourceNotFoundException**   
HTTP Status Code: 400

 **ThrottlingException**   
HTTP Status Code: 400

 **ValidationException**   
HTTP Status Code: 400

## See Also<a name="API_BatchDeleteDocument_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/kendra-2019-02-03/BatchDeleteDocument) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/kendra-2019-02-03/BatchDeleteDocument) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/BatchDeleteDocument) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/BatchDeleteDocument) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/BatchDeleteDocument) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/kendra-2019-02-03/BatchDeleteDocument) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/kendra-2019-02-03/BatchDeleteDocument) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/kendra-2019-02-03/BatchDeleteDocument) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/BatchDeleteDocument) 