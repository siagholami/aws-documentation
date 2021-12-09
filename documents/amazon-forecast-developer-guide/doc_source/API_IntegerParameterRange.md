# IntegerParameterRange<a name="API_IntegerParameterRange"></a>

Specifies an integer hyperparameter and it's range of tunable values\. This object is part of the [ParameterRanges](API_ParameterRanges.md) object\.

## Contents<a name="API_IntegerParameterRange_Contents"></a>

 **MaxValue**   <a name="forecast-Type-IntegerParameterRange-MaxValue"></a>
The maximum tunable value of the hyperparameter\.  
Type: Integer  
Required: Yes

 **MinValue**   <a name="forecast-Type-IntegerParameterRange-MinValue"></a>
The minimum tunable value of the hyperparameter\.  
Type: Integer  
Required: Yes

 **Name**   <a name="forecast-Type-IntegerParameterRange-Name"></a>
The name of the hyperparameter to tune\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z][a-zA-Z0-9_]*`   
Required: Yes

 **ScalingType**   <a name="forecast-Type-IntegerParameterRange-ScalingType"></a>
The scale that hyperparameter tuning uses to search the hyperparameter range\. Valid values:    
Auto  
Amazon Forecast hyperparameter tuning chooses the best scale for the hyperparameter\.  
Linear  
Hyperparameter tuning searches the values in the hyperparameter range by using a linear scale\.  
Logarithmic  
Hyperparameter tuning searches the values in the hyperparameter range by using a logarithmic scale\.  
Logarithmic scaling works only for ranges that have values greater than 0\.  
ReverseLogarithmic  
Not supported for `IntegerParameterRange`\.  
Reverse logarithmic scaling works only for ranges that are entirely within the range 0 <= x < 1\.0\.
For information about choosing a hyperparameter scale, see [Hyperparameter Scaling](http://docs.aws.amazon.com/sagemaker/latest/dg/automatic-model-tuning-define-ranges.html#scaling-type)\. One of the following values:  
Type: String  
Valid Values:` Auto | Linear | Logarithmic | ReverseLogarithmic`   
Required: No

## See Also<a name="API_IntegerParameterRange_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/IntegerParameterRange) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/IntegerParameterRange) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/IntegerParameterRange) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/IntegerParameterRange) 