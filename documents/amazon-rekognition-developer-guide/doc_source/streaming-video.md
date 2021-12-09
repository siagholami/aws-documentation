# Working with Streaming Videos<a name="streaming-video"></a>

You can use Amazon Rekognition Video to detect and recognize faces in streaming video\. A typical use case is when you want to detect a known face in a video stream\. Amazon Rekognition Video uses Amazon Kinesis Video Streams to receive and process a video stream\. The analysis results are output from Amazon Rekognition Video to a Kinesis data stream and then read by your client application\. Amazon Rekognition Video provides a stream processor \([CreateStreamProcessor](API_CreateStreamProcessor.md)\) that you can use to start and manage the analysis of streaming video\.

**Note**  
The Amazon Rekognition Video streaming API is available in the following regions only: US East \(N\. Virginia\), US West \(Oregon\), Asia Pacific \(Tokyo\), EU \(Frankfurt\), and EU \(Ireland\)\.

The following diagram shows how Amazon Rekognition Video detects and recognizes faces in a streaming video\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/rekognition/latest/dg/images/VideoRekognitionStream.png)

To use Amazon Rekognition Video with streaming video, your application needs to implement the following:
+ A Kinesis video stream for sending streaming video to Amazon Rekognition Video\. For more information, see [Kinesis video stream](https://docs.aws.amazon.com/kinesisvideostreams/latest/dg/what-is-kinesis-video.html)\. 
+ An Amazon Rekognition Video stream processor to manage the analysis of the streaming video\. For more information, see [Starting Streaming Video Analysis](streaming-video-starting-analysis.md)\.
+ A Kinesis data stream consumer to read the analysis results that Amazon Rekognition Video sends to the Kinesis data stream\. For more information, see [Consumers for Amazon Kinesis Streams](https://docs.aws.amazon.com/streams/latest/dev/amazon-kinesis-consumers.html)\. 

This section contains information about writing an application that creates the Kinesis video stream and the Kinesis data stream, streams video into Amazon Rekognition Video, and consumes the analysis results\. For more information, see [Recognizing Faces in a Streaming Video](recognize-faces-in-a-video-stream.md)\.

**Topics**
+ [Recognizing Faces in a Streaming Video](recognize-faces-in-a-video-stream.md)
+ [Giving Amazon Rekognition Video Access to Your Kinesis Streams](api-streaming-video-roles.md)
+ [Starting Streaming Video Analysis](streaming-video-starting-analysis.md)
+ [Reading Streaming Video Analysis Results](streaming-video-kinesis-output.md)
+ [Reference: Kinesis Face Recognition Record](streaming-video-kinesis-output-reference.md)
+ [Troubleshooting Streaming Video](streaming-video-troubleshooting.md)