# Preparing for the Factory Reset of Your AWS DeepLens Device<a name="deeplens-device-factory-reset-preparation"></a>

## <a name="Introduction"></a>

Resetting your AWS DeepLens completely wipes the data on the device and returns it to its factory settings\. To prepare, there are steps you need to take that require additional hardware\. This topic explains what you need to get started and walks you through the process\.

## Prerequisites<a name="prerequisites"></a>

Before you get started, make sure you have the following items ready:
+ 1 USB flash drive, 16GB or larger
+ A DeepLens \(v1\.0\) or DeepLens 2019 Edition \(v1\.1\) device \(to verify your hardware version, see the following image\)
+ A computer to facilitate preparation: 
  + Set up your AWS DeepLens box as a Linux computer with  a mouse, keyboard, monitor, HDMI to mini USB cable, and a USB hub **OR**
  + Connect AWS DeepLens to a personal computer 

**Note**  
A micro SD card only works in lieu of a USB flash drive if you use it with a card reader because the reset can't be initiated if the card slot on the back of the AWS DeepLens device is in use\.

![\[\]](http://docs.aws.amazon.com/deeplens/latest/dg/images/deeplens-hardware-version-verification.png)

## Preparation<a name="preparation"></a>

You need to perform the procedure in this section to prepare for factory reset\. At a high level, the preparation process includes the following: 
+ Format the USB flash drive into the following two partitions:
  + 1st partition: FAT32 of 2 GB
  + 2nd partition: NTFS of at least 9 GB
+ Make the USB flash drive bootable:
  + Download the required [customized Ubuntu ISO image](https://s3.amazonaws.com/deeplens-public/factory-restore/Ubuntu-Live-16.04.3-Recovery.iso) \(which can be used for both versions, 1\.0 and 1\.1, of AWS DeepLens\) 
  + Use the downloaded image to turn the first partition of your flash drive into a bootable device
+ Put the factory restore files on the USB drive:
  + Download the compressed factory restore package for your version of DeepLens, [v1\.0](https://s3.amazonaws.com/deeplens-public/factory-restore/DeepLensFactoryRestore.zip) or [v1\.1](https://deeplens-public.s3.amazonaws.com/factory-restore/DeepLensFactoryRestore_hw_1_1.zip) \(\~3\.5GB\)
  + Unzip the package and put the unpacked files onto the 2nd partition of the USB drive

You only need to follow the procedure once to set up your USB flash drive\. Afterward, you can use the same flash drive to reset your AWS DeepLens as needed\.

There are multiple ways to partition and format a USB drive\. Depending on the computer you use, specific tasks may differ from one operating system to another\. The following procedure uses your AWS DeepLens box as an Ubuntu computer to prepare your USB flash drive using GParted, a partition\-editing application, and UNetbootin, a live USB creator which makes your flash drive bootable\.

 The same instructions apply if you are using a personal computer running the Ubuntu operating system\. If you are using another Linux or Unix computer, just replace the `apt-get` commands with the corresponding commands supported by the other system\. 

**To partition a USB drive and make it bootable by using an Ubuntu computer**

1. Format the USB drive by running Ubuntu commands on the AWS DeepLens device or a computer running Ubuntu, by doing the following:

   1. In a terminal window, run the following commands to install and launch GParted\.

      ```
      sudo apt-get update; sudo apt-get install gparted
      sudo gparted
      ```  
![\[\]](http://docs.aws.amazon.com/deeplens/latest/dg/images/DeepLens_System_Restore_GParted.png)

   1. In the GParted console, choose **/dev/sda** in the drop\-down menu in the upper\-right corner and then delete all existing partitions\.

      If the partitions are locked, open the context \(right\-click\) menu and choose **unmount**\.

   1. To create the FAT32 partition of 2 GB capacity, choose the file icon in the upper\-left corner, set the parameters as follows, and then choose **Add**: 

      **Free space preceding:** **1**

      **New size:** **2048**

      **Free space following:** **28551**

      **Align to:** **MiB**

      **Create as:** **Primary Partition**

      **Partition name:**: 

      **File system:** **fat32**

      **Label:** **BOOT**  
![\[\]](http://docs.aws.amazon.com/deeplens/latest/dg/images/DeepLens_System_Restore_Instruction.jpg)

   1. To create the NTFS partition of at least 9 GB capacity, choose the file icon, set the parameters as follows, and then choose **Add**:

      **Free space preceding:** **0**

      **New size:** **28551**

      **Free space following:** **0**

      **Align to:** **MiB**

      **Create as:** **Primary Partition**

      **Partition name:** 

      **File system:** **nfts**

      **Label:** **Flash**  
![\[\]](http://docs.aws.amazon.com/deeplens/latest/dg/images/DeepLens_System_Restore_NTFS.jpg)

   1. After you've created the FAT32 and NTFS partitions, the USB drive partition information appears in the GParted console\.  
![\[\]](http://docs.aws.amazon.com/deeplens/latest/dg/images/DeepLens_System_Restore_USB_Success.jpg)

1. To make the partitioned USB drive bootable from the FAT32 partition using UNetbootin, follow these steps:

   1. Download the [customized Ubuntu ISO image](https://s3.amazonaws.com/deeplens-public/factory-restore/Ubuntu-Live-16.04.3-Recovery.iso)\.

   1. Using UNetbootin on your AWS DeepLens device, do the following:

      1. In a terminal window, run the following commands to install and launch UNetbootin:

         ```
         sudo apt-get update; sudo apt-get install unetbootin
         sudo unetbootin
         ```

      1. In the UNetbootin window, do the following:

         1. Select **Disimage**\.

         1. For the disk image, choose **ISO**\.

         1. Open the file picker and then choose the downloaded Ubuntu ISO file\.

         1. For **Type**, choose **USB Drive**\.

         1. For **Drive**, choose `/dev/sda1`\.

         1. Choose **OK**\.  
![\[\]](http://docs.aws.amazon.com/deeplens/latest/dg/images/DeepLens_System_Restore_UNetbootin.jpg)
**Note**  
The customized Ubuntu image might be more recent than what's shown here\. If it is, use the most recent version of the Ubuntu image\.

1. To copy the factory restore files to the NTFS partition of the USB drive, follow these steps:

   1. Download the compressed factory restore package for your version of AWS DeepLens\. They are both about 3\.5 GB in size\. 
      + [AWS DeepLens v1\.0](https://s3.amazonaws.com/deeplens-public/factory-restore/DeepLensFactoryRestore.zip)
      + [AWS DeepLens v1\.1](https://deeplens-public.s3.amazonaws.com/factory-restore/DeepLensFactoryRestore_hw_1_1.zip)

   1. Unzip the downloaded package\. 

   1. Copy the following uncompressed files to the second \(NTFS\) partition of the USB drive:

      **DeepLens v1\.0:** 
      + Image files\. About 8\.6GB:
        + *DeepLens\_image\_1\.3\.22\.bin*
        + *DeepLens\_1\.3\.22\.md5*
      + Script file: 
        + *usb\_flash*

      **DeepLens v1\.1**
      + Image files\. About 8\.6GB: 
        + *image\_deepcam\_19WW19\.5tpm*
        + *image\_deepcam\_19WW19\.5\_tpm\.md5*
        + *APL\_1\.0\.15\_19WW19\.5\_pcr\_fuse\.dat*
        + *pubkey\.der\.aws*
      + Script files: 
        + *usb\_flash*
        + *seal\_and\_luksChangeKey*

Once you have your USB flash drive formatted into two partitions, you have made the first partition bootable, and you have uploaded the factory reset files to the second partition, you are ready to reset your AWS DeepLens\. Continue to the next proceedure, [Restoring Your AWS DeepLens Device to Factory Settings](deeplens-device-factory-reset-instructions.md)\.