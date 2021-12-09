# You Can't Access Your File System Using Remote PowerShell<a name="remote-pwr-shell"></a>

There are a number of potential causes for being unable to connect to your file system using Remote PowerShell, each with their own resolution, as follows\.

**Potential Cause**  
The file system's security group lacks the required inbound rules to allow a remote PowerShell connection\.

**Resolution**  
The file system's security group must have an inbound rule that allows traffic on port 5985 in order to establish a Remote PowerShell session\. For more information, see [Amazon VPC Security Groups](limit-access-security-groups.md#fsx-vpc-security-groups)\.

**Potential Cause**  
You have an external trust configured between the AWS managed Microsoft AD and your on premise AD\.

**Resolution**  
In order to use the Amazon FSx Remote Powershell with Kerberos authentication, you need to configure a local group policy on the client for forest search order\. For more information, see the Microsoft documentation [Configure Kerberos Forest Search Order \(KFSO\)](https://docs.microsoft.com/en-us/previous-versions/windows/it-pro/windows-server-2008-R2-and-2008/hh921473(v=ws.10)?redirectedfrom=MSDN)\.

**Potential Cause**  
A language localization error occurs when trying to initiate a remote PowerShell session\.

**Resolution**  
You need to add the following `-SessionOption` to your command: `-SessionOption (New-PSSessionOption -uiCulture "en-US")`

Following are two examples using `-SessionOption` when initiating a remote PowerShell session on your file system\.

```
PS C:\Users\delegateadmin> Invoke-Command -ComputerName Windows Remote PowerShell Endpoint -ConfigurationName FSxRemoteAdmin -scriptblock {fsx-command} -SessionOption (New-PSSessionOption -uiCulture "en-US")
```

```
PS C:\Users\delegateadmin> Enter-Pssession -ComputerName Windows Remote PowerShell Endpoint -ConfigurationName FsxRemoteAdmin -SessionOption (New-PSSessionOption -uiCulture "en-US")
```