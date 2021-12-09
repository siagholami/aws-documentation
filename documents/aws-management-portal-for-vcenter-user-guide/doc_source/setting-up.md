# Setting Up AWS Management Portal for vCenter<a name="setting-up"></a>

When you set up the management portal, you enable users in your organization to access your AWS resources\. The process involves creating accounts, setting up trust between the management portal and your authentication provider, and deploying and configuring the connector\.

To set up the management portal, complete the following tasks:

**Tasks**
+ [Install and configure AWS Management Portal for vCenter](#install-management-portal)
+ [Configure time synchronization](#time-synchronization)
+ [\(Optional\) Configure network settings](#network-settings)

**Note**  
For most VM import needs we recommend that you use AWS Server Migration Service\. AWS SMS automates the import process \(reducing the workload of migrating large VM infrastructures\), adds support for incremental updates of changing VMs, and converts your imported VMs into ready\-to\-use Amazon machine images \(AMIs\)\.  
If any of the following are true, you should consider using AWS SMS:  
You are using vCenter 6\.5\.
You want to specify BYOL licenses during migration\.
You are interested in migrating VMs to Amazon EC2\.
You want to use incremental migration\.
You should only use AWS Management Portal for vCenter if you want to manage Amazon EC2 resources from within vSphere Client\. AWS Management Portal for vCenter does not support vCenter 6\.5 or later\.  
To get started with AWS SMS, see [AWS Server Migration Service](https://aws.amazon.com/server-migration-service)\.

## Installing and Configuring AWS Management Portal for vCenter<a name="install-management-portal"></a>

You can choose one of two authentication providers: the AWS Connector for vCenter or an identity provider \(IdP\) that supports SAML 2\.0\. The setup process for the management portal differs based on the authentication provider that you choose\. The following table describes your options\. Follow the directions for the authentication provider that you chose\.


| Authentication Provider | Description | 
| --- | --- | 
|  [Federation authentication proxy](install-option-connector.md)  |  You can configure the connector to authenticate users\. There are no prerequisites for this option\. As part of the setup process, you'll set up a trust relationship between the management portal and the connector\. This option is provided for organizations that aren't using an IdP that supports SAML 2\.0\.  | 
|  [SAML\-based authentication](install-option-saml.md)  |  SAML 2\.0 provides an open standard specifically designed for single sign\-on \(SSO\)\. This enables users who have been authenticated by your IdP to access the management portal\. To use this option, you must first set up an IdP for your organization\. As part of the setup process, you'll set up a SAML provider and configure a trust relationship between the management portal and AWS\. For more information about the benefits of SAML, see [Advantages of SAML](http://saml.xml.org/advantages-saml)\.  | 

After you select an authentication provider, complete the setup process\. To select a different authentication provider, return to the first page of the setup program and then click **Reset Trust Relationship**, or expand **Reset Trust Relationship** on the summary page, click **I acknowledge that I want to reset my trust relationships configuration**, and then click **Reset Trust Relationship**\.

## Configuring Time Synchronization<a name="time-synchronization"></a>

The connector virtual appliance synchronizes its time with the time of its ESX/ESXi server\. The connector requires that the Network Time Protocol \(NTP\) is configured on the ESXi server where it is deployed\.

If the setup program fails to register your credentials, it's possible that this is a time synchronization issue\. To verify, open `debug-file.log` and search for the following string: **ntpdate, \-qv, pool\.ntp\.org**\. If the offset is greater than 15 seconds, configure NTP on the ESX/ESXi server and restart the connector\.

## \(Optional\) Configuring Network Settings<a name="network-settings"></a>

You can configure various network settings using the connector command line interface \(CLI\)\.

**To update your network settings using the connector CLI**

1. Locate the connector VM in the vSphere client, right\-click it, and select **Open Console\.**

1. Log in as **ec2\-user** with the password **ec2pass**\.

1. Run the sudo setup\.rb command\. This command displays the following menu:

   ```
   Choose one of the following options
   1. Reset password
   2. Reconfigure network settings
   3. Restart services
   4. Factory reset
   5. Delete unused upgrade-related files
   6. Enable/disable SSL certificate validation
   7. Display connector's SSL certificate
   8. Generate log bundle
   9. Exit
   Please enter your option [1-9]:
   ```

1. Type `2`, and then press Enter\. The command displays the following menu:

   ```
   Reconfigure your network:
   1. Renew or acquire a DHCP lease
   2. Set up a static IP
   3. Set up a web proxy for AWS communication
   4. Set up a DNS suffix search list
   5. Exit
   Please enter your option [1-5]:
   ```

   Use these options to complete the following tasks:

   1. Renew your DHCP lease, or re\-enable DHCP after setting up a static IP address\.

   1. Set up a static IP address for the connector\. When prompted, enter the static IP address, netmask, gateway, and DNS servers\.

   1. Configure the connector to use a corporate web proxy\. When prompted, enter the proxy IP address, port, and an optional user name and password to log in to the proxy\. If you need to use authentication for the web proxy, note that the connector supports only password\-based authentication\.
**Note**  
This option requires that you've set your initial password by logging into the connector using https://*ip\_address*/, where *ip\_address* is the IP address of the connector management console

   1. Configure the DNS suffix search list so that connector can migrate VMs from the ESX host\. You do not need to do this if vCenter displays all ESX hosts using fully\-qualified domain names or IP addresses\.

1. If the IP address changes or the proxy settings change, re\-register the connector as follows:

   1. Using a web browser, open the connector management console\.

   1. From the dashboard, click **Register the Connector**\.

   1. Follow the directions to complete the registration wizard\.