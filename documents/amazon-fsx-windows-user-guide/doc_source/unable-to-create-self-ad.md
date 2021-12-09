# Troubleshooting File Systems Joined to a Self\-Managed Active Directory<a name="unable-to-create-self-ad"></a>

**Error Message**  
 Amazon FSx can't reach the DNS servers provided or the domain controllers for your self\-managed directory in Microsoft Active Directory\. File system creation failed\. Amazon FSx is unable to communicate with your Microsoft Active Directory domain controllers\. This is because Amazon FSx can't reach the DNS servers provided or domain controllers for your domain\. To fix this problem, delete your file system and create a new one with valid DNS servers and networking configuration that allows traffic from the file system to the domain controller\. 

**Resolution**  
Use the following to troubleshoot and resolve the issue\.

****

1.  Verify that you followed the prerequisites for having network connectivity and routing established between the subnet where you're creating an Amazon FSx file system, and your self\-managed Active Directory\. For more information, see [Prerequisites for Using a Self\-Managed Microsoft AD](self-manage-prereqs.md)\. 
**Note**  
If you have multiple Active Directory sites defined, ensure that the subnets in the VPC associated with your Amazon FSx file system are defined in an Active Directory site and that no IP conflicts exist between the subnets in your VPC and the subnets in your other sites\. You can view and change these settings using the Active Directory Sites and Services MMC snap\-in\.

