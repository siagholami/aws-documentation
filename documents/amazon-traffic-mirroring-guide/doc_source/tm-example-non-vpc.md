# Example: Mirror Non\-Local VPC Traffic<a name="tm-example-non-vpc"></a>

Consider the scenario where you want to monitor traffic leaving your VPC or traffic whose source is outside your VPC\. In this case, you will mirror all traffic except traffic passing within your VPC and send it to a single monitoring appliance\. You need the following traffic mirror resources: 
+ A traffic mirror target for the appliance \(Target A\)
+ A traffic mirror filter that has two sets of rules for outbound and inbound traffic\. For outbound traffic, it will reject all packets which have a destination IP in the VPC CIDR block and accept all other outbound packets\. For inbound traffic, it will reject all packets which have a source IP in the VPC CIDR block and accept all other inbound packets\.
+ A traffic mirror session that has the following:
  + A traffic mirror source
  + A traffic mirror target for the appliance \(Target A\)
  + A traffic mirror filter with a traffic mirror rule for the TCP inbound traffic \(Filter F\)

In this example, the VPC CIDR block is 10\.0\.0\.0/16\.

## Step 1: Create a Traffic Mirror Target<a name="step-create-target-non-vpc"></a>

Create a traffic mirror target \(Target A\) for the monitoring appliance\. Depending on your configuration, the target is one of the following types:
+ The network interface of the monitoring appliance
+ The Network Load Balancer when the appliance is deployed behind one

For more information, see [Create a Traffic Mirror Target](traffic-mirroring-target.md#create-traffic-mirroring-target)\.

## Step 2: Create a Traffic Mirror Filter<a name="step-create-filter-non-vpc"></a>

Create a traffic mirror filter \(Filter F\) that has the following rules\. For more information, see [Create a Traffic Mirror Filter](traffic-mirroring-filter.md#create-traffic-mirroring-filter)\.

### Outbound Traffic Mirror Filter Rules<a name="outbound-rules"></a>

Create the following outbound rules:
+ Reject all outbound packets which have a destination IP in the VPC CIDR block
+ Accept all other outbound packets \(destination CIDR block 0\.0\.0\.0/0\)


| Option | Value | 
| --- | --- | 
| Rule number | 10 | 
| Rule action | Reject | 
| Protocol | All | 
| Source port range |  | 
| Destination port range |  | 
| Source CIDR block | 0\.0\.0\.0/0 | 
| Destination CIDR block | 10\.0\.0\.0/16 | 
| Description | Reject all intra\-VPC traffic | 


| Option | Value | 
| --- | --- | 
| Rule number | 20 | 
| Rule action | Accept | 
| Protocol | All | 
| Source port range |  | 
| Destination port range |  | 
| Source CIDR block | 0\.0\.0\.0/0 | 
| Destination CIDR block | 0\.0\.0\.0/0 | 
| Description | Accept all outbound traffic | 

### Inbound Traffic Mirror Filter Rules<a name="inbound-rules"></a>

Create the following inbound rules:
+ Reject all inbound packets which have a source IP in the VPC CIDR block
+ Accept all other inbound packets \(source CIDR block 0\.0\.0\.0/0\)


| Option | Value | 
| --- | --- | 
| Rule number | 10 | 
| Rule action | Reject | 
| Protocol | All | 
| Source port range |  | 
| Destination port range |  | 
| Source CIDR block | 10\.0\.0\.0/16 | 
| Destination CIDR block | 0\.0\.0\.0/0 | 
| Description | Reject all intra\-VPC traffic | 


| Option | Value | 
| --- | --- | 
| Rule number | 20 | 
| Rule action | Accept | 
| Protocol | All | 
| Source port range |  | 
| Destination port range |  | 
| Source CIDR block | 0\.0\.0\.0/0 | 
| Destination CIDR block | 0\.0\.0\.0/0 | 
| Description | Accept all inbound traffic | 

## Step 3: Create a Traffic Mirror Session<a name="step-create-session-non-vpc"></a>

Create and configure a traffic mirror session with the following options\. For more information, see [Create a Traffic Mirror Session](traffic-mirroring-session.md#create-traffic-mirroring-session)\.


**Traffic Mirror Session to Monitor Inbound TCP Traffic**  

| Option | Value | 
| --- | --- | 
| Mirror source | The network interface of the instance that you want to monitor\. | 
| Mirror target | Target A | 
| Filter | Filter F | 
