# Step 1: Create the Network and First Member<a name="get-started-create-network"></a>

When you create the network, you specify the following parameters along with basic information such as names and descriptions:
+ The open\-source framework and version\. This tutorial uses Hyperledger Fabric version 1\.2\.
+ The voting policy for proposals on the network\. For more information, see [Work with Proposals](managed-blockchain-proposals.md)\.
+ The first member of the network, including the administrative user and administrative password that are used to authenticate to the member's certificate authority \(CA\)\.

Create the network using the AWS CLI or Managed Blockchain management console according to the following instructions\. It may take a few minutes for Managed Blockchain to provision resources and bring the network online\.

## To create a Managed Blockchain network using the AWS Management Console<a name="w22aab9c11b9b1"></a>

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

## To create a Managed Blockchain network using the AWS CLI<a name="w22aab9c11b9b3"></a>

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

The **Networks** page on the console shows a **Status** of **Active** when the network is ready\. Alternatively, you can use the `list-networks` command, as shown in the following example, to confirm the network status\.

```
aws managedblockchain list-networks
```

The command returns information about the network, including an `AVAILABLE` status\.

```
{
    "Networks": [
        {
            "Id": "n-MWY63ZJZU5HGNCMBQER7IN6OIU",
            "Name": "MyTestNetwork",
            "Description": "MyNetDescription",
            "Framework": "HYPERLEDGER_FABRIC",
            "FrameworkVersion": "1.2",
            "Status": "AVAILABLE",
            "CreationDate": 1541497086.888,
        }
    ]
}
```