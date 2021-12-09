# ForecastSummary<a name="API_ForecastSummary"></a>

Provides a summary of the forecast properties used in the [ListForecasts](API_ListForecasts.md) operation\. To get the complete set of properties, call the [DescribeForecast](API_DescribeForecast.md) operation, and provide the `ForecastArn` that is listed in the summary\.

## Contents<a name="API_ForecastSummary_Contents"></a>

 **CreationTime**   <a name="forecast-Type-ForecastSummary-CreationTime"></a>
When the forecast creation task was created\.  
Type: Timestamp  
Required: No

 **DatasetGroupArn**   <a name="forecast-Type-ForecastSummary-DatasetGroupArn"></a>
The Amazon Resource Name \(ARN\) of the dataset group that provided the data used to train the predictor\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\_]+$`   
Required: No

 **ForecastArn**   <a name="forecast-Type-ForecastSummary-ForecastArn"></a>
The ARN of the forecast\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\-\_\.\/\:]+$`   
Required: No

 **ForecastName**   <a name="forecast-Type-ForecastSummary-ForecastName"></a>
The name of the forecast\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z][a-zA-Z0-9_]*`   
Required: No

 **LastModificationTime**   <a name="forecast-Type-ForecastSummary-LastModificationTime"></a>
Initially, the same as `CreationTime` \(status is `CREATE_PENDING`\)\. Updated when inference \(creating the forecast\) starts \(status changed to `CREATE_IN_PROGRESS`\), and when inference is complete \(status changed to `ACTIVE`\) or fails \(status changed to `CREATE_FAILED`\)\.  
Type: Timestamp  
Required: No

 **Message**   <a name="forecast-Type-ForecastSummary-Message"></a>
If an error occurred, an informational message about the error\.  
Type: String  
Required: No

 **PredictorArn**   <a name="forecast-Type-ForecastSummary-PredictorArn"></a>
The ARN of the predictor used to generate the forecast\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\_]+$`   
Required: No

 **Status**   <a name="forecast-Type-ForecastSummary-Status"></a>
The status of the forecast\. States include:  
+  `ACTIVE` 
+  `CREATE_PENDING`, `CREATE_IN_PROGRESS`, `CREATE_FAILED` 
+  `DELETE_PENDING`, `DELETE_IN_PROGRESS`, `DELETE_FAILED` 
The `Status` of the forecast must be `ACTIVE` before you can query or export the forecast\.
Type: String  
Length Constraints: Maximum length of 256\.  
Required: No

## See Also<a name="API_ForecastSummary_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/ForecastSummary) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/ForecastSummary) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/ForecastSummary) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/ForecastSummary) 