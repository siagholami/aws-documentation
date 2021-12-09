--------

This guide is for the Snowball \(50 TB or 80 TB of storage space\)\. If you are looking for documentation for the Snowball Edge, see the [AWS Snowball Edge Developer Guide](https://docs.aws.amazon.com/snowball/latest/developer-guide/whatisedge.html)\.

--------

# Security in AWS Snowball<a name="security"></a>

Following, you can find information on security considerations for working with AWS Snowball\. Security is a significant concern when transporting information of any level of classification, and Snowball has been designed with this concern in mind\.

**Topics**
+ [Encryption in AWS Snowball](#encryption)
+ [Authorization and Access Control in AWS Snowball](auth-access-control.md)
+ [AWS Key Management Service in Snowball](kms.md)
+ [Authorization with the Amazon S3 API Adapter for Snowball](auth-adapter.md)
+ [Other Security Considerations for Snowball](security-considerations.md)

## Encryption in AWS Snowball<a name="encryption"></a>

When you're using a standard Snowball to import data into S3, all data transferred to a Snowball has two layers of encryption:

1. A layer of encryption is applied in the memory of your local workstation\. This layer is applied whether you're using the Amazon S3 Adapter for Snowball or the Snowball client\. This encryption uses AES GCM 256\-bit keys, and the keys are cycled for every 60 GB of data transferred\.

1. SSL encryption is a second layer of encryption for all data going onto or off of a standard Snowball\.

AWS Snowball uses server side\-encryption \(SSE\) to protect data at rest\.

### Server\-Side Encryption in AWS Snowball<a name="sse"></a>

AWS Snowball supports server\-side encryption with Amazon S3–managed encryption keys \(SSE\-S3\) and server\-side encryption with AWS Key Management Service–managed keys \(SSE\-KMS\)\. Server\-side encryption is about protecting data at rest\. For more information, see [Protecting Data Using Server\-Side Encryption](https://docs.aws.amazon.com/AmazonS3/latest/dev/serv-side-encryption.html) in the *Amazon Simple Storage Service Developer Guide*\.

Currently, Snowball doesn't support server\-side encryption with customer\-provided keys \(SSE\-C\)\. However, you might want to use this SSE option to protect data that has been imported\. Or you might already use this encryption option for data you want to export\. In these cases, keep the following in mind:
+ **Import** – If you want to use SSE\-C to encrypt the objects that you've imported into S3, copy those objects into another bucket that has SSE\-KMS or SSE\-S3 encryption established as a part of that bucket's bucket policy\.
+ **Export** – If you want to export objects that are encrypted with SSE\-C, first copy those objects to another bucket that either has no server\-side encryption, or has SSE\-KMS or SSE\-S3 specified in that bucket's bucket policy\.

#### Enabling SSE\-S3 for Data Imported into Amazon S3 from a Snowball<a name="howto-sse"></a>

Use the following procedure in the Amazon S3 Management Console to enable SSE\-S3 for data being imported into Amazon S3\. No configuration is necessary in the AWS Snowball Management Console or on the Snowball device itself\. 

To enable SSE\-S3 encryption for the data that you're importing into Amazon S3, simply update the bucket policies for all the buckets that you're importing data into\. You update the policies to deny upload object \(`s3:PutObject`\) permission if the upload request doesn't include the `x-amz-server-side-encryption` header\.

**To enable SSE\-S3 for data imported into Amazon S3**

1. Sign in to the AWS Management Console and open the Amazon S3 console at [https://console\.aws\.amazon\.com/s3/](https://console.aws.amazon.com/s3/)\.

1. Choose the bucket that you're importing data into from the list of buckets\.

1. Choose **Permissions**\.

1. Choose **Bucket Policy**\.

1. In **Bucket policy editor**, enter the following policy\. Replace all the instances of *`YourBucket`* in this policy with the actual name of your bucket\.

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