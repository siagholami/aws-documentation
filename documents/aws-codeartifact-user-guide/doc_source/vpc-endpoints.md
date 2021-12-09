# Working with Amazon VPC endpoints<a name="vpc-endpoints"></a>

 You can configure CodeArtifact to use an interface virtual private cloud \(VPC\) endpoint to improve the security of your VPC\. 

VPC endpoints use AWS PrivateLink, a service that makes it possible for you to access CodeArtifact APIs through private IP addresses\. AWS PrivateLink restricts all network traffic between your VPC and CodeArtifact to the AWS network\. When you use an interface VPC endpoint, you don't need an internet gateway, NAT device, or virtual private gateway\. For more information, see [VPC Endpoints](https://docs.aws.amazon.com/vpc/latest/userguide/vpc-endpoints.html) in the *Amazon Virtual Private Cloud User Guide*\. 

**Important**  
 VPC endpoints do not support cross\-AWS Region requests\. Make sure that you create your endpoint in the same AWS Region where you plan to issue your API calls to CodeArtifact\. 
 VPC endpoints only support Amazon\-provided DNS through Amazon Route 53\. If you want to use your own DNS, you can use conditional DNS forwarding\. For more information, see [DHCP Option Sets](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_DHCP_Options.html) in the *Amazon Virtual Private Cloud User Guide*\. 
 The security group attached to the VPC endpoint must allow incoming connections on port 443 from the private subnet of the VPC\. 

**Topics**
+ [Create VPC endpoints](create-vpc-endpoints.md)
+ [Create the Amazon S3 gateway endpoint](create-s3-gateway-endpoint.md)
+ [Use CodeArtifact from a VPC](use-codeartifact-from-vpc.md)
+ [Create a VPC endpoint policy](create-vpc-endoint-policy.md)