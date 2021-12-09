# Requirements for AWS Server Migration Service<a name="prereqs"></a>

Your VMware vSphere, Microsoft Hyper\-V/SCVMM, or Microsoft Azure environment must meet the following requirements for you to use the Server Migration Service to migrate your on\-premises virtualized servers to Amazon EC2\.

**Topics**
+ [General requirements](#general-requirements)
+ [Operating systems](#os_prereqs)
+ [Volume types and file systems](#volume-types-file-systems)
+ [Configure an IAM user for Server Migration Connector](#connector-permissions)
+ [Permissions for IAM users](#permissions-roles)
+ [Limitations](#limitations)
+ [Licensing options for AWS SMS](#licensing)
+ [Other requirements](#other_prereqs)

## General requirements<a name="general-requirements"></a>

Before setting up AWS SMS, take action as needed to meet all of the following requirements\.

**All VMs**
+ Disable any antivirus or intrusion detection software on the VM you are migrating\. These services can be re\-enabled after the migration process is complete\.
+ Disconnect any CD\-ROM drives \(virtual or physical\) connected to the VM\.

**Windows VMs**
+ Enable Remote Desktop \(RDP\) for remote access\.
+ Install the appropriate version of \.NET Framework on the VM\. Note that \.NET Framework 4\.5 or later will be installed automatically on your VM if required\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/server-migration-service/latest/userguide/prereqs.html)
+ When preparing a Microsoft Windows VM for migration, configure a fixed pagefile size and ensure that at least 6 GiB of free space is available on the root volume\. This is necessary for successful installation of the drivers\.
+ Make sure that your host firewall \(such as Windows firewall\) allows access to RDP\. Otherwise, you will not be able to access your instance after the migration is complete\.
+ Apply the following hotfixes:
  + [You cannot change system time if `RealTimeIsUniversal` registry entry is enabled in Windows](https://support.microsoft.com/en-us/help/2922223/you-cannot-change-system-time-if-realtimeisuniversal-registry-entry-is-enabled-in-windows)
  + [High CPU usage during DST changeover in Windows Server 2008, Windows 7, or Windows Server 2008 R2](https://support.microsoft.com/en-us/help/2800213/high-cpu-usage-during-dst-changeover-in-windows-server-2008,-windows-7,-or-windows-server-2008-r2.)

**Linux VMs**
+ Enable Secure Shell \(SSH\) for remote access\.
+ Make sure that your host firewall \(such as iptables\) allows access to SSH\. Otherwise, you will not be able to access your instance after the migration is complete\.
+ Make sure that your Linux VM uses GRUB \(GRUB legacy\) or GRUB 2 as its bootloader\.
+ Make sure that the root volume of your Linux VM uses one of the following file systems:
  + EXT2
  + EXT3
  + EXT4
  + Btrfs
  + JFS
  + XFS

**Programmatic modifications to VMs**  
When importing a VM, AWS modifies the file system to make the imported VM accessible to the customer\. The following actions may occur:
+ \[Linux\] Installing Citrix PV drivers either directly in OS or modify initrd/initramfs to contain them\.
+ \[Linux\] Modifying network scripts to replace static IP addresses with dynamic IP addresses\.
+ \[Linux\] Modifying `/etc/fstab`, commenting out invalid entries and replacing device names with UUIDs\. If no matching UUID can be found for a device, the `nofail` option is added to the device description\. You will need to correct the device naming and remove `nofail` after import\. As a best practice when preparing your VMs for import, we recommend that you specify your VM disk devices by UUID rather than device name\.

  Entries in `/etc/fstab` that contain distributed file system types \(nfs, cifs, smbfs, vboxsf, sshfs, etc\.\) will be disabled\.
+ \[Linux\] Modifying grub bootloader settings such as the default entry and timeout\.
+ \[Windows\] Modifying registry settings to make the VM bootable\.

When writing a modified file, AWS retains the original file at the same location under a new name\.

## Operating systems<a name="os_prereqs"></a>

The following operating systems can be migrated to EC2 using SMS:

**Windows \(32\- and 64\-bit\)**
+ Microsoft Windows Server 2003 \(Standard, Datacenter, Enterprise\) with Service Pack 1 \(SP1\) or later \(32\- and 64\-bit\)
+ Microsoft Windows Server 2003 R2 \(Standard, Datacenter, Enterprise\) \(32\- and 64\-bit\)
+ Microsoft Windows Server 2008 \(Standard, Datacenter, Enterprise\) \(32\- and 64\-bit\)
+ Microsoft Windows Server 2008 R2 \(Standard, Web Server, Datacenter, Enterprise\) \(64\-bit only\)
+ Microsoft Windows Server 2012 \(Standard, Datacenter\) \(64\-bit only\)
+ Microsoft Windows Server 2012 R2 \(Standard, Datacenter\) \(64\-bit only\) \(Nano Server installation not supported\)
+ Microsoft Windows Server 2016 \(Standard, Datacenter\) \(64\-bit only\)
+ Microsoft Windows Server 1709 \(Standard, Datacenter\) \(64\-bit only\)
+ Microsoft Windows Server 1803 \(Standard, Datacenter\) \(64\-bit only\)
+ Microsoft Windows Server 2019 \(Standard, Datacenter\) \(64\-bit only\)
+ Microsoft Windows 7 \(Home, Professional, Enterprise, Ultimate\) \(US English\) \(32\- and 64\-bit\)
+ Microsoft Windows 8 \(Home, Professional, Enterprise\) \(US English\) \(32\- and 64\-bit\)
+ Microsoft Windows 8\.1 \(Professional, Enterprise\) \(US English\) \(64\-bit only\)
+ Microsoft Windows 10 \(Home, Professional, Enterprise, Education\) \(US English\) \(64\-bit only\)

**Linux/Unix \(64\-bit\)**
+ Ubuntu 12\.04, 12\.10, 13\.04, 13\.10, 14\.04, 14\.10, 15\.04, 16\.04, 16\.10, 17\.04, 18\.04
+ Red Hat Enterprise Linux \(RHEL\) 5\.1\-5\.11, 6\.1\-6\.9, 7\.0\-7\.6 \(6\.0 lacks required drivers\)
+ SUSE Linux Enterprise Server 11 with Service Pack 1 and kernel 2\.6\.32\.12\-0\.7
+ SUSE Linux Enterprise Server 11 with Service Pack 2 and kernel 3\.0\.13\-0\.27
+ SUSE Linux Enterprise Server 11 with Service Pack 3 and kernel 3\.0\.76\-0\.11, 3\.0\.101\-0\.8, or 3\.0\.101\-0\.15
+ SUSE Linux Enterprise Server 11 with Service Pack 4 and kernel 3\.0\.101\-63
+ SUSE Linux Enterprise Server 12 with kernel 3\.12\.28\-4
+ SUSE Linux Enterprise Server 12 with Service Pack 1 and kernel 3\.12\.49\-11
+ SUSE Linux Enterprise Server 12 with Service Pack 2 and kernel 4\.4
+ SUSE Linux Enterprise Server 12 with Service Pack 3 and kernel 4\.4
+ CentOS 5\.1\-5\.11, 6\.1\-6\.6, 7\.0\-7\.6 \(6\.0 lacks required drivers\)
+ Debian 6\.0\.0\-6\.0\.8, 7\.0\.0\-7\.8\.0, 8\.0\.0
+ Oracle Linux 5\.10\-5\.11 with el5uek kernel suffix
+ Oracle Linux 6\.1\-6\.10 using RHEL\-compatible kernel 2\.6\.32 or UEK kernels 3\.8\.13, 4\.1\.12
+ Oracle Linux 7\.0\-7\.6 using RHEL compatible kernel 3\.10\.0 or UEK kernels 3\.8\.13, 4\.1\.12, 4\.14\.35
+ Fedora Server 19\-21

## Volume types and file systems<a name="volume-types-file-systems"></a>

AWS Server Migration Service supports migrating Windows and Linux instances with the following file systems:

[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/server-migration-service/latest/userguide/prereqs.html)

AMIs with volumes using EBS encryption are not supported\. When migrating servers using AWS SMS, do not turn on encryption by default\. If encryption by default is already on and you are experiencing delta replication failures, turn off this feature\.

## Configure an IAM user for Server Migration Connector<a name="connector-permissions"></a>

**To create an IAM user for Server Migration Connector in your AWS account**

1. Create a new IAM user for your connector to communicate with AWS\. Save the generated access key and secret key for use during the initial connector setup\. For information about managing IAM users and permissions, see [Creating an IAM User in Your AWS Account](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_users_create.html)\.

1. Attach the managed IAM policy **ServerMigrationConnector** to the IAM user\. For more information, see [Managed Policies and Inline Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_managed-vs-inline.html)\.

## Permissions for IAM users<a name="permissions-roles"></a>

By default, IAM users do not have permissions required to use AWS SMS\. IAM users with administrator permissions already have full access to AWS SMS\. Otherwise, you can add the AWS managed policy **ServerMigrationServiceConsoleFullAccess** to ensure that IAM users have the permissions required to use AWS SMS\.

## Limitations<a name="limitations"></a>

The following limitations apply\.

**Topics**
+ [Image format](#image-format)
+ [File system](#file-system)
+ [Booting](#boot)
+ [Networking](#networking)
+ [Application import from Migration Hub](#migration-hub-requirements)
+ [Miscellaneous](#miscellaneous)

### Image format<a name="image-format"></a>
+ When migrating VMs managed by Hyper\-V/SCVMM, SMS supports both Generation 1 VMs \(using either VHD or VHDX disk format\) and Generation 2 VMs \(VHDX only\)\.
+ AWS SMS does not support VMs on Hyper\-V running any version of RHEL 5 if backed by a VHDX disk\. We recommend converting disks in this format to VHD for migration\.
+ AWS SMS does not support VMs that have a mix of VHD and VHDX disk files\.
+ On VMware, AWS SMS does not support VMs that use Raw Device Mapping \(RDM\)\. Only VMDK disk images are supported\.

### File system<a name="file-system"></a>
+ Migrated Linux VMs must use 64\-bit images\. Migrating 32\-bit Linux images is not supported\.
+ Migrated Linux VMs should use default kernels for best results\. VMs that use custom Linux kernels might not migrate successfully\.
+ When preparing Amazon EC2 Linux VMs for migration, make sure that at least 250 MiB of disk space is available on the root volume for installing drivers and other software\. For Microsoft Windows VMs, configure a fixed pagefile size and ensure that at least 6 GiB of free space is available on the root volume\.

### Booting<a name="boot"></a>
+ UEFI/EFI boot partitions are supported only for Windows boot volumes with VHDX as the image format\. Otherwise, a VM's boot volume must use Master Boot Record \(MBR\) partitions\. In either case, boot volume cannot exceed 2 TiB \(uncompressed\) due to MBR limitations\.
**Note**  
When AWS detects a Windows GPT boot volume with an UEFI boot partition, it converts it on\-the\-fly to an MBR boot volume with a BIOS boot partition\. This is because EC2 does not directly support GPT boot volumes\.
+ An imported VM might fail to boot if the root partition is not on the same virtual hard drive as the MBR\.
+ A migrated VM might fail to boot if the root partition is not on the same virtual hard disk as the MBR\.
+ Migrating VMs with dual\-boot configurations is not supported\.

### Networking<a name="networking"></a>
+ Multiple network interfaces are not currently supported\. After migration, your VM will have a single virtual network interface that uses DHCP to assign addresses\. Your instance receives a private IP address\.
+ A VM migrated into a VPC does not receive a public IP address, regardless of the auto\-assign public IP setting for the subnet\. Instead, you can allocate an Elastic IP address to your account and associate it with your instance\.
+ Internet Protocol version 6 \(IPv6\) IP addresses are not supported\.

### Application import from Migration Hub<a name="migration-hub-requirements"></a>
+ SMS imports application\-related servers from AWS Migration Hub only if they exist in the SMS Server Catalog\. As a result, some applications may only be partially migrated\.
+  If none of the servers in a Migration Hub application exist in the SMS Server Catalog, the import will fail silently and the application will not be visible in SMS\.
+ Imported applications can be migrated but cannot be edited in SMS\. They can, however, be edited in Migration Hub\. 

### Miscellaneous<a name="miscellaneous"></a>
+ An SMS replication job will fail for VMs with more than 22 volumes attached\.
+ AMIs with volumes using EBS encryption are not supported\. When migrating servers using AWS SMS, do not turn on encryption by default\. If encryption by default is already on and you are experiencing delta replication failures, turn off this feature\.
+ AWS SMS creates AMIs that use Hardware Virtual Machine \(HVM\) virtualization\. It can't create AMIs that use Paravirtual \(PV\) virtualization\. Linux PVHVM drivers are supported within migrated VMs\.
+ VMs that are created as the result of a P2V conversion are not supported\. A P2V conversion occurs when a disk image is created by performing a Linux or Windows installation process on a physical machine and then importing a copy of that Linux or Windows installation to a VM\.
+ AWS SMS does not install the single root I/O virtualization \(SR\-IOV\) drivers except with imports of Microsoft Windows Server 2012 R2 VMs\. These drivers are not required unless you plan to use enhanced networking, which provides higher performance \(packets per second\), lower latency, and lower jitter\. For Microsoft Windows Server 2012 R2 VMs, SR\-IOV drivers are automatically installed as a part of the migration process\.
+ Because independent disks are unaffected by snapshots, AWS SMS does not support interval replication for VMDKs in independent mode\.
+ Windows language packs that use UTF\-16 \(or non\-ASCII\) characters are not supported for import\. We recommend using the English language pack when importing Windows Server 2003, Windows Server 2008, and Windows Server 2012 R1 VMs\.
+ For Windows Server 2003, disable Windows driver\-signing checks before migrating\.

## Licensing options for AWS SMS<a name="licensing"></a>

When you create a new replication job, the AWS Server Migration Service console provides a **License type** option\. If you choose a license type that is incompatible with your VM, the replication job fails with an error message\. The possible values are:
+ **Auto** \(default\)

  Detects the source\-system operating system \(OS\) and applies the appropriate license to the migrated virtual machine \(VM\)\.
+ **AWS**

  Replaces the source\-system license with an AWS license, if appropriate, on the migrated VM\.
+ **BYOL**

  Retains the source\-system license, if appropriate, on the migrated VM\.

The same licensing options are available through AWS SMS API and CLI\. For example:

```
aws sms create-replication-job --license-type value
```

The value of the `--license-type` parameter can be AWS or BYOL\. Leaving it unset is the same as choosing **Auto** in the console\.

### Licensing for Linux<a name="linux"></a>

Linux operating systems support only BYOL licenses\. Choosing **Auto** \(the default\) means that SMS uses a BYOL license\.

Migrated Red Hat Enterprise Linux \(RHEL\) VMs must use Cloud Access \(BYOL\) licenses\. For more information, see [Red Hat Cloud Access](https://www.redhat.com/en/technologies/cloud-computing/cloud-access) on the Red Hat website\.

Migrated SUSE Linux Enterprise Server VMs must use SUSE Public Cloud Program \(BYOS\) licenses\. For more information, see [SUSE Public Cloud Program—Bring Your Own Subscription](https://www.suse.com/docrep/documents/h4jlnjpfx3/suse_public_cloud_program_bring_your_own_subscription_faq_external.pdf)\.

### Licensing for Windows<a name="windows"></a>

Windows server operating systems support either BYOL or AWS licenses\. Windows client operating systems \(such as Windows 10\) support only BYOL licenses\.

If you choose **Auto** \(the default\), AWS SMS uses the AWS license if the VM has a server OS\. If the VM has a client OS, the BYOL license is used\.

The following rules apply when you use your BYOL Microsoft license, either through MSDN or [Windows Software Assurance Per User](http://download.microsoft.com/download/5/c/7/5c727885-ec15-4920-818b-4d140ec6c38a/Windows_SA_per_User_at_a_Glance.pdf):
+ Your BYOL instances are priced at the prevailing Amazon EC2 Linux instance pricing, provided that you meet the following conditions:
  + Run on a Dedicated Host \([Dedicated Hosts](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/dedicated-hosts-overview.html)\)
  + Launch from VMs sourced from software binaries provided by you using AWS SMS, which are subject to the current terms and abilities of AWS SMS
  + Designate the instances as BYOL instances
  + Run the instances within your designated AWS Regions, and where AWS offers the BYOL model
  + Activate using Microsoft keys that you provide or are used in your key management system
+ You must account for the fact that when you start an Amazon EC2 instance, it can run on any one of many servers within an Availability Zone\. This means that each time you start an Amazon EC2 instance \(including a stop/start\), it might run on a different server within an Availability Zone\. You must account for this fact in light of the limitations on license reassignment as described in Microsoft Volume Licensing Product Terms, available at [Licensing Terms](https://www.microsoft.com/en-us/licensing/product-licensing/products.aspx), or consult your specific use rights to determine if your rights are consistent with this usage\.
+ You must be eligible to use the BYOL program for the applicable Microsoft software under your agreements with Microsoft, for example, under your MSDN user rights or under your Windows Software Assurance Per User Rights\. You are solely responsible for obtaining all required licenses and for complying with all applicable Microsoft licensing requirements, including the PUR/PT\. Further, you must have accepted Microsoft's End User License Agreement \(Microsoft EULA\), and by using the Microsoft Software under the BYOL program, you agree to the Microsoft EULA\.
+ AWS recommends that you consult with your own legal and other advisers to understand and comply with the applicable Microsoft licensing requirements\. Usage of the Services \(including usage of the **licenseType** parameter and **BYOL** flag\) in violation of your agreements with Microsoft is not authorized or permitted\.

## Other requirements<a name="other_prereqs"></a>

**Support for VMware vMotion**

AWS Server Migration Service partially supports vMotion, Storage vMotion, and other features based on virtual machine migration \(such as DRS and Storage DRS\) subject to the following limitations:
+ Migrating a virtual machine to a new ESXi host or datastore after one replication run ends, and before the next replication run begins, is supported as long as the Server Migration Connector's vCenter service account has sufficient permissions on the destination ESXi host, datastores, and datacenter, and on the virtual machine itself at the new location\.
+ Migrating a virtual machine to a new ESXi host, datastore, and/or datacenter while a replication run is active—that is, while a virtual machine upload is in progress—is not supported\. 
+ Cross vCenter vMotion is not supported for use with the AWS Server Migration Service\.

**Support for VMware vSAN**  
VMs on vSAN datastores are only supported when **Replication job type** on the **Configure replication jobs settings** page is set to **One\-time migration**\.

**Support for VMware Virtual Volumes \(VVol\)**  
AWS does not provide support for migrating VMware Virtual Volumes\. Some implementations may work, however\.

**VMware VMs with snapshots**  
AWS SMS supports only one\-time migration on VMs where snapshot\-based backup software is used\. Also, avoid creating snapshots on VMs replicated through AWS SMS\. 

**Hyper\-V checkpoints**  
AWS SMS does not support VMs with existing checkpoints\.

**Hyper\-V differencing disk**  
AWS SMS does not support VMs with differencing disks\.