# Onboard Your vSphere Cluster<a name="getting-started-with-rds-on-vmware.onboard"></a>

After you complete the steps in [Complete the Prerequisites](getting-started-with-rds-on-vmware.pre-onboarding.md), you can onboard your vSphere cluster\. To do this, create a new custom Availability Zone \(AZ\) and install Amazon RDS on VMware\.

**To onboard your vSphere cluster**

1. Sign in to the AWS Management Console and open the Amazon RDS console at [https://console\.aws\.amazon\.com/rds/](https://console.aws.amazon.com/rds/)\.

1. In the upper\-right corner of the console, choose the US East \(N\. Virginia\) AWS Region\.

1. In the navigation pane, choose **Custom AZs**\.

1. Download the Amazon RDS on VMware Installer \(Installer\) on your vSphere cluster\.

   1. Choose **Download Installer**, accept the terms of the agreement, and save the file on your file system\.  
![\[Download Amazon RDS on VMware Installer\]](http://docs.aws.amazon.com/AmazonRDS/latest/RDSonVMwareUserGuide/images/installer-download.png)

   1. Unzip the archive\.

1. In the Amazon RDS console, create a custom AZ:

   1. In the upper\-right corner of the console, choose the AWS Region from which you downloaded the Installer\.

   1. In the navigation pane, choose **Custom AZs**\.

   1. Choose **Create custom AZ**\.

      The **Create custom AZ** page appears\.  
![\[Create custom AZ\]](http://docs.aws.amazon.com/AmazonRDS/latest/RDSonVMwareUserGuide/images/create-custom-az.png)

   1. In **Custom AZ name**, enter a name for the custom AZ\.

   1. In **VPN settings**, enter a name for the VPN for **VPN tunnel name** and enter the VPN Originator IP for **VPN originator IP**\.

   1. Choose **Create custom AZ**\.

      Amazon RDS on VMware begins the custom AZ creation process\.

   You can repeat this step to create additional custom AZs in the same AWS Region\.

1. In your VMware environment, deploy the Installer OVA to start an Installer virtual machine \(VM\)\.

   As part of the installation, you choose the networks for Cluster Control Network, Internet Network, Application Network, and Management Network\. The Internet Network and Application Network must have DHCP enabled\.  
![\[Deploy the Installer OVA\]](http://docs.aws.amazon.com/AmazonRDS/latest/RDSonVMwareUserGuide/images/installer-deploy-ovf.png)

1. Power on the installer VM\. The installer VM gets two IP addresses dynamically assigned on both the Internet Network and Application Network\. You must be able to reach at least one of these IP addresses to continue with the installation\. Note the IP address that you can reach as `installer-ip`\.

1. Launch the Installer by opening a browser and connecting to the following URL\.

   ```
   https://installer-ip/ui          
   ```

   Replace *installer\-ip* with the IP address of the Installer VM you noted earlier\.

   You launch the Installer by connecting to the Installer VM over HTTPS\. When you connect to the Installer, the Installer presents a self\-signed certificate that may not be trusted by your browser\.

   If the certificate is not trusted by your browser, you can choose to add an exception because you're connecting to the Installer VM that you just deployed in your VMware data center\.

   Or you can follow the steps in [Import the Installer VM Certificate](getting-started-with-rds-on-vmware.onboard.import-vm-certificate.md) to add the certificate to your browser before launching the installer\.

   The opening page of the Installer appears\.  
![\[Opening page of the Amazon RDS on VMware Installer\]](http://docs.aws.amazon.com/AmazonRDS/latest/RDSonVMwareUserGuide/images/installer-opening.png)

1. On the opening page, enter the following information:
   + **AWS Access Key ID** – The access key for your AWS Identity and Access Management \(IAM\) user\.
   + **AWS Secret Access Key** – The secret key for your IAM user\.
   + **Proxy Setting** – Enable this option if you want all external HTTP and HTTPS traffic \(for example, traffic to AWS services such as Amazon CloudWatch and Amazon S3\) from RDS on VMware to use a proxy server\.

     If you enable this option, the Installer shows the proxy server settings\.  
![\[Proxy server options in the Amazon RDS on VMware Installer\]](http://docs.aws.amazon.com/AmazonRDS/latest/RDSonVMwareUserGuide/images/installer-proxy.png)

     Enter the following information:
     + **Proxy Host** – The URL of the proxy host\.
     + **Proxy Port** – The port used by the proxy host\.
     + **Proxy Authentication required** – Enable this option if you aren't using a transparent proxy, and enter the proxy user, password, and public key in PEM format\.

1. Choose **VALIDATE WITH AWS CREDENTIALS**\.

   If validation fails, create your **AWS Access Key ID** and **AWS Secret Access Key** by following the instructions in [Managing Access Keys for Your AWS Account](https://docs.aws.amazon.com/general/latest/gr/managing-aws-access-keys.html) in the *AWS General Reference*\.

1. Choose **AWS Configuration** and, for **Select Region**, choose the AWS Region that contains your custom AZ\.  
![\[Choose AWS Region\]](http://docs.aws.amazon.com/AmazonRDS/latest/RDSonVMwareUserGuide/images/installer-aws-region.png)

   If you can't connect to the AWS Region, make sure that you completed all prerequisites described in [Complete the Prerequisites](getting-started-with-rds-on-vmware.pre-onboarding.md)\.

1. On the **AWS Configuration** page, choose **RETRIEVE AZS** to populate the list of custom AZs in the selected AWS Region\. Next, choose your custom AZ from **Select Custom AZs**\.  
![\[Select custom AZ\]](http://docs.aws.amazon.com/AmazonRDS/latest/RDSonVMwareUserGuide/images/installer-select-custom-az.png)

1. Choose **NEXT** to open the **Network Configurations** page\.  
![\[Network Configuration page\]](http://docs.aws.amazon.com/AmazonRDS/latest/RDSonVMwareUserGuide/images/installer-network-configuration.png)

   Enter the following information:
   + **ESXi Management Static IP Address** – The IP address of your ESXi Management Network
   + **DNS Server** – The IP address of the DNS server for the vCenter Server that is authoritative for your vCenter Server's private DNS zone
   + **ESXi Management Netmask** – The IP address of the subnet mask of the Management Network
   + **ESXi Management Default Gateway** – The IP address of the gateway \(router\) for the Management Network 
   + **NTP Server** – The DNS name or IPv4 address of the Network Time Protocol \(NTP\) server to which your ESXi hosts sync

1. Choose **NEXT** to open the **vCenter Configuration** page\.  
![\[vCenter Configuration page\]](http://docs.aws.amazon.com/AmazonRDS/latest/RDSonVMwareUserGuide/images/installer-vcenter-configuration.png)

   Enter the following information:
   + **FQDN** – The vCenter fully qualified domain name
   + **Administrator Username** – The administrative user name for the specified vCenter FQDN

     Enter the username in the format `user@domain`, for example `admin@vsphere.local`\.
   + **Administrator Password** – The password for the specified administrative user

1. On the **vCenter Configuration** page, choose **TEST CONNECTION**\.

   If you can't connect, make sure that you completed all of the prerequisites described in [Complete the Prerequisites](getting-started-with-rds-on-vmware.pre-onboarding.md)\. You can also choose **DOWNLOAD SUPPORT BUNDLE** to download log files that can help you diagnose connection problems\.

1. Choose **NEXT** to open the **Placement** page\.  
![\[Placement Details page\]](http://docs.aws.amazon.com/AmazonRDS/latest/RDSonVMwareUserGuide/images/installer-placement-details.png)

   Choose the following items:
   + **Select Datacenter** – The virtual data center
   + **Select Cluster** – The vSphere cluster
   + **Select Datastore** – The datastore
   + **Select Resource Pool** – The resource pool

1. Choose **VALIDATE** to open the **Validation Status** page, and check the status for each item\.

   If there is a problem with one or more items, correct the problem before proceeding\. Choose **BACK**, and then choose **VALIDATE** again to check the validation status\.

1. When all of the items are ready for installation, choose **NEXT** to open the **Summary** page\.  
![\[Summary page\]](http://docs.aws.amazon.com/AmazonRDS/latest/RDSonVMwareUserGuide/images/installer-summary.png)

   Verify the onboarding information\.

   If an item isn't correct, go back to a previous page and correct it\.

   If the summary information is correct, choose **INSTALL** to complete the installation\.

1. On the **Installation Status** page, read the message and choose **CLOSE**\.
**Important**  
The installation isn't complete until the status of the custom AZ is **Active**\. Move on to the next steps to check the status of the custom AZ\.  
![\[Installation Status page\]](http://docs.aws.amazon.com/AmazonRDS/latest/RDSonVMwareUserGuide/images/installer-installation-status.png)

1. In the Amazon RDS console, check the status of your custom AZs\.

   1. In the upper\-right corner of the console, choose the AWS Region that contains your custom AZs\.

   1. In the navigation pane, choose **Custom AZs**\.

   1. View the **Status** column\.  
![\[Custom AZ Status\]](http://docs.aws.amazon.com/AmazonRDS/latest/RDSonVMwareUserGuide/images/custom-az-status.png)

      If a custom AZ isn't registered yet with your vSphere cluster, the status is **Unregistered**\. Register these custom AZs\.

      If a custom AZ is registered with your vSphere cluster, the status is **Active**\.

      If a custom AZ is disconnected from Amazon RDS, the status is **Disconnected**\. For more information about restoring connectivity with such a custom AZ, see [Custom AZ Is Disconnected](troubleshooting-rds-on-vmware.md#troubleshooting-rds-on-vmware.disconnected)\.

1. After a custom AZ is registered, you can create one or more DB instances in the custom AZ\.

   For more information, see [Creating an On\-Premises DB Instance](creating-an-on-premises-db-instance.md)\.