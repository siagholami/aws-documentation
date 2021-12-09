# Working with Backups<a name="using-backups"></a>

With Amazon FSx, backups are file\-system\-consistent, highly durable, and incremental\. To ensure file system consistency, Amazon FSx uses the Volume Shadow Copy Service \(VSS\) in Microsoft Windows\. To ensure high durability, Amazon FSx stores backups in Amazon Simple Storage Service \(Amazon S3\)\. 

Amazon FSx backups are incremental, whether they are generated using the automatic daily backup or the manual backup feature\. This means that only the data on the file system that has changed after your most recent backup is saved\. This minimizes the time required to create the backup and saves on storage costs by not duplicating data\. When you delete a backup, only the data unique to that backup is removed\. Each Amazon FSx for Windows File Server backup contains all of the information that is needed to create a new file system from the backup, effectively restoring a point\-in\-time snapshot of the file system\.

Creating regular backups for your file system is a best practice that complements the replication that Amazon FSx for Windows File Server performs for your file system\. Amazon FSx backups help support your backup retention and compliance needs\. Working with Amazon FSx backups is easy, whether it's creating backups, restoring a file system from a backup, or deleting a backup\.

**Topics**
+ [Working with Manual Backups](#manual-backups)
+ [Working with Automatic Daily Backups](#automatic-backups)
+ [Restoring Backups](#restoring-backups)
+ [Deleting Backups](#delete-backups)
+ [Setting Up a Custom Backup Schedule](custom-backup-schedule.md)

## Working with Manual Backups<a name="manual-backups"></a>

Amazon FSx enables you to manually take backups of your file systems at any time\. You can do so using the Amazon FSx Management Console, API, or the AWS Command Line Interface \(CLI\)\. Your manual backups of Amazon FSx file systems never expire, and are available for as long as you want to keep them\. Manual backups are retained even after you have deleted the file system that was backed up\. Manual backups can only be deleted by using the Amazon FSx console, API, or CLI, and they are never automatically deleted by Amazon FSx\. For more information, see [Deleting Backups](#delete-backups)\.

### Creating Manual Backups<a name="creating-backups"></a>

The following procedure guides you through how to create a user\-initiated backup in the Amazon FSx console for an existing file system\.

**To create a manual file system backup**

1. Open the Amazon FSx console at [https://console\.aws\.amazon\.com/fsx/](https://console.aws.amazon.com/fsx/)\.

1. From the console dashboard, choose the name of the file system that you want to back up\.

1. From **Actions**, choose **Create backup**\.

1. In the **Create backup** dialog box that opens, provide a name for your backup\. Backup names can be a maximum of 256 Unicode characters, including letters, white space, numbers, and the special characters \. \+ \- = \_ : /

1. Choose **Create backup**\.

You have now created your file system backup\. You can find a table of all your backups in the Amazon FSx console by choosing **Backups** in the right side navigation\. You can search for the name you gave your backup, and the table filters to only show matching results\.

When you create a user\-initiated backup as this procedure described, it has the type `USER_INITIATED`, and it has the `CREATING` status until it is fully available\.

## Working with Automatic Daily Backups<a name="automatic-backups"></a>

By default, Amazon FSx takes an automatic daily backup of your file system\. These automatic daily backups occur during the daily backup window that was established when you created the file system\. At some point during the daily backup window, storage I/O might be suspended briefly while the backup process initializes \(typically for less than a few seconds\)\. When you choose your daily backup window, we recommend that you choose a convenient time of the day\. This time ideally is outside of the normal operating hours for the applications that use the file system\.

Automatic daily backups are kept for a certain period of time, known as a retention period\. The default retention period for automatic daily backups is 7 days\. You can set the retention period to be between 0–35 days\. Setting the retention period to 0 \(zero\) days turns of automatic daily backups\. Automatic daily backups are deleted when the file system is deleted\.

**Note**  
Setting the retention period to 0 days means that your file system is never automatically backed up\. We highly recommend that you use automatic daily backups for file systems that have any level of critical functionality associated with them\.

You can use the AWS CLI or one of the AWS SDKs to change the backup window, and backup retention period for your file systems with the [https://docs.aws.amazon.com/fsx/latest/APIReference/API_UpdateFileSystem.html](https://docs.aws.amazon.com/fsx/latest/APIReference/API_UpdateFileSystem.html) API operation or the [https://docs.aws.amazon.com/cli/latest/reference/fsx/update-file-system.html](https://docs.aws.amazon.com/cli/latest/reference/fsx/update-file-system.html) CLI command\. For more information, see [Walkthrough 3: Update an Existing File System](walkthrough03-update-file-system.md)\.

## Restoring Backups<a name="restoring-backups"></a>

You can use an available backup to create a new file system, effectively restoring a point\-in\-time snapshot of another file system\. You can restore a backup using the console, AWS CLI, or one of the AWS SDKs\. Restoring a backup to a new file system takes the same amount of time as creating a new file system\. The data restored from the backup is lazy\-loaded onto the file system, during which time you will experience slightly higher latency\.

The following procedure guides you through how to restore a backup using the console to create a new file system\.

**Note**  
You can only restore your backup to a file system of the same storage capacity as the original\. You can increase your restored file system's storage capacity after it becomes available\. For more information, see [Managing Storage Capacity](managing-storage-capacity.md)\.

**To restore a file system from a backup**

1. Open the Amazon FSx console at [https://console\.aws\.amazon\.com/fsx/](https://console.aws.amazon.com/fsx/)\.

1. From the console dashboard, choose **Backups** from the left side navigation\.

1. Choose the backup that you want to restore from the **Backups** table, and then choose **Restore backup**\. 

   Doing so opens the file system creation wizard\. This wizard is identical to the standard file system creation wizard, except the **Storage capacity** is already set and can't be changed\. However, you can change the throughput capacity, associated VPC, and other settings, and storage type\. The storage type is set to **SSD** by default, but you can change it to **HDD** under the following conditions:
   + The file system deployment type is **Multi\-AZ** or **Single\-AZ 2**\.
   + The storage capacity is at least 2,000 GiB\.

1. Complete the wizard as you do when you create a new file system\.

1. Choose **Review and create**\.

1. Review the settings you chose for your Amazon FSx file system, and then choose **Create file system**\.

You have restored from a backup, and a new file system is now being created\. When its status changes to `AVAILABLE`, you can use the file system as normal\.

## Deleting Backups<a name="delete-backups"></a>

Deleting a backup is a permanent, unrecoverable action\. Any data in a deleted backup is also deleted\. Do not delete a backup unless you're sure you won't need that backup again in the future\.

**To delete a backup**

1. Open the Amazon FSx console at [https://console\.aws\.amazon\.com/fsx/](https://console.aws.amazon.com/fsx/)\.

1. From the console dashboard, choose **Backups** from the right side navigation\.

1. Choose the backup that you want to delete from the **Backups** table, and then choose **Delete backup**\.

1. In the **Delete backups** dialog box that opens, confirm that the ID of the backup identifies the backup that you want to delete\.

1. Confirm that the check box is checked for the backup that you want to delete\.

1. Choose **Delete backups**\.

Your backup and all included data are now permanently and unrecoverably deleted\.