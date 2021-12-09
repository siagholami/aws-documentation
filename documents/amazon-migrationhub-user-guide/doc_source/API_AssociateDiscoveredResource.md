# AssociateDiscoveredResource<a name="API_AssociateDiscoveredResource"></a>

Associates a discovered resource ID from Application Discovery Service with a migration task\.

## Request Syntax<a name="API_AssociateDiscoveredResource_RequestSyntax"></a>

```
{
   "DiscoveredResource": { 
      "ConfigurationId": "string",
      "Description": "string"
   },
   "DryRun": boolean,
   "MigrationTaskName": "string",
   "ProgressUpdateStream": "string"
}
```

## Request Parameters<a name="API_AssociateDiscoveredResource_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [DiscoveredResource](#API_AssociateDiscoveredResource_RequestSyntax) **   <a name="migrationhub-AssociateDiscoveredResource-request-DiscoveredResource"></a>
Object representing a Resource\.  
Type: [DiscoveredResource](API_DiscoveredResource.md) object  
Required: Yes

 ** [DryRun](#API_AssociateDiscoveredResource_RequestSyntax) **   <a name="migrationhub-AssociateDiscoveredResource-request-DryRun"></a>
Optional boolean flag to indicate whether any effect should take place\. Used to test if the caller has permission to make the call\.  
Type: Boolean  
Required: No

 ** [MigrationTaskName](#API_AssociateDiscoveredResource_RequestSyntax) **   <a name="migrationhub-AssociateDiscoveredResource-request-MigrationTaskName"></a>
The identifier given to the MigrationTask\. *Do not store personal data in this field\.*   
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 256\.  
Pattern: `[^:|]+`   
Required: Yes

 ** [ProgressUpdateStream](#API_AssociateDiscoveredResource_RequestSyntax) **   <a name="migrationhub-AssociateDiscoveredResource-request-ProgressUpdateStream"></a>
The name of the ProgressUpdateStream\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 50\.  
Pattern: `[^/:|\000-\037]+`   
Required: Yes

## Response Elements<a name="API_AssociateDiscoveredResource_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response with an empty HTTP body\.

## Errors<a name="API_AssociateDiscoveredResource_Errors"></a>

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

## Example<a name="API_AssociateDiscoveredResource_Examples"></a>

### Associate a discovered resource<a name="API_AssociateDiscoveredResource_Example_1"></a>

The following example associates an AWS Application Discovery Service discovered resource specified by its configuration id and description to the migration task identified by the values passed to the required parameters of `MigrationTaskName` and `ProgressUpdateStream` in the request\.

#### Sample Request<a name="API_AssociateDiscoveredResource_Example_1_Request"></a>

```
{
    "ProgressUpdateStream": "SMS", 
    "MigrationTaskName": "sms-12de3cf1a", 
    "DiscoveredResource": {
        "ConfigurationId": "d-server-0025db43a885966c8", 
        "Description": "Amazon Linux AMI release 2016.09"
    }
}
```

## See Also<a name="API_AssociateDiscoveredResource_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/AWSMigrationHub-2017-05-31/AssociateDiscoveredResource) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/AWSMigrationHub-2017-05-31/AssociateDiscoveredResource) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/AWSMigrationHub-2017-05-31/AssociateDiscoveredResource) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/AWSMigrationHub-2017-05-31/AssociateDiscoveredResource) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/AWSMigrationHub-2017-05-31/AssociateDiscoveredResource) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/AWSMigrationHub-2017-05-31/AssociateDiscoveredResource) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/AWSMigrationHub-2017-05-31/AssociateDiscoveredResource) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/AWSMigrationHub-2017-05-31/AssociateDiscoveredResource) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/AWSMigrationHub-2017-05-31/AssociateDiscoveredResource) 