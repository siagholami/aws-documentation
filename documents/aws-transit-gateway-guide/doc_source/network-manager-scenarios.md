# Scenarios for Transit Gateway Network Manager<a name="network-manager-scenarios"></a>

The following are common use cases and scenarios for Network Manager\.

**Topics**
+ [AWS\-only global network](#scenario-aws-only-global-network)
+ [Single device with a single VPN connection](#scenario-one-device-one-vpn)
+ [Device with multiple VPN connections](#scenario-device-multiple-vpns)
+ [Multi\-device and multi\-link site](#scenario-multi-device-site)
+ [SD\-WAN connecting to AWS](#scenario-wan-to-aws)

## AWS\-only global network<a name="scenario-aws-only-global-network"></a>

In this scenario, your AWS network consists of three transit gateways\. You own transit gateways `tgw-1` and `tgw-3`\. Transit gateway `tgw-1` has a peering attachment with transit gateway `tgw-2` that's in a different AWS account\. Your entire network is within AWS, and does not consist of on\-premises resources\.

![\[AWS-only global network\]](http://docs.aws.amazon.com/vpc/latest/tgw/images/nm-aws-only.png)

For this scenario, do the following in Network Manager:
+ Create a global network\. For more information, see [Creating a global network](global-networks.md#global-networks-creating)\.
+ Register the transit gateways `tgw-1` and `tgw-3` with your global network\. For more information, see [Registering a transit gateway](tgw-registrations.md#register-tgw)\. 

  When you register `tgw-1`, the transit gateway peering attachment is included in the global network and you can see information about `tgw-2`\. However, any attachments for `tgw-2` are not included in your global network\.

## Single device with a single VPN connection<a name="scenario-one-device-one-vpn"></a>

In the following scenario, your global network consists of a single site with a single device and link\. The site is connected to your AWS network through a Site\-to\-Site VPN attachment on a transit gateway\. Your transit gateway also has two VPC attachments\.

![\[Single device and single VPN network\]](http://docs.aws.amazon.com/vpc/latest/tgw/images/nm-single-device-single-vpn.png)

For this scenario, do the following in Network Manager:
+ Create a global network\. For more information, see [Creating a global network](global-networks.md#global-networks-creating)\.
+ Register the transit gateway\. For more information, see [Registering a transit gateway](tgw-registrations.md#register-tgw)\.
+ Create a site, device, and link\. For more information, see [Working with sites](on-premises-networks.md#working-with-sites), [Working with devices](on-premises-networks.md#working-with-devices), and [Working with links](on-premises-networks.md#working-with-links)\.
+ Associate the device with the site and with the link\. For more information, see [Device associations](on-premises-networks.md#device-associations)\.
+ Associate the customer gateway \(for the transit gateway Site\-to\-Site VPN attachment\) with the device, and optionally, the link\. For more information, see [Customer gateway associations](on-premises-networks.md#cgw-association)\.

## Device with multiple VPN connections<a name="scenario-device-multiple-vpns"></a>

In the following scenario, your on\-premises network consists of a device with two Site\-to\-Site VPN connections to AWS\. The device is associated with two customer gateways on two different transit gateways\. Each VPN connection uses a separate link\. To indicate which link applies to which VPN connection, you associate the customer gateway with both the device and the corresponding link\.

![\[Multi-VPN network\]](http://docs.aws.amazon.com/vpc/latest/tgw/images/nm-device-multiple-vpn.png)

For this scenario, do the following in Network Manager:
+ Create a global network\. For more information, see [Creating a global network](global-networks.md#global-networks-creating)\.
+ Register the transit gateways\. For more information, see [Registering a transit gateway](tgw-registrations.md#register-tgw)\.
+ Create a site, device, and link\. For more information, see [Working with sites](on-premises-networks.md#working-with-sites), [Working with devices](on-premises-networks.md#working-with-devices), and [Working with links](on-premises-networks.md#working-with-links)\.
+ Associate the device with the site and both links\. For more information, see [Device associations](on-premises-networks.md#device-associations)\.
+ Associate each customer gateway with the device and the corresponding link\. For more information, see [Customer gateway associations](on-premises-networks.md#cgw-association)\.

## Multi\-device and multi\-link site<a name="scenario-multi-device-site"></a>

In the following scenario, your on\-premises network consists of a site with two devices and two separate Site\-to\-Site VPN connections to AWS\. For example, in a single building or campus, you might have multiple devices connected to AWS resources\. Each device is associated with a customer gateway that's attached to your transit gateway\.

Your AWS network is also connected to your on\-premises network though an AWS Direct Connect gateway, which is an attachment on your transit gateway\.

![\[Multi-device and multi-link network\]](http://docs.aws.amazon.com/vpc/latest/tgw/images/nm-multi-device-site.png)

For this scenario, do the following in Network Manager:
+ Create a global network\. For more information, see [Creating a global network](global-networks.md#global-networks-creating)\.
+ Register the transit gateway\. For more information, see [Registering a transit gateway](tgw-registrations.md#register-tgw)\.
+ Create one site, two devices, and two links\. For more information, see [Working with sites](on-premises-networks.md#working-with-sites), [Working with devices](on-premises-networks.md#working-with-devices), and [Working with links](on-premises-networks.md#working-with-links)\.
+ Associate each device with the corresponding link\. For more information, see [Device associations](on-premises-networks.md#device-associations)\.
+ Associate each customer gateway with the corresponding device and link\. For more information, see [Customer gateway associations](on-premises-networks.md#cgw-association)\.

## SD\-WAN connecting to AWS<a name="scenario-wan-to-aws"></a>

In the following example, your on\-premises network consists of two sites\. The Chicago site has two devices and the New York site has one device\. Your AWS network consists of two transit gateways\. All devices are associated with customer gateways \(Site\-to\-Site VPN attachments\) on both transit gateways\.

Your on\-premises network is managed using SD\-WAN\. The SD\-WAN controller creates Site\-to\-Site VPN connections to the transit gateways, and creates the device, site, and link resources in Network Manager\. This automates connectivity and enables you to get a full view of your network in Network Manager\. The SD\-WAN controller can also use Network Manager events and metrics to enhance its dashboard\. 

![\[SD-WAN connecting to AWS\]](http://docs.aws.amazon.com/vpc/latest/tgw/images/nm-sd-wan-aws.png)

For more information about Partners who can help you set up your Site\-to\-Site VPN connections, see [Transit Gateway Network Manager](https://aws.amazon.com/transit-gateway/network-manager)\.