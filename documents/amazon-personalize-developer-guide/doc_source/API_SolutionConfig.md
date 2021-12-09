# SolutionConfig<a name="API_SolutionConfig"></a>

Describes the configuration properties for the solution\.

## Contents<a name="API_SolutionConfig_Contents"></a>

 **algorithmHyperParameters**   <a name="personalize-Type-SolutionConfig-algorithmHyperParameters"></a>
Lists the hyperparameter names and ranges\.  
Type: String to string map  
Map Entries: Maximum number of 100 items\.  
Key Length Constraints: Maximum length of 256\.  
Value Length Constraints: Maximum length of 1000\.  
Required: No

 **autoMLConfig**   <a name="personalize-Type-SolutionConfig-autoMLConfig"></a>
The [AutoMLConfig](API_AutoMLConfig.md) object containing a list of recipes to search when AutoML is performed\.  
Type: [AutoMLConfig](API_AutoMLConfig.md) object  
Required: No

 **eventValueThreshold**   <a name="personalize-Type-SolutionConfig-eventValueThreshold"></a>
Only events with a value greater than or equal to this threshold are used for training a model\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Required: No

 **featureTransformationParameters**   <a name="personalize-Type-SolutionConfig-featureTransformationParameters"></a>
Lists the feature transformation parameters\.  
Type: String to string map  
Map Entries: Maximum number of 100 items\.  
Key Length Constraints: Maximum length of 256\.  
Value Length Constraints: Maximum length of 1000\.  
Required: No

 **hpoConfig**   <a name="personalize-Type-SolutionConfig-hpoConfig"></a>
Describes the properties for hyperparameter optimization \(HPO\)\.  
Type: [HPOConfig](API_HPOConfig.md) object  
Required: No

## See Also<a name="API_SolutionConfig_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/SolutionConfig) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/SolutionConfig) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/SolutionConfig) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/SolutionConfig) 