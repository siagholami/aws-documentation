# How Amazon RDS on VMware Works<a name="rds-on-vmware-architecture"></a>

The Amazon RDS on VMware architecture uses the RDS connector, a software appliance for your VMware vSphere environment\. With the RDS connector, you can manage on\-premises DB instances through a dedicated virtual private network \(VPN\) tunnel\.

**Topics**
+ [Onboarding Amazon RDS on VMware](#rds-on-vmware-architecture.onboarding)
+ [Connecting to an AWS Region from a vSphere Cluster](#rds-on-vmware-architecture.connecting)
+ [Provisioning and Managing On\-Premises DB Instances](#rds-on-vmware-architecture.provisioning)
+ [Backing Up and Restoring On\-Premises DB Instances](#rds-on-vmware-architecture.backup-restore)

## Onboarding Amazon RDS on VMware<a name="rds-on-vmware-architecture.onboarding"></a>

The following diagram shows the onboarding process for Amazon RDS on VMware\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/AmazonRDS/latest/RDSonVMwareUserGuide/images/rds-on-vmware-architecture-onboarding.png)

To onboard Amazon RDS on VMware, you create a custom Availability Zone from the AWS Management Console in the AWS Region\. You then download the Amazon RDS on VMware Installer from the AWS Management Console to the on\-premises vSphere cluster where you want to use the service\. When you run the Installer, it deploys the local components for Amazon RDS on VMware on your vSphere cluster and connects your cluster to the Amazon RDS service running in the AWS Region\. You can then create a new database using the AWS Management Console, AWS CLI, or RDS API by choosing the appropriate database engine and DB instance class size\.

## Connecting to an AWS Region from a vSphere Cluster<a name="rds-on-vmware-architecture.connecting"></a>

The RDS connector uses an outbound VPN connection to connect to an AWS Region\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/AmazonRDS/latest/RDSonVMwareUserGuide/images/rds-on-vmware-architecture-connecting.png)

The connection enables communication between your vSphere cluster and the AWS Region\. Amazon RDS on VMware uses the connection for management activities\. It also uses the connection to send information, such as Amazon CloudWatch data, from the vSphere cluster to the AWS Region\.

## Provisioning and Managing On\-Premises DB Instances<a name="rds-on-vmware-architecture.provisioning"></a>

To provision and manage DB instances, you create a Cluster Control Network in your vSphere cluster\. You can provision several DB instances and choose from different DB engine types, such a MySQL, PostgreSQL, and Microsoft SQL Server\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/AmazonRDS/latest/RDSonVMwareUserGuide/images/rds-on-vmware-architecture-provisioning.png)

You also create an Application Network in your vSphere cluster\. Your applications, users, and DBAs use this network to interact with Amazon RDS on VMware DB instances\.

## Backing Up and Restoring On\-Premises DB Instances<a name="rds-on-vmware-architecture.backup-restore"></a>

You can create automated or manual snapshots of your DB instances\. These snapshots are stored on your vSphere cluster\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/AmazonRDS/latest/RDSonVMwareUserGuide/images/rds-on-vmware-architecture-backup.png)

You can restore from a snapshot or to a point in time to create new on\-premises DB instances\.