# FeaturizationMethod<a name="API_FeaturizationMethod"></a>

Provides information about the method that featurizes \(transforms\) a dataset field\. The method is part of the `FeaturizationPipeline` of the [Featurization](API_Featurization.md) object\. 

The following is an example of how you specify a `FeaturizationMethod` object\.

 `{` 

 `"FeaturizationMethodName": "filling",` 

 `"FeaturizationMethodParameters": {"aggregation": "sum", "middlefill": "zero", "backfill": "zero"}` 

 `}` 

## Contents<a name="API_FeaturizationMethod_Contents"></a>

 **FeaturizationMethodName**   <a name="forecast-Type-FeaturizationMethod-FeaturizationMethodName"></a>
The name of the method\. The "filling" method is the only supported method\.  
Type: String  
Valid Values:` filling`   
Required: Yes

 **FeaturizationMethodParameters**   <a name="forecast-Type-FeaturizationMethod-FeaturizationMethodParameters"></a>
The method parameters \(key\-value pairs\), which are a map of override parameters\. Specify these parameters to override the default values\. Related Time Series attributes do not accept aggregation parameters\.  
The following list shows the parameters and their valid values for the "filling" featurization method for a **Target Time Series** dataset\. Bold signifies the default value\.  
+  `aggregation`: **sum**, `avg`, `first`, `min`, `max` 
+  `frontfill`: **none** 
+  `middlefill`: **zero**, `nan` \(not a number\), `value`, `median`, `mean`, `min`, `max` 
+  `backfill`: **zero**, `nan`, `value`, `median`, `mean`, `min`, `max` 
The following list shows the parameters and their valid values for a **Related Time Series** featurization method \(there are no defaults\):  
+  `middlefill`: `zero`, `value`, `median`, `mean`, `min`, `max` 
+  `backfill`: `zero`, `value`, `median`, `mean`, `min`, `max` 
+  `futurefill`: `zero`, `value`, `median`, `mean`, `min`, `max` 
To set a filling method to a specific value, set the fill parameter to `value` and define the value in a corresponding `_value` parameter\. For example, to set backfilling to a value of 2, include the following: `"backfill": "value"` and `"backfill_value":"2"`\.   
Type: String to string map  
Map Entries: Maximum number of 20 items\.  
Key Length Constraints: Maximum length of 256\.  
Key Pattern: `^[a-zA-Z0-9\-\_\.\/\[\]\,\\]+$`   
Value Length Constraints: Maximum length of 256\.  
Value Pattern: `^[a-zA-Z0-9\-\_\.\/\[\]\,\"\\\s]+$`   
Required: No

## See Also<a name="API_FeaturizationMethod_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/FeaturizationMethod) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/FeaturizationMethod) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/FeaturizationMethod) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/FeaturizationMethod) 