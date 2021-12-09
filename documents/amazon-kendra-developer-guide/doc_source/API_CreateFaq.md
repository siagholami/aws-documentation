--------

--------

# CreateFaq<a name="API_CreateFaq"></a>

Creates an new set of frequently asked question \(FAQ\) questions and answers\.

## Request Syntax<a name="API_CreateFaq_RequestSyntax"></a>

```
{
   "Description": "string",
   "IndexId": "string",
   "Name": "string",
   "RoleArn": "string",
   "S3Path": { 
      "Bucket": "string",
      "Key": "string"
   },
   "Tags": [ 
      { 
         "Key": "string",
         "Value": "string"
      }
   ]
}
```

## Request Parameters<a name="API_CreateFaq_RequestParameters"></a>

For information about the parameters that are common to all actions, see [Common Parameters](CommonParameters.md)\.

The request accepts the following data in JSON format\.

 ** [Description](#API_CreateFaq_RequestSyntax) **   <a name="Kendra-CreateFaq-request-Description"></a>
A description of the FAQ\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1000\.  
Pattern: `^\P{C}*$`   
Required: No

 ** [IndexId](#API_CreateFaq_RequestSyntax) **   <a name="Kendra-CreateFaq-request-IndexId"></a>
The identifier of the index that contains the FAQ\.  
Type: String  
Length Constraints: Fixed length of 36\.  
Pattern: `[a-zA-Z0-9][a-zA-Z0-9-]*`   
Required: Yes

 ** [Name](#API_CreateFaq_RequestSyntax) **   <a name="Kendra-CreateFaq-request-Name"></a>
The name that should be associated with the FAQ\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 100\.  
Pattern: `[a-zA-Z0-9][a-zA-Z0-9_-]*`   
Required: Yes

 ** [RoleArn](#API_CreateFaq_RequestSyntax) **   <a name="Kendra-CreateFaq-request-RoleArn"></a>
The Amazon Resource Name \(ARN\) of a role with permission to access the S3 bucket that contains the FAQs\. For more information, see [IAM Roles for Amazon Kendra](https://docs.aws.amazon.com/kendra/latest/dg/iam-roles.html)\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1284\.  
Pattern: `arn:[a-z0-9-\.]{1,63}:[a-z0-9-\.]{0,63}:[a-z0-9-\.]{0,63}:[a-z0-9-\.]{0,63}:[^/].{0,1023}`   
Required: Yes

 ** [S3Path](#API_CreateFaq_RequestSyntax) **   <a name="Kendra-CreateFaq-request-S3Path"></a>
The S3 location of the FAQ input data\.  
Type: [S3Path](API_S3Path.md) object  
Required: Yes

 ** [Tags](#API_CreateFaq_RequestSyntax) **   <a name="Kendra-CreateFaq-request-Tags"></a>
A list of key\-value pairs that identify the FAQ\. You can use the tags to identify and organize your resources and to control access to resources\.  
Type: Array of [Tag](API_Tag.md) objects  
Array Members: Minimum number of 0 items\. Maximum number of 200 items\.  
Required: No

## Response Syntax<a name="API_CreateFaq_ResponseSyntax"></a>

```
{
   "Id": "string"
}
```

## Response Elements<a name="API_CreateFaq_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [Id](#API_CreateFaq_ResponseSyntax) **   <a name="Kendra-CreateFaq-response-Id"></a>
The unique identifier of the FAQ\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 100\.  
Pattern: `[a-zA-Z0-9][a-zA-Z0-9_-]*` 

## Errors<a name="API_CreateFaq_Errors"></a>

For information about the errors that are common to all actions, see [Common Errors](CommonErrors.md)\.

 **AccessDeniedException**   
HTTP Status Code: 400

 **ConflictException**   
HTTP Status Code: 400

 **InternalServerException**   
HTTP Status Code: 500

 **ResourceNotFoundException**   
HTTP Status Code: 400

 **ServiceQuotaExceededException**   
HTTP Status Code: 400

 **ThrottlingException**   
HTTP Status Code: 400

 **ValidationException**   
HTTP Status Code: 400

## See Also<a name="API_CreateFaq_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/kendra-2019-02-03/CreateFaq) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/kendra-2019-02-03/CreateFaq) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/CreateFaq) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/CreateFaq) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/CreateFaq) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/kendra-2019-02-03/CreateFaq) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/kendra-2019-02-03/CreateFaq) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/kendra-2019-02-03/CreateFaq) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/CreateFaq) 