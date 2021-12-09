# Troubleshooting AWS DeepLens Software Issues<a name="troubleshooting-device-software"></a>

The following troubleshooting tips explain how to resolve issues that you might encounter with AWS DeepLens software\.

**Topics**
+ [How to Determine Which Version of AWS DeepLens Software You Have?](#troubleshooting-device-software-version)
+ [How to Check the Latest Version of the awscam Software Package?](#troubleshooting-device-software-awscam-version)
+ [How to Reactivate Wi\-Fi Hotspots After Restarting the Device?](#troubleshooting-device-software-wifi-hotspots)
+ [How to Ensure That a Successfully Deployed Lambda Inference Function Can Be Called?](#troubleshooting-device-software-kernel-version)
+ [How to Update the awscam Software Package to the Latest Version?](#troubleshooting-device-software-upgrade-awscam)
+ [How to Upgrade the awscam Software Package Dependencies?](#troubleshooting-device-software-awscam-dependencies)
+ [How to Install Security Updates on the Device?](#troubleshooting-device-software-security-updates)
+ [How to Handle Unsupported Architecture During a Device Update?](#troubleshooting-device-software-unsupported-architecture)

## How to Determine Which Version of AWS DeepLens Software You Have?<a name="troubleshooting-device-software-version"></a>

The software on the AWS DeepLens device is a Debian package named `awscam`\. To find the version of `awscam` that you have, you can use the AWS DeepLens console or the terminal on your AWS DeepLens device, 

**To use the AWS DeepLens console**

1. Sign in to the [AWS DeepLens console](https://console.aws.amazon.com/deeplens)\.

1. In the navigation pane, choose **Devices**\.

1. In the **Devices** list, choose your registered device\.

1. Make note of the **Device version**\.

**To use the terminal on your AWS DeepLens device**

1. Connect your device to a monitor using a micro\-HDMI cable, mouse, and keyboard or connect to the device using an `ssh` command\.

1. In a terminal on the device, run the following command:

   ```
   dpkg -l awscam
   ```

1. Look for the version number in the version column\. For example, in the following example, the installed version of `awscam` is `1.2.3`\. 

   ```
   Desired=Unknown/Install/Remove/Purge/Hold
   | Status=Not/Inst/Conf-files/Unpacked/halF-conf/Half-inst/trig-aWait/Trig-pend
   |/ Err?=(none)/Reinst-required (Status,Err: uppercase=bad)
   ||/ Name           Version     Architecture    Description
   +++-==============-===========-===============-===============
   ii  awscam         1.2.3      amd64           awscam
   ```

## How to Check the Latest Version of the awscam Software Package?<a name="troubleshooting-device-software-awscam-version"></a>

You can use the terminal on your AWS DeepLens device to see what the latest version of `awscam` is\.

**To see what the latest version of awscam is using your AWS DeepLens device**

1. Connect to your AWS DeepLens device\.

1. Open a terminal on your device\.

1. Run the following commands:

   ```
   sudo apt-get update
   ```

   ```
   sudo apt-cache policy awscam
   ```

The following example shows an example output, where `1.2.3` would be the latest version of awscam on your device:

```
awscam | 1.2.3 | https://awsdeep-update.us-east-1.amazonaws.com awscam/main amd64 Packages
```

## How to Reactivate Wi\-Fi Hotspots After Restarting the Device?<a name="troubleshooting-device-software-wifi-hotspots"></a>

If your device loses Wi\-Fi connection and restarting your device doesn't reactivate Wi\-Fi hotspots, you might be affected by the Linux kernel upgrade from Ubuntu\. To resolve this, roll back the kernel\.

**To roll back the Linux kernel on your device**

1. Open a terminal on your device\.

1. Run the following command:

   ```
   ifconfig
   ```

1. Inspect the output of the command\. If the output lists only the `localhost` network interface, turn off the device and then turn it back on to restart the system\. 

1. If you still don't have Wi\-Fi access, run the following command to check which version of the Linux kernel is installed\.

   ```
   uname -r
   ```

1. If you have the 4\.13\.x\-xx version of the kernel, you are affected by the kernel upgrade from Ubuntu\. To resolve this, roll back the kernel using the following commands\. Replace `x-xx` with your version number:

   ```
   sudo apt remove linux-image-4.13.x-xx-generic linux-headers-4.13.x-xx-generic
   sudo reboot
   ```

   After the device has restarted, the kernel version should be `4.10.17+` or `4.13.x-xx-deeplens`\.

If the version of your `awscam` software is 1\.2\.0 or later, you shouldn't have this issue\. 

## How to Ensure That a Successfully Deployed Lambda Inference Function Can Be Called?<a name="troubleshooting-device-software-kernel-version"></a>

If you successfully deployed an inference function to Lambda before January 10, 2018, but the Lambda function doesn't appear to be called to perform inference, and your Linux kernel version is 4\.13\.0\-26, you are affected by the Linux kernel upgrade from Ubuntu\. To resolve this, follow the procedure in [How to Determine Which Version of AWS DeepLens Software You Have?](#troubleshooting-device-software-version) to roll back the Linux kernel to Ubuntu 4\.10\.17\+\.

## How to Update the awscam Software Package to the Latest Version?<a name="troubleshooting-device-software-upgrade-awscam"></a>

If you enabled automatic updates when you set up your device, AWS DeepLens automatically updates `awscam` every time you turn on your device\. If you find the software is out\-of\-date, restart the AWS DeepLens device and wait for a few minutes after the system is running\. 

The update might get delayed or fail under the following conditions:
+ Scenario 1: The Ubuntu system is updated every time you restart the device\. This blocks concurrent `awscam` automatic updates \. To check if an Ubuntu update is running, run the following command from a terminal:

  ```
  sudo lsof /var/lib/dpkg/lock
  ```

  If the output looks similar to the following, a concurrent Ubuntu update is running:

  ```
  COMMAND   PID  USER FD  TYPE DEVICE SIZE/OFF NODE NAME
  unattende 2638 root 4uW REG  179,2  0        21   /var/lib/dpkg/lock
  ```

  In this case, wait for the Ubuntu update to finish\. If the installed version of `awscam` is earlier than 1\.1\.11, restart the system after Ubuntu finishes updating\. Otherwise, wait for the `awscam` update to start automatically\.
+ Scenario 2: `awscam` installation can be interrupted by a system restart or other events\. If this happens, `awscam` might be only partially configured\. Run the following command to check the package version:

  ```
  dpkg -l awscam
  ```

  If the upgrade has not completed successfully, you see output similar to the following:

  ```
  Desired=Unknown/Install/Remove/Purge/Hold
  | Status=Not/Inst/Conf-files/Unpacked/halF-conf/Half-inst/trig-aWait/Trig-pend
  |/ Err?=(none)/Reinst-required (Status,Err: uppercase=bad)
  ||/ Name           Version     Architecture   Description
  +++-==============-===========-==============-===============
  iF  awscam         1.1.10      amd64          awscam
  ```

  A status of `iF` prevents an `awscam` update\. To resolve this issue, run the following command:

  ```
  sudo dpkg --configure -a
  ```

  Verify the status again and restart the device to let the automatic update of `awscam` proceed\.
+ Scenario 3: If you've tried the suggestions for Scenario 1 and 2, and `awscam` still hasn't been updated, manually start the update by running the following commands:

  ```
  sudo apt-get update
  sudo apt-get install awscam
  ```

  Allow several minutes for the update to finish\. If AWS DeepLens reports an error during the upgrade process, see [How to Upgrade the awscam Software Package Dependencies?](#troubleshooting-device-software-awscam-dependencies)\.

## How to Upgrade the awscam Software Package Dependencies?<a name="troubleshooting-device-software-awscam-dependencies"></a>

When upgrading `awscam` on your device, you might get an error message about unmet dependencies\. An example of such error message is shown in the following output: 

```
Reading package lists... Done
Building dependency tree
Reading state information... Done
You might want to run 'apt-get -f install' to correct these.
The following packages have unmet dependencies:
pulseaudio : Depends: libpulse0 (= 1:8.0-0ubuntu3.3) but 1:8.0-0ubuntu3.4 is
installed
pulseaudio-module-bluetooth : Depends: pulseaudio (= 1:8.0-0ubuntu3.4)
pulseaudio-module-x11 : Depends: pulseaudio (= 1:8.0-0ubuntu3.4)
E: Unmet dependencies. Try using -f.
```

To resolve such an error , run the following command from a terminal on your device:

```
sudo apt-get -f install
```

If the error persists or you get another error message similar to the following, you might need to force installation:

```
Errors were encountered while processing:
/var/cache/apt/archives/pulseaudio_1%3a8.0-0ubuntu3.4_amd64.deb
E: Sub-process /usr/bin/dpkg returned an error code (1)
```

To force installation, run the following commands: 

```
sudo dpkg --configure -a
sudo dpkg -i --force-overwrite /var/cache/apt/archives/pulseaudio_1%3a8.0-0ubuntu3.4_amd64.deb
```

If you have the Linux kernel version 4\.13\-32, you might need to change the path of the pulse audio package to `/var/cache/apt/archives/pulseaudio_1%3a8.0-0ubuntu3.7_amd64.deb` in the preceding command\. 

Make sure that the package is installed by inspecting the output of the following command:

```
sudo apt-get -f install
```

If multiple packages show the `Errors were encountered while processing` error message, run the following command on each of them:

```
dpkg -i --force-overwrite
```

After forced installation has finished, run the following command to complete the upgrade:

```
sudo apt-get upgrade
```

## How to Install Security Updates on the Device?<a name="troubleshooting-device-software-security-updates"></a>

When using `ssh` to connect to your device, you might see messages like `245 packages can be updated` and `145 updates are security updates`\.

In general, security updates don't affect the operation of your device\. However, if you have security concerns, you can manually apply security updates with the following command:

```
sudo apt-get update
sudo apt-get upgrade
```

To update all packages at once, run the following command:

```
sudo apt-get dist-upgrade
```

If you get `unmet dependencies` error messages, follow the instruction in [How to Upgrade the awscam Software Package Dependencies?](#troubleshooting-device-software-awscam-dependencies) to resolve the errors\.

## How to Handle Unsupported Architecture During a Device Update?<a name="troubleshooting-device-software-unsupported-architecture"></a>

If you run the `sudo apt-get update` command and get the `The https://awsdeepupdate.us-east-1.amazonaws.com packages repository is not set to public (access denied) causing error: "doesn't support architecture i386"` error message , you can safely ignore it\. The `awscam` package is supported only for x86\_64 architecture\.