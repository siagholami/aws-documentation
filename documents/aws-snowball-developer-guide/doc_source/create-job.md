--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Create Your First Job<a name="create-job"></a>

The process for creating an AWS Snowball Edge device job in the AWS Snowball Management Console has the following steps\.

**Important**  
Before including Amazon EC2 compute instances in your job creation request, see [Creating a Job with Compute Instances](create-ec2-edge-job.md)\.

**To create an AWS Snowball Edge device job in the console**

1. Sign in to the AWS Management Console and open the [AWS Snowball Management Console](https://console.aws.amazon.com/importexport/home?region=us-west-2)\.

1. Choose **Create Job**\.

1. On the **Plan your job** page of the job creation wizard, choose your job type\.

   **Job\-Type Specific Consideration**
   + If you are creating a cluster, select the **Make this a cluster** check box\.

1. Choose **Next**\.

1. On the **Give shipping details** page, provide the shipping address that you want the AWS Snowball Edge device for this job delivered to\. In some Regions, you choose your shipping speed at this point\. For more information, see [Shipping Speeds](mailing-storage.md#shippingspeeds)\.

1. Choose **Next**\.

1. On the **Give job details** page, provide the details for your job, including a name, Region, and at least one bucket\.
**Important**  
With an AWS Snowball Edge device, all jobs can use the compute functionality in Regions where Lambda is supported\. How the compute functionality is implemented in AWS Snowball jobs is specific to Snowball—the functionality can differ significantly from how Lambda works in the cloud\. Before creating your first compute job, we recommend that you familiarize yourself with how AWS Lambda powered by AWS Greengrass works\. For more information, see [Using AWS Lambda with an AWS Snowball Edge](using-lambda.md)\.

1. Choose **Next**\.

1. On the **Set security** page, specify the following:
   + The Amazon Resource Name \(ARN\) for the AWS Identity and Access Management \(IAM\) role that AWS Snowball assumes to import your data to your destination S3 bucket when you return the AWS Snowball Edge device\.
   + The ARN for the AWS Key Management Service \(AWS KMS\) master key to be used to protect your data within the AWS Snowball Edge device\. For more information, see [Security for AWS Snowball Edge](security.md)\.

1. Choose **Next**\.

1. On the **Set notifications** page, specify the Amazon Simple Notification Service \(Amazon SNS\) notification options for your job and provide a list of comma\-separated email addresses to receive email notifications for this job\. You can also choose which job status values trigger these notifications\. For more information, see [Notifications for the AWS Snowball Edge](notifications.md)\.

1. Choose **Next**\.

1. On the **Review** page, review the information you've provided\. To make changes, choose **Edit** next to the step to change in the navigation pane, or choose **Back**\.
**Important**  
Review this information carefully, because incorrect information can result in unwanted delays\.

Once your job is created, you're taken to the job dashboard, where you can view and manage your jobs\. The last job you created is selected by default, with its **Job status** pane open\.

**Note**  
The **Job created** status is the only status during which you can cancel a job\.

For more information on managing jobs from the AWS Snowball Management Console and tracking job status, see [Job Statuses](jobstatuses.md)\. Jobs can also be created and managed with the job management API\. For more information, see the [AWS Snowball API Reference](https://docs.aws.amazon.com/snowball/latest/api-reference/api-reference.html)\.

After you created your first job, AWS processes the information you provided and prepares an AWS Snowball Edge device specifically for your job\. During the processing stage, if there's an issue with your job, we contact you by email\. Otherwise, we ship the device to the address you provided when you created the job\. Shipping can take a few days, but you can track the shipping status of the device we prepared for your job\. In your job's details, you should see a link to the tracking webpage with your tracking number provided\.

**Job\-Type Specific Consideration**

For an export job, once the Snowball is prepared, the status for your first job part becomes **Exporting**\. Exporting typically takes one business day; however, it can take longer on occasion\. Now that your export job is on its way, you can get from the console a report of the data transfer from Amazon S3 to the AWS Snowball Edge device, and also success and failure logs\. For more information, see [Get Your Job Completion Report and Logs in the Console](report.md)\.

**Next:** [Receive the Snowball Edge](receive-device.md) 