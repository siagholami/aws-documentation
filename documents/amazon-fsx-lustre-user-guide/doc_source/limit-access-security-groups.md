# File System Access Control with Amazon VPC<a name="limit-access-security-groups"></a>

An Amazon FSx file system is accessible through an elastic network interface that resides in the virtual private cloud \(VPC\) based on the Amazon VPC service that you associate with your file system\. You access your Amazon FSx file system through its DNS name, which maps to the file system's network interface\. Only resources within the associated VPC, or a peered VPC, can access your file system's network interface\. For more information, see [What is Amazon VPC?](https://docs.aws.amazon.com/vpc/latest/userguide/what-is-amazon-vpc.html) in the* Amazon VPC User Guide\.*

**Warning**  
You must not modify or delete the Amazon FSx elastic network interface\. Modifying or deleting the network interface can cause a permanent loss of connection between your VPC and your file system\.

## Amazon VPC Security Groups<a name="fsx-vpc-security-groups"></a>

To further control network traffic going through your file system's network interface within your VPC, you use security groups to limit access to your file systems\. A *security group* acts as a virtual firewall to control the traffic for its associated resources\. In this case, the associated resource is your file system's network interface\. You also use VPC security groups to control network traffic for your Lustre clients\. 

### Controlling Access Using Inbound and Outbound Rules<a name="inbound-outbound-rules"></a>

 To use a security group to control access to your Amazon FSx file system and Lustre clients, you add the inbound rules to control incoming traffic and outbound rules to control the outgoing traffic from your file system and Lustre clients\. Make sure to have the right network traffic rules in your security group to map your Amazon FSx file system's file share to a folder on your supported compute instance\. 

 For more information on security group rules, see [Security Group Rules](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-security-groups.html#security-group-rules) in the *Amazon EC2 User Guide for Linux Instances\.* 

**To create a security group for your Amazon FSx File System**

1. Open the Amazon EC2 console at [https://console\.aws\.amazon\.com/ec2](https://console.aws.amazon.com/ec2)\.

1. In the navigation pane, choose **Security Groups**\.

1. Choose **Create Security Group**\.

1. Specify a name and description for the security group\.

1. For **VPC**, choose the VPC associated with your Amazon FSx file system to create the security group within that VPC\.

1.  Choose **Create** to create the security group\. 

Next, you add inbound rules to the security group that you just created to enable Lustre traffic between your Amazon FSx for Lustre file servers\.

**To add inbound rules to your security group**

1. Select the security group you just created if it's not already selected\. For **Actions**, choose **Edit inbound rules**\.

1. Add the following inbound rules\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/fsx/latest/LustreGuide/limit-access-security-groups.html)

1. Choose **Save** to save and apply the new inbound rules\.

By default, security group rules allow all outbound traffic \(All, 0\.0\.0\.0/0\)\. If your security group doesn't allow all outbound traffic, add the following outbound rules to your security group\. These rules allow traffic between Amazon FSx for Lustre file servers and Lustre clients, and between Lustre file servers\.

**To add outbound rules to your security group**

1.  Choose the same security group to which you just added the inbound rules\. For **Actions**, choose **Edit outbound rules**\. 

1. Add the following outbound rules\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/fsx/latest/LustreGuide/limit-access-security-groups.html)

1. Choose **Save** to save and apply the new outbound rules\.

**To associate a security group with your Amazon FSx file system**

1. Open the Amazon FSx console at [https://console\.aws\.amazon\.com/fsx/](https://console.aws.amazon.com/fsx/)\.

1. On the console dashboard, chose your file system to view its details\.

1. On the **Network & Security** tab, choose your file system's network interface IDs \(for example, `ENI-01234567890123456`\)\. Doing this redirects you to the Amazon EC2 console\.

1. Choose each network interface ID\. Each action opens a new instance of the Amazon EC2 console in your browser\. For each security group, choose **Change Security Groups** for **Actions**\. 

1. In the **Change Security Groups** dialog box, choose the security groups to use, and choose **Save**\.

## Lustre Client VPC Security Group Rules<a name="lustre-client-inbound-outbound-rules"></a>

You use VPC security groups to control access to your Lustre clients by adding inbound rules to control incoming traffic and outbound rules to control the outgoing traffic from your Lustre clients\. Make sure to have the right network traffic rules in your security group to ensure that Lustre traffic can flow between your Lustre clients and your Amazon FSx file systems\.

Add the following inbound rules to the security groups applied to your Lustre clients\.


| Type | Protocol | Port Range | Source | Description | 
| --- | --- | --- | --- | --- | 
| Custom TCP rule | TCP | 988 | Choose Custom and enter the security group IDs of the security groups that are applied to your Lustre clients | Allows Lustre traffic between Lustre clients | 
| Custom TCP rule | TCP | 988 | Choose Custom and enter the security group IDs of the security groups associated with your Amazon FSx for Lustre file systems  | Allows Lustre traffic between Amazon FSx for Lustre file servers and Lustre clients | 
| Custom TCP rule | TCP | 1021\-1023 | Choose Custom and enter the security group IDs of the security groups that are applied to your Lustre clients | Allows Lustre traffic between Lustre clients | 
| Custom TCP rule | TCP | 1021\-1023 | Choose Custom and enter the security group IDs of the security groups associated with your Amazon FSx for Lustre file systems  | Allows Lustre traffic between Amazon FSx for Lustre file servers and Lustre clients | 

Add the following outbound rules to the security groups applied to your Lustre clients\.


| Type | Protocol | Port Range | Source | Description | 
| --- | --- | --- | --- | --- | 
| Custom TCP rule | TCP | 988 | Choose Custom and enter the security group IDs of the security groups that are applied to your Lustre clients | Allows Lustre traffic between Lustre clients | 
| Custom TCP rule | TCP | 988 | Choose Custom and enter the security group IDs of the security groups associated with your Amazon FSx for Lustre file systems | Allow Lustre traffic between Amazon FSx for Lustre file servers and Lustre clients | 
| Custom TCP rule | TCP | 1021\-1023 | Choose Custom and enter the security group IDs of the security groups that are applied to your Lustre clients | Allows Lustre traffic between Lustre clients | 
| Custom TCP rule | TCP | 1021\-1023 | Choose Custom and enter the security group IDs of the security groups associated with your Amazon FSx for Lustre file systems | Allows Lustre traffic between Amazon FSx for Lustre file servers and Lustre clients | 