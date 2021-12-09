# ListApplicationStates<a name="API_ListApplicationStates"></a>

Lists all the migration statuses for your applications\. If you use the optional `ApplicationIds` parameter, only the migration statuses for those applications will be returned\.

## Request Syntax<a name="API_ListApplicationStates_RequestSyntax"></a>

```
{
   "ApplicationIds": [ "string" ],
   "MaxResults": number,
   "NextToken": "string"
}
```

## Request Parameters<a name="API_ListApplicationStates_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [ApplicationIds](#API_ListApplicationStates_RequestSyntax) **   <a name="migrationhub-ListApplicationStates-request-ApplicationIds"></a>
The configurationIds from the Application Discovery Service that uniquely identifies your applications\.  
Type: Array of strings  
Array Members: Minimum number of 1 item\. Maximum number of 100 items\.  
Length Constraints: Minimum length of 1\. Maximum length of 1600\.  
Pattern: `^.{1,1600}$`   
Required: No

 ** [MaxResults](#API_ListApplicationStates_RequestSyntax) **   <a name="migrationhub-ListApplicationStates-request-MaxResults"></a>
Maximum number of results to be returned per page\.  
Type: Integer  
Valid Range: Minimum value of 1\. Maximum value of 100\.  
Required: No

 ** [NextToken](#API_ListApplicationStates_RequestSyntax) **   <a name="migrationhub-ListApplicationStates-request-NextToken"></a>
If a `NextToken` was returned by a previous call, there are more results available\. To retrieve the next page of results, make the call again using the returned token in `NextToken`\.  
Type: String  
Length Constraints: Minimum length of 0\. Maximum length of 2048\.  
Pattern: `^[a-zA-Z0-9\/\+\=]{0,2048}$`   
Required: No

## Response Syntax<a name="API_ListApplicationStates_ResponseSyntax"></a>

```
{
   "ApplicationStateList": [ 
      { 
         "ApplicationId": "string",
         "ApplicationStatus": "string",
         "LastUpdatedTime": number
      }
   ],
   "NextToken": "string"
}
```

## Response Elements<a name="API_ListApplicationStates_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [ApplicationStateList](#API_ListApplicationStates_ResponseSyntax) **   <a name="migrationhub-ListApplicationStates-response-ApplicationStateList"></a>
A list of Applications that exist in Application Discovery Service\.  
Type: Array of [ApplicationState](API_ApplicationState.md) objects  
Array Members: Minimum number of 0 items\. Maximum number of 1000 items\.

 ** [NextToken](#API_ListApplicationStates_ResponseSyntax) **   <a name="migrationhub-ListApplicationStates-response-NextToken"></a>
If a `NextToken` was returned by a previous call, there are more results available\. To retrieve the next page of results, make the call again using the returned token in `NextToken`\.  
Type: String  
Length Constraints: Minimum length of 0\. Maximum length of 2048\.  
Pattern: `^[a-zA-Z0-9\/\+\=]{0,2048}$` 

## Errors<a name="API_ListApplicationStates_Errors"></a>

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

 **ServiceUnavailableException**   
Exception raised when there is an internal, configuration, or dependency error encountered\.  
HTTP Status Code: 500

 **ThrottlingException**   
The request was denied due to request throttling\.  
HTTP Status Code: 400

## See Also<a name="API_ListApplicationStates_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/AWSMigrationHub-2017-05-31/ListApplicationStates) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/AWSMigrationHub-2017-05-31/ListApplicationStates) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/AWSMigrationHub-2017-05-31/ListApplicationStates) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/AWSMigrationHub-2017-05-31/ListApplicationStates) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/AWSMigrationHub-2017-05-31/ListApplicationStates) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/AWSMigrationHub-2017-05-31/ListApplicationStates) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/AWSMigrationHub-2017-05-31/ListApplicationStates) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/AWSMigrationHub-2017-05-31/ListApplicationStates) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/AWSMigrationHub-2017-05-31/ListApplicationStates) 