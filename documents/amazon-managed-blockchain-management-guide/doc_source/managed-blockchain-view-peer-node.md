# View Peer Node Properties<a name="managed-blockchain-view-peer-node"></a>

You can view information about each peer node in your member using the AWS Management Console, the AWS CLI or the Managed Blockchain API [GetNode](https://docs.aws.amazon.com/managed-blockchain/latest/APIReference/API_GetNode.html) command\. Details include basic information like the Managed Blockchain instance type, Availability Zone, and creation date, along with the following important properties:
+ Status
  + **Creating**

    Managed Blockchain is provisioning and configuring the Managed Blockchain instance for the peer node\.
  + **Available**

    The peer node is running and available on the Managed Blockchain network\.
  + **Failed**

    The peer node has an issue that has caused Managed Blockchain to add it to the deny list on the network\. This usually indicates that the peer node has reached memory or storage capacity\. As a first step, we recommend that you delete the instance and provision an instance with more capacity\.
  + **Create Failed**

    The node could not be created with the Managed Blockchain instance type and the Availability Zone specified\. We recommend trying another availability zone, a different instance type, or both\.
  + **Deleting**

    The node is being deleted\. This can happen because the node was deleted by the member, the member was deleted by the AWS account, or the member was deleted through an approved removal proposal\.
  + **Deleted**

    The node has been deleted\. See the previous item for possible reasons\.
+ Endpoints

  Hyperledger Fabric uses endpoints associated with each peer node to identify the peer node on the network for different processes\. Managed Blockchain assigns unique peer node endpoints to each peer node on each network when the peer node is created\. The peer node endpoint consists of the applicable port and the domain name of the peer node derived from the network ID, member ID, and peer node ID\. For more information, see [Identifying Managed Blockchain Resources and Connecting from a Client](network-components.md#network-components-connecting)\. Do not assume that the ports for a service are the same among members; different members may use different ports for the same service\. Conversely, peer nodes in different networks may use the same ports, but their endpoints are always unique\.
  + **Peer endpoint**

    Use this endpoint, including the port, within Hyperledger Fabric to address the peer node when using all services other than peer channel\-based event services\. 
  + **Peer event endpoint**

    Use this endpoint, including the port, within Hyperledger Fabric to address the peer node for peer channel\-based event services\.

You can also view and monitor **Metrics** related to peer node performance\. For more information, see [Use Peer Node Metrics](managed-blockchain-peer-node-metrics.md)\.

You can check the peer node status using the `get-node` command, as shown in the following example:

```
aws managedblockchain get-node \
--network-id n-MWY63ZJZU5HGNCMBQER7IN6OIU \ 
--member-id m-K46ICRRXJRCGRNNS4ES4XUUS5A \
--node-id nd-6EAJ5VA43JGGNPXOUZP7Y47E4Y
```

The command returns output that includes the peer node's `PeerEndpoint` and `PeerEventEndpoint`, as shown in the following example\. You need this endpoint and port when communicating with the node using your blockchain framework client or addressing the node within an application\.

```
{
   "Node": { 
      "AvailabilityZone": "us-east-1a",
      "CreationDate": 2019-04-08T23:40:20.628Z,
      "FrameworkAttributes": { 
         "Fabric": { 
            "PeerEndpoint": "nd-6EAJ5VA43JGGNPXOUZP7Y47E4Y.m-K46ICRRXJRCGRNNS4ES4XUUS5A.n-MWY63ZJZU5HGNCMBQER7IN6OIU.managedblockchain.us-east-1.amazonaws.com:30003",
            "PeerEventEndpoint": "nd-6EAJ5VA43JGGNPXOUZP7Y47E4Y.m-K46ICRRXJRCGRNNS4ES4XUUS5A.n-MWY63ZJZU5HGNCMBQER7IN6OIU.managedblockchain.us-east-1.amazonaws.com:30004"
         }
      },
      "Id": "nd-6EAJ5VA43JGGNPXOUZP7Y47E4Y",
      "InstanceType": "bc.t3.small",
      "Status": "AVAILABLE"
   }
}
```