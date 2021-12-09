--------

This guide is for the Snowball \(50 TB or 80 TB of storage space\)\. If you are looking for documentation for the Snowball Edge, see the [AWS Snowball Edge Developer Guide](https://docs.aws.amazon.com/snowball/latest/developer-guide/whatisedge.html)\.

--------

# AWS Snowball Device Differences<a name="device-differences"></a>

The Snowball and the Snowball Edge are two different devices\. This guide is for the Snowball\. If you are looking for documentation for the Snowball Edge, see the [AWS Snowball Edge Developer Guide](https://docs.aws.amazon.com/snowball/latest/developer-guide/whatisedge.html)\. Both devices allow you to move huge amounts of data into and out of Amazon S3, they both have the same [job management API](https://docs.aws.amazon.com/snowball/latest/api-reference/api-reference.html), and they both use the same [console](https://console.aws.amazon.com/importexport)\. However, the two devices differ in hardware specifications, some features, what transfer tools are used, and price\.

## AWS Snowball Use Case Differences<a name="usecase-differences"></a>

Following is a table that shows the different use cases for the different AWS Snowball devices:


| Use case | Snowball | Snowball Edge | 
| --- | --- | --- | 
| Import data into Amazon S3 | ✓ | ✓ | 
| Export from Amazon S3 | ✓ | ✓ | 
| Durable local storage |  | ✓ | 
| Local compute with AWS Lambda |  | ✓ | 
| Amazon EC2 compute instances |  | ✓ | 
| Use in a cluster of devices |  | ✓ | 
| Use with AWS IoT Greengrass \(IoT\) |  | ✓ | 
| Transfer files through NFS with a GUI |  | ✓ | 

## AWS Snowball Hardware Differences<a name="hardware-differences"></a>

Following is a table that shows how the devices differ from each other, physically\. For information on specifications for the Snowball, see [AWS Snowball Specifications](specifications.md)\. For information on specifications for the Snowball Edge, see [AWS Snowball Edge Specifications](https://docs.aws.amazon.com/snowball/latest/developer-guide/specifications.html)\.


| Snowball | Snowball Edge | 
| --- | --- | 
|  ![\[The Snowball is a large briefcase-sized device that weighs less than 50 pounds and is used to transfer data.\]](http://docs.aws.amazon.com/snowball/latest/ug/images/Snowball-closed-600w.png)  |  ![\[The Snowball Edge is a large briefcase-sized device that weighs less than 50 pounds and is used to transfer, store, or compute data.\]](http://docs.aws.amazon.com/snowball/latest/ug/images/SnowballEdgeAppliance.png)  | 

Each device has different storage capacities, as follows:


| Storage capacity \(usable capacity\) | Snowball | Snowball Edge | 
| --- | --- | --- | 
|  50 TB \(42 TB\) \- US regions only  | ✓ |  | 
|  80 TB \(72 TB\)  | ✓ |  | 
|  100 TB \(83 TB\)  |  | ✓ | 
|  100 TB Clustered \(45 TB per node\)  |  | ✓ | 

Each device has the following physical interfaces for management purposes:


| Physical interface | Snowball | Snowball Edge | 
| --- | --- | --- | 
| E Ink display – used to track shipping information and configure your IP address\. | ✓ | ✓ | 
| LCD display – used to manage connections and provide some administrative functions\. |  | ✓ | 

## AWS Snowball Tool Differences<a name="tool-differences"></a>

The following outlines the different tools used with the AWS Snowball devices, and how they are used:

### Snowball Tools<a name="tool-differences-snowball"></a>

**Snowball client with Snowball**
+ The Snowball client must be downloaded from the [AWS Snowball Resources](http://aws.amazon.com/snowball/resources/) page and installed on a powerful workstation that you own\.
+ Can transfer data to or from the Snowball\. For more information, see [Using the Snowball Client](using-client.md)\.
+ Encrypts data on your powerful workstation before the data is transferred to the Snowball\.

**Amazon S3 Adapter for Snowball with Snowball**
+ The Amazon S3 Adapter for Snowball must be downloaded from the [AWS Snowball Resources](http://aws.amazon.com/snowball/resources/) page and installed on a powerful workstation that you own\.
+ Can transfer data to or from the Snowball\. For more information, see [Transferring Data with the Amazon S3 Adapter for Snowball](snowball-transfer-adapter.md)\.
+ Encrypts data on your powerful workstation before the data is transferred to the Snowball\.

### Snowball Edge Tools<a name="tool-differences-edge"></a>

**Snowball client with Snowball Edge**
+ The Snowball client must be downloaded from the [AWS Snowball Edge Resources](http://aws.amazon.com/snowball-edge/resources/) page and installed on a powerful workstation that you own\.
+ Must be used to unlock the Snowball Edge or the cluster of Snowball Edge devices\. For more information, see [Using the Snowball Client](https://docs.aws.amazon.com/snowball/latest/developer-guide/using-client.html)\.
+ Can't be used to transfer data\.

**Amazon S3 Adapter for Snowball with Snowball Edge**
+ Is already installed on the Snowball Edge by default\. It does not need to be downloaded or installed\.
+ Can transfer data to or from the Snowball Edge\. For more information, see [Using the Amazon S3 Adapter](https://docs.aws.amazon.com/snowball/latest/developer-guide/using-adapter.html)\.
+ Encrypts data on the Snowball Edge while the data is transferred to the device\.

**File interface with Snowball Edge**
+ Is already installed on the Snowball Edge by default\. It does not need to be downloaded or installed\.
+ Can transfer data by dragging and dropping files up to 150 GB in size from your computer to the buckets on the Snowball Edge through an easy\-to\-configure NFS mount point\. For more information, see [Using the File Interface for the AWS Snowball Edge](https://docs.aws.amazon.com/snowball/latest/developer-guide/using-fileinterface.html)\.
+ Encrypts data on the Snowball Edge while the data is transferred to the device\.

**AWS IoT Greengrass console with Snowball Edge**
+ With a Snowball Edge, you can use the AWS IoT Greengrass console to update your AWS IoT Greengrass group and the core running on the Snowball Edge\.

### Differences Between Items Provided for the Snowball and Snowball Edge<a name="network-differences"></a>

The following outlines the differences between the network adapters, cables used, and cables provided for the Snowball and Snowball Edge\.


| Network Interface | Snowball Support | Snowball Edge Support | Cables Provided with Device | 
| --- | --- | --- | --- | 
| RJ45 | ✓ | ✓ | Only provided with Snowball | 
| SFP\+ | ✓ | ✓ | Only provided with Snowball | 
| SFP\+ \(with optic connector\) | ✓ | ✓ | No cables provided for either device\. No optic connector provided for Snowball Edge devices\. An optic connector is provided with each Snowball | 
| QSFP |   | ✓ | No cables or optics provided | 

For more information on the network interfaces, cables, and connectors that work with the different device types, see the following topics:
+ [Supported Network Hardware](specifications.md#network-hardware) for Snowballs in this guide\.
+ [Supported Network Hardware](https://docs.aws.amazon.com/snowball/latest/developer-guide/specifications.html#network-hardware) in the *AWS Snowball Edge Developer Guide\.*

## AWS Snowball Other Differences<a name="other-differences"></a>

For other differences, including FAQs and pricing information, see:
+ [https://aws.amazon.com/snowball](https://aws.amazon.com/snowball)
+ [https://aws.amazon.com/snowball-edge](https://aws.amazon.com/snowball-edge)