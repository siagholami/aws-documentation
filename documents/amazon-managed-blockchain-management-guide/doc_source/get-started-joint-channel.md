# Step 8: Invite Another AWS Account to be a Member and Create a Joint Channel<a name="get-started-joint-channel"></a>

Now that you have a Hyperledger Fabric network set up using Amazon Managed Blockchain, with an initial member in your AWS account and a VPC endpoint with a service name, you are ready to invite additional members\. You invite additional members by creating a proposal for an invitation that existing members vote on\. Since the blockchain network at this point consists of only one member, the first member always has the only vote on the invitation proposal for the second member\. In the steps that follow, the network creator has an initial member named `org1` and the invited member is named `org2`\. For proof of concept, you can create an invitation proposal for an additional member in the same AWS account that you used to create the network, or you can create an invitation proposal for a different AWS account\.

After the invitation proposal is approved, the invited account can create a member\. Invited members are free to reject the invitation or ignore it until the invitation proposal expires\. The invited account needs the network ID and VPC endpoint service name of the blockchain network to create a member\. For more information, see [Work with Invitations](accept-invitation.md)\. The invited account also needs to fulfill the prerequisites listed in [Prerequisites and Considerations](get-started-prerequisites.md)\.

## Step 8\.1: Create an Invitation Proposal<a name="get-started-joint-channel-invite-account"></a>

Create a proposal to invite an AWS account to create a member and join the network according to the following procedures\. You need the AWS account ID of the member you want to invite\. You can also invite your own account to create an additional member\. If you are using the CLI, you also need the Network ID and Member ID that you created in [Step 1: Create the Network and First Member](get-started-create-network.md)\.

### To create an invitation proposal using the AWS Management Console<a name="w22aab9c25b7b5b1"></a>

