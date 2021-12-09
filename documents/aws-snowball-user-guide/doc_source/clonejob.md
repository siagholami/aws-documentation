--------

This guide is for the Snowball \(50 TB or 80 TB of storage space\)\. If you are looking for documentation for the Snowball Edge, see the [AWS Snowball Edge Developer Guide](https://docs.aws.amazon.com/snowball/latest/developer-guide/whatisedge.html)\.

--------

# Cloning an Import Job in the Console<a name="clonejob"></a>

When you first create an import job, you might discover that you need more than one Snowball\. Because each Snowball is associated with a single import job, requiring more than one Snowball means that you need to create more than one job\. When creating additional jobs, you can go through the job creation wizard again, or you can clone an existing job\.

Cloning a job means recreating it exactly, except for an automatically modified name\. Cloning is a simple process\.

**To clone a job**

1. In the AWS Snowball Management Console, choose your job from the table\.

1. For **Actions**, choose **Clone job**\.

1. The **Create job** wizard opens to the last page, **Step 6: Review**\.

1. Review the information and make any changes you want by choosing the appropriate **Edit** button\.

1. To create your cloned job, choose **Create job**\.

Cloned jobs are named in the format ***Job Name*\-clone\-*number***\. The number is automatically appended to the job name and represents the number of times you've cloned this job after the first time you clone it\. For example, **AprilFinanceReports\-clone** represents the first cloned job of **AprilFinanceReports** job, and **DataCenterMigration\-clone\-42** represents the forty\-second clone of the **DataCenterMigration** job\.