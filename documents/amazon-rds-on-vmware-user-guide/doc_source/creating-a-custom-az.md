# Creating Additional Custom AZs in a Region<a name="creating-a-custom-az"></a>

During the onboarding process described in [Getting Started with Amazon RDS on VMware](getting-started-with-rds-on-vmware.md), you created a custom Availability Zone \(custom AZ\) in an AWS Region\. You can create additional custom AZs in the same AWS Region\. 

**To create a custom AZ**

1. Sign in to the AWS Management Console and open the Amazon RDS console at [https://console\.aws\.amazon\.com/rds/](https://console.aws.amazon.com/rds/)\.

1. In the top\-right corner of the AWS Management Console, choose the AWS Region that you want to create the custom AZ in\. 

1. In the navigation pane, choose **Custom AZs**\.

1. Choose **Create custom AZ**\.

   The **Create custom AZ** page appears\.  
![\[Create custom AZ\]](http://docs.aws.amazon.com/AmazonRDS/latest/RDSonVMwareUserGuide/images/create-custom-az.png)

1. In **Custom AZ name**, enter a name for the custom AZ\.

1. In **VPN settings**, enter a friendly name for the VPN in **VPN tunnel name**, and enter the Local Uplink IP in **VPN originator IP**\.
**Note**  
A Local Uplink IP is the external source IPv4 address of packets leaving your virtual data center\. Multiple vSphere clusters in the same virtual data center can use the same Local Uplink IP or different Local Uplink IPs\. However, you must create a new VPN connection for each vSphere cluster\.

1. Choose **Create custom AZ**\.

   Amazon RDS on VMware begins the custom AZ creation process\.