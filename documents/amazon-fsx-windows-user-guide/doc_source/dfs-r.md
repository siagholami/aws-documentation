# You Can't Configure DFS\-R on a Multi\-AZ or Single\-AZ 2 File System<a name="dfs-r"></a>

Microsoft Distributed File System Replication \(DFS\-R\) is not supported on Multi\-AZ and Single\-AZ 2 file systems\.

**Potential Cause**  
Multi\-AZ file systems are configured for redundancy across multiple access zones natively, and do not support DFS\-R\.

**Resolution**  
Use the Multi\-AZ deployment type for high availability across multiple Availability Zones\. For more information, see [Availability and Durability: Single\-AZ and Multi\-AZ File Systems](high-availability-multiAZ.md)\.