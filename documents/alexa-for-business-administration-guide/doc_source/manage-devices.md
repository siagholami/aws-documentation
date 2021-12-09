# Managing Devices<a name="manage-devices"></a>

You can set up your Alexa devices \(Amazon Echo, Echo Dot, or Echo Plus\) using the Device Setup Tool\. This connects your device to your Wi\-Fi network and registers it with Alexa for Business\. You can also use the Alexa Companion app to set up your devices using your Amazon\.com or Amazon Business account, then import your devices into Alexa for Business\. For more information, see [Import Your Devices](getting-started.md#import)\.

After you set up your devices, you can assign them to your rooms\.

**Note**  
You need a Windows computer to use the Device Setup Tool\. You cannot run the Device Setup Tool on any cloud\-based, Windows streaming tool, such as Amazon WorkSpaces, or any imaged driver such as Boot Camp\. 

**To set up your devices using the Device Setup Tool**

1. If you haven't already, install the Device Setup Tool\. For more information, see [Run the Device Setup Tool](getting-started.md#run-tool)\.

1. Note the last three characters of the device service number \(DSN\), printed on the box\. These characters are included in the Wi\-Fi network that the device broadcasts while you are setting it up\. They are required when you assign your device to a room\.

1. Plug your device into a power outlet, and press and hold the **Action** button \(white dot\) for five seconds\. Wait until the device tells you that it is ready and the light ring turns orange\.
**Note**  
If the device has already been set up before, you can manually enter setup mode by pressing and holding the **Action** button for 7 seconds\.

1. Open the Device Setup Tool, which discovers your device\.
**Note**  
If the Device Setup Tool doesn’t discover your devices, choose **Discover devices**\.

1. Choose the devices to set up and choose **Set up devices**\.

1. Enter your Wi\-Fi network details and choose **Next**\.

The Device Setup Tool connects your devices to your Wi\-Fi network and registers them with Alexa for Business\.

**To assign devices to a room**

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Shared devices** and select the check box next to the devices to assign to a room\.

1. Choose **Assign to room**, and choose the room to which to assign the devices\.

1. Unplug the device and plug it back in to restart it\.

We recommend that you label the devices with the room to help ensure that the device remains in the correct room\. To move devices from one room to another, unassign and then re\-assign the devices\.

**To view device information**

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Shared devices** to see a list of your registered devices and the following information for each device:
   + **Serial number** – The serial number of the device\.
   + **Type** – The type of device\. 
   + **Device name** – The name of the device\.
   + **Assigned room** – The room to which the device is assigned\.
   + **Status** – The status of the device, including the network connection status of the skills and settings being applied to the device\.
     + **Online** – The device is connected to the network and all skills and settings have been applied\.
     + **Offline** – The device isn’t connected to the network\. The device might be unplugged or the network might not be working\. The time stamp next to the status shows the date and local time when the device was first detected to be offline\. 
     + **Sync in progress** – The device is connected to the network, and Alexa for Business is applying skills and settings to the device\.
     + **Sync needed** –The device is connected to the network, but not all skills and settings have been applied to the device\. This usually happens when the device was offline when Alexa for Business tried to apply all skills and settings\. To sync the device, choose **Sync**\. To sync multiple devices with this status, select all the devices from the table and choose **Sync devices** from the drop\-down menu\. 
     + **Deregistered** –The device is no longer registered with the AWS account\. The time stamp next to the status shows the date and local time when the device was first detected to be deregistered\. To remove the device, select the device and choose **Actions**, **Delete Devices**\.

Alexa for Business publishes the number of your shared devices online, offline, and deregistered to Amazon CloudWatch as metrics\. These metrics are inside the namespace **AWS/A4B**\. The metric names are **OnlineSharedDevices**, **OfflineSharedDevices**, and **DeregisteredSharedDevices** \. All of these metrics can be grouped by the metric dimensions **Room Profile** or **Organization**\.

**Note**  
Viewing **AWS/A4B** metrics by **Room Profile** filters out devices in your organization that aren't assigned to a room\. It also allows you to filter results for a specific building with offline devices\. 

**To monitor devices using CloudWatch**

1. Follow the steps in [View Available Metrics](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/viewing_metrics_with_cloudwatch.html) in the *Amazon CloudWatch User Guide*\. Instead of choosing the namespace **EC2**, choose the namespace **AWS/A4B**, and then choose a metric dimension \(**Organization** or **Room Profile**\)\.

1. To set up alarms from CloudWatch when a critical number of devices go offline, follow these steps:

   1. Graph the metric\. For more information, see [Graph a Metric](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/graph_a_metric.html)\. 

   1. Create an alarm\. For more information, see [Create an Alarm from a Metric on a Graph](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/create_alarm_metric_graph.html)\. 

**To delete a device**

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Shared devices** and select the check box next to the device to deregister\.

1. Choose **Actions**, **Delete Devices**\.
**Note**  
This action removes the device from the console\.

You can reset a device to clear all timers, alarms, to\-do lists, shopping lists, and Bluetooth\-connected phones for a device\. This also sets the volume to 5 for a shared device\.

**To reset a device**

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Shared devices** and select the devices to reset\.

1. Choose **Actions**, **Reset device**\.

Alexa for Business manages device accounts and settings through rooms and room profiles\. When you add devices to a room, change the room of a device, update specific settings in a room profile \(including the wake word, volume limit, and device setup mode\), or when you reset a device, the device must be connected to the internet for the update to complete successfully\. Alexa for Business retries these calls for one hour, and then the device is placed into a **Sync needed** status\. To implement your changes, plug in the Alexa device, ensure that it's connected to Wi\-Fi, and sync the device\. 

**To sync a device**

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Shared devices** and select one or more devices with the status **Sync needed**\.

1. Choose **Actions**, **Sync devices**\.