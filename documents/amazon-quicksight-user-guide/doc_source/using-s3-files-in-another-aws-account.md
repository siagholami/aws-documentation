# Data Sets Using S3 Files in Another AWS Account<a name="using-s3-files-in-another-aws-account"></a>

Use this section to learn how to set up security so you can use Amazon QuickSight to access Amazon S3 files in another AWS account\. 

For you to access files in another account, the owner of the other account must first set Amazon S3 to grant you permissions to read the file\. Then, in Amazon QuickSight, you must set up access to the buckets that were shared with you\. After both of these steps are finished, you can use a manifest to create a data set\.

**Note**  
 To access files that are shared with the public, you don't need to set up any special security\. However, you still need a manifest file\.

**Topics**
+ [Setting Up Amazon S3 to Allow Access from a Different Amazon QuickSight Account](#setup-S3-to-allow-access-from-a-different-quicksight-account)
+ [Setting Up Amazon QuickSight to Access Amazon S3 Files in Another AWS Account](#setup-quicksight-to-access-S3-in-a-different-account)

## Setting Up Amazon S3 to Allow Access from a Different Amazon QuickSight Account<a name="setup-S3-to-allow-access-from-a-different-quicksight-account"></a>

Use this section to learn how to set permissions in Amazon S3 files so they can be accessed by Amazon QuickSight in another AWS account\. 

For information on accessing another account's Amazon S3 files from your Amazon QuickSight account, see [Setting Up Amazon QuickSight to Access Amazon S3 Files in Another AWS Account](#setup-quicksight-to-access-S3-in-a-different-account)\. For more information about S3 permissions, see [Managing Access Permissions to Your Amazon S3 Resources](https://docs.aws.amazon.com//AmazonS3/latest/dev/s3-access-control.html) and [How Do I Set Permissions on an Object?](https://docs.aws.amazon.com//AmazonS3/latest/user-guide/set-object-permissions.html)

You can use the following procedure to set this access from the S3 console\. Alternatively, you can grant permissions by using the AWS CLI or by writing a script\. If you have a lot of files to share, you can instead create an S3 bucket policy on the `s3:GetObject` action\. To use a bucket policy, add it to the bucket permissions, not to the file permissions\. For information on bucket policies, see [Bucket Policy Examples](https://docs.aws.amazon.com//AmazonS3/latest/dev/example-bucket-policies.html) in the *Amazon S3 Developer Guide\. *

1. Get the email address of the AWS account email you want to share with\. Alternatively, you can get and use the canonical user ID\. For more information on canonical user IDs, see [AWS Account Identifiers](https://docs.aws.amazon.com//general/latest/gr/acct-identifiers.html) in the *AWS General Reference\.*

1. Sign in to the AWS Management Console and open the Amazon S3 console at [https://console\.aws\.amazon\.com/s3/](https://console.aws.amazon.com/s3/)\.

1. Locate the Amazon S3 bucket that you want to share with Amazon QuickSight\. Choose **Permissions**\.

1. Choose **Add Account**, and then type in an email address, or paste in a canonical user ID, for the AWS account that you want to share with\. This email address should be the primary one associated with the AWS account\. 

1. Choose **Yes** for both **Read bucket permissions** and **List objects**\.

   Choose **Save** to confirm\.

1. Locate the file you want to share, and open the file's permission settings\. 

1. Type in an email address or canonical user ID for the AWS account you want to share with\. This email address should be the primary one associated with the AWS account\. 

1. Enable **Read object** permissions for each file that Amazon QuickSight needs access to\. 

1. Notify the Amazon QuickSight user that the files are now available for use\.

## Setting Up Amazon QuickSight to Access Amazon S3 Files in Another AWS Account<a name="setup-quicksight-to-access-S3-in-a-different-account"></a>

Use this section to learn how to set up Amazon QuickSight so you can access Amazon S3 files in another AWS account\. For information on allowing someone else to access your Amazon S3 files from their Amazon QuickSight account, see [Setting Up Amazon S3 to Allow Access from a Different Amazon QuickSight Account](#setup-S3-to-allow-access-from-a-different-quicksight-account)\.

Use the following procedure to access another account's Amazon S3 files from Amazon QuickSight\. Before you can use this procedure, the users in the other AWS account must share the files in their Amazon S3 bucket with you\.

1. Verify that the user or users in the other AWS account gave your account read and write permission to the S3 bucket in question\. 

1. Choose your profile icon, and then choose **Manage QuickSight**\.

1. Choose **Edit AWS Permissions**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/s3-crosslinked1.png)

1. Choose **Choose S3 buckets**\.

1. On the **Select Amazon S3 buckets** screen, choose the **S3 buckets you can access across AWS** tab\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/s3-crosslinked-select-buckets.png)

   The default tab is named **S3 buckets linked to QuickSight account**\. It shows all the buckets your Amazon QuickSight account has access to\. 

1. If you want to add all the buckets you have permission to use, choose **Choose accessible buckets from other AWS accounts**\. Otherwise, type the name of the Amazon S3 bucket that you want to add\. It must exactly match the unique name of the Amazon S3 bucket\.

   If you don't have the appropriate permissions, you see the error message "We can't connect to this S3 bucket\. Make sure that any S3 buckets you specify are associated with the AWS account used to create this QuickSight account\." This error message appears if you don't have either account permissions or Amazon QuickSight permissions\.
**Note**  
To use Amazon Athena, Amazon QuickSight needs to access the Amazon S3 buckets that Athena uses\. You can add them here one by one, or use the **Choose accessible buckets from other AWS accounts** option\.

1. Choose **Select buckets** to confirm your selection\. 

1. Create a new data set based on Amazon S3, and upload your manifest file\. For more information Amazon S3 data sets, see [Creating a Data Set Using Amazon S3 Files](create-a-data-set-s3.md)\.