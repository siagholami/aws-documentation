# Internetwork traffic privacy<a name="internetwork-traffic-privacy"></a>

**To route traffic directly between MediaConnect and your corporate network via a virtual private cloud \(VPC\)**

1. Set up a private connection between your Amazon VPC and your corporate network\. Set up either an IPsec VPN connection over the internet or a private physical connection using AWS Direct Connect connection\. AWS Direct Connect enables you to establish a private virtual interface from your on\-premises network directly to your Amazon VPC, providing you with a private, high\-bandwidth network connection between your network and your VPC\. With multiple virtual interfaces, you can establish private connectivity to multiple VPCs while maintaining network isolation\. For more information, see [What is AWS Site\-to\-Site VPN?](https://docs.aws.amazon.com/vpn/latest/s2svpn/VPC_VPN.html) and [What is AWS Direct Connect?](https://docs.aws.amazon.com/directconnect/latest/UserGuide/Welcome.html)

1. [Create a flow that uses a VPC *source*](flows-create-vpc-source.md)\. During this process, you add a VPC *interface* to your flow to establish the initial connection between your VPC and your flow\. You also specify that same VPC interface as the source for the new flow\.
**Note**  
If your flow already exists, you can update the flow to [add a VPC interface](vpc-interface-add.md) and then [add another source that uses that VPC interface](source-adding-vpc.md)\.