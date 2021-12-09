# Managing Security Groups from AWS Explorer<a name="tkv-sg-create"></a>

The Toolkit for Visual Studio enables you to create and configure security groups to use with Amazon Elastic Compute Cloud \(Amazon EC2\) instances and AWS CloudFormation\. When you launch Amazon EC2 instances or deploy an application to AWS CloudFormation, you specify a security group to associate with the Amazon EC2 instances\. \(Deployment to AWS CloudFormation creates Amazon EC2 instances\.\)

A security group acts like a firewall on incoming network traffic\. The security group specifies which types of network traffic are allowed on an Amazon EC2 instance\. It can also specify that incoming traffic will be accepted from certain IP addresses only or from specified users or other security groups only\.

## Creating a Security Group<a name="tkv-sg-create-security"></a>

In this section, we'll create a security group\. After it has been created, the security group will not have any permissions configured\. Configuring permissions is handled through an additional operation\.

 *To create a security group* 

1. In AWS Explorer, under the **Amazon EC2** node, open the context \(right\-click\) menu on the **Security Groups** node, and then choose **View**\.

1. On the **EC2 Security Groups** tab, choose **Create Security Group**\.

1. In the **Create Security Group** dialog box, type a name and description for the security group, and then choose **OK**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-ec2-sg-create.png)

## Adding Permissions to Security Groups<a name="tkv-permission-sg"></a>

In this section, we'll add permissions to the security group to allow web traffic through the HTTP and HTTPS protocols\. We'll also allow other computers to connect by using Windows Remote Desktop Protocol \(RDP\)\.

 *To add permissions to a security group* 

1. On the **EC2 Security Groups** tab, choose a security group and then choose the **Add Permission** button\.

1. In the **Add IP Permission** dialog box, choose the **Protocol, Port and Network** radio button, and then from the **Protocol** drop\-down list, choose **HTTP**\. The port range automatically adjusts to port 80, the default port for HTTP\. The **Source CIDR** field defaults to 0\.0\.0\.0/0, which specifies that HTTP network traffic will be accepted from any external IP address\. Choose **OK**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-ec2-sg-http.png)

   Open port 80 \(HTTP\) for this security group

1. Repeat this process for HTTPS and RDP\. Your security groups permissions should now look like the following\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-ec2-sg-display.png)

You can also set permissions in the security group by specifying a user ID and security group name\. In this case, Amazon EC2 instances in this security group will accept all incoming network traffic from Amazon EC2 instances in the specified security group\. You must also specify the user ID as a way to disambiguate the security group name; security group names are not required to be unique across all of AWS\. For more information about security groups, go to the [EC2 documentation](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-network-security.html)\.