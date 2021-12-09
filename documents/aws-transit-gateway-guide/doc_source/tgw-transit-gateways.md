# Transit gateways<a name="tgw-transit-gateways"></a>

A transit gateway enables you to attach VPCs and VPN connections in the same Region and route traffic between them\. A transit gateway works across AWS accounts, and you can use AWS Resource Access Manager to share your transit gateway with other accounts\. After you share a transit gateway with another AWS account, the account owner can attach their VPCs to your transit gateway\. A user from either account can delete the attachment at any time\.

You can enable multicast on a transit gateway, and then create a transit gateway multicast domain that allows multicast traffic to be sent from your multicast source to multicast group members over VPC attachments that you associate with the domain\.

You can also create a peering connection attachment between transit gateways in different AWS Regions\. This enables you to route traffic between the transit gateways' attachments across different Regions\.

Each VPC or VPN attachment is associated with a single route table\. That route table decides the next hop for the traffic coming from that resource attachment\. A route table inside the transit gateway allows for both IPv4 or IPv6 CIDRs and targets\. The targets are VPCs and VPN connections\. When you attach a VPC or create a VPN connection on a transit gateway, the attachment is associated with the default route table of the transit gateway\.

You can create additional route tables inside the transit gateway, and change the VPC or VPN association to these route tables\. This enables you to segment your network\. For example, you can associate development VPCs with one route table and production VPCs with a different route table\. This enables you to create isolated networks inside a transit gateway similar to virtual routing and forwarding \(VRFs\) in traditional networks\.

Transit gateways support dynamic and static routing between attached VPCs and VPN connections\. You can enable or disable route propagation for each attachment\. Transit gateway peering attachments support static routing only\.

