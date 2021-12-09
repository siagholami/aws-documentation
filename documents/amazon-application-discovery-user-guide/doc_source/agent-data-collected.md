# Data Collected by the Discovery Agent<a name="agent-data-collected"></a>

Following, you can find an inventory of the information collected by the Discovery Agent\.

**Table legend for Discovery Agent collected data:**
+ The term host refers to either a physical server or a VM\.
+ Collected data is in measurements of kilobytes \(KB\) unless stated otherwise\.
+ Equivalent data in the Migration Hub console is reported in megabytes \(MB\)\.
+ Data fields denoted with an asterisk \(\*\) are only available in the `.csv` files produced from the agent's API export function\.
+ The polling period is in intervals of approximately 15 minutes\.


| Data field | Description | 
| --- | --- | 
| agentAssignedProcessId\* | Process ID of processes discovered by the agent | 
| agentId | Unique ID of agent | 
| agentProvidedTimeStamp\* | Date and time of agent observation \(mm/dd/yyyy hh:mm:ss am/pm\) | 
| cmdLine\* | Process entered at the command line | 
| cpuType  | Type of CPU \(central processing unit\) used in host | 
| destinationIp\* | IP address of device to which packet is being sent | 
| destinationPort\* | Port number to which the data/request is to be sent | 
| family\* | Protocol of routing family | 
| freeRAM \(MB\)  | Free RAM and cached RAM that can be made immediately available to applications, measured in MB | 
| gateway\* | Node address of network | 
| hostName | Name of host data was collected on | 
| hypervisor | Type of hypervisor | 
| ipAddress | IP address of the host | 
| ipVersion\* | IP version number | 
| isSystem\* | Boolean attribute to indicate if a process is owned by the OS | 
| macAddress  | MAC address of the host | 
| name\* | Name of the host, network, metrics, etc\. data is being collected for | 
| netMask\* | IP address prefix that a network host belongs to | 
| osName  | Operating system name on host | 
| osVersion | Operating system version on host | 
| path | Path of the command sourced from the command line | 
| sourceIp\* | IP address of the device sending the IP packet  | 
| sourcePort\* | Port number from which the data/request originates from | 
| timestamp\* | Date and time of reported attribute logged by agent | 
| totalCpuUsagePct  | Percentage of CPU usage on host during polling period | 
| totalDiskBytesReadPerSecond \(Kbps\) | Total amount of disk free space on host | 
| totalDiskBytesWrittenPerSecond \(Kbps\) | Total size of disk on host  | 
| totalDiskFreeSize \(GB\) | Free disk space expressed in GB | 
| totalDiskReadOpsPerSecond | Total number of read I/O operations per second | 
| totalDiskSize \(GB\) | Total capacity of disk expressed in GB | 
| totalDiskWriteOpsPerSecond | Total number of write I/O operations per second | 
| totalNetworkBytesReadPerSecond \(Kbps\) | Total amount of throughput of bytes read per second | 
| totalNetworkBytesWrittenPerSecond \(Kbps\) | Total amount of throughput of bytes written per second | 
| totalNumCores | Total number of independent processing units within CPU | 
| totalNumCpus | Total number of central processing units | 
| totalNumDisks | The number of physical hard disks on a host | 
| totalNumLogicalProcessors\* | Total number of physical cores times the number of threads that can run on each core | 
| totalNumNetworkCards | Total count of network cards on server | 
| totalRAM \(MB\) | Total amount of RAM available on host | 
| transportProtocol\* | Type of transport protocol used | 