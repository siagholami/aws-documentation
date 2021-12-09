# DeploymentConfig<a name="API_DeploymentConfig"></a>

Information about a deployment configuration\.

## Contents<a name="API_DeploymentConfig_Contents"></a>

 **concurrentDeploymentPercentage**   <a name="robomaker-Type-DeploymentConfig-concurrentDeploymentPercentage"></a>
The percentage of robots receiving the deployment at the same time\.  
Type: Integer  
Valid Range: Minimum value of 1\. Maximum value of 100\.  
Required: No

 **downloadConditionFile**   <a name="robomaker-Type-DeploymentConfig-downloadConditionFile"></a>
The download condition file\.  
Type: [S3Object](API_S3Object.md) object  
Required: No

 **failureThresholdPercentage**   <a name="robomaker-Type-DeploymentConfig-failureThresholdPercentage"></a>
The percentage of deployments that need to fail before stopping deployment\.  
Type: Integer  
Valid Range: Minimum value of 1\. Maximum value of 100\.  
Required: No

 **robotDeploymentTimeoutInSeconds**   <a name="robomaker-Type-DeploymentConfig-robotDeploymentTimeoutInSeconds"></a>
The amount of time, in seconds, to wait for deployment to a single robot to complete\. Choose a time between 1 minute and 7 days\. The default is 5 hours\.  
Type: Long  
Required: No

## See Also<a name="API_DeploymentConfig_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/DeploymentConfig) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/DeploymentConfig) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/DeploymentConfig) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/DeploymentConfig) 