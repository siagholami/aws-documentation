# ListSimulationApplications<a name="API_ListSimulationApplications"></a>

Returns a list of simulation applications\. You can optionally provide filters to retrieve specific simulation applications\. 

## Request Syntax<a name="API_ListSimulationApplications_RequestSyntax"></a>

```
POST /listSimulationApplications HTTP/1.1
Content-type: application/json

{
   "[filters](#robomaker-ListSimulationApplications-request-filters)": [ 
      { 
         "[name](API_Filter.md#robomaker-Type-Filter-name)": "string",
         "[values](API_Filter.md#robomaker-Type-Filter-values)": [ "string" ]
      }
   ],
   "[maxResults](#robomaker-ListSimulationApplications-request-maxResults)": number,
   "[nextToken](#robomaker-ListSimulationApplications-request-nextToken)": "string",
   "[versionQualifier](#robomaker-ListSimulationApplications-request-versionQualifier)": "string"
}
```

## URI Request Parameters<a name="API_ListSimulationApplications_RequestParameters"></a>

The request does not use any URI parameters\.

## Request Body<a name="API_ListSimulationApplications_RequestBody"></a>

The request accepts the following data in JSON format\.

 ** [filters](#API_ListSimulationApplications_RequestSyntax) **   <a name="robomaker-ListSimulationApplications-request-filters"></a>
Optional list of filters to limit results\.  
The filter name `name` is supported\. When filtering, you must use the complete value of the filtered item\. You can use up to three filters\.  
Type: Array of [Filter](API_Filter.md) objects  
Array Members: Fixed number of 1 item\.  
Required: No

 ** [maxResults](#API_ListSimulationApplications_RequestSyntax) **   <a name="robomaker-ListSimulationApplications-request-maxResults"></a>
When this parameter is used, `ListSimulationApplications` only returns `maxResults` results in a single page along with a `nextToken` response element\. The remaining results of the initial request can be seen by sending another `ListSimulationApplications` request with the returned `nextToken` value\. This value can be between 1 and 100\. If this parameter is not used, then `ListSimulationApplications` returns up to 100 results and a `nextToken` value if applicable\.   
Type: Integer  
Required: No

 ** [nextToken](#API_ListSimulationApplications_RequestSyntax) **   <a name="robomaker-ListSimulationApplications-request-nextToken"></a>
The `nextToken` value returned from a previous paginated `ListSimulationApplications` request where `maxResults` was used and the results exceeded the value of that parameter\. Pagination continues from the end of the previous results that returned the `nextToken` value\.   
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 2048\.  
Pattern: `[a-zA-Z0-9_.\-\/+=]*`   
Required: No

 ** [versionQualifier](#API_ListSimulationApplications_RequestSyntax) **   <a name="robomaker-ListSimulationApplications-request-versionQualifier"></a>
The version qualifier of the simulation application\.  
Type: String  
Pattern: `ALL`   
Required: No

## Response Syntax<a name="API_ListSimulationApplications_ResponseSyntax"></a>

```
HTTP/1.1 200
Content-type: application/json

{
   "[nextToken](#robomaker-ListSimulationApplications-response-nextToken)": "string",
   "[simulationApplicationSummaries](#robomaker-ListSimulationApplications-response-simulationApplicationSummaries)": [ 
      { 
         "[arn](API_SimulationApplicationSummary.md#robomaker-Type-SimulationApplicationSummary-arn)": "string",
         "[lastUpdatedAt](API_SimulationApplicationSummary.md#robomaker-Type-SimulationApplicationSummary-lastUpdatedAt)": number,
         "[name](API_SimulationApplicationSummary.md#robomaker-Type-SimulationApplicationSummary-name)": "string",
         "[robotSoftwareSuite](API_SimulationApplicationSummary.md#robomaker-Type-SimulationApplicationSummary-robotSoftwareSuite)": { 
            "[name](API_RobotSoftwareSuite.md#robomaker-Type-RobotSoftwareSuite-name)": "string",
            "[version](API_RobotSoftwareSuite.md#robomaker-Type-RobotSoftwareSuite-version)": "string"
         },
         "[simulationSoftwareSuite](API_SimulationApplicationSummary.md#robomaker-Type-SimulationApplicationSummary-simulationSoftwareSuite)": { 
            "[name](API_SimulationSoftwareSuite.md#robomaker-Type-SimulationSoftwareSuite-name)": "string",
            "[version](API_SimulationSoftwareSuite.md#robomaker-Type-SimulationSoftwareSuite-version)": "string"
         },
         "[version](API_SimulationApplicationSummary.md#robomaker-Type-SimulationApplicationSummary-version)": "string"
      }
   ]
}
```

## Response Elements<a name="API_ListSimulationApplications_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [nextToken](#API_ListSimulationApplications_ResponseSyntax) **   <a name="robomaker-ListSimulationApplications-response-nextToken"></a>
The `nextToken` value to include in a future `ListSimulationApplications` request\. When the results of a `ListRobot` request exceed `maxResults`, this value can be used to retrieve the next page of results\. This value is `null` when there are no more results to return\.   
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 2048\.  
Pattern: `[a-zA-Z0-9_.\-\/+=]*` 

 ** [simulationApplicationSummaries](#API_ListSimulationApplications_ResponseSyntax) **   <a name="robomaker-ListSimulationApplications-response-simulationApplicationSummaries"></a>
A list of simulation application summaries that meet the criteria of the request\.  
Type: Array of [SimulationApplicationSummary](API_SimulationApplicationSummary.md) objects  
Array Members: Minimum number of 0 items\. Maximum number of 100 items\.

## Errors<a name="API_ListSimulationApplications_Errors"></a>

For information about the errors that are common to all actions, see [Common Errors](CommonErrors.md)\.

 **InternalServerException**   
AWS RoboMaker experienced a service issue\. Try your call again\.  
HTTP Status Code: 500

 **InvalidParameterException**   
A parameter specified in a request is not valid, is unsupported, or cannot be used\. The returned message provides an explanation of the error value\.  
HTTP Status Code: 400

 **ThrottlingException**   
AWS RoboMaker is temporarily unable to process the request\. Try your call again\.  
HTTP Status Code: 400

## See Also<a name="API_ListSimulationApplications_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/robomaker-2018-06-29/ListSimulationApplications) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/robomaker-2018-06-29/ListSimulationApplications) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/ListSimulationApplications) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/ListSimulationApplications) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/ListSimulationApplications) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/robomaker-2018-06-29/ListSimulationApplications) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/robomaker-2018-06-29/ListSimulationApplications) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/robomaker-2018-06-29/ListSimulationApplications) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/ListSimulationApplications) 