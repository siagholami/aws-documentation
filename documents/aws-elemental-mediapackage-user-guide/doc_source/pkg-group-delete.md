# Deleting a Packaging Group<a name="pkg-group-delete"></a>

To stop AWS Elemental MediaPackage from delivering more content from an asset, delete the packaging group\. Before you can delete the packaging group, you must delete the group's packaging configurations and any assets that use the group\.
+ To delete a packaging configuration, see [Deleting a Packaging Configuration](pkg-cfig-delete.md)\.
+ To delete an asset, see [Deleting an Asset](asset-delete.md)\.

To delete a packaging group, you can use the AWS Elemental MediaPackage console, the AWS CLI, or the MediaPackage API\. information about deleting a packaging group with the AWS CLI or MediaPackage API, see [Packaging\_groups id](https://docs.aws.amazon.com/mediapackage-vod/latest/apireference/packaging_groups-id.html) in the *AWS Elemental MediaPackage VOD API Reference*\.

**To delete a packaging group \(console\)**

1. Open the MediaPackage console at [https://console\.aws\.amazon\.com/mediapackage/](https://console.aws.amazon.com/mediapackage/)\.

1. In the navigation pane, under **Video on demand**, choose **Packaging groups**\.

1. On the **Packaging groups** page, choose the group using one the following methods: 
   + Choose the group name
   + Select the check box next to the group **ID**

1. Choose **Delete**\.

1. In the confirmation dialog box, choose **Delete** to finish deleting the packaging group\.