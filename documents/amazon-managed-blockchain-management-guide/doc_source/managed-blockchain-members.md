# Invite or Remove Members<a name="managed-blockchain-members"></a>

To invite and remove other network members, any member can create a *proposal* that is submitted for a vote to all network members\. If a proposal is approved within the duration and with the percentage of Yes votes specified in the voting policy for the network, the appropriate action is carried out\.

A member can only join the network through an approved invitation proposal\. The exception is the first member, which is created along with the network\. The first member then submits a proposal and is the sole voter on the proposal to invite the second member\. An AWS account can delete members from the network that they own directly\. A proposal is not required\. To delete a member in a different AWS account, a proposal to remove the member is required\. Information about all proposals, including the member who created the proposal, the current vote count, and more is available to all network members\.

This topic provides basic information for creating proposals to invite or remove members, and to delete a member that your AWS account owns\. For more detailed information about proposals, including how to vote on a proposal, see [Work with Proposals](managed-blockchain-proposals.md)\.

## Create a Proposal to Invite an AWS Account to the Network<a name="managed-blockchain-create-invitation"></a>

You can use the AWS Management Console, the AWS CLI, or the Managed Blockchain API to create an invitation proposal\. When a proposal to invite a member is approved, an invitation is sent to the specified AWS accounts\. An administrator with the appropriate permissions in that account can then choose to either create a member and join the network or reject the invitation\.

### To create an invitation proposal using the AWS Management Console<a name="w22aac15b9b5b1"></a>

1. Open the Managed Blockchain console at [https://console\.aws\.amazon\.com/managedblockchain/](https://console.aws.amazon.com/managedblockchain/)\.

1. From the navigation pane, choose **Networks**, and then choose the network to which you want to invite an AWS account\.

1. Choose **Proposals** and then choose **Propose invitation**\.

1. For **Submit proposal as**, choose the member in your account that submits the proposal\.
**Note**  
The member who submits the proposal must also vote on it\. A Yes vote is not automatically assumed\.

1. Enter an optional **Description **\. The description appears to other members\. It's a good way to communicate key points or a reminder about the proposal before they vote\.

1. For each AWS account that you want to invite, enter the account number in the space provided\. Choose **Add** to enter additional accounts\.

### To create an invitation proposal using the AWS CLI<a name="w22aac15b9b5b3"></a>
+ Type a command similar to the following\. Replace the value of `Principal` with the AWS account ID that you want to invite\. Replace the value of `--member-id` with the value for the member in your account that submits the proposal\.

  ```
  [ec2-user@ip-192-0-2-17 ~]$ aws managedblockchain create-proposal \
  --actions Invitations=[{Principal=123456789012}] \
  --network-id n-MWY63ZJZU5HGNCMBQER7IN6OIU \
  --member-id m-K46ICRRXJRCGRNNS4ES4XUUS5A
  ```

  The command returns the proposal ID, as shown in the following example:

  ```
  {
      "ProposalId": "p-ZR7KUD2YYNESLNG6RQ33X3FUFE"
  }
  ```

## Create a Proposal to Remove a Member From the Network<a name="managed-blockchain-create-removal"></a>

You can use the AWS Management Console, the AWS CLI, or the Managed Blockchain API to create a proposal to remove a member owned by another AWS account\.

### To create a proposal to remove a member using the AWS Management Console<a name="w22aac15c11b5b1"></a>

1. Open the Managed Blockchain console at [https://console\.aws\.amazon\.com/managedblockchain/](https://console.aws.amazon.com/managedblockchain/)\.

1. From the navigation pane, choose **Networks**, and then choose the network\.

1. Choose **Proposals** and then choose **Propose removal**\.

1. For **Submit proposal as**, choose the member in your account that submits the proposal\.
**Note**  
The member who submits the proposal must also vote on it\. A Yes vote is not automatically assumed\.

1. Enter an optional **Description **\. The description appears to other members\. It's a good way to communicate key points or a reminder about the proposal before they vote\.

1. For each member that you want to remove, enter the member ID in the space provided\. Choose **Add** to enter additional members\.

### To create a removal proposal using the AWS CLI<a name="w22aac15c11b5b3"></a>
+ Type a command similar to the following\. Replace the value of `Principal` with the AWS account ID that you want to invite\. Replace the value of `--member-id` with the value for the member in your account that submits the proposal\.

  ```
  [ec2-user@ip-192-0-2-17 ~]$ aws managedblockchain create-proposal \
  --actions Removals=[{MemberID=m-K46ICRRXJRCGRNNS4ES4XUUS5A}] \
  --network-id n-MWY63ZJZU5HGNCMBQER7IN6OIU \
  --member-id m-J46DNSFRTVCCLONS9DT5TTLS2A
  ```

  The command returns the proposal ID, as shown in the following example:

  ```
  {
      "ProposalId": "p-ZR7KUD2YYNESLNG6RQ33X3FUFE"
  }
  ```

## Delete a Member in Your AWS Account<a name="managed-blockchain-delete-account-member"></a>

You can use the AWS Management Console, the AWS CLI, or the Managed Blockchain API to directly remove members that your AWS account owns from a network\.

**Warning**  
Removing a member in your account deletes all associated resources, such as peer nodes\. For your AWS account to rejoin the network, an existing member must create a proposal to invite your AWS account, and the proposal must be approved\.

### To delete a member in your account using the AWS Management Console<a name="w22aac15c13b7b1"></a>

1. Open the Managed Blockchain console at [https://console\.aws\.amazon\.com/managedblockchain/](https://console.aws.amazon.com/managedblockchain/)\.

1. Choose **Networks**, choose the network **Name**, and then choose **Members**\.

1. Under **Members owned by you**, select a member and then choose **Delete member**\.

1. Choose **Delete** when prompted to confirm\.

### To delete a member in your account using the AWS CLI<a name="w22aac15c13b7b3"></a>
+ Use the `delete-member` command as shown in the following example\. Replace the values of `--network-id` and `--member-id` as appropriate\.

  ```
  aws managedblockchain delete-member --network-id n-MWY63ZJZU5HGNCMBQER7IN6OIU --member-id m-J46DNSFRTVCCLONS9DT5TTLS2A
  ```