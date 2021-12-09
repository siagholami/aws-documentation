# Components<a name="launch-wizard-components"></a>

A SQL Server Always On application deployed with Launch Wizard includes the following components:
+ A **virtual private cloud \(VPC\)** configured with [public and private subnets](https://docs.aws.amazon.com/vpc/latest/userguide/what-is-amazon-vpc.html#what-is-vpc-subnet) across two Availability Zones\. A public subnet is a subnet whose traffic is routed to an internet gateway\. If a subnet does not have a route to the internet gateway, then it is a private subnet\. The VPC provides the network infrastructure for your SQL Server deployment\. You can choose an optional third Availability Zone for additional SQL cluster nodes, as shown below\.
+ An **internet gateway** to provide access to the internet\.
+ In the public subnets, **Windows Server\-based Remote Desktop Gateway \(RDGW\) instances and network address translation \(NAT\) gateways** for outbound internet access\. If you are deploying in your preexisting VPC, Launch Wizard uses the existing NAT gateway in your VPC\. For more information about NAT gateways, see [NAT Gateways](https://docs.aws.amazon.com/vpc/latest/userguide/vpc-nat-gateway.html)\.
+ **Elastic IP addresses** associated with the NAT gateway and RDGW instances\. For more information about Elastic IP addresses, see [Elastic IP Addresses](https://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/elastic-ip-addresses-eip.html)\.
+ In the private subnets, **Active Directory domain controllers**\.
+ In the private subnets, **Windows Server\-based instances as Windows Server Failover Clustering \(WSFC\) nodes**\. For more information, see [Windows Server Failover Clustering with SQL Server](https://docs.microsoft.com/en-us/sql/sql-server/failover-clusters/windows/windows-server-failover-clustering-wsfc-with-sql-server?view=sql-server-2017)\.
+ **SQL Server Enterprise edition with SQL Server Always On Availability Groups on each WSFC node**\. This architecture provides redundant databases and a witness server to ensure that a quorum can vote for the node to be promoted to master\. The default architecture mirrors an on\-premises architecture of two SQL Server instances spanning two subnets placed in two different Availability Zones\. For more information about SQL Server Always On Availability Groups, see [Overview of Always On Availability Groups \(SQL Server\)](https://docs.microsoft.com/en-us/sql/database-engine/availability-groups/windows/overview-of-always-on-availability-groups-sql-server?view=sql-server-2017)\. 
+ **Security groups** to ensure the secure flow of traffic between the instances deployed in the VPC\. For more information, see [Security Groups for Your VPC](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_SecurityGroups.html)\.

**Note**  
If you choose to deploy SQL Server Always On through Launch Wizard into your existing VPC, there is an additional mandatory check box on the console for you to indicate whether VPC and public/private subnet requirements have been met\. 

![\[Deploy SQL Server Always On with Launch Wizard\]](http://docs.aws.amazon.com/launchwizard/latest/userguide/images/sql-server-on-aws-architecture_mod.png)

You can also choose to build an architecture with three Availability Zones, as shown in the following diagram\.

![\[Deploy SQL Server Always On with Three Availability Zones\]](http://docs.aws.amazon.com/launchwizard/latest/userguide/images/sql-server-on-aws-architecture-3az_mod.png)