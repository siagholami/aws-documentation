# ListSimulationJobBatches<a name="API_ListSimulationJobBatches"></a>

Returns a list simulation job batches\. You can optionally provide filters to retrieve specific simulation batch jobs\. 

## Request Syntax<a name="API_ListSimulationJobBatches_RequestSyntax"></a>

```
POST /listSimulationJobBatches HTTP/1.1
Content-type: application/json

{
   "[filters](#robomaker-ListSimulationJobBatches-request-filters)": [ 
      { 
         "[name](API_Filter.md#robomaker-Type-Filter-name)": "string",
         "[values](API_Filter.md#robomaker-Type-Filter-values)": [ "string" ]
      }
   ],
   "[maxResults](#robomaker-ListSimulationJobBatches-request-maxResults)": number,
   "[nextToken](#robomaker-ListSimulationJobBatches-request-nextToken)": "string"
}
```

## URI Request Parameters<a name="API_ListSimulationJobBatches_RequestParameters"></a>

The request does not use any URI parameters\.

## Request Body<a name="API_ListSimulationJobBatches_RequestBody"></a>

The request accepts the following data in JSON format\.

 ** [filters](#API_ListSimulationJobBatches_RequestSyntax) **   <a name="robomaker-ListSimulationJobBatches-request-filters"></a>
Optional filters to limit results\.  
Type: Array of [Filter](API_Filter.md) objects  
Array Members: Fixed number of 1 item\.  
Required: No

 ** [maxResults](#API_ListSimulationJobBatches_RequestSyntax) **   <a name="robomaker-ListSimulationJobBatches-request-maxResults"></a>
When this parameter is used, `ListSimulationJobBatches` only returns `maxResults` results in a single page along with a `nextToken` response element\. The remaining results of the initial request can be seen by sending another `ListSimulationJobBatches` request with the returned `nextToken` value\.   
Type: Integer  
Required: No

 ** [nextToken](#API_ListSimulationJobBatches_RequestSyntax) **   <a name="robomaker-ListSimulationJobBatches-request-nextToken"></a>
The `nextToken` value returned from a previous paginated `ListSimulationJobBatches` request where `maxResults` was used and the results exceeded the value of that parameter\. Pagination continues from the end of the previous results that returned the `nextToken` value\.   
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 2048\.  
Pattern: `[a-zA-Z0-9_.\-\/+=]*`   
Required: No

## Response Syntax<a name="API_ListSimulationJobBatches_ResponseSyntax"></a>

```
HTTP/1.1 200
Content-type: application/json

{
   "[nextToken](#robomaker-ListSimulationJobBatches-response-nextToken)": "string",
   "[simulationJobBatchSummaries](#robomaker-ListSimulationJobBatches-response-simulationJobBatchSummaries)": [ 
      { 
         "[arn](API_SimulationJobBatchSummary.md#robomaker-Type-SimulationJobBatchSummary-arn)": "string",
         "[createdAt](API_SimulationJobBatchSummary.md#robomaker-Type-SimulationJobBatchSummary-createdAt)": number,
         "[createdRequestCount](API_SimulationJobBatchSummary.md#robomaker-Type-SimulationJobBatchSummary-createdRequestCount)": number,
         "[failedRequestCount](API_SimulationJobBatchSummary.md#robomaker-Type-SimulationJobBatchSummary-failedRequestCount)": number,
         "[lastUpdatedAt](API_SimulationJobBatchSummary.md#robomaker-Type-SimulationJobBatchSummary-lastUpdatedAt)": number,
         "[pendingRequestCount](API_SimulationJobBatchSummary.md#robomaker-Type-SimulationJobBatchSummary-pendingRequestCount)": number,
         "[status](API_SimulationJobBatchSummary.md#robomaker-Type-SimulationJobBatchSummary-status)": "string"
      }
   ]
}
```

## Response Elements<a name="API_ListSimulationJobBatches_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [nextToken](#API_ListSimulationJobBatches_ResponseSyntax) **   <a name="robomaker-ListSimulationJobBatches-response-nextToken"></a>
The `nextToken` value to include in a future `ListSimulationJobBatches` request\. When the results of a `ListSimulationJobBatches` request exceed `maxResults`, this value can be used to retrieve the next page of results\. This value is `null` when there are no more results to return\.   
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 2048\.  
Pattern: `[a-zA-Z0-9_.\-\/+=]*` 

 ** [simulationJobBatchSummaries](#API_ListSimulationJobBatches_ResponseSyntax) **   <a name="robomaker-ListSimulationJobBatches-response-simulationJobBatchSummaries"></a>
A list of simulation job batch summaries\.  
Type: Array of [SimulationJobBatchSummary](API_SimulationJobBatchSummary.md) objects

## Errors<a name="API_ListSimulationJobBatches_Errors"></a>

For information about the errors that are common to all actions, see [Common Errors](CommonErrors.md)\.

 **InternalServerException**   
AWS RoboMaker experienced a service issue\. Try your call again\.  
HTTP Status Code: 500

 **InvalidParameterException**   
A parameter specified in a request is not valid, is unsupported, or cannot be used\. The returned message provides an explanation of the error value\.  
HTTP Status Code: 400

## See Also<a name="API_ListSimulationJobBatches_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/robomaker-2018-06-29/ListSimulationJobBatches) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/robomaker-2018-06-29/ListSimulationJobBatches) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/ListSimulationJobBatches) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/ListSimulationJobBatches) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/ListSimulationJobBatches) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/robomaker-2018-06-29/ListSimulationJobBatches) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/robomaker-2018-06-29/ListSimulationJobBatches) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/robomaker-2018-06-29/ListSimulationJobBatches) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/ListSimulationJobBatches) 