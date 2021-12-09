# Work with Proposals<a name="managed-blockchain-proposals"></a>

To make a change to the network in Amazon Managed Blockchain that requires consensus among network members, network members create a *proposal*\. For example, members can create a proposal to invite another AWS account to become a member, to invite multiple accounts, or to remove one or more members in different AWS accounts\.

A proposal is submitted to all network members to make a Yes or No vote\. If the proposal is approved within the duration and with the percentage of Yes votes specified in the voting policy for the network, the proposed action is carried out\. The *voting policy* is established when the network is created and governs votes on all proposals\. It can't be updated after the network is created\. For more information, see [Create an Amazon Managed Blockchain Network](create-network.md)\.

## Understanding the Proposal Lifecycle<a name="managed-blockchain-proposal-lifecycle"></a>

To understand the proposal lifecycle, consider a hypothetical proposal to invite AWS account 123456789012 to join a Managed Blockchain network made by a member named Org3\. The Managed Blockchain network currently has six members: Org1, Org2, Org3, and so on\. The network was created by Org1, who specified a voting policy with a **50% approval threshold**, a **greater than** comparator, and a proposal duration of 24 hours\.

The following flow diagrams depict the possible outcomes of a proposal using this example:
+ [Approved with Full Vote](#approved-full)
+ [Approved with Partial Vote](#approved-partial)
+ [Rejected with Full Vote](#rejected-full)
+ [Rejected with Partial Vote](#rejected-partial)
+ [Expired, Does Not Pass](#expired)

**Example – Proposal approved with full member vote**  
For the following proposal, all members cast a vote before the duration expired\. The proposal is `APPROVED`, and an invitation is extended to the AWS account\.  

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/managed-blockchain/latest/managementguide/images/approved_full.png)

**Example – Proposal approved with partial member vote**  
For the following proposal, not all members cast a vote before the duration expired\. However, enough Yes votes were cast to approve the proposal according to the voting policy\. The proposal is `APPROVED`, and an invitation is extended to the AWS account\.  

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/managed-blockchain/latest/managementguide/images/approved_partial.png)

**Example – Proposal rejected with full member vote**  
For the following proposal, all members cast a vote before the duration expired\. Because the comparator in the voting policy is **greater than**, a three\-to\-three vote does not pass the threshold for approval\. The proposal is `REJECTED`, and an invitation is not extended to the AWS account\.  

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/managed-blockchain/latest/managementguide/images/rejected_full.png)

**Example – Proposal rejected with partial member vote**  
For the following proposal, not all members cast a vote before the duration expired\. However, enough No votes were cast to reject the proposal according to the voting policy\. The proposal is `REJECTED`, and an invitation is extended to the AWS account\.  

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/managed-blockchain/latest/managementguide/images/rejected_partial.png)

**Example – Proposal expires and is not approved**  
For the following proposal, not all members cast a vote before the duration expired, and neither the number of Yes nor No votes were cast to determine the outcome of the proposal\. The proposal is `EXPIRED`, and an invitation is not extended to the AWS account\.  

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/managed-blockchain/latest/managementguide/images/expired.png)

## View Proposals<a name="managed-blockchain-proposal-view"></a>

