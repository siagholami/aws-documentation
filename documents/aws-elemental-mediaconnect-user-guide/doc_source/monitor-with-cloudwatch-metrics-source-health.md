# AWS Elemental MediaConnect metrics to monitor source health<a name="monitor-with-cloudwatch-metrics-source-health"></a>

AWS Elemental MediaConnect sends metrics to CloudWatch\. You can review specific metrics to evaluate the health of the source of your flow\. If the flow is unhealthy, these metrics can help you determine whether the issue originates with the source\. For details about each metric, see the tables in this section\.

**Note**  
Metrics tracked by MediaConnect adhere to the standard as defined by the TR 101 290 spec\.

**Topics**
+ [Network metrics](#monitor-with-cloudwatch-metrics-source-health-network)
+ [TR 101 290 Priority 1 metrics](#monitor-with-cloudwatch-metrics-source-health-p1)
+ [TR 101 290 Priority 2 metrics](#monitor-with-cloudwatch-metrics-source-health-p2)
+ [Source metrics](#monitor-with-cloudwatch-metrics-source-health-source)

## Network metrics<a name="monitor-with-cloudwatch-metrics-source-health-network"></a>

The following table lists network metrics that AWS Elemental MediaConnect sends to CloudWatch\.


| Metric | Description | 
| --- | --- | 
| ARQRecovered |  The number of dropped packets that were recovered by automatic repeat request \(ARQ\)\. This metric applies only to sources that use the RIST protocol or the Zixi protocol\. It doesn't apply to flows that receive content from an entitlement\. Units: Count Valid dimensions:  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediaconnect/latest/ug/monitor-with-cloudwatch-metrics-source-health.html)  | 
| ARQRequests |  The number of retransmitted packets that were requested through automatic repeat request \(ARQ\) and received\. This metric applies only to sources that use the RIST protocol or the Zixi protocol\. It doesn't apply to flows that receive content from an entitlement\. Units: Count Valid dimensions:  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediaconnect/latest/ug/monitor-with-cloudwatch-metrics-source-health.html)  | 
| Connected |  The status of the source\. A value of one indicates that the source is connected and a value of zero indicates that the source is disconnected\. This metric applies only to sources that use the Zixi protocol\. Units: None Valid dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediaconnect/latest/ug/monitor-with-cloudwatch-metrics-source-health.html)  | 
| Disconnections |  The number of times that the source status changed from connected to disconnected\. Units: Count Valid dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediaconnect/latest/ug/monitor-with-cloudwatch-metrics-source-health.html)  | 
| DroppedPackets |  The number of packets that were lost during transit\. This value is measured before any error correction takes place\. Units: Count Valid dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediaconnect/latest/ug/monitor-with-cloudwatch-metrics-source-health.html)  | 
| FECPackets |  The number of packets that were transmitted using forward error correction \(FEC\) and received\. This metric applies only to sources that use the RTP\-FEC protocol or the Zixi protocol\. It doesn't apply to flows that receive content from an entitlement\. Units: Count Valid dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediaconnect/latest/ug/monitor-with-cloudwatch-metrics-source-health.html)  | 
| FECRecovered |  The number of packets that were transmitted using forward error correction \(FEC\), lost during transit, and recovered\. This metric applies only to sources that use the RTP\-FEC protocol or the Zixi protocol\. It doesn't apply to flows that receive content from an entitlement\. Units: Count Valid dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediaconnect/latest/ug/monitor-with-cloudwatch-metrics-source-health.html)  | 
| NotRecoveredPackets |  The number of packets that were lost during transit and were not recovered by error correction\. Units: Count Valid dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediaconnect/latest/ug/monitor-with-cloudwatch-metrics-source-health.html)  | 
| OverflowPackets |  The number of packets that were lost in transit because the video required more buffer than was available\. This metric doesn't apply to flows that receive content from an entitlement\. Units: Count Valid dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediaconnect/latest/ug/monitor-with-cloudwatch-metrics-source-health.html)  | 
| PacketLossPercent |  The percentage of packets that were lost during transit, even if they were recovered\. Units: Percent Valid dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediaconnect/latest/ug/monitor-with-cloudwatch-metrics-source-health.html)  | 
| RecoveredPackets |  The number of packets that were lost during transit, but recovered\. Units: Counter Valid dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediaconnect/latest/ug/monitor-with-cloudwatch-metrics-source-health.html)  | 
| RoundTripTime |  The amount of time it takes for the source to send a signal and receive an acknowledgment from AWS Elemental MediaConnect\. This metric applies only to sources that use the Zixi protocol\. It doesn't apply to flows that receive content from an entitlement\. Units: Milliseconds Valid dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediaconnect/latest/ug/monitor-with-cloudwatch-metrics-source-health.html)  | 
| TotalPackets |  The total number of packets that were received\. Units: Count Valid dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediaconnect/latest/ug/monitor-with-cloudwatch-metrics-source-health.html)  | 

## TR 101 290 Priority 1 metrics<a name="monitor-with-cloudwatch-metrics-source-health-p1"></a>

