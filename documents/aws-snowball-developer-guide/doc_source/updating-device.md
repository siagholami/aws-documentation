--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Updating software on a AWS Snowball Edge<a name="updating-device"></a>

The software update allows you to download an update from AWS and install it on Snowball Edge devices in your on\-premises environments\. These updates happen in the background\. You can continue to use your devices as normal while the latest software is downloaded securely from AWS to your device\. However, to apply downloaded updates, you need to restart the device\.

**Warning**  
We highly recommend that you suspend all activity on your device before restarting it\. Restarting a device stops running instances, interrupts any writing to local Amazon S3 buckets, and stops any write operations from the file interface without clearing the cache\. All of these processes can result in lost data\.

## Prerequisites<a name="prereq-updating-device"></a>

Before you can update your device, the following prerequisites must be met:
+ You've created your job, have the device on\-premises, and you've unlocked it\. For more information see [Getting Started with an AWS Snowball Edge Device](getting-started.md)\.
+ Updating a Snowball Edge is done through the Snowball client\. The Snowball client must be downloaded and installed on a computer in your local environment that has a network connection to the device you want to update\. For more information, see [Using the Snowball Client](using-client.md)\.
+ \(Optional\) We recommend that you configure a profile for the Snowball client\. For more information, see [Configuring a Profile for the Snowball Client](using-client-commands.md#client-configuration)\.

Now that you've completed those tasks, you can now download and install updates for Snowball Edge devices\.

## Downloading Updates<a name="download-updates"></a>

There are two primary ways that you can download an update for a Snowball Edge device: 
+ You can trigger manual updates at any time using specific Snowball client commands\.
+ You can programmatically determine a time to automatically update the device\.

The following procedure outlines the process of manually downloading updates\. For information on automatically updating your Snowball Edge device, see `snowballEdge configure-auto-update-strategy` in [Updating a Snowball Edge](using-client-commands.md#update-client-commands)\.

**Note**  
If your device has no access to the internet, you can download an update file using the [GetSoftwareUpdates](https://docs.aws.amazon.com/snowball/latest/api-reference/API_GetSoftwareUpdates.html) API\. Then point to a local file location when you call `download-updates` using the `--uri` option\. For example:  

```
snowballEdge download-updates --uri file:///tmp/local-update
```

**To check for and download Snowball Edge software updates**

1. Open a terminal window, and ensure that the Snowball Edge device is unlocked with the `snowballEdge describe-device` command\. If the device is locked, use the `snowballEdge unlock-device` command to unlock it\.

1. When the device is unlocked, run the `snowballEdge check-for-updates` command\. This command returns the latest available version of the Snowball Edge software, and also the current version installed on the device\.

1. If your device software is out of date, run the `snowballEdge download-updates` command\.
**Note**  
If you device is not connected to the internet, first download an update file using use the [GetSoftwareUpdates](https://docs.aws.amazon.com/snowball/latest/api-reference/API_GetSoftwareUpdates.html) API\. Then run the `snowballEdge download-updates` command using the `--uri` option with a local path to the file you downloaded\. For example:  

   ```
   snowballEdge download-updates --uri file:///tmp/local-update
   ```

1. You can check the status of this download with the `snowballEdge describe-device-software` command\. While an update is downloading, the status displayed with this command\. 

**Example output**  
 `Install State: Downloading`

## Installing Updates<a name="install-updates"></a>

After you've downloaded updates, you need to install them and restart your device for the updates to take effect\. The following procedure guides you through how to manually install updates\.

**To install Snowball Edge software updates that were already downloaded**

1. Open a terminal window, and ensure that the Snowball Edge device is unlocked with the `snowballEdge describe-device` command\. If the device is locked, use the `snowballEdge unlock-device` command to unlock it\.

1. Run the `snowballEdge install-updates` command\.

1. You can check the status of this installation with the `snowballEdge describe-device-software` command\. While an update is installing, the status is displayed with this command\.

**Example output**  
`Install State: Installing //Possible values[NA, Installing, Requires Reboot]`

   You’ve successfully installed a software update for your Snowball Edge device\. Installing an update does not automatically apply the update to the device\. To finish installing the update, the device must be restarted\.

   We highly recommend that you suspend all activity on the device before you restart the device\. Restarting a device stops running instances, interrupts any writing to Amazon S3 buckets on the device, and stops any write operations from the file interface without clearing the cache\.
**Warning**  
Restarting your Snowball Edge device without stopping all activity on the device can result in lost data\.

1. Run the `snowballEdge list-services `command to list the currently running services on the device\.

1. Run the `snowballEdge describe-service` command for each of the running services, to see their status\.

1. Use this information to stop those services \(setting the services to the `INACTIVE` state\)\.

1. When all the services on the device have stopped, run the `snowballEdge reboot-device` command\. This command immediately power\-cycles the device to complete installation of the downloaded software updates\.

1. After the device powers on open a terminal window and use the `snowballEdge unlock-device` command to unlock the device\.

1. Run the `snowballEdge check-for-updates` command\. This command returns the latest available version of the Snowball Edge software, and also the current version installed on the device

You have now successfully updated your device and confirmed that your device is up\-to\-date with the latest Snowball Edge software\.