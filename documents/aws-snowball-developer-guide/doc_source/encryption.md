--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Encryption for AWS Snowball Edge<a name="encryption"></a>

When you're using a Snowball Edge to import data into S3, all data transferred to a device is protected by SSL encryption over the network\. To protect data at rest, AWS Snowball Edge uses server side\-encryption \(SSE\)\.

## Server\-Side Encryption in AWS Snowball Edge<a name="sse"></a>

AWS Snowball Edge supports server\-side encryption with Amazon S3–managed encryption keys \(SSE\-S3\)\. Server\-side encryption is about protecting data at rest, and SSE\-S3 has strong, multifactor encryption to protect your data at rest in Amazon S3\. For more information on SSE\-S3, see [Protecting Data Using Server\-Side Encryption with Amazon S3\-Managed Encryption Keys \(SSE\-S3\)](https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingServerSideEncryption.html) in the * Amazon Simple Storage Service Developer Guide*\.

Currently, AWS Snowball Edge doesn't offer server\-side encryption with customer\-provided keys \(SSE\-C\)\. However, you might want to use that SSE type to protect data that has been imported, or you might already use it on data you want to export\. In these cases, keep the following in mind:
+ **Import** – If you want to use SSE\-C to encrypt the objects that you've imported into S3, copy those objects into another bucket that has SSE\-KMS or SSE\-S3 encryption established as a part of that bucket's bucket policy\.
+ **Export** – If you want to export objects that are encrypted with SSE\-C, first copy those objects to another bucket that either has no server\-side encryption, or has SSE\-KMS or SSE\-S3 specified in that bucket's bucket policy\.

### Enabling SSE\-S3 for Data Imported into Amazon S3 from a Snowball Edge<a name="howto-sse"></a>

Use the following procedure in the Amazon S3 Management Console to enable SSE\-S3 for data being imported into Amazon S3\. No configuration is necessary in the AWS Snowball Management Console or on the Snowball device itself\. 

To enable SSE\-S3 encryption for the data that you're importing into Amazon S3, simply set the bucket policies for all the buckets that you're importing data into\. You update the policies to deny upload object \(`s3:PutObject`\) permission if the upload request doesn't include the `x-amz-server-side-encryption` header\.

**To enable SSE\-S3 for data imported into Amazon S3**

1. Sign in to the AWS Management Console and open the Amazon S3 console at [https://console\.aws\.amazon\.com/s3/](https://console.aws.amazon.com/s3/)\.

1. Choose the bucket that you're importing data into from the list of buckets\.

1. Choose **Permissions**\.

1. Choose **Bucket Policy**\.

1. In the **Bucket policy editor**, enter the following policy\. Replace all the instances of *`YourBucket`* in this policy with the actual name of your bucket\.

   ```
   {
     "Version": "2012-10-17",
     "Id": "PutObjPolicy",
     "Statement": [
       {
         "Sid": "DenyIncorrectEncryptionHeader",
         "Effect": "Deny",
         "Principal": "*",
         "Action": "s3:PutObject",
         "Resource": "arn:aws:s3:::YourBucket/*",
         "Condition": {
           "StringNotEquals": {
             "s3:x-amz-server-side-encryption": "AES256"
           }
         }
       },
       {
         "Sid": "DenyUnEncryptedObjectUploads",
         "Effect": "Deny",
         "Principal": "*",
         "Action": "s3:PutObject",
         "Resource": "arn:aws:s3:::YourBucket/*",
         "Condition": {
           "Null": {
             "s3:x-amz-server-side-encryption": "true"
           }
         }
       }
     ]
   }
   ```

1. Choose **Save**\.

You've finished configuring your Amazon S3 bucket\. When your data is imported into this bucket, it is protected by SSE\-S3\. Repeat this procedure for any other buckets, as necessary\.