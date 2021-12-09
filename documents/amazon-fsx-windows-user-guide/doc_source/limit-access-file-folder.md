# File\- and Folder\-Level Access Control Using Windows ACLs<a name="limit-access-file-folder"></a>

Amazon FSx for Windows File Server supports identity\-based authentication over the Server Message Block \(SMB\) protocol through Microsoft Active Directory\. Active Directory is the Microsoft directory service to store information about objects on the network and make this information easy for administrators and users to find and use\. These objects typically include shared resources such as file servers, and the network user and computer accounts\. To learn more about Active Directory support in Amazon FSx, see [Working with Active Directory in Amazon FSx for Windows File Server](aws-ad-integration-fsxW.md)\.

Your domain\-joined compute instances can access Amazon FSx file shares using Active Directory credentials\. You use standard Windows access control lists \(ACLs\) for fine\-grained file\- and folder\-level access control\. Amazon FSx file systems automatically verify the credentials of users accessing file system data to enforce these Windows ACLs\.

 Every Amazon FSx file system comes with a default Windows file share called `share`\. The Windows ACLs for this shared folder are configured to allow read/write access to domain users\. They also allow full control to the delegated administrators group in your Active Directory that is delegated to perform administrative actions on your file systems\. If you're integrating your file system with AWS Managed Microsoft AD, this group is AWS Delegated FSx Administrators\. If you're integrating your file system with your self\-managed Microsoft AD setup, this group can be Domain Admins\. Or it can be a custom delegated administrators group that you specified when creating the file system\. To change the ACLs, you can map the share as a user that is a member of the delegated administrators group\. 


|  | 
| --- |
|  Amazon FSx requires that the SYSTEM user have **Full control** NTFS ACL permissions on all folders within your file system\. Do not change the NTFS ACL permissions for this user on your folders\. Doing so can make your file share inaccessible\.  | 

## Related Links<a name="ad-related-topics"></a>
+ [What Is AWS Directory Service?](https://docs.aws.amazon.com/directoryservice/latest/admin-guide/what_is.html) in the AWS Directory Service Administration Guide\.
+ [Create Your AWS Managed Microsoft AD directory](https://docs.aws.amazon.com/directoryservice/latest/admin-guide/ms_ad_getting_started_create_directory.html) in the *AWS Directory Service Administration Guide*\.
+ [When to Create a Trust Relationship](https://docs.aws.amazon.com/directoryservice/latest/admin-guide/ms_ad_setup_trust.html) in the *AWS Directory Service Administration Guide*\.
+ [Walkthrough 1: Prerequisites for Getting Started](walkthrough01-prereqs.md)\.