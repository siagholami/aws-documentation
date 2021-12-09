# Walkthrough 5: Using a Custom DNS Name for Your File System<a name="walkthrough05-file-system-custom-CNAME"></a>

Amazon FSx for Windows File Server provides a Domain Name Service \(DNS\) name for every file system of the form *filesystem\.your\-domain* using DNS integrated with Microsoft Active Directory\. This DNS name is created on the AWS Directory Service for Microsoft Active Directory \(AWS Managed Microsoft AD\) directory to which you join your file system\. 

You can add a custom DNS name for your Amazon FSx file system within your Microsoft AD directory\. Doing this can make it easier to manage mapping the file shares within your file systems for large organizations or for discrete use cases\. To add a custom DNS name for your file system from a Microsoft Windows Server client that is joined to the same AWS Managed Microsoft AD directory, use the DNS Manager application \(`dnsmgmt.msc`\)\.

**Note**  
Amazon FSx for Windows File Server supports custom DNS names only on Single\-AZ 1 file systems\. Support for custom DNS names on Multi\-AZ and Single\-AZ 2 file systems coming soon\.

**To add a custom DNS name to your Amazon FSx file system**

1. Launch your Windows EC2 instance and connect it to the Microsoft Active Directory to which you've joined your Amazon FSx file systems\. To perform this action, choose one of the following procedures from the *AWS Directory Service Administration Guide*:
   + [Seamlessly Join a Windows EC2 Instance](https://docs.aws.amazon.com/directoryservice/latest/admin-guide/launching_instance.html)
   + [Manually Join a Windows Instance](https://docs.aws.amazon.com/directoryservice/latest/admin-guide/join_windows_instance.html)

1. Connect to your Amazon EC2 instance as a user that is a member of a group that has DNS administration permissions \(**AWS Delegated Domain Name System Administrators** in AWS Managed AD, and **Domain Admins** or another group to which you’ve delegated DNS administration permissions in your self\-managed AD\) For more information, see [Connecting to Your Windows Instance](https://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/connecting_to_windows_instance.html) in the *Amazon EC2 User Guide for Windows Instances*\.

1. Open the **Start** menu and enter `dnsmgmt.msc` to open the DNS Manager application\.
**Note**  
If DNS Manager isn't already installed, you can install it from the Add Roles and Features wizard of the **Server Manager** application\.

1. In **DNS Manager**, choose **Forward Lookup Zones** from the left navigation\.

1. Open the context \(right\-click\) menu for your AWS Managed Microsoft AD directory, and choose **New Alias \(CNAME\)** to open the **New Resource Record** dialog box\.

1. For **Alias name**, enter the name to use for your Amazon FSx file system\.

1. For **Fully qualified domain name \(FQDN\) for target host**, choose **Browse**\.

1. In the **Browse** dialog box that opens, double\-click on the record name for your target host\.

1. Double\-click on **Forward Lookup Zone**, and then double\-click on the original name of your Amazon FSx file server\.

1. Choose the name of a server, and then choose **OK**\.

You've now added a `CNAME` value for your Amazon FSx file system\. You can use this `CNAME` value to access your data within this Microsoft Active Directory\.