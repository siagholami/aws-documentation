# Robot<a name="API_Robot"></a>

Information about a robot\.

## Contents<a name="API_Robot_Contents"></a>

 **architecture**   <a name="robomaker-Type-Robot-architecture"></a>
The architecture of the robot\.  
Type: String  
Valid Values:` X86_64 | ARM64 | ARMHF`   
Required: No

 **arn**   <a name="robomaker-Type-Robot-arn"></a>
The Amazon Resource Name \(ARN\) of the robot\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `arn:.*`   
Required: No

 **createdAt**   <a name="robomaker-Type-Robot-createdAt"></a>
The time, in milliseconds since the epoch, when the robot was created\.  
Type: Timestamp  
Required: No

 **fleetArn**   <a name="robomaker-Type-Robot-fleetArn"></a>
The Amazon Resource Name \(ARN\) of the fleet\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `arn:.*`   
Required: No

 **greenGrassGroupId**   <a name="robomaker-Type-Robot-greenGrassGroupId"></a>
The Greengrass group associated with the robot\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `.*`   
Required: No

 **lastDeploymentJob**   <a name="robomaker-Type-Robot-lastDeploymentJob"></a>
The Amazon Resource Name \(ARN\) of the last deployment job\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `arn:.*`   
Required: No

 **lastDeploymentTime**   <a name="robomaker-Type-Robot-lastDeploymentTime"></a>
The time of the last deployment\.  
Type: Timestamp  
Required: No

 **name**   <a name="robomaker-Type-Robot-name"></a>
The name of the robot\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 255\.  
Pattern: `[a-zA-Z0-9_\-]*`   
Required: No

 **status**   <a name="robomaker-Type-Robot-status"></a>
The status of the robot\.  
Type: String  
Valid Values:` Available | Registered | PendingNewDeployment | Deploying | Failed | InSync | NoResponse`   
Required: No

## See Also<a name="API_Robot_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/Robot) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/Robot) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/Robot) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/Robot) 