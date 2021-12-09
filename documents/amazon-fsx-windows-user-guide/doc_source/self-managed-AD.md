# Using Amazon FSx with Your Self\-Managed Microsoft Active Directory<a name="self-managed-AD"></a>

Your organization might manage identities and devices on a self\-managed Active Directory \(on\-premises or in the cloud\)\. If so, you can join your Amazon FSx file system directly to your existing self\-managed AD domain\. To use Amazon FSx with your AWS Managed Microsoft AD setup, you can use the Amazon FSx console\. When you create a new Amazon FSx for Windows File Server file system in the console, choose **Self\-managed Microsoft Active Directory** under the **Windows Authentication** section\. Provide the following details for your self\-managed AD: 
+  A fully qualified domain name of your self\-managed directory 
**Note**  
Domain name must not be in the Single Label Domain \(SLD\) format\. Amazon FSx currently does not support SLD domains\.
+  IP addresses of the DNS servers for your domain 
+  User name and password for a service account on your AD domain, for Amazon FSx to use to join the file system to your AD domain 
+  \(Optional\) The Organizational Unit \(OU\) in your domain in which you want your file system to be joined
+ \(Optional\) The domain group to which you want to delegate authority to perform administrative actions on your file system\. For example, this domain group might manage Windows file shares, manage ACLs on the file system's root folder, take ownership of files and folders, and so on\. If you don’t specify this group, Amazon FSx delegates this authority to the Domain Admins group in your AD domain by default\. 

  For more information, see [Joining an Amazon FSx File System to a Self\-Managed Microsoft Active Directory Domain](creating-joined-ad-file-systems.md)\.

 When you join your file system directly to your self\-managed AD, your Amazon FSx for Windows File Server resides in the same AD forest \(the top\-most logical container in an AD configuration that contains domains, users, and computers\) and in the same AD domain as your users and existing resources \(including existing file servers\)\. 

**Note**  
If you’d like to beneﬁt from a resource forest isolation model, where you isolate your resources, including your Amazon FSx ﬁle systems, into a separate AD forest from the one where your users reside, you can alternately choose to join your ﬁle system to an AWS Managed AD and establish a one\-way forest trust relationship between an AWS Managed AD that you create and your existing self\-managed AD\. 

**Topics**
+ [Prerequisites for Using a Self\-Managed Microsoft AD](self-manage-prereqs.md)
+ [Best Practices for Joining Amazon FSx for Windows File Server File Systems to a Self\-managed Microsoft Active Directory Domain](self-managed-AD-best-practices.md)
+ [Joining an Amazon FSx File System to a Self\-Managed Microsoft Active Directory Domain](creating-joined-ad-file-systems.md)