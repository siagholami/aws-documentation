# DeploymentJob<a name="API_DeploymentJob"></a>

Information about a deployment job\.

## Contents<a name="API_DeploymentJob_Contents"></a>

 **arn**   <a name="robomaker-Type-DeploymentJob-arn"></a>
The Amazon Resource Name \(ARN\) of the deployment job\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `arn:.*`   
Required: No

 **createdAt**   <a name="robomaker-Type-DeploymentJob-createdAt"></a>
The time, in milliseconds since the epoch, when the deployment job was created\.  
Type: Timestamp  
Required: No

 **deploymentApplicationConfigs**   <a name="robomaker-Type-DeploymentJob-deploymentApplicationConfigs"></a>
The deployment application configuration\.  
Type: Array of [DeploymentApplicationConfig](API_DeploymentApplicationConfig.md) objects  
Array Members: Fixed number of 1 item\.  
Required: No

 **deploymentConfig**   <a name="robomaker-Type-DeploymentJob-deploymentConfig"></a>
The deployment configuration\.  
Type: [DeploymentConfig](API_DeploymentConfig.md) object  
Required: No

 **failureCode**   <a name="robomaker-Type-DeploymentJob-failureCode"></a>
The deployment job failure code\.  
Type: String  
Valid Values:` ResourceNotFound | EnvironmentSetupError | EtagMismatch | FailureThresholdBreached | RobotDeploymentAborted | RobotDeploymentNoResponse | RobotAgentConnectionTimeout | GreengrassDeploymentFailed | MissingRobotArchitecture | MissingRobotApplicationArchitecture | MissingRobotDeploymentResource | GreengrassGroupVersionDoesNotExist | ExtractingBundleFailure | PreLaunchFileFailure | PostLaunchFileFailure | BadPermissionError | DownloadConditionFailed | InternalServerError`   
Required: No

 **failureReason**   <a name="robomaker-Type-DeploymentJob-failureReason"></a>
A short description of the reason why the deployment job failed\.  
Type: String  
Required: No

 **fleet**   <a name="robomaker-Type-DeploymentJob-fleet"></a>
The Amazon Resource Name \(ARN\) of the fleet\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `arn:.*`   
Required: No

 **status**   <a name="robomaker-Type-DeploymentJob-status"></a>
The status of the deployment job\.  
Type: String  
Valid Values:` Pending | Preparing | InProgress | Failed | Succeeded | Canceled`   
Required: No

## See Also<a name="API_DeploymentJob_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/DeploymentJob) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/DeploymentJob) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/DeploymentJob) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/DeploymentJob) 