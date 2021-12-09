--------

This guide is for the Snowball \(50 TB or 80 TB of storage space\)\. If you are looking for documentation for the Snowball Edge, see the [AWS Snowball Edge Developer Guide](https://docs.aws.amazon.com/snowball/latest/developer-guide/whatisedge.html)\.

--------

# Using an AWS Snowball Device<a name="using-device"></a>

Following, you can find an overview of the Snowball appliance, the physically rugged device protected by AWS Key Management Service \(AWS KMS\) that you use to transfer data between your on\-premises data centers and Amazon Simple Storage Service \(Amazon S3\)\. This overview includes images of the Snowball, instructions for preparing the device for data transfer, and networking best practices to help optimize your data transfer\.

For information on transferring data to or from a Snowball, see [Transferring Data with a Snowball](#snowball-data-transfer)\.

When the Snowball first arrives, inspect it for damage or obvious tampering\.

**Warning**  
If you notice anything that looks suspicious about the Snowball, don't connect it to your internal network\. Instead, contact [AWS Support](https://aws.amazon.com/premiumsupport/), and a new Snowball will be shipped to you\.

The following is what the Snowball looks like\.

![\[The Snowball is a device that weighs less than 50 pounds and is used to transfer data.\]](http://docs.aws.amazon.com/snowball/latest/ug/images/Snowball-closed-600w.png)

It has two panels, a front and a back, which are opened by latches and flipped up to rest on the top of the Snowball\.

![\[The Snowball is a device that weighs less than 50 pounds and is used to transfer data.\]](http://docs.aws.amazon.com/snowball/latest/ug/images/Snowball-opening-600w.png)

Open the front panel first, flip it on top of the Snowball, and then open the back panel second, flipping it up to rest on the first\.

![\[The Snowball is a device that weighs less than 50 pounds and is used to transfer data.\]](http://docs.aws.amazon.com/snowball/latest/ug/images/Snowball-opened-600w.png)

Doing this gives you access to the touch screen on the E Ink display embedded in the front side of the Snowball, and the power and network ports in the back\.

Remove the cables from the cable catch, and plug the Snowball into power\. Each Snowball has been engineered to support data transfer over RJ45, SFP\+ copper, or SFP\+ optical 10 gigabit Ethernet\. Choose a networking option, and plug the Snowball into your network\. Power on the Snowball by pressing the power button above the E Ink display\.

You’ll hear the Snowball internal fans start up, and the display changes from your shipping label to say **Preparing**\. Wait a few minutes, and the **Ready** screen appears\. When that happens, the Snowball is ready to communicate with the Snowball client data transfer tool and accept your incoming traffic\.

![\[The Snowball is ready.\]](http://docs.aws.amazon.com/snowball/latest/ug/images/digitaldisplayready.png)

The E Ink display is used to provide you with shipping labels and with the ability to manage the IP address that the Snowball uses to communicate across your local network\.

## Changing Your IP Address<a name="snowballnetwork"></a>

You can change your IP address to a different static address, which you provide by following this procedure\.

**To change the IP address of a Snowball**

1. On the E Ink display, tap **Network**\. The following screen appears, which shows you the current network settings for the Snowball\.  
![\[DHCP is on by default.\]](http://docs.aws.amazon.com/snowball/latest/ug/images/DHCPdefault.png)

1. At the top of the page, either **RJ45**, **SFP\+ Copper**, or **SFP\+ Optical** has been highlighted\. This value represents the type of connection that Snowball is currently using to communicate on your local network\. Here, on the active **DHCP** tap, you see your current network settings\. To change to a static IP address, tap **Static**\.   
![\[Static is an option.\]](http://docs.aws.amazon.com/snowball/latest/ug/images/staticedit.png)

   On this page, you can change the IP address and network mask to your preferred values\.

## Transferring Data with a Snowball<a name="snowball-data-transfer"></a>

When locally transferring data between a Snowball and your on\-premises data center, you can use the Amazon S3 Adapter for Snowball or the Snowball client:
+ [Snowball client](snowball-transfer-client.md) – A standalone terminal application that you run on your local workstation to do your data transfer\. You don't need any coding knowledge to use the Snowball client\. It provides all the functionality you need to transfer data, including handling errors and writing logs to your local workstation for troubleshooting and auditing\.
+ [Amazon S3 Adapter for Snowball](snowball-transfer-adapter.md) – A tool that transfers data programmatically using a subset of the Amazon Simple Storage Service \(Amazon S3\) REST API, including support for AWS Command Line Interface \(AWS CLI\) commands and the Amazon S3 SDKs\.

**Note**  
If you're performing a petabyte\-scale data transfer, we recommend that you read [How to Transfer Petabytes of Data Efficiently](transfer-petabytes.md) before you create your first job\.