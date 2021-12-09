# RobotDeployment<a name="API_RobotDeployment"></a>

Information about a robot deployment\.

## Contents<a name="API_RobotDeployment_Contents"></a>

 **arn**   <a name="robomaker-Type-RobotDeployment-arn"></a>
The robot deployment Amazon Resource Name \(ARN\)\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `arn:.*`   
Required: No

 **deploymentFinishTime**   <a name="robomaker-Type-RobotDeployment-deploymentFinishTime"></a>
The time, in milliseconds since the epoch, when the deployment finished\.  
Type: Timestamp  
Required: No

 **deploymentStartTime**   <a name="robomaker-Type-RobotDeployment-deploymentStartTime"></a>
The time, in milliseconds since the epoch, when the deployment was started\.  
Type: Timestamp  
Required: No

 **failureCode**   <a name="robomaker-Type-RobotDeployment-failureCode"></a>
The robot deployment failure code\.  
Type: String  
Valid Values:` ResourceNotFound | EnvironmentSetupError | EtagMismatch | FailureThresholdBreached | RobotDeploymentAborted | RobotDeploymentNoResponse | RobotAgentConnectionTimeout | GreengrassDeploymentFailed | MissingRobotArchitecture | MissingRobotApplicationArchitecture | MissingRobotDeploymentResource | GreengrassGroupVersionDoesNotExist | ExtractingBundleFailure | PreLaunchFileFailure | PostLaunchFileFailure | BadPermissionError | DownloadConditionFailed | InternalServerError`   
Required: No

 **failureReason**   <a name="robomaker-Type-RobotDeployment-failureReason"></a>
A short description of the reason why the robot deployment failed\.  
Type: String  
Required: No

 **progressDetail**   <a name="robomaker-Type-RobotDeployment-progressDetail"></a>
Information about how the deployment is progressing\.  
Type: [ProgressDetail](API_ProgressDetail.md) object  
Required: No

 **status**   <a name="robomaker-Type-RobotDeployment-status"></a>
The status of the robot deployment\.  
Type: String  
Valid Values:` Available | Registered | PendingNewDeployment | Deploying | Failed | InSync | NoResponse`   
Required: No

## See Also<a name="API_RobotDeployment_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/RobotDeployment) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/RobotDeployment) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/RobotDeployment) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/RobotDeployment) 