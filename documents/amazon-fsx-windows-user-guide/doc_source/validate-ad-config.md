# Validating Your Active Directory Configuration<a name="validate-ad-config"></a>

 Before you create an Amazon FSx for Windows File Server file system joined to your Active Directory, we recommend that you validate your Active Directory configuration using the Amazon FSx Active Directory Validation tool\. <a name="test-ad-network-config"></a>

**To validate your Active Directory configuration**

1. Launch an Amazon EC2 Windows instance in the same subnet and with the same Amazon VPC security groups that you will use for your Amazon FSx for Windows File Server file system\.

1. Join your EC2 Windows instance to your Active Directory\. For more information, see [Manually Join a Windows Instance](https://docs.aws.amazon.com/directoryservice/latest/admin-guide/join_windows_instance.html) in the *AWS Directory Service Administration Guide*\.

1. Connect to your EC2 instance\. For more information, see [Connecting to Your Windows Instance](https://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/connecting_to_windows_instance.html) in the *Amazon EC2 User Guide for Windows Instances*\.

1. Open a Windows PowerShell window \(using **Run as Administrator**\) on the EC2 instance\. 

   To test whether the required Active Directory module for Windows PowerShell is installed, use the following test command\.

   ```
   PS C:\> Import-Module ActiveDirectory
   ```

   If above returns an error, install it using the following command\.

   ```
   PS C:\> Install-WindowsFeature RSAT-AD-PowerShell
   ```

1. Download the network validation tool using the following command\. 

   ```
   PS C:\> Invoke-WebRequest "https://docs.aws.amazon.com/fsx/latest/WindowsGuide/samples/AmazonFSxADValidation.zip" -OutFile "AmazonFSxADValidation.zip"
   ```

1. Expand the zip file by using the following command\.

   ```
   PS C:\> Expand-Archive -Path "AmazonFSxADValidation.zip"
   ```

1. Add the AmazonFSxADValidation module to the current session\.

   ```
   PS C:\> Import-Module .\AmazonFSxADValidation
   ```

1. Set required parameters by substituting into the following command your:
   + Active Directory domain name \(*DOMAINNAME\.COM*\)
   + Service account username \(*SERVICE\_ACCOUNT\_USER*\)
   + Service account password \(*SERVICE\_ACCOUNT\_PASSWORD*\)
   + DNS server IP addresses \(*IP\_ADDRESS\_1*, *IP\_ADDRESS\_2*\)
   + Subnet ID\(s\) for subnets where you plan to create your Amazon FSx file system \(*SUBNET\_1*, *SUBNET\_2*, for example, `subnet-04431191671ac0d19`\)\.

   ```
   PS C:\> # Credential for Amazon FSx service account
   $Password = ConvertTo-SecureString 'SERVICE_ACCOUNT_PASSWORD' -AsPlainText -Force
   $Credential = New-Object System.Management.Automation.PSCredential ('SERVICE_ACCOUNT_USER', $Password)
   
   $FSxADValidationArgs = @{
       # DNS root of ActiveDirectory domain
       DomainDNSRoot = 'DOMAINNAME.COM'
   
       # IP v4 addresses of DNS servers
       DnsIpAddresses = @('IP_ADDRESS_1', 'IP_ADDRESS_2')
   
       # Subnet IDs for Amazon FSx file server(s)
       SubnetIds = @('SUBNET_1', 'SUBNET_2')
   
       Credential = $Credential
   }
   ```

1. \(Optional\) Set Organizational Unit, Delegated Administrators group, and enable service account permission validation by following instructions in the included `README.md` file prior to running the validation tool\.

1. Run the validation tool by using this command\.

   ```
   PS C:\> $Result = Test-FSxADConfiguration @FSxADValidationArgs
   ```

1. The following is an example of a successful test result\.

   ```
   Test 1 - Validate EC2 Subnets ...
   ...
   Test 16 - Validate 'Delete Computer Objects' permission ...
   
   Test computer object amznfsxtestd53f deleted!
   ...
   SUCCESS - All tests passed! Please proceed to creating an Amazon FSx file system. For your convenience, SelfManagedActiveDirectoryConfiguration of result can be used directly in CreateFileSystemWindowsConfiguration for New-FSXFileSystem
   PS C:\AmazonFSxADValidation> $Result.Failures.Count
   0
   PS C:\AmazonFSxADValidation> $Result.Warnings.Count
   0
   ```

   The following is an example of a test result with errors\.

   ```
   Test 1 - Validate EC2 Subnets ...
   ...
   Test 7 - Validate that provided EC2 Subnets belong to a single AD Site ...
   
   Name          DistinguishedName                                                         Site
   ----          -----------------                                                         ----
   10.0.0.0/19   CN=10.0.0.0/19,CN=Subnets,CN=Sites,CN=Configuration,DC=test-ad,DC=local   CN=SiteB,CN=Sites,CN=Configu...
   10.0.128.0/19 CN=10.0.128.0/19,CN=Subnets,CN=Sites,CN=Configuration,DC=test-ad,DC=local CN=Default-First-Site-Name,C...
   10.0.64.0/19  CN=10.0.64.0/19,CN=Subnets,CN=Sites,CN=Configuration,DC=test-ad,DC=local  CN=SiteB,CN=Sites,CN=Configu...
   
   
   
   Best match for EC2 subnet subnet-092f4caca69e360e7 is AD site CN=Default-First-Site-Name,CN=Sites,CN=Configuration,DC=te
   st-ad,DC=local
   Best match for EC2 subnet subnet-04431191671ac0d19 is AD site CN=SiteB,CN=Sites,CN=Configuration,DC=test-ad,DC=local
   WARNING: EC2 subnets subnet-092f4caca69e360e7 subnet-04431191671ac0d19 matched to different AD sites! Make sure they
   are in a single AD site.
   ...
   9 of 16 tests skipped.
   FAILURE - Tests failed. Please see error details below:
   
   Name                           Value
   ----                           -----
   SubnetsInSeparateAdSites       {subnet-04431191671ac0d19, subnet-092f4caca69e360e7}
   
   
   
   Please address all errors and warnings above prior to re-running validation to confirm fix.
   PS C:\AmazonFSxADValidation> $Result.Failures.Count
   1
   PS C:\AmazonFSxADValidation> $Result.Failures
   
   Name                           Value
   ----                           -----
   SubnetsInSeparateAdSites       {subnet-04431191671ac0d19, subnet-092f4caca69e360e7}
   
   
   PS C:\AmazonFSxADValidation> $Result.Warnings.Count
   0
   ```

   If you receive warnings or errors when you run the validation tool, refer to the Troubleshooting guide included in the validation tool package \(`TROUBLESHOOTING.md`\) and [Troubleshooting Problems for Amazon FSx](troubleshooting.md) in the Amazon FSx for Windows File Server documentation\. 