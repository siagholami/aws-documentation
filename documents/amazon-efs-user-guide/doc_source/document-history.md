# Document History<a name="document-history"></a>
+ **API version**: 2015\-02\-01
+ **Latest documentation update**: July 16, 2020

The following table describes important changes to the *Amazon Elastic File System User Guide* after July 2018\. For notifications about documentation updates, you can subscribe to the RSS feed\.

| Change | Description | Date | 
| --- |--- |--- |
| [Support added for automatic daily backups of Amazon EFS file systems](#document-history) | Automatic daily backups are now enabled by default when creating a file system using the EFS console\. For more information, see [Using AWS Backup with Amazon EFS](https://docs.aws.amazon.com/efs/latest/ug/awsbackup.html)\. | July 16, 2020 | 
| [New Amazon EFS management console is now available](#document-history) | The new EFS console makes it easier for you to use Amazon EFS and simplifies the management of your EFS file systems\. | July 16, 2020 | 
| [EFS Quick Create simplifies creating Amazon EFS file systems](#document-history) | Using the Quick Create option in the EFS console, you can create an EFS file system using service recommended settings with a single button\. For more information, see [Create Your Amazon EFS File System](https://docs.aws.amazon.com/efs/latest/ug/gs-step-two-create-efs-resources.html)\. | July 16, 2020 | 
| [Performance of General Purpose Mode file systems increased](#document-history) | Amazon EFS General Purpose mode file systems now support up to 35,000 read operations per second, a 400% increase from the previous limit of 7,000\. For more information, see [ Quotas for Amazon EFS File Systems](https://docs.aws.amazon.com/efs/latest/ug/limits.html#limits-fs-specific)\. | April 1, 2020 | 
| [Additional AWS Region support added](#document-history) | Amazon EFS is now available to all users in the Beijing and Ningxia AWS Regions\. | January 22, 2020 | 
| [Support added for IAM authorization for NFS clients](#document-history) | You can now use AWS Identity and Access Management \(IAM\) to manage NFS access to an Amazon EFS file system\. For more information, see [Using AWS IAM to Control NFS Access to Amazon EFS](https://docs.aws.amazon.com/efs/latest/ug/iam-access-control-nfs-efs.html)\. | January 13, 2020 | 
| [Support added for EFS Access Points](#document-history) | Amazon EFS access points are application\-specific entry points into an Amazon EFS file system that make it easy to manage application access to shared datasets\. For more information, see [Working with Amazon EFS Access Points](https://docs.aws.amazon.com/efs/latest/ug/efs-access-points.html)\. | January 13, 2020 | 
| [Support added for AWS Backup partial restore\.](#document-history) | You can now restore specific files and directories using a partial restore, in addition to restoring a complete recovery point\. For more information, see [Using AWS Backup with Amazon EFS](https://docs.aws.amazon.com/efs/latest/ug/awsbackup.html)\. | January 13, 2020 | 
| [Support added for IAM service\-linked roles](#document-history) | Amazon EFS now uses a service\-linked role based on IAM, making it easier to set up EFS by automatically adding the necessary permissions\. For more information, see [Using Service\-Linked Roles for Amazon EFS](https://docs.aws.amazon.com/efs/latest/ug/using-service-linked-roles.html)\.  | December 10, 2019 | 
| [Additional AWS Region support added](#document-history) | Amazon EFS is now available to all users in the Europe \(Stockholm\) AWS Region\. | November 20, 2019 | 
| [Additional AWS Region support added](#document-history) | Amazon EFS is now available to all users in the Asia Pacific \(Hong Kong\) AWS Region\. | November 20, 2019 | 
| [Additional AWS Region support added](#document-history) | Amazon EFS is now available to all users in the South America \(São Paulo\) AWS Region\. | November 20, 2019 | 
| [Additional AWS Region support added](#document-history) | Amazon EFS is now available to all users in the Middle East \(Bahrain\) AWS Region\. | November 20, 2019 | 
| [New 7 day Lifecycle management policy added](#document-history) | Lifecycle management now has an additional policy to move data to the cost\-effective Infrequent Access storage class after 7 days\. For more information, see [EFS Lifecycle Management](https://docs.aws.amazon.com/efs/latest/ug/lifecycle-management-efs.html)\. | November 6, 2019 | 
| [Support added for Interface VPC Endpoints](#document-history) | You can establish a private connection between your virtual private cloud and Amazon EFS to call the EFS API\. For more information, see [Working with VPC Endpoints](https://docs.aws.amazon.com/efs/latest/ug/VPC-endpoints.html)\.  | October 22, 2019 | 
| [Mount an EFS file system when launching a new EC2 instance\.](#document-history) | You can now configure new Amazon EC2 instances to mount your EFS file systems at launch in the EC2 Launch Instance Wizard\. For more information, see [Step 2\. Create Your EC2 Resources and Launch Your EC2 Instance](https://docs.aws.amazon.com/efs/latest/ug/gs-step-one-create-ec2-resources.html)\.  | October 17, 2019 | 
| [Support for Service Quotas added](#document-history) | You can now view all Amazon EFS limits in the Service Quotas console\. For more information, see [Amazon EFS Limits](https://docs.aws.amazon.com/efs/latest/ug/limits.html)\.  | September 10, 2019 | 
| [New lifecycle management policies added](#document-history) | When using Lifecycle Management, you can now choose from one of four lifecycle policies to define when files are transitioned into the cost\-effective Infrequent Access storage class\. For more information, see [EFS Lifecycle Management](https://docs.aws.amazon.com/efs/latest/ug/lifecycle-management-efs.html)\.  | July 9, 2019 | 
| [EFS Lifecycle Management now available on all EFS file systems\.](#document-history) | The EFS Lifecycle Management feature is now available on all EFS file systems\. A previous restriction based on when a file system was created is now removed\. For more information, see [EFS Lifecycle Management](https://docs.aws.amazon.com/efs/latest/ug/lifecycle-management-efs.html)\.  | July 9, 2019 | 
| [Additional AWS Region support added](#document-history) | Amazon EFS is now available to all users in the Europe \(Paris\) AWS Region\. | June 12, 2019 | 
| [Additional AWS Region support added](#document-history) | Amazon EFS is now available to all users in the Asia Pacific \(Mumbai\) AWS Region\. | June 5, 2019 | 
| [Additional AWS Region support added](#document-history) | Amazon EFS is now available to all users in the Canada \(Central\) AWS Region\. | May 1, 2019 | 
| [API Update: Tags are now part of the CreateFileSystem operation payload](#document-history) | You can now include tags when using the AWS API and CLI CreateFileSystem operation to create an Amazon EFS file system\. For more information, see [CreateFileSystem](https://docs.aws.amazon.com/efs/latest/ug/API_CreateFileSystem.html) and [Creating a File System Using the AWS CLI](https://docs.aws.amazon.com/efs/latest/ug/creating-using-create-fs.html#creating-using-fs-part1-cli)\. | February 19, 2019 | 
| [New features: EFS Infrequent Access storage class and EFS lifecycle management](#document-history) | Amazon EFS Infrequent Access is a cost\-optimized storage class for infrequently accessed files\. EFS lifecycle management automatically transitions files from Standard to Infrequent Access storage\. For more information, see [EFS Storage Classes](https://docs.aws.amazon.com/efs/latest/ug/storage-classes.html)\. | February 13, 2019 | 
| [Additional AWS Region support added](#document-history) | Amazon EFS is now available to all users in the Europe \(London\) AWS Region\. | January 23, 2019 | 
| [AWS Backup Service integration with Amazon EFS](#document-history) | Amazon EFS file systems can be backed up using AWS Backup, a fully managed, centralized, automated backup service for backing up data across AWS services in the cloud and on premises\. For more information, see [AWS Backup and EFS](https://docs.aws.amazon.com/efs/latest/ug/awsbackup.html)\. | January 16, 2019 | 
| [Transit Gateway connection support to on\-premises storage systems added\.](#document-history) | Amazon EFS file systems are now accessible using Transit Gateway connections to on\-premises storage systems\. For more information, see [Mounting from Another Account or VPC](https://docs.aws.amazon.com/efs/latest/ug/manage-fs-access-vpc-peering.html) and [Walkthrough: Mount a File System from a Different VPC](https://docs.aws.amazon.com/efs/latest/ug/efs-different-vpc.html)\. | December 6, 2018 | 
| [EFS File Sync is now part of the new AWS DataSync service\. ](#document-history) | AWS DataSync is a managed data transfer service that simplifies synchronizing large amounts of data between on\-premises storage systems and AWS storage services\. For more information, see [Transfer Files from On\-Premises File Systems to Amazon EFS Using AWS DataSync](https://docs.aws.amazon.com/efs/latest/ug/gs-step-four-sync-files.html)\. | November 26, 2018 | 
| [VPN and inter\-region VPC peering connection support added](#document-history) | Amazon EFS are now accessible over VPN connections and inter\-region VPC peering connections\. For more information, see [Transfer Files from On\-Premises File Systems to Amazon EFS Using AWS DataSync](https://docs.aws.amazon.com/efs/latest/ug/gs-step-four-sync-files.html)\. | October 23, 2018 | 
| [VPN and Inter\-region VPC Peering connection support added](#document-history) | Amazon EFS file systems are now accessible over VPN connections and inter\-region VPC peering connections\. For more information, see [Mounting from Another Account or VPC](https://docs.aws.amazon.com/efs/latest/ug/manage-fs-access-vpc-peering.html) and [How Amazon EFS Works with Direct Connect and VPNs](https://docs.aws.amazon.com/efs/latest/ug/how-it-works.html#how-it-works-direct-connect)\. | October 23, 2018 | 
| [Additional AWS Region support added](#document-history) | Amazon EFS is now available to all users in the Asia Pacific \(Singapore\) AWS Region\. | July 13, 2018 | 
| [Introducing Provisioned Throughput mode](#document-history) | You can now provision throughput for new or existing file systems with the new Provisioned Throughput mode\. For more information, see [Throughput Modes](https://docs.aws.amazon.com/efs/latest/ug/throughput-modes.html)\. | July 12, 2018 | 
| [Additional AWS Region support added](#document-history) | Amazon EFS is now available to all users in the Asia Pacific \(Tokyo\) AWS Region\. | July 11, 2018 | 

The following table describes important changes to the *Amazon Elastic File System User Guide* before July 2018\.


| Change | Description | Date Changed | 
| --- | --- | --- | 
| Additional AWS Region support added | Amazon EFS is now available to all users in the Asia Pacific \(Seoul\) AWS Region\. | May 30, 2018 | 
| Added CloudWatch metric math support | Metric math enables you to query multiple CloudWatch metrics and use math expressions to create new time series based on these metrics\. For more information, see [Using metric math with Amazon EFS](monitoring-metric-math.md)\. | April 4, 2018 | 
| Added the amazon\-efs\-utils set of open\-source tools, and added encryption in transit | The amazon\-efs\-utils tools are a set of open\-source executable files that simplifies aspects of using Amazon EFS, like mounting\. There's no additional cost to use amazon\-efs\-utils, and you can download these tools from GitHub\. For more information, see [Using the amazon\-efs\-utils Tools](using-amazon-efs-utils.md)\. Also in this release, Amazon EFS now supports encryption in transit through Transport Layer Security \(TLS\) tunneling\. For more information, see [Data Encryption in EFS](encryption.md)\. | April 4, 2018 | 
| Updated file system limits per AWS Region | Amazon EFS has increased the limit on the number of file systems for all accounts in all AWS Regions\. For more information, see [Resource Quotas](limits.md#limits-efs-resources-per-account-per-region)\. | March 15, 2018 | 
| Additional AWS Region support added | Amazon EFS is now available to all users in the US West \(N\. California\) AWS Region\. | March 14, 2018 | 
| Data encryption at rest | Amazon EFS now supports data encryption at rest\. For more information, see [Data Encryption in EFS](encryption.md)\. | August 14, 2017 | 
| Additional region support added | Amazon EFS is now available to all users in the Europe \(Frankfurt\) region\. | July 20, 2017 | 
| File system names using Domain Name System \(DNS\) | Amazon EFS now supports DNS names for file systems\. A file system's DNS name automatically resolves to a mount target’s IP address in the Availability Zone for the connecting Amazon EC2 instance\. For more information, see [Mounting on Amazon EC2 with a DNS Name](mounting-fs-mount-cmd-dns-name.md)\. | December 20, 2016 | 
| Increased tag support for file systems | Amazon EFS now supports 50 tags per file system\. For more information on tags in Amazon EFS, see [Managing file system tags](manage-fs-tags.md)\. | August 29, 2016 | 
|  General availability  |  Amazon EFS is now generally available to all users in the US East \(N\. Virginia\), US West \(Oregon\), and Europe \(Ireland\) Regions\.  |  June 28, 2016  | 
|  File system limit increase  |  The number of Amazon EFS file systems that can be created per account for each AWS Region increased from 5 to 10\.  |  August 21, 2015  | 
|  Updated Getting Started exercise  |  The Getting Started exercise has been updated to simplify the getting started process\.  |  August 17, 2015  | 
|  New guide  |  This is the first release of the *Amazon Elastic File System User Guide*\.  |  May 26, 2015  | 