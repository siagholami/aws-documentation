--------

--------

# DataSourceVpcConfiguration<a name="API_DataSourceVpcConfiguration"></a>

Provides information for connecting to an Amazon VPC\.

## Contents<a name="API_DataSourceVpcConfiguration_Contents"></a>

 **SecurityGroupIds**   <a name="Kendra-Type-DataSourceVpcConfiguration-SecurityGroupIds"></a>
A list of identifiers of security groups within your Amazon VPC\. The security groups should enable Amazon Kendra to connect to the data source\.  
Type: Array of strings  
Array Members: Minimum number of 1 item\. Maximum number of 10 items\.  
Length Constraints: Minimum length of 1\. Maximum length of 200\.  
Pattern: `[-0-9a-zA-Z]+`   
Required: Yes

 **SubnetIds**   <a name="Kendra-Type-DataSourceVpcConfiguration-SubnetIds"></a>
A list of identifiers for subnets within your Amazon VPC\. The subnets should be able to connect to each other in the VPC, and they should have outgoing access to the Internet through a NAT device\.  
Type: Array of strings  
Array Members: Minimum number of 1 item\. Maximum number of 6 items\.  
Length Constraints: Minimum length of 1\. Maximum length of 200\.  
Pattern: `[\-0-9a-zA-Z]+`   
Required: Yes

## See Also<a name="API_DataSourceVpcConfiguration_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/DataSourceVpcConfiguration) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/DataSourceVpcConfiguration) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/DataSourceVpcConfiguration) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/DataSourceVpcConfiguration) 