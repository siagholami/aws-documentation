# Accessing Resources Shared With You<a name="working-with-shared"></a>

AWS RAM enables you to view the resource shares to which you have been added, the shared resources that you can access, and the accounts that have shared resources with you\. You can also leave a resource share when you no longer require access to the shared resources\.

**Topics**
+ [Accepting and Rejecting Invitations](#working-with-shared-invitation)
+ [Viewing Resource Shares](#working-with-shared-view-rs)
+ [Viewing Shared Resources](#working-with-shared-viewing-sr)
+ [Viewing Principals Sharing With You](#working-with-shared-view-accounts)
+ [Leaving a Resource Share](#working-with-shared-leave)

## Accepting and Rejecting Invitations<a name="working-with-shared-invitation"></a>

To access shared resources, a principal must add you to a resource share\.

If you were added to the resource share by an account in your organization in AWS Organizations, and sharing within your organization is enabled, you are automatically get access to the shared resources\.

If you were added to a resource share by one of the following, you receive an invitation to join the resource share:
+ An account outside of your organization in AWS Organizations
+ An account inside your organization, if sharing with AWS Organizations is not enabled

If you receive an invitation to join a resource share, you must accept it to access to the shared resources\. If you decline the invitation, you cannot access the shared resources\.

You have seven days to accept an invitation to join a resource share\. If you do not accept the invitation within seven days, it is automatically declined\.

**To respond to invitations**

1. Open the AWS RAM console at [https://console\.aws\.amazon\.com/ram](https://console.aws.amazon.com/ram/)\.

1. In the navigation pane, choose **Shared with me**, **Resource shares**\.

1. Review the list of resource shares to which you have been added\.

   The **Status** column indicates your current participation status for the resource share\. The `Pending` status indicates that you have been added to a resource share, but you have not yet accepted or rejected the invitation\.

1. To respond to the resource share invitation, select the resource share ID and choose **Accept resource share** to accept the invitation, or **Reject resource share** to decline the invitation\. If you reject the invitation, you do not get access to the resources\. If you accept the invitation, you gain access to the resources\.

**To respond to an invitation \(AWS CLI\)**  
Use the following commands:
+ [accept\-resource\-share\-invitation](https://docs.aws.amazon.com/cli/latest/reference/ram/accept-resource-shareinvitation.html)
+ [reject\-resource\-share\-invitation](https://docs.aws.amazon.com/cli/latest/reference/ram/reject-resource-shareinvitation.html)

## Viewing Resource Shares<a name="working-with-shared-view-rs"></a>

You can view the resource shares to which you have been added\. You can see which principals are sharing resources with you and which resources they are sharing\.

**To view the resource shares using the console**

1. Open the AWS RAM console at [https://console\.aws\.amazon\.com/ram](https://console.aws.amazon.com/ram/)\.

1. In the navigation pane, choose **Shared with me**, **Resource shares**\.

1. Apply a filter to find specific resource shares\. You can apply multiple filters to narrow your search\.

1. The following information is available:
   + **Name**—The name of the resource share\.
   + **ID**—The ID of the resource share\. Choose the ID to view the resource share\.
   + **Owner**—The ID of the AWS account that created the resource share\.
   + **Status**—The current status of the resource share\. Possible values include:
     + **Active**—The resource share is active and available for use\.
     + **Deleted**—The resource share has been deleted and is no longer available for use\.
     + **Pending**—An invitation to join the resource share is pending\.

**To view the resource shares using the AWS CLI**  
Use the [get\-resource\-shares](https://docs.aws.amazon.com/cli/latest/reference/ram/get-resource-shares.html) command\.

## Viewing Shared Resources<a name="working-with-shared-viewing-sr"></a>

You can view the shared resources that you can access\. You can see which principals are sharing resources and in which resource shares they are included\.

**To view shared resources using the console**

1. Open the AWS RAM console at [https://console\.aws\.amazon\.com/ram](https://console.aws.amazon.com/ram/)\.

1. In the navigation pane, choose **Shared with me**, **Shared resources**\.

1. Apply a filter to find specific shared resources\. You can apply multiple filters to narrow your search\.

1. The following information is available:
   + **Resource ID**—The ID of the resource\. Choose the ID of the resource to view it in its service console\.
   + **Resource type**—The type of resource\.
   + **Last share date**—The date on which the resource was shared with you\.
   + **Resource shares**—The number of resource shares in which the resource is included\. Choose the value to view the resource shares\.
   + **Owner ID**—The ID of the principal who owns the resource\.

**To view shared resources using the AWS CLI**  
Use the [list\-resources](https://docs.aws.amazon.com/cli/latest/reference/ram/list-resources.html) command\.

## Viewing Principals Sharing With You<a name="working-with-shared-view-accounts"></a>

You can view a list of all the principals that are sharing resources with you\. You can see which resources and resource shares they have shared with you\.

**To view the principals that are sharing resources with you using the console**

1. Open the AWS RAM console at [https://console\.aws\.amazon\.com/ram](https://console.aws.amazon.com/ram/)\.

1. In the navigation pane, choose **Shared with me**, **Principals**\.

1. Apply a filter to find specific principals\. You can apply multiple filters to narrow your search\.

1. The following information is available:
   + **Principal ID**—The ID of the principal who is sharing with you\.
   + **Resource shares**—The number of resource shares to which the principal has added you\. Choose the value to view the resource shares\.
   + **Resources**—The number of resources the principal is sharing with you\. Choose the value to view the resources\.

**To view the principals that are sharing resources with you using the AWS CLI**  
Use the [list\-principals](https://docs.aws.amazon.com/cli/latest/reference/ram/list-principals.html) command\.

## Leaving a Resource Share<a name="working-with-shared-leave"></a>

If you no longer need access to resources shared with you, you can leave a resource share at any time\. When you leave a resource share, you lose access to the shared resources\.

You cannot leave a resource share if you were added to it by an account inside your organization and sharing with AWS Organizations is enabled\.

**To leave a resource share using the console**

1. Open the AWS RAM console at [https://console\.aws\.amazon\.com/ram](https://console.aws.amazon.com/ram/)\.

1. In the navigation pane, choose **Shared with me**, **Resource shares**\.

1. Select the resource share\.

1. Choose **Leave resource share**, type the confirmation text, and choose **Leave resource share**\.

**To leave a resource share using the AWS CLI**  
Use the [disassociate\-resource\-share](https://docs.aws.amazon.com/cli/latest/reference/ram/disassociate-resource-share.html) command\.