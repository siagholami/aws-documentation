# Creating a bucket<a name="CreatingABucket"></a>

Now that you've signed up for AWS you're ready to create a bucket using the AWS Management Console\. Every object in Amazon S3 is stored in a bucket\. Before you can store data in Amazon S3, you must create a bucket\. 

**Note**  
You are not charged for creating a bucket\. You are charged only for storing objects in the bucket and for transferring objects in and out of the bucket\. The charges that you incur through following the examples in this guide are minimal \(less than $1\)\. For more information about storage charges, see [Amazon S3 pricing](http://aws.amazon.com/s3/pricing/)\.

To create a bucket using the AWS Command Line Interface, see [create\-bucket](https://awscli.amazonaws.com/v2/documentation/api/latest/reference/s3api/create-bucket.html) in the *AWS CLI Command Reference*\. 

**To create a bucket**

1. Sign in to the AWS Management Console and open the Amazon S3 console at [https://console\.aws\.amazon\.com/s3/](https://console.aws.amazon.com/s3/)\.

1. Choose **Create bucket**\.

   The **Create bucket** page opens\.

1. In **Bucket name**, enter a DNS\-compliant name for your bucket\.

   The bucket name must:
   + Be unique across all of Amazon S3\.
   + Be between 3 and 63 characters long\.
   + Not contain uppercase characters\.
   + Start with a lowercase letter or number\.

   After you create the bucket, you can't change its name\. For information about naming buckets, see [Rules for Bucket Naming](https://docs.aws.amazon.com/AmazonS3/latest/dev/BucketRestrictions.html#bucketnamingrules) in the *Amazon Simple Storage Service Developer Guide*\.
**Important**  
Avoid including sensitive information, such as account numbers, in the bucket name\. The bucket name is visible in the URLs that point to the objects in the bucket\.

1. In **Region**, choose the AWS Region where you want the bucket to reside\. 

   Choose a Region close to you to minimize latency and costs and address regulatory requirements\. Objects stored in a Region never leave that Region unless you explicitly transfer them to another Region\. For a list of Amazon S3 AWS Regions, see [AWS Service Endpoints](https://docs.aws.amazon.com/general/latest/gr/rande.html#s3_region) in the *Amazon Web Services General Reference*\.

1. In **Bucket settings for Block Public Access**, keep the values set to the defaults\. 

   By default Amazon S3 blocks all public access to your buckets\. We recommend that you leave all Block Public Access settings enabled\. For more information about blocking public access, see [Using Amazon S3 Block Public Access](https://docs.aws.amazon.com/AmazonS3/latest/dev/access-control-block-public-access.html) in the *Amazon Simple Storage Service Developer Guide*\.

1. Choose **Create bucket**\.

You've created a bucket in Amazon S3\. 

To add an object to your bucket, see [Uploading an object to a bucket](PuttingAnObjectInABucket.md)\.