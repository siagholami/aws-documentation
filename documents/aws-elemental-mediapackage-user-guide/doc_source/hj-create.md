# Creating a Harvest Job<a name="hj-create"></a>

Create a harvest job to extract a live\-to\-VOD asset from an unencrypted, live HLS stream\. 

**Important**  
To run a harvest job and save the live\-to\-VOD asset, MediaPackage must have permissions to access and write to the Amazon S3 bucket where the asset will be stored\. To create a role that gives MediaPackage the right permissions, see [Allowing AWS Elemental MediaPackage to Access Other AWS Services](setting-up-create-trust-rel.md)\.

You can use the MediaPackage console, the AWS CLI, or the MediaPackage API to create a harvest job\. For information about creating a job through the AWS CLI or MediaPackage API, see the [AWS Elemental MediaPackage API Reference](https://docs.aws.amazon.com/mediapackage/latest/apireference/)\.

When you're creating a harvest job, don't put sensitive identifying information like customer account numbers into free\-form fields, such as the **ID** field\. This applies when you're using the console, REST API, AWS CLI, or AWS SDKs\. Any data that you enter into MediaPackage might get picked up for inclusion in diagnostic logs or Amazon CloudWatch Events\.

**To create a harvest job \(console\)**

1. Open the MediaPackage console at [https://console\.aws\.amazon\.com/mediapackage/](https://console.aws.amazon.com/mediapackage/)\.

1. In the navigation pane, under **Live**, choose **Harvest jobs**\. 

1. On the **Harvest jobs** page, choose **Create job**\.

1. On the **Create harvest job** page, complete the fields as described in the following topics:
   + [Basic Details](hj-create-basic.md)
   + [Start and End Date and Time](hj-create-time.md)
   + [Destination](hj-create-destination.md)

1. Choose **Create job**\.