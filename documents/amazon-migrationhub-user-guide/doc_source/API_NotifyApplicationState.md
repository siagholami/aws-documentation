# NotifyApplicationState<a name="API_NotifyApplicationState"></a>

Sets the migration state of an application\. For a given application identified by the value passed to `ApplicationId`, its status is set or updated by passing one of three values to `Status`: `NOT_STARTED | IN_PROGRESS | COMPLETED`\.

## Request Syntax<a name="API_NotifyApplicationState_RequestSyntax"></a>

```
{
   "ApplicationId": "string",
   "DryRun": boolean,
   "Status": "string",
   "UpdateDateTime": number
}
```

## Request Parameters<a name="API_NotifyApplicationState_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [ApplicationId](#API_NotifyApplicationState_RequestSyntax) **   <a name="migrationhub-NotifyApplicationState-request-ApplicationId"></a>
The configurationId in Application Discovery Service that uniquely identifies the grouped application\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1600\.  
Pattern: `^.{1,1600}$`   
Required: Yes

 ** [DryRun](#API_NotifyApplicationState_RequestSyntax) **   <a name="migrationhub-NotifyApplicationState-request-DryRun"></a>
Optional boolean flag to indicate whether any effect should take place\. Used to test if the caller has permission to make the call\.  
Type: Boolean  
Required: No

 ** [Status](#API_NotifyApplicationState_RequestSyntax) **   <a name="migrationhub-NotifyApplicationState-request-Status"></a>
Status of the application \- Not Started, In\-Progress, Complete\.  
Type: String  
Valid Values:` NOT_STARTED | IN_PROGRESS | COMPLETED`   
Required: Yes

 ** [UpdateDateTime](#API_NotifyApplicationState_RequestSyntax) **   <a name="migrationhub-NotifyApplicationState-request-UpdateDateTime"></a>
The timestamp when the application state changed\.  
Type: Timestamp  
Required: No

## Response Elements<a name="API_NotifyApplicationState_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response with an empty HTTP body\.

## Errors<a name="API_NotifyApplicationState_Errors"></a>

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

 **PolicyErrorException**   
Exception raised when there are problems accessing Application Discovery Service \(Application Discovery Service\); most likely due to a misconfigured policy or the `migrationhub-discovery` role is missing or not configured correctly\.  
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

## Example<a name="API_NotifyApplicationState_Examples"></a>

### Notify the application state to Migration Hub<a name="API_NotifyApplicationState_Example_1"></a>

The following example communicates the migration status to Migration Hub using the values passed to the required parameters `ApplicationId` and `Status`\.

**Note**  
In this example, the `DryRun` parameter is used and set to "true" in order to show the output of the `DryRunOperation` when the user has appropriate permissions to run the command\.

#### Sample Request<a name="API_NotifyApplicationState_Example_1_Request"></a>

```
{
   "ApplicationId": "d-application-0039038d504694533",
   "Status": "IN_PROGRESS"
   "DryRun": true
}
```

#### Sample Response<a name="API_NotifyApplicationState_Example_1_Response"></a>

```
An error occurred (DryRunOperation) when calling the NotifyApplicationState operation: Dry Run was a success!
$
```

## See Also<a name="API_NotifyApplicationState_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/AWSMigrationHub-2017-05-31/NotifyApplicationState) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/AWSMigrationHub-2017-05-31/NotifyApplicationState) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/AWSMigrationHub-2017-05-31/NotifyApplicationState) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/AWSMigrationHub-2017-05-31/NotifyApplicationState) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/AWSMigrationHub-2017-05-31/NotifyApplicationState) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/AWSMigrationHub-2017-05-31/NotifyApplicationState) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/AWSMigrationHub-2017-05-31/NotifyApplicationState) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/AWSMigrationHub-2017-05-31/NotifyApplicationState) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/AWSMigrationHub-2017-05-31/NotifyApplicationState) 