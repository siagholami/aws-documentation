# DescribeForecast<a name="API_DescribeForecast"></a>

Describes a forecast created using the [CreateForecast](API_CreateForecast.md) operation\.

In addition to listing the properties provided in the `CreateForecast` request, this operation lists the following properties:
+  `DatasetGroupArn` \- The dataset group that provided the training data\.
+  `CreationTime` 
+  `LastModificationTime` 
+  `Status` 
+  `Message` \- If an error occurred, information about the error\.

## Request Syntax<a name="API_DescribeForecast_RequestSyntax"></a>

```
{
   "ForecastArn": "string"
}
```

## Request Parameters<a name="API_DescribeForecast_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [ForecastArn](#API_DescribeForecast_RequestSyntax) **   <a name="forecast-DescribeForecast-request-ForecastArn"></a>
The Amazon Resource Name \(ARN\) of the forecast\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\-\_\.\/\:]+$`   
Required: Yes

## Response Syntax<a name="API_DescribeForecast_ResponseSyntax"></a>

```
{
   "CreationTime": number,
   "DatasetGroupArn": "string",
   "ForecastArn": "string",
   "ForecastName": "string",
   "ForecastTypes": [ "string" ],
   "LastModificationTime": number,
   "Message": "string",
   "PredictorArn": "string",
   "Status": "string"
}
```

## Response Elements<a name="API_DescribeForecast_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [CreationTime](#API_DescribeForecast_ResponseSyntax) **   <a name="forecast-DescribeForecast-response-CreationTime"></a>
When the forecast creation task was created\.  
Type: Timestamp

 ** [DatasetGroupArn](#API_DescribeForecast_ResponseSyntax) **   <a name="forecast-DescribeForecast-response-DatasetGroupArn"></a>
The ARN of the dataset group that provided the data used to train the predictor\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\-\_\.\/\:]+$` 

 ** [ForecastArn](#API_DescribeForecast_ResponseSyntax) **   <a name="forecast-DescribeForecast-response-ForecastArn"></a>
The forecast ARN as specified in the request\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\-\_\.\/\:]+$` 

 ** [ForecastName](#API_DescribeForecast_ResponseSyntax) **   <a name="forecast-DescribeForecast-response-ForecastName"></a>
The name of the forecast\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z][a-zA-Z0-9_]*` 

 ** [ForecastTypes](#API_DescribeForecast_ResponseSyntax) **   <a name="forecast-DescribeForecast-response-ForecastTypes"></a>
The quantiles at which probabilistic forecasts were generated\.  
Type: Array of strings  
Array Members: Minimum number of 1 item\. Maximum number of 20 items\.  
Pattern: `(^0?\.\d\d?$|^mean$)` 

 ** [LastModificationTime](#API_DescribeForecast_ResponseSyntax) **   <a name="forecast-DescribeForecast-response-LastModificationTime"></a>
Initially, the same as `CreationTime` \(status is `CREATE_PENDING`\)\. Updated when inference \(creating the forecast\) starts \(status changed to `CREATE_IN_PROGRESS`\), and when inference is complete \(status changed to `ACTIVE`\) or fails \(status changed to `CREATE_FAILED`\)\.  
Type: Timestamp

 ** [Message](#API_DescribeForecast_ResponseSyntax) **   <a name="forecast-DescribeForecast-response-Message"></a>
If an error occurred, an informational message about the error\.  
Type: String

 ** [PredictorArn](#API_DescribeForecast_ResponseSyntax) **   <a name="forecast-DescribeForecast-response-PredictorArn"></a>
The ARN of the predictor used to generate the forecast\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\-\_\.\/\:]+$` 

 ** [Status](#API_DescribeForecast_ResponseSyntax) **   <a name="forecast-DescribeForecast-response-Status"></a>
The status of the forecast\. States include:  
+  `ACTIVE` 
+  `CREATE_PENDING`, `CREATE_IN_PROGRESS`, `CREATE_FAILED` 
+  `DELETE_PENDING`, `DELETE_IN_PROGRESS`, `DELETE_FAILED` 
The `Status` of the forecast must be `ACTIVE` before you can query or export the forecast\.
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\_]+$` 

## Errors<a name="API_DescribeForecast_Errors"></a>

 **InvalidInputException**   
We can't process the request because it includes an invalid value or a value that exceeds the valid range\.  
HTTP Status Code: 400

 **ResourceNotFoundException**   
We can't find a resource with that Amazon Resource Name \(ARN\)\. Check the ARN and try again\.  
HTTP Status Code: 400

## See Also<a name="API_DescribeForecast_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/forecast-2018-06-26/DescribeForecast) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/forecast-2018-06-26/DescribeForecast) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/DescribeForecast) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/DescribeForecast) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/DescribeForecast) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/forecast-2018-06-26/DescribeForecast) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/forecast-2018-06-26/DescribeForecast) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/forecast-2018-06-26/DescribeForecast) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/DescribeForecast) 