# Add instance store volumes to your EC2 instance<a name="add-instance-store-volumes"></a>

You specify the EBS volumes and instance store volumes for your instance using a block device mapping\. Each entry in a block device mapping includes a device name and the volume that it maps to\. The default block device mapping is specified by the AMI you use\. Alternatively, you can specify a block device mapping for the instance when you launch it\.

All the NVMe instance store volumes supported by an instance type are automatically enumerated and assigned a device name on instance launch; including them in the block device mapping for the AMI or the instance has no effect\. For more information, see [Block device mapping](block-device-mapping-concepts.md)\.

A block device mapping always specifies the root volume for the instance\. The root volume is mounted automatically\. For Windows instances, the root volume must be an Amazon EBS volume; instance store is not supported for the root volume\.

You can use a block device mapping to specify additional EBS volumes when you launch your instance, or you can attach additional EBS volumes after your instance is running\. For more information, see [Amazon EBS volumes](ebs-volumes.md)\.

You can specify the instance store volumes for your instance only when you launch it\. You can't attach instance store volumes to an instance after you've launched it\.

If you change the instance type, an instance store will not be attached to the new instance type\. For more information, see [Changing the instance type](ec2-instance-resize.md)\.

The number and size of available instance store volumes for your instance varies by instance type\. Some instance types do not support instance store volumes\. If the number of instance store volumes in a block device mapping exceeds the number of instance store volumes available to an instance, the additional volumes are ignored\. For more information about the instance store volumes support by each instance type, see [Instance store volumes](InstanceStorage.md#instance-store-volumes)\.

If the instance type you choose for your instance supports non\-NVMe instance store volumes, you must add them to the block device mapping for the instance when you launch it\. NVMe instance store volumes are available by default\. After you launch an instance, you must ensure that the instance store volumes for your instance are formatted and mounted before you can use them\. The root volume of an instance store\-backed instance is mounted automatically\.

**Topics**
+ [Adding instance store volumes to an AMI](#adding-instance-storage-ami)
+ [Adding instance store volumes to an instance](#adding-instance-storage-instance)
+ [Making instance store volumes available on your instance](#making-instance-stores-available-on-your-instances)

## Adding instance store volumes to an AMI<a name="adding-instance-storage-ami"></a>

You can create an AMI with a block device mapping that includes instance store volumes\. If you launch an instance with an instance type that supports instance store volumes and an AMI that specifies instance store volumes in its block device mapping, the instance includes these instance store volumes\. If the number of instance store volumes in the block device mapping exceeds the number of instance store volumes available to the instance, the additional instance store volumes are ignored\.

**Considerations**
+ For M3 instances, specify instance store volumes in the block device mapping of the instance, not the AMI\. Amazon EC2 might ignore instance store volumes that are specified only in the block device mapping of the AMI\.
+ When you launch an instance, you can omit non\-NVMe instance store volumes specified in the AMI block device mapping or add instance store volumes\.

**To add instance store volumes to an Amazon EBS\-backed AMI using the console**

1. Open the Amazon EC2 console at [https://console\.aws\.amazon\.com/ec2/](https://console.aws.amazon.com/ec2/)\.

1. In the navigation pane, choose **Instances** and select the instance\.

1. Choose **Actions**, **Image**, **Create Image**\.

1. In the **Create Image** dialog box, type a meaningful name and description for your image\.

1. For each instance store volume to add, choose **Add New Volume**, from **Volume Type** select an instance store volume, and from **Device** select a device name\. \(For more information, see [Device naming on Windows instances](device_naming.md)\.\) The number of available instance store volumes depends on the instance type\. For instances with NVMe instance store volumes, the device mapping of these volumes depends on the order in which the operating system enumerates the volumes\.

1. Choose **Create Image**\.

**To add instance store volumes to an AMI using the command line**

You can use one of the following commands\. For more information about these command line interfaces, see [Accessing Amazon EC2](concepts.md#access-ec2)\.
+ [create\-image](https://docs.aws.amazon.com/cli/latest/reference/ec2/create-image.html) or [register\-image](https://docs.aws.amazon.com/cli/latest/reference/ec2/register-image.html) \(AWS CLI\)
+ [New\-EC2Image](https://docs.aws.amazon.com/powershell/latest/reference/items/New-EC2Image.html) and [Register\-EC2Image](https://docs.aws.amazon.com/powershell/latest/reference/items/Register-EC2Image.html) \(AWS Tools for Windows PowerShell\)

## Adding instance store volumes to an instance<a name="adding-instance-storage-instance"></a>

When you launch an instance, the default block device mapping is provided by the specified AMI\. If you need additional instance store volumes, you must add them to the instance as you launch it\. You can also omit devices specified in the AMI block device mapping\.

**Considerations**
+ For M3 instances, you might receive instance store volumes even if you do not specify them in the block device mapping for the instance\.
+ For HS1 instances, no matter how many instance store volumes you specify in the block device mapping of an AMI, the block device mapping for an instance launched from the AMI automatically includes the maximum number of supported instance store volumes\. You must explicitly remove the instance store volumes that you don't want from the block device mapping for the instance before you launch it\.

**To update the block device mapping for an instance using the console**

1. Open the Amazon EC2 console\.

1. From the dashboard, choose **Launch instance**\.

1. In **Step 1: Choose an Amazon Machine Image \(AMI\)**, select the AMI to use and choose **Select**\.

1. Follow the wizard to complete **Step 1: Choose an Amazon Machine Image \(AMI\)**, **Step 2: Choose an Instance Type**, and **Step 3: Configure Instance Details**\.

1. In **Step 4: Add Storage**, modify the existing entries as needed\. For each instance store volume to add, choose **Add New Volume**, from **Volume Type** select an instance store volume, and from **Device** select a device name\. The number of available instance store volumes depends on the instance type\.

1. Complete the wizard and launch the instance\.

1. \(Optional\) To view the instance store volumes available on your instance, open Windows Disk Management\.

**To update the block device mapping for an instance using the command line**

You can use one of the following options commands with the corresponding command\. For more information about these command line interfaces, see [Accessing Amazon EC2](concepts.md#access-ec2)\.
+ `--block-device-mappings` with [run\-instances](https://docs.aws.amazon.com/cli/latest/reference/ec2/run-instances.html) \(AWS CLI\)
+ `-BlockDeviceMapping` with [New\-EC2Instance](https://docs.aws.amazon.com/powershell/latest/reference/items/New-EC2Instance.html) \(AWS Tools for Windows PowerShell\)

## Making instance store volumes available on your instance<a name="making-instance-stores-available-on-your-instances"></a>

After you launch an instance, the instance store volumes are available to the instance, but you can't access them until they are mounted\. For Linux instances, the instance type determines which instance store volumes are mounted for you and which are available for you to mount yourself\. For Windows instances, the EC2Config service mounts the instance store volumes for an instance\. The block device driver for the instance assigns the actual volume name when mounting the volume, and the name assigned can be different than the name that Amazon EC2 recommends\.

Many instance store volumes are pre\-formatted with the ext3 file system\. SSD\-based instance store volumes that support TRIM instruction are not pre\-formatted with any file system\. However, you can format volumes with the file system of your choice after you launch your instance\. For more information, see [Instance store volume TRIM support](ssd-instance-store.md#InstanceStoreTrimSupport)\. For Windows instances, the EC2Config service reformats the instance store volumes with the NTFS file system\.

You can confirm that the instance store devices are available from within the instance itself using instance metadata\. For more information, see [Viewing the instance block device mapping for instance store volumes](block-device-mapping-concepts.md#bdm-instance-metadata)\.

For Windows instances, you can also view the instance store volumes using Windows Disk Management\. For more information, see [Listing the disks using Windows Disk Management](ec2-windows-volumes.md#windows-disks)\.

**To manually mount an instance store volume**

1. Choose **Start**, enter **Computer Management**, and then press **Enter**\.

1. In left\-hand panel, choose **Disk Management**\.

1. If you are prompted to initialize the volume, choose the volume to initialize, select the required partition type depending on your use case, and then choose **OK**\.

1. In the list of volumes, right\-click the volume to mount, and then choose **New Simple Volume**\.

1. On the wizard, choose **Next**\.

1. On the Specify Volume Size screen, choose **Next** to use the maximum volume size\. Alternatively, choose a volume size that is between the minimum and maximum disk space\.

1. On the Assign a Drive Letter or Path screen, do one of the following, and choose **Next**\.
   + To mount the volume with a drive letter, choose **Assign the following drive letter** and then choose the drive letter to use\.
   + To mount the volume as a folder, choose **Mount in the following empty NTFS folder** and then choose **Browse** to create or select the folder to use\.
   + To mount the volume without a drive letter or path, choose **Do not assign a drive letter or drive path**\.

1. On the Format Partition screen, specify whether or not to format the volume\. If you choose to format the volume, choose the required file system and unit size, and specify a volume label\.

1. Choose **Next**, **Finish**\.