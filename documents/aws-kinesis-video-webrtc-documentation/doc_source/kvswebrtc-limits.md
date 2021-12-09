# Amazon Kinesis Video Streams with WebRTC Service Quotas<a name="kvswebrtc-limits"></a>

Kinesis Video Streams with WebRTC has the following service quotas:

The service quotas are either soft \[s\], which can be upgraded by submitting a support ticket, or hard \[h\], which can't be increased\.

**Topics**
+ [Control Plane API Service Quotas](#limits-control-plane)
+ [Signaling API Service Quotas](#limits-signaling-service)
+ [TURN Service Quotas](#limits-turn-service)

## Control Plane API Service Quotas<a name="limits-control-plane"></a>

The following section describes service quotas for the control plane APIs\.


**Control Plane API Service Quotas**  

| API | Account service quota: Request | Account service quota: Channels | Channel\-level service quota | Relevant Exceptions and Notes | 
| --- | --- | --- | --- | --- | 
| CreateSignalingChannel | 50 TPS \[s\] | 10000 signaling channels per account \[s\] per region, in all other supported regions\.  |  |  | 
| DescribeSignalingChannel | 300 TPS \[h\] | N/A | 5 TPS \[h\] |  | 
| UpdateSignalingChannel | 50 TPS \[h\] | N/A | 5 TPS \[h\] |  | 
| ListSignalingChannels | 50 TPS \[h\] | N/A |  |  | 
| DeleteSignalingChannel | 50 TPS \[h\] | N/A | 5 TPS \[h\] |  | 
| GetSignalingChannelEndpoint | 300 TPS \[h\] | N/A |  |  | 
| TagResource | 50 TPS \[h\]  | N/A | 5 TPS \[h\] |  | 
| UntagResource | 50 TPS \[h\]  | N/A | 5 TPS \[h\] |  | 
| ListTagsForResource | 50 TPS \[h\]  | N/A | 5 TPS \[h\] |  | 

## Signaling API Service Quotas<a name="limits-signaling-service"></a>

The following section describes service quotas for the signaling component in Kinesis Video Streams with WebRTC\. For more information, see [Kinesis Video Streams with WebRTC: How It Works](kvswebrtc-how-it-works.md)\.
+ ConnectAsMaster
  + API \- 3 TPS per channel \(hard\)
  + Maximum number of master connections per signaling channel \- 1 \(hard\)
  + Connection duration limit \- 1 hour \(hard\)
  + Idle connection timeout \- 10 minutes \(hard\)
  + When a client receives the `GO_AWAY` message from the server, connection is terminated after a grace period of 1 minute \(hard\)
+ ConnectAsViewer
  + API \- 3 TPS per channel \(hard\)
  + Maximum number of viewer connections per channel \- 10 \(soft\)
  + Connection duration limit \- 1 hour \(hard\)
  + Idle connection timeout \- 10 minutes \(hard\)
  + Once a client receives the `GO_AWAY` message from the server, connection is terminated after a grace period of 1 minute \(hard\)
+ SendSDPOffer
  + API: 5 TPS per WebSocket connection \(hard\)
  + Message payload size limit \- 10k \(hard\)
+ SendSDPAnswer
  + API: 5 TPS per WebSocket connection \(hard\)
  + Message payload size limit \- 10k \(hard\)
+ SendICECandidate
  + API: 20 TPS per WebSocket connection \(hard\)
  + Message payload size limit \- 10k \(hard\)
+ SendAlexaOffertoMaster
  + API: 5 TPS per signaling channel \(hard\)
+ GetIceServerConfig
  + API: 5 TPS per signaling channel \(hard\)
+ Disconnect
  + N/A

## TURN Service Quotas<a name="limits-turn-service"></a>

The following section describes service quotas for the Traversal Using Relays around NAT \(TURN\) component in Kinesis Video Streams with WebRTC\. For more information, see [Kinesis Video Streams with WebRTC: How It Works](kvswebrtc-how-it-works.md)\.
+ Bit Rate \- 5Mbps \(hard\)
+ Credential Lifecycle \- 5 minutes \(hard\)
+ Number of allocations \- 50 per signaling channel \(hard\)