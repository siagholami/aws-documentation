# SimulationJobRequest<a name="API_SimulationJobRequest"></a>

Information about a simulation job request\.

## Contents<a name="API_SimulationJobRequest_Contents"></a>

 **dataSources**   <a name="robomaker-Type-SimulationJobRequest-dataSources"></a>
Specify data sources to mount read\-only files from S3 into your simulation\. These files are available under `/opt/robomaker/datasources/data_source_name`\.   
There is a limit of 100 files and a combined size of 25GB for all `DataSourceConfig` objects\. 
Type: Array of [DataSourceConfig](API_DataSourceConfig.md) objects  
Array Members: Minimum number of 1 item\. Maximum number of 5 items\.  
Required: No

 **failureBehavior**   <a name="robomaker-Type-SimulationJobRequest-failureBehavior"></a>
The failure behavior the simulation job\.    
Continue  
Restart the simulation job in the same host instance\.  
Fail  
Stop the simulation job and terminate the instance\.
Type: String  
Valid Values:` Fail | Continue`   
Required: No

 **iamRole**   <a name="robomaker-Type-SimulationJobRequest-iamRole"></a>
The IAM role name that allows the simulation instance to call the AWS APIs that are specified in its associated policies on your behalf\. This is how credentials are passed in to your simulation job\.   
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 255\.  
Pattern: `arn:aws:iam::\w+:role/.*`   
Required: No

 **loggingConfig**   <a name="robomaker-Type-SimulationJobRequest-loggingConfig"></a>
The logging configuration\.  
Type: [LoggingConfig](API_LoggingConfig.md) object  
Required: No

 **maxJobDurationInSeconds**   <a name="robomaker-Type-SimulationJobRequest-maxJobDurationInSeconds"></a>
The maximum simulation job duration in seconds\. The value must be 8 days \(691,200 seconds\) or less\.  
Type: Long  
Required: Yes

 **outputLocation**   <a name="robomaker-Type-SimulationJobRequest-outputLocation"></a>
The output location\.  
Type: [OutputLocation](API_OutputLocation.md) object  
Required: No

 **robotApplications**   <a name="robomaker-Type-SimulationJobRequest-robotApplications"></a>
The robot applications to use in the simulation job\.  
Type: Array of [RobotApplicationConfig](API_RobotApplicationConfig.md) objects  
Array Members: Fixed number of 1 item\.  
Required: No

 **simulationApplications**   <a name="robomaker-Type-SimulationJobRequest-simulationApplications"></a>
The simulation applications to use in the simulation job\.  
Type: Array of [SimulationApplicationConfig](API_SimulationApplicationConfig.md) objects  
Array Members: Fixed number of 1 item\.  
Required: No

 **tags**   <a name="robomaker-Type-SimulationJobRequest-tags"></a>
A map that contains tag keys and tag values that are attached to the simulation job request\.  
Type: String to string map  
Key Length Constraints: Minimum length of 1\. Maximum length of 128\.  
Key Pattern: `[a-zA-Z0-9 _.\-\/+=:]*`   
Value Length Constraints: Minimum length of 0\. Maximum length of 256\.  
Value Pattern: `[a-zA-Z0-9 _.\-\/+=:]*`   
Required: No

 **useDefaultApplications**   <a name="robomaker-Type-SimulationJobRequest-useDefaultApplications"></a>
Boolean indicating whether to use default simulation tool applications\.  
Type: Boolean  
Required: No

 **vpcConfig**   <a name="robomaker-Type-SimulationJobRequest-vpcConfig"></a>
If your simulation job accesses resources in a VPC, you provide this parameter identifying the list of security group IDs and subnet IDs\. These must belong to the same VPC\. You must provide at least one security group and two subnet IDs\.  
Type: [VPCConfig](API_VPCConfig.md) object  
Required: No

## See Also<a name="API_SimulationJobRequest_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/SimulationJobRequest) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/SimulationJobRequest) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/SimulationJobRequest) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/SimulationJobRequest) 