# DeleteProgressUpdateStream<a name="API_DeleteProgressUpdateStream"></a>

Deletes a progress update stream, including all of its tasks, which was previously created as an AWS resource used for access control\. This API has the following traits:
+ The only parameter needed for `DeleteProgressUpdateStream` is the stream name \(same as a `CreateProgressUpdateStream` call\)\.
+ The call will return, and a background process will asynchronously delete the stream and all of its resources \(tasks, associated resources, resource attributes, created artifacts\)\.
+ If the stream takes time to be deleted, it might still show up on a `ListProgressUpdateStreams` call\.
+  `CreateProgressUpdateStream`, `ImportMigrationTask`, `NotifyMigrationTaskState`, and all Associate\[\*\] APIs related to the tasks belonging to the stream will throw "InvalidInputException" if the stream of the same name is in the process of being deleted\.
+ Once the stream and all of its resources are deleted, `CreateProgressUpdateStream` for a stream of the same name will succeed, and that stream will be an entirely new logical resource \(without any resources associated with the old stream\)\.

## Request Syntax<a name="API_DeleteProgressUpdateStream_RequestSyntax"></a>

```
{
   "DryRun": boolean,
   "ProgressUpdateStreamName": "string"
}
```

## Request Parameters<a name="API_DeleteProgressUpdateStream_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [DryRun](#API_DeleteProgressUpdateStream_RequestSyntax) **   <a name="migrationhub-DeleteProgressUpdateStream-request-DryRun"></a>
Optional boolean flag to indicate whether any effect should take place\. Used to test if the caller has permission to make the call\.  
Type: Boolean  
Required: No

 ** [ProgressUpdateStreamName](#API_DeleteProgressUpdateStream_RequestSyntax) **   <a name="migrationhub-DeleteProgressUpdateStream-request-ProgressUpdateStreamName"></a>
The name of the ProgressUpdateStream\. *Do not store personal data in this field\.*   
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 50\.  
Pattern: `[^/:|\000-\037]+`   
Required: Yes

## Response Elements<a name="API_DeleteProgressUpdateStream_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response with an empty HTTP body\.

## Errors<a name="API_DeleteProgressUpdateStream_Errors"></a>

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

## Example<a name="API_DeleteProgressUpdateStream_Examples"></a>

### Delete a progress update stream<a name="API_DeleteProgressUpdateStream_Example_1"></a>

The following example deletes a progress update stream identified by the values passed to the required parameter `ProgressUpdateStreamName` in the request\.

#### Sample Request<a name="API_DeleteProgressUpdateStream_Example_1_Request"></a>

```
{
    "ProgressUpdateStreamName": "SMS", 
    "DryRun": false
}
```

## See Also<a name="API_DeleteProgressUpdateStream_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/AWSMigrationHub-2017-05-31/DeleteProgressUpdateStream) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/AWSMigrationHub-2017-05-31/DeleteProgressUpdateStream) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/AWSMigrationHub-2017-05-31/DeleteProgressUpdateStream) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/AWSMigrationHub-2017-05-31/DeleteProgressUpdateStream) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/AWSMigrationHub-2017-05-31/DeleteProgressUpdateStream) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/AWSMigrationHub-2017-05-31/DeleteProgressUpdateStream) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/AWSMigrationHub-2017-05-31/DeleteProgressUpdateStream) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/AWSMigrationHub-2017-05-31/DeleteProgressUpdateStream) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/AWSMigrationHub-2017-05-31/DeleteProgressUpdateStream) 