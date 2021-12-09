# Creating a Job in Elastic Transcoder<a name="creating-jobs"></a>

You can create a job using the AWS Management Console or using the Elastic Transcoder Create Job API action\. The following procedure explains how to create a job by using the console\. For information about how to create a job using the API, see [Create Job](create-job.md)\.

You can configure Elastic Transcoder to notify you when the status of a job changes, including when Elastic Transcoder starts and finishes processing a job, and when it encounters a warning or error condition\. For more information, see [Creating a Pipeline in Elastic Transcoder](creating-pipelines.md)\.

You cannot update a job after you have created it\. If you need to change settings in a job, cancel it, create a new job based on the one that you canceled, update the applicable values, and create the new job\. 

**Note**  
Before you can create a job, you must create the pipeline \(the queue\) that will manage the job\. For more information about creating a pipeline, see [Creating a Pipeline in Elastic Transcoder](creating-pipelines.md)\. In addition, if you want to transcode a file using settings other than those provided in the Elastic Transcoder default presets, you must create a new preset\. For more information about creating a preset, see [Creating a Preset in Elastic Transcoder](creating-presets.md)\.

**To create a job using the Elastic Transcoder console**

1. Sign in to the AWS Management Console and open the Elastic Transcoder console at [https://console\.aws\.amazon\.com/elastictranscoder/](https://console.aws.amazon.com/elastictranscoder/)\.

1. In the navigation bar of the Elastic Transcoder console, select the region corresponding to the pipeline that you want to use for the transcoding job\. Pipelines are available only in the regions where they were created\.

1. In the navigation \(left\) pane of the console, click **Pipelines**\. \(You create the job in the pipeline—the queue—that you want to use to transcode the file\.\)

1. On the **Pipelines** page, click **Create New Job**\.

1. Enter the applicable values\. For more information about each field, see [Settings that You Specify When You Create an Elastic Transcoder Job](job-settings.md)\.

1. Click **Create Job**\. Jobs start as soon as they are created\.
**Note**  
If a job fails with an `Access Denied` error, we recommend that you run the `Test Role` API action to determine what is causing the error\. For more information, see [Test Role](test-pipeline-role.md)\.