# Example: Centralized router<a name="transit-gateway-centralized-router"></a>

You can configure your transit gateway as a centralized router that connects all of your VPCs, AWS Direct Connect, and Site\-to\-Site VPN connections\. In this scenario, all attachments are associated with the transit gateway default route table and propagate to the transit gateway default route table\. Therefore, all attachments can route packets to each other, with the transit gateway serving as a simple layer 3 IP router\.

**Topics**
+ [Overview](#transit-gateway-centralized-router-overview)
+ [Routing](#transit-gateway-centralized-router-routing)

## Overview<a name="transit-gateway-centralized-router-overview"></a>

The following diagram shows the key components of the configuration for this scenario\. In this scenario, there are three VPC attachments and one Site\-to\-Site VPN attachment to the transit gateway\. Packets from the subnets in VPC A, VPC B, and VPC C that are destined for a subnet in another VPC or for the VPN connection first route through the transit gateway\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/vpc/latest/tgw/images/transit-gateway-centralized.png)

In this scenario, you create the following entities for this scenario::
+ Three VPCs\. For information about creating a VPC, see [Creating a VPC](https://docs.aws.amazon.com/vpc/latest/userguide/working-with-vpcs.html#Create-VPC) in the *Amazon Virtual Private Cloud User Guide*\.
+ A transit gateway\. For more information, see [Create a transit gateway](tgw-transit-gateways.md#create-tgw)\.
+ Three VPC attachments on the transit gateway\. For more information, see [Create a transit gateway attachment to a VPC](tgw-vpc-attachments.md#create-vpc-attachment)\.
+ A Site\-to\-Site VPN attachment on the transit gateway\. For more information, see [Create a transit gateway attachment to a VPN](tgw-vpn-attachments.md#create-vpn-attachment)\. Ensure that you review the [requirements for your customer gateway device](https://docs.aws.amazon.com/vpn/latest/s2svpn/your-cgw.html#CGRequirements) in the *AWS Site\-to\-Site VPN User Guide*\.

When you create the VPC attachments, the CIDR blocks for each VPC propagate to the transit gateway route table\. When the VPN connection is up, the BGP session is established and the Site\-to\-Site VPN CIDR propagates to the transit gateway route table and the VPC CIDRs are added to the customer gateway BGP table\.

## Routing<a name="transit-gateway-centralized-router-routing"></a>

Each VPC has a route table and there is a route table for the transit gateway\.

### VPC route tables<a name="transit-gateway-centralized-router-vpc-route-tables"></a>

Each VPC has a route table with 2 entries\. The first entry is the default entry for local IPv4 routing in the VPC; this entry enables the instances in this VPC to communicate with each other\. The second entry routes all other IPv4 subnet traffic to the transit gateway\. The following table shows the VPC A routes\.


| Destination | Target | 
| --- | --- | 
|  10\.1\.0\.0/16  |  local  | 
|  0\.0\.0\.0/0  |  *tgw\-id*  | 

### Transit gateway route table<a name="transit-gateway-centralized-router-tgw-route-table"></a>

The following is an example of a default route table for the attachments shown in the previous diagram, with route propagation enabled\.


| Destination | Target | Route type | 
| --- | --- | --- | 
|  10\.1\.0\.0/16  |  *Attachment for VPC A*  |  propagated  | 
|  10\.2\.0\.0/16  |  *Attachment for VPC B*  |  propagated  | 
|  10\.3\.0\.0/16  |  *Attachment for VPC C*  |  propagated  | 
|  10\.99\.99\.0/24  | Attachment for VPN connection  |  propagated  | 

### Customer gateway BGP table<a name="transit-gateway-centralized-router-vpn-route-table"></a>

The customer gateway BGP table contains the following VPC CIDRs\.
+ 10\.1\.0\.0/16
+ 10\.2\.0\.0/16
+ 10\.3\.0\.0/16