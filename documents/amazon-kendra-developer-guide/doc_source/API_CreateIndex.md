--------

--------

# CreateIndex<a name="API_CreateIndex"></a>

Creates a new Amazon Kendra index\. Index creation is an asynchronous operation\. To determine if index creation has completed, check the `Status` field returned from a call to [DescribeIndex](API_DescribeIndex.md)\. The `Status` field is set to `ACTIVE` when the index is ready to use\.

Once the index is active you can index your documents using the [BatchPutDocument](API_BatchPutDocument.md) operation or using one of the supported data sources\. 

## Request Syntax<a name="API_CreateIndex_RequestSyntax"></a>

```
{
   "ClientToken": "string",
   "Description": "string",
   "Edition": "string",
   "Name": "string",
   "RoleArn": "string",
   "ServerSideEncryptionConfiguration": { 
      "KmsKeyId": "string"
   },
   "Tags": [ 
      { 
         "Key": "string",
         "Value": "string"
      }
   ]
}
```

## Request Parameters<a name="API_CreateIndex_RequestParameters"></a>

For information about the parameters that are common to all actions, see [Common Parameters](CommonParameters.md)\.

The request accepts the following data in JSON format\.

 ** [ClientToken](#API_CreateIndex_RequestSyntax) **   <a name="Kendra-CreateIndex-request-ClientToken"></a>
A token that you provide to identify the request to create an index\. Multiple calls to the `CreateIndex` operation with the same client token will create only one index\.”  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 100\.  
Required: No

 ** [Description](#API_CreateIndex_RequestSyntax) **   <a name="Kendra-CreateIndex-request-Description"></a>
A description for the index\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1000\.  
Pattern: `^\P{C}*$`   
Required: No

 ** [Edition](#API_CreateIndex_RequestSyntax) **   <a name="Kendra-CreateIndex-request-Edition"></a>
The Amazon Kendra edition to use for the index\. Choose `DEVELOPER_EDITION` for indexes intended for development, testing, or proof of concept\. Use `ENTERPRISE_EDITION` for your production databases\. Once you set the edition for an index, it can't be changed\.   
Type: String  
Valid Values:` DEVELOPER_EDITION | ENTERPRISE_EDITION`   
Required: No

 ** [Name](#API_CreateIndex_RequestSyntax) **   <a name="Kendra-CreateIndex-request-Name"></a>
The name for the new index\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1000\.  
Pattern: `[a-zA-Z0-9][a-zA-Z0-9_-]*`   
Required: Yes

 ** [RoleArn](#API_CreateIndex_RequestSyntax) **   <a name="Kendra-CreateIndex-request-RoleArn"></a>
An IAM role that gives Amazon Kendra permissions to access your Amazon CloudWatch logs and metrics\. This is also the role used when you use the `BatchPutDocument` operation to index documents from an Amazon S3 bucket\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1284\.  
Pattern: `arn:[a-z0-9-\.]{1,63}:[a-z0-9-\.]{0,63}:[a-z0-9-\.]{0,63}:[a-z0-9-\.]{0,63}:[^/].{0,1023}`   
Required: Yes

 ** [ServerSideEncryptionConfiguration](#API_CreateIndex_RequestSyntax) **   <a name="Kendra-CreateIndex-request-ServerSideEncryptionConfiguration"></a>
The identifier of the AWS KMS customer managed key \(CMK\) to use to encrypt data indexed by Amazon Kendra\. Amazon Kendra doesn't support asymmetric CMKs\.  
Type: [ServerSideEncryptionConfiguration](API_ServerSideEncryptionConfiguration.md) object  
Required: No

 ** [Tags](#API_CreateIndex_RequestSyntax) **   <a name="Kendra-CreateIndex-request-Tags"></a>
A list of key\-value pairs that identify the index\. You can use the tags to identify and organize your resources and to control access to resources\.  
Type: Array of [Tag](API_Tag.md) objects  
Array Members: Minimum number of 0 items\. Maximum number of 200 items\.  
Required: No

## Response Syntax<a name="API_CreateIndex_ResponseSyntax"></a>

```
{
   "Id": "string"
}
```

## Response Elements<a name="API_CreateIndex_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [Id](#API_CreateIndex_ResponseSyntax) **   <a name="Kendra-CreateIndex-response-Id"></a>
The unique identifier of the index\. Use this identifier when you query an index, set up a data source, or index a document\.  
Type: String  
Length Constraints: Fixed length of 36\.  
Pattern: `[a-zA-Z0-9][a-zA-Z0-9-]*` 

## Errors<a name="API_CreateIndex_Errors"></a>

For information about the errors that are common to all actions, see [Common Errors](CommonErrors.md)\.

 **AccessDeniedException**   
HTTP Status Code: 400

 **ConflictException**   
HTTP Status Code: 400

 **InternalServerException**   
HTTP Status Code: 500

 **ResourceAlreadyExistException**   
HTTP Status Code: 400

 **ServiceQuotaExceededException**   
HTTP Status Code: 400

 **ThrottlingException**   
HTTP Status Code: 400

 **ValidationException**   
HTTP Status Code: 400

## See Also<a name="API_CreateIndex_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/kendra-2019-02-03/CreateIndex) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/kendra-2019-02-03/CreateIndex) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/CreateIndex) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/CreateIndex) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/CreateIndex) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/kendra-2019-02-03/CreateIndex) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/kendra-2019-02-03/CreateIndex) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/kendra-2019-02-03/CreateIndex) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/CreateIndex) 