# How AWS Launch Wizard for SAP works<a name="how-launch-wizard-sap-works"></a>

AWS Launch Wizard provisions and configures the infrastructure required to run SAP HANA database\- and Netweaver\-based SAP applications on AWS\. You select the SAP deployment pattern and provide the specifications, such as operating system, instance size, and vCPU/memory\. Or, Launch Wizard can make these selections for you according to [SAP Standard Application Benchmarks \(SAPS\)](https://www.sap.com/about/benchmark/measuring.html)\. You have the option to manually choose the instance\. Based on your selections, Launch Wizard automatically provisions the necessary AWS resources in the cloud\. 

Launch Wizard recommends Amazon EC2 instances by evaluating the [SAPS](https://www.sap.com/about/benchmark/measuring.html) or vCPU/memory requirements against the performance of Amazon EC2 instances supported by AWS\. When new EC2 instances are released and certified for SAP, the sizing feature of Launch Wizard will take them into consideration when proposing recommendations\.

Launch Wizard maintains a mapping rule engine built on the list of certified EC2 instances that are supported by SAP\. When you enter your vCPU/memory or SAPS requirements, Launch Wizard recommends an Amazon EC2 instance that is certified for SAP workloads and offers performance that is no less than your input requirements\. For certain workloads, such as SAP HANA in a production environment, Launch Wizard recommends instances based on the official SAP recommendations for SAP HANA database workloads\. For workloads in a non\-production environment, Launch Wizard recommends Amazon EC2 instances that meet SAP recommended requirements; however, the recommended instances are not enforced\. You can change the instance types after deployment, or you can override the recommendation by making manual selections\. 

In addition to launching instances based on the SAP system information that you provide, such as SAP System Number and SAP System Identifier \(SAP SID\), Launch Wizard performs the following operations:
+ Configures the operating system
+ Configures hostname
+ Attaches security groups so that the systems in the cluster that use the same configuration template, and also external systems, can communicate with the SAP systems that will be deployed on these instances\.

Launch Wizard provides an estimated cost of deployment\. You can modify your resources and instantly view an updated cost assessment\. After you approve the deployment, Launch Wizard validates the inputs and flags inconsistencies\. After you resolve the inconsistencies, Launch Wizard provisions and configures the resources\. The result is a ready\-to\-use SAP application\.

Launch Wizard creates a CloudFormation stack according to your infrastructure needs\. For more information, see [Working With Stacks](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/stacks.html) in the *AWS CloudFormation User Guide*\.

## Implementation Details<a name="launch-wizard-sap-implementation"></a>

AWS Launch Wizard implements SAP deployments as follows\.

**Topics**
+ [Storage for SAP Systems](#launch-wizard-sap-storage)
+ [Amazon Elastic File System setup for transport directory](#launch-wizard-sap-efs)
+ [Amazon Elastic File System setup for SAP Central Services instances configured for high availability](#launch-wizard-sap-efs-ha)
+ [Bring your own image \(BYOI\)](#launch-wizard-sap-byoi)
+ [Configuration settings](#launch-wizard-sap-config)
+ [Manual cleanup activities](#launch-wizard-sap-manual-cleanup)
+ [Default Quotas](#launch-wizard-sap-default-quotas)
+ [AWS Regions and Endpoints](#launch-wizard-sap-regions-endpoints)

### Storage for SAP Systems<a name="launch-wizard-sap-storage"></a>

Storage capacity and performance are key aspects of any SAP system installation\. Launch Wizard provides storage type options for the SAP Netweaver Application tier and the SAP HANA database tiers\.

Amazon Elastic Block Store \(Amazon EBS\) volumes are included in the architecture to provide durable, high\-performance storage\. Amazon EBS volumes are network\-attached disk storage, which you can create and attach to EC2 instances\. When attached, you can create a file system on top of these volumes, run a database, or use them in any way that you would use a block device\. Amazon EBS volumes are placed in a specific Availability Zone, where they are automatically replicated to protect you from the failure of a single component\.

[General Purpose EBS Volumes](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ebs-volume-types.html#EBSVolumeTypes_gp2) offer storage for a broad range of workloads\. These volumes deliver single\-digit millisecond latencies and the ability to burst to 3,000 IOPS for extended periods of time\. Between a minimum of 100 IOPS \(at 33\.33 GiB and below\) and a maximum of 16,000 IOPS \(at 5,334 GiB and above\), baseline performance scales linearly at 3 IOPS per GiB of volume size\. 

[Provisioned IOPS Amazon EBS volumes](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EBSVolumeTypes.html#EBSVolumeTypes_piops) offer storage with consistent and low\-latency performance\. They are backed by solid state drives \(SSDs\) and designed for applications with I/O intensive workloads, such as databases\. Amazon EBS\-optimized instances, such as the R4 instance type, deliver dedicated throughput between Amazon EC2 and Amazon EBS\.

By default, Launch Wizard deploys Amazon EBS volumes for the SAP HANA database that meet the storage KPIs for SAP as listed in [Storage Configurations for SAP HANA](https://docs.aws.amazon.com/quickstart/latest/sap-hana/storage.html)\.

For Netweaver database stacks, you can choose between a `gp2` or `io1` volume for the `usr/sap/SAPSID` file system, whereas other configurations are deployed with `gp2` volumes\.

In an SAP landscape, development occurs in the development system and is then imported into the QA and follow\-on systems\. For this import to occur successfully, a shared file system is required for SAP systems in the landscape\. Amazon EFS is used to create the SAP Transport file system that is shared between multiple SAP systems in the landscape\. 

### Amazon Elastic File System setup for transport directory<a name="launch-wizard-sap-efs"></a>

The SAP transport directory is a shared file system between SAP systems \(for example, Development, Quality, and Production\) that are part of the same SAP Transport Domain for releasing and importing SAP transports\. To avoid a single point of failure, Launch Wizard creates a file system with Amazon Elastic File System or reuses existing file systems\. It mounts the file systems on the SAP systems that you select based on the role of the system\. The transport file system is mounted on all of the applications servers included in the deployment\.

When systems within the same SAP Transport Domain are created in one VPC and need to be attached to SAP systems in other VPCs \(for example, if Development and Quality are deployed in a VPC tagged as Non\_Prod, and Production is deployed in a VPC tagged as Prod\), a prerequisite for using VPC Peering/Transit Gateway is that you must enable the VPCs to be able to communicate\. This allows Launch Wizard to attach the transport directory created in one VPC to instance\(s\) in other VPCs using a mount target in the same Availability Zone or other Availability Zones, as applicable\. If the VPCs are not permitted to communicate, then the deployment will fail when it attempts to mount the transport file system created in one VPC to systems in another VPC\.

**Note**  
When a transport files system is created with Amazon Elastic File System, Launch Wizard considers it a shared resource and will not delete it when you delete the deployment or if the deployment is rolled back\.

### Amazon Elastic File System setup for SAP Central Services instances configured for high availability<a name="launch-wizard-sap-efs-ha"></a>

The SAP Central Services instances that make up a Netweaver high availability deployment, ABAP Central Server \(ASCS\) and Enqueue Replication Server \(ERS\) instances, must contain the following file systems to be highly available: `/sapmnt`, `/usr/sap<SAPSID>/ASCS<XX>`, and `/usr/sap/<SAPSID>/ERS<XX>`\. These file systems are built with Amazon EFS to avoid a single point of failure for the SAP system\. Launch Wizard creates these file systems for the Netweaver high availability pattern using a single Amazon Elastic File System\. 

The following table contains information about how a single Amazon EFS is configured and mounted on an ASCS, ERS, Primary Application Server \(PAS\), and Additional Application Server \(AAS\)\. 


| EFS ID | EFS DNS name | Instance mounted on | File System name | Server mounted on | 
| --- | --- | --- | --- | --- | 
| fs\-123A456B | fs\-123A456B\.efs\.<AWS Region>\.amazonaws\.com | fs\-123A456B\.efs\.<AWS Region>\.amazonaws\.com:/SAPMNT\-<SAPSID> | /sapmnt | SAP ASCS, ERS, Primary and Additional Application servers | 
| fs\-123A456B | fs\-123A456B\.efs\.<AWS Region>\.amazonaws\.com | fs\-123A456B\.efs\.<AWS Region>\.amazonaws\.com:/ASCS\-<SAPSID> |  `/usr/sap/<SAPSID>/` `ASCS<XX>`  | SAP ASCS Server | 
| fs\-123A456B | fs\-123A456B\.efs\.<AWS Region>\.amazonaws\.com | fs\-123A456B\.efs\.<AWS Region>\.amazonaws\.com:/ERS\-<SAPSID> |  `/usr/sap/<SAPSID>/` `ERS<XX>`  | SAP ERS Server | 

### Bring your own image \(BYOI\)<a name="launch-wizard-sap-byoi"></a>

You can bring your own images to deploy and configure EC2 instances for SAP with AWS Launch Wizard\. During launch, in order to continue with a deployment, Launch Wizard verifies whether the operating system version selected on the front end matches the operating system version of the instance\. If the versions do not match, the deployment fails with an error\. 

When building your own image,consider the following:
+ Launch Wizard configures the operating systems with OS\-level parameters and utilities required by SAP
+ Refer to SAP installation documents to ensure that operating system prerequisites are in place so that Launch Wizard deployments do not fail\.
+ Launch Wizard accesses standard repositories provided by OS vendors\. Do not block access to them\. 
+ Deployments by Launch Wizard use OS utilities and programs, such as zipper, yum, grep, printf, awk, sed, autofs, python, saptune, and tuned\-profiles in the deployment script to configure SAP application and database servers\. We recommend that you do not delete standard utilities\. 

### Configuration settings<a name="launch-wizard-sap-config"></a>

The following configuration settings are applied when deploying an SAP application with Launch Wizard\.


| Setting | Applies to | 
| --- | --- | 
| SSM Agent |  All SAP systems and patterns  | 
| EBS Volumes for SAP application tier |  All SAP systems and patterns  | 
| EBS Volumes for SAP HANA database, log and backup file systems |  All SAP systems and patterns  | 
| EFS volumes for SAP transport file systems | All SAP systems and patterns | 
| EFS volumes for SAP central services: sapmnt, /usr/sap/<SID>/ASCS<XX> and /usr/sap/<SID>/ERS<XX | ASCS and ERS systems | 
|  OS parameters required based on the operating system chosen for SAP HANA  |  All SAP systems and patterns  | 
| Security groups created and assigned for accessing the SAP system |  All SAP systems and patterns  | 
|  SSM Session Manager to remotely access the server for administrator activities  |  All SAP systems and patterns  | 
|  Time zone settings at the OS level  |  All SAP systems and patterns  | 

### Manual cleanup activities<a name="launch-wizard-sap-manual-cleanup"></a>

If you choose to delete a deployment, or a deployment fails during the deployment phase and rolls back, Launch Wizard deletes the Amazon EC2 and Amazon EBS volumes that it launches as part of the deployment\. The following resources are considered shared resources and are created without the deletion flag\.
+ The Amazon Elastic File System file system that is created for the SAP transport files system `/usr/sap/trans`
+ Security groups that you create 

These resources must be verified manually to ensure that they are not being used by other systems in the landscape\. They must then be manually deleted from either the Amazon Elastic File System or Amazon EC2 consoles, or using APIs\. 

### Default Quotas<a name="launch-wizard-sap-default-quotas"></a>

To view the default quotas for AWS Launch Wizard, see [AWS Launch Wizard Endpoints and Quotas](https://docs.aws.amazon.com/general/latest/gr/launchwizard.html)\.

### AWS Regions and Endpoints<a name="launch-wizard-sap-regions-endpoints"></a>

To view the service endpoints for AWS Launch Wizard, see [AWS Launch Wizard Endpoints and Quotas](https://docs.aws.amazon.com/general/latest/gr/launchwizard.html)\.