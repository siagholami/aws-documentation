# DeploymentLaunchConfig<a name="API_DeploymentLaunchConfig"></a>

Configuration information for a deployment launch\.

## Contents<a name="API_DeploymentLaunchConfig_Contents"></a>

 **environmentVariables**   <a name="robomaker-Type-DeploymentLaunchConfig-environmentVariables"></a>
An array of key/value pairs specifying environment variables for the robot application  
Type: String to string map  
Key Length Constraints: Minimum length of 1\. Maximum length of 1024\.  
Key Pattern: `[A-Z_][A-Z0-9_]*`   
Value Length Constraints: Minimum length of 1\. Maximum length of 1024\.  
Value Pattern: `.*`   
Required: No

 **launchFile**   <a name="robomaker-Type-DeploymentLaunchConfig-launchFile"></a>
The launch file name\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1024\.  
Pattern: `[a-zA-Z0-9_.\-]*`   
Required: Yes

 **packageName**   <a name="robomaker-Type-DeploymentLaunchConfig-packageName"></a>
The package name\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1024\.  
Pattern: `[a-zA-Z0-9_.\-]*`   
Required: Yes

 **postLaunchFile**   <a name="robomaker-Type-DeploymentLaunchConfig-postLaunchFile"></a>
The deployment post\-launch file\. This file will be executed after the launch file\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1024\.  
Pattern: `.*`   
Required: No

 **preLaunchFile**   <a name="robomaker-Type-DeploymentLaunchConfig-preLaunchFile"></a>
The deployment pre\-launch file\. This file will be executed prior to the launch file\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1024\.  
Pattern: `.*`   
Required: No

## See Also<a name="API_DeploymentLaunchConfig_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/DeploymentLaunchConfig) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/DeploymentLaunchConfig) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/DeploymentLaunchConfig) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/DeploymentLaunchConfig) 