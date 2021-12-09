# FeaturizationConfig<a name="API_FeaturizationConfig"></a>

In a [CreatePredictor](API_CreatePredictor.md) operation, the specified algorithm trains a model using the specified dataset group\. You can optionally tell the operation to modify data fields prior to training a model\. These modifications are referred to as *featurization*\.

You define featurization using the `FeaturizationConfig` object\. You specify an array of transformations, one for each field that you want to featurize\. You then include the `FeaturizationConfig` object in your `CreatePredictor` request\. Amazon Forecast applies the featurization to the `TARGET_TIME_SERIES` and `RELATED_TIME_SERIES` datasets before model training\.

You can create multiple featurization configurations\. For example, you might call the `CreatePredictor` operation twice by specifying different featurization configurations\.

## Contents<a name="API_FeaturizationConfig_Contents"></a>

 **Featurizations**   <a name="forecast-Type-FeaturizationConfig-Featurizations"></a>
An array of featurization \(transformation\) information for the fields of a dataset\.  
Type: Array of [Featurization](API_Featurization.md) objects  
Array Members: Minimum number of 1 item\. Maximum number of 50 items\.  
Required: No

 **ForecastDimensions**   <a name="forecast-Type-FeaturizationConfig-ForecastDimensions"></a>
An array of dimension \(field\) names that specify how to group the generated forecast\.  
For example, suppose that you are generating a forecast for item sales across all of your stores, and your dataset contains a `store_id` field\. If you want the sales forecast for each item by store, you would specify `store_id` as the dimension\.  
All forecast dimensions specified in the `TARGET_TIME_SERIES` dataset don't need to be specified in the `CreatePredictor` request\. All forecast dimensions specified in the `RELATED_TIME_SERIES` dataset must be specified in the `CreatePredictor` request\.  
Type: Array of strings  
Array Members: Minimum number of 1 item\. Maximum number of 5 items\.  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z][a-zA-Z0-9_]*`   
Required: No

 **ForecastFrequency**   <a name="forecast-Type-FeaturizationConfig-ForecastFrequency"></a>
The frequency of predictions in a forecast\.  
Valid intervals are Y \(Year\), M \(Month\), W \(Week\), D \(Day\), H \(Hour\), 30min \(30 minutes\), 15min \(15 minutes\), 10min \(10 minutes\), 5min \(5 minutes\), and 1min \(1 minute\)\. For example, "Y" indicates every year and "5min" indicates every five minutes\.  
The frequency must be greater than or equal to the TARGET\_TIME\_SERIES dataset frequency\.  
When a RELATED\_TIME\_SERIES dataset is provided, the frequency must be equal to the RELATED\_TIME\_SERIES dataset frequency\.  
Type: String  
Pattern: `^Y|M|W|D|H|30min|15min|10min|5min|1min$`   
Required: Yes

## See Also<a name="API_FeaturizationConfig_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/FeaturizationConfig) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/FeaturizationConfig) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/FeaturizationConfig) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/FeaturizationConfig) 