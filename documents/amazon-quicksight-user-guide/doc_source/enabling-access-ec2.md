# Authorizing Connections from Amazon QuickSight to Amazon EC2 Instances<a name="enabling-access-ec2"></a>

For Amazon QuickSight to connect to an Amazon EC2 instance, you must create a new security group for that instance\. This security group contains an inbound rule authorizing access from the appropriate IP address range for the Amazon QuickSight servers in that region\. 

To modify the security groups for these Amazon EC2 instances, you must have AWS credentials that permit you to access to the instances\.

Enabling connection from Amazon QuickSight servers to your instance is just one of several prerequisites for creating a data set based on an AWS database data source\. For more information about what is required, see [Creating Data Sets from New Database Data Sources](creating-database-data-sets.md)\.

**To enable Amazon QuickSight access to an Amazon EC2 instance**

1. Sign in to the AWS Management Console and open the Amazon EC2 console at [https://console\.aws\.amazon\.com/ec2/](https://console.aws.amazon.com/ec2/)\.

1. If your EC2 instance is in a VPC, select the instance to view the instance details pane\. Locate its VPC ID and make note of it for later use\.

1. Choose **Security Groups** in the **NETWORK & SECURITY** section of the navigation pane on the left\. Then choose **Create Security Group**, as shown following\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/create-ec2-security-group.png)

1. Enter the security group information as follows:
   + For **Security group name**, type **Amazon\-QuickSight\-access**\.
   + For **Description**, type **Amazon\-QuickSight\-access**\.
   + For **VPC**, choose the VPC ID that you noted in step 2 if your Amazon EC2 instance is in a VPC\. Otherwise, choose **No VPC**\.

1. Choose **Add Rule** on the **Inbound** tab\.

1. Create a new rule with the following values:
   + For **Type**, choose **Custom TCP Rule**\.
   + For **Protocol**, choose **TCP**\.
   + \(Optional\) For **Port Range**, enter the port number used by the instance on this Amazon EC2 instance to which you are providing access\.
   + For **Source**, type the CIDR address block for the region where you'll be using QuickSight\. For example, here is the CIDR address block for EU \(Ireland\): `52.210.255.224/27`\. For more information on the IP address ranges for Amazon QuickSight in supported regions, see [AWS Regions and IP Address Ranges](regions.md)\.
**Note**  
If you have activated Amazon QuickSight in multiple regions, you can create inbound rules for each Amazon QuickSight endpoint CIDR\. Doing this allows Amazon QuickSight to have access to the Amazon RDS DB instance from any region defined in the inbound rules\.   
An Amazon QuickSight user or administrator who uses Amazon QuickSight in multiple regions is treated as a single user\. In other words, even if you are using Amazon QuickSight in every region, both your Amazon QuickSight account and your users are global\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/ec2-security-group.png)

1. Choose **Create**\.

1. Choose **Instances** in the **INSTANCES** section of the navigation pane, and then choose the instance that you want to enable access to\.

1. Choose **Actions**, then **Networking**, and then **Change Security Groups**\. 

1. In **Change Security Groups**, select the **Amazon\-QuickSight\-access** security group\. 

   Then choose **Assign Security Groups**, as shown following\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/chooose-ec2-security-group.png)