# BatchInferenceJobSummary<a name="API_BatchInferenceJobSummary"></a>

A truncated version of the [BatchInferenceJob](API_BatchInferenceJob.md) datatype\. The [ListBatchInferenceJobs](API_ListBatchInferenceJobs.md) operation returns a list of batch inference job summaries\.

## Contents<a name="API_BatchInferenceJobSummary_Contents"></a>

 **batchInferenceJobArn**   <a name="personalize-Type-BatchInferenceJobSummary-batchInferenceJobArn"></a>
The Amazon Resource Name \(ARN\) of the batch inference job\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

 **creationDateTime**   <a name="personalize-Type-BatchInferenceJobSummary-creationDateTime"></a>
The time at which the batch inference job was created\.  
Type: Timestamp  
Required: No

 **failureReason**   <a name="personalize-Type-BatchInferenceJobSummary-failureReason"></a>
If the batch inference job failed, the reason for the failure\.  
Type: String  
Required: No

 **jobName**   <a name="personalize-Type-BatchInferenceJobSummary-jobName"></a>
The name of the batch inference job\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z0-9][a-zA-Z0-9\-_]*`   
Required: No

 **lastUpdatedDateTime**   <a name="personalize-Type-BatchInferenceJobSummary-lastUpdatedDateTime"></a>
The time at which the batch inference job was last updated\.  
Type: Timestamp  
Required: No

 **solutionVersionArn**   <a name="personalize-Type-BatchInferenceJobSummary-solutionVersionArn"></a>
The ARN of the solution version used by the batch inference job\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

 **status**   <a name="personalize-Type-BatchInferenceJobSummary-status"></a>
The status of the batch inference job\. The status is one of the following values:  
+ PENDING
+ IN PROGRESS
+ ACTIVE
+ CREATE FAILED
Type: String  
Length Constraints: Maximum length of 256\.  
Required: No

## See Also<a name="API_BatchInferenceJobSummary_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/BatchInferenceJobSummary) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/BatchInferenceJobSummary) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/BatchInferenceJobSummary) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/BatchInferenceJobSummary) 