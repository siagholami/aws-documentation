# Transit gateway attachments to a VPC<a name="tgw-vpc-attachments"></a>

When you attach a VPC to a transit gateway, you must specify one subnet from each Availability Zone to be used by the transit gateway to route traffic\. Specifying one subnet from an Availability Zone enables traffic to reach resources in every subnet in that Availability Zone\.

**Limits**  
When you attach a VPC to a transit gateway, resources in Availability Zones where there is no transit gateway attachment cannot reach the transit gateway\. If there is a route to the transit gateway in a subnet route table, traffic is only forwarded to the transit gateway when the transit gateway has an attachment in a subnet in the same Availability Zone\. 

The resources in a VPC attached to a transit gateway cannot access the security groups of a different VPC that is also attached to the same transit gateway\.

A transit gateway does not support DNS resolution for custom DNS names of attached VPCs set up using private hosted zones in Amazon Route 53\. To configure the name resolution for private hosted zones for all VPCs attached to a transit gateway, see [Centralized DNS management of hybrid cloud with Amazon Route 53 and AWS Transit Gateway](https://aws.amazon.com/blogs/networking-and-content-delivery/centralized-dns-management-of-hybrid-cloud-with-amazon-route-53-and-aws-transit-gateway/)\.

You cannot create an attachment for a VPC subnet that resides in a AWS Local Zone\.

## Create a transit gateway attachment to a VPC<a name="create-vpc-attachment"></a>

**To create a VPC attachment using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. On the navigation pane, choose **Transit Gateway Attachments**\.

1. Choose **Create Transit Gateway Attachment**\.

1. For **Transit Gateway ID**, choose the transit gateway for the attachment\. You can choose a transit gateway that you own or a transit gateway that was shared with you\.

1. For **Attachment type**, choose **VPC**\.

1. Under **VPC Attachment**, optionally type a name for **Attachment name tag**\.

1. Choose whether to enable **DNS Support** and **IPv6 Support**\.

1. For **VPC ID**, choose the VPC to attach to the transit gateway\.

   This VPC must have at least one subnet associated with it\.

1. For **Subnet IDs**, select one subnet for each Availability Zone to be used by the transit gateway to route traffic\. You must select at least one subnet\. You can select only one subnet per Availability Zone\.

1. Choose **Create attachment**\.

**To create a VPC attachment using the AWS CLI**  
Use the [create\-transit\-gateway\-vpc\-attachment](https://docs.aws.amazon.com/cli/latest/reference/ec2/create-transit-gateway-vpc-attachment.html) command\.

## Modify your VPC attachment<a name="modify-vpc-attachment"></a>

**To modify your VPC attachments using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. On the navigation pane, choose **Transit Gateway Attachments**\.

1. Select the VPC attachment, and then choose **Actions**, **Modify**\.

1. To enable DNS support, select **DNS support**\.

1. To add a subnet to the attachment, next to the subnet, select the box\. 

1. Choose **Modify attachment**\. 

**To modify your VPC attachments using the AWS CLI**  
Use the [modify\-transit\-gateway\-vpc\-attachment](https://docs.aws.amazon.com/cli/latest/reference/ec2/modify-transit-gateway-vpc-attachment.html) command\.

## Modify your VPC attachment tags<a name="modify-vpc-attachment-tag"></a>

**To modify your VPC attachment tags using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. On the navigation pane, choose **Transit Gateway Attachments**\.

1. Select the VPC attachment, and then choose **Actions**, **Add/Edit tags**\.

1. \[Add a tag\] Choose **Add tag** and do the following:
   + For **Key**, enter the key name\.
   + For **Value**, enter the key value\.

1. \[Remove a tag\] Next to the tag, choose Delete \("X"\)\.

1. Choose **Modify attachment**\. 

## View your VPC attachments<a name="view-vpc-attachment"></a>

**To view your VPC attachments using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. On the navigation pane, choose **Transit Gateway Attachments**\.

1. Choose the search bar, select **Resource type** from the menu, and then select **VPC**\.

1. The VPC attachments are displayed\. Choose an attachment to view its details\.

**To view your VPC attachments using the AWS CLI**  
Use the [describe\-transit\-gateway\-vpc\-attachments](https://docs.aws.amazon.com/cli/latest/reference/ec2/describe-transit-gateway-vpc-attachments.html) command\.

## Delete a VPC attachment<a name="delete-vpc-attachment"></a>

**To delete a VPC attachment using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. On the navigation pane, choose **Transit Gateway Attachments**\.

1. Select the VPC attachment\.

1. Choose **Actions**, **Delete**\.

1. When prompted for confirmation, choose **Delete**\.

**To delete a VPC attachment using the AWS CLI**  
Use the [delete\-transit\-gateway\-vpc\-attachment](https://docs.aws.amazon.com/cli/latest/reference/ec2/delete-transit-gateway-vpc-attachment.html) command\.