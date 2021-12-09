# Best practices for AWS Elemental MediaConnect<a name="best-practices"></a>

For the best performance and availability, follow best practices when you configure your AWS Elemental MediaConnect flows\.

## Performance<a name="best-practices-performance"></a>
+ AWS Elemental MediaConnect is designed to work with mezzanine quality live video and has been tested with bitrates up to 120 megabits per second \(Mb/s\)\. 
+ AWS Elemental MediaConnect is designed to work with an aggregate output bandwidth of 400 Mb/s\. The *aggregate output bandwidth* is calculated by multiplying the bitrate of the source by the number of outputs\. For example, if your flow has a source with a bitrate of 80 Mb/s and 5 outputs, the aggregate output bandwidth is 400 Mb/s\. Likewise, a flow that has a source with a bitrate of 20 Mb/s and sends content to 20 outputs also has an aggregate output bandwidth of 400 Mb/s\.

## Availability<a name="best-practices-availability"></a>
+ To minimize packet loss, use Forward Error Correction \(FEC\) or automatic repeat request \(ARQ\) based protocols such as the Zixi or RTP\-FEC protocol\. These [protocols](protocols.md) are designed to minimize packet loss between the source and destination devices\.
+ Because packet loss is present on any network, even in fully managed networks such as the AWS Cloud, you should create and manage redundant connections throughout your workflows\. In MediaConnect, there are multiple ways to add redundancy to your workflow:
  + Create flows in at least two different Availability Zones\.
  + [Add a second source](source-adding.md) to each flow\. If there are errors in the stream, MediaConnect can use packets from a redundant source or switch to the redundant source completely\.

## Reliability<a name="best-practices-reliability"></a>
+ Set up Amazon CloudWatch metrics and alarms to track the health of your source\. For information about which metrics to monitor, see [Monitoring and tagging](monitor.md)\.

## Security<a name="best-practices-security"></a>
+ The CIDR block on the flow source should be as precise as possible\. Include only the IP addresses that you want to contribute content to your flow\. If the CIDR block is too wide, it allows for the possibility of outside parties sending content to your flow\.