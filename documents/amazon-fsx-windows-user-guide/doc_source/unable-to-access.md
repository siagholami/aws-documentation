# You Can't Access Your File System<a name="unable-to-access"></a>

There are a number of potential causes for being unable to access your file system, each with their own resolution, as follows\.

**Potential Cause**  
The FSx elastic network interface for your file system was modified or deleted\.

**Resolution**  
You must not modify or delete the FSx elastic network interface\. Modifying or deleting the network interface can cause a permanent loss of connection between your VPC and your file system\. Create a new file system, and do not modify or delete the FSx elastic network interface\. For more information, see [ File System Access Control with Amazon VPC ](limit-access-security-groups.md)\. 

**Potential Cause**  
The security group that you specified for your Amazon FSx file system lacks the required inbound rules\.

**Resolution**  
Make sure that your security group has the inbound rules specified in [Amazon VPC Security Groups](limit-access-security-groups.md#fsx-vpc-security-groups)\. 

**Potential Cause**  
The security group that you associated with your compute instances lacks the required outbound rules\.

**Resolution**  
Review the outbound rules specified in [Amazon VPC Security Groups](limit-access-security-groups.md#fsx-vpc-security-groups), and make sure that the security group associated with your compute instances has the corresponding outbound rules\.

**Potential Cause**  
Your compute instances might not be correctly joined to one of two types of Active Directory\. In a working setup, they can be joined to the AWS Managed Microsoft AD directory to which your file system is joined\. Or they can be joined to a Microsoft Active Directory directory that has a one\-way forest trust relationship established with the AWS Managed Microsoft AD directory\.

**Resolution**  
Make sure that your compute instances are joined to one of two types of directory\. One type is the AWS Managed Microsoft AD directory to which your file system is joined\. The other type is a Microsoft AD directory that has a one\-way forest trust relationship established with the AWS Managed Microsoft AD directory\.

**Potential Cause**  
The Microsoft Windows file share that you're attempting to access doesn't exist\.

**Resolution**  
If you're using an existing file share, make sure that the file system DNS name and the share name are correctly specified\. To manage your file shares, see [File Shares](managing-file-shares.md)\.

**Potential Cause**  
The Active Directory user that you're accessing the file share as lacks the necessary access permissions\.

**Resolution**  
Make sure that the access permissions for the file share and Windows access control lists \(ACLs\) for the shared folder allow access to the Active Directory users that need to access it\.

**Potential Cause**  
If you remove **Allow Full control** NTFS ACL permissions for the SYSTEM user on a folder that you shared, that share can become inaccessible\.

**Resolution**  
Re\-create your file share or shares\. For more information, see [File Shares](managing-file-shares.md)\. After they're re\-created, you can map and use the Windows file shares from your compute instance or instances\.

**Potential Cause**  
You're using your Amazon FSx file system from on\-premises using AWS Direct Connect or VPN, and you're using a public IP address range for the on\-premises client\.

**Resolution**  
Use a private IP address range for the on\-premises client\. For more information, see [Accessing Amazon FSx for Windows File Server File Systems from On\-Premises](supported-fsx-clients.md#on-premise-access)\. 