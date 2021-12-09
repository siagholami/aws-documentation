# ListPredictors<a name="API_ListPredictors"></a>

Returns a list of predictors created using the [CreatePredictor](API_CreatePredictor.md) operation\. For each predictor, this operation returns a summary of its properties, including its Amazon Resource Name \(ARN\)\. You can retrieve the complete set of properties by using the ARN with the [DescribePredictor](API_DescribePredictor.md) operation\. You can filter the list using an array of [Filter](API_Filter.md) objects\.

## Request Syntax<a name="API_ListPredictors_RequestSyntax"></a>

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

## Request Parameters<a name="API_ListPredictors_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [Filters](#API_ListPredictors_RequestSyntax) **   <a name="forecast-ListPredictors-request-Filters"></a>
An array of filters\. For each filter, you provide a condition and a match statement\. The condition is either `IS` or `IS_NOT`, which specifies whether to include or exclude the predictors that match the statement from the list, respectively\. The match statement consists of a key and a value\.  
 **Filter properties**   
+  `Condition` \- The condition to apply\. Valid values are `IS` and `IS_NOT`\. To include the predictors that match the statement, specify `IS`\. To exclude matching predictors, specify `IS_NOT`\.
+  `Key` \- The name of the parameter to filter on\. Valid values are `DatasetGroupArn` and `Status`\.
+  `Value` \- The value to match\.
For example, to list all predictors whose status is ACTIVE, you would specify:  
 `"Filters": [ { "Condition": "IS", "Key": "Status", "Value": "ACTIVE" } ]`   
Type: Array of [Filter](API_Filter.md) objects  
Required: No

 ** [MaxResults](#API_ListPredictors_RequestSyntax) **   <a name="forecast-ListPredictors-request-MaxResults"></a>
The number of items to return in the response\.  
Type: Integer  
Valid Range: Minimum value of 1\. Maximum value of 100\.  
Required: No

 ** [NextToken](#API_ListPredictors_RequestSyntax) **   <a name="forecast-ListPredictors-request-NextToken"></a>
If the result of the previous request was truncated, the response includes a `NextToken`\. To retrieve the next set of results, use the token in the next request\. Tokens expire after 24 hours\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 3000\.  
Required: No

## Response Syntax<a name="API_ListPredictors_ResponseSyntax"></a>

```
{
   "NextToken": "string",
   "Predictors": [ 
      { 
         "CreationTime": number,
         "DatasetGroupArn": "string",
         "LastModificationTime": number,
         "Message": "string",
         "PredictorArn": "string",
         "PredictorName": "string",
         "Status": "string"
      }
   ]
}
```

## Response Elements<a name="API_ListPredictors_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [NextToken](#API_ListPredictors_ResponseSyntax) **   <a name="forecast-ListPredictors-response-NextToken"></a>
If the response is truncated, Amazon Forecast returns this token\. To retrieve the next set of results, use the token in the next request\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 3000\.

 ** [Predictors](#API_ListPredictors_ResponseSyntax) **   <a name="forecast-ListPredictors-response-Predictors"></a>
An array of objects that summarize each predictor's properties\.  
Type: Array of [PredictorSummary](API_PredictorSummary.md) objects

## Errors<a name="API_ListPredictors_Errors"></a>

 **InvalidInputException**   
We can't process the request because it includes an invalid value or a value that exceeds the valid range\.  
HTTP Status Code: 400

 **InvalidNextTokenException**   
The token is not valid\. Tokens expire after 24 hours\.  
HTTP Status Code: 400

## See Also<a name="API_ListPredictors_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/forecast-2018-06-26/ListPredictors) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/forecast-2018-06-26/ListPredictors) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/ListPredictors) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/ListPredictors) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/ListPredictors) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/forecast-2018-06-26/ListPredictors) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/forecast-2018-06-26/ListPredictors) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/forecast-2018-06-26/ListPredictors) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/ListPredictors) 