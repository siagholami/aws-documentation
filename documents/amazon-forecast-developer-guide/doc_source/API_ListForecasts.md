# ListForecasts<a name="API_ListForecasts"></a>

Returns a list of forecasts created using the [CreateForecast](API_CreateForecast.md) operation\. For each forecast, this operation returns a summary of its properties, including its Amazon Resource Name \(ARN\)\. To retrieve the complete set of properties, specify the ARN with the [DescribeForecast](API_DescribeForecast.md) operation\. You can filter the list using an array of [Filter](API_Filter.md) objects\.

## Request Syntax<a name="API_ListForecasts_RequestSyntax"></a>

```
{
   "Filters": [ 
      { 
         "Condition": "string",
         "Key": "string",
         "Value": "string"
      }
   ],
   "MaxResults": number,
   "NextToken": "string"
}
```

## Request Parameters<a name="API_ListForecasts_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [Filters](#API_ListForecasts_RequestSyntax) **   <a name="forecast-ListForecasts-request-Filters"></a>
An array of filters\. For each filter, you provide a condition and a match statement\. The condition is either `IS` or `IS_NOT`, which specifies whether to include or exclude the forecasts that match the statement from the list, respectively\. The match statement consists of a key and a value\.  
 **Filter properties**   
+  `Condition` \- The condition to apply\. Valid values are `IS` and `IS_NOT`\. To include the forecasts that match the statement, specify `IS`\. To exclude matching forecasts, specify `IS_NOT`\.
+  `Key` \- The name of the parameter to filter on\. Valid values are `DatasetGroupArn`, `PredictorArn`, and `Status`\.
+  `Value` \- The value to match\.
For example, to list all forecasts whose status is not ACTIVE, you would specify:  
 `"Filters": [ { "Condition": "IS_NOT", "Key": "Status", "Value": "ACTIVE" } ]`   
Type: Array of [Filter](API_Filter.md) objects  
Required: No

 ** [MaxResults](#API_ListForecasts_RequestSyntax) **   <a name="forecast-ListForecasts-request-MaxResults"></a>
The number of items to return in the response\.  
Type: Integer  
Valid Range: Minimum value of 1\. Maximum value of 100\.  
Required: No

 ** [NextToken](#API_ListForecasts_RequestSyntax) **   <a name="forecast-ListForecasts-request-NextToken"></a>
If the result of the previous request was truncated, the response includes a `NextToken`\. To retrieve the next set of results, use the token in the next request\. Tokens expire after 24 hours\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 3000\.  
Required: No

## Response Syntax<a name="API_ListForecasts_ResponseSyntax"></a>

```
{
   "Forecasts": [ 
      { 
         "CreationTime": number,
         "DatasetGroupArn": "string",
         "ForecastArn": "string",
         "ForecastName": "string",
         "LastModificationTime": number,
         "Message": "string",
         "PredictorArn": "string",
         "Status": "string"
      }
   ],
   "NextToken": "string"
}
```

## Response Elements<a name="API_ListForecasts_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [Forecasts](#API_ListForecasts_ResponseSyntax) **   <a name="forecast-ListForecasts-response-Forecasts"></a>
An array of objects that summarize each forecast's properties\.  
Type: Array of [ForecastSummary](API_ForecastSummary.md) objects

 ** [NextToken](#API_ListForecasts_ResponseSyntax) **   <a name="forecast-ListForecasts-response-NextToken"></a>
If the response is truncated, Amazon Forecast returns this token\. To retrieve the next set of results, use the token in the next request\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 3000\.

## Errors<a name="API_ListForecasts_Errors"></a>

 **InvalidInputException**   
We can't process the request because it includes an invalid value or a value that exceeds the valid range\.  
HTTP Status Code: 400

 **InvalidNextTokenException**   
The token is not valid\. Tokens expire after 24 hours\.  
HTTP Status Code: 400

## See Also<a name="API_ListForecasts_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/forecast-2018-06-26/ListForecasts) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/forecast-2018-06-26/ListForecasts) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/ListForecasts) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/ListForecasts) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/ListForecasts) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/forecast-2018-06-26/ListForecasts) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/forecast-2018-06-26/ListForecasts) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/forecast-2018-06-26/ListForecasts) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/ListForecasts) 