# Step 4: \(Optional\) Output VOD Content<a name="gs-output-vod"></a>

To use MediaPackage to make the live\-to\-VOD asset available for playback, create a packaging group, packaging configuration, and asset resource\. The asset ingests the live\-to\-VOD asset from the Amazon S3 bucket\. A packaging group holds one or more packaging configurations, which define the output format and settings\. 

## Create a Packaging Group<a name="gs-create-grp-ltov"></a>

A packaging group holds one or more packaging configurations\. The packaging configurations enable you to define what kind of VOD outputs you want\. To apply these output definitions, associate a packaging group to multiple assets\.

**Example**  
 You have 15 pieces of source content\. You want to serve them all as DASH, HLS, and encrypted HLS outputs\. To do this, you define one packaging group with DASH, HLS, and encrypted HLS packaging configurations\. You then associate that group to the asset resources that represent these pieces of content\. You don't have to create new configurations for each asset\.

AWS Elemental MediaPackage does not require that you supply any customer data\. There are no fields in packaging groups where there is an expectation that you will provide customer data\.

**To create a packaging group**

1. On the AWS Elemental MediaPackage **Packaging groups** page, choose **Create**\.

1. For **ID**, enter a name that describes the group, such as **gamehighlights** \. The ID is the primary identifier for the group, and must be unique for your account in this AWS Region\. Supported characters are letters, numbers, underscore \(\_\), and dash \(\-\)\. You can't use spaces in the ID\.

1. Choose **Create**\.

## Create a Packaging Configuration<a name="gs-create-cfig-ltov"></a>

A packaging configuration specifies how the output manifest is configured, such as stream selection limitations and ordering\.

AWS Elemental MediaPackage does not require that you supply any customer data\. There are no fields in packaging configurations where there is an expectation that you will provide customer data\.

**To create a packaging configuration**

1. On the **Packaging groups** page, choose the group that you just created\.

1. On the details page for the packaging group, choose either **Add or remove configuration** or **Add configuration** if there are no existing packaging configurations\.

1. On the **Add packaging configurations** page, choose **Add**, and then choose **New configuration**\.

1. For **ID**, enter a name that describes the configuration, such as **hls\_highlights**\. The ID is the primary identifier for the configuration, and must be unique for your account in this AWS Region\. Supported characters are letters, numbers, underscore \(\_\), and dash \(\-\)\. You can't use spaces in the ID\.

1. Keep the defaults for the remaining fields, and then choose **Save**\.

## Create an Asset<a name="gs-create-asset-ltov"></a>

An asset resource is how MediaPackage ingests, packages, and serves VOD content\. The asset is associated with one or more packaging configurations\. Downstream devices send playback requests to specific packaging configurations on the asset\.

AWS Elemental MediaPackage does not require that you supply any customer data\. There are no fields in assets where there is an expectation that you will provide customer data\.

**To create an asset and ingest source content**

1. From your Amazon S3 buckets, determine what file you're using as source content\. Make note of the following:
   + The name of the Amazon S3 bucket where the file is stored
   + The full path for the file, such as *S3://bucket/path/source\-file\-name*
   + The IAM role that allows AWS Elemental MediaPackage to read from Amazon S3

1. On the AWS Elemental MediaPackage console, go to the **Assets** page, and then choose **Ingest asset**\.

1. For **S3 bucket name**, select the bucket where your source content is stored\.

1. For **IAM role**, choose **Use existing role** and select the IAM role that allows AWS Elemental MediaPackage to read from Amazon S3\.

1. For **Filename**, enter the path within the Amazon S3 bucket and name for the source content\.

1. For **Packaging group**, select the group that you created in [Step 2: Create a Packaging Group](gs-create-grp.md)\.

1. Choose **Ingest assets**\.

## Provide Playback URLs<a name="gs-provide-url-ltov"></a>

After creating the asset resource, AWS Elemental MediaPackage prepares to serve the packaged manifests to viewers\. This happens in the background and might take some time depending on the size and complexity of the source content, but is usually less than a few minutes\. The URLs of the manifests are available immediately on the asset's details page, but content is not yet available for playback\.

After the processing for each manifest is complete, MediaPackage sends an Amazon CloudWatch event to your account\.

On the asset, MediaPackage provides a URL for each packaging configuration\. This URL is how downstream devices \(CDN or playback device\) request VOD content from MediaPackage\.

**To get playback URLs**

1. On the MediaPackage console, go to the **Assets** page and choose the **ID** of the asset that you created in [Step 4: Create an Asset](gs-create-asset.md)\.

1. On the asset's detail page, get the URL for each packaging configuration\.

1. Provide the URLs to the person in charge of the downstream device \(CDN or player\)\. In the downstream device, this person must enter the request destination as the URL from the corresponding packaging configuration\.

Each URL is stable\. It never changes during the lifetime of the combination of this asset and packaging configuration\. Provide the URL to the person in charge of the downstream device \(CDN or player\)\. In the downstream device, this person must use the asset's URL as the request destination\.