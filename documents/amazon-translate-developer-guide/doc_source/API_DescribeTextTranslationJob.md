# DescribeTextTranslationJob<a name="API_DescribeTextTranslationJob"></a>

Gets the properties associated with an asycnhronous batch translation job including name, ID, status, source and target languages, input/output S3 buckets, and so on\.

## Request Syntax<a name="API_DescribeTextTranslationJob_RequestSyntax"></a>

```
{
   "[JobId](#Translate-DescribeTextTranslationJob-request-JobId)": "string"
}
```

## Request Parameters<a name="API_DescribeTextTranslationJob_RequestParameters"></a>

For information about the parameters that are common to all actions, see [Common Parameters](CommonParameters.md)\.

The request accepts the following data in JSON format\.

 ** [JobId](#API_DescribeTextTranslationJob_RequestSyntax) **   <a name="Translate-DescribeTextTranslationJob-request-JobId"></a>
The identifier that Amazon Translate generated for the job\. The [StartTextTranslationJob](API_StartTextTranslationJob.md) operation returns this identifier in its response\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 32\.  
Pattern: `^([\p{L}\p{Z}\p{N}_.:/=+\-%@]*)$`   
Required: Yes

## Response Syntax<a name="API_DescribeTextTranslationJob_ResponseSyntax"></a>

```
{
   "[TextTranslationJobProperties](#Translate-DescribeTextTranslationJob-response-TextTranslationJobProperties)": { 
      "[DataAccessRoleArn](API_TextTranslationJobProperties.md#Translate-Type-TextTranslationJobProperties-DataAccessRoleArn)": "string",
      "[EndTime](API_TextTranslationJobProperties.md#Translate-Type-TextTranslationJobProperties-EndTime)": number,
      "[InputDataConfig](API_TextTranslationJobProperties.md#Translate-Type-TextTranslationJobProperties-InputDataConfig)": { 
         "[ContentType](API_InputDataConfig.md#Translate-Type-InputDataConfig-ContentType)": "string",
         "[S3Uri](API_InputDataConfig.md#Translate-Type-InputDataConfig-S3Uri)": "string"
      },
      "[JobDetails](API_TextTranslationJobProperties.md#Translate-Type-TextTranslationJobProperties-JobDetails)": { 
         "[DocumentsWithErrorsCount](API_JobDetails.md#Translate-Type-JobDetails-DocumentsWithErrorsCount)": number,
         "[InputDocumentsCount](API_JobDetails.md#Translate-Type-JobDetails-InputDocumentsCount)": number,
         "[TranslatedDocumentsCount](API_JobDetails.md#Translate-Type-JobDetails-TranslatedDocumentsCount)": number
      },
      "[JobId](API_TextTranslationJobProperties.md#Translate-Type-TextTranslationJobProperties-JobId)": "string",
      "[JobName](API_TextTranslationJobProperties.md#Translate-Type-TextTranslationJobProperties-JobName)": "string",
      "[JobStatus](API_TextTranslationJobProperties.md#Translate-Type-TextTranslationJobProperties-JobStatus)": "string",
      "[Message](API_TextTranslationJobProperties.md#Translate-Type-TextTranslationJobProperties-Message)": "string",
      "[OutputDataConfig](API_TextTranslationJobProperties.md#Translate-Type-TextTranslationJobProperties-OutputDataConfig)": { 
         "[S3Uri](API_OutputDataConfig.md#Translate-Type-OutputDataConfig-S3Uri)": "string"
      },
      "[SourceLanguageCode](API_TextTranslationJobProperties.md#Translate-Type-TextTranslationJobProperties-SourceLanguageCode)": "string",
      "[SubmittedTime](API_TextTranslationJobProperties.md#Translate-Type-TextTranslationJobProperties-SubmittedTime)": number,
      "[TargetLanguageCodes](API_TextTranslationJobProperties.md#Translate-Type-TextTranslationJobProperties-TargetLanguageCodes)": [ "string" ],
      "[TerminologyNames](API_TextTranslationJobProperties.md#Translate-Type-TextTranslationJobProperties-TerminologyNames)": [ "string" ]
   }
}
```

## Response Elements<a name="API_DescribeTextTranslationJob_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [TextTranslationJobProperties](#API_DescribeTextTranslationJob_ResponseSyntax) **   <a name="Translate-DescribeTextTranslationJob-response-TextTranslationJobProperties"></a>
An object that contains the properties associated with an asynchronous batch translation job\.  
Type: [TextTranslationJobProperties](API_TextTranslationJobProperties.md) object

## Errors<a name="API_DescribeTextTranslationJob_Errors"></a>

For information about the errors that are common to all actions, see [Common Errors](CommonErrors.md)\.

 **InternalServerException**   
An internal server error occurred\. Retry your request\.  
HTTP Status Code: 500

 **ResourceNotFoundException**   
The resource you are looking for has not been found\. Review the resource you're looking for and see if a different resource will accomplish your needs before retrying the revised request\.  
HTTP Status Code: 400

 **TooManyRequestsException**   
 You have made too many requests within a short period of time\. Wait for a short time and then try your request again\.  
HTTP Status Code: 400

## See Also<a name="API_DescribeTextTranslationJob_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/translate-2017-07-01/DescribeTextTranslationJob) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/translate-2017-07-01/DescribeTextTranslationJob) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/translate-2017-07-01/DescribeTextTranslationJob) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/translate-2017-07-01/DescribeTextTranslationJob) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/translate-2017-07-01/DescribeTextTranslationJob) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/translate-2017-07-01/DescribeTextTranslationJob) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/translate-2017-07-01/DescribeTextTranslationJob) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/translate-2017-07-01/DescribeTextTranslationJob) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/translate-2017-07-01/DescribeTextTranslationJob) 