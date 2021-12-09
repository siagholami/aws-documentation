# Manage Your WorkSpace from Your Client<a name="manage_workspace_client"></a>

If you use the [Windows client ](amazon-workspaces-windows-client.md), the [macOS client ](amazon-workspaces-osx-client.md), or the [Linux client](amazon-workspaces-linux-client.md) for Amazon WorkSpaces, you can perform the following management tasks directly from your client\. 

**Note**  
You can perform these tasks only if they are enabled by your Amazon WorkSpaces administrator\.

**Topics**
+ [Save Your Credentials](#client-save-credentials)
+ [Change Your Password](#client-change-password)
+ [Restart Your WorkSpace](#client-restart-workspace)
+ [Increase Your WorkSpace Disk Size](#client-increase-disk-workspace)
+ [Change Your WorkSpace Compute Type](#client-change-compute-type)
+ [Switch Your WorkSpace Running Mode](#client-switch-running-mode)
+ [Rebuild Your WorkSpace](#client-rebuild-workspace)

## Save Your Credentials<a name="client-save-credentials"></a>

You can choose whether to save your credentials \(your user name and password\) securely so that you can reconnect to your WorkSpace without re\-entering your credentials while the client application remains running\. Your credentials are securely cached in RAM only\. You can disable this feature and enable it again at any time\.

### To save your credentials for 3\.0\+ clients<a name="client-save-credentials-new-clients"></a>

1. Open your Amazon WorkSpaces client\.

1. On the client login screen, select or clear the **Keep me logged in** check box to enable or disable this option as required\.

### To save your credentials for 1\.0\+ and 2\.0\+ clients<a name="client-save-credentials-legacy-clients"></a>

1. Open your Amazon WorkSpaces client\.

1. On the client login screen, choose the gear icon \(Windows\) or the **Option** menu \(macOS\), and choose **Advanced Settings**\.

1. Select or clear the **Remember Me** check box to enable or disable this option as required\.

## Change Your Password<a name="client-change-password"></a>

You can change your WorkSpaces login password at any time\.

**To change your password**

1. Open your Amazon WorkSpaces client\.

1. On the client login screen, choose **Forgot Password?** under the **Sign In** button\.
**Note**  
If **Forgot password? **isn't available on your login screen, contact your WorkSpaces administrator for assistance with resetting your password\.

1. Enter your user name, and then enter the characters you see in the image\.

1. Choose **Recover Password**\.

1. You will receive an email with a password\-reset link\. Follow the instructions in the email to change your password\.

## Restart Your WorkSpace<a name="client-restart-workspace"></a>

If you are experiencing issues with your WorkSpace, you can restart it\. Restarting a WorkSpace disconnects you from your WorkSpace, so that it can be shut down and restarted\. Your user data, operating system, and system settings are not affected\. This process takes several minutes to finish\.

**Important**  
To avoid losing changes, save any open documents and other application files before you restart your WorkSpace\. 

**To restart your WorkSpace**

1. Open your Amazon WorkSpaces client and connect to your WorkSpace\.

1. Choose **Amazon WorkSpaces**, **Restart WorkSpace**\. 

1. When prompted to restart your WorkSpace, choose **Restart**\.

1. After you are disconnected from your WorkSpace, the client application login screen remains open\. You can log back in to your WorkSpace, or close the screen\.

## Increase Your WorkSpace Disk Size<a name="client-increase-disk-workspace"></a>

You can increase your WorkSpace disk size to add more storage capacity\. You can increase the size of your C: drive \(for Linux, this is /\) up to 175 GB, and you can increase the size of your D: drive \(for Linux, this is /home\) up to 100 GB without contacting your administrator\. If you need your drives increased beyond these limits, your administrator must increase the sizes of your drives for you\. 

If your administrator recently created your WorkSpace, you must wait 6 hours before you can increase your WorkSpace disk sizes\. After that, you can increase your disk sizes once in a 6\-hour period\. 

You cannot increase the size of the C: and D: drives at the same time\. \(The same is true of the / and /home volumes in Linux\.\) To increase the C: drive \(or / in Linux\), you must first increase the D: drive \(or /home in Linux\) to 100 GB\. After the D: drive \(or /home in Linux\) has been increased, you can increase the C: drive \(or / in Linux\)\.

While your WorkSpace disk size increase is in progress, you can perform most tasks on your WorkSpace\. However, you can't change your WorkSpace compute type, switch the WorkSpace running mode, rebuild your WorkSpace, or restart your WorkSpace\. The disk size increase process might take up to an hour\.

**Important**  
You can resize only SSD volumes\. 
Increasing your WorkSpace disk size will increase the amount that your organization pays for your WorkSpace\. 

**To increase your WorkSpace disk size**

1. Open your Amazon WorkSpaces client and connect to your WorkSpace\.

1. Depending on which client you're using, do one of the following\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/manage_workspace_client.html)

1. The **Increase disk size** dialog box displays the current disk size of your C: drive and D: drive \(or / and /home in Linux\)\. If you proceed with the disk size increase, it also displays the amount by which your storage increases\. 

1. To proceed with the disk size increase, choose **Increase**\. 

1. A message displays information about the disk size increase process\. Review the information, and choose **Close**\.

1. When the disk size increase is finished, you must [ restart the WorkSpace](#client-restart-workspace) for the changes to take effect\. Save any open files before restarting the WorkSpace\.

## Change Your WorkSpace Compute Type<a name="client-change-compute-type"></a>

You can change your WorkSpace compute type to choose a different bundle for your WorkSpace\. If your administrator recently created your WorkSpace, you must wait 6 hours before you can change your WorkSpace compute type\. After that, you can switch to a larger compute type once in a 6\-hour period, or to a smaller compute type once in a 30\-day period\.

When your WorkSpace compute type change is in progress, you are disconnected from the WorkSpace\. During this time, you can't use or make changes to the WorkSpace\. This process might take up to an hour\.

**Important**  
To avoid losing changes, save any open documents and other application files before you change your WorkSpace compute type\. 
Changing your WorkSpace compute type will change the amount that your organization pays for your WorkSpace\. 

**To change your WorkSpace compute type**

1. Open your Amazon WorkSpaces client and connect to your WorkSpace\.

1. Depending on which client you're using, do one of the following\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/manage_workspace_client.html)

1. The **Change compute type** dialog box displays the current compute type for your WorkSpace\. Choose a different compute type from the list, and then choose **Update**\.

1. A message displays information about the compute type change process\. Review the information, and choose **Update**\.

## Switch Your WorkSpace Running Mode<a name="client-switch-running-mode"></a>

You can specify whether your WorkSpace is always running or whether it stops after a specified period of inactivity\. Amazon WorkSpaces provides the following two running modes that you can choose from\.
+ **AlwaysOn** — Keeps your WorkSpace always running\. 
+ **AutoStop** — Your WorkSpace starts when you sign in and stops after a specified period of inactivity\. After your WorkSpace stops, the state of your apps and data is saved\. 

**Note**  
Switching your WorkSpace running mode will change the amount that your organization pays for your WorkSpace\. 

### To switch your WorkSpace running mode for 3\.0\+ clients<a name="client-switch-running-mode-new-clients"></a>

1. Open your Amazon WorkSpaces client and connect to your WorkSpace\.

1. Choose **Settings**, **Switch Running Mode**\. 

1. In the **Switch Running Mode** dialog box, choose a different running mode, and then choose **Switch**\.

1. A message confirms your choice\. Close the message box\.

### To switch your WorkSpace running mode for 1\.0\+ and 2\.0\+ clients<a name="client-switch-running-mode-credentials-legacy-clients"></a>

1. Open your Amazon WorkSpaces client and connect to your WorkSpace\.

1. Choose **My WorkSpace**, **Switch running mode**\. 

1. In the **Switch running mode** dialog box, choose a different running mode, and then choose **Switch**\.

1. A message confirms your choice\. Choose **Close**\.

## Rebuild Your WorkSpace<a name="client-rebuild-workspace"></a>

To restore the operating system that is running on your WorkSpace to its original state, you can rebuild the WorkSpace\.

If you want to rebuild your WorkSpace to resolve an issue that you are experiencing with the WorkSpace, try restarting it first\. If you rebuild your WorkSpace, any applications that you installed and system settings that you configured after the WorkSpace was created are lost\. When a WorkSpace is rebuilt, the D: drive is re\-created from the latest backup\. Because backups are completed every 12 hours, your data may be up to 12 hours old\. If your administrator recently created your WorkSpace, you must wait 12 hours before you can rebuild your WorkSpace\. 

While your WorkSpace rebuild is in progress, you are disconnected from the WorkSpace\. During this time, you can't use or make changes to the WorkSpace\. To avoid losing changes, save any open documents and other application files before you rebuild your WorkSpace, and then contact your WorkSpaces administrator to make sure your D: drive has been backed up\. The rebuild process might take up to an hour\.

**To rebuild your WorkSpace**

1. Open your Amazon WorkSpaces client and connect to your WorkSpace\.

1. Depending on which client you're using, do one of the following\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/manage_workspace_client.html)

1. In the **Rebuild WorkSpace** dialog box, review the information\. If you choose to proceed with the rebuild, choose **Rebuild**\.