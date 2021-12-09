# Managing the AWS Connector for vCenter<a name="manage-connector"></a>

You can manage the connector using the connector management console and the connector CLI\.

Starting with connector version 2\.4\.0, AWS collects metrics about the performance, usage, and customization of your connector so that we can make it more stable and secure\.

**Topics**
+ [Accessing the Management Console](#access-management-console)
+ [Logging into the Virtual Machine Console](#access-virtual-machine-console)
+ [Resetting the Connector Password](#reset-connector-pwd)
+ [Rotating the Keys](#rotate-keys)
+ [Monitoring the Connector](#monitor-connector)
+ [Reporting a Problem to AWS](#sending-logs)
+ [Updating the AWSConnector Policy](#updating-the-AWSConnector-policy)
+ [General Troubleshooting](#troubleshooting-general)
+ [Troubleshooting Upgrades](#troubleshooting)
+ [Installing a Trusted SSL Certificate](#upload-certificate)
+ [Validating an Untrusted SSL Certificate](#ssl-certificate)
+ [Uninstalling the Connector](#uninstall-connector)

Note that the procedures on this page are written for version 2\.1\.0 and later of the connector\. If the version information in the upper\-right corner of the connector management console is **Version: 2\.0\.0**, download the PDF file [Managing the Connector](http://awsdocs.s3.amazonaws.com/AMP/2.0/managing-connector-2-0.pdf) for directions written for version 2\.0\.0 of the connector\.

## Accessing the Management Console<a name="access-management-console"></a>

To access the management console, go to https://*ip\_address*/, where *ip\_address* is the IP address of the connector management console that you saved when you deployed the connector virtual appliance\.

## Logging into the Virtual Machine Console<a name="access-virtual-machine-console"></a>

You can use the connector CLI from the connector virtual machine console\. To access the virtual machine console, locate the connector VM in the vSphere client, right\-click it, and select **Open Console**\.

The default user is ec2\-user and the default password is ec2pass\.

We recommend that you change the password after you have logged in\. To change the password, use the following command:

```
passwd new_password
```

**Important**  
Note that if you use the command `sudo passwd` it will modify the password for `root`, not the password for `ec2-user`\.

## Resetting the Connector Password<a name="reset-connector-pwd"></a>

If you forget the password that you use to log in to the connector setup console, you can reset the password using the connector CLI\.

**To reset your password using the connector CLI**

1. Locate the connector VM in the vSphere client, right\-click it, and select **Open Console**\.

1. Log in as ec2\-user\. For more information, see [Logging into the Virtual Machine Console](#access-virtual-machine-console)\.

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

1. Type `1`, and then press Enter\. Follow the onscreen directions\. Note that in general, you should not change the vCenter IP/hostname, you should use the same vCenter to authenticate\.

## Rotating the Keys<a name="rotate-keys"></a>

We recommend that you rotate these keys periodically\.

The AMP\-connector key is shared between the management console and the on\-premises connector and is used to establish trust between these entities\.

**To rotate the AMP\-connector key**

1. Open the [AWS Management Portal for vCenter setup console](https://amp.aws.amazon.com/VCPlugin.html#setup)\.

1. On the **AWS Management Portal Setup** page, expand the **AMP\-Connector Key** pane and then click **Edit**\.

1. On the **Create an AMP\-Connector Key** page, select **Create a new AMP\-Connector key**\.

1. Enter a name for the key and then click **Create**\.

1. On the **Review Your Configuration** page, click **Download Configuration**\. Save this file to a safe location\. You'll need it to complete the connector deployment process\.

1. Click **Finish**\.

The connector encryption key is used to encrypt sensitive information \(such as account credentials\) that is local to the connector\.

**To rotate the connector encryption key**

1. Using a web browser, open the connector management console\.

1. From the connector management console, click **Rotate encryption key**\.

1. In the **Rotate encryption key** dialog box, enter a password for the connector and then click **Rotate**\.

## Monitoring the Connector<a name="monitor-connector"></a>

The connector enables you to monitor its health using the management console\.

**To monitor the connector using the management console**

1. Using a web browser, open the connector management console\.

1. Locate the **Health Status** pane\.  
![\[The Health Status pane\]](http://docs.aws.amazon.com/amp/latest/userguide/images/health_status.png)

1. Check whether there are any failures\. If there is a failure, click **View Error Log** for more information\.  
**Connector Up\-to\-Date**  
Indicates whether you are using the current version of the connector\. If you see a warning icon, there is an upgrade available; click **What's new?** to learn more\. If you see an error icon, the connector has been recalled and there is a downgrade available; click **What will be fixed?** to learn more\.  
**AWS Connectivity**  
Verifies that the connector can access AWS using the credentials you specified when you configured the connector\. If there are errors, click **View Error Log**\.  
**vCenter Connectivity**  
Verifies that the connector can access vCenter using the credentials you specified when you configured the connector\. If there are errors, click **View Error Log**\.  
**Connector Registered IP Is Current**  
Indicates whether the IP address used to register the connector is valid\.  
**System Time Synchronization**  
Verifies that the time of the current system and the host are in sync\. If there are errors, click **View Error Log**\. For more information, see [Configuring Time Synchronization](setting-up.md#time-synchronization)\.  
**UserProvider Service**  
Enumerates vCenter users\. If there are errors, click **View Error Log**\.  
**Poller Service**  
Monitors the status of VMs that you migrate to Amazon EC2\. If there are errors, click **View Error Log**\. If the error is that the service hasn't refreshed, try restarting services, as described in [Troubleshooting Upgrades](#troubleshooting)\.  
**Network Proxy Configured**  
Indicates whether you are connected using a proxy\. If you are not using a network proxy, this item is not present\.  
**Connector Dashboard Login**  
Indicates whether there are attempts to log in to the connector with an incorrect password\. After 20 attempts to log in with an incorrect password, the connector is locked down\.  
**Authentication Proxy Service**  
Indicates that you are using the federation authentication proxy in the connector to validate user credentials when they log into AWS Management Portal for vCenter\. If you are using SAML\-based authentication, this item is not present\.

## Reporting a Problem to AWS<a name="sending-logs"></a>

Use the following procedure to report a problem with the connector to AWS\. We recommend that you send us your connector logs\. Sending your logs is secure, and it enables us to provide you with better support\.

**To report an issue to AWS**

1. From your web browser, go to https://*ip\_address*/, where *ip\_address* is the IP address of the connector management console\.

1. Log in to the connector using your password\.

1. Under **Support Links**, click **Report a problem to AWS**\.

1. In the **Report a problem to AWS** dialog box, do the following:

   1. Select an issue from the list of common issues provided, or 'Other' if your issue is not listed\.

   1. Describe the issue in the text box\.

   1. To include your connector logs, select **I agree to send my logs to Amazon Web Services**\.

   1. Click **Send**\.

## Updating the AWSConnector Policy<a name="updating-the-AWSConnector-policy"></a>

If you installed a version of AWS Connector for vCenter earlier than 2\.4\.0, you must update the policies used by the IAM users that you created during the setup process as follows\. This ensures that these users are granted the access to AWS that is now required to migrate a VM\.

**To update the AWSConnector policy**

1. Open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. In the navigation pane, click **Users**\.

1. Select the user\.

1. On the **Permissions** tab, click **Remove Policy** for the `AWSConnector` policy\. When prompted for confirmation, click **Remove**\.

1. Click **Attach Policy**\.

1. Select the check box next to the **AWSConnector** policy\.

1. Click **Attach Policy**\.

## General Troubleshooting<a name="troubleshooting-general"></a>

**If you need to download and review the log files**

If you need to troubleshoot issues with the connector, you can download the debug log files as follows:

1. Using a web browser, open the connector management console\.

1. From the dashboard, click **Download Debug Log Bundle**\.

1. Download and review the log files\.

<a name="vSphere"></a>**If AWS Management Portal for vCenter is not showing up in vSphere Web Client**

1. Log out of vSphere Web Client and then log back in\.

1. If the management portal is still not showing up, re\-register the connector as follows:

   1. Using a web browser, open the connector management console\.

   1. From the dashboard, click **Register the Connector**\.

   1. Follow the directions to complete the registration wizard\.

   1. Log out of vSphere Web Client and then log back in\.

1. If the management portal is still not showing up, restart the service for the connector, as described in the procedure for "If the connector isn't responding" below, and then re\-register the connector as described in the previous step\.

**If the connector isn't responding**<a name="restart-services"></a>

1. You can restart the services for the connector using the connector CLI as follows:

   1. Locate the connector VM in the vSphere client, right\-click it, and select **Open Console**\.

   1. Log in as ec2\-user\. For more information, see [Logging into the Virtual Machine Console](#access-virtual-machine-console)\.

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

   1. Type `3`, and then press Enter\. Follow the onscreen directions\.

1. Alternatively, you can reboot the host computer itself\. Locate the connector in the vSphere client inventory tree, right\-click it, and then select **Power > Restart Guest**\.

1. If restarting the services or rebooting doesn't fix the problem, you can perform a factory reset as follows:
**Warning**  
Performing a factory reset should be a last resort\. You'll need to configure the connector after the factory reset is complete\.

   1. Locate the connector VM in the vSphere client, right\-click it, and select **Open Console**\.

   1. Log in as ec2\-user\. For more information, see [Logging into the Virtual Machine Console](#access-virtual-machine-console)\.

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

   1. Type `4`, and then press Enter\. Follow the onscreen directions\.

   1. After the factory reset is complete, it's as if you have just downloaded the OVA file and installed it\. You must configure the connector again\. For more information, see [Configuring the Connector](install-option-saml.md#configure-connector)\.

## Troubleshooting Upgrades<a name="troubleshooting"></a>

**If an error occurs during an upgrade**

1. From the management console, check whether there are any failures in the **Health Status** pane\. If there is a failure, attempt to resolve the issue\. For more information, see [Monitoring the Connector](#monitor-connector)\.

1. Refresh the page and retry the upgrade\.

1. If the error persists, send debug logs to AWS\. For more information, see [Reporting a Problem to AWS](#sending-logs)\.

**If an upgrade continues for a long time**

If you have launched a manual upgrade of connector version 2\.4\.*x* from the management console, the upgrade process can take a long time to finish\. This is because we are making security upgrades to the connector\.

1. If the upgrade is still in progress after 20 minutes, refresh your browser\. If the page is down, the upgrade process might not have finished; try refreshing again after another 10 minutes\.

1. When prompted by your browser, accept the new certificates for connector\.

1. Log in to the connector\.

**If the connector is unresponsive after an upgrade**

1. If the connector is still unresponsive after 30 minutes, reboot the connector appliance\.

1. If the connector remains unresponsive, contact AWS Support for further assistance\.

## Installing a Trusted SSL Certificate<a name="upload-certificate"></a>

The first time that you power on the connector appliance, it automatically generates a self\-signed certificate based on its IP address\. Because this is a self\-signed certificate, your web browser notifies you that it is an untrusted certificate the first time you visit the connector management console\. We recommend that you validate this certificate before you trust it, and then replace the certificate by installing an SSL certificate signed by a trusted certificate authority \(CA\) on your connector, as shown in the following procedure\. After you do so, you will make subsequent connections to the connector using the new certificate\.

**To install an SSL certificate on your connector**

1. Before uploading a trusted certificate to the connector, we recommend that you ensure that communication between your computer and the connector over the network is secure\. For more information, see [Validating an Untrusted SSL Certificate](#ssl-certificate)\.

1. Create a private key and obtain a corresponding trusted certificate in PEM format\. The recommended way to do this is as follows:

   1. Create the private key and certificate signing request \(CSR\) using tools such as the openssl tools\. You must specify the IP address of the connector\. If you've set up a DNS hostname that resolves to the IP address of the connector, you must also specify the DNS hostname of the connector\.

   1. Submit the CSR to your CA\.

   1. Wait for the CA to send you the trusted certificate\.

1. Package the private key and trusted certificate into a PKCS\#12 file with a passphrase as follows:

   ```
   openssl pkcs12 -export -inkey my-private-key.pem -in my-certificate.pem -out my-passphrase.p12 -passout pass:passphrase
   ```

1. Open the management console\.

1. In the **Actions** pane, click **Upload security certificate**\.

1. In the **Upload Security Certificate** dialog box, click **Choose file** and select your PKCS 12 file\. Enter the passphrase and then click **Upload**\.

Each SSL certificate has a validity period\. You must replace a certificate before its validity period ends\. To replace a certificate, you must create and upload a new certificate\.

## Validating an Untrusted SSL Certificate<a name="ssl-certificate"></a>

The first time that you power on the connector appliance, it automatically generates a self\-signed certificate based on its IP address\. The connector presents your browser with this certificate to identify itself and encrypt the connection\. This certificate helps your browser determine whether this site is actually the site that it claims to be\. Because this is a self\-signed certificate, your web browser notifies you that it is an untrusted certificate the first time you visit the connector management console\. \(Check the error message in your browser for details\.\) We recommend that you validate this certificate before you trust it\.

If the IP address shown in the SSL certificate for the connector is different than the current IP address of the connector, you should restart the services on the connector, which regenerates the certificate using the current IP address\. For more information, see [Restart Services](#restart-services)\.

You can validate the untrusted certificate by viewing the certificate details as follows, and comparing them against the untrusted certificate\.

**To view the connector certificate**

1. Locate the connector VM in the vSphere client, right\-click it, and select **Open Console**\.

1. Log in as ec2\-user\. For more information, see [Logging into the Virtual Machine Console](#access-virtual-machine-console)\.

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

1. Type `7`, and then press Enter\.

## Uninstalling the Connector<a name="uninstall-connector"></a>

If you need to uninstall the connector, complete the following steps\.

**To uninstall the connector**

1. Using a web browser, open the connector management console\.

1. From the dashboard, click **Unregister the Connector**\.

1. In the **Unregister the Connector** dialog box, enter the user name and password, and then click **Unregister**\.

1. Sign in to vCenter\.

1. Locate the connector in the vSphere client inventory tree, right\-click it, and select **Power > Power Off**\. Right\-click the template again and select **Delete from Disk**\.