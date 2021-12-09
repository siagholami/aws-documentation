# Update Your AWS DeepLens Device<a name="deeplens-manual-updates"></a>

When you set up your device, you had the option to enable automatic updates \(see [Set Up Your AWS DeepLens Device](deeplens-getting-started-set-up.md)\)\. If you enabled automatic updates, you need only to reboot the device to get the software updated on your device\. If you didn't enable automatic updates, you need to manually update your device periodically\.

**Note**  
 If your updates gets stuck in an endless loop, try to check and turn on the **Unsupported updates** option under **Install updates from:** on the **Updates** tab in **Software & Updates**, an Ubuntu system utility on the device\. 

**To manually update your AWS DeepLens on the device**

1. Plug in your AWS DeepLens and turn it on\.

1. Use a micro HDMI cable to connect your AWS DeepLens to a monitor\. 

1. Connect a USB mouse and keyboard to your AWS DeepLens\.

1. When the login screen appears, sign in to the device using the SSH password you set when you registered it\.

1. Start your terminal and run each of the following commands:

   ```
   sudo apt-get update
   sudo apt-get install awscam
   sudo reboot
   ```

**To manually update your AWS DeepLens using an SSH terminal**

1. Go to the AWS DeepLens console, and do the following:

   1. Choose **Devices** from the main navigation pane\.

   1. From the device list, choose your AWS DeepLens device to open the device information page\.

   1. From the **Device details** section, copy a local IP address of the selected AWS DeepLens device\.  
![\[\]](http://docs.aws.amazon.com/deeplens/latest/dg/images/deeplens-device-local-ipaddresses.png)

1. Start a terminal and type the following SSH command, using the above example's IP address \(`192.168.1.36`\):

   ```
   ssh aws_cam@192.168.1.36
   ```

1. Run each of the following commands:

   ```
   sudo apt-get update
   sudo apt-get install awscam
   sudo reboot
   ```