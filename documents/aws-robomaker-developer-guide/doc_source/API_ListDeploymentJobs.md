# ListDeploymentJobs<a name="API_ListDeploymentJobs"></a>

Returns a list of deployment jobs for a fleet\. You can optionally provide filters to retrieve specific deployment jobs\. 

## Request Syntax<a name="API_ListDeploymentJobs_RequestSyntax"></a>

```
POST /listDeploymentJobs HTTP/1.1
Content-type: application/json

{
   "[filters](#robomaker-ListDeploymentJobs-request-filters)": [ 
      { 
         "[name](API_Filter.md#robomaker-Type-Filter-name)": "string",
         "[values](API_Filter.md#robomaker-Type-Filter-values)": [ "string" ]
      }
   ],
   "[maxResults](#robomaker-ListDeploymentJobs-request-maxResults)": number,
   "[nextToken](#robomaker-ListDeploymentJobs-request-nextToken)": "string"
}
```

## URI Request Parameters<a name="API_ListDeploymentJobs_RequestParameters"></a>

The request does not use any URI parameters\.

## Request Body<a name="API_ListDeploymentJobs_RequestBody"></a>

The request accepts the following data in JSON format\.

 ** [filters](#API_ListDeploymentJobs_RequestSyntax) **   <a name="robomaker-ListDeploymentJobs-request-filters"></a>
Optional filters to limit results\.  
The filter names `status` and `fleetName` are supported\. When filtering, you must use the complete value of the filtered item\. You can use up to three filters, but they must be for the same named item\. For example, if you are looking for items with the status `InProgress` or the status `Pending`\.  
Type: Array of [Filter](API_Filter.md) objects  
Array Members: Fixed number of 1 item\.  
Required: No

 ** [maxResults](#API_ListDeploymentJobs_RequestSyntax) **   <a name="robomaker-ListDeploymentJobs-request-maxResults"></a>
When this parameter is used, `ListDeploymentJobs` only returns `maxResults` results in a single page along with a `nextToken` response element\. The remaining results of the initial request can be seen by sending another `ListDeploymentJobs` request with the returned `nextToken` value\. This value can be between 1 and 200\. If this parameter is not used, then `ListDeploymentJobs` returns up to 200 results and a `nextToken` value if applicable\.   
Type: Integer  
Required: No

 ** [nextToken](#API_ListDeploymentJobs_RequestSyntax) **   <a name="robomaker-ListDeploymentJobs-request-nextToken"></a>
The `nextToken` value returned from a previous paginated `ListDeploymentJobs` request where `maxResults` was used and the results exceeded the value of that parameter\. Pagination continues from the end of the previous results that returned the `nextToken` value\.   
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 2048\.  
Pattern: `[a-zA-Z0-9_.\-\/+=]*`   
Required: No

## Response Syntax<a name="API_ListDeploymentJobs_ResponseSyntax"></a>

```
HTTP/1.1 200
Content-type: application/json

{
   "[deploymentJobs](#robomaker-ListDeploymentJobs-response-deploymentJobs)": [ 
      { 
         "[arn](API_DeploymentJob.md#robomaker-Type-DeploymentJob-arn)": "string",
         "[createdAt](API_DeploymentJob.md#robomaker-Type-DeploymentJob-createdAt)": number,
         "[deploymentApplicationConfigs](API_DeploymentJob.md#robomaker-Type-DeploymentJob-deploymentApplicationConfigs)": [ 
            { 
               "[application](API_DeploymentApplicationConfig.md#robomaker-Type-DeploymentApplicationConfig-application)": "string",
               "[applicationVersion](API_DeploymentApplicationConfig.md#robomaker-Type-DeploymentApplicationConfig-applicationVersion)": "string",
               "[launchConfig](API_DeploymentApplicationConfig.md#robomaker-Type-DeploymentApplicationConfig-launchConfig)": { 
                  "[environmentVariables](API_DeploymentLaunchConfig.md#robomaker-Type-DeploymentLaunchConfig-environmentVariables)": { 
                     "string" : "string" 
                  },
                  "[launchFile](API_DeploymentLaunchConfig.md#robomaker-Type-DeploymentLaunchConfig-launchFile)": "string",
                  "[packageName](API_DeploymentLaunchConfig.md#robomaker-Type-DeploymentLaunchConfig-packageName)": "string",
                  "[postLaunchFile](API_DeploymentLaunchConfig.md#robomaker-Type-DeploymentLaunchConfig-postLaunchFile)": "string",
                  "[preLaunchFile](API_DeploymentLaunchConfig.md#robomaker-Type-DeploymentLaunchConfig-preLaunchFile)": "string"
               }
            }
         ],
         "[deploymentConfig](API_DeploymentJob.md#robomaker-Type-DeploymentJob-deploymentConfig)": { 
            "[concurrentDeploymentPercentage](API_DeploymentConfig.md#robomaker-Type-DeploymentConfig-concurrentDeploymentPercentage)": number,
            "[downloadConditionFile](API_DeploymentConfig.md#robomaker-Type-DeploymentConfig-downloadConditionFile)": { 
               "[bucket](API_S3Object.md#robomaker-Type-S3Object-bucket)": "string",
               "[etag](API_S3Object.md#robomaker-Type-S3Object-etag)": "string",
               "[key](API_S3Object.md#robomaker-Type-S3Object-key)": "string"
            },
            "[failureThresholdPercentage](API_DeploymentConfig.md#robomaker-Type-DeploymentConfig-failureThresholdPercentage)": number,
            "[robotDeploymentTimeoutInSeconds](API_DeploymentConfig.md#robomaker-Type-DeploymentConfig-robotDeploymentTimeoutInSeconds)": number
         },
         "[failureCode](API_DeploymentJob.md#robomaker-Type-DeploymentJob-failureCode)": "string",
         "[failureReason](API_DeploymentJob.md#robomaker-Type-DeploymentJob-failureReason)": "string",
         "[fleet](API_DeploymentJob.md#robomaker-Type-DeploymentJob-fleet)": "string",
         "[status](API_DeploymentJob.md#robomaker-Type-DeploymentJob-status)": "string"
      }
   ],
   "[nextToken](#robomaker-ListDeploymentJobs-response-nextToken)": "string"
}
```

## Response Elements<a name="API_ListDeploymentJobs_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [deploymentJobs](#API_ListDeploymentJobs_ResponseSyntax) **   <a name="robomaker-ListDeploymentJobs-response-deploymentJobs"></a>
A list of deployment jobs that meet the criteria of the request\.  
Type: Array of [DeploymentJob](API_DeploymentJob.md) objects  
Array Members: Minimum number of 0 items\. Maximum number of 200 items\.

 ** [nextToken](#API_ListDeploymentJobs_ResponseSyntax) **   <a name="robomaker-ListDeploymentJobs-response-nextToken"></a>
The `nextToken` value to include in a future `ListDeploymentJobs` request\. When the results of a `ListDeploymentJobs` request exceed `maxResults`, this value can be used to retrieve the next page of results\. This value is `null` when there are no more results to return\.   
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 2048\.  
Pattern: `[a-zA-Z0-9_.\-\/+=]*` 

## Errors<a name="API_ListDeploymentJobs_Errors"></a>

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

## See Also<a name="API_ListDeploymentJobs_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/robomaker-2018-06-29/ListDeploymentJobs) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/robomaker-2018-06-29/ListDeploymentJobs) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/ListDeploymentJobs) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/ListDeploymentJobs) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/ListDeploymentJobs) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/robomaker-2018-06-29/ListDeploymentJobs) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/robomaker-2018-06-29/ListDeploymentJobs) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/robomaker-2018-06-29/ListDeploymentJobs) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/ListDeploymentJobs) 