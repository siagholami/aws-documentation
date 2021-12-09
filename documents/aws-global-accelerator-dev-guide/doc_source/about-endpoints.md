# Endpoints in AWS Global Accelerator<a name="about-endpoints"></a>

Endpoints in AWS Global Accelerator can be Network Load Balancers, Application Load Balancers, Amazon EC2 instances, or Elastic IP addresses\. A static IP address serves as a single point of contact for clients, and Global Accelerator then distributes incoming traffic across healthy endpoints\. Global Accelerator directs traffic to endpoints by using the port \(or port range\) that you specify for the listener that the endpoint group for the endpoint belongs to\. 

Each endpoint group can have multiple endpoints\. You can add each endpoint to multiple endpoint groups, but the endpoint groups must be associated with different listeners\.

Global Accelerator continually monitors the health of all endpoints that are included in an endpoint group\. It routes traffic only to the active endpoints that are healthy\. If Global Accelerator doesn’t have any healthy endpoints to route traffic to, it routes traffic to all endpoints\.

Be aware of the following for specific types of Global Accelerator endpoints:

**Load balancer endpoints**  
+ An Application Load Balancer endpoint can be internet\-facing or internal\. A Network Load Balancer endpoint must be internet\-facing\.

**Amazon EC2 instance endpoints**  
+ An EC2 instance endpoint can't be one of the following types: C1, CC1, CC2, CG1, CG2, CR1, CS1, G1, G2, HI1, HS1, M1, M2, M3, or T1\.
+ EC2 instances are supported as endpoints in only some AWS Regions\. For a list of supported Regions, see [Supported AWS Regions for client IP address preservation](preserve-client-ip-address.regions.md)\.
+ We recommend that you remove an EC2 instance from Global Accelerator endpoint groups before you terminate the instance\. If you terminate an EC2 instance before you remove it from an endpoint group in Global Accelerator, and then you create another instance in the same VPC with the same private IP address, and health checks pass, Global Accelerator will route traffic to the new endpoint\. 

**Topics**
+ [Adding, editing, or removing an endpoint](about-endpoints-adding-endpoints.md)
+ [Endpoint weights](about-endpoints-endpoint-weights.md)
+ [Adding endpoints with client IP address preservation](#about-endpoints-sipp-caveats)
+ [Transitioning endpoints to use client IP address preservation](about-endpoints.transition-to-IP-preservation.md)

## Adding endpoints with client IP address preservation<a name="about-endpoints-sipp-caveats"></a>

A feature that you can use with some endpoint types—in some Regions— is *client IP address preservation*\. With this feature, you preserve the source IP address of the original client for packets that arrive at the endpoint\. You can use this feature with Application Load Balancer and EC2 instance endpoints\. For more information, see [Preserve client IP addresses in AWS Global Accelerator](preserve-client-ip-address.md)\.

If you intend to use the client IP address preservation feature, be aware of the following when you add endpoints to Global Accelerator:

**Elastic network interfaces**  
To support client IP address preservation, Global Accelerator creates elastic network interfaces in your AWS account—one for each subnet where an endpoint is present\. For more information about how Global Accelerator works with elastic network interfaces, see [Best practices for client IP address preservation](best-practices-aga.md)\.

**Endpoints in private subnets**  
You can target an Application Load Balancer or an EC2 instance in a private subnet using AWS Global Accelerator but you must have an [internet gateway](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_Internet_Gateway.html) attached to the VPC that contains the endpoints\. For more information, see [Secure VPC connections in AWS Global Accelerator](secure-vpc-connections.md)\.

**Add the client IP address to the allow list**  
Before you add and begin to route traffic to endpoints that preserve the client IP address, make sure that all your required security configurations, for example, security groups, are updated to include the user client IP address on the allow list\. Network access control lists \(ACLs\) only apply to egress \(outbound\) traffic\. If you need to filter ingress \(inbound\) traffic, you must use security groups\. 

**Configure network access control lists \(ACLs\)**  
Network ACLs associated with your VPC subnets apply to egress \(outbound\) traffic when client IP address preservation is enabled on your accelerator\. However, for traffic to be allowed to exit through Global Accelerator, you must configure the ACL as both an inbound and outbound rule\.   
For example, to allow TCP and UDP clients using an ephemeral source port to connect to your endpoint through Global Accelerator, associate the subnet of your endpoint with a Network ACL that allows outbound traffic destined to an ephemeral TCP or UDP port \(port range 1024\-65535, destination 0\.0\.0\.0/0\)\. In addition, create a matching inbound rule \(port range 1024\-65535, source 0\.0\.0\.0/0\)\.  
Security group and AWS WAF rules are an additional set of capabilities that you can apply to protect your resources\. For example, the inbound security group rules associated with your Amazon EC2 instances and Application Load Balancers allow you to control the destination ports that clients can connect to through Global Accelerator, such as port 80 for HTTP or port 443 for HTTPS\. Note that Amazon EC2 instance security groups apply to any traffic that arrives to your instances, including traffic from Global Accelerator and any public or Elastic IP address that is assigned to your instance\. As a best practice, use private subnets if you want to ensure that traffic is delivered only by Global Accelerator\. Also make sure that the inbound security group rules are configured appropriately to correctly allow or deny traffic for your applications\.