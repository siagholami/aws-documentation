# Viewing Channel Details<a name="channels-view"></a>

View all channels that are configured in AWS Elemental MediaPackage, or view the details of a specific channel, including the endpoints that are associated with it\.

You can use the AWS Elemental MediaPackage console, the AWS CLI, or the MediaPackage API to view channel details\. For information about viewing details about a channel through the AWS CLI or MediaPackage API, see the [AWS Elemental MediaPackage API Reference](https://docs.aws.amazon.com/mediapackage/latest/apireference/)\.

**To view channels \(console\)**

1. Open the MediaPackage console at [https://console\.aws\.amazon\.com/mediapackage/](https://console.aws.amazon.com/mediapackage/)\.

1. If the **Channels** page doesn't appear, on the AWS Elemental MediaPackage home page, choose **Skip and go to console**\.

   All existing channels are displayed on the console\.

1. \(Optional\) To adjust your viewing preferences \(such as page size and properties that are displayed\), choose **Preferences**\. 

1. To view more information about a specific channel, choose the name of the channel that you want to view\.

   AWS Elemental MediaPackage displays important information such as the values for **Input URL** and the WebDAV **Username** and **Password** for each input URL\. Provide this information for the upstream encoder stream destination settings\. If you're using input redundancy, provide the information for both input URLs\. If you're sending only one stream to the channel, you can provide the information for either input URL\. For information about how input redundancy works, see [Live Input Redundancy AWS Elemental MediaPackage Processing Flow](what-is-flow-ir.md)\.
**Note**  
All channels have two input URLs\. For channels that existed before input redundancy, AWS Elemental MediaPackage created two new input URLs\. You can use either the old or new URLs for inputs to the channel\.

   If you created an Amazon CloudFront distribution from the AWS Elemental MediaPackage console, you will also see the high\-level distribution information \(such as status and ID\) from the channel\. When you add an endpoint in MediaPackage, an origin is also added to the distribution, and you will see the CloudFront CDN URL from the channel's details page as well\.