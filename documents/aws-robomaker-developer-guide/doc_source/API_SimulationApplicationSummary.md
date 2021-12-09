# SimulationApplicationSummary<a name="API_SimulationApplicationSummary"></a>

Summary information for a simulation application\.

## Contents<a name="API_SimulationApplicationSummary_Contents"></a>

 **arn**   <a name="robomaker-Type-SimulationApplicationSummary-arn"></a>
The Amazon Resource Name \(ARN\) of the simulation application\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `arn:.*`   
Required: No

 **lastUpdatedAt**   <a name="robomaker-Type-SimulationApplicationSummary-lastUpdatedAt"></a>
The time, in milliseconds since the epoch, when the simulation application was last updated\.  
Type: Timestamp  
Required: No

 **name**   <a name="robomaker-Type-SimulationApplicationSummary-name"></a>
The name of the simulation application\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 255\.  
Pattern: `[a-zA-Z0-9_\-]*`   
Required: No

 **robotSoftwareSuite**   <a name="robomaker-Type-SimulationApplicationSummary-robotSoftwareSuite"></a>
Information about a robot software suite \(ROS distribution\)\.  
Type: [RobotSoftwareSuite](API_RobotSoftwareSuite.md) object  
Required: No

 **simulationSoftwareSuite**   <a name="robomaker-Type-SimulationApplicationSummary-simulationSoftwareSuite"></a>
Information about a simulation software suite\.  
Type: [SimulationSoftwareSuite](API_SimulationSoftwareSuite.md) object  
Required: No

 **version**   <a name="robomaker-Type-SimulationApplicationSummary-version"></a>
The version of the simulation application\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 255\.  
Pattern: `(\$LATEST)|[0-9]*`   
Required: No

## See Also<a name="API_SimulationApplicationSummary_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/SimulationApplicationSummary) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/SimulationApplicationSummary) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/SimulationApplicationSummary) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/SimulationApplicationSummary) 