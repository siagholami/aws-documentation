# File System Access Control with Amazon VPC<a name="limit-access-security-groups"></a>

You access your Amazon FSx file system through an elastic network interface\. This network interface resides in the virtual private cloud \(VPC\) based on the Amazon Virtual Private Cloud \(Amazon VPC\) service that you associate with your file system\. You connect to your Amazon FSx file system through its Domain Name Service \(DNS\) name\. The DNS name maps to the private IP address of the file system's elastic network interface in your VPC\. Only resources within the associated VPC, resources connected with the associated VPC by AWS Direct Connect or VPN, or resources within peered VPCs can access your file system's network interface\. For more information, see [What is Amazon VPC?](https://docs.aws.amazon.com/vpc/latest/userguide/what-is-amazon-vpc.html) in the * Amazon VPC User Guide\.* 

**Warning**  
You must not modify or delete the elastic network interface\(s\) associated with your file system\. Modifying or deleting the network interface can cause a permanent loss of connection between your VPC and your file system\.

Amazon FSx for Windows File Server supports VPC sharing, which enables you to view, create, modify, and delete resources in a shared subnet in a VPC owned by another AWS account\. For more information, see [Working with Shared VPCs](https://docs.aws.amazon.com/vpc/latest/userguide/vpc-sharing.html) in the *Amazon VPC User Guide*\.

## Amazon VPC Security Groups<a name="fsx-vpc-security-groups"></a>

 To further control network traffic going through your file system's elastic network interface within your VPC, you use security groups to limit access to your file systems\. A *security group *is a stateful firewall that controls the traffic to and from its associated network interfaces\. In this case, the associated resource is your file system's network interface\. 

 To use a security group to control access to your Amazon FSx file system, add inbound and outbound rules\. Inbound rules control incoming traffic, and outbound rules control outgoing traffic from your file system\. Make sure that you have the right network traffic rules in your security group to map your Amazon FSx file system's file share to a folder on your supported compute instance\. 

For more information on security group rules, see [Security Group Rules](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-network-security.html#security-group-rules) in the *Amazon EC2 User Guide for Linux Instances\.*

**To create a security group for Amazon FSx**

1. Open the Amazon EC2 console at [https://console\.aws\.amazon\.com/ec2](https://console.aws.amazon.com/ec2)\.

1. In the navigation pane, choose **Security Groups**\.

1. Choose **Create Security Group**\.

1. Specify a name and description for the security group\.

1. For **VPC**, choose the Amazon VPC associated with your file system to create the security group within that VPC\.

1. <a name="vpc-sg-step6"></a>Add the following rules to allow outbound network traffic on the following ports: 

   1. Add the following inbound and outbound rules to allow the following ports\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/fsx/latest/WindowsGuide/limit-access-security-groups.html)

      Add from and to IP addresses or security group IDs associated with the following source and destination resources:
      + Client compute instances that you want to access your file system from\.
      + Other file servers that you expect your file system to communicate with in DFS Replication groups\.

   1. Add outbound rules to allow all traffic to the Active Directory that you're joining your file system to\. To do this, do one of the following:
      + Allow outbound traffic to the security group ID associated with your AWS Managed AD directory\. 
      + Allow outbound traffic to the IP addresses associated with your self\-managed Active Directory domain controllers\. 
**Note**  
In some cases, you might have modified the rules of your AWS Managed Microsoft AD security group from the default settings\. If so, make sure that this security group has the required inbound rules to allow traffic from your Amazon FSx file system\. For more information about the required inbound rules, see [AWS Managed Microsoft AD Prerequisites](https://docs.aws.amazon.com/directoryservice/latest/admin-guide/ms_ad_getting_started_prereqs.html) in the *AWS Directory Service Administration Guide*\.

Now that you've created your security group, you can associate it with your Amazon FSx file system's elastic network interface\.

**To associate a security group with your Amazon FSx file system**

1. Open the Amazon FSx console at [https://console\.aws\.amazon\.com/fsx/](https://console.aws.amazon.com/fsx/)\.

1. On the dashboard, choose your file system to view its details\.

1. Choose the **Network & Security** tab, and choose your file system's network interface ID \(for example, **ENI\-01234567890123456**\)\.

1. For **Actions**, choose **Change Security Groups**\.

1. In the **Change Security Groups** dialog box, choose the security groups to use, and choose **Save**\.

### Disallow Access to a File System<a name="disallow-access"></a>

 To temporarily disallow network access to your file system from all clients, you can remove all the security groups associated with your file system's elastic network interface\(s\) and replace them with a group that has no inbound/outbound rules\. 

## Amazon VPC Network ACLs<a name="limit-access-acl"></a>

Another option for securing access to the file system within your VPC is to establish network access control lists \(network ACLs\)\. Network ACLs are separate from security groups, but have similar functionality to add an additional layer of security to the resources in your VPC\. For more information on network ACLs, see [Network ACLs](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_ACLs.html) in the *Amazon VPC User Guide\.*