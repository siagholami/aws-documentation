# Work with Hyperledger Fabric<a name="framework-client"></a>

You access services and applications in the Managed Blockchain network from a blockchain framework client\. The framework client runs tools and applications that you install for the blockchain framework version that you run on the Managed Blockchain network\.

The client accesses Managed Blockchain network resource endpoints using an interface VPC endpoint that you set up in your account\. For more information, see [Create an Interface VPC Endpoint to Connect to Managed Blockchain Network Resources](managed-blockchain-endpoints.md)\. The client must have access to the interface VPC endpoint\.

You can get the endpoints that networks, members, and clients make available using the AWS Management Console, or using `get` commands and actions with the AWS CLI or Managed Blockchain SDK\. The available endpoints depend on the blockchain framework and may vary from client to client\.

An AWS CloudFormation template to create a Hyperledger Fabric client is available in [amazon\-managed\-blockchain\-client\-templates repository](https://github.com/awslabs/amazon-managed-blockchain-client-templates) on Github\. For more information, see the [readme\.md](https://github.com/awslabs/amazon-managed-blockchain-client-templates/blob/master/README.md) in that repository\. For more information about using AWS CloudFormation, see [Getting Started](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/GettingStarted.Walkthrough.html) in the *AWS CloudFormation User Guide*\.

**Topics**
+ [Register and Enroll a User as an Administrator](managed-blockchain-hyperledger-create-admin.md)
+ [Develop Chaincode](managed-blockchain-hyperledger-write-and-run-chaincode.md)