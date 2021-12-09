# Deployment options<a name="launch-wizard-deployment-options"></a>

AWS Launch Wizard provides the following four deployment paths:

1. **Deploy SQL Server into a new VPC**\. When you choose this configuration option, Launch Wizard builds a new AWS environment consisting of the VPC, subnets, NAT gateways, security groups, domain controllers, and other infrastructure components\. It then deploys Windows Server Failover Clustering \(WSFC\) with SQL Server into this new VPC\.

1. **Deploy SQL Server into an existing VPC and create a new AWS Managed Active Directory**\. When you choose this configuration option, Launch Wizard builds a new AWS environment that consists of security groups, domain controllers, and other infrastructure components, and then deploys WSFC with SQL Server in to the customer\-specified VPC and subnets\. Your AWS environment must include a VPC with two or three Availability Zones, private subnets in each Availability Zone, and at least one public subnet in the VPC\. Currently, Launch Wizard only supports AWS Managed Microsoft Active Directory for this scenario\.

1. **Deploy a SQL Server into an existing VPC with an existing AWS Managed Active Directory**\. When you choose this configuration option, Launch Wizard provisions WSFC in your existing AWS infrastructure\. Your AWS environment must include a VPC with two or three Availability Zones, private subnets in each Availability Zone, at least one public subnet in the VPC, and an AWS Active Directory in the VPC \(this is the Active Directory on which you deploy your SQL nodes\)\. 

1. **Deploy a SQL Server into an existing VPC and connect to an on\-premises Active Directory**\. When you choose this configuration option, Launch Wizard provisions WSFC in your existing AWS infrastructure\. Your AWS environment must include a VPC with two or three Availability Zones, private subnets in each Availability Zone, at least one public subnet in the VPC, and an [AWS Direct Connect](https://docs.aws.amazon.com/directconnect/latest/UserGuide/Welcome.html) connection to your on\-premises Active Directory\. 

Launch Wizard allows you to configure additional settings, such as the version of SQL Server \(by your choice of AMI\), in addition to instance types and Amazon EBS volume types based on the infrastructure requirements that you specify\.