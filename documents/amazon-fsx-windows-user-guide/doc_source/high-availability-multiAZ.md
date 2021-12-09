# Availability and Durability: Single\-AZ and Multi\-AZ File Systems<a name="high-availability-multiAZ"></a>

Amazon FSx for Windows File Server offers two file system deployment types: Single\-AZ and Multi\-AZ\.

## Choosing Single\-AZ or Multi\-AZ File System Deployment<a name="single-or-multi-az"></a>

With Single\-AZ file systems, Amazon FSx automatically replicates your data within an Availability Zone \(AZ\) to protect it from component failure\. It continuously monitors for hardware failures and automatically replaces infrastructure components in the event of a failure\. Amazon FSx also uses the Windows Volume Shadow Copy Service to make highly durable backups of your file system daily and store them in Amazon S3\. You can make additional backups at any point\. *Single\-AZ 2* is the latest generation of Single\-AZ file systems, and it supports both SSD and HDD storage\. *Single\-AZ 1* file systems support SSD storage, Microsoft Distributed File System Replication \(DFSR\), and the use of custom DNS names\.

Multi\-AZ file systems support all the availability and durability features of Single\-AZ file systems\. In addition, they are designed to provide continuous availability to data, even when an Availability Zone is unavailable\. In a Multi\-AZ deployment, Amazon FSx automatically provisions and maintains a standby file server in a different Availability Zone\. Any changes written to disk in your file system are synchronously replicated across Availability Zones to the standby\. With Amazon FSx Multi\-AZ deployments can enhance availability during planned system maintenance, and help protect your data against instance failure and Availability Zone disruption\. If there is planned file system maintenance or unplanned service disruption, Amazon FSx automatically fails over to the secondary file server, allowing you to continue accessing your data without manual intervention\. 

Multi\-AZ file systems are ideal for business\-critical workloads that require high availability to shared Windows file data\. Examples of these include business applications, web serving environments, and Microsoft SQL Server\. Single\-AZ file systems offer a lower price point for workloads that don’t require the high availability of a Multi\-AZ solution and that can recover from the most recent file system backup if data is lost\. Amazon FSx takes automatic daily backups of all file systems by default\.

### Feature Support by Deployment Types<a name="deployment-type-features-summary"></a>

The following table summarizes features supported by the Amazon FSx for Windows File Server file system deployment types:


| Deployment type | SSD storage | HDD storage |  DFS namespaces | DFS replication | Custom DNS name | CA shares | 
| --- | --- | --- | --- | --- | --- | --- | 
| Single\-AZ 1 | ✓  |  | ✓ | ✓ | ✓ |  | 
| Single\-AZ 2 | ✓ | ✓ | ✓ |  | Coming soon | ✓\* | 
| Multi\-AZ | ✓ | ✓ | ✓ |  | Coming soon | ✓\* | 

**Note**  
\* While you can create CA shares on Single\-AZ 2 file systems, you should use CA shares on Multi\-AZ file systems for SQL Server HA deployments\.

## Failover Process for Amazon FSx for Windows File Server<a name="MulitAZ-Failover"></a>

Multi\-AZ file systems automatically fail over from the preferred file server to the standby file server if any of the following conditions occur:
+ An Availability Zone outage occurs\.
+ The preferred file server becomes unavailable\.
+ The preferred file server undergoes planned maintenance\.

 When failing over from one file server to another, the new active file server automatically begins serving all file system read and write requests\. When the resources in the preferred subnet are available, Amazon FSx automatically fails back to the preferred file server in the preferred subnet\. A failover typically completes in less than 30 seconds from the detection of the failure on the active file server to the promotion of the standby file server to active status\. Failback to the original Multi\-AZ configuration also completes in less than 30 seconds, and only occurs once the file server in the preferred subnet is fully recovered\. 

### Failover Experience on Windows Clients<a name="windows-failover"></a>

 When failing over from one file server to another, the new active file server automatically begins serving all file system read and write requests\. After the resources in the preferred subnet are available, Amazon FSx automatically fails back to the preferred file server in the preferred subnet\. Because the file system's DNS name remains the same, failovers are transparent to Windows applications, which resume file system operations without manual intervention\. A failover typically completes in less than 30 seconds from the detection of the failure on the active file server to the promotion of the standby file server to active status\. Failback to the original Multi\-AZ configuration also completes in less than 30 seconds, and only occurs after the file server in the preferred subnet is fully recovered\. 

### Failover Experience on Linux Clients<a name="linux-failover"></a>

 Linux clients do not support automatic DNS\-based failover\. Therefore, they don't automatically connect to the standby file server during a failover\. They will automatically resume file system operations after the Multi\-AZ file system has failed back to the file server in the preferred subnet\.

## Working with Single and Multi\-AZ File System Resources<a name="single-multi-az-resources"></a>

### Subnets<a name="fs-subnets"></a>

When you create a VPC, it spans all the Availability Zones \(AZs\) in the Region\. Availability Zones are distinct locations that are engineered to be isolated from failures in other Availability Zones\. After creating a VPC, you can add one or more subnets in each Availability Zone\. The default VPC has a subnet in each Availability Zone\. Each subnet must reside entirely within one Availability Zone and cannot span zones\. When you create a Single\-AZ Amazon FSx file system, you specify a single subnet for the file system\. The subnet you choose defines the Availability Zone in which the file system is created\.

When you create a Multi\-AZ file system, you specify two subnets, one for the preferred file server, and one for the standby file server\. The two subnets you choose must be in different Availability Zones within the same AWS Region\. 

For in\-AWS applications, we recommend that you launch your clients in the same Availability Zone as your preferred file server to reduce cross\-AZ data transfer costs and minimize latency\.

### File System Elastic Network Interfaces<a name="file-system-eni-fsxw"></a>

 When you create an Amazon FSx file system, Amazon FSx provisions one or more [elastic network interfaces](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_ElasticNetworkInterfaces.html) in the [Amazon Virtual Private Cloud \(VPC\)](https://docs.aws.amazon.com/vpc/latest/userguide/what-is-amazon-vpc.html) that you associate with your file system\. The network interface allows your client to communicate with the Amazon FSx for Windows File Server file system\. The network interface is considered to be within the service scope of Amazon FSx, despite being part of your account's VPC\. Multi\-AZ file systems have two elastic network interfaces, one for each file server\. Single\-AZ file systems have one elastic network interface\. 

**Warning**  
You must not modify or delete the elastic network interfaces associated with your file system\. Modifying or deleting the network interface can cause a permanent loss of connection between your VPC and your file system\.

The following table summarizes the subnet, elastic network interface, and IP address resources for Amazon FSx for Windows File Server file system deployment types:


| File system deployment type | Number of subnets | Number of elastic network interfaces | Number of IP addresses | 
| --- | --- | --- | --- | 
| Single\-AZ 2 | 1 | 1 | 2 | 
| Single\-AZ 1 | 1 | 1 | 1 | 
| Multi\-AZ | 2 | 2 | 4 | 