# Set Up Your AWS DeepLens Device<a name="deeplens-getting-started-set-up"></a>

When setting up your AWS DeepLens device, you perform the following tasks while your computer is connected to your device's `AMDC-NNNN` network: 
+  Enable the device's internet connection through your home or office wireless \(Wi\-Fi\) or wired \(Ethernet\) network\.
+ Attach to your device the AWS\-provisioned security certificate as discussed in [Register Your AWS DeepLens Device](deeplens-getting-started-register.md)\.
+ Set up login access to the device, including with an SSH connection or a wired connection\.
+ Optionally, download the streaming certificate from the device to enable viewing project video output in a supported browser\.

 If your computer is no longer a member of the `AMDC-NNNN `network because your AWS DeepLens device has exited setup mode, follow the instructions in [Connect to Your AWS DeepLens Device's Wi\-Fi Network](deeplens-getting-started-connect.md) to establish a connection and to open the device setup page, again, before proceeding further\.<a name="deeplens-set-up-device-procedure"></a>

**To set up your AWS DeepLens device**

1. If your AWS DeepLens device has a more recent version of the software installed, you won't be prompted with the following tasks\. Skip to Step 2 below\. Otherwise, proceed to the **Device setup** page, which you opened after [connecting to the device](deeplens-getting-started-connect.md), to set up your home or office network to connect your device to the internet: 

   1. Under **Step 1: Connect to network**, choose your home or office Wi\-Fi network SSID from the **Wi\-Fi network ID** drop\-down list\. Type the Wi\-Fi network password  
![\[\]](http://docs.aws.amazon.com/deeplens/latest/dg/images/deeplens-initial-device-setup.png)

      Alternatively, You can choose **Use Ethernet** to connect your AWS DeepLens device to the internet\.

   1. Choose **Next** to connect the device to the internet\.

   1.  On the next page, Choose **Install and reboot** to install the latest software on the device and to restart the device\.  
![\[\]](http://docs.aws.amazon.com/deeplens/latest/dg/images/deeplens-device-setup-guide-page.png)

      After the software update is installed and the device restarted, reconnect your computer to your device's `AMDC-NNNN` network, navigate to http://deeplens\.config in a web browser to open the updated device setup application, and to complete the rest of the device setup as shown in Step 2\.

1. When your device has an updated software installed, starting the device setup application \(e\.g\., `http://deeplens.config`\) opens a browser page similar to the following:  
![\[\]](http://docs.aws.amazon.com/deeplens/latest/dg/images/deeplens-updated-device-setup-page.png)

   The **Connect your device to your home or office network** section shows the device's internet connection status as **Online**\. You can choose **Edit** to update the internet connection by choosing a different Wi\-Fi network or a wired network with a micro\-USB\-to\-Ethernet adaptor\. Otherwise, continue to the next step to complete the rest of the device configuration\.

1. Under **Upload security certificate to associate your AWS DeepLens to your AWS account** on the updated **Configure your AWS DeepLens** page, do the following:

   1. Choose **Browse** to open a file picker\. 

   1. Locate and choose the security certificate that you downloaded when [preparing your AWS account for AWS DeepLens](deeplens-getting-started-register.md),

   1. Choose **Upload zip file** to attach the certificate to the device\.
**Note**  
The downloaded security certificate for the device is a \.zip file\. Upload the unzipped certificate file as\-is\. 

   For device setup update after the initial registration, your device has a previous certificate installed\. In this case, choose **Edit** and follow the instructions above in this step to upload the new certificate\.

1. Under **Set a password to control how you access and update the device**, complete the following steps to configure device access\.

   1. For the initial registration, type a password in **Create a password**\. The password must be at minimum eight characters long and contain at least one number, an uppercase letter, and a special character \(e\.g\., '`*`', '`&`', '`#`', '`$`', '`%`', '`@`', or '`!`'\)\. You need this password to log in to your device either using an SSH connection \(if enabled below\) or using a hardwired monitor, a USB mouse and/or a USB keyboard\.

   1. For **SSH server**, choose **Enable** or **Disable**\. If enabled, SSH allows you to log in to your device using an SSH terminal on your Mac or Linux computer or using PuTTY or another SSH client on your Windows computer\. 

   For subsequent configuration updates after the initial registration, you can choose **Edit** and follow the ensuing instructions to update the password\. 

1. Optionally, on the upper\-right corner of the device setup page, choose **Enable video streaming** to enable viewing project video output using a supported browser\. For the initial registration, we recommend that you skip this option and enable it later when updating the device configuration after you've become more familiar with AWS DeepLens\.

1. Review the settings\. Then, choose **Finish** to complete setting up the device and to terminate your connection to the device's Wi\-Fi network\. Make sure to connect your computer back to your home or office network\.
**Note**  
 To ensure the setup completes successfully, make sure that AWS DeepLens device has access to ports 8883 and 8443 and is not blocked by your network firewall policy\.   
If the AWS DeepLens device's connection to the internet repeated turns on and off after you chose **Finish**, restart your home or office Wi\-Fi network\. 

 This completes the device registration\. [Verify your device registration status](deeplens-getting-started-verify-connection.md) before moving on to create and deploy a project to your AWS DeepLens device\. 