# Create an Amazon Managed Blockchain Network<a name="create-network"></a>

When a user in an AWS account creates a blockchain network on Amazon Managed Blockchain, they also create the first member in the network\. This first member has no peer nodes associated with it until you create them\. After you create the network and the first member, you can use that member to create an invitation proposal for other members in the same AWS account or in other AWS accounts\. Any member can create an invitation proposal\.

When you create the network and the first member in your AWS account, the network exists\. However, transactions cannot be conducted and the ledger does not exist because there are no peer nodes\. Do the following tasks to make your network functional:
+ Create an interface VPC endpoint based on the network's **VPC service name** so that you can privately connect to resources\. For more information, see [Create an Interface VPC Endpoint to Connect to Managed Blockchain Network Resources](managed-blockchain-endpoints.md)\.
+ Create at least one peer node in your first membership to interact with the network and to create and endorse transactions\. For more information, see [Work with Peer Nodes in a Managed Blockchain Network](managed-blockchain-hyperledger-peer-nodes.md)\.
+ Create an invitation proposal for other AWS accounts to be members of the network, or invite an additional member in your account to simulate a multi\-AWS account network\. Vote Yes on your own proposal to approve it and create the invitation\. For more information about inviting members, see [Create an Invitation Proposal](managed-blockchain-proposals.md#managed-blockchain-propose-invitation)\.

## Create a Managed Blockchain Network<a name="create-network-procedure"></a>

You can create a Managed Blockchain network using the AWS Management Console, the AWS CLI, or the Managed Blockchain SDK [CreateNetwork](https://docs.aws.amazon.com/managed-blockchain/latest/APIReference/>CreateNetwork.html) action\.

### To create a Managed Blockchain network using the AWS Management Console<a name="w22aac11c11b5b1"></a>

1. Open the Managed Blockchain console at [https://console\.aws\.amazon\.com/managedblockchain/](https://console.aws.amazon.com/managedblockchain/)\.

1. Choose **Create network**\.

1. Under **Blockchain framework**:

   1. Select the blockchain framework to use\. This tutorial is based on **Hyperledger Fabric version 1\.2**\.

   1. Select the **Network edition** to use\. The network edition determines attributes of the network, such as the maximum number of members, nodes per member, and transaction throughput\. Different editions have different rates associated with the membership\. For more information, see [Amazon Managed Blockchain Pricing](https://aws.amazon.com/managed-blockchain/pricing)\.

1. Enter a **Network name and description**\.

1. Under **Voting Policy**, choose the following:

   1. Enter the **Approval threshold percentage** along with the comparator, either **Greater than** or **Greater than or equal to**\. For a proposal to pass, the Yes votes cast must meet this threshold before the vote duration expires\.

   1. Enter the **Proposal duration in hours**\. If enough votes are not cast within this duration to either approve or reject a proposal, the proposal status is `EXPIRED`, no further votes on this proposal are allowed, and the proposal does not pass\.

1. Choose **Next**, and then, under **Create member**, do the following to define the first member for the network, which you own:

   1. Enter a **Member name** that will be visible to all members and an optional **Description**\.

   1. Under **Hyperledger Fabric certificate authority \(CA\) configuration** specify a username and password to be used as the administrator on the Hyperledger Fabric CA\. Remember the user name and password\. You need them later any time that you create users and resources that need to authenticate\.

   1. Choose **Create member and join network**\.

1. Review **Network options** and **Member options**, and then choose **Create network and member**\.

   The **Networks** list shows the name and **Network ID** of the network you created, with a **Status** of **Creating**\. It may take a minute or two for Managed Blockchain to create your network, after which the **Status** is **Active**\.

### To create a Managed Blockchain network using the AWS CLI<a name="w22aac11c11b5b3"></a>

Use the `create-network` command as shown in the following example\. Consider the following:
+ The example shows `HYPERLEDGER_FABRIC` as the `Framework` and `1.2` as the `FrameworkVersion`\. The `FrameworkConfiguration` properties for `--network-configuration` and `--member-configuration` options may be different for other frameworks and versions\.
+ The `AdminPassword` must be at least 8 characters long and no more than 32 characters\. It must contain at least one uppercase letter, one lowercase letter, and one digit\. It cannot have a single quote\(‘\), double quote\(“\), forward slash\(/\), backward slash\(\\\), @, percent sign \(%\), or a space\.
+ Remember the user name and password\. You need them later any time you create users and resources that need to authenticate\.

```
[ec2-user@ip-192-0-2-17 ~]$ aws managedblockchain create-network \
--network-configuration '{"Name":"OurBlockchainNet", \
"Description":"OurBlockchainNetDesc", \
"Framework":"HYPERLEDGER_FABRIC","FrameworkVersion": "1.2", \
"FrameworkConfiguration": {"Fabric": {"Edition": "STARTER"}}, \
"VotingPolicy": {"ApprovalThresholdPolicy": {"ThresholdPercentage": 50, \
"ProposalDurationInHours": 24, \
"ThresholdComparator": "GREATER_THAN"}}}' \
--member-configuration '{"Name":"org1", \
"Description":"Org1 first member of network",\
"FrameworkConfiguration":{"Fabric":{"AdminUsername":"AdminUser","AdminPassword":"Password123"}}}'
```

The command returns the Network ID and the Member ID, as shown in the following example:

```
{
    "NetworkId": "n-MWY63ZJZU5HGNCMBQER7IN6OIU",
    "MemberId": "m-K46ICRRXJRCGRNNS4ES4XUUS5A"
}
```