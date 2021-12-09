# Monitoring Kinesis Video Streams with WebRTC Metrics with CloudWatch<a name="kvswebrtc-monitoring-cw"></a>

You can monitor a Kinesis Video Streams with WebRTC using Amazon CloudWatch, which collects and processes raw data from Kinesis Video Streams with WebRTC into readable, near real\-time metrics\. These statistics are recorded for a period of 15 months, so that you can access historical information and gain a better perspective on how your web application or service is performing\. 

Kinesis Video Streams provides the following metrics:

**Topics**
+ [Signaling Metrics](#kvswebrtc-monitoring-cw-signaling)
+ [TURN Metrics](#kvswebrtc-monitoring-cw-turn)

## Signaling Metrics<a name="kvswebrtc-monitoring-cw-signaling"></a>


****  

| Metric name | Dimensions | Unit | Description | 
| --- | --- | --- | --- | 
| Failure | Operation, SignalingChannelName | Count | '0' is emitted if the Operation mentioned in dimension returns 200 status code response\. '1' otherwise\. | 
| Latency | Operation, SignalingChannelName | Milliseconds | The time measured from when the service receives the request until the service returns the response\. | 
| MessagesTransferred\.Count | SignalingChannelName | Count | Total number of messages transferred \(sent and received\) for a given channel\. | 

The `Operation` dimension can apply to any of the following APIs:
+ ConnectAsMaster
+ ConnectAsViewer
+ SendSdpOffer
+ SendSdpAnswer
+ SendCandidate
+ SendAlexaOfferToMaster
+ GetIceServerConfig
+ Disconnect

## TURN Metrics<a name="kvswebrtc-monitoring-cw-turn"></a>


****  

| Metric name | Dimensions | Unit | Description | 
| --- | --- | --- | --- | 
| TURNConnectedMinutes | SignalingChannelName | Count | '1' is emitted for each TURN allocation that is used to stream data through in a minute\. | 