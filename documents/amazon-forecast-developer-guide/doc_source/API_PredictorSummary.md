# PredictorSummary<a name="API_PredictorSummary"></a>

Provides a summary of the predictor properties that are used in the [ListPredictors](API_ListPredictors.md) operation\. To get the complete set of properties, call the [DescribePredictor](API_DescribePredictor.md) operation, and provide the listed `PredictorArn`\.

## Contents<a name="API_PredictorSummary_Contents"></a>

 **CreationTime**   <a name="forecast-Type-PredictorSummary-CreationTime"></a>
When the model training task was created\.  
Type: Timestamp  
Required: No

 **DatasetGroupArn**   <a name="forecast-Type-PredictorSummary-DatasetGroupArn"></a>
The Amazon Resource Name \(ARN\) of the dataset group that contains the data used to train the predictor\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\-\_\.\/\:]+$`   
Required: No

 **LastModificationTime**   <a name="forecast-Type-PredictorSummary-LastModificationTime"></a>
Initially, the same as `CreationTime` \(status is `CREATE_PENDING`\)\. Updated when training starts \(status changed to `CREATE_IN_PROGRESS`\), and when training is complete \(status changed to `ACTIVE`\) or fails \(status changed to `CREATE_FAILED`\)\.  
Type: Timestamp  
Required: No

 **Message**   <a name="forecast-Type-PredictorSummary-Message"></a>
If an error occurred, an informational message about the error\.  
Type: String  
Required: No

 **PredictorArn**   <a name="forecast-Type-PredictorSummary-PredictorArn"></a>
The ARN of the predictor\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\-\_\.\/\:]+$`   
Required: No

 **PredictorName**   <a name="forecast-Type-PredictorSummary-PredictorName"></a>
The name of the predictor\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z][a-zA-Z0-9_]*`   
Required: No

 **Status**   <a name="forecast-Type-PredictorSummary-Status"></a>
The status of the predictor\. States include:  
+  `ACTIVE` 
+  `CREATE_PENDING`, `CREATE_IN_PROGRESS`, `CREATE_FAILED` 
+  `DELETE_PENDING`, `DELETE_IN_PROGRESS`, `DELETE_FAILED` 
+  `UPDATE_PENDING`, `UPDATE_IN_PROGRESS`, `UPDATE_FAILED` 
The `Status` of the predictor must be `ACTIVE` before you can use the predictor to create a forecast\.
Type: String  
Length Constraints: Maximum length of 256\.  
Required: No

## See Also<a name="API_PredictorSummary_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/PredictorSummary) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/PredictorSummary) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/PredictorSummary) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/PredictorSummary) 