# VOD Content Processing<a name="what-is-flow-vod"></a>

In the processing flow for video on demand \(VOD\) content, AWS Elemental MediaPackage ingests file\-based video content from Amazon S3\. MediaPackage then packages the content, formatting it in response to playback requests from downstream devices\. 

Here is the general processing flow for VOD content in AWS Elemental MediaPackage:

1.  From the MediaPackage asset, you initiate ingest of the source content from an Amazon S3 bucket\. This process can take several minutes\. You receive an Amazon CloudWatch event when ingest is complete and the playback URLs are live\.

1. A downstream device requests content from MediaPackage through the packaging configuration URL on the asset\. A downstream device is either a video player or a content delivery network \(CDN\)\. The URL is associated with a configuration for a specific streaming format \(either Apple HLS, DASH\-ISO, CMAF, or Microsoft Smooth\)\.

1. When MediaPackage receives the playback request from the downstream device, it dynamically packages the stream according to the settings that you specified in the packaging configuration\. Packaging can include adding encryption and configuring audio, video, and subtitles or captions track outputs\.

1. MediaPackage delivers the output stream over HTTPS to the requesting device\. As with input, AWS scales resources up and down to handle changes in traffic\.

1. MediaPackage logs activity through Amazon CloudWatch\. You can view information like the number of content requests and amount of content that MediaPackage has delivered\. For information about viewing MediaPackage VOD metrics in CloudWatch, see [Monitoring AWS Elemental MediaPackage with Amazon CloudWatch Metrics](monitoring-cloudwatch.md)\.

Throughout the content input and output processes, MediaPackage detects and mitigates potential infrastructure failures before they become a problem for viewers\. 