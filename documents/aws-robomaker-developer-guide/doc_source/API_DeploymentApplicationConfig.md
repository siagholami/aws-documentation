# DeploymentApplicationConfig<a name="API_DeploymentApplicationConfig"></a>

Information about a deployment application configuration\.

## Contents<a name="API_DeploymentApplicationConfig_Contents"></a>

 **application**   <a name="robomaker-Type-DeploymentApplicationConfig-application"></a>
The Amazon Resource Name \(ARN\) of the robot application\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `arn:.*`   
Required: Yes

 **applicationVersion**   <a name="robomaker-Type-DeploymentApplicationConfig-applicationVersion"></a>
The version of the application\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 255\.  
Pattern: `[0-9]*`   
Required: Yes

 **launchConfig**   <a name="robomaker-Type-DeploymentApplicationConfig-launchConfig"></a>
The launch configuration\.  
Type: [DeploymentLaunchConfig](API_DeploymentLaunchConfig.md) object  
Required: Yes

## See Also<a name="API_DeploymentApplicationConfig_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/DeploymentApplicationConfig) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/DeploymentApplicationConfig) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/DeploymentApplicationConfig) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/DeploymentApplicationConfig) 