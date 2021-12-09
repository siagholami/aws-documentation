--------

This guide is for the Snowball \(50 TB or 80 TB of storage space\)\. If you are looking for documentation for the Snowball Edge, see the [AWS Snowball Edge Developer Guide](https://docs.aws.amazon.com/snowball/latest/developer-guide/whatisedge.html)\.

--------

# Create an Export Job<a name="create-export-job"></a>

**To create an export job from the console**

1. Sign in to the AWS Management Console and open the AWS Snowball Management Console at [AWS Snowball Management Console](https://console.aws.amazon.com/importexport/home?region=us-west-2)\.

1. Choose **Create Job**\.

1. Plan your job\.

   In this step, you'll choose your job type\. For an export job, choose **Export**\.

   Once you've finished this page, choose **Next**\.
**Note**  
If you're performing a petabyte scale data transfer, we recommend that you read [How to Transfer Petabytes of Data Efficiently](transfer-petabytes.md) before you create your first job\.

1. Give shipping details\.

   On the next page, you'll provide the shipping address that you want the Snowball for this job delivered to\. In some regions you choose your shipping speed as well\. For more information, see [Shipping Speeds](mailing-storage.md#shippingspeeds)\.

   Once you've finished this page, choose **Next**\.

1. Give job details\.

   On the next page, specify the details of your job\. These details include the name of your export job, the region that your source Amazon S3 buckets reside in, the buckets that you want to export data from, and the storage size for the Snowballs that will be used with this job\. We recommend that you let AWS decide on the Snowball sizes for each job part, as we will optimize for cost efficiency and speed for each job part\. When you create an export job in the [AWS Snowball Management Console](https://console.aws.amazon.com/importexport/home?region=us-west-2), you can choose to export an entire Amazon S3 bucket or a specific range of objects and prefixes\. For more information, see [Using Export Ranges](ranges.md)\.
**Important**  
When selecting what data to export, keep in mind that objects with trailing slashes in their names \(`/` or `\`\) will not be transferred\. Before exporting any objects with trailing slashes, update their names to remove the slash\.

   Once you've finished this page, choose **Next**\.

1. Set security\.

   On the next page, you'll specify the Amazon Resource Name \(ARN\) for the AWS Identity and Access Management role that Snowball assumes to export your data from your source Amazon S3 buckets, and also the AWS Key Management Service \(AWS KMS\) master key ARN to be used to protect your data within the Snowball\. For more information, see [Security in AWS Snowball](security.md)\.

   Once you've finished this page, choose **Next**\.

1. Set notifications\.

   On the next page, specify the Amazon Simple Notification Service \(Amazon SNS\) notification options for your job and provide a list of comma\-separated email addresses to receive email notifications for this job\. You can also choose which job status values trigger these notifications\. For more information, see [Snowball Notifications](notifications.md)\.

   Once you've finished this page, choose **Next**\.

1. Review\.

   On the next page, review the information you've provided\. To make changes, choose the **Edit** button next to the step to change in the navigation pane, or choose **Back**\.
**Important**  
Review this information carefully, because incorrect information can result in unwanted delays\.

Once your job is created, you're taken to the job dashboard, where you can view and manage your jobs\. The newest job you created is selected by default, though this a temporary placeholder\. When the Amazon S3 listing operation completes in the background, this newest job will be replaced with the number of job parts necessary to complete your job\.

**Note**  
At this point, until the job enters the **Preparing Snowball** status, you have the option of canceling the job and its job parts\. If you think that you might want to cancel a job, we suggest that you use Amazon SNS notifications to track when the job is created\.

For more information on managing jobs from the AWS Snowball Management Console and tracking job status, see [Using the AWS Snowball Management Console](using-console.md)\.

Once the Snowball is prepared, the status for your first job part will become **Exporting**\. Exporting typically takes one business day; however, this can take longer on occasion\.

Once Exporting has completed, the Snowball for your job part enters the **Preparing shipment** status, followed quickly by the **In transit to you** status\. Shipping can take a few days, and you can track the shipping status of the Snowball we prepared for your job\. In your job's details, you'll see a link to the tracking webpage with your tracking number provided\.

Now that your export job is on its way, you can get from the console a report of the data transfer from Amazon S3 to the Snowball, and also success and failure logs\. To access the report or the logs, select the job from the table, and expand it to reveal the job's detailed information\. Choose **Get report** to download your job report\. For more information, see [Getting Your Job Completion Report and Logs in the Console](report.md)\.

**Next:** [Receive the AWS Snowball device](receive-export.md) 