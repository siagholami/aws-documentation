# CodeGuru Reviewer and interface VPC endpoints \(AWS PrivateLink\)<a name="vpc-interface-endpoints"></a>

 You can use VPC endpoints when you call Amazon CodeGuru Reviewer APIs\. When you use VPC endpoints, your API calls are more secure because they are contained within your VPC and do not access the internet\. For more information, see [Actions](https://docs.aws.amazon.com/codeguru/latest/reviewer-api/API_Operations.html) in the *Amazon CodeGuru Reviewer API Reference*\. 

You establish a private connection between your VPC and CodeGuru Reviewer by creating an *interface VPC endpoint*\. Interface endpoints are powered by [AWS PrivateLink](http://aws.amazon.com/privatelink), a technology that enables you to privately access CodeGuru Reviewer APIs without an internet gateway, NAT device, VPN connection, or AWS Direct Connect connection\. Instances in your VPC don't need public IP addresses to communicate with CodeGuru Reviewer APIs\. Traffic between your VPC and CodeGuru Reviewer does not leave the Amazon network\. 

Each interface endpoint is represented by one or more [Elastic Network Interfaces](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-eni.html) in your subnets\. 

For more information, see [Interface VPC endpoints \(AWS PrivateLink\)](https://docs.aws.amazon.com/vpc/latest/userguide/vpce-interface.html) in the *Amazon VPC User Guide*\. 

**Note**  
CodeGuru Reviewer does not support Amazon VPC endpoint policies\.

## Considerations for CodeGuru Reviewer VPC endpoints<a name="vpc-endpoint-considerations"></a>

Before you set up an interface VPC endpoint for CodeGuru Reviewer, ensure that you review [Interface endpoint properties and limitations](https://docs.aws.amazon.com/vpc/latest/userguide/vpce-interface.html#vpce-interface-limitations) in the *Amazon VPC User Guide*\. 

CodeGuru Reviewer supports making calls to all of its API actions from your VPC\. 

VPC endpoint policies are not supported for CodeGuru Reviewer\. By default, full access to CodeGuru Reviewer is allowed through the endpoint\. For more information, see [Controlling access to services with VPC endpoints](https://docs.aws.amazon.com/vpc/latest/userguide/vpc-endpoints-access.html) in the *Amazon VPC User Guide*\.

## Creating an interface VPC endpoint for CodeGuru Reviewer<a name="vpc-endpoint-create"></a>

You can create a VPC endpoint for the CodeGuru Reviewer service using either the Amazon VPC console or the AWS Command Line Interface \(AWS CLI\)\. For more information, see [Creating an interface endpoint](https://docs.aws.amazon.com/vpc/latest/userguide/vpce-interface.html#create-interface-endpoint) in the *Amazon VPC User Guide*\.

Create a VPC endpoint for CodeGuru Reviewer using the following service name: 
+ com\.amazonaws\.*region*\.codeguru\-reviewer 

If you enable private DNS for the endpoint, you can make API requests to CodeGuru Reviewer using its default DNS name for the Region, for example, `codeguru-reviewer.us-east-1.amazonaws.com`\. 

For more information, see [Accessing a service through an interface endpoint](https://docs.aws.amazon.com/vpc/latest/userguide/vpce-interface.html#access-service-though-endpoint) in the *Amazon VPC User Guide*\.