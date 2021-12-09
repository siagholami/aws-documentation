# Managing mobile devices<a name="manage-devices"></a>

Remotely wipe user mobile devices, remove devices from your organization, and view details for devices in your organization from Amazon WorkMail\. For information about editing your organization's mobile device policy, see [Editing your organization's mobile device policy](edit_organization_mobile_policy.md)\.

**Topics**
+ [Remotely wiping mobile devices](#remote_wipe_device)
+ [Removing user devices from the devices list](#remove_mobile_device)
+ [Viewing mobile device details](#view_device_details)

## Remotely wiping mobile devices<a name="remote_wipe_device"></a>

You can only remotely wipe user devices when they are connected to Amazon WorkMail\. If a device is disconnected from the network, this procedure doesn't work\.

**Warning**  
For most mobile devices, a remote wipe resets the device to factory defaults\. All data, including personal files, can be removed when you perform this procedure\.

**To remotely wipe a user's mobile device**

1. Open the Amazon WorkMail console at [https://console\.aws\.amazon\.com/workmail/](https://console.aws.amazon.com/workmail/)\.

1. If necessary, change the AWS Region\. From the navigation bar, select the Region that meets your needs\. For more information, see [Regions and endpoints](http://docs.aws.amazon.com/general/latest/gr/index.html?rande.html) in the *Amazon Web Services General Reference*\.

1. For **Organizations**, choose the name of your organization\.

1. In the navigation pane, choose **Users**, select the user with the device to view, and choose **Mobile**\.

1. In the list of devices, select the device to wipe and choose **Wipe device**\.

1. Check the status in overview to see whether the wipe is requested\.

1. After the device is wiped, you can remove the device from the list\.
**Important**  
To re\-add a device, make sure the device is removed from the list; otherwise, the device will be wiped again\.

## Removing user devices from the devices list<a name="remove_mobile_device"></a>

If a user is no longer using a specific mobile device or the device is remote wiped, you can remove it from the list\. When the user configures the device again, it shows up in the list\.

**To remove a user's mobile devices from the devices list**

1. Open the Amazon WorkMail console at [https://console\.aws\.amazon\.com/workmail/](https://console.aws.amazon.com/workmail/)\.

1. If necessary, change the Region\. From the navigation bar, select the Region that meets your needs\. For more information, see [Regions and endpoints](http://docs.aws.amazon.com/general/latest/gr/index.html?rande.html) in the *Amazon Web Services General Reference*\.

1. For **Organizations**, choose the name of your organization\.

1. In the navigation pane, choose **Users**, select the user with the device to view, and choose **Mobile**\.

1. In the list of devices, select the device to remove and choose **Remove device**\.

## Viewing mobile device details<a name="view_device_details"></a>

You can view the details of a user's mobile device\.

**Note**  
Some devices don't send all of their details to the server, so you may not see all available device details\.

**To view device details**

1. Open the Amazon WorkMail console at [https://console\.aws\.amazon\.com/workmail/](https://console.aws.amazon.com/workmail/)\.

1. If necessary, change the Region\. From the navigation bar, select the Region that meets your needs\. For more information, see [Regions and endpoints](http://docs.aws.amazon.com/general/latest/gr/index.html?rande.html) in the *Amazon Web Services General Reference*\.

1. For **Organizations**, choose the name of your organization\.

1. In the navigation pane, choose **Users**, select the user with device to view, and choose **Mobile**\.

1. In the list of devices, select the device whose details you want to view\. Device status codes are listed in the following table\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workmail/latest/adminguide/manage-devices.html)