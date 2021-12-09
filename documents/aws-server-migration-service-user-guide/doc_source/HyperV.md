# Install the Server Migration Connector on Hyper\-V<a name="HyperV"></a>

AWS SMS supports migration in either of two modes: from standalone Hyper\-V servers, or from Hyper\-V servers managed by System Center Virtual Machine Manager \(SCVMM\)\. Use the following information to install the Server Migration Connector on Hyper\-V so that you can use AWS SMS to migrate VMs from Hyper\-V to Amazon EC2\.

This information applies only to VMs in an on\-premises Hyper\-V environment\. For information about installing the connector on other environments, see [Install the Server Migration Connector](SMS_setup.md)\.

**Considerations for migration scenarios**
+ The installation procedures for standalone Hyper\-V and for SCVMM environments are not interchangeable\.
+ When configured in SCVMM mode, one Server Migration Connector appliance supports migration from one SCVMM \(which may manage multiple Hyper\-V servers\)\.
+ When configured in standalone Hyper\-V mode, one Server Migration Connector appliance supports migration from multiple Hyper\-V servers\.
+ AWS SMS supports deploying any number of connector appliances to support migration from multiple SCVMMs and multiple standalone Hyper\-V servers in parallel\.

**Requirements for Hyper\-V connector**
+ Hyper\-V role on Windows Server 2012 R2 or Windows Server 2016
+ Active Directory 2012 or above
+ \[Optional\] SCVMM 2012 SP1 or SCVMM 2016
+ Minimum 8 GiB RAM
+ Minimum available disk storage of 300 GiB
+ Support for the following network services\. Note that you might need to reconfigure your firewall to permit stateful outbound connections from the connector to these services\.
  + DNS—Allow the connector to initiate connections to port 53 for name resolution\.
  + HTTPS on WinRM port 5986 on your SCVMM or standalone Hyper\-V host
  + Inbound HTTPS on port 443 of the connector—Allow the connector to receive secure web connections on port 443 from Hyper\-V hosts containing the VMs you intend to migrate\.
  + NTP—Optionally allow the connector outbound access to port 123 for time synchronization\. If the connector synchronizes its clock with the Hyper\-V host, this is unnecessary\.
+ Allow outbound connections from the connector to the following URL ranges: 
  + \*\.amazonaws\.com
  + \*\.aws\.amazon\.com

