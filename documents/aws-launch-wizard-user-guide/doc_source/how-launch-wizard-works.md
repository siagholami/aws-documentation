# How AWS Launch Wizard works<a name="how-launch-wizard-works"></a>

AWS Launch Wizard provides a complete solution to provision popular third\-party applications on AWS\. Currently, Launch Wizard supports Microsoft SQL Server Always On applications\. You select Microsoft SQL Server Always On and provide the specifications, such as for performance, throughput, and networking requirements\. Based on the application requirements that you enter, Launch Wizard automatically provisions the right AWS resources in the cloud\. For example, Launch Wizard determines the best instance type and EBS volume for your CPU, memory, and bandwidth specifications, then deploys and configures them\. 

Launch Wizard provides an estimated cost of deployment\. You can modify your resources and instantly view an updated cost assessment\. Once you approve, AWS Launch Wizard validates the inputs and flags inconsistencies\. After you resolve the inconsistencies, AWS Launch Wizard provisions the resources and configures them\. The result is a ready\-to\-use SQL Server Always On application\.

Launch Wizard creates a CloudFormation stack according to your infrastructure needs\. You can reuse this template as a baseline for future infrastructure provisioning\. 

Launch Wizard supports AWS Managed Microsoft Active Directory \(AD\) as well as connecting to Active Directory on\-premises through AWS Direct Connect\.

## Implementation details<a name="launch-wizard-implementation"></a>

AWS Launch Wizard implements SQL Server Always On deployments as follows\.

### SQL Server Enterprise Edition<a name="launch-wizard-sql"></a>

 Launch Wizard supports installation of SQL Server Enterprise and Standard Editions of 2016 and 2017 on Windows Server 2012 R2, 2016, and 2019 through License Included Amazon Machine Images \(AMIs\)\. Launch Wizard allows you to bring your own SQL licenses through a custom AMI\. If you use a custom AMI, ensure that your AMI meets the requirements listed in [Using custom AMIs](launch-wizard-setting-up.md#launch-wizard-custom-ami)\.

### Storage on WSFC nodes<a name="launch-wizard-storage"></a>

Storage capacity and performance are key aspects of any production SQL Server installation\. Launch Wizard lets you choose capacity and performance based on your deployment needs\. 

Amazon Elastic Block Store \(Amazon EBS\) volumes are included in the architecture to provide durable, high\-performance storage\. EBS volumes are network\-attached disk storage, which you can create and attach to EC2 instances\. When attached, you can create a file system on top of these volumes, run a database, or use them in any way that you would use a block device\. EBS volumes are placed in a specific Availability Zone, where they are automatically replicated to protect you from the failure of a single component\. EBS volume type `io1` is not supported\. 

[Provisioned IOPS EBS volumes](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EBSVolumeTypes.html#EBSVolumeTypes_piops) offer storage with consistent and low\-latency performance\. They are backed by solid state drives \(SSDs\) and designed for applications with I/O intensive workloads, such as databases\. Amazon EBS\-optimized instances, such as the R4 instance type, deliver dedicated throughput between Amazon EC2 and Amazon EBS\.

By default, Launch Wizard deploys three 500 GiB general purpose SSD volumes to store databases, logs, tempdb, and backups on each WSFC node\. These general purpose SSD volumes are in addition to the root general purpose SSD volume used by the operating system, which delivers a consistent baseline of 3 IOPS/GiB and provides a total of 1,500 IOPS per volume for SQL Server database and log volumes\. You can customize the volume size and switch to using dedicated IOPS volumes with the volume you specify\. If you need more IOPS per volume, consider using Provisioned IOPS SSD volumes by changing the SQL Server Volume Type and SQL Server Volume IOPS parameters\.

 The default disk layout for SQL Server deployed by Launch Wizard is: 
+ One general purpose SSD volume \(100 GiB\) for the operating system \(C:\)
+ One general purpose SSD volume \(500 GiB\) to host the SQL Server database files \(D:\)
+ One general purpose SSD volume \(500 GiB\) to host the SQL Server log files \(E:\)
+ One general purpose SSD volume \(500 GiB\) to host the SQL Server tempdb and backup files \(F:\)

### IP Addressing on the Windows Server Failover Clustering \(WSFC\) Nodes<a name="launch-wizard-ip-wsfc"></a>

In order to support WSFC and Always On Availability Group listeners, each node that hosts the SQL Server instances that participate in the cluster must have three IP addresses assigned, as follows:
+ One IP address as the primary IP address for the instance
+ A second IP address as the WSFC IP resource
+ A third IP address to host the Always On Availability Group listener

When you launch the AWS CloudFormation template, you can specify the addresses for each node\. By default, the underlying CloudFormation templates of Launch Wizard use 10\.0\.0\.0/20, 10\.0\.16\.0/20, and 10\.0\.32\.0/20 as CIDR blocks for the private subnets\. This is true only when you use Launch Wizard to deploy SQL Server Always On clusters in a new VPC\.

### Windows Server Failover Clustering \(WSFC\)<a name="launch-wizard-wsfc"></a>

You can build the failover cluster after your Windows Server instances have been deployed and domain\-joined\. Launch Wizard's underlying AWS CloudFormation templates build the cluster when deploying the second node\. If you use the default template parameter settings, Launch Wizard executes the following Windows PowerShell commands to complete this task\. 

```
PS C:\> Install-WindowsFeature failover-clustering –IncludeManagementTools
```

```
PS C:\> New-Cluster –Name WSFClusterName –Node $nodes -StaticAddress $addr
```

The first command runs on each instance during the bootstrapping process\. It installs the required components and management tools for the failover clustering services\. The second command runs near the end of the bootstrapping process on the second node and is responsible for creating the cluster and for defining the server nodes and IP addresses\.

If you set the optional third Availability Zone, Launch Wizard keeps the quorum settings to the default node majority\.

```
PS C:\> Set-ClusterQuorum –NodeMajority
```

### Always On configuration<a name="launch-wizard-alwayson"></a>

After SQL Server Enterprise edition has been installed and the Windows Server failover cluster has been built, Launch Wizard enables SQL Server Always On with the following PowerShell command\.

```
PS C:\> Enable-SqlAlwaysOn –ServerInstance $ServerInstance
```

Launch Wizard runs this command on each node, and the proper server name is provided as a value for the `ServerInstance` parameter\.

When the deployment is complete, Launch Wizard creates your databases and make them highly available by creating an Always On Availability Group\.

When you create an availability group, you provide a network share that is used to perform an initial data synchronization\. As you progress through the New Availability Group wizard, a full backup for each selected database is taken and placed in the share\. The secondary node connects to the share and restores the database backups before joining the availability group\.