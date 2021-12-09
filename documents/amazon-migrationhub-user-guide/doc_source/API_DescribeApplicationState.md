# DescribeApplicationState<a name="API_DescribeApplicationState"></a>

Gets the migration status of an application\.

## Request Syntax<a name="API_DescribeApplicationState_RequestSyntax"></a>

```
{
   "ApplicationId": "string"
}
```

## Request Parameters<a name="API_DescribeApplicationState_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [ApplicationId](#API_DescribeApplicationState_RequestSyntax) **   <a name="migrationhub-DescribeApplicationState-request-ApplicationId"></a>
The configurationId in Application Discovery Service that uniquely identifies the grouped application\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1600\.  
Pattern: `^.{1,1600}$`   
Required: Yes

## Response Syntax<a name="API_DescribeApplicationState_ResponseSyntax"></a>

```
{
   "ApplicationStatus": "string",
   "LastUpdatedTime": number
}
```

## Response Elements<a name="API_DescribeApplicationState_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [ApplicationStatus](#API_DescribeApplicationState_ResponseSyntax) **   <a name="migrationhub-DescribeApplicationState-response-ApplicationStatus"></a>
Status of the application \- Not Started, In\-Progress, Complete\.  
Type: String  
Valid Values:` NOT_STARTED | IN_PROGRESS | COMPLETED` 

 ** [LastUpdatedTime](#API_DescribeApplicationState_ResponseSyntax) **   <a name="migrationhub-DescribeApplicationState-response-LastUpdatedTime"></a>
The timestamp when the application status was last updated\.  
Type: Timestamp

## Errors<a name="API_DescribeApplicationState_Errors"></a>

 **AccessDeniedException**   
You do not have sufficient access to perform this action\.  
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

## Example<a name="API_DescribeApplicationState_Examples"></a>

### Describe a migration task by listing all associated attributes<a name="API_DescribeApplicationState_Example_1"></a>

The following example lists all of the attributes associated with the values passed to the required parameters of `MigrationTaskName` and `ProgressUpdateStream`\.

#### Sample Request<a name="API_DescribeApplicationState_Example_1_Request"></a>

```
{
    "ApplicationId": "d-application-0039038d504694533"
}
```

#### Sample Response<a name="API_DescribeApplicationState_Example_1_Response"></a>

```
{
    "ApplicationStatus": "IN_PROGRESS", 
    "LastUpdatedTime": 1493405005.639
}
```

## See Also<a name="API_DescribeApplicationState_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/AWSMigrationHub-2017-05-31/DescribeApplicationState) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/AWSMigrationHub-2017-05-31/DescribeApplicationState) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/AWSMigrationHub-2017-05-31/DescribeApplicationState) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/AWSMigrationHub-2017-05-31/DescribeApplicationState) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/AWSMigrationHub-2017-05-31/DescribeApplicationState) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/AWSMigrationHub-2017-05-31/DescribeApplicationState) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/AWSMigrationHub-2017-05-31/DescribeApplicationState) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/AWSMigrationHub-2017-05-31/DescribeApplicationState) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/AWSMigrationHub-2017-05-31/DescribeApplicationState) 