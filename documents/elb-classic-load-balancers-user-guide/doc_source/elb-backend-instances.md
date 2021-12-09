# Registered instances for your Classic Load Balancer<a name="elb-backend-instances"></a>

After you've created your Classic Load Balancer, you must register your EC2 instances with the load balancer\. You can select EC2 instances from a single Availability Zone or multiple Availability Zones within the same Region as the load balancer\. Elastic Load Balancing routinely performs health checks on registered EC2 instances, and automatically distributes incoming requests to the DNS name of your load balancer across the registered, healthy EC2 instances\.

**Topics**
+ [Best practices for your instances](#backend-instance-best-practices)
+ [Prepare your VPC and EC2 instances](#set-up-ec2)
+ [Configure health checks for your Classic Load Balancer](elb-healthchecks.md)
+ [Configure security groups for your Classic Load Balancer](elb-security-groups.md)
+ [Add or remove Availability Zones for your load balancer in EC2\-Classic](enable-disable-az.md)
+ [Add or remove subnets for your Classic Load Balancer in a VPC](elb-manage-subnets.md)
+ [Register or deregister EC2 instances for your Classic Load Balancer](elb-deregister-register-instances.md)

## Best practices for your instances<a name="backend-instance-best-practices"></a>
+ Install a web server, such as Apache or Internet Information Services \(IIS\), on all instances that you plan to register with your load balancer\.
+ For HTTP and HTTPS listeners, we recommend that you enable the keep\-alive option in your EC2 instances, which enables the load balancer to re\-use the connections to your instances for multiple client requests\. This reduces the load on your web server and improves the throughput of the load balancer\. The keep\-alive timeout should be at least 60 seconds to ensure that the load balancer is responsible for closing the connection to your instance\.
+ Elastic Load Balancing supports Path Maximum Transmission Unit \(MTU\) Discovery\. To ensure that Path MTU Discovery can function correctly, you must ensure that the security group for your instance allows ICMP fragmentation required \(type 3, code 4\) messages\. For more information, see [Path MTU Discovery](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/network_mtu.html#path_mtu_discovery) in the *Amazon EC2 User Guide for Linux Instances*\.

## Prepare your VPC and EC2 instances<a name="set-up-ec2"></a>

We recommend that you launch your instances and create your load balancer in a virtual private cloud \(VPC\)\. If you have a new AWS account or plan to use a Region that you haven't used before, you have a default VPC\. You can use a default VPC if you have one, or create your own VPC\.

**Load balancers in a VPC**  
Amazon Virtual Private Cloud \(Amazon VPC\) enables you to define a virtual networking environment in a private, isolated section of the AWS cloud\. Within this virtual private cloud \(VPC\), you can launch AWS resources such as load balancers and EC2 instances\. For more information, see the *[Amazon VPC User Guide](https://docs.aws.amazon.com/vpc/latest/userguide/)*\.

**Subnets for your load balancer**  
To ensure that your load balancer can scale properly, verify that each subnet for your load balancer has a CIDR block with at least a `/27` bitmask \(for example, `10.0.0.0/27`\) and has at least 8 free IP addresses\. Your load balancer uses these IP addresses to establish connections with the instances\.

Create a subnet in each Availability Zone where you want to launch instances\. Depending on your application, you can launch your instances in public subnets, private subnets, or a combination of public and private subnets\. A public subnet has a route to an internet gateway\. Note that default VPCs have one public subnet per Availability Zone by default\.

When you create a load balancer, you must add one or more public subnets to the load balancer\. If your instances are in private subnets, create public subnets in the same Availability Zones as the subnets with your instances; you will add these public subnets to the load balancer\.

**Security groups**  
You must ensure that the load balancer can communicate with your instances on both the listener port and the health check port\. For more information, see [Security groups for load balancers in a VPC](elb-security-groups.md#elb-vpc-security-groups)\. The security group for your instances must allow traffic in both directions on both ports for each subnet for your load balancer\. For more information, see [Security groups for instances in a VPC](elb-security-groups.md#elb-vpc-instance-security-groups)\.

**Network ACLs**  
The network ACLs for your VPC must allow traffic in both directions on the listener port and the health check port\. For more information, see [Network ACLs for load balancers in a VPC](elb-security-groups.md#elb-vpc-nacl)\.

**ClassicLink**  
ClassicLink enables your EC2\-Classic instances to communicate with VPC instances using private IP addresses, provided that the VPC security groups allow it\. If you plan to register linked EC2\-Classic instances with your load balancer, you must enable ClassicLink for your VPC, and then create your load balancer in the ClassicLink\-enabled VPC\. For more information, see [ClassicLink basics](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/vpc-classiclink.html#classiclink-basics) and [Working with ClassicLink](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/vpc-classiclink.html#working-with-classiclink) in the *Amazon EC2 User Guide for Linux Instances*\.