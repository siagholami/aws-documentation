# RobotApplicationConfig<a name="API_RobotApplicationConfig"></a>

Application configuration information for a robot\.

## Contents<a name="API_RobotApplicationConfig_Contents"></a>

 **application**   <a name="robomaker-Type-RobotApplicationConfig-application"></a>
The application information for the robot application\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `arn:.*`   
Required: Yes

 **applicationVersion**   <a name="robomaker-Type-RobotApplicationConfig-applicationVersion"></a>
The version of the robot application\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 255\.  
Pattern: `(\$LATEST)|[0-9]*`   
Required: No

 **launchConfig**   <a name="robomaker-Type-RobotApplicationConfig-launchConfig"></a>
The launch configuration for the robot application\.  
Type: [LaunchConfig](API_LaunchConfig.md) object  
Required: Yes

## See Also<a name="API_RobotApplicationConfig_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/RobotApplicationConfig) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/RobotApplicationConfig) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/RobotApplicationConfig) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/RobotApplicationConfig) 