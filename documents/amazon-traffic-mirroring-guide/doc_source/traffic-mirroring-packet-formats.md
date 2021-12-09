# Traffic Mirroring Packet Format<a name="traffic-mirroring-packet-formats"></a>

Mirrored traffic is encapsulated with a VXLAN header\. All appliances that receive traffic directly with this feature should be able parse a VXLAN\-encapsulated packet\. For more information about the VXLAN protocol, see [RFC 7348](https://tools.ietf.org/html/rfc7348)\.

The following fields apply to Traffic Mirroring:
+ **VXLAN ID** — The virtual network ID that you can assign to a traffic mirror session\. If you do not assign a value, we assign a random value that is unique to all sessions in the account\.
+ **Source IP address** — The primary IP address of the source network interface\. 
+ **Destination IP address** — The primary IP address of the appliance, or the Network Load Balancer when the appliance is deployed behind one\. 