# HyperParameterTuningJobConfig<a name="API_HyperParameterTuningJobConfig"></a>

Configuration information for a hyperparameter tuning job\. You specify this object in the [CreatePredictor](API_CreatePredictor.md) request\.

A *hyperparameter* is a parameter that governs the model training process\. You set hyperparameters before training starts, unlike model parameters, which are determined during training\. The values of the hyperparameters effect which values are chosen for the model parameters\.

In a *hyperparameter tuning job*, Amazon Forecast chooses the set of hyperparameter values that optimize a specified metric\. Forecast accomplishes this by running many training jobs over a range of hyperparameter values\. The optimum set of values depends on the algorithm, the training data, and the specified metric objective\.

## Contents<a name="API_HyperParameterTuningJobConfig_Contents"></a>

 **ParameterRanges**   <a name="forecast-Type-HyperParameterTuningJobConfig-ParameterRanges"></a>
Specifies the ranges of valid values for the hyperparameters\.  
Type: [ParameterRanges](API_ParameterRanges.md) object  
Required: No

## See Also<a name="API_HyperParameterTuningJobConfig_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/HyperParameterTuningJobConfig) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/HyperParameterTuningJobConfig) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/HyperParameterTuningJobConfig) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/HyperParameterTuningJobConfig) 