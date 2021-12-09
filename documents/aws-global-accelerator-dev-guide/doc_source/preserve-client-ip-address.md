# Preserve client IP addresses in AWS Global Accelerator<a name="preserve-client-ip-address"></a>

Your options for preserving and accessing the client IP address for AWS Global Accelerator depend on the endpoints that you've set up with your accelerator\. There are two types of endpoints that can preserve the source IP address of the client in incoming packets: Application Load Balancers and Amazon EC2 instances\.
+ When you use an internet\-facing Application Load Balancer as an endpoint with Global Accelerator, client IP address preservation is enabled by default for new accelerators\. This means that the source IP address of the original client is preserved for packets that arrive at the load balancer\. You can choose to disable the option when you create the accelerator or by editing the accelerator later\.
+ When you use an internal Application Load Balancer or an EC2 instance with Global Accelerator, the endpoint always has client IP address preservation enabled\. 

**Note**  
Global Accelerator does not support client IP address preservation for Network Load Balancer and Elastic IP address endpoints\.

When you plan for adding client IP address preservation, be aware of the following:
+ Before you add and begin to route traffic to endpoints that preserve the client IP address, make sure that all your required security configurations, for example, security groups, are updated to include the user client IP address on allow lists\. 
+ Client IP address preservation is supported only in specific AWS Regions\. For more information, see [Supported AWS Regions for client IP address preservation](preserve-client-ip-address.regions.md)\.

**Topics**
+ [How to enable client IP address preservation](preserve-client-ip-address.how-to-enable-preservation.md)
+ [Benefits of client IP address preservation](preserve-client-ip-address.benefits-of-preservation.md)
+ [How the client IP address is preserved in AWS Global Accelerator](preserve-client-ip-address.headers.md)
+ [Best practices for client IP address preservation](best-practices-aga.md)
+ [Supported AWS Regions for client IP address preservation](preserve-client-ip-address.regions.md)