# Step 3: Create a Pipeline<a name="gs-3-create-a-pipeline"></a>

A pipeline manages the jobs that transcode your files\. Typically, you'll create two or more pipelines, for example, to manage standard\-priority jobs and high\-priority jobs\. In this example, you'll create a single pipeline\. For more information about pipelines, see [Working with Pipelines](working-with-pipelines.md)\.

**To create a pipeline using the Elastic Transcoder console**

1. Open the Elastic Transcoder console at [https://console\.aws\.amazon\.com/elastictranscoder/](https://console.aws.amazon.com/elastictranscoder/)\.

1. In the navigation bar of the Elastic Transcoder console, select the region in which you want to create the pipeline\.  
![\[Select a region.\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/)

1. In the left pane of the console, click **Pipelines**\.

1. On the **Pipelines** page, click **Create New Pipeline**\.

1. Enter the applicable values\. For more information about each field, see [Settings that You Specify When You Create an Elastic Transcoder Pipeline](pipeline-settings.md)\.
**Note**  
If you want to monitor the progress of your job, specify the Amazon Simple Notification Service \(Amazon SNS\) topic that you want to notify when Elastic Transcoder begins processing a job and when Elastic Transcoder has completed the job\.

1. Click **Create Pipeline**\.