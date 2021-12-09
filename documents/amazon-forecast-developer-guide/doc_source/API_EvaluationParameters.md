# EvaluationParameters<a name="API_EvaluationParameters"></a>

Parameters that define how to split a dataset into training data and testing data, and the number of iterations to perform\. These parameters are specified in the predefined algorithms but you can override them in the [CreatePredictor](API_CreatePredictor.md) request\.

## Contents<a name="API_EvaluationParameters_Contents"></a>

 **BackTestWindowOffset**   <a name="forecast-Type-EvaluationParameters-BackTestWindowOffset"></a>
The point from the end of the dataset where you want to split the data for model training and testing \(evaluation\)\. Specify the value as the number of data points\. The default is the value of the forecast horizon\. `BackTestWindowOffset` can be used to mimic a past virtual forecast start date\. This value must be greater than or equal to the forecast horizon and less than half of the TARGET\_TIME\_SERIES dataset length\.  
 `ForecastHorizon` <= `BackTestWindowOffset` < 1/2 \* TARGET\_TIME\_SERIES dataset length  
Type: Integer  
Required: No

 **NumberOfBacktestWindows**   <a name="forecast-Type-EvaluationParameters-NumberOfBacktestWindows"></a>
The number of times to split the input data\. The default is 1\. Valid values are 1 through 5\.  
Type: Integer  
Required: No

## See Also<a name="API_EvaluationParameters_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/EvaluationParameters) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/EvaluationParameters) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/EvaluationParameters) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/EvaluationParameters) 