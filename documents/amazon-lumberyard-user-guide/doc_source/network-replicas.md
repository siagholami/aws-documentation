# Replicas<a name="network-replicas"></a>

Game sessions use replicas to synchronize the state of the session\. To use a replica, you simply declare the states that must be synchronized and the remote procedure calls \(RPCs\) that are supported\. After you bind the replica object to the network, the engine does the work\. There is no need to worry about how to properly route messages or discover remote objects\. When you add a local \(master\) replica to the network, the replica is automatically discovered by remote nodes\. In addition, corresponding remote proxy replica objects are created on the remote nodes\. Only the owner of the replica is allowed to change states, and new states are automatically propagated to all other nodes\. RPCs can be called from any node but are routed to the master \(owner\) node for verification and processing\.

**Topics**
+ [Replica](network-replicas-replica.md)
+ [Replica Chunks](network-replicas-chunks.md)
+ [Datasets](network-replicas-data-sets.md)
+ [Remote Procedure Calls \(RPCs\)](network-replicas-remote-procedure-calls.md)