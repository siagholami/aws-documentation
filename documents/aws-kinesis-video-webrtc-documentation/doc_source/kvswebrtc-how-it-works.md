# Kinesis Video Streams with WebRTC: How It Works<a name="kvswebrtc-how-it-works"></a>

**Topics**
+ [Amazon Kinesis Video Streams with WebRTC Concepts](#how-kvswebrtc-concepts)
+ [WebRTC Technology Concepts](#how-webrtc-concepts)
+ [How STUN, TURN and ICE Work Together](#how-webrtc-components-interwork)
+ [Kinesis Video Streams with WebRTC Components](#how-kvswebrtc-works)
+ [WebRTC Websocket APIs](kvswebrtc-websocket-apis.md)

## Amazon Kinesis Video Streams with WebRTC Concepts<a name="how-kvswebrtc-concepts"></a>

The following are key terms and concepts specific to the Amazon Kinesis Video Streams with WebRTC\.

**Signaling channel**  
A resource that enables applications to discover, set up, control, and terminate a peer\-to\-peer connection by exchanging signaling messages\. Signaling messages are metadata that two applications exchange with each other to establish peer\-to\-peer connectivity\. This metadata includes local media information, such as media codecs and codec parameters, and possible network candidate paths for the two applications to connect with each other for live streaming\.  
Streaming applications can maintain persistent connectivity with a signaling channel and wait for other applications to connect to them\. Or, they can connect to a signaling channel only when they need to live stream media\. A signaling channel enables applications to connect with each other in a one\-to\-few model, using the concept of one master connecting to multiple viewers\. The application that initiates the connection assumes the responsibility of a master using the `ConnectAsMaster` API and waits for viewers\. Up to 10 applications can then connect to that signaling channel by assuming the viewer responsibility by invoking the `ConnectAsViewer` API\. After they're connected to a signaling channel, the master and viewer applications can send each other signaling messages to establish peer\-to\-peer connectivity for live media streaming\.

**Peer**  
Any device or application \(for example, a mobile or web application, webcam, home security camera, baby monitor, etc\.\) that is configured for real\-time, two\-way streaming through a Kinesis Video Streams with WebRTC\.

**Master**  
A peer that initiates the connection and is connected to the signaling channel with the ability to discover and exchange media with any of the signaling channel's connected viewers\.   
Currently, a signaling channel can only have one master\.

**Viewer**  
A peer that is connected to the signaling channel with the ability to discover and exchange media only with the signaling channel's master\. A viewer cannot discover or interact with other viewers through a given signaling channel\. A signaling channel can have up to 10 connected viewers\.

## WebRTC Technology Concepts<a name="how-webrtc-concepts"></a>

As you get started with Kinesis Video Streams with WebRTC, you can also benefit from learning about several interrelated protocols and APIs of which the WebRTC technology consists\.

**Session Traversal Utilities for NAT \(STUN\)**  
A protocol that is used to discover your public address and determine any restrictions in your router that would prevent a direct connection with a peer\.

**Traversal Using Relays around NAT \(TURN\)**  
A server that is used to bypass the Symmetric NAT restriction by opening a connection with a TURN server and relaying all information through that server\.

**Session Description Protocol \(SDP\)**  
A standard for describing the multimedia content of the connection such as resolution, formats, codecs, encryption, etc\. so that both peers can understand each other once the data is transferring\.

**SDP Offer**  
An SDP message sent by an agent which generates a session description in order to create or modify a session\. It describes the aspects of desired media communication\.

**SDP Answer**  
An SDP message sent by an answerer in response to an offer received from an offerer\. The answer indicates the aspects that are accepted\. For example, if all the audio and video streams in the offer are accepted\.

**Interactive Connectivity Establishment \(ICE\)**  
A framework that allows your web browser to connect with peers\.

**ICE Candidate**  
A method that the sending peer is able to use to communicate\.

## How STUN, TURN and ICE Work Together<a name="how-webrtc-components-interwork"></a>

Let's take the scenario of two peers, A and B, who are both using a WebRTC peer to peer two way media streaming \(for example, a video chat application\)\. What happens when A wants to call B?

To connect to B's application, A's application must generate an SDP offer\. An SDP offer contains information about the session A's application wants to establish, including what codecs to use, whether this is an audio or video session, etc\. It also contains a list of ICE candidates, which are the IP and port pairs that B's application can attempt to use to connect to A\.

To build the list of ICE candidates, A's application makes a series of requests to a STUN server\. The server returns the public IP address and port pair that originated the request\. A's application adds each pair to the list of ICE candidates, in other words, it gathers ICE candidates\. Once A's application has finished gathering ICE candidates, it can return an SDP\.

Next, A's application must pass the SDP to B's application through a signaling channel over which these applications communicate\. The transport protocol for this exchange is not specified in the WebRTC standard\. It can be performed over HTTPS, secure WebSocket, or any other communication protocol\.

Now, B's application must generate an SDP answer\. B's application follows the same steps A used in the previous step: gathers ICE candidates, etc\. B's application then needs to return this SDP answer to A's application\.

After A and B have exchanged SDPs, they then perform a series of connectivity checks\. The ICE algorithm in each application takes a candidate IP/port pair from the list it received in the other party's SDP, and sends it a STUN request\. If a response comes back from the other application, the originating application considers the check successful and marks that IP/port pair as a valid ICE candidate\.

After connectivity checks are finished on all of the IP/port pairs, the applications negotiate and decide to use one of the remaining, valid pairs\. When a pair is selected, media begins flowing between the application\. 

If either of the applications can't find an IP/port pair that passes connectivity checks, they'll make STUN requests to the TURN server to obtain a media relay address\. A relay address is a public IP address and port that forwards packets received to and from the application to set up the relay address\. This relay address is then added to the candidate list and exchanged via the signaling channel\.

## Kinesis Video Streams with WebRTC Components<a name="how-kvswebrtc-works"></a>

Kinesis Video Streams with WebRTC includes the following components:
+ **Control plane**

  The control plane component is responsible for creating and maintaining the Kinesis Video Streams with WebRTC signaling channels\. For more information, see the [Amazon Kinesis Video Streams API Reference](https://docs.aws.amazon.com/kinesisvideostreams/latest/dg/API_Operations_Amazon_Kinesis_Video_Streams.html)\.
+ **Signaling**

  The signaling component manages the WebRTC signaling endpoints that allow applications to securely connect with each other for peer\-to\-peer live media streaming\. The signaling component includes the [Amazon Kinesis Video Signaling REST APIs](https://docs.aws.amazon.com/kinesisvideostreams/latest/dg/API_Operations_Amazon_Kinesis_Video_Signaling.html) and a set of [Websocket APIs](https://docs.aws.amazon.com/kinesisvideostreams-webrtc-dg/latest/devguide/kvswebrtc-websocket-apis.html)\.
+ **STUN**

  This component manages STUN endpoints that enable applications to discover their public IP address when they are located behind a NAT or a firewall\.
+ **TURN**

  This component manages TURN endpoints that enable media relay via the cloud when applications can't stream media peer\-to\-peer\.
+ **Kinesis Video Streams WebRTC SDKs**

  These are software libraries that you can download, install, and configure on your devices and application clients to enable your camera IoT devices with WebRTC capabilities to engage in low latency peer\-to\-peer media streaming\. These SDKs also enable Android, iOS, and web application clients to integrate Kinesis Video Streams with WebRTC signaling, TURN, and STUN capabilities with any WebRTC\-compliant mobile or web players\.
  + [WebRTC SDK in C for Embedded Devices](kvswebrtc-sdk-c.md)
  + [WebRTC SDK in JavaScript for Web Applications](kvswebrtc-sdk-js.md)
  + [WebRTC SDK for Android](kvswebrtc-sdk-android.md)
  + [WebRTC SDK for iOS](kvswebrtc-sdk-ios.md)