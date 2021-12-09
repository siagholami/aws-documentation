# I Can't Connect to Amazon S3<a name="troubleshoot-connect-S3"></a>

To successfully connect to Amazon S3, you must configure authentication and create a valid manifest file inside the bucket you are trying to access\. You also need to make sure that the file described by the manifest is available\.

To verify authentication, make sure that you authorized Amazon QuickSight to access the S3 account\. It’s not enough that you, the user, are authorized\. Amazon QuickSight must be authorized separately\. 

**To authorize Amazon QuickSight to access your Amazon S3 bucket**

1. In the AWS Region list at top right, choose the US East \(N\. Virginia\) Region\. You use this AWS Region temporarily while you edit your account permissions\. 

1. Inside of Amazon QuickSight, choose your profile name \(top right\)\. Choose **Manage QuickSight**, and then choose **Account Settings**, on the left\. 

1. On the **Account Settings** page, choose **Edit AWS permissions**\. 

1. If **Amazon S3** is selected, see how many buckets are authorized\. 

1. To select individual buckets, choose **Choose S3 buckets**\. Select the buckets you want to access from Amazon QuickSight\. Then choose **Select buckets**\.

1. Choose **Apply**\.

1. If you changed your AWS Region during the first step of this process, change it back to the AWS Region you want to use\.

We strongly recommend that you make sure that your manifest file is valid\. If Amazon QuickSight can't parse your file, it gives you an error similar to "We can't parse the manifest file as a valid JSON" or "We can't connect to the S3 bucket\."

**To verify your manifest file**

1. Open your manifest file\. You can do this directly from the Amazon S3 console at [https://console\.aws\.amazon\.com/s3/](https://console.aws.amazon.com/s3/)\. Navigate to your manifest file and choose **Open**\.

1. Make sure that the URI or URLs provided inside the manifest file indicate the file or files that you want connect to\.

1. Make sure that your manifest file is formed correctly, if you use a link to the manifest file rather than uploading the file\. The link shouldn't have any additional phrases after the word `.json`\. You can get the correct link to an S3 file by viewing its **Link** value in the details on the S3 console\.

1. Make sure that the content of the manifest file is valid by using a JSON validator, like the one at [https://jsonlint.com](https://jsonlint.com)\. 

1. Verify permissions on your bucket or file\. In the [https://console\.aws\.amazon\.com/s3/](https://console.aws.amazon.com/s3/), navigate to your Amazon S3 bucket, choose the **Permissions** tab, and add the appropriate permissions\. Make sure that the permissions are at the right level, either on the bucket or on the file or files\. 

1. If you are using the `s3://` protocol, rather than `https://`, make sure that you reference your bucket directly\. For example, use *s3://mybucket/myfile\.csv* instead of *s3://s3\-us\-west\-2\.amazonaws\.com/mybucket/myfile\.csv*\. Doubly specifying Amazon S3, by using `s3://` and also `s3-us-west-2.amazonaws.com`, causes an error\.

   For more information on manifest files and connecting to Amazon S3, see [Supported Formats for Amazon S3 Manifest Files](supported-manifest-file-format.md)\.

In addition, verify that your Amazon S3 data set was created according to the steps in [Creating a Data Set Using Amazon S3 Files](create-a-data-set-s3.md)\.

If you use Athena to connect to Amazon S3, see [I Can't Connect to Amazon Athena](troubleshoot-connect-athena.md)\.