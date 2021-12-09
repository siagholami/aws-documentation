# How Live\-to\-VOD Works<a name="ltov-how"></a>

In the processing flow for live\-to\-VOD \(video on demand\) content, AWS Elemental MediaPackage extracts a clip of video from a live content stream\. MediaPackage saves this clip as a live\-to\-VOD asset in Amazon S3\. You can use the VOD content processing functionality in MediaPackage to deliver the asset to playback devices, or you can use a VOD encoding service that supports HLS inputs\. 

Here's an overview of the main steps:

1. You create a channel and endpoint to ingest a live stream and package it for HLS output\. The endpoint must meet the requirements outlined in [Live\-to\-VOD Requirements](ltov-reqmts.md)\.

1. You create a harvest job, which defines the live\-to\-VOD asset that you're extracting from the live stream\. The asset must also meet the requirements outlined in *Live\-to\-VOD Requirements*\.

1. MediaPackage harvests the timeframe that you indicated in the harvest job\. The asset is segment\-accurate\. This means that if you have a 6\-second segment, and the harvest job has a start time of three seconds into the segment, the asset will start three seconds earlier, at the start of the segment\.

   After MediaPackage harvests the asset, it saves the asset in the Amazon S3 bucket that you indicated in the harvest job\. MediaPackage creates a directory within that bucket and names the parent manifest based on the information that you provided in the **Manifest key** on the harvest job\. For example, if the manifest key is **thursdaynight/highlights/index\.m3u8**, MediaPackage creates a `thursdaynight/highlights` directory in your Amazon S3 bucket and names the parent manifest `index.m3u8`\.

   MediaPackage creates a CloudWatch event when the harvest job completes or fails\. For information about events for harvest jobs, see [Harvest Job Notification Events](cloudwatch-events-example.md#hj-status-events)\.

   MediaPackage keeps a read\-only reference of the job on your account for 90 days\. After 90 days, MediaPackage deletes the record of the job from your account\. At this time, if your workflow requires it, you can reuse the identifier from harvest job\.

1. At this point, the live\-to\-VOD functionality in MediaPackage is complete\. The live\-to\-VOD asset is in your Amazon S3 bucket, and you can do with it what your workflow requires\. For example, you can use the VOD functionality in MediaPackage or an encoding service to make the asset available for playback\.