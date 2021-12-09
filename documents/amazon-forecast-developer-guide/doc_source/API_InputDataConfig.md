# InputDataConfig<a name="API_InputDataConfig"></a>

The data used to train a predictor\. The data includes a dataset group and any supplementary features\. You specify this object in the [CreatePredictor](API_CreatePredictor.md) request\.

## Contents<a name="API_InputDataConfig_Contents"></a>

 **DatasetGroupArn**   <a name="forecast-Type-InputDataConfig-DatasetGroupArn"></a>
The Amazon Resource Name \(ARN\) of the dataset group\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\-\_\.\/\:]+$`   
Required: Yes

 **SupplementaryFeatures**   <a name="forecast-Type-InputDataConfig-SupplementaryFeatures"></a>
An array of supplementary features\. The only supported feature is a holiday calendar\.  
Type: Array of [SupplementaryFeature](API_SupplementaryFeature.md) objects  
Array Members: Fixed number of 1 item\.  
Required: No

## See Also<a name="API_InputDataConfig_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/InputDataConfig) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/InputDataConfig) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/InputDataConfig) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/InputDataConfig) 