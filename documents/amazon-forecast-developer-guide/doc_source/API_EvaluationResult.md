# EvaluationResult<a name="API_EvaluationResult"></a>

The results of evaluating an algorithm\. Returned as part of the [GetAccuracyMetrics](API_GetAccuracyMetrics.md) response\.

## Contents<a name="API_EvaluationResult_Contents"></a>

 **AlgorithmArn**   <a name="forecast-Type-EvaluationResult-AlgorithmArn"></a>
The Amazon Resource Name \(ARN\) of the algorithm that was evaluated\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\-\_\.\/\:]+$`   
Required: No

 **TestWindows**   <a name="forecast-Type-EvaluationResult-TestWindows"></a>
The array of test windows used for evaluating the algorithm\. The `NumberOfBacktestWindows` from the [EvaluationParameters](API_EvaluationParameters.md) object determines the number of windows in the array\.  
Type: Array of [WindowSummary](API_WindowSummary.md) objects  
Required: No

## See Also<a name="API_EvaluationResult_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/EvaluationResult) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/EvaluationResult) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/EvaluationResult) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/EvaluationResult) 