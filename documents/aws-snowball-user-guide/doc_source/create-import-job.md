--------

This guide is for the Snowball \(50 TB or 80 TB of storage space\)\. If you are looking for documentation for the Snowball Edge, see the [AWS Snowball Edge Developer Guide](https://docs.aws.amazon.com/snowball/latest/developer-guide/whatisedge.html)\.

--------

# Create an Import Job<a name="create-import-job"></a>

**To create an import job from the console**

1. Sign in to the AWS Management Console and open the [AWS Snowball Management Console](https://console.aws.amazon.com/importexport/home?region=us-west-2)\.

1. Choose **Create Job**\.

1. Plan your job\.

   In this optional step, you determine the number of jobs you need to create to finish transferring all the data you want to import into Amazon S3\. The answer you provide helps you better plan for your data transfer\.

   Once you've finished this page, choose **Next**\.
**Note**  
If you're performing a petabyte scale data transfer, we recommend that you read [How to Transfer Petabytes of Data Efficiently](transfer-petabytes.md) before you create your first job\.

1. Give shipping details\.

   On this page, you provide the shipping address that you want the Snowball for this job delivered to\. In some regions you choose your shipping speed as well\. For more information, see [Shipping Speeds](mailing-storage.md#shippingspeeds)\.

   Once you've finished this page, choose **Next**\.

1. Give job details\.

   On this page, specify the details of your job\. These details include the name of your import job, the region for your destination Amazon S3 bucket, the specific Amazon S3 bucket to receive your imported data, and the storage size of the Snowball\. If you don't already have an Amazon S3 bucket, you can create one on this page\. If you create a new Amazon S3 bucket for your destination, note that the Amazon S3 namespace for buckets is shared universally by all AWS users as a feature of the service\. Use a bucket name that is specific and clear for your usage\.

   Once you've finished this page, choose **Next**\.

1. Set security\.

   On this page, you specify the following:
   + The Amazon Resource Name \(ARN\) for the IAM role that Snowball assumes to import your data to your destination S3 bucket when you return the Snowball\.
   + The ARN for the AWS Key Management Service \(AWS KMS\) master key to be used to protect your data within the Snowball\. For more information, see [Security in AWS Snowball](security.md)\.

   Once you've finished this page, choose **Next**\.

1. Set notifications\.

   On this page, specify the Amazon Simple Notification Service \(Amazon SNS\) notification options for your job and provide a list of comma\-separated email addresses to receive email notifications for this job\. You can also choose which job status values trigger these notifications\. For more information, see [Snowball Notifications](notifications.md)\.

   Once you've finished this page, choose **Next**\.

1. Review\. 

   On the next page, review the information you've provided\. To make changes, choose the **Edit** button next to the step to change in the navigation pane, or choose **Back**\.
**Important**  
Review this information carefully, because incorrect information can result in unwanted delays\.

Once your job is created, you're taken to the job dashboard, where you can view and manage your jobs\. The last job you created is selected by default, with its **Job status** pane open\. 

**Note**  
The **Job created** status is the only status during which you can cancel a job\.

For more information on managing jobs from the AWS Snowball Management Console and tracking job status, see [Using the AWS Snowball Management Console](using-console.md)\. Jobs can also be created and managed with the job management API\. For more information, see the [AWS Snowball API Reference](https://docs.aws.amazon.com/snowball/latest/api-reference/api-reference.html)\.

After you created your first import job, AWS processes the information you provided and prepares a Snowball specifically for your import job into Amazon S3\. During the processing stage, if there's an issue with your job, we contact you by email\. Otherwise, we ship a Snowball to the address you provided when you created the job\. Shipping can take a few days, but you can track the shipping status of the Snowball we prepared for your job\. In your job's details, you'll see a link to the tracking webpage with your tracking number provided\.

**Next:** [Receive the AWS Snowball device](receive-device.md) 