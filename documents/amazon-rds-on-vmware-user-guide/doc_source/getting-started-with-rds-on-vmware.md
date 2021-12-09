# Getting Started with Amazon RDS on VMware<a name="getting-started-with-rds-on-vmware"></a>

To get started with Amazon RDS on VMware, you onboard a new vSphere cluster as a custom Availability Zone \(custom AZ\) for Amazon RDS\.

You only onboard a particular vSphere cluster once\. After you complete the onboarding tasks successfully, you don't need to repeat the tasks for the same vSphere cluster\. If you have already configured the vSphere cluster for Amazon RDS on VMware, and you want to add another custom AZ to it, see [Creating Additional Custom AZs in a Region](creating-a-custom-az.md)\.

During onboarding, you configure the following networks\.


****  

| Network Name | Purpose | DHCP Server Required? | 
| --- | --- | --- | 
| Cluster Control Network | New network for communication between Amazon RDS management virtual machines \(VMs\) and database VMs | No\. Amazon RDS runs its own Dynamic Host Configuration Protocol \(DHCP\) server on this network\. | 
| Internet Network | New or existing network for outbound internet connectivity for Amazon RDS VMs and for establishing a VPN tunnel to the Amazon RDS service | Yes\. This network must advertise a default route\. | 
| Application Network | New or existing network for communication between your applications and Amazon RDS database VMs | Yes\. This network can advertise a default route, but the corresponding default route is not installed\. | 
| Management Network | Existing network for communication between Amazon RDS management VMs and ESXi hosts | No\. You must provide a static IP address during onboarding\. | 

The following illustration shows how your Amazon RDS on VMware configuration looks after onboarding is complete\.

![\[Amazon RDS on VMware configuration after onboarding\]](http://docs.aws.amazon.com/AmazonRDS/latest/RDSonVMwareUserGuide/images/pre-onboarding-requirements.png)

**Important**  
Currently, Amazon RDS on VMware is available only in the US East \(N\. Virginia\) AWS Region\.

To create a custom AZ, you take the following two steps:

1. [Complete the Prerequisites](getting-started-with-rds-on-vmware.pre-onboarding.md)

1. [Onboard Your vSphere Cluster](getting-started-with-rds-on-vmware.onboard.md)

For more details about working with Amazon RDS on VMware, see [Working with Amazon RDS on VMware](working-with-rds.md)\.