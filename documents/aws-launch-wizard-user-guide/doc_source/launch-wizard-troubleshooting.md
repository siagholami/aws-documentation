# Troubleshooting AWS Launch Wizard for SQL Server<a name="launch-wizard-troubleshooting"></a>

Each application in your account in the same AWS Region can be uniquely identified by the application name specified at the time of a deployment\. The application name can be used to view the details related to the application launch\.

**Topics**
+ [Active Directory objects and DNS record clean up](#launch-wizard-ad-dns-clean)
+ [Launch Wizard provisioning events](#launch-wizard-provisioning)
+ [CloudWatch Logs](#launch-wizard-logs)
+ [SSM Automation execution](#launch-wizard-ssm-automation)
+ [AWS CloudFormation stack](#launch-wizard-cloudformation)
+ [Application launch limits](#launch-wizard-limits)
+ [Errors](#launch-wizard-errors)

## Active Directory objects and DNS record clean up<a name="launch-wizard-ad-dns-clean"></a>

When you delete a deployment, you lose all specification settings for the SQL Server Always On application\. Launch Wizard attempts to delete only the AWS resources that it created in your account as part of the deployment\. If you created resources outside of Launch Wizard, for example, resources in a VPC created by Launch Wizard, the deletion can fail\. Launch Wizard does not delete Active Directory objects in your Active Directory, nor does it delete any of the records in your DNS server\. Launch Wizard has no control over your Active Directory domain user password over time, which is required to clean up Active Directory objects or DNS records\. We recommend that you remove these entries from your Active Directory after Launch Wizard deletes the deployment\.

If the initial Active Directory objects or DNS records are not cleaned up, then when you attempt to deploy Launch Wizard on an existing Active Directory using a deployment name that has already been used or Availability Group/Listener/Cluster name that has already been used, the deployment may fail with the following error\.

**Error message**

`System.Management.Automation.Remoting.PSRemotingTransportException: Connecting to remote server xxxxxx failed with the following error message : WinRM cannot complete the operation. Verify that the specified computer name is valid, that the computer is accessible over the network, and that a firewall exception for the WinRM service is enabled and allows access from this computer. By default, the WinRM firewall exception for public profiles limits access to remote computers within the same local subnet.`

To address this error, we recommend that you remove the initial entries from your Active Directory\.

To clean up Active Directory Objects, run the following example PowerShell commands as a domain user with the appropriate authorization to perform these operations\.

`$Pwd = ConvertTo-SecureString $password -AsPlainText –Force`

`$cred = New-Object System.Management.Automation.PSCredential $domainUser, $Pwd`

`$ADObject = Get-ADObject -Filter 'DNSHostName -eq “SQLnode.example.com”`

`Remove-ADObject -Recursive -Identity $ADObject -Credential $cred`

To remove a DNS Record, the name of the record that you want to delete \(SQL Server node name\), the DNS server FQDN, and the DNS zone within which the record is residing are required\. The following are example PowerShell commands to perform the DNS record removal\.

`$NodeDNS = Get-DnsServerResourceRecord -ZoneName $ZoneName -ComputerName $DNSServer -Node $NodeToDelete -RRType A -ErrorAction SilentlyContinue`

`Remove-DnsServerResourceRecord -ZoneName $ZoneName -ComputerName $DNSServer -InputObject $NodeDNS -Force`

## Launch Wizard provisioning events<a name="launch-wizard-provisioning"></a>

Launch Wizard captures events from SSM Automation and AWS CloudFormation to track the status of an ongoing application deployment\. If an application deployment fails, you can view the deployment events for this application by selecting **Deployments** from the navigation pane\. A failed event shows a status of **Failed** along with a failure message\. 

## CloudWatch Logs<a name="launch-wizard-logs"></a>

Launch Wizard streams provisioning logs from all of the AWS log sources, such as AWS CloudFormation, SSM, and CloudWatch Logs\. CloudWatch Logs for a given application name can be viewed on the CloudWatch console for the log group name `LaunchWizard-APPLICATION_NAME` and log stream `ApplicationLaunchLog`\. 

## SSM Automation execution<a name="launch-wizard-ssm-automation"></a>

Launch Wizard uses SSM Automation to provision SQL Server Always On applications\. SSM Automation execution can be found in your account using the `ssm describe-automation-executions` API, and adding document name prefix filters\. Launch Wizard launches various automation documents in your account for validation and application provisioning\. The following are the relevant filters for the `ssm describe-automation-executions` API\.
+ **Validation: Validate VPC connectivity**

  `LaunchWizard-Validate-VPC-Connectivity-APPLICATION_NAME-Subnet_id`, where `Subnet_id` is the subnet on which to perform the validation\.
+ **Validation: Validate credentials**

  `LaunchWizard-Validate-Credentials-APPLICATION_NAME`
+ **Application Provisioning: Provisioning resources and Post Configuration**

  `LaunchWizard-SQLHAAlwaysOn-APPLICATION_NAME-Provision`

You can view the status of these SSM Automation executions\. If any of them fail, you can view the cause of the failure\.

## AWS CloudFormation stack<a name="launch-wizard-cloudformation"></a>

Launch Wizard uses AWS CloudFormation to provision the infrastructure resources of an application\. CloudFormation stacks can be found in your account using the CloudFormation `describe-stacks` API\. Launch Wizard launches various stacks in your account for validation and application resource creation\. The following are the relevant filters for the `describe-stacks` API\.
+ **Validation**

  `LaunchWizard-APPLICATION_NAME-checkCredentials-SSM_execution_id`
+ **Validation**

  `LaunchWizard-APPLICATION_NAME-checkVPCConnectivity-SSM_execution_id`
+ **Application resources**

  `LaunchWizard-APPLICATION_NAME`\. This stack also has nested stacks for VPC, AD, the RDGW node, and SQL nodes\.

You can view the status of these CloudFormation stacks\. If any of them fail, you can view the cause of failure\.

## Application launch limits<a name="launch-wizard-limits"></a>

Launch Wizard allows for a maximum of 50 active applications \(with status `in progress` or `completed`\) for any given application type\. If you want to increase this limit, contact [AWS Support](https://aws.amazon.com/contact-us)\. Launch Wizard supports 3 paralell in\-progress deployment per account\. 

## Errors<a name="launch-wizard-errors"></a>

**Directory fails to create**
+ **Cause:** An internal service error has been encountered during the creation of the directory\.
+ **Solution:** Retry the operation\. For this scenario, you must retry the deployment from the initial page of the Launch Wizard console\.

**Your requested instance type is not supported in your requested Availability Zone**
+ **Cause:** This failure might happen during the launch of either your RDGW instance or your SQL Server instance, or during the validation of the instances that Launch Wizard launches in your selected subnets\. 
+ **Solution:** For this scenario, you must choose a different Availability Zone and retry the deployment from the initial page of the Launch Wizard console\.

**Validate connectivity for subnet\. The following resource\(s\) failed to create: \[ValidationNodeWaitCondition\]**

This failure can occur for multiple reasons\. The following list shows known causes and solutions\.
+ 

**VPC or subnet configuration does not meet prerequisites**
  + **Cause:** This failure occurs when your VPC or subnet configuration does not meet the prerequisites documented in the VPC Connectivity Section under [Accessing and deploying an application with AWS Launch Wizard for SQL Server](launch-wizard-deploying.md)\. If the failure message points to your selected public subnet, then the public subnet is not configured for outbound internet access\. If the failure message points to one of your selected private subnets, then the specified private subnet does not have outbound connectivity\. 
  + **Solution:** Check that your VPC includes one public subnet and, at least, two private subnets\. Your VPC must be associated with a DHCP Options Set to enable DNS translations to work\. The private subnets must have outbound connectivity to the internet and other AWS services \(S3, CFN, SSM, and Logs\)\. We recommend that you enable this connectivity with a NAT Gateway\. Note that, in the console, when you select a private subnet for the public subnet dropdown or you select a public subnet for the private subnet dropdown, you will encounter the same error\. Please refer to the VPC Connectivity section under [Accessing and deploying an application with AWS Launch Wizard for SQL Server](launch-wizard-deploying.md) for more information about how to configure your VPC\.
+ 

**EC2 instance stabilization error**
  + **Cause:** Failure can occur if the EC2 instance used for validation fails to stabilize\. When this happens, the EC2 instance is unable to communicate to the CloudFormation service to signal completions, resulting in `WaitCondition` errors\. 
  + **Solution:** Please contact [AWS Support](https://aws.amazon.com/support) for assistance\.