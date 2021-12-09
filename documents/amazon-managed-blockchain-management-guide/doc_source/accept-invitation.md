# Work with Invitations<a name="accept-invitation"></a>

If you are invited to join a Managed Blockchain network, you can accept the invitation by creating a member using the invitation ID\. You can also reject the invitation\. After you reject an invitation, the invitation ID is no longer valid\. A new invitation proposal must be approved, and a new invitation ID is required to create a member\. If don't accept or reject an invitation before it expires, the invitation lapses\. As with a rejected invitation, a new invitation ID is required\.

You can see all pending, accepted, and rejected invitations for your AWS account in the AWS Management Console\. Alternatively, you can use the AWS CLI or the Managed Blockchain SDK [ListInvitations](https://docs.aws.amazon.com/managed-blockchain/latest/APIReference/>API_ListInvitedNetworks.html) action\.

You can set up Amazon CloudWatch Events along with Amazon Simple Notification Service so that you receive an alert when there is an invitation for your account\. For more information, see [Automating Managed Blockchain Proposal Notifications with CloudWatch Events](automating-proposals-with-cloudwatch-events.md)\.

## To list blockchain network member invitations for your AWS account using the console<a name="w22aac17c13b9b1"></a>

1. Open the Managed Blockchain console at [https://console\.aws\.amazon\.com/managedblockchain/](https://console.aws.amazon.com/managedblockchain/)\.

1. Choose **Invitations**, and then do one of the following:    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/managed-blockchain/latest/managementguide/accept-invitation.html)

## To list blockchain network member invitations for your AWS account using the AWS CLI<a name="w22aac17c13b9b3"></a>
+ Use the following command:

  ```
  aws managedblockchain list-invitations
  ```

  The command returns a list of invitations, along with detail for each invitation, as shown in the following example for an invitation in the `PENDING` status:

  ```
  {
     "Invitations": [ 
        { 
           "CreationDate": 2019-04-08T23:40:20.628Z,
           "ExpirationDate": 2019-04-09T23:40:20.628Z,
           "InvitationId": "i-XL9MDD6LVWWDNA9FF94Y4TFTE",
           "NetworkSummary": { 
              "CreationDate": 2019-04-03T13:15:22.345Z,
              "Description": "Test network for supply chain blockchain.",
              "Framework": "HYPERLEDGER_FABRIC",
              "FrameworkVersion": "1.2",
              "Id": "n-MWY63ZJZU5HGNCMBQER7IN6OIU",
              "Name": "Example Corp.",
              "Status": "AVAILABLE"
           },
           "Status": "PENDING"
        }
     ]
  }
  ```

You can use the `InvitationID` with the `create-member` command to create a member and join the network\. For next steps, see [Create a Member and Join a Network](managed-blockchain-hyperledger-create-member.md)\.