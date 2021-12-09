# Troubleshooting Device Registration Issues<a name="troubleshooting-device-registration"></a>

Use the following guidelines to troubleshoot issues with AWS DeepLens device registration\.

**Topics**
+ [Why Does My Attempt to Use the AWS DeepLens Console to Register a Device Go into an Apparently Endless Loop and Fail to Complete?](#troubleshooting-device-registration-v1.1-device-no-windows7-ie11)
+ [How to Ensure My AWS DeepLens 2019 Edition Device Is Detectable During Registration?](#troubleshooting-undetected-v1.1-device)
+ [How to Turn your Device Back to its Setup Mode to Complete Device Registration or Update Device Settings?](#troubleshooting-device-registration-1)
+ [How to Connect Your Device to Your Home or Office Wi\-Fi Network When the Wi\-Fi SSID or Password Contains Special Characters?](#troubleshooting-device-wifi-connection)
+ [What IAM Roles to Choose When None Is Available?](#troubleshooting-device-registration-2)
+ [How to View Project Output in the Chrome Browser on Mac El Capitan or Earlier?](#troubleshooting-view-project-output-in-chrome-on-mac-elcapitan-or-earlier)
+ [How to Fix an Incomplete Certificate \(\.zip\) File?](#troubleshooting-device-registration-3)
+ [How to Fix an Incorrectly Uploaded Certificate File?](#troubleshooting-device-registration-4)
+ [How to Resolve the Maximum User Limits Exceeded Restriction for Devices, Projects, or Models?](#troubleshooting-device-registration-5)
+ [How to Fix Failed Deregistration of the AWS DeepLens Device?](#troubleshooting-device-registration-6)
+ [How to Resolve Failed Registration of the AWS DeepLens Device?](#troubleshooting-device-registration-7)
+ [How to Open the Device Setup Page When the Device's Local IP Address \(192\.168\.0\.1\) Is Not Accessible?](#troubleshooting-device-registration-8)
+ [How to Make the Device's Wi\-Fi Network Visible on Your Computer When the Device Wi\-Fi Indicator Is Blinking or After Your Computer Has Connected to the Device?](#troubleshooting-device-registration-9)
+ [How to Fix an Unsuccessful Device Wi\-Fi Reset?](#troubleshooting-device-registration-10)

## Why Does My Attempt to Use the AWS DeepLens Console to Register a Device Go into an Apparently Endless Loop and Fail to Complete?<a name="troubleshooting-device-registration-v1.1-device-no-windows7-ie11"></a>

 When you use the AWS DeepLens console to register a device, if the registration fails to complete after you choose **Register device**, you may have used an unsupported browser\. Make sure that you do not use the following browser: 

**Unsupported Browser for the AWS DeepLens Console**
+  Internet Explorer 11 on Windows 7 

## How to Ensure My AWS DeepLens 2019 Edition Device Is Detectable During Registration?<a name="troubleshooting-undetected-v1.1-device"></a>

 When registering your AWS DeepLens 2019 Edition device, your computer may not detect the device after you've connected your device to your computer with a USB cable\. This would prevent your from completing the registration\. 

 To ensure that your device can be detected, make sure the following conditions are met: 
+ Your device is powered on\.
+ Your computer is connected to the device through the REGISTRATION USB port at the bottom\.
+ Your computer is not connected to Ethernet and a VPN network\.
+ Your firewall is not blocking the DeepLens network connection\. 
+ You’re using Chrome, Firefox or Safari and have the latest OS update installed\.

 If the above conditions are met and your device still remains undetected, disconnect and reconnect the USB cable to the REGISTRATION USB port on the device, then wait for a minute or two\. 

 The network interface service order on your computer may play a role to prevent your device from being detected during registration\. For example, if the USB\-C interface has a higher preference over the standard USB interface on your computer, your computer could default to USB\-C to scan attached USB devices\. Your AWS DeepLens device would become invisible\. In this case, you need to reorder the preference of network types\. To do so, you can follow, for example, [this tip on a Mac computer](https://thesweetsetup.com/set-network-service-order-macos-high-sierra/) or [this tip on a Windows computer](https://www.windowscentral.com/how-change-priority-order-network-adapters-windows-10)\. 

## How to Turn your Device Back to its Setup Mode to Complete Device Registration or Update Device Settings?<a name="troubleshooting-device-registration-1"></a>

If you don't see your device's Wi\-Fi network SSID among the available Wi\-Fi networks on your computer and the device's Wi\-Fi indicator \(the middle LED light\) does not blink, you cannot connect to the device to set up the device and to complete the registration\. 

Your device is in its setup mode when the Wi\-Fi indicator \(the middle LED light\) on the front of the device blinks\. When you start registering your device, the device is booted into the setup mode after you power it on\. Only in the setup mode is the device's Wi\-Fi \(`AMDC-NNNN`\) network visible in the list of available Wi\-Fi networks on your computer\. After 30 minutes, the device exits the setup mode, and the Wi\-Fi indicator stays on and stops blinking, 

Your device must be in the setup mode for you to connect your computer to the device, to configure the device to complete the registration or to update the device settings, or to view the output of a deployed project\. If you don't finish the setup within the allotted time, you must reset the device back to its setup mode and then reconnect your computer to the device's Wi\-Fi network\. 

After connecting your computer to the device's Wi\-Fi network, navigate to `http://deeplens.config` from a web browser to open the device configuration page and to complete setting up your device\. For an initial registration, you may want type `http://deeplens.amazon.net` in the browser's address bar to open the configuration page\.

For detailed instructions to connect to your device's Wi\-Fi network, see [Connect to Your AWS DeepLens Device's Wi\-Fi Network](deeplens-getting-started-connect.md)\.

## How to Connect Your Device to Your Home or Office Wi\-Fi Network When the Wi\-Fi SSID or Password Contains Special Characters?<a name="troubleshooting-device-wifi-connection"></a>

 If your home or office network Wi\-Fi name \(SSID\) or password contains special characters \(including single quotes, back slashes, or white spaces\), you might not be able to connect your AWS DeepLens device to the home or office Wi\-Fi network when setting up your device on the device configuration page \(`http://deeplens.amazon.net` or `http://deeplens.config`\)\.  

To work around this, follow the steps below to use SSH commands to log into the device and connect it to your home or office Wi\-Fi network\. 

**To connect your DeepLens device to your home or office Wi\-Fi network when the Wi\-Fi SSID and password contains special characters**

1. Connect to your device's Wi\-Fi network\. 

   1. Power on your DeepLens and press the power button on the front to turn on the device\. Skip this step if the device is already turned on\.

   1. Wait until the device enters into the setup mode when the Wi\-Fi indicator on the front of the device starts to flash\. If you skipped the previous step, you can turn the device into its setup mode by pressing a paper clip into the reset pinhole on the back of the device and, after feeling a click, wait for about 20 seconds for the Wi\-Fi indicator to blink\.

   1. Connect your computer to the device's Wi\-Fi network by selecting the device Wi\-Fi network SSID \(of the `AMDC-NNNN` format\) from the list of available networks and type the network password\. The SSID and password are printed on the bottom of your device\. On a Windows computer, choose **Connecting using a security key instead** when prompted for **Enter the PIN from the router label \(usually 8 digits\)**\.

1.  After the Wi\-Fi connection is established, open a web browser on your computer and type `http://deeplens.amazon.net/#deviceAccess` in the address bar\.

1. In the **Configure device access** page, choose **Enable** under **SSH server**\. Create a device password if you haven't already done so\. Choose **Save**\.
**Important**  
 After choosing **Save** do not choose **Finish**\. Otherwise, you'll be disconnected from the device and can't proceed in the following step\.  
If you've chosen **Finish**, follow **Step 1\-3** above to get back to the device's Wi\-Fi network before continuing to the next step\.

1. While your computer is connected to the device \(`AMDC-NNNN`\) network Wi\-Fi connection, open a terminal on your computer and run the following SSH command to log in to your device:

   ```
   ssh aws_cam@deeplens.amazon.net
   ```

   Type the device password\. 
**Note**  
 On a computer running Windows, you can use PuTTY or a similar SSH client to execute the SSH command\.

1. After you have logged in, run the following shell command in the terminal:

   ```
   sudo nmcli device wifi con '<wifi_ssid>' password '<wifi_password>' ifname mlan0
   ```

   Replace `<wifi_ssid>` and `<wifi_password>` with the SSID and the password for the Wi\-Fi connection, respectively\. 

   You must enclose the SSID and password in single quotes\. If the SSID or password contains a single quote, escape each instance by prefixing a back slash \(`\`\) and enclosing them within a pair of single quotes\. For example, if a single quote appears in the original `<wifi_ssid>` as `Jane's Home Network`, the escaped version is `Jane'\''s Home Network`\. 

   After the command has run, verify that your device is connected to the internet by pinging any public website\.

1. Go to `http://deeplens.amazon.net` or `http://deeplens.config` on your browser to continue setting up the device, as prescribed by [**Step 3\.b** in Set Up Your Device](deeplens-getting-started-set-up.md#deeplens-set-up-device-procedure)\. 

   When prompted, update the device software to version 1\.3\.10 or higher\. The update ensures that your AWS DeepLens device can connect to your home or office Wi\-Fi network from the AWS DeepLens console so you won't have to repeat this workaround\. 

## What IAM Roles to Choose When None Is Available?<a name="troubleshooting-device-registration-2"></a>

If [the required IAM roles](deeplens-required-iam-roles.md) are not available in your account when you register your device using the AWS DeepLens console for the first, you will be prompted to create the roles with a single click of button\. If you wish to create the required IAM roles without using the AWS DeepLens console, follow the instructions in [Create IAM Roles for Your AWS DeepLens Project](deeplens-required-iam-roles.md#deeplens-required-iam-role-create)\.

## How to View Project Output in the Chrome Browser on Mac El Capitan or Earlier?<a name="troubleshooting-view-project-output-in-chrome-on-mac-elcapitan-or-earlier"></a>

 On a Mac computer \(El Capitan and earlier\), you must provide a password to upload the streaming certificate into the key chain while using Chrome\. To use Chrome to view project output streamed from your device, you must update the device software to associate the password of `DeepLens` with the certificate first and then use the password to add the streaming certificate to the key chain\. The steps are detailed in the following procedure\. 

**To set up the `DeepLens` password on the device to enable viewing the project output in Chrome on Mac El Capitan or earlier**

1. Update the device software to set up the `DeepLens` password for the streaming certificate:

   1.  Connect to your AWS DeepLens device using an SSH or uHDMI connection\.

   1.  On the device terminal, type `$wget https://s3.amazonaws.com/cert-fix/cert_fix.zip`\.

   1.  Type `$unzip cert_fix.zip` to unzip the file\.

   1.  Type `$cd cert_fix` to step into the unzipped directory\.

   1.  Type `$sudo bash install.s` to install the updates\.

   1.  Restart your device\. 

1. After the device is started, upload the streaming certificate to your Mac \(El Capitan or earlier\) for viewing project output:

   1.  [Connect](deeplens-getting-started-connect.md) your computer to the devices Wi\-Fi \(`AMDC-NNNN`\) network

   1.  Open the device setup page in your browser using the `deeplens.config` URL

   1.  Choose **Enable streaming certificates**\. Ignore the browser instructions\.

   1.  Choose the **Download streaming certificates** button\.

   1.  After the certificates are downloaded, rename the downloaded certificates from `download` to `my_device.p12` or `some_other_unique_string.p12`\.

   1.  Double click on your certificate to upload it into the key chain\.

   1.  The key chain will ask you for a certificate password, enter `DeepLens`\. 

   1.  To view the project output streamed from your device, open Chrome on your Mac computer and navigate to your device's video server web page at `https://your_device_ip:4000` or use the AWS DeepLens console to open the page\.

      You'll be asked to select a streaming certificate from the key chain\. However, the key chain refers to any streaming certificate uploaded in **Step 2\.f** above as `client cert`\. To differentiate any multiple like\-named key\-chain entries, use the expiration date and validation date when choosing the streaming certificate\.

   1.  Add the security exception\. When prompted, enter your computer system's username and password, and choose to have the browser remember it so you don’t have to keep entering it\. 

## How to Fix an Incomplete Certificate \(\.zip\) File?<a name="troubleshooting-device-registration-3"></a>

If you download a certificate \.zip file and forget to choose the **Finish** button, you get an incomplete and, therefore, unusable certificate file\. To fix this, delete the downloaded zip file and reregister your device\.

## How to Fix an Incorrectly Uploaded Certificate File?<a name="troubleshooting-device-registration-4"></a>

If you accidentally uploaded an incorrect certificate \(\.zip\) file, upload the correct certificate \(\.zip\) file to overwrite the incorrect one\.

## How to Resolve the Maximum User Limits Exceeded Restriction for Devices, Projects, or Models?<a name="troubleshooting-device-registration-5"></a>

Deregister the device, delete a project, or delete a model before adding new one\.

## How to Fix Failed Deregistration of the AWS DeepLens Device?<a name="troubleshooting-device-registration-6"></a>

 Stop deregistration and reregister the device\. 

**To stop deregistering and then reregister an AWS DeepLens device**

1. Turn the device back to its setup mode by inserting a small paper clip into the reset pinhole at the back of the device\.

1. Reregister the device with a new device name\. 

1. Upload the new certificate to replace the old one\.

## How to Resolve Failed Registration of the AWS DeepLens Device?<a name="troubleshooting-device-registration-7"></a>

Device registration often fails because you have incorrect or insufficient permissions\. Make sure that the correct IAM roles and permissions are set for the AWS services you use\. 

For example, when setting the permissions in the AWS DeepLens console, you must already have created an IAM role with the required permissions for AWS IoT Greengrass and associated this role with the **IAM role for AWS Greengrass** option\. If registration fails, make sure that you've created and specified the correct roles, then reregister the device\.

Specifying an existing Lambda role for the **IAM role for AWS Lambda** can also cause registration to fail if the role name doesn't start with `AWSDeepLens`\. Specifying a role whose name doesn't begin with `AWSDeepLens` doesn't affect the deployment of Lambda functions\.

To set up the roles correctly, follow the instructions in [Register Your AWS DeepLens Device](deeplens-getting-started-register.md) and check with the AWS DeepLens console tips for each role\.

## How to Open the Device Setup Page When the Device's Local IP Address \(192\.168\.0\.1\) Is Not Accessible?<a name="troubleshooting-device-registration-8"></a>

If your AWS DeepLens device is running software \(`awscam`\) version 1\.3\.6 or later, you can open the device setup page by navigating to `http://deeplens.amazon.net` \(the first time you register the device\) or `http://deeplens.config` in a browser window on your computer\. Your computer must be [connected to the device's \(`AMDC-nnnn`\) Wi\-Fi network](deeplens-getting-started-connect.md)\.

If your device is running an earlier version of the `awscam` package, update o the latest version by running the following commands from a terminal on the device:

```
sudo apt update
sudo apt install awscam
```

If you don't want to update the `awscam` package to the latest version yet, you can navigate to `http://192.168.0.1` to launch the device setup page if your AWS DeepLens device software package is older than 1\.2\.4 or you can navigate to http://10\.105\.168\.217 if the device software package is 1\.2\.4 or newer 

If your device software is older than 1\.2\.4 and your home or office Wi\-Fi network router also uses `192.168.0.1` as the default IP address, reset the router's IP address to, for example, `192.168.1.0`\. For instructions on resetting your router's IP address, see the documentation for your router\. For example, to change a D\-Link router IP address, see [ How do I change the IP Address of my router?](http://www.dlink.com/uk/en/support/faq/routers/mydlink-routers/dir-605l/how-do-i-change-the-ip-address-of-my-router)\. 

If your device's Wi\-Fi network is unresponsive, reset the device and connect to it again\. To reset the device, press a pin on the **RESET** button on the back of the device, and wait until the Wi\-Fi indicator \(on the front of the device\) blinks\. 

## How to Make the Device's Wi\-Fi Network Visible on Your Computer When the Device Wi\-Fi Indicator Is Blinking or After Your Computer Has Connected to the Device?<a name="troubleshooting-device-registration-9"></a>

When you can't see your device's Wi\-Fi network on your laptop even though the middle LED light on the device is blinking or if your computer is still connected to the device Wi\-Fi network after the middle LED light stops blinking, refresh the available Wi\-Fi networks on your computer\. Usually, this involves turning off the laptop Wi\-Fi and turning it back on\. 

It takes up to 2 minutes to reboot a device and for the device Wi\-Fi network to be ready to accept connection requests\.

## How to Fix an Unsuccessful Device Wi\-Fi Reset?<a name="troubleshooting-device-registration-10"></a>

If the device's Wi\-Fi indicator \(middle LED light\) isn't blinking after you reset the device by pressing a pin into the reset pinhole on the back of it, connect the device to the internet with an Ethernet cable, connect the device to a monitor\. a keyboard and a mouse, log in to the device, open a terminal window, and run the following commands to reset the `awscam` package:

```
sudo systemctl status softap.service
```

If the command returns error code 203, reinstall `awscam-webserver` by running the following commands on your AWS DeepLens device:

```
sudo apt-get install --reinstall awscam-webserver
sudo reboot
```

The successful reboot sets up the device's Wi\-Fi network, and the middle LED light on the device will start to blink\.