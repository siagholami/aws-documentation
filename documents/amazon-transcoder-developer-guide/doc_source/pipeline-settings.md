# Settings that You Specify When You Create an Elastic Transcoder Pipeline<a name="pipeline-settings"></a>

When you create a pipeline using the Elastic Transcoder console, you can specify the following values\.

**Topics**
+ [Region](#pipeline-settings-region)
+ [General Settings](#pipeline-settings-general)
+ [Configure Amazon S3 Bucket for Transcoded Files and Playlists](#pipeline-settings-configure-transcoded-bucket)
+ [Configure Amazon S3 Bucket for Thumbnails](#pipeline-settings-configure-thumbnail-bucket)
+ [Notifications](#pipeline-settings-notifications)

## Region<a name="pipeline-settings-region"></a>

Elastic Transcoder creates your pipeline in the region you are in\. Choose the region you plan to run jobs in\.

## General Settings<a name="pipeline-settings-general"></a>

 **Pipeline Name**  
The name of the pipeline\. We recommend that the name be unique within the AWS account, but uniqueness is not enforced\. The maximum length of a pipeline name is 40 characters\. 

 **Input Bucket**  
The Amazon S3 bucket in which you saved the media files that you want to transcode and the graphics files, if any, that you want to use for watermarks\.

 **IAM Role**  
The IAM Amazon Resource name \(ARN\) for the role that you want Elastic Transcoder to use to transcode jobs for this pipeline\.

 **AWS KMS Key ARN**  
The AWS Key Management Service \(AWS KMS\) key that you want to use with this pipeline\.  
If you use either **s3** or **s3\-aws\-kms** as your **Encryption:Mode**, you don't need to provide a key with your job because a default key, known as an AWS\-KMS key, is created for you automatically\. You need to provide an AWS\-KMS key only if you want to use a non\-default AWS\-KMS key, or if you are using an **Encryption:Mode** of **aes\-pkcs7**, **aes\-ctr**, or **aes\-gcm**\.

## Configure Amazon S3 Bucket for Transcoded Files and Playlists<a name="pipeline-settings-configure-transcoded-bucket"></a>

Use the settings in this section to specify the Amazon S3 bucket in which you want Elastic Transcoder to save transcoded files and playlists for jobs that are submitted to this pipeline, the Amazon S3 storage class that you want to assign to the files, which users you want to have access to the files, and the type of access you want users to have\. 

 **Bucket**  
The Amazon S3 bucket in which you want Elastic Transcoder to save transcoded files and playlists \(if applicable\) for jobs that you submit to this pipeline\.

 **Storage Class**  
The Amazon S3 storage class, **Standard** or **Reduced Redundancy**, that you want Elastic Transcoder to assign to the transcoded files and playlists that it stores in your Amazon S3 bucket\. For more information, see [Reduced Redundancy Storage](https://docs.aws.amazon.com/AmazonS3/latest/dev/Introduction.html#RRS) in the *Amazon Simple Storage Service Developer Guide*\.

 **Grantee Type**  
Specify how you want to identify the users or groups that you want to have access to transcoded files and playlists\. When you select a grantee type, the [Grantee Type](#pipeline-settings-transcoded-grantee-type) field appears:  
+ **Canonical:** The value of **Grantee** is either the canonical user ID for an AWS account or an origin access identity for an Amazon CloudFront distribution\. For more information about canonical user IDs, see [Access Control List \(ACL\) Overview](https://docs.aws.amazon.com/AmazonS3/latest/dev/ACLOverview.html) in the *Amazon Simple Storage Service Developer Guide*\. For more information about using CloudFront origin access identities to require that users use CloudFront URLs instead of Amazon S3 URLs, see [Using an Origin Access Identity to Restrict Access to Your Amazon S3 Content](https://docs.aws.amazon.com/AmazonCloudFront/latest/DeveloperGuide/private-content-restricting-access-to-s3.html) in the *Amazon CloudFront Developer Guide*\.
**Important**  
A canonical user ID is not the same as an AWS account number\.
+ **Email:** The value of **Grantee** is the registered email address of an AWS account\.
+ **Group:** The value of **Grantee** is one of the following predefined Amazon S3 groups: **AllUsers**, **AuthenticatedUsers**, or **LogDelivery**\.

 **Grantee**  
The AWS user or group that you want to have access to transcoded files and playlists\. To identify the user or group, you can specify the canonical user ID for an AWS account, an origin access identity for a CloudFront distribution, the registered email address of an AWS account, or a predefined Amazon S3 group\. For more information, see [Grantee Type](#pipeline-settings-transcoded-grantee-type)\.

 **Access**  
The permission that you want to give to the AWS user that you specified in [Grantee](#pipeline-settings-transcoded-grantee)\. Permissions are granted on the transcoded files and playlists that Elastic Transcoder adds to the bucket\. Valid values include:  
+ ****Open/Download**:** The grantee can read the objects and metadata for transcoded files and playlists that Elastic Transcoder adds to the Amazon S3 bucket\.
+ ****View Permissions**:** The grantee can read the object ACL for transcoded files and playlists that Elastic Transcoder adds to the Amazon S3 bucket\.
+ ****Edit Permissions**:** The grantee can write the ACL for transcoded files and playlists that Elastic Transcoder adds to the Amazon S3 bucket\.
+ ****Full Control**:** The grantee has permissions to read objects, and view and edit the ACL for transcoded files and playlists that Elastic Transcoder adds to the Amazon S3 bucket\.

![\[Screenshot of the S3 bucket settings for files and playlists.\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/)

## Configure Amazon S3 Bucket for Thumbnails<a name="pipeline-settings-configure-thumbnail-bucket"></a>

Use the settings in this section to specify the Amazon S3 bucket in which you want Elastic Transcoder to save thumbnails for jobs that are submitted to this pipeline, the Amazon S3 storage class that you want to assign to the thumbnails, which users you want to have access to the thumbnails, and the type of access you want users to have\. 

 **Bucket**  
The Amazon S3 bucket in which you want Elastic Transcoder to save thumbnails for jobs that you submit to this pipeline\.

 **Storage Class**  
The Amazon S3 storage class, **Standard** or **Reduced Redundancy**, that you want Elastic Transcoder to assign to the thumbnails that it stores in your Amazon S3 bucket\. For more information, see [Reduced Redundancy Storage](https://docs.aws.amazon.com/AmazonS3/latest/dev/Introduction.html#RRS) in the *Amazon Simple Storage Service Developer Guide*\.

 **Grantee Type**  
Specify how you want to identify the users or groups that you want to have access to thumbnails\. When you select a grantee type, the [Grantee Type](#pipeline-settings-thumbnail-grantee-type) field appears:  
+ **Canonical:** The value of **Grantee** is either the canonical user ID for an AWS account or an origin access identity for an Amazon CloudFront distribution\. For more information about canonical user IDs, see [Access Control List \(ACL\) Overview](https://docs.aws.amazon.com/AmazonS3/latest/dev/ACLOverview.html) in the *Amazon Simple Storage Service Developer Guide*\. For more information about using CloudFront origin access identities to require that users use CloudFront URLs instead of Amazon S3 URLs, see [Using an Origin Access Identity to Restrict Access to Your Amazon S3 Content](https://docs.aws.amazon.com/AmazonCloudFront/latest/DeveloperGuide/private-content-restricting-access-to-s3.html) in the *Amazon CloudFront Developer Guide*\.
**Important**  
A canonical user ID is not the same as an AWS account number\.
+ **Email:** The value of **Grantee** is the registered email address of an AWS account\.
+ **Group:** The value of **Grantee** is one of the following predefined Amazon S3 groups: **AllUsers**, **AuthenticatedUsers**, or **LogDelivery**\.

 **Grantee**  
The AWS user or group that you want to have access to thumbnails\. To identify the user or group, you can specify the canonical user ID for an AWS account, an origin access identity for a CloudFront distribution, the registered email address of an AWS account, or a predefined Amazon S3 group\. For more information, see [Grantee Type](#pipeline-settings-thumbnail-grantee-type)\.

 **Access**  
The permission that you want to give to the AWS user that you specified in [Grantee](#pipeline-settings-thumbnail-grantee)\. Permissions are granted on the thumbnails that Elastic Transcoder adds to the bucket\. Valid values include:  
+ ****Open/Download**:** The grantee can read the objects and metadata for thumbnails that Elastic Transcoder adds to the Amazon S3 bucket\.
+ ****View Permissions**:** The grantee can read the object ACL for thumbnails that Elastic Transcoder adds to the Amazon S3 bucket\.
+ ****Edit Permissions**:** The grantee can write the ACL for thumbnails that Elastic Transcoder adds to the Amazon S3 bucket\.
+ ****Full Control**:** The grantee has permissions to read objects, and view and edit the ACL for thumbnails that Elastic Transcoder adds to the Amazon S3 bucket\.

![\[Screenshot of the S3 bucket settings for thumbnails.\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/)

## Notifications<a name="pipeline-settings-notifications"></a>

Use the settings in this section to configure Elastic Transcoder to notify you when the status of a job changes\. 

 **On Progressing Event**  
The Amazon Simple Notification Service \(Amazon SNS\) topic that you want to notify when Elastic Transcoder has started to process the job\.  
To receive notifications, you must also subscribe to the new topic in the Amazon SNS console\.
Amazon SNS offers a variety of notification options, including the ability to send Amazon SNS messages to Amazon Simple Queue Service \(Amazon SQS\) queues\. For more information, see the [Amazon Simple Notification Service Developer Guide](https://docs.aws.amazon.com/sns/latest/dg/)\.

 **On Complete Event**  
The Amazon SNS topic that you want to notify when Elastic Transcoder has finished processing the job\.

 **On Warning Event**  
The Amazon SNS topic that you want to notify when Elastic Transcoder encounters a warning condition\.

 **On Error Event**  
The Amazon SNS topic that you want to notify when Elastic Transcoder encounters an error condition\.

![\[Notifications screenshot.\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/)