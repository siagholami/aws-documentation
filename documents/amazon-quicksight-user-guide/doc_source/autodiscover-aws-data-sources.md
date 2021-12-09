# Allowing Autodiscovery of AWS Resources<a name="autodiscover-aws-data-sources"></a>

## Configuring AWS Resources<a name="configure-aws-resources"></a>

Use the following sections to help you configure your AWS resources to work with Amazon QuickSight\.

### Configuring Your AWS Data Sources for Amazon QuickSight Access<a name="network-configuration"></a>

You can have Amazon QuickSight autodiscover Amazon RDS DB instances or Amazon Redshift clusters that are associated with your AWS account\. These resources must be located in the same AWS Region as your Amazon QuickSight account\. 

If you choose to enable autodiscovery, choose one of the following options to make the AWS resource accessible:
+ For Amazon RDS DB instances that you created in a default VPC and didn't choose to make private, or that aren't in a VPC \(are EC2\-Classic instances\), see [Authorizing Connections from Amazon QuickSight to Amazon RDS DB Instances](enabling-access-rds.md)\. In this topic, you can find information on creating a security group to allow connections from Amazon QuickSight servers\.
+ For Amazon Redshift clusters that you created in a default VPC and didn't choose to make private, or that aren't in a VPC \(are EC2\-Classic instances\), see [Authorizing Connections from Amazon QuickSight to Amazon Redshift Clusters](enabling-access-redshift.md)\. In this topic, you can find information on creating a security group to allow connections from Amazon QuickSight servers\.
+ For an Amazon RDS DB instance or Amazon Redshift cluster that is in a nondefault VPC, see [Authorizing Connections from Amazon QuickSight to Amazon RDS DB Instances](enabling-access-rds.md) or [Authorizing Connections from Amazon QuickSight to Amazon Redshift Clusters](enabling-access-redshift.md)\. In these topics, you can find information on creating a security group to allow connections from Amazon QuickSight servers, and then verifying that the VPC meets the requirements described in [Network Configuration for an AWS Instance in a Non\-Default VPC](configure-access.md#network-configuration-aws-nondefault-vpc)\. 
+ The Amazon RDS instance must be available for access to the public IP of the Amazon QuickSight region\.

Enabling autodiscovery is the easiest way to make this data available in Amazon QuickSight\. You can still manually create data connections whether or not you enable autodiscovery\. 

### Confirming the Availability of AWS Identity and Access Management \(IAM\) Roles<a name="confirm-iam-role-availability"></a>

If you choose to enable autodiscovery of AWS resources for your Amazon QuickSight account, Amazon QuickSight creates an AWS Identity and Access Management \(IAM\) role in your AWS account\. This IAM role that grants your account permission to identify and retrieve data from your AWS data sources\.

Because AWS limits you to 250 IAM roles, be sure that you have at least one free role for Amazon QuickSight to use if you want Amazon QuickSight to autodiscover your AWS resources\.