# ListFleets<a name="API_ListFleets"></a>

Returns a list of fleets\. You can optionally provide filters to retrieve specific fleets\. 

## Request Syntax<a name="API_ListFleets_RequestSyntax"></a>

```
POST /listFleets HTTP/1.1
Content-type: application/json

{
   "[filters](#robomaker-ListFleets-request-filters)": [ 
      { 
         "[name](API_Filter.md#robomaker-Type-Filter-name)": "string",
         "[values](API_Filter.md#robomaker-Type-Filter-values)": [ "string" ]
      }
   ],
   "[maxResults](#robomaker-ListFleets-request-maxResults)": number,
   "[nextToken](#robomaker-ListFleets-request-nextToken)": "string"
}
```

## URI Request Parameters<a name="API_ListFleets_RequestParameters"></a>

The request does not use any URI parameters\.

## Request Body<a name="API_ListFleets_RequestBody"></a>

The request accepts the following data in JSON format\.

 ** [filters](#API_ListFleets_RequestSyntax) **   <a name="robomaker-ListFleets-request-filters"></a>
Optional filters to limit results\.  
The filter name `name` is supported\. When filtering, you must use the complete value of the filtered item\. You can use up to three filters\.  
Type: Array of [Filter](API_Filter.md) objects  
Array Members: Fixed number of 1 item\.  
Required: No

 ** [maxResults](#API_ListFleets_RequestSyntax) **   <a name="robomaker-ListFleets-request-maxResults"></a>
When this parameter is used, `ListFleets` only returns `maxResults` results in a single page along with a `nextToken` response element\. The remaining results of the initial request can be seen by sending another `ListFleets` request with the returned `nextToken` value\. This value can be between 1 and 200\. If this parameter is not used, then `ListFleets` returns up to 200 results and a `nextToken` value if applicable\.   
Type: Integer  
Required: No

 ** [nextToken](#API_ListFleets_RequestSyntax) **   <a name="robomaker-ListFleets-request-nextToken"></a>
The `nextToken` value returned from a previous paginated `ListFleets` request where `maxResults` was used and the results exceeded the value of that parameter\. Pagination continues from the end of the previous results that returned the `nextToken` value\.   
This token should be treated as an opaque identifier that is only used to retrieve the next items in a list and not for other programmatic purposes\.
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 2048\.  
Pattern: `[a-zA-Z0-9_.\-\/+=]*`   
Required: No

## Response Syntax<a name="API_ListFleets_ResponseSyntax"></a>

```
HTTP/1.1 200
Content-type: application/json

{
   "[fleetDetails](#robomaker-ListFleets-response-fleetDetails)": [ 
      { 
         "[arn](API_Fleet.md#robomaker-Type-Fleet-arn)": "string",
         "[createdAt](API_Fleet.md#robomaker-Type-Fleet-createdAt)": number,
         "[lastDeploymentJob](API_Fleet.md#robomaker-Type-Fleet-lastDeploymentJob)": "string",
         "[lastDeploymentStatus](API_Fleet.md#robomaker-Type-Fleet-lastDeploymentStatus)": "string",
         "[lastDeploymentTime](API_Fleet.md#robomaker-Type-Fleet-lastDeploymentTime)": number,
         "[name](API_Fleet.md#robomaker-Type-Fleet-name)": "string"
      }
   ],
   "[nextToken](#robomaker-ListFleets-response-nextToken)": "string"
}
```

## Response Elements<a name="API_ListFleets_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [fleetDetails](#API_ListFleets_ResponseSyntax) **   <a name="robomaker-ListFleets-response-fleetDetails"></a>
A list of fleet details meeting the request criteria\.  
Type: Array of [Fleet](API_Fleet.md) objects  
Array Members: Minimum number of 0 items\. Maximum number of 200 items\.

 ** [nextToken](#API_ListFleets_ResponseSyntax) **   <a name="robomaker-ListFleets-response-nextToken"></a>
The `nextToken` value to include in a future `ListDeploymentJobs` request\. When the results of a `ListFleets` request exceed `maxResults`, this value can be used to retrieve the next page of results\. This value is `null` when there are no more results to return\.   
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 2048\.  
Pattern: `[a-zA-Z0-9_.\-\/+=]*` 

## Errors<a name="API_ListFleets_Errors"></a>

For information about the errors that are common to all actions, see [Common Errors](CommonErrors.md)\.

 **InternalServerException**   
AWS RoboMaker experienced a service issue\. Try your call again\.  
HTTP Status Code: 500

 **InvalidParameterException**   
A parameter specified in a request is not valid, is unsupported, or cannot be used\. The returned message provides an explanation of the error value\.  
HTTP Status Code: 400

 **ResourceNotFoundException**   
The specified resource does not exist\.  
HTTP Status Code: 400

 **ThrottlingException**   
AWS RoboMaker is temporarily unable to process the request\. Try your call again\.  
HTTP Status Code: 400

## See Also<a name="API_ListFleets_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/robomaker-2018-06-29/ListFleets) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/robomaker-2018-06-29/ListFleets) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/ListFleets) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/ListFleets) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/ListFleets) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/robomaker-2018-06-29/ListFleets) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/robomaker-2018-06-29/ListFleets) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/robomaker-2018-06-29/ListFleets) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/ListFleets) 