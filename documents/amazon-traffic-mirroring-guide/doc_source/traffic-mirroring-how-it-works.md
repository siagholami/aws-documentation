# How Traffic Mirroring Works<a name="traffic-mirroring-how-it-works"></a>

Traffic Mirroring copies inbound and outbound traffic from the network interfaces that are attached to your Amazon EC2 instances\. You can send the mirrored traffic to the network interface of another EC2 instance, or a Network Load Balancer that has a UDP listener\. The traffic mirror source and the traffic mirror target \(monitoring appliance\) can be in the same VPC\. Or they can be in a different VPC connected via intra\-Region VPC peering or a transit gateway\.

Consider the following scenario, where you want to mirror traffic from two sources \(Source A and Source B\) to a single traffic mirror target \(Target D\)\. The following procedures are required:
+ Identify the traffic mirror source \(Source A\)
+ Identify the traffic mirror source \(Source B\)
+ Configure the traffic mirror target \(Target D\)
+ Configure the traffic mirror filter \(Filter A\)
+ Configure the traffic mirror session for Source A, Filter A, and Target D
+ Configure the traffic mirror session for Source B, Filter A, and Target D

 After you create the traffic mirror session, any traffic that matches the filter rules is encapsulated in a VXLAN header\. It is then sent to the target\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/vpc/latest/mirroring/images/traffic-mirroring.png)

**Topics**
+ [Traffic Mirror Targets](traffic-mirroring-targets.md)
+ [Traffic Mirror Filters and Filter Rules](traffic-mirroring-filters.md)
+ [Traffic Mirror Sessions](traffic-mirroring-sessions.md)
+ [Traffic Mirroring and VPC Flow Logs](flow-log.md)
+ [Traffic Mirror Source and Target Connectivity Options](traffic-mirroring-connection.md)
+ [Traffic Mirroring Packet Format](traffic-mirroring-packet-formats.md)
+ [Traffic Mirroring Authentication and Access Control](traffic-mirroring-security.md)