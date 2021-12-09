# Exploring Amazon S3 Analytics Data<a name="explore-from-s3-analytics"></a>

Amazon QuickSight contains a dashboard designed to provide insight into your Amazon S3 analytics data\. To use this feature, you must first enable S3 analytics storage class analysis for your S3 buckets\. For more on enabling storage class analysis in S3, see [Amazon S3 Analytics – Storage Class Analysis](https://docs.aws.amazon.com/AmazonS3/latest/dev/analytics-storage-class.html) in the *Amazon S3 Developer Guide\. *

After you have enabled storage class analysis, you can use Amazon QuickSight to explore your S3 analytics data\.

**To explore S3 analytics data in Amazon QuickSight**

1. Open the Amazon S3 console at [https://console\.aws\.amazon\.com/s3/](https://console.aws.amazon.com/s3/)\.

1. Choose a bucket to explore\. The bucket must have storage class analysis enabled, with at least one filter\.

1. Choose the **Management** tab\.

1. Then Choose **Analytics**\.

1. Choose **Explore in QuickSight**\.
**Note**  
If you don't have an Amazon QuickSight account, you're prompted to create one before you can use the dashboard\.  
![\[The image shows the S3 Analytics screen. There is a button labeled Explore in QuickSight on the top right.\]](http://docs.aws.amazon.com/quicksight/latest/user/images/s3-analytics-deeplink.png)

When you choose the option to explore in Amazon QuickSight, your S3 analytics data is automatically loaded into the dashboard template\. The dashboard contains multiple visualizations to help you to understand the storage access pattern of your bucket\. 

Use the template as is, or customize it to suit your needs\. For example, one visual on the default template helps you identify infrequently accessed data\. It compares the amount of data retrieved to the amount of storage consumed, for objects of different ages\.

![\[The image shows the S3 Analytics dashboard in QuickSight. There are multiple visuals in a single dashboard.\]](http://docs.aws.amazon.com/quicksight/latest/user/images/s3-analytics-dashboard.png)

You can also add your own visualizations to the dashboard\. For example, you can break down the data access patterns, using filters for storage class analysis that you already have defined in S3 analytics\. 

To learn more about using S3 analytics and storage class analysis, see [Amazon S3 Analytics – Storage Class Analysis](https://docs.aws.amazon.com/AmazonS3/latest/dev/analytics-storage-class.html) in the *Amazon S3 Developer Guide\.* 