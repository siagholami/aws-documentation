# AssociateCreatedArtifact<a name="API_AssociateCreatedArtifact"></a>

Associates a created artifact of an AWS cloud resource, the target receiving the migration, with the migration task performed by a migration tool\. This API has the following traits:
+ Migration tools can call the `AssociateCreatedArtifact` operation to indicate which AWS artifact is associated with a migration task\.
+ The created artifact name must be provided in ARN \(Amazon Resource Name\) format which will contain information about type and region; for example: `arn:aws:ec2:us-east-1:488216288981:image/ami-6d0ba87b`\.
+ Examples of the AWS resource behind the created artifact are, AMI's, EC2 instance, or DMS endpoint, etc\.

## Request Syntax<a name="API_AssociateCreatedArtifact_RequestSyntax"></a>

```
{
   "CreatedArtifact": { 
      "Description": "string",
      "Name": "string"
   },
   "DryRun": boolean,
   "MigrationTaskName": "string",
   "ProgressUpdateStream": "string"
}
```

## Request Parameters<a name="API_AssociateCreatedArtifact_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [CreatedArtifact](#API_AssociateCreatedArtifact_RequestSyntax) **   <a name="migrationhub-AssociateCreatedArtifact-request-CreatedArtifact"></a>
An ARN of the AWS resource related to the migration \(e\.g\., AMI, EC2 instance, RDS instance, etc\.\)   
Type: [CreatedArtifact](API_CreatedArtifact.md) object  
Required: Yes

 ** [DryRun](#API_AssociateCreatedArtifact_RequestSyntax) **   <a name="migrationhub-AssociateCreatedArtifact-request-DryRun"></a>
Optional boolean flag to indicate whether any effect should take place\. Used to test if the caller has permission to make the call\.  
Type: Boolean  
Required: No

 ** [MigrationTaskName](#API_AssociateCreatedArtifact_RequestSyntax) **   <a name="migrationhub-AssociateCreatedArtifact-request-MigrationTaskName"></a>
Unique identifier that references the migration task\. *Do not store personal data in this field\.*   
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 256\.  
Pattern: `[^:|]+`   
Required: Yes

 ** [ProgressUpdateStream](#API_AssociateCreatedArtifact_RequestSyntax) **   <a name="migrationhub-AssociateCreatedArtifact-request-ProgressUpdateStream"></a>
The name of the ProgressUpdateStream\.   
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 50\.  
Pattern: `[^/:|\000-\037]+`   
Required: Yes

## Response Elements<a name="API_AssociateCreatedArtifact_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response with an empty HTTP body\.

## Errors<a name="API_AssociateCreatedArtifact_Errors"></a>

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

## Example<a name="API_AssociateCreatedArtifact_Examples"></a>

### Associate a created artifact<a name="API_AssociateCreatedArtifact_Example_1"></a>

The following example associates an AWS resource to the migration task identified by the values passed to the required parameters of `MigrationTaskName` and `ProgressUpdateStream` in the request\.

#### Sample Request<a name="API_AssociateCreatedArtifact_Example_1_Request"></a>

```
{
   "CreatedArtifact": [
      { 
         "Description": "Using SMS to migrate server to EC2",
         "Name": "arn:aws:ec2:us-east-1:488216288981:image/ami-6d0ba87b"
      }
   ],
   "DryRun": false,
   "MigrationTaskName": "sms-12de3cf1a",
   "ProgressUpdateStream": "SMS"               

}
```

## See Also<a name="API_AssociateCreatedArtifact_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/AWSMigrationHub-2017-05-31/AssociateCreatedArtifact) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/AWSMigrationHub-2017-05-31/AssociateCreatedArtifact) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/AWSMigrationHub-2017-05-31/AssociateCreatedArtifact) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/AWSMigrationHub-2017-05-31/AssociateCreatedArtifact) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/AWSMigrationHub-2017-05-31/AssociateCreatedArtifact) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/AWSMigrationHub-2017-05-31/AssociateCreatedArtifact) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/AWSMigrationHub-2017-05-31/AssociateCreatedArtifact) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/AWSMigrationHub-2017-05-31/AssociateCreatedArtifact) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/AWSMigrationHub-2017-05-31/AssociateCreatedArtifact) 