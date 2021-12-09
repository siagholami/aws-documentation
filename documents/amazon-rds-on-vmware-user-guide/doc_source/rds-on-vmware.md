# What Is Amazon RDS on VMware?<a name="rds-on-vmware"></a>

Amazon Relational Database Service \(Amazon RDS\) is a web service that makes it easier to set up, operate, and scale a relational database in the cloud\. It provides cost\-efficient, resizeable capacity for an industry\-standard relational database and manages common database administration tasks\. Amazon RDS includes Amazon RDS on VMware, which provides these services in an on\-premises, private environment\. For more information about Amazon RDS, see the *[Amazon RDS User Guide](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/)\.*

Using Amazon RDS on VMware, you can set up, operate, and scale databases in VMware environments\. Amazon RDS on VMware automates time\-consuming database management tasks, such as provisioning, patching, and backups\. This automation frees you to focus on developing and tuning your applications\.

Amazon RDS on VMware supports Amazon RDS for MySQL, PostgreSQL, and Microsoft SQL Server databases in customer\-owned private cloud environments\. These databases can run workloads that must remain on\-premises in compliance with security, privacy, regulatory, or data sovereignty policies\. You can get started by downloading Amazon RDS on VMware onto a VMware vSphere cluster and installing it\.

Amazon RDS on VMware reduces operational overhead for database management in your on\-premises VMware data centers\. Amazon RDS on VMware automates administrative tasks including software installation, patching, monitoring, and backups\. Amazon RDS on VMware includes a software package for your VMware vSphere environment that provides easy provisioning, automatic monitoring, and simple manageability of your databases, enabling database management through a dedicated VPN tunnel connecting to the AWS Region\.

To learn more about Amazon RDS on VMware, see the following topics:
+ [Features of Amazon RDS on VMware](#rds-on-vmware-features)
+ [Accessing Amazon RDS on VMware](#acessing)
+ [How Amazon RDS on VMware Works](rds-on-vmware-architecture.md)
+ [Terminology](rds-on-vmware-concepts.md)
+ [Support for RDS Features in Amazon RDS on VMware](rds-feature-support.md)

To start work with Amazon RDS on VMware, see [Setting Up Amazon RDS on VMware](setting-up-rds-on-vmware.md)\. 

## Features of Amazon RDS on VMware<a name="rds-on-vmware-features"></a>

Amazon RDS on VMware provides the following features:
+ Automates administrative tasks for your on\-premises databases in VMware vSphere environments
+ Provides a simple interface for creating, modifying, and managing your databases using the AWS Management Console, AWS CLI, and RDS API
+ Enables easy scaling of the compute, storage, and memory resources in your on\-premises DB instance
+ Provides CloudWatch metrics for your on\-premises databases
+ Enables manual or automatic backup of your on\-premises databases
+ Supports restoring a DB instance from a snapshot and point\-in\-time restore \(except for Microsoft SQL Server DB instances\)

## Accessing Amazon RDS on VMware<a name="acessing"></a>

Amazon RDS on VMware provides a web\-based user interface, the AWS Management Console\. You can sign into the AWS Management Console and manage your on\-premises databases\. 

If you prefer to use a command line interface, you can use the AWS CLI\. The RDS API provides a programmatic interface\.