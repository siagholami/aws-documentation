# Prefix list references<a name="tgw-prefix-lists"></a>

You can reference a *prefix list* in your transit gateway route table\. A prefix list is a set of one or more CIDR block entries\. You can use a prefix list to simplify the management of the IP addresses that you reference in your resources to route network traffic\. For example, if you frequently specify the same destination CIDRs across multiple transit gateway route tables, you can manage those CIDRs in a single prefix list\.

When you create a prefix list reference in your transit gateway route table, each entry in the prefix list is represented as a route in your transit gateway route table\.

For more information about prefix lists, see [Prefix lists](https://docs.aws.amazon.com/vpc/latest/userguide/managed-prefix-lists.html) in the *Amazon VPC User Guide*\.

## Create a prefix list reference<a name="create-prefix-list-reference"></a>

You can create a reference to a prefix list in your transit gateway route table\.

**To create a prefix list reference using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. In the navigation pane, choose **Transit Gateway Route tables**\.

1. Select the transit gateway route table\.

1. Choose **Actions**, **Create prefix list reference**\.

1. For **Prefix list ID**, choose the ID of the prefix list\.

1. For **Attachment ID**, choose the ID of the attachment to which to route traffic\.

   Alternatively, to drop the traffic that matches the route, choose **Blackhole**\.

1. Choose **Create prefix list reference**\.

**To create a prefix list reference using the AWS CLI**  
Use the [create\-transit\-gateway\-prefix\-list\-reference](https://docs.aws.amazon.com/cli/latest/reference/ec2/create-transit-gateway-prefix-list-reference.html) command\.

## View prefix list references<a name="view-prefix-list-reference"></a>

You can view the prefix list references in your transit gateway route table\. You can also view each entry in the prefix list as an individual route in your transit gateway route table\. The route type for a prefix list route is `propagated`\.

**To view a prefix list reference using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. In the navigation pane, choose **Transit Gateway Route tables**\.

1. Select the transit gateway route table\.

1. In the lower pane, choose **Prefix list references**\. The prefix list references are listed\.

1. Choose **Routes**\. Each prefix list entry is listed as a route in the route table\.

**To view a prefix list reference using the AWS CLI**  
Use the [get\-transit\-gateway\-prefix\-list\-references](https://docs.aws.amazon.com/cli/latest/reference/ec2/get-transit-gateway-prefix-list-references.html) command\.

## Modify a prefix list reference<a name="modify-prefix-list-reference"></a>

You can modify a prefix list reference by changing the attachment that the traffic is routed to, or indicating whether to drop traffic that matches the route\.

You cannot modify the individual routes for a prefix list in the **Routes** tab\. To modify the entries in the prefix list, use the **Managed Prefix Lists** screen\. For more information, see [Modifying a prefix list](https://docs.aws.amazon.com/vpc/latest/userguide/managed-prefix-lists.html#modify-managed-prefix-list) in the *Amazon VPC User Guide*\.

**To modify a prefix list reference using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. In the navigation pane, choose **Transit Gateway Route tables**\.

1. Select the transit gateway route table\.

1. In the lower pane, choose **Prefix list references**\.

1. Choose the prefix list reference, and choose **Modify reference**\.

1. For **Attachment ID**, choose the ID of the attachment to which to route traffic\.

   Alternatively, to drop the traffic that matches the route, choose **Blackhole**\.

1. Choose **Modify prefix list reference**\.

**To modify a prefix list reference using the AWS CLI**  
Use the [modify\-transit\-gateway\-prefix\-list\-reference](https://docs.aws.amazon.com/cli/latest/reference/ec2/modify-transit-gateway-prefix-list-reference.html) command\.

## Delete a prefix list reference<a name="delete-prefix-list-reference"></a>

If you no longer need a prefix list reference, you can delete it from your transit gateway route table\. Deleting the reference does not delete the prefix list\.

**To delete a prefix list reference using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. In the navigation pane, choose **Transit Gateway Route tables**\.

1. Select the transit gateway route table\.

1. Choose the prefix list reference, and choose **Delete reference**\.

1. Choose **Delete reference**\.

**To delete a prefix list reference using the AWS CLI**  
Use the [delete\-transit\-gateway\-prefix\-list\-reference](https://docs.aws.amazon.com/cli/latest/reference/ec2/delete-transit-gateway-prefix-list-reference.html) command\.