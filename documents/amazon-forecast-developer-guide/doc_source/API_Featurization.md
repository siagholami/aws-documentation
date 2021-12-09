# Featurization<a name="API_Featurization"></a>

Provides featurization \(transformation\) information for a dataset field\. This object is part of the [FeaturizationConfig](API_FeaturizationConfig.md) object\.

For example:

 `{` 

 `"AttributeName": "demand",` 

 `FeaturizationPipeline [ {` 

 `"FeaturizationMethodName": "filling",` 

 `"FeaturizationMethodParameters": {"aggregation": "avg", "backfill": "nan"}` 

 `} ]` 

 `}` 

## Contents<a name="API_Featurization_Contents"></a>

 **AttributeName**   <a name="forecast-Type-Featurization-AttributeName"></a>
The name of the schema attribute that specifies the data field to be featurized\. Amazon Forecast supports the target field of the `TARGET_TIME_SERIES` and the `RELATED_TIME_SERIES` datasets\. For example, for the `RETAIL` domain, the target is `demand`, and for the `CUSTOM` domain, the target is `target_value`\. For more information, see [Handling Missing Values](howitworks-missing-values.md)\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z][a-zA-Z0-9_]*`   
Required: Yes

 **FeaturizationPipeline**   <a name="forecast-Type-Featurization-FeaturizationPipeline"></a>
An array of one `FeaturizationMethod` object that specifies the feature transformation method\.  
Type: Array of [FeaturizationMethod](API_FeaturizationMethod.md) objects  
Array Members: Fixed number of 1 item\.  
Required: No

## See Also<a name="API_Featurization_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/Featurization) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/Featurization) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/Featurization) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/Featurization) 