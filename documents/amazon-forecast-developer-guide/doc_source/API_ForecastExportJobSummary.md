# ForecastExportJobSummary<a name="API_ForecastExportJobSummary"></a>

Provides a summary of the forecast export job properties used in the [ListForecastExportJobs](API_ListForecastExportJobs.md) operation\. To get the complete set of properties, call the [DescribeForecastExportJob](API_DescribeForecastExportJob.md) operation, and provide the listed `ForecastExportJobArn`\.

## Contents<a name="API_ForecastExportJobSummary_Contents"></a>

 **CreationTime**   <a name="forecast-Type-ForecastExportJobSummary-CreationTime"></a>
When the forecast export job was created\.  
Type: Timestamp  
Required: No

 **Destination**   <a name="forecast-Type-ForecastExportJobSummary-Destination"></a>
The path to the Amazon Simple Storage Service \(Amazon S3\) bucket where the forecast is exported\.  
Type: [DataDestination](API_DataDestination.md) object  
Required: No

 **ForecastExportJobArn**   <a name="forecast-Type-ForecastExportJobSummary-ForecastExportJobArn"></a>
The Amazon Resource Name \(ARN\) of the forecast export job\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\-\_\.\/\:]+$`   
Required: No

 **ForecastExportJobName**   <a name="forecast-Type-ForecastExportJobSummary-ForecastExportJobName"></a>
The name of the forecast export job\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z][a-zA-Z0-9_]*`   
Required: No

 **LastModificationTime**   <a name="forecast-Type-ForecastExportJobSummary-LastModificationTime"></a>
When the last successful export job finished\.  
Type: Timestamp  
Required: No

 **Message**   <a name="forecast-Type-ForecastExportJobSummary-Message"></a>
If an error occurred, an informational message about the error\.  
Type: String  
Required: No

 **Status**   <a name="forecast-Type-ForecastExportJobSummary-Status"></a>
The status of the forecast export job\. States include:  
+  `ACTIVE` 
+  `CREATE_PENDING`, `CREATE_IN_PROGRESS`, `CREATE_FAILED` 
+  `DELETE_PENDING`, `DELETE_IN_PROGRESS`, `DELETE_FAILED` 
The `Status` of the forecast export job must be `ACTIVE` before you can access the forecast in your S3 bucket\.
Type: String  
Length Constraints: Maximum length of 256\.  
Required: No

## See Also<a name="API_ForecastExportJobSummary_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/ForecastExportJobSummary) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/ForecastExportJobSummary) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/ForecastExportJobSummary) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/ForecastExportJobSummary) 