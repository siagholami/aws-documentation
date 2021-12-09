# Using USB Remotization<a name="using-usb"></a>

NICE DCV enables you to use specialized USB devices, such as 3D pointing devices and graphic tablets, which are physically connected to your computer to interact with an application running on a NICE DCV server\.

**Note**  
USB remotization is only supported with the installable Windows client\. It is not supported with the portable Windows client, web browser client, Linux client, or macOS client\. Additional configuration might be required on the NICE DCV server\. For more information, see [Enabling USB Remotization](https://docs.aws.amazon.com/dcv/latest/adminguide/manage-usb-remote.html) in the *NICE DCV Administrator Guide*\.

Most commonly used USB devices are supported by default\. This enables you to connect a USB device to your computer and use it on the server without any additional configuration\. To use a USB device, connect it to your computer\. In the client, choose **Settings**, and then move the slider next to the USB device in the list\.

However, some specialized USB devices are not supported by default\. Unsupported devices do not appear in the **Settings** menu after they are connected\. These devices must be added to the USB device *allow list* on the NICE DCV server before they can be used\. After they have been added to the allow list, they appear in the **Settings** menu in the client\.

**To use a device that must be added to the allow list on the NICE DCV server**

1. Ensure that you have installed the latest version of the Windows client and that you opted to install the USB remotization drivers\. For more information, see [Installable Windows Client](client-windows.md#client-windows-install)\.

1. Ensure that the USB device is connected to your computer and that you have installed the required hardware drivers\.

1. Navigate to `C:\Program Files (x86)\NICE\DCV\Client\bin\` and run `dcvusblist.exe`\.

1. Open the context \(right\-click\) menu for the USB device in the list, choose **Copy filter string**, and then send the filter string to your NICE DCV server administrator\.
**Note**  
The NICE DCV server administrator adds each USB device's filter string to the allow list\. For more information, see [Enabling USB Remotization](https://docs.aws.amazon.com/dcv/latest/adminguide/manage-usb-remote.html) in the *NICE DCV Administrator Guide*\.

1. After the device has been added to the allow list on the NICE DCV server, choose **Settings** and move the slider next to the USB device to use it\.