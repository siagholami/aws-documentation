# What is a Classic Load Balancer?<a name="introduction"></a>

Elastic Load Balancing supports three types of load balancers: Application Load Balancers, Network Load Balancers, and Classic Load Balancers\. This guide discusses Classic Load Balancers\. For more information about Application Load Balancers, see the [User Guide for Application Load Balancers](https://docs.aws.amazon.com/elasticloadbalancing/latest/application/)\. For more information about Network Load Balancers, see the [Elastic Load Balancing User Guide](https://docs.aws.amazon.com/elasticloadbalancing/latest/userguide/)\.

## Classic Load Balancer overview<a name="classic-load-balancer-overview"></a>

A load balancer distributes incoming application traffic across multiple EC2 instances in multiple Availability Zones\. This increases the fault tolerance of your applications\. Elastic Load Balancing detects unhealthy instances and routes traffic only to healthy instances\.

Your load balancer serves as a single point of contact for clients\. This increases the availability of your application\. You can add and remove instances from your load balancer as your needs change, without disrupting the overall flow of requests to your application\. Elastic Load Balancing scales your load balancer as traffic to your application changes over time\. Elastic Load Balancing can scale to the vast majority of workloads automatically\.

A *listener* checks for connection requests from clients, using the protocol and port that you configure, and forwards requests to one or more registered instances using the protocol and port number that you configure\. You add one or more listeners to your load balancer\.

You can configure *health checks*, which are used to monitor the health of the registered instances so that the load balancer only sends requests to the healthy instances\.

![\[A load balancer routes traffic from clients to your EC2 instances.\]](http://docs.aws.amazon.com/elasticloadbalancing/latest/classic/images/load_balancer.png)

To ensure that your registered instances are able to handle the request load in each Availability Zone, it is important to keep approximately the same number of instances in each Availability Zone registered with the load balancer\. For example, if you have ten instances in Availability Zone us\-west\-2a and two instances in us\-west\-2b, the requests are distributed evenly between the two Availability Zones\. As a result, the two instances in us\-west\-2b serve the same amount of traffic as the ten instances in us\-west\-2a\. Instead, you should have six instances in each Availability Zone\.

By default, the load balancer distributes traffic evenly across the Availability Zones that you enable for your load balancer\. To distribute traffic evenly across all registered instances in all enabled Availability Zones, enable *cross\-zone load balancing* on your load balancer\. However, we still recommend that you maintain approximately equivalent numbers of instances in each Availability Zone for better fault tolerance\.

For more information, see [How Elastic Load Balancing works](https://docs.aws.amazon.com/elasticloadbalancing/latest/userguide/how-elastic-load-balancing-works.html) in the *Elastic Load Balancing User Guide*\.

## Benefits<a name="classic-load-balancer-benefits"></a>

Using a Classic Load Balancer instead of an Application Load Balancer has the following benefits:
+ Support for EC2\-Classic
+ Support for TCP and SSL listeners
+ Support for sticky sessions using application\-generated cookies

For more information about the features supported by each load balancer type, see [Product comparison](https://aws.amazon.com/elasticloadbalancing/details/#compare) for Elastic Load Balancing\.

## How to get started<a name="classic-load-balancer-getting-started"></a>
+ To learn how to create a Classic Load Balancer and register EC2 instances with it, see [Tutorial: Create a Classic Load Balancer](elb-getting-started.md)\.
+ To learn how to create an HTTPS load balancer and register EC2 instances with it, see [Create a Classic Load Balancer with an HTTPS listener](elb-create-https-ssl-load-balancer.md)\.
+ To learn how to use the various features supported by Elastic Load Balancing, see [Configure your Classic Load Balancer](elb-configure-load-balancer.md)\.

## Pricing<a name="classic-load-balancer-pricing"></a>

With your load balancer, you pay only for what you use\. For more information, see [Elastic Load Balancing Pricing](https://aws.amazon.com/elasticloadbalancing/pricing/)\.