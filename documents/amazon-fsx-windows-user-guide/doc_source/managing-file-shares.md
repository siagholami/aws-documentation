# File Shares<a name="managing-file-shares"></a>

You can manage file shares and perform the following tasks\.
+ Create a new file share
+ Modify a file share
+ Remove a file share

You can use the Windows\-native Shared Folders GUI and the Amazon FSx CLI for remote management on PowerShell to manage file shares on your Amazon FSx for Windows File Server file system\.

## Using the GUI to Manage File Shares<a name="shared-folders-tool"></a>

To manage file shares on your Amazon FSx file system, you can use the Shared Folders GUI\. The Shared Folders GUI provides a central location for managing all shared folders on a Windows server\. The following procedures detail how to manage your file shares\.

**To connect Shared Folders to your FSx file system**

1. Launch your Amazon EC2 instance and connect it to the Microsoft Active Directory that your Amazon FSx file system is joined to\. To do this, choose one of the following procedures from the *AWS Directory Service Administration Guide*:
   + [Seamlessly Join a Windows EC2 Instance](https://docs.aws.amazon.com/directoryservice/latest/admin-guide/launching_instance.html)
   + [Manually Join a Windows Instance](https://docs.aws.amazon.com/directoryservice/latest/admin-guide/join_windows_instance.html)

1. Connect to your instance as a user that is a member of the file system administrators group\. In AWS Managed AD, this group is called AWS Delegated FSx Administrators\. In your self\-managed Microsoft AD, this group is called Domain Admins or the custom name for the administrators group that you provided during creation\. For more information, see [Connecting to Your Windows Instance](https://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/connecting_to_windows_instance.html) in the *Amazon EC2 User Guide for Windows Instances*\.

1. Open the **Start** menu and run **fsmgmt\.msc** using **Run As Administrator**\. Doing this opens the Shared Folders GUI tool\.

1. For **Action**, choose **Connect to another computer**\.

1. For **Another computer**, enter the Domain Name System \(DNS\) name for your Amazon FSx file system, for example **amznfsxabcd0123\.corp\.example\.com**\. 

   To find your file system's DNS name on the Amazon FSx console, choose **File systems**, choose your file system, and then check the **Network & Security** section of the file system details page\. You can also get the DNS name in the response of the [DescribeFileSystems](https://docs.aws.amazon.com/fsx/latest/APIReference/API_DescribeFileSystems.html) API operation\.

1. Choose **OK**\. An entry for your Amazon FSx file system then appears in the list for the Shared Folders tool\.

Now that Shared Folders is connected to your Amazon FSx file system, you can manage the Windows file shares on the file system\. The default share is called `\share`\. You can do so with the following actions:
+ **Create a new file share** – In the Shared Folders tool, choose **Shares** in the left pane to see the active shares for your Amazon FSx file system\. Choose **New Share** and complete the Create a Shared Folder wizard\.

  You have to create the local folder prior to creating the new file share\. You can do so as follows: 
  + Using the Shared Folders tool: click on "Browse" when specifying local folder path and click on "Make new folder" to create the local folder\.
  + Using command line:

    ```
    New-Item -Type Directory -Path \\amznfsxabcd0123.corp.example.com\D$\MyNewShare
    ```
+ **Modify a file share** – In the Shared Folders tool, open the context \(right\-click\) menu for the file share that you want to modify in the right pane, and choose **Properties**\. Modify the properties and choose **OK**\.
+ **Remove a file share** – In the Shared Folders tool, open the context \(right\-click\) menu for the file share that you want to remove in the right pane, and then choose **Stop Sharing**\.

## Using PowerShell to Manage File Shares<a name="manage-file-shares-pwrshell"></a>

You can manage file shares using custom remote\-management commands for PowerShell\. These commands can help you more easily automate these tasks:
+ Migration of file shares on existing file servers to Amazon FSx
+ Synchronization of file shares across AWS Regions for disaster recovery
+ Programmatic management of file shares for ongoing workflows, such as team file\-share provisioning

To learn how to use the Amazon FSx CLI for remote management on PowerShell, see [Getting Started with the Amazon FSx CLI for Remote Management on PowerShellGetting Started](remote-pwrshell.md)\.

### Creating a Continuously Available Share<a name="create-ca-share"></a>

You can create continuously available \(CA\) shares using the Amazon FSx CLI for Remote Management on PowerShell\. CA shares created on an Amazon FSx for Windows File Server Multi\-AZ file system are highly durable and highly available\. An Amazon FSx Single\-AZ file system is built on a single node cluster\. As a result, CA shares created on a Single\-AZ file system are highly durable, but are not highly available\. Use the `New-FSxSmbShare` with the `-ContinuouslyAvailable` option set to `$True` to specify that the share is a continuously available share\. The following is an example command to create a CA share\. 

```
New-FSxSmbShare -Name "New CA Share" -Path "D:\share" -Description "CA share" -ContinuouslyAvailable $True 
```

Following are custom remote\-management PowerShell commands that you can use\.


| Share Management Command | Description | 
| --- | --- | 
| New\-FSxSmbShare | Creates a new file share\. | 
| Remove\-FSxSmbShare | Removes a file share\. | 
| Get\-FSxSmbShare | Retrieves existing file shares\. | 
| Set\-FSxSmbShare | Sets properties for a share\. | 
|  Get\-FSxSmbShareAccess  |  Retrieves the access control list \(ACL\) of a share\.   | 
|  Grant\-FSxSmbShareAccess  |  Adds an allow access control entry \(ACE\) for a trustee to the security descriptor of a share\.  | 
|  Revoke\-FSxSmbShareAccess  |  Removes all of the allow ACEs for a trustee from the security descriptor of a share\.  | 
|  Block\-FSxSmbShareAccess  |  Adds a deny ACE for a trustee to the security descriptor of a share\.  | 
|  Unblock\-FSxSmbShareAccess  |  Removes all of the deny ACEs for a trustee from the security descriptor of a share\.  | 

The online help for each command provides a reference of all command options\. To access this help, run the command with a `-?`, for example `New-FSxSmbShare -?`\. 

### Passing Credentials to New\-FSxSmbShare<a name="pass-credentials-to-new-fsxsmbshare"></a>

You can pass credentials to New\-FSxSmbShare so that you can run it in a loop to create hundreds or thousands of shares without having to re\-enter credentials each time\.

Prepare the credential object required to create the file shares on your Amazon FSx for Windows File Server file server using one of the following options\.
+ To generate the credential object interactively, use the following command\.

  ```
  $credential = Get-Credential
  ```
+ To generate the credential object using an AWS Secrets Manager resource, use the following command\.

  ```
  $credential = ConvertFrom-Json -InputObject (Get-SECSecretValue -SecretId $AdminSecret).SecretString
  $FSxAdminUserCredential = (New-Object PSCredential($credential.UserName,(ConvertTo-SecureString $credential.Password -AsPlainText -Force)))
  ```