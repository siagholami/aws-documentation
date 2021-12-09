# Data Deduplication<a name="using-data-dedup"></a>

Large datasets often have redundant data, which increases the data storage costs\. For example, with user file shares, multiple users can store many copies or versions of the same file\. With software development shares, many binaries remain unchanged from build to build\. 

You can reduce your data storage costs by turning on data deduplication for your file system\. *Data deduplication *reduces or eliminates redundant data by storing duplicated portions of the dataset only once\. Because data deduplication runs as a background process, it doesn't significantly affect your file system's performance\. It's also transparent to your users and connected clients\. After data deduplication is enabled, it continually and automatically scans and optimizes your file system in the background\. 

The storage savings that you can achieve with data deduplication depends on the nature of your dataset, including how much duplication exists across files\. Typical savings average 50–60 percent for general\-purpose file shares\. Within shares, savings range from 30–50 percent for user documents to 70–80 percent for software development datasets\.

## Enabling Data Deduplication<a name="enable-dedup"></a>

You enable data deduplication on an Amazon FSx for Windows File Server file share using the `Enable-FSxDedup` command, as follows\.

```
PS C:\Users\Admin> Invoke-Command -ComputerName amznfsxzzzzzzzz.corp.example.com -ConfigurationName FSxRemoteAdmin -ScriptBlock {Enable-FsxDedup }
```

When you enable data deduplication, a default data dedup schedule is in place\. Also, the minimum file age before optimizing is set to 3 days\.

## Setting a Data Deduplication Schedule<a name="set-dedup-sched"></a>

Even though the default schedule works well in most cases, you can modify an existing deduplication schedule by using the `Set-FsxDedupSchedule`, shown as follows\.

```
PS C:\Users\Admin> Invoke-Command -ComputerName amznfsxzzzzzzzz.corp.example.com -ConfigurationName FSxRemoteAdmin -ScriptBlock {   
New-FSxDedupSchedule -Name "CustomOptimization" -Type Optimization -Days Mon,Tues,Wed,Sat -Start 08:00 -DurationHours 9
}
```

 This command modifies the default `BackgroundOptimization` schedule to run on days Monday to Wednesday and Saturday, starting the job at 8:00 am each day, with a maximum duration of 9 hours, after which the job stops if it is still running\. 

 To modify the minimum file age before optimizing setting, use the `Set-FSxDedupConfiguration` command\. 

## Retrieving the Dedup Configuration<a name="get-dedup-config"></a>

You can retrieve the data dedup configuration for a file system using the `Get-FsxDedupConfiguration` command, as follows\.

```
PS C:\Users\Admin> Invoke-Command -ComputerName amznfsxzzzzzzzz.corp.example.com -ConfigurationName FSxRemoteAdmin -ScriptBlock { Get-FsxDeDupConfiguration }
```

The output lists the dedup configuration parameters and their current values\.

**Note**  
The values shown in the command response for following parameters are not reliable, and you should not use these values: Capacity, FreeSpace, UsedSpace, UnoptimizedSize, and SavingsRate\.

To view the amount of disk space you are saving from running data deduplication, use the following command\.

```
PS C:\Users\Admin> Invoke-Command -ComputerName amznfsxzzzzzzzz.corp.example.com -ConfigurationName FsxRemoteAdmin -ScriptBlock { 
Get-FSxDedupStatus } | select OptimizedFilesCount,OptimizedFilesSize,SavedSpace,OptimizedFilesSavingsRate

OptimizedFilesCount OptimizedFilesSize SavedSpace OptimizedFilesSavingsRate
------------------- ------------------ ---------- -------------------------
              12587           31163594   25944826                        83
```

## Managing Data Deduplication<a name="managing-data-dedup"></a>

You can manage data deduplication on your file system using the Amazon FSx CLI for remote management on PowerShell\. To learn how to use this CLI, see [Getting Started with the Amazon FSx CLI for Remote Management on PowerShellGetting Started](remote-pwrshell.md)\. 

Following are commands that you can use for data deduplication\. 


| Data Deduplication Command | Description | 
| --- | --- | 
|  Enable\-FSxDedup  |  Enables data deduplication on the file share\.  | 
|  Disable\-FSxDedup  |  Disables data deduplication on the file share\.  | 
|  Get\-FSxDedupConfiguration  |  Retrieves deduplication configuration information, including Minimum file size and age for optimization, Compression settings, and Excluded file types and folders\.  | 
| Set\-FSxDedupConfiguration | Changes the deduplication configuration settings, including minimum file size and age for optimization, compression settings, and excluded file types and folders\. | 
| Get\-FSxDedupStatus |  Retrieves the deduplication status, and includes read\-only properties that describe optimization savings and status on the file system, times, and completion status for the last jobs on the file system\.  | 
| Get\-FSxDedupMetadata | Retrieves deduplication optimization metadata\. | 
| Update\-FSxDedupStatus | Computes and retrieves updated data deduplication savings information\. | 
| Measure\-FSxDedupFileMetadata | Measures and retrieves the potential storage space that you can reclaim on your file system if you delete a group of folders\. Files often have chunks that are shared across other folders, and the deduplication engine calculates which chunks are unique and would be deleted\. | 
| Get\-FSxDedupSchedule | Retrieves deduplication schedules that are currently defined\. | 
| New\-FSxDedupSchedule | Creates and customizes a data deduplication schedule\. | 
| Set\-FSxDedupSchedule | Changes configuration settings for existing data deduplication schedules\. | 
| Remove\-FSxDedupSchedule | Deletes a deduplication schedule\. | 
| Get\-FSxDedupJob | Gets status and information for all currently running or queued deduplication jobs\. | 
| Stop\-FSxDedupJob | Cancel one or more specified data deduplication jobs\. | 

**Note**  
The values shown for following output fields do not represent the actual values, and you should not rely on them: Capacity, FreeSpace, UsedSpace, UnoptimizedSize, and SavingsRate\.

The online help for each command provides a reference of all command options\. To access this help, run the command with \-?, for example Enable\-FSxDedup \-?\. 