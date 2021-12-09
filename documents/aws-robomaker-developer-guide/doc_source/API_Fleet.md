# Fleet<a name="API_Fleet"></a>

Information about a fleet\.

## Contents<a name="API_Fleet_Contents"></a>

 **arn**   <a name="robomaker-Type-Fleet-arn"></a>
The Amazon Resource Name \(ARN\) of the fleet\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `arn:.*`   
Required: No

 **createdAt**   <a name="robomaker-Type-Fleet-createdAt"></a>
The time, in milliseconds since the epoch, when the fleet was created\.  
Type: Timestamp  
Required: No

 **lastDeploymentJob**   <a name="robomaker-Type-Fleet-lastDeploymentJob"></a>
The Amazon Resource Name \(ARN\) of the last deployment job\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `arn:.*`   
Required: No

 **lastDeploymentStatus**   <a name="robomaker-Type-Fleet-lastDeploymentStatus"></a>
The status of the last fleet deployment\.  
Type: String  
Valid Values:` Pending | Preparing | InProgress | Failed | Succeeded | Canceled`   
Required: No

 **lastDeploymentTime**   <a name="robomaker-Type-Fleet-lastDeploymentTime"></a>
The time of the last deployment\.  
Type: Timestamp  
Required: No

 **name**   <a name="robomaker-Type-Fleet-name"></a>
The name of the fleet\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 255\.  
Pattern: `[a-zA-Z0-9_\-]*`   
Required: No

## See Also<a name="API_Fleet_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/Fleet) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/Fleet) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/Fleet) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/Fleet) 