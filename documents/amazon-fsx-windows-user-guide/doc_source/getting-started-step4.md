# Step 4: Back Up Your File System<a name="getting-started-step4"></a>

Now that you've had a chance to use your Amazon FSx file system and its file shares, you can back it up\. By default, daily backups are created automatically during your file system's 30\-minute backup window\. However you can create a user\-initiated backup at any time\. Backups have additional costs associated with them\. For more information on backup pricing, see [Pricing](https://aws.amazon.com/fsx/windows/pricing)\.

**To create a backup of your file system from the console**

1. Open the Amazon FSx console at [https://console\.aws\.amazon\.com/fsx/](https://console.aws.amazon.com/fsx/)\.

1. From the console dashboard, choose the name of the file system you created for this exercise\.

1. From the **Overview** tab for your file system, choose **Create backup**\.

1. In the **Create backup** dialog box that opens, provide a name for your backup\. This name can contain a maximum of 256 Unicode letters and include white space, numbers, and the following special characters: \+ \- = \. \_ : / 

1. Choose **Create backup**\.

1. To view all your backups in a list, so you can restore your file system or delete the backup, choose **Backups**\.

When you create a new backup, its status is set to **CREATING** while it is being created\. This can take a few minutes\. When the backup is available for use, its status changes to **AVAILABLE**\.