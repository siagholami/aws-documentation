# Working with Amazon S3 buckets by using the AWS Toolkit for JetBrains<a name="work-with-S3-buckets"></a>

Every object you store in Amazon S3 resides in a bucket\. You can use buckets to group related objects in the same way that you use a directory to group files in a file system\.

**Topics**
+ [Creating an Amazon S3 bucket](#creating-s3-bucket)
+ [Viewing Amazon S3 buckets](#viewing-s3-bucket)
+ [Deleting an Amazon S3 bucket](#deleting-s3-buckets)

## Creating an Amazon S3 bucket<a name="creating-s3-bucket"></a>

1. [Open AWS Explorer](key-tasks.md#key-tasks-open-explorer), if it isn't already open\.

1. Right\-click the **Amazon S3** node and choose **Create S3 Bucket**\.  
![\[Creating an AWS Lambda bucket in AWS Explorer\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

1. In the **Create S3 Bucket** dialog box, enter a name for the bucket\.
**Note**  
Because Amazon S3 allows your bucket to be used as a URL that can be accessed publicly, the bucket name that you choose must be globally unique\. If some other account has already created a bucket with the name that you chose, you must use another name\. For more information, see [Bucket Restrictions and Limitations](https://docs.aws.amazon.com/AmazonS3/latest/dev/BucketRestrictions.html) in the *Amazon Simple Storage Service Developer Guide*\.

1. Choose **Create**\.

## Viewing Amazon S3 buckets<a name="viewing-s3-bucket"></a>

1. [Open AWS Explorer](key-tasks.md#key-tasks-open-explorer), if it isn't already open\.

1. Click the **Amazon S3** node to expand the list of buckets\.
   + The S3 buckets for the [current AWS Region](setup-region.md#setup-region-current-region) are displayed beneath the **Amazon S3** node\.

## Deleting an Amazon S3 bucket<a name="deleting-s3-buckets"></a>

1. [Open AWS Explorer](key-tasks.md#key-tasks-open-explorer), if it isn't already\.

1. Click the **Amazon S3** node to expand the list of buckets\.

1. Right\-click the bucket to delete, and then choose **Delete S3 Bucket**\.  
![\[Deleting an AWS Lambda bucket in AWS Explorer\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

1. Enter the bucket's name to confirm the deletion, and then choose **OK**\.
   + If the bucket contains objects, the bucket is emptied before deletion\. A notification is displayed after the deletion is complete\.