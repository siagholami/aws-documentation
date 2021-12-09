# Troubleshooting Amazon RDS on VMware<a name="troubleshooting-rds-on-vmware"></a>

To help troubleshoot problems that you have with Amazon RDS on VMware, you can use the following sections\.

**Topics**
+ [Can't Connect to the RDS Connector](#troubleshooting-rds-on-vmware.connection)
+ [Custom AZ Is Unregistered or Creating](#troubleshooting-rds-on-vmware.custom-az-not-active)
+ [Custom AZ Is Disconnected](#troubleshooting-rds-on-vmware.disconnected)
+ [Can't Create a New Custom AZ](#troubleshooting-rds-on-vmware.cannot-create-custom-az)
+ [Edge Router Can't Ping the ESXi Edge Gateway](#troubleshooting-rds-on-vmware.cannot-create-custom-az)
+ [Error in the OVF Template](#troubleshooting-rds-on-vmware.ovf-template-error)
+ [Proxy Server Connection Problems or Changes](#troubleshooting-rds-on-vmware.proxy-server)

## Can't Connect to the RDS Connector<a name="troubleshooting-rds-on-vmware.connection"></a>

In this case, you can't connect to the RDS connector on your vSphere cluster\.

The cause for this issue is almost always that one or more of the following values in your \.ovf file are incorrect:
+ The host name
+ IP addresses in the Management Network
+ The custom Availability Zone \(custom AZ\) ID
+ The VPN originator IP address
+ The certificate

To solve the issue when onboarding is not complete, deploy the RDS Edge Router image and correct the values in the \.ovf file\. If a certificate is incorrect, check the output in the `/var/output/log/application.log` file\.

To solve the issue when onboarding is finished, complete the following steps:

1. Delete all of the management VMs associated with onboarding\.

1. Delete any roles created by the VMware Virtual DMZ Environment \(VDME\), if any\.

1. Delete the custom AZ in Amazon RDS\.

1. Complete the onboarding steps for a new custom AZ\.

For more information, see [Onboard Your vSphere Cluster](getting-started-with-rds-on-vmware.onboard.md)\.

## Custom AZ Is Unregistered or Creating<a name="troubleshooting-rds-on-vmware.custom-az-not-active"></a>

If your custom AZ is unregistered or is in **Creating** status on the **Custom AZs** page, your custom AZ has yet to complete onboarding\. The onboarding might still be in progress\.

To solve the issue, make sure that your custom AZ ID is correct\. Also, make sure that you selected the correct custom AZ\. If you are onboarding a new custom AZ, you might have selected this new custom AZ by mistake instead of an already onboarded custom AZ\.

## Custom AZ Is Disconnected<a name="troubleshooting-rds-on-vmware.disconnected"></a>

If your custom AZ is disconnected, Amazon RDS can't reach your custom AZ\. In this state, some Amazon RDS features are disabled on this specific custom AZ\. In this state, the AWS Management Console shows the **Disconnected** status on the **Custom AZs** page\.

![\[Disconnected custom AZ\]](http://docs.aws.amazon.com/AmazonRDS/latest/RDSonVMwareUserGuide/)

The following cases might result in a disconnected custom AZ:
+ Your custom AZ might not have internet access\. Check the Distributed Port Group that is providing internet access to the custom AZ to verify whether it still has internet access\. You can verify internet access by first deploying a VM attached to this Distributed Port Group\. You can then run `curl checkip.amazonaws.com` or go to [ http://checkip\.amazonaws\.com/](http://checkip.amazonaws.com/) in a browser from within this VM\.
+ The custom AZ's VPN Originator IP might have changed\. Make sure that this IP address matches the internet\-facing IP address of your vSphere Cluster\. You can verify this by first deploying a VM attached to this Distributed Port Group\. You can then run `curl checkip.amazonaws.com` or go to [http://checkip\.amazonaws\.com/](http://checkip.amazonaws.com/) in a browser from within this VM\. The IP address returned is the cluster's internet\-facing IP address\. If this IP address doesn't match the Originator IP for this custom AZ, the custom AZ is disconnected\.

To solve the issue, make sure that the Distributed Port Group provides internet access\. Also, make sure that the custom AZ's VPN Originator IP matches the internet\-facing IP address of your vSphere Cluster\. You might need to change your egress routing to use this IP address\.

If you make any adjustments to your environment, wait up to 15 minutes for connectivity to be re\-established\. Contact AWS Support if your custom AZ remains offline after taking the steps described preceding\.

## Can't Create a New Custom AZ<a name="troubleshooting-rds-on-vmware.cannot-create-custom-az"></a>

In this case, you can't create a new custom AZ, and the following error can be returned\.

```
Custom Availability Zones quota exceeded.
```

To solve the issue, delete your unused DB instances and unused custom AZs\. If you can't create a new custom AZ after deleting unused DB instances and unused custom AZs, contact AWS Support\.

For information about creating a new custom AZ, see [Creating Additional Custom AZs in a Region](creating-a-custom-az.md)\.

## Edge Router Can't Ping the ESXi Edge Gateway<a name="troubleshooting-rds-on-vmware.cannot-create-custom-az"></a>

In this case, the Edge Router can't ping the ESXi Edge Gateway\.

To solve the issue, check the routing configuration from Edge Router console, and look for errors\.

## Error in the OVF Template<a name="troubleshooting-rds-on-vmware.ovf-template-error"></a>

In this case, there is an error in the OVF template\.

If you haven't completed onboarding, modify the OVF template using the software package option to attempt to solve the issue\.

If you have completed onboarding, complete the following steps to attempt to solve the issue:
+ Delete all your management VMs\.
+ Remove any roles created by VDME\.
+ Delete the custom AZ in Amazon RDS\.
+ Create a new custom AZ\.

For more information about the OVF template, see [Onboard Your vSphere Cluster](getting-started-with-rds-on-vmware.onboard.md)\.

For information about creating a new custom AZ, see [Creating Additional Custom AZs in a Region](creating-a-custom-az.md)\.

## Proxy Server Connection Problems or Changes<a name="troubleshooting-rds-on-vmware.proxy-server"></a>

In this case, you can't reach the internet through a proxy server, or you want to change your proxy server settings\.

To solve connectivity problems, contact AWS Support\. To avoid connectivity problems, contact AWS Support before changing any proxy server settings\.