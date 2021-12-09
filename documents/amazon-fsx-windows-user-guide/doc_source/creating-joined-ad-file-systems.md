# Joining an Amazon FSx File System to a Self\-Managed Microsoft Active Directory Domain<a name="creating-joined-ad-file-systems"></a>

When you create a new Amazon FSx for Windows File Server file system, you can configure Microsoft Active Directory integration so that it joins to your self\-managed Microsoft Active Directory domain\. To do this, provide the following information for your Microsoft AD: 
+ The fully qualified domain name of your on\-premises Microsoft AD directory\. 
**Note**  
Amazon FSx currently does not support Single Label Domain \(SLD\) domains\.
+ The IP addresses of the DNS servers for your domain\.
+ Credentials for a service account in your on\-premises Microsoft AD domain\. Amazon FSx uses these credentials to join to your self\-managed AD\. 

Optionally, you can also specify the following:
+  A specific Organizational Unit \(OU\) within the domain that you want your Amazon FSx file system to join to\. 
+  The name of the domain group whose members are granted administrative privileges for the Amazon FSx file system\. 

After you specify this information, Amazon FSx joins your new file system to your self\-managed AD domain using the service account that you provided\. 

## Before You Begin<a name="b4-you-begin"></a>

Make sure that you have completed the [Prerequisites for Using a Self\-Managed Microsoft AD](self-manage-prereqs.md) detailed in [Using Amazon FSx with Your Self\-Managed Microsoft Active Directory](self-managed-AD.md)\.

## To Create an Amazon FSx for Windows File Server file system joined to a Self\-Managed AD \(Console\)<a name="create-joined-fsx-console"></a>

1. Open the Amazon FSx console at [https://console\.aws\.amazon\.com/fsx/](https://console.aws.amazon.com/fsx/)\.

1. On the dashboard, choose **Create file system** to start the file system creation wizard\. 

1. Choose **Amazon FSx for Windows File Server** and then choose **Next**\. The **Create file system page appears\.**

1. Provide a name for your file system\. You can use a maximum of 256 Unicode letters, white space, and numbers, plus the special characters \+ \- = \. \_ : /

1. For **Storage capacity**, enter the storage capacity of your file system, in GiB\. If you're using SSD storage, enter any whole number in the range of 32–65,536\. If you're using HDD storage, enter any whole number in the range of 2,000–65,536\. You can increase the amount of storage capacity as needed at any time after you create the file system\. For more information, see [Managing Storage Capacity](managing-storage-capacity.md)\.

1. Keep **Throughput capacity** at its default setting\. **Throughput capacity** is the sustained speed at which the file server that hosts your file system can serve data\. The **Recommended throughput capacity** setting is based on the amount of storage capacity you choose\. If you need more than the recommended throughput capacity, choose **Specify throughput capacity**, and then choose a value\. For more information, see [Amazon FSx for Windows File Server PerformancePerformance](performance.md)\. 

   You can modify the throughput capacity as needed at any time after you create the file system\. For more information, see [Managing Throughput Capacity](managing-throughput-capacity.md)\.

1. Choose the VPC that you want to associate with your file system\. For the purposes of this getting started exercise, choose the same VPC as for your AWS Directory Service directory and Amazon EC2 instance\.

1. Choose any value for **Availability Zones** and **Subnet**\.

1. For **VPC security groups**, the default security group for your default Amazon VPC is already added to your file system in the console\. If you're not using the default security group, make sure that you add the following rules to the security group that you use for this exercise:
   + Inbound and outbound rules to allow the following ports:
     + TCP 445 \(SMB\)
     + TCP 135 \(RPC\)
     + TCP/UDP 1024\-65535 \(Ephemeral ports for RPC\)

     From and to IP addresses or security group IDs associated with the following source and destination resources:
     + Client compute instances from which you want to access the file system\.
     + Other file servers that you expect this file system to participate with in DFS Replication groups\.
   + Outbound rules to allow all traffic to the IP addresses associated with the DNS servers and domain controllers for your self\-managed Microsoft AD domain\. For more information, see [Microsoft's documentation on configuring your firewall for Active Directory communication](https://support.microsoft.com/en-us/help/179442/how-to-configure-a-firewall-for-domains-and-trusts)\.

1. For **Windows authentication**, choose **Self\-managed Microsoft Active Directory**\. 

1.  Enter a value for **Fully qualified domain name** for the self\-managed Microsoft AD directory\. 
**Note**  
Domain name must not be in the Single Label Domain \(SLD\) format\. Amazon FSx currently does not support SLD domains\.

1. Enter a value for **Organizational Unit** for the self\-managed Microsoft AD directory\.
**Note**  
Ensure that the service account you provided has permissions delegated to the OU that you specify here or to the default OU if you don’t specify one\.

1. Enter at least one, and no more that two, values for **DNS Server IP Addresses** for the self\-managed Microsoft AD directory\. 

1. Enter a string value for **Service account username** for the account on your self\-managed AD domain, such as `ServiceAcct`\. Amazon FSx uses this user name to join to your Microsoft AD domain\.
**Important**  
 DO NOT include a domain prefix \(`corp.com\ServiceAcct`\) or domain suffix \(`ServiceAcct@corp.com`\) when entering the **Service account username**\.   
 DO NOT use the Distinguished Name \(DN\) when entering the **Service account username** \(`CN=ServiceAcct,OU=example,DC=corp,DC=com`\)\. 

1. Enter a value for **Service account password** for the account on your self\-managed AD domain\. Amazon FSx uses this password to join to your Microsoft AD domain\. 

1.  Re\-enter the password to confirm it in **Confirm password**\. 

1. \(Optional\) Specify a value for **Delegated file system administrators group** in your domain\. This group has the delegated authority to perform administrative tasks on your file system\. If none is provided, Amazon FSx attempts to use the Builtin Domain Admins group\.
**Important**  
 If you do not provide a **Delegated file system administrators group**, by default Amazon FSx attempts to use the Builtin Domain Admins group in your AD domain\. If the name of this Builtin group has been changed or if you’re using a different group for domain administration, you must provide that name for the group here\. 
**Important**  
 DO NOT include a domain prefix \(corp\.com\\FSxAdmins\) or domain suffix \(FSxAdmins@corp\.com\) when providing the group name parameter\.   
 DO NOT use the Distinguished Name \(DN\) for the group\. An example of a distinguished name is CN=FSxAdmins,OU=example,DC=corp,DC=com\. 

## To Create an Amazon FSx for Windows File Server File System Joined to a Self\-managed AD \(AWS CLI\)<a name="create-joined-fsx-cli"></a>

 The following example creates an Amazon FSx for Windows File Server file system with a `SelfManagedActiveDirectoryConfiguration` in the `us-east-2` Availability Zone\. 

```
aws fsx --region us-east-2 \
create-file-system \
--file-system-type WINDOWS \
--storage-capacity 300 \
--security-group-ids security-group-id \
--subnet-ids subnet-id\
--windows-configuration SelfManagedActiveDirectoryConfiguration='{DomainName="corp.example.com", \
OrganizationalUnitDistinguishedName="OU=FileSystems,DC=corp,DC=example,DC=com",FileSystemAdministratorsGroup="FSxAdmins", \
UserName="FSxService",Password="password", \
   DnsIps=["10.0.1.18"]}',ThroughputCapacity=8
```