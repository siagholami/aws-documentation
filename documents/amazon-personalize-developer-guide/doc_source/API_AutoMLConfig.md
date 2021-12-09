# AutoMLConfig<a name="API_AutoMLConfig"></a>

When the solution performs AutoML \(`performAutoML` is true in [CreateSolution](API_CreateSolution.md)\), Amazon Personalize determines which recipe, from the specified list, optimizes the given metric\. Amazon Personalize then uses that recipe for the solution\.

## Contents<a name="API_AutoMLConfig_Contents"></a>

 **metricName**   <a name="personalize-Type-AutoMLConfig-metricName"></a>
The metric to optimize\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Required: No

 **recipeList**   <a name="personalize-Type-AutoMLConfig-recipeList"></a>
The list of candidate recipes\.  
Type: Array of strings  
Array Members: Maximum number of 100 items\.  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

## See Also<a name="API_AutoMLConfig_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/AutoMLConfig) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/AutoMLConfig) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/AutoMLConfig) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/AutoMLConfig) 