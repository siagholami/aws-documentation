# Working with multicast<a name="working-with-multicast"></a>

You can configure multicast on transit gateways using the Amazon VPC console or the AWS CLI\.

**Topics**
+ [Create a transit gateway multicast domain](#create-tgw-domain)
+ [Associate VPC attachments and subnets with a transit gateway multicast domain](#associate-attachment-to-domain)
+ [Register sources with a multicast group](#add-source-multicast-group)
+ [Register members with a multicast group](#add-members-multicast-group)
+ [Deregister sources from a multicast group](#remove-source-multicast-group)
+ [Deregister members from a multicast group](#remove-members-multicast-group)
+ [Disassociate subnets from a transit gateway multicast domain](#remove-subnet-association)
+ [View your multicast groups](#view-multicast-group)
+ [View your transit gateway multicast domain associations](#view-tgw-domain-association)
+ [Add or remove tags for a transit gateway multicast domain](#tgw-domain-tagging)
+ [Delete a transit gateway multicast domain](#delete-tgw-domain)

## Create a transit gateway multicast domain<a name="create-tgw-domain"></a>

To begin using multicast on a transit gateway, create a transit gateway multicast domain\.

Before you create a multicast domain, create a new transit gateway that has multicast enabled\. For more information, see [Create a transit gateway](tgw-transit-gateways.md#create-tgw)\.

**To create a transit gateway multicast domain using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. On the navigation pane, choose **Transit Gateway Multicast**\.

1. Choose **Create Transit Gateway Multicast domain**\.

1. \(Optional\) For **Name tag**, enter a name to identify the domain\.

1. For **Transit Gateway ID**, select the transit gateway that processes the multicast traffic\.

1. Choose **Create Transit Gateway Multicast Domain**\.

**To create a transit gateway multicast domain using the AWS CLI**  
Use the [create\-transit\-gateway\-multicast\-domain](https://docs.aws.amazon.com/cli/latest/reference/ec2/create-transit-gateway-multicast-domain.html) command\.

## Associate VPC attachments and subnets with a transit gateway multicast domain<a name="associate-attachment-to-domain"></a>

Use the following procedure to associate a VPC attachment with a multicast domain\. When you create an association, you can then select the subnets to include in the multicast domain\. 

Before you begin, you must create a VPC attachment on your transit gateway\. For more information, see [Transit gateway attachments to a VPC](tgw-vpc-attachments.md)\.

**To associate VPC attachments with a transit gateway multicast domain using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. On the navigation pane, choose **Transit Gateway Multicast**\.

1. Select the transit gateway multicast domain, and then choose **Actions**, **Create association**\.

1. For **Transit Gateway ID**, select the transit gateway attachment\.

1. For **Choose subnets to associate**, select the subnets to include in the domain\.

1. Choose **Create association**\.

**To associate VPC attachments with a transit gateway multicast domain using the AWS CLI**  
Use the [associate\-transit\-gateway\-multicast\-domain](https://docs.aws.amazon.com/cli/latest/reference/ec2/associate-transit-gateway-multicast-domain.html) command\.

## Register sources with a multicast group<a name="add-source-multicast-group"></a>

Use the following procedure to register sources with a multicast group\. The source is the network interface that sends multicast traffic\.

You need the following information before you add a source:
+ The ID of the transit gateway multicast domain
+ The ID of the source network interface
+ The multicast group IP address

**To register sources using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. On the navigation pane, choose **Transit Gateway Multicast**\.

1. Select the transit gateway multicast domain, and then choose **Actions**, **Add group sources**\.

1. For **Group IP address**, enter either the IPv4 CIDR block or IPv6 CIDR block to assign to the multicast domain\.

1. Under **Choose network interfaces**, select the multicast senders' network interfaces\.

1. Choose **Add sources**\.

**To register sources using the AWS CLI**  
Use the [register\-transit\-gateway\-multicast\-group\-sources](https://docs.aws.amazon.com/cli/latest/reference/ec2/register-transit-gateway-multicast-group-sources.html) command\.

## Register members with a multicast group<a name="add-members-multicast-group"></a>

Use the following procedure to register group members with a multicast group\. The members are the network interfaces that receive multicast traffic\.

You need the following information before you add members:
+ The ID of the transit gateway multicast domain
+ The IDs of the group members' network interfaces
+ The multicast group IP address

**To register members using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. On the navigation pane, choose **Transit Gateway Multicast**\.

1. Select the transit gateway multicast domain, and then choose **Actions**, **Add group members**\.

1. For **Group IP address**, enter either the IPv4 CIDR block or IPv6 CIDR block to assign to the multicast domain\.

1. Under **Choose network interfaces**, select the multicast receivers' network interfaces\.

1. Choose **Add members**\.

**To register members using the AWS CLI**  
Use the [register\-transit\-gateway\-multicast\-group\-sources](https://docs.aws.amazon.com/cli/latest/reference/ec2/register-transit-gateway-multicast-group-sources.html) command\.

## Deregister sources from a multicast group<a name="remove-source-multicast-group"></a>

Use the following procedure to remove a source from a multicast group\.

**To remove a source using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. On the navigation pane, choose **Transit Gateway Multicast**\.

1. Select the transit gateway multicast domain\.

1. Choose the **Groups** tab\.

1. Select the sources, and then choose **Remove source**\.

**To remove a source using the AWS CLI**  
Use the [deregister\-transit\-gateway\-multicast\-group\-sources](https://docs.aws.amazon.com/cli/latest/reference/ec2/deregister-transit-gateway-multicast-group-sources.html) command\.

## Deregister members from a multicast group<a name="remove-members-multicast-group"></a>

Use the following procedure to deregister members from a multicast group\. 

**To deregister members using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. On the navigation pane, choose **Transit Gateway Multicast**\.

1. Select the transit gateway multicast domain\.

1. Choose the **Groups** tab\.

1. Select the members, and then choose **Remove member**\.

**To deregister members using the AWS CLI**  
Use the [deregister\-transit\-gateway\-multicast\-group\-members](https://docs.aws.amazon.com/cli/latest/reference/ec2/deregister-transit-gateway-multicast-group-members.html) command\.

## Disassociate subnets from a transit gateway multicast domain<a name="remove-subnet-association"></a>

Use the following procedure to disassociate subnets from a transit gateway multicast domain\.

**To disassociate subnets using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. On the navigation pane, choose **Transit Gateway Multicast**\.

1. Select the transit gateway multicast domain\.

1. Choose the **Associations** tab\.

1. Select the subnet, and then choose **Remove association**\.

**To disassociate subnets using the AWS CLI**  
Use the [disassociate\-transit\-gateway\-multicast\-domain](https://docs.aws.amazon.com/cli/latest/reference/ec2/API_DisassociateTransitGatewayMulticastDomain.html) command\.

## View your multicast groups<a name="view-multicast-group"></a>

Use the following procedure to view your multicast groups\.

**To view multicast groups using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. On the navigation pane, choose **Transit Gateway Multicast**\.

1. Select the transit gateway multicast domain\.

1. Choose the **Groups** tab\.

**To view multicast groups using the AWS CLI**  
Use the [view multicast groups ](https://docs.aws.amazon.com/cli/latest/reference/ec2/view multicast groups .html) command\.

## View your transit gateway multicast domain associations<a name="view-tgw-domain-association"></a>

You can view your transit gateway multicast domains to verify that they are available, and that they contain the appropriate subnets and attachments\.

**To view a transit gateway multicast domain using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. On the navigation pane, choose **Transit Gateway Multicast**\.

1. Select the transit gateway multicast domain\.

**To view a transit gateway multicast domain using the AWS CLI**  
Use the [describe\-transit\-gateway\-multicast\-domains](https://docs.aws.amazon.com/cli/latest/reference/ec2/describe-transit-gateway-multicast-domains.html) command\.

## Add or remove tags for a transit gateway multicast domain<a name="tgw-domain-tagging"></a>

Add tags to your resources to help organize and identify them, such as by purpose, owner, or environment\. You can add multiple tags to each transit gateway multicast domain\. Tag keys must be unique for each transit gateway multicast domain\. If you add a tag with a key that is already associated with the transit gateway multicast domain, it updates the value of that tag\. For more information, see [Tagging your Amazon EC2 Resources](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/Using_Tags.html)\.

**Add tags to a transit gateway using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. On the navigation pane, choose **Transit Gateways Multicast**\.

1. Choose the transit gateway multicast domain for which to add or edit tags\.

1. Choose the **Tags** tab in the lower part of the page\.

1. Choose **Add/Edit Tags**\.

1. Choose **Create Tag**\.

1. Enter a **Key** and **Value** for the tag\.

1. Choose **Save**\.

## Delete a transit gateway multicast domain<a name="delete-tgw-domain"></a>

Use the following procedure to delete a transit gateway multicast domain\.

**To delete a transit gateway multicast domain using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. On the navigation pane, choose **Transit Gateway Multicast**\.

1. Select the transit gateway multicast domain, and then choose **Actions**, **Delete multicast domain**\.

1. Choose **Delete**\.

**To delete a transit gateway multicast domain using the AWS CLI**  
Use the [delete\-transit\-gateway\-multicast\-domain](https://docs.aws.amazon.com/cli/latest/reference/ec2/delete-transit-gateway-multicast-domain.html) command\.