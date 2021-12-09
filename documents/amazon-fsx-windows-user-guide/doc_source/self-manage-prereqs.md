# Prerequisites for Using a Self\-Managed Microsoft AD<a name="self-manage-prereqs"></a>

Before you create an Amazon FSx file system joined to your self\-managed Microsoft AD domain, make sure that you have created and set up the following requirements:
+ An on\-premises or other self\-managed Microsoft AD that the Amazon FSx file system is to join, with the following configuration:
  +  The domain functional level of your AD domain controller is at Windows Server 2008 R2 or higher\.
  + DNS server IP addresses and AD domain controller IP addresses that are in one of the following:
    + The same subnet\(s\) as the one in which your Amazon FSx file system is being created
    + The primary VPC CIDR range of the VPC in which your Amazon FSx file system is being created 
    + The following private IP address ranges, as specified in [RFC 1918](http://www.faqs.org/rfcs/rfc1918.html):
      + 10\.0\.0\.0–10\.255\.255\.255 \(10/8 prefix\)
      + 172\.16\.0\.0–172\.31\.255\.255 \(172\.16/12 prefix\)
      + 192\.168\.0\.0–192\.168\.255\.255 \(192\.168/16 prefix\)
  +  Domain name that is not in the Single Label Domain \(SLD\) format\. Amazon FSx does not support SLD domains\. 
  + If you have Active Directory sites defined, you must make sure that the subnets in the VPC associated with your Amazon FSx file system are defined in an Active Directory site, and that no conflicts exist between the subnets in your VPC and the subnets in your other sites\.
+ The following network configurations:
  + Connectivity configured between the VPC based on Amazon VPC where you want to create the file system and your self\-managed Active Directory\. You can set up connectivity using AWS Direct Connect, AWS VPN, VPC peering, or AWS Transit Gateway\.
  +  VPC Security Groups that you've associated with your Amazon FSx file system, along with any VPC Network ACLs, configured to allow outbound network traffic on the following ports:     
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/fsx/latest/WindowsGuide/self-manage-prereqs.html)
**Important**  
Allowing outbound traffic on TCP port 9389 is required for Single\-AZ 2 and all Multi\-AZ file system deployments\.
  + Add outbound rules to allow all traffic to the Active Directory that you're joining your file system to\. To do this, do one of the following:
    + Allow outbound traffic to the security group ID associated with your AWS Managed AD directory\. 
    + Allow outbound traffic to the IP addresses associated with your self\-managed Active Directory domain controllers\. 
  +  Windows Firewall on your Active Directory domain controllers configured to allow inbound traffic on the above mentioned ports from the subnet\(s\) where you'd like to have your Amazon FSx file system\. 

     In the case where the domain controllers are in AWS, the VPC Security Groups that you've associated with them, along with any VPC Network ACLs, configured to allow inbound traffic on the above mentioned ports\.

  Use the [Amazon FSx Network Validation tool](validate-ad-config.md#test-ad-network-config) to test these network settings before attempting to join your file system to your self\-managed AD\.
+  A service account in your self\-managed Microsoft AD with delegated permissions to join computers to the domain\. A *service account *is a user account in your self\-managed Microsoft AD that has been delegated certain tasks\. 

   The service account also needs to, at a minimum, be delegated the following permissions in the OU that you're joining the file system to: 
  + Ability to reset passwords
  + Ability to restrict accounts from reading and writing data
  + Validated ability to write to the DNS host name 
  + Validated ability to write to the service principal name 
  + Be delegated control to create and delete computer objects

To learn more about creating a service account with the correct permissions, see [ Delegating Privileges to Your Amazon FSx Service Account ](self-managed-AD-best-practices.md#connect_delegate_privileges)\.

**Note**  
Amazon FSx requires a valid service account throughout the lifetime of your Amazon FSx file system\. Amazon FSx must be able to fully manage the file system and perform tasks that require unjoining and rejoining your AD domain using, such as replacing a failed file server or patching Windows Server software\. Please keep your Active Directory configuration, including the service account credentials, updated with Amazon FSx\. To learn how, see [Keeping Your Active Directory Configuration Updated with Amazon FSx](self-managed-AD-best-practices.md#keep-ad-config-updated)\.

 If this is your first time using AWS and Amazon FSx for Windows File Server, make sure to set up before starting\. For more information, see [Setting Up](setting-up.md)\. 