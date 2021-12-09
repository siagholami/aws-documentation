# WindowSummary<a name="API_WindowSummary"></a>

The metrics for a time range within the evaluation portion of a dataset\. This object is part of the [EvaluationResult](API_EvaluationResult.md) object\.

The `TestWindowStart` and `TestWindowEnd` parameters are determined by the `BackTestWindowOffset` parameter of the [EvaluationParameters](API_EvaluationParameters.md) object\.

## Contents<a name="API_WindowSummary_Contents"></a>

 **EvaluationType**   <a name="forecast-Type-WindowSummary-EvaluationType"></a>
The type of evaluation\.  
+  `SUMMARY` \- The average metrics across all windows\.
+  `COMPUTED` \- The metrics for the specified window\.
Type: String  
Valid Values:` SUMMARY | COMPUTED`   
Required: No

 **ItemCount**   <a name="forecast-Type-WindowSummary-ItemCount"></a>
The number of data points within the window\.  
Type: Integer  
Required: No

 **Metrics**   <a name="forecast-Type-WindowSummary-Metrics"></a>
Provides metrics used to evaluate the performance of a predictor\.  
Type: [Metrics](API_Metrics.md) object  
Required: No

 **TestWindowEnd**   <a name="forecast-Type-WindowSummary-TestWindowEnd"></a>
The timestamp that defines the end of the window\.  
Type: Timestamp  
Required: No

 **TestWindowStart**   <a name="forecast-Type-WindowSummary-TestWindowStart"></a>
The timestamp that defines the start of the window\.  
Type: Timestamp  
Required: No

## See Also<a name="API_WindowSummary_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/WindowSummary) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/WindowSummary) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/WindowSummary) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/WindowSummary) 