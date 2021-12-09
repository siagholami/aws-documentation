# Ingesting an Asset<a name="asset-create"></a>

To ingest source content, create an asset in AWS Elemental MediaPackage\. When MediaPackage ingests content, it creates a unique playback URL for every packaging configuration that's associated with the asset\.

**Important**  
To ingest an asset, MediaPackage must have permissions to access the Amazon S3 bucket where the source content is stored\. To create a role that gives MediaPackage the right permissions, see [Allowing AWS Elemental MediaPackage to Access Other AWS Services](setting-up-create-trust-rel.md)\.

To create an asset, you can use the AWS Elemental MediaPackage console, the AWS CLI, or the MediaPackage API\. For information about creating a packaging configuration with the AWS CLI or MediaPackage API, see [Assets](https://docs.aws.amazon.com/mediapackage-vod/latest/apireference/assets.html) in the *AWS Elemental MediaPackage VOD API Reference*\.

When you're creating an asset, don't put sensitive identifying information like customer account numbers into free\-form fields, such as the **ID** field\. This applies when you're using the console, REST API, AWS CLI, or AWS SDKs\. Any data that you enter into MediaPackage might get picked up for inclusion in diagnostic logs or Amazon CloudWatch Events\.

**To ingest an asset \(console\)**

1. Open the MediaPackage console at [https://console\.aws\.amazon\.com/mediapackage/](https://console.aws.amazon.com/mediapackage/)\.

1. In the navigation pane, under **Video on demand**, choose **Assets**\.

1. On the **Assets** page, choose **Ingest asset**\.

1. On the **Ingest asset** page, complete the fields as described in the following topics:
   + [Asset Access Fields](asset-create-access.md)
   + [Asset Details Fields](asset-create-details.md)
   + [Packaging Settings Field](asset-create-pkg.md)

1. Choose **Ingest assets**\.

If you exceed the quotas for your account when you're creating a packaging configuration, you get an error\. If you get an error similar to Too many requests, please try again\. Resource limit exceeded, either you have exceeded the API request quotas, or you have already reached the maximum number of packaging groups allowed on your account\. If this is your first group, or if you think you mistakenly received this error, use the Service Quotas console to [request quota increases](https://console.aws.amazon.com/servicequotas/home?region=us-east-1#!/services/mediapackage/quotas)\. For more information about quotas in MediaPackage, see [Quotas in AWS Elemental MediaPackage](limits.md)\.