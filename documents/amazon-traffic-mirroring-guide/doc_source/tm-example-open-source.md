# Working with Open\-Source Tools for Traffic Mirroring<a name="tm-example-open-source"></a>

You can use open\-source tools to monitor network traffic from Amazon EC2 instances\. The following tools work with Traffic Mirroring:
+ **Zeek** — For more information, see the [Zeek Network Monitor Security website](https://www.zeek.org/)\.
+ **Suricata** — For more information see the [Suricata website](https://suricata-ids.org/)\.

These open\-source tools support VXLAN decapsulation, and they can be used at scale to monitor VPC traffic\. For information about how Zeek handles VXLAN support and to download the code, see [Zeek vxlan](https://github.com/zeek/zeek/tree/master/src/analyzer/protocol/vxlan) on the GitHub website\. For information about how Suricata handles VXLAN support and to download the code, see [Suricata](https://github.com/OISF/suricata) on the GitHub website\.

The following example uses the Suricata open\-source tool\. You can follow similar steps for Zeek\.

Consider the scenario where you want to mirror inbound TCP traffic on an instance and send the traffic to an instance that has the Suricata software installed\. You need the following traffic mirror entities for this example:
+ An EC2 instance with the Suricata software installed on it
+ A traffic mirror target for the EC2 instance \(Target A\)
+ A traffic mirror filter with a traffic mirror rule for the TCP inbound traffic \(Filter rule 1\)
+ A traffic mirror session that has the following:
  + A traffic mirror source
  + A traffic mirror target for the appliance
  + A traffic mirror filter with a traffic mirror rule for the TCP inbound traffic

## Step 1: Install the Suricata Software on the EC2 Instance Target<a name="tm-example-open-source-install-software"></a>

Launch an EC2 instance, and then install the Suricata software on it by using the following commands\.

```
# Become sudo
sudo -s
# Install epel-release
amazon-linux-extras install -y epel
# Install suricata
yum install -y suricata
# Create the default suricata rules directory
mkdir /var/lib/suricata/rules
# Add a rule to match all UDP traffic
echo 'alert udp any any -> any any (msg:"UDP traffic detected"; sid:200001; rev:1;)' > /var/lib/suricata/rules/suricata.rules
# Start suricata listening on eth0 in daemon mode
suricata -c /etc/suricata/suricata.yaml -k none -i eth0 -D

# Capture logs can be found in /var/log/suricata/fast.log
```

## Step 2: Create a Traffic Mirror Target<a name="tm-example-open-source-step-create-target"></a>

Create a traffic mirror target \(Target A\) for the EC2 instance\. Depending on your configuration, the target is one of the following types:
+ The network interface of the monitoring appliance
+ The Network Load Balancer when the appliance is deployed behind one\.

For more information, see [Create a Traffic Mirror Target](traffic-mirroring-target.md#create-traffic-mirroring-target)\.

## Step 3: Create a Traffic Mirror Filter<a name="tm-example-open-source-step-create-filter"></a>

Create a traffic mirror filter \(Filter 1\) with the following inbound rule\. For more information, see [Create a Traffic Mirror Filter](traffic-mirroring-filter.md#create-traffic-mirroring-filter)\.


**Traffic Mirror Filter Rule for Inbound TCP Traffic**  

| Option | Value | 
| --- | --- | 
| Rule action | Accept | 
| Protocol | TCP | 
| Source port range |  | 
| Destination port range |  | 
| Source CIDR block | 0\.0\.0\.0/0 | 
| Destination CIDR block | 0\.0\.0\.0/0 | 
| Description | TCP Rule | 

## Step 4: Create a Traffic Mirror Session<a name="tm-example-open-source-step-create-session"></a>

Create and configure a traffic mirror session with the following options\. For more information, see [Create a Traffic Mirror Session](traffic-mirroring-session.md#create-traffic-mirroring-session)\.


**Traffic Mirror Session to Monitor Inbound TCP Traffic**  

| Option | Value | 
| --- | --- | 
| Mirror source | The network interface of the instance that you want to monitor\. | 
| Mirror target | Target A | 
| Filter | Filter 1 | 