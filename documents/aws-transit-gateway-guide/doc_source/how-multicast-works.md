# Multicast routing<a name="how-multicast-works"></a>

Learn how route tables, network ACLs, and security groups handle multicast traffic\.

When you enable multicast on a transit gateway, it acts as a multicast router\. We send all multicast traffic to the transit gateway that is associated with a multicast domain, when you add a subnet to that multicast domain\.

## Network ACLs<a name="multicast-nacl"></a>

Network ACL rules operate at the subnet level and apply to multicast traffic, because transit gateways reside outside of the subnet\. For information about network ACLs, see [Network ACLs](https://docs.aws.amazon.com/vpc/latest/userguide/vpc-network-acls.html) in the * Amazon VPC User Guide*\.

To control multicast traffic, you can create allow and deny rules\. For example, to allow outbound multicast traffic, create the following outbound rule using the console or CLI:
+ Rule number \- A rule number, for example 100\.
+ CIDR block \- The CIDR block of the multicast group, for example 224\.0\.0\.0/24\.
+ Protocol \- The protocol that your multicast applications use\.
+ Action \- Set this to Allow\.
+ Description \- A description for the rule, for example, "Allow all outbound multicast traffic"\.

## Security groups<a name="mulicast-security-group"></a>

Security group rules operate at the instance level and can be applied to both inbound and outbound multicast traffic\. This behavior is the same as unicast traffic\. For all group member instances, you must allow inbound traffic from the group source\. For information about security groups, see [Security groups](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_SecurityGroups.html) in the *Amazon VPC User Guide*\.

You can control traffic that multicast sources can send by adding inbound rules to the security group for the multicast traffic\. Use the following values for the parameters\.
+ Type \- The traffic type that your multicast applications use\.
+ Port range \- The ports that your multicast applications use\.
+ Protocol \- The protocol that your multicast applications use\.
+ Source \- The multicast senders IP address, or CIDR\. You cannot use a security group for the source\.
+ Description \- A description for the rule, for example, "Allow all inbound multicast traffic"\.

For example, to allow receipt of multicast UDP traffic on port 143 from any multicast sender in a VPC with a CIDR of 10\.0\.0\.0/16, create a security group, and then add the following inbound rule:


|  |  |  |  |  | 
| --- |--- |--- |--- |--- |
|  Type  | Protocol  | Source | Port Range |  Description  | 
|  Custom UDP Rule  |  UDP  | Custom 10\.0\.0\.0/16 | 143 |  UDP port 143 rule   | 