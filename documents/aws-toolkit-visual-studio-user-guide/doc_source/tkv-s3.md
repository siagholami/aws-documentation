# Using Amazon S3 from AWS Explorer<a name="tkv-s3"></a>

Amazon Simple Storage Service \(Amazon S3\) enables you to store and retrieve data from any connection to the Internet\. All data you store on Amazon S3 is associated with your account and, by default, can only be accessed by you\. The Toolkit for Visual Studio enables you to store data on Amazon S3 and to view, manage, retrieve, and distribute that data\.

Amazon S3 uses the concept of buckets, which you can think of as being similar to file systems or logical drives\. Buckets can contain folders, which are similar to directories, and objects, which are similar to files\. In this section, we'll be using these concepts as we walk through the Amazon S3 functionality exposed by the Toolkit for Visual Studio\.

**Note**  
To use this tool, your IAM policy must grant permissions for the `s3:GetBucketAcl`, `s3:GetBucket`, and `s3:ListBucket` actions\. For more information, see [Overview of AWS IAM Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/PoliciesOverview.html)\.

## Creating an Amazon S3 Bucket<a name="create-s3-bucket"></a>

The bucket is most fundamental unit of storage in Amazon S3\.

 **To create an S3 bucket** 

1. In AWS Explorer, open the context \(right\-click\) menu for the **Amazon S3** node, and then choose **Create Bucket**\.

1. In the **Create Bucket** dialog box, type a name for the bucket\. Bucket names must be unique across AWS\. For information about other constraints, go to the [Amazon S3 documentation](https://docs.aws.amazon.com/AmazonS3/latest/dev/BucketRestrictions.html)\.

1. Choose **OK**\.

## Managing Amazon S3 Buckets from AWS Explorer<a name="managing-s3-buckets"></a>

In AWS Explorer, the following operations are available when you open a context \(right\-click\) menu for an Amazon S3 bucket\.

 *Browse* 

Displays a view of the objects contained in the bucket\. From here, you can create folders or upload files or entire directories and folders from your local computer\. The lower pane displays status messages about the upload process\. To clear these messages, choose the **Clear** icon\. You can also access this view of the bucket by double\-clicking the bucket name in AWS Explorer\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-s3-bucket-browse-empty.png)

 *Properties* 

Displays a dialog box where you can do the following:
+ Set Amazon S3 permissions that scope to:
  + you as the bucket owner\.
  + all users who have been authenticated on AWS\.
  + everyone with Internet access\.
