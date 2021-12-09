# WeightedQuantileLoss<a name="API_WeightedQuantileLoss"></a>

The weighted loss value for a quantile\. This object is part of the [Metrics](API_Metrics.md) object\.

## Contents<a name="API_WeightedQuantileLoss_Contents"></a>

 **LossValue**   <a name="forecast-Type-WeightedQuantileLoss-LossValue"></a>
The difference between the predicted value and the actual value over the quantile, weighted \(normalized\) by dividing by the sum over all quantiles\.  
Type: Double  
Required: No

 **Quantile**   <a name="forecast-Type-WeightedQuantileLoss-Quantile"></a>
The quantile\. Quantiles divide a probability distribution into regions of equal probability\. For example, if the distribution was divided into 5 regions of equal probability, the quantiles would be 0\.2, 0\.4, 0\.6, and 0\.8\.  
Type: Double  
Required: No

## See Also<a name="API_WeightedQuantileLoss_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/WeightedQuantileLoss) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/WeightedQuantileLoss) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/WeightedQuantileLoss) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/WeightedQuantileLoss) 