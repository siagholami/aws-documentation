# What Is Amazon FSx for Windows File Server?<a name="what-is"></a>

Amazon FSx for Windows File Server provides fully managed Microsoft Windows file servers, backed by a fully native Windows file system\. Amazon FSx for Windows File Server has the features, performance, and compatibility to easily lift and shift enterprise applications to the AWS Cloud\.

Amazon FSx supports a broad set of enterprise Windows workloads with fully managed file storage built on Microsoft Windows Server\. Amazon FSx has native support for Windows file system features and for the industry\-standard Server Message Block \(SMB\) protocol to access file storage over a network\. Amazon FSx is optimized for enterprise applications in the AWS Cloud, with native Windows compatibility, enterprise performance and features, and consistent submillisecond latencies\.

With file storage on Amazon FSx, the code, applications, and tools that Windows developers and administrators use today can continue to work unchanged\. Windows applications and workloads ideal for Amazon FSx include business applications, home directories, web serving, content management, data analytics, software build setups, and media processing workloads\.

As a fully managed service, Amazon FSx for Windows File Server eliminates the administrative overhead of setting up and provisioning file servers and storage volumes\. Additionally, Amazon FSx keeps Windows software up to date, detects and addresses hardware failures, and performs backups\. It also provides rich integration with other AWS services like [AWS IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/introduction.html), [AWS Directory Service for Microsoft Active Directory](https://docs.aws.amazon.com/directoryservice/latest/admin-guide/directory_microsoft_ad.html), [Amazon WorkSpaces](https://docs.aws.amazon.com/workspaces/latest/adminguide/amazon-workspaces.html), [AWS Key Management Service](https://docs.aws.amazon.com/kms/latest/developerguide/overview.html), and [AWS CloudTrail](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-user-guide.html)\.

## Amazon FSx for Windows File Server Resources: File Systems, Backups, and File Shares<a name="fsx-resources"></a>

The primary resources in Amazon FSx are *file systems* and *backups*\. A file system is where you store and access your files and folders\. A file system is made up of a Windows file server and storage volumes, and is accessed with its DNS name\. When you create a file system, you specify an amount of storage capacity \(in GiB\) and an amount of throughput capacity \(in MB/s\)\. You can modify these properties as your needs change\. For more information, see [Managing Storage Capacity](managing-storage-capacity.md) and [Managing Throughput Capacity](managing-throughput-capacity.md)\. 

Amazon FSx for Windows File Server backups are file\-system\-consistent, highly durable, and incremental\. To ensure file system consistency, Amazon FSx uses the Volume Shadow Copy Service \(VSS\) in Microsoft Windows\. Automatic daily backups are turned on by default when you create a file system, and you can also take additional manual backups at anytime\. For more information, see [Working with Backups](using-backups.md),

A Windows file share is a specific folder \(and its subfolders\) within your file system that you make accessible to your compute instances with SMB\. Your file system already comes with a default Windows file share called `\share`\. You can create and manage as many other Windows file shares as you want by using the Shared Folders graphical user interface \(GUI\) tool on Windows\. For more information, see [Using Microsoft Windows File Shares](using-file-shares.md)\.

### Accessing File Shares<a name="fsx-access-shares"></a>

Amazon FSx is accessible from compute instances with the SMB protocol \(supporting versions 2\.0 to 3\.1\.1\)\. You can access your shares from all Windows versions starting from Windows Server 2008 and Windows 7, and also from current versions of Linux\. You can map your Amazon FSx file shares on Amazon Elastic Compute Cloud \(Amazon EC2\) instances, and on Amazon WorkSpaces instances, Amazon AppStream 2\.0 instances, and VMware Cloud on AWS VMs\. 

You can access your file shares from on\-premises compute instances using AWS Direct Connect or AWS VPN\. In addition to accessing file shares that are in the same VPC, AWS account, and AWS Region as the file system, you can also access your shares on compute instances that are in a different Amazon VPC, account, or Region\. You do so using VPC peering or transit gateways\. For more information, see [Supported Access Methods](supported-fsx-clients.md#access-methods)\. 

## Security and Data Protection<a name="security-considerations"></a>

Amazon FSx provides multiple levels of security and compliance to help ensure that your data is protected\. It automatically encrypts data at rest \(for both file systems and backups\) using keys that you manage in AWS Key Management Service \(AWS KMS\)\. Data in transit is also automatically encrypted using SMB Kerberos session keys\. It has been assessed to comply with ISO, PCI\-DSS, and SOC certifications, and is HIPAA eligible\.

Amazon FSx provides access control at the file and folder level with Windows access control lists \(ACLs\)\. It provides access control at the file system level using Amazon Virtual Private Cloud \(Amazon VPC\) security groups\. In addition, it provides access control at the API level using AWS Identity and Access Management \(IAM\) access policies\. Users accessing file systems are authenticated with Microsoft Active Directory\. Amazon FSx integrates with AWS CloudTrail to monitor and log your API calls letting you see actions taken by users on your Amazon FSx resources\.

Additionally, it protects your data by taking highly durable backups of your file system automatically on a daily basis and allows you to take additional backups at any point\. For more information, see [Security in Amazon FSx](security.md)\.

## Availability and Durability<a name="avail_durability"></a>

Amazon FSx for Windows File Server oﬀers file systems with two levels of availability and durability\. Single\-AZ files ensure high availability within a single Availability Zone \(AZ\) by automatically detecting and addressing component failures\. In addition, Multi\-AZ file systems provide high availability and failover support across multiple Availability Zones by provisioning and maintaining a standby file server in a separate Availability Zone within an AWS Region\. To learn more about Single\-AZ and Multi\-AZ file system deployments, see [Availability and Durability: Single\-AZ and Multi\-AZ File Systems](high-availability-multiAZ.md)\.

## Managing File Systems<a name="managing-FSxW"></a>

You can administer your Amazon FSx for Windows File Server file systems using custom remote management PowerShell commands, or using the Windows\-native GUI in some cases\. To learn more about managing Amazon FSx file systems, see [Administering File Systems](administering-file-systems.md)\.

## Price and Performance Flexibility<a name="price-perf-flexibility"></a>

Amazon FSx for Windows File Server gives you the price and performance flexibility by offering both solid state drive \(SSD\) and hard disk drive \(HDD\) storage types\. HDD storage is designed for a broad spectrum of workloads, including home directories, user and departmental shares, and content management systems\. SSD storage is designed for the highest\-performance and most latency\-sensitive workloads, including databases, media processing workloads, and data analytics applications\. 

With Amazon FSx for Windows File Server, you can provision file system storage and throughput independently to achieve the right mix of cost and performance\. You can modify your file system's storage and throughput capacities to meet changing workload needs, so that you pay only for what you need\. For more information, see [Optimizing Costs with Amazon FSx](optimize-fsx-costs.md)\.

## Pricing for Amazon FSx<a name="pricing"></a>

With Amazon FSx, there are no upfront hardware or software costs\. You pay for only the resources used, with no minimum commitments, setup costs, or additional fees\. For information about the pricing and fees associated with the service, see [Amazon FSx for Windows File Server Pricing](http://aws.amazon.com/fsx/windows/pricing)\.

## Assumptions<a name="assumptions"></a>

To use Amazon FSx, you need an AWS account with an Amazon EC2 instance, Amazon WorkSpaces instance, AppStream 2\.0 instance, or VM running in VMware Cloud on AWS environments of the supported type\.

In this guide, we make the following assumptions:
+ If you're using Amazon EC2, we assume that you're familiar with Amazon EC2\. For more information on how to use Amazon EC2, see [Amazon Elastic Compute Cloud documentation](https://docs.aws.amazon.com/ec2)\.
+ If you're using Amazon WorkSpaces, we assume that you're familiar with Amazon WorkSpaces\. For more information on how to use Amazon WorkSpaces, see [Amazon WorkSpaces User Guide](https://docs.aws.amazon.com/workspaces/latest/userguide/)\.
+ If you're using VMware Cloud on AWS, we assume that you're familiar with it\. For more information, see [VMware Cloud on AWS](https://aws.amazon.com/vmware)\.
+ We assume that you are familiar with Microsoft Active Directory concepts\.

### Prerequisites<a name="prerequisites"></a>

To create an Amazon FSx file system, you need the following:
+ An AWS account with the permissions necessary to create an Amazon FSx file system and an Amazon EC2 instance\. For more information, see [Setting Up](setting-up.md)\.
+ An Amazon EC2 instance running Microsoft Windows Server in the virtual private cloud \(VPC\) based on the Amazon VPC service that you want to associate with your Amazon FSx file system\. For information on how to create one, see [Getting Started with Amazon EC2 Windows Instances](https://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/EC2_GetStarted.html) in the *Amazon EC2 User Guide for Windows Instances\.*
+ Amazon FSx works with Microsoft Active Directory to perform user authentication and access control\. You join your Amazon FSx file system to a Microsoft Active Directory while creating it\. For more information, see [Working with Active Directory in Amazon FSx for Windows File Server](aws-ad-integration-fsxW.md)\.
+ This guide assumes that you haven't changed the rules on the default security group for your VPC based on the Amazon VPC service\. If you have, you need to ensure that you add the necessary rules to allow network traffic from your Amazon EC2 instance to your Amazon FSx file system\. For more details, see [Security in Amazon FSx](security.md)\.
+ Install and configure the AWS Command Line Interface \(AWS CLI\)\. Supported versions are 1\.9\.12 and newer\. For more information, see [Installing the AWS Command Line Interface](https://docs.aws.amazon.com/cli/latest/userguide/installing.html) in the *AWS Command Line Interface User Guide\.*
**Note**  
You can check the version of the AWS CLI you're using with the `aws --version` command\.

## Amazon FSx for Windows File Server Forums<a name="fsx-forums"></a>

If you encounter issues while using Amazon FSx, use the [forums](https://forums.aws.amazon.com/forum.jspa?forumID=308)\.

## Are You a First\-Time User of Amazon FSx?<a name="first-time-user"></a>

If you are a first\-time user of Amazon FSx, we recommend that you read the following sections in order:

1. If you're ready to create your first Amazon FSx file system, try the [Getting Started with Amazon FSx](getting-started.md)\.

1. For information on performance, see [Amazon FSx for Windows File Server PerformancePerformance](performance.md)\.

1. For Amazon FSx security details, see [Security in Amazon FSx](security.md)\.

1. For information on the Amazon FSx API, see [Amazon FSx API Reference](https://docs.aws.amazon.com/fsx/latest/APIReference/Welcome.html)\.