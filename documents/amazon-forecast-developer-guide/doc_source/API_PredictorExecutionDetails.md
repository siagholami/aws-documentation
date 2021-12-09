# PredictorExecutionDetails<a name="API_PredictorExecutionDetails"></a>

Contains details on the backtests performed to evaluate the accuracy of the predictor\. The tests are returned in descending order of accuracy, with the most accurate backtest appearing first\. You specify the number of backtests to perform when you call the [CreatePredictor](API_CreatePredictor.md) operation\.

## Contents<a name="API_PredictorExecutionDetails_Contents"></a>

 **PredictorExecutions**   <a name="forecast-Type-PredictorExecutionDetails-PredictorExecutions"></a>
An array of the backtests performed to evaluate the accuracy of the predictor against a particular algorithm\. The `NumberOfBacktestWindows` from the [EvaluationParameters](API_EvaluationParameters.md) object determines the number of windows in the array\.  
Type: Array of [PredictorExecution](API_PredictorExecution.md) objects  
Array Members: Minimum number of 1 item\. Maximum number of 5 items\.  
Required: No

## See Also<a name="API_PredictorExecutionDetails_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/PredictorExecutionDetails) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/PredictorExecutionDetails) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/PredictorExecutionDetails) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/PredictorExecutionDetails) 