# Creating a Packaging Group<a name="pkg-group-create"></a>

Create a packaging group to hold all of the packaging configurations for an asset\. The packaging group, for example, tells AWS Elemental MediaPackage that an asset is available for output to devices that support Apple HLS and DASH\-ISO\.

To create a packaging group, you can use the AWS Elemental MediaPackage console, the AWS CLI, or the MediaPackage API\. information about creating a packaging group with the AWS CLI or MediaPackage API, see [Packaging\_groups](https://docs.aws.amazon.com/mediapackage-vod/latest/apireference/packaging_groups.html) in the *AWS Elemental MediaPackage VOD API Reference*\.

When you're creating a packaging group, don't put sensitive identifying information like customer account numbers into free\-form fields, such as the **ID** field\. This applies when you're using the console, REST API, AWS CLI, or AWS SDKs\. Any data that you enter into MediaPackage might get picked up for inclusion in diagnostic logs or Amazon CloudWatch Events\.

**To create a packaging group \(console\)**

1. Open the MediaPackage console at [https://console\.aws\.amazon\.com/mediapackage/](https://console.aws.amazon.com/mediapackage/)\.

1. In the navigation pane, under **Video on demand**, choose **Packaging groups**\.

1. On the **Packaging groups** page, choose **Create**\.

1. In the **Creating packaging group** dialog box, do the following:

   1. For **ID**, enter a name that describes the packaging group\. The ID is the primary identifier for the group, and must be unique for your account in this AWS Region\.

   1. Choose **Create**\.

MediaPackage displays the new packaging group's details page\.

If you exceed the quotas for your account when you're creating a packaging group, you get an error\. If you get an error similar to Too many requests, please try again\. Resource limit exceeded, either you have exceeded the API request quotas, or you have already reached the maximum number of packaging groups allowed on your account\.If this is your first group, or if you think you mistakenly received this error, use the Service Quotas console to [request quota increases](https://console.aws.amazon.com/servicequotas/home?region=us-east-1#!/services/mediapackage/quotas)\. For more information about quotas in MediaPackage, see [Quotas in AWS Elemental MediaPackage](limits.md)\.