# ListTextTranslationJobs<a name="API_ListTextTranslationJobs"></a>

Gets a list of the batch translation jobs that you have submitted\.

## Request Syntax<a name="API_ListTextTranslationJobs_RequestSyntax"></a>

```
{
   "[Filter](#Translate-ListTextTranslationJobs-request-Filter)": { 
      "[JobName](API_TextTranslationJobFilter.md#Translate-Type-TextTranslationJobFilter-JobName)": "string",
      "[JobStatus](API_TextTranslationJobFilter.md#Translate-Type-TextTranslationJobFilter-JobStatus)": "string",
      "[SubmittedAfterTime](API_TextTranslationJobFilter.md#Translate-Type-TextTranslationJobFilter-SubmittedAfterTime)": number,
      "[SubmittedBeforeTime](API_TextTranslationJobFilter.md#Translate-Type-TextTranslationJobFilter-SubmittedBeforeTime)": number
   },
   "[MaxResults](#Translate-ListTextTranslationJobs-request-MaxResults)": number,
   "[NextToken](#Translate-ListTextTranslationJobs-request-NextToken)": "string"
}
```

## Request Parameters<a name="API_ListTextTranslationJobs_RequestParameters"></a>

For information about the parameters that are common to all actions, see [Common Parameters](CommonParameters.md)\.

The request accepts the following data in JSON format\.

 ** [Filter](#API_ListTextTranslationJobs_RequestSyntax) **   <a name="Translate-ListTextTranslationJobs-request-Filter"></a>
The parameters that specify which batch translation jobs to retrieve\. Filters include job name, job status, and submission time\. You can only set one filter at a time\.  
Type: [TextTranslationJobFilter](API_TextTranslationJobFilter.md) object  
Required: No

 ** [MaxResults](#API_ListTextTranslationJobs_RequestSyntax) **   <a name="Translate-ListTextTranslationJobs-request-MaxResults"></a>
The maximum number of results to return in each page\. The default value is 100\.  
Type: Integer  
Valid Range: Minimum value of 1\. Maximum value of 500\.  
Required: No

 ** [NextToken](#API_ListTextTranslationJobs_RequestSyntax) **   <a name="Translate-ListTextTranslationJobs-request-NextToken"></a>
The token to request the next page of results\.  
Type: String  
Length Constraints: Maximum length of 8192\.  
Pattern: `\p{ASCII}{0,8192}`   
Required: No

## Response Syntax<a name="API_ListTextTranslationJobs_ResponseSyntax"></a>

```
{
   "[NextToken](#Translate-ListTextTranslationJobs-response-NextToken)": "string",
   "[TextTranslationJobPropertiesList](#Translate-ListTextTranslationJobs-response-TextTranslationJobPropertiesList)": [ 
      { 
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
   ]
}
```

## Response Elements<a name="API_ListTextTranslationJobs_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [NextToken](#API_ListTextTranslationJobs_ResponseSyntax) **   <a name="Translate-ListTextTranslationJobs-response-NextToken"></a>
The token to use to retreive the next page of results\. This value is `null` when there are no more results to return\.  
Type: String  
Length Constraints: Maximum length of 8192\.  
Pattern: `\p{ASCII}{0,8192}` 

 ** [TextTranslationJobPropertiesList](#API_ListTextTranslationJobs_ResponseSyntax) **   <a name="Translate-ListTextTranslationJobs-response-TextTranslationJobPropertiesList"></a>
A list containing the properties of each job that is returned\.  
Type: Array of [TextTranslationJobProperties](API_TextTranslationJobProperties.md) objects

## Errors<a name="API_ListTextTranslationJobs_Errors"></a>

For information about the errors that are common to all actions, see [Common Errors](CommonErrors.md)\.

 **InternalServerException**   
An internal server error occurred\. Retry your request\.  
HTTP Status Code: 500

 **InvalidFilterException**   
The filter specified for the operation is invalid\. Specify a different filter\.  
HTTP Status Code: 400

 **InvalidRequestException**   
 The request that you made is invalid\. Check your request to determine why it's invalid and then retry the request\.   
HTTP Status Code: 400

 **TooManyRequestsException**   
 You have made too many requests within a short period of time\. Wait for a short time and then try your request again\.  
HTTP Status Code: 400

## See Also<a name="API_ListTextTranslationJobs_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/translate-2017-07-01/ListTextTranslationJobs) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/translate-2017-07-01/ListTextTranslationJobs) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/translate-2017-07-01/ListTextTranslationJobs) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/translate-2017-07-01/ListTextTranslationJobs) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/translate-2017-07-01/ListTextTranslationJobs) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/translate-2017-07-01/ListTextTranslationJobs) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/translate-2017-07-01/ListTextTranslationJobs) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/translate-2017-07-01/ListTextTranslationJobs) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/translate-2017-07-01/ListTextTranslationJobs) 