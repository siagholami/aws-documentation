# PredictorExecution<a name="API_PredictorExecution"></a>

The algorithm used to perform a backtest and the status of those tests\.

## Contents<a name="API_PredictorExecution_Contents"></a>

 **AlgorithmArn**   <a name="forecast-Type-PredictorExecution-AlgorithmArn"></a>
The ARN of the algorithm used to test the predictor\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\-\_\.\/\:]+$`   
Required: No

 **TestWindows**   <a name="forecast-Type-PredictorExecution-TestWindows"></a>
An array of test windows used to evaluate the algorithm\. The `NumberOfBacktestWindows` from the [EvaluationParameters](API_EvaluationParameters.md) object determines the number of windows in the array\.  
Type: Array of [TestWindowSummary](API_TestWindowSummary.md) objects  
Required: No

## See Also<a name="API_PredictorExecution_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/PredictorExecution) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/PredictorExecution) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/PredictorExecution) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/PredictorExecution) 