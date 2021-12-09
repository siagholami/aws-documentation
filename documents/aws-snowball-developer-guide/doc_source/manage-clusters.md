--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Managing an Amazon EC2 Cluster<a name="manage-clusters"></a>

An Amazon EC2 *cluster* is a group of devices that provision together as a cluster of devices\. To use a cluster, the AWS services on your device must be running at your default endpoint\. You also need to choose the specific device in the cluster that you want to talk to\. You use a cluster on a per\-device basis\.

**To create an EC2 cluster**

1. Connect and log in to your Snow device\. For instructions on how to log in to your device, see [Unlocking a Device](connect-unlock-device.md)\.

1. On the **Choose device** page, choose **Snowball Edge Cluster**, and then choose **Next**\.

1. On the **Connect to your device** page, provide the IP address of the device and the IP addresses of other devices in the cluster\. 

1. Choose **Add another** device to add more devices, and then choose **Next**\.

1. On the **Provide the keys** page, enter the device client unlock code, upload the device manifest, and choose **Unlock device**\. 

   Snowball Edge devices use 256\-bit encryption to help ensure both security and full chain\-of\-custody for your data\.

1. Optionally, you can enter a name to create a profile, and then choose **Save profile name**\. You are directed to the dashboard, where you see all your clusters\.

   You can now start using AWS services and managing your cluster\. You manage instances in the cluster the same way you manage individual instances\. For instructions, see [Managing AWS Services on Your Device](manage-services.md) or [Managing Your Devices](manage-device.md)\.