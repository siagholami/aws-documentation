# Traffic Mirror Filters and Filter Rules<a name="traffic-mirroring-filters"></a>

A *traffic mirror filter* is a set of inbound and outbound traffic rules that define the traffic that is copied from the traffic mirror source, and sent to the traffic mirror destination\. By default, no traffic is mirrored\. To mirror traffic, add traffic mirror rules to the filter\. The rules that you add define what traffic gets mirrored\. You can also choose to mirror certain network services traffic, including Amazon DNS\. When you add network services traffic, all traffic \(inbound and outbound\) related to that network service is mirrored\. 

## Traffic Mirror Filter Rules<a name="traffic-mirroring-rules"></a>

Traffic mirror filter rules define what traffic gets mirrored\. You can define a set of parameters to apply to the traffic mirror source traffic to determine the traffic to mirror\. The following traffic mirror filter rule parameters are available:
+ Traffic direction: Inbound or outbound
+ Action: The action to take, either to accept or reject the packet
+ Protocol: The L4 protocol
+ Source port range
+ Destination port range
+ Source CIDR block
+ Destination CIDR block