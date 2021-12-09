# NotifyMigrationTaskState<a name="API_NotifyMigrationTaskState"></a>

Notifies Migration Hub of the current status, progress, or other detail regarding a migration task\. This API has the following traits:
+ Migration tools will call the `NotifyMigrationTaskState` API to share the latest progress and status\.
+  `MigrationTaskName` is used for addressing updates to the correct target\.
+  `ProgressUpdateStream` is used for access control and to provide a namespace for each migration tool\.

## Request Syntax<a name="API_NotifyMigrationTaskState_RequestSyntax"></a>

```
{
   "DryRun": boolean,
   "MigrationTaskName": "string",
   "NextUpdateSeconds": number,
   "ProgressUpdateStream": "string",
   "Task": { 
      "ProgressPercent": number,
      "Status": "string",
      "StatusDetail": "string"
   },
   "UpdateDateTime": number
}
```

## Request Parameters<a name="API_NotifyMigrationTaskState_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [DryRun](#API_NotifyMigrationTaskState_RequestSyntax) **   <a name="migrationhub-NotifyMigrationTaskState-request-DryRun"></a>
Optional boolean flag to indicate whether any effect should take place\. Used to test if the caller has permission to make the call\.  
Type: Boolean  
Required: No

 ** [MigrationTaskName](#API_NotifyMigrationTaskState_RequestSyntax) **   <a name="migrationhub-NotifyMigrationTaskState-request-MigrationTaskName"></a>
Unique identifier that references the migration task\. *Do not store personal data in this field\.*   
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 256\.  
Pattern: `[^:|]+`   
Required: Yes

 ** [NextUpdateSeconds](#API_NotifyMigrationTaskState_RequestSyntax) **   <a name="migrationhub-NotifyMigrationTaskState-request-NextUpdateSeconds"></a>
Number of seconds after the UpdateDateTime within which the Migration Hub can expect an update\. If Migration Hub does not receive an update within the specified interval, then the migration task will be considered stale\.  
Type: Integer  
Valid Range: Minimum value of 0\.  
Required: Yes

 ** [ProgressUpdateStream](#API_NotifyMigrationTaskState_RequestSyntax) **   <a name="migrationhub-NotifyMigrationTaskState-request-ProgressUpdateStream"></a>
The name of the ProgressUpdateStream\.   
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 50\.  
Pattern: `[^/:|\000-\037]+`   
Required: Yes

 ** [Task](#API_NotifyMigrationTaskState_RequestSyntax) **   <a name="migrationhub-NotifyMigrationTaskState-request-Task"></a>
Information about the task's progress and status\.  
Type: [Task](API_Task.md) object  
Required: Yes

 ** [UpdateDateTime](#API_NotifyMigrationTaskState_RequestSyntax) **   <a name="migrationhub-NotifyMigrationTaskState-request-UpdateDateTime"></a>
The timestamp when the task was gathered\.  
Type: Timestamp  
Required: Yes

## Response Elements<a name="API_NotifyMigrationTaskState_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response with an empty HTTP body\.

## Errors<a name="API_NotifyMigrationTaskState_Errors"></a>

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

## Example<a name="API_NotifyMigrationTaskState_Examples"></a>

### Notify the migration task state to Migration Hub<a name="API_NotifyMigrationTaskState_Example_1"></a>

The following example communicates the latest progress and updates to Migration Hub using the values passed to the required parameters `MigrationTaskName` and `ProgressUpdateStream` to tag the correct target and its migration tool\. The other parameters in the example are also required to provide details of the task state\.

#### Sample Request<a name="API_NotifyMigrationTaskState_Example_1_Request"></a>

```
{
    "MigrationTaskName": "sms-12de3cf1a",
    "NextUpdateSeconds": 60,
    "ProgressUpdateStream": "SMS",
    "Task": { 
       "ProgressPercent": 77,
       "Status": "IN_PROGRESS",
       "StatusDetail": "Migration: Copying image data"
    },
    "UpdateDateTime": 1493660853
}
```

## See Also<a name="API_NotifyMigrationTaskState_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/AWSMigrationHub-2017-05-31/NotifyMigrationTaskState) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/AWSMigrationHub-2017-05-31/NotifyMigrationTaskState) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/AWSMigrationHub-2017-05-31/NotifyMigrationTaskState) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/AWSMigrationHub-2017-05-31/NotifyMigrationTaskState) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/AWSMigrationHub-2017-05-31/NotifyMigrationTaskState) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/AWSMigrationHub-2017-05-31/NotifyMigrationTaskState) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/AWSMigrationHub-2017-05-31/NotifyMigrationTaskState) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/AWSMigrationHub-2017-05-31/NotifyMigrationTaskState) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/AWSMigrationHub-2017-05-31/NotifyMigrationTaskState) 