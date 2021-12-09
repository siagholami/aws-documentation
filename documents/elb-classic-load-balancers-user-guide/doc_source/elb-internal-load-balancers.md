# Internal Classic Load Balancers<a name="elb-internal-load-balancers"></a>

When you create a load balancer in a VPC, you must choose whether to make it an internal load balancer or an internet\-facing load balancer\.

The nodes of an internet\-facing load balancer have public IP addresses\. The DNS name of an internet\-facing load balancer is publicly resolvable to the public IP addresses of the nodes\. Therefore, internet\-facing load balancers can route requests from clients over the internet\. For more information, see [Internet\-facing Classic Load Balancers](elb-internet-facing-load-balancers.md)\.

The nodes of an internal load balancer have only private IP addresses\. The DNS name of an internal load balancer is publicly resolvable to the private IP addresses of the nodes\. Therefore, internal load balancers can only route requests from clients with access to the VPC for the load balancer\.

If your application has multiple tiers, for example web servers that must be connected to the internet and database servers that are only connected to the web servers, you can design an architecture that uses both internal and internet\-facing load balancers\. Create an internet\-facing load balancer and register the web servers with it\. Create an internal load balancer and register the database servers with it\. The web servers receive requests from the internet\-facing load balancer and send requests for the database servers to the internal load balancer\. The database servers receive requests from the internal load balancer\.

![\[An internal load balancer routes traffic to your EC2 instances in private subnets.\]](http://docs.aws.amazon.com/elasticloadbalancing/latest/classic/images/internal_load_balancer.png)

**Topics**
+ [Public DNS name for your load balancer](#internal-public-dns-name)
+ [Create an internal Classic Load Balancer](elb-create-internal-load-balancer.md)

## Public DNS name for your load balancer<a name="internal-public-dns-name"></a>

When an internal load balancer is created, it receives a public DNS name with the following form:

```
internal-name-123456789.region.elb.amazonaws.com
```

The DNS servers resolve the DNS name of your load balancer to the private IP addresses of the load balancer nodes for your internal load balancer\. Each load balancer node is connected to the private IP addresses of the back\-end instances using elastic network interfaces\. If cross\-zone load balancing is enabled, each node is connected to each back\-end instance, regardless of Availability Zone\. Otherwise, each node is connected only to the instances that are in its Availability Zone\.