# Step 5: Create a Job<a name="gs-5-create-a-job"></a>

A job does the work of transcoding\. You specify the name of the file that you want to transcode \(the input file\), the name that you want Elastic Transcoder to give the transcoded file, the preset that you want Elastic Transcoder to use, and a few other settings\. Elastic Transcoder gets the input file from the Amazon S3 input bucket that you specified in your pipeline, transcodes the file, and saves the transcoded file or files in the Amazon S3 output bucket that you specified in the pipeline\.

For more information about jobs, see [Working with Jobs](working-with-jobs.md)\.

**To create a job using the Elastic Transcoder console**

1. Open the Elastic Transcoder console at [https://console\.aws\.amazon\.com/elastictranscoder/](https://console.aws.amazon.com/elastictranscoder/)\.

1. In the navigation bar of the Elastic Transcoder console, select the region in which you want to create the job\.  
![\[Select a region.\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/)

1. In the left pane of the console, click **Pipelines**\. \(You create the job in the pipeline—the queue—that you want to use to transcode the file\.\)

1. On the **Pipelines** page, click **Create New Job**\.

1. Enter the applicable values\. For more information about each field, see [Settings that You Specify When You Create an Elastic Transcoder Job](job-settings.md)\.

1. Click **Create Job**\.