--------

This guide is for the Snowball \(50 TB or 80 TB of storage space\)\. If you are looking for documentation for the Snowball Edge, see the [AWS Snowball Edge Developer Guide](https://docs.aws.amazon.com/snowball/latest/developer-guide/whatisedge.html)\.

--------

# Connect the AWS Snowball device to Your Local Network<a name="getting-started-connect"></a>

In this step, you'll connect the Snowball to your network\. The Snowball appliance has two panels, a front and a back, which are opened by latches and flipped up to rest on the top of the Snowball\. Open the front panel first, flip it on top of the Snowball, and then open the back panel, flipping it up to rest on the first\. Doing this gives you access to the touch screen on the E Ink display embedded in the front side of the Snowball, and the power and network ports in the back\.

Remove the cables from the cable catch, and plug the Snowball into power\. Each Snowball has been engineered to support data transfer over RJ45, SFP\+ copper, or SFP\+ optical 10 gigabit Ethernet\. For SFP\+ optical, you'll have to use your own cable, connected to the SFP\+ optical adapter in one of the SFP\+ ports\. For more information on cables and ports, see [Supported Network Hardware](specifications.md#network-hardware)\. Choose a networking option, and plug the Snowball into your network\. Power on the Snowball by pressing the power button above the E Ink display\.

1. Connect the powered\-off Snowball to your network\.
**Note**  
We recommend that you set up your network connections so that there are as few hops as possible between the data source, the workstation, and the Snowball\. 

1. Attach the power cable to the back of the Snowball, and then plug it in to a reliable source of power\. Then press the power button, located above the E Ink display, and wait for the E Ink display to read **Ready**\.

1. When the Snowball is ready, the E Ink display shows the following screen\.  
![\[The Snowball is ready.\]](http://docs.aws.amazon.com/snowball/latest/ug/images/digitaldisplayready.png)

   At this point, you can change the default network settings through the E Ink display by choosing **Network**\. To learn more about specifying network settings for the Snowball, see [Changing Your IP Address](using-device.md#snowballnetwork)\.

   Make a note of the IP address shown, because you'll need it to configure the Snowball client\.
**Important**  
To prevent corrupting your data, do not disconnect the Snowball or change its network settings while transferring data\.

The Snowball is now connected to your network\.

**Next:** [Transfer Data](transfer-data.md) 