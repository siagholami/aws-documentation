--------

--------

# StartDataSourceSyncJob<a name="API_StartDataSourceSyncJob"></a>

Starts a synchronization job for a data source\. If a synchronization job is already in progress, Amazon Kendra returns a `ResourceInUseException` exception\.

## Request Syntax<a name="API_StartDataSourceSyncJob_RequestSyntax"></a>

```
{
   "Id": "string",
   "IndexId": "string"
}
```

## Request Parameters<a name="API_StartDataSourceSyncJob_RequestParameters"></a>

For information about the parameters that are common to all actions, see [Common Parameters](CommonParameters.md)\.

The request accepts the following data in JSON format\.

 ** [Id](#API_StartDataSourceSyncJob_RequestSyntax) **   <a name="Kendra-StartDataSourceSyncJob-request-Id"></a>
The identifier of the data source to synchronize\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 100\.  
Pattern: `[a-zA-Z0-9][a-zA-Z0-9_-]*`   
Required: Yes

 ** [IndexId](#API_StartDataSourceSyncJob_RequestSyntax) **   <a name="Kendra-StartDataSourceSyncJob-request-IndexId"></a>
The identifier of the index that contains the data source\.  
Type: String  
Length Constraints: Fixed length of 36\.  
Pattern: `[a-zA-Z0-9][a-zA-Z0-9-]*`   
Required: Yes

## Response Syntax<a name="API_StartDataSourceSyncJob_ResponseSyntax"></a>

```
{
   "ExecutionId": "string"
}
```

## Response Elements<a name="API_StartDataSourceSyncJob_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [ExecutionId](#API_StartDataSourceSyncJob_ResponseSyntax) **   <a name="Kendra-StartDataSourceSyncJob-response-ExecutionId"></a>
Identifies a particular synchronization job\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 2048\.

## Errors<a name="API_StartDataSourceSyncJob_Errors"></a>

For information about the errors that are common to all actions, see [Common Errors](CommonErrors.md)\.

 **AccessDeniedException**   
HTTP Status Code: 400

 **ConflictException**   
HTTP Status Code: 400

 **InternalServerException**   
HTTP Status Code: 500

 **ResourceInUseException**   
HTTP Status Code: 400

 **ResourceNotFoundException**   
HTTP Status Code: 400

 **ThrottlingException**   
HTTP Status Code: 400

 **ValidationException**   
HTTP Status Code: 400

## See Also<a name="API_StartDataSourceSyncJob_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/kendra-2019-02-03/StartDataSourceSyncJob) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/kendra-2019-02-03/StartDataSourceSyncJob) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/StartDataSourceSyncJob) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/StartDataSourceSyncJob) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/StartDataSourceSyncJob) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/kendra-2019-02-03/StartDataSourceSyncJob) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/kendra-2019-02-03/StartDataSourceSyncJob) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/kendra-2019-02-03/StartDataSourceSyncJob) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/StartDataSourceSyncJob) 