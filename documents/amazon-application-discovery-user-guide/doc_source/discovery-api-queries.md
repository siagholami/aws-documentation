# Querying Discovered Configuration Items<a name="discovery-api-queries"></a>

A *configuration item* is an IT asset that was discovered in your data center by an agent or the connector\. When you use Application Discovery Service, you can specify filters and query specific configuration items for server, application, process, and connection assets\. 

The tables in the following sections list the available input filters and output sorting options for two Application Discovery Service actions:
+  `DescribeConfigurations`
+  `ListConfigurations`

The filtering and sorting options are organized by the type of asset to which apply \(server, application, process, or connection\)\.

## Using the `DescribeConfigurations`Action<a name="DescribeConfigurations"></a>

The `DescribeConfigurations`action retrieves attributes for a list of configuration IDs\. All the supplied IDs must be for the same asset type \(server, application, process, or connection\)\. Output fields are specific to the asset type selected\. For example, the output for a server configuration item includes a list of attributes about the server, such as host name, operating system, and number of network cards\. For more information about command syntax, see [DescribeConfigurations](https://docs.aws.amazon.com/application-discovery/latest/APIReference/API_DescribeConfigurations.html)\.

The `DescribeConfigurations`action does not support filtering\.

**Output fields for `DescribeConfigurations`**  
The following tables, organized by asset type, list the supported output fields of the `DescribeConfigurations`action\. The ones marked as mandatory are always present in the output\.

**Server assets**


| Field | Mandatory | 
| --- | --- | 
| server\.agentId |  | 
| server\.applications |  | 
| server\.applications\.hasMoreValues |  | 
| server\.configurationId | x | 
| server\.cpuType |  | 
| server\.hostName |  | 
| server\.hypervisor |  | 
| server\.networkInterfaceInfo |  | 
| server\.networkInterfaceInfo\.hasMoreValues |  | 
| server\.osName |  | 
| server\.osVersion |  | 
| server\.tags |  | 
| server\.tags\.hasMoreValues |  | 
| server\.timeOfCreation | x | 
| server\.type |  | 
| server\.performance\.avgCpuUsagePct |  | 
| server\.performance\.avgDiskReadIOPS |  | 
| server\.performance\.avgDiskReadsPerSecondInKB |  | 
| server\.performance\.avgDiskWriteIOPS |  | 
| server\.performance\.avgDiskWritesPerSecondInKB |  | 
| server\.performance\.avgFreeRAMInKB |  | 
| server\.performance\.avgNetworkReadsPerSecondInKB |  | 
| server\.performance\.avgNetworkWritesPerSecondInKB |  | 
| server\.performance\.maxCpuUsagePct |  | 
| server\.performance\.maxDiskReadIOPS |  | 
| server\.performance\.maxDiskReadsPerSecondInKB |  | 
| server\.performance\.maxDiskWriteIOPS |  | 
| server\.performance\.maxDiskWritesPerSecondInKB |  | 
| server\.performance\.maxNetworkReadsPerSecondInKB |  | 
| server\.performance\.maxNetworkWritesPerSecondInKB |  | 
| server\.performance\.minFreeRAMInKB |  | 
| server\.performance\.numCores |  | 
| server\.performance\.numCpus |  | 
| server\.performance\.numDisks |  | 
| server\.performance\.numNetworkCards |  | 
| server\.performance\.totalRAMInKB |  | 

**Process assets**


| Field | Mandatory | 
| --- | --- | 
| process\.commandLine |  | 
| process\.configurationId | x | 
| process\.name |  | 
| process\.path |  | 
| process\.timeOfCreation | x | 

**Application assets**


| Field | Mandatory | 
| --- | --- | 
| application\.configurationId | x | 
| application\.description |  | 
| application\.lastModifiedTime | x | 
| application\.name | x | 
| application\.serverCount | x | 
| application\.timeOfCreation | x | 

## Using the `ListConfigurations`Action<a name="ListConfigurations"></a>

The `ListConfigurations`action retrieves a list of configuration items according to the criteria that you specify in a filter\. For more information about command syntax, see [ListConfigurations](https://docs.aws.amazon.com/application-discovery/latest/APIReference/API_ListConfigurations.html)\.
<a name="ListConfigurations_output"></a>
**Output fields for `ListConfigurations`**  
The following tables, organized by asset type, list the supported output fields of the `ListConfigurations`action\. The ones marked as mandatory are always present in the output\.

 **Server assets**


| Field | Mandatory | 
| --- | --- | 
| server\.configurationId | x | 
| server\.agentId |  | 
| server\.hostName |  | 
| server\.osName |  | 
| server\.osVersion |  | 
| server\.timeOfCreation | x | 
| server\.type |  | 

**Process assets**


| Field | Mandatory | 
| --- | --- | 
| process\.commandLine |  | 
| process\.configurationId | x | 
| process\.name |  | 
| process\.path |  | 
| process\.timeOfCreation | x | 
| server\.agentId |  | 
| server\.configurationId | x | 

**Application assets**


| Field | Mandatory | 
| --- | --- | 
| application\.configurationId | x | 
| application\.description |  | 
| application\.name | x | 
| application\.serverCount | x | 
| application\.timeOfCreation | x | 
| application\.lastModifiedTime | x | 

**Connection assets**


| Field | Mandatory | 
| --- | --- | 
| connection\.destinationIp | x | 
| connection\.destinationPort | x | 
| connection\.ipVersion | x | 
| connection\.latestTimestamp | x | 
| connection\.occurrence | x | 
| connection\.sourceIp | x | 
| connection\.transportProtocol |  | 
| destinationProcess\.configurationId |  | 
| destinationProcess\.name |  | 
| destinationServer\.configurationId |  | 
| destinationServer\.hostName |  | 
| sourceProcess\.configurationId |  | 
| sourceProcess\.name |  | 
| sourceServer\.configurationId |  | 
| sourceServer\.hostName |  | 
<a name="ListConfigurations_filters"></a>
**Supported filters for `ListConfigurations`**  
The following tables, organized by asset type, list the supported filters for the `ListConfigurations`action\. Filters and values are in a key/value relationship defined by one of the supported logical conditions\. You can sort the output of the indicated filters\.

**Server assets**


|  Filter  |  Supported conditions  |  Supported values  |  Supported sorting  | 
| --- | --- | --- | --- | 
| server\.configurationId |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | None | 
| server\.hostName |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | 
| server\.osName |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | 
| server\.osVersion |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | 
| server\.agentId |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | None | 
| server\.connectorId |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | None | 
| server\.type |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | String with one of the following values:[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html) | None | 
| server\.vmWareInfo\.morefId |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | None | 
| server\.vmWareInfo\.vcenterId |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | None | 
| server\.vmWareInfo\.hostId |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | None | 
| server\.networkInterfaceInfo\.portGroupId |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | None | 
| server\.networkInterfaceInfo\.portGroupName |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | None | 
| server\.networkInterfaceInfo\.virtualSwitchName |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | None | 
| server\.networkInterfaceInfo\.ipAddress |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | None | 
| server\.networkInterfaceInfo\.macAddress |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | None | 
| server\.performance\.avgCpuUsagePct |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | None | 
| server\.performance\.totalDiskFreeSizeInKB |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | None | 
| server\.performance\.avgFreeRAMInKB |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | None | 
| server\.tag\.value |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | None | 
| server\.tag\.key |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | None | 
| server\.application\.name |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | None | 
| server\.application\.description |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | None | 
| server\.application\.configurationId |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | None | 
| server\.process\.configurationId |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | None | 
| `server.process.name` |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | None | 
| server\.process\.commandLine |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | None | 

**Application assets**


|  Filter  |  Supported conditions  |  Supported values  |  Supported sorting  | 
| --- | --- | --- | --- | 
| application\.configurationId |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | None | 
| application\.name |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | 
| application\.description |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | 
| application\.serverCount | Filtering not supported\. | Filtering not supported\. |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | 
| application\.timeOfCreation | Filtering not supported\. | Filtering not supported\. |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | 
| application\.lastModifiedTime | Filtering not supported\. | Filtering not supported |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | 
| server\.configurationId |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | None | 

**Process assets**


|  Filter  |  Supported conditions  |  Supported values  |  Supported sorting  | 
| --- | --- | --- | --- | 
| process\.configurationId |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |   | 
| process\.name |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | 
| process\.commandLine |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | 
| server\.configurationId |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  | 
| server\.hostName |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | 
| server\.osName |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | 
| server\.osVersion |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | 
| server\.agentId |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  | 

**Connection assets**


|  Filter  |  Supported conditions  |  Supported values  |  Supported sorting  | 
| --- | --- | --- | --- | 
| connection\.sourceIp |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | 
| connection\.destinationIp |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | 
| connection\.destinationPort |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | 
| sourceServer\.configurationId |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  | 
| sourceServer\.hostName |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | 
| destinationServer\.osName |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | 
| destinationServer\.osVersion |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | 
| destinationServer\.agentId |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  | 
| sourceProcess\.configurationId |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  | 
| sourceProcess\.name |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | 
| sourceProcess\.commandLine |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | 
| destinationProcess\.configurationId |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  | 
| destinationProcess\.name |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | 
| destinationprocess\.commandLine |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html)  | 