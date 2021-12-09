# Install the Server Migration Connector on Azure<a name="Azure"></a>

Use the following information to install the Server Migration Connector on Azure so that you can use AWS SMS to migrate VMs from Azure to Amazon EC2\.

This information applies only to VMs hosted by Azure\. For information about installing the connector on other environments, see [Install the Server Migration Connector](SMS_setup.md)\.

**Considerations for migration scenarios**
+ A single Server Migration Connector appliance can only migrate VMs under one subscription and one Azure Region\.
+ After a Server Migration Connector appliance is deployed, you cannot change its subscription or Region unless you deploy another connector in the new subscription/Region\.
+ AWS SMS supports deploying any number of Server Migration Connector appliance VMs to support migration from multiple Azure subscriptions and Regions in parallel\.<a name="azure-connector-requirements"></a>

**Requirements for Azure connector**
+ The recommended VM size of Azure connector is F4s – 4 vCPUs and 8 GB RAM\. Ensure that you have a sufficient Azure CPU quota in the region where you are deploying the connector\.
+ A Standard Storage Account \(cannot be Premium\) under which the connector can be deployed\.
+ A virtual network where the connector can be deployed\.
+ Inbound access on port 443 \(HTTPS\), either from within the connector’s virtual network \(recommended\) or open to the public \(not recommended\), for connector registration and viewing the connector dashboard\.
+ Outbound Internet access to access AWS services, Azure services, to perform connector OS updates, and so on\.

