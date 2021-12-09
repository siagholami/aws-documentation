# Create a Member and Join a Network<a name="managed-blockchain-hyperledger-create-member"></a>

You can use the Managed Blockchain console, the AWS CLI, or the Managed Blockchain SDK [CreateMember](https://docs.aws.amazon.com/managed-blockchain/latest/APIReference/>API_CreateMember.html) action to create a member in a network that your account is invited to\. If you created the Managed Blockchain network, you create the first member when you create the network\. All subsequent members must be invited to join by way of a member proposal\.

After you create the member, for the member to be functional on the network, your account must have a VPC endpoint associated with the VPC endpoint service name published by the network\. For more information, see [Create an Interface VPC Endpoint to Connect to Managed Blockchain Network Resources](managed-blockchain-endpoints.md)\. You also must create at least one peer node in your membership\. For more information, see [Work with Peer Nodes in a Managed Blockchain Network](managed-blockchain-hyperledger-peer-nodes.md)\.

## To accept an invitation to create a member and join a network using the AWS Management Console<a name="w22aac17c15b9b1"></a>

1. Open the Managed Blockchain console at [https://console\.aws\.amazon\.com/managedblockchain/](https://console.aws.amazon.com/managedblockchain/)\.

1. From the navigation pane, choose **Invitations**\.

1. Select the invitation that you want to accept from the list, and then choose **Accept invitation**\. To view more information about the network you are invited to join, choose the network **Name** from the list

1. Under **Join network**, configure your network member according to the following guidelines:

   1. Enter a **Member name** that will be visible to all members and an optional **Description**\.

   1. Under **Hyperledger Fabric certificate authority \(CA\) configuration** specify a username and password to be used as the administrator on the Hyperledger Fabric CA\. Remember the user name and password\. You need them later any time that you create users and resources that need to authenticate\.

   1. Choose **Create member and join network**\.

1. Choose **Create member**\.

## To accept an invitation to create a member and join a network using the AWS CLI<a name="w22aac17c15b9b3"></a>
+ Use the `create-member` command similar to the example below\. Replace the value of `--network-id` with the Network ID that you are joining and `--invitation-id` with the Invitation ID sent to your account from the network\.

  ```
  aws managedblockchain create-member \
  --network-id n-MWY63ZJZU5HGNCMBQER7IN6OIU \
  --invitation-id i-XL9MDD6LVWWDNA9FF94Y4TFTE \
  --member-configuration 'Name=org2,Description=MyMemberDesc,\
  FrameworkConfiguration={Fabric={AdminUsername=MyAdminUsername,\
  AdminPassword=Password123}}'
  ```

  The command returns output similar to the following:

  ```
  {
  "MemberId": "m-J46DNSFRTVCCLONS9DT5TTLS2A"
  }
  ```

After you create the member, you can use the `get-member` command to return important details about the member configuration\.