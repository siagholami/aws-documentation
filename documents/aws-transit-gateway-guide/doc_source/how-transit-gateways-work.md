# How transit gateways work<a name="how-transit-gateways-work"></a>

A *transit gateway* acts as a Regional virtual router for traffic flowing between your virtual private clouds \(VPC\) and VPN connections\. A transit gateway scales elastically based on the volume of network traffic\. Routing through a transit gateway operates at layer 3, where the packets are sent to a specific next\-hop attachment, based on their destination IP addresses\.

## Resource attachments<a name="tgw-attachments-overview"></a>

A transit gateway attachment is both a source and a destination of packets\. You can attach the following resources to your transit gateway:
+ One or more VPCs
+ One or more VPN connections
+ One or more AWS Direct Connect gateways
+ One or more transit gateway peering connections

If you attach a transit gateway peering connection, the transit gateway must be in a different Region\.

## Availability Zones<a name="tgw-az-overview"></a>

When you attach a VPC to a transit gateway, you must enable one or more Availability Zones to be used by the transit gateway to route traffic to resources in the VPC subnets\. To enable each Availability Zone, you specify exactly one subnet\. The transit gateway places a network interface in that subnet using one IP address from the subnet\. After you enable an Availability Zone, traffic can be routed to all subnets in that Availability Zone, not just the specified subnet\. Resources that reside in Availability Zones where there is no transit gateway attachment will not be able to reach the transit gateway\.

We recommend that you enable multiple Availability Zones to ensure availability\.

## Routing<a name="tgw-routing-overview"></a>

Your transit gateway routes IPv4 and IPv6 packets between attachments using transit gateway route tables\. You can configure these route tables to propagate routes from the route tables for the attached VPCs and VPN connections\. You can also add static routes to the transit gateway route tables\. When a packet comes from one attachment, it is routed to another attachment using the route that matches the destination IP address\.

For transit gateway peering attachments, only static routes are supported\.

### Route tables<a name="tgw-route-tables-overview"></a>

Your transit gateway automatically comes with a default route table\. By default, this route table is the default association route table and the default propagation route table\. Alternatively, if you disable route propagation and route table association, we do not create a default route table for the transit gateway\.

You can create additional route tables for your transit gateway\. This enables you to isolate subnets of attachments\. Each attachment can be associated with one route table\. An attachment can propagate their routes to one or more route tables\.

You can create a blackhole route in your transit gateway route table that drops traffic that matches the route\.

When you attach a VPC to a transit gateway, you must add a route to your subnet route table for traffic to route through the transit gateway\. For more information, see [Routing for a Transit Gateway](https://docs.aws.amazon.com/vpc/latest/userguide/route-table-options.html#route-tables-tgw) in the *Amazon VPC User Guide*\.

### Route table association<a name="tgw-route-table-association-overview"></a>

You can associate a transit gateway attachment with a single route table\. Each route table can be associated with zero to many attachments and forward packets to other attachments\.

### Route propagation<a name="tgw-route-propagation-overview"></a>

Each attachment comes with routes that can be installed to one or more transit gateway route tables\. When an attachment is propagated to a transit gateway route table, these routes are installed in the route table\. 

For a VPC attachment, the CIDR blocks of the VPC are propagated to the transit gateway route table\. 

For a VPN connection attachment, routes in the transit gateway route table propagate to and from the transit gateway and your on\-premises router using Border Gateway Protocol \(BGP\)\. The prefixes that are advertised over the BGP session are propagated to the transit gateway route table\.

### Routes for peering attachments<a name="tgw-route-table-peering"></a>

You can peer two transit gateways and route traffic between them\. To do this, you create a peering attachment on your transit gateway, and specify the peer transit gateway with which to create the peering connection\. You then create a static route in your transit gateway route table to route traffic to the transit gateway peering attachment\. Traffic that's routed to the peer transit gateway can then be routed to the VPC and VPN attachments for the peer transit gateway\.

For more information, see [Example: Peered transit gateways](transit-gateway-peering-scenario.md)\.

### Route evaluation order<a name="tgw-route-evaluation-overview"></a>

Transit gateway routes are evaluated in the following order:
+ The most specific route for the destination address\.
+ If routes are the same with different targets:
  + Static routes have a higher precedence than propagated routes\.
  + Among propagated routes, VPC CIDRs have a higher precedence than Direct Connect gateways than Site\-to\-Site VPN\.

Consider the following VPC route table\. The VPC local route has the highest priority, followed by the routes that are the most specific\. When a static route and a propagated route have the same destination, the static route has a higher priority\.


| Destination | Target | Priority | 
| --- | --- | --- | 
| 10\.0\.0\.0/16 |  local  | 1 | 
| 192\.168\.0\.0/16 | pcx\-12345 | 2 | 
| 172\.31\.0\.0/16 | vgw\-12345 \(static\) ortgw\-12345 \(static\) | 2 | 
| 172\.31\.0\.0/16 | vgw\-12345 \(propagated\) | 3 | 
| 0\.0\.0\.0/0 | igw\-12345 | 4 | 

Consider the following transit gateway route table\. When a static route and a propagated route have the same destination, the static route has a higher priority\. If you want to use the AWS Direct Connect gateway attachment over the VPN attachment, then use a BGP VPN connection and propagate the routes in the transit gateway route table\.


| Destination | Attachment \(Target\) | Resource type | Route type | Priority | 
| --- | --- | --- | --- | --- | 
| 10\.0\.0\.0/16 | tgw\-attach\-123 \| vpc\-1234 | VPC | Static or propagated | 1 | 
| 192\.168\.0\.0/16 | tgw\-attach\-789 \| vpn\-5678 | VPN | Static | 2 | 
| 172\.31\.0\.0/16 | tgw\-attach\-456 \| dxgw\_id | AWS Direct Connect gateway | Propagated | 3 | 
| 172\.31\.0\.0/16 | tgw\-attach\-789 \| vpn\-5678 | VPN | Propagated | 4 | 