**Topics**
+ [About the Server Migration Connector installation script](#script-actions)
+ [Step 1: Create a service account for Server Migration Connector in Active Directory](#hyperv-ad-user)
+ [Step 2: Download and deploy the Server Migration Connector](#download-hyperv-connector)
+ [Step 3: Download and install the Hyper\-V/SCVMM configuration script](#hyperv-script)
+ [Step 4: Validate the integrity and cryptographic signature of the script file](#validate-hyperv-script)
+ [Step 5: Run the script](#run-hyperv-script)
+ [Step 6: Configure the connector](#configure-hyperv-connector)

## About the Server Migration Connector installation script<a name="script-actions"></a>

The AWS SMS configuration script automates creation of appropriate permissions and network connections that allow AWS SMS to execute tasks on your Hyper\-V environment\. You must run the script as administrator on each Hyper\-V and SCVMM host that you plan to use in migrating VMs\. When you run the script, it performs the following actions:

1. **\[All systems\]** Checks whether the Windows Remote Management \(WinRM\) service is enabled on SCVMM and all Hyper\-V hosts, enables it if necessary, and sets it to start automatically on boot\.

1. **\[All systems\]** Enables PowerShell remoting, which allows the connector to execute PowerShell commands on that host over a WinRM connection\.

1. **\[All systems\]** Creates a self\-signed X\.509 certificate, creates a WinRM HTTPS listener, and binds the certificate to the listener\.

1. **\[All systems\]** Creates a firewall rule to accept incoming connections to the WinRM listener\.

1. **\[All systems\]** Adds the IP address or domain name of the connector to the list of trusted hosts in the WinRM configuration\. You must have this IP address or domain name configured before running the script so that you can provide it interactively\.

1. **\[All systems\]** Enables Credential Security Support Provider \(CredSSP\) authentication with WinRM\.

1. **\[All systems\]** Grants read and execute permissions to a pre\-configured Active Directory user on WinRM configSDDL\. This user is the same as the service account described below in [Step 1: Create a service account for Server Migration Connector in Active Directory](#hyperv-ad-user)\.

1. **\[Standalone Hyper\-V only\]** Adds the Active Directory user to the groups Hyper\-V Administrators and Remote Management Users on your Hyper\-V host\. 

1. **\[Standalone Hyper\-V only\]** Gives read\-only permissions to all VM data folders manged by this Hyper\-V\.

1. **\[SCVMM only\]** Grants "Execute Methods," "Enable Account," and "Remote Enable" permissions to the Active Directory user on two WMI objects, CIMV2 and SCVMM\.

1. **\[SCVMM only\]** Creates a Delegated Administrator role in SCVMM with permissions to access all Hyper\-V hosts\. It assigns the role to the Active Directory user\. You can selectively remove access to hosts by editing this role in SCVMM\.

1. **\[SCVMM only\]** Checks whether a secure \(HTTPS\) network path exists between SCVMM and the Hyper\-V hosts\. If the script does not detect a secure channel, it returns an error and generates instructions for the administrator to secure the channel\.

1. **\[SCVMM only\]** Iterates through all the Hyper\-V hosts managed by SCVMM and grants the Active Directory user read\-only permissions on all VM folders on each Hyper\-V host\.

## Step 1: Create a service account for Server Migration Connector in Active Directory<a name="hyperv-ad-user"></a>

The Server Migration Connector requires a service account in Active Directory\. As the connector configuration script is run on each SCVMM and Hyper\-V host, it grants permissions on those hosts to this account\. 

**Note**  
When configured in SCVMM mode, the SCVMM host and all the Hyper\-V hosts that it manages must be located in a single Active Directory domain\. If you have multiple Active Directory domains, configure a connector for each\. 

**To create the Active Directory user**

1. Using the Active Directory Administrative Center on the Windows computer where your Active Directory forest is installed, create a new user and assign a password to it\.

1. Add the new user to the **Remote Management Users** group\.

## Step 2: Download and deploy the Server Migration Connector<a name="download-hyperv-connector"></a>

Download the [Server Migration Connector for Hyper\-V and SCVMM](https://s3.amazonaws.com/sms-connector/AWS-SMS-Connector-for-SCVMM-HyperV.zip) to your on\-premises environment and install it on a Hyper\-V host\.

**To set up the connector for a Hyper\-V environment**

1. Open the **AWS Server Migration Service** console and choose **Connectors**,**SMS Connector setup guide**\. 

1. On the **AWS Server Migration Connector setup** page, choose **Download VHD ZIP** to download the connector for Hyper\-V\.

1. Transfer the downloaded connector file to your Hyper\-V host, unzip it, and import the connector as a VM\.

1. Open the connector's virtual machine console and log in as `ec2-user` with the password `ec2pass`\. Supply a new password if prompted\.

1. Obtain the IP address of the connector as follows:

   1. Run the command sudo setup\.rb\. This displays a configuration menu:

      ```
      Choose one of the following options:
            1. Reset password
            2. Reconfigure network settings
            3. Restart services
            4. Factory reset
            5. Delete unused upgrade-related files
            6. Enable/disable SSL certificate validation
            7. Display connector's SSL certificate
            8. Generate log bundle
            0. Exit
      Please enter your option [1-9]:
      ```

   1. Enter option 2\. This displays current network information and a submenu for making changes to the network settings\. The output should resemble the following:

      ```
      Current network configuration: DHCP
      IP: 192.0.2.100
      Netmask: 255.255.254.0
      Gateway: 192.0.2.1
      DNS server 1: 192.0.2.200
      DNS server 2: 192.0.2.201
      DNS suffix search list: subdomain.example.com
      Web proxy: not configured
       
      Reconfigure your network:
            1. Renew or acquire a DHCP lease
            2. Set up a static IP
            3. Set up a web proxy for AWS communication
            4. Set up a DNS suffix search list
            5. Exit
      Please enter your option [1-5]:
      ```

   You need to enter this IP address in later procedures\.

1. \[Optional\] Configure a static IP address for the connector\. This prevents you from having to reconfigure the trusted hosts lists on your LAN each time DHCP assigns a new address to the connector\.

   In the **Reconfigure your network** menu, enter option **2**\. This displays a form to supply network settings:

   For each field, provide an appropriate value and press Enter\. You should see output similar to the following:

   ```
   Setting up static IP:
         1. Enter IP address: 192.0.2.50
         2. Enter netmask: 255.255.254.0
         3. Enter gateway: 192.0.2.1
         4. Enter DNS 1: 192.0.2.200
         5. Enter DNS 2: 192.0.2.201
    
   Static IP address configured.
   ```

1. In the connector's network configuration menu, configure domain suffix values for the DNS suffix search list\.

1. If your environment uses a web proxy to reach the internet, configure that now\.

1. Before leaving the connector console, use ping to verify network access to the following targets inside and outside your LAN:
   + Inside your LAN, to your Hyper\-V hosts and SCVMM by hostname, FQDN, and IP address
   + Outside your LAN, to AWS

## Step 3: Download and install the Hyper\-V/SCVMM configuration script<a name="hyperv-script"></a>

AWS SMS provides a downloadable PowerShell script to configure the Windows environment to support communications with the Server Migration Connector\. The same script is used for configuring either standalone Hyper\-V or SCVMM\. The script is cryptographically signed by AWS\. 

Download the script and hash files from the following URLs:


| File | URL | 
| --- | --- | 
| Installation script | [https://s3\.amazonaws\.com/sms\-connector/aws\-sms\-hyperv\-setup\.ps1](https://s3.amazonaws.com/sms-connector/aws-sms-hyperv-setup.ps1) | 
| MD5 hash | [https://s3\.amazonaws\.com/sms\-connector/aws\-sms\-hyperv\-setup\.ps1\.md5](https://s3.amazonaws.com/sms-connector/aws-sms-hyperv-setup.ps1.md5) | 
| SHA256 hash | [https://s3\.amazonaws\.com/sms\-connector/aws\-sms\-hyperv\-setup\.ps1\.sha256](https://s3.amazonaws.com/sms-connector/aws-sms-hyperv-setup.ps1.sha256) | 

After download, transfer the downloaded files to the computer or computers where you plan to run the script\. 

## Step 4: Validate the integrity and cryptographic signature of the script file<a name="validate-hyperv-script"></a>

Before running the script, we recommend that you validate its integrity and signature\. These procedures assume that you have downloaded the script and the hash files, that they are installed on the desktop of the computer where you plan to run the script, and that you are signed in as the administrator\. You may need to modify the procedures to match your setup\.

**To validate script integrity using cryptographic hashes \(PowerShell\)**

1. Use one or both of the downloaded hash files to validate the integrity of the script file, ensuring that it has not changed in transit to your computer\.

   1. To validate with the MD5 hash, run the following command in a PowerShell window:

      ```
      PS C:\Users\Administrator> Get-FileHash aws-sms-hyperv-setup.ps1 -Algorithm MD5
      ```

      This should return information similar to the following:

      ```
      Algorithm         Hash
      ---------         ----
      MD5               1AABAC6D068EEF6EXAMPLEDF50A05CC8
      ```

   1. To validate with the SHA256 hash, run the following command in a PowerShell window:

      ```
      PS C:\Users\Administrator> Get-FileHash aws-sms-hyperv-setup.ps1 -Algorithm SHA256
      ```

      This should return information similar to the following:

      ```
      Algorithm         Hash
      ---------         ----
      SHA256            6B86B273FF34FCE19D6B804EFF5A3F574EXAMPLE22F1D49C01E52DDB7875B4B
      ```

1. Compare the returned hash values with the values provided in the downloaded files, `aws-sms-hyperv-setup.ps1.md5` and `aws-sms-hyperv-setup.ps1.sha256`\.

Next, use either the Windows user interface or PowerShell to check that the script file includes a valid signature from AWS\.

**To check the script file for a valid cryptographic signature \(Windows GUI\)**

1. In Windows Explorer, open the context \(right\-click\) menu on the script file and choose **Properties**, **Digital Signatures**, **Amazon Web Services**, and **Details**\.

1. Verify that the displayed information contains "This digital signature is OK" and that "Amazon Web Services, Inc\." is the signer\.

**To check the script file for a valid cryptographic signature \(PowerShell\)**
+ In a PowerShell window, run the following command:

  ```
  PS C:\Users\Administrator> Get-AuthenticodeSignature aws-sms-hyperv-setup.ps1 | Select *
  ```

  A correctly signed script file should return information similar to the following:

  ```
  SignerCertificate          : [Subject]
                              CN="Amazon Web Services, Inc." ...
                           [Issuer]
                              CN=DigiCert EV Code Signing CA (SHA2), OU=www.digicert.com, O=DigiCert Inc, C=US
  ...
  
  TimeStamperCertificate     : 
  Status                     : Valid
  StatusMessage              : Signature verified.
  Path                       : C:\Users\Administrator\Desktop\aws-sms-hyperv-setup.ps1
  
  ...
  ```

## Step 5: Run the script<a name="run-hyperv-script"></a>

This procedure assumes that you have downloaded the script onto the desktop of the computer where you plan to run the script, and that you are signed in as the administrator\. You may need to modify the procedure shown to match your setup\.

**Note**  
If you are using SCVMM, you must first run this script on each Hyper\-V host you plan to migrate from, and then run it on SCVMM\.

**To run the script on each host**

1. Using RDP, log in to your SCVMM system or standalone Hyper\-V host as administrator\.

1. Run the script using the following PowerShell command:

   ```
   PS C:\Users\Administrator> .\aws-sms-hyperv-setup.ps1
   ```
**Note**  
If your PowerShell execution policy is set to verify signed scripts, you are prompted for an authorization when you run the connector configuration script\. Verify that the script is published by "Amazon Web Services, Inc\." and choose "R" to run one time\. You can view this setting using Get\-ExecutionPolicy and modify it using Set\-ExecutionPolicy\.

1. As the script runs, it prompts you for several pieces of information\. Be prepared to respond to the following prompts:    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/server-migration-service/latest/userguide/HyperV.html)

## Step 6: Configure the connector<a name="configure-hyperv-connector"></a>

When the connector configuration has been successfully run, browse to the connector's web interface:

```
https://ip-address-of-connector/
```

Complete the following steps to set up the new connector\.

**To configure the connector**

1. On the connector landing page, choose **Get started now**\.

1. Review the license agreement, select the check box, and choose **Next**\.

1. Create a password for the connector\. The password must meet the displayed criteria\. Choose **Next**\.

1. On the **Network Info** page, you can \(among other tasks\) assign a static IP address to the connector if you have not already done so\. Choose **Next**\.

1. On the **Log Uploads and Upgrades** page, select **Upload logs automatically** and **Server Migration Connector auto\-upgrade**, and choose **Next**\.

1. On the **Server Migration Service** page, provide the following information:
   +  For **AWS Region**, choose your Region from the list\. 
   +  For **AWS Credentials**, enter the IAM credentials that you created in [Permissions for IAM users](prereqs.md#permissions-roles)\. Choose **Next**\. 

1. On the **Choose your VM manager type** page, choose either **Microsoft® System Center Virtual Manager \(SCVMM\)** or **Microsoft® Hyper\-V** depending on your environment\. Selecting **VMware® vCenter** results in an error if you have installed the Hyper\-V connector\. Choose **Next**\.

1. On the **Hyper\-V: Host and Service Account Setup** or **SCVMM: Host and Service Account Setup** page, provide the account information for the Active Directory user that you created in [Step 1: Create a service account for Server Migration Connector in Active Directory](#hyperv-ad-user), including **Username** and **Password**\.

1. 
   + \[SCVMM only\] Provide the SCVMM hostname to be served by this connector and choose **Next**\. Inspect the certificate for the host and choose **Trust** if the certificate is valid\. 
   + \[Stand\-alone Hyper\-V only\] Provide the Hyper\-V hostname for each host to be served by this connector\. To add additional hosts, use the plus symbol\. To inspect the certificate for each host, choose **Verify Certificate** and choose **Trust** if the certificate is valid\. Choose **Next**\.

   Alternatively, you can select the host\-specific option to **Ignore hostname mismatch and expiration errors\.\.\.** for either SCVMM or Hyper\-V host certificates\. We do not recommend overriding security in production, but it may be useful during testing\.
**Note**  
If you have Hyper\-V hosts located in multiple Active Directory domains, we recommend configuring a separate connector for each domain\.

1. If you successfully authenticated with the connector, you should see the **Congratulations** page\. To view the connector's health status, choose **Go to connector dashboard**\.

1. To verify that the connector that you registered is now listed, open the **Connectors** page on the AWS Server Migration Service console\. If you encounter an issue registering the connector, contact [sms\-service@amazon\.com](mailto:sms-service@amazon.com)\.