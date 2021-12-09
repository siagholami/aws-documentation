# Walkthrough 4: Using Amazon FSx with Amazon AppStream 2\.0<a name="walkthrough04-fsx-with-appstream2"></a>

By supporting the Server Message Block \(SMB\) protocol, Amazon FSx for Windows File Server supports accessing your file system from Amazon EC2, VMware Cloud on AWS, Amazon WorkSpaces, and Amazon AppStream 2\.0 instances\. AppStream 2\.0 is a fully managed application streaming service\. You centrally manage your desktop applications on AppStream 2\.0 and securely deliver them to a browser on any computer\. For more information on AppStream 2\.0, see the [https://docs.aws.amazon.com/appstream2/latest/developerguide/](https://docs.aws.amazon.com/appstream2/latest/developerguide/)\.

Use this walkthrough as a guide through how to use Amazon FSx with AppStream 2\.0 for two use cases: providing personal persistent storage to each user and providing a shared folder across users to access common files\.

## Providing Personal Persistent Storage to Each User<a name="fsx-personal-persistent"></a>

You can use Amazon FSx to provide every user in your organization a unique storage drive within AppStream 2\.0 streaming sessions\. A user will have permissions to access only their folder\. The drive is automatically mounted at the start of a streaming session and files added or updated to the drive are automatically persisted between streaming sessions\.

There are three procedures you'll need to perform to complete this task\.

**To create home folders for domain users using Amazon FSx**

1. Create an Amazon FSx file system\. For more information, see [Getting Started with Amazon FSx](getting-started.md)\.

1. After the file system is available, create a folder for every domain AppStream 2\.0 user within your Amazon FSx file system\. The example following uses the domain user name of the user as the name of the corresponding folder\. Doing this means that you can build the UNC name of the file share to map easily using the Windows environment variable `%username%`\.

1. Share each of these folders out as a shared folder\. For more information, see [File Shares](managing-file-shares.md)\.

**To launch a domain\-joined AppStream 2\.0 image builder**

1. Sign into the AppStream 2\.0 console: [https://console\.aws\.amazon\.com/appstream2](https://console.aws.amazon.com/appstream2)

1. Choose **Directory Configs** from the navigation menu, and create a Directory Config object\. For more information, see [Using Active Directory with AppStream 2\.0](https://docs.aws.amazon.com/appstream2/latest/developerguide/active-directory.html) in the *Amazon AppStream 2\.0 Administration Guide*\.

1. Choose **Images**, **Image Builder**, and launch a new image builder\.

1. Choose the directory config object created earlier in the image builder launch wizard to join the image builder to your Active Directory domain\.

1. Launch the image builder in the same VPC as that of your Amazon FSx file system\. Make sure to associate the image builder with the same AWS Managed Microsoft AD directory to which your Amazon FSx file system is joined\. The VPC security groups that you associate with the image builder must allow access to your Amazon FSx file system\.

1. Once the image builder is available, connect to the image builder and login using your domain administrator account\.

1. Install your applications\.

**To link Amazon FSx file shares with AppStream 2\.0**

1. In the image builder, create a batch script with the following command and store it in a known file location \(for example: C:\\Scripts\\map\-fs\.bat\)\. The following example uses S: as the drive letter to map the shared folder on your Amazon FSx file system\. You use the DNS name of your Amazon FSx file system in this script, which you can get from the file system details view in the Amazon FSx console\.

   ```
   @echo off
   net use S: /delete 
   net use S: \\file-system-DNS-name\users\%username%
   ```

1. Open a PowerShell prompt and run `gpedit.msc`\.

1. From **User Configuration** choose **Windows Settings** and then **Logon**\.

1. Navigate to the batch script that you created in the first step of this procedure, and choose it\.

1. From **Computer Configuration**, choose **Windows Administrative Templates**, **System**, and then **Group Policy**\.

1. Choose the policy **Configure Logon Script delay**\. Enable the policy and reduce the time delay to `0`\. This setting helps to ensure that the user logon script is executed immediately when the user starts a streaming session\.

1. Create your image and assign it to an AppStream 2\.0 fleet\. Ensure that you also join the AppStream 2\.0 fleet to the same Active Directory domain that you used for image builder\. Launch the fleet in the same VPC that is used by your Amazon FSx file system\. The VPC security groups that you associate with the fleet must provide access to your Amazon FSx file system\.

1. Launch a streaming session using SAML SSO\. To connect to an fleet that is joined to Active Directory, configure single sign\-on federation using a SAML provider\. For more information, see [Single Sign\-on Access to AppStream 2\.0 Using SAML 2\.0](https://docs.aws.amazon.com/appstream2/latest/developerguide/external-identity-providers.html) in the *Amazon AppStream 2\.0 Administration Guide*\.

1. Your Amazon FSx file share is mapped to the S: drive letter within the streaming session\.

## Providing a Shared Folder Across Users<a name="fsx-shared-folder"></a>

You can use Amazon FSx to provide a shared folder to users in your organization\. A shared folder can be used to maintain common files \(for example, demo files, code examples, instruction manuals, etc\.\) needed by all users\.

There are three procedures you'll need to perform to complete this task\.

**To create a shared folder using Amazon FSx**

1. Create an Amazon FSx file system\. For more information, see [Getting Started with Amazon FSx](getting-started.md)\.

1. Every Amazon FSx file system includes a shared folder by default that can be accessed using the address \\\\*file\-system\-DNS\-name*\\share\. You can use the default share or create a different shared folder\. For more information, see [File Shares](managing-file-shares.md)\.

**To launch an AppStream 2\.0 image builder**

1. From the AppStream 2\.0 console, launch a new image builder or connect to an existing image builder\. Launch the image builder in the same VPC that is used by your Amazon FSx file system\. The VPC security groups that you associate with the image builder must allow access to your Amazon FSx file system\.

1. Once the image builder is available, connect to the image builder as the Administrator user\.

1. Install or update your applications as Administrator\.

**To link the shared folder with AppStream 2\.0**

1. Create a batch script, as described in the previous procedure, to automatically mount the shared folder whenever a user launches a streaming session\. To complete the script, you need the file systems DNS name \(which you can obtain from the file system details view in the Amazon FSx Console\), and credentials for accessing the shared folder\.

   ```
   @echo off
   net use S: /delete
   net use S: \\file-system-DNS-name\share /user:username password
   ```

1. Create a Group Policy to execute this batch script at every user logon\. You can follow the same instructions as described in the previous section\.

1. Create your image and assign it to your fleet\.

1. Launch a streaming session\. You should now see the shared folder automatically mapped to the drive letter\. 