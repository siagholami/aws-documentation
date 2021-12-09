# Document history for User Guide<a name="doc-history"></a>

The following table describes important additions to the AWS Elemental MediaConvert documentation\. We also update the documentation frequently to address the feedback that you send us\.
+ **API version: 2017\-08\-29** 
+ **Latest documentation update:**June 20, 2018

| Change | Description | Date | 
| --- |--- |--- |
| [New supported output formats](reference-codecs-containers.md#reference-codecs-containers-output-video) | Updated output codec and container reference table to reflect new format support\. MediaConvert now supports WebM as an output container with VP8 and VP9 video codecs and Opus and Vorbis audio codecs\. | June 3, 2020 | 
| [Queue hopping](setting-up-queue-hopping-to-avoid-long-waits.md) | Learn about the AWS Elemental MediaConvert queue hopping feature\. This feature lets you set up a job to automatically move to a different queue after waiting a specified length of time in the queue that you originally submitted it to\. | April 8, 2020 | 
| [You can now convert from HDR to SDR with automatic tone mapping](hdr-support.md#supported-color-space-conversions) | Learn about how AWS Elemental MediaConvert uses tone mapping to automatically convert from HDR formats to SDR color spaces\. | March 6, 2020 | 
| [8k output support in AWS Elemental MediaConvert](supported-output-resolution-maximums-by-codec.md) | MediaConvert now supports up to 8k output resolution\. Find more information about resolution maximums by output codec\. | November 25, 2019 | 
| [Use accelerated transcoding with slow PAL](job-requirements.md) | You can now use accelerated transcoding for slow PAL jobs\. | November 15, 2019 | 
| [Set up access for other AWS accounts to your MediaConvert outputs](setting-up-access-for-other-aws-accounts.md) | You can now grant cross\-account access by writing your AWS Elemental MediaConvert outputs to an Amazon S3 bucket owned by another AWS account and applying a canned access control list \(ACL\) to your outputs\. This chapter also provides information about the alternative method for setting up access—granting other accounts access to your output bucket in Amazon S3\. | November 15, 2019 | 
| [New supported input format](reference-codecs-containers-input.md) | Updated reference tables to reflect new input format support\. MediaConvert now supports HEVC \(H\.265\) in QuickTime containers as input files\. | November 15, 2019 | 
| [New supported captions format](captions-support-tables-by-container-type.md) | Updated reference tables to reflect new captions support\. IMSC sidecar output captions now available in **CMAF**, **DASH ISO**, and **File group** output groups\. You can generate these from the following input captions formats: Ancillary, Embedded, IMSC, Teletext, TTML, SCC, SCTE\-20, SMI, SRT, and STL\. | November 15, 2019 | 
| [ESAM support in DASH outputs](specifying-scte-35-markers-using-esam-xml.md) | You can now specify ad insertion points in DASH outputs by including Event Signaling and Management \(ESAM\) XML documents as strings inside your AWS Elemental MediaConvert job settings\. | November 15, 2019 | 
| [Doc\-only update: Synchronizing sidecar captions and audio in jobs that use input clipping and stitching](assembling-multiple-inputs-and-input-clips.md) | Learn about using the MediaConvert input and output timelines to synchronize your video, audio, captions, and overlays in assembly workflow jobs\. | November 15, 2019 | 
| [Create additional top\-level manifests](create-additional-manifests.md) | You can now set up your ABR streaming packages in AWS Elemental MediaConvert with additional top\-level manifests that specify different subsets of your outputs\. | November 15, 2019 | 
| [Create Dolby Vision outputs](dolby-vision.md) | Learn how to create Dolby Vision outputs with AWS Elemental MediaConvert\. | November 15, 2019 | 
| [Use integrated AWS tags on AWS Elemental MediaConvert resources](tagging-mediaconvert-resources.md) | You can now use standard AWS tags with MediaConvert jobs the same way that you do with queues, templates, and presets\. You can use these tags to sort your billing report for cost allocation purposes, to include your MediaConvert resources in resource groups with other AWS resources, and to control access to specific resources\. | October 9, 2019 | 
| [Use accelerated transcoding with frame capture](job-requirements.md) | You can now use accelerated transcoding for jobs that include frame capture outputs\. | October 9, 2019 | 
| [Have AWS Elemental MediaConvert automatically choose accelerated transcoding for jobs that are compatible](accelerated-transcoding.md) | You can now set accelerated transcoding to PREFERRED, to have the service fall back to standard transcoding when your inputs or job settings aren't compatible with accelerated transcoding\. | October 9, 2019 | 
| [Doc\-only update, use cases for Time delta](time-delta-use-cases.md) | Learn about using the **Time delta** setting to synchronize sidecar captions with your video\. See use case examples that illustrate common captions sync problems that you can fix with this setting\. | September 6, 2019 | 
| [Choose the encryption method for DRM in CMAF output groups](encrypting-content.md) | You can now choose between AES\-CTR and AES\-CBC subsample encryption types when you enable DRM for CMAF output groups\. Learn how to set up DRM encryption\. | September 6, 2019 | 
| [Align sidecar captions with your video after using the Timecode source setting](about-input-timecode-source-and-captions-alignment.md) | When you use the input setting **Timecode source** to align your sidecar audio file with your video, make sure that your sidecar captions still line up\. Learn which sidecar captions formats require adjustment and how to make any necessary adjustments\. | September 6, 2019 | 
| [Multi\-system SPEKE DRM for CMAF](encrypting-content.md#speke-encryption-parameters) | When you work with SPEKE\-compliant DRM partners to enable DRM on your CMAF outputs, you can now signal up to three system IDs in your DASH manifest and one in your HLS manifest\. Learn about setting up this SPEKE encryption parameter in your AWS Elemental MediaConvert job\. | August 12, 2019 | 
| [Export and import jobs](exporting-and-importing-jobs.md) | Learn how to export MediaConvert jobs and how to create new jobs by importing one\. | August 9, 2019 | 
| [Specify the priority of your jobs](setting-the-priority-of-a-job.md) | Learn how to set the relative priority of your jobs when you create them\. | July 30, 2019 | 
| [Convert two SCC input files to embedded captions](converting-dual-scc-input-files-to-embedded-captions.md) | Learn about converting dual SCC input captions to embedded format\. | July 30, 2019 | 
| [Create audio\-only outputs](audio-only.md) | Learn how to create MediaConvert outputs that contain only audio, without video\. | July 23, 2019 | 
| [HTTP inputs to AWS Elemental MediaConvert](upload-input-files.md#http-input-requirements) | You can now specify an HTTP\(S\) URL for your primary inputs to MediaConvert transcoding jobs\. Learn about HTTP\(S\) input requirements\. | July 12, 2019 | 
| [Monitor output file upload progress](monitoring-overview.md) | Using CloudWatch Events, you can now monitor the progress of your job with finer granularity, because AWS Elemental MediaConvert now reports percentage completion of the job phases PROBING, UPLOADING, and TRANSCODING, in addition to reporting overall job progress in percent completion\. | May 7, 2019 | 
| [Doc\-only update, format identifiers ](using-variables-in-your-job-settings.md) | Learn how to use format identifiers as variables in your job settings\. For example, you can use a format identifier to represent your input file name in a job template or output preset, so that AWS Elemental MediaConvert uses the input file name in the file path for your output\. | April 24, 2019 | 
| [You can now cancel an in\-progress job\.](working-with-jobs.md) | AWS Elemental MediaConvert now allows you to cancel jobs that are already in progress\. | March 13, 2019 | 
| [Monitor job progress](monitoring-overview.md) | Using CloudWatch Events, you can now monitor the progress of your AWS Elemental MediaConvert jobs by viewing the percentage of job completion\. | March 13, 2019 | 
| [Added client\-side and server\-side encryption](using-encryption.md) | You can now encrypt your input files before you upload them to Amazon S3\. AWS Elemental MediaConvert decrypts them before transcoding\. You can also now set up your MediaConvert jobs so that Amazon S3 encrypts your job outputs as they are saved to Amazon S3\. | March 13, 2019 | 
| [Find information about the new rotate feature\.](auto-rotate.md) | For most inputs, you can now use the rotate feature to specify how the service rotates your video from input to output\. You can also specify whether the service follows any rotation metadata in the input\. Find information and instructions for setting rotation\.  | February 19, 2019 | 
| [ESAM support](specifying-scte-35-markers-using-esam-xml.md) | You can now specify ad insertion points by including Event Signaling and Management \(ESAM\) XML documents as strings inside your AWS Elemental MediaConvert job settings\. | February 13, 2019 | 
| [Code samples, sample workflows, and other related information](related-information.xml.md) | Find links to code samples, tutorials, and other helpful information for getting started with AWS Elemental MediaConvert\. | February 13, 2019 | 
| [New supported captions formats](captions-support-tables-by-container-type.md) | Updated reference tables to reflect new support for the following captions formats\. On input: SMI, SCTE\-20\. On output: SCTE\-20 \+ embedded, Embedded \+ SCTE\-20, SMI\. | November 19, 2018 | 
| [Find information about the new image inserter features](graphic-overlay.md) | You can now use the image inserter to overlay still graphics on individual inputs as well as outputs\. You can also overlay motion graphics\. Find information and instructions for setting up these overlays\.  | November 19, 2018 | 
| [Added content key encryption to DRM encryption](drm-content-key-encryption.md) | Added the option to encrypt content keys\. Prior to this, AWS Elemental MediaConvert supported plaintext key delivery only\. To use content key encryption, your DRM key provider must support encrypted content keys\. If you enable this feature for a key provider that doesn't handle content key encryption, the operation fails\. | November 19, 2018 | 
| [Reserved queues](working-with-queues.md) | Learn about the AWS Elemental MediaConvert new pricing option, reserved queues\. With reserved queues, you pay for the transcoding capacity of the entire queue, regardless of how much or how little you use it\. If you continuously or frequently run transcoding jobs, you might find considerable cost savings with a reserved queue\. | September 27, 2018 | 
| [Find output file names and paths in your CloudWatch Events notifications](output-file-names-and-paths.md) | Use CloudWatch Events with AWS Elemental MediaConvert jobs to receive output file names and paths, including manifest and media file outputs\. | September 18, 2018 | 
| [Set up cost allocation reports to sort your AWS bill by the tags that you apply to AWS Elemental MediaConvert resources](tagging-mediaconvert-resources.md) | You can use the tags you apply to AWS Elemental MediaConvert queues, job templates, and output presets as cost allocation tags\. First activate them in the AWS Billing and Cost Management dashboard, and then set up a billing report to view your AWS charges by resource\. | September 7, 2018 | 
| [Quality\-defined variable bitrate \(QVBR\) mode now available](cbr-vbr-qvbr.md) | You can now use the QVBR rate control mode to get better video quality for the same file size, or to reduce your file sizes while maintaining video quality\. Get information about how to set it up\. | August 13, 2018 | 
| [Use AWS Elemental MediaConvert tags for cost allocation through tagging](tagging-mediaconvert-resources.md) | You can now activate tags on AWS Elemental MediaConvert queues, job templates, and output presets in the AWS Billing and Cost Management dashboard, and then set up a monthly cost allocation report\. | July 31, 2018 | 
| [Tagging AWS Elemental MediaConvert resources on the console](tagging-mediaconvert-resources.md) | You can now work with tags on existing AWS Elemental MediaConvert queues, job templates, and output presets in the MediaConvert console\. | July 31, 2018 | 
| [CloudTrail changes](logging-using-cloudtrail.md) | Updated the MediaConvert documentation to reflect changes in AWS CloudTrail behavior\. | July 19, 2018 | 
| [Tagging AWS Elemental MediaConvert resources initial release](tagging-mediaconvert-resources.md) | You can now tag MediaConvert resources when you create them using the MediaConvert console, the MediaConvert API, or the AWS CLI\. You can list the tags on an existing MediaConvert resource, and add and remove tags on existing MediaConvert resources, through the MediaConvert API and AWS CLI\. | July 16, 2018 | 
| [Doc\-only update, setting up a job](specify-output-groups.md) | Added step\-by\-step procedures for setting up a job to transcode input media files into files and packages for playing on multiple device types\. | June 20, 2018 | 
| [Doc\-only update, "working with" procedures](working-with-jobs.md) | Added step\-by\-step procedures for creating, listing, editing, and deleting templates, presets, queues, and jobs\. | May 29, 2018 | 
| [CMAF support](structuring-complex-jobs.md) | MediaConvert adds support for common media application format \(CMAF\) outputs\. | May 4, 2018 | 
| [New MediaConvert service release](what-is.md) | Initial documentation for the MediaConvert service\. | November 27, 2017 | 

**Note**  
The AWS Media Services are not designed or intended for use with applications or in situations requiring fail‐safe performance, such as life safety operations, navigation or communication systems, air traffic control, or life support machines in which the unavailability, interruption or failure of the services could lead to death, personal injury, property damage or environmental damage\.
A component of MediaConvert is licensed under the AVC patent portfolio license for the personal and non\-commercial use of a consumer to \(i\) encode video in compliance with the AVC standard \("AVC video"\) and/or \(ii\) decode AVC video that was encoded by a consumer engaged in a personal and non\-commercial activity and/or was obtained from a video provider licensed to provide AVC video\. No license is granted or shall be implied for any other use\. A component of MediaConvert is licensed under the mpeg\-4 patent portfolio license for the personal and non\-commercial use of a consumer for \(i\) encoding video in compliance with the mpeg\-4 visual standard \(“mpeg\-4 video”\) and/or \(ii\) decoding mpeg\-4 video that was encoded by a consumer engaged in a personal and non\-commercial activity and/or was obtained from a video provider licensed to provide AVC video\. No license is granted or shall be implied for any other use\. Additional information may be obtained from MPEG\-LA, LLC\. See [http://www\.mpegla\.com](http://www.mpegla.com)\.
MediaConvert may contain Dolby Digital and Dolby Digital Plus, which are protected under international and U\.S\. copyright laws as unpublished works\. Dolby Digital and Dolby Digital Plus are confidential and proprietary to Dolby Laboratories\. Their reproduction or disclosure, in whole or in part, or the production of derivative works therefrom without the express permission of Dolby Laboratories is prohibited\. © Copyright 2003\-2015 Dolby Laboratories\. All rights reserved\.