All proposals made on a network are shown on the **Proposals** page for a network\. Both **Active** proposals and **Completed** proposals are listed\. Active proposals are still open for voting\. You can also list proposals from the AWS CLI using the `list-proposals` command, or using the [ListProposals](https://docs.aws.amazon.com/managed-blockchain/latest/APIReference/APIList_Proposals.html) action with the Managed Blockchain API\.

The **Proposals** page for a Network shows both **Active** and **Completed** proposals, listing the **Proposal ID**, the name of the member that created the proposal, and the **Expiration Date \(UTC\)**, which is the creation time plus the proposal duration specified in the network's voting policy\. You can choose a **Proposal ID** to vote on active proposals and to see more detail about any proposal, including the actions proposed and a voting summary by member\.

Proposals have one of the following statuses:
+ `IN_PROGRESS` \- The proposal is active and open for member voting\.
+ `APPROVED` \- The proposal was approved with sufficient `YES` votes among members according to the `VotingPolicy` specified for the `Network`\. The specified proposal actions are carried out\.
+ `REJECTED` \- The proposal was rejected with insufficient `YES` votes among members according to the `VotingPolicy` specified for the `Network`\. The specified `ProposalActions` are not carried out\.
+ `EXPIRED` \- Members did not cast the number of votes required to determine the proposal outcome before the proposal expired\. The specified `ProposalActions` are not carried out\.
+ `ACTION_FAILED` \- One or more of the specified `ProposalActions` in a proposal that was approved could not be completed because of an error\. The `ACTION_FAILED` status occurs even if only one proposal action fails and other actions are successful\.

**To view proposals for a network using the AWS Management Console**

1. Open the Managed Blockchain console at [https://console\.aws\.amazon\.com/managedblockchain/](https://console.aws.amazon.com/managedblockchain/)\.

1. Choose **Networks**, choose a network **Name**, and then choose **Proposals**\.

1. Choose a **Proposal ID** from the list to view more detailed information, such as the description, a summary of **Actions**, and a **Voting Summary**\.

1. Under **Voting Summary**, expand **Votes** to see individual member's votes on the proposal to date\.

**To view proposals for a network using the AWS CLI**
+ Enter a command similar to the following example\. Replace *n\-MWY63ZJZU5HGNCMBQER7IN6OIU* with the network ID for which you want to list proposals\.

  ```
  aws managedblockchain list-proposals --network-id n-MWY63ZJZU5HGNCMBQER7IN6OIU
  ```

  The command returns output similar to the following:

  ```
  {
      "Proposals": [
          {
              "CreationDate": 2019-04-08T23:40:20.628Z,
              "Description": "Proposal to add Example Corp. member",
              "ExpirationDate": 2019-04-09T23:40:20.628Z,
              "ProposalId": "p-ZR7KUD2YYNESLNG6RQ33X3FUFE",
              "ProposedByMemberId": "m-J46DNSFRTVCCLONS9DT5TTLS2A",
              "ProposedByMemberName": "org1",
              "Status": "IN_PROGRESS"
              
          }
      ]
  }
  ```

**To view the details of a proposal using the AWS CLI**
+ Enter a command similar to the following\. Replace *n\-MWY63ZJZU5HGNCMBQER7IN6OIU* with the network ID and *p\-ZR7KUD2YYNESLNG6RQ33X3FUFE* with the proposal ID to view\.

  ```
  aws managedblockchain get-proposal --network-id n-MWY63ZJZU5HGNCMBQER7IN6OIU --proposal-id p-ZR7KUD2YYNESLNG6RQ33X3FUFE
  ```

  The command returns output similar to the following:

  ```
  {
     "Proposal": { 
        "Actions": { 
           "Invitations": [ 
              { 
                 "Principal": "0123456789012"
              }
           ],
        "CreationDate": 2019-04-08T23:40:20.628Z,
        "Description": "Proposal to invite AWS Acct 0123456789012",
        "ExpirationDate": 2019-04-08T23:40:20.628Z,
        "NetworkId": "n-MWY63ZJZU5HGNCMBQER7IN6OIU",
        "NoVoteCount": 1,
        "OutstandingVoteCount": 3,
        "ProposalId": "p-ZR7KUD2YYNESLNG6RQ33X3FUFE",
        "ProposedByMemberId": "m-J46DNSFRTVCCLONS9DT5TTLS2A",
        "ProposedByMemberName": "org1",
        "Status": "IN_PROGRESS",
        "YesVoteCount": 2
     }
  }
  ```

## Vote on a Proposal<a name="managed-blockchain-proposal-vote"></a>

You can use the AWS Management Console, the AWS CLI `vote-on-proposal` command, or the [VoteOnProposal](https://docs.aws.amazon.com/managed-blockchain/latest/APIReference/API_VoteOnProposal.html) action of the Managed Blockchain API to vote Yes or No on an active proposal\. You cannot change a vote after you make it\.

### To vote on a proposal using the AWS Management Console<a name="w22aac23c11b5b1"></a>

1. Open the Managed Blockchain console at [https://console\.aws\.amazon\.com/managedblockchain/](https://console.aws.amazon.com/managedblockchain/)\.

1. Choose **Networks**, choose a network **Name**, and then choose **Proposals**\.

1. From the list of **Active** proposals, choose a **Proposal ID**\.

1. Under **Vote on proposal**, choose the member to vote as from the list, and then choose **Yes** or **No**\.

1. When prompted, choose **Confirm**\.

### To vote on a proposal using the AWS CLI<a name="w22aac23c11b5b3"></a>
+ Use the `vote-on-proposal` command as shown in the following example\. Replace the values of `--network-id`, `--member-id`, and `--vote` as appropriate\.

  ```
  aws managedblockchain vote-on-proposal --network-id n-MWY63ZJZU5HGNCMBQER7IN6OIU --proposal-id p-ZR7KUD2YYNESLNG6RQ33X3FUFE --member-id m-K46ICRRXJRCGRNNS4ES4XUUS5A --vote YES
  ```

## Create an Invitation Proposal<a name="managed-blockchain-propose-invitation"></a>

You can use the AWS Management Console, the AWS CLI, or the Managed Blockchain API to create an invitation proposal\.

### To create an invitation proposal using the AWS Management Console<a name="w22aac23c13b5b1"></a>

1. Open the Managed Blockchain console at [https://console\.aws\.amazon\.com/managedblockchain/](https://console.aws.amazon.com/managedblockchain/)\.

1. From the navigation pane, choose **Networks**, and then choose the network to which you want to invite an AWS account\.

1. Choose **Proposals** and then choose **Propose invitation**\.

1. For **Submit proposal as**, choose the member in your account that submits the proposal\.
**Note**  
The member who submits the proposal must also vote on it\. A Yes vote is not automatically assumed\.

1. Enter an optional **Description **\. The description appears to other members\. It's a good way to communicate key points or a reminder about the proposal before they vote\.

1. For each AWS account that you want to invite, enter the account number in the space provided\. Choose **Add** to enter additional accounts\.

### To create an invitation proposal using the AWS CLI<a name="w22aac23c13b5b3"></a>
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

## Create a Proposal to Remove a Network Member<a name="managed-blockchain-propose-removal"></a>

### To create a proposal to remove a member using the AWS Management Console<a name="w22aac23c15b5b1"></a>

1. Open the Managed Blockchain console at [https://console\.aws\.amazon\.com/managedblockchain/](https://console.aws.amazon.com/managedblockchain/)\.

1. From the navigation pane, choose **Networks**, and then choose the network\.

1. Choose **Proposals** and then choose **Propose removal**\.

1. For **Submit proposal as**, choose the member in your account that submits the proposal\.
**Note**  
The member who submits the proposal must also vote on it\. A Yes vote is not automatically assumed\.

1. Enter an optional **Description **\. The description appears to other members\. It's a good way to communicate key points or a reminder about the proposal before they vote\.

1. For each member that you want to remove, enter the member ID in the space provided\. Choose **Add** to enter additional members\.

### To create a removal proposal using the AWS CLI<a name="w22aac23c15b5b3"></a>
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