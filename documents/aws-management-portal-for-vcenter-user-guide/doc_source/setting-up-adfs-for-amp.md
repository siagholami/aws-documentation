# Setting Up ADFS for AWS Management Portal for vCenter<a name="setting-up-adfs-for-amp"></a>

If you are using Windows Active Directory \(AD\) as your directory service, you can use Active Directory Federation Services \(ADFS\) as your identity provider \(IdP\) and enable federated single sign\-on \(SSO\) to your AWS environment\.

To enable integration between your organization and AWS, complete the following tasks\.

**Tasks**

1. [Prepare requirements](#prepare-adfs)

1. [Install ADFS 2\.0](#install-adfs-2) or [Install ADFS 3\.0](#install-adfs-3)

1. [Enable RelayState](#enable-relaystate)

## Requirements<a name="prepare-adfs"></a>

Prepare the following requirements:
+ Create a domain account in Active Directory\. For example, we use the name `adfssvc` in these procedures\. Keep the password in a safe place\. You'll use this account as the ADFS service account later in this procedure\.
+ Verify that the server to run ADFS is joined to the domain\. You can also update the computer name\.
+ \(Optional\) If you don't have a certificate, you can create a self\-signed certificate using Internet Information Services \(IIS\)\. It's convenient to use a self\-signed certificate in a development environment\. However, you'll need a certificate from a trusted certificate authority for a production environment\.

**To create a self\-signed certificate**

  1. Open Internet Information Services \(IIS\) Manager\.

  1. In the **Connections** pane, select a server node\.

  1. From the **Home** page for the server node, open **Server Certificates**\.

  1. From the **Actions** pane, click **Create Self\-Signed Certificate**\.

  1. In the **Create Self\-Signed Certificate** dialog box, specify a name for the certificate, and then click **OK**\.

## Installing ADFS 2\.0<a name="install-adfs-2"></a>

If you have not done so already, install ADFS on your server and configure it as a federation server\.

**To download and install ADFS 2\.0 on Windows Server 2008 R2**

1. Download [Active Directory Federation Services 2\.0](http://www.microsoft.com/en-us/download/details.aspx?id=10909) from the Microsoft Download Center and start the installation\.

1. On the **Server Role** page, select **Federation server**\.

1. Complete the wizard as directed\.

**To configure ADFS 2\.0**

1. Open the **AD FS 2\.0 Federation Server Configuration Wizard**\.

1. On the **Welcome** page, select **Create a new Federation Service**, and then click **Next**\.

1. On the **Select Stand\-Alone or Farm Deployment** page, click **New federation server farm**, and then click **Next**\.

1. On the **Specify the Federation Service Name** page, from the **SSL certificate** list, select a certificate, and then click **Next**\.

1. On the **Specify a Service Account** page, do the following:

   1. Click **Browse**\.

   1. In the **Select User** dialog box, enter the domain account described in the Requirements section \(for example, `adfssvc`\), click **Check Names**, and then click **OK**\.  
![\[The Select User dialog box\]](http://docs.aws.amazon.com/amp/latest/userguide/images/service_account.png)

   1. Enter the password for the account, and then click **Next**\.

1. On the **Ready to Apply Settings** page, review the settings, make any changes that you need, and then click **Next**\.

1. On the **Configuration Results** page, review the results\.

   If all the configuration steps completed successfully, click **Close**\.

   If you see a warning icon next to **Configure service settings**, click **Configuration finished with warnings**\.  
![\[The Configuration Results page\]](http://docs.aws.amazon.com/amp/latest/userguide/images/configuration_results_warning.png)

   If the error message begins with "An error occurred during an attempt to set the SPN for the specified service account," you can fix the issue by opening a Command Prompt window as an administrator and then running the following command:

   ```
   setspn -a host/localhost service-account
   ```

   Note that *service\-account* is the name of the service account described in the Requirements section \(for example, `adfssvc`\)\. Upon success, the output for this command ends with "Updated object\."

## Installing ADFS 3\.0<a name="install-adfs-3"></a>

If you have not done so already, install ADFS on your server and configure it as a federation server\.

**To install ADFS 3\.0 on Windows Server 2012**

1. Open Server Manager\.

1. From the dashboard, click **Add roles and features**\.

1. On the **Select installation type** page, select **Role\-based or feature\-based installation** and then click **Next**\.

1. On the **Select destination server** page, select **Select a server from the server pool**, select your server from the list, and then click **Next**\.

1. On the **Select server roles** page, select **Active Directory Federation Services** and then click **Next**\.

1. On the **Confirm installation selections** page, click **Install**\.

**To configure ADFS 3\.0**

1. Open Server Manager and click the warning icon to complete post\-deployment configuration\.

1. On the **Welcome** page, select **Create the first federation server in a federation server farm**, and then click **Next**\.

1. On the **Connect to Active Directory Domain Services** page, specify a domain administrator account, and then click **Next**\.

1. On the **Specify Service Properties** page, select the SSL certificate described in the Requirements section\. Click **Import**\. Provide the requested information, and then click **Next**\.

1. On the **Specify Service Account** page, click **Use an existing domain user account or group Managed Service Account**\. Specify the domain account described in the Requirements section \(for example, `adfssvc`\)\.

1. On the **Specify Configuration Database** page, click **Create a database on this server using Windows Internal Database** and then click **Next**\.

1. Review the information on the **Review Options** page, and then click **Next**\.

1. On the **Pre\-requisite Checks** page, monitor the status of the checks\. Address any issues that are reported\. When all checks pass successfully, click **Configure**\.

   If you see an error message that begins with "An error occurred during an attempt to set the SPN for the specified service account," you can fix the issue by opening a Command Prompt window as an administrator and then running the following command:

   ```
   setspn -a host/localhost service-account
   ```

   Note that *service\-account* is the name of the service account described in the Requirements section \(for example, `adfssvc`\)\. Upon success, the output for this command ends with "Updated object\."

## Enabling RelayState<a name="enable-relaystate"></a>

Before you continue, verify that your ADFS supports the `RelayState` parameter, and then enable it\. This parameter was introduced in Update Rollup 2 for ADFS 2\.0\. This parameter is supported in ADFS 3\.0, but it is not enabled by default\.

**To enable RelayState**

1. \[ADFS 2\.0\] In Control Panel, go to Installed Updates and look for update KB2681584 \(Update Rollup 2\) or KB2790338 \(Update Rollup 3\)\. If you need to, download and install either [Update Rollup 2](http://support.microsoft.com/kb/2681584) or [Update Rollup 3](http://support.microsoft.com/kb/2790338)\.

1. In a text editor, such as Notepad, open the following file:
   + \[ADFS 2\.0\] `C:\inetpub\adfs\ls\web.config`
   + \[ADFS 3\.0\] `%systemroot%\ADFS\Microsoft.IdentityServer.Servicehost.exe.config`

1. In the `microsoft.identityServer.web` section, add `useRelyStateForIdpInitiatedSignOn` as follows, and save the change:

   ```
   <microsoft.identityServer.web>
       ...
       <useRelayStateForIdpInitiatedSignOn enabled="true" />
   </microsoft.identityServer.web>
   ```

1. \[ADFS 2\.0\] Restart IIS using the following command:

   ```
   C:\> IISReset
   
   Attempting stop...
   Internet services successfully stopped
   Attempting start...
   Internet services successfully restarted
   ```

1. Restart ADFS as follows:

   1. On the **Start** menu, point to **Administrative Tools**, and then click **Services**\.

   1. Right\-click the ADFS service, and then click **Restart**\.