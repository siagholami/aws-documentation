# BatchPolicy<a name="API_BatchPolicy"></a>

Information about the batch policy\.

## Contents<a name="API_BatchPolicy_Contents"></a>

 **maxConcurrency**   <a name="robomaker-Type-BatchPolicy-maxConcurrency"></a>
The number of active simulation jobs create as part of the batch that can be in an active state at the same time\.   
Active states include: `Pending`,`Preparing`, `Running`, `Restarting`, `RunningFailed` and `Terminating`\. All other states are terminal states\.   
Type: Integer  
Required: No

 **timeoutInSeconds**   <a name="robomaker-Type-BatchPolicy-timeoutInSeconds"></a>
The amount of time, in seconds, to wait for the batch to complete\.   
If a batch times out, and there are pending requests that were failing due to an internal failure \(like `InternalServiceError`\), they will be moved to the failed list and the batch status will be `Failed`\. If the pending requests were failing for any other reason, the failed pending requests will be moved to the failed list and the batch status will be `TimedOut`\.   
Type: Long  
Required: No

## See Also<a name="API_BatchPolicy_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/BatchPolicy) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/BatchPolicy) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/BatchPolicy) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/BatchPolicy) 