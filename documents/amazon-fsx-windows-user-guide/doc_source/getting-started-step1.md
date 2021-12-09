# Step 1: Create Your File System<a name="getting-started-step1"></a>

To create your Amazon FSx file system, you must create your Amazon Elastic Compute Cloud \(Amazon EC2\) instance and the AWS Directory Service directory\. If you don't have that set up already, see [Walkthrough 1: Prerequisites for Getting Started](walkthrough01-prereqs.md)\. 

**To create your first file system**

1. Open the Amazon FSx console at [https://console\.aws\.amazon\.com/fsx/](https://console.aws.amazon.com/fsx/)\.

1. On the dashboard, choose **Create file system** to start the file system creation wizard\.

1. On the **Select file system type** page, choose **Amazon FSx for Windows File Server**, and then choose **Next**\. The **Create file system** page appears\.

1. In the **File system details** section, provide a name for your file system\. It's easier to find and manage your file systems when you name them\. You can use a maximum of 256 Unicode letters, white space, and numbers, plus the special characters \+ \- = \. \_ : /

1. For **Deployment type** choose **Multi\-AZ** or **Single\-AZ**\. 
   + Choose **Multi\-AZ** to deploy a file system that is tolerant to Availability Zone unavailability\. This option supports SSD and HDD storage\. 
   + Choose **Single\-AZ** to deploy a file system that is deployed in a single Availability Zone\. *Single\-AZ 2* is the latest generation of single Availability Zone file systems, and it supports SSD and HDD storage\.

   For more information, see [Availability and Durability: Single\-AZ and Multi\-AZ File Systems](high-availability-multiAZ.md)\.

   The following image shows all of the configuration options available in the **File system details** section\.   
![\[Create file system details screen showing options for deployment type, storage type, storage capacity, and recommended throughput.\]](http://docs.aws.amazon.com/fsx/latest/WindowsGuide/images/CreateFSxWindow-details.png)

1. For **Storage type**, you can choose either **SSD** or **HDD**\. 

   Amazon FSx for Windows File Server offers solid state drive \(SSD\) and hard disk drive \(HDD\) storage types\. **SSD** storage is designed for the highest\-performance and most latency\-sensitive workloads, including databases, media processing workloads, and data analytics applications\. **HDD** storage is designed for a broad spectrum of workloads, including home directories, user and departmental file shares, and content management systems\. For more information, see [Optimizing Costs Using Storage Types](optimize-fsx-costs.md#storage-type-options)\.

1. For **Storage capacity**, enter the storage capacity of your file system, in GiB\. If you're using SSD storage, enter any whole number in the range of 32–65,536\. If you're using HDD storage, enter any whole number in the range of 2,000–65,536\. You can increase the amount of storage capacity as needed at any time after you create the file system\. For more information, see [Managing Storage Capacity](managing-storage-capacity.md)\.

1. Keep **Throughput capacity** at its default setting\. **Throughput capacity** is the sustained speed at which the file server that hosts your file system can serve data\. The **Recommended throughput capacity** setting is based on the amount of storage capacity you choose\. If you need more than the recommended throughput capacity, choose **Specify throughput capacity**, and then choose a value\. For more information, see [Amazon FSx for Windows File Server PerformancePerformance](performance.md)\. 

   You can modify the throughput capacity as needed at any time after you create the file system\. For more information, see [Managing Throughput Capacity](managing-throughput-capacity.md)\.

1. In the **Network & security** section, choose the Amazon VPC that you want to associate with your file system\. For this getting started exercise, choose the same Amazon VPC that you chose for your AWS Directory Service directory and your Amazon EC2 instance\.

1. <a name="security_group_setup"></a>For **VPC Security Groups**, the default security group for your default Amazon VPC is already added to your file system in the console\. If you're not using the default security group, make sure that you add the following rules to the security group you're using for this getting started exercise:

   1. Add the following inbound and outbound rules to allow the following ports\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/fsx/latest/WindowsGuide/getting-started-step1.html)

      Add from and to IP addresses or security group IDs associated with the client compute instances that you want to access your file system from\.

   1. Add outbound rules to allow all traffic to the Active Directory that you're joining your file system to\. To do this, do one of the following:
      + Allow outbound traffic to the security group ID associated with your AWS Managed AD directory\. 
      + Allow outbound traffic to the IP addresses associated with your self\-managed Active Directory domain controllers\. 
**Note**  
In some cases, you might have modified the rules of your AWS Managed Microsoft AD security group from the default settings\. If so, make sure that this security group has the required inbound rules to allow traffic from your Amazon FSx file system\. For more information about the required inbound rules, see [AWS Managed Microsoft AD Prerequisites](https://docs.aws.amazon.com/directoryservice/latest/admin-guide/ms_ad_getting_started_prereqs.html) in the *AWS Directory Service Administration Guide*\.

   For more information, see [ File System Access Control with Amazon VPC ](limit-access-security-groups.md)\.

1. If you have a Multi\-AZ deployment \(see step 5\), choose a **Preferred subnet** value for the primary file server and a **Standby subnet** value for the standby file server\. A Multi\-AZ deployment has a primary and a standby file server, each in its own Availability Zone and subnet\. 

1. For **Windows authentication**, you have the following options:

   If you want to join your file system to a Microsoft Active Directory domain that is managed by AWS, choose **AWS Managed Microsoft Active Directory**, and then choose your AWS Directory Service directory from the list\. For more information, see [Working with Active Directory in Amazon FSx for Windows File Server](aws-ad-integration-fsxW.md)\.

   If you want to join your file system to a self\-managed Microsoft Active Directory domain, choose **Self\-managed Microsoft Active Directory**, and provide the following details for your Active Directory\.
   + The fully qualified domain name of your active directory\.
   + **DNS server IP addresses**—the IPv4 addresses of the DNS servers for your domain
   + **Service account username**—the user name of the service account in your existing active directory\. Do not include a domain prefix or suffix\. 
   + **Service account password**—the password for the service account\.
   + **Confirm password**—the password for the service account\.
   + \(Optional\) **Organizational Unit \(OU\)**—the distinguished path name of the organizational unit in which you want to join you file system\.
   + \(Optional\) **Delegated file system administrators group**— the name of the group in your active directory that can administer your file system\. The default group is 'Domain Admins'\.

1. For **Encryption**, keep the default **Encryption key** setting of **aws/fsx \(default\)**\.

1. Keep the default settings for **Maintenance preferences**\.

1. For **Tags\-Optional**, enter a key and value to add tags to your file system\. A tag is a case\-sensitive key\-value pair that helps you manage, filter, and search for your file system and choose **Next**\.

1. Review the file system configuration shown on the **Create file system** page\. For your reference, note which file system settings you can modify after file system is created\. Choose **Create file system**\. 

1. After the file system has been created, choose the file system ID in the **File Systems** dashboard, then choose **Attach**, and note the fully qualified domain name for your file system\. You will need it in a later step\.