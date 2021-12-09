# Troubleshoot a Classic Load Balancer: Client connectivity<a name="ts-elb-connection-failed"></a>

If your internet\-facing load balancer in a VPC is not responding to requests, check for the following:

**Your internet\-facing load balancer is attached to a private subnet**  
Verify that you specified public subnets for your load balancer\. A public subnet has a route to the internet gateway for your virtual private cloud \(VPC\)\.

**A security group or network ACL does not allow traffic**  
The security group for the load balancer and any network ACLs for the load balancer subnets must allow inbound traffic from the clients and outbound traffic to the clients on the listener ports\. For more information, see [Security groups for load balancers in a VPC](elb-security-groups.md#elb-vpc-security-groups)\.