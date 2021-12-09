# Working with Amazon VPC<a name="working-with-aws-vpc"></a>

Amazon QuickSight is fully integrated with the Amazon Virtual Private Cloud \(Amazon VPC\) service\. Use this section to find how to configure Amazon QuickSight to access data in your VPC\.

In Amazon QuickSight Enterprise edition, you can create connections to your VPCs from your AWS account's Amazon QuickSight subscription\. Each connection creates an elastic network interface in your VPC for Amazon QuickSight to send traffic to instances in your VPC\. When creating a data set, Amazon QuickSight accesses a VPC connection using only private IP addresses to connect to an instance that is not reachable from the public internet\. You can access VPCs that are located in the same AWS Region where you are using Amazon QuickSight to create analyses\. 

## Create a Private Connection to Amazon VPC Using Amazon QuickSight<a name="private-connection-to-vpc-using-quicksight"></a>

Use the following procedure to create a connection to a VPC\. Before you begin, you should understand your deployment of Amazon VPC in the AWS Region you are using: its subnets, and security groups, in relation to the destinations \(databases\) you want to reach from Amazon QuickSight\. 

1. In Amazon QuickSight, choose your profile icon at the top right of the screen, then choose **Manage QuickSight**\. From the menu at left, choose **Manage VPC connections**\.

   The **Account Settings** page appears\. Any existing private connections to VPCs display on this page\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/vpc-connections-managing.png)

1. Choose **Add VPC connection** to add a new VPC connection\. 

   On this page, you can also delete a VPC connection by using the delete icon\. You can change a VPC connection on this page by creating a new VPC connection and deleting the old one\.

1. For **VPC connection name**, type a unique descriptive name\. This name doesn't need to be an actual VPC ID or name\. 

