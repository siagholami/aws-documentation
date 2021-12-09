# ImportMigrationTask<a name="API_ImportMigrationTask"></a>

Registers a new migration task which represents a server, database, etc\., being migrated to AWS by a migration tool\.

This API is a prerequisite to calling the `NotifyMigrationTaskState` API as the migration tool must first register the migration task with Migration Hub\.

## Request Syntax<a name="API_ImportMigrationTask_RequestSyntax"></a>

```
{
   "DryRun": boolean,
   "MigrationTaskName": "string",
   "ProgressUpdateStream": "string"
}
```

## Request Parameters<a name="API_ImportMigrationTask_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [DryRun](#API_ImportMigrationTask_RequestSyntax) **   <a name="migrationhub-ImportMigrationTask-request-DryRun"></a>
Optional boolean flag to indicate whether any effect should take place\. Used to test if the caller has permission to make the call\.  
Type: Boolean  
Required: No

 ** [MigrationTaskName](#API_ImportMigrationTask_RequestSyntax) **   <a name="migrationhub-ImportMigrationTask-request-MigrationTaskName"></a>
Unique identifier that references the migration task\. *Do not store personal data in this field\.*   
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 256\.  
Pattern: `[^:|]+`   
Required: Yes

 ** [ProgressUpdateStream](#API_ImportMigrationTask_RequestSyntax) **   <a name="migrationhub-ImportMigrationTask-request-ProgressUpdateStream"></a>
The name of the ProgressUpdateStream\. >  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 50\.  
Pattern: `[^/:|\000-\037]+`   
Required: Yes

## Response Elements<a name="API_ImportMigrationTask_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response with an empty HTTP body\.

## Errors<a name="API_ImportMigrationTask_Errors"></a>

 **AccessDeniedException**   
You do not have sufficient access to perform this action\.  
HTTP Status Code: 400

 **DryRunOperation**   
Exception raised to indicate a successfully authorized action when the `DryRun` flag is set to "true"\.  
HTTP Status Code: 400

 **HomeRegionNotSetException**   
The home region is not set\. Set the home region to continue\.  
HTTP Status Code: 400

 **InternalServerError**   
Exception raised when an internal, configuration, or dependency error is encountered\.  
HTTP Status Code: 500

 **InvalidInputException**   
Exception raised when the provided input violates a policy constraint or is entered in the wrong format or data type\.  
HTTP Status Code: 400

 **ResourceNotFoundException**   
Exception raised when the request references a resource \(Application Discovery Service configuration, update stream, migration task, etc\.\) that does not exist in Application Discovery Service \(Application Discovery Service\) or in Migration Hub's repository\.  
HTTP Status Code: 400

 **ServiceUnavailableException**   
Exception raised when there is an internal, configuration, or dependency error encountered\.  
HTTP Status Code: 500

 **ThrottlingException**   
The request was denied due to request throttling\.  
HTTP Status Code: 400

 **UnauthorizedOperation**   
Exception raised to indicate a request was not authorized when the `DryRun` flag is set to "true"\.  
HTTP Status Code: 400

## Example<a name="API_ImportMigrationTask_Examples"></a>

### Import a migration task to register it with Migration Hub<a name="API_ImportMigrationTask_Example_1"></a>

The following example registers a new migration task with Migration Hub identified by the values passed to the required parameters `MigrationTaskName` and `ProgressUpdateStreamName` in the request\.

#### Sample Request<a name="API_ImportMigrationTask_Example_1_Request"></a>

```
{
   "MigrationTaskName": "sms-12de3cf1a",
   "ProgressUpdateStream": "SMS"
}
```

## See Also<a name="API_ImportMigrationTask_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/AWSMigrationHub-2017-05-31/ImportMigrationTask) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/AWSMigrationHub-2017-05-31/ImportMigrationTask) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/AWSMigrationHub-2017-05-31/ImportMigrationTask) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/AWSMigrationHub-2017-05-31/ImportMigrationTask) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/AWSMigrationHub-2017-05-31/ImportMigrationTask) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/AWSMigrationHub-2017-05-31/ImportMigrationTask) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/AWSMigrationHub-2017-05-31/ImportMigrationTask) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/AWSMigrationHub-2017-05-31/ImportMigrationTask) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/AWSMigrationHub-2017-05-31/ImportMigrationTask) 