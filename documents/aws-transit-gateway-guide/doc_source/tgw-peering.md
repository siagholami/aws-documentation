# Transit gateway peering attachments<a name="tgw-peering"></a>

You can peer two transit gateways and route traffic between them, which includes IPv4 and IPv6 traffic\. To do this, create a peering attachment on your transit gateway, and specify a transit gateway in another AWS Region\. The peer transit gateway can be in your account or a different AWS account\. 

After you create a peering attachment request, the owner of the peer transit gateway \(also referred to as the *accepter transit gateway*\) must accept the request\. To route traffic between the transit gateways, add a static route to the transit gateway route table that points to the transit gateway peering attachment\.

We recommend using unique ASNs for the peered transit gateways to take advantage of future route propagation capabilities\.

Transit gateway cross\-region peering does not support resolving public IPv4 DNS host names to private IPv4 addresses across VPCs on either side of the transit gateway peering attachment\.

Transit gateway peering uses the same network infrastructure as VPC peering and is therefore encrypted\. For more information about VPC encryption, [Encryption in transit ](https://docs.aws.amazon.com/vpc/latest/userguide/data-protection.html#encryption-transit) in the *Amazon VPC User Guide\.*

For information about what Regions support transit gateway peering attachments, see [AWS Transit Gateways FAQs](https://aws.amazon.com/transit-gateway/faqs/)\.

## Create a peering attachment<a name="tgw-peering-create"></a>

Before you begin, ensure that you have the ID of the transit gateway that you want to attach\. If the transit gateway is in another AWS account, ensure that you have the AWS account ID of the owner of the transit gateway\.

After you create the peering attachment, the owner of the accepter transit gateway must accept the attachment request\.

**To create a peering attachment using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. On the navigation pane, choose **Transit Gateway Attachments**\.

1. Choose **Create Transit Gateway Attachment**\.

1. For **Transit Gateway ID**, choose the transit gateway for the attachment\. You can choose a transit gateway that you own or a transit gateway that was shared with you\.

1. For **Attachment type**, choose **Peering Connection**\.

1. Optionally enter a name tag for the attachment\.

1. For **Account**, do one of the following:
   + If the transit gateway is in your account, choose **My account**\.
   + If the transit gateway is in different AWS account, choose **Other account**\. For **Account ID**, enter the AWS account ID\.

1. For **Region**, choose the Region that the transit gateway is located in\.

1. For **Transit gateway ID \(accepter\)**, enter the ID of the transit gateway that you want to attach\.

1. Choose **Create attachment**\.

**To create a peering attachment using the AWS CLI**  
Use the [create\-transit\-gateway\-peering\-attachment](https://docs.aws.amazon.com/cli/latest/reference/ec2/create-transit-gateway-peering-attachment.html) command\.

## Accept or reject a peering attachment request<a name="tgw-peering-accept-reject"></a>

To activate the peering attachment, the owner of the accepter transit gateway must accept the peering attachment request\. This is required even if both transit gateways are in the same account\. The peering attachment must be in the `pendingAcceptance` state\. Accept the peering attachment request from the Region that the accepter transit gateway is located in\.

Alternatively, you can reject any peering connection request that you've received that's in the `pendingAcceptance` state\. You must reject the request from the Region that the accepter transit gateway is located in\.

**To accept a peering attachment request using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. On the navigation pane, choose **Transit Gateway Attachments**\.

1. Select the transit gateway peering attachment that's pending acceptance\.

1. Choose **Actions**, **Accept**\.

1. Add the static route to the transit gateway route table\. For more information, see [Create a static route](tgw-route-tables.md#tgw-create-static-route)\.

**To reject a peering attachment request using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. On the navigation pane, choose **Transit Gateway Attachments**\.

1. Select the transit gateway peering attachment that's pending acceptance\.

1. Choose **Actions**, **Reject**\.

**To accept or reject a peering attachment using the AWS CLI**  
Use the [accept\-transit\-gateway\-peering\-attachment](https://docs.aws.amazon.com/cli/latest/reference/ec2/accept-transit-gateway-peering-attachment.html) and [reject\-transit\-gateway\-peering\-attachment](https://docs.aws.amazon.com/cli/latest/reference/ec2/reject-transit-gateway-peering-attachment.html) commands\.

## Add a route to the transit gateway route table<a name="tgw-peering-add-route"></a>

To route traffic between the peered transit gateways, you must add a static route to the transit gateway route table that points to the transit gateway peering attachment\. The owner of the accepter transit gateway must also add a static route to their transit gateway's route table\.

**To create a static route using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. On the navigation pane, choose **Transit Gateway Route Tables**\.

1. Select the route table for which to create a route\.

1. Choose **Actions**, **Create route**\.

1. On the **Create route** page, enter the CIDR block for which to create the route\. For example, specify the CIDR block of a VPC that's attached to the peer transit gateway\.

1. Choose the peering attachment for the route\.

1. Choose **Create route**\.

**To create a static route using the AWS CLI**  
Use the [create\-transit\-gateway\-route](https://docs.aws.amazon.com/cli/latest/reference/ec2/create-transit-gateway-route.html) command\.

After you create the route, associate the transit gateway route table with the transit gateway peering attachment\. For more information, see [Associate a transit gateway route table](tgw-route-tables.md#associate-tgw-route-table)\.

## View your transit gateway peering connection attachments<a name="tgw-peering-view-attachments"></a>

You can view your transit gateway peering attachments and information about them\.

**To view your peering attachments using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. On the navigation pane, choose **Transit Gateway Attachments**\.

1. Choose the search bar, select **Resource type** from the menu, and then select **peering**\.

1. The peering attachments are displayed\. Choose an attachment to view its details\.

**To view your transit gateway peering attachments using the AWS CLI**  
Use the [describe\-transit\-gateway\-peering\-attachments](https://docs.aws.amazon.com/cli/latest/reference/ec2/describe-transit-gateway-peering-attachments.html) command\.

## Delete a peering attachment<a name="tgw-peering-delete"></a>

You can delete a transit gateway peering attachment\. The owner of either of the transit gateways can delete the attachment\.

**To delete a peering attachment using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. On the navigation pane, choose **Transit Gateway Attachments**\.

1. Select the transit gateway peering attachment\.

1. Choose **Actions**, **Delete**\.

1. When prompted for confirmation, choose **Delete**\.

**To delete a peering attachment using the AWS CLI**  
Use the [delete\-transit\-gateway\-peering\-attachment](https://docs.aws.amazon.com/cli/latest/reference/ec2/delete-transit-gateway-peering-attachment.html) command\.