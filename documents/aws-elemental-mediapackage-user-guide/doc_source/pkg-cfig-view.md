# Viewing Packaging Configuration Details<a name="pkg-cfig-view"></a>

To ensure that the content is available in all necessary stream formats, view all packaging configurations that are associated with a specific packaging group or with an asset\. 

To view packaging configurations, you can use the AWS Elemental MediaPackage console, the AWS CLI, or the MediaPackage API\. For information about viewing a packaging configuration with the AWS CLI or MediaPackage API, see [Packaging\_configurations id](https://docs.aws.amazon.com/mediapackage-vod/latest/apireference/packaging_configurations-id.html) in the *AWS Elemental MediaPackage VOD API Reference*\.

**To view packaging configurations in a packaging group \(console\)**

1. Open the MediaPackage console at [https://console\.aws\.amazon\.com/mediapackage/](https://console.aws.amazon.com/mediapackage/)\.

1. In the navigation pane, under **Video on demand**, choose **Packaging groups**\.

1. On the **Packaging groups** page, choose the group that contains the configurations that you want to view\. 

   The **Packaging configurations** section displays all of the configurations that are in this group\.

1. To view the details of a specific packaging configuration, choose the **Id** of that configuration\.

AWS Elemental MediaPackage displays summary information, such as the assets associated with this packaging configuration\.

**To view all packaging configurations associated with an asset \(console\)**

1. Open the MediaPackage console at [https://console\.aws\.amazon\.com/mediapackage/](https://console.aws.amazon.com/mediapackage/)\.

1. In the navigation pane, under **Video on demand**, choose **Assets**\.

1. On the **Assets** page, choose the asset that you want to audit\. 

   The **Playback details** section displays all of the configurations that are associated with this asset\.