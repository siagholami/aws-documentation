# Sharing Resources Owned by You<a name="working-with-sharing"></a>

AWS RAM enables you to share the resources that you specify with the principals that you specify\. At any time, you can modify resource shares that you have created and delete them when they are no longer needed\.

**Topics**
+ [Creating a Resource Share](#working-with-sharing-create)
+ [Updating a Resource Share](#working-with-sharing-update)
+ [Viewing a Resource Share](#working-with-sharing-view-rs)
+ [Viewing Your Shared Resources](#working-with-sharing-view-sr)
+ [Viewing Principals](#working-with-sharing-view-accounts)
+ [Deleting a Resource Share](#working-with-sharing-delete)
+ [Supported Actions on Shared Resources](#working-with-sharing-view-permissions)

## Creating a Resource Share<a name="working-with-sharing-create"></a>

To share resources that you own, create a resource share, add the resources to share, and specify the principals with whom they are to be shared\.

To create a resource share, follow the directions in [Sharing Your Resources](getting-started-sharing.md)\.

## Updating a Resource Share<a name="working-with-sharing-update"></a>

You can update a resource share at any time\. You can add principals, resources, or tags to a resource share that you created\. You can revoke access to shared resources by removing principals or resources from a resource share\. If you revoke access, principals no longer have access to the shared resources\.

**To update a resource share using the console**

1. Open the AWS RAM console at [https://console\.aws\.amazon\.com/ram](https://console.aws.amazon.com/ram/)\.

1. In the navigation pane, choose **Shared by me**, **Resource shares**\.

1. Select the resource share and choose **Modify**\.

1. \(Optional\) To change the name of the resource share, edit **Name**\.

1. \(Optional\) To add a resource to the resource share, under **Resources**, select the type of resource and select the check box next to the resource\.

1. \(Optional\) To remove a resource, locate the resource in the **Selected resources** panel and choose **X**\.

1. \(Optional\) To add a principal, type the ID of the AWS account OU, or organization and choose **Add**\.

1. \(Optional\) To remove a principal, locate it in the **Selected principals** panel and choose **X**\.

1. \(Optional\) To add a tag to the resource share, under **Tags**, choose **Add tag** and type a tag key and tag value pair\.

1. To remove a tag from the resource share, locate it and choose **Remove tag**\.

1. Choose **Save changes**\.

**To update a resource share using the AWS CLI**

Use the following commands:
+ [associate\-resource\-share](https://docs.aws.amazon.com/cli/latest/reference/ram/associate-resource-share.html)
+ [disassociate\-resource\-share](https://docs.aws.amazon.com/cli/latest/reference/ram/disassociate-resource-share.html)
+ [tag\-resource](https://docs.aws.amazon.com/cli/latest/reference/ram/tag-resource.html)
+ [update\-resource\-share](https://docs.aws.amazon.com/cli/latest/reference/ram/update-resource-share.html)

## Viewing a Resource Share<a name="working-with-sharing-view-rs"></a>

You can view a list of all the resource shares that you have created\. You can see which resources you are sharing and the principals with whom they are shared\.

**To view your resource shares using the console**

1. Open the AWS RAM console at [https://console\.aws\.amazon\.com/ram](https://console.aws.amazon.com/ram/)\.

1. In the navigation pane, choose **Shared by me**, **Resource shares**\. 

1. Apply a filter to find specific resource shares\. You can apply multiple filters to narrow your search\.

1. Choose the resource share to review\. The following information is available:
   + **Summary**—Lists information about the resource share, such as its name, ID, owner, Amazon Resource Name \(ARN\), creation date, and current status\.
   + **Shared resources**—Lists the resources that are included in the resource share\. Choose the ID of a resource to view it in its service console\.
   + **Shared principals**—Lists the principals with whom the resources are shared\.
   + **Tags**—Lists the tag key\-value pairs for the resource share\.

**To view your resource shares using the AWS CLI**  
Use the [get\-resource\-shares](https://docs.aws.amazon.com/cli/latest/reference/ram/get-resource-shares.html) command\.

## Viewing Your Shared Resources<a name="working-with-sharing-view-sr"></a>

You can view the resources that are shared by your account, across all resource shares\. This enables you to determine which resources you are currently sharing, the number of resource shares they are included in, and the number of principals that have access to them\.

**To view the resources that you're sharing using the console**

1. Open the AWS RAM console at [https://console\.aws\.amazon\.com/ram](https://console.aws.amazon.com/ram/)\.

1. In the navigation pane, choose **Shared by me**, **Shared resources**\.

1. For each shared resource, the following information is available:
   + **Resource ID**—The ID of the resource\. Choose the ID of a resource to view it in its service console\.
   + **Resource type**—The type of resource\.
   + **Last share date**—The date on which the resource was last shared\.
   + **Resource shares**—The number of resource shares in which the resource is included\. Choose the value to list the resource shares\.
   + **Principals**—The number of principals with whom the resource is shared\. Choose the value to view the principals\.

**To view the resources that you're sharing using the AWS CLI**  
Use the [list\-resources](https://docs.aws.amazon.com/cli/latest/reference/ram/list-resources.html) command\.

## Viewing the Principals with Whom You're Sharing<a name="working-with-sharing-view-accounts"></a>

You can view the principals with whom you are sharing your resources, across all resource shares\. Viewing the principals with whom you are sharing enables you to determine who has access to your shared resources\.

**To view the principals with whom you're sharing using the console**

1. Open the AWS RAM console at [https://console\.aws\.amazon\.com/ram](https://console.aws.amazon.com/ram/)\.

1. In the navigation pane, choose **Shared by me**, **Principals**\.

1. For each principal, the following information is available:
   + **Principal ID**—The ID of the principal\.
   + **Resource shares**—The number of resource shares you shared with the principal\. Choose the value to view the resource shares\.
   + **Resources**—The number of resources you shared with the principal\. Choose the value to view the shared resources\.

**To view the principals with whom you're sharing using the AWS CLI**  
Use the [list\-principals](https://docs.aws.amazon.com/cli/latest/reference/ram/list-principals.html) command\.

## Deleting a Resource Share<a name="working-with-sharing-delete"></a>

You can delete a resource share at any time\. When you delete a resource share, all principals that were associated with the resource share lose access to the shared resources\. Deleting a resource share does not delete the shared resources\.

The deleted resource share remains visible in the console for a short period after deletion, but its status changes to `Deleted`\.

**To delete a resource share using the console**

1. Open the AWS RAM console at [https://console\.aws\.amazon\.com/ram](https://console.aws.amazon.com/ram/)\.

1. In the navigation pane, choose **Shared by me**, **Resource shares**\.

1. Select the resource share\. Be sure to select the correct resource share\. You can't recover a resource share after you delete it\.

1. Choose **Delete**, type the confirmation message, and choose **Delete**\.

**To delete a resource share using the AWS CLI**  
Use the [delete\-resource\-share](https://docs.aws.amazon.com/cli/latest/reference/ram/delete-resource-share.html) command\.

## Supported Actions on Shared Resources<a name="working-with-sharing-view-permissions"></a>

You can use the AWS CLI to view the actions that principals can perform on shared resources\. For more information, see the [get\-resource\-policies](https://docs.aws.amazon.com/cli/latest/reference/ram/get-resource-policies.html) command\.