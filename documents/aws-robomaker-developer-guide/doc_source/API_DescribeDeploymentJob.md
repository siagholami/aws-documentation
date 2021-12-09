# DescribeDeploymentJob<a name="API_DescribeDeploymentJob"></a>

Describes a deployment job\.

## Request Syntax<a name="API_DescribeDeploymentJob_RequestSyntax"></a>

```
POST /describeDeploymentJob HTTP/1.1
Content-type: application/json

{
   "[job](#robomaker-DescribeDeploymentJob-request-job)": "string"
}
```

## URI Request Parameters<a name="API_DescribeDeploymentJob_RequestParameters"></a>

The request does not use any URI parameters\.

## Request Body<a name="API_DescribeDeploymentJob_RequestBody"></a>

The request accepts the following data in JSON format\.

 ** [job](#API_DescribeDeploymentJob_RequestSyntax) **   <a name="robomaker-DescribeDeploymentJob-request-job"></a>
The Amazon Resource Name \(ARN\) of the deployment job\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `arn:.*`   
Required: Yes

## Response Syntax<a name="API_DescribeDeploymentJob_ResponseSyntax"></a>

```
HTTP/1.1 200
Content-type: application/json

{
   "[arn](#robomaker-DescribeDeploymentJob-response-arn)": "string",
   "[createdAt](#robomaker-DescribeDeploymentJob-response-createdAt)": number,
   "[deploymentApplicationConfigs](#robomaker-DescribeDeploymentJob-response-deploymentApplicationConfigs)": [ 
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
   "[deploymentConfig](#robomaker-DescribeDeploymentJob-response-deploymentConfig)": { 
      "[concurrentDeploymentPercentage](API_DeploymentConfig.md#robomaker-Type-DeploymentConfig-concurrentDeploymentPercentage)": number,
      "[downloadConditionFile](API_DeploymentConfig.md#robomaker-Type-DeploymentConfig-downloadConditionFile)": { 
         "[bucket](API_S3Object.md#robomaker-Type-S3Object-bucket)": "string",
         "[etag](API_S3Object.md#robomaker-Type-S3Object-etag)": "string",
         "[key](API_S3Object.md#robomaker-Type-S3Object-key)": "string"
      },
      "[failureThresholdPercentage](API_DeploymentConfig.md#robomaker-Type-DeploymentConfig-failureThresholdPercentage)": number,
      "[robotDeploymentTimeoutInSeconds](API_DeploymentConfig.md#robomaker-Type-DeploymentConfig-robotDeploymentTimeoutInSeconds)": number
   },
   "[failureCode](#robomaker-DescribeDeploymentJob-response-failureCode)": "string",
   "[failureReason](#robomaker-DescribeDeploymentJob-response-failureReason)": "string",
   "[fleet](#robomaker-DescribeDeploymentJob-response-fleet)": "string",
   "[robotDeploymentSummary](#robomaker-DescribeDeploymentJob-response-robotDeploymentSummary)": [ 
      { 
         "[arn](API_RobotDeployment.md#robomaker-Type-RobotDeployment-arn)": "string",
         "[deploymentFinishTime](API_RobotDeployment.md#robomaker-Type-RobotDeployment-deploymentFinishTime)": number,
         "[deploymentStartTime](API_RobotDeployment.md#robomaker-Type-RobotDeployment-deploymentStartTime)": number,
         "[failureCode](API_RobotDeployment.md#robomaker-Type-RobotDeployment-failureCode)": "string",
         "[failureReason](API_RobotDeployment.md#robomaker-Type-RobotDeployment-failureReason)": "string",
         "[progressDetail](API_RobotDeployment.md#robomaker-Type-RobotDeployment-progressDetail)": { 
            "[currentProgress](API_ProgressDetail.md#robomaker-Type-ProgressDetail-currentProgress)": "string",
            "[estimatedTimeRemainingSeconds](API_ProgressDetail.md#robomaker-Type-ProgressDetail-estimatedTimeRemainingSeconds)": number,
            "[percentDone](API_ProgressDetail.md#robomaker-Type-ProgressDetail-percentDone)": number,
            "[targetResource](API_ProgressDetail.md#robomaker-Type-ProgressDetail-targetResource)": "string"
         },
         "[status](API_RobotDeployment.md#robomaker-Type-RobotDeployment-status)": "string"
      }
   ],
   "[status](#robomaker-DescribeDeploymentJob-response-status)": "string",
   "[tags](#robomaker-DescribeDeploymentJob-response-tags)": { 
      "string" : "string" 
   }
}
```

## Response Elements<a name="API_DescribeDeploymentJob_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [arn](#API_DescribeDeploymentJob_ResponseSyntax) **   <a name="robomaker-DescribeDeploymentJob-response-arn"></a>
The Amazon Resource Name \(ARN\) of the deployment job\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `arn:.*` 

 ** [createdAt](#API_DescribeDeploymentJob_ResponseSyntax) **   <a name="robomaker-DescribeDeploymentJob-response-createdAt"></a>
The time, in milliseconds since the epoch, when the deployment job was created\.  
Type: Timestamp

 ** [deploymentApplicationConfigs](#API_DescribeDeploymentJob_ResponseSyntax) **   <a name="robomaker-DescribeDeploymentJob-response-deploymentApplicationConfigs"></a>
The deployment application configuration\.  
Type: Array of [DeploymentApplicationConfig](API_DeploymentApplicationConfig.md) objects  
Array Members: Fixed number of 1 item\.

 ** [deploymentConfig](#API_DescribeDeploymentJob_ResponseSyntax) **   <a name="robomaker-DescribeDeploymentJob-response-deploymentConfig"></a>
The deployment configuration\.  
Type: [DeploymentConfig](API_DeploymentConfig.md) object

 ** [failureCode](#API_DescribeDeploymentJob_ResponseSyntax) **   <a name="robomaker-DescribeDeploymentJob-response-failureCode"></a>
The deployment job failure code\.  
Type: String  
Valid Values:` ResourceNotFound | EnvironmentSetupError | EtagMismatch | FailureThresholdBreached | RobotDeploymentAborted | RobotDeploymentNoResponse | RobotAgentConnectionTimeout | GreengrassDeploymentFailed | MissingRobotArchitecture | MissingRobotApplicationArchitecture | MissingRobotDeploymentResource | GreengrassGroupVersionDoesNotExist | ExtractingBundleFailure | PreLaunchFileFailure | PostLaunchFileFailure | BadPermissionError | DownloadConditionFailed | InternalServerError` 

 ** [failureReason](#API_DescribeDeploymentJob_ResponseSyntax) **   <a name="robomaker-DescribeDeploymentJob-response-failureReason"></a>
A short description of the reason why the deployment job failed\.  
Type: String

 ** [fleet](#API_DescribeDeploymentJob_ResponseSyntax) **   <a name="robomaker-DescribeDeploymentJob-response-fleet"></a>
The Amazon Resource Name \(ARN\) of the fleet\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `arn:.*` 

 ** [robotDeploymentSummary](#API_DescribeDeploymentJob_ResponseSyntax) **   <a name="robomaker-DescribeDeploymentJob-response-robotDeploymentSummary"></a>
A list of robot deployment summaries\.  
Type: Array of [RobotDeployment](API_RobotDeployment.md) objects

 ** [status](#API_DescribeDeploymentJob_ResponseSyntax) **   <a name="robomaker-DescribeDeploymentJob-response-status"></a>
The status of the deployment job\.  
Type: String  
Valid Values:` Pending | Preparing | InProgress | Failed | Succeeded | Canceled` 

 ** [tags](#API_DescribeDeploymentJob_ResponseSyntax) **   <a name="robomaker-DescribeDeploymentJob-response-tags"></a>
The list of all tags added to the specified deployment job\.  
Type: String to string map  
Key Length Constraints: Minimum length of 1\. Maximum length of 128\.  
Key Pattern: `[a-zA-Z0-9 _.\-\/+=:]*`   
Value Length Constraints: Minimum length of 0\. Maximum length of 256\.  
Value Pattern: `[a-zA-Z0-9 _.\-\/+=:]*` 

## Errors<a name="API_DescribeDeploymentJob_Errors"></a>

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

## See Also<a name="API_DescribeDeploymentJob_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/robomaker-2018-06-29/DescribeDeploymentJob) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/robomaker-2018-06-29/DescribeDeploymentJob) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/DescribeDeploymentJob) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/DescribeDeploymentJob) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/DescribeDeploymentJob) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/robomaker-2018-06-29/DescribeDeploymentJob) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/robomaker-2018-06-29/DescribeDeploymentJob) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/robomaker-2018-06-29/DescribeDeploymentJob) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/DescribeDeploymentJob) 