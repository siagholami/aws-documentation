# SimulationApplicationConfig<a name="API_SimulationApplicationConfig"></a>

Information about a simulation application configuration\.

## Contents<a name="API_SimulationApplicationConfig_Contents"></a>

 **application**   <a name="robomaker-Type-SimulationApplicationConfig-application"></a>
The application information for the simulation application\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `arn:.*`   
Required: Yes

 **applicationVersion**   <a name="robomaker-Type-SimulationApplicationConfig-applicationVersion"></a>
The version of the simulation application\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 255\.  
Pattern: `(\$LATEST)|[0-9]*`   
Required: No

 **launchConfig**   <a name="robomaker-Type-SimulationApplicationConfig-launchConfig"></a>
The launch configuration for the simulation application\.  
Type: [LaunchConfig](API_LaunchConfig.md) object  
Required: Yes

## See Also<a name="API_SimulationApplicationConfig_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/SimulationApplicationConfig) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/SimulationApplicationConfig) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/SimulationApplicationConfig) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/SimulationApplicationConfig) 