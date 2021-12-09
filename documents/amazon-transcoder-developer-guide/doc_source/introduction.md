# What is Amazon Elastic Transcoder?<a name="introduction"></a>

**Topics**
+ [Accessing Elastic Transcoder](accessing.md)
+ [Choosing a Region for Your Elastic Transcoder Resources](#regions-choosing)
+ [Limits on the Number of Elastic Transcoder Pipelines, Jobs, and Presets](limits.md)

Amazon Elastic Transcoder lets you convert media files that you have stored in Amazon Simple Storage Service \(Amazon S3\) into media files in the formats required by consumer playback devices\. For example, you can convert large, high\-quality digital media files into formats that users can play back on mobile devices, tablets, web browsers, and connected televisions\.

Elastic Transcoder has four components:
+ **Jobs** do the work of transcoding\. Each job converts one file into up to 30 formats\. For example, if you want to convert a media file into six different formats, you can create files in all six formats by creating a single job\.

  When you create a job, you specify the name of the file that you want to transcode, the names that you want Elastic Transcoder to give to the transcoded files, and several other settings\. For each format that you want to transcode into, you also specify a template, known as a *preset* \(see below\), that contains the audio and video settings that you want to use for the transcoded file or files\.
+ **Pipelines** are queues that manage your transcoding jobs\. When you create a job, you specify which pipeline you want to add the job to\. Elastic Transcoder starts processing the jobs in a pipeline in the order in which you added them\. If you configure a job to transcode into more than one format, Elastic Transcoder creates the files for each format in the order in which you specify the formats in the job\.

  One common configuration is to create two pipelines—one for standard\-priority jobs, and one for high\-priority jobs\. Most jobs go into the standard\-priority pipeline; you use the high\-priority pipeline only when you need to transcode a file immediately\.

  If a pipeline already contains jobs when you create a new job, Elastic Transcoder queues the newest job and begins processing it as soon as resources are available for that pipeline\. If the pipeline is already using all of its resources, Elastic Transcoder begins processing the next job in the pipeline when it finishes one of the jobs that it's currently processing\.

  A pipeline can process more than one job simultaneously, and the time required to complete a job varies significantly based on the size of the file you're converting and the job specifications\. Accordingly, jobs don't necessarily complete in the order in which you create them\.

  You can temporarily stop processing jobs by pausing the pipeline\.
+ **Presets** are templates that contain most of the settings for transcoding media files from one format to another\. Elastic Transcoder includes some default presets for common formats, for example, several iPod and iPhone versions\. You can also create your own presets for formats that aren't included among the default presets\. You specify which preset you want to use when you create a job\.
+ **Notifications** let you optionally configure Elastic Transcoder and Amazon Simple Notification Service to keep you apprised of the status of a job: when Elastic Transcoder starts processing the job, when Elastic Transcoder finishes the job, and whether Elastic Transcoder encounters warning or error conditions during processing\. Notifications eliminate the need for polling to determine when a job has finished\. You configure notifications when you create a pipeline\.

## Choosing a Region for Your Elastic Transcoder Resources<a name="regions-choosing"></a>

Pipelines and jobs are closely associated with specific regions\. When you create pipelines and jobs, they're created in the current region\. When you create a new job, you must specify a pipeline in the current region\.

You can specify Amazon S3 buckets in a different region than your Elastic Transcoder resources, but we don't recommend it because you'll incur additional charges for transferring files between AWS regions\.

For more information on cross\-regional fees, see Data Transfer Pricing in [Amazon S3 Pricing](http://aws.amazon.com/s3/pricing/)\.