# Requirements<a name="Requirements"></a>

Unless otherwise noted, the following requirements are common to all gateway configurations\.

**Topics**
+ [Hardware and storage requirements](#requirements-hardware-storage)
+ [Network and firewall requirements](#networks)
+ [Supported hypervisors and host requirements](#requirements-host)
+ [Supported NFS clients for a file gateway](#requirements-nfs-clients)
+ [Supported SMB clients for a file gateway](#requirements-smb-versions)
+ [Supported file system operations for a file gateway](#requirements-file-operations)
+ [Supported iSCSI initiators](#requirements-iscsi-initiators)
+ [Supported third\-party backup applications for a Tape Gateway](#requirements-backup-sw-for-vtl)

## Hardware and storage requirements<a name="requirements-hardware-storage"></a>

In this section, you can find information about the minimum hardware and settings for your gateway and the minimum amount of disk space to allocate for the required storage\. For information about best practices for file gateway performance, see [Performance Guidance for File Gateways](Performance.md#performance-fgw)\.

### Hardware requirements for on\-premises VMs<a name="requirements-hardware"></a>

When deploying your gateway on\-premises, you must make sure that the underlying hardware on which you deploy the gateway VM can dedicate the following minimum resources:
+ Four virtual processors assigned to the VM\.
+ 16 GiB of reserved RAM assigned to the VM\.
+ 80 GiB of disk space for installation of VM image and system data\.

For more information, see [Optimizing Gateway Performance](Performance.md#Optimizing-common)\. For information about how your hardware affects the performance of the gateway VM, see [AWS Storage Gateway quotas](resource-gateway-limits.md)\. 

### Requirements for Amazon EC2 instance types<a name="requirements-hardware-ec2"></a>

When deploying your gateway on Amazon Elastic Compute Cloud \(Amazon EC2\), the instance size must be at least **xlarge** for your gateway to function\. However, for the compute\-optimized instance family the size must be at least **2xlarge**\. Use one of the following instance types recommended for your gateway type\.

**Recommended for file gateway types**
+ General\-purpose instance family – m4 or m5 instance type\.
+ Compute\-optimized instance family – c4 or c5 instance types\. Choose the **2xlarge** instance size or higher to meet the required RAM requirements\.
+ Memory\-optimized instance family – r3 instance types\.
+ Storage\-optimized instance family – i3 instance types\.
**Note**  
When you launch your gateway in Amazon EC2, and the instance type you select supports ephemeral storage, the disks are listed automatically\. For more information about Amazon EC2 instance storage, see [Instance storage](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/InstanceStorage.html) in the *Amazon EC2 User Guide\.*   
Application writes are stored in the cache synchronously, and then asynchronously uploaded to durable storage in Amazon S3\. If the ephemeral storage is lost because an instance stops before the upload is complete, then the data that still resides in cache and has not yet written to S3 can be lost\. Before you stop the instance that hosts the gateway make sure the CachePercentDirty CloudWatch metric is `0`\. For information about ephemeral storage, see [Using Ephemeral Storage With EC2 Gateways](ManagingLocalStorage-common.md#ephemeral-disk-cache)\. For more information about monitoring metrics for your storage gateway, see [Monitoring Storage Gateway](Main_monitoring-gateways-common.md)\.  
If you have more than 5 million objects in your S3 bucket and you are using a General Purposes SSD volume, a minimum root EBS volume of 350 GiB is needed for acceptable performance of your gateway during start up\. For information about how to increase your volume size, see [Modifying an EBS volume using elastic volumes \(console\)](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/requesting-ebs-volume-modifications.html#modify-ebs-volume)\.

**Recommended for cached volumes and tape gateway types**
+ General\-purpose instance family – m4 or m5 instance types\. We don't recommend using the **m4\.16xlarge** instance type\.
+ Compute\-optimized instance family – c4 or c5 instance types\. Choose the **2xlarge** instance size or higher to meet the required RAM requirements\.
+ Storage\-optimized instance family – d2, i2, or i3 instance types\.

### <a name="appliance-hardware-requirements"></a>

### Storage requirements<a name="requirements-storage"></a>

In addition to 80 GiB disk space for the VM, you also need additional disks for your gateway\.

The following table recommends sizes for local disk storage for your deployed gateway\. 


| Gateway Type | Cache \(Minimum\) | Cache \(Maximum\) | Upload Buffer \(Minimum\) | Upload Buffer \(Maximum\) | Other Required Local Disks | 
| --- | --- | --- | --- | --- | --- | 
| File gateway | 150 GiB | 64 TiB | — | — | — | 
| Cached volume gateway | 150 GiB | 16 TiB | 150 GiB |  2 TiB  | — | 
| Stored volume gateway | — | — | 150 GiB |  2 TiB  | 1 or more for stored volume or volumes | 
| Tape gateway | 150 GiB | 16 TiB | 150 GiB | 2 TiB | — | 

**Note**  
You can configure one or more local drives for your cache and upload buffer, up to the maximum capacity\.  
When adding cache or upload buffer to an existing gateway, it's important to create new disks in your host \(hypervisor or Amazon EC2 instance\)\. Don't change the size of existing disks if the disks have been previously allocated as either a cache or upload buffer\.

For information about gateway quotas, see [AWS Storage Gateway quotas](resource-gateway-limits.md)\.

## Network and firewall requirements<a name="networks"></a>

Your gateway requires access to the internet, local networks, Domain Name Service \(DNS\) servers, firewalls, routers, and so on\. Following, you can find information about required ports and how to allow access through firewalls and routers\.

**Note**  
In some cases, you might deploy AWS Storage Gateway on Amazon EC2 or use other types of deployment \(including on\-premises\) with network security policies that restrict AWS IP address ranges\. In these cases, your gateway might experience service connectivity issues when the AWS IP range values changes\. The AWS IP address range values that you need to use are in the Amazon service subset for the AWS Region that you activate your gateway in\. For the current IP range values, see [AWS IP address ranges](https://docs.aws.amazon.com/general/latest/gr/aws-ip-ranges.html) in the *AWS General Reference*\.

**Topics**
+ [Port requirements](#requirements-network)
+ [Networking and firewall requirements for the AWS Storage Gateway Hardware Appliance](#appliance-network-requirements)
+ [Allowing AWS Storage Gateway access through firewalls and routers](#allow-firewall-gateway-access)
+ [Configuring security groups for your Amazon EC2 gateway instance](#EC2GatewayCustomSecurityGroup-common)

### Port requirements<a name="requirements-network"></a>

AWS Storage Gateway requires certain ports to be allowed for its operation\. The following illustrations show the required ports that you must allow for each type of gateway\. Some ports are required by all gateway types, and others are required by specific gateway types\. For more information about port requirements, see [Port Requirements](Resource_Ports.md)\.

**Common ports for all gateway types**

The following ports are common to all gateway types and are required by all gateway types\.


|  Protocol  |  Port  |  Direction  |  Source  |  Destination  |  How Used  | 
| --- | --- | --- | --- | --- | --- | 
|  TCP  |  443 \(HTTPS\)  |  Outbound  |  Storage Gateway  |  AWS  |  For communication from AWS Storage Gateway to the AWS service endpoint\. For information about service endpoints, see [Allowing AWS Storage Gateway access through firewalls and routers](#allow-firewall-gateway-access)\.  | 
|  TCP  |  80 \(HTTP\)  |  Inbound  |  The host from which you connect to the AWS Management Console\.  |  Storage Gateway  |  By local systems to obtain the storage gateway activation key\. Port 80 is only used during activation of the Storage Gateway appliance\.  AWS Storage Gateway does not require port 80 to be publicly accessible\. The required level of access to port 80 depends on your network configuration\. If you activate your gateway from the AWS Storage Gateway Management Console, the host from which you connect to the console must have access to your gateway’s port 80\.  | 
|  UDP/UDP  |  53 \(DNS\)  |  Outbound  |  Storage Gateway  |  Domain Name Service \(DNS\) server  |  For communication between AWS Storage Gateway and the DNS server\.  | 
|  TCP  |  22 \(Support channel\)  |  Outbound  |  Storage Gateway  |  AWS Support  |  Allows AWS Support to access your gateway to help you with troubleshooting gateway issues\. You don't need this port open for the normal operation of your gateway, but it is required for troubleshooting\.  | 
|  UDP  |  123 \(NTP\)  |  Outbound  |  NTP client  |  NTP server  |  Used by local systems to synchronize VM time to the host time\.   | 

**Ports for file gateways**

The following illustration shows the ports to open for a file gateway\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/storagegateway/latest/userguide/images/File-Gateway-Port-Diagram.png)

**Note**  
For specific port requirements \(including NFS and SMB port requirements\), see [Port Requirements](Resource_Ports.md)\.

You only need to use Microsoft Active Directory when you want to allow domain users to access an Server Message Block \(SMB\) file share\. You can join your file gateway to any valid Microsoft Windows domain \(resolvable by DNS\)\.

You can also use the AWS Directory Service to create an [AWS managed Microsoft Active Directory](https://docs.aws.amazon.com/directoryservice/latest/admin-guide/directory_microsoft_ad.html) in the AWS Cloud\. For most AWS\-managed Active Directory deployments, you need to configure the Dynamic Host Configuration Protocol \(DHCP\) service for your VPC\. For more information about how to create a DHCP options set, see [Create a DHCP options set](https://docs.aws.amazon.com/directoryservice/latest/admin-guide/dhcp_options_set.html)\.

In addition to the common ports, file gateways require the following ports\. 


|  Protocol  |  Port  |  Direction  |  Source  |  Destination  |  How Used  | 
| --- | --- | --- | --- | --- | --- | 
|  TCP/UDP  |  2049 \(NFS\)  |  Inbound  |  NFS Clients  |  Storage Gateway  |  For local systems to connect to NFS shares that your gateway exposes\.  | 
|  TCP/UDP  |  111 \(NFSv3\)  |  Inbound  |  NFSv3 client  |  Storage Gateway  |  For local systems to connect to the port mapper that your gateway exposes\.  This port is needed only for NFSv3\.  | 
|  TCP/UDP  |  20048 \(NFSv3\)  |  Inbound  |  NFSv3 client  |  Storage Gateway  |  For local systems to connect to mounts that your gateway exposes\.  This port is needed only for NFSv3\.  | 

**Ports for volume and tape gateways**

The following illustration shows the ports to open for volume and tape gateways\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/storagegateway/latest/userguide/images/SGWNetworkPorts16-volume-tape2.png)

In addition to the common ports, volume and tape gateways require the following port\.


|  Protocol  |  Port  |  Direction  |  Source  |  Destination  |  How Used  | 
| --- | --- | --- | --- | --- | --- | 
|  TCP  |  3260 \(iSCSI\)  |  Inbound  |  iSCSI Initiators  |  Storage Gateway  |  By local systems to connect to iSCSI targets exposed by the gateway\.   | 

For detailed information about port requirements, see [Port Requirements](Resource_Ports.md) in the *Additional AWS Storage Gateway resources* section\.

### Networking and firewall requirements for the AWS Storage Gateway Hardware Appliance<a name="appliance-network-requirements"></a>

Each AWS Storage Gateway Hardware Appliance requires the following network services:
+ **Internet access** – an always\-on network connection to the internet through any network interface on the server\.
+ **DNS services** – DNS services for communication between the hardware appliance and DNS server\.
+ **Time synchronization** – an automatically configured Amazon NTP time service must be reachable\.
+ **IP address** – A DHCP or static IPv4 address assigned\. You cannot assign an IPv6 address\.

There are five physical network ports at the rear of the Dell PowerEdge R640 server\. From left to right \(facing the back of the server\) these ports are as follows:

1. iDRAC

1. `em1`

1. `em2`

1. `em3`

1. `em4`

You can use the iDRAC port for remote server management\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/storagegateway/latest/userguide/images/ApplianceFirewallRules.png)

A hardware appliance requires the following ports to operate\.


|  Protocol  |  Port  |  Direction  |  Source  |  Destination  |  How Used  | 
| --- | --- | --- | --- | --- | --- | 
| SSH |  22  |  Outbound  | Hardware appliance |  `54.201.223.107`  | Support channel | 
| DNS | 53 | Outbound | Hardware appliance | DNS servers | Name resolution | 
| UDP/NTP | 123 | Outbound | Hardware appliance | \*\.amazon\.pool\.ntp\.org | Time synchronization | 
| HTTPS |  443  |  Outbound  | Hardware appliance |  `*.amazonaws.com`  |  Data transfer  | 
| HTTP | 8080 | Inbound | AWS | Hardware appliance | Activation \(only briefly\) | 

To perform as designed, a hardware appliance requires network and firewall settings as follows:
+ Configure all connected network interfaces in the hardware console\.
+ Make sure that each network interface is on a unique subnet\.
+ Provide all connected network interfaces with outbound access to the endpoints listed in the diagram preceding\.
+ Configure at least one network interface to support the hardware appliance\. For more information, see [Configuring Network Parameters](appliance-configure-network.md)\.

**Note**  
For an illustration showing the back of the server with its ports, see [Rack\-Mounting Your Hardware Appliance and Connecting It to Power](appliance-rack-mount.md)

All IP addresses on the same network interface \(NIC\), whether for a gateway or a host, must be on the same subnet\. The following illustration shows the addressing scheme\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/storagegateway/latest/userguide/images/ApplianceAddressing.png)

For more information on activating and configuring a hardware appliance, see [Using the AWS Storage Gateway Hardware Appliance](HardwareAppliance.md)\.

### Allowing AWS Storage Gateway access through firewalls and routers<a name="allow-firewall-gateway-access"></a>

Your gateway requires access to the following service endpoints to communicate with AWS\. If you use a firewall or router to filter or limit network traffic, you must configure your firewall and router to allow these service endpoints for outbound communication to AWS\.

**Important**  
Depending on your gateway's AWS Region, replace *region* in the service endpoint with the correct region string\.

The following service endpoints are required by all gateways for control path \(anon\-cp, client\-cp, proxy\-app\) and data path \(dp\-1\) operations\.

```
anon-cp.storagegateway.region.amazonaws.com:443
client-cp.storagegateway.region.amazonaws.com:443
proxy-app.storagegateway.region.amazonaws.com:443
dp-1.storagegateway.region.amazonaws.com:443
```

The following gateway service endpoint is required to make API calls\.

```
storagegateway.region.amazonaws.com:443
```

The following example is a gateway service endpoint in the US West \(Oregon\) Region \(`us-west-2`\)\.

```
storagegateway.us-west-2.amazonaws.com:443
```

The Amazon S3 service endpoint, shown following, is used by file gateways only\. A file gateway requires this endpoint to access the S3 bucket that a file share maps to\.

```
s3.region.amazonaws.com
```

The following example is an S3 service endpoint in the US East \(Ohio\) Region \(`us-east-2`\)\.

```
s3.us-east-2.amazonaws.com
```

**Note**  
If your gateway can't determine the AWS Region where your S3 bucket is located, this service endpoint defaults to `s3.us-east-1.amazonaws.com`\. We recommend that you allow access to the US East \(N\. Virginia\) Region \(`us-east-1`\) in addition to AWS Regions where your gateway is activated, and where your S3 bucket is located\.

The following are S3 service endpoints for AWS GovCloud \(US\) Regions\.

```
s3-fips-us-gov-west-1.amazonaws.com (AWS GovCloud (US-West) Region (FIPS))
s3-fips.us-gov-east-1.amazonaws.com (AWS GovCloud (US-East) Region (FIPS))
s3.us-gov-west-1.amazonaws.com (AWS GovCloud (US-West) Region (Standard))
s3.us-gov-east-1.amazonaws.com (AWS GovCloud (US-East) Region (Standard))
```

The following example is a FIPS service endpoint for an S3 bucket in the AWS GovCloud \(US\-West\) Region\.

```
bucket-name.s3-fips-us-gov-west-1.amazonaws.com
```

The Amazon CloudFront endpoint following is required for Storage Gateway to get the list of available AWS Regions\.

```
https://d4kdq0yaxexbo.cloudfront.net/
```

A Storage Gateway VM is configured to use the following NTP servers\.

```
0.amazon.pool.ntp.org
1.amazon.pool.ntp.org
2.amazon.pool.ntp.org
3.amazon.pool.ntp.org
```
+ Storage Gateway—For supported AWS Regions and a list of AWS service endpoints you can use with Storage Gateway, see [AWS Storage Gateway endpoints and quotas](https://docs.aws.amazon.com/general/latest/gr/sg.html) in the *AWS General Reference*\.
+ AWS Storage Gateway Hardware Appliance—For supported AWS Regions you can use with the hardware appliance see [AWS Storage Gateway hardware appliance regions](https://docs.aws.amazon.com/general/latest/gr/sg.html#sg-hardware-appliance) in the *AWS General Reference*\.

### Configuring security groups for your Amazon EC2 gateway instance<a name="EC2GatewayCustomSecurityGroup-common"></a>

A security group controls traffic to your Amazon EC2 gateway instance\. When you configure a security group, we recommend the following:
+ The security group should not allow incoming connections from the outside internet\. It should allow only instances within the gateway security group to communicate with the gateway\. If you need to allow instances to connect to the gateway from outside its security group, we recommend that you allow connections only on ports 3260 \(for iSCSI connections\) and 80 \(for activation\)\.
+ If you want to activate your gateway from an Amazon EC2 host outside the gateway security group, allow incoming connections on port 80 from the IP address of that host\. If you cannot determine the activating host's IP address, you can open port 80, activate your gateway, and then close access on port 80 after completing activation\.
+ Allow port 22 access only if you are using AWS Support for troubleshooting purposes\. For more information, see [You want AWS Support to help troubleshoot your EC2 gateway](troubleshooting-EC2-gateway-issues.md#EC2-EnableAWSSupportAccess)\.

In some cases, you might use an Amazon EC2 instance as an initiator \(that is, to connect to iSCSI targets on a gateway that you deployed on Amazon EC2\. In such a case, we recommend a two\-step approach:

1. You should launch the initiator instance in the same security group as your gateway\.

1. You should configure access so the initiator can communicate with your gateway\.

For information about the ports to open for your gateway, see [Port Requirements](Resource_Ports.md)\.

## Supported hypervisors and host requirements<a name="requirements-host"></a>

You can run Storage Gateway on\-premises as either a virtual machine \(VM\) appliance, or a physical hardware appliance, or in AWS as an Amazon EC2 instance\.

Storage Gateway supports the following hypervisor versions and hosts:
+ VMware ESXi Hypervisor \(version 6\.0, 6\.5 or 6\.7\) – A free version of VMware is available on the [VMware website](http://www.vmware.com/products/vsphere-hypervisor/overview.html)\. For this setup, you also need a VMware vSphere client to connect to the host\.
+  Microsoft Hyper\-V Hypervisor \(version 2012 R2 or 2016\) – A free, standalone version of Hyper\-V is available at the [Microsoft Download Center](http://www.microsoft.com/en-us/search/Results.aspx?q=hyper-V&form=DLC)\. For this setup, you need a Microsoft Hyper\-V Manager on a Microsoft Windows client computer to connect to the host\.
+ Linux Kernel\-based Virtual Machine \(KVM\) – A free, open\-source virtualization technology\. KVM is included in all versions of Linux version 2\.6\.20 and newer\. Storage Gateway is tested and supported for the CentOS/RHEL 7\.7, Ubuntu 16\.04 LTS, and Ubuntu 18\.04 LTS distributions\. Any other modern Linux distribution may work, but function or performance is not guaranteed\. We recommend this option if you already have a KVM environment up and running and you are already familiar with how KVM works\.
+ Amazon EC2 instance – Storage Gateway provides an Amazon Machine Image \(AMI\) that contains the gateway VM image\. Only file, cached volume, and tape gateway types can be deployed on Amazon EC2\. For information about how to deploy a gateway on Amazon EC2, see [Deploying a Volume or Tape Gateway on an Amazon EC2 Host](ec2-gateway-common.md)\.
+ Storage Gateway Hardware Appliance – Storage Gateway provides a physical hardware appliance as a on\-premises deployment option for locations with limited virtual machine infrastructure\.

**Note**  
Storage Gateway doesn’t support recovering a gateway from a VM that was created from a snapshot or clone of another gateway VM or from your Amazon EC2 AMI\. If your gateway VM malfunctions, activate a new gateway and recover your data to that gateway\. For more information, see [Recovering from an unexpected virtual machine shutdown](recover-data-from-gateway.md#recover-from-gateway-shutdown)\.  
Storage Gateway doesn’t support dynamic memory and virtual memory ballooning\.

## Supported NFS clients for a file gateway<a name="requirements-nfs-clients"></a>

File gateways support the following Network File System \(NFS\) clients:
+ Amazon Linux
+ Mac OS X
+ RHEL 7
+ SUSE Linux Enterprise Server 11 and SUSE Linux Enterprise Server 12
+ Ubuntu 14\.04
+ Microsoft Windows 10 Enterprise, Windows Server 2012, and Windows Server 2016\. Native clients only support NFS version 3\.
+ Windows 7 Enterprise and Windows Server 2008\.

  Native clients only support NFS v3\. The maximum supported NFS I/O size is 32 KB, so you might experience degraded performance on these versions of Windows\.
**Note**  
You can now use SMB file shares when access is required through Windows \(SMB\) clients instead of using Windows NFS clients\.

## Supported SMB clients for a file gateway<a name="requirements-smb-versions"></a>

File gateways support the following Service Message Block \(SMB\) clients:
+ Microsoft Windows Server 2003 and later
+ Windows desktop versions: 10, 8, and 7\.
+  Windows Terminal Server running on Windows Server 2003 and later

## Supported file system operations for a file gateway<a name="requirements-file-operations"></a>

Your NFS or SMB client can write, read, delete, and truncate files\. When clients send writes to AWS Storage Gateway, it writes to local Cache synchronously\. Then it writes to S3 asynchronously through optimized transfers\. Reads are first served through the local cache\. If data is not available, it's fetched through S3 as a read\-through cache\.

Writes and reads are optimized in that only the parts that are changed or requested are transferred through your gateway\. Deletes remove objects from S3\. Directories are managed as folder objects in S3, using the same syntax as in the Amazon S3 Management Console\.

 HTTP operations such as `GET`, `PUT`, `UPDATE`, and `DELETE` can modify files in a file share\. These operations conform to the atomic create, read, update, and delete \(CRUD\) functions\.

## Supported iSCSI initiators<a name="requirements-iscsi-initiators"></a>

When you deploy a cached volume or stored volume gateway, you can create iSCSI storage volumes on your gateway\. When you deploy a tape gateway, the gateway is preconfigured with one media changer and 10 tape drives\. These tape drives and the media changer are available to your existing client backup applications as iSCSI devices\.

To connect to these iSCSI devices, Storage Gateway supports the following iSCSI initiators:
+ Windows Server 2012 and Windows Server 2012 R2
+ Windows Server 2008 and Windows Server 2008 R2
+ Windows 7
+  Red Hat Enterprise Linux 5
+  Red Hat Enterprise Linux 6
+  Red Hat Enterprise Linux 7
+  VMware ESX Initiator, which provides an alternative to using initiators in the guest operating systems of your VMs

**Important**  
Storage Gateway doesn't support Microsoft Multipath I/O \(MPIO\) from Windows clients\.  
Storage Gateway supports connecting multiple hosts to the same volume if the hosts coordinate access by using Windows Server Failover Clustering \(WSFC\)\. However, you can't connect multiple hosts to that same volume \(for example, sharing a nonclustered NTFS/ext4 file system\) without using WSFC\.

## Supported third\-party backup applications for a Tape Gateway<a name="requirements-backup-sw-for-vtl"></a>

You use a backup application to read, write, and manage tapes with a tape gateway\. The following third\-party backup applications are supported to work with tape gateways\.

The type of medium changer you choose depends on the backup application you plan to use\. The following table lists third\-party backup applications that have been tested and found to be compatible with tape gateways\. This table includes the medium changer type recommended for each backup application\.


| Backup Application | Medium Changer Type | 
| --- | --- | 
| Arcserve Backup | AWS\-Gateway\-VTL | 
| Bacula Enterprise V10\.x | AWS\-Gateway\-VTL or STK\-L700 | 
| Commvault V11 | STK\-L700 | 
| Dell EMC NetWorker V8\.x or V9\.x | AWS\-Gateway\-VTL | 
| IBM Spectrum Protect v7\.x | IBM\-03584L32\-0402 | 
| Micro Focus \(HPE\) Data Protector 9\.x | AWS\-Gateway\-VTL | 
| Microsoft System Center 2012 R2 or 2016 Data Protection Manager | STK\-L700 | 
| NovaStor DataCenter/Network 6\.4 or 7\.1 | STK\-L700 | 
| Quest NetVault Backup 10\.0 or 11\.x or 12\.x | STK\-L700 | 
| Veeam Backup & Replication V7 or V8 | STK\-L700 | 
| Veeam Backup & Replication V9 Update 2 or later | AWS\-Gateway\-VTL | 
| Veritas Backup Exec 2014 or 15 or 16 or 20\.x | AWS\-Gateway\-VTL | 
| Veritas Backup Exec 2012 Veritas has ended support for Backup Exec 2012\.  | STK\-L700 | 
| Veritas NetBackup Version 7\.x or 8\.x | AWS\-Gateway\-VTL | 

**Important**  
We highly recommend that you choose the medium changer that's listed for your backup application\. Other medium changers might not function properly\. You can choose a different medium changer after the gateway is activated\. For more information, see [Selecting a Medium Changer After Gateway Activation](resource_vtl-devices.md#change-mediumchanger-vtl)\.