# What Is Amazon Kinesis Video Streams with WebRTC<a name="what-is-kvswebrtc"></a>

WebRTC is an open technology specification for enabling real\-time communication \(RTC\) across browsers and mobile applications via simple APIs\. It uses peering techniques for real\-time data exchange between connected peers and provides low latency media streaming required for human\-to\-human interaction\. The WebRTC specification includes a set of IETF protocols including [Interactive Connectivity Establishment](https://www.ietf.org/rfc/rfc5245.txt), [Traversal Using Relay around NAT \(TURN\)](https://tools.ietf.org/html/rfc5766), and [Session Traversal Utilities for NAT \(STUN\)](https://www.ietf.org/rfc/rfc5389.txt) for establishing peer\-to\-peer connectivity, in addition to protocol specifications for reliable and secure real\-time media and data streaming\. 

[Amazon Kinesis Video Streams](https://docs.aws.amazon.com/kinesisvideostreams/latest/dg/what-is-kinesis-video.html) provides a standards\-compliant WebRTC implementation as a fully managed capability\. You can use Amazon Kinesis Video Streams with WebRTC to securely live stream media or perform two\-way audio or video interaction between any camera IoT device and WebRTC\-compliant mobile or web players\. As a fully managed capability, you don't have to build, operate, or scale any WebRTC\-related cloud infrastructure, such as signaling or media relay servers to securely stream media across applications and devices\.

Using Kinesis Video Streams with WebRTC, you can easily build applications for live peer\-to\-peer media streaming, or real\-time audio or video interactivity between camera IoT devices, web browsers, and mobile devices for a variety of use cases\. Such applications can help parents keep an eye on their baby’s room, enable homeowners to use a video doorbell to check who’s at the door, enable owners of camera\-enabled robot vacuums to remotely control the robot by viewing the live camera stream on a mobile phone, and so on\.

If you're a first\-time user of Kinesis Video Streams with WebRTC, we recommend that you read the following sections:
+ [Kinesis Video Streams with WebRTC: How It Works](kvswebrtc-how-it-works.md)
+ [WebRTC SDK in C for Embedded Devices](kvswebrtc-sdk-c.md)
+ [WebRTC SDK in JavaScript for Web Applications](kvswebrtc-sdk-js.md)
+ [WebRTC SDK for Android](kvswebrtc-sdk-android.md)
+ [WebRTC SDK for iOS](kvswebrtc-sdk-ios.md)
+ [Control plane APIs](https://docs.aws.amazon.com/kinesisvideostreams/latest/dg/API_Operations_Amazon_Kinesis_Video_Streams.html)
+ [Data plane REST APIs](https://docs.aws.amazon.com/kinesisvideostreams/latest/dg/API_Operations_Amazon_Kinesis_Video_Signaling_Channels.html)
+ [Data plane Websocket APIs](https://docs.aws.amazon.com/kinesisvideostreams-webrtc-dg/latest/devguide/kvswebrtc-websocket-apis.html)

## Kinesis Video Streams with WebRTC Pricing<a name="kvswebrtc-pricing"></a>

For information about Kinesis Video Streams with WebRTC pricing, see [Amazon Kinesis Video Streams Pricing](https://aws.amazon.com/kinesis/video-streams/pricing/)\. 

## Accessing Kinesis Video Streams with WebRTC<a name="kvswebrtc-accessing"></a>

You can work with Kinesis Video Streams with WebRTC in any of the following ways: 

**Amazon Kinesis Video Streams Console**  
[https://console\.aws\.amazon\.com/kinesisvideo](https://console.aws.amazon.com/kinesisvideo)  
The console is a browser\-based interface to access and use Kinesis Video Streams with WebRTC\.

**AWS SDKs**  
AWS provides software development kits \(SDKs\) that consist of libraries and sample code for various programming languages and platforms \(for example, Java, Python, Ruby, \.NET, iOS, Android, and more\)\. The SDKs provide a convenient way to create programmatic access to Kinesis Video Streams with WebRTC\. For information about the AWS SDKs, including how to download and install them, see [Tools for Amazon Web Services](https://aws.amazon.com/tools/)\.

**Kinesis Video Streams with WebRTC HTTPS API**  
You can access Kinesis Video Streams with WebRTC and AWS programmatically by using the Kinesis Video Streams with WebRTC APIs, which lets you issue API requests directly to the service\. For more information, see the [Amazon Kinesis Video Streams API Reference](https://docs.aws.amazon.com/kinesisvideostreams/latest/dg/API_Reference.html)\.