# How Network ACLs work with transit gateways<a name="tgw-nacls"></a>

A network access control list \(NACL\) is an optional layer of security\. 

Network access control list \(NACL\) rules are applied differently, depending on the scenario: 
+ When you have the same subnet for your EC2 network interface workload and transit gateway association\. 
+ When you have different subnets for your EC2 network interface workload and transit gateway association\.

## Same subnet for EC2 network interface workload and transit gateway association<a name="nacl-tgw-same-subnet"></a>

Consider a configuration where you have an EC2 network interface workload and transit gateway association that have the same subnet\. The same route table is used for both outbound and inbound traffic: the traffic from individual EC2 instances to the transit gateway, and the traffic that comes through the transit gateway to your VPC\. 

NACL rules are applied in the following way for traffic from individual EC2 instances to the transit gateway:
+ Outbound rules use the destination IP address for evaluation\.
+ Inbound rules use the source IP address for evaluation\.

NACL rules are applied in the following way for traffic from the transit gateway to your VPC:
+ Inbound rules and outbound rules are not evaluated\.

## Different subnet for EC2 network interface workload and transit gateway association<a name="nacl-tgw-different-subnet"></a>

Consider a configuration where you have an EC2 network interface workload and transit gateway association that have different subnets\. In this configuration, each subnet is associated with a different NACL\.

NACL rules are applied in the following way for traffic from individual EC2 instances to the transit gateway:
+ Outbound rules for the EC2 instance subnet use the destination IP address for evaluation\.
+ Inbound rules for the transit gateway subnet use the source IP address for evaluation\.
+ Outbound rules for the transit gateway subnet are not evaluated\.

NACL rules are applied in the following way for traffic from the transit gateway to your VPC:
+ Outbound rules for the transit gateway subnet use the destination IP address for evaluation\.
+ Inbound rules for the transit gateway subnet are not evaluated\.
+ Inbound rules for the EC2 instance subnet use the source IP address for evaluation\.

## Best Practices<a name="nacl-best-practices"></a>

Use a separate subnet for each transit gateway VPC attachment\. For each subnet, use a small CIDR, for example /28, so that you have more addresses for EC2 resources\. When you use a separate subnet, you can configure the following:
+ Keep the inbound and outbound NACL that is associated with the transit gateway subnets open\. 
+ Depending on your traffic flow, you can apply NACLs to your workload subnets\.