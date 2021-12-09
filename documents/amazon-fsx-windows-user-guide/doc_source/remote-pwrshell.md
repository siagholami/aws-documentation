# Getting Started with the Amazon FSx CLI for Remote Management on PowerShell<a name="remote-pwrshell"></a>

The Amazon FSx CLI for remote management on PowerShell enables file system administration for users in the file system administrators group\. To start a remote PowerShell session on your Amazon FSx for Windows File Server file system, first meet the following prerequisites: 
+ Be able to connect to a Windows compute instance that has network connectivity with your file system\. 
+ Be logged into the Windows compute instance as a member of the file system administrators group\. In AWS Managed Microsoft AD, that group is AWS Delegated FSx Administrators\. In your self\-managed Microsoft AD, that group is Domain Admins or the custom group that you specified for administration when you created your file system\. For more information, see [Connecting to Your Windows Instance](https://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/connecting_to_windows_instance.html) in the *Amazon EC2 User Guide for Windows Instances*\. 
+ Make sure that your file system's security group inbound rules allows traffic on port 5985\. 

## Security and the CLI for Remote Management on PowerShell<a name="rps-security"></a>

The Amazon FSx CLI for Remote Management on PowerShell uses the following security features:
+ User logins are authenticated using Kerberos authentication\.
+ Management session communications are encrypted using Kerberos\.

## Using the CLI for Remote Management on PowerShell<a name="using-rps"></a>

You have two options to run remote management commands on your Amazon FSx file system\. You can establish a long\-running Remote PowerShell session and run the commands inside the session\. Or, you can use the `Invoke-Command` to execute a single command or a single block of commands without establishing a long\-running Remote PowerShell session\. If you want to set and pass variables as parameters to the remote management command, you need to use `Invoke-Command`\.

To run these commands, you must know the *Windows Remote PowerShell Endpoint* for your file system\. To find this endpoint, follow these steps:

1. Open the Amazon FSx console at [https://console\.aws\.amazon\.com/fsx/](https://console.aws.amazon.com/fsx/)\.

1. Choose your file system\. On the **Network & security** tab, locate the **Windows Remote PowerShell Endpoint**, as shown following\.

![\[FSx console Network & security tab, Windows Remote PowerShell Endpoint.\]](http://docs.aws.amazon.com/fsx/latest/WindowsGuide/images/FSx-network-sec-tab.png)

**To start a remote PowerShell session on your file system**

1. Connect to a compute instance that has network connectivity with your file system as a user that is a member of the file system administrators group\. 

1.  Open a Windows PowerShell window on the compute instance\. 

1. Use the following command to open the remote session on your Amazon FSx file system\. Replace `FSxFileSystem-Remote-PowerShell-Endpoint` with the Windows Remote PowerShell endpoint of file system that you want to administer\.

   ```
   PS C:\Users\delegateadmin> enter-pssession -ComputerName FSxFileSystem-Remote-PowerShell-Endpoint -ConfigurationName FsxRemoteAdmin
   [fs-0123456789abcdef0]: PS>
   ```

   You are prompted to enter user credentials in a pop\-up\.

 You can also run Amazon FSx CLI for remote management CLI on PowerShell commands on your file system using the `Invoke-Command` cmdlet, described following\.

 The following example illustrates the syntax required when using the `Invoke-Command` cmdlet to run PowerShell commands on an Amazon FSx for Windows File Server file system\. 

```
PS C:\Users\delegateadmin> Invoke-Command -ComputerName amznfsxzzzzzzzz.corp.example.com -ConfigurationName FSxRemoteAdmin -scriptblock { fsx-command}
```