+ Turn on logging for the bucket\.
+ Set up a notification using the Amazon Simple Notification Service \(Amazon SNS\) so that if you are using Reduced Redundancy Storage \(RRS\), you are notified if data loss occurs\. RRS is an Amazon S3 storage option that provides less durability than standard storage, but at reduced cost\. For more information, see [S3 FAQs](https://aws.amazon.com/s3/faqs/#What_is_RRS)\.
+ Create a static website using the data in the bucket\.

 *Policy* 

Enables you to set up AWS Identity and Access Management \(IAM\) policies for your bucket\. For more information, go to the [IAM documentation](https://docs.aws.amazon.com/IAM/latest/UserGuide/IAM_Overview.html) and the use cases for [IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/IAM_UseCases.html) and [S3](https://docs.aws.amazon.com/AmazonS3/latest/dev/AccessPolicyLanguage_UseCases_s3_a.html)\.

 *Create Pre\-Signed URL* 

Enables you to generate a time\-limited URL you can distribute to provide access to the contents of the bucket\. For more information, see [How to Create a Pre\-Signed URL](#s3-pre-sign-create)\.

 *View Multi\-Part Uploads* 

Enables you to view multipart uploads\. Amazon S3 supports breaking large object uploads into parts to make the upload process more efficient\. For more information, go to the discussion of [multipart uploads in the S3 documentation](https://docs.aws.amazon.com/AmazonS3/latest/dev/uploadobjusingmpu.html)\.

 *Delete* 

Enables you to delete the bucket\. You can only delete empty buckets\.

## Uploading Files and Folders to Amazon S3<a name="upload-s3-files"></a>

You can use AWS Explorer to transfer files or entire folders from your local computer to any of your buckets\.

**Note**  
If you upload files or folders that have the same name as files or folders that already exist in the Amazon S3 bucket, your uploaded files will overwrite the existing files without warning\.

 **To upload a file to S3** 

1. In AWS Explorer, expand the **Amazon S3** node, and double\-click a bucket or open the context \(right\-click\) menu for the bucket and choose **Browse**\.

1. In the **Browse** view of your bucket, choose **Upload File** or **Upload Folder**\.

1. In the **File\-Open** dialog box, navigate to the files to upload, choose them, and then choose **Open**\. If you are uploading a folder, navigate to and choose that folder, and then choose **Open**\.

   The **Upload Settings** dialog box enables you to set metadata and permissions on the files or folder you are uploading\. Selecting the **Make everything public** check box is equivalent to setting **Open/Download** permissions to **Everyone**\. You can select the option to use [Reduced Redundancy Storage](https://aws.amazon.com/s3/faqs/#What_is_RRS) for the uploaded files\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-s3-file-upload.png)  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-s3-file-upload-complete.png)

## Amazon S3 File Operations from AWS Toolkit for Visual Studio<a name="tkv-s3-file-ops"></a>

If you choose a file in the Amazon S3 view and open the context \(right\-click\) menu, you can perform various operations on the file\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-s3-file-ops-menu.png)

 *Create Folder* 

Enables you to create a folder in the current bucket\. \(Equivalent to choosing the **Create Folder** link\.\)

 *Upload* 

Enables you to upload files or folders\. \(Equivalent to choosing the **Upload File** or **Upload Folder** links\.\)

 *Open* 

Attempts to open the selected file in your default browser\. Depending on the type of file and your default browser's capabilities, the file might not be displayed\. It might simply be downloaded by your browser instead\.

 *Download* 

Opens a **Folder\-Tree** dialog box to enable you to download the selected file\.

 *Make Public* 

Sets permissions on the selected file to **Open/Download** and **Everyone**\. \(Equivalent to selecting the **Make everything public** check box on the **Upload Settings** dialog box\.\)

 *Delete* 

Deletes the selected files or folders\. You can also delete files or folders by choosing them and pressing `Delete`\.

 *Change Storage Class* 

Sets the storage class to either Standard or Reduced Redundancy Storage \(RRS\)\. To view the current storage class setting, choose **Properties**\.

 *Change Encryption* 

Enables you to set server\-side encryption on the file\. To view the current encryption setting, choose **Properties**\.

 *Rename* 

Enables you to rename a file\. You cannot rename a folder\.

 *Cut \| Copy \| Paste* 

Enables you to cut, copy, and paste files or folders between folders or between buckets\.

 *Properties* 

Displays a dialog box that enables you to set metadata and permissions for the file, as well as toggle storage for the file between Reduced Redundancy Storage \(RRS\) and Standard, and set server\-side encryption for the file\. This dialog box also displays an https link to the file\. If you choose this link, the Toolkit for Visual Studio opens the file in your default browser\. If you have permissions on the file set to **Open/Download** and **Everyone**, other people will be able to access the file through this link\. Rather than distributing this link, we recommend you create and distribute pre\-signed URLs\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-s3-properties-file.png)

 *Create Pre\-Signed URL* 

Enables you to create a time\-limited pre\-signed URL that you can distribute to enable other people to access the content you have stored on Amazon S3\.

### How to Create a Pre\-Signed URL<a name="s3-pre-sign-create"></a>

You can create a pre\-signed URL for a bucket or files in a bucket\. Other people can then use this URL to access the bucket or file\. The URL will expire after a period of time that you specify when you create the URL\.

 **To create a pre\-signed URL** 

1. In the **Create Pre\-Signed URL** dialog box, set the expiration date and time for the URL\. The default setting is one hour from the current time\.

1. Choose the **Generate** button\.

1. To copy the URL to the clipboard, choose **Copy**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-s3-presigned-url.png)