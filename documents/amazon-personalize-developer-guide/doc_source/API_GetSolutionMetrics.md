# GetSolutionMetrics<a name="API_GetSolutionMetrics"></a>

Gets the metrics for the specified solution version\.

## Request Syntax<a name="API_GetSolutionMetrics_RequestSyntax"></a>

```
{
   "solutionVersionArn": "string"
}
```

## Request Parameters<a name="API_GetSolutionMetrics_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [solutionVersionArn](#API_GetSolutionMetrics_RequestSyntax) **   <a name="personalize-GetSolutionMetrics-request-solutionVersionArn"></a>
The Amazon Resource Name \(ARN\) of the solution version for which to get metrics\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: Yes

## Response Syntax<a name="API_GetSolutionMetrics_ResponseSyntax"></a>

```
{
   "metrics": { 
      "string" : number 
   },
   "solutionVersionArn": "string"
}
```

## Response Elements<a name="API_GetSolutionMetrics_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [metrics](#API_GetSolutionMetrics_ResponseSyntax) **   <a name="personalize-GetSolutionMetrics-response-metrics"></a>
The metrics for the solution version\.  
Type: String to double map  
Map Entries: Maximum number of 100 items\.  
Key Length Constraints: Maximum length of 256\.

 ** [solutionVersionArn](#API_GetSolutionMetrics_ResponseSyntax) **   <a name="personalize-GetSolutionMetrics-response-solutionVersionArn"></a>
The same solution version ARN as specified in the request\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+` 

## Errors<a name="API_GetSolutionMetrics_Errors"></a>

 **InvalidInputException**   
Provide a valid value for the field or parameter\.  
HTTP Status Code: 400

 **ResourceInUseException**   
The specified resource is in use\.  
HTTP Status Code: 400

 **ResourceNotFoundException**   
Could not find the specified resource\.  
HTTP Status Code: 400

## See Also<a name="API_GetSolutionMetrics_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/personalize-2018-05-22/GetSolutionMetrics) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/personalize-2018-05-22/GetSolutionMetrics) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/GetSolutionMetrics) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/GetSolutionMetrics) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/GetSolutionMetrics) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/personalize-2018-05-22/GetSolutionMetrics) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/personalize-2018-05-22/GetSolutionMetrics) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/personalize-2018-05-22/GetSolutionMetrics) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/GetSolutionMetrics) 