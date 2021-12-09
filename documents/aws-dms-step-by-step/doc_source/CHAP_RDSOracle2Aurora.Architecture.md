# Migration Architecture<a name="CHAP_RDSOracle2Aurora.Architecture"></a>

This walkthrough uses AWS CloudFormation to create a simple network topology for database migration that includes the source database, the replication instance, and the target database in the same VPC\. For more information on AWS CloudFormation, see [the CloudFormation documentation](http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/Welcome.html)\. 

We will provision the AWS resources that are required for this AWS Database Migration Service \(AWS DMS\) walkthrough through AWS CloudFormation\. These resources include a VPC and Amazon Relational Database Service \(Amazon RDS\) instances for Oracle and Amazon Aurora MySQL\. We provision through AWS CloudFormation because it simplifies the process, so we can concentrate on tasks related to data migration\. When you create a stack from the AWS CloudFormation template, it provisions the following resources:
+ A VPC with CIDR \(10\.0\.0\.0/24\) with two public subnets in your region, DBSubnet1 at the address 10\.0\.0\.0/26 in Availability Zone \(AZ\) 1 and DBSubnet2 at the address 10\.0\.0\.64/26, in AZ 12\.
+ A DB subnet group that includes DBSubnet1 and DBSubnet2\.
+ Oracle RDS Standard Edition Two with these deployment options: 
  + License Included
  + Single\-AZ setup
  + db\.m3\.medium or equivalent instance class
  + Port 1521
  + Default option and parameter groups
+ Amazon Aurora MySQL DB instance with these deployment options: 
  + No replicas
  + db\.r3\.large or equivalent instance class
  + Port 3306
  + Default option and parameter groups
+ A security group with ingress access from your computer or 0\.0\.0\.0/0 \(access from anywhere\) based on the input parameter

We have designed the CloudFormation template to require few inputs from the user\. It provisions the necessary AWS resources with minimum recommended configurations\. However, if you want to change some of the configurations and parameters, such as the VPC CIDR block and Amazon RDS instance types, feel free to update the template\.

We will use the AWS Management Console to provision the AWS DMS resources, such as the replication instance, endpoints, and tasks\. You will install client tools such as SQL Workbench/J and the AWS Schema Conversion Tool \(AWS SCT\) on your local computer to connect to the Amazon RDS instances\. 

Following is an illustration of the migration architecture for this walkthrough\.

![\[AWS Database Migration Service replication instance\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2aurora1.png)