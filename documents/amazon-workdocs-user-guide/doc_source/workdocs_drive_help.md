# Using Amazon WorkDocs Drive<a name="workdocs_drive_help"></a>

Amazon WorkDocs Drive provides a native desktop experience for accessing Amazon WorkDocs content\. With Amazon WorkDocs Drive, users get the power of the AWS Cloud on their desktops\. They can access all of their folders and files with minimal use of local storage\. Users don’t need to change the way they work, because they can see all of their Amazon WorkDocs folders and files on their computer\.

Amazon WorkDocs Drive is available for PC and macOS users, and for Amazon WorkSpaces on Windows\. Amazon WorkDocs Drive can upload and download file sizes of up to 5 TB each, and allows file path lengths of up to 260 characters\.

**Topics**
+ [Installing Amazon WorkDocs Drive](#drive_install)
+ [Using Amazon WorkDocs Drive](#drive_use)
+ [Searching Amazon WorkDocs Drive](#drive_search)
+ [File icons](#drive_icons)
+ [Enabling offline access](#drive_offline)
+ [Troubleshooting Amazon WorkDocs Drive](#drive_troubleshoot)

## Installing Amazon WorkDocs Drive<a name="drive_install"></a>

If you have administrator permissions on your device, you can install Amazon WorkDocs Drive\.

Amazon WorkDocs Drive is available for 64\-bit versions of Windows 7, Windows 8, and Windows 10, and Windows Server 2008, Windows Server 2012 R2, and Windows Server 2016\. Amazon WorkDocs Drive for Windows also requires Microsoft \.NET Framework 4\.6\.2 or later\. Amazon WorkDocs Drive is available for macOS version 10\.11 or later\.

Amazon WorkDocs Drive requires HTTPS access on port 443 for all IP addresses for AWS\. 

**To install Amazon WorkDocs Drive**

1. Download Amazon WorkDocs Drive from [Apps & Integrations for Amazon WorkDocs](https://amazonworkdocs.com/apps.html) and follow the installation prompts\.

1. Open the Amazon WorkDocs Drive application\. When prompted, enter the name of your Amazon WorkDocs site, username, and password\.

**Note**  
macOS High Sierra 10\.13 users might encounter this error message during installation: `System Extension Blocked`\. To unblock the installation, open **System Preferences** on your computer and choose **Security & Privacy**\. Then, choose **Allow** to install Amazon WorkDocs Drive\.

### Installing Amazon WorkDocs Drive for Windows to multiple PCs and WorkSpaces<a name="install-multiple"></a>

Administrators who are responsible for managing the domain\-joined machine fleet for their organization can install the Amazon WorkDocs Drive client by using Group Policy Objects \(GPO\) or System Center Configuration Manager \(SCCM\) Tools\.

**Note**  
When deploying with GPO or SCCM tools, we recommend installing the Amazon WorkDocs Drive client after users have logged in\.

The MSI installer for Amazon WorkDocs Drive supports the following optional install parameters:
+ **`SITEID`** – Pre\-populates the Amazon WorkDocs site information for users during registration\. For example, `SITEID` :*site\-name*\.
+ **`DefaultDriveLetter`** – Pre\-populates the drive letter to be used for mounting Amazon WorkDocs Drive\. For example, `DefaultDriveLetter`:*W*\.

Individual users can select a different default drive letter when they launch the Amazon WorkDocs application\.

### Mounting Amazon WorkDocs Drive for PC with Windows Subsystem for Linux<a name="mount-linux"></a>

You can mount Amazon WorkDocs Drive for PC using the following `Bash` commands in Windows Subsystem for Linux\. For more information, see [File System Improvements to the Windows Subsystem for Linux](https://blogs.msdn.microsoft.com/wsl/2017/04/18/file-system-improvements-to-the-windows-subsystem-for-linux/)\.

```
              $ sudo mkdir /mnt/w
              $ sudo mount -t drvfs W: /mnt/w
              $ cd /mnt/w
              $ ls
```

## Using Amazon WorkDocs Drive<a name="drive_use"></a>

Windows users can open Amazon WorkDocs Drive from the **Desktop** shortcut or the W: drive in File Explorer\. macOS users can open Amazon WorkDocs Drive from the menu bar, from their **Applications**, or from the Finder under **Favorites**\.

Create, rename, move, and delete files and folders directly from Amazon WorkDocs Drive on your computer\. Moving files out of Amazon WorkDocs Drive deletes them\. Deleted files are moved to your **Recycle bin** on Amazon WorkDocs\.

**Note**  
If two files or folders have the same name, only one of them appears in Amazon WorkDocs Drive\.

**To work with files and folders**

1. 

   Do one of the following:  
**Windows**  
Open Amazon WorkDocs Drive from File Explorer, or choose or right\-click the Amazon WorkDocs Drive icon in the notification area and choose **Open Drive**\.  
**macOS**  
Open Amazon WorkDocs Drive from your **Applications**, or from the Finder, under **Favorites**, or choose or right\-click the Amazon WorkDocs Drive icon on the menu bar and choose **Open Drive**\.

1. Choose or right\-click an Amazon WorkDocs file or folder, choose **Amazon WorkDocs Drive**, and choose one of the following actions:
   + To generate a link to share the content with other users, choose **Copy web link**\.
   + To view or edit the content in a web browser, choose **Open in browser**\.
   + To mark a file or folder as a favorite, choose **Add to Favorites**\.

   The following actions apply to files only:
   + To allow specific users in an organization to access the content, choose **Share by invite**\.
   + To prevent other users from changing the file while you're working on it, choose **Lock and Edit**\. When you're done, choose **Unlock**\.

1. Your changes are automatically uploaded to Amazon WorkDocs and made available on all of your devices\.

To quit running Amazon WorkDocs Drive on your device, do the following\.

**To quit Amazon WorkDocs Drive**
+ Choose or right\-click the Amazon WorkDocs Drive icon in the notification area or menu bar, and choose **Quit**\.

To uninstall Amazon WorkDocs Drive from your device, do the following\.

**To uninstall Amazon WorkDocs Drive**

1. Choose or right\-click the Amazon WorkDocs Drive icon in the notification area or menu bar, and choose **Quit**\.

1. 

   Do one of the following:  
**Windows**  
From the **Control Panel**, choose **Programs and Features**, **Amazon WorkDocs Drive**, **Uninstall**, **OK**\.  
**macOS**  
From the **Applications** folder, choose or right\-click the Amazon WorkDocs Drive icon, then choose **Move to Trash**\.

## Searching Amazon WorkDocs Drive<a name="drive_search"></a>

Search for file names in Amazon WorkDocs Drive\. 

**To search for content in Amazon WorkDocs Drive**

1. Choose or right\-click the Amazon WorkDocs Drive icon in the notification area or menu bar\.

1. Enter search terms to search for files in Amazon WorkDocs\. File names are case sensitive\. Either search for files in all folders, or narrow your search to the `My Documents` or `Shared With Me` folders\.

1. Open the files directly from the search results list\.

**Note**  
File Explorer search for Windows and Spotlight search for macOS are not supported in Amazon WorkDocs Drive\.

## File icons<a name="drive_icons"></a>

Amazon WorkDocs Drive provides the following visual icons to communicate file status:
+ **Gray arrow icon**—A file is syncing to the cloud\.
+ **Blue cloud icon**—A file is stored in the cloud\.
+ **Green checkmark icon**—A file is stored locally on your device\.
+ **Blue star icon**—A file or folder is marked as a Favorite\.
+ **Red lock icon**—A file is locked by the user for exclusive editing\.

## Enabling offline access<a name="drive_offline"></a>

Enable offline access to your files and folders so that you can work on your content when your computer is offline\. Changes made in Amazon WorkDocs Drive while offline sync to Amazon WorkDocs the next time your computer is online\.

**Note**  
Enabling offline access uses network bandwidth to download your content\. It also uses disk space for storing the downloaded content\. It can take some time for your content to download, depending on the number of files and the network bandwidth\.

**To enable offline access to your content**

1. Choose or right\-click the Amazon WorkDocs Drive icon in the notification area or menu bar\.

1. Choose the gear icon\.

1. Choose **Work offline**\.

1. For **Sync settings**, select **Choose files for offline access**\.

1. Choose **Next**\.

1. Select the files you'd like to save locally for offline access\.
**Note**  
The size of the selected files appears in the **Sync settings** panel, along with the available amount of local disk space\.

1. Choose **Save**\.

1. Wait for Amazon WorkDocs Drive to finish downloading the selected content from Amazon WorkDocs to your computer\. This can take some time\.

You can stop syncing your files for offline access by choosing to access your files on demand\. This specifies that you use Amazon WorkDocs Drive to access your content only when your computer is online\.

**To access your content on demand**

1. Open the Amazon WorkDocs Drive application on your computer\.

1. Choose the gear icon\.

1. Choose **Work offline**\.

1. For **Sync settings**, select **Access files on demand**\.

1. Choose **OK**\.

You can also pause the syncing of Amazon WorkDocs content to your computer, and resume syncing later\. If you have limited network bandwidth for syncing, you might consider using this option\.

**To pause file and folder syncing**

1. Open the Amazon WorkDocs Drive application on your computer\.

1. Choose the gear icon\.

1. Select **Pause file sync**\.

1. To resume syncing your files and folders, clear **Pause file sync**\.

While syncing is paused, you can continue working on downloaded files that are available on your computer\. When syncing resumes, your changes to those files are uploaded as new versions\.

## Troubleshooting Amazon WorkDocs Drive<a name="drive_troubleshoot"></a>

This section describes troubleshooting tips for the most commonly encountered Amazon WorkDocs Drive errors\.

**Recovered Files**  
If you don't have permissions to edit a file, you can't upload it to the Amazon WorkDocs site\. Your changes are saved in your local `Recovered Files` folder\. You can open this folder from the Amazon WorkDocs Drive menu by choosing the question mark icon, then **Go to recovery folder**\. From there, you can upload the file to Amazon WorkDocs as a new file\.

**Recovery Folder Full**  
Delete unnecessary files from your local `Recovered Files` folder\.

**Drive Repair Required**  
Restart Amazon WorkDocs Drive by choosing the gear icon, then **Log out \(change site\)**\. Sign in again and check the `Recovered Files` folder for any files you might need to save\.

**Local Disk Full**  
Delete unnecessary files from your local disk and `Recovered Files` folder\.

**Storage Limit Exceeded**  
Delete unused files to free up storage space\. If you need more space after deleting unused files, contact your Amazon WorkDocs administrator\.

**Critical Dependency Unavailable**  
Restart the **Message Queuing** service on your computer by opening the **Services** app\. For **Message Queuing**, choose **Restart** or **Start**\.  
If the error persists, open **Computer Management**, **Services and Applications**\. If **Message Queuing** does not appear in the navigation pane, [uninstall **Message Queuing**](https://docs.particular.net/transports/msmq/uninstalling-msmq) and Amazon WorkDocs Drive\. When you reinstall Amazon WorkDocs Drive, it reinstalls **Message Queuing** for you\. For more help, contact your administrator\.

You can also report an issue from the Amazon WorkDocs Drive menu\.

**Report an Issue**  
From the Amazon WorkDocs Drive menu, choose the question mark icon, then **Report an issue** to send us a description of the problem\. Take note of the tracking number provided, which serves as a reference for support cases or correspondence with us\.

**Known Limitations**  
Symlinks are not supported\.