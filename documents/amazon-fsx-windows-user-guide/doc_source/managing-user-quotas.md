# Storage Quotas<a name="managing-user-quotas"></a>

You can configure user storage quotas on your file systems to limit how much data storage that users can consume\. After you set quotas, you can track quota status to monitor usage and see when users surpass their quotas\. 

You can also enforce quotas by stopping users who reach their quotas from writing to the storage space\. When you enforce quotas, a user that exceeds their quota receives an "insufficient disk space" error message\.

You can set these thresholds for quota settings:
+ Warning \- used to track whether a user or group is approaching their quota limit, relevant for tracking only\.
+ Limit \- the storage quota limit for a user or group\. 

You can configure default quotas that are applied to new users who access a file system and quotas that apply to specific users or groups\. You can also view a report of how much storage each user or group is consuming and whether they're surpassing their quotas\. 

Storage consumption at a user level is tracked based on file ownership\. Storage consumption is calculated using logical file size, not the actual physical storage space that files occupy\. User storage quotas are tracked at the time when data is written to a file\. 

## Managing User Storage Quotas<a name="managing-storage-quotas"></a>

You can manage user storage quotas on your file system using the Amazon FSx CLI for remote management on PowerShell\. To learn how to use this CLI, see [Getting Started with the Amazon FSx CLI for Remote Management on PowerShellGetting Started](remote-pwrshell.md)\. 

Following are commands that you can use to manage user storage quotas\.


| User Storage Quotas Command | Description | 
| --- | --- | 
|  Enable\-FSxUserQuotas  |  Starts tracking or enforcing user storage quotas, or both\.  | 
|  Disable\-FSxUserQuotas  |  Stops tracking and enforcement for user storage quotas\.   | 
| Get\-FSxUserQuotaSettings | Retrieves the current user\-storage quota settings for the file system\. | 
| Get\-FSxUserQuotaEntries | Retrieves the current user\-storage quota entries for individual users and groups on the file system\. | 
| Set\-FSxUserQuotas | Set the user storage quota for an individual user or group\. Quota values are specified in bytes\. | 

The online help for each command provides a reference of all command options\. To access this help, run the command with \-?, for example Enable\-FSxUserQuotas \-?\. 