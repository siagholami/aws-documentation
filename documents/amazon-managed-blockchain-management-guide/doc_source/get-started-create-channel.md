# Step 6: Create a Hyperledger Fabric Channel<a name="get-started-create-channel"></a>

In Hyperledger Fabric, a ledger exists in the scope of a channel\. The ledger can be shared across the entire network if every member is operating on a common channel\. A channel also can be privatized to include only a specific set of participants\. Members can be in your AWS account, or they can be members that you invite from other AWS accounts\.

In this step, you set up a basic channel\. Later on in the tutorial, in [Step 8: Invite Another AWS Account to be a Member and Create a Joint Channel](get-started-joint-channel.md), you go through a similar process to set up a channel that includes another member\.

## Step 6\.1: Create configtx for Hyperledger Fabric Channel Creation<a name="get-started-create-channel-configtx"></a>

The `configtx.yaml` file contains details of the channel configuration\. For more information, see [Channel Configuration \(configtx\)](https://hyperledger-fabric.readthedocs.io/en/release-1.2/configtx.html) in the Hyperledger Fabric documentation\.

Use a text editor to create a file with the following contents and save it as `configtx.yaml` on your Hyperledger Fabric client\. Replace *MemberID* with the MemberID you returned previously\. For example *m\-K46ICRRXJRCGRNNS4ES4XUUS5A*\.

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
            # DefaultOrg defines the organization which is used in the sampleconfig
            # of the fabric.git development environment
        Name: MemberID
            # ID to load the MSP definition as
        ID: MemberID
        MSPDir: /opt/home/admin-msp
            # AnchorPeers defines the location of peers which can be used
            # for cross org gossip communication.  Note, this value is only
            # encoded in the genesis block in the Application section context    
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
    OneOrgChannel:
        Consortium: AWSSystemConsortium
        Application:
            <<: *ApplicationDefaults
            Organizations:
                - *Org1
```

Run the following command to generate the configtx peer block:

```
docker exec cli configtxgen \
-outputCreateChannelTx /opt/home/mychannel.pb \
-profile OneOrgChannel -channelID mychannel \
--configPath /opt/home/
```

**Important**  
Hyperledger Fabric 1\.2 requires that a channel ID contain only lowercase ASCII alphanumeric characters, dots \(\.\), and dashes \(\-\)\. It must start with a letter, and must be fewer than 250 characters\.

## Step 6\.2: Set Environment Variables for the Orderer<a name="get-started-create-channel-environment-variables"></a>

Set the `$ORDERER` environment variable for convenience\. Replace *orderer\.n\-MWY63ZJZU5HGNCMBQER7IN6OIU\.managedblockchain\.amazonaws\.com:*30001** with the `OrderingServiceEndpoint` returned by the `aws managedblockchain get-network` command and listed on the network details page of the Managed Blockchain console\.

```
export ORDERER=orderer.n-MWY63ZJZU5HGNCMBQER7IN6OIU.managedblockchain.amazonaws.com:30001
```

This variable must be exported each time you log out of the client\. To persist the variable across sessions, add the export statement to your `~/.bash_profile` as shown in the following example\.

```
# .bash_profile
...other configurations
export ORDERER=orderer.n-MWY63ZJZU5HGNCMBQER7IN6OIU.managedblockchain.amazonaws.com:30001
```

After updating `.bash_profile`, apply the changes:

```
source ~/.bash_profile
```

## Step 6\.3: Create the Channel<a name="get-started-create-channel-create-channel"></a>

Run the following command to create a channel using the variables that you established and the configtx peer block that you created:

```
docker exec cli peer channel create -c mychannel \
-f /opt/home/mychannel.pb -o $ORDERER \
--cafile /opt/home/managedblockchain-tls-chain.pem --tls
```

## Step 6\.4: Join Your Peer Node to the Channel<a name="get-started-create-channel-join-peer"></a>

Run the following command to join the peer node that you created earlier to the channel:

```
docker exec cli peer channel join -b mychannel.block \
-o $ORDERER --cafile /opt/home/managedblockchain-tls-chain.pem --tls
```