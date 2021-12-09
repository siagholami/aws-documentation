# Using AWS CloudTrail with Interface VPC Endpoints<a name="cloudtrail-and-interface-VPC"></a>

If you use Amazon Virtual Private Cloud \(Amazon VPC\) to host your AWS resources, you can establish a private connection between your VPC and AWS CloudTrail\. You can use this connection to enable CloudTrail to communicate with your resources on your VPC without going through the public internet\.

Amazon VPC is an AWS service that you can use to launch AWS resources in a virtual network that you define\. With a VPC, you have control over your network settings, such the IP address range, subnets, route tables, and network gateways\. With VPC endpoints, the routing between the VPC and AWS Services is handled by the AWS network, and you can use IAM policies to control access to service resources\.

To connect your VPC to CloudTrail, you define an *interface VPC endpoint* for CloudTrail\. An interface endpoint is an elastic network interface with a private IP address that serves as an entry point for traffic destined to a supported AWS service\. The endpoint provides reliable, scalable connectivity to CloudTrail without requiring an internet gateway, network address translation \(NAT\) instance, or VPN connection\. For more information, see [What is Amazon VPC](https://docs.aws.amazon.com/vpc/latest/userguide/) in the *Amazon VPC User Guide*\.

 Interface VPC endpoints are powered by AWS PrivateLink, an AWS technology that enables private communication between AWS services using an elastic network interface with private IP addresses\. For more information, see [AWS PrivateLink](https://aws.amazon.com/privatelink/)\.

The following steps are for users of Amazon VPC\. For more information, see [Getting Started](https://docs.aws.amazon.com/vpc/latest/userguide/GetStarted.html) in the *Amazon VPC User Guide*\.

## Availability<a name="cloudtrail-interface-VPC-availability"></a>

CloudTrail currently supports VPC endpoints in the following AWS Regions:
+ US East \(Ohio\)
+ US East \(N\. Virginia\)
+ US West \(N\. California\)
+ US West \(Oregon\)
+ Asia Pacific \(Mumbai\)
+ Asia Pacific \(Seoul\)
+ Asia Pacific \(Singapore\)
+ Asia Pacific \(Sydney\)
+ Asia Pacific \(Tokyo\)
+ Canada \(Central\)
+ Europe \(Frankfurt\)
+ Europe \(Ireland\)
+ Europe \(London\)
+ Europe \(Paris\)
+ South America \(São Paulo\)

## Create a VPC Endpoint for CloudTrail<a name="create-VPC-endpoint-for-CloudTrail"></a>

To start using CloudTrail with your VPC, create an interface VPC endpoint for CloudTrail\. For more information, see [Creating an Interface Endpoint](https://docs.aws.amazon.com/vpc/latest/userguide/vpce-interface.html#create-interface-endpoint.html) in the *Amazon VPC User Guide*\.

You don't need to change the settings for CloudTrail\. CloudTrail calls other AWS services using either public endpoints or private interface VPC endpoints, whichever are in use\. 