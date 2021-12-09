# ListRobots<a name="API_ListRobots"></a>

Returns a list of robots\. You can optionally provide filters to retrieve specific robots\.

## Request Syntax<a name="API_ListRobots_RequestSyntax"></a>

```
POST /listRobots HTTP/1.1
Content-type: application/json

{
   "[filters](#robomaker-ListRobots-request-filters)": [ 
      { 
         "[name](API_Filter.md#robomaker-Type-Filter-name)": "string",
         "[values](API_Filter.md#robomaker-Type-Filter-values)": [ "string" ]
      }
   ],
   "[maxResults](#robomaker-ListRobots-request-maxResults)": number,
   "[nextToken](#robomaker-ListRobots-request-nextToken)": "string"
}
```

## URI Request Parameters<a name="API_ListRobots_RequestParameters"></a>

The request does not use any URI parameters\.

## Request Body<a name="API_ListRobots_RequestBody"></a>

The request accepts the following data in JSON format\.

 ** [filters](#API_ListRobots_RequestSyntax) **   <a name="robomaker-ListRobots-request-filters"></a>
Optional filters to limit results\.  
The filter names `status` and `fleetName` are supported\. When filtering, you must use the complete value of the filtered item\. You can use up to three filters, but they must be for the same named item\. For example, if you are looking for items with the status `Registered` or the status `Available`\.  
Type: Array of [Filter](API_Filter.md) objects  
Array Members: Fixed number of 1 item\.  
Required: No

 ** [maxResults](#API_ListRobots_RequestSyntax) **   <a name="robomaker-ListRobots-request-maxResults"></a>
When this parameter is used, `ListRobots` only returns `maxResults` results in a single page along with a `nextToken` response element\. The remaining results of the initial request can be seen by sending another `ListRobots` request with the returned `nextToken` value\. This value can be between 1 and 200\. If this parameter is not used, then `ListRobots` returns up to 200 results and a `nextToken` value if applicable\.   
Type: Integer  
Required: No

 ** [nextToken](#API_ListRobots_RequestSyntax) **   <a name="robomaker-ListRobots-request-nextToken"></a>
The `nextToken` value returned from a previous paginated `ListRobots` request where `maxResults` was used and the results exceeded the value of that parameter\. Pagination continues from the end of the previous results that returned the `nextToken` value\.   
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 2048\.  
Pattern: `[a-zA-Z0-9_.\-\/+=]*`   
Required: No

## Response Syntax<a name="API_ListRobots_ResponseSyntax"></a>

```
HTTP/1.1 200
Content-type: application/json

{
   "[nextToken](#robomaker-ListRobots-response-nextToken)": "string",
   "[robots](#robomaker-ListRobots-response-robots)": [ 
      { 
         "[architecture](API_Robot.md#robomaker-Type-Robot-architecture)": "string",
         "[arn](API_Robot.md#robomaker-Type-Robot-arn)": "string",
         "[createdAt](API_Robot.md#robomaker-Type-Robot-createdAt)": number,
         "[fleetArn](API_Robot.md#robomaker-Type-Robot-fleetArn)": "string",
         "[greenGrassGroupId](API_Robot.md#robomaker-Type-Robot-greenGrassGroupId)": "string",
         "[lastDeploymentJob](API_Robot.md#robomaker-Type-Robot-lastDeploymentJob)": "string",
         "[lastDeploymentTime](API_Robot.md#robomaker-Type-Robot-lastDeploymentTime)": number,
         "[name](API_Robot.md#robomaker-Type-Robot-name)": "string",
         "[status](API_Robot.md#robomaker-Type-Robot-status)": "string"
      }
   ]
}
```

## Response Elements<a name="API_ListRobots_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [nextToken](#API_ListRobots_ResponseSyntax) **   <a name="robomaker-ListRobots-response-nextToken"></a>
The `nextToken` value to include in a future `ListRobots` request\. When the results of a `ListRobot` request exceed `maxResults`, this value can be used to retrieve the next page of results\. This value is `null` when there are no more results to return\.   
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 2048\.  
Pattern: `[a-zA-Z0-9_.\-\/+=]*` 

 ** [robots](#API_ListRobots_ResponseSyntax) **   <a name="robomaker-ListRobots-response-robots"></a>
A list of robots that meet the criteria of the request\.  
Type: Array of [Robot](API_Robot.md) objects  
Array Members: Minimum number of 0 items\. Maximum number of 1000 items\.

## Errors<a name="API_ListRobots_Errors"></a>

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

## See Also<a name="API_ListRobots_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/robomaker-2018-06-29/ListRobots) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/robomaker-2018-06-29/ListRobots) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/ListRobots) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/ListRobots) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/ListRobots) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/robomaker-2018-06-29/ListRobots) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/robomaker-2018-06-29/ListRobots) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/robomaker-2018-06-29/ListRobots) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/ListRobots) 