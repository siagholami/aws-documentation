# Amazon Translate API Permissions: Actions, Resources, and Conditions Reference<a name="translate-api-permissions-ref"></a>

Use the following table as a reference when writing a permissions policy that you can attach to an IAM identity \(an identity\-based policy\)\. The list includes each Amazon Translate API operation, the corresponding action for which you can grant permissions, and the AWS resource for which you can grant the permissions\. You specify the actions in the policy's `Action` field, and you specify the resource value in the policy's `Resource` field\. 

To express conditions, you can use AWS\-wide condition keys in your Amazon Translate policies\. For a complete list of AWS\-wide keys, see [Available Keys](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements.html#AvailableKeys) in the *IAM User Guide*\. 

**Note**  
To specify an action, use the `translate:` prefix followed by the API operation name, for example, `translate:TranslateText`\.

If you see an expand arrow \(**↗**\) in the upper\-right corner of the table, you can open the table in a new window\. To close the window, choose the close button \(**X**\) in the lower\-right corner\.


**Amazon Translate API and Required Permissions for Actions**  

| Amazon Translate API Operations | Required Permissions \(API Actions\) | Resources | 
| --- | --- | --- | 
| [TranslateText](API_TranslateText.md) – Use to specify the source language \. |  `translate:TranslateText`  | \* | 
| [TranslateText](API_TranslateText.md) – Use for automatic source language detection\. |  `translate:TranslateText` `comprehend:DetectDominantLanguage`  | \* | 
| [DeleteTerminology](API_DeleteTerminology.md) – Use for deleting a custom terminology from your account\. |  `translate:DeleteTerminology`  | \* | 
| [GetTerminology](API_GetTerminology.md) – Use for retrieving information about a custom terminology associated with your account\. |  `translate:GetTerminology` If the terminology uses KMS encryption, it also requires that the following permissions be set in the KMS key policy \(not an IAM policy\): `kms:Decrypt`  | \* | 
| [ImportTerminology](API_ImportTerminology.md) – Use for importing a custom terminology to your account\. |  `translate:ImportTerminology` If the terminology uses AWS KMS encryption, it also requires that the following permissions be set in the AWS KMS key policy \(not an IAM policy\): `kms:CreateGrant` `kms:DescribeKey` `kms:GenerateDataKey` `kms:RetireGrant`  | \* | 
| [ListTerminologies](API_ListTerminologies.md) – Use to list custom terminologies in your account\. |  `translate:ListTerminology`  | \* | 
| [StartTextTranslationJob](API_StartTextTranslationJob.md) \- Use to start an [asynchronous batch translation job\.](async.md)  |  `translate:StartTextTranslationJob` You also need to give an IAM role read permission to the Amazon S3 folder that contains your input files, and read and write permissions to the folder that will contain your output files\.  | \* | 
| [ DescribeTextTranslationJob APIrequestsDescribeTextTranslationJob  Gets the properties associated with an asycnhronous batch translation job including name, ID, status, source and target languages, input/output S3 buckets, and so on\.  Request Syntax  

```
{
   "[JobId](#Translate-DescribeTextTranslationJob-request-JobId)": "string"
}
```   Request Parameters  For information about the parameters that are common to all actions, see [Common Parameters](CommonParameters.md)\. The request accepts the following data in JSON format\.  

 ** [JobId](#API_DescribeTextTranslationJob_RequestSyntax) **   <a name="Translate-DescribeTextTranslationJob-request-JobId"></a>
The identifier that Amazon Translate generated for the job\. The [StartTextTranslationJob](API_StartTextTranslationJob.md) operation returns this identifier in its response\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 32\.  
Pattern: `^([\p{L}\p{Z}\p{N}_.:/=+\-%@]*)$`   
Required: Yes    Response Syntax  

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
```   Response Elements  If the action is successful, the service sends back an HTTP 200 response\. The following data is returned in JSON format by the service\.  

 ** [TextTranslationJobProperties](#API_DescribeTextTranslationJob_ResponseSyntax) **   <a name="Translate-DescribeTextTranslationJob-response-TextTranslationJobProperties"></a>
An object that contains the properties associated with an asynchronous batch translation job\.  
Type: [TextTranslationJobProperties](API_TextTranslationJobProperties.md) object    Errors  For information about the errors that are common to all actions, see [Common Errors](CommonErrors.md)\.  

 **InternalServerException**   
An internal server error occurred\. Retry your request\.  
HTTP Status Code: 500 

 **ResourceNotFoundException**   
The resource you are looking for has not been found\. Review the resource you're looking for and see if a different resource will accomplish your needs before retrying the revised request\.  
HTTP Status Code: 400 

 **TooManyRequestsException**   
 You have made too many requests within a short period of time\. Wait for a short time and then try your request again\.  
HTTP Status Code: 400    See Also   For more information about using this API in one of the language\-specific AWS SDKs, see the following:    [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/translate-2017-07-01/DescribeTextTranslationJob)     [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/translate-2017-07-01/DescribeTextTranslationJob)     [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/translate-2017-07-01/DescribeTextTranslationJob)     [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/translate-2017-07-01/DescribeTextTranslationJob)     [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/translate-2017-07-01/DescribeTextTranslationJob)     [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/translate-2017-07-01/DescribeTextTranslationJob)     [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/translate-2017-07-01/DescribeTextTranslationJob)     [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/translate-2017-07-01/DescribeTextTranslationJob)     [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/translate-2017-07-01/DescribeTextTranslationJob)    ](API_DescribeTextTranslationJob.md) \- Use to get details on a batch translation job\. | `translate:DescribeTextTranslationJob` | \* | 
| [ListTextTranslationJobs](API_ListTextTranslationJobs.md) \- Use to list all batch translation jobs in your account in the current Region\. | translate:ListTextTranslationJobs | \* | 
| [ StopTextTranslationJob APIrequestsStopTextTranslationJob  Stops an asynchronous batch translation job that is in progress\. If the job's state is `IN_PROGRESS`, the job will be marked for termination and put into the `STOP_REQUESTED` state\. If the job completes before it can be stopped, it is put into the `COMPLETED` state\. Otherwise, the job is put into the `STOPPED` state\. Asynchronous batch translation jobs are started with the [StartTextTranslationJob](API_StartTextTranslationJob.md) operation\. You can use the [DescribeTextTranslationJob](API_DescribeTextTranslationJob.md) or [ListTextTranslationJobs](API_ListTextTranslationJobs.md) operations to get a batch translation job's `JobId`\.  Request Syntax  

```
{
   "[JobId](#Translate-StopTextTranslationJob-request-JobId)": "string"
}
```   Request Parameters  For information about the parameters that are common to all actions, see [Common Parameters](CommonParameters.md)\. The request accepts the following data in JSON format\.  

 ** [JobId](#API_StopTextTranslationJob_RequestSyntax) **   <a name="Translate-StopTextTranslationJob-request-JobId"></a>
The job ID of the job to be stopped\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 32\.  
Pattern: `^([\p{L}\p{Z}\p{N}_.:/=+\-%@]*)$`   
Required: Yes    Response Syntax  

```
{
   "[JobId](#Translate-StopTextTranslationJob-response-JobId)": "string",
   "[JobStatus](#Translate-StopTextTranslationJob-response-JobStatus)": "string"
}
```   Response Elements  If the action is successful, the service sends back an HTTP 200 response\. The following data is returned in JSON format by the service\.  

 ** [JobId](#API_StopTextTranslationJob_ResponseSyntax) **   <a name="Translate-StopTextTranslationJob-response-JobId"></a>
The job ID of the stopped batch translation job\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 32\.  
Pattern: `^([\p{L}\p{Z}\p{N}_.:/=+\-%@]*)$`  

 ** [JobStatus](#API_StopTextTranslationJob_ResponseSyntax) **   <a name="Translate-StopTextTranslationJob-response-JobStatus"></a>
The status of the designated job\. Upon successful completion, the job's status will be `STOPPED`\.  
Type: String  
Valid Values:` SUBMITTED | IN_PROGRESS | COMPLETED | COMPLETED_WITH_ERROR | FAILED | STOP_REQUESTED | STOPPED`     Errors  For information about the errors that are common to all actions, see [Common Errors](CommonErrors.md)\.  

 **InternalServerException**   
An internal server error occurred\. Retry your request\.  
HTTP Status Code: 500 

 **ResourceNotFoundException**   
The resource you are looking for has not been found\. Review the resource you're looking for and see if a different resource will accomplish your needs before retrying the revised request\.  
HTTP Status Code: 400 

 **TooManyRequestsException**   
 You have made too many requests within a short period of time\. Wait for a short time and then try your request again\.  
HTTP Status Code: 400    See Also   For more information about using this API in one of the language\-specific AWS SDKs, see the following:    [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/translate-2017-07-01/StopTextTranslationJob)     [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/translate-2017-07-01/StopTextTranslationJob)     [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/translate-2017-07-01/StopTextTranslationJob)     [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/translate-2017-07-01/StopTextTranslationJob)     [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/translate-2017-07-01/StopTextTranslationJob)     [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/translate-2017-07-01/StopTextTranslationJob)     [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/translate-2017-07-01/StopTextTranslationJob)     [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/translate-2017-07-01/StopTextTranslationJob)     [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/translate-2017-07-01/StopTextTranslationJob)    ](API_StopTextTranslationJob.md) \- Use to stop a batch translation job\. | translate:StopTextTranslationJob | \* | 