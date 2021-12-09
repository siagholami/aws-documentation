# StopTextTranslationJob<a name="API_StopTextTranslationJob"></a>

Stops an asynchronous batch translation job that is in progress\.

If the job's state is `IN_PROGRESS`, the job will be marked for termination and put into the `STOP_REQUESTED` state\. If the job completes before it can be stopped, it is put into the `COMPLETED` state\. Otherwise, the job is put into the `STOPPED` state\.

Asynchronous batch translation jobs are started with the [StartTextTranslationJob](API_StartTextTranslationJob.md) operation\. You can use the [DescribeTextTranslationJob](API_DescribeTextTranslationJob.md) or [ListTextTranslationJobs](API_ListTextTranslationJobs.md) operations to get a batch translation job's `JobId`\.

## Request Syntax<a name="API_StopTextTranslationJob_RequestSyntax"></a>

```
{
   "[JobId](#Translate-StopTextTranslationJob-request-JobId)": "string"
}
```

## Request Parameters<a name="API_StopTextTranslationJob_RequestParameters"></a>

For information about the parameters that are common to all actions, see [Common Parameters](CommonParameters.md)\.

The request accepts the following data in JSON format\.

 ** [JobId](#API_StopTextTranslationJob_RequestSyntax) **   <a name="Translate-StopTextTranslationJob-request-JobId"></a>
The job ID of the job to be stopped\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 32\.  
Pattern: `^([\p{L}\p{Z}\p{N}_.:/=+\-%@]*)$`   
Required: Yes

## Response Syntax<a name="API_StopTextTranslationJob_ResponseSyntax"></a>

```
{
   "[JobId](#Translate-StopTextTranslationJob-response-JobId)": "string",
   "[JobStatus](#Translate-StopTextTranslationJob-response-JobStatus)": "string"
}
```

## Response Elements<a name="API_StopTextTranslationJob_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [JobId](#API_StopTextTranslationJob_ResponseSyntax) **   <a name="Translate-StopTextTranslationJob-response-JobId"></a>
The job ID of the stopped batch translation job\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 32\.  
Pattern: `^([\p{L}\p{Z}\p{N}_.:/=+\-%@]*)$` 

 ** [JobStatus](#API_StopTextTranslationJob_ResponseSyntax) **   <a name="Translate-StopTextTranslationJob-response-JobStatus"></a>
The status of the designated job\. Upon successful completion, the job's status will be `STOPPED`\.  
Type: String  
Valid Values:` SUBMITTED | IN_PROGRESS | COMPLETED | COMPLETED_WITH_ERROR | FAILED | STOP_REQUESTED | STOPPED` 

## Errors<a name="API_StopTextTranslationJob_Errors"></a>

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

## See Also<a name="API_StopTextTranslationJob_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/translate-2017-07-01/StopTextTranslationJob) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/translate-2017-07-01/StopTextTranslationJob) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/translate-2017-07-01/StopTextTranslationJob) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/translate-2017-07-01/StopTextTranslationJob) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/translate-2017-07-01/StopTextTranslationJob) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/translate-2017-07-01/StopTextTranslationJob) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/translate-2017-07-01/StopTextTranslationJob) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/translate-2017-07-01/StopTextTranslationJob) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/translate-2017-07-01/StopTextTranslationJob) 