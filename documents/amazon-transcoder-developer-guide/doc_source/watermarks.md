# Watermarks<a name="watermarks"></a>

You can configure Elastic Transcoder to overlay up to four graphics, known as watermarks, over a video during transcoding\. For example, the logo that a television channel sometimes displays over its broadcast is a watermark\.

Watermarks appear for the duration of the transcoded video in the size, position, scale, and opacity that you specify\. Opacity controls the density of a watermark, from completely transparent \(invisible\) to completely obscuring the portion of the video that it overlays\.

The graphics that you use for watermarks can be in \.png or \.jpg format; if you want to display a watermark that is not rectangular, use the \.png format, which supports transparency\. You save the graphics in the same Amazon S3 bucket in which you save the videos that you want to transcode\. You specify this bucket, the input bucket, in pipeline settings\.

To add watermarks, you specify settings both in presets and in jobs:
+ **Presets** include settings for the size, the location, and the opacity of up to four watermarks\. You assign an identifier to each group of settings\. When you create a job, this identifier allows you to control which preset settings are used for which graphics\.

  For information about specifying watermark settings in presets by using the Elastic Transcoder console, see [Creating a Preset in Elastic Transcoder](creating-presets.md)\. For information about specifying settings by using the Elastic Transcoder API, see [Create Preset](create-preset.md)\.
+ **Jobs** identify the \.png or \.jpg images that you want to use as watermarks and the group of settings from the preset that you want to use for each watermark\. When you create a job and specify a preset that includes watermark settings, you can choose to add graphics for none, some, or all of the watermark settings that you defined in the preset\.

  For information about specifying watermark settings in jobs by using the Elastic Transcoder console, see [Creating a Job in Elastic Transcoder](creating-jobs.md)\. For information about specifying settings by using the Elastic Transcoder API, see [Create Job](create-job.md)\.