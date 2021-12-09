# Using Microsoft Windows File Shares<a name="using-file-shares"></a>

A Microsoft Windows *file share* is a specific folder in your file system, including that folder's subfolders, which you make accessible to your compute instances with the Server Message Block \(SMB\) protocol\. Your file system comes with a default Windows file share, named `share`\. You can create and manage as many other Windows file shares as you want by using the Windows graphical user interface \(GUI\) tool called Shared Folders\.

## Accessing File Shares<a name="accessing-file-shares"></a>

To access your file shares, you use the Windows Map Network Drive functionality to map a drive letter on your compute instance to your Amazon FSx file share\. The process of mapping a file share to a drive on your compute instance is known as mounting a file share in Linux\. This process differs depending on the type of compute instance and the operating system\. After your file share is mapped, your applications and users can access files and folders on your file share as if they are local files and folders\.

Following, you can find procedures for mapping a file share on the different supported compute instances\.

**Topics**
+ [Mapping a File Share on an Amazon EC2 Windows Instance](#map-share-windows)
+ [Mounting a File Share on an Amazon EC2 Linux Instance](#map-shares-linux)
+ [Automatically Mount File Shares on an Amazon Linux EC2 Instance Not Joined to Your Active Directory](#automount-fsxw-ec2-linux)

### Mapping a File Share on an Amazon EC2 Windows Instance<a name="map-share-windows"></a>

You can map a file share on an EC2 Windows instance by using the Windows File Explorer or the command prompt\.

#### To Map a File Share on an Amazon EC2 Windows Instance \(Console\)<a name="map-file-share-ec2-win-console"></a>

1. Launch the EC2 Windows instance and connect it to the Microsoft Active Directory that you joined your Amazon FSx file system to\. To do this, choose one of the following procedures from the *AWS Directory Service Administration Guide*:
   + [Seamlessly Join a Windows EC2 Instance](https://docs.aws.amazon.com/directoryservice/latest/admin-guide/launching_instance.html)
   + [Manually Join a Windows Instance](https://docs.aws.amazon.com/directoryservice/latest/admin-guide/join_windows_instance.html)

1. Connect to your EC2 Windows instance\. For more information, see [Connecting to Your Windows Instance](https://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/connecting_to_windows_instance.html) in the *Amazon EC2 User Guide for Windows Instances*\.

1. After you're connected, open File Explorer\.

1. In the navigation pane, open the context \(right\-click\) menu for **Network** and choose **Map Network Drive**\.

1. For **Drive**, choose a drive letter\.

1. For **Folder**, enter the file system DNS name and the share name\. You can find the DNS name in the Amazon FSx console, [https://console\.aws\.amazon\.com/fsx/](https://console.aws.amazon.com/fsx/), **Windows File Server > Network & Security** section, or in the response of CreateFileSystem or DescribeFileSystems API command\.
   + For a Single AZ file system joined to an AWS Managed Microsoft Active Directory, the DNS name looks like this:

     ```
     fs-0123456789abcdef0.ad-domain.com
     ```
   + For a Single AZ file system joined to a self\-managed AD, and any Multi AZ file system, the DNS name looks like this:

     ```
     amznfsxaa11bb22.ad-domain.com
     ```

   For example, enter:

   ```
   \\fs-0123456789abcdef0\.ad-domain.com\share
   ```

   for **Folder**\.

1. Choose an option for **Reconnect at sign\-in**, which indicates whether the file share should reconnect at sign\-in, and then choose **Finish**\.

#### To Map a File Share on an Amazon EC2 Windows Instance \(Command Prompt\)<a name="map-file-share-ec2-win-command"></a>

1. Launch the EC2 Windows instance and connect it to the Microsoft Active Directory that you joined your Amazon FSx file system to\. To do this, choose one of the following procedures from the *AWS Directory Service Administration Guide*:
   + [Seamlessly Join a Windows EC2 Instance](https://docs.aws.amazon.com/directoryservice/latest/admin-guide/launching_instance.html)
   + [Manually Join a Windows Instance](https://docs.aws.amazon.com/directoryservice/latest/admin-guide/join_windows_instance.html)

1. Connect to your EC2 Windows instance as a user in your AWS Managed Microsoft AD directory\. For more information, see [Connecting to Your Windows Instance](https://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/connecting_to_windows_instance.html) in the *Amazon EC2 User Guide for Windows Instances*\.

1. After you're connected, open a command prompt window\.

1. Mount the file share using a drive letter of your choice, the file system's DNS name, and the share name\. You can find the DNS name in the Amazon FSx console, [https://console\.aws\.amazon\.com/fsx/](https://console.aws.amazon.com/fsx/), **Windows File Server > Network & Security** section, or in the response of CreateFileSystem or DescribeFileSystems API command\.
   + For a Single AZ file system joined to an AWS Managed Microsoft Active Directory, the DNS name looks like this:

     ```
     fs-0123456789abcdef0.ad-domain.com
     ```
   + For a Single AZ file system joined to a self\-managed AD, and any Multi AZ file system, the DNS name looks like this:

     ```
     amznfsxaa11bb22.ad-domain.com
     ```

   Here's an example command to mount the file share\.

   ```
   $ net use H: \\amzfsxaa11bb22.ad-domain.com\share /persistent:yes
   ```

  

### Mounting a File Share on an Amazon EC2 Linux Instance<a name="map-shares-linux"></a>

You can mount an Amazon FSx for Windows File Server file share on an Amazon EC2 Linux instance that is either joined to your Active Directory or not joined\.

#### To Mount a File Share on an Amazon EC2 Linux Instance Joined to Your Active Directory<a name="map-file-share-ec2-linux-kerberos"></a>

1. If you don't already have a running EC2 Linux instance joined to your Microsoft Active Directory, see [Manually Join a Linux Instance](https://docs.aws.amazon.com/directoryservice/latest/admin-guide/join_linux_instance.html) in the *AWS Directory Service Administration Guide* for the instructions to do so\. 

1. Connect to your EC2 Linux instance\. For more information, see [Connect to Your Linux Instance](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/AccessingInstances.html) in the *Amazon EC2 User Guide for Linux Instances*\.

1. Run the following command to install the `cifs-utils` package\. This package is used to mount network file systems like Amazon FSx on Linux\.

   ```
   $ sudo yum install cifs-utils
   ```

1. Create the mount point directory **/mnt/fsx**\. This is where you will mount the Amazon FSx file system\.

   ```
   $ sudo mkdir -p /mnt/fsx
   ```

1. Authenticate with kerberos using the following command\.

   ```
   $ kinit
   ```

1. Mount the file share with the following command\.

   ```
   $ sudo mount -t cifs //file_system_dns_name/file_share mount_point --verbose -o vers=3.0,sec=krb5,cruid=ad_user,rsize=CIFSMaxBufSize,wsize=CIFSMaxBufSize,cache=none,ip=preferred-file-server-Ip
   ```

    You can find the DNS name in the Amazon FSx console, [https://console\.aws\.amazon\.com/fsx/](https://console.aws.amazon.com/fsx/), **Windows File Server > Network & Security** section, or in the response of CreateFileSystem or DescribeFileSystems API command\.
   + For a Single AZ file system joined to an AWS Managed Microsoft Active Directory, the DNS name looks like this:

     ```
     fs-0123456789abcdef0.ad-domain.com
     ```
   + For a Single AZ file system joined to a self\-managed AD, and any Multi AZ file system, the DNS name looks like this:

     ```
     amznfsxaa11bb22.ad-domain.com
     ```

   Replace `CIFSMaxBufSize` with the largest value allowed by your kernel\. Run the following command to get this value\.

   ```
   $ modinfo cifs | grep CIFSMaxBufSize
   parm:           CIFSMaxBufSize:Network buffer size (not including header). Default: 16384 Range: 8192 to 130048 (uint)
   ```

   The output shows the maximum buffer size is 130048\.

1. Verify that the file system is mounted by running the following command, which returns only file systems of the Common Internet File System \(CIFS\) type\.

   ```
   $ mount -l -t cifs
   //fs-0123456789abcdef0/share on /mnt/fsx type cifs (rw,relatime,vers=3.0,sec=krb5,cache=strict,username=user1@CORP.NETWORK.COM,uid=0,noforceuid,gid=0,noforcegid,addr=192.0.2.0,file_mode=0755,dir_mode=0755,soft,nounix,serverino,mapposix,rsize=1048576,wsize=1048576,echo_interval=60,actimeo=1)
   ```

The mount command used in this procedure does the following at the given points:
+ `//file_system_dns_name/file_share` – Specifies the DNS name and share of the file system to mount\.
+ *mount\_point* – the directory on the EC2 instance that you are mounting the file system to\.
+ `-t cifs vers=3.0` – Specifies the type of file system as CIFS and the protocol version as 3\.0\.
+ `sec=krb5` – Specifies to use Kerberos version 5 for authentication\.
+ `cruid=ad_user` – sets the uid of the owner of the credentials cache to the AD directory administrator\.
+ `/mnt/fsx` – Specifies the mount point for the FSx file share on your EC2 instance\.
+ `rsize=CIFSMaxBufSize,wsize=CIFSMaxBufSize` – Specifies the read and write buffer size as the maximum allowed by the CIFS protocol\. Replace `CIFSMaxBufSize` with the largest value allowed by your kernel\. Determine the `CIFSMaxBufSize` by running the following command\.

  ```
  $ modinfo cifs | grep CIFSMaxBufSize
  parm:           CIFSMaxBufSize:Network buffer size (not including header). Default: 16384 Range: 8192 to 130048 (uint)
  ```

  The output shows the maximum buffer size is 130048\.
+ `cache=none` – Sets the CIFS cache mode to none, that is to not cache file data at all\.
+ `ip=preferred-file-server-Ip` – sets the destination IP address to that of the file system's preferred file server\.

  You can retrieve the file system's preferred file server IP address as follows:
  + Using the Amazon FSx management console, in the **Network & security** tab of the **File system details** page
  + In the response of the `describe-file-systems` CLI command or the equivalent [DescribeFileSystems](https://docs.aws.amazon.com/fsx/latest/APIReference/API_DescribeFileSystems.html) API command\.

#### To Mount a File Share on an Amazon EC2 Linux Instance Not Joined to Your Active Directory<a name="map-file-share-ec2-linux-command"></a>

The following procedure mounts an Amazon FSx file share to an Amazon EC2 Linux instance that is not joined to your active directory \(AD\)\. For an EC2 Linux instance that is *not* joined to your Active Directory, you can only mount an Amazon FSx for Windows File Server file share by using it's private IP address\. You can get the file system's private IP address in the Amazon FSx console \([https://console\.aws\.amazon\.com/fsx/](https://console.aws.amazon.com/fsx/)\), in the **Network & security** tab, the **Preferred File Server IP Address**\.

 This example uses NTLM authentication\. To do this, you mount the file system as a user that is a member of the Microsoft Active Directory domain that the Amazon FSx for Windows File Server file system is joined to\. The credentials for the user account are provided in a text file that you create on your EC2 instance, `creds.txt`\. This file contains the user name, password, and domain for the user\.

```
$ cat creds.txt
username=user1
password=Password123
domain=EXAMPLE.COM
```

**To launch and configure the Amazon Linux EC2 instance**

1. Launch an Amazon Linux EC2 instance using the Amazon EC2 console [https://console\.aws\.amazon\.com/ec2/](https://console.aws.amazon.com/ec2/)\. For more information, see [Launch an Instance](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EC2_GetStarted.html#ec2-launch-instance) in the *Amazon EC2 User Guide for Linux Instances*\.

1. Connect to your Amazon Linux EC2 instance\. For more information, see [Connect to Your Linux Instance](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/AccessingInstances.html) in the *Amazon EC2 User Guide for Linux Instances*\.

1. Run the following command to install the `cifs-utils` package\. This package is used to mount network file systems like Amazon FSx on Linux\.

   ```
   $ sudo yum install cifs-utils
   ```

1. Create the mount point **/mnt/fsxx** where you plan to mount the Amazon FSx file system\.

   ```
   $ sudo mkdir -p /mnt/fsx
   ```

1. Create the `creds.txt` credentials file in the `/home/ec2-user` directory, using the format shared above\.

1. Set the `creds.txt` file permissions so that only you \(the owner\) can read and write to the file by running the following command\.

   ```
   $ chmod 700 creds.txt
   ```<a name="mnt-ip-addr"></a>

**To mount the file system**

1. You mount a file share not joined to your Active Directory by using its private IP address\. You can get the file system's private IP address using the Amazon FSx console \([https://console\.aws\.amazon\.com/fsx/](https://console.aws.amazon.com/fsx/)\), in the **Network & security** tab, the **Preferred File Server IP Address**\. 

1. Mount the file system using the following command:

   ```
   $ sudo mount -t cifs //file-system-IP-address/file_share /mnt/fsx --verbose -o vers=3.0,sec=ntlmsspi,cred=/home/ec2-user/creds.txt,rsize=CIFSMaxBufSize,wsize=CIFSMaxBufSize,cache=none
   ```

   Replace `CIFSMaxBufSize` with the largest value allowed by your kernel\. Run the following command to get this value\.

   ```
   $ modinfo cifs | grep CIFSMaxBufSize
   parm:           CIFSMaxBufSize:Network buffer size (not including header). Default: 16384 Range: 8192 to 130048 (uint)
   ```

   The output shows the maximum buffer size is 130048\.

1. Verify that the file system is mounted by running the following command, which returns only CIFS file systems\.

   ```
   $ mount -l -t cifs
   //file-system-IP-address/file_share on /mnt/fsx type cifs (rw,relatime,vers=3.0,sec=ntlmsspi,cache=strict,username=user1,domain=CORP.EXAMPLE.COM,uid=0,noforceuid,gid=0,noforcegid,addr=192.0.2.0,file_mode=0755,dir_mode=0755,soft,nounix,serverino,mapposix,rsize=1048576,wsize=1048576,echo_interval=60,actimeo=1)
   ```

The mount command used in this procedure does the following at the given points:
+ `//file-system-IP-address/file_share` – Specifies the IP address and share of the file system to mount\.
+ `-t cifs vers=3.0` – Specifies the type of file system as CIFS and the protocol version as 3\.0\.
+ `sec=ntlmsspi` – Specifies to use NT LAN Manager Security Support Provider Interface \(NTLMSSPI\) for authentication\.
+ `cred=/home/ec2-user/creds.txt` – Specifies where to get the user credentials\.
+ `/mnt/fsx` – Specifies the mount point for the FSx file share on your EC2 instance\.
+ `rsize=CIFSMaxBufSize,wsize=CIFSMaxBufSize` – Specifies the read and write buffer size as the maximum allowed by the CIFS protocol\. Replace `CIFSMaxBufSize` with the largest value allowed by your kernel\. Determine the `CIFSMaxBufSize` by running the following command\.

  ```
  $ modinfo cifs | grep CIFSMaxBufSize
  parm:           CIFSMaxBufSize:Network buffer size (not including header). Default: 16384 Range: 8192 to 130048 (uint)
  ```

  The output shows the maximum buffer size is 130048\.
+ `cache=none` – Sets the CIFS cache mode to none, that is not to cache file data at all\.

  

### Automatically Mount File Shares on an Amazon Linux EC2 Instance Not Joined to Your Active Directory<a name="automount-fsxw-ec2-linux"></a>

To automatically mount your Amazon FSx for Windows File Server file share whenever the Amazon EC2 Linux instance to which it's mounted reboots, you add an entry to the `/etc/fstab` file on the EC2 instance\. The `/etc/fstab` file contains information about file systems\. The command mount \-a, which runs during instance startup, mounts the file systems listed in the `/etc/fstab` file\. For an Amazon Linux EC2 instance that is not joined to your Active Directory, you can only mount an Amazon FSx for Windows File Server file share by using it's private IP address\. You can get the file system's private IP address in the Amazon FSx console \([https://console\.aws\.amazon\.com/fsx/](https://console.aws.amazon.com/fsx/)\), in the **Network & security** tab, the **Preferred File Server IP Address**\.

The following procedure use Microsoft NTLM authentication\. You mount the file system as a user that is a member of the Microsoft Active Directory domain to which the Amazon FSx for Windows File Server file system is joined\. The credentials for the user account are provided in the text file `creds.txt`\. This file contains the user name, password, and domain for the user\.

```
$ cat creds.txt
username=user1
password=Password123
domain=EXAMPLE.COM
```

#### To Automatically Mount a File Share on an Amazon Linux EC2 Instance not Joined to Your Active Directory<a name="automount-ec2-linux-ip"></a>

**To launch and configure the Amazon Linux EC2 instance**

1. Launch an Amazon Linux EC2 instance using the Amazon EC2 console [https://console\.aws\.amazon\.com/ec2/](https://console.aws.amazon.com/ec2/)\. For more information, see [Launch an Instance](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EC2_GetStarted.html#ec2-launch-instance) in the *Amazon EC2 User Guide for Linux Instances*\.

1. Connect to your instance\. For more information, see [Connect to Your Linux Instance](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/AccessingInstances.html) in the *Amazon EC2 User Guide for Linux Instances*\.

1. Run the following command to install the `cifs-utils` package\. This package is used to mount network file systems like Amazon FSx on Linux\.

   ```
   $ sudo yum install cifs-utils
   ```

1. Create the `/mnt/fsx` directory\. This is where you will mount the Amazon FSx file system\.

   ```
   $ sudo mkdir /mnt/fsx
   ```

1. Create the `creds.txt` credentials file in the `/home/ec2-user` directory\.

1. Set the file permissions so that only you \(the owner\) can read the file by running the following command\.

   ```
   $ sudo chmod 700 creds.txt
   ```

**To automatically mount the file system**

1. You automatically mount a file share not joined to your Active Directory by using its private IP address\. You can get the file system's private IP address from the Amazon FSx console \([https://console\.aws\.amazon\.com/fsx/](https://console.aws.amazon.com/fsx/)\), in the **Network & security** tab, the **Preferred File Server IP Address**\.

1. To automatically mount the file share using its private IP address, add the following line to the `/etc/fstab` file\.

   ```
   //file-system-IP-address/file_share /mnt/fsx cifs vers=3.0,sec=ntlmsspi,cred=/home/ec2-user/creds.txt,rsize=CIFSMaxBufSize,wsize=CIFSMaxBufSize,cache=none
   ```

   Replace `CIFSMaxBufSize` with the largest value allowed by your kernel\. Run the following command to get this value\.

   ```
   $ modinfo cifs | grep CIFSMaxBufSize
   parm:           CIFSMaxBufSize:Network buffer size (not including header). Default: 16384 Range: 8192 to 130048 (uint)
   ```

   The output shows the maximum buffer size is 130048\.

1. Test the fstab entry by using the `mount` command with the 'fake' option in conjunction with the 'all' and 'verbose' options\.

   ```
   $ sudo mount -fav
   home/ec2-user/fsx      : successfully mounted
   ```

1. To mount the file share, reboot the Amazon EC2 instance\.

1. When the instance is available again, verify that the file system is mounted by running the following command\.

   ```
   $ sudo mount -l -t cifs
   //file-system-IP-address/file_share on /mnt/fsx type cifs (rw,relatime,vers=3.0,sec=ntlmsspi,cache=strict,username=user1,domain=CORP.EXAMPLE.COM,uid=0,noforceuid,gid=0,noforcegid,addr=192.0.20.0,file_mode=0755,dir_mode=0755,soft,nounix,serverino,mapposix,rsize=1048576,wsize=1048576,echo_interval=60,actimeo=1)
   ```

   The line added to the `/etc/fstab` file in this procedure does the following at the given points:
   + `//file-system-IP-address/file_share` – Specifies the IP address and share of the Amazon FSx file system you're mounting\.
   + `/mnt/fsx` – Specifies the mount point for the FSx file system on your EC2 instance\.
   + `cifs vers=3.0` – Specifies the type of file system as CIFS and the protocol version as 3\.0\.
   + `sec=ntlmsspi` – Specifies using NT LAN Manager Security Support Provider Interface to facilitate NTLM challenge\-response authentication\.
   + `cred=/home/ec2-user/creds.txt` – Specifies where to get the user credentials\.
   + `_netdev` – Tells the operating system that the file system resides on a device that requires network access\. Using this option prevents the instance from mounting the file system until the network service is enabled on the client\.
   + `0` – Indicates that the file system should be backed up by `dump`, if it's a nonzero value\. For Amazon FSx, this value should be `0`\.
   + `0` – Specifies the order in which `fsck` checks file systems at boot\. For Amazon FSx file systems, this value should be `0` to indicate that `fsck` shouldn't run at startup\.