# RobotApplicationSummary<a name="API_RobotApplicationSummary"></a>

Summary information for a robot application\.

## Contents<a name="API_RobotApplicationSummary_Contents"></a>

 **arn**   <a name="robomaker-Type-RobotApplicationSummary-arn"></a>
The Amazon Resource Name \(ARN\) of the robot\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `arn:.*`   
Required: No

 **lastUpdatedAt**   <a name="robomaker-Type-RobotApplicationSummary-lastUpdatedAt"></a>
The time, in milliseconds since the epoch, when the robot application was last updated\.  
Type: Timestamp  
Required: No

 **name**   <a name="robomaker-Type-RobotApplicationSummary-name"></a>
The name of the robot application\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 255\.  
Pattern: `[a-zA-Z0-9_\-]*`   
Required: No

 **robotSoftwareSuite**   <a name="robomaker-Type-RobotApplicationSummary-robotSoftwareSuite"></a>
Information about a robot software suite \(ROS distribution\)\.  
Type: [RobotSoftwareSuite](API_RobotSoftwareSuite.md) object  
Required: No

 **version**   <a name="robomaker-Type-RobotApplicationSummary-version"></a>
The version of the robot application\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 255\.  
Pattern: `(\$LATEST)|[0-9]*`   
Required: No

## See Also<a name="API_RobotApplicationSummary_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/RobotApplicationSummary) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/RobotApplicationSummary) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/RobotApplicationSummary) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/RobotApplicationSummary) 