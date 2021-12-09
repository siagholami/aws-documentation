# Working with Pipelines<a name="working-with-pipelines"></a>

**Topics**
+ [Creating a Pipeline in Elastic Transcoder](creating-pipelines.md)
+ [Pausing and Reactivating Pipelines in Elastic Transcoder](updating-pipeline-status.md)
+ [Updating Pipeline Notifications in Elastic Transcoder](updating-pipeline-notifications.md)
+ [Listing and Viewing Pipelines in Elastic Transcoder](listing-pipelines.md)
+ [Deleting an Elastic Transcoder Pipeline](deleting-a-pipeline.md)
+ [Settings that You Specify When You Create an Elastic Transcoder Pipeline](pipeline-settings.md)

Pipelines are queues that manage your transcoding jobs\. When you create a job, you specify the pipeline to which you want to add the job\. Elastic Transcoder starts processing the jobs in a pipeline in the order in which you added them\.

One common configuration is to create two pipelines—one for standard\-priority jobs, and one for high\-priority jobs\. Most jobs go into the standard\-priority pipeline; you use the high\-priority pipeline only when you need to transcode a file immediately\.

If there are other jobs in a pipeline when you create a job, Elastic Transcoder starts processing the new job when resources are available\. A pipeline can process more than one job simultaneously, and the time required to complete a job varies significantly based on the size of the file you're converting and the job specifications\. As a result, jobs don't necessarily complete in the order in which you create them\.

You can temporarily pause a pipeline so it stops processing jobs\. This is useful if you want to cancel one or more jobs, which you can do only until Elastic Transcoder starts processing the jobs\.