**Topics**
+ [Step 1: Download the connector installation script](#azure-script-deployment)
+ [Step 2: Validate the integrity and cryptographic signature of the script file](#validate-azure-script)
+ [Step 3: Run the script](#run-azure-script)
+ [Step 4: Configure the connector](#azure-connector-configuration)
+ [\(Alternative\) Deploy the Server Migration Connector manually](#azure-manual)

## Step 1: Download the connector installation script<a name="azure-script-deployment"></a>

AWS SMS provides a downloadable PowerShell script to deploy the connector in your Azure environment\. The script is cryptographically signed by AWS\. Complete this procedure to run the PowerShell script and install the connector automatically in your Azure environment\. The script requires PowerShell 5\.1 or later\.

**Note**  
AWS recommends using the scripted installation, but you can alternatively install the connector manually\. For more information, see [\(Alternative\) Deploy the Server Migration Connector manually](#azure-manual)\.

**To download the script and hash files**

1. Download the PowerShell script and hash files from the following URLs:    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/server-migration-service/latest/userguide/Azure.html)

1. After download, transfer the files to the computer or computers where you plan to run the script\.

## Step 2: Validate the integrity and cryptographic signature of the script file<a name="validate-azure-script"></a>

Before running the script, we recommend that you validate its integrity and signature, ensuring that it has not changed in transit to your computer\. These procedures assume that you have downloaded the script and the hash files, that they are installed on the desktop of the computer where you plan to run the script, and that you are signed in as administrator\. You may need to modify the procedures to match your setup\.

**To validate script integrity using cryptographic hashes \(PowerShell\)**

1. Use one or both of the downloaded hash files to validate the integrity of the script file\.

   1. To validate with the MD5 hash, run the following command in a PowerShell window:

      ```
      PS C:\Users\Administrator> Get-FileHash aws-sms-azure-setup.ps1 -Algorithm MD5
      ```

      This should return information similar to the following:

      ```
      Algorithm         Hash
      ---------         ----
      MD5               1AABAC6D068EEF6EXAMPLEDF50A05CC8
      ```

   1. To validate with the SHA256 hash, run the following command in a PowerShell window:

      ```
      PS C:\Users\Administrator> Get-FileHash aws-sms-azure-setup.ps1 -Algorithm SHA256
      ```

      This should return information similar to the following:

      ```
      Algorithm         Hash
      ---------         ----
      SHA256            6B86B273FF34FCE19D6B804EFF5A3F574EXAMPLE22F1D49C01E52DDB7875B4B
      ```

1. Compare the returned hash values with the values provided in the downloaded files, `aws-sms-azure-setup.ps1.md5` and `aws-sms-azure-setup.ps1.sha256`\.

Next, use either PowerShell or the Windows user interface to check that the script file includes a valid signature from AWS\.

**To check the script file for a valid cryptographic signature \(PowerShell\)**
+ In a PowerShell window, run the following command:

  ```
  PS C:\Users\Administrator> Get-AuthenticodeSignature aws-sms-azure-setup.ps1 | Select *
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
  Path                       : C:\Users\Administrator\Desktop\aws-sms-azure-setup.ps1
  
  ...
  ```

**To check the script file for a valid cryptographic signature \(Windows GUI\)**

1. In Windows Explorer, open the context \(right\-click\) menu on the script file and choose **Properties**, **Digital Signatures**, **Amazon Web Services**, and **Details**\.

1. Verify that the displayed information contains "This digital signature is OK" and that "Amazon Web Services, Inc\." is the signer\.

## Step 3: Run the script<a name="run-azure-script"></a>

Run this script from any computer with PowerShell 5\.1 or later installed\.

**Note**  
If your PowerShell execution policy is set to verify signed scripts, you are prompted for an authorization when you run the connector configuration script\. Verify that the script is published by "Amazon Web Services, Inc\." and choose "R" to run one time\. You can view this setting using Get\-ExecutionPolicy and modify it using Set\-ExecutionPolicy\.

```
PS C:\Users\Administrator> .\aws-sms-azure-setup.ps1 -StorageAccountName name -ExistingVNetName name -SubscriptionId id -SubnetName name
```

`StorageAccountName`  
The name of the storage account where you want to deploy the connector\.

`ExistingVNetName`  
The name of the virtual network where you want to deploy the connector\.

`SubscriptionId`  
\(Optional\) The ID of the subscription to use\. If you do not specify this parameter, the default subscription for the account is used\.

`SubnetName`  
\(Optional\) The name of the subnet in the virtual network\. If you do not specify this parameter, the subnet named "default" is used\.

When the script prompts for an Azure login, use a login that has administrator permissions for the subscription under which you are deploying the connector\.

When the script completes, the connector is deployed in your account\. The script prints out the connector's private IP address and the Object ID of the System Assigned Identity of the connector VM\. You need both of these to complete the next step\.

## Step 4: Configure the connector<a name="azure-connector-configuration"></a>

From another VM on the same virtual network where you deployed the connector, browse to the connector's web interface using the following URL, which includes the private IP address of the connector that you obtained in the previous step:

```
https://ip-address-of-connector
```

**To configure the connector**

1. On the connector landing page, choose **Get started now**\.

1. Review the license agreement, select the check box, and choose **Next**\.

1. Create a password for the connector\. The password must meet the displayed criteria\. Choose **Next**\.

1. On the **Network Info** page, you can find instructions to perform network\-related tasks, such as setting up AWS proxy for the connector\. Choose **Next**\.

1. On the **Log Uploads** page, select **Upload logs automatically** and choose **Next**\.

1. On the **Server Migration Service** page, provide the following information:
   +  For **AWS Region**, choose your Region from the list\. 
   +  For **AWS Credentials**, enter the IAM credentials that you created in [Permissions for IAM users](prereqs.md#permissions-roles)\. Choose **Next**\. 

1. On the **Azure Account Verification** page, verify that your Azure subscription ID and location are correct\. This connector can migrate VMs under this subscription and location\. Provide the object ID of the System Assigned Identity of the connector VM, which was provided as output from the deployment script\.

1. If you successfully set up the connector, the **Congratulations** page is displayed\. To view the health status of the connector, choose **Go to connector dashboard**\.

1. To verify that the connector that you registered is listed, open the **Connectors** page on the Systems Manager console\.

## \(Alternative\) Deploy the Server Migration Connector manually<a name="azure-manual"></a>

Complete this procedure to install the connector manually in your Azure environment\.

**To install the connector manually**

1. Log into the Azure Portal as a user with administrator permissions for the subscription under which you are deploying this connector\.

1. Make sure that you are ready to supply a Storage Account, its Resource Group, a Virtual Network, and the Azure Region as described in [Requirements for Azure connector](#azure-connector-requirements)\.

1. Download the connector VHD and associated files from the URLs in the following table\.     
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/server-migration-service/latest/userguide/Azure.html)

1. Verify the cryptographic integrity of the connector VHD using procedures similar to those described in [Step 2: Validate the integrity and cryptographic signature of the script file](#validate-azure-script)\.

1. Upload the connector VHD and associated files to your Storage Account\.

1. Create a new managed disk with the following parameter values:
   + **Resource Group**: Select your resource group
   + **Name**: Any name \- for example, sms\-connector\-disk\-westus
   + **Region**: Select your Azure Region
   + **Availability Zone**: None
   + **Source Type**: Storage Blob \(Choose the VHD blob you uploaded from step 3\.c\.\)
   + **OSType**: Linux
   + **Size**: 60 GB/Standard HDD

1. Choose **Create VM** to create a new virtual machine from the managed disk that you created\. Assign the following parameter values\.

   Under the **Basics** tab:
   + **Resource Group**: Enter in your resource group
   +  **Virtual Machine Name**: Any name, for example sms\-connector\-vm\-westus
   + **Region**: Select your Azure Region
   + **Size**: F4s
   + **Public Inbound Ports**: None

   Under the **Disks** tab:
   + **OS Disk Type**: Standard HDD

   Under the **Networking** tab:
   + **Virtual Network**: Enter in your Virtual Network name
   + **Subnet**: Leave as default or choose a particular subnet
   + **Public IP**: Leave as new
   + **NIC Network Security Group**: Basic
   + **Public Inbound Ports**: None
   + Accept defaults for the remaining fields\.

   Under the **Management** tab: 
   + **Boot Diagnostics**: On 
   + **OS Guest Diagnostics**: Off
   + **Diagnostics Storage account**: Storage Account
   + **System Assigned Managed Identity**: On
   + **Enable auto\-shutdown**: Off

1. Review and create the VM\. This will be your connector VM\.

1. Download the two role documents:
   + [https://s3\.amazonaws\.com/sms\-connector/SMSConnectorRole\.json](https://s3.amazonaws.com/sms-connector/SMSConnectorRole.json)
   + [https://s3\.amazonaws\.com/sms\-connector/SMSConnectorRoleSA\.json](https://s3.amazonaws.com/sms-connector/SMSConnectorRoleSA.json)

1. **\(Important\)** Customize the role documents\.

   Edit `SMSConnectorRole.json`\. Change the `name` field to `sms-connector-role-`*subscription\_id*\. Then change the `AssignableScopes` field to match your subscription ID\.

   Edit `SMSConnectorRoleSA.json`\. Change the `name` field to `sms-connector-role-`*storage\_account*\. For example, if your account is *testStorage*, then the name field must be `sms-connector-role-testStorage`\. Then change the `AssignableScopes` field to match your Subscription, Resource Group, and Storage Account values\.

1. Create a role definition\. Currently, there is no way to create a role definition from the Azure Portal\. You must use Az CLI or Az PowerShell for this step\. Use the [New\-AzRoleDefinition](https://docs.microsoft.com/en-us/powershell/module/az.resources/new-azroledefinition) \(Az PowerShell\) or [az role definition create](https://docs.microsoft.com/en-us/cli/azure/role/definition#az-role-definition-create) \(Az CLI\) command to create these custom roles in your subscription, using the JSON files that you created in the previous step\.

1. Assign roles to the connector VM\. In Azure Portal, choose **Storage Account**, **Access Control**, **Roles**, **Add**, **Add Role Assignment**\. Choose the role `sms-connector-role`, assign access to *Virtual Machine*, and select the connector VM’s System Assigned Identity from the list\. Repeat this for the role `sms-connector-role-storage_account`\.

1. Restart the connector VM to activate the role assignments\.

1. Continue to [Step 4: Configure the connector](#azure-connector-configuration)\.