--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Managing Amazon S3 Storage<a name="manage-s3"></a>

You can use AWS OpsHub to create and manage Amazon Simple Storage Service \(Amazon S3\) storage on your Snow Family Devices\.

**Topics**
+ [Creating Amazon S3 Storage](#create-s3-storage)
+ [Uploading Files to Amazon S3 Storage](#upload-file)
+ [Downloading Files from Amazon S3 Storage](#download-file)
+ [Deleting Files from S3 Storage](#delete-file)

## Creating Amazon S3 Storage<a name="create-s3-storage"></a>

You can upload files to your device and access the files locally\. You can physically move them to another location on the device, or import them back to the AWS Cloud when the device is returned\. 

Snow Family Devices use Amazon S3 buckets to store and manage files on your device\.

**To create an S3 bucket**

1. Open the AWS OpsHub application\.

1. In the **Manage file storage** section of the dashboard, choose **Get started**\. 

   If you have S3 buckets on your device, they appear in the **Buckets** section on the **File storage** page\. You can see details of each bucket on the page\.

1. Choose the **Devices** menu, and then choose the name of your device\.

1. Under **Services**, choose **S3 Storage**, and then choose **Start service**\.

## Uploading Files to Amazon S3 Storage<a name="upload-file"></a>

**To upload a file**

1. In the **Manage file storage** section on the dashboard, choose **Get started**\. 

   If you have S3 buckets on your device, they appear in the **Buckets** section on the **File storage** page\. You can see details of each bucket on the page\.

1. Choose the bucket that you want to upload files into\.

1. Choose **Upload files**, or drag and drop the files in the bucket, and choose **OK**\.
**Note**  
To upload larger files, you can use the multipart upload feature in Amazon S3\. For more information, see [Multipart Upload Overview](https://docs.aws.amazon.com/AmazonS3/latest/dev/mpuoverview.html) in the *Amazon Simple Storage Service Developer Guide*\.

## Downloading Files from Amazon S3 Storage<a name="download-file"></a>

**To download a file**

1. In the **Manage file storage** section of the dashboard, choose **Get started**\. If you have S3 buckets on your device, they appear in the **Buckets** section on the **File storage** page\. You can see details of each bucket on the page\.

1. Choose the bucket that you want to download files from and navigate to the file that you want to download\.

1. In the **Actions** menu, choose **Download**\.

1. Choose a location to download the file to, and choose **OK**\.

## Deleting Files from S3 Storage<a name="delete-file"></a>

**To delete a file**

1. In the **Manage file storage** section of the dashboard, choose **Get started**\. If you have S3 buckets on your device, they appear in the **Buckets** section on the **File storage** page\. You can see details of each bucket on the page\.

1. Choose the bucket you want to delete files from, and navigate to the file that you want to delete\.

1. On the **Actions** menu, choose **Delete**\.

1. In the dialog box that appears, choose **Confirm delete**\.