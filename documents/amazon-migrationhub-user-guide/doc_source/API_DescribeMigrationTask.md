# DescribeMigrationTask<a name="API_DescribeMigrationTask"></a>

Retrieves a list of all attributes associated with a specific migration task\.

## Request Syntax<a name="API_DescribeMigrationTask_RequestSyntax"></a>

```
{
   "MigrationTaskName": "string",
   "ProgressUpdateStream": "string"
}
```

## Request Parameters<a name="API_DescribeMigrationTask_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [MigrationTaskName](#API_DescribeMigrationTask_RequestSyntax) **   <a name="migrationhub-DescribeMigrationTask-request-MigrationTaskName"></a>
The identifier given to the MigrationTask\. *Do not store personal data in this field\.*   
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 256\.  
Pattern: `[^:|]+`   
Required: Yes

 ** [ProgressUpdateStream](#API_DescribeMigrationTask_RequestSyntax) **   <a name="migrationhub-DescribeMigrationTask-request-ProgressUpdateStream"></a>
The name of the ProgressUpdateStream\.   
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 50\.  
Pattern: `[^/:|\000-\037]+`   
Required: Yes

## Response Syntax<a name="API_DescribeMigrationTask_ResponseSyntax"></a>

```
{
   "MigrationTask": { 
      "MigrationTaskName": "string",
      "ProgressUpdateStream": "string",
      "ResourceAttributeList": [ 
         { 
            "Type": "string",
            "Value": "string"
         }
      ],
      "Task": { 
         "ProgressPercent": number,
         "Status": "string",
         "StatusDetail": "string"
      },
      "UpdateDateTime": number
   }
}
```

## Response Elements<a name="API_DescribeMigrationTask_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [MigrationTask](#API_DescribeMigrationTask_ResponseSyntax) **   <a name="migrationhub-DescribeMigrationTask-response-MigrationTask"></a>
Object encapsulating information about the migration task\.  
Type: [MigrationTask](API_MigrationTask.md) object

## Errors<a name="API_DescribeMigrationTask_Errors"></a>

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

 **ResourceNotFoundException**   
Exception raised when the request references a resource \(Application Discovery Service configuration, update stream, migration task, etc\.\) that does not exist in Application Discovery Service \(Application Discovery Service\) or in Migration Hub's repository\.  
HTTP Status Code: 400

 **ServiceUnavailableException**   
Exception raised when there is an internal, configuration, or dependency error encountered\.  
HTTP Status Code: 500

 **ThrottlingException**   
The request was denied due to request throttling\.  
HTTP Status Code: 400

## Example<a name="API_DescribeMigrationTask_Examples"></a>

### Describe a migration task by listing all associated attributes<a name="API_DescribeMigrationTask_Example_1"></a>

The following example lists all of the attributes associated with the values passed to the required parameters of `MigrationTaskName` and `ProgressUpdateStream`\.

#### Sample Request<a name="API_DescribeMigrationTask_Example_1_Request"></a>

```
{
    "ProgressUpdateStream": "SMS",
    "MigrationTaskName": "sms-12de3cf1a"
}
```

#### Sample Response<a name="API_DescribeMigrationTask_Example_1_Response"></a>

```
{
    "MigrationTask": {
        "ProgressUpdateStream": "SMS", 
        "Task": {
            "Status": "IN_PROGRESS", 
            "StatusDetail": "Migration: Copying image data", 
            "ProgressPercent": 77
        }, 
        "UpdateDateTime": 1493750385.0, 
        "MigrationTaskName": "sms-12de3cf1a"
    }
}
```

## See Also<a name="API_DescribeMigrationTask_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/AWSMigrationHub-2017-05-31/DescribeMigrationTask) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/AWSMigrationHub-2017-05-31/DescribeMigrationTask) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/AWSMigrationHub-2017-05-31/DescribeMigrationTask) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/AWSMigrationHub-2017-05-31/DescribeMigrationTask) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/AWSMigrationHub-2017-05-31/DescribeMigrationTask) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/AWSMigrationHub-2017-05-31/DescribeMigrationTask) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/AWSMigrationHub-2017-05-31/DescribeMigrationTask) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/AWSMigrationHub-2017-05-31/DescribeMigrationTask) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/AWSMigrationHub-2017-05-31/DescribeMigrationTask) 