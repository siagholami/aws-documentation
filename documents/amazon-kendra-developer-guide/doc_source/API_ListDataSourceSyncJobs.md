--------

--------

# ListDataSourceSyncJobs<a name="API_ListDataSourceSyncJobs"></a>

Gets statistics about synchronizing Amazon Kendra with a data source\.

## Request Syntax<a name="API_ListDataSourceSyncJobs_RequestSyntax"></a>

```
{
   "Id": "string",
   "IndexId": "string",
   "MaxResults": number,
   "NextToken": "string",
   "StartTimeFilter": { 
      "EndTime": number,
      "StartTime": number
   },
   "StatusFilter": "string"
}
```

## Request Parameters<a name="API_ListDataSourceSyncJobs_RequestParameters"></a>

For information about the parameters that are common to all actions, see [Common Parameters](CommonParameters.md)\.

The request accepts the following data in JSON format\.

 ** [Id](#API_ListDataSourceSyncJobs_RequestSyntax) **   <a name="Kendra-ListDataSourceSyncJobs-request-Id"></a>
The identifier of the data source\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 100\.  
Pattern: `[a-zA-Z0-9][a-zA-Z0-9_-]*`   
Required: Yes

 ** [IndexId](#API_ListDataSourceSyncJobs_RequestSyntax) **   <a name="Kendra-ListDataSourceSyncJobs-request-IndexId"></a>
The identifier of the index that contains the data source\.  
Type: String  
Length Constraints: Fixed length of 36\.  
Pattern: `[a-zA-Z0-9][a-zA-Z0-9-]*`   
Required: Yes

 ** [MaxResults](#API_ListDataSourceSyncJobs_RequestSyntax) **   <a name="Kendra-ListDataSourceSyncJobs-request-MaxResults"></a>
The maximum number of synchronization jobs to return in the response\. If there are fewer results in the list, this response contains only the actual results\.  
Type: Integer  
Valid Range: Minimum value of 1\. Maximum value of 10\.  
Required: No

 ** [NextToken](#API_ListDataSourceSyncJobs_RequestSyntax) **   <a name="Kendra-ListDataSourceSyncJobs-request-NextToken"></a>
If the result of the previous request to `GetDataSourceSyncJobHistory` was truncated, include the `NextToken` to fetch the next set of jobs\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 800\.  
Required: No

 ** [StartTimeFilter](#API_ListDataSourceSyncJobs_RequestSyntax) **   <a name="Kendra-ListDataSourceSyncJobs-request-StartTimeFilter"></a>
When specified, the synchronization jobs returned in the list are limited to jobs between the specified dates\.   
Type: [TimeRange](API_TimeRange.md) object  
Required: No

 ** [StatusFilter](#API_ListDataSourceSyncJobs_RequestSyntax) **   <a name="Kendra-ListDataSourceSyncJobs-request-StatusFilter"></a>
When specified, only returns synchronization jobs with the `Status` field equal to the specified status\.  
Type: String  
Valid Values:` FAILED | SUCCEEDED | SYNCING | INCOMPLETE | STOPPING | ABORTED | SYNCING_INDEXING`   
Required: No

## Response Syntax<a name="API_ListDataSourceSyncJobs_ResponseSyntax"></a>

```
{
   "History": [ 
      { 
         "DataSourceErrorCode": "string",
         "EndTime": number,
         "ErrorCode": "string",
         "ErrorMessage": "string",
         "ExecutionId": "string",
         "Metrics": { 
            "DocumentsAdded": "string",
            "DocumentsDeleted": "string",
            "DocumentsFailed": "string",
            "DocumentsModified": "string",
            "DocumentsScanned": "string"
         },
         "StartTime": number,
         "Status": "string"
      }
   ],
   "NextToken": "string"
}
```

## Response Elements<a name="API_ListDataSourceSyncJobs_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [History](#API_ListDataSourceSyncJobs_ResponseSyntax) **   <a name="Kendra-ListDataSourceSyncJobs-response-History"></a>
A history of synchronization jobs for the data source\.  
Type: Array of [DataSourceSyncJob](API_DataSourceSyncJob.md) objects

 ** [NextToken](#API_ListDataSourceSyncJobs_ResponseSyntax) **   <a name="Kendra-ListDataSourceSyncJobs-response-NextToken"></a>
The `GetDataSourceSyncJobHistory` operation returns a page of vocabularies at a time\. The maximum size of the page is set by the `MaxResults` parameter\. If there are more jobs in the list than the page size, Amazon Kendra returns the NextPage token\. Include the token in the next request to the `GetDataSourceSyncJobHistory` operation to return in the next page of jobs\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 800\.

## Errors<a name="API_ListDataSourceSyncJobs_Errors"></a>

For information about the errors that are common to all actions, see [Common Errors](CommonErrors.md)\.

 **AccessDeniedException**   
HTTP Status Code: 400

 **ConflictException**   
HTTP Status Code: 400

 **InternalServerException**   
HTTP Status Code: 500

 **ResourceNotFoundException**   
HTTP Status Code: 400

 **ThrottlingException**   
HTTP Status Code: 400

 **ValidationException**   
HTTP Status Code: 400

## See Also<a name="API_ListDataSourceSyncJobs_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/kendra-2019-02-03/ListDataSourceSyncJobs) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/kendra-2019-02-03/ListDataSourceSyncJobs) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/ListDataSourceSyncJobs) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/ListDataSourceSyncJobs) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/ListDataSourceSyncJobs) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/kendra-2019-02-03/ListDataSourceSyncJobs) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/kendra-2019-02-03/ListDataSourceSyncJobs) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/kendra-2019-02-03/ListDataSourceSyncJobs) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/ListDataSourceSyncJobs) 