**Topics**
+ [Create a transit gateway](#create-tgw)
+ [View your transit gateways](#view-tgws)
+ [Add or edit tags for a transit gateway](#tgw-tagging)
+ [Modify a transit gateway](#tgw-modifying)
+ [Share a transit gateway](#tgw-sharing)
+ [Accept a resource share](#tgw-share-accept)
+ [Accept a shared attachment](#tgw-accept-shared-attachment)
+ [Delete a transit gateway](#delete-tgw)

## Create a transit gateway<a name="create-tgw"></a>

When you create a transit gateway, we create a default transit gateway route table and use it as the default association route table and the default propagation route table\.

**To create a transit gateway using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. On the navigation pane, choose **Transit Gateways**\.

1. Choose **Create Transit Gateway**\.

1. For **Name tag**, optionally enter a name for the transit gateway\. A name tag can make it easier to identify a specific gateway from the list of gateways\. When you add a **Name tag**, a tag is created with a key of **Name** and with a value equal to the value you enter\.

1. For **Description**, optionally enter a description for the transit gateway\.

1. For **Amazon side ASN**, either leave the default value to use the default Autonomous System Number \(ASN\), or enter the private ASN for your transit gateway\. This should be the ASN for the AWS side of a Border Gateway Protocol \(BGP\) session\.

   The range is 64512 to 65534 for 16\-bit ASNs\.

   The range is 4200000000 to 4294967294 for 32\-bit ASNs\.

   If you have a multi\-region deployment, we recommend that you use a unique ASN for each of your transit gateways\.

1. For **DNS support**, choose **enable** if you need the VPC to resolve public IPv4 DNS host names to private IPv4 addresses when queried from instances in another VPC attached to the transit gateway\.

1. For **VPN ECMP support**, choose **enable** if you need Equal Cost Multipath \(ECMP\) routing support between VPN tunnels\. If connections advertise the same CIDRs, the traffic is distributed equally between them\.

   When you select this option, the advertised BGP ASN, the BGP attributes such as the AS\-path and the communities for preference must be the same\.
**Note**  
To use ECMP, you must create a VPN connection that uses dynamic routing\. VPN connections that use static routing do not support ECMP\.

1. For **Default route table association**, choose **enable** to automatically associate transit gateway attachments with the default route table for the transit gateway\.

1. For **Default route table propagation**, choose **enable** to automatically propagate transit gateway attachments to the default route table for the transit gateway\.

1. \(Optional\) To use the transit gateway as a router for multicast traffic, select **Multicast support**\.

1. For **Auto accept shared attachments**, choose **enable** to automatically accept cross\-account attachments\.

1. Choose **Create Transit Gateway**\.

1. After you see the message **Create Transit Gateway request succeeded**, choose **Close**\.

**To create a transit gateway using the AWS CLI**  
Use the [create\-transit\-gateway](https://docs.aws.amazon.com/cli/latest/reference/ec2/create-transit-gateway.html) command\.

## View your transit gateways<a name="view-tgws"></a>

**To view your transit gateways using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. On the navigation pane, choose **Transit Gateways**\. The details for the transit gateway are displayed below the list of gateways on the page\.

**To view your transit gateways using the AWS CLI**  
Use the [describe\-transit\-gateways](https://docs.aws.amazon.com/cli/latest/reference/ec2/describe-transit-gateways.html) command\.

## Add or edit tags for a transit gateway<a name="tgw-tagging"></a>

Add tags to your resources to help organize and identify them, such as by purpose, owner, or environment\. You can add multiple tags to each transit gateway\. Tag keys must be unique for each transit gateway\. If you add a tag with a key that is already associated with the transit gateway, it updates the value of that tag\. For more information, see [Tagging your Amazon EC2 Resources](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/Using_Tags.html)\.

**Add tags to a transit gateway using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. On the navigation pane, choose **Transit Gateways**\.

1. Choose the transit gateway for which to add or edit tags\.

1. Choose the **Tags** tab in the lower part of the page\.

1. Choose **Add/Edit Tags**\.

1. Choose **Create Tag**\.

1. Enter a **Key** and **Value** for the tag\.

1. Choose **Save**\.

## Modify a transit gateway<a name="tgw-modifying"></a>

You can modify the configuration options for your transit gateway\. When you modify a transit gateway, the modified options are applied to new transit gateway attachments only\. Your existing transit gateway attachments are not modified\.

You cannot modify a transit gateway that has been shared with you\.

**To modify a transit gateway**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. On the navigation pane, choose **Transit Gateways**\.

1. Choose the transit gateway to modify\.

1. Choose **Actions**, **Modify**\.

1. Modify the options as needed, and choose **Modify transit gateway**\.

**To modify your transit gateway using the AWS CLI**  
Use the [modify\-transit\-gateway](https://docs.aws.amazon.com/cli/latest/reference/ec2/modify-transit-gateway.html) command\.

## Share a transit gateway<a name="tgw-sharing"></a>

You can use AWS Resource Access Manager \(RAM\) to [share a transit gateway](transit-gateway-share.md) across accounts or across your organization in AWS Organizations\. Use the following procedure to share a transit gateway that you own\. 

You must enable resource sharing from the master account for your organization\. For information about enabling resource sharing, see [Enable Sharing with AWS Organizations](https://docs.aws.amazon.com/ram/latest/userguide/getting-started-sharing.html#getting-started-sharing-orgs) in the *AWS RAM User Guide*\.

**To share a transit gateway**

1. Open the AWS Resource Access Manager console at [https://console\.aws\.amazon\.com/ram/](https://console.aws.amazon.com/ram/)\.

1. Choose **Create a resource share**\.

1. Under **Description**, for **Name**, type a descriptive name for the resource share\.

1. For **Select resource type**, choose **Transit Gateways**\. Select the transit gateway\.

1. \(Optional\) For **Principals**, add principals to the resource share\. For each AWS account, OU, or organization, specify its ID and choose **Add**\.

   For **Allow external accounts**, choose whether to allow sharing for this resource with AWS accounts that are external to your organization\.

1. \(Optional\) Under **Tags**, type a tag key and tag value pair for each tag\. These tags are applied to the resource share but not to the transit gateway\.

1. Choose **Create resource share**\.

## Accept a resource share<a name="tgw-share-accept"></a>

If you were added to a resource share, you receive an invitation to join the resource share\. You must accept the resource share before you can access the shared resources\.

**To accept a resource share**

1. Open the AWS Resource Access Manager console at [https://console\.aws\.amazon\.com/ram/](https://console.aws.amazon.com/ram/)\.

1. On the navigation pane, choose **Shared with me**, **Resource shares**\.

1. Select the resource share\.

1. Choose **Accept resource share**\.

1. To view the shared transit gateway, open the **Transit Gateways** page in the Amazon VPC console\.

## Accept a shared attachment<a name="tgw-accept-shared-attachment"></a>

If you didn't enable the **Auto accept shared attachments** functionality when you created your transit gateway, you must manually accept cross\-account \(shared\) attachments\.

**To manually accept a shared attachment**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. On the navigation pane, choose **Transit Gateway Attachments**\.

1. Select the transit gateway attachment that's pending acceptance\.

1. Choose **Actions**, **Accept**\.

**To accept a shared attachment using the AWS CLI**  
Use the [accept\-transit\-gateway\-vpc\-attachment](https://docs.aws.amazon.com/cli/latest/reference/ec2/accept-transit-gateway-vpc-attachment.html) command\.

## Delete a transit gateway<a name="delete-tgw"></a>

You can't delete a transit gateway with existing attachments\. You need to delete all attachments before you can delete a transit gateway\.

**To delete a transit gateway using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. Choose the transit gateway to delete\.

1. Choose **Actions**, **Delete**, then choose **Delete** to confirm the deletion\.

**To delete a transit gateway using the AWS CLI**  
Use the [delete\-transit\-gateway](https://docs.aws.amazon.com/cli/latest/reference/ec2/delete-transit-gateway.html) command\.