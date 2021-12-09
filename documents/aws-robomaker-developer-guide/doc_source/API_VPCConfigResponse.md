# VPCConfigResponse<a name="API_VPCConfigResponse"></a>

VPC configuration associated with your simulation job\.

## Contents<a name="API_VPCConfigResponse_Contents"></a>

 **assignPublicIp**   <a name="robomaker-Type-VPCConfigResponse-assignPublicIp"></a>
A boolean indicating if a public IP was assigned\.  
Type: Boolean  
Required: No

 **securityGroups**   <a name="robomaker-Type-VPCConfigResponse-securityGroups"></a>
A list of security group IDs associated with the simulation job\.  
Type: Array of strings  
Array Members: Minimum number of 1 item\. Maximum number of 5 items\.  
Length Constraints: Minimum length of 1\. Maximum length of 255\.  
Required: No

 **subnets**   <a name="robomaker-Type-VPCConfigResponse-subnets"></a>
A list of subnet IDs associated with the simulation job\.  
Type: Array of strings  
Array Members: Minimum number of 1 item\. Maximum number of 16 items\.  
Length Constraints: Minimum length of 1\. Maximum length of 255\.  
Required: No

 **vpcId**   <a name="robomaker-Type-VPCConfigResponse-vpcId"></a>
The VPC ID associated with your simulation job\.  
Type: String  
Required: No

## See Also<a name="API_VPCConfigResponse_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/VPCConfigResponse) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/VPCConfigResponse) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/VPCConfigResponse) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/VPCConfigResponse) 