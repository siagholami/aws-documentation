# Managing Security Groups from AWS Explorer<a name="tke-sg"></a>

The AWS Toolkit for Eclipse enables you to create and configure security groups to use with Amazon Elastic Compute Cloud \(Amazon EC2\) instances\. When you launch an Amazon EC2 instance, you need to specify an associated security group\.

A security group acts like a firewall on incoming network traffic\. The security group specifies what types of network traffic an Amazon EC2 instance will allow to be received\. It can also specify that incoming traffic will be accepted only from certain IP addresses or only from other specified security groups\.

## Creating a New Security Group<a name="tke-sg-create"></a>

In this section, we’ll create a new security group\. Initially after creation, the security group will not have any permissions configured\. Configuring permissions is handled through an additional operation\.

**To create a new security group**

1. In **AWS Explorer**, beneath the **Amazon EC2** node, right\-click **Security Groups**, and then click **Open EC2 Security Groups View**\.

1. Right\-click in the left pane of the **EC2 Security Groups** tab, and then click **New Group**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/tke-sg-ec2-sg-tab.png)

1. In the dialog box, enter a name and description for the new security group\. Click **OK**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/tke-sg-new-dlg.png)

## Adding Permissions to Security Groups<a name="tke-permission-sg"></a>

In this section, we’ll add permissions to the new security group to allow other computers to connect to our Amazon EC2 instance using Secure Shell \(SSH\) protocol\.

**To add permissions to a security group**

1. Right\-click in the right pane of the **EC2 Security Groups** tab, and then click **Add Permissions**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/tke-sg-add-perms.png)

1. In the dialog box, select **Protocol, port and network**\. Click **TCP** from the **Protocol** drop\-down menu\. Enter `22` for **Port or Port Range**\. Port 22 is the standard port for SSH\. The **Network Mask** box specifies the allowed source IP addresses in CIDR format; it defaults to 0\.0\.0\.0/0, which specifies that the security group will allow a TCP connection to port 22 \(SSH\) from any external IP address\.

   You could also, for example, specify that connections should be allowed only from computers in your local computer’s subnet\. In this case, you would specify your local computer’s IP address followed by a “/10”\. For example, “xxx\.xxx\.xxx\.xxx/10” where the “xxx” correspond to the distinct octet values that make up your local computer’s IP address\.

   Click **OK**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/tke-sg-assign-perms-dlg.png)

You could also set permissions to the security group by specifying a UserID and security group name\. In this case, Amazon EC2 instances in this security group would accept all incoming network traffic from Amazon EC2 instances in the specified security group\. It is necessary to also specify the UserID as a way to disambiguate the security group name; security group names are not required to be unique across all of AWS\. For more information about security groups, see [Network and Security](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EC2_Network_and_Security.html) in the Amazon EC2 User Guide for Linux Instances\.