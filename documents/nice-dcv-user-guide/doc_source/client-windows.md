# Windows Client<a name="client-windows"></a>

The NICE DCV Windows client is supported on Windows computers only\. The Windows client is a standalone application that runs natively on the Windows operating system\.

The Windows client is available in two versions: installable and portable\. Both versions have the same minimum system requirements and offer the same features\.

**Contents**
+ [Installable Windows Client](#client-windows-install)
+ [Portable Windows Client](#client-windows-portable)

## Installable Windows Client<a name="client-windows-install"></a>

You can use an installation wizard to install the client\. The wizard walks you through a series of steps that let you customize your client installation\. Or you can use the command line to perform an unattended installation, which uses default settings to automate the installation procedure\.

**To install the Windows client using the installation wizard**

1. Download the [Windows client installer](https://d1uj6qtbmh3dt5.cloudfront.net/2020.1/Clients/nice-dcv-client-Release-2020.1-7342.msi)\.

1. Run the installer\.

1. On the **Welcome** screen, choose **Next**\.

1. On the **End\-User License Agreement** screen, read the license agreement and, if you accept the terms, select the **I accept the terms in the License Agreement** check box\. Choose **Next**\.

1. On the **Destination Folder** screen, choose **Next** to keep the default installation folder\. To install the client in a different folder, change the destination path, and then choose **Next**\.

1. \(Optional\) On the **Drivers Selection** screen, select **USB device remotization** and choose **Will be installed on local hard drive**, **Next**\. This installs the drivers required to support some specialized USB devices, such as 3D pointing devices and graphic tablets\.
**Note**  
Using specialized USB devices requires additional client and server configuration\. For more information, see [Using USB Remotization](using-usb.md)\.

1. On the **Ready to install** screen, choose **Install**\.

**To install the Windows client using an unattended installation**

1. Download the [Windows client installer](https://d1uj6qtbmh3dt5.cloudfront.net/2020.1/Clients/nice-dcv-client-Release-2020.1-7342.msi)\.

1. Open a command prompt window and navigate to the folder where you downloaded the installer\.

1. Run the unattended installer\.

   ```
   C:\> msiexec.exe /i nice-dcv-client-Release-2020.1-7342.msi /quiet /norestart /l*v dcv_client_install_msi.log
   ```

## Portable Windows Client<a name="client-windows-portable"></a>

The Windows client is also available in a portable version\. The portable Windows client does not require installation\. This enables you to copy the client to a USB drive and execute it directly from the USB drive using any Windows computer that meets the minimum requirements\.

**To use the portable Windows client**

1. Download the portable [Windows client zip file](https://d1uj6qtbmh3dt5.cloudfront.net/2020.1/Clients/nice-dcv-client-Release-portable-2020.1-7342.zip)\.

1. Extract the contents of the zip file\.

1. To launch the client, open the extracted folder, navigate to `/bin/`, and double\-click `dcvviewer.exe`\.