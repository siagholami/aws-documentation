--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Cloning a Job in the Console<a name="clonejob"></a>

When you first create an import job or a local compute and storage job, you might discover that you need more than one AWS Snowball Edge device\. Because import jobs and local compute and storage jobs are associated with a single device, requiring more than one device means that you need to create more than one job\. When creating additional jobs, you can go through the job creation wizard again in the console, or you can clone an existing job\.

**Note**  
Cloning a job is a shortcut available in the console to make creating additional jobs easier\. If you're creating jobs with the job management API, you can simply run the job creation command again\.

Cloning a job means recreating it exactly, except for an automatically modified name\. Cloning is a simple process\.

**To clone a job in the console**

1. In the AWS Snowball Management Console, choose your job from the table\.

1. For **Actions**, choose **Clone job**\.

1. The **Create job** wizard opens to the last page, **Step 6: Review**\.

1. Review the information and make any changes you want by choosing the appropriate **Edit** button\.

1. To create your cloned job, choose **Create job**\.

Cloned jobs are named in the format ***Job Name*\-clone\-*number***\. The number is automatically added to the job name and represents the number of times you've cloned this job after the first time you clone it\. For example, **AprilFinanceReports\-clone** represents the first cloned job of **AprilFinanceReports** job, and **DataCenterMigration\-clone\-42** represents the forty\-second clone of the **DataCenterMigration** job\.