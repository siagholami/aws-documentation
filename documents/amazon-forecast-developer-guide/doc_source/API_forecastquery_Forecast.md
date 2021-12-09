# Forecast<a name="API_forecastquery_Forecast"></a>

Provides information about a forecast\. Returned as part of the [QueryForecast](API_forecastquery_QueryForecast.md) response\.

## Contents<a name="API_forecastquery_Forecast_Contents"></a>

 **Predictions**   <a name="forecast-Type-forecastquery_Forecast-Predictions"></a>
The forecast\.  
The *string* of the string\-to\-array map is one of the following values:  
+ p10
+ p50
+ p90
The default setting is `["0.1", "0.5", "0.9"]`\. Use the optional `ForecastTypes` parameter of the [CreateForecast](https://docs.aws.amazon.com/forecast/latest/dg/API_CreateForecast.html) operation to change the values\. The values will vary depending on how this is set, with a minimum of `1` and a maximum of `5.`   
Type: String to array of [DataPoint](API_forecastquery_DataPoint.md) objects map  
Key Length Constraints: Maximum length of 4\.  
Required: No

## See Also<a name="API_forecastquery_Forecast_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecastquery-2018-06-26/Forecast) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecastquery-2018-06-26/Forecast) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecastquery-2018-06-26/Forecast) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecastquery-2018-06-26/Forecast) 