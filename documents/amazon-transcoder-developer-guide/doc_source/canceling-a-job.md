# Canceling an Elastic Transcoder Job<a name="canceling-a-job"></a>

You can cancel a job that still has a status of **Submitted**, which means that Elastic Transcoder hasn't started to transcode your file\. The following procedure explains how to cancel a job using the Elastic Transcoder console\. 

To cancel a job using the API, pause the corresponding pipeline so Elastic Transcoder doesn't start processing the job, list jobs that have a status of **Submitted** to get the applicable job ID, then cancel the job using the job ID to identify which job you want to cancel\. For more information, see:
+ [Update Pipeline Status](update-pipeline-status.md)
+ [List Jobs by Status](list-jobs-by-status.md)
+ [Cancel Job](cancel-job.md)

**To cancel a job using the Elastic Transcoder console**

1. Sign in to the AWS Management Console and open the Elastic Transcoder console at [https://console\.aws\.amazon\.com/elastictranscoder/](https://console.aws.amazon.com/elastictranscoder/)\.

1. In the navigation bar of the Elastic Transcoder console, select the region in which you want to cancel a job\.

1. **Optional but recommended:** Pause the pipeline to which you submitted the job, so Elastic Transcoder doesn't begin to process the job\. You can't cancel a job after Elastic Transcoder begins to process it\.

   1. In the navigation \(left\) pane, click **Pipelines**\.

   1. Select the check box next to the pipeline that you want to pause\.

   1. Click **Pause**\.

1. In the navigation pane of the console, click **Jobs**\.

1. On the **Jobs** page, specify the following values:  
**Search By**  
Click **Status**\.  
**Job Status**  
Select **Submitted**\.  
You can only cancel a job that has a status of **Submitted**\.

   For **Order** and **Number of Jobs**, enter the applicable values\.

1. Click **Search**\.

1. In the search results, if you need to view more details about a job to determine whether it's the one you want to cancel, click the ![\[Arrow to expand the settings for a preset.\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/images/magnifying-glass-icon.png) icon next to the job\.

1. To cancel a job, select the check box next to the job, and click **Cancel**\.

1. If you paused the pipeline in Step 3, reactivate it so it resumes processing jobs\.

   1. In the navigation pane, click **Pipelines**\.

   1. Select the check box next to the pipeline that you want to reactivate\.

   1. Click **Activate**\.