# Best Practices for Joining Amazon FSx for Windows File Server File Systems to a Self\-managed Microsoft Active Directory Domain<a name="self-managed-AD-best-practices"></a>

Here are some suggestions and guidelines you should consider when joining Amazon FSx for Windows File Server ﬁle systems to your self\-managed Microsoft Active Directory\. Note that these are recommended as best practices, but not required\.

## Delegating Privileges to Your Amazon FSx Service Account<a name="connect_delegate_privileges"></a>

Make sure to configure the service account that you provide to Amazon FSx with the minimum privileges required\. In addition, segregate the Organizational Unit \(OU\) from other domain controller concerns\. 

To join Amazon FSx file systems to your domain, make sure that the service account has delegated privileges\. Members of the **Domain Admins** group have sufficient privileges to perform this task\. However, as a best practice, use a service account that only has the minimum privileges necessary to do this\. The following procedure demonstrates how to delegate just the privileges necessary to join Amazon FSx file systems to your domain\.

Perform this procedure on a machine that is joined to your directory and has the Active Directory User and Computers MMC snap\-in installed\. 

**To create a service account for your Active Directory domain**

1. Make sure that you are logged in as a domain administrator for your Active Directory domain\. 

1. Open the **Active Directory User and Computers** MMC snap\-in\.

1. In the task pane, expand the domain node\. 

1. Locate and open the context \(right\-click\) menu for the OU that you want to modify, and then choose **Delegate Control**\.

1. On the **Delegation of Control Wizard** page, choose **Next**\.

1. Choose **Add** to add a specific user or a specific group for **Selected users and groups**, and then choose **Next**\.

1. On the **Tasks to Delegate** page, choose **Create a custom task to delegate**, and then choose **Next**\.

1. Choose **Only the following objects in the folder**, and then choose **Computer objects**\.

1. Choose **Create selected objects in this folder** and **Delete selected objects in this folder**\. Then choose **Next**\.

1. For **Permissions**, choose the following:
   + **Reset Password**
   + **Read and write Account Restriction**s
   + **Validated write to DNS host name**
   + **Validated write to service principal name**

1. Choose **Next**, and then choose **Finish**\.

1. Close the Active Directory User and Computers MMC snap\-in\.

## Keeping Your Active Directory Configuration Updated with Amazon FSx<a name="keep-ad-config-updated"></a>

To help ensure continued, uninterrupted availability of your Amazon FSx file system, update the file system's self\-managed Active Directory \(AD\) configuration any time that you make changes to your self\-managed AD setup\. 

For example, suppose that your AD uses a time\-based password reset policy\. In this case, as soon as the password is reset, make sure to update the service account password with Amazon FSx\. To do this, use the Amazon FSx console, Amazon FSx API, or AWS CLI\. Similarly, if the DNS server IP addresses change for your Active Directory domain, as soon as the change occurs update the DNS server IP addresses with Amazon FSx\. Again, do this using the Amazon FSx console, API, or CLI\. 

When you update the self\-managed AD configuration for your Amazon FSx file system, your file system's state switches from **Available** to **Updating** while the update is applied\. Verify that the state switches back to **Available** after the update has been applied – note that the update can take up to several minutes to complete\.

If there's an issue with the updated self\-managed AD configuration, the file system state switches to **Misconfigured**\. This state shows an error message and recommended action beside the file system description in the console, API, and CLI\. If an issue happens, take the recommended corrective action to provide the correct configuration properties\. If the issue is resolved, verify that your file system's state changes to **Updating** and eventually to **Available**\. To learn more about troubleshooting possible self\-managed AD misconfigurations, see [File System Is In a Misconfigured State](misconfigured-ad-config.md)\. 

## Using Security Groups to Limit Traffic Within Your VPC<a name="least-privilege-sg-rules"></a>

To limit network traffic in your virtual private cloud \(VPC\), you can implement the principle of least privilege in your VPC\. In other words, you can limit privileges to the minimum ones necessary\. To do this, use security group rules\. To learn more, see [Amazon VPC Security Groups](limit-access-security-groups.md#fsx-vpc-security-groups)\. 

## Creating Outbound Security Group Rules for Your File System's Network Interface<a name="sg-rules-fsx-eni"></a>

For greater security, consider configuring a security group with outbound traffic rules\. These rules should allow outbound traffic only to your self\-managed Microsoft AD domains controllers or within the subnet or security group\. Apply this security group to the VPC associated with your Amazon FSx file system's elastic network interface\. To learn more, see [ File System Access Control with Amazon VPC ](limit-access-security-groups.md)\. 