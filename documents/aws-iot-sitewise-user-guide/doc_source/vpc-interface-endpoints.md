# AWS IoT SiteWise and interface VPC endpoints \(AWS PrivateLink\)<a name="vpc-interface-endpoints"></a>

You can establish a private connection between your virtual private cloud \(VPC\) and AWS IoT SiteWise by creating an *interface VPC endpoint*\. Interface endpoints are powered by [AWS PrivateLink](http://aws.amazon.com/privatelink), a technology that lets you privately access AWS IoT SiteWise APIs without an internet gateway, NAT device, VPN connection, or AWS Direct Connect connection\. Instances in your VPC don't need public IP addresses to communicate with AWS IoT SiteWise APIs\. Traffic between your VPC and AWS IoT SiteWise doesn't leave the AWS network\.

Each interface endpoint is represented by one or more [elastic network interfaces](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-eni.html) in your subnets\. 

For more information, see [Interface VPC endpoints \(AWS PrivateLink\)](https://docs.aws.amazon.com/vpc/latest/userguide/vpce-interface.html) in the *Amazon VPC User Guide*\. 

## Considerations for AWS IoT SiteWise VPC endpoints<a name="vpc-endpoint-considerations"></a>

Before you set up an interface VPC endpoint for AWS IoT SiteWise, review the [Interface endpoint properties and limitations](https://docs.aws.amazon.com/vpc/latest/userguide/vpce-interface.html#vpce-interface-limitations) in the *Amazon VPC User Guide*\. 

AWS IoT SiteWise supports making calls to the following API operations from your VPC:
+ [BatchPutAssetPropertyValue](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_BatchPutAssetPropertyValue.html)
+ [GetAssetPropertyAggregates](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_GetAssetPropertyAggregates.html)
+ [GetAssetPropertyValue](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_GetAssetPropertyValue.html)
+ [GetAssetPropertyValueHistory](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_GetAssetPropertyValueHistory.html)

VPC endpoint policies are not supported for AWS IoT SiteWise\. By default, full access to AWS IoT SiteWise is allowed through the endpoint\. For more information, see [Controlling access to services with VPC endpoints](https://docs.aws.amazon.com/vpc/latest/userguide/vpc-endpoints-access.html) in the *Amazon VPC User Guide*\.

## Creating an interface VPC endpoint for AWS IoT SiteWise<a name="vpc-endpoint-create"></a>

You can create a VPC endpoint for the AWS IoT SiteWise service\. Use either the Amazon VPC console or the AWS Command Line Interface \(AWS CLI\)\. For more information, see [Creating an interface endpoint](https://docs.aws.amazon.com/vpc/latest/userguide/vpce-interface.html#create-interface-endpoint) in the *Amazon VPC User Guide*\.

Create a VPC endpoint for AWS IoT SiteWise using the following service name: 
+ com\.amazonaws\.*region*\.iotsitewise\.data 

## Accessing AWS IoT SiteWise through an interface VPC endpoint<a name="vpc-endpoint-access"></a>

If you enable private DNS for the endpoint, you can make API requests to AWS IoT SiteWise using its default DNS name for the AWS Region, for example, `iotsitewise.us-east-1.amazonaws.com`\. Private DNS is enabled by default\.

If you disable private DNS for the endpoint, you must do the following to access AWS IoT SiteWise through the endpoint:
+ Specify the VPC endpoint in API requests\.

  For the data plane actions \(`BatchPutAssetPropertyValue`, `GetAssetPropertyAggregates`, `GetAssetPropertyValue`, and `GetAssetPropertyValueHistory`\) use the following endpoint\. Replace *vpc\-endpoint\-id* and *region* with your VPC endpoint ID and Region\.

  ```
  vpc-endpoint-id.data.iotsitewise.region.vpce.amazonaws.com
  ```
+ Disable host prefix injection\. The AWS CLI and AWS SDKs prepend the service endpoint with various host prefixes when you call each API operation\. This feature causes the AWS CLI and AWS SDKs to produce invalid URLs for AWS IoT SiteWise when you specify a VPC endpoint\.
**Important**  
You can't disable host prefix injection in the AWS CLI or the AWS Tools for PowerShell\. This means that if you disable private DNS, then you can't use these tools to access AWS IoT SiteWise through the VPC endpoint\. Enable private DNS to use the AWS CLI or the AWS Tools for PowerShell to access AWS IoT SiteWise through the endpoint\.

  For more information about how to disable host prefix injection in the AWS SDKs, see the following sections of each SDK's documentation:
  + [AWS SDK for C\+\+](https://sdk.amazonaws.com/cpp/api/LATEST/struct_aws_1_1_client_1_1_client_configuration.html#a3579c1a2f2e1c9d54e99c59d27643499)
  + [AWS SDK for Go](https://docs.aws.amazon.com/sdk-for-go/api/aws/#Config.WithDisableEndpointHostPrefix)
  + [AWS SDK for Go v2](https://docs.aws.amazon.com/sdk-for-go/v2/api/aws/#Config)
  + [AWS SDK for Java](https://docs.aws.amazon.com/AWSJavaSDK/latest/javadoc/com/amazonaws/ClientConfiguration.html#setDisableHostPrefixInjection-boolean-)
  + [AWS SDK for Java 2\.x](https://sdk.amazonaws.com/java/api/latest/software/amazon/awssdk/core/client/config/SdkAdvancedClientOption.html)
  + [AWS SDK for JavaScript](https://docs.aws.amazon.com/AWSJavaScriptSDK/latest/AWS/Config.html#hostPrefixEnabled-property)
  + [AWS SDK for \.NET](https://docs.aws.amazon.com/sdkfornet/v3/apidocs/items/Runtime/TClientConfig.html)
  + [AWS SDK for PHP](https://docs.aws.amazon.com/aws-sdk-php/v3/api/class-Aws.AwsClient.html#___construct)
  + [AWS SDK for Python \(Boto3\)](https://botocore.amazonaws.com/v1/documentation/api/latest/reference/config.html)
  + [AWS SDK for Ruby](https://docs.aws.amazon.com/sdk-for-ruby/v3/api/Aws/IoTSiteWise/Client.html#initialize-instance_method)

For more information, see [Accessing a service through an interface endpoint](https://docs.aws.amazon.com/vpc/latest/userguide/vpce-interface.html#access-service-though-endpoint) in the *Amazon VPC User Guide*\.