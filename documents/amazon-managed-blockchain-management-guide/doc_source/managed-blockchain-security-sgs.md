# Configuring Security Groups<a name="managed-blockchain-security-sgs"></a>

Security groups act as virtual firewalls\. They control inbound and outbound traffic between your Hyperledger Fabric client and Managed Blockchain network resources through the VPC endpoint in your account\. By default, security group rules are restrictive, so you must add rules that allow traffic for any resources, such as client computers, that must access the Managed Blockchain network\. The following tables list the minimum required security group rules that must be associated with the VPC endpoint and the Hyperledger Fabric client\.


**VPC Endpoint Security Group Minimum Rules**  

| Inbound/Outbound | Type | Source/Destination | Purpose | 
| --- | --- | --- | --- | 
|  Outbound  |  All traffic  |  0\.0\.0/0 \(Anywhere\)  |  Default\. Allows unrestricted outbound traffic from the interface VPC endpoint to all recipients\.  | 
|  Inbound  |  Custom TCP, Port for Ordering Service \(ranging between 30000 and 34000\)—for example, 30001\. The port is available within the **Ordering service endpoint** on the network details page using the console and returned within the `OrderingServiceEndpoint` property using the `get-network` command from the AWS CLI or using the `GetNetwork` API action\.  |  The IPv4 address, an address range, or a security group that includes all members' Hyperledger Fabric clients\.  | Allows the Hyperledger Fabric ordering service to receive traffic from Hyperledger Fabric clients\. | 
|  Inbound  |  Custom TCP, Port for the CA Service for a member \(ranging between 30000 and 34000\)—for example, 30002\. This is unique to each member, and each member only needs access to their own CA\. The port is available within the **Fabric certificate authority endpoint** on the member details page using the console and returned within the `CaEndpoint` property using the `get-member` command from the AWS CLI or using the `GetMember` API action\.  |  The IPv4 address, an address range, or a security group that includes all members' Hyperledger Fabric clients\.  | Allows the Hyperledger Fabric certificate authority \(CA\) for each member to receive traffic from respective Hyperledger Fabric clients\. | 
|  Inbound  |  Custom TCP, Ports, or Range of Ports for Peer Event Services on Peer Nodes \(ranging between 30000 and 34000\)\. The port is available within the **Peer node endpoints** on the member details page using the console and returned as the `PeerEventPort` property using the `get-node` command from the AWS CLI or using the `GetNode` API action\.  |  The IPv4 address, an address range, or a security group that includes all members' Hyperledger Fabric clients\.  | Allows the network to receive traffic from peer nodes as required\. Each node in each membership has a unique port associated with its peer event service\. Any node that might be a participant in an endorsement policy, regardless of membership, must be allowed communications in order to endorse transactions\. | 


**Hyperledger Fabric Client Security Group Minimum Rules**  

| Inbound/Outbound | Type | Source/Destination | Purpose | 
| --- | --- | --- | --- | 
|  Outbound  |  All traffic  |  0\.0\.0/0 \(Anywhere\)  |  Default\. Allows unrestricted outbound traffic from the Hyperledger Fabric client to all recipients\. If necessary, you can limit the destination to the interface VPC endpoint\.  | 
|  Inbound  |  SSH \(Port 22\)  |  The IP address, address range, or security group that includes trusted SSH clients that connect to the Hyperledger Fabric client\.  |  Allows trusted clients to use SSH to connect to the Hyperledger Fabric client to interact—for example, to query and execute chaincode\.  | 