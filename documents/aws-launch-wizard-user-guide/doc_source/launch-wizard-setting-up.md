# Setting up for AWS Launch Wizard for SQL Server<a name="launch-wizard-setting-up"></a>

The following prerequisites must be verified in order to deploy a SQL Server Always On application with AWS Launch Wizard\.

**Topics**
+ [Active Directory](#launch-wizard-ad)
+ [AWS Identity and Access Management \(IAM\)](#launch-wizard-iam)
+ [Using custom AMIs](#launch-wizard-custom-ami)
+ [Requirements](#launch-wizard-requirements)
+ [Configuration settings](#launch-wizard-config)

## Active Directory<a name="launch-wizard-ad"></a>

### AWS Managed Active Directory<a name="launch-wizard-ad-managed"></a>

If you are [deploying SQL Server into an existing VPC with an existing Active Directory](launch-wizard-deployment-options.md#option-3), Launch Wizard uses your Managed Active Directory \(AD\) domain user credentials to set up a fully functional SQL Server Always On Availability Group in the Active Directory\. Currently, Launch Wizard only supports this deployment option for an AWS Managed Active Directory\. Your Managed Active Directory does not have to be in the same VPC as the one in which SQL Server Always On is deployed\. If it is in a different VPC than the one in which SQL Server Always On is deployed, ensure that you set up connectivity between the two VPCs\.The domain user requires the following permissions in the [Active Directory Default organizational unit \(OU\)](https://docs.microsoft.com/en-us/windows-server/identity/ad-ds/plan/creating-an-organizational-unit-design) to enable Launch Wizard to perform the deployment successfully\.
+ Join machines to the domain
+ Create user accounts
+ Create computer objects
+ Read all properties
+ Modify permissions

The following key operations are performed against your Active Directory by Launch Wizard\. These operations result in the creation of new records or entries in Active Directory\.
+ SQL Server service user added as a new Active Directory user if it does not already exist in Active Directory\.
+ SQL Server instance and Remote Desktop Gateway Access instance joined to the Active Directory domain\.
+ CreateChild role added to Windows Server Failover Cluster as part of ActiveDirectoryAccessRule\.
+ FullControl role added to SQL Server Service user as part of FileSystemRights\.

### On\-premises Active Directory through AWS Direct Connect<a name="launch-wizard-ad-onprem"></a>

If you are [deploying SQL Server into an existing VPC and connecting to an on-premises Active Directory](launch-wizard-deployment-options.md#option-4), ensure the following prerequisites\.
+ Make sure you have connectivity between your AWS account and your on\-premises network\. You can establish a dedicated network connection from your on\-premises network to your AWS account with AWS Direct Connect\. For more information, see [the AWS Direct Connect documentation](https://docs.aws.amazon.com/directconnect/latest/UserGuide/Welcome.html)\. 
+ The domain functional level of your Active Directory domain controller must be Windows Server 2012 or later\.
+ The IP addresses of your DNS server must be either in the same VPC CIDR range as the one in which your Launch Wizard SQL Server Always On deployment will be created, or in the private IP address range\. 
+ The firewall on the Active Directory domain controllers should allow the connections from the Amazon VPC from which you will create the Launch Wizard deployment\. At a minimum, your configuration should include the ports mentioned in [How to configure a firewall for Active Directory domains and trusts](https://support.microsoft.com/en-us/help/179442/how-to-configure-a-firewall-for-domains-and-trusts)\.

You can optionally perform the following step\.
+ Establish DNS resolution across your environments\. For options on how to set this up, see [ How to Set Up DNS Resolution Between On\-Premises Networks and AWS Using AWS Directory Service and Amazon Route 53](https://aws.amazon.com/blogs/security/how-to-set-up-dns-resolution-between-on-premises-networks-and-aws-using-aws-directory-service-and-amazon-route-53/) or [How to Set Up DNS Resolution Between On\-Premises Networks and AWS Using AWS Directory Service and Microsoft Active Directory](https://aws.amazon.com/blogs/security/how-to-set-up-dns-resolution-between-on-premises-networks-and-aws-using-aws-directory-service-and-microsoft-active-directory/)\.

## AWS Identity and Access Management \(IAM\)<a name="launch-wizard-iam"></a>

The following steps for establishing the AWS Identity and Access Management \(IAM\) role and setting up the IAM user for permissions are typically performed by an IAM Administrator for your organization\. 

### One\-time creation of IAM Role<a name="launch-wizard-iam-role"></a>

On the **Choose Application** page of Launch Wizard, under **Permissions**, Launch Wizard displays the IAM role required for the Amazon EC2 service to access other AWS services on your behalf\. When you select **Next**, Launch Wizard attempts to discover the IAM role in your account\. If the role exists, the role is attached to the instance profile for the EC2 instances that Launch Wizard will launch into your account\. If the role does not exist, Launch Wizard attempts to create the role with the same name, `AmazonEC2RoleForLaunchWizard`\. This role is comprised of two IAM managed policies: `AmazonSSMManagedInstanceCore` and `AmazonEC2RolePolicyForLaunchWizard`\. After the role is created, the IAM Administrator can delegate the application deployment process to another IAM user who, in turn, must have the Launch Wizard IAM managed policy described in the following section\.

### IAM user setup<a name="launch-wizard-iam-user-setup"></a>

To deploy a SQL Server Always On application with Launch Wizard, you must create an [Identity and Access Management \(IAM\) policy](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html) and attach it to your IAM user identity\. The IAM policy defines the user permissions\. If you do not already have an IAM user in your account, follow the steps listed in [Create an IAM User in Your AWS Account](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_users_create.html)\.

When you have an IAM user in your account, create an IAM policy\.

1. Go to the IAM console at [ https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam)\. In the left navigation pane, choose **Policies**\.

1. Choose **Users** from the left navigation pane\. 

1. Select the **User name** of the user to which you want to attach the policy\.

1. Select **Add permissions**\. 

1. Select **Attach existing policies directly**\. 

1. Search for the policy named `AmazonLaunchWizardFullaccess` and select the check box to the left of the policy name\.

1. Select **Next: Review**\. 

1. Verify that the correct policy is listed, and then select **Add permissions**\. 

**Important**  
Make sure that you log in with the user associated with the above policy when you use Launch Wizard\. 

## Using custom AMIs<a name="launch-wizard-custom-ami"></a>

We recommend that you use Amazon Windows license\-included AMIs whenever possible\. There are occasions when you may want to use a custom AMI\. For example, you may have existing licenses \(BYOL\) or you may have made changes to one of our public images and re\-imaged it\.

If you use Amazon Windows license\-included AMIs, you are not required to perform any pre\-checks on the AMI to ensure that it meets Launch Wizard requirements\.

Launch Wizard relies on user data to begin the process of configuring SQL Server or RGW instances the service launches in your accounts\. For more information, see [User Data Scripts](https://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/ec2-windows-user-data.html)\. By default, all AWS Windows AMIs have user data execution enabled for the initial launch\. To ensure that your custom AMIs are set up to run the User Data script at launch, follow the AWS recommended method to prepare your AMIs using either EC2Launch \(Windows Server 2016 and later\) or the EC2Config service \(Windows 2012 R2 and earlier\)\. For more information about how to prepare your custom AMI using the options to Shutdown with Sysprep or Shutdown without Sysprep, see [Create a Standard Amazon Machine Image Using Sysprep](https://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/ami-create-standard.html)\. For Windows Server 2016 and later, see [Using Sysprep with EC2Launch ](https://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/ec2launch.html#ec2launch-sysprep)\. If you want to directly enable user data as part of the custom AMI creation process, follow the steps for Subsequent Reboots or Starts under [Running Commands on Your Windows Instance at Launch](https://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/ec2-windows-user-data.html)\. 

If you use a custom AMI, the volume drive letter for the root partition should be `C:`, because EC2Launch and EC2Config rely on this configuration to install the components\. 

## Requirements<a name="launch-wizard-requirements"></a>

While not exhaustive, the following requirements cover most of the configurations whose alteration might impact the successful deployment of a SQL Server Always On application using Launch Wizard\.


| SQL Server Version | Windows Server 2012 R2 | Windows Server 2016 | Windows Server 2019 | 
| --- | --- | --- | --- | 
|  SQL Server 2016  |  YES  |  YES  |  YES  | 
|  SQL Server 2017  |  YES  |  YES  |  YES  | 
| SQL Server 2019 | Currently not supported\.  | YES | YES | 

**OS and SQL Requirements**
+ Microsoft Windows Server 2012 R2 \(Datacenter\) \(64\-bit only\)
+ Microsoft Windows Server 2016 \(Datacenter\) \(64\-bit only\)
+ Microsoft Windows Server 2019 \(Datacenter\) \(64\-bit only\)
+ MBR\-partitioned volumes and GUID Partition Table \(GPT\) partitioned volumes that are formatted using the NTFS file system
+ English language pack only
+ SQL Server Enterprise Edition 2017/2016 or Standard Edition 2017/2016
+ The root volume drive for the custom AMI should be `C:`
+ SQL Server is installed in the root drive

**AWS Software and Drivers**
+ EC2Config service \(Windows Server 2012 R2\)
+ EC2Launch \(Windows Server 2016\)
+ AWS Systems Manager \([SSM agent must be installed](https://docs.aws.amazon.com/systems-manager/latest/userguide/sysman-install-win.html)\)
+ AWS Tools for Windows PowerShell
+ Network drivers \(SRIOV, ENA\)
+ Storage drivers \(NVMe, AWS PV\)

## Configuration settings<a name="launch-wizard-config"></a>

The following configuration settings are applied when deploying a SQL Server Always On application with Launch Wizard\.


| Setting | Applies to | 
| --- | --- | 
|  Current EC2Config and SSM Agent  |  Windows Server 2012 R2  | 
|  Current EC2Launch and SSM Agent  |  Windows Server 2016 and 2019  | 
|  Current AWS PV, ENA, and NVMe drivers  |  Windows Server 2012 R2, 2016, and 2019  | 
|  Current SRIOV drivers  |  Windows Server 2012 R2, 2016, and 2019  | 
|  Microsoft SQL Server: Latest service pack SQL Service configured to start automatically SQL Service running BUILTIN\\Administrators added to the SysAdmin server role TCP port 1433 and UDP port 1434 open  |  Windows Server 2012 R2, 2016, and 2019  | 
|  Allow ICMP traffic through the firewall  |  Windows Server 2012 R2, 2016, and 2019  | 
|  Allow RDP traffic through host firewall  |  Windows Server 2012 R2, 2016, and 2019  | 
|  Enable file and printer sharing  |  Windows Server 2012 R2  | 
|  RealTimeIsUniversal registry key set  |  Windows Server 2012 R2, 2016, and 2019  | The following AMI settings can impact the Launch Wizard deployment:

**System Time**  
**RealTimeIsUniversal**\. If disabled, Windows system time drifts when the time zone is set to a value other than UTC\.

**Windows Firewall**  
In most cases, Launch Wizard configures the correct protocols and ports\. However, custom Windows Firewall rules could impact the cluster service\. To ensure that your custom AMI works with Launch Wizard, see [Service overview and network port requirements for Windows](https://support.microsoft.com/en-us/help/832017/service-overview-and-network-port-requirements-for-windows)\.

**Remote Desktop**  
**Service Start**\. Remote Desktop service must be enabled\.  
**Remote Desktop Connections**\. Must be enabled\.

**EC2Config** \(Server 2012 R2\)  
**Installation**\. We recommend using the latest version of EC2Config\.  
**Service Start**\. EC2Config service should be enabled\.

**Network Interface**  
**DHCP Service Startup**\. DHCP service should be enabled\.  
**DHCP on Ethernet**\. DHCP should be enabled\.