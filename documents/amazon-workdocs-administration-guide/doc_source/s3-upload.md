# Step 2: Uploading files to Amazon S3<a name="s3-upload"></a>

**To upload files to Amazon S3**

1. Create a new Amazon Simple Storage Service \(Amazon S3\) bucket in your AWS account that you want to upload your files and folders to\. The Amazon S3 bucket must be in the same AWS account and AWS Region as your Amazon WorkDocs site\. For more information, see [Getting started with Amazon Simple Storage Service](https://docs.aws.amazon.com/AmazonS3/latest/gsg/GetStartedWithS3.html) in the *Amazon Simple Storage Service Getting Started Guide*\.

1. Upload your files to the Amazon S3 bucket that you created in the previous step\. We recommend using AWS DataSync to upload your files and folders to the Amazon S3 bucket\. DataSync provides additional tracking, reporting, and syncing features\. For more information, see [How AWS DataSync works](https://docs.aws.amazon.com/datasync/latest/userguide/how-datasync-works.html) and [Using identity\-based policies \(IAM policies\) for DataSync](https://docs.aws.amazon.com/datasync/latest/userguide/using-identity-based-policies.html) in the *AWS DataSync User Guide*\.