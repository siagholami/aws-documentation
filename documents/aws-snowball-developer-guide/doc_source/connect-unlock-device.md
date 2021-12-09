--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Unlocking a Device<a name="connect-unlock-device"></a>

When your device arrives at your site, the first step is to connect your device and unlock it\.

**To connect and unlock your device**

1. Open the AWS OpsHub application\. If you are a first\-time user, you are prompted to choose a language, and then choose **Next**\.

1. On the **Select your device** page, choose the type of device that you want to set up, and then choose **Next**\. 

   If you don't have a device, you can order one\.

1. Choose how you want to log in to the device\. You have the following options:

   **Access with device credentials** \- This option enables you to unlock and use your device with unrestricted access\. It requires that your device be connected to your local network\. You must have the IP address of your device, the device unlock code, and the device manifest\.

   **Sign in as IAM user** \- This option enables you to sign in as an AWS Identity and Access Management \(IAM\) user\. You must have your device access code and secret key\.

1.  Choose **Access with device credentials** \- This option enables you to unlock and use your device with unrestricted access\. It requires that your device be connected to your local network\. You must have the IP address of your device, the device unlock code, and the device manifest\.

1. Choose **Next**\.

1. Open the device's flap, locate the power cord, and connect your device to a power source\.

1. Connect the Ethernet cable \(typically an RJ45 cable\), open the front panel, and power the device on\.

1. On the **Connect to your device** page, for **IP address**, enter the IP address of your device, and choose **Next**\.

1.  Enter your device client unlock code and choose **Upload** to upload the device manifest\. Then choose **Unlock**\. 

1. Optionally, you can save your device's credentials as a *profile*\. Name the profile and choose **Save profile name**\. You are directed to the AWS OpsHub dashboard, where you can see your all your devices and start managing them\. 

   For more information about profiles, see [Managing Profiles](manage-device.md#manage-profile)\.

1. On the **Devices** tab, locate and choose your device to see its details, such as network interfaces and AWS services that are running on the device\. You can filter your devices by their alias or IP address\. You can also see details of your clusters, if you have any\.

   From the device details page, you can manage your devices just as you do with the AWS Command Line Interface \(AWS CLI\)\. For more information, see [Managing AWS Services on Your Device](manage-services.md)\. 