# DefaultCategoricalHyperParameterRange<a name="API_DefaultCategoricalHyperParameterRange"></a>

Provides the name and default range of a categorical hyperparameter and whether the hyperparameter is tunable\. A tunable hyperparameter can have its value determined during hyperparameter optimization \(HPO\)\.

## Contents<a name="API_DefaultCategoricalHyperParameterRange_Contents"></a>

 **isTunable**   <a name="personalize-Type-DefaultCategoricalHyperParameterRange-isTunable"></a>
Whether the hyperparameter is tunable\.  
Type: Boolean  
Required: No

 **name**   <a name="personalize-Type-DefaultCategoricalHyperParameterRange-name"></a>
The name of the hyperparameter\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Required: No

 **values**   <a name="personalize-Type-DefaultCategoricalHyperParameterRange-values"></a>
A list of the categories for the hyperparameter\.  
Type: Array of strings  
Array Members: Maximum number of 100 items\.  
Length Constraints: Maximum length of 1000\.  
Required: No

## See Also<a name="API_DefaultCategoricalHyperParameterRange_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/DefaultCategoricalHyperParameterRange) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/DefaultCategoricalHyperParameterRange) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/DefaultCategoricalHyperParameterRange) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/DefaultCategoricalHyperParameterRange) 