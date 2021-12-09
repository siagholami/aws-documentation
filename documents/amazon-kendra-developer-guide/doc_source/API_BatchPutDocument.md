--------

--------

# BatchPutDocument<a name="API_BatchPutDocument"></a>

Adds one or more documents to an index\.

The `BatchPutDocument` operation enables you to ingest inline documents or a set of documents stored in an Amazon S3 bucket\. Use this operation to ingest your text and unstructured text into an index, add custom attributes to the documents, and to attach an access control list to the documents added to the index\.

The documents are indexed asynchronously\. You can see the progress of the batch using AWS CloudWatch\. Any error messages related to processing the batch are sent to your AWS CloudWatch log\.

## Request Syntax<a name="API_BatchPutDocument_RequestSyntax"></a>

```
{
   "Documents": [ 
      { 
         "AccessControlList": [ 
            { 
               "Access": "string",
               "Name": "string",
               "Type": "string"
            }
         ],
         "Attributes": [ 
            { 
               "Key": "string",
               "Value": { 
                  "DateValue": number,
                  "LongValue": number,
                  "StringListValue": [ "string" ],
                  "StringValue": "string"
               }
            }
         ],
         "Blob": blob,
         "ContentType": "string",
         "Id": "string",
         "S3Path": { 
            "Bucket": "string",
            "Key": "string"
         },
         "Title": "string"
      }
   ],
   "IndexId": "string",
   "RoleArn": "string"
}
```

## Request Parameters<a name="API_BatchPutDocument_RequestParameters"></a>

For information about the parameters that are common to all actions, see [Common Parameters](CommonParameters.md)\.

The request accepts the following data in JSON format\.

 ** [Documents](#API_BatchPutDocument_RequestSyntax) **   <a name="Kendra-BatchPutDocument-request-Documents"></a>
One or more documents to add to the index\.   
Documents have the following file size limits\.  
+ 5 MB total size for inline documents
+ 50 MB total size for files from an S3 bucket
+ 5 MB extracted text for any file
For more information about file size and transaction per second quotas, see [Quotas](https://docs.aws.amazon.com/kendra/latest/dg/quotas.html)\.  
Type: Array of [Document](API_Document.md) objects  
Array Members: Minimum number of 1 item\. Maximum number of 10 items\.  
Required: Yes

 ** [IndexId](#API_BatchPutDocument_RequestSyntax) **   <a name="Kendra-BatchPutDocument-request-IndexId"></a>
The identifier of the index to add the documents to\. You need to create the index first using the [CreateIndex](API_CreateIndex.md) operation\.  
Type: String  
Length Constraints: Fixed length of 36\.  
Pattern: `[a-zA-Z0-9][a-zA-Z0-9-]*`   
Required: Yes

 ** [RoleArn](#API_BatchPutDocument_RequestSyntax) **   <a name="Kendra-BatchPutDocument-request-RoleArn"></a>
The Amazon Resource Name \(ARN\) of a role that is allowed to run the `BatchPutDocument` operation\. For more information, see [IAM Roles for Amazon Kendra](https://docs.aws.amazon.com/kendra/latest/dg/iam-roles.html)\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1284\.  
Pattern: `arn:[a-z0-9-\.]{1,63}:[a-z0-9-\.]{0,63}:[a-z0-9-\.]{0,63}:[a-z0-9-\.]{0,63}:[^/].{0,1023}`   
Required: No

## Response Syntax<a name="API_BatchPutDocument_ResponseSyntax"></a>

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

## Response Elements<a name="API_BatchPutDocument_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [FailedDocuments](#API_BatchPutDocument_ResponseSyntax) **   <a name="Kendra-BatchPutDocument-response-FailedDocuments"></a>
A list of documents that were not added to the index because the document failed a validation check\. Each document contains an error message that indicates why the document couldn't be added to the index\.  
If there was an error adding a document to an index the error is reported in your AWS CloudWatch log\. For more information, see [Monitoring Amazon Kendra with Amazon CloudWatch Logs](https://docs.aws.amazon.com/kendra/latest/dg/cloudwatch-logs.html)   
Type: Array of [BatchPutDocumentResponseFailedDocument](API_BatchPutDocumentResponseFailedDocument.md) objects

## Errors<a name="API_BatchPutDocument_Errors"></a>

For information about the errors that are common to all actions, see [Common Errors](CommonErrors.md)\.

 **AccessDeniedException**   
HTTP Status Code: 400

 **ConflictException**   
HTTP Status Code: 400

 **InternalServerException**   
HTTP Status Code: 500

 **ResourceNotFoundException**   
HTTP Status Code: 400

 **ServiceQuotaExceededException**   
HTTP Status Code: 400

 **ThrottlingException**   
HTTP Status Code: 400

 **ValidationException**   
HTTP Status Code: 400

## See Also<a name="API_BatchPutDocument_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/kendra-2019-02-03/BatchPutDocument) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/kendra-2019-02-03/BatchPutDocument) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/BatchPutDocument) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/BatchPutDocument) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/BatchPutDocument) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/kendra-2019-02-03/BatchPutDocument) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/kendra-2019-02-03/BatchPutDocument) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/kendra-2019-02-03/BatchPutDocument) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/BatchPutDocument) 