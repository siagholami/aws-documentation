--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Connect to Your Local Network<a name="getting-started-connect"></a>

Using the following procedure, you connect the AWS Snowball Edge device to your local network\. The device doesn't need to be connected to the internet\. The device has three doors, a front, a back, and a top\.

**To connect the device to your network**

1. Open the front and back doors, sliding them inside the device door slots\. Doing this gives you access to the touch screen on the LCD display embedded in the front of the device, and the power and network ports in the back\.

1. Open the top door and remove the provided power cable from the cable nook, and plug the device into power\.

1. Choose one of your RJ45, SFP\+, or QSFP\+ network cables, and plug the device into your network\. The network ports are on the back of the device\.

1. Power on the AWS Snowball Edge device by pressing the power button above the LCD display\.

1. When the device is ready, the LCD display shows a short video while the device is getting ready to start\. After about 10 minutes, the device is ready to be unlocked\.

1. \(Optional\) Change the default network settings through the LCD display by choosing **CONNECTION**\. 

   You can change your IP address to a different static address, which you provide by using the following procedure\.

**To change the IP address of an AWS Snowball Edge device**

1. On the LCD display, choose **CONNECTION**\. 

   A screen appears that shows you the current network settings for the AWS Snowball Edge device\. The IP address below the drop\-down box is automatically updated to reflect the DHCP address that the AWS Snowball Edge device requested\. 

1. \(Optional\) Change the IP address to a static IP address\. You can also keep it as is\.

The device is now connected to your network\.

**Important**  
To prevent corrupting your data, don't disconnect the AWS Snowball Edge device or change its connection settings while it's in use\.

**Next:** [Get Your Credentials and Tools](get-credentials.md) 