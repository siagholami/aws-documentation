# General AWS Elemental MediaPackage Live Processing Flow<a name="what-is-flow-gen"></a>

Here is the general processing flow for live content in MediaPackage:

1. An upstream encoder \(such as AWS Elemental MediaLive\) sends an HLS live stream with digest authentication over WebDAV to the MediaPackage channel input URL, and includes the channel's access credentials \(as supplied in MediaPackage\)\. If you're using input redundancy, the encoder sends two identical HLS live streams to MediaPackage, one to each input URL on the channel\. MediaPackage uses the stream from one input URL as the source content\. If MediaPackage stops receiving content on the active input URL, it automatically switches to the other input URL for source content\. Additionally, AWS scales resources up and down to handle the incoming traffic\.

   For more information, see [Live Input Redundancy AWS Elemental MediaPackage Processing Flow](what-is-flow-ir.md)\.
**Note**  
To allow support for features like time\-shifted viewing, MediaPackage stores all received content for a limited time\. This stored content is only available for playback if it falls within the **startover window** that's defined on the endpoint\. Stored content is not available for playback if it's outside the startover window, or if you haven't defined a window on the endpoint\. For more information, see [Time\-shifted Viewing Reference in AWS Elemental MediaPackage](time-shifted.md)\.

1. A downstream device requests content from MediaPackage through the endpoint output URL\. A downstream device is either a video player or a content delivery network \(CDN\)\. The output URL is associated with an endpoint for a specific streaming format \(either Apple HLS, DASH\-ISO, CMAF, or Microsoft Smooth Streaming\)\.

1. When MediaPackage receives the playback request from the downstream device, it dynamically packages the stream according to the settings that you specified on the endpoint\. Packaging can include adding encryption and configuring audio, video, and subtitles or captions track outputs\.

1. MediaPackage delivers the output stream over HTTPS to the requesting device\. As with input, AWS scales resources up and down to handle changes in traffic\.

1. MediaPackage logs activity through Amazon CloudWatch\. You can view information like the number of content requests and amount of content that MediaPackage has received or delivered\. For information about viewing MediaPackage metrics in CloudWatch, see [Monitoring AWS Elemental MediaPackage with Amazon CloudWatch Metrics](monitoring-cloudwatch.md)\.

Throughout the content input and output processes, MediaPackage detects and mitigates potential infrastructure failures before they become a problem for viewers\. 

The following illustration shows the overall process\.

![\[MediaPackage workflow\]](http://docs.aws.amazon.com/mediapackage/latest/ug/images/bbl flow1.png)