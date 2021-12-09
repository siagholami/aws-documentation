# SimulationJobSummary<a name="API_SimulationJobSummary"></a>

Summary information for a simulation job\.

## Contents<a name="API_SimulationJobSummary_Contents"></a>

 **arn**   <a name="robomaker-Type-SimulationJobSummary-arn"></a>
The Amazon Resource Name \(ARN\) of the simulation job\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `arn:.*`   
Required: No

 **dataSourceNames**   <a name="robomaker-Type-SimulationJobSummary-dataSourceNames"></a>
The names of the data sources\.  
Type: Array of strings  
Length Constraints: Minimum length of 1\. Maximum length of 255\.  
Pattern: `[a-zA-Z0-9_\-]*`   
Required: No

 **lastUpdatedAt**   <a name="robomaker-Type-SimulationJobSummary-lastUpdatedAt"></a>
The time, in milliseconds since the epoch, when the simulation job was last updated\.  
Type: Timestamp  
Required: No

 **name**   <a name="robomaker-Type-SimulationJobSummary-name"></a>
The name of the simulation job\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 255\.  
Pattern: `[a-zA-Z0-9_\-]*`   
Required: No

 **robotApplicationNames**   <a name="robomaker-Type-SimulationJobSummary-robotApplicationNames"></a>
A list of simulation job robot application names\.  
Type: Array of strings  
Length Constraints: Minimum length of 1\. Maximum length of 255\.  
Pattern: `[a-zA-Z0-9_\-]*`   
Required: No

 **simulationApplicationNames**   <a name="robomaker-Type-SimulationJobSummary-simulationApplicationNames"></a>
A list of simulation job simulation application names\.  
Type: Array of strings  
Length Constraints: Minimum length of 1\. Maximum length of 255\.  
Pattern: `[a-zA-Z0-9_\-]*`   
Required: No

 **status**   <a name="robomaker-Type-SimulationJobSummary-status"></a>
The status of the simulation job\.  
Type: String  
Valid Values:` Pending | Preparing | Running | Restarting | Completed | Failed | RunningFailed | Terminating | Terminated | Canceled`   
Required: No

## See Also<a name="API_SimulationJobSummary_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/SimulationJobSummary) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/SimulationJobSummary) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/SimulationJobSummary) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/SimulationJobSummary) 