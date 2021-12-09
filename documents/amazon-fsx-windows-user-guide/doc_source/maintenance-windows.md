# Working with Amazon FSx Maintenance Windows<a name="maintenance-windows"></a>

Amazon FSx for Windows File Server performs routine software patching for the Microsoft Windows Server software it manages\. The maintenance window is your opportunity to control what day and time of the week this software patching occurs\.

Patching occurs infrequently, typically once every several weeks\. Patching should require only a fraction of your 30\-minute maintenance window\. During these few minutes of time, your Single\-AZ file system is temporarily unavailable, and Multi\-AZ file systems automatically fail over and fail back\.

You choose the maintenance window during file system creation\. If you have no time preference, then a 30\-minute default window is assigned\.

**Note**  
To ensure data integrity during maintenance activity, Amazon FSx for Windows File Server completes any pending write operations to the underlying storage volumes hosting your file system before maintenance begins\.

You can use the Amazon FSx Management Console, AWS CLI or one of the AWS SDKs to change the maintenance window for your file systems\. 

**To change the maintenance window using the console**

1. Open the Amazon FSx console at [https://console\.aws\.amazon\.com/fsx/](https://console.aws.amazon.com/fsx/)\.

1. Choose **File systems** in the left hand navigation column\.

1. Choose the file system that you want to changes the maintenance window for\. The file system details page displays\.

1. Choose the **Maintenance** tab\. The maintenance window **Settings** panel displays\.

1. Choose **Edit** and enter the new day and time that you want the maintenance window to start\.

1. Choose **Save** to save your changes\. The new maintenance start time is displayed in the **Settings** panel\.

To change the maintenance window using the CLI or API using the [UpdateFileSystem](https://docs.aws.amazon.com/fsx/latest/APIReference/API_UpdateFileSystem.html) operation, see [Walkthrough 3: Update an Existing File System](walkthrough03-update-file-system.md)\.