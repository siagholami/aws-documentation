# Traffic Mirror Targets<a name="traffic-mirroring-targets"></a>

A *traffic mirror target* is the destination for mirrored traffic\. The traffic mirror target can be owned by an AWS account that is different from the traffic mirror source\.

Use any of the following resources for a traffic mirror target:
+ A network interface
+ A Network Load Balancer

A traffic mirror target can be used in more than one traffic mirror session\. Make sure to allow VXLAN traffic \(UDP port 4789\) from the traffic mirror source in the security groups that are associated with the traffic mirror target\.

## Traffic Mirror Target Options<a name="traffic-mirroring-targets-options"></a>

You can either use open\-source tools or choose a monitoring solution available on [AWS Marketplace](https://aws.amazon.com/marketplace/)\. You can stream replicated traffic to any network packet collector or analytics tool, without having to install vendor\-specific agents\. 

## Network Load Balancer Considerations<a name="traffic-mirroring-targets-nlb"></a>

When the traffic mirror target is a Network Load Balancer, the following rules apply:
+ There must be UDP listeners on port 4789\.
+ If all of the Network Load Balancer traffic mirror targets in an Availability Zone become unhealthy, the mirrored traffic can still be sent to traffic mirror targets in other zones\. In this case, enable cross\-zone load balancing to allow the Network Load Balancer to forward the mirrored traffic to a healthy target in another zone\.