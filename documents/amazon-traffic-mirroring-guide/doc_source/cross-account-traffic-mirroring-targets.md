# Cross\-Account Traffic Mirror Targets<a name="cross-account-traffic-mirroring-targets"></a>

A traffic mirror target can be owned by an AWS account that is different from the traffic mirror source\.

Before you can use a cross\-account traffic mirror target, the traffic mirror target owner shares the target with you by using the AWS Resource Access Manager\. When you are in different AWS Organizations from the owner, after the owner shares the traffic mirror target, you accept the share request\. After you accept the share request, you can use the traffic mirror target in a traffic mirror session\. You can only create a traffic mirror session if you are the owner of the source network interface or its subnet\. 

The traffic mirror target is visible to shared accounts in their `DescribeTrafficMirrorTarget` API calls\. Only the traffic mirror target owner can modify or delete the traffic mirror target\.

Traffic mirror sessions that are created in a different account than the traffic mirror target are visible in `DescribeTrafficMirrorSession` API calls that are made by the traffic mirror target owner\.

## Sharing a Traffic Mirror Target<a name="tm-sharing"></a>

You can use AWS Resource Access Manager \(RAM\) to share a traffic mirror target across accounts\. Use the following procedure to share a traffic mirror target that you own\.

You must create a traffic mirror target before you share it\. For more information, see [Create a Traffic Mirror Target](traffic-mirroring-target.md#create-traffic-mirroring-target)\.

**To share a traffic mirror target**

1. Open the AWS Resource Access Manager console at [https://console\.aws\.amazon\.com/ram/](https://console.aws.amazon.com/ram/)\.

1. Choose **Create a resource share**\.

1. Under **Description**, for **Name**, enter a descriptive name for the resource share\.

1. For **Select resource type**, choose **Traffic Mirror Targets**\. Select the traffic mirror target\.

1. For **Principals**, add principals to the resource share\. For each AWS account, OU, or organization, specify its ID and choose **Add**\.

   For **Allow external accounts**, choose whether to allow sharing for this resource with AWS accounts that are external to your organization\.

1. \(Optional\) Under **Tags**, enter a tag key and tag value pair for each tag\. These tags are applied to the resource share but not to the traffic mirror target\.

1. Choose **Create resource share**\.

## Accepting a Resource Share<a name="tm-share-accept"></a>

 If you are in different AWS Organizations from the share owner, you must accept the resource share before you can access the shared resources\.

**To accept a resource share**

1. Open the AWS Resource Access Manager console at [https://console\.aws\.amazon\.com/ram/](https://console.aws.amazon.com/ram/)\.

1. On the navigation pane, choose **Shared with me**, **Resource shares**\.

1. Select the resource share\.

1. Choose **Accept resource share**\.

1. To view the shared traffic mirror target, open the **Traffic Mirror Targets** page in the Amazon VPC console\.

## Deleting a Resource Share<a name="tm-delete-share"></a>

You can delete a resource share at any time\. When you delete a resource share, all principals that are associated with the resource share lose access to the shared resources\. Deleting a resource share does not delete the shared resources\. 

When you delete a shared traffic mirror target that is in use, the traffic mirror session becomes inactive\.

**To delete a resource share**

1. Open the AWS Resource Access Manager console at [https://console\.aws\.amazon\.com/ram/](https://console.aws.amazon.com/ram/)\.

1. On the navigation pane, choose **Shared by me**, **Resource shares**\.

1. Select the resource share\.

    Be sure to select the correct resource share\. You cannot recover a resource share after you delete it\.

1. Choose **Delete**\.

1. In the **Delete confirmation** dialog box, enter **delete**, and then choose **Delete**\.