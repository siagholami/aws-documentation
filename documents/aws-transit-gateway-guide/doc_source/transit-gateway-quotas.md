# Quotas for your transit gateways<a name="transit-gateway-quotas"></a>

Your AWS account has the following service quotas \(previously referred to as *limits*\) related to transit gateways\. Unless indicated otherwise, you can [request an increase](https://console.aws.amazon.com/support/home#/case/create?issueType=service-limit-increase&limitType=vpc) for a quota\. For more information about service quotas, see [AWS Service Quotas](https://docs.aws.amazon.com/general/latest/gr/aws_service_limits.html) in the *Amazon Web Services General Reference*\.

## General<a name="general-quota"></a>
+ Number of transit gateways per Region per account: 5

## Routing<a name="general-quota"></a>
+ Number of transit gateway route tables per transit gateway: 20
+ Number of routes per transit gateway: 10,000

  For VPC route table quotas, see [Amazon VPC quotas](https://docs.aws.amazon.com/vpc/latest/userguide/amazon-vpc-limits.html) in the *Amazon VPC User Guide*\.

## Transit gateway attachments<a name="attachments-quota"></a>
+ Total number of transit gateway attachments per transit gateway: 5,000
+ Number of unique transit gateway attachments per VPC: 5

  This value cannot be increased\. A transit gateway cannot have more than one attachment to the same VPC\.
+ Number of transit gateway peering attachments per transit gateway: 50
+ Number of transit gateway peering attachments between two transit gateways: 1
+ Number of pending transit gateway peering attachments transit gateway:10

## Bandwidth<a name="bandwidth-quota"></a>
+ Maximum bandwidth \(burst\) per VPC, Direct Connect gateway, or peered transit gateway connection: 50 Gbps
+ Maximum bandwidth per VPN tunnel: 1\.25 Gbps

  This is a hard value\. You can use ECMP to get higher VPN bandwidth by aggregating multiple VPN tunnels\. To use ECMP, the VPN connection must be configured for dynamic routing\. ECMP is not supported on VPN connections that use static routing\.

## AWS Direct Connect gateways<a name="direct-connect-quota"></a>
+ Number of AWS Direct Connect gateways per transit gateway: 20

  This value cannot be increased\.
+ Transit gateways per AWS Direct Connect gateway: 3

  This value cannot be increased\.

## MTU<a name="mtu-quota"></a>
+  The maximum transmission unit \(MTU\) of a network connection is the size, in bytes, of the largest permissible packet that can be passed over the connection\. The larger the MTU of a connection, the more data can be passed in a single packet\. A transit gateway supports an MTU of 8500 bytes for traffic between VPCs, Direct Connect and peering attachments\. Traffic over VPN connections can have an MTU of 1500 bytes\. 
+ Packets with a size larger than 8500 bytes which arrive at the transit gateway are dropped\.
+ The transit gateway does not generate the FRAG\_NEEDEDICMP packet, so Path MTU Discovery \(PMTUD\) is not supported\.
+ The transit gateway enforces Maximum Segment Size \(MSS\) clamping for all packets\. For more information, see [RFC879](https://tools.ietf.org/html/rfc879)\.

## Multicast<a name="multicast-quota"></a>
+ Number of multicast domains per transit gateway: 20
+ Number of multicast group members and sources per transit gateway: 1000
+ Number of members per transit gateway multicast group: 100
+ Number of multicast domain associations per VPC: 20
+ Number of sources per transit gateway multicast group: 1

## Additional quota resources<a name="additional-quota"></a>

For information about quotas that apply to Site\-to\-Site VPN connections, see [Site\-to\-Site VPN Quotas](https://docs.aws.amazon.com/vpn/latest/s2svpn/vpn-limits.html) in the *AWS Site\-to\-Site VPN User Guide*\.

For information about quotas that apply to VPC attachments see [Amazon VPC Quotas](https://docs.aws.amazon.com/vpc/latest/userguide/amazon-vpc-limits.html) in the *Amazon VPC User Guide*\.

For information about quotas that apply to Direct Connect gateway attachments see [AWS Direct Connect Quotas](https://docs.aws.amazon.com/directconnect/latest/UserGuide/limits.html) in the* AWS Direct Connect User Guide*\.

For more information about service quotas for Transit Gateway Network Manager, see [Network Manager quotas](how-network-manager-works.md#network-manager-limits)\.