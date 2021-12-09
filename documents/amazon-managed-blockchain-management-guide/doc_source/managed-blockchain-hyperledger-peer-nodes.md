# Work with Peer Nodes in a Managed Blockchain Network<a name="managed-blockchain-hyperledger-peer-nodes"></a>

Peer nodes are essential\. They do the work for your member on the Managed Blockchain network\. They keep a local copy of the shared ledger, let you query the ledger, and interact with clients and other peer nodes to perform transactions\. A new member has no peer nodes\. Create at least one peer node per member\.

Each peer node runs on a *Managed Blockchain instance type*\. You cannot add a custom Amazon EC2 instance to your member, nor can you connect an on\-premises machine\. The number of peer nodes and the Managed Blockchain instance type of peer nodes available to each member depends on the network edition specified when the network was created\. For more information, see [Amazon Managed Blockchain Pricing](https://aws.amazon.com/managed-blockchain/pricing)\.

When you create a peer node, you select the following characteristics:
+ **Managed Blockchain instance type**

  This determines the computational and memory capacity allocated to this node for the blockchain workload\. You can choose more CPU and RAM if you anticipate a more demanding workload for each node\. For example, your nodes may need to process a higher rate of transactions\. Different instance types are subject to different pricing\. 
+ **Allocated storage**

  This is the amount of storage in GiB that is available to the peer node for storing local copies of the ledger\. Storage rates apply\.
+ **Availability Zone**

  You can select the Availability Zone to launch the peer node in\. The ability to distribute peer nodes in a member across different Availability Zones allows you to design your blockchain application for resiliency\. For more information, see [Regions and Availability Zones](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-regions-availability-zones.html) in the *Amazon EC2 User Guide for Linux Instances*\.

You can monitor CPU and memory utilization to determine if your Managed Blockchain instance type is sized appropriately\. For more information, see [Use Peer Node Metrics](managed-blockchain-peer-node-metrics.md)\.