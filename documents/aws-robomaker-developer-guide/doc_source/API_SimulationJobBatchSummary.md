# SimulationJobBatchSummary<a name="API_SimulationJobBatchSummary"></a>

Information about a simulation job batch\.

## Contents<a name="API_SimulationJobBatchSummary_Contents"></a>

 **arn**   <a name="robomaker-Type-SimulationJobBatchSummary-arn"></a>
The Amazon Resource Name \(ARN\) of the batch\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `arn:.*`   
Required: No

 **createdAt**   <a name="robomaker-Type-SimulationJobBatchSummary-createdAt"></a>
The time, in milliseconds since the epoch, when the simulation job batch was created\.  
Type: Timestamp  
Required: No

 **createdRequestCount**   <a name="robomaker-Type-SimulationJobBatchSummary-createdRequestCount"></a>
The number of created simulation job requests\.  
Type: Integer  
Required: No

 **failedRequestCount**   <a name="robomaker-Type-SimulationJobBatchSummary-failedRequestCount"></a>
The number of failed simulation job requests\.  
Type: Integer  
Required: No

 **lastUpdatedAt**   <a name="robomaker-Type-SimulationJobBatchSummary-lastUpdatedAt"></a>
The time, in milliseconds since the epoch, when the simulation job batch was last updated\.  
Type: Timestamp  
Required: No

 **pendingRequestCount**   <a name="robomaker-Type-SimulationJobBatchSummary-pendingRequestCount"></a>
The number of pending simulation job requests\.  
Type: Integer  
Required: No

 **status**   <a name="robomaker-Type-SimulationJobBatchSummary-status"></a>
The status of the simulation job batch\.    
Pending  
The simulation job batch request is pending\.  
InProgress  
The simulation job batch is in progress\.   
Failed  
The simulation job batch failed\. One or more simulation job requests could not be completed due to an internal failure \(like `InternalServiceError`\)\. See `failureCode` and `failureReason` for more information\.  
Completed  
The simulation batch job completed\. A batch is complete when \(1\) there are no pending simulation job requests in the batch and none of the failed simulation job requests are due to `InternalServiceError` and \(2\) when all created simulation jobs have reached a terminal state \(for example, `Completed` or `Failed`\)\.   
Canceled  
The simulation batch job was cancelled\.  
Canceling  
The simulation batch job is being cancelled\.  
Completing  
The simulation batch job is completing\.  
TimingOut  
The simulation job batch is timing out\.  
If a batch timing out, and there are pending requests that were failing due to an internal failure \(like `InternalServiceError`\), the batch status will be `Failed`\. If there are no such failing request, the batch status will be `TimedOut`\.   
TimedOut  
The simulation batch job timed out\.
Type: String  
Valid Values:` Pending | InProgress | Failed | Completed | Canceled | Canceling | Completing | TimingOut | TimedOut`   
Required: No

## See Also<a name="API_SimulationJobBatchSummary_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/SimulationJobBatchSummary) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/SimulationJobBatchSummary) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/SimulationJobBatchSummary) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/SimulationJobBatchSummary) 