# ListBatchInferenceJobs<a name="API_ListBatchInferenceJobs"></a>

Gets a list of the batch inference jobs that have been performed off of a solution version\.

## Request Syntax<a name="API_ListBatchInferenceJobs_RequestSyntax"></a>

```
{
   "maxResults": number,
   "nextToken": "string",
   "solutionVersionArn": "string"
}
```

## Request Parameters<a name="API_ListBatchInferenceJobs_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [maxResults](#API_ListBatchInferenceJobs_RequestSyntax) **   <a name="personalize-ListBatchInferenceJobs-request-maxResults"></a>
The maximum number of batch inference job results to return in each page\. The default value is 100\.  
Type: Integer  
Valid Range: Minimum value of 1\. Maximum value of 100\.  
Required: No

 ** [nextToken](#API_ListBatchInferenceJobs_RequestSyntax) **   <a name="personalize-ListBatchInferenceJobs-request-nextToken"></a>
The token to request the next page of results\.  
Type: String  
Length Constraints: Maximum length of 1300\.  
Required: No

 ** [solutionVersionArn](#API_ListBatchInferenceJobs_RequestSyntax) **   <a name="personalize-ListBatchInferenceJobs-request-solutionVersionArn"></a>
The Amazon Resource Name \(ARN\) of the solution version from which the batch inference jobs were created\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

## Response Syntax<a name="API_ListBatchInferenceJobs_ResponseSyntax"></a>

```
{
   "batchInferenceJobs": [ 
      { 
         "batchInferenceJobArn": "string",
         "creationDateTime": number,
         "failureReason": "string",
         "jobName": "string",
         "lastUpdatedDateTime": number,
         "solutionVersionArn": "string",
         "status": "string"
      }
   ],
   "nextToken": "string"
}
```

## Response Elements<a name="API_ListBatchInferenceJobs_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [batchInferenceJobs](#API_ListBatchInferenceJobs_ResponseSyntax) **   <a name="personalize-ListBatchInferenceJobs-response-batchInferenceJobs"></a>
A list containing information on each job that is returned\.  
Type: Array of [BatchInferenceJobSummary](API_BatchInferenceJobSummary.md) objects  
Array Members: Maximum number of 100 items\.

 ** [nextToken](#API_ListBatchInferenceJobs_ResponseSyntax) **   <a name="personalize-ListBatchInferenceJobs-response-nextToken"></a>
The token to use to retreive the next page of results\. The value is `null` when there are no more results to return\.  
Type: String  
Length Constraints: Maximum length of 1300\.

## Errors<a name="API_ListBatchInferenceJobs_Errors"></a>

 **InvalidInputException**   
Provide a valid value for the field or parameter\.  
HTTP Status Code: 400

 **InvalidNextTokenException**   
The token is not valid\.  
HTTP Status Code: 400

## See Also<a name="API_ListBatchInferenceJobs_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/personalize-2018-05-22/ListBatchInferenceJobs) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/personalize-2018-05-22/ListBatchInferenceJobs) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/ListBatchInferenceJobs) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/ListBatchInferenceJobs) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/ListBatchInferenceJobs) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/personalize-2018-05-22/ListBatchInferenceJobs) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/personalize-2018-05-22/ListBatchInferenceJobs) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/personalize-2018-05-22/ListBatchInferenceJobs) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/ListBatchInferenceJobs) 