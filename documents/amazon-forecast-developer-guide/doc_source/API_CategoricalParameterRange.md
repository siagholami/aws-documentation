# CategoricalParameterRange<a name="API_CategoricalParameterRange"></a>

Specifies a categorical hyperparameter and it's range of tunable values\. This object is part of the [ParameterRanges](API_ParameterRanges.md) object\.

## Contents<a name="API_CategoricalParameterRange_Contents"></a>

 **Name**   <a name="forecast-Type-CategoricalParameterRange-Name"></a>
The name of the categorical hyperparameter to tune\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z][a-zA-Z0-9_]*`   
Required: Yes

 **Values**   <a name="forecast-Type-CategoricalParameterRange-Values"></a>
A list of the tunable categories for the hyperparameter\.  
Type: Array of strings  
Array Members: Minimum number of 1 item\. Maximum number of 20 items\.  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\_\-]+$`   
Required: Yes

## See Also<a name="API_CategoricalParameterRange_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/CategoricalParameterRange) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/CategoricalParameterRange) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/CategoricalParameterRange) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/CategoricalParameterRange) 