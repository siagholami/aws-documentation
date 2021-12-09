# Step 4: Create an Asset<a name="gs-create-asset"></a>

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