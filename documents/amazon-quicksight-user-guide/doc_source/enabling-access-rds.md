# Authorizing Connections from Amazon QuickSight to Amazon RDS DB Instances<a name="enabling-access-rds"></a>

For Amazon QuickSight to connect to an Amazon RDS DB instance, you must create a new security group for that DB instance\. This security group contains an inbound rule authorizing access from the appropriate IP address range for the Amazon QuickSight servers in that region\. To learn more about authorizing Amazon QuickSight connections, see [Manually Enabling Access to an Amazon RDS Instance in a VPC](#rds-vpc-access) or [Manually Enabling Access to an Amazon RDS Instance That Is Not in a VPC](#rds-classic-access)\.

To create and assign a security group for an Amazon RDS DB instance, you must have AWS credentials that permit access to that DB instance\.

Enabling connection from Amazon QuickSight servers to your instance is just one of several prerequisites for creating a data set based on an AWS database data source\. For more information about what is required, see [Creating Data Sets from New Database Data Sources](creating-database-data-sets.md)\.

## Manually Enabling Access to an Amazon RDS Instance in a VPC<a name="rds-vpc-access"></a>

Use the following procedure to enable Amazon QuickSight access to an Amazon RDS DB instance in a VPC\.

**To enable Amazon QuickSight access to an Amazon RDS DB instance in a VPC**

1. Sign in to the AWS Management Console and open the Amazon RDS console at [https://console\.aws\.amazon\.com/rds/](https://console.aws.amazon.com/rds/)\.

1. On the **Instances** page, select the instance to which you want to grant access, and then choose the details page icon, as shown following\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/rds-details.png)

1. Locate **Port** in the **Cluster Database Properties** section\. Note the **Port** value\. 

1. Locate **VPC** in the **Security and Network** section, and note the **VPC** value\. Choose the **VPC** value to open the VPC console\. 

1. On the Amazon VPC Management Console, choose **Security Groups** in the navigation pane\.

1. Choose **Create Security Group**\.

1. On the **Create Security Group** page, enter the security group information as follows:
   + For **Name tag** and **Group name**, type **Amazon\-QuickSight\-access**\.
   + For **Description**, type **Amazon\-QuickSight\-access**\.
   + For **VPC**, choose the VPC for your instance\. This VPC is the one with the VPC ID that you noted\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/security-group.png)

1. Choose **Yes, Create**\.

1. Your new security group should be displayed on the screen\. Choose the security group, and then choose **Inbound Rules** from the tab list\. 

   Choose **Edit** to create a new rule\. Use the following values:
   + For **Type**, choose **Custom TCP Rule**\.
   + For **Protocol**, choose **TCP \(6\)**\.
   + For **Port Range**, type the port number of the Amazon RDS cluster to which you are providing access\. This port number is the one that you noted in an earlier step\.
   + For **Source**, type the CIDR address block for the region where you'll be using QuickSight\. For example, here is the CIDR address block for EU \(Ireland\): `52.210.255.224/27`\. For more information on the IP address ranges for Amazon QuickSight in supported regions, see [AWS Regions and IP Address Ranges](regions.md)\.
**Note**  
If you have activated Amazon QuickSight in multiple regions, you can create inbound rules for each Amazon QuickSight endpoint CIDR\. Doing this allows Amazon QuickSight to have access to the Amazon RDS DB instance from any region defined in the inbound rules\.   
An Amazon QuickSight user or administrator who uses Amazon QuickSight in multiple regions is treated as a single user\. In other words, even if you are using Amazon QuickSight in every region, both your Amazon QuickSight account and your users are global\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/vpc-rule.png)

1. Choose **Save** to save your new inbound rule\.

1. Return to the **Instances** page of the Amazon RDS console\. 

   Choose the instance that you want to enable access to\.

   Choose **Instance Actions**, and then choose **Modify**\. 

1. In the **Network & Security** section, the currently assigned security group or groups are already chosen for **Security Group**\. Press CTRL and choose **Amazon\-QuickSight\-access** in addition to the other selected groups\.

1. Choose **Continue**, and then choose **Modify DB Instance**\.

## Manually Enabling Access to an Amazon RDS Instance That Is Not in a VPC<a name="rds-classic-access"></a>

Use the following procedure to access an Amazon RDS DB instance that is not in a VPC\.

**To access an Amazon RDS DB instance that is not in a VPC**

1. Sign in to the Amazon RDS console\.

1. Choose **Security Groups** in the navigation pane\.

1. Choose **Create DB Security Group**\.

1. Type **Amazon\-QuickSight\-access** for the **Name** and **Description** values, and then choose **Create**\.

1. The new security group is selected by default\.

   Select the details icon next to the security group, as shown following\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/rds-security-group.png)

1. For **Connection Type**, choose **CIDR/IP**\.

1. For **CIDR/IP to Authorize**, type the appropriate CIDR address block\. For more information on the IP address ranges for Amazon QuickSight in supported regions, see [AWS Regions and IP Address Ranges](regions.md)\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/rds-cidr.png)

1. Choose **Authorize**\.

1. Return to the **Instances** page of the Amazon RDS Management Console, choose the instance that you want to enable access to, choose **Instance Actions**, and then choose **Modify**\. 

1. In the **Network & Security** section, the currently assigned security group or groups already is chosen for **Security Group**\. Press CTRL and choose **Amazon\-QuickSight\-access** in addition to the other selected groups\.

1. Choose **Continue**, and then choose **Modify DB Instance**\.