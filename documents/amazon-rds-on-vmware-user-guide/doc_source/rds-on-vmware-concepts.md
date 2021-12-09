# Terminology<a name="rds-on-vmware-concepts"></a>

Using Amazon RDS on VMware requires an understanding of VMware terminology and of terminology that is specific to Amazon RDS on VMware\.

## VMware Terminology<a name="rds-on-vmware-concepts.vmware"></a>

This guide uses VMware terminology, such as data center, cluster, and resource pools\. For information about VMware terminology, see the [VMware vSphere Documentation](https://docs.vmware.com/en/VMware-vSphere/index.html)\.

## Amazon RDS on VMware Terminology<a name="rds-on-vmware-concepts.rdsonvmare"></a>

This guide uses the following Amazon RDS on VMware terminology\.

**Topics**
+ [Custom Availability Zones](#custom-azs)
+ [RDS Edge Router](#rds-edge-router)
+ [RDS Connector](#rds-connector)
+ [RDS Cluster Control Network](#rds-cluster-control-network)
+ [Application Network](#rds-application-network)
+ [VPN Originator IP](#vpn-originator-ip)

### Custom Availability Zones<a name="custom-azs"></a>

Each AWS Region is a separate geographic area\. Each AWS Region has multiple, isolated locations known as Availability Zones \(AZs\)\. For more information, see [Regions and Availability Zones](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/Concepts.RegionsAndAvailabilityZones.html) in the *Amazon RDS User Guide*\.

A *custom Availability Zone \(custom AZ\)* is an on\-premises AZ that is integrated with your vSphere cluster\. Custom AZs are similar to Amazon RDS AZs, but each custom AZ is limited to a specific VMware environment\.

### RDS Edge Router<a name="rds-edge-router"></a>

The *RDS Edge Router* is a software package that you install in your network\. It's configured as a router between the public internet, the ESXi Host network \(the Management Network\), and the Cluster Control Network\. It also acts as an authoritative Domain Name Service \(DNS\) server and Dynamic Host Configuration Protocol \(DHCP\) server for the RDS Cluster Control Network\. In addition, it establishes an outbound VPN connection to a single\-tenant DMZ or demilitarized zone \(sometimes referred to as a perimeter network or screened subnet\) in AWS\. This DMZ is specific to your deployment\.

### RDS Connector<a name="rds-connector"></a>

The *RDS Connector* is a software package that is installed on the on\-premises vSphere environment\. It manages the interaction between various software components so that the on\-premises environment can interact with the on\-premises databases\.

### RDS Cluster Control Network<a name="rds-cluster-control-network"></a>

The *RDS Cluster Control Network* controls and monitors traffic for Amazon RDS on VMware\. All Amazon RDS on VMware components and database instances have one interface on this network\.

This network is analogous to the network that Amazon RDS uses to manage your databases\. It's similar to a virtual private cloud \(VPC\) based on the Amazon Virtual Private Cloud \(Amazon VPC\) service, but in your environment\. All the DB instances are managed by control virtual machines \(VMs\)\. Some of the VMs are built by AWS and some are built by VMware\. Each Amazon RDS on VMware VM and DB instance has one interface on this network\.

### Application Network<a name="rds-application-network"></a>

The *Application Network* is the network that your applications use to interact with the DB instances that you provision on Amazon RDS on VMware\.

### VPN Originator IP<a name="vpn-originator-ip"></a>

The *VPN originator IP* is an external IP address for outgoing traffic from the vSphere cluster to the Amazon RDS website\. This external IP address is used during the configuration of a vSphere cluster\. Amazon RDS on VMware uses the VPN originator IP address at that point to create a VPN tunnel between the vSphere cluster and the Amazon RDS website\.