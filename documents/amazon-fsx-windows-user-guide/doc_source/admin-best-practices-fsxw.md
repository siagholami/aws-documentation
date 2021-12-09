# Best Practices for Administering Amazon FSx File Systems<a name="admin-best-practices-fsxw"></a>

Amazon FSx provides several features that can help you implement best practices for administering your file systems, including:
+ optimizing storage consumption
+ enabling end\-users to recover files and folders to previous versions
+ enforcing encryption for all connected clients

Use the following Amazon FSx CLI for Remote Management on PowerShell commands to quickly implement these best practices on your file systems\. 

To run these commands, you must know the *Windows Remote PowerShell Endpoint* for your file system\. To find this endpoint, follow these steps:

1. Open the Amazon FSx console at [https://console\.aws\.amazon\.com/fsx/](https://console.aws.amazon.com/fsx/)\.

1. Choose your file system\. On the **Network & security** tab, locate the **Windows Remote PowerShell Endpoint**, as shown following\.

![\[FSx console Network & security tab, Windows Remote PowerShell Endpoint.\]](http://docs.aws.amazon.com/fsx/latest/WindowsGuide/images/FSx-network-sec-tab.png)

For more information, see [Administering File Systems](administering-file-systems.md) and [Getting Started with the Amazon FSx CLI for Remote Management on PowerShellGetting Started](remote-pwrshell.md)\.

**Topics**
+ [One\-Time Administrative Setup Tasks](#one-time-admin-tasks)
+ [Ongoing Administration Tasks to Monitor Your File System](#bestpractice2)

## One\-Time Administrative Setup Tasks<a name="one-time-admin-tasks"></a>

The following are tasks that you can quickly set up once for your file system\.

### Managing Storage Consumption<a name="manage-disk-usage"></a>

Use the following commands to manage your file system storage consumption\.
+ To turn on data deduplication with the default schedule, run the following command\.

  ```
  Invoke-Command -ComputerName $FSxWindowsRemotePowerShellEndpoint -ConfigurationName FSxRemoteAdmin -ScriptBlock { Enable-FsxDedup }
  ```

  Optionally, use the following command to get data deduplication operating on your files soon after a file is created, without requiring any minimum file age\.

  ```
  Invoke-Command -ComputerName $FSxWindowsRemotePowerShellEndpoint -ConfigurationName FSxRemoteAdmin -ScriptBlock { Set-FSxDedupConfiguration -MinimumFileAgeDays 0 }
  ```

  For more information, see [Data Deduplication](using-data-dedup.md)\. 

   
+ Use the following command to turn on user storage quotas in “Track” mode, which is for reporting purposes only and not for enforcement\.

  ```
  $QuotaLimit = Quota limit in bytes
  $QuotaWarningLimit = Quota warning threshold in bytes
  Invoke-Command -ComputerName $FSxWindowsRemotePowerShellEndpoint -ConfigurationName FSxRemoteAdmin -ScriptBlock { Enable-FSxUserQuotas -Track -DefaultLimit $Using:QuotaLimit -DefaultWarningLimit $Using:QuotaWarningLimit }
  ```

  For more information, see [Storage Quotas](managing-user-quotas.md)\.

### Turning on Shadow Copies to Enable End\-Users to Recover Files and Folders to Previous Versions<a name="turn-on-shadow-copies"></a>

Turn on shadow copies with the default schedule \(weekdays 7 AM and 12 noon\), as follows\.

```
Invoke-Command -ComputerName $FSxWindowsRemotePowerShellEndpoint -ConfigurationName FSxRemoteAdmin -ScriptBlock { Set-FsxShadowStorage -Default }
     
Invoke-Command -ComputerName $FSxWindowsRemotePowerShellEndpoint -ConfigurationName FSxRemoteAdmin -ScriptBlock { Set-FsxShadowCopySchedule -Default -Confirm:$False}
```

For more information, see [Shadow Copies](manage-shadow-cpy.md)\.

### Enforcing Encryption in Transit<a name="admin-encryption"></a>

The following command enforces encryption for clients connecting to your file system\.

```
Invoke-Command -ComputerName $FSxWindowsRemotePowerShellEndpoint -ConfigurationName FSxRemoteAdmin -ScriptBlock { Set-FsxSmbServerConfiguration -EncryptData $True -RejectUnencryptedAccess $True -Confirm:$False}
```

You can close all open sessions and force clients currently connected to reconnect using encryption\.

```
Invoke-Command -ComputerName $FSxWindowsRemotePowerShellEndpoint -ConfigurationName FSxRemoteAdmin -ScriptBlock { Close-FSxSmbSession -Confirm:$False}
```

For more information, see [Encryption in Transit](manage-encrypt-in-transit.md) and [User Sessions and Open Files](manage-sessions-and-files.md)\.

## Ongoing Administration Tasks to Monitor Your File System<a name="bestpractice2"></a>

The following ongoing tasks help you monitor your file system's disk usage, user quotas, and open files\.

### Monitoring Deduplication Status<a name="monitor-dedup"></a>

Monitor deduplication status, including the savings rate achieved on your file system, as follows\.

```
Invoke-Command -ComputerName $FSxWindowsRemotePowerShellEndpoint -ConfigurationName FsxRemoteAdmin -ScriptBlock { Get-FSxDedupStatus } | select OptimizedFilesCount,OptimizedFilesSize,SavedSpace,OptimizedFilesSavingsRate
```

### Monitoring User\-Level Storage Consumption<a name="monitor-storage-consumption"></a>

Get a report of the current user storage quota entries, including how much space they're consuming and whether they’re violating the limit and the warning threshold\.

```
Invoke-Command -ComputerName $FSxWindowsRemotePowerShellEndpoint -ConfigurationName FSxRemoteAdmin -ScriptBlock { Get-FSxUserQuotaEntries }
```

### Monitoring and Closing Open Files<a name="monitor-files"></a>

Manage open files by looking for files left open, and closing them\. Use the following command to check for open files\.

```
Invoke-Command -ComputerName $FSxWindowsRemotePowerShellEndpoint -ConfigurationName FSxRemoteAdmin -ScriptBlock { Get-FSxSmbOpenFile}
```

Use the following command to close open files\.

```
Invoke-Command -ComputerName $FSxWindowsRemotePowerShellEndpoint -ConfigurationName FSxRemoteAdmin -ScriptBlock { Close-FSxSmbOpenFile -Confirm:$false}
```