1. Type the subnet ID for **Subnet ID**, and type the group ID for **Security group ID**\. Make sure that the subnet and the security group are in the same VPC\. Also, make sure you are accessing a VPC that is in the same AWS Region where you are creating Amazon QuickSight analyses\. You can't use Amazon QuickSight in one AWS Region to connect to a subnet and security group that are in a different AWS Region\. More detailed requirements are provided in the following steps, and in [How Amazon QuickSight Connects to Your VPC](#vpc-how-does-quicksight-connect)\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/vpc-connections-adding.png)

   If you need to locate information about the subnet and security group, do the following:

   1. On the Amazon VPC console, find the **VPC ID** that you want to use\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/vpc-console.png)

   1. On the Amazon VPC subnet console page, see which subnets are in that VPC by locating the VPC ID\. Choose a subnet, and copy its **Subnet ID** value\. The subnet you choose is the one where you plan to create an elastic network interface\. It must be possible to route from this subnet to any destinations you want to reach\. For more information, see [VPCs and Subnets](https://docs.aws.amazon.com//AmazonVPC/latest/UserGuide/VPC_Subnets.html)\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/vpc-subnet-console.png)

   1. On the **Adding VPC connection** screen, enter the **Subnet ID** value that you copied in the previous step for **Subnet ID**\.

   1. On the Amazon VPC security group console page, see which security groups are in that VPC by locating the VPC ID\. Choose a group, and copy its **Group ID** value\. 

      Create a new security group for use only with the elastic network interface created by Amazon QuickSight\.The group must allow inbound traffic on all ports from the security groups of the destinations you want to reach\.  

      The group must also allow outbound traffic to the database on the port that the database is listening on\. 

      Additionally, you must update your database's security group to allow inbound traffic from your new security group\.

      For more information, see [Security Group Rules for Amazon QuickSight's Elastic Network Interface](#vpc-security-groups-for-eni)\.
**Note**  
The database server's security group must allow inbound traffic from the security group you choose\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/vpc-security-group-console.png)

   1. On the **Adding VPC connection** screen, enter the **Group ID** value that you copied in the previous step for **Security group ID**\.

1. 
**Important**  
You can't change the settings for a VPC connection\.

   Review your choices, then choose **Create**\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/vpc-connections-creating.png)

**Note**  
Creating a VPC connection requires permission for the `quicksight:CreateVPCConnection` and `ec2:CreateNetworkInterface` actions\.

For best practices when using Amazon VPC, see the following:
+ [AWS Single VPC Design](https://aws.amazon.com/answers/networking/aws-single-vpc-design/) on the AWS website
+ [Recommended Network ACL Rules for Your VPC](https://docs.aws.amazon.com//AmazonVPC/latest/UserGuide/VPC_Appendix_NACLs.html) in the *Amazon VPC User Guide*
+ [VPC Scenarios and Examples](https://docs.aws.amazon.com//AmazonVPC/latest/UserGuide/VPC_Scenarios.html) in the *Amazon VPC User Guide*

## What Is Amazon VPC?<a name="vpc-intro"></a>

Amazon Virtual Private Cloud \(Amazon VPC\) enables you to define a virtual network in your own logically isolated area within the AWS cloud, known as a *virtual private cloud \(VPC\)*\. You can launch your AWS resources, such as instances, into your VPC\. Your VPC closely resembles a traditional network that you might operate in your own data center, with the benefits of using AWS's scalable infrastructure\. You can configure your VPC; you can select its IP address range, create subnets, and configure route tables, network gateways, and security settings\. You can connect instances in your VPC to the internet\. You can connect your VPC to your own corporate data center, making the AWS cloud an extension of your data center\. To protect the resources in each subnet, you can use multiple layers of security, including security groups and network access control lists\. For more information, see the [Amazon VPC User Guide](https://docs.aws.amazon.com/vpc/latest/userguide/)\.

## How Amazon QuickSight Connects to Your VPC<a name="vpc-how-does-quicksight-connect"></a>

When you create a VPC connection from Amazon QuickSight to your VPC, Amazon QuickSight creates an elastic network interface in the subnet that you choose\. It must be possible to route from this subnet to any destinations you want to reach\.

Network traffic from Amazon QuickSight then originates from this network interface when Amazon QuickSight connects to a database or other instance within your VPC using a VPC connection\. Because this network interface exists inside your VPC, traffic originating from it can reach destinations within your VPC using their private IP addresses\.

## Controlling the Resources That Amazon QuickSight Can Reach in Your VPC<a name="vpc-quicksight-control"></a>

Network traffic sent from Amazon QuickSight to an instance within your VPC through a VPC connection is subject to all of the standard security controls, just as other traffic in your VPC is\. Route tables, network ACLs, and security groups all apply to network traffic from Amazon QuickSight in the same way they apply to traffic between other instances n your VPC\.

### Configuring Security Group Rules for Use with Amazon QuickSight<a name="vpc-configuring-security-group-rules-for-quicksight"></a>

For Amazon QuickSight to successfully connect to an instance in your VPC, you must configure your security group rules to allow traffic between the Amazon QuickSight network interface and your instance\.

#### Security Group Rules for the Instance in Your VPC<a name="vpc-security-groups-for-instance"></a>

The security group attached to your data source's instance must allow inbound traffic from Amazon QuickSight on the port that Amazon QuickSight is connecting to\. 

You can do this by adding a rule to your security group that allows traffic from the security group ID that is associated with the Amazon QuickSight \(recommended\)\. Alternatively, you can use a rule that allows traffic from the private IP address assigned to Amazon QuickSight\.

For more information, see [Security Groups for Your VPC](https://docs.aws.amazon.com//AmazonVPC/latest/UserGuide/VPC_SecurityGroups.html) and [VPCs and Subnets](https://docs.aws.amazon.com//AmazonVPC/latest/UserGuide/VPC_Subnets.html)\.

#### Security Group Rules for Amazon QuickSight's Elastic Network Interface<a name="vpc-security-groups-for-eni"></a>

When using a VPC Connection, traffic comes from the elastic network interface that we create in your VPC\. Each elastic network interface gets its own private IP address that’s chosen from the subnet you configure\. The private IP address is unique for each AWS account, unlike the public IP range\. 

The security group attached to the Amazon QuickSight elastic network interface should have outbound rules allowing traffic to all of the data source instances in your VPC that you want Amazon QuickSight to connect to\. If you don't want to restrict which instances Amazon QuickSight can connect to, you can configure your security group with an outbound rule to allow traffic to 0\.0\.0\.0/0 on all ports\. If you want to restrict Amazon QuickSight to connect only to certain instances, you can specify the security group ID \(recommended\) or private IP address of the instances you want to allow\. You specify these, along with the appropriate port numbers for your instances, in your outbound security group rule\.

The security group attached to the Amazon QuickSight elastic network interface behaves differently than most security groups\. Security groups are usually stateful, meaning that when an outbound connection is established the return traffic from the destination host is automatically allowed\. However, the security group attached to the Amazon QuickSight network interface isn't stateful\. This means that your return traffic from the destination host isn't automatically allowed\. In this case, adding an egress rule to the network interface security group doesn't work\. Therefore, you must add inbound rules to your security group to explicitly authorize it\. 

Because the destination port number of any inbound return packets is set to a randomly allocated port number, the inbound rule in your security group must allow traffic on all ports \(0–65535\)\. If you don't want to restrict which instances Amazon QuickSight can connect to, then you can configure this security group with an inbound rule to allow traffic on 0\.0\.0\.0/0 on all ports\. If you want to restrict Amazon QuickSight to connect only to certain instances, you can specify the security group ID \(recommended\)\. Alternatively, you can specify the private IP address of the instances you want to allow in your inbound security group rule\. In this case, your inbound security group rule still needs to allow traffic on all ports\.

## Limitations on Data Sources Using a VPC Connection<a name="vpc-limitations"></a>

The following data source types can use a VPC connection:
+ Amazon Redshift
+ Amazon RDS
+ Amazon Aurora
+ PostgreSQL
+ MySQL
+ MariaDB
+ Microsoft SQL Server

The instance you are connecting to must either reside within your VPC or be reachable by using an AWS Direct Connect gateway\. Amazon QuickSight can also send traffic from VPC of one region to another using cross region VPC peering\. However, Amazon QuickSight can't send traffic through a VPC connection to instances that are only reachable by a VPN gateway, NAT gateway, or cross account PC peering connection\.

Amazon QuickSight can't connect to a network load balancer by using a VPC connection\.

## Other Requirements for Data Sources Using a VPC Connection<a name="vpc-requirements"></a>

The DNS name of the database or instance you are connecting to through a VPC connection must be resolvable from outside of your VPC\. Also, the connection must return the private IP address of your instance\. Databases hosted by Amazon Redshift, Amazon RDS, and Aurora automatically meet this requirement\.