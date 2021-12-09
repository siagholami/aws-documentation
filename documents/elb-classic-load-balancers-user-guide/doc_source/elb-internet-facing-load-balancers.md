# Internet\-facing Classic Load Balancers<a name="elb-internet-facing-load-balancers"></a>

An internet\-facing load balancer has a publicly resolvable DNS name, so it can route requests from clients over the internet to the EC2 instances that are registered with the load balancer\.

![\[An internet-facing load balancer routes traffic from the internet to your EC2 instances.\]](http://docs.aws.amazon.com/elasticloadbalancing/latest/classic/images/internet_facing_load_balancer.png)

If a load balancer is in a VPC with ClassicLink enabled, its instances can be linked EC2\-Classic instances\. If a load balancer is in EC2\-Classic, its instances must be in EC2\-Classic\.

**Topics**
+ [Public DNS names for your load balancer](#internet-facing-ip-addresses)
+ [Create an internet\-facing load balancer](#elb-create-internet-facing-load-balancer)

## Public DNS names for your load balancer<a name="internet-facing-ip-addresses"></a>

When your load balancer is created, it receives a public DNS name that clients can use to send requests\. The DNS servers resolve the DNS name of your load balancer to the public IP addresses of the load balancer nodes for your load balancer\. Each load balancer node is connected to the back\-end instances using private IP addresses\.

**EC2\-VPC**  
Load balancers in a VPC support IPv4 addresses only\. The console displays a public DNS name with the following form:

```
name-1234567890.region.elb.amazonaws.com
```

**EC2\-Classic**  
Load balancers in EC2\-Classic support both IPv4 and IPv6 addresses\. The console displays the following public DNS names:

```
name-123456789.region.elb.amazonaws.com
ipv6.name-123456789.region.elb.amazonaws.com    
dualstack.name-123456789.region.elb.amazonaws.com
```

The base public DNS name returns only IPv4 records\. The public DNS name with the `ipv6` prefix returns only IPv6 records\. The public DNS name with the `dualstack` prefix returns both IPv4 and IPv6 records\. We recommend that you enable IPv6 support by using the DNS name with the `dualstack` prefix to ensure that clients can access the load balancer using either IPv4 or IPv6\.

Clients can connect to your load balancer in EC2\-Classic using either IPv4 or IPv6\. However, communication between the load balancer and its back\-end instances uses only IPv4, regardless of how the client communicates with your load balancer\.

## Create an internet\-facing load balancer<a name="elb-create-internet-facing-load-balancer"></a>

When you create a load balancer in a VPC, you can make it an internal load balancer or an internet\-facing load balancer\. You create an internet\-facing load balancer in a public subnet\. Load balancers in EC2\-Classic are always internet\-facing load balancers\.

When you create your load balancer, you configure listeners, configure health checks, and register back\-end instances\. You configure a listener by specifying a protocol and a port for front\-end \(client to load balancer\) connections, and a protocol and a port for back\-end \(load balancer to back\-end instances\) connections\. You can configure multiple listeners for your load balancer\.

To create a basic internet\-facing load balancer, see [Tutorial: Create a Classic Load Balancer](elb-getting-started.md)\.

To create a load balancer with an HTTPS listener, see [Create a Classic Load Balancer with an HTTPS listener](elb-create-https-ssl-load-balancer.md)\.