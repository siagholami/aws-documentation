# VPCConfig<a name="API_VPCConfig"></a>

If your simulation job accesses resources in a VPC, you provide this parameter identifying the list of security group IDs and subnet IDs\. These must belong to the same VPC\. You must provide at least one security group and two subnet IDs\.

## Contents<a name="API_VPCConfig_Contents"></a>

 **assignPublicIp**   <a name="robomaker-Type-VPCConfig-assignPublicIp"></a>
A boolean indicating whether to assign a public IP address\.  
Type: Boolean  
Required: No

 **securityGroups**   <a name="robomaker-Type-VPCConfig-securityGroups"></a>
A list of one or more security groups IDs in your VPC\.  
Type: Array of strings  
Array Members: Minimum number of 1 item\. Maximum number of 5 items\.  
Length Constraints: Minimum length of 1\. Maximum length of 255\.  
Required: No

 **subnets**   <a name="robomaker-Type-VPCConfig-subnets"></a>
A list of one or more subnet IDs in your VPC\.  
Type: Array of strings  
Array Members: Minimum number of 1 item\. Maximum number of 16 items\.  
Length Constraints: Minimum length of 1\. Maximum length of 255\.  
Required: Yes

## See Also<a name="API_VPCConfig_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/VPCConfig) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/VPCConfig) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/VPCConfig) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/VPCConfig) 