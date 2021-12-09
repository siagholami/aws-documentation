# Create an Interface VPC Endpoint to Connect to Managed Blockchain Network Resources<a name="managed-blockchain-endpoints"></a>

Each member of a blockchain network on Managed Blockchain needs to privately access resource endpoints from their client applications and tools\. Amazon Managed Blockchain uses [Interface VPC Endpoints \(AWS PrivateLink\)](https://docs.aws.amazon.com/vpc/latest/userguide/vpce-interface.html) to accomplish this\.

Managed Blockchain creates a *VPC service name* for each network when it is created\. Each Managed Blockchain network is a unique *endpoint service* with its own VPC service name\. Each member then uses the VPC service name to create an interface VPC endpoint in their account\. This interface VPC endpoint lets you access resources on the Managed Blockchain network through their endpoints\. AWS accounts that are not invited to the network don't have access to the VPC service name and cannot set up an interface VPC endpoint for access\.

The IAM principal \(user\) identity that you are using must have sufficient IAM permissions to create an interface VPC endpoint in your AWS account\. For more information, see [Controlling Access \- Creating and Managing VPC Endpoints](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_IAM.html#vpc-endpoints-iam) in the *Amazon VPC User Guide*\.

Any blockchain framework clients that access resources on the network need access to the interface VPC endpoint\. For example, if you use an Amazon EC2 instance as a blockchain framework client, you can create it in a subnet and security group that are shared with the interface VPC endpoint\.

Applicable charges for interface VPC endpoints apply\. For more information, see [AWS PrivateLink Pricing](https://aws.amazon.com/privatelink/pricing/)\.

The interface VPC endpoint that you set up to access a Managed Blockchain network must be enabled for private DNS names\. This requires that you create the endpoint in a VPC that has the `enableDnsHostnames` and `enableDnsSupport` options set to `true`\.

**To create an interface VPC endpoint using the Managed Blockchain console**

1. Open the Managed Blockchain console at [https://console\.aws\.amazon\.com/managedblockchain/](https://console.aws.amazon.com/managedblockchain/)\.

1. Choose **Networks**, select your network from the list, and then choose **View details**\.

1. Choose **Create VPC endpoint**\.

1. Choose a **VPC**\.

1. For **Subnets**, choose a subnet from the list, and then choose additional subnets as necessary\.

1. For **Security groups**, choose an EC2 security group from the list, and then choose additional security groups as necessary\. We recommend that you select the same security group that your framework client EC2 instance is associated with\.

1. Choose **Create**\.

**To create an interface VPC Endpoint for the Managed Blockchain network**

1. Find the **VPC endpoint service name** of the network\. This value is returned by `get-network` command using the Managed Blockchain CLI, and is available on the network **Details** page using the Managed Blockchain console \(choose **Networks**, select the network from the list, and then choose **View details**\)\.

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. Choose **Endpoints**, **Create Endpoint**\.

1. Choose **Find service by name**\. For **Service Name**, enter the VPC Endpoint Service Name from step 1\.

1. Choose **Verify** and then choose **Create endpoint**\.

1. Make sure that **Enable Private DNS Name** is selected\. This option is only available if the VPC you selected has **Enable DNS hostnames** and **Enable DNS support** set to true for the VPC\. This is a requirement for the VPC\.

1. We recommend that the EC2 security group that you specify for the VPC endpoint is the same as the EC2 security group for the blockchain client that you create to work with the Managed Blockchain network\.