1.  Verify that you configured the VPC security groups that you associated with your Amazon FSx file system, along with any VPC network ACLs, to allow outbound network traffic on all ports\. 
**Note**  
If you want to implement least privilege, you can allow outbound traffic only to the specific ports required for communication with the Active Directory domain controllers\. For more information, see the [Microsoft Active Directory documentation](https://support.microsoft.com/en-us/help/179442/how-to-configure-a-firewall-for-domains-and-trusts)\. 

1.  Verify that your AD domain's DNS servers and domain controllers are active and able to respond to requests for the domain provided\. 

1.  Ensure that the functional level of your AD domain is Windows Server 2008 R2 or higher\. 

1.  Make sure that the firewall rules on your AD domain's domain controllers allow traffic from your Amazon FSx file system\. For more information, see the [Microsoft Active Directory documentation](https://support.microsoft.com/en-us/help/179442/how-to-configure-a-firewall-for-domains-and-trusts)\. 

**Error Message**  
 Amazon FSx is unable to establish a connection with your Microsoft Active Directory domain controllers because the service account credentials provided are invalid\. To fix this problem, delete your file system and create a new one using a valid service account\. 

**Resolution**  
Use the following to troubleshoot and resolve the issue\.

1.  Verify that you're entering only the user name as input for the **Service account username**, such as `ServiceAcct`, in the self\-managed Active Directory configuration\. 
**Important**  
 DO NOT include a domain prefix \(`corp.com\ServiceAcct`\) or domain suffix \(`ServiceAcct@corp.com`\) when entering the service account user name\.   
 DO NOT use the distinguished name \(DN\) when entering the service account user name \(CN=ServiceAcct,OU=example,DC=corp,DC=com\)\. 

1.  Verify that the service account that you provided exists in your AD domain\. 

1.  Make sure that you delegated the required permissions to the service account that you provided\. The service account must be able to create and delete computer objects in the OU in the domain to which you're joining the file system\. The service account also needs, at a minimum, to have permissions to do the following: 
   +  Reset passwords 
   +  Restrict accounts from reading and writing data 
   +  Validated ability to write to the DNS host name 
   +  Validated ability to write to the service principal name 

    For more information about creating a service account with correct permissions, see [ Delegating Privileges to Your Amazon FSx Service Account ](self-managed-AD-best-practices.md#connect_delegate_privileges)\. 

**Error Message**  
 Amazon FSx is unable to establish a connection with your Microsoft Active Directory domain controllers\. This is because the service account provided does not have permission to join the file system to the domain with the specified organizational unit\. To fix this problem, delete your file system and create a new one using a service account with permission to join the file system to the domain with the specified organizational unit\. 

**Resolution**  
Use the following procedure to troubleshoot and resolve the issue\.
+  Make sure that you delegated the required permissions to the service account that you provided\. The service account must be able to create and delete computer objects in the OU in the domain to which you're joining the file system\. The service account also needs, at a minimum, to have permissions to do the following: 
  +  Reset passwords 
  +  Restrict accounts from reading and writing data 
  +  Validated ability to write to the DNS host name 
  +  Validated ability to write to the service principal name 

   For more information about creating a service account with correct permissions, see [ Delegating Privileges to Your Amazon FSx Service Account ](self-managed-AD-best-practices.md#connect_delegate_privileges)\. 

**Error Message**  
Amazon FSx can't establish a connection with your Microsoft Active Directory domain controllers\. This is because the service account provided has reached the maximum number of computers that it can join to the domain\. To fix this problem, delete your file system and create a new one, supplying a service account that is able to join new computers to the domain\.

**Resolution**  
Use the following procedure to troubleshoot and resolve the issue\.
+  Make sure that the service account you provided has not reached the maximum number of computers it can join to the domain\. If it has reached the maximum limit, create a new service account with the correct permissions\. For more information, see [ Delegating Privileges to Your Amazon FSx Service Account ](self-managed-AD-best-practices.md#connect_delegate_privileges)\.

**Error Message**  
Amazon FSx can't establish a connection with your Microsoft Active Directory domain controller\(s\)\. This is because the organizational unit you specified either doesn't exist or isn't accessible to the service account provided\. To fix this problem, delete your file system and create a new one specifying an organizational unit to which the service account can join the file system\. 

**Resolution**  
 Use the following procedure to troubleshoot and resolve the issue\. 

1.  Verify that the OU you provided is in your Active Directory domain\. 

1.  Make sure that you delegated the required permissions to the service account that you provided\. The service account must be able to create and delete computer objects in the OU in the domain to which you're joining the file system\. The service account also needs, at a minimum, to have permissions to do the following: 
   +  Reset passwords 
   +  Restrict accounts from reading and writing data 
   +  Validated ability to write to the DNS host name 
   +  Validated ability to write to the service principal name 

    For more information about creating a service account with correct permissions, see [ Delegating Privileges to Your Amazon FSx Service Account ](self-managed-AD-best-practices.md#connect_delegate_privileges)\. 

**Error Message**  
Amazon FSx is unable to apply your Microsoft Active Directory configuration\. This is because the file system administrators group you provided either doesn't exist or isn't accessible to the service account you provided\. To fix this problem, delete your file system and create a new one specifying a file system administrators group in the domain that is accessible to the service account provided\.

**Resolution**  
Use the following procedure to troubleshoot and resolve the issue\.

1.  Ensure that you’re providing just the name of the group as a string for the administrators group parameter\. 
**Important**  
 DO NOT include a domain prefix \(`corp.com\FSxAdmins`\) or domain suffix \(`FSxAdmins@corp.com`\) when providing the group name parameter\.   
 DO NOT use the distinguished name \(DN\) for the group\. An example of a distinguished name is CN=FSxAdmins,OU=example,DC=corp,DC=com\. 

1.  Ensure that the administrators group provided exists in the same Active Directory domain as the one to which you were trying to join the file system\. 

1.  If you did not provide an administrator group parameter, Amazon FSx attempts to use the `Builtin Domain Admins` group in your AD domain\. If the name of this group has been changed, or if you’re using a different group for domain administration, you need to provide that name for the group\. 

**Error Message**  
 Amazon FSx is unable to apply your Microsoft Active Directory configuration\. To fix this problem, delete your file system and create a new one meeting the pre\-requisites described in the Amazon FSx user guide\. 

**Resolution**  
 When creating your file system, Amazon FSx was able to reach your AD domain’s DNS servers and domain controllers, and join the file system successfully to your AD domain\. However, while completing file system creation, Amazon FSx lost connectivity to or membership in your domain\. Use the following to troubleshoot and resolve the issue\.

1.  Ensure that network connectivity continues to exist between your Amazon FSx file system and your Active Directory\. And, ensure that network traffic continues to be allowed between them by using routing rules, VPC security group rules, VPC network ACLs, and domain controller firewall rules\. 

1.  Ensure that the computer objects created by Amazon FSx for your file systems in your AD domain are still active, and were not deleted or otherwise manipulated\. 

**Error Message**  
 File system creation failed\. Amazon FSx is unable to establish a connection with your Microsoft Active Directory domain controller\(s\)\. This is because the service account provided does not have permission to join the file system to the domain with the specified organizational unit \(OU\)\. To fix this problem, delete your file system and create a new one using a service account with permission to create computer objects and reset passwords within the specified organizational unit\. 

**Resolution**  
Make sure that you delegated the required permissions to the service account that you provided\. Use the following to troubleshoot and resolve the issue\.

 The service account needs to have, at a minimum, the following permissions: 
+ Be delegated control to create and delete computer objects in the OU that you’re joining the file system to
+ Have the following permissions in the OU that you’re joining the file system to:
  + Ability to reset passwords
  + Ability to restrict accounts from reading and writing data
  + Validated ability to write to the DNS host name 
  + Validated ability to write to the service principal name 

  For more information about creating a service account with the correct permissions, see [ Delegating Privileges to Your Amazon FSx Service Account ](self-managed-AD-best-practices.md#connect_delegate_privileges)\.

If you encounter problems not listed here while using Amazon FSx, ask a question in the [Amazon FSx Forum](https://forums.aws.amazon.com/forum.jspa?forumID=308) or contact [AWS Support](https://aws.amazon.com/premiumsupport/)\.