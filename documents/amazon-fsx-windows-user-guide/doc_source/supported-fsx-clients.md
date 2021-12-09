# Supported Clients, Access Methods, and Environments for Amazon FSx for Windows File Server<a name="supported-fsx-clients"></a>

Amazon FSx supports access to your file systems using a variety of clients and methods from both AWS and on\-premises environments\.

**Topics**
+ [Supported Clients](#supported-clients-fsx)
+ [Supported Access Methods](#access-methods)
+ [Supported Environments](#access-environments)

## Supported Clients<a name="supported-clients-fsx"></a>

Amazon FSx supports connecting to your file system from a wide variety of compute instances and operating systems\. It does this by supporting access through the Server Message Block \(SMB\) protocol, versions 2\.0 through 3\.1\.1\. 

The following AWS compute instances are supported for use with Amazon FSx:
+ Amazon Elastic Compute Cloud \(Amazon EC2\) instances\.
+ Amazon WorkSpaces instances – To learn more, see the AWS blog post [ Using Amazon FSx for Windows File Server with Amazon WorkSpaces](http://aws.amazon.com/blogs/desktop-and-application-streaming/using-amazon-fsx-for-windows-file-server-with-amazon-workspaces/)\.
+ Amazon AppStream 2\.0 instances – To learn more, see the AWS blog post [ Using Amazon FSx with Amazon AppStream 2\.0](http://aws.amazon.com/blogs/desktop-and-application-streaming/using-amazon-fsx-with-amazon-appstream-2-0/)\. 
+  VMs running in VMware Cloud on AWS environments – To learn more, see the AWS blog post [Storing and Sharing Files with Amazon FSx for Windows File Server in a VMware Cloud on AWS Environment](http://aws.amazon.com/blogs/apn/storing-and-sharing-files-with-amazon-fsx-in-a-vmware-cloud-on-aws-environment/)\. 

The following operating systems are supported for use with Amazon FSx:
+ Windows Server 2008, Windows Server 2008 R2, Windows Server 2012, Windows Server 2012 R2, Windows Server 2016, and Windows Server 2019\.
+ Windows Vista, Windows 7, Windows 8, Windows 8\.1, and Windows 10 \(including the Windows 7 and Windows 10 desktop experiences of Amazon WorkSpaces\)
+ Linux, using the `cifs-utils` tool

## Supported Access Methods<a name="access-methods"></a>

You can use the following access methods and approaches with Amazon FSx\.

### Accessing Amazon FSx File Systems Using DNS Names<a name="dns-name"></a>

Amazon FSx for Windows File Server provides a Domain Name System \(DNS\) name for every file system\. You access your Amazon FSx for Windows File Server file system by mapping a drive letter on your compute instance to your Amazon FSx file share using this DNS name\. To learn more, see [Using Microsoft Windows File Shares](using-file-shares.md)\.

 You can find the DNS name in the Amazon FSx Management Console, the **File systems > Details > Network & Security** section, or in the response of the CreateFileSystem or DescribeFileSystems API command\.
+ For a Single AZ file system joined to an AWS Managed Microsoft Active Directory, the DNS name looks as follows\.

  `fs-0123456789abcdef0.ad-domain.com`
+ For a Single AZ file system joined to a self\-managed AD, and any Multi AZ file system, the DNS name looks as follows\.

  `amznfsxaa11bb22.ad-domain.com`

**Important**  
To get Kerberos\-based authentication and encryption of data in transit for your SMB sessions, use the file system's DNS name provided by Amazon FSx to access your file system\. If you have an external trust configured between your AWS managed Microsoft AD and your on premise AD, in order to use the Amazon FSx Remote Powershell with Kerberos authentication, you need to configure a local group policy on the client for forest search order\. For more information, see the Microsoft documentation [Configure Kerberos Forest Search Order \(KFSO\)](https://docs.microsoft.com/en-us/previous-versions/windows/it-pro/windows-server-2008-R2-and-2008/hh921473(v=ws.10)?redirectedfrom=MSDN)\.

### Working with Amazon FSx for Windows File Server File Systems and DFS Namespaces<a name="dfs-namespace"></a>

Amazon FSx for Windows File Server supports the use of Microsoft Distributed File System \(DFS\) Namespaces\. You can use DFS Namespaces to organize file shares on multiple file systems into one common folder structure \(a namespace\) that you use to access the entire file dataset\. You can use a name in your DFS Namespace to access your Amazon FSx file system by configuring its link target to be the file system's DNS name\.

## Supported Environments<a name="access-environments"></a>

You can access your file system from resources that are in the same VPC as your file system\. For more information and detailed instructions, see [Walkthrough 1: Prerequisites for Getting Started](walkthrough01-prereqs.md)\.

You can also access file systems created after February 22, 2019, from on\-premises resources and from resources that are in a different VPC, AWS account, or AWS Region\. Following, you can find information about how to access your Amazon FSx for Windows File Server file systems from on\-premises and from different VPCs, AWS accounts, or AWS Regions\.

**Important**  
In some cases, you might want to access a file system created before February 22, 2019, from on\-premises resources or from resources in a different VPC, AWS account, or AWS Region\. To do this, create a new file system from a backup of your existing file system\. To learn more about creating and restoring backups, see [Working with Backups](using-backups.md)\. 

**Note**  
Amazon FSx can support access from resources outside the VPC associated with your file system\. It can do this if those resources have an IP address in the following private IP version 4 \(IPv4\) address ranges, as specified in [RFC 1918](http://www.faqs.org/rfcs/rfc1918.html):  
10\.0\.0\.0–10\.255\.255\.255 \(10/8 prefix\)
172\.16\.0\.0–172\.31\.255\.255 \(172\.16/12 prefix\)
192\.168\.0\.0–192\.168\.255\.255 \(192\.168/16 prefix\)
If those resources have a non\-private IP address, you can only access file systems from within the same VPC that the resource resides in\.

### Accessing Amazon FSx for Windows File Server File Systems from On\-Premises<a name="on-premise-access"></a>

Amazon FSx for Windows File Server supports the use of AWS Direct Connect or AWS VPN to access your file systems from your on\-premises compute instances\. With support for AWS Direct Connect, Amazon FSx for Windows File Server enables you to access your file system over a dedicated network connection from your on\-premises environment\. With support for AWS VPN, Amazon FSx for Windows File Server enables you to access your file system from your on\-premises devices over a secure and private tunnel\.

After you connect your on\-premises environment to the VPC associated with your Amazon FSx file system, you can access your file system using its DNS name\. You do so just as you do from compute instances within the VPC\. For more information on AWS Direct Connect, see the *[AWS Direct Connect User Guide](https://docs.aws.amazon.com/directconnect/latest/UserGuide/)\.* For more information on setting up a VPN connection, see [VPN Connections](https://docs.aws.amazon.com/vpc/latest/userguide/vpn-connections.html) in the *Amazon VPC User Guide*\. 

### Accessing Amazon FSx for Windows File Server File Systems from Another VPC, Account, or AWS Region<a name="different-vpc-account-access"></a>

You can access your Amazon FSx for Windows File Server file system from compute instances in a different VPC, AWS account, or AWS Region from that associated with your file system\. To do so, you can use VPC peering or transit gateways\. When you use a VPC peering connection or transit gateway to connect VPCs, compute instances that are in one VPC can access Amazon FSx file systems in another VPC\. This access is possible even if the VPCs belong to different accounts, and even if the VPCs reside in different AWS Regions\. 

A *VPC peering connection* is a networking connection between two VPCs that you can use to route traffic between them using private IPv4 or IP version 6 \(IPv6\) addresses\. You can use VPC peering to connect VPCs within the same AWS Region or between AWS Regions\. For more information on VPC peering, see [What is VPC Peering?](https://docs.aws.amazon.com/vpc/latest/peering/Welcome.html) in the *Amazon VPC Peering Guide*\.

A *transit gateway *is a network transit hub that you can use to interconnect your VPCs and on\-premises networks\. For more information about using VPC transit gateways, see [Getting Started with Transit Gateways](https://docs.aws.amazon.com/vpc/latest/tgw/tgw-getting-started.html) in the *Amazon VPC Transit Gateways*\.

After you set up a VPC peering or transit gateway connection, you can access your file system using its DNS name\. You do so just as you do from compute instances within the associated VPC\.