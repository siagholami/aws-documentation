# Launch an Amazon EC2 Instance from an Amazon Machine Image<a name="ami-launch"></a>

Before launching an EC2 instance, you should create a security group that will permit network traffic that is appropriate to your application to connect to the instance\. At a minimum, the security group should enable access on port 22, so that you can SSH into the EC2 instance\. You may also want to create a keypair, although you can also create the keypair while going through the launch wizard\. Finally, you should think about which instance type is appropriate to your application; the price for an EC2 instance is typically higher for the more powerful types of instances\. You can find a list of instance types and pricing information on the [EC2 Pricing](https://aws.amazon.com/ec2/pricing/) page\.

**To launch an Amazon EC2 instance**

1. In **AWS Explorer**, expand the **Amazon EC2** node\. Right\-click the **Amazon Machine Images \(AMIs\)** subnode and select **Open EC2 AMIs View**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/amzn-exp-open-ami-view.png)

1. Configure the AMIs view to show the AMI that we’ll use in this example\. In the filter box, type ** `start ebs` **\. This filters the list of AMIs to show only those AMIs with names that contains both “start” and “ebs”\.

   Right\-click the **amazon/getting\-started\-with\-ebs** AMI and select **Launch** from the context menu\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/ami-view-launch-start-ebs.png)

1. In the **Launch EC2 Instance** dialog box, configure the AMI for your application\.  
** *Number of Hosts* **  
Set this value to the number of EC2 instances to launch\.  
** *Instance Type* **  
Select the type of the EC2 instance to launch\. You can find a list of instance types and pricing information on the [EC2 Pricing](https://aws.amazon.com/ec2/pricing/) page\.  
** *Availability Zone* **  
Select an availability zone \(AZ\) in which to launch the instance\. Note that not all AZs are available in all regions\. If the AZ that you select is not available, the Toolkit will generate a message saying that you need to select a different AZ\. For more information about AZs, go to the [Region and Availability Zone FAQ](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-regions-availability-zones.html) in the Amazon EC2 User Guide for Linux Instances\.  
** *Key Pair* **  
A key pair is a set of public/private encryption keys that are used to authenticate you when you connect to the EC2 instance using SSH\. Select a keypair for which you have access to the private key\.  

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/inline-keypair-create.png)  
** *Security Group* **  
The security group controls what type of network traffic the EC2 instance will accept\. You should select a security group that will allow incoming traffic on port 22, i\.e\. the port that is used by SSH, so that you can connect to the EC2 instance\. For information about how to create security groups using the Toolkit, see [Managing Security Groups from AWS Explorer](tke-sg.md)   
** *Instance Profile* **  
The instance profile is a logical container for an IAM role\. When you select an instance profile, you associate the corresponding IAM role with the EC2 instance\. IAM roles are configured with policies that specify access to particular AWS services and account resources\. When an EC2 instance is associated with an IAM role, application software that runs on the instance runs with the permissions specified by the IAM role\. This enables the application software to run without having to specify any AWS credentials of its own, which makes the software more secure\. For in\-depth information about IAM roles, go to [Working with Roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html) in the IAM User Guide\.  
** *User Data* **  
The user data is data that you provide to the application software that runs on your EC2 instance\. The application software can access this data through the [Instance Meta Data Service \(IMDS\)](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-instance-metadata.html)\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/launch-ami-tke.png)

1. Click **Finish**\.

1. In AWS Explorer, under the **Amazon EC2** node, right\-click the **Instances** subnode and select **Open EC2 Instances View**\.

   Your EC2 instance should appear in the **EC2 Instances** view\. It may take a few minutes for the instance to transition into the **running** state\. Once the instance is running, you can right\-click the instance to bring up a context menu of operations that you can perform on the instance\. For example, you can terminate the instance from this menu\. You can also copy the instance’s public DNS address\. You would use this address to connect to the instance using SSH\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/instances-view-ami-launch-start-ebs.png)