The following table lists TR 101 290 Priority 1 metrics that AWS Elemental MediaConnect sends to CloudWatch\.


| Metric | Description | 
| --- | --- | 
| ContinuityCounter |  The number of times that a continuity error occurred\. This error indicates an incorrect packet order or lost packets\. Units: Count Valid dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediaconnect/latest/ug/monitor-with-cloudwatch-metrics-source-health.html)  | 
| PATError |  The number of times that a program association table \(PAT\) error occurred\. This error indicates that the PAT is missing\. The PAT lists the programs that are available in a transport stream and points to the program map tables \(PMTs\)\. The decoder needs the PAT to do its job\. Units: Count Valid dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediaconnect/latest/ug/monitor-with-cloudwatch-metrics-source-health.html)  | 
| PIDError |  The number of times that a packet identifier \(PID\) error occurred\. This error indicates that a PID is missing its associated data stream\. The PIDs are identifiers that provide the location of the video, audio, and data streams\. This error can occur after the transport stream \(TS\) has been multiplexed and then remultiplexed\. Units: Count Valid dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediaconnect/latest/ug/monitor-with-cloudwatch-metrics-source-health.html)  | 
| PMTError |  The number of times that a program map table \(PMT\) error occurred\. This error happens when the PMT is not received at least every 500 milliseconds \(ms\)\. Each PMT contains a list of PIDs, which help decoders reassemble data\. The decoder needs the PMTs to do its job\. Units: Count Valid dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediaconnect/latest/ug/monitor-with-cloudwatch-metrics-source-health.html)  | 
| TSByteError |  The number of times that a transport stream \(TS\) byte error occurred\. This error indicates that the sync byte did not appear after the prescribed number of bytes\. Units: Count Valid dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediaconnect/latest/ug/monitor-with-cloudwatch-metrics-source-health.html)  | 
| TSSyncLoss |  The number of times that a TS sync loss error occurred\. This error happens after two or more consecutive TS byte errors\. Units: Count Valid dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediaconnect/latest/ug/monitor-with-cloudwatch-metrics-source-health.html)  | 

## TR 101 290 Priority 2 metrics<a name="monitor-with-cloudwatch-metrics-source-health-p2"></a>

The following table lists TR 101 290 Priority 2 metrics that AWS Elemental MediaConnect sends to CloudWatch\.


| Metric | Description | 
| --- | --- | 
| CATError |  The number of times that a conditional access table \(CAT\) error occurred\. This error indicates that the CAT is not present\. The CAT tells the integrated receiver decoder \(IRD\) where to find management messages for the conditional access \(CA\) systems that are in use\. Units: Count Valid dimensions:  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediaconnect/latest/ug/monitor-with-cloudwatch-metrics-source-health.html)  | 
| CRCError |  The number of times that a cyclic redundancy check \(CRC\) error occurred\. This error happens when a CRC determines that data is corrupted\. Units: Count Valid dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediaconnect/latest/ug/monitor-with-cloudwatch-metrics-source-health.html)  | 
| PCRAccuracyError |  The number of times that a program clock register \(PCR\) accuracy error occurred\. This error happens when the value of the transmitted PCR differs from what is expected by more than 500 nanoseconds \(ns\)\. When a stream is encoded, the encoder assigns periodic PCR values of the encoder's program clock\. The decoder relies on these values to ensure that the stream is kept in sync\. Units: Count Valid dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediaconnect/latest/ug/monitor-with-cloudwatch-metrics-source-health.html)  | 
| PCRError |  The number of times that a PCR error occurred\. This error happens when PCR values are not sent frequently enough\. The service relies on consistent, frequent PCRs to reset the local 27 MHz system clock\. Although the error occurs when the interval exceeds 100 milliseconds \(ms\), best practices dictate that PCRs should be received at least every 40 ms\.  Units: Count Valid dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediaconnect/latest/ug/monitor-with-cloudwatch-metrics-source-health.html)  | 
| PTSError |  The number of times that a presentation timestamp \(PTS\) error occurred\. This error happens when a presentation timestamp \(PTS\) is not received at least every 700 ms\. This can occur if the PTS is sent less frequently or not at all\. The most common cause of this error is when the transport stream is scrambled\. Units: Count Valid dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediaconnect/latest/ug/monitor-with-cloudwatch-metrics-source-health.html)  | 
| TransportError |  The number of times that a primary transport error occurred\. This error indicates that the TS packet is unusable\. When this error occurs, ignore all other TR 101 290 errors for this packet\. Units: Count Valid dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediaconnect/latest/ug/monitor-with-cloudwatch-metrics-source-health.html)  | 

## Source metrics<a name="monitor-with-cloudwatch-metrics-source-health-source"></a>

The following table lists source metrics that AWS Elemental MediaConnect sends to CloudWatch\.


| Metric | Description | 
| --- | --- | 
| SourceBitRate |  The bitrate of the incoming \(source\) video\. Units: bits per second \(b/s\) Valid dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediaconnect/latest/ug/monitor-with-cloudwatch-metrics-source-health.html)  | 