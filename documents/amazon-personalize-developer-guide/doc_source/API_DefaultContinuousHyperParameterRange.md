# DefaultContinuousHyperParameterRange<a name="API_DefaultContinuousHyperParameterRange"></a>

Provides the name and default range of a continuous hyperparameter and whether the hyperparameter is tunable\. A tunable hyperparameter can have its value determined during hyperparameter optimization \(HPO\)\.

## Contents<a name="API_DefaultContinuousHyperParameterRange_Contents"></a>

 **isTunable**   <a name="personalize-Type-DefaultContinuousHyperParameterRange-isTunable"></a>
Whether the hyperparameter is tunable\.  
Type: Boolean  
Required: No

 **maxValue**   <a name="personalize-Type-DefaultContinuousHyperParameterRange-maxValue"></a>
The maximum allowable value for the hyperparameter\.  
Type: Double  
Valid Range: Minimum value of \-1000000\.  
Required: No

 **minValue**   <a name="personalize-Type-DefaultContinuousHyperParameterRange-minValue"></a>
The minimum allowable value for the hyperparameter\.  
Type: Double  
Valid Range: Minimum value of \-1000000\.  
Required: No

 **name**   <a name="personalize-Type-DefaultContinuousHyperParameterRange-name"></a>
The name of the hyperparameter\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Required: No

## See Also<a name="API_DefaultContinuousHyperParameterRange_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/DefaultContinuousHyperParameterRange) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/DefaultContinuousHyperParameterRange) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/DefaultContinuousHyperParameterRange) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/DefaultContinuousHyperParameterRange) 