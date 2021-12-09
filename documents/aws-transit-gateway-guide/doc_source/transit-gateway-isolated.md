# Example: Isolated VPCs<a name="transit-gateway-isolated"></a>

You can configure your transit gateway as multiple isolated routers\. This is similar to using multiple transit gateways, but provides more flexibility in cases where the routes and attachments might change\. In this scenario, each isolated router has a single route table\. All attachments associated with an isolated router propagate and associate with its route table\. Attachments associated with one isolated router can route packets to each other, but cannot route packets to or receive packets from the attachments for another isolated router\.

**Topics**
+ [Overview](#transit-gateway-isolated-overview)
+ [Routing](#transit-gateway-isolated-routes)

## Overview<a name="transit-gateway-isolated-overview"></a>

The following diagram shows the key components of the configuration for this scenario\. Packets from VPC A, VPC B, and VPC C route to the transit gateway\. Packets from the subnets in VPC, A, VPC B, and VPC C that have the internet as a destination first route through the transit gateway and then route to the Site\-to\-Site VPN connection \(if the destination is within that network\)\. Packets from one VPC that have a destination of a subnet in another VPC, for example from 10\.1\.0\.0 to 10\.2\.0\.0, route through the transit gateway, where they are blocked because there is no route for them in the transit gateway route table\. 

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/vpc/latest/tgw/images/transit-gateway-centralized.png)

In this scenario, you create the following entities:
+ Three VPCs\. For information about creating a VPC, see [Creating a VPC](https://docs.aws.amazon.com/vpc/latest/userguide/working-with-vpcs.html#Create-VPC) in the *Amazon Virtual Private Cloud User Guide*\.
+ A transit gateway\. For more information, see [Create a transit gateway](tgw-transit-gateways.md#create-tgw)\.
+ Three attachments on the transit gateway for the three VPCs\. For more information, see [Create a transit gateway attachment to a VPC](tgw-vpc-attachments.md#create-vpc-attachment)\.
+ A Site\-to\-Site VPN attachment on the transit gateway\. For more information, see [Create a transit gateway attachment to a VPN](tgw-vpn-attachments.md#create-vpn-attachment)\. Ensure that you review the [requirements for your customer gateway device](https://docs.aws.amazon.com/vpn/latest/s2svpn/your-cgw.html#CGRequirements) in the *AWS Site\-to\-Site VPN User Guide*\.

When the VPN connection is up, the BGP session is established and the VPN CIDR propagates to the transit gateway route table and the VPC CIDRs are added to the customer gateway BGP table\.

## Routing<a name="transit-gateway-isolated-routes"></a>

Each VPC has a route table, and the transit gateway has two route tables—one for the VPCs and one for the VPN connection\.

### VPC A, VPC B, and VPC C route tables<a name="transit-gateway-isolated-route-tables"></a>

Each VPC has a route table with 2 entries\. The first entry is the default entry for local IPv4 routing in the VPC\. This entry enables the instances in this VPC to communicate with each other\. The second entry routes all other IPv4 subnet traffic to the transit gateway\. The following table shows the VPC A routes\.


| Destination | Target | 
| --- | --- | 
|  10\.1\.0\.0/16  |  local  | 
| 0\.0\.0\.0/0 |  *tgw\-id*  | 

### Transit gateway route tables<a name="transit-gateway-isolated-route-table-tgw-route-table"></a>

This scenario uses one route table for the VPCs and one route table for the VPN connection\. 

The VPC attachments are associated with the following route table, which has a propagated route for the VPN attachment\.


| Destination | Target | Route type | 
| --- | --- | --- | 
| 10\.99\.99\.0/24 | Attachment for VPN connection |  propagated  | 

The VPN attachment is associated with the following route table, which has propagated routes for each of the VPC attachments\. 


| Destination | Target | Route type | 
| --- | --- | --- | 
|  10\.1\.0\.0/16  |  *Attachment for VPC A*  |  propagated  | 
|  10\.2\.0\.0/16  |  *Attachment for VPC B*  |  propagated  | 
|  10\.3\.0\.0/16  |  *Attachment for VPC C*  |  propagated  | 

For more information about propagating routes in a transit gateway route table, see [Propagate a route to a transit gateway route table](tgw-route-tables.md#enable-tgw-route-propagation)\.

### Customer gateway BGP table<a name="transit-gateway-isolated-route-table-bgp-table"></a>

The customer gateway BGP table contains the following VPC CIDRs\.
+ 10\.1\.0\.0/16
+ 10\.2\.0\.0/16
+ 10\.3\.0\.0/16