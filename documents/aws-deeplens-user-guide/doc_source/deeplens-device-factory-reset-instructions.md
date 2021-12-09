# Restoring Your AWS DeepLens Device to Factory Settings<a name="deeplens-device-factory-reset-instructions"></a>

Follow the instructions  to restore your AWS DeepLens device to its factory settings\. Before you proceed, you must follow the instructions in [Preparing for the Factory Reset of Your AWS DeepLens Device](deeplens-device-factory-reset-preparation.md)\. 

**Warning**  
 All data previously stored on your AWS DeepLens device will be erased\! <a name="deeplens-device-factory-reset-procedure"></a>

**To restore your AWS DeepLens device to its factory settings**

1.  Insert the prepared USB drive into your AWS DeepLens device and power it on\. Repeatedly press the *ESC* key to enter BIOS\. To prepare a USB drive, see [Preparing for the Factory Reset of Your AWS DeepLens Device](deeplens-device-factory-reset-preparation.md)\.

1. From the BIOS window on your monitor, choose **Boot From File**, choose **USB VOLUME**, choose **EFI**, choose **BOOT**, and then choose **BOOTx64\.EFI**\.

1.  After the live system is up, wait for the device reset to start automatically\. This occurs when the power LED indicator starts to flash and a terminal window pops up to display your progress\. No further user input is necessary at this point\. 
**Note**  
If an error occurs and the recovery fails, restart the procedure from step 1\. For detailed error messages, see the *result\.log* file that's generated on the USB flash drive\.  
The LED indicator light won't flash if you are using the card slot on the back of the device\.

1. After approximately six minutes, the power LED light stops flashing and the terminal closes, which indicates that the factory reset is complete\. Then, the device reboots itself automatically\. 

1.  Your device is now restored\. You can disconnect your USB flash drive from AWS DeepLens\. 