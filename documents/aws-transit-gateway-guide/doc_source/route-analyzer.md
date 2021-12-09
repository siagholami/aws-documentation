# Route Analyzer<a name="route-analyzer"></a>

In your global network, you can use the Route Analyzer to perform an analysis of the routes in your transit gateway route tables\. The Route Analyzer analyzes the routing path between a specified source and destination, and returns information about the connectivity between components\. You can use the Route Analyzer to do the following:
+ Verify that the transit gateway route table configuration will work as expected before you start sending traffic\.
+ Validate your existing route configuration\.
+ Diagnose route\-related issues that are causing traffic disruption in your global network\.

**Topics**
+ [Route Analyzer basics](#route-analyzer-basics)
+ [Performing a route analysis](#working-with-route-analyzer)
+ [Example: Route analysis for peered transit gateways](#example-route-analyzer)
+ [Example: Route analysis with a middlebox configuration](#example-route-analyzer-middlebox)

## Route Analyzer basics<a name="route-analyzer-basics"></a>

To use the Route Analyzer, you indicate the path for the traffic from a source to a destination\. For the source, you specify the transit gateway, the transit gateway attachment from which the traffic originates, and a source IPv4 or IPv6 address\. The Route Analyzer analyzes the routes in the associated transit gateway route table for the transit gateway attachment\. For the destination, you specify a target IPv4 or IPv6 address, and the destination transit gateway and transit gateway attachment\.

If you've configured a middlebox appliance in your VPC, you can indicate the location of the appliance in the route analysis\. This enables you to specify multiple network hops in a route between a source and destination, to help you analyze the route of the traffic\.

You can also analyze the return path for traffic from the specified destination back to the source\. 

The following rules apply when using the Route Analyzer:
+ The Route Analyzer analyzes routes in transit gateway route tables only\. It does not analyze routes in VPC route tables or in your customer gateway devices\. 
+ The transit gateways must be registered in your global network\.
+ The Route Analyzer does not analyze security group rules or network ACL rules\. To capture information about accepted and rejected IP traffic in your VPC, you can use [VPC flow logs](https://docs.aws.amazon.com/vpc/latest/userguide/flow-logs.html)\.
+ The Route Analyzer only returns information for the return path if it can successfully return information for the forward path\.

## Performing a route analysis<a name="working-with-route-analyzer"></a>

To use the Route Analyzer, you must use the Network Manager console\.

**To analyze your routes**

1. Open the Network Manager console at [https://console\.aws\.amazon\.com/networkmanager/](https://console.aws.amazon.com/networkmanager/)\. 

1. Choose the ID for your global network, and then choose **Route Analyzer**\.

1. Under **Source**, do the following:
   + Choose the transit gateway and the transit gateway attachment\.
   + For **IP address**, enter a source IPv4 or IPv6 address\.

1. Under **Destination**, do the following:
   + Choose the transit gateway and the transit gateway attachment\.
   + For **IP address**, enter a target IPv4 or IPv6 address\.

1. \(Optional\) To analyze the return path, ensure that you enable **Include return path in results**\. If enabled, you must specify an IP address under **Source**\.

1. To specify middlebox appliances in the routing path, choose **Middlebox appliance?**\.

1. Choose **Run route analysis**\.

1. The results are displayed under **Results of route analysis**\. If you specified **Middlebox appliance?** in step 6, choose **Yes **or **No** for each of the attachments to indicate the location of the appliances and to complete the route analysis\.

   You can choose the ID of any of the resources in the path to view more information about the resources\.

## Example: Route analysis for peered transit gateways<a name="example-route-analyzer"></a>

In the following example, transit gateway 1 has two VPC attachments, and a peering attachment to transit gateway 2\. Transit gateway 2 has a Site\-to\-Site VPN attachment to your on\-premises network\. You want to use the Route Analyzer to ensure that the VPCs and Site\-to\-Site VPN connections can route traffic to each other through the transit gateways\.

![\[Peered transit gateways\]](http://docs.aws.amazon.com/vpc/latest/tgw/images/transit-gateway-peering.png)

In the Route Analyzer, do the following:

1. Under **Source**, specify transit gateway 1 and the transit gateway attachment for VPC A\. Specify an IP address from the CIDR block of VPC A, for example, `10.0.0.7`\.

1. Under **Destination**, specify transit gateway 2 and the VPN attachment\. Specify an IP address from the range of the on\-premises network, for example, `172.31.0.8`\.

1. Ensure that **Include return path in results** is selected\.

1. Run the route analysis\. In the results, verify the path between the source and destination\. For example, the following results indicate that there is a forward path from transit gateway 1 to transit gateway 2, but no return path\. Check the route table for transit gateway 2, and ensure that there is a static route that points to the peering attachment\.  
![\[Route analyzer results\]](http://docs.aws.amazon.com/vpc/latest/tgw/images/nm-route-analyzer-peering.png)

1. To run the analysis between VPC B and the VPN connection, modify the information under **Source**\. Choose the transit gateway attachment for VPC B, and specify an IP address from the CIDR block of VPC B, for example, `10.2.0.9`\.

1. Reload the results and verify the path between the source and destination\.

For more information about the routing configuration for this scenario, see the [transit gateway peering example](transit-gateway-peering-scenario.md)\.

## Example: Route analysis with a middlebox configuration<a name="example-route-analyzer-middlebox"></a>

If you've configured a VPC to act as a middlebox appliance for inspecting traffic that flows to other parts of your network, you can indicate the location of the appliance in the route analysis\. In the following example, the transit gateway has two VPC attachments and a VPN attachment\. VPC A runs a firewall appliance \(middlebox\) that inspects the traffic that flows between the VPN connection and VPC B\.

![\[Middlebox appliance\]](http://docs.aws.amazon.com/vpc/latest/tgw/images/route-analyzer-middlebox.png)

 In the Route Analyzer, you can specify the location of the middlebox appliance as follows:

1. Under **Source**, specify the transit gateway and the VPN attachment\. Specify an IP address from the range of the on\-premises network, for example, `10.0.0.7`\.

1. Under **Destination**, specify the transit gateway and the attachment for VPC B\. Specify an IP address from the CIDR block of VPC B, for example, `172.31.0.8`\.

1. For **Middlebox appliance?**, choose **Include**\.

1. Run the route analysis\.

1. For the **Middlebox appliance?** sections for the transit gateway attachment for VPC A, choose **Yes**\.

   You can choose the ID of any resource in the path to view more information about that resource\.

![\[Route analyzer results\]](http://docs.aws.amazon.com/vpc/latest/tgw/images/nm-route-analyzer-middlebox.png)