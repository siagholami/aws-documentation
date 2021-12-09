# Walkthrough 3: Update an Existing File System<a name="walkthrough03-update-file-system"></a>

There are three elements that you can update with the procedures in this walkthrough\. All other elements of your file system that you can update, you can do so from the console\. These procedures assume you have the AWS CLI installed and configured on your local computer\. For more information, see [Install](https://docs.aws.amazon.com/cli/latest/userguide/installing.html) and [Configure](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-getting-started.html) in the *AWS Command Line Interface User Guide*\.
+ **AutomaticBackupRetentionDays** – the number of days that you want to retain automatic backups for your file system\.
+ **DailyAutomaticBackupStartTime** – the time of the day in Coordinated Universal Time \(UTC\) that you want the daily automatic backup window to start\. The window is 30 minutes starting from this specified time\. This window can't overlap with the weekly maintenance backup window\.
+ **WeeklyMaintenanceStartTime** – the time of the week that you want the maintenance window to start\. Day 1 is Monday, 2 is Tuesday, and so on\. The window is 30 minutes starting from this specified time\. This window can't overlap with the daily automatic backup window\.

The following procedures outlines how to update your file system with the AWS CLI\.

**To update how long automatic backups are retained for your file system**

1. Open a command prompt or terminal on your computer\.

1. Run the following command, replacing the file system ID with the ID for your file system, and the number of days that you want to retain your automatic backups for\.

   ```
   aws fsx update-file-system --file-system-id fs-0123456789abcdef0 --windows-configuration AutomaticBackupRetentionDays=30
   ```

**To update the daily backup window of your file system**

1. Open a command prompt or terminal on your computer\.

1. Run the following command, replacing the file system ID with the ID for your file system, and the time with when you want to begin the window\.

   ```
   aws fsx update-file-system --file-system-id fs-0123456789abcdef0 --windows-configuration DailyAutomaticBackupStartTime=01:00
   ```

**To update the weekly maintenance window of your file system**

1. Open a command prompt or terminal on your computer\.

1. Run the following command, replacing the file system ID with the ID for your file system, and the date and time with when you want to begin the window\.

   ```
   aws fsx update-file-system --file-system-id fs-0123456789abcdef0 --windows-configuration WeeklyMaintenanceStartTime=1:01:30
   ```