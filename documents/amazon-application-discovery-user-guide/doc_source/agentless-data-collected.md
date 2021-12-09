# Data Collected by the Discovery Connector<a name="agentless-data-collected"></a>

The Discovery Connector collects information about your VMware vCenter Server hosts and VMs\. However, you can capture this data only if VMware vCenter Server tools are installed\. To make sure the AWS account you are using has the required permission for this task, see [AWS Managed \(Predefined\) Policies for Application Discovery Service](security-iam-managed-policies.md)\. 

Following, you can find an inventory of the information collected by the Discovery Connector\.

**Table legend for Discovery Connector collected data:**
+ Collected data is in measurements of kilobytes \(KB\) unless stated otherwise\.
+ Equivalent data in the Migration Hub console is reported in megabytes \(MB\)\.
+ Data fields denoted with an asterisk \(\*\) are only available in the \.csv files produced from the connector's API export function\.
+ The polling period is in intervals of approximately 60 minutes\.
+ Data fields denoted with a double asterisk \(\*\*\) currently return a *null* value\.


| Data field | Description | 
| --- | --- | 
| applicationConfigurationId\* | ID of the migration application the VM is grouped under | 
| avgCpuUsagePct | Average percentage of CPU usage over polling period | 
| avgDiskBytesReadPerSecond | Average number of bytes read from disk over polling period | 
| avgDiskBytesWrittenPerSecond | Average number of bytes written to disk over polling period | 
| avgDiskReadOpsPerSecond\*\* | Average number of read I/O operations per second null | 
| avgDiskWriteOpsPerSecond\*\* | Average number of write I/O operations per second | 
| avgFreeRAM | Average free RAM expressed in MB | 
| avgNetworkBytesReadPerSecond | Average amount of throughput of bytes read per second | 
| avgNetworkBytesWrittenPerSecond | Average amount of throughput of bytes written per second | 
| configId | Application Discovery Service assigned ID to the discovered VM | 
| configType | Type of resource discovered | 
| connectorId | ID of the Discovery Connector virtual appliance | 
| cpuType | vCPU for a VM, actual model for a host | 
| datacenterId | ID of the vCenter | 
| hostId\* | ID of the VM host | 
| hostName | Name of host running the virtualization software | 
| hypervisor | Type of hypervisor | 
| id | ID of server | 
| lastModifiedTimeStamp\* | Latest date and time of data collection before data export | 
| macAddress | MAC address of the VM | 
| manufacturer | Maker of the virtualization software | 
| maxCpuUsagePct  | Max\. percentage of CPU usage during polling period | 
| maxDiskBytesReadPerSecond | Max\. number of bytes read from disk over polling period | 
| maxDiskBytesWrittenPerSecond | Max\. number of bytes written to disk over polling period | 
| maxDiskReadOpsPerSecond\*\* | Max\. number of read I/O operations per second | 
| maxDiskWriteOpsPerSecond\*\* | Max\. number of write I/O operations per second | 
| maxNetworkBytesReadPerSecond | Max\. amount of throughput of bytes read per second | 
| maxNetworkBytesWrittenPerSecond | Max\. amount of throughput of bytes written per second | 
| memoryReservation\* | Limit to avoid overcommitment of memory on VM | 
| moRefId | Unique vCenter Managed Object Reference ID | 
| name\* | Name of VM or network \(user specified\) | 
| numCores | Number of independent processing units within CPU | 
| numCpus | Number of central processing units on VM | 
| numDisks\*\* | Number of disks on VM | 
| numNetworkCards\*\* | Number of network cards on VM | 
| osName | Operating system name on VM | 
| osVersion | Operating system version on VM | 
| portGroupId\* | ID of group of member ports of VLAN | 
| portGroupName\* | Name of group of member ports of VLAN | 
| powerState\* | Status of power | 
| serverId | Application Discovery Service assigned ID to the discovered VM | 
| smBiosId\* | ID/version of the system management BIOS | 
| state\* | Status of the Discovery Connector virtual appliance | 
| tagKey | User\-defined key to store custom data or metadata about servers | 
| tagValue | User\-defined value to further define a key's custom data or metadata about servers | 
| toolsStatus | Operational state of VMware tools \(See [Viewing and Sorting Data Collectors](data_collection.md#sort-data-collectors) for a complete list\.\) | 
| totalDiskSize | Total capacity of disk expressed in MB | 
| totalRAM | Total amount of RAM available on VM in MB | 
| type | Type of host | 
| vCenterId | Unique ID number of a VM | 
| vCenterName\* | Name of the vCenter host | 
| virtualSwitchName\* | Name of the virtual switch | 
| vmFolderPath | Directory path of VM files | 
| vmName | Name of the virtual machine | 