1. Open the Managed Blockchain console at [https://console\.aws\.amazon\.com/managedblockchain/](https://console.aws.amazon.com/managedblockchain/)\.

1. From the navigation pane, choose **Networks**, and then choose the network to which you want to invite an AWS account\.

1. Choose **Proposals** and then choose **Propose invitation**\.

1. For **Submit proposal as**, choose the member in your account that submits the proposal\.
**Note**  
The member who submits the proposal must also vote on it\. A Yes vote is not automatically assumed\.

1. Enter an optional **Description **\. The description appears to other members\. It's a good way to communicate key points or a reminder about the proposal before they vote\.

1. For each AWS account that you want to invite, enter the account number in the space provided\. Choose **Add** to enter additional accounts\.

### To create an invitation proposal using the AWS CLI<a name="w22aab9c25b7b5b3"></a>
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

## Step 8\.2: Vote Yes on the Proposal<a name="get-started-joint-channel-cast-vote"></a>

After you create the invitation proposal, use the first member that you created to vote Yes and approve the proposal\. You must do this within the duration defined by the network voting policy\.

1. Open the Managed Blockchain console at [https://console\.aws\.amazon\.com/managedblockchain/](https://console.aws.amazon.com/managedblockchain/)\.

1. From the navigation pane, choose **Networks**, and then choose the **Network** for which the proposal was made\.

1. Choose **Proposals**\.

1. Under **Active proposals**, choose the **Proposal ID** to vote on\.

1. Under **Vote on proposal**, select the member in your account to vote as\. If your account has multiple members, each member gets a vote\.

1. Choose **Yes** to vote to approve the proposal\. Voting yes is a requirement for the second member to be created in the next step\. Choosing **No** rejects the proposal and an invitation is not created\.

1. Choose to **Confirm** your vote\.

## Step 8\.3: Create the New Member<a name="get-started-joint-channel-invite-member"></a>

To accept an invitation to create a member and join a network, the steps are similar whether you are creating a member in a Managed Blockchain network in a different AWS account or your own AWS account\. You first create the member as shown in the following procedures\. If you use the AWS CLI, make sure that you have the relevant information, including the Network ID and the Invitation ID that the network sent to your account\. When you create a member, you specify the name that identifies your member on the network\. You also specify the admin user and password to authenticate to your member certificate authority \(CA\)\.

### To accept an invitation to create a member and join a network using the AWS Management Console<a name="w22aab9c25c11b5b1"></a>

1. Open the Managed Blockchain console at [https://console\.aws\.amazon\.com/managedblockchain/](https://console.aws.amazon.com/managedblockchain/)\.

1. From the navigation pane, choose **Invitations**\.

1. Select the invitation that you want to accept from the list, and then choose **Accept invitation**\. To view more information about the network you are invited to join, choose the network **Name** from the list

1. Under **Join network**, configure your network member according to the following guidelines:

   1. Enter a **Member name** that will be visible to all members and an optional **Description**\.

   1. Under **Hyperledger Fabric certificate authority \(CA\) configuration** specify a username and password to be used as the administrator on the Hyperledger Fabric CA\. Remember the user name and password\. You need them later any time that you create users and resources that need to authenticate\.

   1. Choose **Create member and join network**\.

1. Choose **Create member**\.

### To accept an invitation to create a member and join a network using the AWS CLI<a name="w22aab9c25c11b5b3"></a>
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

### Additional Steps to Configure a Member<a name="w22aab9c25c11b7"></a>

After you create the member, perform the following steps to configure the member\. As you perform the steps, replace values with those specific to your member configuration, including the Member ID returned by the previous command\. The Network ID and `OrderingServiceEndpoint` are the same for all members\.
+ [Step 2: Create and Configure the Interface VPC Endpoint](get-started-create-endpoint.md)

  This step is only required if you are creating the second member in a different AWS account\.
+ [Step 3: Create an Amazon EC2 Instance and Set Up the Hyperledger Fabric Client](get-started-create-client.md)

  If you are creating an additional member in the same AWS account, and you already have a Hyperledger Fabric client, you can skip most of these steps\. However, you should verify connectivity to the Hyperledger Fabric CA as described in [Step 3\.2: Set Up the Hyperledger Fabric CA Client](get-started-create-client.md#get-started-client-setup-CA-client), using the new CA endpoint for the new member\.
+ [Step 4: Enroll an Administrative User](get-started-enroll-admin.md)
+ [Step 5: Create a Peer Node in Your Membership](get-started-create-peer-node.md)

## Step 8\.4: Share Artifacts and Information with the Network Creator<a name="get-started-joint-channel-artifact-exchange"></a>

Before a shared channel can be created, the following artifacts and information need to be shared with `org1` by `org2`:
+ **org1 needs the org2 administrative certificate**—This certificate is saved the `/home/ec2-user/admin-msp/admincerts` directory on org2's Hyperledger Fabric client after [Step 4: Enroll an Administrative User](get-started-enroll-admin.md)\. This is referenced in the following steps as `Org2AdminCertFile`
+ **org1 needs the org2 root CA**—This certificate is saved to org2's `/home/ec2-user/admin-msp/cacerts` directory on org2's Hyperledger Fabric client after the same step as previous\. This is referenced in the following steps as `Org2CACertFile`
+ **org1 needs the `Endpoint` of the peer node that will join the channel**—This `Endpoint` value is output by the `get-node` command after [Step 5: Create a Peer Node in Your Membership](get-started-create-peer-node.md) is complete\.

## Step 8\.5: The Channel Creator \(org1\) Creates Artifacts for org2's MSP<a name="get-started-joint-channel-create-org2msp"></a>

In the following example, the channel creator is org1\. The CA administrator for org1 copies the certificates from the step above to a location on the Hyperledger Fabric client computer\. The Membership Service Provider \(MSP\) uses the certificates to authenticate the member\.

On the channel creator's Hyperledger Fabric client, use the following commands to create directories to store the certificates, and then copy the certificates from the previous step to the new directories:

```
mkdir /home/ec2-user/org2-msp
 mkdir /home/ec2-user/org2-msp/admincerts
 mkdir /home/ec2-user/org2-msp/cacerts

cp Org2AdminCerts /home/ec2-user/org2-msp/admincerts
cp Org2CACerts /home/ec2-user/org2-msp/cacerts
```

Org1 needs org2's member ID\. You can get this by running the `list-members` command on org1's Hyperledger Fabric client as shown in the following example:

```
aws managedblockchain list-members \
--network-id n-MWY63ZJZU5HGNCMBQER7IN6OIU
```

The channel creator \(org1\) should verify that the required artifacts for channel creation are saved on the Hyperledger Fabric client as shown in the following list:
+ Org1 MSP artifacts:
  + /home/ec2\-user/admin\-msp/signcerts/*certname*\.pem
  + /home/ec2\-user/admin\-msp/admincerts/*certname*\.pem
  + /home/ec2\-user/admin\-msp/cacerts/*certname*\.pem
  + /home/ec2\-user/admin\-msp/keystore/*keyname*\_sk
+ Org2 MSP artifacts
  + /home/ec2\-user/org2\-msp/admincerts/*certname*\.pem
  + /home/ec2\-user/org2\-msp/cacerts/*certname*\.pem
+ The TLS CA cert used for the Region:
  + /home/ec2\-user/managedblockchain\-tls\-chain\.pem
+ Addresses of all peer nodes to join the channel for both org1 and org2\.
+ The respective member IDs of org1 and org2\.
+ A `configtx.yaml` file, which you create in the following step, saved to the `/home/ec2-user` directory on the channel creator's Hyperledger Fabric client\.
**Note**  
If you created this configtx file earlier, delete the old file, rename it, or replace it\.

## Step 8\.6: Create configtx for the Joint Channel<a name="get-started-joint-channel-channel-configtx"></a>

The `configtx.yaml` file contains details of the channel configuration\. For more information, see [Channel Configuration \(configtx\)](https://hyperledger-fabric.readthedocs.io/en/release-1.2/configtx.html) in the Hyperledger Fabric documentation\.

The channel creator creates this file on the Hyperledger File client\. If you compare this file to the file created in [Step 6\.1: Create configtx for Hyperledger Fabric Channel Creation](get-started-create-channel.md#get-started-create-channel-configtx), you see that this `configtx.yaml` specifies two members in the channel\.

Use a text editor to create a file with the following contents and save it as `configtx.yaml` on your Hyperledger File client\. In the example below, replace *Member1ID* with the member ID of org1, which was created with the network in [Step 1: Create the Network and First Member](get-started-create-network.md)\. For example *m\-K46ICRRXJRCGRNNS4ES4XUUS5A*\. Replace *Member2ID* with the member ID of org2, which was created with [Step 8\.3: Create the New Member](#get-started-joint-channel-invite-member)\.

**Important**  
This file is sensitive\. Artifacts from pasting can cause the file to fail with marshalling errors\. We recommend using `emacs` to edit it\. You can also use `VI`, but before using `VI`, enter `:set paste`, press `i` to enter insert mode, paste the contents, press escape, and then enter `:set nopaste` before saving\.

```
################################################################################
#
#   Section: Organizations
#
#   - This section defines the different organizational identities which will
#   be referenced later in the configuration.
#
################################################################################
Organizations:
    - &Org1
            # member id defines the organization
        Name: Member1ID
            # ID to load the MSP definition as
        ID: Member1ID
            #msp dir of org1 in the docker container
        MSPDir: /opt/home/admin-msp
            # AnchorPeers defines the location of peers which can be used
            # for cross org gossip communication.  Note, this value is only
            # encoded in the genesis block in the Application section context
        AnchorPeers:
            - Host:
              Port:
    - &Org2
        Name: Member2ID
        ID: Member2ID
        MSPDir: /opt/home/org2-msp
        AnchorPeers:
            - Host:
              Port:

################################################################################
#
#   SECTION: Application
#
#   - This section defines the values to encode into a config transaction or
#   genesis block for application related parameters
#
################################################################################
Application: &ApplicationDefaults
        # Organizations is the list of orgs which are defined as participants on
        # the application side of the network
     Organizations:

################################################################################
#
#   Profile
#
#   - Different configuration profiles may be encoded here to be specified
#   as parameters to the configtxgen tool
#
################################################################################
Profiles:
    TwoOrgChannel:
        Consortium: AWSSystemConsortium
        Application:
            <<: *ApplicationDefaults
            Organizations:
                - *Org1
                - *Org2
```

Run the following command to generate the configtx peer block:

```
docker exec cli configtxgen \
-outputCreateChannelTx /opt/home/ourchannel.pb \
-profile TwoOrgChannel -channelID ourchannel \
--configPath /opt/home/
```

## Step 8\.7: Create the Channel<a name="get-started-joint-channel-create-channel"></a>

The channel creator \(org1\) uses the following command on their Hyperledger Fabric client to create the channel `ourchannel`\. The command example assumes that Docker environment variables have been configured as described in [Step 3\.4: Configure and Run Docker Compose to Start the Hyperledger Fabric CLI](get-started-create-client.md#get-started-client-configure-peer-cli) and that the `$ORDERER` environment variable has been set on the client\.

```
docker exec cli peer channel create -c ourchannel \
-f /opt/home/ourchannel.pb -o $ORDERER \ 
--cafile /opt/home/managedblockchain-tls-chain.pem --tls
```

## Step 8\.8: Get Channel Genesis Block<a name="get-started-joint-channel-get-genesis-block"></a>

A member who joins the channel must get the channel genesis block\. In this example, org2 runs the following command from their Hyperledger Fabric client to get the genesis block\. 

```
docker exec cli peer channel fetch oldest /opt/home/ourchannel.block \
-c ourchannel -o $ORDERER \
--cafile /opt/home/managedblockchain-tls-chain.pem --tls
```

## Step 8\.9: Join Peer Nodes to the Channel<a name="get-started-joint-channel-invite-join-peer"></a>

Both org1 and org2 need to run the following command on their respective Hyperledger Fabric clients to join their peer nodes to the channel:

```
docker exec cli peer channel join -b /opt/home/ourchannel.block \
-o $ORDERER --cafile /opt/home/managedblockchain-tls-chain.pem --tls
```

## Step 8\.10: Install Chaincode<a name="get-started-joint-channel-invite-install-chaincode"></a>

Both org1 and org2 run the following command on their respective Hyperledger Fabric clients to install example chaincode on their respective peer nodes:

```
docker exec cli peer chaincode install -n myjointcc -v v0 \
-p github.com/chaincode_example02/go
```

## Step 8\.11: Instantiate Chaincode<a name="get-started-joint-channel-invite-instantiate"></a>

The channel creator \(org1\) runs the following command to instantiate the chaincode with an endorsement policy that requires both org1 and org2 to endorse all transactions\. Replace *Member1ID* with the member ID of org1 and *Member2ID* with the member ID of org2\. You can use the `list-members` command to get them\.

```
docker exec cli peer chaincode instantiate -o $ORDERER \ 
-C ourchannel -n myjointcc -v v0 \
-c '{"Args":["init","a","100","b","200"]}' \
--cafile /opt/home/managedblockchain-tls-chain.pem --tls \
-P "AND ('Member1ID.member','Member2ID.member')"
```

You may need to wait a brief moment for the instantiation from the previous step to complete before you run the following command to query a value:

```
docker exec cli peer chaincode query -C ourchannel \
-n myjointcc -c '{"Args":["query","a"]}'
```

The command should return the value of `a`, which you instantiated to a value of `100`\.

## Step 8\.12: Invoke Chaincode<a name="get-started-joint-channel-invite-invoke"></a>

With the channel created and configured with both members, and the chaincode instantiated with values and an endorsement policy, channel members can invoke chaincode\. This example command is similar to the example in [Step 7\.4: Invoke the Chaincode](get-started-chaincode.md#get-started-create-channel-invoke-chaincode)\. However, the command uses the `--peerAddresses` option to specify the endpoints of peer nodes that belong to members in the endorsement policy\. The example specifies *Org2PeerNodeEndpoint* in addition to *Org1PeerEndpoint*\.

```
docker exec cli peer chaincode invoke \ 
-C ourchannel -n myjointcc -c '{"Args":["invoke","a","b","10"]}' \
--peerAddresses Org1PeerEndpoint \
--tlsRootCertFiles /opt/home/managedblockchain-tls-chain.pem \
--peerAddresses Org2PeerNodeEndpoint \
--tlsRootCertFiles /opt/home/managedblockchain-tls-chain.pem \
-o $ORDERER --cafile /opt/home/managedblockchain-tls-chain.pem --tls
```

When we query again using the following command:

```
docker exec cli peer chaincode query -C ourchannel \
-n myjointcc -c '{"Args":["query","a"]}'
```

The command should return the value of `a` as the new value `90`\.