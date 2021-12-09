# CreateDeploymentJob<a name="API_CreateDeploymentJob"></a>

Deploys a specific version of a robot application to robots in a fleet\.

The robot application must have a numbered `applicationVersion` for consistency reasons\. To create a new version, use `CreateRobotApplicationVersion` or see [Creating a Robot Application Version](https://docs.aws.amazon.com/robomaker/latest/dg/create-robot-application-version.html)\. 

**Note**  
After 90 days, deployment jobs expire and will be deleted\. They will no longer be accessible\. 

## Request Syntax<a name="API_CreateDeploymentJob_RequestSyntax"></a>

```
POST /createDeploymentJob HTTP/1.1
Content-type: application/json

{
   "[clientRequestToken](#robomaker-CreateDeploymentJob-request-clientRequestToken)": "string",
   "[deploymentApplicationConfigs](#robomaker-CreateDeploymentJob-request-deploymentApplicationConfigs)": [ 
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
   "[deploymentConfig](#robomaker-CreateDeploymentJob-request-deploymentConfig)": { 
      "[concurrentDeploymentPercentage](API_DeploymentConfig.md#robomaker-Type-DeploymentConfig-concurrentDeploymentPercentage)": number,
      "[downloadConditionFile](API_DeploymentConfig.md#robomaker-Type-DeploymentConfig-downloadConditionFile)": { 
         "[bucket](API_S3Object.md#robomaker-Type-S3Object-bucket)": "string",
         "[etag](API_S3Object.md#robomaker-Type-S3Object-etag)": "string",
         "[key](API_S3Object.md#robomaker-Type-S3Object-key)": "string"
      },
      "[failureThresholdPercentage](API_DeploymentConfig.md#robomaker-Type-DeploymentConfig-failureThresholdPercentage)": number,
      "[robotDeploymentTimeoutInSeconds](API_DeploymentConfig.md#robomaker-Type-DeploymentConfig-robotDeploymentTimeoutInSeconds)": number
   },
   "[fleet](#robomaker-CreateDeploymentJob-request-fleet)": "string",
   "[tags](#robomaker-CreateDeploymentJob-request-tags)": { 
      "string" : "string" 
   }
}
```

## URI Request Parameters<a name="API_CreateDeploymentJob_RequestParameters"></a>

The request does not use any URI parameters\.

## Request Body<a name="API_CreateDeploymentJob_RequestBody"></a>

The request accepts the following data in JSON format\.

 ** [clientRequestToken](#API_CreateDeploymentJob_RequestSyntax) **   <a name="robomaker-CreateDeploymentJob-request-clientRequestToken"></a>
Unique, case\-sensitive identifier that you provide to ensure the idempotency of the request\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 64\.  
Pattern: `[a-zA-Z0-9_\-=]*`   
Required: Yes

 ** [deploymentApplicationConfigs](#API_CreateDeploymentJob_RequestSyntax) **   <a name="robomaker-CreateDeploymentJob-request-deploymentApplicationConfigs"></a>
The deployment application configuration\.  
Type: Array of [DeploymentApplicationConfig](API_DeploymentApplicationConfig.md) objects  
Array Members: Fixed number of 1 item\.  
Required: Yes

 ** [deploymentConfig](#API_CreateDeploymentJob_RequestSyntax) **   <a name="robomaker-CreateDeploymentJob-request-deploymentConfig"></a>
The requested deployment configuration\.  
Type: [DeploymentConfig](API_DeploymentConfig.md) object  
Required: No

 ** [fleet](#API_CreateDeploymentJob_RequestSyntax) **   <a name="robomaker-CreateDeploymentJob-request-fleet"></a>
The Amazon Resource Name \(ARN\) of the fleet to deploy\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `arn:.*`   
Required: Yes

 ** [tags](#API_CreateDeploymentJob_RequestSyntax) **   <a name="robomaker-CreateDeploymentJob-request-tags"></a>
A map that contains tag keys and tag values that are attached to the deployment job\.  
Type: String to string map  
Key Length Constraints: Minimum length of 1\. Maximum length of 128\.  
Key Pattern: `[a-zA-Z0-9 _.\-\/+=:]*`   
Value Length Constraints: Minimum length of 0\. Maximum length of 256\.  
Value Pattern: `[a-zA-Z0-9 _.\-\/+=:]*`   
Required: No

## Response Syntax<a name="API_CreateDeploymentJob_ResponseSyntax"></a>

```
HTTP/1.1 200
Content-type: application/json

{
   "[arn](#robomaker-CreateDeploymentJob-response-arn)": "string",
   "[createdAt](#robomaker-CreateDeploymentJob-response-createdAt)": number,
   "[deploymentApplicationConfigs](#robomaker-CreateDeploymentJob-response-deploymentApplicationConfigs)": [ 
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
   "[deploymentConfig](#robomaker-CreateDeploymentJob-response-deploymentConfig)": { 
      "[concurrentDeploymentPercentage](API_DeploymentConfig.md#robomaker-Type-DeploymentConfig-concurrentDeploymentPercentage)": number,
      "[downloadConditionFile](API_DeploymentConfig.md#robomaker-Type-DeploymentConfig-downloadConditionFile)": { 
         "[bucket](API_S3Object.md#robomaker-Type-S3Object-bucket)": "string",
         "[etag](API_S3Object.md#robomaker-Type-S3Object-etag)": "string",
         "[key](API_S3Object.md#robomaker-Type-S3Object-key)": "string"
      },
      "[failureThresholdPercentage](API_DeploymentConfig.md#robomaker-Type-DeploymentConfig-failureThresholdPercentage)": number,
      "[robotDeploymentTimeoutInSeconds](API_DeploymentConfig.md#robomaker-Type-DeploymentConfig-robotDeploymentTimeoutInSeconds)": number
   },
   "[failureCode](#robomaker-CreateDeploymentJob-response-failureCode)": "string",
   "[failureReason](#robomaker-CreateDeploymentJob-response-failureReason)": "string",
   "[fleet](#robomaker-CreateDeploymentJob-response-fleet)": "string",
   "[status](#robomaker-CreateDeploymentJob-response-status)": "string",
   "[tags](#robomaker-CreateDeploymentJob-response-tags)": { 
      "string" : "string" 
   }
}
```

## Response Elements<a name="API_CreateDeploymentJob_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [arn](#API_CreateDeploymentJob_ResponseSyntax) **   <a name="robomaker-CreateDeploymentJob-response-arn"></a>
The Amazon Resource Name \(ARN\) of the deployment job\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `arn:.*` 

 ** [createdAt](#API_CreateDeploymentJob_ResponseSyntax) **   <a name="robomaker-CreateDeploymentJob-response-createdAt"></a>
The time, in milliseconds since the epoch, when the fleet was created\.  
Type: Timestamp

 ** [deploymentApplicationConfigs](#API_CreateDeploymentJob_ResponseSyntax) **   <a name="robomaker-CreateDeploymentJob-response-deploymentApplicationConfigs"></a>
The deployment application configuration\.  
Type: Array of [DeploymentApplicationConfig](API_DeploymentApplicationConfig.md) objects  
Array Members: Fixed number of 1 item\.

 ** [deploymentConfig](#API_CreateDeploymentJob_ResponseSyntax) **   <a name="robomaker-CreateDeploymentJob-response-deploymentConfig"></a>
The deployment configuration\.  
Type: [DeploymentConfig](API_DeploymentConfig.md) object

 ** [failureCode](#API_CreateDeploymentJob_ResponseSyntax) **   <a name="robomaker-CreateDeploymentJob-response-failureCode"></a>
The failure code of the simulation job if it failed:    
BadPermissionError  
AWS Greengrass requires a service\-level role permission to access other services\. The role must include the [ `AWSGreengrassResourceAccessRolePolicy` managed policy](https://console.aws.amazon.com/iam/home?#/policies/arn:aws:iam::aws:policy/service-role/AWSGreengrassResourceAccessRolePolicy$jsonEditor)\.   
ExtractingBundleFailure  
The robot application could not be extracted from the bundle\.  
FailureThresholdBreached  
The percentage of robots that could not be updated exceeded the percentage set for the deployment\.  
GreengrassDeploymentFailed  
The robot application could not be deployed to the robot\.  
GreengrassGroupVersionDoesNotExist  
The AWS Greengrass group or version associated with a robot is missing\.  
InternalServerError  
An internal error has occurred\. Retry your request, but if the problem persists, contact us with details\.  
MissingRobotApplicationArchitecture  
The robot application does not have a source that matches the architecture of the robot\.  
MissingRobotDeploymentResource  
One or more of the resources specified for the robot application are missing\. For example, does the robot application have the correct launch package and launch file?  
PostLaunchFileFailure  
The post\-launch script failed\.  
PreLaunchFileFailure  
The pre\-launch script failed\.  
ResourceNotFound  
One or more deployment resources are missing\. For example, do robot application source bundles still exist?   
RobotDeploymentNoResponse  
There is no response from the robot\. It might not be powered on or connected to the internet\.
Type: String  
Valid Values:` ResourceNotFound | EnvironmentSetupError | EtagMismatch | FailureThresholdBreached | RobotDeploymentAborted | RobotDeploymentNoResponse | RobotAgentConnectionTimeout | GreengrassDeploymentFailed | MissingRobotArchitecture | MissingRobotApplicationArchitecture | MissingRobotDeploymentResource | GreengrassGroupVersionDoesNotExist | ExtractingBundleFailure | PreLaunchFileFailure | PostLaunchFileFailure | BadPermissionError | DownloadConditionFailed | InternalServerError` 

 ** [failureReason](#API_CreateDeploymentJob_ResponseSyntax) **   <a name="robomaker-CreateDeploymentJob-response-failureReason"></a>
The failure reason of the deployment job if it failed\.  
Type: String

 ** [fleet](#API_CreateDeploymentJob_ResponseSyntax) **   <a name="robomaker-CreateDeploymentJob-response-fleet"></a>
The target fleet for the deployment job\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `arn:.*` 

 ** [status](#API_CreateDeploymentJob_ResponseSyntax) **   <a name="robomaker-CreateDeploymentJob-response-status"></a>
The status of the deployment job\.  
Type: String  
Valid Values:` Pending | Preparing | InProgress | Failed | Succeeded | Canceled` 

 ** [tags](#API_CreateDeploymentJob_ResponseSyntax) **   <a name="robomaker-CreateDeploymentJob-response-tags"></a>
The list of all tags added to the deployment job\.  
Type: String to string map  
Key Length Constraints: Minimum length of 1\. Maximum length of 128\.  
Key Pattern: `[a-zA-Z0-9 _.\-\/+=:]*`   
Value Length Constraints: Minimum length of 0\. Maximum length of 256\.  
Value Pattern: `[a-zA-Z0-9 _.\-\/+=:]*` 

## Errors<a name="API_CreateDeploymentJob_Errors"></a>

For information about the errors that are common to all actions, see [Common Errors](CommonErrors.md)\.

 **ConcurrentDeploymentException**   
The failure percentage threshold percentage was met\.  
HTTP Status Code: 400

 **IdempotentParameterMismatchException**   
The request uses the same client token as a previous, but non\-identical request\. Do not reuse a client token with different requests, unless the requests are identical\.   
HTTP Status Code: 400

 **InternalServerException**   
AWS RoboMaker experienced a service issue\. Try your call again\.  
HTTP Status Code: 500

 **InvalidParameterException**   
A parameter specified in a request is not valid, is unsupported, or cannot be used\. The returned message provides an explanation of the error value\.  
HTTP Status Code: 400

 **LimitExceededException**   
The requested resource exceeds the maximum number allowed, or the number of concurrent stream requests exceeds the maximum number allowed\.   
HTTP Status Code: 400

 **ResourceNotFoundException**   
The specified resource does not exist\.  
HTTP Status Code: 400

 **ThrottlingException**   
AWS RoboMaker is temporarily unable to process the request\. Try your call again\.  
HTTP Status Code: 400

## See Also<a name="API_CreateDeploymentJob_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/robomaker-2018-06-29/CreateDeploymentJob) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/robomaker-2018-06-29/CreateDeploymentJob) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/CreateDeploymentJob) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/CreateDeploymentJob) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/CreateDeploymentJob) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/robomaker-2018-06-29/CreateDeploymentJob) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/robomaker-2018-06-29/CreateDeploymentJob) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/robomaker-2018-06-29/CreateDeploymentJob) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/CreateDeploymentJob) 