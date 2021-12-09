# Multicast on transit gateways<a name="tgw-multicast-overview"></a>

Multicast is a communication protocol used for delivering a single stream of data to multiple receiving computers simultaneously\. Transit Gateway supports routing multicast traffic between subnets of attached VPCs and serves as a multicast router for instances sending traffic destined for multiple receiving instances\. 

## Multicast concepts<a name="concepts"></a>

The following are the key concepts for multicast:
+ **Multicast domain** — A Multicast domain allows segmentation of a multicast network into different domains and makes the transit gateway act as multiple multicast routers\. You define multicast domain membership at the subnet level\. 
+ **Multicast group** — A multicast group is used to identify a set of sources and receivers that will send and receive the same multicast traffic\. A multicast group is identified by a group IP address\. Sources use the group address as the IP destination address in their data packets\. Receivers use this group address to inform the network that they are interested in receiving packets sent to that group\. Transit gateway multicast group membership is defined by individual elastic network interfaces attached to EC2 instances\.
+ **Multicast source** — An elastic network interface associated with a supported EC2 instance that sends multicast traffic\. 
+ **Multicast group member** — An elastic network interface associated with a supported EC2 instance that receives multicast traffic\. A multicast group has multiple group members\.

## Considerations<a name="limits"></a>
+ For information about supported Regions, see [AWS Transit Gateway FAQs](https://aws.amazon.com/transit-gateway/faqs)\.
+ You must create a new transit gateway to enable multicast\.
+ You cannot share multicast\-enabled transit gateways with other accounts \(using AWS Resource Access Manager\)\.
+ Multicast group membership is managed using Amazon VPC Console or the AWS CLI\. 
+   [Internet Group Management Protocol \(IGMP\)](https://en.wikipedia.org/wiki/Internet_Group_Management_Protocol) support for managing group membership will come in the future\.
+ A subnet can only be in one multicast domain\. 
+ If you use a non\-Nitro instance, you must disable the **Source/Dest** check\. For information about disabling the check, see [Changing the source or destination checking](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-eni.html#change_source_dest_check) in the *Amazon EC2 User Guide for Linux Instances*\.
+ A non\-Nitro instance cannot be a multicast sender\.
+ Multicast routing is not supported over AWS Direct Connect, Site\-to\-Site VPN, and peering attachments\.
+ A transit gateway does not support fragmentation of multicast packets\. Fragmented multicast packets will get dropped\. For more information, see [MTU](transit-gateway-quotas.md#mtu-quota)\.