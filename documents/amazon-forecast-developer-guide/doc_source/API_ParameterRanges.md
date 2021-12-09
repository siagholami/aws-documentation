# ParameterRanges<a name="API_ParameterRanges"></a>

Specifies the categorical, continuous, and integer hyperparameters, and their ranges of tunable values\. The range of tunable values determines which values that a hyperparameter tuning job can choose for the specified hyperparameter\. This object is part of the [HyperParameterTuningJobConfig](API_HyperParameterTuningJobConfig.md) object\.

## Contents<a name="API_ParameterRanges_Contents"></a>

 **CategoricalParameterRanges**   <a name="forecast-Type-ParameterRanges-CategoricalParameterRanges"></a>
Specifies the tunable range for each categorical hyperparameter\.  
Type: Array of [CategoricalParameterRange](API_CategoricalParameterRange.md) objects  
Array Members: Minimum number of 1 item\. Maximum number of 20 items\.  
Required: No

 **ContinuousParameterRanges**   <a name="forecast-Type-ParameterRanges-ContinuousParameterRanges"></a>
Specifies the tunable range for each continuous hyperparameter\.  
Type: Array of [ContinuousParameterRange](API_ContinuousParameterRange.md) objects  
Array Members: Minimum number of 1 item\. Maximum number of 20 items\.  
Required: No

 **IntegerParameterRanges**   <a name="forecast-Type-ParameterRanges-IntegerParameterRanges"></a>
Specifies the tunable range for each integer hyperparameter\.  
Type: Array of [IntegerParameterRange](API_IntegerParameterRange.md) objects  
Array Members: Minimum number of 1 item\. Maximum number of 20 items\.  
Required: No

## See Also<a name="API_ParameterRanges_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/ParameterRanges) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/ParameterRanges) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/ParameterRanges) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/ParameterRanges) 