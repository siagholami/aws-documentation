# Metrics<a name="API_Metrics"></a>

Provides metrics that are used to evaluate the performance of a predictor\. This object is part of the [WindowSummary](API_WindowSummary.md) object\.

## Contents<a name="API_Metrics_Contents"></a>

 **RMSE**   <a name="forecast-Type-Metrics-RMSE"></a>
The root mean square error \(RMSE\)\.  
Type: Double  
Required: No

 **WeightedQuantileLosses**   <a name="forecast-Type-Metrics-WeightedQuantileLosses"></a>
An array of weighted quantile losses\. Quantiles divide a probability distribution into regions of equal probability\. The distribution in this case is the loss function\.  
Type: Array of [WeightedQuantileLoss](API_WeightedQuantileLoss.md) objects  
Required: No

## See Also<a name="API_Metrics_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/Metrics) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/Metrics) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/Metrics) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/Metrics) 