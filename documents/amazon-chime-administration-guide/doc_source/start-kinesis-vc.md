# Streaming Amazon Chime Voice Connector media to Kinesis<a name="start-kinesis-vc"></a>

You can stream phone call audio from Amazon Chime Voice Connectors to Amazon Kinesis Video Streams for analytics, machine learning, and other processing\. Developers can store and encrypt audio data in Kinesis Video Streams, and access the data using the Kinesis Video Streams API operation\. For more information, see the [https://docs.aws.amazon.com/kinesisvideostreams/latest/dg/what-is-kinesis-video.html](https://docs.aws.amazon.com/kinesisvideostreams/latest/dg/what-is-kinesis-video.html)\.

Use the Amazon Chime console to start media streaming for your Amazon Chime Voice Connector\. When media streaming is started, your Amazon Chime Voice Connector uses an AWS Identity and Access Management \(IAM\) service\-linked role to grant permissions to stream media to Kinesis Video Streams\. Then, call audio from each Amazon Chime Voice Connector telephone call leg is streamed in real time to separate Kinesis Video Streams\.

Use the Kinesis Video Streams Parser Library to download the media streams sent from your Amazon Chime Voice Connector\. Filter the streams by the following persistent fragments metadata:
+ TransactionId
+ VoiceConnectorId

For more information, see [Kinesis Video Streams Parser Library](https://docs.aws.amazon.com/kinesisvideostreams/latest/dg/parser-library.html) and [Using streaming metadata with Kinesis Video Streams](https://docs.aws.amazon.com/kinesisvideostreams/latest/dg/how-meta.html) in the *Amazon Kinesis Video Streams Developer Guide*\.

For more information about using IAM service\-linked roles with Amazon Chime Voice Connectors, see [Using roles to stream Amazon Chime Voice Connector media to Kinesis](using-service-linked-roles-stream.md)\. For more information about using Amazon CloudWatch with Amazon Chime, see [Logging and monitoring in Amazon Chime](monitoring-overview.md)\.

When you enable media streaming for your Amazon Chime Voice Connector, Amazon Chime creates an IAM service\-linked role called AWSServiceRoleForAmazonChimeVoiceConnector\. If you have configured call detail record logging for Amazon Chime Voice Connectors in the Amazon Chime console, streaming detail records are sent to your configured Amazon S3 bucket\. For more information, see [Amazon Chime Voice Connector streaming detail records](manage-global.md#vc-sdr)\.

## Starting media streaming<a name="start-kinesis"></a>

Start media streaming for your Amazon Chime Voice Connector from the Amazon Chime console\.

**To start media streaming for your Amazon Chime Voice Connector**

1. Open the Amazon Chime console at [https://chime\.aws\.amazon\.com/](https://chime.aws.amazon.com)\.

1. For **Calling**, choose **Voice connectors**\.

1. Choose the name of the Amazon Chime Voice Connector\.

1. Choose **Streaming**\.

1. For **Sending to Kinesis Video Streams**, choose **Start**\.

1. Select a **Data retention period**\.

1. Choose **Save**\.

Turn off media streaming from the Amazon Chime console\. If you no longer need to use media streaming for any of your Amazon Chime Voice Connectors, we recommend that you also delete the related service\-linked role\. For more information, see [Deleting a service\-linked role for Amazon Chime Voice Connectors](using-service-linked-roles-stream.md#delete-service-linked-role-stream)\.

**To stop media streaming for your Amazon Chime Voice Connector**

1. Open the Amazon Chime console at [https://chime\.aws\.amazon\.com/](https://chime.aws.amazon.com)\.

1. For **Calling**, choose **Voice connectors**\.

1. Choose the name of the Amazon Chime Voice Connector\.

1. Choose **Streaming**\.

1. For **Sending to Kinesis Video Streams**, choose **Stop**\.

1. Choose **Save**\.

## SIP\-based media recording \(SIPREC\) and network\-based recording \(NBR\) compatibility<a name="siprec"></a>

You can use an Amazon Chime Voice Connector to stream media to Kinesis Video Streams\. You can stream from a SIPREC\-compatible voice infrastructure or the NBR feature associated with Cisco Unified Border Element \(CUBE\)\.

You must have a Private Branch Exchange \(PBX\), Session Border Controller \(SBC\), or contact center that supports the SIPREC protocol or NBR feature\. The PBX or SBC must be able to send signaling and media to AWS public IP addresses\. For more information, see [Before you begin](voice-connectors.md#vc-prereq)\.

**To set up streaming of RTP audio streams forked with SIPREC or NBR**

1. Create an Amazon Chime Voice Connector\. For more information, see [Creating an Amazon Chime Voice Connector](create-voicecon.md)\.

1. Start media streaming for your Amazon Chime Voice Connector\. For more information, see [Starting media streaming](#start-kinesis)\.

1. In the Amazon Chime console, under **Voice connectors**, view the **Outbound host name** for your Amazon Chime Voice Connector\. For example, `abcdef1ghij2klmno3pqr4.voiceconnector.chime.aws`\.

1. Do one of the following:
   + **For SIPREC** – Configure your PBX, SBC, or other voice infrastructure to fork RTP streams with SIPREC to the **Outbound host name** of your Amazon Chime Voice Connector\.
   + **For NBR** – Configure your PBX, SBC, or other voice infrastructure to fork RTP streams with NBR to the **Outbound host name** of your Amazon Chime Voice Connector\. Send an additional header or URI parameter of `X-Voice-Connector-Record-Only` with the value `true` in the `SIP INVITE`\.