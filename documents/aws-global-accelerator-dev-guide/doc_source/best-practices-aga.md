# Best practices for client IP address preservation<a name="best-practices-aga"></a>

When you use client IP address preservation in AWS Global Accelerator, keep in mind the information and best practices in this section for elastic network interfaces and security groups\.

To support client IP address preservation, Global Accelerator creates elastic network interfaces in your AWS account—one for each subnet where an endpoint is present\. An elastic network interface is a logical networking component in a VPC that represents a virtual network card\. Global Accelerator uses these elastic network interfaces to route traffic to the endpoints configured behind an accelerator\. The supported endpoints for routing traffic this way are Application Load Balancers \(internal and internet\-facing\) and Amazon EC2 instances\. 

**Note**  
When you add an internal Application Load Balancer or an EC2 instance endpoint in Global Accelerator, you enable internet traffic to flow directly to and from the endpoint in Virtual Private Clouds \(VPCs\) by targeting it in a private subnet\. For more information, see [Secure VPC connections in AWS Global Accelerator](secure-vpc-connections.md)\.

**How Global Accelerator uses elastic network interfaces**  
When you have an Application Load Balancer with client IP address preservation enabled, the number of subnets that the load balancer is in determines the number of elastic network interfaces that Global Accelerator creates in your account\. Global Accelerator creates one elastic network interface for each subnet that has at least one elastic network interface of the Application Load Balancer in it that is fronted by an accelerator in your account\.  
The following examples illustrate how this works:  
+ **Example 1: **If an Application Load Balancer has elastic network interfaces in subnetA and subnetB, and then you add the load balancer as an accelerator endpoint, Global Accelerator creates two elastic network interfaces, one in each subnet\.
+ **Example 2: **If you add, for example, an ALB1 that has elastic network interfaces in subnetA and subnetB to Accelerator1, and then add an ALB2 with elastic network interfaces in subnetA and subnetB to Accelerator2, Global Accelerator creates only two elastic network interfaces: one in subnetA and one in subnetB\.
+ **Example 3: **If you add an ALB1 that has elastic network interfaces in subnetA and subnetB to Accelerator1, and then add an ALB2 with elastic network adaptors in subnetA and subnetC to Accelerator2, Global Accelerator creates three elastic network interfaces: one in subnetA, one in subnetB, and one in subnetC\. The elastic network interface in subnetA delivers traffic on for both Accelerator1 and Accelerator2\.
As shown in Example 3, elastic network interfaces are reused across accelerators if endpoints in the same subnet are placed behind multiple accelerators\.   
The logical elastic network interfaces that Global Accelerator creates do not represent a single host, a throughput bottleneck, or a single point of failure\. Like other AWS services that appear as a single elastic network interface in an Availability Zone or subnet—services like a network address translation \(NAT\) gateway or a Network Load Balancer—Global Accelerator is implemented as a horizontally scaled, highly available service\.   
Evaluate the number of subnets that are used by endpoints in your accelerators to determine the number of elastic network interfaces that Global Accelerator will create\. Before you create an accelerator, make sure that you have enough IP address space capacity for the required elastic network interfaces, at least one free IP address per relevant subnet\. If you don't have enough free IP address space, you must create or use a subnet that has adequate free IP address space for your Application Load Balancer and associated Global Accelerator elastic network interfaces\.   
When Global Accelerator determines that an elastic network interface is not being used by any of the endpoints in accelerators in your account, Global Accelerator deletes the interface\. 

**Security groups created by Global Accelerator**  
Review the following information and best practices when you work with Global Accelerator and security groups\.  
+ Global Accelerator creates security groups that are associated with its elastic network interfaces\. Although the system doesn't prevent you from doing so, you shouldn't edit any of the security group settings for these groups\.
+ Global Accelerator doesn't delete security groups that it creates\. However, Global Accelerator does delete an elastic network interface if it isn't being used by any of the endpoints in accelerators in your account\.
+ You can use the security groups created by Global Accelerator as a source group in other security groups that you maintain, but Global Accelerator only forwards traffic to the targets that you specify in your VPC\.
+ If you modify the security group rules created by Global Accelerator, the endpoint might become unhealthy\. If that happens, contact [AWS Support](https://console.aws.amazon.com/support/home) for assistance\. 
+ Global Accelerator creates a specific security group for each VPC\. Elastic network interfaces that are created for the endpoints within a specific VPC all use the same security group, no matter which subnet an elastic network interface is associated with\.